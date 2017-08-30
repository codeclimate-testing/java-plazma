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
package org.plazmaforge.bsolution.project.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.project.client.swing.GUIProjectEnvironment;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.services.TaskPriorityService;
import org.plazmaforge.framework.client.swing.controls.XIntegerField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class TaskPriorityEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel orderNumberLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XIntegerField orderNumberField;

    public TaskPriorityEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(TaskPriority.class);
	this.setEntityServiceClass(TaskPriorityService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	orderNumberLabel = new JLabel(getString("panel.label-order.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	orderNumberField = new XIntegerField();
	nameField = new XTextField(50);
	nameField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(orderNumberLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	editPanel.addByY(orderNumberField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);

	add(editPanel);
    }

    private TaskPriority getTaskPriority() {
	return (TaskPriority) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getTaskPriority().getName());
	codeField.setText(getTaskPriority().getCode());
	orderNumberField.setValue(getTaskPriority().getOrderNumber());
	nameField.setText(getTaskPriority().getName());
    }

    protected void populateData() throws ApplicationException {
	getTaskPriority().setCode(codeField.getText());
	getTaskPriority().setOrderNumber(orderNumberField.intValue());
	getTaskPriority().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getTaskPriority().getName(), nameLabel.getText());
	checkError(buf);
    }

}
