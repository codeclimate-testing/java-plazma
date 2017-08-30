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

package org.plazmaforge.framework.security;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.security.UserContext;
import org.plazmaforge.framework.ext.security.UserContextHolder;

/**
 * 
 * @author Oleh Hapon
 * $Id: AbstractSecureManager.java,v 1.8 2010/12/05 07:51:23 ohapon Exp $
 */
public abstract class AbstractSecureManager {

    private static final String[] EMPTY_ROLE_IDS = new String[0];
    
    public abstract void checkReadPermission(String secureObjectId, String  objectType)  throws ApplicationException;

    public abstract void checkWritePermission(String secureObjectId, String  objectType) throws ApplicationException;

    public abstract void checkExecPermission(String secureObjectId, String  objectType)  throws ApplicationException;

    /**
     * Return secureObjectId by class
     * @param objectClass
     * @return
     */
    protected String getSecureObjectId(Class objectClass) {
	// Get association
	Association association = AssociationManager.getAssociationByElementClass(objectClass);
	if (association == null) {
	    return null;
	}
	// Get associationId. The associationId is not secureObjectId 
	String associationId = association.getId(); 
	if (associationId == null) {
	    return null;
	}
	return associationId;
    }
    
    
    public void checkReadPermission(Class objectClass) throws ApplicationException {
	checkReadPermission(getSecureObjectId(objectClass), SecureManager.ENTITY);
    }

    public void checkWritePermission(Class objectClass) throws ApplicationException {
	checkWritePermission(getSecureObjectId(objectClass), SecureManager.ENTITY);
    }

    public void checkExecPermission(Class objectClass) throws ApplicationException {
	checkExecPermission(getSecureObjectId(objectClass), SecureManager.ENTITY);
    }

    public void checkSecureObject(Class objectClass) throws ApplicationException {
	checkReadPermission(objectClass);
    }
	
    protected String[] getContextRoleIds() {
	UserContext ctx = (UserContext) UserContextHolder.getContext();
	if (ctx == null) {
	    return EMPTY_ROLE_IDS;
	}
	return ctx.getRoles();
    }
    
    
    
	
}
