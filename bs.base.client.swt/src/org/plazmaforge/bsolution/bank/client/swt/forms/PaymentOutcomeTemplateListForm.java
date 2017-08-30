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
 * Created on 19.12.2007
 *
 */

package org.plazmaforge.bsolution.bank.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.bank.common.TemplatePaymentDocumentCreator;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcomeTemplate;
import org.plazmaforge.bsolution.bank.common.services.PaymentOutcomeService;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: PaymentOutcomeTemplateListForm.java,v 1.7 2010/12/05 07:57:18 ohapon Exp $
 */

public class PaymentOutcomeTemplateListForm extends AbstractListForm {

    
    private Table table;
    

    
    
    public PaymentOutcomeTemplateListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PaymentOutcomeTemplateListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn partnerColumn;
        TableColumn paymentMissingColumn;
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
        documentNoColumn.setText(Messages.getString("PaymentOutcomeTemplateListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("PaymentOutcomeTemplateListForm.documentDateColumn.text")); //$NON-NLS-1$

        partnerColumn = new TableColumn(table, SWT.NONE);
        partnerColumn.setMoveable(true);
        partnerColumn.setWidth(250);
        partnerColumn.setText(Messages.getString("PaymentOutcomeTemplateListForm.partnerColumn.text")); //$NON-NLS-1$
        
        paymentMissingColumn = new TableColumn(table, SWT.NONE);
        paymentMissingColumn.setMoveable(true);
        paymentMissingColumn.setWidth(250);
        paymentMissingColumn.setText(Messages.getString("PaymentOutcomeTemplateListForm.paymentMissingColumn.text"));         //$NON-NLS-1$
    	
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(100);
        currencyTotalColumn.setText(Messages.getString("PaymentOutcomeTemplateListForm.currencyTotalColumn.text"));    	 //$NON-NLS-1$
    	
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn(2, "documentDate", getDateFormat());
	bindColumn(3, "partnerName");
	bindColumn(4, "paymentMissing");
	bindColumn(5, getCurrencyEnterTotalProperty(), getCurrencyFormat());
    }
 

  
    private String amountVar = getCurrencyEnterTotalProperty();

    protected String getCurrencyEnterTotalProperty() {
	return FinanceDocument.getCurrencyEnterTotalProperty(PaymentOutcome.class);
    }

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

    
    public void doAddOtherObjectsAction() throws ApplicationException {
	Object entity = getSelectedEntity();
	
	if (entity == null) {
	    openNotSelecetdRowsDialog();
	    return;
	}
	
	if (!openConfirmYesNoDialog(Messages.getString("PaymentOutcomeTemplateListForm.action.confirmCreateDocument"))) {
	    return;
	}
	
	PaymentOutcomeTemplate template = (PaymentOutcomeTemplate) entity;
	TemplatePaymentDocumentCreator creator = new TemplatePaymentDocumentCreator();
	creator.setDocumentClass(PaymentOutcome.class);
	creator.setDocumentType(DocumentEnvironment.getDocumentType("PAYMENT_OUTCOME"));
	
	PaymentOutcome paymentDocument = (PaymentOutcome) creator.createDocument(template);
	
	PaymentOutcomeService service = (PaymentOutcomeService) getService(PaymentOutcomeService.class);
	service.create(paymentDocument);
	
	openMessageDialog(Messages.getString("PaymentOutcomeTemplateListForm.action.resultCreateDocument"));

    }
    
    public void init() throws ApplicationException {
	initDocumentActions();
	super.init();
    }
    
    protected void initDocumentActions() {
	Action1 action1 = new Action1();
	action1.setName(Messages.getString("PaymentOutcomeTemplateListForm.action.name"));
	addAction(action1);
    }
    
    private class Action1 extends DefaultAction {
	public void execute() throws ApplicationException {
	    doAddOtherObjectsAction();
	}
    }
    
    
}
