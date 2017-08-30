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

package org.plazmaforge.bsolution.goods.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: GoodsIncomeListForm.java,v 1.6 2010/12/05 07:57:19 ohapon Exp $
 */

public class GoodsIncomeListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public GoodsIncomeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("GoodsIncomeListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn partnerColumn;
        TableColumn warehouseColumn;
        TableColumn mtrlResponsibleColumn;
        TableColumn currencyTotalColumn;
        TableColumn currencyColumn; 
        TableColumn totalColumn;

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
        documentNoColumn.setText(Messages.getString("GoodsIncomeListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("GoodsIncomeListForm.documentDateColumn.text")); //$NON-NLS-1$

        partnerColumn = new TableColumn(table, SWT.NONE);
        partnerColumn.setMoveable(true);
        partnerColumn.setWidth(200);
        partnerColumn.setText(Messages.getString("GoodsIncomeListForm.partnerColumn.text")); //$NON-NLS-1$
    	
        warehouseColumn = new TableColumn(table, SWT.NONE);
        warehouseColumn.setMoveable(true);
        warehouseColumn.setWidth(100);
        warehouseColumn.setText(Messages.getString("GoodsIncomeListForm.warehouseColumn.text")); //$NON-NLS-1$
    	
        mtrlResponsibleColumn = new TableColumn(table, SWT.NONE);
        mtrlResponsibleColumn.setMoveable(true);
        mtrlResponsibleColumn.setWidth(200);
        mtrlResponsibleColumn.setText(Messages.getString("GoodsIncomeListForm.mtrlResponsibleColumn.text")); //$NON-NLS-1$
    	
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(120);
        currencyTotalColumn.setText(Messages.getString("GoodsIncomeListForm.currencyTotalColumn.text"));    	 //$NON-NLS-1$
    	
        currencyColumn = new TableColumn(table, SWT.CENTER);
        currencyColumn.setMoveable(true);
        currencyColumn.setWidth(70);
        currencyColumn.setText(Messages.getString("GoodsIncomeListForm.currencyColumn.text")); //$NON-NLS-1$
        
        totalColumn = new TableColumn(table, SWT.RIGHT);
        totalColumn.setMoveable(true);
        totalColumn.setWidth(120);
        totalColumn.setText(Messages.getString("GoodsIncomeListForm.totalColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("partnerName");
	bindColumn("warehouseName");
	bindColumn("mtrlResponsibleName");
	
	bindColumn(getCurrencyEnterTotalProperty(), getCurrencyFormat());
	bindColumn("currencyName");
	bindColumn(getEnterTotalProperty(), getCurrencyFormat());

    }
 
    ////
    
    private String amountVar = getEnterTotalProperty();

    
    protected void initAggregateVariables() {
	setAggregateVariable(amountVar, 0d);
    }
    
    protected void calculateAggregateVariablesByEntity(Object entity) throws ApplicationException {
	calculateVariableSum(amountVar, entity);
    }

    protected String getAggregateVariablesText() {
	double amount = (Double) getAggregateVariable(amountVar);
	return  getAggregateVariablesLabel() + formatCurrency(amount);
    }

 
}  //  @jve:decl-index=0:visual-constraint="10,10"



