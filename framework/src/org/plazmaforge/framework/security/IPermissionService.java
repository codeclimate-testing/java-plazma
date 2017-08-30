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

import java.util.List;

import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;

public interface IPermissionService {

    List<IPermission> getPermissionsByType(String objectType) throws ApplicationException;
    
    void checkReadPermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException ;
    
    void checkWritePermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException;

    void checkExecPermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException;
    
    

    /**
     * Check READ permission
     * @param objectId
     * @param objectType 
     * @throws AccessDeniedException
     * @throws ApplicationException
     */
    void checkReadPermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException;
    
    /**
     * Check WRITE permission
     * @param objectId
     * @param objectType 
     * @throws AccessDeniedException
     * @throws ApplicationException
     */
    void checkWritePermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException;
    
    
    /**
     * Check EXEC permission
     * @param objectId
     * @param objectType 
     * @throws AccessDeniedException
     * @throws ApplicationException
     */
    void checkExecPermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException;
}
