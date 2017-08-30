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
 * Created on 13.07.2007
 *
 */

package org.plazmaforge.bsolution.security.client.swt.actions;


import org.plazmaforge.bsolution.security.client.swt.forms.PermissionListForm;
import org.plazmaforge.bsolution.security.client.swt.forms.RoleListForm;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.models.FormAdapter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: PermissionListAction.java,v 1.8 2010/12/05 07:57:23 ohapon Exp $
 */

public class PermissionListAction extends DefaultAction {

    
    public void execute() throws ApplicationException {
	RoleListForm roleListForm = (RoleListForm) Toolkit.getListForm(null, RoleListForm.class, true);
	roleListForm.setChooseState(true);
	roleListForm.addFormListener(new PermissionFormListener());
	Toolkit.openForm(null, roleListForm);
    }
    
    public class PermissionFormListener extends FormAdapter {
	
	
	// DON'T MOVE IT TO updateForm(FormEvent event) method !
	
	public void closeForm(FormEvent event) throws ApplicationException {
	    IForm form = event.getForm();
	    if (form == null) {
		return;
	    }
	    RoleListForm roleListForm = (RoleListForm) form;
	    Role role = (Role) roleListForm.getEntity();
	    if (role == null) {
		return;
	    }
	    PermissionListForm listForm = (PermissionListForm) Toolkit.getListForm(null, PermissionListForm.class, true);
	    listForm.setRole(role);
	        
	    Toolkit.openForm(null, listForm);
	     
	}
    }    
}
