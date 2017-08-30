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

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;


/**
 * @author Oleh Hapon 
 * Date: 30.05.2004 
 * Time: 14:11:03 
 * $Id: User.java,v 1.6 2010/12/05 07:56:01 ohapon Exp $
 */
public class User extends UserHeader {


    private String password;

    private Date regDate;

    private Integer ownerId;

    private String entityId;

    private Integer contactId;
    
    private Integer organizationId;

    private String organizationName;

    private int partnerId;
    
    // TODO:  
    private ContactTitle contact;
    

    private List<UserRole> userRoleList;
    
    private List<UserOrganization> userOrganizationList;

    
    private boolean changePassword;
    
    

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getRegDate() {
	return regDate;
    }

    public void setRegDate(Date regDate) {
	this.regDate = regDate;
    }

    public String getEntityId() {
	return entityId;
    }

    public void setEntityId(String entityId) {
	this.entityId = entityId;
    }

    public Integer getOrganizationId() {
	return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
	this.organizationId = organizationId;
    }

    public Integer getOwnerId() {
	return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
	this.ownerId = ownerId;
    }

    public String getOrganizationName() {
	return organizationName;
    }

    public void setOrganizationName(String organizationName) {
	this.organizationName = organizationName;
    }

    public int getPartnerId() {
	return partnerId;
    }

    public void setPartnerId(int partnerId) {
	this.partnerId = partnerId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    
    public ContactTitle getContact() {
        return contact;
    }

    public void setContact(ContactTitle contact) {
        this.contact = contact;
    }

    public void init() {
	super.init();
	getUserRoleList().size();
	getUserOrganizationList().size();
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // USER ROLES
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<UserRole> getUserRoleList() {
	if (userRoleList == null) {
	    userRoleList = new ArrayList<UserRole>();
	}
	return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
	this.userRoleList = userRoleList;
    }

    public void addUserRole(UserRole userRole) {
	userRole.setUser(this);
	this.getUserRoleList().add(userRole);
	this.init();
    }

  

    public boolean isExistRole(Role role) {
	if (role == null) {
	    return false;
	}
	return isExistRole(role.getId());
    }

    public boolean isExistRole(Integer roleId) {
	return isExistRole(roleId, getNormalUserRoleList());
    }

    public boolean isExistRole(Integer roleId, List<UserRole> userRoles) {
	if (roleId == null || userRoles == null || userRoles.size() == 0) {
	    return false;
	}
	for (UserRole userRole : userRoles) {
	    Role role = userRole.getRole();
	    if (role == null) {
		continue;
	    }
	    if (roleId.equals(role.getId())) {
		return true;
	    }
	}
	return false;
    }

    private List<UserRole> getNormalUserRoleList() {
	List<UserRole> roles = getUserRoleList();
	if (roles == null) {
	    return null;
	}
	List<UserRole> normalRoles = new ArrayList<UserRole>();
	for (UserRole userRole : roles) {
	    if (userRole.isDeleted()) {
		continue;
	    }
	    normalRoles.add(userRole);
	}
	return normalRoles;
    }
    
    public boolean isEmptyUserRoles() {
	if (userRoleList == null || userRoleList.isEmpty()) {
	    return true;
	}
	List<UserRole> list = getNormalUserRoleList();
	return (list == null || list.isEmpty());
    }

    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // USER ORGANIZATIONS
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<UserOrganization> getUserOrganizationList() {
	if (userOrganizationList == null) {
	    userOrganizationList = new ArrayList<UserOrganization>();
	}
        return userOrganizationList;
    }

    public void setUserOrganizationList(List<UserOrganization> userOrganizationList) {
        this.userOrganizationList = userOrganizationList;
    }
    
    public void addUserOrganization(UserOrganization userOrganization) {
	userOrganization.setUser(this);
	getUserOrganizationList().add(userOrganization);
	//init();
    }
    
    
    public boolean isExistOrganization(Integer organizationId) {
	return isExistOrganization(organizationId, getNormalUserOrganizationList());
    }

    public boolean isExistOrganization(Integer organizationId, List<UserOrganization> userOrganizations) {
	if (organizationId == null || userOrganizations == null || userOrganizations.size() == 0) {
	    return false;
	}
	for (UserOrganization userOrganization : userOrganizations) {
	   
	    if (organizationId.equals(userOrganization.getOrganizationId())) {
		return true;
	    }
	}
	return false;
    }

    private List<UserOrganization> getNormalUserOrganizationList() {
	List<UserOrganization> organizations = getUserOrganizationList();
	if (organizations == null) {
	    return null;
	}
	List<UserOrganization> normalOrganizations = new ArrayList<UserOrganization>();
	for (UserOrganization userOrganization : organizations) {
	    if (userOrganization.isDeleted()) {
		continue;
	    }
	    normalOrganizations.add(userOrganization);
	}
	return normalOrganizations;
    }
    
    public boolean isEmptyUserOrganizations() {
	if (userOrganizationList == null || userOrganizationList.isEmpty()) {
	    return true;
	}
	List<UserOrganization> list = getNormalUserOrganizationList();
	return (list == null || list.isEmpty());
    }
    
    
    public String[] getRoleIds() {
	List<UserRole> roles = getUserRoleList();
	if (roles == null || roles.isEmpty()) {
	    return new String[0]; 
	}
	List<String> roleList = new ArrayList<String>(); 
	for (UserRole role : roles) {
	    if (role.getRole() == null) {
		continue;
	    }
	    Integer roleId = role.getRole().getId();
	    if (roleId == null) {
		continue;
	    }
	    roleList.add(roleId.toString());
	}
	if (roleList.isEmpty()) {
	    return new String[0];
	}
	return (String[]) roleList.toArray(new String[0]);
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }
    
    public Integer getOwnerId(String entityId) {
	if (entityId == null || this.entityId == null) {
	    return null;
	}
	if (this.entityId.trim().equals(entityId.trim())) {
	    return ownerId;
	}
	return null;
    }
    
}
