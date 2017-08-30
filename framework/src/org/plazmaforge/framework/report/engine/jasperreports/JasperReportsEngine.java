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
package org.plazmaforge.framework.report.engine.jasperreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jasperreports.engine.util.JRStyledText;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;
import javax.swing.table.*;
import javax.swing.*;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.AbstractReportEngine;
import org.plazmaforge.framework.report.IReport;

/**
 * @author Oleh Hapon Date: 01.07.2004 Time: 20:38:36 $Id: JasperReportsEngine.java,v 1.12 2010/12/10 11:45:53 ohapon Exp $
 */
public class JasperReportsEngine extends AbstractReportEngine {

    public final String COMPILE_FILE_EXT = "jasper";
    
    public final String DESIGN_FILE_EXT = "jrxml";
    
    public final String PRINT_FILE_EXT = "jrprint";
    

    private static IReportPreview reportPreview;

    
    public JasperReportsEngine() {
	super();
	// TODO: Must use preferences or 'plazma.jasperreports.properties' file
	JRProperties.setProperty(JRStyledText.PROPERTY_AWT_IGNORE_MISSING_FONT, Boolean.TRUE); // 
    }

    protected String getReportCompileFileExt() {
	return COMPILE_FILE_EXT;
    }
    
    protected String getReportDesignFileExt() {
	return DESIGN_FILE_EXT;
    }
    
    protected String getReportPrintFileExt() {
	return PRINT_FILE_EXT;
    }

    ////
    
    protected String getReportFileExt(int fileType) {
	if (fileType == 1) {
	    return COMPILE_FILE_EXT;
	} else if (fileType == 2) {
	    return DESIGN_FILE_EXT;
	} else if (fileType == 3) {
	    return PRINT_FILE_EXT;
	} else {
	    return COMPILE_FILE_EXT;
	}
    }
    
    
    public void viewReport(String title, JTable table)
	    throws ApplicationException {
	try {

	    TableModel model = table.getModel();

	    Map parameters = new HashMap();
	    parameters.put(IReport.TITLE, title);

	    int[] fieldWidth = new int[model.getColumnCount()];
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < model.getColumnCount(); i++) {
		fieldWidth[i] = columnModel.getColumn(i).getWidth();
	    }

	    JasperReport report = JasperCompileManager.compileReport(getTableDesign(model, fieldWidth));
	    JasperPrint print = JasperFillManager.fillReport(report, parameters, createTableDataSource(model));

	    getReportPreview().viewReport(print, false);

	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    public JasperDesign getTableDesign(TableModel model, int[] fieldWidth)
	    throws JRException {
	return new TableDesign(model, fieldWidth);
    }

    public JRDataSource createTableDataSource(TableModel model) {
	JRDataSource dataSource = new TableDataSource(model);
	return dataSource;
    }

    public void viewReport(Object reportData) throws ApplicationException {
	if (!(reportData instanceof JasperPrint)) {
	    throw new ApplicationException("Invalid ReportData");
	}
	try {
	    JasperPrint print = (JasperPrint) reportData;
	    getReportPreview().viewReport(print, false);
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }



    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Do fill methods
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public Object doFillReport(Class klass, String name, Map parameters, Connection cn) throws ApplicationException {
	try {
	    InputStream is = klass.getResourceAsStream(name);
	    JasperReport jasperReport = JasperManager.loadReport(is);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);
	    return jasperPrint;
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    public Object doFillReport(IReport report, Connection cn) throws ApplicationException {
	return doFillReport(report, null, cn);
    }

    public Object doFillReport(IReport report, Map parameters, Connection cn) throws ApplicationException {
	try {
	    if (parameters == null) {
		parameters = report.getParameters();
	    }
	    InputStream is = getInputStream(report);

	    String subReportDir = report.getReportPath();
	    if (subReportDir.startsWith("file://")) {
		subReportDir = subReportDir.substring("file://".length());
	    }
	    parameters.put("SUBREPORT_DIR", subReportDir);
	    
	    prepareReportData(report, parameters, cn);
	    
	    //InputStream is = ReportProcessor.getReportEngine().getInputStream(report);
	    JasperReport jasperReport = JasperManager.loadReport(is);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, cn);
	    
	    return jasperPrint;
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    
    
    
    
    public static IReportPreview getReportPreview() {
	return reportPreview;
    }

    public static void setReportPreview(IReportPreview reportPreview) {
	JasperReportsEngine.reportPreview = reportPreview;
    }
    
    public Object createDataSourceByMapArray(Object[] mapArray)  throws ApplicationException {
	JRMapArrayDataSource dataSource = new JRMapArrayDataSource(mapArray);
	return dataSource;
    }

}
