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
/*
 * Created on 18.06.2005
 *
 */
package org.plazmaforge.bsolution.document.client.swing.forms;

import java.awt.Window;
import java.util.Date;
import java.util.Map;

import javax.swing.*;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.common.PeriodReportDialog;
import org.plazmaforge.bsolution.document.common.services.DocumentService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;


/**
 * <code>Abstract Document List Form</code> 
 * Use <code>DocumentService</code>
 * 
 * @author hapon
 * 
 */
public abstract class AbstractDocumentList extends EXTListForm {

    /** OrganizationHeader ID * */
    private Integer organizationId;

    /** Period ID * */
    private Integer periodId;

    private Date startDate;

    private Date endDate;

    private PeriodReportDialog intervalDialog;

    public AbstractDocumentList() {
	super();
	initialize();
    }

    public AbstractDocumentList(JDesktopPane desktop, Resources resources) {
	super(desktop, resources);
	initialize();
    }

    public AbstractDocumentList(JDesktopPane jDesktopPane, String s) {
	super(jDesktopPane, s);
	initialize();
    }

    public AbstractDocumentList(Resources resources) {
	super(resources);
	initialize();
    }

    public AbstractDocumentList(String s) {
	super(s);
	initialize();
    }

    public AbstractDocumentList(Window window, Resources resources) {
	super(window, resources);
	initialize();
    }

    private void initialize() {
	this.setOrganizationId(EnterpriseEnvironment.getOrganizationId(getEnterpriseContext()));
	this.setPeriodId(EnterpriseEnvironment.getPeriodId());
	this.setIntervalActionVisible(true);
    }

    public Integer getOrganizationId() {
	return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
	this.organizationId = organizationId;
    }

    public Integer getPeriodId() {
	return periodId;
    }

    public void setPeriodId(Integer periodId) {
	this.periodId = periodId;
    }

    protected DocumentService getDocumentService() {
	return (DocumentService) this.getEntityService();
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    protected PeriodReportDialog getIntervalDialog() {
	if (intervalDialog == null) {
	    intervalDialog = new PeriodReportDialog();
	}
	return intervalDialog;
    }

    protected void loadData() throws ApplicationException {
	if (getStartDate() != null || getEndDate() != null) {
	    refreshTableModel(getDocumentService()
		    .findByOrganizationIdAndInterval(getOrganizationId(),
			    getStartDate(), getEndDate()));

	} else {
	    refreshTableModel(getDocumentService()
		    .findByOrganizationIdAndPeriodId(getOrganizationId(),
			    getPeriodId()));
	}
    }

    public void doIntervalCommand() throws ApplicationException {
	if (getIntervalDialog().showDialog() != JOptionPane.OK_OPTION) {
	    return;
	}
	Map parameters = getIntervalDialog().readParameters();
	setStartDate((Date) parameters.get("PERIOD_START_DATE"));
	setEndDate((Date) parameters.get("PERIOD_END_DATE"));
	doRefreshData();
    }

    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }
}
