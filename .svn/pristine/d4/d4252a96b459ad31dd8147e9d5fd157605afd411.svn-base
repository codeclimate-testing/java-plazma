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

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;


/** 
 * @author Oleh Hapon
 * $Id: AbstractEmployableEditForm.java,v 1.2 2010/04/28 06:31:04 ohapon Exp $
 */

public abstract class AbstractEmployableEditForm extends AbstractEditForm implements EmployableForm {
    
    /** OrganizationHeader ID * */
    private Integer organizationId;

    /** Period ID * */
    private Integer periodId;

    /** Employee * */
    private EmployeeHeader employee;

    
    public AbstractEmployableEditForm(Composite parent, int style) {
	super(parent, style);
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
}
