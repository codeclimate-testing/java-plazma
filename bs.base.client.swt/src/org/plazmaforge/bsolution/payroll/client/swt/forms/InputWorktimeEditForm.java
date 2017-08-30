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

package org.plazmaforge.bsolution.payroll.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeTotal;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeTotalService;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: InputWorktimeEditForm.java,v 1.3 2010/12/05 07:57:20 ohapon Exp $
 */

public class InputWorktimeEditForm extends AbstractEditForm {
    
    private Label employeeLabel;
    
    private Label workDayLabel;
    
    private Label workHourLabel;
    
    
    private XTextField employeeField;
    
    private XIntegerField workDayField;
    
    private XCurrencyField workHourField;
    

    
    
    ///---
    
    private Integer organizationId;
    
    private Integer periodId;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public InputWorktimeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("InputWorktimeEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
       	employeeLabel = new Label(this, SWT.NONE);
	employeeLabel.setText(Messages.getString("InputWorktimeEditForm.employeeLabel.text")); //$NON-NLS-1$

    	employeeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 200;
    	employeeField.setLayoutData(gridData);
    	
    	
    	workDayLabel = new Label(this, SWT.NONE);
    	workDayLabel.setText(Messages.getString("InputWorktimeEditForm.workDayLabel.text")); //$NON-NLS-1$

    	workDayField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	workDayField.setLayoutData(gridData);
    	
    	
	workHourLabel = new Label(this, SWT.NONE);
    	workHourLabel.setText(Messages.getString("InputWorktimeEditForm.workHourLabel.text")); //$NON-NLS-1$

    	workHourField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	workHourField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108));
    	
    	///--
    	setEntityClass(EmployeeTotal.class);
	setEntityServiceClass(EmployeeTotalService.class);
	
	initNoEditableField(employeeField);
    }
    
    protected void bindControls() {
	bindControl(employeeField, "employeeName");
	bindControl(workDayField, "workDay");
	bindControl(workHourField, "workHour");
    }
    
    private EmployeeResult getEmployeeResult() {
	return (EmployeeResult) getForwardEntity();
    }
    
      
    public boolean setFocus () {
	
	boolean f = super.setFocus();
	if (f) {
	    return workDayField.setFocus();
	}
	return f;
    }
    
    protected void createData() throws ApplicationException {
	//NO SUPPORT
    }
    
    protected void loadData() throws ApplicationException {
	EmployeeResult employeeResult = getEmployeeResult();
	if (employeeResult.getEmployeeTotalId() == null) {
	    EmployeeTotal total = new EmployeeTotal();
	    total.setPeriodId(getPeriodId());
	    total.setEmployee(employeeResult.getEmployee());
	    setEntityId(null);
	    setEntity(total);
	} else {
	    setEntityId(employeeResult.getEmployeeTotalId());
	    super.loadData();
	}
    }
    
    protected void storeData() throws ApplicationException {
	if (getEntityId() == null) {
	    super.createData();
	} else {
	    super.storeData();
	}
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

    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"



