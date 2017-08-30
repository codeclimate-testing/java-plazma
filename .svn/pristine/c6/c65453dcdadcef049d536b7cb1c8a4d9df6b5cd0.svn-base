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

package org.plazmaforge.framework.util;

import java.lang.reflect.InvocationTargetException;

import org.plazmaforge.framework.core.exception.ApplicationException;

public class ErrorUtils {

    public static Throwable getCause(Throwable t) {
	if (t == null) {
	    return null;
	}
	
	if (t instanceof ApplicationException) {
	    return privateGetApplicationExceptionCause(t);
	}

	if (t instanceof InvocationTargetException) {
	    return privateGetCause(t);
	}

	Throwable cause = privateGetCause(t);
	if (cause instanceof ApplicationException) {
	    cause = privateGetApplicationExceptionCause(cause); 
	}

	return cause;
    }

    private static Throwable privateGetCause(Throwable t) {
	if (t == null) {
	    return null;
	}
	if (t.getCause() != null) {
	    return t.getCause();
	}
	return t;
    }

    private static Throwable privateGetApplicationExceptionCause(Throwable t) {
	if (t == null) {
	    return null;
	}
	
	
	
	Throwable cause = t.getCause();
	if (cause == null) {
	    return t;
	}

	if (cause instanceof InvocationTargetException) {
	    return privateGetCause(cause);
	}
	return cause;	
    }

    
    public static String getMessage(Throwable ex) {
	if (ex == null) {
	    return "";
	}
	Throwable cause = getCause(ex);
	String message = cause.getMessage();
	if (message == null) {
	    message = cause.toString();
	}
	return message;
    }

}
