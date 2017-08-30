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
 * Created on 14.06.2007
 *
 */

package org.plazmaforge.bsolution.organization.client.swt.actions;


import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.SWTClientApplicationManager;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerEditForm;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.models.FormAdapter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.core.exception.ApplicationException;



/** 
 * @author Oleh Hapon
 * $Id: OrganizationEditAction.java,v 1.8 2010/12/05 07:57:24 ohapon Exp $
 */

public class OrganizationEditAction extends DefaultAction /*implements IFormHolder*/ {

    
    public void execute() throws ApplicationException {

	//
	Integer orgainizationId = EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext());
	if (orgainizationId == null) {
	    return;
	}
	
	IForm form = Toolkit.getForm(null, PartnerEditForm.class, PWT.EDIT_FORM);
	if (form == null) {
	    return;
	}
	form.setMode(PWT.EDIT_MODE);
	form.setEntityId(orgainizationId);
	form.addFormListener(new OrganizationFormListener());
	
	Toolkit.openForm(null, form);
    }
    
    public class OrganizationFormListener extends FormAdapter {
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    IForm form = event.getForm();
	    if (form == null) {
		return;
	    }
	    if (!form.isModify()) {
		return;
	    }
	    SWTClientApplicationManager manager = new SWTClientApplicationManager();
	    manager.reloadOrganization();
	}
    }    
}
