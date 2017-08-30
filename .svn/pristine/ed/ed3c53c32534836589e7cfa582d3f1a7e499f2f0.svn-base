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
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.security.SecureEnvironment;
import org.plazmaforge.framework.security.SecureManager;



/** 
 * @author Oleh Hapon
 *
 */

public class Toolkit {
    
 
    
    
    public static void openListForm(Object parent, String formName) throws ApplicationException {
	openListForm(parent, getFormClass(formName));
    }

    public static void openEditForm(Object parent, String formName) throws ApplicationException {
	openEditForm(parent, getFormClass(formName));
    }
    
    public static void openForm(Object parent, String formName, int type) throws ApplicationException {
	openForm(parent, getFormClass(formName), type);
    }
    
     
    public static IForm getForm(Object parent, String formName, int type) throws ApplicationException {
	return getForm(parent, getFormClass(formName), type);
    }    
    
    
    
    
    
    public static void openListForm(Object parent, Class formClass) throws ApplicationException {
	openListForm(parent, formClass, isDefaultModal(PWT.LIST_FORM));
    }
    
    public static void openListForm(Object parent, Class formClass, boolean isModal) throws ApplicationException {
	openForm(parent, formClass, PWT.LIST_FORM, isModal);
    }

    
    
    
    public static void openEditForm(Object parent, Class formClass) throws ApplicationException {
	openEditForm(parent, formClass, isDefaultModal(PWT.EDIT_FORM));
    }
    
    public static void openEditForm(Object parent, Class formClass, boolean isModal) throws ApplicationException {
	openForm(parent, formClass, PWT.EDIT_FORM, isModal);
    }
    
    
    
    public static void openForm(Object parent, Class formClass, int type) throws ApplicationException {
	openForm(parent, formClass, type, isDefaultModal(type));
    }
    
    public static void openForm(Object parent, Class formClass, int type, boolean isModal) throws ApplicationException {
	IForm form = getForm(parent, formClass, type, isModal);
	if (form == null) {
	    return;
	}
	openForm(parent, form);
    }
    
    public static void openForm(Object parent, IForm form) throws ApplicationException {
	getToolkitManager().openForm(parent, form);
    }
   
    public static IForm getForm(Object parent, Class formClass, int type) throws ApplicationException {
	return getForm(parent, formClass, type, isDefaultModal(type));
    }
    
    public static IForm getForm(Object parent, Class formClass, int type, boolean isModal) throws ApplicationException {
	
	// FORM TYPE
	if (type != PWT.FORM && type != PWT.LIST_FORM && type != PWT.EDIT_FORM) {
	    throw new ApplicationException("Form type must be PWT.FORM or PWT.LIST_FORM or PWT.EDIT_FORM");
	}
	
	// FORM CLASS
	if (formClass == null) {
	    throw new ApplicationException("Form class is empty");
	}
	
	// FORM FACTORY
	IFormFactory formFactory = Environment.getFormFactory();
	if (formFactory == null) {
	    throw new ApplicationException("Form factory is empty");
	}
	
	// FORM DECORATOR
	IFormDecorator decorator = getToolkitManager().createFormDecorator(parent, type, isModal);
	if (decorator == null) {
	    throw new ApplicationException("Form decorator is empty");
	}
	
	// FORM
	IForm form = formFactory.getForm(formClass, decorator);
	if (form == null) {
	    throw new ApplicationException("Form ["+ formClass + "] not found");
	}
	return form;
    }
    
    
    // LIST FORM
    
    public static IListForm getListForm(Object parent, Class formClass) throws ApplicationException {
	return getListForm(parent, formClass, isDefaultModal(PWT.LIST_FORM));
    }
    
    public static IListForm getListForm(Object parent, Class formClass, boolean isModal) throws ApplicationException {
	return (IListForm) getForm(parent, formClass, PWT.LIST_FORM, isModal);
    }
    
    
    
    
    
    // EDIT FORM
    
    public static IEditForm getEditForm(Object parent, Class formClass) throws ApplicationException {
	return getEditForm(parent, formClass, isDefaultModal(PWT.EDIT_FORM));
    }
    
    public static IEditForm getEditForm(Object parent, Class formClass, boolean isModal) throws ApplicationException {
	return (IEditForm) getForm(parent, formClass, PWT.EDIT_FORM, isModal);
    }    
    
    public static Class getFormClass(String formName) {
	IFormFactory formFactory = Environment.getFormFactory();
	if (formFactory == null) {
	    return null;
	}
	return formFactory.getFormClass(formName);
    }
    
    
    /**
     * Returns default modal flag by form type
     * @param formType
     * @return
     */
    protected static boolean isDefaultModal(int formType) {
	return (formType == PWT.EDIT_FORM);
    }
    
    
    
    
    
    
    
    
    
    public static void run(IAction action, EventObject event) {
	getToolkitManager().run(action, event);
    }

    
    public static void run(Action action, EventObject event) {
	getToolkitManager().run(action, event);
    }
    
    
    public static void openErrorDialog(String title, Throwable e) {
	getToolkitManager().openErrorDialog(title, e);
    }
    
    
    public static void openErrorDialog(String title, String message) {
	getToolkitManager().openErrorDialog(title, message);
    }
    
    public static void openErrorDialog(Throwable e) {
	getToolkitManager().openErrorDialog(e);
    }
    
    public static void openApplicationErrorDialog(Throwable e) {
	getToolkitManager().openApplicationErrorDialog(e);
    }

    public static void openSystemErrorDialog(Throwable e) {
	getToolkitManager().openSystemErrorDialog(e);
    }

    
    public static void openMessageDialog(String title, String message) {
	getToolkitManager().openMessageDialog(title, message);
    }
    
    public static boolean openConfirmYesNoDialog(String title, String message) {
	return getToolkitManager().openConfirmYesNoDialog(title, message);
    }

    
    private static IToolkitManager getToolkitManager() {
	return Environment.getToolkitManager();
    }
    
    private static IEntityManager getEntityManager() {
	return Environment.getEntityManager();
    }    

    public static boolean isUseListForm(Class formClass) {
	return isUseListForm(formClass, null);
    }
    
    public static boolean isUseListForm(Class formClass, Serializable identifier) {
	return Environment.getToolkitManager().isUseListForm(formClass, identifier);
    }
    
    public static boolean activeListForm(Class formClass) {
	return activeListForm(formClass, null);
    }
    
    public static boolean activeListForm(Class formClass, Serializable identifier) {
	return Environment.getToolkitManager().activeListForm(formClass, identifier);
    }
    
    public static void closeAllForms() {
	getToolkitManager().closeAllForms();
    }
    
    public static List<IEntityConfig> getEntityConfigListByType(String type) {
	IEntityManager entityManager = getEntityManager();
	if (entityManager == null) {
	    return null;
	}
	return entityManager.getEntityConfigListByType(type);
    }
    
    public static List<IEntityConfig> getEntityConfigListByTypeAndForm(String type) {
	IEntityManager entityManager = getEntityManager();
	if (entityManager == null) {
	    return null;
	}
	return entityManager.getEntityConfigListByTypeAndForm(type);
    }
    
    public static Class getSelectedFormClass(List<IEntityConfig> entities, Class baseClass) throws ApplicationException  {
	return getToolkitManager().getSelectedFormClass(entities, baseClass);
    }

    public static FormClassContext getSelectedFormClassContext(List<IEntityConfig> entities, Class baseClass) throws ApplicationException  {
	return getToolkitManager().getSelectedFormClassContext(entities, baseClass);
    }

    public static Class getSelectedFormClass(String type, Class baseClass) throws ApplicationException  {
	FormClassContext context = getSelectedFormClassContext(type, baseClass);
	if (context == null) {
	    return null;
	}
	return context.getFormClass();
    }

    public static FormClassContext getSelectedFormClassContext(String type, Class baseClass) throws ApplicationException  {
	if (type == null || baseClass == null) {
	    return null;
	}	
	List<IEntityConfig> entities = getEntityConfigListByTypeAndForm(type);
	if (entities == null) {
	    return null;
	}
	return getSelectedFormClassContext(entities, baseClass);
    }

    
    public static void newFormByType(String type) throws ApplicationException  {
	if (type == null) {
	    return;
	}
	Class formClass = getSelectedFormClass(type, IEditForm.class);
	if (formClass == null) {
	    return;
	}
	IForm form = Toolkit.getForm(null, formClass, PWT.EDIT_FORM);
	if (form == null) {
	    return;
	}
	form.setMode(PWT.ADD_MODE);
	Toolkit.openForm(null, form);
    }
    
    public static void chooseFormByType(String type) throws ApplicationException  {
	if (type == null) {
	    return;
	}
	Class formClass = getSelectedFormClass(type, IListForm.class);
	if (formClass == null) {
	    return;
	}
	Toolkit.openListForm(null, formClass);
    }
    
    public static void checkSecureForm(Class formClass) throws ApplicationException {
	checkReadPermission(formClass);
    }
    
    public static void checkReadPermission(Class objectClass) throws ApplicationException {
	SecureManager secureManager = SecureEnvironment.getSecureManager();
	if (secureManager == null) {
	    return;
	}
	secureManager.checkSecureObject(objectClass);
    }
    
}
