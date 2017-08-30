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



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import org.plazmaforge.bsolution.bank.client.swing.GUIBankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.Bank;
import org.plazmaforge.bsolution.bank.common.services.BankService;
import org.plazmaforge.bsolution.contact.client.swing.forms.AbstractContactableEdit;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 13.07.2004
 * Time: 9:27:37
 * $Id: BankEdit.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 */
public class BankEdit extends AbstractContactableEdit {

    private JLabel codeLabel;
    private JLabel nameLabel;
    private JLabel fullNameLabel;
    private JLabel taxCodeLabel;
    private JLabel swiftCodeLabel;
    private JLabel taxLabel;
    private JLabel bankSwiftCodeLabel;
    private JLabel correspondentAccountLabel;
    private JLabel yearCreateLabel;
    private JLabel workTimeLabel;

    private XTextField codeField;
    private XTextField nameField;
    private XTextField fullNameField;
    private XTextField taxCodeField;
    private XTextField swiftCodeField;
    private JCheckBox taxField;
    private XTextField bankSwiftCodeField;
    private XTextField correspondentAccountField;
    private XTextField yearCreateField;
    private XTextField workTimeField;
	
    private XTextEdit noteField;

    public BankEdit() throws ApplicationException {
        super(GUIBankEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Bank.class);
        this.setEntityServiceClass(BankService.class);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        setParentTabbedPane(createMasterTabbedPane());
        addParentTabbedPane();
        getChildrenPane().setMaximumSize(new Dimension(100, 50));
        setChildrenTabbedPane(createItemsTabbedPane());
        addChildrenTabbedPane();

    }

    private JTabbedPane createMasterTabbedPane() {
        JTabbedPane tp = new JTabbedPane();
        tp.addTab(getString("panel.title.common.text"), createCommonPanel());
        tp.addTab(getString("panel.title.other.text"), createOtherPanel());
        tp.addTab(getString("panel.title.note.text"), createNotePanel());		
        return tp;
    }

    private JPanel createCommonPanel() {

        codeLabel = new JLabel(getString("panel.label-code.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));
        fullNameLabel = new JLabel(getString("panel.label-full-name.text"));
        taxCodeLabel = new JLabel(getString("panel.label-tax-code.text"));
        swiftCodeLabel = new JLabel(getString("panel.label-swift-code.text"));
        taxLabel = new JLabel(getString("panel.label-tax.text"));
        bankSwiftCodeLabel = new JLabel(getString("panel.label-bank-swift-code.text"));
        correspondentAccountLabel = new JLabel(getString("panel.label-correspondent-account.text"));

        codeField = new XTextField(20);
        codeField.setMaxChar(10);
        nameField = new XTextField(30);
        nameField.setMaxChar(50);
        fullNameField = new XTextField(30);
        fullNameField.setMaxChar(100);
        taxCodeField = new XTextField(20);
        taxCodeField.setMaxChar(12);
        swiftCodeField = new XTextField(20);
        swiftCodeField.setMaxChar(20);
        taxField = new JCheckBox();
        bankSwiftCodeField = new XTextField(20);
        bankSwiftCodeField.setMaxChar(20);
        correspondentAccountField = new XTextField(30);
        correspondentAccountField.setMaxChar(30);

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(codeLabel);
        editPanel.addByY(nameLabel);
        editPanel.addByY(fullNameLabel);
        editPanel.addByY(bankSwiftCodeLabel);
        editPanel.addByY(correspondentAccountLabel);
        editPanel.addByY(taxCodeLabel);
        editPanel.addByY(swiftCodeLabel);
        editPanel.addByY(taxLabel);

        gbc.gridy = 0;
        editPanel.addByX(codeField);
        editPanel.addByY(nameField);
        editPanel.addByY(fullNameField);
        editPanel.addByY(bankSwiftCodeField);
        editPanel.addByY(correspondentAccountField);

        editPanel.addByY(taxCodeField);
        editPanel.addByY(swiftCodeField);
        editPanel.addByY(taxField);

        return editPanel;
    }

    private JPanel createOtherPanel() {

        yearCreateLabel = new JLabel(getString("panel.label-year-create.text"));
        workTimeLabel = new JLabel(getString("panel.label-work-time.text"));
        yearCreateField = new XTextField(4);
        yearCreateField.setMaxChar(4);
        workTimeField = new XTextField(30);
        workTimeField.setMaxChar(50);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(yearCreateLabel);
        editPanel.addByY(workTimeLabel);

        gbc.gridy = 0;
        editPanel.addByX(yearCreateField);
        editPanel.addByY(workTimeField);

        return editPanel;
    }

    private JPanel createNotePanel() {
        JPanel editPanel =  new JPanel(new BorderLayout());
        noteField = new XTextEdit();
        editPanel.add(noteField, BorderLayout.CENTER);
        return editPanel;
    }
	
    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
        JTabbedPane tp = createTabbedPane(150);
        tp.addTab(getString("table-address.name"), createAddressPanel());
        tp.addTab(getString("table-phone.name"), createPhonePanel());
        tp.addTab(getString("table-email.name"), createEmailPanel());
        tp.addTab(getString("table-web.name"), createWebPanel());
        return tp;
    }

    private Bank getBank() {
        return (Bank) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getBank().getName());
        codeField.setText(getBank().getCode());
        nameField.setText(getBank().getName());
        fullNameField.setText(getBank().getFullName());
        taxCodeField.setText(getBank().getIdn());
        swiftCodeField.setText(getBank().getNec());
        taxField.setSelected(getBank().isTax());

        bankSwiftCodeField.setText(getBank().getBic());
        correspondentAccountField.setText(getBank().getCorrespondentAccount());


        yearCreateField.setText(String.valueOf(getBank().getYearCreate()));
        workTimeField.setText(getBank().getWorkTime());

        noteField.setText(getBank().getNote());		
	updateTables();
		
    }

    protected void populateData() throws ApplicationException {
        getBank().setCode(codeField.getText());
        getBank().setName(nameField.getText());
        getBank().setFullName(fullNameField.getText());
        getBank().setIdn(taxCodeField.getText());
        getBank().setNec(swiftCodeField.getText());
        getBank().setTax(taxField.isSelected());
        getBank().setBic(bankSwiftCodeField.getText());
        getBank().setCorrespondentAccount(correspondentAccountField.getText());
        getBank().setYearCreate(Integer.valueOf(yearCreateField.getText()).intValue());
        getBank().setWorkTime(workTimeField.getText());
        getBank().setNote(noteField.getText());
    }


    protected ContactableElement getContactableElement() {
	return getBank().getContactableElement();
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getBank().getName(), nameLabel.getText());
	checkError(buf);
    }



}
