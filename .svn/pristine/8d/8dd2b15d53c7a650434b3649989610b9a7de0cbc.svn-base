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

import org.plazmaforge.framework.config.object.IConfigIdentifierHolder;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;


/** 
 * @author Oleh Hapon
 *
 */

public interface IFormObject extends IConfigIdentifierHolder {
    
    void init() throws ApplicationException;
    
    
    void initActions() throws ApplicationException;
    
    void initMenuBar() throws ApplicationException;
    
    void initToolBar() throws ApplicationException;
    

    /**
     * Create entity in data source
     * @throws ApplicationException
     */
    void doCreateEntity() throws ApplicationException;
    
    /**
     * Load entity from data source
     * @throws ApplicationException
     */
    void doLoadEntity() throws ApplicationException;
    
    /**
     * Store entity to data source
     * @throws ApplicationException
     */
    void doStoreEntity() throws ApplicationException;
    
    
    /**
     * Create data in data source.
     * If data is one entity then <code>doCreateData()</code> method uses <code>doCreateEntity()</code>
     * @throws ApplicationException
     */
    void doCreateData() throws ApplicationException;

    /**
     * Load data from data source.
     * If data is one entity then <code>doLoadData()</code> uses <code>doLoadEntity()</code>
     * @throws ApplicationException
     */
    void doLoadData() throws ApplicationException;
    
    /**
     * Store data to data source.
     * If data is one entity then <code>doStoreData()</code> method uses <code>doStoreEntity()</code>
     * @throws ApplicationException
     */
    void doStoreData() throws ApplicationException;

     
    void updateForm() throws ApplicationException;
    
    void updateEntity() throws ApplicationException;    
    
    void updateData() throws ApplicationException;
 
    
    void executeAction(String actionIdentificator) throws ApplicationException;
    
    
    void doHelpAction() throws ApplicationException;
    
    void doExitAction() throws ApplicationException;
    
    void doSetupAction() throws ApplicationException;
    
    void doPrintAction() throws ApplicationException;
    
    
    
    Association getAssociation();
    
}
