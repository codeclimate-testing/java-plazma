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
 * Created on 17.10.2004
 *
 */
package org.plazmaforge.framework.client.swing.forms;

import java.awt.Window;
import java.util.Map;
import java.util.HashMap;


import org.apache.log4j.Logger;

/**
 * @author Oleh Hapon $Id: FORMBaseFactory.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class FORMBaseFactory implements IFORMFactory {

    private static final Logger logger = Logger.getLogger(FORMBaseFactory.class);

    private static final String CREATE_FORM_MESSAGE_ERROR = "Create form error";

    private Map formMap = new HashMap();

    public Form getFORM(Class klass, Window window) {
	try {
	    Object obj = formMap.get(klass);
	    if (obj != null) {
		return (Form) obj;
	    } else {
		Form form = (Form) klass.newInstance();
		if (window != null) {
		    form.initWindow(window);
		}
		return form;
	    }
	} catch (IllegalAccessException e) {
	    logger.error(CREATE_FORM_MESSAGE_ERROR, e);
	    // throw new BIZFinderException(e);
	} catch (InstantiationException e) {
	    logger.error(CREATE_FORM_MESSAGE_ERROR, e);
	    // throw new BIZFinderException(e);
	}
	return null;
    }

    public Form getFORM(Class klass) {
	return getFORM(klass, null);
    }

    public EditForm getEDIT(Class klass) {
	return (EditForm) getFORM(klass);
    }

    public EditForm getEDIT(Class klass, Window window) {
	return (EditForm) getFORM(klass, window);
    }

    public ListForm getLIST(Class klass) {
	return (ListForm) getFORM(klass);
    }

    public ListForm getLIST(Class klass, Window window) {
	return (ListForm) getFORM(klass, window);
    }

    public ListForm getLIST(Class klass, Window window, int listableMode) {
	ListForm form = (ListForm) getFORM(klass, window);
	form.initListableMode(listableMode);
	return form;
    }

    public Window getShellWindow() {
	return null;
    }
}
