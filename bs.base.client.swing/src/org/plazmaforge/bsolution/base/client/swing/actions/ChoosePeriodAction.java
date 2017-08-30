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

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.SwingClientApplicationManager;
import org.plazmaforge.bsolution.base.client.swing.forms.ChoosePeriodDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.event.ActionEvent;

/**
 * @author Oleh Hapon Date: 14.01.2005 Time: 9:18:38 $Id: ChoosePeriodAction.java,v 1.3 2010/12/05 07:56:42 ohapon Exp $
 */
public class ChoosePeriodAction extends GUIBaseAction {

    public void perform(ActionEvent e) throws ApplicationException {
	ChoosePeriodDialog dialog = new ChoosePeriodDialog();
	if (dialog.showDialog() != JOptionPane.OK_OPTION
		|| dialog.getPeriodId() == null) {
	    return;
	}
	EnterpriseEnvironment.loadPeriod(dialog.getPeriodId());
	new SwingClientApplicationManager().updateStatusBar();
    }
}
