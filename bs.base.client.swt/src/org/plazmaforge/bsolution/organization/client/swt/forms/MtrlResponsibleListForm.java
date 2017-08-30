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
 * Created on 17 Тра 2007
 *
 */

package org.plazmaforge.bsolution.organization.client.swt.forms;


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
 */

public class MtrlResponsibleListForm extends AbstractListForm {

    private Table table;
    

    
    public MtrlResponsibleListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("MtrlResponsibleListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn employeeColumn;
        TableColumn warehouseColumn;        

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	employeeColumn = new TableColumn(table, SWT.NONE);
    	employeeColumn.setWidth(300);
    	employeeColumn.setText(Messages.getString("MtrlResponsibleListForm.employeeColumn.text")); //$NON-NLS-1$
    	
    	warehouseColumn = new TableColumn(table, SWT.NONE);
    	warehouseColumn.setWidth(300);
    	warehouseColumn.setText(Messages.getString("MtrlResponsibleListForm.warehouseColumn.text")); //$NON-NLS-1$
    	

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "contactName");
	bindColumn(2, "warehouseName");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
