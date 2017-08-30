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
 * Created on 01.04.2007
 *
 */

package org.plazmaforge.framework.client.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.action.ICommand;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.FormClassContext;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: ChooseFormCommand.java,v 1.4 2010/12/05 07:51:56 ohapon Exp $
 */
 
public class ChooseFormCommand implements ICommand, CommandConstants {

    public void execute(String parameter) throws ApplicationException {
	if (parameter == null) {
	    return;
	}
	String type = parameter;
	
	FormClassContext context = Toolkit.getSelectedFormClassContext(type, IListForm.class);
	if (context == null || context.getFormClass() == null) {
	    return;
	}
	Class formClass = context.getFormClass();
	Serializable identifier = context.getIdentifier();
	
	if (Toolkit.activeListForm(formClass, identifier)) {
	    return;
	}
	IListForm listForm = Toolkit.getListForm(null, formClass);
	listForm.setIdentifier(identifier);
	if (identifier != null && identifier instanceof String) {
	    List<String> arguments = new ArrayList<String>();
	    arguments.add(((String) identifier).trim());
	    listForm.setArguments(arguments);
	}
	Toolkit.openForm(null, listForm);
	
	//Toolkit.chooseFormByType(type);
    }

    public String getName() {
	return CHOOSE_FORM;
    }     
    
  
}
