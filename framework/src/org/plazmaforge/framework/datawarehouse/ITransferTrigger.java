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

package org.plazmaforge.framework.datawarehouse;

import java.sql.Connection;
import java.sql.SQLException;

import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * Trigger for Row transfer
 *  
 * @author ohapon
 *
 */
public interface ITransferTrigger {

    void init() throws ApplicationException, SQLException;
    
    void dispose() throws ApplicationException, SQLException;
    
    Connection getConnection();

    void setConnection(Connection connection);
    
    void doBeforeInsert(TransferEvent event) throws ApplicationException, SQLException;
    
    void doAfterInsert(TransferEvent event) throws ApplicationException, SQLException;
    
    void doBeforeUpdate(TransferEvent event) throws ApplicationException, SQLException;
    
    void doAfterUpdate(TransferEvent event) throws ApplicationException, SQLException;
    
    void doBeforeDelete(TransferEvent event) throws ApplicationException, SQLException;
    
    void doAfterDelete(TransferEvent event) throws ApplicationException, SQLException;
    
}
