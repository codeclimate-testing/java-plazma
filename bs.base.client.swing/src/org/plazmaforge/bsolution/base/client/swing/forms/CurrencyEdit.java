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
package org.plazmaforge.bsolution.base.client.swing.forms;

import javax.swing.*;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.services.CurrencyService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon Date: 05.05.2004 Time: 17:38:36 $Id: CurrencyEdit.java,v 1.4 2010/12/05 07:56:44 ohapon Exp $
 */
public class CurrencyEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel charCodeLabel;

    private JLabel nameLabel;

    private JLabel fullNameLabel;

    private XTextField codeField;

    private XTextField charCodeField;

    private XTextField nameField;

    private XTextField fullNameField;

    public CurrencyEdit() {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Currency.class);
	this.setEntityServiceClass(CurrencyService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	charCodeLabel = new JLabel(getString("panel.label-char-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	fullNameLabel = new JLabel(getString("panel.label-full-name.text"));

	codeField = new XTextField(4);
	codeField.setMaxChar(3);
	charCodeField = new XTextField(4);
	charCodeField.setMaxChar(3);
	nameField = new XTextField(25);
	fullNameField = new XTextField(25);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(charCodeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(fullNameLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(charCodeField);
	editPanel.addByY(nameField);
	editPanel.addByY(fullNameField);

	add(editPanel);
    }

    private Currency getCurrency() {
	return (Currency) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getCurrency().getFullName());
	codeField.setText(getCurrency().getCode());
	charCodeField.setText(getCurrency().getNumericCode());
	nameField.setText(getCurrency().getName());
	fullNameField.setText(getCurrency().getFullName());
    }

    protected void populateData() throws ApplicationException {
	getCurrency().setCode(codeField.getText());
	getCurrency().setNumericCode(charCodeField.getText());
	getCurrency().setName(nameField.getText());
	getCurrency().setFullName(fullNameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getCurrency().getName(), nameLabel.getText());
	checkError(buf);
    }

}
