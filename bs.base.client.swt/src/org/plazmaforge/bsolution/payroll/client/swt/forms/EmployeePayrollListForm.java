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
import org.plazmaforge.bsolution.employee.client.swt.forms.AbstractEmployableListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.criteria.IDisableCriteriaImplementator;



/** 
 * @author Oleh Hapon
 * $Id: EmployeePayrollListForm.java,v 1.5 2010/12/05 07:57:20 ohapon Exp $
 */

public class EmployeePayrollListForm extends AbstractEmployableListForm implements IDisableCriteriaImplementator {

    private Table table;
    

    
    public  EmployeePayrollListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("EmployeePayrollListForm.title")); //$NON-NLS-1$
	
	// NO PAGING !!!
	setDisablePagingMode();
	
        TableColumn tableColumn;
        TableColumn payrollCodeColumn;
        TableColumn payrollNameColumn;
        TableColumn payrollTypeNameColumn;
        TableColumn payrollDayColumn;
        TableColumn payrollHourColumn;
        TableColumn amountColumn;
     

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setSortDirection(SWT.DOWN);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(10);

    	payrollCodeColumn = new TableColumn(table, SWT.NONE);
    	payrollCodeColumn.setWidth(50);
    	payrollCodeColumn.setText(Messages.getString("EmployeePayrollListForm.payrollCodeColumn.text"));  //$NON-NLS-1$
    	
 	payrollNameColumn = new TableColumn(table, SWT.NONE);
    	payrollNameColumn.setWidth(200);
    	payrollNameColumn.setText(Messages.getString("EmployeePayrollListForm.payrollNameColumn.text")); //$NON-NLS-1$
    	
 	payrollTypeNameColumn = new TableColumn(table, SWT.NONE);
    	payrollTypeNameColumn.setWidth(150);
    	payrollTypeNameColumn.setText(Messages.getString("EmployeePayrollListForm.payrollTypeColumn.text")); //$NON-NLS-1$
    	

 	payrollDayColumn = new TableColumn(table, SWT.RIGHT);
    	payrollDayColumn.setWidth(80);
    	payrollDayColumn.setText(Messages.getString("EmployeePayrollListForm.payrollDayColumn.text")); //$NON-NLS-1$
    	
 	payrollHourColumn = new TableColumn(table, SWT.RIGHT);
    	payrollHourColumn.setWidth(80);
    	payrollHourColumn.setText(Messages.getString("EmployeePayrollListForm.payrollHourColumn.text")); //$NON-NLS-1$

    	amountColumn = new TableColumn(table, SWT.RIGHT);
    	amountColumn.setWidth(100);
    	amountColumn.setText(Messages.getString("EmployeePayrollListForm.amountColumn.text")); //$NON-NLS-1$


        this.setSize(new Point(700, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "payrollCode");
	bindColumn("payrollName");
	bindColumn("payrollTypeName");

	bindColumn("payrollDay");
	bindColumn("payrollHour", getCurrencyFormat());
	
	bindColumn("amount", getCurrencyFormat());
    }
 
  
 
}  //  @jve:decl-index=0:visual-constraint="10,10"


