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
 * Created on 11.07.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: PersonJobEditForm.java,v 1.2 2010/04/28 06:31:02 ohapon Exp $
 */

public class PersonJobEditForm extends AbstractPersonableEdit {
    
    private Label startDateLabel;
    private Label endDateLabel;
    private Label organizationLabel;
    private Label positionLabel;
    
  
    private XDateCombo startDateField;
    private XDateCombo endDateField;
    private XTextField organizationField;
    private XTextField positionField;

    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PersonJobEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("PersonJobEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 4;
	setLayout(gridLayout);
    	
	startDateLabel = new Label(this, SWT.NONE);
	startDateLabel.setText(Messages.getString("PersonJobEditForm.startDateLabel.text")); //$NON-NLS-1$

	startDateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	startDateField.setLayoutData(gridData);
    	
    	
    	
    	endDateLabel = new Label(this, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	endDateLabel.setLayoutData(gridData);
    	endDateLabel.setText(Messages.getString("PersonJobEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	endDateField.setLayoutData(gridData);
    	
    	
    	organizationLabel = new Label(this, SWT.NONE);
    	organizationLabel.setText(Messages.getString("PersonJobEditForm.organizationLabel.text")); //$NON-NLS-1$

    	organizationField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	organizationField.setLayoutData(gridData);
    	organizationField.setTextLimit(30);
    	
    	
    	positionLabel = new Label(this, SWT.NONE);
    	positionLabel.setText(Messages.getString("PersonJobEditForm.positionLabel.text")); //$NON-NLS-1$

    	positionField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	positionField.setLayoutData(gridData);
    	positionField.setTextLimit(30);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(startDateField, "startDate");
	bindControl(endDateField, "endDate");
	bindControl(organizationField, "organization", organizationLabel, REQUIRED);
	bindControl(positionField, "position", positionLabel, REQUIRED);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

