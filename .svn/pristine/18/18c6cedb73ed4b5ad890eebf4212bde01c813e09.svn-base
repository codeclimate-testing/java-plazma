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
 * Created on 03.06.2006
 *
 */
package org.plazmaforge.framework.action;

import java.util.List;

import org.plazmaforge.framework.config.AbstractConfigFactory;
import org.plazmaforge.framework.config.configurer.ActionConfigurer;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.core.command.BaseCommandParser;
import org.plazmaforge.framework.core.command.CommandInfo;
import org.plazmaforge.framework.core.command.CommandParser;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.ReportFactory;
import org.plazmaforge.framework.util.ClassUtilsExt;


/**
 * Action factory
 * @author Oleh Hapon
 */
public class ActionFactory extends AbstractConfigFactory {

    
    public static final String SEPARATOR = "-";
    
    public static final String OPEN_REPORT_COMMAND = "open-report";
    
    
    
    private static ActionFactory instance;

    private static CommandParser commandParser; 
    
    private ActionFactory() {

    }

    public synchronized static ActionFactory getInstance() {
	if (instance == null) {
	    instance = new ActionFactory();
	}
	return instance;
    }

    @Override
    protected String getConfigurerName() {
	return ActionConfigurer.NAME;
    }

    /**
     * Return action by name
     * @param id
     * @return
     */
    public static IAction getActionByName(String name) {
	return getAction((IActionConfig) getInstance().getObjectConfigByName(name));
    }


    /**
     * Return action by actionConfig
     * @param actionConfig
     * @return
     */
    public static IAction getAction(IActionConfig actionConfig) {
	return getInstance().createAction(actionConfig);
    }

    /**
     * Create action
     * @param actionConfig
     * @return
     */
    protected IAction createAction(IActionConfig actionConfig) {

	IAction action = null;
	if (actionConfig == null) {
	    return null;
	}
	    
	// If separator the return null
	if (SEPARATOR.equals(actionConfig.getName())) {
	    return null;
	}
	    
	String className = actionConfig.getClassName();
	String command = actionConfig.getCommand();

	if (!isEmpty(className)) {
	    action = createActionByClass(actionConfig, className);
	} else if (!isEmpty(command)) {
	    action = createActionByCommand(actionConfig, command);
	}
	return action;

    }
    
    /**
     * Create action by class
     * @param actionConfig
     * @param className
     * @return
     */
    protected IAction createActionByClass(IActionConfig actionConfig, String className) {
	IAction action = null;
	try {
	    Object original = ClassUtilsExt.getClassInstance(className);
	    if (original instanceof IAction) {
		action = (IAction) original;
		populate(action, actionConfig);
	    } else {
		//action = new DefaultAction(actionConfig, original);
		DefaultAction defaultAction = new DefaultAction();
		defaultAction.setOriginal(original);
		populate(defaultAction, actionConfig);
		action = defaultAction;
	    }

	} catch (ApplicationException ex) {
	    logger.error("Error create action by class", ex);
	}
	return action;
    }
    
    /**
     * Create action by command
     * @param actionConfig
     * @param command
     * @return
     */
    protected IAction createActionByCommand(IActionConfig actionConfig, String command) {
	IAction action = null;
	CommandInfo commandInfo = parseCommand(actionConfig);
	if (OPEN_REPORT_COMMAND.equals(commandInfo.getName())) {
	    String reportName = commandInfo == null ? null : commandInfo.getParameter();
	    action = ReportFactory.getReportActionByName(reportName);
	    if (action == null) {
		logger.warn("Error creation action [" + actionConfig + "]: Report [" + reportName + "] not found");
	    } else {
		action.setId(actionConfig.getId());
	    }
	} else {
	    DefaultAction defaultAction = new DefaultAction();
	    populate(defaultAction, actionConfig);
	    action = defaultAction;
	}
	return action;
    }
    
    
    public static void populate(IAction action, IActionConfig actionConfig) {
	CommandInfo commandInfo = parseCommand(actionConfig);
	action.setId(actionConfig.getId());
	action.setName(actionConfig.getName());
	action.setText(actionConfig.getCaption());
	action.setCommand(commandInfo == null ? null: commandInfo.getName()); // COMMAND NAME
	action.setDescription(actionConfig.getDescription());
	action.setParameter(commandInfo == null ? null: commandInfo.getParameter()); // COMMAND FIRST PARAMETER
	action.setImageUrl(actionConfig.getIcon());
    }

    public static List<IActionConfig> getActionConfigs() {
	return getInstance().getObjects();
    }

    public static CommandParser getCommandParser() {
	if (commandParser == null) {
	    commandParser = new BaseCommandParser();
	}
        return commandParser;
    }

    public static void setCommandParser(CommandParser commandParser) {
        ActionFactory.commandParser = commandParser;
    }
    
    public static CommandInfo parseCommand(IActionConfig actionConfig) {
	return getCommandParser().parseCommand(actionConfig.getCommand());
    }
    
    
}
