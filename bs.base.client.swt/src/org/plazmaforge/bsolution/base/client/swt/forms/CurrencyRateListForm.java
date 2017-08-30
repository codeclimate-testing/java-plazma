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
 * $Id: CurrencyRateListForm.java,v 1.7 2010/05/17 11:26:16 ohapon Exp $
 */
public class CurrencyRateListForm extends AbstractListForm { 

    private Table table;
    

    
    public CurrencyRateListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CurrencyRateListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        TableColumn baseCurrencyCodeColumn;
        TableColumn currencyCodeColumn;
        TableColumn dateColumn;
        TableColumn rateColumn;
        
        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	baseCurrencyCodeColumn = new TableColumn(table, SWT.CENTER);
    	baseCurrencyCodeColumn.setWidth(100);
    	baseCurrencyCodeColumn.setText(Messages.getString("CurrencyRateListForm.baseCurrencyCodeColumn.text")); //$NON-NLS-1$

 	currencyCodeColumn = new TableColumn(table, SWT.CENTER);
    	currencyCodeColumn.setWidth(100);
    	currencyCodeColumn.setText(Messages.getString("CurrencyRateListForm.currencyCodeColumn.text")); //$NON-NLS-1$
    	
    	dateColumn = new TableColumn(table, SWT.NONE);
    	dateColumn.setWidth(100);
    	dateColumn.setText(Messages.getString("CurrencyRateListForm.dateColumn.text")); //$NON-NLS-1$
      	
  	rateColumn = new TableColumn(table, SWT.RIGHT);
    	rateColumn.setWidth(100);
    	rateColumn.setText(Messages.getString("CurrencyRateListForm.rateColumn.text")); //$NON-NLS-1$

        	
    	    	
        this.setSize(new Point(700, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "baseCurrencyCode");
	bindColumn("currencyCode");	
	bindColumn("date", getDateFormat());
	bindColumn("rate");	
    }

}
