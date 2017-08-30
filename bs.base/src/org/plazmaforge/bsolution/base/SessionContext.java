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
package org.plazmaforge.bsolution.base;

import java.util.List;

import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.config.object.IInterfaceConfig;
import org.plazmaforge.framework.platform.structure.PartContext;


/**
 * Session Context
 * 
 * @author Oleh Hapon Date: 09.10.2003 Time: 16:37:14
 */
public class SessionContext implements PartContext {


    private static final int DEFAULT_ORGANIZATION_ID = 1;
    
    

    /** OrganizationHeader * */
    private OrganizationHeader organization;

    /** User * */
    private User user;

    private IInterfaceConfig userInterface;
    
    
    private List<OrganizationHeader> availableOrganizations;
    
    private List<IInterfaceConfig> availableUserInterfaces;
    
    

    
    
    public SessionContext() {

    }

  
    public OrganizationHeader getOrganization() {
	return organization;
    }
    
    public void setOrganization(OrganizationHeader organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }
    

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public boolean isCurrentUser(User user) {
	Integer userId = user == null ? null : user.getId();
	if (userId == null) {
	    return false;
	}
	User currentUser = getUser();
	Integer currentUserId = currentUser == null ? null : currentUser.getId();
	if (currentUserId == null) {
	    return false;
	}
	return userId.equals(currentUserId);
    }
    
    public IInterfaceConfig getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(IInterfaceConfig userInterface) {
        this.userInterface = userInterface;
    }

    public List<OrganizationHeader> getAvailableOrganizations() {
        return availableOrganizations;
    }

    public void setAvailableOrganizations(List<OrganizationHeader> availableOrganizations) {
        this.availableOrganizations = availableOrganizations;
    }

    public List<IInterfaceConfig> getAvailableUserInterfaces() {
        return availableUserInterfaces;
    }

    public void setAvailableUserInterfaces(List<IInterfaceConfig> availableUserInterfaces) {
        this.availableUserInterfaces = availableUserInterfaces;
    }

    public Integer getDefaultUserOrganizationId() {
	if (availableOrganizations == null || availableOrganizations.isEmpty()) {
	    return DEFAULT_ORGANIZATION_ID;
	}
	OrganizationHeader org = availableOrganizations.get(0);
	Integer organizationId = org == null ? null : org.getId(); 
	if (organizationId == null) {
	    return DEFAULT_ORGANIZATION_ID;
	}
	return organizationId;
	    
    }
    


    
}
