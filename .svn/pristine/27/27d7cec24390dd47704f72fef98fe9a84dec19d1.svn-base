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
 * Created on 11.06.2007
 *
 */

package org.plazmaforge.bsolution.bank.client.swt.forms;


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
 * $Id: PaymentIncomeListForm.java,v 1.6 2010/12/05 07:57:18 ohapon Exp $
 */

public class PaymentIncomeListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public PaymentIncomeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PaymentIncomeListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn partnerColumn;
        TableColumn paymentMissingColumn;
        TableColumn currencyTotalColumn;
        TableColumn responsibleColumn;
        TableColumn projectColumn;
            

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
        documentNoColumn.setText(Messages.getString("PaymentIncomeListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("PaymentIncomeListForm.documentDateColumn.text")); //$NON-NLS-1$

        partnerColumn = new TableColumn(table, SWT.NONE);
        partnerColumn.setMoveable(true);
        partnerColumn.setWidth(250);
        partnerColumn.setText(Messages.getString("PaymentIncomeListForm.partnerColumn.text")); //$NON-NLS-1$
        
        paymentMissingColumn = new TableColumn(table, SWT.NONE);
        paymentMissingColumn.setMoveable(true);
        paymentMissingColumn.setWidth(250);
        paymentMissingColumn.setText(Messages.getString("PaymentIncomeListForm.paymentMissingColumn.text"));         //$NON-NLS-1$
    	
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(100);
        currencyTotalColumn.setText(Messages.getString("PaymentIncomeListForm.currencyTotalColumn.text"));    	 //$NON-NLS-1$
    	
        responsibleColumn = new TableColumn(table, SWT.NONE);
        responsibleColumn.setMoveable(true);
        responsibleColumn.setWidth(200);
        responsibleColumn.setText(Messages.getString("PaymentOutcomeListForm.responsibleColumn.text")); //$NON-NLS-1$
        
        projectColumn = new TableColumn(table, SWT.NONE);
        projectColumn.setMoveable(true);
        projectColumn.setWidth(200);
        projectColumn.setText(Messages.getString("PaymentIncomeListForm.projectColumn.text")); //$NON-NLS-1$
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("partnerName");
	bindColumn("paymentMissing");
	bindColumn(getCurrencyEnterTotalProperty(), getCurrencyFormat());
	bindColumn("responsibleName");
	bindColumn("projectName");
    }
 
    
    ////
    
    private String amountVar = getCurrencyEnterTotalProperty();

    
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


