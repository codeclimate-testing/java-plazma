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

package org.plazmaforge.bsolution.employee.common.services;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.RemoveException;
import org.plazmaforge.framework.ext.service.EntityService;



/**
 * Employable Service
 * Use Employ ID and Period ID
 * 
 * @author hapon
 *
 */
public interface EmployableService<E, PK extends Serializable> extends EntityService<E, PK> {
	
	
    void removeByEmployee(Integer employeeId) throws DAOException, RemoveException;
    
    void removeByEmployeeAndPeriod(Integer employeeId, Integer periodId) throws DAOException, RemoveException;
    
    
    
    List findByEmployee(Integer employeeId) throws DAOException;
    
    List findByEmployee(Integer employeeId, Criteria criteria) throws DAOException;
    
    
    ////
	
    List findByEmployeeAndPeriod(Integer employeeId, Integer periodId) throws DAOException;

    List findByEmployeeAndPeriod(Integer employeeId, Integer periodId, Criteria criteria) throws DAOException;
	

}
