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

package org.plazmaforge.bsolution.organization.client.swing.actions;


import java.awt.event.ActionEvent;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerEdit;
import org.plazmaforge.framework.app.IAppManager;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.SwingFormManager;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatfromClientApplicationManager;


public class OrganizationEditAction extends GUIOrganizationAction {

    public void perform(ActionEvent e) throws ApplicationException {
	SessionContext context = SessionEnvironment.getContext();
        Integer orgainizationId = EnterpriseEnvironment.getOrganizationId(context);
        EditForm form = SwingFormManager.showEditFormByEditMode(PartnerEdit.class, orgainizationId);
        if (form != null && form.isModifyData()) {
        	EnterpriseEnvironment.loadOrganization(context);
        	IAppManager manager = SwingEnvironment.getApplication().getAppManager();
        	if (manager != null && manager instanceof PlatfromClientApplicationManager) {
        		((PlatfromClientApplicationManager) manager).updateStatusBar();
        	}
        }
    }

}
