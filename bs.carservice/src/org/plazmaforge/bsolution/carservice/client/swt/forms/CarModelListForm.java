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

package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarModelListForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarModelListForm extends AbstractListForm {

    private Table table;
    

    
    public CarModelListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarModelListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn markColumn;
        //TableColumn manufacturerColumn;        

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(230);
    	nameColumn.setText(Messages.getString("CarModelListForm.nameColumn.text")); //$NON-NLS-1$

    	markColumn = new TableColumn(table, SWT.NONE);
    	markColumn.setWidth(230);
    	markColumn.setText(Messages.getString("CarModelListForm.markColumn.text")); //$NON-NLS-1$

    	/*
    	manufacturerColumn = new TableColumn(table, SWT.NONE);
    	manufacturerColumn.setWidth(230);
    	manufacturerColumn.setText(Messages.getString("CarModelListForm.manufacturerColumn.text")); //$NON-NLS-1$
    	*/
    	

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");
	bindColumn("carMarkName");
	//bindColumn("carManufacturerName");
    }
}