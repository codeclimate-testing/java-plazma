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

package org.plazmaforge.bsolution.security.common.services;

import java.util.List;

import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.EntityService;


public interface PermissionViewService extends
	EntityService<PermissionView, Integer> {

    List<PermissionView> findByRole(Role role) throws ApplicationException;

    List<PermissionView> findByRole(Integer roleId) throws ApplicationException;

    PermissionView findByRoleAndId(final Integer roleId, final Integer id)
	    throws ApplicationException;
}
