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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentListForm;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeResultService;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: InputPayrollListForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class InputPayrollListForm extends AbstractDocumentListForm {

    private Table table;
    

    
    public InputPayrollListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("InputPayrollListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn employeeCodeColumn;
        TableColumn employeeNameColumn;
        TableColumn departmentNameColumn;
        TableColumn workDayColumn;
        TableColumn workHourColumn;
        TableColumn incrementAmountColumn;
        TableColumn decrementAmountColumn;
        TableColumn payrollAmountColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setSortDirection(SWT.DOWN);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(10);

    	employeeCodeColumn = new TableColumn(table, SWT.NONE);
    	employeeCodeColumn.setWidth(100);
    	employeeCodeColumn.setText(Messages.getString("InputPayrollListForm.employeeCodeColumn.text"));  //$NON-NLS-1$
    	
 	employeeNameColumn = new TableColumn(table, SWT.NONE);
    	employeeNameColumn.setWidth(300);
    	employeeNameColumn.setText(Messages.getString("InputPayrollListForm.employeeNameColumn.text")); //$NON-NLS-1$
    	
 	departmentNameColumn = new TableColumn(table, SWT.NONE);
    	departmentNameColumn.setWidth(150);
    	departmentNameColumn.setText(Messages.getString("InputPayrollListForm.departmentNameColumn.text")); //$NON-NLS-1$
    	
 	workDayColumn = new TableColumn(table, SWT.RIGHT);
    	workDayColumn.setWidth(80);
    	workDayColumn.setText(Messages.getString("InputPayrollListForm.workDayColumn.text")); //$NON-NLS-1$
    	
 	workHourColumn = new TableColumn(table, SWT.RIGHT);
    	workHourColumn.setWidth(80);
    	workHourColumn.setText(Messages.getString("InputPayrollListForm.workHourColumn.text")); //$NON-NLS-1$

    	incrementAmountColumn = new TableColumn(table, SWT.RIGHT);
    	incrementAmountColumn.setWidth(100);
    	incrementAmountColumn.setText(Messages.getString("InputPayrollListForm.incrementAmountColumn.text")); //$NON-NLS-1$
    	
    	decrementAmountColumn = new TableColumn(table, SWT.RIGHT);
    	decrementAmountColumn.setWidth(100);
    	decrementAmountColumn.setText(Messages.getString("InputPayrollListForm.decrementAmountColumn.text")); //$NON-NLS-1$
    	
    	payrollAmountColumn = new TableColumn(table, SWT.RIGHT);
    	payrollAmountColumn.setWidth(100);
    	payrollAmountColumn.setText(Messages.getString("InputPayrollListForm.payrollAmountColumn.text")); //$NON-NLS-1$

        this.setSize(new Point(600, 300));
        
        ///---
	setPeriodId(EnterpriseEnvironment.getPayrollPeriodId());
	setEntityClass(EmployeeResult.class);
	setEntityServiceClass(EmployeeResultService.class);
	
	setSupportAddMode(false);
	setSupportDelMode(false);
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "employeeCode");
	bindColumn(2, "employeeName");
	bindColumn(3, "departmentName");
	bindColumn(4, "workDay");
	bindColumn(5, "workHour", getCurrencyFormat());
	
	bindColumn(6, "incrementAmount", getCurrencyFormat());
	bindColumn(7, "decrementAmount", getCurrencyFormat());
	bindColumn(8, "payrollAmount", getCurrencyFormat());
    }
 
    public void doEnterAction() throws ApplicationException  {
	Object entity = getSelectedEntity();
	if (entity == null) {
	    return;
	}
	
	EmployeePayrollListForm listForm = (EmployeePayrollListForm) Toolkit.getListForm(null, EmployeePayrollListForm.class, true);
        listForm.setOrganizationId(getOrganizationId());
	listForm.setPeriodId(getPeriodId());
	listForm.setEmployee(((EmployeeResult) entity).getEmployee());
        
	Toolkit.openForm(null, listForm);
    }
    

 
}  //  @jve:decl-index=0:visual-constraint="10,10"




