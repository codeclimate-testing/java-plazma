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
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.services.RoleService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * Created on 31.05.2006
 */
public class RoleEdit extends EXTEditForm {

    private JLabel nameLabel;

    private XTextField nameField;

    public RoleEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Role.class);
	this.setEntityServiceClass(RoleService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	nameLabel = new JLabel(getString("panel.label-name.text"));

	nameField = new XTextField(50);
	nameField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(nameField);

	add(editPanel);
    }

    private Role getRole() {
	return (Role) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getRole().getName());
	nameField.setText(getRole().getName());
    }

    protected void populateData() throws ApplicationException {
	getRole().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	// validateRequiredField(buf, getRole().getName(), nameLabel.getText());
	checkError(buf);
    }

}
