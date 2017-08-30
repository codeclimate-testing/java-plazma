/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs;

import java.util.HashMap;
import java.util.Map;

import org.plazmaforge.framework.core.command.CommandExecutor;
import org.plazmaforge.framework.core.command.CommandInfo;
import org.plazmaforge.framework.core.command.CommandParser;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.uwt.form.FormManager;
import org.plazmaforge.framework.uwt.widget.MessageBox;


/**
 * @author ohapon
 *
 */
public class ApplicationCommandExecutor implements CommandExecutor {

    
    private static final Logger logger = Logger.getLogger(ApplicationCommandExecutor.class.getName());
    
    
    /**
     * Application commands
     */
    public static final String NEW_FORM_COMMAND = "new-form";
    
    public static final String OPEN_FORM_COMMAND = "open-form";
    
    public static final String OPEN_LIST_FORM_COMMAND = "open-list-form";
    
    public static final String OPEN_EDIT_FORM_COMMAND = "open-edit-form";
    
    public static final String OPEN_REPORT_COMMAND = "open-report";
    
    
    private CommandParser commandParser = new ApplicationCommandParser(); 
    
    private TypeResolver typeResolver;
    
    private Map<String, Command> commands = new HashMap<String, ApplicationCommandExecutor.Command>();
    
    
    
    public ApplicationCommandExecutor(TypeResolver typeResolver) {
	this.typeResolver = typeResolver;
	registerCommand(OPEN_LIST_FORM_COMMAND, new OpenListCommand());
    }

    public void registerCommand(String name, Command command) {
	commands.put(name, command);
    }
    
    public void executeCommand(String command) {
	if (command == null) {
	    return;
	}
	CommandInfo commandInfo = commandParser.parseCommand(command);
	executeCommand(commandInfo);
	
    }
    
    protected void executeCommand(CommandInfo commandInfo) {
	if (commandInfo == null) {
	    return;
	}
	String commandName = commandInfo.getName();
	if (commandName == null) {
	    handleError("Can't execute empty command.");
	    return;
	}
	Command command = commands.get(commandName);
	if (command == null) {
	    handleError(commandInfo, "Command '" + commandName + "' not found.");
	    return;
	}
	try {
	    command.setCommandInfo(commandInfo);
	    command.execute();
	} catch (Throwable e) {
	    handleError(commandInfo, null, e);
	}
    }
    
    protected void handleError(CommandInfo commandInfo, String message, Throwable e) {
	String commandLine = commandInfo == null ? null : commandInfo.getLine();
	String errorMessage = null;
	if (e != null) {
	    errorMessage = e.getMessage() != null ? e.getMessage() : e.getClass().toString();
	}
	String headerMessage = "Can't execute command '" + commandLine + "'"; 
	logger.error(headerMessage + (message == null ? "" : (": " + message)), e);
	MessageBox.error(headerMessage 
	+ (message == null ? "" : (".\n" + message)) 
	+ (errorMessage == null ? "" : (".\n" + errorMessage)));
    }

    protected void handleError(CommandInfo commandInfo, String message) {
	handleError(commandInfo, message, null);
    }
    
    protected void handleError(String message) {
	logger.error(message);
	MessageBox.error(message);
    }

    public static interface Command {
	
	CommandInfo getCommandInfo();

	void setCommandInfo(CommandInfo commandInfo);
	
	public void execute();
	
    }
    
    class OpenListCommand implements Command {

	private CommandInfo commandInfo;
	
	public CommandInfo getCommandInfo() {
	    return commandInfo;
	}

	public void setCommandInfo(CommandInfo commandInfo) {
	    this.commandInfo = commandInfo;
	}

	@Override
	public void execute() {
	    String formPath = commandInfo.getParameter();
	    if (formPath == null) {
		return;
	    }
	    String formClass = typeResolver.getClassNameByPath(formPath);
	    if (formClass == null) {
		return;
	    }
	    FormManager.open(formClass);
	}
	
    }
    
    public static boolean isFormCommand(String commandName) {
	// TODO: NEW_FORM
	return (ApplicationCommandExecutor.OPEN_FORM_COMMAND.equals(commandName) 
		|| ApplicationCommandExecutor.OPEN_LIST_FORM_COMMAND.equals(commandName)
		|| ApplicationCommandExecutor.OPEN_EDIT_FORM_COMMAND.equals(commandName));
    }
    
    public static boolean isReportCommand(String commandName) {
	return (ApplicationCommandExecutor.OPEN_REPORT_COMMAND.equals(commandName));
    }
    
}
