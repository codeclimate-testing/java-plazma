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

package org.plazmaforge.framework.client.swing.forms;

import javax.swing.*;

import org.plazmaforge.framework.client.swing.actions.Command;
import org.plazmaforge.framework.client.swing.forms.actions.edit.EditFormAction;
import org.plazmaforge.framework.client.swing.forms.actions.edit.SaveAction;
import org.plazmaforge.framework.core.DefaultAcceptor;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Oleh Hapon Date: 13.8.2003 Time: 14:43:11 $Id: EditForm.java,v 1.4 2010/12/05 07:52:08 ohapon Exp $
 */

/**
 * Abstract Edit Form
 */
public abstract class EditForm extends Form {

    private static final String SAVE_MESSAGE_ERROR = "Saving error";

    /**
         * This is ID of object or Object (input data)
         */
    protected Object transferObject;

    protected EditFormAction saveAction;

    private EditableMode editableMode;

    private JTabbedPane tabbedPane;

    private IAcceptor editAcceptor;

    /**
     * Real ID of entity
     */
    private Serializable entityId;

    /**
     * Real entity
     */
    private Object entity;

    private boolean packMode = true;

    public EditForm(Window window, Resources resources) {
	initialize(window, resources);
    }

    public EditForm(Window window) {
	this(window, null);
    }

    private void initialize(Window window, Resources resources) {
	this.resources = resources;
	this.owner = window;
	modal = true;
    }

    protected void initActions() throws ApplicationException {
	saveAction = createSaveAction();
    }

    protected EditFormAction createSaveAction() {
	EditFormAction a = new SaveAction(this, getResources());
	a.setActionCommand(createSaveCommand());
	return a;
    }

    protected Command createSaveCommand() {
	return null;
    }

    protected void initToolBar(JToolBar toolBar) {

	// Initialize default tool bar
	toolBar.add(saveAction);

	// Initialize custom tool bar
	initCustomToolBar(toolBar);
    }

    protected void initMenuBar(JMenuBar menuBar) {

    }

    protected JTabbedPane getTabbedPane() {
	return tabbedPane;
    }

    protected void setTabbedPane(JTabbedPane tabbedPane) {
	this.tabbedPane = tabbedPane;
    }

    protected void addTabbedPane() throws ApplicationException {
	if (getTabbedPane() == null) {
	    return;
	}
	add(getTabbedPane());
    }

    public void doShow() {
	JDialog d = getDialog();
	if (isPackMode()) {
	    d.pack();
	}
	d.setLocationRelativeTo(null);
	beforeShow();
	d.show();
    }

    protected JDialog getDialog() {
	return (JDialog) shell;
    }

    private boolean isRun = false;

    public void doRun() throws ApplicationException {
	init();
	if (getTransferObject() != null
		&& getEditableMode().getMode() > EditableMode.EDIT) {
	    editableMode = createEditableMode(EditableMode.EDIT);
	}
	if (isRun) {
	    resetView();
	} else {
	    isRun = true;
	}
	getEditableMode().loadEditableData();
	prepareData();
	updateView(); // Update view from data
	// beforeShow();
	doShow();
	// afterShow();

    }

    public void doRun(Object objectValue, boolean modal, int mode)
	    throws ApplicationException {
	setTransferObject(objectValue);
	setModal(modal);
	initEditableMode(mode);
	doRun();
    }

    public void doRun(Object objectValue, boolean modal)
	    throws ApplicationException {
	setTransferObject(objectValue);
	setModal(modal);
	doRun();
    }

    public void doRun(Object objectValue) throws ApplicationException {
	setTransferObject(objectValue);
	doRun();
    }

    protected void beforeShow() {
	if (getTabbedPane() == null) {
	    return;
	}
	getTabbedPane().setSelectedIndex(0);
    }

    protected void afterShow() {
    }

    protected void loadData() throws ApplicationException {
	Object value = getTransferObject();
	if (value == null)
	    return;
	loadData(value);
    }

    protected abstract void loadData(Object value) throws ApplicationException;

    protected abstract void initData() throws ApplicationException;

    protected void prepareData() throws ApplicationException {
    }

    protected abstract void populateData() throws ApplicationException;

    protected void validateData() throws ApplicationException {
    }

    protected abstract Object createData() throws ApplicationException;

    protected abstract void storeData() throws ApplicationException;

    protected void resetView() throws ApplicationException {
    } // ???

    protected abstract void updateView() throws ApplicationException;

    public void doSaveData() throws ApplicationException {
	requestFocus();
	populateData();
	validateData();
	getEditableMode().storeEditableData();
    }

    public Object getTransferObject() {
	return transferObject;
    }

    public void setTransferObject(Object transferObject) {
	this.transferObject = transferObject;
    }

    public EditableMode getEditableMode() {
	if (editableMode == null) {
	    editableMode = createEditableMode(EditableMode.ADD);
	}
	return editableMode;
    }

    public void initEditableMode(int mode) {
	if ((editableMode == null) || (editableMode.getMode() != mode)) {
	    editableMode = createEditableMode(mode);
	}
    }

    protected EditableMode createEditableMode(int mode) {
	if (mode == EditableMode.EDIT) {
	    return new EditMode();
	} else if (mode == EditableMode.ADD) {
	    return new AddMode();
	} else if (mode == EditableMode.ADD_CYCLE) {
	    return new AddCycleMode();
	} else if (mode == EditableMode.VIEW) {
	    return new ViewMode();
	} else {
	    throw new IllegalArgumentException("Invalid Editable Mode argument");
	}
    }

    /***********************************************************************
     * EDIT FORM MODE DEFINITION
     **********************************************************************/

    /*
     * Edit Mode
     */
    class EditMode extends EditableMode {

	public int getMode() {
	    return EDIT;
	}

	public void loadEditableData() throws ApplicationException {
	    doLoadData();
	}

	public void storeEditableData() throws ApplicationException {
	    storeData();
	    setModifyData(true);
	    // getDialog().hide();
	    close();
	}

    }

    /*
     * Add Mode
     */
    class AddMode extends EditableMode {

	public int getMode() {
	    return ADD;
	}

	public void loadEditableData() throws ApplicationException {
	    initData();
	}

	public void storeEditableData() throws ApplicationException {
	    transferObject = createData();
	    setModifyData(true);
	    // getDialog().hide();
	    close();
	}

    }

    /*
     * Add Cycle Mode
     */
    class AddCycleMode extends EditableMode {

	public int getMode() {
	    return ADD_CYCLE;
	}

	public void loadEditableData() throws ApplicationException {
	    initData();
	}

	public void storeEditableData() throws ApplicationException {
	    createData();
	    setModifyData(true);
	    resetView();
	}

    }

    /*
     * View Mode
     */
    class ViewMode extends EditableMode {

	public int getMode() {
	    return VIEW;
	}

	public void loadEditableData() throws ApplicationException {
	    doLoadData();
	}

	public void storeEditableData() throws ApplicationException {
	}

    }

    protected Container createShell() {
	Container c = super.createShell();
	if (c instanceof JDialog) {
	    JComponent comp = ((JDialog) c).getRootPane();
	    registerKeyEsc(comp);
	    registerKeyCtrlEnter(comp);
	}
	return c;
    }

    protected void registerKeyCtrlEnter(JComponent comp) {
	comp.registerKeyboardAction(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    doSaveData();
		} catch (ApplicationException ex) {
		    logger.error(SAVE_MESSAGE_ERROR, ex);
		    applicationError(ex);
		} catch (Throwable ex) {
		    logger.error(SAVE_MESSAGE_ERROR, ex);
		    systemError(ex);
		}
	    }
	}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK),
		JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    protected IAcceptor getEditAcceptor() {
	if (editAcceptor == null) {
	    editAcceptor = createEditAcceptor();
	}
	return editAcceptor;
    }

    protected IAcceptor createEditAcceptor() {
	return new EditAcceptor();
    }

    protected class EditAcceptor extends DefaultAcceptor {

	public Map<String, Object> readParameters() throws ApplicationException {
	    Object value = getTransferObject();
	    if (value == null) {
		return null;
	    }
	    getParameters().put(IAcceptor.ID, value);
	    getParameters().put(IAcceptor.ENTITY, getEntity());
	    getParameters().put(IAcceptor.DIALOG, getDialog());
	    return getParameters();
	}

    }

    protected IAcceptor getFormAcceptor() {
	return getEditAcceptor();
    }

    public Serializable getEntityId() {
	return entityId;
    }

    public void setEntityId(Serializable entityId) {
	this.entityId = entityId;
    }

    public Object getEntity() {
	return entity;
    }

    public void setEntity(Object entity) {
	this.entity = entity;
    }

    public boolean isPackMode() {
	return packMode;
    }

    public void setPackMode(boolean packMode) {
	this.packMode = packMode;
    }

    protected void initCustomActionState(Action action) {
	if (action == null) {
	    return;
	}
	if (getEditableMode() == null) {
	    return;
	}
	if (getEditableMode().getMode() == EditableMode.ADD) {
	    action.setEnabled(false);
	} else {
	    action.setEnabled(true);
	}
    }

}
