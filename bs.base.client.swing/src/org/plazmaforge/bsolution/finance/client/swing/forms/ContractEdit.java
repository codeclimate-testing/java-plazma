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
package org.plazmaforge.bsolution.finance.client.swing.forms;

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.services.CurrencyService;
import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentEdit;
import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.bsolution.finance.common.services.ContractService;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author Oleh Hapon Date: 26.12.2004 Time: 12:06:09 
 * $Id: ContractEdit.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class ContractEdit extends AbstractDocumentEdit {

    private JLabel codeLabel;

    private JLabel dateLabel;

    private JLabel partnerLabel;

    private JLabel currencyLabel;

    private JLabel currencyRateLabel;

    private JLabel currencyRateDateLabel;

    private JLabel currencyAmountLabel;

    private JLabel taxPercentLabel;

    private JLabel currencyTaxAmountLabel;

    private XTextField codeField;

    private XDateField dateField;

    private XComboEdit partnerComboEdit; // Partner

    private XComboBox currencyComboBox;

    private XNumberField currencyRateField;

    private XDateField currencyRateDateField;

    private XCurrencyField currencyAmountField;

    private XTaxComboBox taxPercentField;

    private XCurrencyField currencyTaxAmountField;

    private XTextEdit noteField;

    public ContractEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Contract.class);
	this.setEntityServiceClass(ContractService.class);
	this.setEntityCode(Contract.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	setLayout(new BorderLayout());
	setTabbedPane(createBaseTabbedPane());
	addTabbedPane();
	initControl();
    }

    private JTabbedPane createBaseTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	currencyLabel = new JLabel(getString("panel.label-currency.text"));
	currencyRateLabel = new JLabel(getString("panel.label-currency-rate.text"));
	currencyRateDateLabel = new JLabel(getString("panel.label-currency-rate-date.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));
	taxPercentLabel = new JLabel(getString("panel.label-tax-percent.text"));
	currencyTaxAmountLabel = new JLabel(getString("panel.label-currency-tax-amount.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	partnerComboEdit = new XComboEdit();
	partnerComboEdit.setColumns(40);
	currencyComboBox = new XComboBox(getCurrencyService().findAll());
	currencyRateField = new XNumberField();
	currencyRateDateField = new XDateField();
	currencyAmountField = new XCurrencyField();
	taxPercentField = new XTaxComboBox();
	currencyTaxAmountField = new XCurrencyField();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;
	int anchor = gbc.anchor;

	editPanel.add(codeLabel);
	editPanel.addByX(codeField);
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.addByX(dateLabel);
	gbc.anchor = anchor;
	editPanel.addByX(dateField);

	gbc.gridx = 0;
	editPanel.addByY(partnerLabel);
	gbc.gridwidth = 5;
	editPanel.addByX(partnerComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(currencyLabel);
	editPanel.addByX(currencyComboBox);
	editPanel.addByX(currencyRateLabel);
	editPanel.addByX(currencyRateField);
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.addByX(currencyRateDateLabel);
	gbc.anchor = anchor;
	editPanel.addByX(currencyRateDateField);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	editPanel.addByY(currencyAmountLabel);
	editPanel.addByX(currencyAmountField);
	editPanel.addByX(taxPercentLabel);
	editPanel.addByX(taxPercentField);
	editPanel.addByX(currencyTaxAmountLabel);
	editPanel.addByX(currencyTaxAmountField);

	partnerComboEdit.initListFormAction(this, PartnerList.class);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Contract getContract() {
	return (Contract) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getContract().setCurrency(EnterpriseEnvironment.getCurrency());
	getContract().setCurrencyRate(1);
	getContract().setCurrencyRateDate(EnterpriseEnvironment.getDate());
	getContract().setPartner(EnterpriseEnvironment.getPartner());
    }

    protected void updateView() throws ApplicationException {
	// appendTitle(details.getCode());
	codeField.setText(getContract().getDocumentNo());
	dateField.setDate(getContract().getDocumentDate());
	partnerComboEdit.setValue(getContract().getPartner());
	currencyComboBox.setValue(getContract().getCurrency());
	currencyRateField.setValue(getContract().getCurrencyRate());
	currencyRateDateField.setDate(getContract().getCurrencyRateDate());
	currencyAmountField.setValue(getContract().getCurrencyEnterAmount());
	taxPercentField.setTaxId(getContract().getTaxId());
	currencyTaxAmountField.setValue(getContract().getCurrencyTaxAmount());

	noteField.setText(getContract().getNote());
    }

    protected void populateData() throws ApplicationException {
	getContract().setDocumentNo(codeField.getText());
	getContract().setDocumentDate(dateField.getDate());
	getContract().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getContract().setCurrency((Currency) currencyComboBox.getValue());
	getContract().setCurrencyRate(currencyRateField.doubleValue());
	getContract().setCurrencyRateDate(currencyRateDateField.getDate());
	getContract().setCurrencyEnterAmount(currencyAmountField.doubleValue());
	getContract().setTaxId(taxPercentField.getTaxId());
	getContract().setCurrencyTaxAmount(currencyTaxAmountField.doubleValue());
	getContract().setNote(noteField.getText());
	getContract().calculate();
    }

    private CurrencyService getCurrencyService() {
	return (CurrencyService) getSERVICE(CurrencyService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getContract().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getContract().getPartner(), partnerLabel.getText());
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
	return getContract() == null ? false : getContract()
		.isIncludeTaxInAmount();
    }

}
