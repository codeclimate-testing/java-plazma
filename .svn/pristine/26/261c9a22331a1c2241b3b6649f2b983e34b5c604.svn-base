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
import org.plazmaforge.bsolution.finance.common.beans.PartnerRest;
import org.plazmaforge.bsolution.finance.common.services.PartnerRestService;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon Date: 17.08.2004 Time: 9:14:03 $Id: PartnerRestEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerRestEdit extends EXTEditForm {

    private JLabel partnerLabel;

    private JLabel operationTypeLabel;

    private JLabel amountLabel;

    private XComboEdit partnerComboEdit;

    private OperationTypeComboBox operationTypeComboBox;

    private XNumberField amountField;

    public PartnerRestEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(PartnerRest.class);
	this.setEntityServiceClass(PartnerRestService.class);

    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	GridBagPanel editPanel = new GridBagPanel();

	partnerLabel = new JLabel(getString("panel.label-client.text"));
	operationTypeLabel = new JLabel(getString("panel.label-operation-type.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));
	partnerComboEdit = new XComboEdit();
	partnerComboEdit.setColumns(30);
	operationTypeComboBox = new OperationTypeComboBox();
	amountField = new XNumberField(12);

	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(partnerLabel);
	editPanel.addByY(operationTypeLabel);
	editPanel.addByY(amountLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
	editPanel.add(partnerComboEdit);

	// gbc.fill = GridBagConstraints.NONE;
	// gbc.gridx = 1;
	gbc.gridwidth = 1;
	editPanel.addByY(operationTypeComboBox);
	editPanel.addByY(amountField);

	add(editPanel);

	partnerComboEdit.initListFormAction(this, PartnerList.class);
    }

    private PartnerRest getPartnerRest() {
	return (PartnerRest) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getPartnerRest().setOrganizationId(EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	getPartnerRest().setCurrency(EnterpriseEnvironment.getCurrency());
	getPartnerRest().setPeriodId(EnterpriseEnvironment.getPeriodId());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPartnerRest().getPartnerName());
	partnerComboEdit.setValue(getPartnerRest().getPartner());
	operationTypeComboBox.setSelectedOperationType(getPartnerRest().getOperationType());
	amountField.setValue(getPartnerRest().getAmount());
    }

    private PartnerRestService getPartnerRestService() {
	return (PartnerRestService) getSERVICE(PartnerRestService.class);
    }

    protected void populateData() throws ApplicationException {
	getPartnerRest().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getPartnerRest().setOperationType(operationTypeComboBox.getSelectedOperationType());
	getPartnerRest().setAmount(amountField.getValue());
    }

}