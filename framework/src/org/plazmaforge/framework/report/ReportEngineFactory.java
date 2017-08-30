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

package org.plazmaforge.framework.report;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.platform.PlatformContext;
import org.plazmaforge.framework.report.engine.jasperreports.JasperReportsEngine;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;

public class ReportEngineFactory {

    public static final String REPORT_ENGINE_CLASS = PlatformContext.SYSTEM_PROPERTY_PREFIX +  "report.engine.class";
    
    
    private static Logger log = Logger.getLogger(ReportEngineFactory.class);
    
  
    private ReportEngine defaultReportEngine;
    
    /** Report Engine Map (Name, Class) **/
    private Map<String, String> reportEngineClassMap = new HashMap<String, String>();

    /** Report Engine (Name, ReportEngine) **/
    private Map<String, ReportEngine> reportEngineMap = new HashMap<String, ReportEngine>();

    
    
    private static ReportEngineFactory instance;

    private ReportEngineFactory() {

    }

    static {
	String defaultClassName = getInstance().getReportEngineClassByProperty(REPORT_ENGINE_CLASS);
	addReportEngineClass("default", defaultClassName);
	addReportEngineClass("jasperreports", defaultClassName);
    }
    
    
    public synchronized static ReportEngineFactory getInstance() {
	if (instance == null) {
	    instance = new ReportEngineFactory();
	}
	return instance;
    }
    
    private ReportEngine createReportEngine(String className) {
	ReportEngine reportEngine = null;
	try {
	    if (className == null) {
		log.warn("Report engine class is null. System will set default reporting engine");
		return getDefaultReportEngine();
	    }
	    reportEngine = (ReportEngine) ClassUtilsExt.getClassInstance(className);
	} catch (Exception ex) {
	    log.error("Create report engine error", ex);
	    return getDefaultReportEngine();
	}
	return reportEngine;
    }
    
    
    private ReportEngine getDefaultReportEngine() {
	if (defaultReportEngine == null) {
	    //TODO: STUB
	    defaultReportEngine = new JasperReportsEngine();
	}
	return defaultReportEngine;
    }
  
    
    private String getReportEngineClassByProperty(String propertyName) {
	String className = System.getProperty(propertyName);
	if (StringUtils.isEmpty(className)) {
	    return null;
	}
	return className.trim();
    }
    
    
    
    public static void addReportEngineClass(String name, String className) {
	getInstance().reportEngineClassMap.put(name, className);
    }
    
    public static String getReportEngineClass(String name) {
	return getInstance().reportEngineClassMap.get(name);
    }
    
    public static ReportEngine getReportEngine(String name) {
	ReportEngine reportEngine = getInstance().reportEngineMap.get(name);
	if (reportEngine != null) {
	    return reportEngine;
	}
	String className = getInstance().reportEngineClassMap.get(name);
	reportEngine = getInstance().createReportEngine(className);
	if (reportEngine != null) {
	    getInstance().reportEngineMap.put(name, reportEngine);
	    return reportEngine;
	}
	log.warn("Report engine class is null. System will set default reporting engine");
	return getInstance().getDefaultReportEngine();
    }
    
    public static ReportEngine getReportEngine(IReport report) {
	if (report == null){
	    return null;
	}
	//TODO: STUB
	return getReportEngine("default");
    }

    public static ReportEngine getReportEngine(Class reportClass) {
	if (reportClass == null){
	    return null;
	}
	//TODO: STUB
	return getReportEngine("default");
    }
}
