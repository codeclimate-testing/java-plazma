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
 * Created on 10.07.2007
 *
 */

package org.plazmaforge.bsolution.employee.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.services.EmployableService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractEmployableListForm.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public abstract class AbstractEmployableListForm extends AbstractListForm implements EmployableForm, IOwnCriteriaImplementator {

    /** OrganizationHeader ID * */
    private Integer organizationId;

    /** Period ID * */
    private Integer periodId;

    /** Employee * */
    private EmployeeHeader employee;

    
    
    public AbstractEmployableListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
        setOrganizationId(EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
        setPeriodId(EnterpriseEnvironment.getPeriodId());
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

    public EmployeeHeader getEmployee() {
	return employee;
    }

    public void setEmployee(EmployeeHeader employee) {
	this.employee = employee;
    }

    /**
     * Get EmployableService
     * 
     * @return
     */
    private EmployableService getEmployableService() {
	return (EmployableService) getEntityService();
    }

    
    protected List loadDataList() throws ApplicationException {
	if (getEmployableService() == null || getEmployee() == null) {
	    return null;
	}
	if (getPeriodId() == null) {
	    return getEmployableService().findByEmployee(getEmployee().getId());
	} else {
	    return getEmployableService().findByEmployeeAndPeriod(getEmployee().getId(), getPeriodId());
	}
    }

    protected List loadDataList(Criteria criteria) throws ApplicationException {
	if (getEmployableService() == null || getEmployee() == null) {
	    return null;
	}
	if (getPeriodId() == null) {
	    return getEmployableService().findByEmployee(getEmployee().getId(), criteria);
	} else {
	    return getEmployableService().findByEmployeeAndPeriod(getEmployee().getId(), getPeriodId(), criteria);
	}
    }


    protected void initEditForm(IEditForm form) throws ApplicationException {
	super.initEditForm(form);
	if (form == null) {
	    return;
	}
	if (!(form instanceof EmployableForm)) {
	    return;
	}
	EmployableForm employableForm = (EmployableForm) form;

	employableForm.setOrganizationId(this.getOrganizationId());
	employableForm.setPeriodId(this.getPeriodId());
	employableForm.setEmployee(this.getEmployee());

    }

}
