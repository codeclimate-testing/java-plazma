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
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.client.swing.forms.common.OperationTypeComboBox;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountRest;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountRestService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/*
 * Created on 11.10.2006
 * 
 */

/**
 * 
 * @author Oleh Hapon
 * 
 * $Id: LedgerAccountRestEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 * 
 */
public class LedgerAccountRestEdit extends EXTEditForm {

    private JLabel ledgerAccountLabel;

    private JLabel operationTypeLabel;

    private JLabel amountLabel;

    private XComboEdit ledgerAccountComboEdit;

    private OperationTypeComboBox operationTypeComboBox;

    private XNumberField amountField;

    public LedgerAccountRestEdit() {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(LedgerAccountRest.class);
	this.setEntityServiceClass(LedgerAccountRestService.class);

    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	GridBagPanel editPanel = new GridBagPanel();

	ledgerAccountLabel = new JLabel(getString("panel.label-ledger-account.text"));
	operationTypeLabel = new JLabel(getString("panel.label-operation-type.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));
	ledgerAccountComboEdit = new XComboEdit();
	ledgerAccountComboEdit.setColumns(30);
	operationTypeComboBox = new OperationTypeComboBox();
	amountField = new XNumberField(12);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(ledgerAccountLabel);
	editPanel.addByY(operationTypeLabel);
	editPanel.addByY(amountLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
	editPanel.add(ledgerAccountComboEdit);

	gbc.gridwidth = 1;
	editPanel.addByY(operationTypeComboBox);
	editPanel.addByY(amountField);

	add(editPanel);

	ledgerAccountComboEdit.initListFormAction(this,	LedgerAccountList.class, "accountName");
    }

    private LedgerAccountRest getLedgerAccountRest() {
	return (LedgerAccountRest) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getLedgerAccountRest().setOrganizationId(EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	getLedgerAccountRest().setCurrency(EnterpriseEnvironment.getCurrency());
	getLedgerAccountRest().setPeriodId(EnterpriseEnvironment.getPeriodId());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getLedgerAccountRest().getAccountName());
	ledgerAccountComboEdit.setValue(getLedgerAccountRest().getLedgerAccount());
	operationTypeComboBox.setSelectedOperationType(getLedgerAccountRest().getOperationType());
	amountField.setValue(getLedgerAccountRest().getAmount());
    }

    protected void populateData() throws ApplicationException {
	getLedgerAccountRest().setLedgerAccount((LedgerAccount) ledgerAccountComboEdit.getValue());
	getLedgerAccountRest().setOperationType(operationTypeComboBox.getSelectedOperationType());
	getLedgerAccountRest().setAmount(amountField.getValue());
    }

}
