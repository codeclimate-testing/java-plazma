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

import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.EntityService;


/**
 * @author Oleh Hapon
 * Date: 30.05.2004
 * Time: 14:12:10
 * $Id: UserService.java,v 1.4 2010/12/05 07:56:03 ohapon Exp $
 */
public interface UserService extends EntityService<User, Integer> {
	
    User login(String login, String password) throws AccessDeniedException;
    
    boolean existsUser(String login) throws DAOException;
    
    boolean existsPassword(String login, String password) throws DAOException;
    
    
    List<Integer> getOrganizationIds(User user);
    
    List<String> getUserInterfaceIds(User user);
    
    
    List<Integer> sysGetOrganizationIds(User user);
    
    List<String> sysGetUserInterfaceIds(User user);

    
}
