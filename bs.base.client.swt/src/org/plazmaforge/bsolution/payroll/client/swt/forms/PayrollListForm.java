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
 * Created on 04.04.2007
 *
 */

package org.plazmaforge.bsolution.payroll.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

/** 
 * @author Oleh Hapon
 * $Id: PayrollListForm.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class PayrollListForm extends AbstractListForm {

    private Table table;
    

    
    public PayrollListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PayrollListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn payrollTypeColumn;
        TableColumn priorityColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setSortDirection(SWT.DOWN);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	table.setSortColumn(codeColumn);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("PayrollListForm.codeColumn.text")); //$NON-NLS-1$
    	
 	nameColumn = new TableColumn(table, SWT.NONE);
    	table.setSortColumn(codeColumn);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("PayrollListForm.nameColumn.text")); //$NON-NLS-1$
    	
 	payrollTypeColumn = new TableColumn(table, SWT.NONE);
    	table.setSortColumn(codeColumn);
    	payrollTypeColumn.setWidth(200);
    	payrollTypeColumn.setText(Messages.getString("PayrollListForm.payrollTypeColumn.text")); //$NON-NLS-1$
    	
 	priorityColumn = new TableColumn(table, SWT.RIGHT);
    	table.setSortColumn(codeColumn);
    	priorityColumn.setWidth(200);
    	priorityColumn.setText(Messages.getString("PayrollListForm.priorityColumn.text"));    	 //$NON-NLS-1$

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");
	bindColumn(2, "name");
	bindColumn(3, "payrollTypeName");
	bindColumn(4, "priority");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"



