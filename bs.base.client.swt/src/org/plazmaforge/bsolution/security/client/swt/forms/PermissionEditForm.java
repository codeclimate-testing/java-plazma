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
 * Created on 13.07.2007
 *
 */

package org.plazmaforge.bsolution.security.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.security.common.beans.Permission;
import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.bsolution.security.common.services.PermissionService;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: PermissionEditForm.java,v 1.4 2010/12/05 07:57:22 ohapon Exp $
 */

public class PermissionEditForm extends AbstractEditForm {

  

    private XTextField nameField;

    private XCheckBox readField;

    private XCheckBox writeField;

    private XCheckBox execField;
    
    
    
    //
    private Role role;

    private PermissionView permissionView;

    private SecureObject secureObject;
    

    public PermissionEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }

    private void initialize() {
	
	Label execLabel;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
	
	Label nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("PermissionEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.NONE);
    	nameField.setLayoutData(new GridData(200, SWT.DEFAULT));

    	Label readLabel = new Label(this, SWT.NONE);
    	readLabel.setText(Messages.getString("PermissionEditForm.readLabel.text")); //$NON-NLS-1$

    	readField = new XCheckBox(this, SWT.NONE);

    	Label writeLabel = new Label(this, SWT.NONE);
    	writeLabel.setText(Messages.getString("PermissionEditForm.writeLabel.text")); //$NON-NLS-1$

    	writeField = new XCheckBox(this, SWT.NONE);

    	execLabel = new Label(this, SWT.NONE);
    	execLabel.setText(Messages.getString("PermissionEditForm.execLabel.text")); //$NON-NLS-1$

    	execField = new XCheckBox(this, SWT.NONE);
    }
    
    protected void bindControls() {
	bindControl(nameField, "objectName");
	bindControl(readField, "read", Boolean.TYPE);
	bindControl(writeField, "write", Boolean.TYPE);
	bindControl(execField, "exec", Boolean.TYPE);
    }
    
    protected void createData() throws ApplicationException {
	//NO SUPPORT
    }
    
    protected void loadData() throws ApplicationException {
	
	Permission permission = null;
	
	if (getPermissionId() == null) {
	    permission = new Permission();
	    permission.setRole(getRole());
	    permission.setSecureObject(getSecureObject());
	} else {
	    // Entity ID is not Permission ID !!!
	    // We use getPermissionId()
	    permission = getPermissionService().findById(getPermissionId());
	    //super.loadData();
	}
	
	setEntity(permission);
    }

    protected void storeData() throws ApplicationException {
	if (getPermissionId() == null) {
	    getPermissionService().create(getPermission());
	} else {
	    getPermissionService().store(getPermission());
	}
    }
    
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	initNoEditableField(nameField);
	
	// Disable IS_EXEC field for entity object because entity has not execute mode
	if ("ENTITY".equals(getPermission().getObjectType())) {
	    initDisableField(execField);
	}
	
	if ("ACTION".equals(getPermission().getObjectType()) || "REPORT".equals(getPermission().getObjectType())) {
	    initDisableField(readField);
	    initDisableField(writeField);
	}

    }
    
    private Integer getPermissionId() {
	return getPermissionView().getPermissionId();
    }
    
    private Permission getPermission() {
	return (Permission) getEntity();
    }

    private PermissionService getPermissionService() {
	return (PermissionService) getEntityService();
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
