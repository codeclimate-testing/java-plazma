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
 * Created on 25.09.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.data.Enumeration;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: EnumerationEditForm.java,v 1.3 2010/12/05 07:57:20 ohapon Exp $
 */

public class EnumerationEditForm extends AbstractEditForm {

    private Label codeLabel;
    private Label nameLabel;

    
    private XTextField codeField;
    private XTextField nameField;

   
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EnumerationEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("EnumerationEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	codeLabel = new Label(this, SWT.NONE);
	codeLabel.setText(Messages.getString("EnumerationEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	codeField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	codeField.setTextLimit(30);

    	nameLabel = new Label(this, SWT.NONE);
	nameLabel.setText(Messages.getString("EnumerationEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }
    
    protected Enumeration getEnumeration() {
	return (Enumeration) getEntity();
    }
    
    protected IEntityConfig getEntityConfig() {
	return (IEntityConfig) getParentEntity();
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	IEntityConfig entity = getEntityConfig();
	if (entity != null & entity.getConfigName() != null) {
	    setTitle(entity.getConfigName());
	}
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getEnumeration().setEntity(getEntityConfig());
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
