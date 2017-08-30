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

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.common.DataTypeController;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XDataTypeComboBox;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XEntityComboBox;
import org.plazmaforge.bsolution.base.common.services.SystemVariableService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.forms.ListForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.data.Variable;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.model.DataType;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.ext.service.ServiceFactory;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created on 24.05.2006
 */
public class SystemVariableEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel dataTypeLabel;

    private JLabel dictionaryLabel;

    private JLabel expressionLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XDataTypeComboBox dataTypeField;

    private XEntityComboBox dictionaryComboBox;

    private DataTypeController controller;

    private IEntityConfig currentEntity;

    public SystemVariableEdit() {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setPackMode(false);
	this.setEntityClass(Variable.class);
	this.setEntityServiceClass(SystemVariableService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	controller = new DataTypeController();
	controller.getDictionaryValueField().initListFormAction(this, null);

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	dataTypeLabel = new JLabel(getString("panel.label-data-type.text"));
	dictionaryLabel = new JLabel(getString("panel.label-dictionary.text"));
	expressionLabel = new JLabel(getString("panel.label-expression.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);
	dataTypeField = new XDataTypeComboBox();
	dictionaryComboBox = new XEntityComboBox("DICTIONARY");

	dataTypeField.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		DataType dataType = (DataType) dataTypeField.getValue();
		controller.setDataType(dataType);
		boolean isDictionary = (dataType != null)
			&& DataType.REFERENCE_TYPE.equals(dataType.getKey());
		setDictionaryVisible(isDictionary);
		revalidate();
	    }

	});

	dictionaryComboBox.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		XComboEdit edit = null;
		try {
		    edit = controller.getDictionaryValueField();

		    EntityConfig entity = (EntityConfig) dictionaryComboBox
			    .getValue();
		    if (entity == null) {
			edit.setValue(null);
			edit.setListFormClass(null);
			return;
		    }

		    if (currentEntity == null
			    || !entity.getConfigId().equals(currentEntity.getConfigId())) {
			edit.setValue(null);
		    }
		    currentEntity = entity;

		    Association association = getAssociation(entity);
		    if (association == null) {
			throw new ApplicationException("Association is null");
		    }
		    Class klass = association.getElementByType(ListForm.class);
		    if (klass == null) {
			throw new ApplicationException(
				"Class of ListForm is null");
		    }
		    edit.setListFormClass(klass);
		} catch (ApplicationException ex) {
		    if (edit != null) {
			edit.setValue(null);
			edit.setListFormClass(null);
		    }
		    ex.printStackTrace();
		}
	    }

	});

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;
	java.util.List components = controller.getComponents();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(dataTypeLabel);
	editPanel.addByY(dictionaryLabel);
	editPanel.addByY(expressionLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 1;
	editPanel.addByX(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	gbc.gridwidth = 1;
	editPanel.addByY(dataTypeField);
	gbc.gridwidth = 1;
	editPanel.addByY(dictionaryComboBox);

	gbc.gridy++;
	for (int i = 0; i < components.size(); i++) {
	    editPanel.add((JComponent) components.get(i), gbc);
	}

	setDictionaryVisible(false);

	add(editPanel);
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(600, 250);
    }

    private Variable getSystemVariable() {
	return (Variable) this.getEntity();
    }

    private void setDictionaryVisible(boolean isVisible) {
	dictionaryLabel.setVisible(isVisible);
	dictionaryComboBox.setVisible(isVisible);
	if (!isVisible) {
	    dictionaryComboBox.setValue(null);
	}
    }

    protected void updateView() throws ApplicationException {

	String code = getSystemVariable().getCode();
	String name = getSystemVariable().getName();
	DataType dataType = getSystemVariable().getDataType();
	IEntityConfig entity = getSystemVariable().getValueEntity();
	Object value = getSystemVariable().getValue();
	
	controller.setDataType(dataType);
	
	appendTitle(code);
	codeField.setText(code);
	nameField.setText(name);
	dataTypeField.setValue(dataType);

	currentEntity = entity;
	dictionaryComboBox.setValue(entity);

	if (dataType == null || !dataType.isReference()) {
	    controller.setValue(value);
	    return;
	}
	
	if (entity == null) {
	    return;
	}
	Integer key = (Integer) value;
	if (key == null) {
	    return;
	}
	Association association = getAssociation(entity);
	if (association == null) {
	    return;
	}
	Class klass = association.getElementByType(Service.class);
	if (klass == null) {
	    return;
	}
	EntityService service = (EntityService) ServiceFactory.getService(klass);

	Object obj = service.findHeaderById(key);
	controller.getDictionaryValueField().setValue(obj);
	controller.getDictionaryValueField().repaint();

    }

    private Association getAssociation(IEntityConfig entity)
	    throws ApplicationException {
	if (entity == null) {
	    return null;
	}
	Association association = AssociationManager.getAssociation(entity.getConfigId());
	if (association == null) {
	    association = AssociationManager.getAssociationByEntity(entity);
	}
	return association;
    }

    protected void populateData() throws ApplicationException {
	getSystemVariable().setCode(codeField.getText());
	getSystemVariable().setName(nameField.getText());
	getSystemVariable().setDataType((DataType) dataTypeField.getValue());

	getSystemVariable().setValue(controller.getValue());

	getSystemVariable().setValueEntity(
		(EntityConfig) dictionaryComboBox.getValue());

    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getSystemVariable().getName(), codeLabel
		.getText());
	checkError(buf);
    }

}
