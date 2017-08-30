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

import javax.swing.Action;

import org.plazmaforge.framework.report.DefaultReport;
import org.plazmaforge.framework.report.IReport;


public class SwingReportAction extends AbstractSwingReportAction {

    public SwingReportAction() {
	super();
    }

    public SwingReportAction(IReport report) {
	super(report);
    }

    protected IReport createReport() {
	return new DefaultReport();
    }

    protected void initReport(IReport report) {
	super.initReport(report);
	
	String name = report.getName();
	if (name == null) {
	    if (report.getId() != null ){
		name = report.getId();
	    } else {
		name = "Unknown Report";
	    }
	}
	String description = report.getDescription();
	
	this.putValue(Action.NAME, name);
	this.putValue(Action.SHORT_DESCRIPTION, description);
    }

}
