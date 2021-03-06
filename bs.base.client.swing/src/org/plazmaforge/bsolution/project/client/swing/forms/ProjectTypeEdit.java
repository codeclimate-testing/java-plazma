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
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.services.ProjectTypeService;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class ProjectTypeEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel noteLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XTextEdit noteField;

    public ProjectTypeEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(ProjectType.class);
	this.setEntityServiceClass(ProjectTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	noteLabel = new JLabel(getString("panel.label-note.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(30);
	nameField.setMaxChar(30);
	noteField = new XTextEdit();
	noteField.setColumns(30);
	noteField.setRows(8);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(noteLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	gbc.gridheight = 8;
	editPanel.addByY(noteField);

	add(editPanel);
    }

    private ProjectType getProjectType() {
	return (ProjectType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getProjectType().getName());
	codeField.setText(getProjectType().getCode());
	nameField.setText(getProjectType().getName());
	noteField.setText(getProjectType().getNote());
    }

    protected void populateData() throws ApplicationException {
	getProjectType().setCode(codeField.getText());
	getProjectType().setName(nameField.getText());
	getProjectType().setNote(noteField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getProjectType().getName(), nameLabel.getText());
	checkError(buf);
    }

}
