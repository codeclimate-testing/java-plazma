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
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountType;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountTypeService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * 
 * @author Oleh Hapon
 * 
 * $Id: LedgerAccountTypeEdit.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 * 
 */
public class LedgerAccountTypeEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private XTextField codeField;

    private XTextField nameField;

    public LedgerAccountTypeEdit() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(LedgerAccountType.class);
	this.setEntityServiceClass(LedgerAccountTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new XTextField(3);
	codeField.setMaxChar(2);
	nameField = new XTextField(30);
	nameField.setMaxChar(30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);

	add(editPanel);
    }

    private LedgerAccountType getLedgerAccountType() {
	return (LedgerAccountType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getLedgerAccountType().getName());
	codeField.setText(getLedgerAccountType().getCode());
	nameField.setText(getLedgerAccountType().getName());
    }

    protected void populateData() throws ApplicationException {
	getLedgerAccountType().setCode(codeField.getText());
	getLedgerAccountType().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getLedgerAccountType().getCode(), codeLabel.getText());
	validateRequiredField(buf, getLedgerAccountType().getName(), nameLabel.getText());
	checkError(buf);
    }

}
