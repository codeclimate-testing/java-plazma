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

package org.plazmaforge.bsolution.base.client.swing.forms.common;


import java.util.List;

import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.gui.XDefaultComboBoxModel;
import org.plazmaforge.framework.core.exception.ApplicationError;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/**
 * Created on 25.05.2006
 */
public class XEntityComboBox extends XComboBox {

    public XEntityComboBox(String entityType) {
	init(entityType);
    }

    public XEntityComboBox() {
	this(null);
    }

    private void init(String entityType) {
	try {
	    List items = ((SystemEntityService) ServiceFactory.getService(SystemEntityService.class)).findByEntityType(entityType);
	    setModel(new XDefaultComboBoxModel(items));
	} catch (ApplicationException ex) {
	    throw new ApplicationError(ex);
	}
    }
}
