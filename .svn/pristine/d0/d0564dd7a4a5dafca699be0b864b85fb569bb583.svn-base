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

package org.plazmaforge.bsolution.organization.common.services;


import java.io.Serializable;

import org.plazmaforge.bsolution.organization.common.beans.IWarehouse;
import org.plazmaforge.framework.core.exception.DAOException;


/**
 * @author Oleh Hapon
 * Date: 11.12.2004
 * Time: 17:27:52
 * $Id: WarehouseService.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 * 
 * The <code>WarehouseService</code>
 * This service manage <code>IWarehouse</code> entities
 */
public interface WarehouseService<E, PK extends Serializable> extends StructurableService<E, PK> {
	
    IWarehouse findByOwnerId(Integer ownerId) throws DAOException;

}
