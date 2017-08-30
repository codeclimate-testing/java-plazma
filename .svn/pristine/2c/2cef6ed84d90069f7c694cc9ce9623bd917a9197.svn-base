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
 * Created on 09.05.2008
 *
 */

package org.plazmaforge.bsolution.carservice.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormInitializer;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: CarEditForm.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */

public class CarEditForm extends AbstractEditForm {

    private final static int FIELD_WIDTH = 130;
    
    
    private Label markLabel;
    private Label modelLabel;
    private Label regNumberLabel;
    private Label chassisNumberLabel;
    private Label engineVolumeLabel;
    private Label manufactureYearLabel;
    private Label ownerLabel;
    
    private XComboEdit markField;
    private XComboEdit modelField;    
    private XTextField regNumberField;
    private XTextField chassisNumberField;    
    private XNumberField engineVolumeField;
    private XIntegerField manufactureYearField;
    private XComboEdit ownerField;
    
    
    private CarMarkAndModelProvider carMarkAndModelProvider = new CarMarkAndModelProvider();
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("CarEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    	
    	//

    	markLabel = new Label(this, SWT.NONE);
    	markLabel.setText(Messages.getString("CarEditForm.markLabel.text")); //$NON-NLS-1$

    	markField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.ADD_BUTTON);
    	markField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	
    	

	modelLabel = new Label(this, SWT.NONE);
	modelLabel.setText(Messages.getString("CarEditForm.modelLabel.text")); //$NON-NLS-1$

	modelField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.ADD_BUTTON);
	modelField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	
	//
    	
    	regNumberLabel = new Label(this, SWT.NONE);
    	regNumberLabel.setText(Messages.getString("CarEditForm.regNumberLabel.text")); //$NON-NLS-1$

    	regNumberField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	regNumberField.setLayoutData(gridData);
    	regNumberField.setTextLimit(20);
    	
    	chassisNumberLabel = new Label(this, SWT.NONE);
    	chassisNumberLabel.setText(Messages.getString("CarEditForm.chassisNumberLabel.text")); //$NON-NLS-1$

    	chassisNumberField = new XTextField(this, SWT.BORDER);
    	gridData.widthHint = FIELD_WIDTH;
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	chassisNumberField.setLayoutData(gridData);
    	chassisNumberField.setTextLimit(20);
    	
    	//
    	
  	engineVolumeLabel = new Label(this, SWT.NONE);
  	engineVolumeLabel.setText(Messages.getString("CarEditForm.engineVolumeLabel.text")); //$NON-NLS-1$

  	engineVolumeField = new XNumberField(this, SWT.BORDER);
  	gridData.widthHint = FIELD_WIDTH;
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	engineVolumeField.setLayoutData(gridData);
    	
	manufactureYearLabel = new Label(this, SWT.NONE);
	manufactureYearLabel.setText(Messages.getString("CarEditForm.manufactureYearLabel.text")); //$NON-NLS-1$

	manufactureYearField = new XIntegerField(this, SWT.BORDER);
	manufactureYearField.setPattern("###0");
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	manufactureYearField.setLayoutData(gridData);
    	

    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	carMarkAndModelProvider.setMarkField(markField);
    	carMarkAndModelProvider.setModelField(modelField);
    	carMarkAndModelProvider.init();
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	
    	
    	
    	ownerLabel = new Label(this, SWT.NONE);
	ownerLabel.setText(Messages.getString("CarEditForm.ownerLabel.text")); //$NON-NLS-1$

    	ownerField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.ADD_BUTTON);
    	ownerField.setAssociationValueClass(Partner.class);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
    	gridData.widthHint = 250;
    	ownerField.setLayoutData(gridData);

    	//
    	
    	ownerField.setEditFormInitializer(new IEditFormInitializer() {
    	    public void initEditForm(IEditForm editForm) {
    		if (editForm == null || !editForm.isAddMode()) {
    		    return;
    		}
    		// Reset child mode because this form by default has child mode = true
    		editForm.setChildFormMode(false);
    	    }
    	});

    	
    	this.setSize(new Point(470, 108));
    }
    
    
    
    //private boolean isLoadData = false;
    
    @Override
    public void updateForm() throws ApplicationException {
        super.updateForm();
        //isLoadData = true;
        carMarkAndModelProvider.refresh();
    }
    
    protected void bindControls() {
	bindControl(ownerField, "partner", ownerLabel, REQUIRED);
	
	bindControl(markField, "carMark");
	bindControl(modelField, "carModel");
	//bindControl(classField, "carClass"); // disable: customer request
	bindControl(regNumberField, "regNumber");
	bindControl(chassisNumberField, "chassisNumber");
	bindControl(engineVolumeField, "engineVolume");
	bindControl(manufactureYearField, "manufactureYear");
    }

}
