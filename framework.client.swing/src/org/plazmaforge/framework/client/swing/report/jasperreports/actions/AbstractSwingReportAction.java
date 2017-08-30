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

import org.plazmaforge.framework.client.swing.actions.ResourceAction;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.NullAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.InvalidReportParameterException;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.ReportProcessor;
import org.plazmaforge.framework.resources.Resources;


import java.awt.event.ActionEvent;

/**
 * @author Oleh Hapon Date: 09.07.2004 Time: 22:13:11 $Id: AbstractSwingReportAction.java,v 1.4 2010/12/05 07:52:08 ohapon Exp $
 */
public abstract class AbstractSwingReportAction extends ResourceAction implements ReportAction {

    private IReport report;

    private IAcceptor acceptor;

    private boolean ignoreInvalidParameter;

    public AbstractSwingReportAction() {
	super();
    }

    public AbstractSwingReportAction(Resources rsrc) {
	super(rsrc);
    }

    public AbstractSwingReportAction(Resources rsrc, IReport report) {
	super(rsrc);
	initReport(report);
    }

    public AbstractSwingReportAction(Resources rsrc, IAcceptor acceptor) {
	super(rsrc);
	this.acceptor = acceptor;
    }

    public AbstractSwingReportAction(Resources rsrc, IReport report, IAcceptor acceptor) {
	super(rsrc);
	initReport(report);
	this.acceptor = acceptor;
    }

    public AbstractSwingReportAction(IReport report) {
	super();
	initReport(report);
    }

    protected void initReport(IReport report) {
	this.report = report;
    }

    public void perform(ActionEvent evt) throws ApplicationException {
	try {
	    if (!isStartReport() || getReport() == null) {
		return;
	    }
	    readParameters();
	    verifyParameters();
	    executeReport();
	} catch (InvalidReportParameterException ex) {
	    if (isIgnoreInvalidParameter()) {
		return;
	    }
	}
    }

    public IReport getReport() {
	if (report == null) {
	    report = createReport();
	}
	return report;
    }

    protected boolean isStartReport() throws ApplicationException {
	return getAcceptor().isStartProcess();
    }

    protected void executeReport() throws ApplicationException {
	ReportProcessor.executeReport(this.getReport());
    }

    public final void setAcceptor(IAcceptor acceptor) {
	if (acceptor == null) {
	    throw new IllegalArgumentException("Acceptor is NULL");
	}
	this.acceptor = acceptor;
    }

    public final IAcceptor getAcceptor() {
	if (acceptor == null) {
	    acceptor = createAcceptor();
	}
	return acceptor;
    }

    protected void readParameters() throws ApplicationException {
	IAcceptor acceptor = getAcceptor();
	if (acceptor != null) {
	    getReport().addParameters(acceptor.readParameters());
	}
	getReport().readParameters();
    }

    protected void verifyParameters() throws InvalidReportParameterException {
	getReport().verifyParameters();
    }

    protected abstract IReport createReport();

    protected IAcceptor createAcceptor() {
	return new NullAcceptor();
    }

    public String toString() {
	return (String) this.getValue(Action.NAME);
    }

    

    public boolean isIgnoreInvalidParameter() {
	return ignoreInvalidParameter;
    }

    public void setIgnoreInvalidParameter(boolean ignoreInvalidParameter) {
	this.ignoreInvalidParameter = ignoreInvalidParameter;
    }
}
