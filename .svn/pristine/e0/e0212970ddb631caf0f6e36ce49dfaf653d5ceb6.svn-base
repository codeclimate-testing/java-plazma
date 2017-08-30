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
 * Created on 08.01.2005
 *
 */
package org.plazmaforge.framework.core;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;

/**
 * @author Oleh Hapon
 * $Id: AbstractAcceptor.java,v 1.1 2010/12/05 07:51:25 ohapon Exp $
 */
public abstract class AbstractAcceptor implements IAcceptor {

    private Map<String, Object> parameters;

    public Map<String, Object> getParameters() {
	if (parameters == null) {
	    parameters = new HashMap<String, Object>();
	}
        return parameters;
    }
    
    public void prepareData(Map parameters) throws ApplicationException {
	
    }
    
    ////
    
    public boolean isEmpty(List list) {
	return list == null || list.isEmpty();
    }
    
    public boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
   


}
