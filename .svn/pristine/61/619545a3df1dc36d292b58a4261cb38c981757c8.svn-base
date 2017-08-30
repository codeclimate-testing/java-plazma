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
 * Created on 06.03.2005
 *
 */
package org.plazmaforge.bsolution.organization;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.framework.platform.Environment;


/**
 * OrganizationHeader Environment
 * 
 * @author hapon
 *
 */
public class OrganizationEnvironment extends Environment {

    private OrganizationEnvironment() {
    }

    /**
     * Initialize Organizable
     * 
     * @param organizable
     */
    public static void initOrganizable(IOrganizable organizable, SessionContext context) {
	organizable.setOrganization(EnterpriseEnvironment.getOrganization(context));
    }

}
