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

package org.plazmaforge.bsolution.pim.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.pim.common.beans.PIMReminder;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XDateTimeCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class PIMReminderEditForm extends AbstractEditForm {

    
    private Label nameLabel;
 
    private Label eventDateTimeLabel;
    
    
    private XTextField nameField;
    
    private XDateTimeCombo eventDateTimeField;
    
    private XTextArea descriptionField;

   
    
    ////
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PIMReminderEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem descriptionTabItem;
	Composite composite;
	GridLayout gridLayout;
	
	setTitle(Messages.getString("PIMReminderEditForm.title")); //$NON-NLS-1$
	
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	

	setLayout(gridLayout);
	GridData gridData;
	
    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PIMReminderEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setText(Messages.getString("PIMReminderEditForm.nameLabel.text")); //$NON-NLS-1$
    
    	nameField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);



    	eventDateTimeLabel = new Label(composite, SWT.NONE);
    	eventDateTimeLabel.setLayoutData(new GridData());
    	eventDateTimeLabel.setText(Messages.getString("PIMReminderEditForm.eventDateTimeLabel.text")); //$NON-NLS-1$

    	eventDateTimeField = new XDateTimeCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	eventDateTimeField.setLayoutData(gridData);

    	////
    	
    	
    	descriptionTabItem = new TabItem(tabFolder, SWT.NONE);
    	descriptionTabItem.setText(Messages.getString("PIMReminderEditForm.descriptionTabItem.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(tabFolder, SWT.MULTI);
    	descriptionField.setTextLimit(255);
    	descriptionField.setFixedHeight(100);
    	descriptionTabItem.setControl(descriptionField);
    	
 	

    }
    
    private PIMReminder getReminder() {
	return (PIMReminder) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getReminder().setUser(getCurrentUser());
    }
	
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(eventDateTimeField, "eventDateTime", eventDateTimeLabel, REQUIRED);	
	bindControl(descriptionField, "description");
    }
    
    protected User getCurrentUser() {
	return EnterpriseEnvironment.getUser(getEnterpriseContext());
    }
    
    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }


}
