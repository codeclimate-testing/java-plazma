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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.config.object.EntityConfig;

/**
 * 
 * @author Oleh Hapon
 * $Id: SystemEntityEditForm.java,v 1.2 2010/04/28 06:31:00 ohapon Exp $
 */
public class SystemEntityEditForm extends AbstractEditForm {

    private Label codeLabel;

    private Label nameLabel;
    
    
    private Label cacheLabel;
    
    private Label cacheExpireTimeLabel;
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XCheckBox cacheField;
    
    private XIntegerField cacheExpireTimeField;

 
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public SystemEntityEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	
	setEntityClass(EntityConfig.class);
        setEntityServiceClass(SystemEntityService.class);

        
	setTitle(Messages.getString("SystemEntityEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("SystemEntityEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(30);
    	

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("SystemEntityEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	

    	
    	cacheLabel = new Label(this, SWT.NONE);
    	cacheLabel.setText(Messages.getString("SystemEntityEditForm.cacheLabel.text")); //$NON-NLS-1$

    	cacheField = new XCheckBox(this, SWT.NONE);
    	cacheField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	

    	cacheExpireTimeLabel = new Label(this, SWT.NONE);
    	cacheExpireTimeLabel.setText(Messages.getString("SystemEntityEditForm.cacheExpireTimeLabel.text")); //$NON-NLS-1$

    	cacheExpireTimeField = new XIntegerField(this, SWT.BORDER);
    	cacheExpireTimeField.setLayoutData(new GridData(50, SWT.DEFAULT));

    	
    	initNoEditableField(codeField);
    	initNoEditableField(nameField);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name");
	bindControl(cacheField, "cache");
	bindControl(cacheExpireTimeField, "cacheExpireTime");
    }
    
    

}  //  @jve:decl-index=0:visual-constraint="10,10"
