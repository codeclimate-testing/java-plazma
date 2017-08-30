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

import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.action.ActionProcessor;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.IToolkitManager;
import org.plazmaforge.framework.client.actions.ChooseFormCommand;
import org.plazmaforge.framework.client.actions.CloseAllFormsCommand;
import org.plazmaforge.framework.client.actions.NewFormCommand;
import org.plazmaforge.framework.client.actions.OpenFormCommand;
import org.plazmaforge.framework.client.actions.OpenListFormCommand;
import org.plazmaforge.framework.client.help.HelpSystem;
import org.plazmaforge.framework.client.swt.app.SWTApplication;
import org.plazmaforge.framework.client.swt.help.SWTHelpProvider;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTEnvironment {

    public static final String PLAZMA_RCP_SWT_TABLE_VIRTUAL = Environment.PLAZMA_RCP_PROPERTY +  ".swt.table.virtual";
    
    private static SWTApplication application;

    private  static IShellProvider shellProvider;
    
    
    public  static IShellProvider getShellProvider() {
        return shellProvider;
    }

    public  static void setShellProvider(IShellProvider shellProvider) {
	SWTEnvironment.shellProvider = shellProvider;
    }

    
    public static SWTApplication getApplication() {
        return application;
    }

    public static void setApplication(SWTApplication application) {
        SWTEnvironment.application = application;
       	setShellProvider(application);
    }
    
    /**
     * Initialize SWT Environment
     */
    public static void init() {
	
	// Initialize System properties
	initSystemProperties();
	
	// Initialize Toolkit Manager
	initToolkitManager();
	
	// Add Form Commands
	ActionProcessor.addCommand(new OpenFormCommand());
	ActionProcessor.addCommand(new OpenListFormCommand());
	ActionProcessor.addCommand(new CloseAllFormsCommand());
	ActionProcessor.addCommand(new NewFormCommand());
	ActionProcessor.addCommand(new ChooseFormCommand());
	
	// Set Help Provider
	HelpSystem.setHelpProvider(new SWTHelpProvider());
	
    }
    
    /**
     * Initialize ToolkitManager
     */
    public static void initToolkitManager() {
	
	// If SWT ToolkitManager was initialized then return
	if (Environment.getToolkitManager() != null && Environment.getToolkitManager() instanceof SWTToolkitManager) {
	    return;
	}
	
	IToolkitManager toolkitManager = new SWTToolkitManager();
	toolkitManager.init();
	Environment.setToolkitManager(toolkitManager);
    }
    
    /**
     * Initialize System Properties
     */
    public static void initSystemProperties() {
	
	String listFormProp = System.getProperty(Environment.PLAZMA_RCP_LIST_FORM_PROPERTY);
	String editFormProp = System.getProperty(Environment.PLAZMA_RCP_LIST_FORM_PROPERTY);
	String tableVirtualProp = System.getProperty(PLAZMA_RCP_SWT_TABLE_VIRTUAL);
	
	int frameType = getFrameType(listFormProp);
	if (frameType > 0) {
	    SWTToolkitManager.setListFormFrame(frameType);
	}
	frameType = getFrameType(editFormProp);
	if (frameType > 0) {
	    SWTToolkitManager.setEditFormFrame(frameType);
	}
	
	if ("true".equals(tableVirtualProp)) {
	    SWTToolkit.TABLE_STYLE |= SWT.VIRTUAL;
	}
	
    }
    
    private static int getFrameType(String prop) {
	if ("SHELL".equals(prop)) {
	    return SWTToolkitManager.SHELL_FRAME;
	} else if ("DECORATIONS".equals(prop)) {
	    return SWTToolkitManager.DECORATIONS_FRAME;
	} else if ("INNER".equals(prop)) {
	    return SWTToolkitManager.INNER_FRAME;
	}
	return 0;
    }
    
    public static Shell getShell() {
	return getShellProvider() == null ? null : getShellProvider().getShell();
    }
}
