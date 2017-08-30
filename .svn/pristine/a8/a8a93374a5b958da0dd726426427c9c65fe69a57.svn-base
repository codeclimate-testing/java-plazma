package org.plazmaforge.bsolution.base.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.security.common.beans.Permission;
import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.bsolution.security.common.services.PermissionService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class PermissionEdit extends EXTEditForm {

    private JLabel nameLabel;

    private JLabel readLabel;

    private JLabel writeLabel;

    private JLabel execLabel;

    private XTextField nameField;

    private JCheckBox readField;

    private JCheckBox writeField;

    private JCheckBox execField;

    private Role role;

    private PermissionView permissionView;

    private SecureObject secureObject;

    public PermissionEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Permission.class);
	this.setEntityServiceClass(PermissionService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	nameLabel = new JLabel(getString("panel.label-name.text"));

	readLabel = new JLabel(getString("panel.label-read.text"));
	writeLabel = new JLabel(getString("panel.label-write.text"));
	execLabel = new JLabel(getString("panel.label-exec.text"));

	nameField = new XTextField(20);
	nameField.setEditable(false);

	readField = new JCheckBox();
	writeField = new JCheckBox();
	execField = new JCheckBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.gridwidth = 2;
	editPanel.add(nameField);
	gbc.gridwidth = 1;
	editPanel.addByY(readLabel);
	editPanel.addByY(writeLabel);
	editPanel.addByY(execLabel);

	gbc.gridx = 1;
	gbc.gridy = 1;
	// editPanel.add(nameField);
	editPanel.add(readField);
	editPanel.addByY(writeField);
	editPanel.addByY(execField);

	add(editPanel);
    }

    private Permission getPermission() {
	return (Permission) this.getEntity();
    }

    private PermissionService getPermissionService() {
	return (PermissionService) this.getEntityService();
    }

    boolean newPermission;

    protected void loadData(Object value) throws ApplicationException {
	Integer id = getPermissionView().getPermissionId();
	if (id == null) {
	    newPermission = true;
	    Permission permission = new Permission();
	    permission.setRole(this.getRole());
	    permission.setSecureObject(this.getSecureObject());
	    setEntity(permission);
	} else {
	    newPermission = false;
	    super.loadData(id);
	}
    }

    protected void storeData() throws ApplicationException {
	if (newPermission) {
	    getPermissionService().create(getPermission());
	} else {
	    getPermissionService().store(getPermission());
	}
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPermission().getObjectName());
	nameField.setText(getPermission().getObjectName());

	readField.setSelected(getPermission().isRead());
	writeField.setSelected(getPermission().isWrite());
	execField.setSelected(getPermission().isExec());

	if ("ENTITY".equals(getPermission().getObjectType())) {
	    execField.setEnabled(false);
	}
    }

    protected void populateData() throws ApplicationException {
	getPermission().setRead(readField.isSelected());
	getPermission().setWrite(writeField.isSelected());
	getPermission().setExec(execField.isSelected());
    }

    protected void initData() throws ApplicationException {/* NOT SUPPORTED */
    }

    protected Object createData() throws ApplicationException {/* NOT SUPPORTED */
	return null;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public PermissionView getPermissionView() {
	return permissionView;
    }

    public void setPermissionView(PermissionView permissionView) {
	this.permissionView = permissionView;
    }

    public SecureObject getSecureObject() {
	return secureObject;
    }

    public void setSecureObject(SecureObject secureObject) {
	this.secureObject = secureObject;
    }

}
