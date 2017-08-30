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
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;

/** 
 * @author Oleh Hapon
 * $Id: PaymentOutcomeTemplateEditForm.java,v 1.5 2010/12/05 07:57:18 ohapon Exp $
 */

public class PaymentOutcomeTemplateEditForm extends AbstractPaymentDocumentEditForm {

    private Label documentNoLabel;
    private Label documentDateLabel;
    private Label organizationBankAccountLabel;
    private Label partnerLabel;
    private Label partnerBankAccountLabel;
    private Label currencyAmountLabel;
    private Label taxLabel;
    private Label currencyTaxAmountLabel;
    private Label paymentMissingLabel; 
    private Label paymentTypeLabel;
    private Label paymentDateLabel;
    private Label taxPrintTypeLabel;
     
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit organizationBankAccountField;
    private XComboEdit partnerBankAccountField;
    private XComboEdit partnerField;
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    private XTextField paymentMissingField;
    private XComboEdit paymentTypeField;
    private XDateCombo paymentDateField;
    private XComboEdit taxPrintTypeField;
  
    private XTextArea noteField;

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PaymentOutcomeTemplateEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("PaymentOutcomeTemplateEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	TabItem noteTabItem;
	Composite composite;
	Label label;
	GridLayout gridLayout;


	
	GridData gridData;

	setLayout(new FillLayout());
	
    	tabFolder = new TabFolder(this, SWT.NONE);

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PaymentOutcomeTemplateEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	documentNoField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 60;
    	documentDateLabel.setLayoutData(gridData);
    	documentDateLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
    	documentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	//label = new Label(composite, SWT.NONE);
    	//label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

    	organizationBankAccountLabel = new Label(composite, SWT.NONE);
    	organizationBankAccountLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.organizationBankAccountLabel.text")); //$NON-NLS-1$

    	organizationBankAccountField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	organizationBankAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	partnerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
	partnerBankAccountLabel = new Label(composite, SWT.NONE);
	partnerBankAccountLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.partnerBankAccountLabel.text")); //$NON-NLS-1$

	partnerBankAccountField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	partnerBankAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
       	currencyAmountLabel = new Label(composite, SWT.NONE);
    	currencyAmountLabel.setLayoutData(new GridData());
    	currencyAmountLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);

    	
    	
    	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	taxLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XTaxCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxField.setLayoutData(gridData);    	

    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
    	
    	currencyTaxAmountLabel = new Label(composite, SWT.NONE);
    	currencyTaxAmountLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyTaxAmountLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

    	currencyTaxAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
   	
    	paymentMissingLabel = new Label(composite, SWT.NONE);
    	paymentMissingLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.paymentMissingLabel.text")); //$NON-NLS-1$

    	paymentMissingField = new XTextField(composite, SWT.BORDER);
    	paymentMissingField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	paymentMissingField.setTextLimit(128);
    	
    	//
    	paymentTypeLabel = new Label(composite, SWT.NONE);
    	paymentTypeLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.paymentTypeLabel.text")); //$NON-NLS-1$

    	paymentTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	paymentTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	paymentDateLabel = new Label(composite, SWT.NONE);
    	paymentDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	paymentDateLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.paymentDateLabel.text")); //$NON-NLS-1$

    	paymentDateField = new XDateCombo(composite, SWT.BORDER);
    	paymentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	taxPrintTypeLabel = new Label(composite, SWT.NONE);
    	taxPrintTypeLabel.setText(Messages.getString("PaymentOutcomeTemplateEditForm.taxPrintTypeLabel.text")); //$NON-NLS-1$

    	taxPrintTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	taxPrintTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

       	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PaymentOutcomeTemplateEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
	this.setSize(new Point(470, 108));

	

	currencyAmountField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
        	calculateTaxAmount();
            }
        });
	
	taxField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		calculateTaxAmount();
	    }
	});
	
	taxField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                calculateTaxAmount();
            }
        });


	initPartnerField(partnerField);
	initBankAccountField(organizationBankAccountField);
	initBankAccountField(partnerBankAccountField);
	
	initOrganizationBankAccountField(organizationBankAccountField);
	initPartnerBankAccountField(partnerBankAccountField);
    }
    
 
    protected void beforeUpdateData() throws ApplicationException {
	calculateTaxAmount();
    }
    
    protected void afterUpdateData() throws ApplicationException {
	getFinanceDocument().calculate();
    }
    
    protected void bindControls() {
	bindControl(documentNoField, "documentNo");
	bindControl(documentDateField, "documentDate");
	bindControl(organizationBankAccountField, "organizationBankAccount", organizationBankAccountLabel, REQUIRED);
	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(partnerBankAccountField, "partnerBankAccount", partnerBankAccountLabel, REQUIRED);
	bindControl(currencyAmountField, "currencyEnterAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	bindControl(paymentMissingField, "paymentMissing", paymentMissingLabel, REQUIRED);
	bindControl(paymentTypeField, "paymentType", paymentTypeLabel, REQUIRED);
	bindControl(paymentDateField, "paymentDate", paymentDateLabel, REQUIRED);
	bindControl(taxPrintTypeField, "taxPrintType", taxPrintTypeLabel, REQUIRED);
	
	bindControl(noteField, "note");
    }
    
    /**
     * Calculate tax amount by tax percent and amount
     * 
     */
    protected void calculateTaxAmount() {
	float taxPercent = taxField.getTaxPercent();
	float amount = currencyAmountField.floatValue();
	float tax = (float) MoneyCalculator.calculateTaxAmount(taxPercent, amount, isIncludeTaxInAmount());
	currencyTaxAmountField.setValue(tax);
    }
    
    

    protected void initDocument() {
	super.initDocument();

	getPaymentDocument().setOrganizationBankAccount(getBankAccount(getOrganization()));
	
	PartnerTitle partner = BankEnvironment.getIncomePartner();
	getPaymentDocument().setPartner(partner);
	getPaymentDocument().setPartnerBankAccount(getBankAccount(partner));
    } 
     
 

}  //  @jve:decl-index=0:visual-constraint="10,10"

