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
package org.plazmaforge.bsolution.base.client.swing.actions;

import java.awt.event.ActionEvent;

import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.gui.GUIPreferencesDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 13.11.2004 Time: 10:45:29 $Id: PreferencesAction.java,v 1.3 2010/12/05 07:56:42 ohapon Exp $
 */
public class PreferencesAction extends GUIBaseAction {

    private GUIPreferencesDialog dialog;

    public void perform(ActionEvent e) throws ApplicationException {
	if (dialog == null) {
	    dialog = new GUIPreferencesDialog(SwingEnvironment.getFrame());
	}
	dialog.showDialog();

    }
}
