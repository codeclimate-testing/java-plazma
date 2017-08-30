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
 * Created on 02.12.2007
 *
 */

package org.plazmaforge.framework.client.actions;

import java.util.Map;

import org.plazmaforge.framework.action.DefaultAcceptorAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractListFormAction.java,v 1.4 2010/12/05 07:51:56 ohapon Exp $
 */

public abstract class AbstractListFormAction extends DefaultAcceptorAction {

    public void execute() throws ApplicationException {
	Map parameters = getAcceptor().readParameters();
        if (parameters == null) return;
        Object entity = parameters.get(IAcceptor.ENTITY);
        if (entity == null) {
            return;
        }
        
        IListForm listForm = Toolkit.getListForm(null, getListFormClass(), true);
        listForm.setParentEntity(entity);
        
	Toolkit.openForm(null, listForm);
    }
    
    public abstract Class getListFormClass();
}
