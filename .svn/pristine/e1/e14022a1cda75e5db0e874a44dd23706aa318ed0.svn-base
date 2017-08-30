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
package org.plazmaforge.bsolution.base.common.services;

import org.plazmaforge.bsolution.base.common.beans.SystemInfo;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.ContextService;
import org.plazmaforge.framework.ext.service.EntityService;



/**
 * @author Oleh Hapon
 * Date: 04.09.2004
 * Time: 10:17:25
 * $Id: SystemInfoService.java,v 1.6 2010/12/05 07:55:56 ohapon Exp $
 */
public interface SystemInfoService extends ContextService, EntityService<SystemInfo, Integer> {
	
    SystemInfo load() throws DAOException, FinderException;
    
    
    void initSystem() throws ApplicationException;
    
    void reinitSystem() throws ApplicationException;

    void checkSystem() throws ApplicationException;
    
    
    void checkSecureSystem() throws ApplicationException;
    
    void syncSecureSystem() throws ApplicationException;
    
    
}
