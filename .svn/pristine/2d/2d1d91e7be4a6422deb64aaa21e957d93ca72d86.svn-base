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

package org.plazmaforge.framework.client.swing.report.jasperreports.actions;

import javax.swing.*;

import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.ReportProcessor;
import org.plazmaforge.framework.report.TableReport;
import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.resources.Resources;


/**
 * @author Oleh Hapon Date: 09.07.2004 Time: 22:32:21 $Id: TableReportAction.java,v 1.5 2010/12/05 07:52:08 ohapon Exp $
 */
public class TableReportAction extends AbstractSwingReportAction {

    public TableReportAction(Resources rsrc) {
	super(rsrc);
    }

    public TableReportAction(Resources rsrc, IReport report) {
	super(rsrc, report);
    }

    public TableReportAction(Resources rsrc, IAcceptor acceptor) {
	super(rsrc);
	setAcceptor(acceptor);
    }

    public TableReportAction(IAcceptor acceptor) {
	super(LibraryResources.getInstance());
	setAcceptor(acceptor);
    }

    protected void executeReport() throws ApplicationException {
	//ReportProcessor.executReport(getTitle(), getTable());
    }

    protected String getTitle() {
	return (String) getReport().getParameter(IReport.TITLE);
    }

    protected JTable getTable() {
	return (JTable) getReport().getParameter(IReport.TABLE);
    }

    protected IReport createReport() {
	return new TableReport();
    }
}
