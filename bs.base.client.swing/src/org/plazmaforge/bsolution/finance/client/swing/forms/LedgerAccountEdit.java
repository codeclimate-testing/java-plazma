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
 * Created on 15.05.2006
 *
 */

package org.plazmaforge.bsolution.finance.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountType;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountService;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * 
 * @author Oleh Hapon
 * 
 * $Id: LedgerAccountEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 * 
 */
public class LedgerAccountEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel ledgerAccountTypeLabel;

    private JLabel parentLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XComboBox ledgerAccountTypeComboBox;

    private XComboEdit parentComboEdit;

    public LedgerAccountEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(LedgerAccount.class);
	this.setEntityServiceClass(LedgerAccountService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	ledgerAccountTypeLabel = new JLabel(getString("panel.label-ledger-account-type.text"));
	parentLabel = new JLabel(getString("panel.label-parent.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);
	ledgerAccountTypeComboBox = new XComboBox(getLedgerAccountTypeService().findAll());
	parentComboEdit = new XComboEdit();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(ledgerAccountTypeLabel);
	editPanel.addByY(parentLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);
	editPanel.addByY(ledgerAccountTypeComboBox);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByY(parentComboEdit);

	add(editPanel);

	parentComboEdit.initListFormAction(this, LedgerAccountList.class);
    }

    private LedgerAccount getLedgerAccount() {
	return (LedgerAccount) this.getEntity();
    }

    private LedgerAccountTypeService getLedgerAccountTypeService() {
	return (LedgerAccountTypeService) getSERVICE(LedgerAccountTypeService.class);
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getLedgerAccount().getName());
	codeField.setText(getLedgerAccount().getCode());
	nameField.setText(getLedgerAccount().getName());
	ledgerAccountTypeComboBox.setValue(getLedgerAccount().getLedgerAccountType());
	if (getLedgerAccount().getParentId() != null) {
	    parentComboEdit.setValue(getEntityService().findHeaderById(getLedgerAccount().getParentId()));
	} else {
	    parentComboEdit.setValue(null);
	}

    }

    protected void populateData() throws ApplicationException {
	getLedgerAccount().setCode(codeField.getText());
	getLedgerAccount().setName(nameField.getText());
	getLedgerAccount().setLedgerAccountType((LedgerAccountType) ledgerAccountTypeComboBox.getValue());
	if (parentComboEdit.getValue() == null) {
	    getLedgerAccount().setParentId(null);
	} else {
	    getLedgerAccount().setParentId(((LedgerAccount) parentComboEdit.getValue()).getId());
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getLedgerAccount().getCode(), codeLabel.getText());
	validateRequiredField(buf, getLedgerAccount().getName(), nameLabel.getText());
	if (parentComboEdit.getValue() != null) {
	    LedgerAccount parentAccount = (LedgerAccount) parentComboEdit .getValue();
	    if (parentAccount.getId() == getLedgerAccount().getId()) {
		addError(buf, getFieldResourceString() + " [" + parentLabel.getText() + "] ", " is equal current account");
	    } else {
		if (parentAccount.getParentId() != null) {
		    addError(buf, getFieldResourceString() + " [" + parentLabel.getText() + "] ", " is child account");
		}
	    }
	}
	checkError(buf);
    }

}
