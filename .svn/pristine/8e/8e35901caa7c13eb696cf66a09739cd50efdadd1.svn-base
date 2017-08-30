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

package org.plazmaforge.framework.client.swing.actions;

import javax.swing.*;


import org.apache.log4j.Logger;
import org.plazmaforge.framework.action.ActionUtils;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.client.swing.message.Message;
import org.plazmaforge.framework.core.DataTransfer;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleh Hapon Date: 19.01.2004 Time: 9:41:01 $Id: BaseAction.java,v 1.6 2010/12/05 07:52:09 ohapon Exp $
 */

public class BaseAction extends AbstractAction implements IAction {

    private static final Logger logger = Logger.getLogger(BaseAction.class);

    private static final String MESSAGE_ERROR = "Action performed error";

    public static final String DISABLED_ICON = "DisabledIcon";

    public static final String ROLLOVER_ICON = "RolloverIcon";

    
    private String id;
    
    private String name;
    
    protected Command actionCommand;

    protected Component messageFrame;

    private String imageUrl;

    private Object original;

    private String command;

    private List<String> parameters;
    
    private String parametersString;


    private boolean parametersStringReady;
    
    
    protected BaseAction() {
	super();
    }

    protected BaseAction(String title) {
	super(title);
    }

    protected BaseAction(String title, Icon icon) {
	super(title, icon);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected Frame getParentFrame(ActionEvent e) {
	if (e == null) {
	    return null;
	}
	Object src = e.getSource();
	if (!(src instanceof Component)) {
	    return null;
	}
	Frame parent = null;
	Component comp = (Component) src;
	while (comp != null && parent == null) {
	    if (comp instanceof Frame) {
		parent = (Frame) comp;
	    } else if (comp instanceof JPopupMenu) {
		comp = ((JPopupMenu) comp).getInvoker();
	    } else {
		comp = comp.getParent();
	    }
	}
	return parent;
    }

    public Command getActionCommand() {
	return actionCommand;
    }

    public void setActionCommand(Command command) {
	this.actionCommand = command;
    }

    public void actionPerformed(ActionEvent evt) {
	try {
	    doActionPerformed(evt);
	    
	    /*
	    if (getActionCommand() != null) {
		getActionCommand().execute();
	    } else {
		perform(evt);
		// new Process(evt).start();
	    }
	    */
	    
	    
	} catch (ApplicationException ex) {
	    logger.error(MESSAGE_ERROR, ex);
	    Message.applicationError(getParentFrame(evt), ex);
	} catch (Throwable ex) {
	    logger.error(MESSAGE_ERROR, ex);
	    Message.systemError(getParentFrame(evt), ex);
	}

    }

    protected void doActionPerformed(ActionEvent evt) throws ApplicationException {
	if (getActionCommand() != null) {
	    getActionCommand().execute();
	} else {
	    perform(evt);
	    // new Process(evt).start();
	}
    }
    
    public void perform(ActionEvent evt) throws ApplicationException {
    }

    class Process extends Thread {

	// Cursor cursor = null;
	ActionEvent event;

	public Process(ActionEvent event) {
	    this.event = event;
	}

	public void run() {

	    try {
		/*
                 * SwingUtilities.invokeAndWait(new Runnable() { public void
                 * run() { cursor = getCursor(); setCursor(new
                 * Cursor(Cursor.WAIT_CURSOR)); if (refreshAction != null) {
                 * refreshAction.setEnabled(false); } } });
                 */
		perform(event);

	    } catch (ApplicationException e) {
		// throw new Throwable(e);
	    } finally {
		/*
                 * try { SwingUtilities.invokeAndWait(new Runnable() { public
                 * void run() { if (refreshAction!=null) {
                 * refreshAction.setEnabled(true); } setCursor(cursor); } }); }
                 * catch (Exception e) { PlatformSystem.err.println(e); }
                 */
	    }
	}
    }

    public void execute() throws ApplicationException {
	execute(null);
    }

    public void execute(DataTransfer transfer) throws ApplicationException {
	doActionPerformed(null);
	//actionPerformed(null);
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    public Object getOriginal() {
	return original;
    }

    public void setOriginal(Object original) {
	this.original = original;
    }

    public String getCommand() {
	return command;
    }

    public void setCommand(String command) {
	this.command = command;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
    
    public String getDescription() {
	return (String) getValue(Action.SHORT_DESCRIPTION);
    }

    public void setDescription(String description) {
	putValue(Action.SHORT_DESCRIPTION, description);
    }
    
    public List<String> getParameters() {
	if (parameters == null) {
	    parameters = new ArrayList<String>();
	}
	return parameters;
    }
    
    public String getParameter() {
        return (parameters == null || parameters.size() == 0) ? null : parameters.get(0);
    }

    public void addParameter(String parameter) {
	getParameters().add(parameter);
	parametersStringReady = false;
    }

    public void setParameter(String parameter) {
	if (getParameters().size() == 0) {
	    getParameters().add(parameter);
	} else {
	    getParameters().set(0, parameter);
	}
	parametersStringReady = false;
    }
    
    public String getParametersString() {
	if (!parametersStringReady) {
	    parametersString = ActionUtils.getParametersString(this);
	    parametersStringReady = true;
	}
        return parametersString;
    }
    
    public void clearParameters() {
	getParameters().clear();
	parametersStringReady = false;
    }

    @Override
    public String getText() {
	return (String) getValue(Action.NAME);
    }

    @Override
    public void setText(String caption) {
	putValue(Action.NAME, name);
    } 
    
    
}
