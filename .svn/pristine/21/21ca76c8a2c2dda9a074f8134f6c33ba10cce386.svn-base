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
 * Created on 19.02.2009
 *
 */

package org.plazmaforge.bsolution.employee.server.services;

import java.util.Map;

import org.plazmaforge.bsolution.personality.server.services.PersonUtils;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeUtils.java,v 1.3 2010/04/28 06:24:22 ohapon Exp $
 */

public class EmployeeUtils {

    // EMPLOYEE
    
    public static void populateEmployeeHibernateAliasMap(Map<String, String> map) {
	map.put("person", "prs");
    }
    
    public static void populateEmployeeHibernatePropertyMap(Map<String, String> map) {
	map.put("firstName", "prs.firstName");
	map.put("middleName", "prs.middleName");
	map.put("lastName", "prs.lastName");
    }
    
    // EMPLOYEE DOCUMENT 
    
    public static void populateEmployeeDocumentHibernateAliasMap(Map<String, String> map) {
	map.put("employee", "emp");
	map.put("emp.person", "prs");
    }
    
    public static void populateEmployeeDocumentHibernatePropertyMap(Map<String, String> map) {
	map.put("employeeName", "prs." + PersonUtils.getFullNameProperty());
    }

}
