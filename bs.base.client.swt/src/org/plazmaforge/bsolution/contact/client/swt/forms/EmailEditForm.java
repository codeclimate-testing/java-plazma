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
 * Created on 21 ��� 2007
 *
 */

package org.plazmaforge.bsolution.contact.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: EmailEditForm.java,v 1.4 2010/12/05 07:57:21 ohapon Exp $
 */

public class EmailEditForm extends AbstractEditForm {

    
    private Label defaultLabel;

    private Label emailAddressLabel;
    
    
    private XCheckBox defaultField;
    
    private XTextField emailAddressField;
    
    private XTextArea noteField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public EmailEditForm(Composite parent, int style) {
	super(parent, style);
	setLayout(new FillLayout());
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("EmailEditForm.title")); //$NON-NLS-1$
	
	
	GridLayout gridLayout;

	TabFolder tabFolder = new TabFolder(this, SWT.NONE);
	GridData gridData;

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("EmailEditForm.generalTabItem.text")); //$NON-NLS-1$
    	
    	Composite composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	  	
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);
    	
    	
    	defaultLabel = new Label(composite, SWT.NONE);
    	defaultLabel.setText(Messages.getString("EmailEditForm.defaultLabel.text")); //$NON-NLS-1$
    	
    	defaultField = new XCheckBox(composite, SWT.NONE);
    	defaultField.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    	
    	
    
    	emailAddressLabel = new Label(composite, SWT.NONE);
    	emailAddressLabel.setText(Messages.getString("EmailEditForm.emailAddressLabel.text")); //$NON-NLS-1$

    	emailAddressField = new XTextField(composite, SWT.BORDER);
    	emailAddressField.setTextLimit(255);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	emailAddressField.setLayoutData(gridData);
    	emailAddressField.setTextLimit(255);
    
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());

    	TabItem noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("EmailEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(50);

	noteTabItem.setControl(noteField);

    	
    	this.setSize(new Point(574, 298));
    }
    
    
    protected void bindControls() {
	bindControl(defaultField, "defaultItem", Boolean.TYPE);
	bindControl(emailAddressField, "emailAddress", emailAddressLabel, REQUIRED);
	bindControl(noteField, "note");
    }
    
    private Email getEmail() {
	return (Email) getEntity();
    }
   
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	if (isSimpleContactList()) {
	    defaultField.setValue(Boolean.TRUE);
	    defaultField.setEnabled(false);
	} else {
	    defaultField.setEnabled(true);
	}
    } 
    
    protected boolean isSimpleContactList() {
	IContactableOwner owner = (IContactableOwner) getParentEntity();
	if (owner == null) {
	    return true;
	}
	ContactableElement element = owner.getContactableElement();
	if (element == null) {
	    return true;
	}
	return element.isSimpleContactList(getEmail());
    }    

}  //  @jve:decl-index=0:visual-constraint="10,10"
