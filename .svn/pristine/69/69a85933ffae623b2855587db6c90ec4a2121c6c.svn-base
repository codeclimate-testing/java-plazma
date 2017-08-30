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

package org.plazmaforge.bsolution.organization.client.swing.forms;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.Store;
import org.plazmaforge.bsolution.organization.common.services.StoreService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 06.05.2004
 * Time: 16:11:47
 * $Id: StoreEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class StoreEdit extends AbstractOrganizableEdit {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private XTextField codeField;

    private XTextField nameField;

    public StoreEdit() throws ApplicationException {
	super(GUIOrganizationEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Store.class);
	this.setEntityServiceClass(StoreService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);

	add(editPanel);
    }

    private Store getStore() {
	return (Store) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getStore().getName());
	codeField.setText(getStore().getCode());
	nameField.setText(getStore().getName());
    }

    protected void populateData() throws ApplicationException {
	getStore().setCode(codeField.getText());
	getStore().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getStore().getName(), nameLabel.getText());
	checkError(buf);
    }

}
