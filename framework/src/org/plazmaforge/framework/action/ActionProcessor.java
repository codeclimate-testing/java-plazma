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
 * Created on 03.07.2003
 *
 */
package org.plazmaforge.framework.action;

import java.util.*;

import org.plazmaforge.framework.core.DataTransfer;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.security.SecureEnvironment;
import org.plazmaforge.framework.security.SecureManager;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;


/**
 * @author Oleh Hapon
 * 
 * $Id: ActionProcessor.java,v 1.9 2010/12/05 07:51:27 ohapon Exp $
 */

/**
 * The Action Processor. Execute action.
 */
public class ActionProcessor implements IProcessor, ActionConstants {

    
    
    /** Standard system command (For example OPEN_LIST_FORM, OPEN_EDIT_FORM, OPEN_REPORT ...) **/
    private static Map<String, ICommand> commandMap = new HashMap<String, ICommand>();

    /** Instance **/
    private static ActionProcessor instance;
    
    
    
    private ActionProcessor() {
    }

    public static ActionProcessor getInstance() {
	if (instance == null) {
	    instance = new ActionProcessor();
	}
	return instance;
    }

    
    /**
     * Add standard system command
     * @param command
     */
    public static void addCommand(ICommand command) {
	commandMap.put(command.getName(), command);
    }

    /**
     * Return standard system command
     * @param id
     * @return
     */
    public static ICommand getCommand(String id) {
	return (ICommand) commandMap.get(id);
    }

    
    /**
     * Execute action
     * 
     * @param className
     * @param transfer
     * @throws ApplicationException
     */
    public static void executeAction(String className, DataTransfer transfer) throws ApplicationException {
	try {
	    if (className == null || className.trim().equals("")) {
		new IllegalArgumentException("Class name must be not null");
	    }
	    Class klass = ClassUtilsExt.forName(className);
	    if (IAction.class.isAssignableFrom(klass)) {
		IAction action = (IAction) klass.newInstance();
		checkSecureAction(action);
		action.execute(transfer);
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex.getMessage());
	}
    }

    /**
     * Execute action
     * 
     * @param className
     * @throws ApplicationException
     */
    public static void executeAction(String className) throws ApplicationException {
	executeAction(className, new DataTransfer());
    }

    /**
     * Execute action
     * 
     * @param className
     * @param prmName
     * @param prmValue
     * @throws ApplicationException
     */
    public static void executeAction(String className, String prmName, String prmValue) throws ApplicationException {
	DataTransfer transfer = new DataTransfer();
	transfer.setParameter(prmName, prmValue);
	executeAction(className, transfer);
    }

    /**
     * Execute action
     * 
     * @param className
     * @param map
     * @throws ApplicationException
     */
    public static void executeAction(String className, Map map) throws ApplicationException {
	DataTransfer transfer = new DataTransfer(map);
	executeAction(className, transfer);
    }

    
    public static void execute(IAction action) throws ApplicationException {
	
	if (action == null) {
	    return;
	}
	
	checkSecureAction(action);
	
	String commandName = action.getCommand();
	if (isEmpty(commandName)) {
	    // ACTION EXECUTE
	    action.execute();
	    return;
	}
	
	String parameterString = action.getParametersString();
	ICommand command = getCommand(commandName);
	if (command == null) {
	    return;
	}
	
	// COMMAND EXECUTE
	command.execute(parameterString);
    }

    private static boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }

    
    private static void checkSecureAction(IAction action) throws ApplicationException {
	if (action == null) {
	    return;
	}
	String secureObjectId = action.getName();
	if (secureObjectId == null) {
	    return;
	}
	
	// DISABLE
	//System.out.println("checkSecureAction [" + secureObjectId  + "]");
	SecureEnvironment.getSecureManager().checkExecPermission(secureObjectId, SecureManager.ACTION);
    }
    
    
    
    

}
