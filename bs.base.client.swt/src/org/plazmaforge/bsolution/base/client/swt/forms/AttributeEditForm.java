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
 * Created on 22.09.2007
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
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.common.services.AttributeService;
import org.plazmaforge.bsolution.base.common.services.DataTypeService;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.DataType;


/** 
 * @author Oleh Hapon
 * $Id: AttributeEditForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class AttributeEditForm extends AbstractEditForm {
    
    //private Label codeLabel;
    private Label nameLabel;
    private Label dataTypeLabel;
    
    //private XTextField codeField;
    private XTextField nameField;
    private XComboEdit dataTypeField;


    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public AttributeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    

    private void initialize() {
	
	setDataSourceSupport(false);
	
	setTitle(Messages.getString("AttributeEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);


	//codeLabel = new Label(this, SWT.NONE);
	//codeLabel.setText("Code");

	//codeField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	//codeField.setLayoutData(gridData);
	//codeField.setTextLimit(50);

	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("AttributeEditForm.nameLabel.text")); //$NON-NLS-1$

	nameField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	gridData.widthHint = 200;
	nameField.setLayoutData(gridData);
	nameField.setTextLimit(50);

	dataTypeLabel = new Label(this, SWT.NONE);
	dataTypeLabel.setText(Messages.getString("AttributeEditForm.dataTypeLabel.text")); //$NON-NLS-1$

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

	setEntityClass(Attribute.class);
	setEntityServiceClass(AttributeService.class);
	
    	this.setSize(new Point(470, 108));
    }
    
    
    protected void selectDataType() {
	selectDataType((DataType) dataTypeField.getValue());
    }

    protected void selectDataType(DataType dataType) {
	layout();
    }

    protected void bindControls() {
	//addMapControl(codeField, "code", codeLabel, REQUIRED);
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(dataTypeField, "dataType", dataTypeLabel, REQUIRED);
    }
    
    private Attribute getAttribute() {
	return (Attribute) getEntity();
    }
    
    public void initData() throws ApplicationException {
	//
	Object parentEntity = getParentEntity();
	if (parentEntity != null) {
	    if (parentEntity instanceof EntityConfig) {
		Attribute attribute = getAttribute();
		attribute.setEntity((EntityConfig) parentEntity);
	    }
	}
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
    }
    

    public void updateData() throws ApplicationException {
	super.updateData();
    }
  
 
    
    

}  //  @jve:decl-index=0:visual-constraint="10,10"