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
 * Created on 18.05.2007
 *
 */

package org.plazmaforge.bsolution.contact.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.contact.ContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.formatter.ContactFormatterFactory;
import org.plazmaforge.bsolution.contact.common.beans.formatter.PhoneFormatter;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: PhoneEditForm.java,v 1.4 2010/12/05 07:57:21 ohapon Exp $
 */

public class PhoneEditForm extends AbstractEditForm {

    private Label phoneTypeLabel;
    
    private Label defaultLabel;

    private Label codeLabel;
    
    private Label numberLabel;    
    
    private Label phoneStringLabel;
    
    
    private XComboEdit phoneTypeField;

    private XCheckBox defaultField;
    
    private XTextField codeField;
    
    private XTextField numberField;

    private XTextField phoneStringField;
    
    private XTextArea noteField;
    
    
    private PhoneFormatter phoneFormatter = ContactFormatterFactory.getPhoneFormatter();


    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PhoneEditForm(Composite parent, int style) {
	super(parent, style);
	setLayout(new FillLayout());
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("PhoneEditForm.title")); //$NON-NLS-1$
	
	
	GridLayout gridLayout;

	TabFolder tabFolder = new TabFolder(this, SWT.NONE);
	GridData gridData;

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PhoneEditForm.generalTabItem.text")); //$NON-NLS-1$
    	
    	Composite composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	  	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);
    	
    	
    	phoneTypeLabel = new Label(composite, SWT.NONE);
    	phoneTypeLabel.setText(Messages.getString("PhoneEditForm.phoneTypeLabel.text")); //$NON-NLS-1$

    	phoneTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON );
       	phoneTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    	
         	
    	defaultLabel = new Label(composite, SWT.NONE);
    	defaultLabel.setText(Messages.getString("PhoneEditForm.defaultLabel.text")); //$NON-NLS-1$
    	
    	defaultField = new XCheckBox(composite, SWT.NONE);
    	defaultField.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
    	
      	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("PhoneEditForm.codeLabel.text")); //$NON-NLS-1$
	
    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.addFocusListener(new FocusAdapter() {
    		public void focusLost(FocusEvent e) {
    		    formatPhoneString();
    		}
    	});
    	codeField.setLayoutData(new GridData(70, SWT.DEFAULT));
    	codeField.setTextLimit(6);

    	numberLabel = new Label(composite, SWT.NONE);
	numberLabel.setText(Messages.getString("PhoneEditForm.numberLabel.text")); //$NON-NLS-1$

    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    
    	numberField = new XTextField(composite, SWT.BORDER);
    	numberField.setLayoutData(gridData);
    	numberField.addFocusListener(new FocusAdapter() {
		public void focusLost(FocusEvent e) {
		    formatPhoneString();
		}
	});
    	
    	numberField.setTextLimit(12);

    	phoneStringLabel = new Label(composite, SWT.NONE);
    	phoneStringLabel.setText(Messages.getString("PhoneEditForm.phoneStringLabel.text")); //$NON-NLS-1$

    	phoneStringField = new XTextField(composite, SWT.BORDER);
    	phoneStringField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());

    	TabItem noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PhoneEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(50);

	noteTabItem.setControl(noteField);

	initNoEditableField(phoneStringField);
	
    	this.setSize(new Point(574, 298));
    }
    
    
    protected void bindControls() {
	bindControl(phoneTypeField, "phoneType", phoneTypeLabel, REQUIRED);
	bindControl(defaultField, "defaultItem", Boolean.TYPE);
	bindControl(codeField, "phoneCode");	
	bindControl(numberField, "phoneNumber", numberLabel, REQUIRED);
	bindControl(phoneStringField, "phoneString");
	bindControl(noteField, "note");
    }
    
    protected void beforeSave() throws ApplicationException {
	getPhone().setPhoneString(phoneFormatter.format(getPhone()));
    }   
    
    protected Phone getPhone() {
	return (Phone) getEntity();
    }    
    
    private void formatPhoneString() {
	phoneStringField.setText(phoneFormatter.format(codeField.getText(), numberField.getText()));
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getPhone().setPhoneType(ContactEnvironment.getPhoneType());
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
	return element.isSimpleContactList(getPhone());
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
