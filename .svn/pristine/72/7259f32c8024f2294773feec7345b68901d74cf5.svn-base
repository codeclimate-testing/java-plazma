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
 * Created on 18.10.2009
 *
 */

package org.plazmaforge.framework.action;

import java.util.List;
import java.util.StringTokenizer;

import org.plazmaforge.framework.util.StringUtils;

/** 
 * @author Oleh Hapon
 * $Id: ActionUtils.java,v 1.2 2010/04/28 06:34:37 ohapon Exp $
 */

public class ActionUtils {

    
    public static void addParametersFromString(IAction action, String parameters, String delim) {
	if (parameters == null) {
	    return;
	}
	    
	StringTokenizer tokenizer = new StringTokenizer(parameters, delim);
	while (tokenizer.hasMoreTokens()) {
	    String token = tokenizer.nextToken();
	    if (isEmpty(token)) {
		continue;
	    }
	    action.addParameter(token);
	}
    }
    
    public static void addParametersFromString(IAction action, String parameters) {
	addParametersFromString(action, parameters, IAction.PARAMETERS_DELIM);
    }
    
    public static String getParametersString(IAction action, String delim) {
	if (action == null) {
	    return null;
	}
	List<String> parameterList = action.getParameters();
	if (parameterList == null || parameterList.isEmpty()) {
	    return null;
	}
	int size = parameterList.size();
	StringBuffer buf = new StringBuffer();
	for (int k = 0; k < size; k++) {
	    if (k != 0) {
		buf.append(delim);
	    }
	    buf.append(parameterList.get(k));
	}
	return buf.toString();
    }
    
    public static String getParametersString(IAction action) {
	return getParametersString(action, IAction.PARAMETERS_DELIM);
    }
    
    private static boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
  
}
