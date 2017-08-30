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
package org.plazmaforge.bsolution.employee.client.swing.forms;

import java.awt.Window;

import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.services.EmployableService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;


public abstract class AbstractEmployableList extends EXTListForm implements EmployableForm {

    /** OrganizationHeader ID * */
    private Integer organizationId;

    /** Period ID * */
    private Integer periodId;

    /** Employee * */
    private EmployeeHeader employee;

    public AbstractEmployableList() {
	super();
    }

    public AbstractEmployableList(Resources resources) {
	super(resources);
    }

    public AbstractEmployableList(Window window, Resources resources) {
	super(window, resources);
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
	return (EmployableService) this.getEntityService();
    }

    /**
     * Load data by Employee ID
     */
    protected void loadData() throws ApplicationException {
	if (this.getPeriodId() == null) {
	    refreshTableModel(getEmployableService().findByEmployee(getEmployee().getId()));
	} else {
	    refreshTableModel(getEmployableService().findByEmployeeAndPeriod(getEmployee().getId(), getPeriodId()));
	}
    }

    /**
     * Get EmployableForm. Set Employee
     */
    protected EditForm getEditForm() throws ApplicationException {
	EditForm form = super.getEditForm();
	EmployableForm employableForm = (EmployableForm) form;

	employableForm.setOrganizationId(this.getOrganizationId());
	employableForm.setPeriodId(this.getPeriodId());
	employableForm.setEmployee(this.getEmployee());

	return form;
    }

}
