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

package org.plazmaforge.framework.client.swt.forms;

import java.util.List;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormController;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.report.IReportAction;

public class SWTFormUtils {

    public static IReportAction getSelectedReportAction(IFormController controller, List<IReportAction> actions) {
	if (controller == null || actions == null || actions.size() == 0) {
	    return null;
	}
	ChooseDialog dialog = new ChooseDialog(getFormShell(controller));
	dialog.setItemLabelProperty("text");
        dialog.setList(actions);
        dialog.open();
        
	Object selectedItem = dialog.getSelectedItem();
	if (selectedItem == null) {
	    return null;
	}	
	return (IReportAction) selectedItem;
    }

    public static Shell getFormShell(IFormController controller) {
	Control control = getFormControl(controller);
	return control == null ? null : control.getShell();
    }

    public static Control getFormControl(IFormController controller) {
	return getFormControl(controller.getForm());
    }

    public static Control getFormControl(IForm form) {
	return (Control) form;
    }
}
