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
 * 10.02.2006
 */

package org.plazmaforge.framework.report;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.config.AbstractConfigFactory;
import org.plazmaforge.framework.config.configurer.ReportConfigurer;
import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;

/**
 * Report factory
 * @author ohapon
 *
 */
public class ReportFactory extends AbstractConfigFactory {

    private static ReportFactory instance;

    private static IReportActionCreator reportActionCreator;
    
    
    
    private ReportFactory() {
    }

    public synchronized static ReportFactory getInstance() {
	if (instance == null) {
	    instance = new ReportFactory();
	}
	return instance;
    }

    @Override
    protected String getConfigurerName() {
	return ReportConfigurer.NAME;
    }

    /**
     * Get <code>Report</code> by id
     * 
     * @param id
     * @return
     */
    public static IReport getReportByName(String name) {
	return getInstance().createReport(getReportConfigByName(name));
    }


    /**
     * Get <code>ReportConfig</code> by name
     * 
     * @param id
     * @return
     */
    public static IReportConfig getReportConfigByName(String name) {
	return (IReportConfig) getInstance().getObjectConfigByName(name);
    }


    public static IReport getReportByConfig(IReportConfig reportConfig) {
	return getInstance().createReport(reportConfig);
    }

    /**
     * Create <code>Report</code> by <code>ReportConfig</code>
     * 
     * @param reportConfig
     * @return
     */
    protected IReport createReport(IReportConfig reportConfig) {
	if (reportConfig == null) {
	    return null;
	}
	
	String className = reportConfig.getClassName();
	if (!isEmpty(className)) {
	    return createReportByClass(reportConfig, className);
	}

	DefaultReport report = new DefaultReport();

	populateHeader(reportConfig, report);

	report.setPath(reportConfig.getPath());
	report.setFileName(reportConfig.getFileName());
	report.setRegion(reportConfig.getRegion());
	report.setCountry(reportConfig.getCountry());
	report.setLanguage(reportConfig.getLanguage());

	//report.setAsolutePath(reportConfig.isAbsolutePath());

	return report;
    }

    protected IReport createReportByClass(IReportConfig reportConfig, String className) {
	try {
	    IReport report = (IReport) ClassUtilsExt.getClassInstance(reportConfig.getClassName());
	    populateHeader(reportConfig, report);
	    return report;
	} catch (ApplicationException ex) {
	    logger.error("Error create report by class", ex);
	    return null;
	}
    }
    
    private void populateHeader(IReportConfig reportConfig, IReport report) {
	report.setId(reportConfig.getId());
	report.setName(reportConfig.getName());
	report.setCaption(reportConfig.getCaption());
    }

    /**
     * Get report action by report name
     * @param id
     * @return
     */
    public static IReportAction getReportActionByName(String reportName) {
	return getInstance().createReportActionByName(reportName);
    }


    /**
     * Get report action by reportConfig
     * @param reportConfig
     * @return
     */
    public static IReportAction getReportAction(IReportConfig reportConfig) {
	return getInstance().createReportAction(reportConfig);
    }

    /**
     * Create report action by name
     * @param id
     * @return
     */
    protected IReportAction createReportActionByName(String name) {
	return createReportAction(getReportConfigByName(name));
    }

    /**
     * Create report action by reportConfig
     * @param reportConfig
     * @return
     */
    protected IReportAction createReportAction(IReportConfig reportConfig) {
	if (reportConfig == null) {
	    return null;
	}
	IReport report = createReport(reportConfig);
	
	IReportActionCreator reportActionCreator = ReportFactory.reportActionCreator;
	IReportAction action =  reportActionCreator == null ? new DefaultReportAction(report) : reportActionCreator.createReportAction(report);

	if (!ReportProcessor.isSupported(report)) {
	    return null;
	}

	if (reportConfig.getAcceptor() != null) {
	    IAcceptor acceptor = ReportAcceptorFactory.getAcceptor(reportConfig, reportConfig.getAcceptor());
	    if (acceptor == null) {
		//action.setValidAcceptor(false);
		logger.warn("Acceptor of " + reportConfig  + " is invalid");
		return action; 
	    }
	    action.setAcceptor(acceptor);
	}
	return action;
	
    }


    
    public static void setReportActionCreator(IReportActionCreator reportActionCreator) {
        ReportFactory.reportActionCreator = reportActionCreator;
    }

    public static List<IReportConfig> getReportConfigs() {
	return getInstance().getObjects();
    }

    public static List<IReportConfig> getReportConfigsBySingle(boolean single) {
	List<IReportConfig> allReports = getReportConfigs();
	List<IReportConfig> reports = new ArrayList<IReportConfig>();
	for (IReportConfig rc : allReports) {
	    if (single == rc.isSingle()) {
		reports.add(rc);
	    }
	}
	return reports;
    }

    
    public static IAcceptor getReportAcceptor(IReportConfig reportConfig) {
	return ReportAcceptorFactory.getAcceptor(reportConfig);
    }
    
    
}
