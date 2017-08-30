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
 * Created on 15.11.2003
 *
 */
package org.plazmaforge.framework.app;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.config.AppConfiguration;
import org.plazmaforge.framework.config.AppConfiguration.Replacer;
import org.plazmaforge.framework.config.AppConfigurationUtils;
import org.plazmaforge.framework.util.FileUtils;
import org.plazmaforge.framework.util.IPropertiesStore;
import org.plazmaforge.framework.util.PropertiesStore;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemInfo;


/**
 * Application environment
 * 
 * @author Oleh Hapon
 * $Id: AppEnvironment.java,v 1.24 2010/06/14 12:45:41 ohapon Exp $
 */
public class AppEnvironment {
    
    /** Root dir property **/
    public static final String ROOT_DIR_PROPERTY          = "plazma.platform.dir";

    /** Configuration dir property **/
    public static final String CONFIGURATION_DIR_PROPERTY = "plazma.platform.configuration.dir";


    /** UI conf property **/
    public static final String UI_CONF_PROPERTY = "plazma.platform.ui.conf";
    

    /** Demo property **/
    public static final String DEMO_PROPERTY              = "plazma.platform.demo";

    /** Auto login property **/
    public static final String AUTO_LOGIN_PROPERTY        = "plazma.platform.autologin";
    
    /** Input Dialog property **/
    public static final String INPUT_DIALOG_PROPERTY        = "plazma.platform.inputdialog";
    
    
	
    /** Configuration name property. It is name of folder. Example: conf, conf-server, conf-explorer etc. **/
    public static final String CONFIG_NAME_PROPERTY       = "plazma.conf.name";	
	
    /** Configuration prefix of file name. Example: server.file-config.xml **/
    //public static final String CONFIG_PREFIX_PROPERTY     = "plazma.conf.prefix";
	
    /** App context property **/
    public static final String APP_CONTEXT_PROPERTY       = "plazma.platform.app.context";	
	
	
    /** File separator **/
    public static final String FILE_SEPARATOR             = System.getProperty("file.separator");

    /** User dir **/
    public static final String USER_DIR                   = System.getProperty("user.dir");

    /** Default configuration name **/
    public static final String DEFAULT_CONFIG_NAME        = "conf";
    
    /** Default logs folder **/
    public static final String DEFAULT_LOGS_DIR_NAME      = "logs";    

    /** Default packages dir name **/
    public static final String DEFAULT_PACKAGES_DIR_NAME  = "packages";


    /** Default App context name **/
    public static final String DEFAULT_APP_CONTEXT_NAME = "plazma";
    
    /** Default root property file name **/
    public static final String DEFAULT_ROOT_PROPERTY_FILE = DEFAULT_APP_CONTEXT_NAME + ".properties";

    /** Default application config file **/
    public static final String DEFAULT_APPLICATION_CONFIG_FILE = "application.xml";
    
    /** Default system configuration file name **/
    public static final String DEFAULT_SYSTEM_CONFIG_FILE = "system-config.xml";
	

    public static final String STD_OUT = "std.out";
    
    public static final String STD_ERR = "std.err";
    

    public static final String DEFAULT_USER_INTERFACE = "All";
    

    
    public static final String SERVER_CONF_FILE = "server.conf";
    
    public static final String CLIENT_CONF_FILE = "client.conf";    
    
	
    private static final String PROPERTIES_FILE_EXT = ".properties";
    
    
    
    
    protected static Properties properties;

    /**
     * Root directory (start directory). By default it is user directory (System.getProperty("user.dir"))
     */
    protected static String rootDir;
	
    /**
     * Configuration directory
     */
    protected static String configurationDir;
    
    /**
     * Array of configuration directories. We can use more configurations. configurationModuleDirs[0] is default configuration. 
     */
    protected static String[] configurationModuleDirs;
    
    protected static String confName;
	
    //protected static String confPrefix;
    
    protected static String systemConf; // standalone, client, server
    
    protected static String uiConf; // ui/swt, ui/swing
    
    protected static String logsDirName;    

    protected static boolean externalConfigFile;
	
    protected static boolean externalDatabaseConfigFile;

    protected static ConfigLoader configLoader;

    protected static String applicationManagerClass;
    
    /** If <b>true<b> the application has demo mode **/
    protected static boolean demo;
    
    /** If <b>true<b> the login dialog sets login and password automaticaly **/
    protected static boolean autoLogin;    
    
    /** If <b>true<b> the application has special input dialog to set parameters (UI, Organization, Branch and etc.) **/
    protected static boolean inputDialog;    
	
    
    private static String applicationConfigFile;
    
    private static String systemConfigFile;
    
    private static String userInterface;
    
    /** Application type: server, client, standalone **/ 
    private static String appType;
    
    private static String appContextName;
    
    private static boolean isInit;
    
    
    
    private static Logger logger;  
    
    /**
     * General Initialize Application Environment 
     *
     */
    public static void init() {
	init(false);
    }
    
    /**
     * General Initialize Application Environment 
     *
     */
    public static void init(boolean forceInit) {
		
	if (!forceInit && isInit) {
	    return;
	}
	
	isInit = true;
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// LOGS
	//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	logsDirName = DEFAULT_LOGS_DIR_NAME;
	checkLogsFolder();
	
	getLogger().info("********** Start Initialize ApplicationEnvironment **********");
	
	
	
	appContextName = System.getProperty(APP_CONTEXT_PROPERTY, DEFAULT_APP_CONTEXT_NAME);
	if (StringUtils.isEmpty(appContextName)) {
	    appContextName = DEFAULT_APP_CONTEXT_NAME;
	}
	
	clearSystemProperties();
	
        initSystemProperties();
		
        rootDir = System.getProperty(ROOT_DIR_PROPERTY, USER_DIR);
        
	confName = System.getProperty(CONFIG_NAME_PROPERTY, DEFAULT_CONFIG_NAME);
	//confPrefix = System.getProperty(CONFIG_PREFIX_PROPERTY, "");
	
	
	// We can use more configurations
	// Each configuration is like one project (module) 
	// We can set configuration directory like string with separator ';'
	
	String configurationModuleDirString = System.getProperty(CONFIGURATION_DIR_PROPERTY, rootDir);
	String[] modules = configurationModuleDirString.split(";");
	
	for (int i = 0; i < modules.length; i++) {
	    modules[i] = modules[i].trim();
	}
	configurationModuleDirs = modules;
	
	// First directory is default (base) configuration
	configurationDir = configurationModuleDirs[0];
	
	systemConf = System.getProperty("plazma.platform.system.conf", ""); // standalone, client, server
	uiConf = System.getProperty(UI_CONF_PROPERTY, ""); // ui/swt, ui/swing
	
	applicationConfigFile = System.getProperty("plazma.platform.application.config.file", DEFAULT_APPLICATION_CONFIG_FILE);
	systemConfigFile = System.getProperty("plazma.platform.system.config.file", DEFAULT_SYSTEM_CONFIG_FILE);
	
	if (!StringUtils.isEmpty(systemConf)) {
	    applicationConfigFile = systemConf + FILE_SEPARATOR + applicationConfigFile;
	    systemConfigFile = systemConf + FILE_SEPARATOR + systemConfigFile;
	}
	    
        demo = Boolean.valueOf(System.getProperty(DEMO_PROPERTY, "false")).booleanValue();
        autoLogin = Boolean.valueOf(System.getProperty(AUTO_LOGIN_PROPERTY, "false")).booleanValue();
        inputDialog = Boolean.valueOf(System.getProperty(INPUT_DIALOG_PROPERTY, "true")).booleanValue();
        
	
        externalConfigFile = true; // By default configuration files are external
        externalDatabaseConfigFile = false;
        properties = new Properties();
        
        initApplicationType();
        
        getLogger().info("CONFIGURATION_DIR=" + configurationDir);
        getLogger().info("APPLICATION_CONFIG_FILE=" + applicationConfigFile);
        getLogger().info("SYSTEM_CONFIG_FILE=" + systemConfigFile);
        getLogger().info("********** ApplicationEnvironment was initialized ***********");
    }
    

    /**
     * Check Logs folder.
     * If the folder not found then create new folder in user folder
     */
    private static void checkLogsFolder() {
	if (logsDirName == null || USER_DIR == null) {
	    return;
	}
	String logsPath = USER_DIR + FILE_SEPARATOR + logsDirName;
	File file = new File(logsPath);
	if (file.exists()) {
	    return;
	}
	file.mkdirs();
    }
    
    private static void clearSystemProperties() {
	
	System.clearProperty(CONFIG_NAME_PROPERTY);
	//System.clearProperty(CONFIG_PREFIX_PROPERTY);
	System.clearProperty(CONFIGURATION_DIR_PROPERTY);
	
	System.clearProperty("plazma.platform.system.conf");
	System.clearProperty(UI_CONF_PROPERTY);
	
	System.clearProperty("plazma.platform.application.config.file");
	System.clearProperty("plazma.platform.system.config.file");
	
	System.clearProperty(DEMO_PROPERTY);
        System.clearProperty(AUTO_LOGIN_PROPERTY);
        System.clearProperty(INPUT_DIALOG_PROPERTY);
        
    }

    /**
     * Initialize system properties.
     * 
     * Load properties from file <user.dir>/plazma.properties.
     * Set properties ( System.setProperty(key, value) ) 
     */
    private static void initSystemProperties() {
	try {
	    String rootDir = System.getProperty(ROOT_DIR_PROPERTY, USER_DIR);
	    String fileName = appContextName + ".properties";
	    String rootPropertyFile = rootDir + FILE_SEPARATOR + fileName;
	    //String rootPropertyFile = USER_DIR + FILE_SEPARATOR + DEFAULT_ROOT_PROPERTY_FILE;
	    
	    // If file not found return
	    if (!FileUtils.exists(rootPropertyFile)) {
		return;
	    }
	    if (SystemInfo.isWindows) {
		 fixingPropertiesFile(rootPropertyFile);
	    }
	    Properties props = new Properties();
	    props.load(new FileInputStream(rootPropertyFile));
	    Enumeration enums = props.keys();
	    Replacer[] replacers = AppConfiguration.createReplacers(rootDir);
	    
	    while (enums.hasMoreElements()) {
		String key = (String) enums.nextElement();
		String value = props.getProperty(key);
		String replValue = AppConfiguration.replaceValue(replacers, value);
		getLogger().info("KEY = " + key +", VALUE = " + replValue);
		System.setProperty(key, replValue);
	    }

	} catch (IOException ex) {
	    getLogger().error("Error initialize system properties", ex);
	}

    }
    
    private static void initApplicationType() {
	appType = null;
	String rootDir = getRootDir();
	String fileName = rootDir + "/" + SERVER_CONF_FILE;
	File file = new File(fileName);
	if (file.exists()) {
	    appType = "server";
	    return;
	}
	fileName = rootDir + "/" + CLIENT_CONF_FILE;
	file = new File(fileName);
	if (file.exists()) {
	    appType = "client";
	    return;
	}
    }
    
    //
    
   

    public static Replacer[] createReplacers() {
	return AppConfiguration.createReplacers(AppEnvironment.getRootDir());
    }
    
    public static String getParentDir(String dir) {
	if (dir == null) {
	    return null;
	}
	int index = dir.lastIndexOf(File.separator);
	if (index < 0) {
	    return dir;
	}
	return dir.substring(0, index);
    }
    
    private static void fixingPropertiesFile(String fileName) {
	BufferedReader reader = null;
	BufferedWriter writer = null;
	try {
	    reader = new BufferedReader(new FileReader(fileName));
	    String str = null;

	    ArrayList<String> buff = new ArrayList<String>();
	    boolean isReplace = false;
	    while ((str = reader.readLine()) != null) {
		if (str.startsWith(ROOT_DIR_PROPERTY)) {
		    str = str.replace("\\", "/");
		    isReplace = true;
		}
		buff.add(str);
	    }

	    reader.close();
	    reader = null;

	    if (buff.size() == 0 || !isReplace) {
		return;
	    }

	    writer = new BufferedWriter(new FileWriter(fileName));

	    for (String line : buff) {
		writer.write(line + '\n');
	    }

	    writer.close();
	    writer = null;
	    System.out.println(fileName + " file was fixed");
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    try {
		if (reader != null) {
		    reader.close();
		}
		if (reader != null) {
		    reader.close();
		}

	    } catch (IOException ex) {
		//
	    }

	}

    }

 
    public static String getProperty(String key) {
	return properties.getProperty(key);
    }

    public static void setProperty(String key, Object value) {
	properties.put(key, value);
    }


    public static void setRootDir(String dir) {
	if (dir == null)
	    rootDir = "";
	else
	    rootDir = dir;
    }

	
    public static Properties getProperties() {
	return properties;
    }

    public static void setProperties(Properties properties) {
	AppEnvironment.properties = properties;
    }

    public static String getRootDir() {
	return rootDir;
    }

    public static String getParentRootDir() {
	return getParentDir(rootDir);
    }
    
    public static String getConfigurationDir() {
	return configurationDir;
    }
    
    public static String getConfName() {
	return confName;
    }

//    public static String getConfPrefix() {
//	return confPrefix;
//    }

  
    public static String getSystemConf() {
	return systemConf;
    }
    
    public static String getUIConf() {
	return uiConf;
    }
    
    
    public static String getApplicationConfigFile() {
        return applicationConfigFile;
    }

    public static String getSystemConfigFile() {
        return systemConfigFile;
    }

    public static boolean isExternalConfigFile() {
	return externalConfigFile;
    }

    public static void setExternalConfigFile(boolean externalConfigFile) {
	AppEnvironment.externalConfigFile = externalConfigFile;
    }

    public static boolean isExternalDatabaseConfigFile() {
	return externalDatabaseConfigFile;
    }

    public static void setExternalDatabaseConfigFile(
	    boolean externalDatabaseConfigFile) {
	AppEnvironment.externalDatabaseConfigFile = externalDatabaseConfigFile;
    }

    public static ConfigLoader getConfigLoader() {
	return configLoader;
    }

    public static void setConfigLoader(ConfigLoader configLoader) {
	AppEnvironment.configLoader = configLoader;
    }

    public static Properties getConfigProperties(String configName, boolean isExternal) throws IOException {
	Properties prop = new Properties();
	prop.load(getConfigInputStream(configName, isExternal));
	return prop;
    }

    public static InputStream getConfigInputStream(String configName, boolean isExternal) throws IOException {
	if (isExternal) {
	    return new FileInputStream(configName);
	} else {
	    if (AppEnvironment.getConfigLoader() == null) {
		return null;
	    }
	    return AppEnvironment.getConfigLoader().getInputStream(configName);
	}
    }

    public static InputStream getConfigInputStream(String configName) throws IOException {
	return getConfigInputStream(configName, AppEnvironment.isExternalConfigFile());
    }

    
    
    
    
    public static ResourceBundle getConfigBundle(String configName, boolean isExternal) throws IOException {
	return getConfigBundle(configName, Locale.getDefault(), isExternal);
    }
    
    public static ResourceBundle getConfigBundle(String configName, Locale locale, boolean isExternal) throws IOException {
	if (locale == null) {
	    locale = Locale.getDefault();
	}
	// We use only language and country of locale
    	String language= locale.getLanguage();
    	String country = locale.getCountry();
    	
	return getConfigBundle(configName, language, country, isExternal);
    }

    
    public static ResourceBundle getConfigBundleByFile(String fileName) throws IOException {
	return getConfigBundleByFile(fileName, AppEnvironment.isExternalConfigFile());
    }
    
    public static ResourceBundle getConfigBundleByFile(String fileName, boolean isExternal) throws IOException {
	if (fileName == null) {
	    return null;
	}
	if (isExternal) {
	    FileInputStream stream = new FileInputStream(fileName);
	    if (stream == null) {
		return null;
	    }
	    return new PropertyResourceBundle(stream);
	} else {
	    if (AppEnvironment.getConfigLoader() == null) {
		return null;
	    }
	    String configName = getSimplePropertiesFileName(fileName);
	    return AppEnvironment.getConfigLoader().getBundle(configName);
	}
    }
    
    //////
    
    public static IPropertiesStore getConfigPropertiesStoreByFile(String fileName) throws IOException {
	return getConfigPropertiesStoreByFile(fileName, AppEnvironment.isExternalConfigFile());
    }
    
    public static IPropertiesStore getConfigPropertiesStoreByFile(String fileName, boolean isExternal) throws IOException {
	if (fileName == null) {
	    return null;
	}
	if (isExternal) {
	    PropertiesStore store = new PropertiesStore();
	    store.initLocales(fileName, true);
	    store.setAutoAddLocale(true);
	    store.load();
	    store.resetLocale();
	    return store;
	} else {
	    if (AppEnvironment.getConfigLoader() == null) {
		return null;
	    }
	    String configName = getSimplePropertiesFileName(fileName);
	    return null; // AppEnvironment.getConfigLoader().getPropertiesStore(configName); // TODO
	}
    }    
    
    //////
    
    private static String getSimplePropertiesFileName(String fileName) {
	String simpleName = fileName;
	if (fileName.endsWith(PROPERTIES_FILE_EXT)) {
	    if (fileName.length() == PROPERTIES_FILE_EXT.length()) {
		return null;
	    }
	    simpleName = simpleName.substring(0, PROPERTIES_FILE_EXT.length());
	}
	return simpleName;
    }
    
    //////
    
    
    public static ResourceBundle getConfigBundle(String configName, Locale locale) throws IOException {
	return getConfigBundle(configName, locale, AppEnvironment.isExternalConfigFile());
    }

    
    
    public static ResourceBundle getConfigBundle(String configName, String language, String country, boolean isExternal) throws IOException {
	if (configName == null) {
	    return null;
	}
	if (isExternal) {
	    FileInputStream stream = AppConfigurationUtils.getPropertiesFileInputStream(configName, language, country);
	    if (stream == null) {
		return null;
	    }
	    return new PropertyResourceBundle(stream);
	} else {
	    if (AppEnvironment.getConfigLoader() == null) {
		return null;
	    }
	    return AppEnvironment.getConfigLoader().getBundle(configName);
	}
    }
	
    public static ResourceBundle getConfigBundle(String configName) throws IOException {
        if (configName == null) {
            return null;
        }
    	return getConfigBundle(configName, AppEnvironment.isExternalConfigFile());
    }
    
    
   

    public static String getRootConfigFileName(String rootConfigDir, String name) {
        return rootConfigDir + FILE_SEPARATOR + name;
    }

    public static String getRootConfigFileName(String name) {
        return getRootConfigDir() + FILE_SEPARATOR + name;
    }
    
    public static String getRootConfigDir() {
        return getConfigurationDir() + FILE_SEPARATOR + getConfName();
    }

    public static String getRootConfigDir(String configurationDir) {
        return configurationDir + FILE_SEPARATOR + getConfName();
    }

    public static String getLogsDir() {
        return getRootDir() + FILE_SEPARATOR + getLogsDirName();
    }
    
    public static String getLogsDirName() {
	return logsDirName;
    }


    public static String getAbsoluteConfigFileName(String name) {
        if (name == null) return name;
        if (isExternalConfigFile()) {
            return getRootConfigFileName(name);
        } else {
            return name;
        }
    }
    
      public static String getApplicationManagerClass() {
	return applicationManagerClass;
    }

    public static void setApplicationManagerClass(String applicationManagerClass) {
	AppEnvironment.applicationManagerClass = applicationManagerClass;
    }

    public static boolean isDemo() {
	return demo;
    }

    public static void setDemo(boolean demo) {
	AppEnvironment.demo = demo;
    }

    public static boolean isAutoLogin() {
        return autoLogin;
    }

    public static boolean isInputDialog() {
        return inputDialog;
    }

    public static void setInputDialog(boolean inputDialog) {
        AppEnvironment.inputDialog = inputDialog;
    }

    public static void setAutoLogin(boolean autoLogin) {
        AppEnvironment.autoLogin = autoLogin;
    }

    public static String getUserInterface() {
        return userInterface;
    }

    public static void setUserInterface(String userInterface) {
        AppEnvironment.userInterface = userInterface;
    }

    /**
     * Return an application type: client, server, standalone
     * @return
     */
    public static String getAppType() {
        return appType == null ? "standalone" : appType;
    }


    /**
     * Return <b>true</b> if application type is <b>server</b>
     * @return
     */
    public static boolean isServer() {
	return "server".equals(getAppType());
    }
   
    /**
     * Return <b>true</b> if application type is <b>client</b>
     * @return
     */
    public static boolean isClient() {
	return "client".equals(getAppType());
    }

    /**
     * Return <b>true</b> if application type is <b>client</b>
     * @return
     */
    public static boolean isStandalone() {
	return !isServer() && isClient();
    }

    
    private static Logger getLogger() {
	if (logger == null) {
	    logger = Logger.getLogger(AppEnvironment.class);
	}
	return logger;
    }


    public static String[] getConfigurationModuleDirs() {
        return configurationModuleDirs;
    }

    public static void logInfo (String message) {
	getLogger().info(message);
    }
	
}
