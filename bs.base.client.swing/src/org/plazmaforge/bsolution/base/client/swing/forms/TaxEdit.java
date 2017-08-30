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
package org.plazmaforge.bsolution.base.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Tax;
import org.plazmaforge.bsolution.base.common.services.TaxService;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class TaxEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel percentLabel;

    private JLabel amountLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XCurrencyField percentField;

    private XCurrencyField amountField;

    public TaxEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Tax.class);
	this.setEntityServiceClass(TaxService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	percentLabel = new JLabel(getString("panel.label-percent.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	nameField = new XTextField(30);
	nameField.setMaxChar(30);
	percentField = new XCurrencyField();
	amountField = new XCurrencyField();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(percentLabel);
	editPanel.addByY(amountLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);
	editPanel.addByY(percentField);
	editPanel.addByY(amountField);

	add(editPanel);
    }

    private Tax getTax() {
	return (Tax) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getTax().getCode());
	codeField.setText(getTax().getCode());
	nameField.setText(getTax().getName());
	percentField.setValue(getTax().getTaxPercent());
	amountField.setValue(getTax().getAmount());
    }

    protected void populateData() throws ApplicationException {
	getTax().setCode(codeField.getText());
	getTax().setName(nameField.getText());
	getTax().setTaxPercent(percentField.floatValue());
	getTax().setAmount(amountField.floatValue());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getTax().getCode(), codeLabel.getText());
	validateRequiredField(buf, getTax().getName(), nameLabel.getText());
	checkError(buf);
    }

}
