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

package org.plazmaforge.framework.client.swing.forms.actions.edit;


import java.awt.event.ActionEvent;

import org.plazmaforge.framework.client.swing.forms.EditableMode;
import org.plazmaforge.framework.client.swing.forms.ParentEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;


/**
 * @author Oleh Hapon
 * Date: 09.03.2004
 * Time: 8:05:38
 * $Id: AddChildAction.java,v 1.3 2010/12/05 07:52:08 ohapon Exp $
 */
public class AddChildAction extends EditFormAction {

    public AddChildAction(ParentEditForm editForm, Resources resources) {
        super(editForm, resources);
    }

    public void perform(ActionEvent evt) throws ApplicationException {
        ((ParentEditForm) editForm).doEditChildCommand(EditableMode.ADD);
    }

}
