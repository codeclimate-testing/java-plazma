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
 * Created on 07.11.2004
 *
 */


package org.plazmaforge.framework.client.swing;

import java.util.List;

import javax.swing.JOptionPane;

import org.plazmaforge.framework.client.swing.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.forms.EditableMode;
import org.plazmaforge.framework.client.swing.forms.FormUtilities;
import org.plazmaforge.framework.client.swing.forms.ListForm;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;


/**
 * @author Oleh Hapon
 *
 * $Id: SwingFormManager.java,v 1.4 2010/12/05 07:52:09 ohapon Exp $
 */


public class SwingFormManager {

    private static SwingFormManager ourInstance;

    public synchronized static SwingFormManager getInstance() {
	if (ourInstance == null) {
	    ourInstance = new SwingFormManager();
	}
	return ourInstance;
    }

    private SwingFormManager() {
    }

    public static void closeAllForm() {
	FormUtilities.closeAllForm(SwingEnvironment.getDesktopPane());
    }

    public static void showListForm(Class classListForm) throws ApplicationException {
	FormUtilities.showListForm(SwingEnvironment.getDesktopPane(),
		classListForm);
    }

    public static void showSelectedListForm(List entities) throws ApplicationException {
	Class klass = getSelectedFormClass(entities, ListForm.class);
	if (klass == null) {
	    return;
	}
	showListForm(klass);
    }

    public static Class getSelectedFormClass(List entities, Class baseClass) throws ApplicationException {
	ChooseDialog dialog = new ChooseDialog(null, entities);
	if (dialog.showDialog() != JOptionPane.OK_OPTION) {
	    return null;
	}
	IEntityConfig entityConfig = (IEntityConfig) dialog.getSelectedValue();
	Association association = AssociationManager.getAssociationByEntity(entityConfig);
	if (association == null) {
	    return null;
	}
	return association.getElementByType(baseClass);
    }

    public static EditForm showEditFormByAddMode(Class classEditForm, Object data) throws ApplicationException {
	return FormUtilities.showEditFormByAddMode(classEditForm, data);
    }

    public static EditForm showEditFormByEditMode(Class classEditForm, Object data) throws ApplicationException {
	return FormUtilities.showEditFormByEditMode(classEditForm, data);
    }

    public static EditForm showEditForm(Class classEditForm, Object data, int mode) throws ApplicationException {
	return FormUtilities.showEditForm(classEditForm, data, mode);
    }

    public static void showSelectedEditForm(List entities, Object data, int mode) throws ApplicationException {
	Class klass = getSelectedFormClass(entities, EditForm.class);
	if (klass == null) {
	    return;
	}
	showEditForm(klass, data, mode);
    }

    public static void showSelectedEditFormByAddMode(List entities, Object data) throws ApplicationException {
	showSelectedEditForm(entities, data, EditableMode.ADD);
    }

    public static void showSelectedEditFormByEditMode(List entities, Object data) throws ApplicationException {
	showSelectedEditForm(entities, data, EditableMode.EDIT);
    }
	
	
}

