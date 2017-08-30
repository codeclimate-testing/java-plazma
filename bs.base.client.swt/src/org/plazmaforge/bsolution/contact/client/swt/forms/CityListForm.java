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

package org.plazmaforge.bsolution.contact.client.swt.forms;


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
 * $Id: CityListForm.java,v 1.2 2010/04/28 06:31:05 ohapon Exp $
 */
public class CityListForm extends AbstractListForm {

    private Table table;
    

    
    
    public CityListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CityListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn regionColumn;
        TableColumn countryColumn;

        setLayout(new FillLayout(SWT.VERTICAL));

      	
        this.setSize(new Point(600, 300));
 

        table = new Table(this, SWTToolkit.TABLE_STYLE);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        nameColumn = new TableColumn(table, SWT.NONE);
        nameColumn.setMoveable(true);
        nameColumn.setWidth(300);
        nameColumn.setText(Messages.getString("CityListForm.nameColumn.text")); //$NON-NLS-1$

        regionColumn = new TableColumn(table, SWT.NONE);
        regionColumn.setMoveable(true);
        regionColumn.setWidth(300);
        regionColumn.setText(Messages.getString("CityListForm.regionColumn.text")); //$NON-NLS-1$

        countryColumn = new TableColumn(table, SWT.NONE);
        countryColumn.setWidth(300);
        countryColumn.setText(Messages.getString("CityListForm.countryColumn.text")); //$NON-NLS-1$
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");	
	bindColumn(2, "regionName");
	bindColumn(3, "countryName");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"

