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
package org.plazmaforge.bsolution.payroll.client.swing.forms;


import java.awt.*;
import javax.swing.*;

import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollForm;
import org.plazmaforge.bsolution.payroll.common.services.PayrollFormService;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * @author Oleh Hapon
 * Date: 04.10.2004
 * Time: 21:57:23
 * $Id: PayrollFormEdit.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class PayrollFormEdit extends EXTEditForm {

    private JLabel nameLabel;

    private JTextField nameField;

    public PayrollFormEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(PayrollForm.class);
	this.setEntityServiceClass(PayrollFormService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));

	nameLabel = new JLabel(getString("panel.label-name.text"));
	nameField = new JTextField(25);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(nameLabel);
	gbc.gridy = 0;
	editPanel.addByX(nameField);

	add(editPanel);
    }

    private PayrollForm getPayrollForm() {
	return (PayrollForm) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPayrollForm().getName());
	nameField.setText(getPayrollForm().getName());
    }

    protected void populateData() throws ApplicationException {
	getPayrollForm().setName(nameField.getText());
    }

}
