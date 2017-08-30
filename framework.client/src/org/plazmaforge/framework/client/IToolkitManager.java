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

package org.plazmaforge.framework.client;

import java.io.Serializable;
import java.util.EventObject;
import java.util.List;

import javax.swing.Action;

import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.client.forms.FormClassContext;
import org.plazmaforge.framework.client.forms.IEditFormDecorator;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IListFormDecorator;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 *  $Id: IToolkitManager.java,v 1.4 2010/12/05 07:51:56 ohapon Exp $
 *
 */

public interface IToolkitManager {
    
    void init();
    
    
    IFormDecorator createFormDecorator(Object parent, int type) throws ApplicationException;
    
    IFormDecorator createFormDecorator(Object parent, int type, boolean isModal) throws ApplicationException;    
    
    
    IListFormDecorator createListFormDecorator() throws ApplicationException;
    
    IListFormDecorator createListFormDecorator(Object parent) throws ApplicationException;
    
    IListFormDecorator createListFormDecorator(Object parent, boolean isModal) throws ApplicationException;  
    
    

    
    IEditFormDecorator createEditFormDecorator() throws ApplicationException;
    
    IEditFormDecorator createEditFormDecorator(Object parent) throws ApplicationException;
    
    IEditFormDecorator createEditFormDecorator(Object parent, boolean isModal) throws ApplicationException;    
    

    void openDecorator(Object parent, IFormDecorator decorator) throws ApplicationException;
    
    void openForm(Object parent, IForm form) throws ApplicationException;
    
    
    
    void run(IAction action, EventObject event);

    void run(Action action, EventObject event);
    
    
    void openErrorDialog(String title, Throwable e);
    
    void openErrorDialog(String title, String message);
    
    void openErrorDialog(Throwable e);
    
    void openApplicationErrorDialog(Throwable e);

    void openSystemErrorDialog(Throwable e);
    
    void openMessageDialog(String title, String message);
    
    
    
    boolean openConfirmYesNoDialog(String title, String message);
    
    
    boolean isUseListForm(Class formClass);
    
    boolean isUseListForm(Class formClass, Serializable identifier);
    
    
    boolean activeListForm(Class formClass);
    
    boolean activeListForm(Class formClass, Serializable identifier);
    
    
    void closeAllForms();
    
    Class getSelectedFormClass(List<IEntityConfig> entities, Class baseClass) throws ApplicationException;
    
    FormClassContext getSelectedFormClassContext(List<IEntityConfig> entities, Class baseClass)  throws ApplicationException;
}
