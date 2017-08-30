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
 * Created on 16.03.2005
 *
 */
package org.plazmaforge.bsolution.employee.common.beans;

import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.organization.common.beans.OrganizableDictionary;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;



/**
 * @author hapon
 *
 */
public class EmployeeHeader extends OrganizableDictionary {
    
    private String code;
    
    private PersonHeader person;
    
    private Department department;
    
    private JobPosition position;    
   
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    
    public PersonHeader getPerson() {
        return person;
    }
    
    public void setPerson(PersonHeader person) {
        this.person = person;
    }
    
    public Integer getPersonId() {
    	return getPerson() == null ? null : getPerson().getId();
    }
    
    public String getFirstName() {
        return getPerson() == null ? null : getPerson().getFirstName();
    }
    
    public String getLastName() {
        return getPerson() == null ? null : getPerson().getLastName();
    }
    
    public String getMiddleName() {
        return getPerson() == null ? null : getPerson().getMiddleName();
    }
    
    public String getFullName() {
        return getPerson() == null ? null : getPerson().getFullName();
    }
    
    public String getDepartmentName() {
        return getDepartment() == null ? null : getDepartment().getName();  
    }
	
    public String getName() {
        return getFullName();
    }
    
    
    public JobPosition getPosition() {
        return position;
    }

    public String getPositionName() {
        return position == null ? null : position.getName();
    }
    
    public void setPosition(JobPosition position) {
        this.position = position;
    }
    
}
