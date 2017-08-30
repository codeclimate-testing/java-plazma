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
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.bsolution.security.common.beans.UserRole;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * Created on 02.06.2006
 */
public class UserRoleEdit extends EXTChildEditForm {

    private JLabel roleLabel;

    private XComboEdit roleComboEdit;

    public UserRoleEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(UserRole.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	roleLabel = new JLabel(getString("panel.label-role.text"));
	roleComboEdit = new XComboEdit();
	roleComboEdit.setColumns(30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(roleLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;

	editPanel.add(roleComboEdit);

	roleComboEdit.initListFormAction(this, RoleList.class);
	add(editPanel);
    }

    private UserRole getUserRole() {
	return (UserRole) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getUserRole().getRoleName());
	roleComboEdit.setValue(getUserRole().getRole());
    }

    private User user;

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    protected void populateData() throws ApplicationException {
	getUserRole().setRole((Role) roleComboEdit.getValue());
    }

    protected void addChild() throws ApplicationException {
	getUser().addUserRole(getUserRole());
    }

}
