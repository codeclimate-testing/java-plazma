/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 06.02.2007
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
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: ProjectStageEditForm.java,v 1.1 2008/12/01 12:27:17 ohapon Exp $
 */

public class ProjectStageEditForm extends AbstractEditForm {

    private Label codeLabel;
    
    private Label nameLabel;
    
    private Label projectStageGroupLabel;
    
    private Label projectTypeLabel;
    
    private Label orderNumberLabel;
    
    private Label fromBeginLabel;
    
    private Label averangeDurationLabel;
    
    private Label descriptionLabel;
    
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XComboEdit projectStageGroupField;
    
    private XComboEdit projectTypeField;    
    
    private XIntegerField orderNumberField;
    
    private XIntegerField fromBeginField;
    
    private XIntegerField averangeDurationField;    
    
    private XTextArea descriptionField;  
   
    

    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ProjectStageEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("ProjectStageEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
    	codeLabel.setText(Messages.getString("ProjectStageEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	codeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	codeField.setTextLimit(20);

    	nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("ProjectStageEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 250;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);

    	projectStageGroupLabel = new Label(this, SWT.NONE);
    	projectStageGroupLabel.setText(Messages.getString("ProjectStageEditForm.projectStageGroupLabel.text")); //$NON-NLS-1$

    	projectStageGroupField = new XComboEdit(this, SWT.BORDER);
    	projectStageGroupField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	projectTypeLabel = new Label(this, SWT.NONE);
    	projectTypeLabel.setText(Messages.getString("ProjectStageEditForm.projectTypeLabel.text")); //$NON-NLS-1$

    	projectTypeField = new XComboEdit(this, SWT.BORDER);
    	projectTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	orderNumberLabel = new Label(this, SWT.NONE);
    	orderNumberLabel.setText(Messages.getString("ProjectStageEditForm.orderNumberLabel.text")); //$NON-NLS-1$

    	orderNumberField = new XIntegerField(this, SWT.BORDER);
    	orderNumberField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	fromBeginLabel = new Label(this, SWT.NONE);
    	fromBeginLabel.setText(Messages.getString("ProjectStageEditForm.fromBeginLabel.text")); //$NON-NLS-1$

    	fromBeginField = new XIntegerField(this, SWT.BORDER);
    	fromBeginField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	averangeDurationLabel = new Label(this, SWT.NONE);
    	averangeDurationLabel.setText(Messages.getString("ProjectStageEditForm.averangeDurationLabel.text")); //$NON-NLS-1$

    	averangeDurationField = new XIntegerField(this, SWT.BORDER);
    	averangeDurationField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	
    	descriptionLabel = new Label(this, SWT.NONE);
    	descriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	descriptionLabel.setText(Messages.getString("ProjectStageEditForm.descriptionLabel.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(this, SWT.BORDER | SWT.MULTI);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    	gridData.heightHint = 100;
    	gridData.widthHint = 250;
    	descriptionField.setLayoutData(gridData);
    	descriptionField.setTextLimit(100);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(projectStageGroupField, "projectStageGroup", projectStageGroupLabel, REQUIRED);
	bindControl(projectTypeField, "projectType", projectTypeLabel, REQUIRED);
	bindControl(orderNumberField, "orderNumber", Integer.TYPE);
	bindControl(fromBeginField, "fromBegin", Integer.TYPE);
	bindControl(averangeDurationField, "averangeDuration", Integer.TYPE);	
	bindControl(descriptionField, "description");	
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"


