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

package org.plazmaforge.bsolution.purchase.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.views.ImageTableCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: PurchaseInvoiceListForm.java,v 1.7 2010/12/05 07:57:18 ohapon Exp $
 */

public class PurchaseInvoiceListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public PurchaseInvoiceListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PurchaseInvoiceListForm.title")); //$NON-NLS-1$
        TableColumn paidColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn partnerColumn;
        TableColumn documentStatusColumn;
        TableColumn responsibleColumn;
        //TableColumn warehouseColumn;
        //TableColumn mtrlResponsibleColumn;
        TableColumn currencyTotalColumn;
        TableColumn currencyColumn; 
        TableColumn totalColumn;
        TableColumn projectColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
    	
        this.setSize(new Point(600, 300));
 

        table = new Table(this, SWTToolkit.TABLE_STYLE);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        paidColumn = new TableColumn(table, SWT.NONE);
        paidColumn.setResizable(false);
        paidColumn.setWidth(20);

        documentNoColumn = new TableColumn(table, SWT.NONE);
        documentNoColumn.setMoveable(true);
        documentNoColumn.setWidth(100);
        documentNoColumn.setText(Messages.getString("PurchaseInvoiceListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("PurchaseInvoiceListForm.documentDateColumn.text")); //$NON-NLS-1$

        partnerColumn = new TableColumn(table, SWT.NONE);
        partnerColumn.setMoveable(true);
        partnerColumn.setWidth(200);
        partnerColumn.setText(Messages.getString("PurchaseInvoiceListForm.partnerColumn.text")); //$NON-NLS-1$
    	
	documentStatusColumn = new TableColumn(table, SWT.NONE);
    	documentStatusColumn.setMoveable(true);
    	documentStatusColumn.setWidth(100);
    	documentStatusColumn.setText(Messages.getString("PurchaseInvoiceListForm.documentStatusColumn.text")); //$NON-NLS-1$
    	
    	responsibleColumn = new TableColumn(table, SWT.NONE);
        responsibleColumn.setMoveable(true);
        responsibleColumn.setWidth(200);
        responsibleColumn.setText(Messages.getString("PurchaseInvoiceListForm.responsibleColumn.text")); //$NON-NLS-1$
         
        ////
        /*
        warehouseColumn = new TableColumn(table, SWT.NONE);
        warehouseColumn.setMoveable(true);
        warehouseColumn.setWidth(100);
        warehouseColumn.setText(Messages.getString("PurchaseInvoiceListForm.warehouseColumn.text")); //$NON-NLS-1$
    	
        mtrlResponsibleColumn = new TableColumn(table, SWT.NONE);
        mtrlResponsibleColumn.setMoveable(true);
        mtrlResponsibleColumn.setWidth(200);
        mtrlResponsibleColumn.setText(Messages.getString("PurchaseInvoiceListForm.mtrlResponsibleColumn.text")); //$NON-NLS-1$
        */
        ////
    	
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(120);
        currencyTotalColumn.setText(Messages.getString("PurchaseInvoiceListForm.currencyTotalColumn.text"));    	 //$NON-NLS-1$
    	
        currencyColumn = new TableColumn(table, SWT.CENTER);
        currencyColumn.setMoveable(true);
        currencyColumn.setWidth(70);
        currencyColumn.setText(Messages.getString("PurchaseInvoiceListForm.currencyColumn.text")); //$NON-NLS-1$
        
        totalColumn = new TableColumn(table, SWT.RIGHT);
        totalColumn.setMoveable(true);
        totalColumn.setWidth(120);
        totalColumn.setText(Messages.getString("PurchaseInvoiceListForm.totalColumn.text")); //$NON-NLS-1$
        
        projectColumn = new TableColumn(table, SWT.NONE);
        projectColumn.setMoveable(true);
        projectColumn.setWidth(200);
        projectColumn.setText(Messages.getString("PurchaseInvoiceListForm.projectColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn("paid");
	bindColumn("documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("partnerName");
	bindColumn("documentStatusName");
	
	bindColumn("responsibleName");
	//bindColumn("warehouseName");
	//bindColumn("mtrlResponsibleName");
	
	bindColumn(getCurrencyEnterTotalProperty(), getCurrencyFormat());
	bindColumn("currencyName");
	bindColumn(getEnterTotalProperty(), getCurrencyFormat());
	
	bindColumn("projectName");
	
        addCellRenderer(0, new ImageTableCellRenderer());
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

    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }
    
    protected boolean isEntryItemsAction() {
	return false;
    }
 
}  //  @jve:decl-index=0:visual-constraint="10,10"



