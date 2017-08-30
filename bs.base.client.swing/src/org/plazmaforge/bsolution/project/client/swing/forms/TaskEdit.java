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

import java.awt.*;

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.document.client.swing.forms.DocumentList;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.organization.client.swing.forms.AbstractOrganizableEdit;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.project.ProjectEnvironment;
import org.plazmaforge.bsolution.project.TaskEnvironment;
import org.plazmaforge.bsolution.project.client.swing.GUIProjectEnvironment;
import org.plazmaforge.bsolution.project.common.beans.ProjectHeader;
import org.plazmaforge.bsolution.project.common.beans.Task;
import org.plazmaforge.bsolution.project.common.beans.TaskPriority;
import org.plazmaforge.bsolution.project.common.beans.TaskStatus;
import org.plazmaforge.bsolution.project.common.beans.TaskType;
import org.plazmaforge.bsolution.project.common.services.TaskService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;



public class TaskEdit extends AbstractOrganizableEdit {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel taskTypeLabel;

    private JLabel startDateTimeLabel;

    private JLabel endDateTimeLabel;

    private JLabel taskPriorityLabel;

    private JLabel alarmDateTimeLabel;

    private JLabel responsibleLabel;

    private JLabel projectLabel;

    private JLabel partnerLabel;

    private JLabel documentLabel;

    private JLabel taskStateLabel;

    private JLabel donePercentLabel;

    private JLabel completedDateTimeLabel;

    private JLabel amountLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XComboEdit taskTypeComboEdit;

    private XDateField startDateTimeField;

    private XDateField endDateTimeField;

    private XComboEdit taskPriorityComboEdit;

    private XDateField alarmDateTimeField;

    private XComboEdit responsibleComboEdit;

    private XComboEdit projectComboEdit;

    private XComboEdit partnerComboEdit;

    private XComboEdit documentComboEdit;

    private XComboEdit taskStateComboEdit;

    private XNumberField donePercentField;

    private XDateField completedDateTimeFiled;

    private XNumberField amountField;

    private XTextEdit noteField;

    public TaskEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Task.class);
	this.setEntityServiceClass(TaskService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	add(tp);
    }

    protected JPanel createCommonPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	taskTypeLabel = new JLabel(getString("panel.label-task-type.text"));
	startDateTimeLabel = new JLabel(getString("panel.label-start-date-time.text"));
	endDateTimeLabel = new JLabel(getString("panel.label-end-date-time.text"));
	taskPriorityLabel = new JLabel(getString("panel.label-task-priority.text"));
	alarmDateTimeLabel = new JLabel(getString("panel.label-alarm-date-time.text"));

	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));
	projectLabel = new JLabel(getString("panel.label-project.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	documentLabel = new JLabel(getString("panel.label-document.text"));

	taskStateLabel = new JLabel(getString("panel.label-task-state.text"));
	donePercentLabel = new JLabel(getString("panel.label-done-percent.text"));

	completedDateTimeLabel = new JLabel(getString("panel.label-completed-date-time.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);
	taskTypeComboEdit = new XComboEdit();
	startDateTimeField = new XDateField();
	endDateTimeField = new XDateField();
	taskPriorityComboEdit = new XComboEdit();
	alarmDateTimeField = new XDateField();

	int comboWidth = 20;
	responsibleComboEdit = new XComboEdit();
	responsibleComboEdit.setColumns(comboWidth);
	projectComboEdit = new XComboEdit(true);
	projectComboEdit.setColumns(comboWidth);
	partnerComboEdit = new XComboEdit(true);
	partnerComboEdit.setColumns(comboWidth);
	documentComboEdit = new XComboEdit(true);
	documentComboEdit.setColumns(comboWidth);

	taskStateComboEdit = new XComboEdit();
	donePercentField = new XNumberField();

	completedDateTimeFiled = new XDateField();

	taskTypeComboEdit.initListFormAction(this, TaskTypeList.class);
	responsibleComboEdit.initListFormAction(this, EmployeeList.class, "fullName");
	projectComboEdit.initListFormAction(this, ProjectList.class);
	partnerComboEdit.initListFormAction(this, PartnerList.class);
	documentComboEdit.initListFormAction(this, DocumentList.class, "title");
	taskPriorityComboEdit.initListFormAction(this, TaskPriorityList.class);
	taskStateComboEdit.initListFormAction(this, TaskStateList.class);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	// LABEL
	editPanel.add(nameLabel);
	editPanel.addByY(codeLabel);
	editPanel.addByY(startDateTimeLabel);
	editPanel.addByY(endDateTimeLabel);

	gbc.gridx = 2;
	gbc.gridy = 1;
	editPanel.add(taskTypeLabel);
	editPanel.addByY(taskPriorityLabel);
	editPanel.addByY(alarmDateTimeLabel);

	// FIELD
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 3;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(nameField);
	gbc.gridwidth = 1;
	editPanel.addByY(codeField);
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(startDateTimeField);
	editPanel.addByY(endDateTimeField);

	gbc.gridx = 3;
	gbc.gridy = 1;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(taskTypeComboEdit);
	editPanel.addByY(taskPriorityComboEdit);
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(alarmDateTimeField);
	editPanel.addSeparator(4);

	gbc.gridx = 0;
	gbc.gridy++;
	int y = gbc.gridy;
	editPanel.add(responsibleLabel);
	editPanel.addByY(projectLabel);
	gbc.gridx = 2;
	gbc.gridy = y;
	editPanel.add(partnerLabel);
	editPanel.addByY(documentLabel);

	gbc.gridx = 1;
	gbc.gridy = y;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(responsibleComboEdit);
	editPanel.addByY(projectComboEdit);
	gbc.gridx = 3;
	gbc.gridy = y;
	editPanel.add(partnerComboEdit);
	editPanel.addByY(documentComboEdit);
	editPanel.addSeparator(4);

	gbc.gridx = 0;
	gbc.gridy++;
	y = gbc.gridy;
	editPanel.add(taskStateLabel);
	editPanel.addByY(donePercentLabel);
	gbc.gridx = 1;
	gbc.gridy = y;
	editPanel.add(taskStateComboEdit);
	editPanel.addByY(donePercentField);

	/*
	 editPanel.addByY(completedDateTimeLabel);
	 editPanel.addByY(completedDateTimeFiled);
	 */

	return editPanel;
    }

    protected JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Task getTask() {
	return (Task) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getTask().getName());
	codeField.setText(getTask().getTaskNo());
	nameField.setText(getTask().getName());
	taskTypeComboEdit.setValue(getTask().getTaskType());
	startDateTimeField.setDate(getTask().getStartDateTime());
	endDateTimeField.setDate(getTask().getEndDateTime());
	taskPriorityComboEdit.setValue(getTask().getTaskPriority());
	alarmDateTimeField.setDate(getTask().getReminderDateTime());
	responsibleComboEdit.setValue(getTask().getResponsible());
	projectComboEdit.setValue(getTask().getProject());
	partnerComboEdit.setValue(getTask().getPartner());
	documentComboEdit.setValue(getTask().getDocument());
	completedDateTimeFiled.setDate(getTask().getActualEndDateTime());
	taskStateComboEdit.setValue(getTask().getTaskStatus());
	donePercentField.setValue(getTask().getPercentComplete());
	noteField.setText(getTask().getDescription());
    }

    protected void populateData() throws ApplicationException {
	getTask().setTaskNo(codeField.getText());
	getTask().setName(nameField.getText());
	getTask().setTaskType((TaskType) taskTypeComboEdit.getValue());
	getTask().setStartDateTime(startDateTimeField.getDate());
	getTask().setEndDateTime(endDateTimeField.getDate());
	getTask().setTaskPriority((TaskPriority) taskPriorityComboEdit.getValue());
	getTask().setReminderDateTime(alarmDateTimeField.getDate());
	getTask().setResponsible((ContactHeader) responsibleComboEdit.getValue());
	getTask().setProject((ProjectHeader) projectComboEdit.getValue());
	getTask().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getTask().setDocument((DocumentHeader) documentComboEdit.getValue());
	getTask().setActualEndDateTime(completedDateTimeFiled.getDate());
	getTask().setTaskStatus((TaskStatus) taskStateComboEdit.getValue());
	getTask().setPercentComplete(donePercentField.doubleValue());
	getTask().setDescription(noteField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getTask().getName(), nameLabel.getText());
	validateRequiredField(buf, getTask().getTaskType(), taskTypeLabel.getText());
	validateRequiredField(buf, getTask().getResponsible(), responsibleLabel.getText());
	validateRequiredField(buf, getTask().getTaskStatus(), taskStateLabel.getText());
	validateRequiredField(buf, getTask().getTaskPriority(),	taskPriorityLabel.getText());
	checkError(buf);
    }

    protected void initData() throws ApplicationException {
	super.initData();

	getTask().setStartDateTime(EnterpriseEnvironment.getDate());
	getTask().setEndDateTime(EnterpriseEnvironment.getDate());

	getTask().setPartner(ProjectEnvironment.getPartner());
	getTask().setTaskType(TaskEnvironment.getTaskType());
	getTask().setTaskStatus(TaskEnvironment.getTaskStatus());
	//getTask().setResponsible(TaskEnvironment.getResponsible());

	getTask().setProject(TaskEnvironment.getProject());
	getTask().setTaskPriority(TaskEnvironment.getTaskPriority());

    }
}
