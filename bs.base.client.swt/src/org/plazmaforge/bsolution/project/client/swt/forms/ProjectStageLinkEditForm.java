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
 * Created on 22.08.2007
 *
 */

package org.plazmaforge.bsolution.project.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: ProjectStageLinkEditForm.java,v 1.2 2010/04/28 06:31:01 ohapon Exp $
 */

public class ProjectStageLinkEditForm extends AbstractEditForm {

    
    private Label nameLabel;
    
    private Label projectStageLabel;
    
    private Label startDateLabel;
    
    private Label actualStartDateLabel;
    
    private Label endDateLabel;
    
    private Label actualEndDateLabel;
    
    
    
    
    
    private XTextField nameField;
    
    private XComboEdit projectStageField;
    
    private XDateCombo startDateField;    
    
    private XDateCombo actualStartDateField;
    
    private XDateCombo endDateField;    
    
    private XDateCombo actualEndDateField;
    
    
   
    

    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ProjectStageLinkEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setDataSourceSupport(false);
	
	setTitle(Messages.getString("ProjectStageLinkEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    

    	nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("ProjectStageLinkEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 250;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);

    	projectStageLabel = new Label(this, SWT.NONE);
    	projectStageLabel.setText(Messages.getString("ProjectStageLinkEditForm.projectStageLabel.text")); //$NON-NLS-1$

    	projectStageField = new XComboEdit(this, SWT.BORDER);
    	projectStageField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	startDateLabel = new Label(this, SWT.NONE);
    	startDateLabel.setText(Messages.getString("ProjectStageLinkEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(this, SWT.BORDER);
    	startDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	actualStartDateLabel = new Label(this, SWT.NONE);
    	actualStartDateLabel.setText(Messages.getString("ProjectStageLinkEditForm.actualStartDateLabel.text")); //$NON-NLS-1$

    	actualStartDateField = new XDateCombo(this, SWT.BORDER);
    	actualStartDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	
    	endDateLabel = new Label(this, SWT.NONE);
    	endDateLabel.setText(Messages.getString("ProjectStageLinkEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(this, SWT.BORDER);
    	endDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	actualEndDateLabel = new Label(this, SWT.NONE);
    	actualEndDateLabel.setText(Messages.getString("ProjectStageLinkEditForm.actualEndDateLabel.text")); //$NON-NLS-1$

    	actualEndDateField = new XDateCombo(this, SWT.BORDER);
    	actualEndDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(projectStageField, "projectStage", projectStageLabel, REQUIRED);
	bindControl(startDateField, "startDate", startDateLabel, REQUIRED);
	bindControl(actualStartDateField, "actualStartDate", actualStartDateLabel, REQUIRED);
	bindControl(endDateField, "endDate", endDateLabel, REQUIRED);
	bindControl(actualEndDateField, "actualEndDate", actualEndDateLabel, REQUIRED);

    }

}  //  @jve:decl-index=0:visual-constraint="10,10"



