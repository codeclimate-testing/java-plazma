/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

/*
 * Created on 22.04.2006
 *
 */

package org.plazmaforge.framework.app;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.plazmaforge.framework.config.AppConfiguration;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.ObjectConfigurer;
import org.plazmaforge.framework.config.configurer.SystemConfigurer;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.FileUtils;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.xml.XMLProperties;


/**
 * The General Application Configurer.
 * Load locale and class of application manager from <code>application.xml</code> file.
 * 
 * @author ohapon
 *
 */
public class AppConfigurer {
    
    
    protected final static Log logger = LogFactory.getLog(AppConfigurer.class);
    
    //private boolean checkSystemConfigFile;
    
    private boolean loadAppManagerMode;
    
    private IAppManager appManager;
    
    private final AppConfiguration configuration;
    
    
    public AppConfigurer(AppConfiguration configuration) {
	this.configuration = configuration;
	//checkSystemConfigFile = true;
	loadAppManagerMode = true;
    }
    
    public AppConfiguration getConfiguration() {
        return configuration;
    }


    /**
     * Get absolute Application Config File
     * @return
     */
    public String getAbsoluteApplicationConfigFile() {
	String fileName = getConfiguration().getApplicationConfigFile(); // Simple file name 'application.xml'
        return AppEnvironment.getAbsoluteConfigFileName(fileName); // Absolute file name
    }
    
    /**
     * Get absolute System Config File
     * @return
     */
    public String getAbsoluteSystemConfigFile() {
	String fileName = getConfiguration().getSystemConfigFile(); // Simple file name 'system-config.xml'
	return AppEnvironment.getAbsoluteConfigFileName(fileName); // Absolute file name
    }
    
    
    /**
     * Load configuration
     * @throws ApplicationException
     */
    public void loadConfiguration() throws ApplicationException {
	String applicationConfigFile = getAbsoluteApplicationConfigFile();
	loadConfiguration(applicationConfigFile);
    }
    
    /**
     * Load configuration from file
     * @param fileName
     * @throws ApplicationException
     */
    public void loadConfiguration(String fileName) throws ApplicationException {
	try {
	    
	    String msg = "APPLICATION_CONFIG_FILE = [" + fileName + "]";
	    if (!FileUtils.exists(fileName)) {
		System.out.println(msg + " - Not found");
		return;
	    } else {
		System.out.println(msg);
	    }
	    
	    
	    XMLProperties properties = loadProperties(fileName, false);
	    if (properties == null) {
		return;
	    }
	    loadConfiguration(properties);
	    
       } catch (Exception ex) {
	   throw new ApplicationException(ex);
       }
		
    }
    
    /**
     * Load configuration from <code>Properties</code>
     * @param properties
     */
    public void loadConfiguration(Properties properties) throws ApplicationException  {
	
	// Load application properties from file 'application.xml'
	loadApplicationProperties(properties);
	
        // Load System Configuration from file 'system-config.xml'
        loadSystemConfiguration();
        
        // Load application manager (create instance of class but doesn't use the instance)
	loadManager();
		
    }
	
    
    /**
     * Load application properties
     * @param properties
     * @throws ApplicationException
     */
    public void loadApplicationProperties(Properties properties) throws ApplicationException {
	try {

	    if (properties == null) {
		return;
	    }
	    
	    if ("true".equals(properties.getProperty("is-external-config"))) {
		AppEnvironment.setExternalConfigFile(true);
	    }

	    // Set application manager
	    AppEnvironment.setApplicationManagerClass(properties.getProperty("application-manager"));
	    
	    // Set system properties
	    AppEnvironment.setProperties(properties);

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    


    /**
     * Create locale by properties
     * @param properties
     * @return
     */
    public static Locale createSystemLocale(XMLProperties properties) {
	if (properties == null) {
	    return null;
	}
	String localeProp = properties.getProperty("locale");
	String iso3languageProp = properties.getProperty("iso3language");
	Locale locale = createSystemLocale(localeProp);
	if (locale == null) {
	    locale = createSystemLocaleBylanguage(iso3languageProp, properties);
	}
	return locale;
    }
	

    /**
     * Create locale by locale string
     * @param locale
     * @return
     */
    public static Locale createSystemLocale(String locale) {
	if (StringUtils.isEmpty(locale)) {
	    return null;
	}
	try {
	    return new Locale(locale.substring(0, 2), locale.substring(3, 5));
	} catch (Exception ex) {
	    logger.error("Creation locale error. Locale string = [" + locale + "]", ex);
	}
	return null;
    }
    


    /**
     * Create locale by language
     * @param iso3language
     * @param properties
     * @return
     */
    public static Locale createSystemLocaleBylanguage(String iso3language, XMLProperties properties) {
	if (StringUtils.isEmpty(iso3language)) {
	    return null;
	}
	Locale defLocale = Locale.getDefault();
	try {
	    String language = LocaleManager.getISO2LanguageByISO3(iso3language);
	    String country = defLocale.getCountry();
	    
	    if (properties != null) {
		properties.setProperty("locale", language + "_" + country);
		properties.setProperty("modify", "true");
	    }
	    return new Locale(language, country);
	} catch (Exception ex) {
	    logger.error("Creation locale error. Language string = [" + iso3language + "]", ex);
	}
	return null;
    }    
    
    

    /**
     * Load properties and set locale
     * If 'modify' is true store (update) properties to file
     * @param fileName
     * @return
     * @throws ApplicationException
     */
    public static XMLProperties loadProperties(String fileName) throws ApplicationException {
	return loadProperties(fileName, true);
    }
    

    /**
     * Load properties and set locale
     * If 'modify' is true store (update) properties to file  
     * @param fileName
     * @param checkFile
     * @return
     * @throws ApplicationException
     */
    public static XMLProperties loadProperties(String fileName, boolean checkFile) throws ApplicationException {
	try {

	    
	    // Load properties from file
	    XMLProperties properties = new XMLProperties();
	    
	    if (checkFile && !FileUtils.exists(fileName)) {
		return properties;
	    }

	    properties.load(fileName);

	    
	    Locale locale = createSystemLocale(properties);
	    if (locale != null) {
		Locale.setDefault(locale);
	    }
	    
	    if ("true".equals(properties.getProperty("modify"))) {
		try {
		    properties.remove("modify");
		    properties.store(fileName);
		} catch (IOException ex) {
		    logger.error("Storing locale error. File name = [" + fileName + "]", ex);
		}
	    }
	    
	    return properties;

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    
    
    protected void loadSystemConfiguration() throws ApplicationException {
	String systemConfigFile = createSystemConfigFileName();
	ConfigurerManager.reset();
        SystemConfigurer systemConfigurer = ConfigurerManager.getSystemConfigurer(getConfiguration());
        if (systemConfigFile != null) {
            systemConfigurer.setAbsoluteConfigFileName(systemConfigFile);
        }
        String msg = "SYSTEM_CONFIG_FILE = [" + systemConfigFile + "]";
        if (!FileUtils.exists(systemConfigFile)) {
            System.out.println(msg + " - Not found");
        } else {
            System.out.println(msg);
        }
        systemConfigurer.loadObjects();
    }
    
    protected String createSystemConfigFileName() {
	//if (!checkSystemConfigFile) {
	//    return null;
	//}
	return getAbsoluteSystemConfigFile();
    }
    
    
    protected void loadManager() throws ApplicationException {
	if (!loadAppManagerMode) {
            setAppManager(null);
            return;
	}
	String applicationManagerClass = AppEnvironment.getApplicationManagerClass(); 
        if (applicationManagerClass == null) {
            setAppManager(null);
            return;
        }
        try {
            IAppManager appManager = (IAppManager) ClassUtilsExt.getClassInstance(applicationManagerClass) ;
            setAppManager(appManager);
        } catch (ApplicationException ex) {
            setAppManager(null);
            if (ex.getCause() instanceof ClassNotFoundException ) {
        	logger.error("Application Manager Class not found: " + applicationManagerClass);
            } else {
        	logger.error("Application Error", ex);
            }
            
        }
    }

    public IAppManager getAppManager() {
        return appManager;
    }

    public void setAppManager(IAppManager appManager) {
        this.appManager = appManager;
    }

//    public void setCheckSystemConfigFile(boolean checkSystemConfigFile) {
//        this.checkSystemConfigFile = checkSystemConfigFile;
//    }
    
    public void setLoadAppManagerMode(boolean loadAppManagerMode) {
        this.loadAppManagerMode = loadAppManagerMode;
    }
    
    /////////////////////////////////////////////////////////////////////////////
    
    

    public void storeConfiguration() throws ApplicationException {
	List<ObjectConfigurer<?>> configurers = ConfigurerManager.getStorableConfigurers();
	if (configurers == null || configurers.isEmpty()) {
	    return;
	}
	for (ObjectConfigurer<?> c: configurers) {
	    if (c.isModify()) {
		
		if (!c.isResolve() && c.isEmpty()) {
		    continue;
		}
		c.storeObjects();
		logger.debug("Configurer '" + c.getName()+ "' was stored [file=" + c.getAbsoluteConfigFileName() + "]");
	    }
	}

    }
    
    
    public void storeApplicationProperties(Properties properties) throws ApplicationException {
	storeApplicationProperties(properties, getAbsoluteApplicationConfigFile());
    }
    
    public void storeApplicationProperties(Properties properties, String fileName) throws ApplicationException {
	try {

	    if (properties == null) {
		throw new IllegalArgumentException("Properties must be not null");
	    }
	    
	    XMLProperties storeProperties = new XMLProperties();
	    Iterator<Map.Entry<Object, Object>> itr = properties.entrySet().iterator();
	    while (itr.hasNext()) {
		Map.Entry<Object, Object> element = itr.next();
		storeProperties.put(element.getKey(), element.getValue());
	    }
	    File file = new File(fileName);
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    storeProperties.store(fileName);

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public void storeSystemDefault(String fileName) throws ApplicationException {
        SystemConfigurer systemConfigurer = ConfigurerManager.getSystemConfigurer(getConfiguration());
        systemConfigurer.setAbsoluteConfigFileName(fileName);
        systemConfigurer.storeDefaultObjects();
    }
    
    public void storeSystemDefault() throws ApplicationException {
	String fileName = getAbsoluteSystemConfigFile();
	storeSystemDefault(fileName);
    }
    
    ////
    
    public static AppConfiguration createCurrenctConfiguration() {
	
	AppConfiguration configuration = new AppConfiguration();
	configuration.setRootDir(AppEnvironment.getRootDir());
	configuration.setConfigurationDir(AppEnvironment.getConfigurationDir());
	configuration.setConfigurationModuleDirs(AppEnvironment.getConfigurationModuleDirs());
	//configuration.setConfName(AppEnvironment.getConfName());
	configuration.setExternalConfigFile(AppEnvironment.isExternalConfigFile());
	configuration.setApplicationConfigFile(AppEnvironment.getApplicationConfigFile());
	configuration.setSystemConfigFile(AppEnvironment.getSystemConfigFile());
	
	configuration.setUiContextName(AppEnvironment.getUIConf());
	configuration.setSystemContextName(AppEnvironment.getSystemConf());

	configuration.setPlatformProperties(PlatformEnvironment.getProperties());
	
	return configuration;
    }
}
