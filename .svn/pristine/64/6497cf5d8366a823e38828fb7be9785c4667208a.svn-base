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
 * $Id: CarAssurerPriceListForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarAssurerPriceListForm extends AbstractListForm {

    private Table table;
    

    
    public CarAssurerPriceListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarAssurerPriceListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn assurerColumn;
        TableColumn carAgeColumn;        
        TableColumn priceColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	assurerColumn = new TableColumn(table, SWT.NONE);
    	assurerColumn.setWidth(230);
    	assurerColumn.setText(Messages.getString("CarAssurerPriceListForm.assurerColumn.text")); //$NON-NLS-1$


    	carAgeColumn = new TableColumn(table, SWT.RIGHT);
    	carAgeColumn.setWidth(230);
    	carAgeColumn.setText(Messages.getString("CarAssurerPriceListForm.carAgeColumn.text")); //$NON-NLS-1$
    	

    	priceColumn = new TableColumn(table, SWT.RIGHT);
    	priceColumn.setWidth(230);
    	priceColumn.setText(Messages.getString("CarAssurerPriceListForm.priceColumn.text")); //$NON-NLS-1$

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "assurerName");
	bindColumn(2, "carAgeName");
	bindColumn(3, "price", getCurrencyFormat());
    }
}
