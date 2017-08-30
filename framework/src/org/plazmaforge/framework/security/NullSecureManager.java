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
 * Created on 14.05.2009
 *
 */

package org.plazmaforge.framework.security;

import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: NullSecureManager.java,v 1.5 2010/12/05 07:51:23 ohapon Exp $
 */

public class NullSecureManager extends AbstractSecureManager implements SecureManager {

    public void checkReadPermission(String secureObjectId, String objectType)  throws ApplicationException {
	
    }

    public void checkWritePermission(String secureObjectId, String objectType) throws ApplicationException {
	
    }

    public void checkExecPermission(String secureObjectId, String objectType)  throws ApplicationException {
	
    }
    
    protected String getSecureObjectId(Class objectClass) {
	return null;
    }

}