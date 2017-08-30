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
package org.plazmaforge.bsolution.bank.client.swing.forms;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.client.swing.GUIBankEnvironment;
import org.plazmaforge.bsolution.bank.client.swing.forms.common.XPaymentTypeComboBox;
import org.plazmaforge.bsolution.bank.client.swing.forms.common.XTaxPrintTypeComboBox;
import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.bank.common.beans.PaymentType;
import org.plazmaforge.bsolution.bank.common.beans.TaxPrintType;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.bank.common.services.PaymentOutcomeService;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentEdit;
import org.plazmaforge.bsolution.finance.common.beans.IEnterValueHolder;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerBankAccountList;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerHeader;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;


/**
 * @author Oleh Hapon Date: 21.07.2004 Time: 9:20:35 $Id:
 * PaymentOutcomeEdit.java,v 1.5 2007/03/23 07:06:15 ohapon Exp $
 */
public class PaymentOutcomeEdit extends AbstractFinanceDocumentEdit implements
	IEnterValueHolder {

    private JLabel codeLabel;

    private JLabel dateLabel;

    private JLabel organizationBankAccountLabel;

    private JLabel partnerLabel;

    private JLabel partnerBankAccountLabel;

    private JLabel currencyAmountLabel;

    private JLabel taxPercentLabel;

    private JLabel currencyTaxAmountLabel;

    private JLabel paymentMissingLabel;

    private JLabel paymentTypeLabel;

    private JLabel paymentDateLabel;

    private JLabel taxPrintTypeLabel;

    private XTextField codeField;

    private XDateField dateField;

    private XComboEdit organizationBankAccountComboEdit;

    private XComboEdit partnerComboEdit;

    private XComboEdit partnerBankAccountComboEdit;

    private XNumberField currencyAmountField;

    private XTaxComboBox taxPercentField;

    private XNumberField currencyTaxAmountField;

    private XTextEdit paymentMissingField;

    private XPaymentTypeComboBox paymentTypeField;

    private XDateField paymentDateField;

    private XTaxPrintTypeComboBox taxPrintTypeField;

    public PaymentOutcomeEdit() throws ApplicationException {
	super(GUIBankEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(PaymentOutcome.class);
	this.setEntityServiceClass(PaymentOutcomeService.class);
	this.setEntityCode(PaymentOutcome.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	organizationBankAccountLabel = new JLabel(getString("panel.label-organization-bank-account.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	partnerBankAccountLabel = new JLabel(getString("panel.label-partner-bank-account.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-amount.text"));
	taxPercentLabel = new JLabel(getString("panel.label-tax-percent.text"));
	currencyTaxAmountLabel = new JLabel(getString("panel.label-tax.text"));
	paymentMissingLabel = new JLabel(getString("panel.label-payment-missing.text"));
	paymentTypeLabel = new JLabel(getString("panel.label-payment-type.text"));
	paymentDateLabel = new JLabel(getString("panel.label-payment-date.text"));
	taxPrintTypeLabel = new JLabel(getString("panel.label-tax-print-type.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	organizationBankAccountComboEdit = new XComboEdit();
	organizationBankAccountComboEdit.setColumns(40);

	partnerComboEdit = new XComboEdit();
	partnerComboEdit.setColumns(40);
	partnerBankAccountComboEdit = new XComboEdit();
	partnerBankAccountComboEdit.setColumns(40);
	currencyAmountField = new XNumberField(12);
	taxPercentField = new XTaxComboBox();
	currencyTaxAmountField = new XNumberField(12);
	paymentMissingField = new XTextEdit(3, 20);

	paymentTypeField = new XPaymentTypeComboBox();
	paymentDateField = new XDateField();
	taxPrintTypeField = new XTaxPrintTypeComboBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;

	editPanel.add(codeLabel);
	editPanel.addByX(codeField);

	editPanel.addByX(Box.createHorizontalStrut(3));
	editPanel.addByX(dateLabel);
	editPanel.addByX(dateField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(organizationBankAccountLabel);
	gbc.gridwidth = 4;
	editPanel.addByX(organizationBankAccountComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(partnerLabel);
	gbc.gridwidth = 4;
	editPanel.addByX(partnerComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(partnerBankAccountLabel);
	gbc.gridwidth = 4;
	editPanel.addByX(partnerBankAccountComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);

	gbc.gridx++;
	editPanel.addByX(taxPercentLabel);
	editPanel.addByX(taxPercentField);

	gbc.gridx = 3;
	editPanel.addByY(currencyTaxAmountLabel);
	editPanel.addByX(currencyTaxAmountField);

	gbc.gridx = 0;
	editPanel.addByY(paymentMissingLabel);
	gbc.gridwidth = 4;
	gbc.gridheight = 3;
	gbc.fill = GridBagConstraints.BOTH;
	editPanel.addByX(paymentMissingField);

	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridy += 2;
	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.gridheight = 1;
	editPanel.addByY(paymentTypeLabel);
	editPanel.addByX(paymentTypeField);

	gbc.gridx++;
	editPanel.addByX(paymentDateLabel);
	editPanel.addByX(paymentDateField);

	gbc.gridx = 0;
	editPanel.addByY(taxPrintTypeLabel);
	gbc.gridwidth = 4;
	editPanel.addByX(taxPrintTypeField);

	organizationBankAccountComboEdit.initListFormAction(this,
		PartnerBankAccountList.class, "accountNo");
	organizationBankAccountComboEdit
		.addInitListActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			initPartnerableForm(organizationBankAccountComboEdit
				.getListForm(), EnterpriseEnvironment
				.getOrganization(getEnterpriseContext()));
		    }
		});

	partnerComboEdit.initListFormAction(this, PartnerList.class);
	partnerComboEdit.addAfterListActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (!partnerComboEdit.isChange())
		    return;
		partnerBankAccountComboEdit.clear();
		PartnerHeader partner = (PartnerHeader) partnerComboEdit
			.getValue();
		partnerBankAccountComboEdit.setValue(getBankAccount(partner));
	    }
	});

	partnerBankAccountComboEdit.initListFormAction(this,
		PartnerBankAccountList.class, "accountNo");
	partnerBankAccountComboEdit
		.addInitListActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			initPartnerableForm(partnerBankAccountComboEdit
				.getListForm(),
				(IPartnerHeader) partnerComboEdit.getValue());
		    }
		});

	initControl();

	add(editPanel);
    }

    private PaymentOutcome getPaymentOutcome() {
	return (PaymentOutcome) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPaymentOutcome().getPartnerName());
	codeField.setText(getPaymentOutcome().getDocumentNo());
	dateField.setDate(getPaymentOutcome().getDocumentDate());
	organizationBankAccountComboEdit.setValue(getPaymentOutcome().getOrganizationBankAccount());
	partnerComboEdit.setValue(getPaymentOutcome().getPartner());
	partnerBankAccountComboEdit.setValue(getPaymentOutcome().getPartnerBankAccount());
	currencyAmountField.setValue(getPaymentOutcome().getCurrencyEnterAmount());
	taxPercentField.setTaxId(getPaymentOutcome().getTaxId());
	currencyTaxAmountField.setValue(getPaymentOutcome().getCurrencyTaxAmount());
	paymentMissingField.setText(getPaymentOutcome().getPaymentMissing());
	paymentTypeField.setValue(getPaymentOutcome().getPaymentType());
	paymentDateField.setDate(getPaymentOutcome().getPaymentDate());
	taxPrintTypeField.setValue(getPaymentOutcome().getTaxPrintType());
    }

    protected void populateData() throws ApplicationException {
	getPaymentOutcome().setDocumentNo(codeField.getText());
	getPaymentOutcome().setDocumentDate(dateField.getDate());
	getPaymentOutcome().setOrganizationBankAccount((BankAccount) organizationBankAccountComboEdit.getValue());
	getPaymentOutcome().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getPaymentOutcome().setPartnerBankAccount((BankAccount) partnerBankAccountComboEdit.getValue());
	getPaymentOutcome().setCurrencyEnterAmount(currencyAmountField.floatValue());
	getPaymentOutcome().setTaxId(taxPercentField.getTaxId());
	getPaymentOutcome().setCurrencyTaxAmount(currencyTaxAmountField.floatValue());
	getPaymentOutcome().setPaymentMissing(paymentMissingField.getText());
	getPaymentOutcome().setPaymentType((PaymentType) paymentTypeField.getValue());
	getPaymentOutcome().setPaymentDate(paymentDateField.getDate());
	getPaymentOutcome().setTaxPrintType((TaxPrintType) taxPrintTypeField.getValue());
    }

    protected Object createData() throws ApplicationException {
	getPaymentOutcome().calculate();
	return super.createData();
    }

    protected void storeData() throws ApplicationException {
	getPaymentOutcome().calculate();
	super.storeData();
    }

    /**
     * Initialize Document
     */
    protected void initDocument() {
	BankEnvironment.initPaymentDocument(getPaymentOutcome(), getEntityCode(), getEnterpriseContext());
	OrganizationHeader organization = EnterpriseEnvironment.getOrganization(getEnterpriseContext());
	PartnerTitle partner = BankEnvironment.getIncomePartner();

	getPaymentOutcome().setPartner(partner);

	getPaymentOutcome().setOrganizationBankAccount(getBankAccount(organization));
	getPaymentOutcome().setPartnerBankAccount(getBankAccount(partner));

    }

    private BankAccount getBankAccount(PartnerTitle partner) {
	if (partner == null) {
	    return null;
	}
	// TODO: Not implemented !!!
	return null;

//	Integer bankAccountId = partner.getBankAccountId();
//	if (bankAccountId == null) {
//	    return null;
//	}
//
//	try {
//	    return getBankAccountService().findById(bankAccountId);
//	} catch (ApplicationException ex) {
//	    ex.printStackTrace();
//	}
//	return null;
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getPaymentOutcome().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getPaymentDate(),paymentDateLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getPartner(),partnerLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getPartnerBankAccount(),	partnerBankAccountLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getOrganizationBankAccount(), organizationBankAccountLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getPaymentType(),paymentTypeLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getTaxPrintType(),taxPrintTypeLabel.getText());
	validateRequiredField(buf, getPaymentOutcome().getPaymentMissing(),paymentMissingLabel.getText());
	checkError(buf);
    }

    protected void initControl() throws ApplicationException {

	taxPercentField.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		calculateTaxAmount();
	    }
	});

	currencyAmountField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		calculateTaxAmount();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

    }

    /**
         * Calculate tax amount by tax percent and amount
         * 
         */
    protected void calculateTaxAmount() {
	currencyTaxAmountField.setValue(MoneyCalculator.calculateTaxAmount(
		taxPercentField.getSelectedPercent(), currencyAmountField
			.floatValue(), isIncludeTaxInAmount()));
    }

    protected boolean isIncludeTaxInAmount() {
	return getPaymentOutcome() == null ? false : getPaymentOutcome()
		.isIncludeTaxInAmount();
    }

    private BankAccountService getBankAccountService() {
	return (BankAccountService) getSERVICE(BankAccountService.class);
    }

}
