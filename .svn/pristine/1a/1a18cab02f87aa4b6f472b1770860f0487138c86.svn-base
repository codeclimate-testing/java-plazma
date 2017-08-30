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
 * Created on 06.06.2007
 *
 */

package org.plazmaforge.bsolution.inventory.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;

/** 
 * @author Oleh Hapon
 * $Id: InventoryMoveListForm.java,v 1.4 2010/04/28 06:31:08 ohapon Exp $
 */

public class InventoryMoveListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public InventoryMoveListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("InventoryMoveListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn outcomeWarehouseColumn;
        TableColumn incomeWarehouseColumn;
        TableColumn currencyTotalColumn;
 
        setLayout(new FillLayout(SWT.VERTICAL));
    	
        this.setSize(new Point(600, 300));
 

        table = new Table(this, SWTToolkit.TABLE_STYLE);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        documentNoColumn = new TableColumn(table, SWT.NONE);
        documentNoColumn.setMoveable(true);
        documentNoColumn.setWidth(100);
        documentNoColumn.setText(Messages.getString("InventoryMoveListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("InventoryMoveListForm.documentDateColumn.text")); //$NON-NLS-1$

        outcomeWarehouseColumn = new TableColumn(table, SWT.NONE);
        outcomeWarehouseColumn.setMoveable(true);
        outcomeWarehouseColumn.setWidth(200);
        outcomeWarehouseColumn.setText(Messages.getString("InventoryMoveListForm.outcomeWarehouseColumn.text")); //$NON-NLS-1$
    	
        incomeWarehouseColumn = new TableColumn(table, SWT.NONE);
        incomeWarehouseColumn.setMoveable(true);
        incomeWarehouseColumn.setWidth(200);
        incomeWarehouseColumn.setText(Messages.getString("InventoryMoveListForm.incomeWarehouseColumn.text")); //$NON-NLS-1$
    	
              
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(120);
        currencyTotalColumn.setText(Messages.getString("InventoryMoveListForm.totalColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("outcomeWarehouseName");
	bindColumn("incomeWarehouseName");
	bindColumn("currencyTotalWithTax" /*"currencyDocumentTotal"*/, getCurrencyFormat());

    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"


