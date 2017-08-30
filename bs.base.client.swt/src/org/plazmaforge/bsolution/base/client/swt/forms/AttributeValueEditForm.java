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

/* 
 * Created on 18.08.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.client.swt.forms.common.DataTypeController;
import org.plazmaforge.bsolution.base.common.services.DataTypeService;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeValue;
import org.plazmaforge.framework.ext.model.DataType;


/** 
 * @author Oleh Hapon
 * $Id: AttributeValueEditForm.java,v 1.8 2010/12/05 07:57:20 ohapon Exp $
 */

public class AttributeValueEditForm extends AbstractEditForm {
    
    private Label nameLabel;
    private Label dataTypeLabel;
    private Label valueLabel;
    
    private XTextField nameField;
    private XComboEdit dataTypeField;


    private DataTypeController controller;

    
    private Attribute attribute;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public AttributeValueEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    

    private void initialize() {
	
	setDataSourceSupport(false);
	
	setTitle(Messages.getString("AttributeValueEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);


	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);

	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("AttributeValueEditForm.nameLabel.text")); //$NON-NLS-1$

	nameField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	gridData.widthHint = 200;
	nameField.setLayoutData(gridData);
	nameField.setTextLimit(50);

	dataTypeLabel = new Label(this, SWT.NONE);
	dataTypeLabel.setText(Messages.getString("AttributeValueEditForm.dataTypeLabel.text")); //$NON-NLS-1$

	dataTypeField = new XComboEdit(this, SWT.BORDER);
	dataTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
		false));
	dataTypeField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		selectDataType();
	    }
	});
	dataTypeField.setEntityClass(DataType.class);
	dataTypeField.setServiceClass(DataTypeService.class);

	valueLabel = new Label(this, SWT.NONE);
	valueLabel.setText(Messages.getString("AttributeValueEditForm.valueLabel.text")); //$NON-NLS-1$
    	controller = new DataTypeController(this); 
    	
    	setEntityClass(AttributeValue.class);
	
    	this.setSize(new Point(470, 108));
    }
    
    
    protected void selectDataType() {
	selectDataType((DataType) dataTypeField.getValue());
    }

    protected void selectDataType(DataType dataType) {
	controller.setDataType(dataType);
	layout();
	getParent().getParent().pack();
    }

    protected void bindControls() {
	if (!isVisibleAttributeControls()) {
	    return;
	}
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(dataTypeField, "dataType", dataTypeLabel, REQUIRED);
    }
    
    private AttributeValue getAttributeValue() {
	return (AttributeValue) getEntity();
    }
    
    public void initData() throws ApplicationException {
	DataType defaultDataType = (DataType) dataTypeField.getValue(0); 
	Attribute attribute = getAttribute();
	if (attribute == null) {
	    attribute = new Attribute();
	    attribute.setDataType(defaultDataType);
	} else {
	    defaultDataType = getAttribute().getDataType();
	}
	getAttributeValue().setAttribute(attribute);
	getAttributeValue().setDataType(defaultDataType);
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	
	setControlsVisibleByMode(isVisibleAttributeControls());
	selectDataType(getAttributeValue().getDataType());
	
	controller.setEntity(getAttributeValue().getValueEntity());
	controller.setValue(getAttributeValue().getValue());
    }
    
    protected boolean isVisibleAttributeControls() {
	return isNewAttribute();
    }

    protected boolean isNewAttribute() {
	return isAddMode() && getAttribute() == null;
    }

    public void updateData() throws ApplicationException {
	super.updateData();
	if (getAttributeValue().getCode() == null) {
	    getAttributeValue().setCode(getAttributeValue().getName());
	}
	
	getAttributeValue().setValueEntity(controller.getEntity());
	getAttributeValue().setValue(controller.getValue());
	
	if (isNewAttribute()) {
	    getAttributeValue().getAttribute().setDataType(getAttributeValue().getDataType());
	    getAttributeValue().getAttribute().setValueEntity(getAttributeValue().getValueEntity());
	}
    }
    
    protected void setControlsVisibleByMode(boolean visible) {
	setControlVisible(nameLabel, visible);
	setControlVisible(nameField, visible);
	setControlVisible(dataTypeLabel, visible);
	setControlVisible(dataTypeField, visible);
    }
    
    protected void setControlVisible(Control control, boolean visible) {
	if (control == null) {
	    return;
	}
	control.setVisible(visible);
	Object layoutData = control.getLayoutData();
	if (layoutData == null) {
	    return;
	}
	if (layoutData instanceof GridData) {
	    ((GridData) layoutData).exclude = !visible;
	}
    }


    public Attribute getAttribute() {
        return attribute;
    }


    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
    
    

}  //  @jve:decl-index=0:visual-constraint="10,10"