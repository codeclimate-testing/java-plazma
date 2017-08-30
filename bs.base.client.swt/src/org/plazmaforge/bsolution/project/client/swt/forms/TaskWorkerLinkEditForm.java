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
import org.plazmaforge.bsolution.project.common.beans.TaskWorkerLink;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.CTimeSheet;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: TaskEmployeeLinkEditForm.java,v 1.3 2010/10/11 06:54:41 ohapon Exp $
 */

public class TaskWorkerLinkEditForm extends AbstractEditForm {


    private Label workerLabel;
    private Label workTimeLabel;
    private Label actualTimeLabel;
    private Label workCostLabel;
    private Label descriptionLabel;    
    
    private XComboEdit workerField;
    private CTimeSheet workTimeField;
    private CTimeSheet actualTimeField;
    private XCurrencyField workCostField;
    private XTextArea descriptionField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public TaskWorkerLinkEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("TaskWorkerLinkEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	   	
    	gridLayout.numColumns = 7;
    	
    	setLayout(gridLayout);

    	workerLabel = new Label(this, SWT.NONE);
    	workerLabel.setText(Messages.getString("TaskWorkerLinkEditForm.workerLabel.text")); //$NON-NLS-1$

    	workerField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1);
    	gridData.widthHint = 300;
    	workerField.setLayoutData(gridData);
    	workerField.setAssociationValueClass(Contact.class);
    	
    	////
    	
    	workTimeLabel = new Label(this, SWT.NONE);
    	workTimeLabel.setText(Messages.getString("TaskWorkerLinkEditForm.workTimeLabel.text")); //$NON-NLS-1$

    	workTimeField = new CTimeSheet(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1);
    	workTimeField.setLayoutData(gridData);

    	////

    	actualTimeLabel = new Label(this, SWT.NONE);
    	actualTimeLabel.setText(Messages.getString("TaskWorkerLinkEditForm.actualTimeLabel.text")); //$NON-NLS-1$

    	actualTimeField = new CTimeSheet(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1);
    	actualTimeField.setLayoutData(gridData);

    	////
    	
    	workCostLabel = new Label(this, SWT.NONE);
    	workCostLabel.setText(Messages.getString("TaskWorkerLinkEditForm.workCostLabel.text")); //$NON-NLS-1$
    	workCostField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.NONE, SWT.CENTER, false, false, 6, 1);
    	gridData.widthHint = 100;
    	workCostField.setLayoutData(gridData);
    	
    	descriptionLabel = new Label(this, SWT.NONE);
	descriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	descriptionLabel.setText(Messages.getString("TaskWorkerLinkEditForm.descriptionLabel.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(this, SWT.BORDER | SWT.MULTI);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1);
    	gridData.heightHint = 100;
    	descriptionField.setLayoutData(gridData);  
    	descriptionField.setTextLimit(100);

    	this.setSize(new Point(574, 298));
    }
    
    
    protected void bindControls() {
	bindControl(workerField, "worker", workerLabel, REQUIRED);	
	bindControl(descriptionField, "description");
	bindControl(workCostField, "workCost");
    }
    
    private TaskWorkerLink getTaskWorkerLink() {
	return (TaskWorkerLink) getEntity();
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	workTimeField.setTimeSheet(getTaskWorkerLink().getWorkTime());
	actualTimeField.setTimeSheet(getTaskWorkerLink().getActualTime());
    }
    
    public void updateData() throws ApplicationException {
	super.updateData();
	getTaskWorkerLink().setWorkTime(workTimeField.getTimeSheet());
	getTaskWorkerLink().setActualTime(actualTimeField.getTimeSheet());
    }
    

}  //  @jve:decl-index=0:visual-constraint="10,10"


