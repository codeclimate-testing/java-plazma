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

package org.plazmaforge.bsolution.base.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.ext.model.File;

/** 
 * @author Oleh Hapon
 * $Id: FileEditForm.java,v 1.3 2010/12/05 07:57:20 ohapon Exp $
 */

public class FileEditForm extends AbstractEditForm {


    private Label fileNameLabel;
    private Label nameLabel;
    private Label descriptionLabel;
    
    private XTextField fileNameField;
    private XTextField nameField;
    private XTextField descriptionField;

    
    private Button fileBrowseButton;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public FileEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    

    private void initialize() {
	
	setDataSourceSupport(false);
	
	setTitle(Messages.getString("FileEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 3;
	setLayout(gridLayout);


	
	fileNameLabel = new Label(this, SWT.NONE);
	fileNameLabel.setText(Messages.getString("FileEditForm.fileNameLabel.text")); //$NON-NLS-1$

	fileNameField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	gridData.widthHint = 200;
	fileNameField.setLayoutData(gridData);
	fileNameField.setTextLimit(255);

	
	fileBrowseButton = new Button(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	fileNameField.setLayoutData(gridData);
    	fileBrowseButton.setText(Messages.getString("FileEditForm.fileBrowseButton.text")); //$NON-NLS-1$
    	fileBrowseButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			chooseFile();
		}
	});
    	
	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("FileEditForm.nameLabel.text")); //$NON-NLS-1$

	nameField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	gridData.widthHint = 300;
	nameField.setLayoutData(gridData);
	nameField.setTextLimit(50);

	
	descriptionLabel = new Label(this, SWT.NONE);
	descriptionLabel.setText(Messages.getString("FileEditForm.descriptionLabel.text")); //$NON-NLS-1$

	descriptionField = new XTextField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	gridData.widthHint = 300;
	descriptionField.setLayoutData(gridData);
	descriptionField.setTextLimit(50);
	
	setEntityClass(File.class);
	
   	this.setSize(new Point(470, 108));
    }
    
    
    protected void bindControls() {
	bindControl(fileNameField, "fileName", fileNameLabel, REQUIRED);
	bindControl(nameField, "name");
	bindControl(descriptionField, "description");
    }
    
    protected void chooseFile() {
	FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
	String fileName = fileDialog.open();
	if (fileName == null || fileName.trim().length() == 0) {
	    fileName = "";
	}
	fileNameField.setText(fileName);
    }

}
