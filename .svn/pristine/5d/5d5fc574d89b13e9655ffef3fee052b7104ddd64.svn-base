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

package org.plazmaforge.bsolution.cash.client.swing.forms;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.cash.CashEnvironment;
import org.plazmaforge.bsolution.cash.client.swing.GUICashEnvironment;
import org.plazmaforge.bsolution.cash.common.beans.CashIncome;
import org.plazmaforge.bsolution.cash.common.services.CashIncomeService;
import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentEdit;
import org.plazmaforge.bsolution.finance.client.swing.forms.ContractorList;
import org.plazmaforge.bsolution.finance.common.beans.IContractorHeader;
import org.plazmaforge.bsolution.finance.common.beans.IEnterValueHolder;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;


/**
 * @author Oleh Hapon
 *
 * $Id: CashIncomeEdit.java,v 1.4 2010/12/05 07:56:48 ohapon Exp $
 * 
 */

public class CashIncomeEdit extends AbstractFinanceDocumentEdit implements
	IEnterValueHolder {

    private JLabel codeLabel;

    private JLabel dateLabel;

    private JLabel contractorLabel;

    private JLabel currencyAmountLabel;

    private JLabel taxPercentLabel;

    private JLabel currencyTaxAmountLabel;

    private JLabel paymentMissingLabel;

    //private JLabel paymentDateLabel;

    private XTextField codeField;

    private XDateField dateField;

    private XComboEdit contractorComboEdit;

    private XNumberField currencyAmountField;

    private XTaxComboBox taxPercentField;

    private XNumberField currencyTaxAmountField;

    private XTextField paymentMissingField;

    //private XDateField paymentDateField;

    public CashIncomeEdit() throws ApplicationException {
	super(GUICashEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(CashIncome.class);
	this.setEntityServiceClass(CashIncomeService.class);
	this.setEntityCode(CashIncome.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));

	contractorLabel = new JLabel(getString("panel.label-contractor.text"));

	currencyAmountLabel = new JLabel(getString("panel.label-amount.text"));
	taxPercentLabel = new JLabel(getString("panel.label-tax-percent.text"));
	currencyTaxAmountLabel = new JLabel(getString("panel.label-tax.text"));
	paymentMissingLabel = new JLabel(
		getString("panel.label-payment-missing.text"));

	//paymentDateLabel = new JLabel(getString("panel.label-payment-date.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();

	contractorComboEdit = new XComboEdit();
	contractorComboEdit.setColumns(40);

	currencyAmountField = new XNumberField(12);
	taxPercentField = new XTaxComboBox();
	currencyTaxAmountField = new XNumberField(12);
	paymentMissingField = new XTextField(40);
	paymentMissingField.setMaxChar(60);

	//paymentDateField = new XDateField();

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
	editPanel.addByY(contractorLabel);
	gbc.gridwidth = 4;
	editPanel.addByX(contractorComboEdit);

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
	editPanel.addByX(paymentMissingField);

	//gbc.gridx++;		
	//editPanel.addByX(paymentDateLabel);
	//editPanel.addByX(paymentDateField);

	initControl();

	contractorComboEdit.initListFormAction(this, ContractorList.class);

	add(editPanel);
    }

    private CashIncome getCashIncome() {
	return (CashIncome) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getCashIncome().getContractorName());
	codeField.setText(getCashIncome().getDocumentNo());
	dateField.setDate(getCashIncome().getDocumentDate());
	contractorComboEdit.setValue(getCashIncome().getContractor());
	currencyAmountField.setValue(getCashIncome().getCurrencyEnterAmount());
	taxPercentField.setTaxId(getCashIncome().getTaxId());
	currencyTaxAmountField.setValue(getCashIncome().getCurrencyTaxAmount());
	paymentMissingField.setText(getCashIncome().getPaymentMissing());
	//paymentDateField.setDate(getCashIncome().getPaymentDate());
    }

    protected void populateData() throws ApplicationException {
	getCashIncome().setDocumentNo(codeField.getText());
	getCashIncome().setDocumentDate(dateField.getDate());
	getCashIncome().setContractor((IContractorHeader) contractorComboEdit.getValue());
	getCashIncome().setCurrencyEnterAmount(currencyAmountField.floatValue());
	getCashIncome().setTaxId(taxPercentField.getTaxId());
	getCashIncome().setCurrencyTaxAmount(currencyTaxAmountField.floatValue());
	getCashIncome().setPaymentMissing(paymentMissingField.getText());
	//getCashIncome().setPaymentDate(paymentDateField.getDate());	
    }

    protected Object createData() throws ApplicationException {
	getCashIncome().calculate();
	return super.createData();
    }

    protected void storeData() throws ApplicationException {
	getCashIncome().calculate();
	super.storeData();
    }

    /**
     * Initialize Document
     */
    protected void initDocument() {
	CashEnvironment.initCashDocument(getCashIncome(), getEntityCode(), getEnterpriseContext());
	getCashIncome().setPaymentDate(EnterpriseEnvironment.getDate());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getCashIncome().getDocumentDate(), dateLabel.getText());
	//validateRequiredField(buf, getCashIncome().getPaymentDate(), paymentDateLabel.getText());		
	validateRequiredField(buf, getCashIncome().getContractor(), contractorLabel.getText());
	validateRequiredField(buf, getCashIncome().getPaymentMissing(),	paymentMissingLabel.getText());
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
	return getCashIncome() == null ? false : getCashIncome()
		.isIncludeTaxInAmount();
    }

}
