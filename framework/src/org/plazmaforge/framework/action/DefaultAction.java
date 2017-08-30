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
 * Created on 03.01.2007
 *
 */

package org.plazmaforge.framework.action;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.core.DataTransfer;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 */

public class DefaultAction implements IAction {

    private String id;
    
    private String name;
    
    private String text;
    
    private String description;

    private String command;
    
    private List<String> parameters;
    
    private String parametersString;
    
    private String imageUrl;
    
    private Object original;
    
    
    private boolean parametersStringReady;
    
    
    public DefaultAction() {
        super();
    }

//    public DefaultAction(IActionConfig actionConfig) {
//        this(actionConfig, null);
//    }
//    
//    public DefaultAction(IActionConfig actionConfig, Object original) {
//        super();
//        if (actionConfig != null) {
//            this.id = actionConfig.getId();
//            this.name = actionConfig.getName();
//            this.text = actionConfig.getCaption();
//            this.description = actionConfig.getDescription();
//            this.command = actionConfig.getCommand();
//            this.parameters = actionConfig.getParameters();
//            this.parametersString = ConfigUtils.getParametersString(actionConfig);
//            this.imageUrl = actionConfig.getIcon();
//        }
//        this.original = original;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void execute() throws ApplicationException {
	execute(null);
    }
    
    public void execute(DataTransfer dataTransfer) throws ApplicationException {
        
    }
    
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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

    
    public static IAction createSeparatorAction() {
	DefaultAction action = new DefaultAction();
	action.setName("-");
	return action;
    }
}
