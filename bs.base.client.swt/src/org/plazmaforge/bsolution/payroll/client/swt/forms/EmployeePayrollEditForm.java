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
import org.plazmaforge.bsolution.employee.client.swt.forms.AbstractEmployableEditForm;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeePayroll;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: EmployeePayrollEditForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class EmployeePayrollEditForm extends AbstractEmployableEditForm {
    
    private Label employeeLabel;
    
    private Label payrollLabel;
    
    private Label payrollDayLabel;
    
    private Label payrollHourLabel;
    
    private Label amountLabel;
    
    
    private XTextField employeeField;
    
    private XComboEdit payrollField;
    
    private XIntegerField payrollDayField;
    
    private XCurrencyField payrollHourField;
    
    private XCurrencyField amountField;
    

    
    
    ///---
    
    private Integer organizationId;
    
    private Integer periodId;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EmployeePayrollEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("EmployeePayrollEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
       	employeeLabel = new Label(this, SWT.NONE);
	employeeLabel.setText(Messages.getString("EmployeePayrollEditForm.employeeLabel.text")); //$NON-NLS-1$

    	employeeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 200;
    	employeeField.setLayoutData(gridData);
    	
    	
    	payrollLabel = new Label(this, SWT.NONE);
    	payrollLabel.setText(Messages.getString("EmployeePayrollEditForm.payrollLabel.text")); //$NON-NLS-1$

    	payrollField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 200;
    	payrollField.setLayoutData(gridData);
    	
    	
    	payrollDayLabel = new Label(this, SWT.NONE);
    	payrollDayLabel.setText(Messages.getString("EmployeePayrollEditForm.payrollDayLabel.text")); //$NON-NLS-1$

    	payrollDayField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	payrollDayField.setLayoutData(gridData);
    	
    	
	payrollHourLabel = new Label(this, SWT.NONE);
    	payrollHourLabel.setText(Messages.getString("EmployeePayrollEditForm.payrollHourLabel.text")); //$NON-NLS-1$

    	payrollHourField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	payrollHourField.setLayoutData(gridData);
    	
    	
    	amountLabel = new Label(this, SWT.NONE);
    	amountLabel.setText(Messages.getString("EmployeePayrollEditForm.amountLabel.text")); //$NON-NLS-1$

    	amountField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	amountField.setLayoutData(gridData);
    	
    	this.setSize(new Point(470, 108));
    	
    
	initNoEditableField(employeeField);
    }
    
    protected void bindControls() {
	bindControl(employeeField, "employeeName");
	bindControl(payrollDayField, "payrollDay");
	bindControl(payrollHourField, "payrollHour");
	bindControl(amountField, "amount");
	bindControl(payrollField, "payroll", payrollLabel, REQUIRED);
    }
    
       
    public boolean setFocus () {
	
	boolean f = super.setFocus();
	if (f) {
	    return payrollField.setFocus();
	}
	return f;
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getEmployeePayroll().setOrganizationId(getOrganizationId());
	getEmployeePayroll().setPeriodId(getPeriodId());
	getEmployeePayroll().setEmployee(getEmployee());
    }
  
    private EmployeePayroll getEmployeePayroll() {
	return (EmployeePayroll) getEntity();
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
