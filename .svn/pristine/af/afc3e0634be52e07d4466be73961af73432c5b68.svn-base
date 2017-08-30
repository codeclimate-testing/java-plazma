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

package org.plazmaforge.bsolution.security.common.beans;

import org.plazmaforge.framework.ext.model.Dictionary;

/**
 * 
 * @author Oleh Hapon 
 * $Id: PermissionView.java,v 1.3 2010/04/28 06:24:28 ohapon Exp $
 * 
 */
public class PermissionView extends Dictionary {

    private Integer secureObjectId;

    private Integer permissionId;

    private Integer roleId;

    private String objectId;

    private String objectType;

    private boolean read;

    private boolean write;

    private boolean exec;

    public Integer getSecureObjectId() {
	return secureObjectId;
    }

    public void setSecureObjectId(Integer secureObjectId) {
	this.secureObjectId = secureObjectId;
    }

    public Integer getPermissionId() {
	return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
	this.permissionId = permissionId;
    }

    public Integer getRoleId() {
	return roleId;
    }

    public void setRoleId(Integer roleId) {
	this.roleId = roleId;
    }

    public String getObjectId() {
	return objectId;
    }

    public void setObjectId(String objectId) {
	this.objectId = objectId;
    }

    public String getObjectType() {
	return objectType;
    }

    public void setObjectType(String objectType) {
	this.objectType = objectType;
    }

    public boolean isExec() {
	return exec;
    }

    public void setExec(boolean exec) {
	this.exec = exec;
    }

    public boolean isRead() {
	return read;
    }

    public void setRead(boolean read) {
	this.read = read;
    }

    public boolean isWrite() {
	return write;
    }

    public void setWrite(boolean write) {
	this.write = write;
    }

    public SecureObject createSecureObject() {
	SecureObject secureObject = new SecureObject();
	// secureObject.setId(this.getSecureObjectId());
	secureObject.setId(this.getId());
	secureObject.setCode(this.getCode());
	secureObject.setName(this.getName());
	secureObject.setObjectType(this.getObjectType());
	secureObject.setObjectId(this.getObjectId());
	return secureObject;
    }

}
