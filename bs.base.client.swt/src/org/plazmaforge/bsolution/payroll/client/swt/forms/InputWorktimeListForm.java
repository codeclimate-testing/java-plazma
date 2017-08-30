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
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: InputWorktimeListForm.java,v 1.3 2010/12/05 07:57:20 ohapon Exp $
 */

public class InputWorktimeListForm extends AbstractDocumentListForm {

    private Table table;
    

    
    public InputWorktimeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("InputWorktimeListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn employeeCodeColumn;
        TableColumn employeeNameColumn;
        TableColumn departmentNameColumn;
        TableColumn workDayColumn;
        TableColumn workHourColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setSortDirection(SWT.DOWN);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	employeeCodeColumn = new TableColumn(table, SWT.NONE);
    	employeeCodeColumn.setWidth(100);
    	employeeCodeColumn.setText(Messages.getString("InputWorktimeListForm.employeeCodeColumn.text")); //$NON-NLS-1$
    	
 	employeeNameColumn = new TableColumn(table, SWT.NONE);
    	employeeNameColumn.setWidth(300);
    	employeeNameColumn.setText(Messages.getString("InputWorktimeListForm.employeeNameColumn.text")); //$NON-NLS-1$
    	
 	departmentNameColumn = new TableColumn(table, SWT.NONE);
    	departmentNameColumn.setWidth(200);
    	departmentNameColumn.setText(Messages.getString("InputWorktimeListForm.departmentNameColumn.text")); //$NON-NLS-1$
    	
 	workDayColumn = new TableColumn(table, SWT.RIGHT);
    	workDayColumn.setWidth(100);
    	workDayColumn.setText(Messages.getString("InputWorktimeListForm.workDayColumn.text")); //$NON-NLS-1$
    	
 	workHourColumn = new TableColumn(table, SWT.RIGHT);
    	workHourColumn.setWidth(100);
    	workHourColumn.setText(Messages.getString("InputWorktimeListForm.workHourColumn.text")); //$NON-NLS-1$


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
    }
 
    protected void initEditForm(IEditForm form ) throws ApplicationException {
	super.initEditForm(form);
	if (form == null) {
	    return;
	}
	InputWorktimeEditForm editForm = (InputWorktimeEditForm) form;
	editForm.setOrganizationId(getOrganizationId());
	editForm.setPeriodId(getPeriodId());
    }

 
}  //  @jve:decl-index=0:visual-constraint="10,10"



