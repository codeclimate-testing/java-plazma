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
import org.plazmaforge.bsolution.project.common.beans.ProjectStage;
import org.plazmaforge.bsolution.project.common.beans.ProjectStageGroup;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.services.ProjectStageService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XIntegerField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class ProjectStageEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel projectStageGroupLabel;

    private JLabel projectTypeLabel;

    private JLabel orderNumberLabel;

    private JLabel fromBeginLabel;

    private JLabel averangeDurationLabel;

    private JLabel noteLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XComboEdit projectStageGroupComboEdit;

    private XComboEdit projectTypeComboEdit;

    private XIntegerField orderNumberField;

    private XIntegerField fromBeginField;

    private XIntegerField averangeDurationField;

    private XTextEdit noteField;

    public ProjectStageEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(ProjectStage.class);
	this.setEntityServiceClass(ProjectStageService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	projectStageGroupLabel = new JLabel(getString("panel.label-project-stage-group.text"));
	projectTypeLabel = new JLabel(getString("panel.label-project-type.text"));
	orderNumberLabel = new JLabel(getString("panel.label-order-number.text"));
	fromBeginLabel = new JLabel(getString("panel.label-from-begin.text"));
	averangeDurationLabel = new JLabel(getString("panel.label-averange-duration.text"));
	noteLabel = new JLabel(getString("panel.label-note.text"));

	codeField = new XTextField(15);
	codeField.setMaxChar(20);
	nameField = new XTextField(30);
	nameField.setMaxChar(30);
	projectStageGroupComboEdit = new XComboEdit();
	projectTypeComboEdit = new XComboEdit();
	orderNumberField = new XIntegerField();
	fromBeginField = new XIntegerField();
	averangeDurationField = new XIntegerField();
	noteField = new XTextEdit();
	noteField.setColumns(30);
	noteField.setRows(8);

	projectStageGroupComboEdit.initListFormAction(this, ProjectStageGroupList.class);
	projectTypeComboEdit.initListFormAction(this, ProjectTypeList.class);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(projectStageGroupLabel);
	editPanel.addByY(projectTypeLabel);
	editPanel.addByY(orderNumberLabel);
	editPanel.addByY(fromBeginLabel);
	editPanel.addByY(averangeDurationLabel);
	editPanel.addByY(noteLabel);

	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	editPanel.addByY(projectStageGroupComboEdit);
	editPanel.addByY(projectTypeComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(orderNumberField);
	editPanel.addByY(fromBeginField);
	editPanel.addByY(averangeDurationField);
	gbc.gridwidth = 2;
	gbc.gridheight = 8;
	editPanel.addByY(noteField);

	add(editPanel);
    }

    private ProjectStage getProjectStage() {
	return (ProjectStage) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getProjectStage().getName());
	codeField.setText(getProjectStage().getCode());
	nameField.setText(getProjectStage().getName());
	orderNumberField.setValue(getProjectStage().getOrderNumber());
	averangeDurationField.setValue(getProjectStage().getAverangeDuration());
	fromBeginField.setValue(getProjectStage().getFromBegin());
	projectTypeComboEdit.setValue(getProjectStage().getProjectType());
	projectStageGroupComboEdit.setValue(getProjectStage().getProjectStageGroup());
	noteField.setText(getProjectStage().getNote());
    }

    protected void populateData() throws ApplicationException {
	getProjectStage().setCode(codeField.getText());
	getProjectStage().setName(nameField.getText());
	getProjectStage().setOrderNumber(orderNumberField.intValue());
	getProjectStage().setAverangeDuration(averangeDurationField.intValue());
	getProjectStage().setFromBegin(fromBeginField.intValue());
	getProjectStage().setProjectType((ProjectType) projectTypeComboEdit.getValue());
	getProjectStage().setProjectStageGroup((ProjectStageGroup) projectStageGroupComboEdit.getValue());
	getProjectStage().setNote(noteField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getProjectStage().getName(), nameLabel.getText());
	validateRequiredField(buf, getProjectStage().getProjectType(), projectTypeLabel.getText());
	validateRequiredField(buf, getProjectStage().getProjectStageGroup(), projectStageGroupLabel.getText());
	checkError(buf);
    }

}
