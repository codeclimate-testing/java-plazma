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

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.organization.OrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author hapon
 *
 */
public abstract class AbstractOrganizableEdit extends EXTEditForm {

    

    public AbstractOrganizableEdit() {
        super();
    }
    
    public AbstractOrganizableEdit(Resources resources) {
        super(resources);
    }
    
    protected IOrganizable getOrganizable() {
        return (IOrganizable) this.getEntity();
    }

    
    protected void initData() throws ApplicationException {
        super.initData();
        OrganizationEnvironment.initOrganizable(getOrganizable(), getEnterpriseContext());
    }

    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }
}
