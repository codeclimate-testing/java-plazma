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

import org.plazmaforge.framework.config.ConfigurerContributor.CommandResolver;
import org.plazmaforge.framework.config.ConfigurerContributor.ConfigItem;
import org.plazmaforge.framework.core.command.CommandInfo;
import org.plazmaforge.framework.core.command.CommandParser;

/**
 * @author ohapon
 *
 */
public class ApplicationCommandResolver implements CommandResolver {
    
    private CommandParser commandParser = new ApplicationCommandParser(); 

    @Override
    public ConfigItem getConfigItem(String command) {
	if (command == null) {
	    return null;
	}
	CommandInfo commandInfo = commandParser.parseCommand(command);
	if (commandInfo == null) {
	    return null;
	}
	String commandName = commandInfo.getName();
	String entityName = null;
	if (commandInfo.getParameters() != null && commandInfo.getParameters().length > 0) {
	    entityName = commandInfo.getParameters()[0];
	}
	
	command = command.trim();
	if (command.isEmpty()) {
	    return null;
	}

	ConfigItem configItem = null;

	
	if (ApplicationCommandExecutor.isFormCommand(commandName)) {
	    configItem = new ConfigItem();
	    configItem.type = "Form";
	    configItem.name = entityName;
	} else if (ApplicationCommandExecutor.isReportCommand(commandName)) {
	    configItem = new ConfigItem();
	    configItem.type = "Report";
	    configItem.name = entityName;
	}
	return configItem;
    }

}
