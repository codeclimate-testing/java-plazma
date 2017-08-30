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
package org.plazmaforge.bsolution.product.client.swing;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.product.client.swing.resources.GUIProductResources;


/**
 * @author Oleh Hapon
 * Date: 20.03.2004
 * Time: 17:07:33
 * $Id: GUIProductEnvironment.java,v 1.2 2010/04/28 06:28:20 ohapon Exp $
 */

/**
 * This is Preferences for PRODUCT unit
 */
public class GUIProductEnvironment {


    private static GUIProductResources resources;

    static {
        resources = new GUIProductResources();
    }

    public static GUIProductResources getResources() {
        return resources;
    }

    public static Unit getUnit() {
	return EnterpriseEnvironment.getUnit();
    }
}
