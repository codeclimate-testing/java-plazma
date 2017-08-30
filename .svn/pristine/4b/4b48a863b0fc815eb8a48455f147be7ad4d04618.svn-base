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
 * Created on 17.05.2007
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
import org.plazmaforge.bsolution.contact.ContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.bsolution.contact.common.beans.formatter.AddressFormatter;
import org.plazmaforge.bsolution.contact.common.beans.formatter.ContactFormatterFactory;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AddressEditForm.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public class AddressEditForm extends AbstractEditForm {

    private Label addressTypeLabel;
    
    private Label defaultLabel;
    
    private Label zipCodeLabel;
    
    private Label cityLabel;
    
    private Label localityLabel;    

    private Label addressStringLabel;
    
    
    
    private XComboEdit addressTypeField;

    private XCheckBox defaultField;
    
    private XTextField zipCodeField;
    
    private XComboEdit cityField;
    
    private XComboEdit localityField;

    private XTextField addressStringField;

    
    private XTextArea noteField;
    
    
    
    private AddressFormatter addressFormatter = ContactFormatterFactory.getAddressFormatter();




    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public AddressEditForm(Composite parent, int style) {
	super(parent, style);
	setLayout(new FillLayout());
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	//STUB
	addressFormatter.setAddressVariant(LocaleManager.SIMPLE_ADDRESS);
	
	setTitle(Messages.getString("AddressEditForm.title")); //$NON-NLS-1$
	
	
	GridLayout gridLayout;

	TabFolder tabFolder = new TabFolder(this, SWT.NONE);
	GridData gridData;

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("AddressEditForm.generalTabItem.text")); //$NON-NLS-1$
    	
    	Composite composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);
    	
    	
    	addressTypeLabel = new Label(composite, SWT.NONE);
    	addressTypeLabel.setText(Messages.getString("AddressEditForm.addressTypeLabel.text")); //$NON-NLS-1$

    	addressTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
       	addressTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	
        	
    	defaultLabel = new Label(composite, SWT.NONE);
    	defaultLabel.setText(Messages.getString("AddressEditForm.defaultLabel.text")); //$NON-NLS-1$
    	
    	defaultField = new XCheckBox(composite, SWT.NONE);
    	
    	// Separator
	Label separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
	separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
    

    	zipCodeLabel = new Label(composite, SWT.NONE);
	zipCodeLabel.setText(Messages.getString("AddressEditForm.zipCodeLabel.text")); //$NON-NLS-1$
	
    	zipCodeField = new XTextField(composite, SWT.BORDER);
    	zipCodeField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	zipCodeField.setTextLimit(10);

    	cityLabel = new Label(composite, SWT.NONE);
	cityLabel.setText(Messages.getString("AddressEditForm.cityLabel.text")); //$NON-NLS-1$
    	
    	cityField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	cityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	if (isUseLocality()) {
    	    localityLabel = new Label(composite, SWT.NONE);
	    localityLabel.setText(Messages.getString("AddressEditForm.localityLabel.text")); //$NON-NLS-1$
    	    localityField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    localityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	}
    	
    	addressStringLabel = new Label(composite, SWT.NONE);
	addressStringLabel.setText(Messages.getString("AddressEditForm.addressString.text")); //$NON-NLS-1$

    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.heightHint = 50;
    	gridData.widthHint = 300;
    
    	addressStringField = new XTextField(composite, SWT.BORDER | SWT.MULTI);
    	addressStringField.setLayoutData(gridData);
    	addressStringField.setTextLimit(100);
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());

    	TabItem noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("AddressEditForm.noteTabItem.text")); //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(50);

	noteTabItem.setControl(noteField);

    	
    	this.setSize(new Point(574, 200));
    }
    
    
    protected void bindControls() {
	bindControl(addressTypeField, "addressType", addressTypeLabel, REQUIRED);
	bindControl(defaultField, "defaultItem", Boolean.TYPE);
	bindControl(zipCodeField, "zipCode");	
	bindControl(cityField, "city");
	if (localityField != null) {
	    bindControl(localityField, "locality");
	}
	bindControl(addressStringField, "addressString");
	bindControl(noteField, "note");
    }
    protected void validateControls(StringBuffer buf) throws ApplicationException {
	super.validateControls(buf);
	String address = addressStringField.getText();
	if (isEmpty(address)) {
	    address = null;
	}
	Object city = cityField.getValue();
	Object locality = localityField == null ? null : localityField.getValue();
	if (address == null && city == null && locality == null) {
	    addFieldError(buf, addressStringLabel.getText(), getRequiredResourceString());
	}
    }
    
    private boolean isUseLocality() {
	return LocaleManager.isUseLocalityInAddress();
    }
    
    protected void beforeSave() throws ApplicationException {
	Address address = getAddress();
	address.setFullAddressString(addressFormatter.formatFullAddress(address));
	address.setLocalityAddressString(addressFormatter.formatLocalityAddress(address));
	//address.setLocalityAddressString(addressFormatter.formatLocalityAddress(address.getLocalityTypeName(), address.getLocalityName(), address.getAddressString()));
    }
    
    protected Address getAddress() {
	return (Address) getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getAddress().setAddressType(ContactEnvironment.getAddressType());
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
	return element.isSimpleContactList(getAddress());
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"