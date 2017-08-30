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
/**
 * 
 * 21.01.2006
 * 
 */

/**
 * PlatformEnvironment is general environment of system.
 * It managements subsystems and environments:
 * 
 * - Locale Manager
 * 
 * - PlatformSystem Environment
 * 
 * - Reporting PlatformSystem
 * 
 * - Service Management
 * 
 */
package org.plazmaforge.framework.platform;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.SystemEnvironment;
import org.plazmaforge.framework.core.SystemFormat;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.platform.structure.PlatformClient;
import org.plazmaforge.framework.platform.structure.PlatformServer;
import org.plazmaforge.framework.platform.structure.PlatformSystem;


public class PlatformEnvironment {

    /** PlatformEnvironment instance * */
    private static PlatformEnvironment instance;

    /** Platform Context * */
    private PlatformContext platformContext;

    private PlatformEnvironment() {
    }

    /**
     * Get Instance
     * 
     * @return
     */
    public synchronized static PlatformEnvironment getInstance() {
	if (instance == null) {
	    instance = new PlatformEnvironment();
	}
	return instance;
    }

    /**
     * Get Platform Context
     * 
     * @return
     */
    public PlatformContext getPlatformContext() {
	if (platformContext == null) {
	    platformContext = new PlatformContext();
	}
	return platformContext;
    }

    /**
     * Set Platform Context
     * 
     * @param platformContext
     */
    public void setPlatformContext(PlatformContext platformContext) {
	this.platformContext = platformContext;
    }

    /**
     * Get Context
     * 
     * @return
     */
    public static PlatformContext getContext() {
	return getInstance().getPlatformContext();
    }

    /**
     * Set Context
     * 
     * @param context
     */
    public static void setContext(PlatformContext context) {
	getInstance().setPlatformContext(context);
    }

    /**
     * Set property
     * 
     * @param key
     * @param value
     */
    public static void setProperty(String key, String value) {
	getContext().setProperty(key, value);
    }

    /**
     * Get property
     * 
     * @param key
     * @return
     */
    public static String getProperty(String key) {
	return getContext().getProperty(key);
    }

    public static Properties getProperties() {
	return getContext().getProperties();
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Locale Manager
    //
    // ----------------------------------------------------------------------------------------------------

    /**
     * Get Locale
     * 
     * @return
     */
    public static Locale getLocale() {
	return LocaleManager.getLocale();
    }

    /**
     * Get region
     * 
     * @return
     */
    public static String getRegion() {
	return LocaleManager.getRegion();
    }

    /**
     * Get ISO2 Countries
     * 
     * @return
     */
    public static String[] getISO2Countries() {
	return LocaleManager.getISO2Countries();
    }

    /**
     * Get ISO2 Languages
     * 
     * @return
     */
    public static String[] getISO2Languages() {
	return LocaleManager.getISO2Languages();
    }

    /**
     * Get ISO3 Countries
     * 
     * @return
     */
    public static String[] getISO3Countries() {
	return LocaleManager.getISO3Countries();
    }

    /**
     * Get ISO3 Languages
     * 
     * @return
     */
    public static String[] getISO3Languages() {
	return LocaleManager.getISO3Languages();
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // PlatformSystem Environment
    //
    // ----------------------------------------------------------------------------------------------------

    /**
     * Get codepage
     */
    public static String getCodepage() {
	return SystemEnvironment.getCodepage();
    }

    /**
     * Get default codepage
     * 
     * @return
     */
    public static String getDefaultCodepage() {
	return SystemEnvironment.getDefaultCodepage();
    }

    /**
     * Get Number Format
     * 
     * @return
     */
    public static NumberFormat getNumberFormat() {
	return SystemEnvironment.getNumberFormat();
    }

    /**
     * Get Number Pattern
     * 
     * @return
     */
    public static String getNumberPattern() {
	return SystemEnvironment.getNumberPattern();
    }

    
    public static NumberFormat getIntegerFormat() {
	return SystemEnvironment.getIntegerFormat();
    }

    /**
     * Get Date Format
     * 
     * @return
     */
    public static DateFormat getDateFormat() {
	return SystemEnvironment.getDateFormat();
    }

    /**
     * Get Date Format by date Style
     * 
     * @param dateStyle
     * @return
     */
    public static DateFormat getDateFormat(int dateStyle) {
	return SystemEnvironment.getDateFormat(dateStyle);
    }

    /**
     * Get Date Format by date style and locale
     * 
     * @param dateStyle
     * @param locale
     * @return
     */
    public static DateFormat getDateFormat(int dateStyle, Locale locale) {
	return SystemEnvironment.getDateFormat(dateStyle, locale);
    }

    /**
     * Get Date Pattern
     * 
     * @return
     */
    public static String getDatePattern() {
	return SystemEnvironment.getDatePattern();
    }

    /**
     * Get normalize Date Pattern
     * 
     * @return
     */
    public static String getNormalizeDatePattern() {
	return SystemEnvironment.getNormalizeDatePattern();
    }

    /**
     * Get Date Pattern by date style
     * 
     * @param dateStyle
     * @return
      */
    public static String getDatePattern(int dateStyle) {
	return SystemEnvironment.getDatePattern(dateStyle);
    }

    /**
     * Get Date Pattern by date style and locale
     * 
     * @param dateStyle
     * @param locale
     * @return
     */
    public static String getDatePattern(int dateStyle, Locale locale) {
	return SystemEnvironment.getDatePattern(dateStyle, locale);
    }

    //// Date Time

    public static DateFormat getDateTimeFormat() {
	return SystemEnvironment.getDateTimeFormat();
    }

    public static String getDateTimePattern() {
	return SystemEnvironment.getDateTimePattern();
    }

    public static String getDateTimePattern(int dateStyle, int timeStyle) {
	return SystemEnvironment.getDateTimePattern(dateStyle, timeStyle);
    }

    
    //// Time

    public static DateFormat getTimeFormat() {
	return SystemEnvironment.getTimeFormat();
    }

    public static String getTimePattern() {
	return SystemEnvironment.getTimePattern();
    }


    ////
    
    public static NumberFormat getCurrencyFormat() {
	return SystemEnvironment.getCurrencyFormat();
    }
    
    public static NumberFormat getPercentFormat() {
	return SystemEnvironment.getPercentFormat();
    }

    public static NumberFormat getQuantityFormat() {
	return SystemEnvironment.getQuantityFormat();
    }

    public static NumberFormat getCoefficientFormat() {
	return SystemEnvironment.getCoefficientFormat();
    }

    ////
    
    
    public static String getCurrencyPattern() {
	return SystemEnvironment.getCurrencyPattern();
    }
    
    public static String getPercentPattern() {
	return SystemEnvironment.getPercentPattern();
    }

    public static String getQuantityPattern() {
	return SystemEnvironment.getQuantityPattern();
    }

    public static String getCoefficientPattern() {
	return SystemEnvironment.getCoefficientPattern();
    }
    
    /////
    
    public static SystemFormat getSystemFormat() {
	return SystemEnvironment.getInstance().getSystemFormat();
    }
    
    public static void setSystemFormat(SystemFormat systemFormat) {
	SystemEnvironment.getInstance().setSystemFormat(systemFormat);
    }

    ////
    
    // ----------------------------------------------------------------------------------------------------
    // 
    // Platform Components
    //
    // ----------------------------------------------------------------------------------------------------

    public static List<PlatformClient> getAvailableClients() {
	return getContext().getAvailableClients();
    }

    public static List<PlatformServer> getAvailableServers() {
	return getContext().getAvailableServers();
    }

    public void addClient(PlatformClient client) {
	getContext().addClient(client);
    }

    public void addServer(PlatformServer server) {
	getContext().addServer(server);
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Platform Classes
    //
    // ----------------------------------------------------------------------------------------------------

    public static String getConnectionManagerClass() {
	return getContext().getConnectionManagerClass();
    }

    public static void setConnectionManagerClass(String connectionManagerClass) {
	getContext().setConnectionManagerClass(connectionManagerClass);
    }

    public static String getServiceLocatorClass() {
	return getContext().getServiceLocatorClass();
    }

    public static void setServiceLocatorClass(String serviceLocatorClass) {
	getContext().setServiceLocatorClass(serviceLocatorClass);
    }

    public static String getConfigLoaderClass() {
	return getContext().getConfigLoaderClass();
    }

    public static void setConfigLoaderClass(String configLoaderClass) {
	getContext().setConfigLoaderClass(configLoaderClass);
    }

    public static String getPeriodCreatorClass() {
	return getContext().getPeriodCreatorClass();
    }

    public static void setPeriodCreatorClass(String periodCreatorClass) {
	getContext().setPeriodCreatorClass(periodCreatorClass);
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Storage path
    //
    // ----------------------------------------------------------------------------------------------------

    public static String getDataStoragePath() {
	return getContext().getDataStoragePath();
    }

    public static void setDataStoragePath(String dataStoragePath) {
	getContext().setDataStoragePath(dataStoragePath);
    }

    public static String getDocumentStoragePath() {
	return getContext().getDocumentStoragePath();
    }

    public static void setDocumentStoragePath(String documentStoragePath) {
	getContext().setDocumentStoragePath(documentStoragePath);
    }

    public static String getReportStoragePath() {
	return getContext().getReportStoragePath();
    }

    public static void setReportStoragePath(String reportStoragePath) {
	getContext().setReportStoragePath(reportStoragePath);
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Reporting PlatformSystem
    //
    // ----------------------------------------------------------------------------------------------------

    // ----------------------------------------------------------------------------------------------------
    // 
    // Service Management
    //
    // ----------------------------------------------------------------------------------------------------

    public static ServiceLocator getServiceLocator() {
	return ServiceFactory.getServiceLocator();
    }

    public static Object getService(Class serviceInterface) {
	return ServiceFactory.getService(serviceInterface);
    }

    public static Object getService(String serviceName) {
	// TODO: Not supported
	return null;
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Object Configurers
    //
    // ----------------------------------------------------------------------------------------------------

//    public static ObjectConfigurer getConfigurer(String name) {
//	return ConfigurerManager.getConfigurer(name);
//    }
//
//    public static void addConfigurer(String name, ObjectConfigurer configurer) {
//	ConfigurerManager.addConfigurer(name, configurer);
//    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // Secure Management
    //
    // ----------------------------------------------------------------------------------------------------

    // TODO

    // ----------------------------------------------------------------------------------------------------
    // 
    // Property Store
    //
    // ----------------------------------------------------------------------------------------------------

    public static void setPropertyStore(String name, Properties prop) {
	getContext().setPropertyStore(name, prop);
    }

    public static Properties getPropertyStore(String name) {
	return getContext().getPropertyStore(name);
    }

    // ----------------------------------------------------------------------------------------------------
    // 
    // System
    //
    // ----------------------------------------------------------------------------------------------------

    public static PlatformSystem getSystem() {
	return getContext().getSystem();
    }

}
