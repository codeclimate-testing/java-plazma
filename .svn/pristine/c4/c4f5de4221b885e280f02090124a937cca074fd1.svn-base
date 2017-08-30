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
package org.plazmaforge.bsolution.contact.client.swing.forms;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.PhoneType;
import org.plazmaforge.bsolution.contact.common.beans.formatter.ContactFormatterFactory;
import org.plazmaforge.bsolution.contact.common.beans.formatter.PhoneFormatter;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 13.03.2004
 * Time: 13:12:45
 * $Id: PhoneEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class PhoneEdit extends AbstractContactableItemEdit {

    private JLabel phoneTypeLabel;

    private JLabel defaultLabel;

    private JLabel phoneCodeLabel;

    private JLabel phoneNumberLabel;

    private JLabel phoneStringLabel;

    private XComboEdit phoneTypeComboEdit;

    private JCheckBox defaultField;

    private XTextField phoneCodeField;

    private XTextField phoneNumberField;

    private XTextField phoneStringField;

    private XTextEdit noteField;

    private PhoneFormatter phoneFormatter = ContactFormatterFactory.getPhoneFormatter();

    public PhoneEdit() throws ApplicationException {
	super(GUIContactEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Phone.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	JTabbedPane tabbedPane = new JTabbedPane();
	tabbedPane.addTab(getString("panel.title.common.text"), createCommonPanel());
	tabbedPane.addTab(getString("panel.title.note.text"), createNotePanel());
	add(tabbedPane);
    }

    private JPanel createCommonPanel() throws ApplicationException {

	phoneTypeLabel = new JLabel(getString("panel.label-phone-type.text"));
	defaultLabel = new JLabel(getString("panel.label-default.text"));
	phoneCodeLabel = new JLabel(getString("panel.label-phone-code.text"));
	phoneNumberLabel = new JLabel(getString("panel.label-phone-number.text"));
	phoneStringLabel = new JLabel(getString("panel.label-phone-string.text"));

	phoneTypeComboEdit = new XComboEdit();
	defaultField = new JCheckBox();

	phoneCodeField = new XTextField(6);
	phoneCodeField.setMaxChar(6);

	phoneNumberField = new XTextField(12);
	phoneNumberField.setMaxChar(12);

	phoneStringField = new XTextField(12);
	phoneStringField.setEditable(!isAutoFormatter());

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(phoneTypeLabel);
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(phoneTypeComboEdit);

	gbc.gridx = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(defaultLabel);
	editPanel.addByX(defaultField);

	gbc.gridx = 0;
	editPanel.addByY(phoneCodeLabel);
	editPanel.addByX(phoneCodeField);
	editPanel.addByX(phoneNumberLabel);
	editPanel.addByX(phoneNumberField);

	gbc.gridx = 0;
	editPanel.addByY(phoneStringLabel);
	gbc.gridwidth = 4;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(phoneStringField);

	if (isAutoFormatter()) {
	    FocusListener formatterListener = new FormatterListener();
	    phoneCodeField.addFocusListener(formatterListener);
	    phoneNumberField.addFocusListener(formatterListener);
	}

	phoneTypeComboEdit.initListFormAction(this, PhoneTypeList.class);
	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Phone getPhone() {
	return (Phone) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPhone().getPhoneNumber());
	phoneTypeComboEdit.setValue(getPhone().getPhoneType());
	defaultField.setSelected(getPhone().isDefaultItem());
	phoneCodeField.setText(getPhone().getPhoneCode());
	phoneNumberField.setText(getPhone().getPhoneNumber());
	phoneStringField.setText(getPhone().getPhoneString());
	noteField.setText(getPhone().getNote());
    }

    protected void populateData() throws ApplicationException {
	getPhone().setPhoneType((PhoneType) phoneTypeComboEdit.getValue());
	getPhone().setDefaultItem(defaultField.isSelected());
	getPhone().setPhoneCode(phoneCodeField.getText());
	getPhone().setPhoneNumber(phoneNumberField.getText());
	getPhone().setNote(noteField.getText());
	if (isAutoFormatter()) {
	    getPhone().setPhoneString(phoneFormatter.format(getPhone()));
	} else {
	    getPhone().setPhoneString(phoneStringField.getText());
	}
    }

    protected void addChild() throws ApplicationException {

	// Add item
	getContactable().addPhone(getPhone());

	// Set default item after add
	getPhone().setDefaultItem(defaultField.isSelected());

    }

    private void formatPhoneString() {
	phoneStringField.setText(phoneFormatter.format(phoneCodeField.getText(), phoneNumberField.getText()));
    }

    protected class FormatterListener implements FocusListener {

	public void focusGained(FocusEvent e) {
	}

	public void focusLost(FocusEvent e) {
	    formatPhoneString();
	}
    }

    protected boolean isAutoFormatter() {
	return true;
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getPhone().getPhoneType(), phoneTypeLabel.getText());
	validateRequiredField(buf, getPhone().getPhoneNumber(),	phoneNumberLabel.getText());
	checkError(buf);
    }

}
