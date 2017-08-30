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

package org.plazmaforge.framework.client.forms;

import java.util.List;

import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 *
 */

public interface IListFormController extends IFormController {
    
    
    void doRemoveEntity() throws ApplicationException;
    
    void doFindEntity() throws ApplicationException;

    
    void doLoadRow() throws ApplicationException;
    
    void doRemoveRow() throws ApplicationException;  
    
    
    void doRefreshAction() throws ApplicationException;
    
    void doChooseAction() throws ApplicationException;
    
    void doAddAction() throws ApplicationException;    
    
    void doDelAction() throws ApplicationException;
    
    void doEditAction() throws ApplicationException;
    
    void doAddCycleAction() throws ApplicationException;
    
    void doPrintAction() throws ApplicationException;
    
    void doSortAction() throws ApplicationException;
    
    void doFindAction() throws ApplicationException;
    
    void doFilterAction() throws ApplicationException; 
    
    
    
    List loadDataList() throws ApplicationException;
    
    List loadDataList(ICriteria criteria) throws ApplicationException;

}
