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
 * Created on 01.08.2005
 *
 */
package org.plazmaforge.framework.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleh Hapon
 * 
 */
public class DefaultUser implements IUser {

    private String login;

    private String password;

    private Map roles = new HashMap();

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void addRole(IRole role) {
	roles.put(role.getRoleName(), role);
    }

    public boolean isRole(String roleName) {
	IRole role = getRole(roleName);
	return role == null ? false : true;
    }

    public IRole getRole(String roleName) {
	return (IRole) roles.get(roleName);
    }

    public Collection getRoles() {
	return roles.values();
    }

}
