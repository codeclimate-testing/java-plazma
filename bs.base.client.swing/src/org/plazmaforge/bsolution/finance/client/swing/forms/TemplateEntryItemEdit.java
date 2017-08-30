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
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntryItem;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class TemplateEntryItemEdit extends EXTChildEditForm {

    private JLabel debitAccountExpLabel;

    private JLabel debitObjectExpLabel;

    private JLabel creditAccountExpLabel;

    private JLabel creditObjectExpLabel;

    private JLabel amountExpLabel;

    private XTextField debitAccountExpField;

    private XTextField debitObjectExpField;

    private XTextField creditAccountExpField;

    private XTextField creditObjectExpField;

    private XTextField amountExpField;

    public TemplateEntryItemEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(TemplateEntryItem.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	debitAccountExpLabel = new JLabel(getString("panel.label-debit-account-exp.text"));
	debitObjectExpLabel = new JLabel(getString("panel.label-debit-object-exp.text"));
	creditAccountExpLabel = new JLabel(getString("panel.label-credit-account-exp.text"));
	creditObjectExpLabel = new JLabel(getString("panel.label-credit-object-exp.text"));
	amountExpLabel = new JLabel(getString("panel.label-amount-exp.text"));

	debitAccountExpField = new XTextField(20);
	debitObjectExpField = new XTextField(20);
	creditAccountExpField = new XTextField(20);
	creditObjectExpField = new XTextField(20);
	amountExpField = new XTextField(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(debitAccountExpLabel);
	editPanel.addByY(debitObjectExpLabel);
	editPanel.addByY(creditAccountExpLabel);
	editPanel.addByY(creditObjectExpLabel);
	editPanel.addByY(amountExpLabel);

	gbc.gridy = 0;
	editPanel.addByX(debitAccountExpField);
	editPanel.addByY(debitObjectExpField);
	editPanel.addByY(creditAccountExpField);
	editPanel.addByY(creditObjectExpField);
	editPanel.addByY(amountExpField);

	add(editPanel);
    }

    public TemplateEntryItem getTemplateEntryItem() {
	return (TemplateEntryItem) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	debitAccountExpField.setText(getTemplateEntryItem().getDebitLedgerAccountExpression());
	debitObjectExpField.setText(getTemplateEntryItem().getDebitObjectExpression());
	creditAccountExpField.setText(getTemplateEntryItem().getCreditLedgerAccountExpression());
	creditObjectExpField.setText(getTemplateEntryItem().getCreditObjectExpression());
	amountExpField.setText(getTemplateEntryItem().getAmountExpression());
    }

    protected void populateData() throws ApplicationException {
	getTemplateEntryItem().setDebitLedgerAccountExpression(debitAccountExpField.getText());
	getTemplateEntryItem().setDebitObjectExpression(debitObjectExpField.getText());
	getTemplateEntryItem().setCreditLedgerAccountExpression(creditAccountExpField.getText());
	getTemplateEntryItem().setCreditObjectExpression(creditObjectExpField.getText());
	getTemplateEntryItem().setAmountExpression(amountExpField.getText());
    }

    private TemplateEntry templateEntry;

    public TemplateEntry getTemplateEntry() {
	return templateEntry;
    }

    public void setTemplateEntry(TemplateEntry templateEntry) {
	this.templateEntry = templateEntry;
    }

    protected void addChild() throws ApplicationException {
	getTemplateEntry().addItem(getTemplateEntryItem());
    }

}
