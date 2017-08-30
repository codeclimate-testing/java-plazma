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

package org.plazmaforge.bsolution.base.client.swt.forms;


import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;


/** 
 * @author Oleh Hapon
 * $Id: CountryListForm.java,v 1.6 2010/05/17 11:17:43 ohapon Exp $
 */

public class CountryListForm extends AbstractListForm {

    private Table table;
    

    
    
    public CountryListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CountryListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn code3Column;
        TableColumn nameColumn;
        TableColumn numericCodeColumn;        

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("CountryListForm.codeColumn.text")); //$NON-NLS-1$

    	code3Column = new TableColumn(table, SWT.NONE);
    	code3Column.setMoveable(true);
    	code3Column.setWidth(100);
    	code3Column.setText(Messages.getString("CountryListForm.code3Column.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("CountryListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	numericCodeColumn = new TableColumn(table, SWT.NONE);
    	numericCodeColumn.setMoveable(true);
    	numericCodeColumn.setWidth(100);
    	numericCodeColumn.setText(Messages.getString("CountryListForm.numericColumn.text")); //$NON-NLS-1$
    	

      	
        this.setSize(new Point(600, 300));
        
        setFlexiblePagingMode();
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn("code3");
	bindColumn("name");
	bindColumn("numericCode");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
