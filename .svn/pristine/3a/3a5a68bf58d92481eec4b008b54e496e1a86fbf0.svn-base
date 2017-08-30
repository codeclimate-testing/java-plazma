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
 * Created on 17.07.2008
 *
 */

package org.plazmaforge.framework.client.swt.app;

import javax.swing.Action;
import javax.swing.ImageIcon;

import org.eclipse.swt.graphics.Image;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.util.StringUtils;

/** 
 * @author Oleh Hapon
 * $Id: SWTActionHelper.java,v 1.3 2010/04/28 06:36:48 ohapon Exp $
 */

public class SWTActionHelper {

    
    /**
     * Returns the action object of action
     * @param action
     * @return
     */
    public Object getActionObject(IAction action) {
	if (action.getOriginal() == null) {
	    return action;
	}
        if (action.getOriginal() instanceof Action) {
            return (Action) action.getOriginal();
        }
        return null;
    }
    
    
    /**
     * Returns the name of Swing action
     * @param action
     * @return name
     */
    public String getActionText(Action action) {
        return (String) action.getValue(Action.NAME);
    }
    
    /**
     * Returns the name of action
     * @param action
     * @return
     */
    public String getActionText(IAction action) {
        return action.getText();
    }    
    
    /**
     * Get SWT image from Swing action 
     * @param action
     * @return
     */
    public Image getActionImage(Action action){
	ImageIcon icon = (ImageIcon) action.getValue(Action.SMALL_ICON);
	if (icon == null) {
	    return null;
	}
       	String path = icon.toString();
       	int index = path.indexOf("!");       	 //$NON-NLS-1$
       	if (index > -1) {
       	    path = path.substring(index + 1);
       	}
       	return getImage(path);
    }
    
    /**
     * Get SWT image from IAction
     */
    public Image getActionImage(IAction action) {
	String path = action.getImageUrl();
	if (isEmpty(path)) {
	    return null;
	}
	return getImage(path);
    }
    
    public boolean isEmpty(String str) {
	return StringUtils.isEmpty(str); 
    }
    
    public Image getImage(String path) {
	return SWTResourceManager.getImage(this.getClass(), path);
    }
}
