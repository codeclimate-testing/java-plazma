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

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * Created on 31.05.2006
 * $Id: Role.java,v 1.3 2010/12/05 07:56:01 ohapon Exp $
 */
public class Role extends BaseEntity {

    private String name;

    private String note;
    
    /**
     * List of User Interface of the role
     */
    private List<RoleInterface> roleInterfaces;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNote() {
	return note;
    }

    public void setNote(String note) {
	this.note = note;
    }

    
    
    public List<RoleInterface> getRoleInterfaces() {
	if (roleInterfaces == null) {
	    roleInterfaces = new ArrayList<RoleInterface>();
	}
        return roleInterfaces;
    }

    public void setRoleInterfaces(List<RoleInterface> roleInterfaces) {
        this.roleInterfaces = roleInterfaces;
    }
    
    public void addRoleInterface(RoleInterface roleInterface) {
	roleInterface.setRole(this);
	getRoleInterfaces().add(roleInterface);
    }
    
    public boolean isEmptyRoleInterfaces() {
	if (roleInterfaces == null || roleInterfaces.isEmpty()) {
	    return true;
	}
	List<RoleInterface> list = getNormalRoleInterfaces();
	return (list == null || list.isEmpty());
    }
    
    
    

    public boolean isExistRoleInterface(String interfaceId) {
	return isExistRoleInterface(interfaceId, getNormalRoleInterfaces());
    }

    public boolean isExistRoleInterface(String interfaceId, List<RoleInterface> interfaces) {
	if (interfaceId == null || interfaces == null || interfaces.isEmpty()) {
	    return false;
	}
	for (RoleInterface i : interfaces) {
	    String id = i.getInterfaceId();
	    if (interfaceId.equals(id)) {
		return true;
	    }
	}
	return false;
    }

    private List<RoleInterface> getNormalRoleInterfaces() {
	List<RoleInterface> interfaces = getRoleInterfaces();
	if (interfaces == null) {
	    return null;
	}
	List<RoleInterface> normalInterfaces = new ArrayList<RoleInterface>();
	for (RoleInterface i : interfaces) {
	    if (i.isDeleted()) {
		continue;
	    }
	    normalInterfaces.add(i);
	}
	return normalInterfaces;
    }
}
