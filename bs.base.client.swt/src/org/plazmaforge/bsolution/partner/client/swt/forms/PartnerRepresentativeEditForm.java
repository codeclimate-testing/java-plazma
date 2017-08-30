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

package org.plazmaforge.bsolution.partner.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerRepresentative;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: PartnerRepresentativeEditForm.java,v 1.3 2010/12/05 07:57:19 ohapon Exp $
 */
public class PartnerRepresentativeEditForm extends AbstractEditForm implements IPartnerableForm {

    private Label codeLabel;
    
    private Label nameLabel;
    
    private Label documentLabel;
    
    private Label addressLabel;
    
    private Label phoneLabel;
    
    private Label partnerLabel;
    
    
    private XTextField codeField;
    
    private XTextField nameField;
    
    private XTextField documentField;
    
    private XTextField addressField;
    
    private XTextField phoneField;
    
    private XComboEdit partnerField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PartnerRepresentativeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("PartnerRepresentativeEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	codeLabel = new Label(this, SWT.NONE);
    	codeLabel.setText(Messages.getString("PartnerRepresentativeEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(20);

    	////
    	nameLabel = new Label(this, SWT.NONE);
    	nameLabel.setText(Messages.getString("PartnerRepresentativeEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(100);
    	
    	////
    	documentLabel = new Label(this, SWT.NONE);
    	documentLabel.setText(Messages.getString("PartnerRepresentativeEditForm.documentLabel.text")); //$NON-NLS-1$

    	documentField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	documentField.setLayoutData(gridData);
    	documentField.setTextLimit(20);
    	
    	////
    	addressLabel = new Label(this, SWT.NONE);
    	addressLabel.setText(Messages.getString("PartnerRepresentativeEditForm.addressLabel.text")); //$NON-NLS-1$

    	addressField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	addressField.setLayoutData(gridData);
    	addressField.setTextLimit(100);
    	
    	////
    	phoneLabel = new Label(this, SWT.NONE);
    	phoneLabel.setText(Messages.getString("PartnerRepresentativeEditForm.phoneLabel.text")); //$NON-NLS-1$

    	phoneField = new XTextField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	phoneField.setLayoutData(gridData);
    	phoneField.setTextLimit(20);

    
    	this.setSize(new Point(574, 298));
    	
    	
    }
    
    public void init() throws ApplicationException {
	createPartnerField();
	super.init();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	if (isSupportParentEntity()) {
	    getPartnerRepresentative().setPartner(getPartner());
	}
	
    }
    
    
    private PartnerRepresentative getPartnerRepresentative() {
	return (PartnerRepresentative) getEntity();
    }
    
    private void createPartnerField() {

	if (isChildFormMode() || isSupportParentEntity()) {
	    return;
	}
	
    	////
    	partnerLabel = new Label(this, SWT.NONE);
    	partnerLabel.setText(Messages.getString("PartnerRepresentativeEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	partnerField.setLayoutData(gridData);
    	
	partnerField.setAssociationValueClass(Partner.class);
	
    }
    
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(documentField, "document");
	bindControl(addressField, "address");
	bindControl(phoneField, "phone");
	
	if (partnerField != null) {
	    bindControl(partnerField, "partner");
	}
    }

  

    public IPartnerTitle getPartner() {
        return (IPartnerTitle) getParentEntity();
    }

   
    
}