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
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.bsolution.security.common.beans.UserRole;
import org.plazmaforge.bsolution.security.common.services.UserService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EXTParentEditForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.forms.EditableMode;
import org.plazmaforge.framework.client.swing.forms.actions.edit.EditFormAction;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;

import java.awt.*;
import java.util.*;

/**
 * Created on 31.05.2006
 */
public class UserEdit extends EXTParentEditForm {

    private JLabel loginLabel;

    private JLabel nameLabel;

    private JLabel passwordLabel;

    private JLabel reenterPasswordLabel;

    private XTextField loginField;

    private XTextField nameField;

    private JPasswordField passwordField;

    private JPasswordField reenterPasswordField;

    public UserEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(User.class);
	this.setEntityServiceClass(UserService.class);

    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	loginLabel = new JLabel(getString("panel.label-login.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	passwordLabel = new JLabel(getString("panel.label-password.text"));
	reenterPasswordLabel = new JLabel(
		getString("panel.label-reenter-password.text"));

	loginField = new XTextField(20);
	loginField.setMaxChar(20);
	nameField = new XTextField(40);
	nameField.setMaxChar(40);
	passwordField = new JPasswordField(20);
	reenterPasswordField = new JPasswordField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(loginLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(passwordLabel);
	editPanel.addByY(reenterPasswordLabel);

	gbc.gridy = 0;
	editPanel.addByX(loginField);
	editPanel.addByY(nameField);
	editPanel.addByY(passwordField);
	editPanel.addByY(reenterPasswordField);

	getParentPane().add(editPanel);

	setChildrenTabbedPane(createItemsTabbedPane());
	addChildrenTabbedPane();

    }

    protected EditFormAction createEditChildAction() {
	return null; // DISABLE EDIT ACTION
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(400, 150);
	tp.addTab(getString("table-user-role.name"), createItemPanel());
	return tp;
    }

    private JTable userRoleTable;

    private JComponent createItemPanel() throws ApplicationException {
	userRoleTable = createChildTable(createItemTableModel());
	JScrollPane scroll = new JScrollPane(userRoleTable);
	this.registerEntityType(scroll, new UserRoleType());
	return scroll;
    }

    protected TableModel createItemTableModel() throws ApplicationException {
	java.util.List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();

	d.setName(getString("table-user-role.role.name"));
	d.setFieldName("roleName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(UserRole.class, columns);
    }

    protected class UserRoleType extends AbstractChildType {
	public JTable getTable() {
	    return userRoleTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(UserRoleEdit.class); // DISABLE
	}
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	((UserRoleEdit) form).setUser(getUser());
	return form;
    }

    // -------------------------------------------------------------------------------

    private User getUser() {
	return (User) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getUser().getLogin());
	loginField.setText(getUser().getLogin());
	nameField.setText(getUser().getName());

	((StateTableModel) userRoleTable.getModel()).addData(getUser()
		.getUserRoleList());
    }

    protected void populateData() throws ApplicationException {
	getUser().setLogin(loginField.getText());
	getUser().setName(nameField.getText());
	if (isEnterPassword()) {
	    getUser().setPassword(new String(passwordField.getPassword()));
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getUser().getName(), nameLabel.getText());
	validateField(buf, isValidPassword(), passwordLabel.getText(),
		"Reenter");
	checkError(buf);
    }

    private boolean isEnterPassword() {
	String p1 = new String(passwordField.getPassword());
	String p2 = new String(reenterPasswordField.getPassword());
	return !(StringUtils.isEmpty(p1) && StringUtils.isEmpty(p2));
    }

    private boolean isValidPassword() {
	if (!isEnterPassword()) {
	    return true;
	}
	String p1 = new String(passwordField.getPassword());
	String p2 = new String(reenterPasswordField.getPassword());
	return StringUtils.equals(p1, p2);
    }

    public void doEditChildCommand(int mode) throws ApplicationException {
	if (mode != EditableMode.ADD) {
	    // You can't edit role
	    return;
	}

	beforeEditChild();

	RoleList roleForm = (RoleList) getLIST(RoleList.class, getShellWindow());
	Role role = (Role) roleForm.showList();
	if (role == null) {
	    return;
	}
	User user = getUser();
	if (user == null) {
	    return;
	}
	if (user.isExistRole(role)) {
	    applicationError("This Role is used");
	    return;
	}

	UserRole userRole = new UserRole();
	userRole.setRole(role);
	user.addUserRole(userRole);

	beforeRefreshChildData();
	doRefreshChildData();
	afterRefreshChildData();

	afterEditChild();
    }
}
