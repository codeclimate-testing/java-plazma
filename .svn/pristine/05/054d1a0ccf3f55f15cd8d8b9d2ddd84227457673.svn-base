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

package org.plazmaforge.framework.client.swt;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.EventObject;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.Action;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.layout.FillLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.action.ActionProcessor;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.client.IToolkitManager;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.FormClassContext;
import org.plazmaforge.framework.client.forms.IEditFormDecorator;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.forms.IListFormDecorator;
import org.plazmaforge.framework.client.swt.custom.ishell.DesktopForm;
import org.plazmaforge.framework.client.swt.custom.ishell.InternalShell;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swt.forms.ISWTFormManager;
import org.plazmaforge.framework.client.swt.forms.ISWTInnerFrameCreator;
import org.plazmaforge.framework.client.swt.forms.ISWTShellPresentation;
import org.plazmaforge.framework.client.swt.forms.SWTEditFormDecorator;
import org.plazmaforge.framework.client.swt.forms.SWTFormDecorator;
import org.plazmaforge.framework.client.swt.forms.SWTListFormDecorator;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.util.ErrorTranslator;
import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTToolkitManager implements IToolkitManager {
    
    
    protected final Log logger = LogFactory.getLog(getClass());
	
    public static final int SHELL_FRAME = 1;
    
    public static final int DECORATIONS_FRAME = 2;
    
    public static final int INNER_FRAME = 3; 
    
    
    private static int listFormFrame = INNER_FRAME;
    
    private static int editFormFrame = SHELL_FRAME; //INNER_FRAME
    
    private static ISWTInnerFrameCreator innerFrameCreator;
    
    private static ISWTShellPresentation listFormShellPresentation;
    
    private static ISWTShellPresentation editFormShellPresentation;
    
    
    private static ISWTFormManager formManager;
    
  
    
   

    public IListFormDecorator createListFormDecorator() throws ApplicationException {
	return createListFormDecorator(null);
    }
    
    public IListFormDecorator createListFormDecorator(Object parent) throws ApplicationException {
	return createListFormDecorator(parent, false);
    }
    
    public IListFormDecorator createListFormDecorator(Object parent, boolean isModal) throws ApplicationException {
	
	
	int frameType = getFrameType(isModal);

	Composite parentFrame = createParentFrame(parent, frameType, isModal);
	
	SWTListFormDecorator decorator = new SWTListFormDecorator(parentFrame);
	decorator.setModal(isModal);
	
	// Shell presentation only for INNER FRAME
	
	if (frameType == INNER_FRAME && listFormShellPresentation != null) {
	    decorator.setShellPresentation(listFormShellPresentation);
	}
	return decorator;
    }

    public IFormDecorator createFormDecorator(Object parent, boolean isModal) throws ApplicationException {
	
	
	int frameType = getFrameType(isModal);
	
	Composite parentFrame = createParentFrame(parent, frameType, isModal);
	
	SWTFormDecorator decorator = new SWTFormDecorator(parentFrame);
	decorator.setModal(isModal);
	
	// Shell presentation only for INNER FRAME
	
	if (frameType == INNER_FRAME && listFormShellPresentation != null) {
	    decorator.setShellPresentation(listFormShellPresentation);
	}
	return decorator;

    }
    
       
    private int getFrameType(boolean isModal) {
	return isModal ? editFormFrame : listFormFrame;
    }
    
    public Composite createParentFrame(Object parent, int formFrameType, boolean isModal) throws ApplicationException {
	if (parent == null) {
	    parent = SWTEnvironment.getShell();
	}
	Composite parentFrame = null;
	
	if (formFrameType == SHELL_FRAME) {
	    parentFrame = createShellFrame((Shell) parent, isModal);
	} else if (formFrameType == DECORATIONS_FRAME) {
	    parentFrame = createDecorationsFrame((Shell) parent, isModal);
	} else if (formFrameType == INNER_FRAME) {
	    
	    if (innerFrameCreator != null) {
		parentFrame = innerFrameCreator.createInnerFrame((Shell) parent, isModal);
	    } else if (SWTEnvironment.getApplication() == null) {
		parentFrame = createShellFrame((Shell) parent, isModal);
	    } else {
		    InternalShell ishell = null;
		    if (isModal) {
			
			Shell shell = new Shell((Shell) parent, SWT.NONE | SWT.APPLICATION_MODAL);
			shell.setLayout(new FillLayout());
			ishell = createInternalShell(shell, SWT.CLOSE | SWT.RESIZE, true, false);
		    } else {
			ishell = createInternalShell(SWTEnvironment.getApplication().getDesktop(), SWT.SHELL_TRIM, true, false);
		    }
		     
	            parentFrame = ishell.getContentPane();    
	    }
	    
	} else {
	    parentFrame = createDefaultFrame((Shell) parent, isModal);
	}

	parentFrame.setVisible(false); // fix 2008-09-02
	parentFrame.setLayout(new FillLayout());
	
	return parentFrame;
    }

    
    protected Shell createDefaultFrame(Shell parent, boolean isModal) {
	return createShellFrame(parent, isModal);
    }
    
    protected Shell createShellFrame(Shell parent, boolean isModal) {
	int style = SWT.SHELL_TRIM;
	if (isModal) {
		style |= SWT.APPLICATION_MODAL;
	}
	return new Shell(parent, style);
    }
    
    protected Decorations createDecorationsFrame(Shell parent, boolean isModal) {
	int style = SWT.SHELL_TRIM;
	if (isModal) {
		style |= SWT.APPLICATION_MODAL;
	}
	return new Decorations(parent, style);
    }    

    
    
    
    
    
    public IEditFormDecorator createEditFormDecorator() throws ApplicationException {
	return createEditFormDecorator(null);
    }
    
    public IEditFormDecorator createEditFormDecorator(Object parent) throws ApplicationException {
	return createEditFormDecorator(parent, true);
    }
    
    
    public IEditFormDecorator createEditFormDecorator(Object parent, boolean isModal) throws ApplicationException {
	Shell parentShell = (Shell) parent;
	if (parent == null) {
	    parentShell = SWTEnvironment.getShell();
	}
	//boolean isModal = true;
	Composite parentFrame = null;
	
	if (editFormFrame == SHELL_FRAME) {
	    parentFrame = createShellEditFrame(parentShell, isModal);
//	} else if (editFormFrame == DECORATIONS_FRAME) {
//	    parentFrame = createDecorationsEditFrame((Shell) parent, isModal);
	} else if (editFormFrame == INNER_FRAME) {
	    Shell shell = new Shell(parentShell, SWT.NONE | SWT.PRIMARY_MODAL);
	    shell.setLayout(new FillLayout());
	    InternalShell ishell = createInternalShell(shell, SWT.CLOSE | SWT.RESIZE, true, false);
	    parentFrame = ishell.getContentPane();
	} else {
	    parentFrame = createDefaultEditFrame(parentShell, isModal);
	}
	parentFrame.setLayout(new FillLayout());	
	SWTEditFormDecorator decorator = new SWTEditFormDecorator(parentFrame);
	decorator.setModal(isModal);
	return decorator;
    }
    
    protected Shell createDefaultEditFrame(Shell parent, boolean isModal) {
	return createShellEditFrame(parent, isModal);
    }
    
    protected Shell createShellEditFrame(Shell parent, boolean isModal) {
	int style = SWT.CLOSE | SWT.TITLE | SWT.MAX | SWT.RESIZE;
	if (isModal) {
            style |= SWT.APPLICATION_MODAL;
	} else {
	    style |= SWT.MIN;
	}
	return new Shell(parent, style);
    }
    
    protected Decorations createDecorationsEditFrame(Shell parent, boolean isModal) {
	int style = SWT.CLOSE | SWT.TITLE | SWT.MAX | SWT.RESIZE;
	if (isModal) {
            style |= SWT.APPLICATION_MODAL;
	} else {
	    style |= SWT.MIN;
	}
	return new Decorations(parent, style);
    }        
    
    
    public IFormDecorator createFormDecorator(Object parent, int type) throws ApplicationException  {
	boolean isMode = (type == PWT.EDIT_FORM);
	return createFormDecorator(parent, type, isMode);
    }
    
    public IFormDecorator createFormDecorator(Object parent, int type, boolean isMode) throws ApplicationException  {
	if (type != PWT.FORM && type != PWT.LIST_FORM && type != PWT.EDIT_FORM) {
	    return null;
	}
	if (type == PWT.LIST_FORM) {
	    return createListFormDecorator(parent, isMode);
	} if (type == PWT.EDIT_FORM) {
	    return createEditFormDecorator(parent, isMode);
	} else {
	    
	    //STUB
	    return createFormDecorator(parent, isMode);
	}
    }
    
    public void openForm(Object parent, IForm form) throws ApplicationException {
	if (form == null) {
	    return;
	}
	openDecorator(parent, form.getDecorator());
    }
    
    public void openDecorator(Object parent, IFormDecorator decorator) throws ApplicationException {
	if (decorator == null) {
	    return;
	}
	decorator.init();
	decorator.open();
    }
    
    public void init() {
	
	//DISABLE: 2010-05-11
	//Environment.setToolkitManager(this);
	
	// ---------------------------------------------------------------------------------------
	//
	// TODO: TEST CONTEXT INITIALIZATION
	//
	// ---------------------------------------------------------------------------------------
	
	//RCPManager clientManager = new RCPManager();
	//clientManager.initRCP();
	


    }
    

    public void run(final IAction action, final EventObject event) {
	if (action == null) {
	    return;
	}
	BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
	    public void run() {
		try {
		    processAction(action, event);
		} catch (Throwable e) {
		    logError(e);
		    openErrorDialog(e);
		}
	    }
	});
    }
    
    protected void processAction(IAction action, EventObject event) throws ApplicationException {
	ActionProcessor.execute(action);
    }
    
    
    public void run(final Action action, final EventObject event) {
	if (action == null) {
	    return;
	}
	
	BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
	    public void run() {
		try {
		    processAction(action, event);
		} catch (Throwable e){
		    logError(e);
		    openErrorDialog(e);
		}
	    }
	});
    }
    
    
    protected void processAction(Action action, EventObject event) throws ApplicationException {
	ActionEvent ae = null;
	if (event instanceof ActionEvent) {
	    ae = (ActionEvent) event;
	} else {
	    ae = new ActionEvent(event.getSource(), 0, null);
	}
	action.actionPerformed(ae);
    }
    
    
    
    private boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }

    public void openApplicationErrorDialog(Throwable e) {
	openErrorDialog("Application Error", "" + getErrorString(e));
    }

    public void openSystemErrorDialog(Throwable e) {
	openErrorDialog("System Error", "" + getErrorString(e));
    }
    
    public void openErrorDialog(String title, Throwable e) {
	openErrorDialog(title, "" + getErrorString(e));
    }
    
    public void openErrorDialog(String title, String message) {
	MessageDialog.openError(getShell(), "" + title, "" + message);
	
//	MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
//	mb.setText("" + title);
//	mb.setMessage("" + message);
//	mb.open();
    }

    public void openMessageDialog(String title, String message) {
	MessageDialog.openInformation(getShell(), "" + title, "" + message);
	
//	MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION | SWT.OK);
//	mb.setText("" + title);
//	mb.setMessage("" + message);
//	mb.open();
    }

    public boolean openConfirmYesNoDialog(String title, String message) {
	
	return MessageDialog.openQuestion(getShell(), "" + title, "" + message);
	
	//return MessageDialog.openConfirm(getShell(), "" + title, "" + message);
	
//	MessageBox mb = new MessageBox(getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
//	mb.setText((title == null ? "" : title));
//	mb.setMessage("" + message);
//	int result = mb.open();
//	return result == SWT.YES;
    }
    
    public void openErrorDialog(Throwable e) {
	if (e == null) {
	    return;
	}
	if (e instanceof ApplicationException) {
	    openApplicationErrorDialog(e);
	} else {
	    openSystemErrorDialog(e);
	}
    }
    
  
    
    
    protected String getErrorString(Throwable e) {
	if (e == null) {
	    return "";
	}
	AccessDeniedException accessDeniedException = AccessDeniedException.getException(e);
	if (accessDeniedException != null) {
	    return AccessDeniedException.ACCESS_DENIED;
	}
	return ErrorTranslator.getMessage(e); //  .e.getLocalizedMessage();
    }
    
    
    
    protected Shell getShell() {
	return SWTEnvironment.getShell();
    }
    
    protected InternalShell createInternalShell(Composite desktop, int style, boolean sizeGrip, boolean customMenu) {
      InternalShell ishell = new InternalShell(desktop, style);
      if(sizeGrip)  {
	  ishell.createSizeGrip(SWT.NONE);
      }
      return ishell;
    }

    public static void setEditFormFrame(int editFormFrame) {
        SWTToolkitManager.editFormFrame = editFormFrame;
    }

    public static void setListFormFrame(int listFormFrame) {
        SWTToolkitManager.listFormFrame = listFormFrame;
    }    
    
    protected DesktopForm getDesktop() {
	if (SWTEnvironment.getApplication() == null) {
	    return null;
	}
	return SWTEnvironment.getApplication().getDesktop();
    }

    protected InternalShell[] getDesktopShells() {
	DesktopForm desktop = getDesktop();
	if (desktop == null) {
	    return null;
	}
	return desktop.getShells();
    }
    
    protected InternalShell getInternalShellByFormClass(Class formClass, Serializable identifier) {
	if (formClass == null) {
	    return null;
	}
	InternalShell[] shells = getDesktopShells();
	if (shells == null) {
	    return null;
	}
	
	for(InternalShell shell : shells) {
	    Composite c = shell.getContentPane();
	    Control[] children = c.getChildren();
	    for (Control child : children) {
		if (child instanceof IFormDecorator) {
		    
		//if (child instanceof IListFormDecorator) {
		    //IListFormDecorator decorator = (IListFormDecorator) child;
		    
		    IFormDecorator decorator = (IFormDecorator) child;
		    
		    IForm form = decorator.getForm();
		    if (form != null) {
			if (formClass.equals(form.getClass())) {
			    
			    // FIX: 2010-12-16
			    
			    if (identifier == null && form.getIdentifier() == null) {
				return shell;
			    }
			    
			    if (identifier == null || form.getIdentifier() == null) {
				continue;
			    }
			    
			    if (identifier.equals(form.getIdentifier())) {
				return shell;
			    }
			    
			    //
			}
		    }
		}
	    }
	}
	return null;
    }

    public boolean activeListForm(Class formClass) {
	return activeListForm(formClass, null);
    }
    
    public boolean activeListForm(Class formClass, Serializable identifier) {
	if (formManager != null) {
	    return formManager.activeListForm(formClass, identifier);
	}
	InternalShell shell = getInternalShellByFormClass(formClass, identifier);
	if (shell == null) {
	    return false;
	}
	shell.setActive();
	return true;
    }
    
    public boolean isUseListForm(Class formClass) {
	return isUseListForm(formClass, null);
    }
    
    public boolean isUseListForm(Class formClass, Serializable identifier) {
	return getInternalShellByFormClass(formClass, identifier) != null;
    }
    
    public void closeAllForms() {
	if (getDesktop() == null) {
	    return;
	}
	getDesktop().closeAll();
    }
    
    
    public Class getSelectedFormClass(List<IEntityConfig> entities, Class baseClass) throws ApplicationException {
	FormClassContext context = getSelectedFormClassContext(entities, baseClass);
	if (context == null) {
	    return null;
	}
	return context.getFormClass();
    }
    
    public FormClassContext getSelectedFormClassContext(List<IEntityConfig> entities, Class baseClass) throws ApplicationException {
	if (entities == null || baseClass == null) {
	    return null;
	}
	ChooseDialog dialog = new ChooseDialog(SWTEnvironment.getShell());
	dialog.setList(entities);
	dialog.open();
        IEntityConfig entityConfig = (IEntityConfig) dialog.getSelectedItem();
        if (entityConfig == null) {
            return null;
        }
	
	Class formClass = null;
	Serializable identifier = null; 
	if (entityConfig.isCustom()) {
	    identifier = entityConfig.getConfigId().trim();
	    String formPackage = "base"; // STUB
	    String formName = entityConfig.getEntityType().getConfigId().trim();
	    formName = formName.toLowerCase();
	    String listFormsuffix = AssociationManager.getAssociationCreator().getTypeSuffix(IListForm.class, IListForm.SUFFIX);
	    formName = formName.substring(0, 1).toUpperCase() + formName.substring(1) + listFormsuffix;
	    formClass = AssociationManager.getAssociationCreator().createElement(formPackage, formName, baseClass);
	} else {
	    Association association = AssociationManager.getAssociationByEntity(entityConfig);
	    if (association == null) {
		return null;
	    }
	    formClass = association.getElementByType(baseClass);
	}
	
	FormClassContext context = new FormClassContext();
	context.setFormClass(formClass);
	context.setIdentifier(identifier);
	return context;
    }

    protected void logError(Object e) {
	if (e == null) {
	    return;
	}
	if (e instanceof AccessDeniedException) {
	    logError(((AccessDeniedException) e));
	    return;
	}
	if (e instanceof Throwable) {
	    Throwable clause = ((Throwable) e).getCause();
	    if (clause instanceof AccessDeniedException) {
		logError(((AccessDeniedException) clause));
		return;
	    }
	}
	logger.error(e);
    }
    
    protected void logError(AccessDeniedException e) {
	logger.error("AccessDenied: " + e.getMessage());
    }
    
    protected void logWarn(Object e) {
	logger.warn(e);
    }

    protected void logInfo(Object e) {
	logger.info(e);
    }

    public static ISWTShellPresentation getEditFormShellPresentation() {
        return editFormShellPresentation;
    }

    public static void setEditFormShellPresentation(
    	ISWTShellPresentation editFormShellPresentation) {
        SWTToolkitManager.editFormShellPresentation = editFormShellPresentation;
    }

    public static ISWTShellPresentation getListFormShellPresentation() {
        return listFormShellPresentation;
    }

    public static void setListFormShellPresentation(
    	ISWTShellPresentation listFormShellPresentation) {
        SWTToolkitManager.listFormShellPresentation = listFormShellPresentation;
    }

    public static ISWTFormManager getFormManager() {
        return formManager;
    }

    public static void setFormManager(ISWTFormManager formManager) {
        SWTToolkitManager.formManager = formManager;
    }

    
    public static ISWTInnerFrameCreator getInnerFrameCreator() {
        return innerFrameCreator;
    }

    public static void setInnerFrameCreator(ISWTInnerFrameCreator innerFrameCreator) {
        SWTToolkitManager.innerFrameCreator = innerFrameCreator;
    } 
    
}
