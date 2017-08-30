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
import org.plazmaforge.bsolution.project.common.beans.TaskResult;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.bsolution.project.common.services.TaskResultService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class TaskResultEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel taskTypeLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XComboEdit taskTypeComboEdit;

    public TaskResultEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(TaskResult.class);
	this.setEntityServiceClass(TaskResultService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	taskTypeLabel = new JLabel(getString("panel.label-task-type.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(40);
	nameField.setMaxChar(50);
	taskTypeComboEdit = new XComboEdit();
	taskTypeComboEdit.initListFormAction(this, TaskTypeList.class);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(taskTypeLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	editPanel.addByY(taskTypeComboEdit);

	add(editPanel);
    }

    private TaskResult getTaskResult() {
	return (TaskResult) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getTaskResult().getName());
	codeField.setText(getTaskResult().getCode());
	nameField.setText(getTaskResult().getName());
	taskTypeComboEdit.setValue(getTaskResult().getTaskType());
    }

    protected void populateData() throws ApplicationException {
	getTaskResult().setCode(codeField.getText());
	getTaskResult().setName(nameField.getText());
	getTaskResult().setTaskType((TaskType) taskTypeComboEdit.getValue());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getTaskResult().getName(), nameLabel.getText());
	validateRequiredField(buf, getTaskResult().getTaskType(), taskTypeLabel.getText());
	checkError(buf);
    }

}
