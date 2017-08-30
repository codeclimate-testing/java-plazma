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
 * Created on 2  ‚≥ 2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;


/** 
 * @author Oleh Hapon
 * $Id: FinanceDocumentTypeEditForm.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class FinanceDocumentTypeEditForm extends AbstractEditForm {

    private Label documentTypeLabel;
    
    private Label moveTypeLabel;
    
    private Label includeTaxInAmountLabel;
    
    
    private XComboEdit documentTypeField;
    
    private XTextField moveTypeField;
    
    private XCheckBox includeTaxInAmountField;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public FinanceDocumentTypeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("FinanceDocumentTypeEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	documentTypeLabel = new Label(this, SWT.NONE);
    	documentTypeLabel.setText(Messages.getString("FinanceDocumentTypeEditForm.documentTypeLabel.text")); //$NON-NLS-1$

    	documentTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.EDIT_BUTTON);
    	final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 300;
    	documentTypeField.setLayoutData(gridData);

    	moveTypeLabel = new Label(this, SWT.NONE);
    	moveTypeLabel.setText(Messages.getString("FinanceDocumentTypeEditForm.moveTypeLabel.text")); //$NON-NLS-1$

    	moveTypeField = new XTextField(this, SWT.BORDER);
    	moveTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    	moveTypeField.setTextLimit(20);
    
    	includeTaxInAmountLabel = new Label(this, SWT.NONE);
    	includeTaxInAmountLabel.setText(Messages.getString("FinanceDocumentTypeEditForm.includeTaxInAmountLabel.text")); //$NON-NLS-1$

    	includeTaxInAmountField = new XCheckBox(this, SWT.NONE);
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(documentTypeField, "documentType", documentTypeLabel, REQUIRED);
	bindControl(moveTypeField, "moveType", moveTypeLabel, REQUIRED);
	bindControl(includeTaxInAmountField, "includeTaxInAmount", Boolean.TYPE);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"

