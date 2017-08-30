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

/**
 * Report Processor
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import org.apache.log4j.Logger;
import org.plazmaforge.framework.action.DefaultProcessRunner;
import org.plazmaforge.framework.action.IProcess;
import org.plazmaforge.framework.action.IProcessRunner;
import org.plazmaforge.framework.action.IProcessor;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.security.SecureEnvironment;
import org.plazmaforge.framework.security.SecureManager;
import org.plazmaforge.framework.util.StringUtils;


public class ReportProcessor implements IProcessor {

    private static Logger log = Logger.getLogger(ReportProcessor.class);
    
    private static ReportProcessor instance;
    
    

    private Locale locale;



    private static IProcessRunner processRunner;
    
    

    private ReportProcessor() {
    }

    public static ReportProcessor getInstance() {
	if (instance == null) {
	    instance = new ReportProcessor();
	}
	return instance;
    }

    public static Locale getLocale() {
	return getInstance().getReportingLocale();
    }

    public static String getCountry() {
	return getInstance().getReportingCountry();
    }

    public static String getLanguage() {
	return getInstance().getReportingLanguage();
    }

    public static String getRegion() {
	return getInstance().getReportingRegion();
    }

    public static Locale[] getOtherFamilyLocales() {
	Locale locale = getLocale();
	Locale[] familyLocales = LocaleManager.getFamilyLocales();
	if (familyLocales.length == 0) {
	    return familyLocales;
	}
	List<Locale> availables = new ArrayList<Locale>();
	for (int i = 0; i < familyLocales.length; i++) {
	    if ((equals(locale.getCountry(), familyLocales[i].getCountry()) && equals(
		    locale.getLanguage(), familyLocales[i].getLanguage()))) {
		continue;
	    }
	    availables.add(familyLocales[i]);
	}
	return (Locale[]) availables.toArray(new Locale[0]);
    }

    public Locale getReportingLocale() {
	if (locale == null) {
	    locale = Locale.getDefault();
	}
	return locale;
    }

    public void setReportingLocale(Locale locale) {
	this.locale = locale;
    }

    public String getReportingCountry() {
	return getReportingLocale().getCountry();
    }

    public String getReportingLanguage() {
	return getReportingLocale().getLanguage();
    }

    public String getReportingRegion() {
	return LocaleManager.getRegion(getReportingLocale());
    }

    public static boolean isSupported(IReport report) {
	if (report == null) {
	    return false;
	}

	// Check region
	if (!equals(getRegion(), report.getRegion())) {
	    return false;
	}

	// Check country
	Locale locale = getLocale();
	if (locale == null) {
	    return false;
	}
	return equals(locale.getCountry(), report.getCountry());

    }

    private static boolean equals(String s1, String s2) {
	return StringUtils.equals(s1, s2);
    }

    public static boolean isSupportedRegionInTemplatePath() {
	return false;
    }

    
    // ---------------------------------------------------------------------------------------------
    // Report Manager
    // ---------------------------------------------------------------------------------------------

    public static void executeReport(final IReport report) throws ApplicationException {
	
	checkSecureReport(report);
	
	// hack: bad code.
	final Map<String, Object> map = new HashMap<String, Object>();
	getProcessRunner().run(new IProcess() {
	    public void run() throws ApplicationException {
		ReportEngine engine = ReportEngineFactory.getReportEngine(report);
		Object reportData = engine.fillReport(report);
		map.put("ENGINE", engine);
		map.put("DATA", reportData);
		//engine.viewReport(reportData);
	    }
	});
	
	ReportEngine engine = (ReportEngine) map.get("ENGINE");
	engine.viewReport(map.get("DATA"));
    }

    /*
    public static void executReport(String title, JTable table) throws ApplicationException {
	ReportProcessor.getReportEngine().viewReport(title, table);
    }
    */

    public static void executeReport(Class reportClass, String name, Map parameters) throws ApplicationException {
	checkSecureReport(reportClass);
	ReportEngineFactory.getReportEngine(reportClass).viewReport(reportClass, name, parameters);
    }

    /*
    public static void viewReport(String title, JTable table) throws ApplicationException {
	ReportEngine engine = getReportEngine();
	if (engine == null) {
	    throw new ApplicationException("Report Engine not found");
	}
	engine.viewReport(title, table);
    }
    */

    
    
    
    
    private static void checkSecureReport(IReport report) throws ApplicationException {
	if (report == null) {
	    return;
	}
	String secureObjectId = report.getName();
	if (secureObjectId == null) {
	    return;
	}
	
	// DISABLE
	//System.out.println("checkSecureReport [" + secureObjectId  + "]");
	SecureEnvironment.getSecureManager().checkExecPermission(secureObjectId, SecureManager.REPORT);
    }
    
    private static void checkSecureReport(Class reportClass) throws ApplicationException {
	// EMPTY
    }
    
    


    public static IProcessRunner getProcessRunner() {
	if (processRunner == null) {
	    processRunner = new DefaultProcessRunner();
	}
        return processRunner;
    }

    public static void setProcessRunner(IProcessRunner fProcessRunner) {
        processRunner = fProcessRunner;
    }
    
    
}
