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
 * Created on 02.04.2008
 *
 */

package org.plazmaforge.framework.security;

import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: SecureManager.java,v 1.5 2010/12/05 07:51:23 ohapon Exp $
 */

public interface SecureManager {
    
    
    /** Object type constants **/
    String ENTITY = "ENTITY";
    
    String SERVICE = "SERVICE";
    
    String ACTION = "ACTION";
    
    String FORM = "FORM";
    
    String REPORT = "REPORT";
    
    
    
    void checkReadPermission(String secureObjectId, String  objectType) throws ApplicationException;

    void checkWritePermission(String secureObjectId, String  objectType) throws ApplicationException;
    
    void checkExecPermission(String secureObjectId, String  objectType) throws ApplicationException;
	
	
	

    void checkSecureObject(Class objectClass) throws ApplicationException;
    
    
    void checkReadPermission(Class objectClass) throws ApplicationException;
    
    void checkWritePermission(Class objectClass) throws ApplicationException;

    void checkExecPermission(Class objectClass) throws ApplicationException;
	
}
