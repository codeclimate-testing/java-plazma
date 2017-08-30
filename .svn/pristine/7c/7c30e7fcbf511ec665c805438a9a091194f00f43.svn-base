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
 * Created on 12.07.2007
 *
 */

package org.plazmaforge.bsolution.payroll.client.swt.forms;


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
 * $Id: EmployeeSicklistListForm.java,v 1.3 2010/04/28 06:31:06 ohapon Exp $
 */

public class EmployeeSicklistListForm extends AbstractDocumentListForm {

    private Table table;
    

    
    public  EmployeeSicklistListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("EmployeeSicklistListForm.title"));  //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn seriesColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn employeeColumn;
        TableColumn startDateColumn;
        TableColumn endDateColumn;
        TableColumn responsibleColumn;
  

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setSortDirection(SWT.DOWN);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(10);

    	seriesColumn = new TableColumn(table, SWT.NONE);
    	seriesColumn.setWidth(50);
    	seriesColumn.setText(Messages.getString("EmployeeSicklistListForm.seriesColumn.text")); //$NON-NLS-1$
    	
    	documentNoColumn = new TableColumn(table, SWT.NONE);
    	documentNoColumn.setWidth(50);
    	documentNoColumn.setText(Messages.getString("EmployeeSicklistListForm.documentNoColumn.text")); //$NON-NLS-1$
    	
 	documentDateColumn = new TableColumn(table, SWT.NONE);
    	documentDateColumn.setWidth(100);
    	documentDateColumn.setText(Messages.getString("EmployeeSicklistListForm.documentDateColumn.text")); //$NON-NLS-1$
    	
 	employeeColumn = new TableColumn(table, SWT.NONE);
    	employeeColumn.setWidth(300);
    	employeeColumn.setText(Messages.getString("EmployeeSicklistListForm.employeeColumn.text")); //$NON-NLS-1$
    	

 	startDateColumn = new TableColumn(table, SWT.RIGHT);
    	startDateColumn.setWidth(100);
    	startDateColumn.setText(Messages.getString("EmployeeSicklistListForm.startDateColumn.text")); //$NON-NLS-1$
    	
 	endDateColumn = new TableColumn(table, SWT.RIGHT);
    	endDateColumn.setWidth(100);
    	endDateColumn.setText(Messages.getString("EmployeeSicklistListForm.endDateColumn.text")); //$NON-NLS-1$

        responsibleColumn = new TableColumn(table, SWT.NONE);
        responsibleColumn.setMoveable(true);
        responsibleColumn.setWidth(200);
        responsibleColumn.setText(Messages.getString("EmployeeSicklistListForm.responsibleColumn.text")); //$NON-NLS-1$

    
        this.setSize(new Point(700, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "series");
	bindColumn("documentNo");
	bindColumn("documentDate", getDateFormat());
	bindColumn("employeeName");

	bindColumn("startDate", getDateFormat());
	bindColumn("endDate", getDateFormat());
	bindColumn("responsibleName");
    }
 
  
 
}  //  @jve:decl-index=0:visual-constraint="10,10"



