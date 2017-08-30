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

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.bsolution.security.common.services.PermissionViewService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.table.BooleanImageCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.LibraryResources;


/**
 * Created on 06.03.2007
 */
public class PermissionList extends EXTListForm {

    private Role role;

    public PermissionList() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    public PermissionList(Window window) throws ApplicationException {
	super(window, GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(PermissionView.class);
	this.setEntityServiceClass(PermissionViewService.class);
	this.setEntityEditFormClass(PermissionEdit.class);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(650, 600);
    }

    protected void initActions() throws ApplicationException {
	super.initActions();
	initModifyActionOnlyEdit();
    }

    protected List<ColumnProperty> createTableColumnProperties()
	    throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-object-type.name"));
	d.setFieldName("objectType");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-read.name"));
	d.setFieldName("read");
	d.setColumnClass(Boolean.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-write.name"));
	d.setFieldName("write");
	d.setColumnClass(Boolean.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-exec.name"));
	d.setFieldName("exec");
	d.setColumnClass(Boolean.class);
	d.setSize(20);
	columns.add(d);

	return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	ImageIcon icon = LibraryResources.getInstance().createIcon(
		"olmari/Permission.gif");
	BooleanImageCellRenderer renderer = GUIEnvironment
		.createBooleanImageCellRenderer(icon);
	table.getColumn(getString("table.column-read.name")).setCellRenderer(
		renderer);
	table.getColumn(getString("table.column-write.name")).setCellRenderer(
		renderer);
	table.getColumn(getString("table.column-exec.name")).setCellRenderer(
		renderer);
	return table;
    }

    private PermissionViewService getPermissionViewService() {
	return (PermissionViewService) getEntityService();
    }

    protected void loadData() throws ApplicationException {
	refreshTableModel(getPermissionViewService().findByRole(getRoleId()));
    }

    protected EditForm getEditForm() throws ApplicationException {
	PermissionEdit form = (PermissionEdit) super.getEditForm();

	PermissionView permissionView = getPermissionView();
	SecureObject secureObject = permissionView.createSecureObject();

	form.setRole(this.getRole());
	form.setPermissionView(permissionView);
	form.setSecureObject(secureObject);

	return form;
    }

    // TODO: Object or ID !!!
    protected Object findObject(Object object) throws ApplicationException {
	if (object == null)
	    return null;
	// return getEntityService().findHeaderById(((PermissionView)
        // object).getId());
	return getPermissionViewService().findByRoleAndId(getRoleId(),
		((PermissionView) object).getId());
    }

    protected void delCommand(Object ID) throws ApplicationException {/*
                                                                         * NOT
                                                                         * SUPPORTED
                                                                         */
    }

    // TODO: TransferObject = Real selected object
    protected Object getTransferObject() {
	return getSelectedObject();
    }

    private PermissionView getPermissionView() {
	return (PermissionView) getSelectedObject();
    }

    public Role getRole() {
	if (role == null) {
	    // TODO: STUB
	    role = new Role();
	    role.setId(1);
	}
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public Integer getRoleId() {
	return getRole().getId();
    }

}