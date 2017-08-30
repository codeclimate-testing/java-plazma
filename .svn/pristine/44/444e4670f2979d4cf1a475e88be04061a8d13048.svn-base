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
 * Created on 21.08.2007
 *
 */

package org.plazmaforge.bsolution.project.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/** 
 * @author Oleh Hapon
 * $Id: TaskContactLinkEditForm.java,v 1.3 2010/10/11 06:54:41 ohapon Exp $
 */

public class TaskContactLinkEditForm extends AbstractEditForm {


    private Label contactLabel;
    private Label taskRoleLabel;
    private Label descriptionLabel;
    
    private XComboEdit contactField;
    private XComboEdit taskRoleField;
    private XTextArea descriptionField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TaskContactLinkEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("TaskContactLinkEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	   	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	contactLabel = new Label(this, SWT.NONE);
    	contactLabel.setText(Messages.getString("TaskContactLinkEditForm.contactLabel.text")); //$NON-NLS-1$

    	contactField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	contactField.setLayoutData(gridData);
    	
    	//
    	
    	taskRoleLabel = new Label(this, SWT.NONE);
    	taskRoleLabel.setText(Messages.getString("TaskContactLinkEditForm.taskRoleLabel.text")); //$NON-NLS-1$

    	taskRoleField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	taskRoleField.setLayoutData(gridData);
    
    	
    	descriptionLabel = new Label(this, SWT.NONE);
	descriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	descriptionLabel.setText(Messages.getString("TaskContactLinkEditForm.descriptionLabel.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(this, SWT.BORDER | SWT.MULTI);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.heightHint = 100;
    	descriptionField.setLayoutData(gridData);  
    	descriptionField.setTextLimit(100);

    	contactField.setAssociationValueClass(Contact.class);
    	
    	this.setSize(new Point(574, 298));
    }
    
    
    protected void bindControls() {
	bindControl(contactField, "contact", contactLabel, REQUIRED);	
	bindControl(taskRoleField, "taskRole", taskRoleLabel, REQUIRED);
	bindControl(descriptionField, "description");
    }
    
   
    

}  //  @jve:decl-index=0:visual-constraint="10,10"

