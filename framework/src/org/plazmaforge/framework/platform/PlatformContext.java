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
 * 21.01.2006
 */

/**
 * PlatformEnvironment Context
 *  
 */
package org.plazmaforge.framework.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.plazmaforge.framework.ext.association.AssociationCreator;
import org.plazmaforge.framework.platform.structure.PartContext;
import org.plazmaforge.framework.platform.structure.PlatformClient;
import org.plazmaforge.framework.platform.structure.PlatformServer;
import org.plazmaforge.framework.platform.structure.PlatformSystem;
import org.plazmaforge.framework.platform.structure.impl.DefaultPlatformSystem;
import org.plazmaforge.framework.report.ReportEngine;




public class PlatformContext implements PartContext {

    /**
     * Standard platform properties.
     * 
     * If property not found then return
     * PlatformSystem.getProperty(SYSTEM_PROPERTY_PREFIX + <propertyName>);
     */

    public static final String SYSTEM_PROPERTY_PREFIX = "plazma.platform.";

    public static final String CONNECTION_MANAGER_CLASS = SYSTEM_PROPERTY_PREFIX + "connection.manager.class";

    public static final String SERVICE_LOCATOR_CLASS = SYSTEM_PROPERTY_PREFIX + "service.locator.class";

    public static final String CONFIG_LOADER_CLASS = SYSTEM_PROPERTY_PREFIX + "config.loader.class";

    public static final String PERIOD_CREATOR_CLASS = SYSTEM_PROPERTY_PREFIX + "period.creator.class";
    
    
    public static final String PERMISSION_SERVICE_CLASS = SYSTEM_PROPERTY_PREFIX + "permission.service.class";
    
    public static final String TRANSFER_SERVICE_CLASS = SYSTEM_PROPERTY_PREFIX + "transfer.service.class";
    
    public static final String CUSTOM_TRANSFER_SERVICE_CLASS = SYSTEM_PROPERTY_PREFIX + "custom.transfer.service.class";
    
    
    public static final String ASSOCIATION_CREATOR_CLASS = SYSTEM_PROPERTY_PREFIX + "association.creator.class";
    
    public static final String SYSTEM_ENTITY_SERVICE_CLASS = SYSTEM_PROPERTY_PREFIX + "system.entity.service.class";    
    
    

    /**
     * Data storage path. Use when system don't use database or database
     * managements data files
     */
    public static final String DATA_STORAGE_PATH = SYSTEM_PROPERTY_PREFIX + "data.storage.path";

    /** Document storage path * */
    public static final String DOCUMENT_STORAGE_PATH = SYSTEM_PROPERTY_PREFIX + "document.storage.path";

    /** Report storage path * */
    public static final String REPORT_STORAGE_PATH = SYSTEM_PROPERTY_PREFIX + "report.storage.path";
    
    
    
    public static final String ENCRYPT_PASSWORD = SYSTEM_PROPERTY_PREFIX + "encrypt.password";
    
    public static final String ENCRYPT_PASSWORD_METHOD = SYSTEM_PROPERTY_PREFIX + "encrypt.password.method";
    

    private Map<String, Properties> propertyStores = new HashMap<String, Properties>();
    

    /** System * */
    private PlatformSystem system = new DefaultPlatformSystem();

    public PlatformContext() {
	super();
	
	setDataStoragePath("");
	setDocumentStoragePath("");
	setReportStoragePath("");
	
	setProperty(ENCRYPT_PASSWORD_METHOD, "MD5");
    }

    /** Platform properties * */
    private Properties properties = new Properties();

    /** Platform variables * */
    private Map<String, Object> variables = new HashMap<String, Object>();

    /** Platform available clients * */
    private List<PlatformClient> availableClients = new ArrayList<PlatformClient>();

    /** Platform available servers * */
    private List<PlatformServer> availableServers = new ArrayList<PlatformServer>();



    /** Association creator * */
    private AssociationCreator associationCreator;

    public Properties getProperties() {
	if (properties == null) {
	    properties = new Properties();
	}
	return properties;
    }

    public void setProperties(Properties properties) {
	this.properties = properties;
    }

    public void setProperty(String key, String value) {
	getProperties().setProperty(key, value);
    }

    public String getProperty(String key) {
	return getProperties().getProperty(key);
    }

    public void addVariable(String name, Object value) {
	variables.put(name, value);
    }

    public Object getVariable(String name) {
	return variables.get(name);
    }

    public Object getIntegerVariable(String name) {
	return (Integer) variables.get(name);
    }

    public Object getDoubleVariable(String name) {
	return (Double) variables.get(name);
    }

    public Object getStringVariable(String name) {
	return (String) variables.get(name);
    }

    public Object getFloatVariable(String name) {
	return (Float) variables.get(name);
    }

    public Object getLongVariable(String name) {
	return (Long) variables.get(name);
    }

    public List<PlatformClient> getAvailableClients() {
	return availableClients;
    }

    public List<PlatformServer> getAvailableServers() {
	return availableServers;
    }

    public void addClient(PlatformClient client) {
	availableClients.add(client);
    }

    public void addServer(PlatformServer server) {
	availableServers.add(server);
    }

    public String getConnectionManagerClass() {
	return getProperty(CONNECTION_MANAGER_CLASS);
    }

    public void setConnectionManagerClass(String connectionManagerClass) {
	setProperty(CONNECTION_MANAGER_CLASS, connectionManagerClass);
    }

    public String getServiceLocatorClass() {
	return getProperty(SERVICE_LOCATOR_CLASS);
    }

    public void setServiceLocatorClass(String serviceLocatorClass) {
	setProperty(SERVICE_LOCATOR_CLASS, serviceLocatorClass);
    }

    public String getConfigLoaderClass() {
	return getProperty(CONFIG_LOADER_CLASS);
    }

    public void setConfigLoaderClass(String configLoaderClass) {
	setProperty(CONFIG_LOADER_CLASS, configLoaderClass);
    }

    public String getPeriodCreatorClass() {
	return getProperty(PERIOD_CREATOR_CLASS);
    }

    public void setPeriodCreatorClass(String periodCreatorClass) {
	setProperty(PERIOD_CREATOR_CLASS, periodCreatorClass);
    }

    public String getDataStoragePath() {
	return getProperty(DATA_STORAGE_PATH);
    }

    public void setDataStoragePath(String dataStoragePath) {
	setProperty(DATA_STORAGE_PATH, dataStoragePath);
    }

    public String getDocumentStoragePath() {
	return getProperty(DOCUMENT_STORAGE_PATH);
    }

    public void setDocumentStoragePath(String documentStoragePath) {
	setProperty(DOCUMENT_STORAGE_PATH, documentStoragePath);
    }

    public String getReportStoragePath() {
	return getProperty(REPORT_STORAGE_PATH);
    }

    public void setReportStoragePath(String reportStoragePath) {
	setProperty(REPORT_STORAGE_PATH, reportStoragePath);
    }

   

    public AssociationCreator getAssociationCreator() {
	// PathAssociationCreator is default
	return associationCreator;
    }

    public void setAssociationCreator(AssociationCreator associationCreator) {
	this.associationCreator = associationCreator;
    }

    public void setPropertyStore(String name, Properties prop) {
	propertyStores.put(name, prop);
    }

    public Properties getPropertyStore(String name) {
	return (Properties) propertyStores.get(name);
    }

    public PlatformSystem getSystem() {
	return system;
    }
}
