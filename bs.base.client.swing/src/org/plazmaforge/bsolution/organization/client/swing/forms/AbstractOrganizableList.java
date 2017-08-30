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
 * Created on 10.07.2005
 *
 */
package org.plazmaforge.bsolution.organization.client.swing.forms;

import java.awt.Window;

import javax.swing.JDesktopPane;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.organization.common.services.OrganizableService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author hapon
 *
 */
public abstract class AbstractOrganizableList extends EXTListForm {
    
    public AbstractOrganizableList() {
        super();
    }
    
    public AbstractOrganizableList(JDesktopPane desktop, Resources resources) {
        super(desktop, resources);
    }
    
    public AbstractOrganizableList(JDesktopPane jDesktopPane, String s) {
        super(jDesktopPane, s);
    }
    
    public AbstractOrganizableList(Resources resources) {
        super(resources);
    }
    
    public AbstractOrganizableList(String s) {
        super(s);

    }
    
    public AbstractOrganizableList(Window window, Resources resources) {
        super(window, resources);
    }

    protected OrganizableService getOrganizableService() {
        return (OrganizableService) this.getEntityService();
    }
    
    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }
    
    protected void loadData() throws ApplicationException {
        refreshTableModel(getOrganizableService().findByOrganizationId(EnterpriseEnvironment.getOrganization(getEnterpriseContext()).getId()));
    }

}
