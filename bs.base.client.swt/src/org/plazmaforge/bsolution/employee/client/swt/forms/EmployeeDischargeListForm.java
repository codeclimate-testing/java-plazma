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
 * Created on 09.07.2007
 *
 */

package org.plazmaforge.bsolution.employee.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeDischargeListForm.java,v 1.3 2010/04/28 06:31:04 ohapon Exp $
 */

public class EmployeeDischargeListForm extends AbstractDocumentListForm {

    private Table table;
    

    
    
    public EmployeeDischargeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("EmployeeDischargeListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn employeeColumn;
        TableColumn responsibleColumn;
      

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	documentNoColumn = new TableColumn(table, SWT.NONE);
    	documentNoColumn.setMoveable(true);
    	documentNoColumn.setWidth(100);
    	documentNoColumn.setText(Messages.getString("EmployeeDischargeListForm.documentNoColumn.text")); //$NON-NLS-1$

    	documentDateColumn = new TableColumn(table, SWT.NONE);
    	documentDateColumn.setMoveable(true);
    	documentDateColumn.setWidth(100);
    	documentDateColumn.setText(Messages.getString("EmployeeDischargeListForm.documentDateColumn.text")); //$NON-NLS-1$
    	
    	employeeColumn = new TableColumn(table, SWT.NONE);
    	employeeColumn.setMoveable(true);
    	employeeColumn.setWidth(300);
    	employeeColumn.setText(Messages.getString("EmployeeDischargeListForm.employeeColumn.text")); //$NON-NLS-1$
    	
        responsibleColumn = new TableColumn(table, SWT.NONE);
        responsibleColumn.setMoveable(true);
        responsibleColumn.setWidth(200);
        responsibleColumn.setText(Messages.getString("EmployeeDischargeListForm.responsibleColumn.text")); //$NON-NLS-1$


       	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("employeeName");
	bindColumn("responsibleName");
	
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
