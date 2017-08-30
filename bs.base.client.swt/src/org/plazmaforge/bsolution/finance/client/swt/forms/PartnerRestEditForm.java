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
 * Created on 09.07.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XOperationTypeCombo;
import org.plazmaforge.bsolution.finance.common.beans.PartnerRest;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: PartnerRestEditForm.java,v 1.3 2010/12/05 07:57:18 ohapon Exp $
 */

public class PartnerRestEditForm extends AbstractEditForm {
    


    private Label partnerLabel;

    private Label operationTypeLabel;

    private Label amountLabel;
    
    

    
    private XComboEdit partnerField;
    
    private XOperationTypeCombo operationtTypeField;
  
    private XCurrencyField amountField;

   
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PartnerRestEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("PartnerRestEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    

    	partnerLabel = new Label(this, SWT.NONE);
	partnerLabel.setText(Messages.getString("PartnerRestEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 250;
    	partnerField.setLayoutData(gridData);

    	
    	operationTypeLabel = new Label(this, SWT.NONE);
	operationTypeLabel.setText(Messages.getString("PartnerRestEditForm.operationTypeLabel.text")); //$NON-NLS-1$

    	operationtTypeField = new XOperationTypeCombo(this, SWT.BORDER);
    	gridData = new GridData(100, SWT.DEFAULT);
    	operationtTypeField.setLayoutData(gridData);
    	
	amountLabel = new Label(this, SWT.NONE);
	amountLabel.setText(Messages.getString("PartnerRestEditForm.amountLabel.text")); //$NON-NLS-1$

    	amountField = new XCurrencyField(this, SWT.BORDER);
    	amountField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	amountField.setTextLimit(10);
    	
    	this.setSize(new Point(470, 108));
    	
    	partnerField.setAssociationValueClass(Partner.class);
    }
    
    private PartnerRest getPartnerRest() {
	return (PartnerRest) getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getPartnerRest().setOrganizationId(EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext()));
	getPartnerRest().setCurrency(EnterpriseEnvironment.getCurrency());
	getPartnerRest().setPeriodId(EnterpriseEnvironment.getPeriodId());
    }
    
    
    protected void bindControls() {

	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(operationtTypeField, "operationType", operationTypeLabel, REQUIRED);
	bindControl(amountField, "amount", amountLabel, REQUIRED);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"


