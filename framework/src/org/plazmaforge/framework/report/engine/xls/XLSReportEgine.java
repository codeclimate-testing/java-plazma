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

package org.plazmaforge.framework.report.engine.xls;

import java.sql.Connection;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.AbstractReportEngine;
import org.plazmaforge.framework.report.IReport;

public class XLSReportEgine extends AbstractReportEngine {
    
    public final String COMPILE_FILE_EXT = "xls";

    public final String DESIGN_FILE_EXT = COMPILE_FILE_EXT;

    public final String PRINT_FILE_EXT = COMPILE_FILE_EXT;

    protected String getReportCompileFileExt() {
	return COMPILE_FILE_EXT;
    }

    protected String getReportDesignFileExt() {
	return DESIGN_FILE_EXT;
    }

    protected String getReportPrintFileExt() {
	return PRINT_FILE_EXT;
    }

    // //

    protected String getReportFileExt(int fileType) {
	return COMPILE_FILE_EXT;
    }

    public void viewReport(Object reportData) throws ApplicationException {
	// TODO: Stub
    }

    public Object fillReport(Class klass, String name, Map parameters)
	    throws ApplicationException {
	// TODO: Stub
	return null;
    }

    public void viewReport(Class klass, String name, Map parameters)
	    throws ApplicationException {

    }

    public Object fillReport(IReport report) throws ApplicationException {
	// TODO: Stub
	return null;
    }

    public Object doFillReport(Class klass, String name, Map parameters, Connection cn) throws ApplicationException {
	// TODO: Stub
	return null;
    }

    public Object doFillReport(IReport report, Connection cn) throws ApplicationException {
	// TODO: Stub
	return null;
    }

    public Object doFillReport(IReport report, Map parameters, Connection cn) throws ApplicationException {
	// TODO: Stub
	return null;
    }
}
