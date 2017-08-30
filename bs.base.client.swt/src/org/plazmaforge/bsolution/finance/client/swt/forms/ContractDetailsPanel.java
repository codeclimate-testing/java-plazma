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
 * Created on 16.03.2008
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;

import org.eclipse.swt.SWT;


import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.controls.AbstractControl;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;

/** 
 * @author Oleh Hapon
 * $Id: ContractDetailsPanel.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class ContractDetailsPanel extends Composite {

    private XComboEdit contactField;
    
    
    private XTextField personField;
    
    private XTextField personEnField;
    
    
    private XTextField personDetailField;
    
    private XTextField personDetailEnField;
    
    
    private XTextField personOnBasisField;
    
    private XTextField personOnBasisEnField;
    
    
    private XComboEdit bankAccountField;
    
    
    private XTextField bankNameField;
    
    private XTextField bankNameEnField;
    
    
    private XTextField addressField;
    
    private XTextField addressEnField;
    
    
    private XTextField phoneField;
    
    private XTextField faxField;
    
    
    public ContractDetailsPanel(Composite parent, int style) {
	super(parent, style);
	
	Label label;

	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	setLayout(gridLayout);

    	Label contactLabel = new Label(this, SWT.NONE);
    	contactLabel.setText(Messages.getString("ContractDetailsPanel.contact")); //$NON-NLS-1$

    	contactField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	contactField.setLayoutData(gridData);
    	
    	//
    	//initDisableField(contactField);

    	Label personLabel = new Label(this, SWT.NONE);
    	personLabel.setText(Messages.getString("ContractDetailsPanel.person")); //$NON-NLS-1$

    	personField = new XTextField(this, SWT.BORDER);
    	personField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	if (isIntertationalAttributes()) {
    	    Label personLabelEn = new Label(this, SWT.NONE);
    	    personLabelEn.setText(Messages.getString("ContractDetailsPanel.personEn")); //$NON-NLS-1$

            personEnField = new XTextField(this, SWT.BORDER);
            personEnField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	}

    	Label personOnBasisLabel = new Label(this, SWT.NONE);
    	personOnBasisLabel.setText(Messages.getString("ContractDetailsPanel.personOnBasis")); //$NON-NLS-1$

    	personOnBasisField = new XTextField(this, SWT.BORDER);
    	personOnBasisField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	if (isIntertationalAttributes()) {
	    Label personOnBasisLabelEn = new Label(this, SWT.NONE);
	    personOnBasisLabelEn.setText(Messages.getString("ContractDetailsPanel.personOnBasisEn")); //$NON-NLS-1$

	    personOnBasisEnField = new XTextField(this, SWT.BORDER);
	    personOnBasisEnField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	}

    	
    	Label personDetailLabel = new Label(this, SWT.NONE);
    	personDetailLabel.setText(Messages.getString("ContractDetailsPanel.personDetail")); //$NON-NLS-1$

    	personDetailField = new XTextField(this, SWT.BORDER);
    	personDetailField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	if (isIntertationalAttributes()) {
	    Label personDetailLabelEn = new Label(this, SWT.NONE);
	    personDetailLabelEn.setText(Messages.getString("ContractDetailsPanel.personDetailEn")); //$NON-NLS-1$

	    personDetailEnField = new XTextField(this, SWT.BORDER);
	    personDetailEnField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	}

    	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	Label bankAccountLabel = new Label(this, SWT.NONE);
    	bankAccountLabel.setText(Messages.getString("ContractDetailsPanel.bankAccount")); //$NON-NLS-1$

    	bankAccountField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	bankAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	Label bankNameLabel = new Label(this, SWT.NONE);
    	bankNameLabel.setText(Messages.getString("ContractDetailsPanel.bankName")); //$NON-NLS-1$

    	bankNameField = new XTextField(this, SWT.BORDER);
    	bankNameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	if (isIntertationalAttributes()) {
	    Label bankNameLabelEn = new Label(this, SWT.NONE);
	    bankNameLabelEn.setText(Messages.getString("ContractDetailsPanel.bankNameEn")); //$NON-NLS-1$

	    bankNameEnField = new XTextField(this, SWT.BORDER);
	    bankNameEnField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	}

    	
    	label = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

    	Label addressLabel = new Label(this, SWT.NONE);
    	addressLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
    	addressLabel.setText(Messages.getString("ContractDetailsPanel.address")); //$NON-NLS-1$

    	addressField = new XTextField(this, SWT.BORDER);
    	addressField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));

    	if (isIntertationalAttributes()) {
	    Label addressLabelEn = new Label(this, SWT.NONE);
	    addressLabelEn.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
	    addressLabelEn.setText(Messages.getString("ContractDetailsPanel.addressEn")); //$NON-NLS-1$

	    addressEnField = new XTextField(this, SWT.BORDER);
	    addressEnField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
	}

    	
    	Label phoneLabel = new Label(this, SWT.NONE);
    	phoneLabel.setText(Messages.getString("ContractDetailsPanel.phone")); //$NON-NLS-1$

    	phoneField = new XTextField(this, SWT.BORDER);
    	phoneField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	
    	Label faxLabel = new Label(this, SWT.NONE);
    	faxLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	faxLabel.setText(Messages.getString("ContractDetailsPanel.fax")); //$NON-NLS-1$

    	faxField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	faxField.setLayoutData(gridData);
   
    }


    public XTextField getAddressField() {
        return addressField;
    }


    public XTextField getAddressEnField() {
        return addressEnField;
    }


    public XComboEdit getBankAccountField() {
        return bankAccountField;
    }


    public XTextField getBankNameField() {
        return bankNameField;
    }


    public XTextField getBankNameEnField() {
        return bankNameEnField;
    }


    public XComboEdit getContactField() {
        return contactField;
    }


    public XTextField getFaxField() {
        return faxField;
    }


    public XTextField getPersonDetailField() {
        return personDetailField;
    }


    public XTextField getPersonDetailEnField() {
        return personDetailEnField;
    }


    public XTextField getPersonField() {
        return personField;
    }


    public XTextField getPersonEnField() {
        return personEnField;
    }


    public XTextField getPersonOnBasisField() {
        return personOnBasisField;
    }


    public XTextField getPersonOnBasisEnField() {
        return personOnBasisEnField;
    }


    public XTextField getPhoneField() {
        return phoneField;
    }

    
    protected boolean isIntertationalAttributes() {
	return EnterpriseEnvironment.isInternationalAttributes();
    }

    // STUB
    protected void initDisableField(AbstractControl field) {
	if (field == null) {
	    return;
	}
	field.setEnabled(false);
    	field.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
    }
    
    protected Color getSystemColor(int color) {
	return SWTResourceManager.getColor(color);
    }

}
