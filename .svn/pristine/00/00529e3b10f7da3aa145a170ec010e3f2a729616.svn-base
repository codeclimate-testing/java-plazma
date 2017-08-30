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

import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.security.IPermission;

/**
 * 
 * @author Oleh Hapon 
 * $Id: Permission.java,v 1.4 2010/12/05 07:56:01 ohapon Exp $
 * 
 */
public class Permission extends BaseEntity implements IPermission {

    private Role role;

    private SecureObject secureObject;

    private boolean read;

    private boolean write;

    private boolean exec;

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public SecureObject getSecureObject() {
	return secureObject;
    }

    public void setSecureObject(SecureObject secureObject) {
	this.secureObject = secureObject;
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

    public String getRoleName() {
	return role == null ? null : role.getName();
    }

    public String getObjectName() {
	return secureObject == null ? null : secureObject.getName();
    }

    public String getObjectType() {
	return secureObject == null ? null : secureObject.getObjectType();
    }

    public String getObjectId() {
	return secureObject == null ? null : secureObject.getObjectId();
    }

}
