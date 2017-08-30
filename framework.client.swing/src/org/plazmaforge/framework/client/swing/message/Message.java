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


/**
 * @author Oleh Hapon
 * Date: 09.11.2004
 * Time: 19:19:38
 * $Id: Message.java,v 1.3 2010/04/28 06:36:13 ohapon Exp $
 */
package org.plazmaforge.framework.client.swing.message;


import javax.swing.*;

import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.resources.Resources;
import org.plazmaforge.framework.util.StringUtils;


import java.awt.*;
import java.lang.reflect.UndeclaredThrowableException;

public class Message {

    private static Message ourInstance;
    private static Resources resources;

    static {
        resources = LibraryResources.getInstance();
    }

    public synchronized static Message getInstance() {
        if (ourInstance == null) {
            ourInstance = new Message();
        }
        return ourInstance;
    }

    private Message() {
    }

    public static int confirm(Component parentComponent, Object message) {
        return JOptionPane.showConfirmDialog(parentComponent, message);
    }

    public static int confirm(Component parentComponent, Object message, String title, int optionType) {
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType);
    }

    public static int confirm(Component parentComponent, Object message, String title, int optionType, int messageType) {
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType);
    }

    public static int confirm(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon) {
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon);
    }

    public static int confirmYesNo(Component parentComponent, Object message) {
        return JOptionPane.showConfirmDialog(parentComponent, message, getString("message.question"), JOptionPane.YES_NO_OPTION);
    }

    public static void error(Component parentComponent, Object message, String title) {
        JOptionPane.showMessageDialog(parentComponent, StringUtils.textErrorFormat(message), title, JOptionPane.ERROR_MESSAGE);
    }

    
    
    public static void applicationError(Component parentComponent, Throwable exception) {
	applicationError(parentComponent, getMessage(exception));
    }
	
    public static void applicationError(Component parentComponent, Object message) {
        JOptionPane.showMessageDialog(parentComponent, StringUtils.textErrorFormat(message), "Application Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    public static void systemError(Component parentComponent, Throwable exception) {
	systemError(parentComponent, getMessage(exception));
    }

    public static void systemError(Component parentComponent, Object message) {
        JOptionPane.showMessageDialog(parentComponent, StringUtils.textErrorFormat(message), "PlatformSystem Error", JOptionPane.ERROR_MESSAGE);
    }

    private static String getString(String key) {
        return resources.getString(key);
    }
    
    private static String getMessage(Throwable ex) {
	Throwable cause = getCause(ex);
	if (cause == null || ex == cause) {
	    return ex.getMessage();
	}
	return cause.getMessage(); 
    }
    
    private static Throwable getCause(Throwable ex) {
	if (ex instanceof UndeclaredThrowableException) {
	    return ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
	}
	Throwable cause = ex.getCause();
	if (cause instanceof UndeclaredThrowableException) {
	    return ((UndeclaredThrowableException) cause).getUndeclaredThrowable();
	}
	return ex;
    }
}

