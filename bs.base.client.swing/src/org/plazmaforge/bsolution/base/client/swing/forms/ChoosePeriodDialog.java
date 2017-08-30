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
package org.plazmaforge.bsolution.base.client.swing.forms;

import javax.swing.*;

import org.plazmaforge.bsolution.base.common.services.PeriodService;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.controls.XOptionComboBox;
import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


import java.awt.*;
import java.util.ArrayList;

/**
 * @author Oleh Hapon Date: 14.01.2005 Time: 9:11:33 $Id: ChoosePeriodDialog.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class ChoosePeriodDialog extends OptionDialog {

    private XOptionComboBox periodComboBox;

    public ChoosePeriodDialog() throws HeadlessException {
	super(SwingEnvironment.getFrame(), "Choose period");
	init();
    }

    protected JPanel createDialogPanel() {
	JPanel p = super.createDialogPanel();
	p.setLayout(new BorderLayout());
	JPanel edit = new JPanel();
	edit.setBorder(BorderFactory.createTitledBorder("Choose year"));
	edit.add(new JLabel("Period"));
	PeriodService biz = (PeriodService) ServiceFactory
		.getService(PeriodService.class);
	//try {
	    periodComboBox = new XOptionComboBox(new ArrayList()/*biz.getOptionList()*/); // TODO
	//} catch (ApplicationException ex) {
	//    ex.printStackTrace();
	//}
	edit.add(periodComboBox);
	p.add(edit);
	return p;
    }

    public Integer getPeriodId() {
	if (periodComboBox == null) {
	    return null;
	}
	return periodComboBox.getOptionComboBoxModel().getSelectedIntKey();
    }
}
