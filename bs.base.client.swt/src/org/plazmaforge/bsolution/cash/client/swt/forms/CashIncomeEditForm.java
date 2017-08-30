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
 * Created on 11.06.2007
 *
 */

package org.plazmaforge.bsolution.cash.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.cash.common.beans.CashDocument;
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentEditForm;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.finance.common.beans.Contractor;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;

/** 
 * @author Oleh Hapon
 * $Id: CashIncomeEditForm.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public class CashIncomeEditForm extends AbstractFinanceDocumentEditForm {

    private Label documentNoLabel;
    private Label documentDateLabel;
    private Label contractorLabel;
    private Label currencyAmountLabel;
    private Label taxLabel;
    private Label currencyTaxAmountLabel;
    private Label paymentMissingLabel;
    private Label responsibleLabel;
     
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit contractorField;
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    private XTextField paymentMissingField;
    private XComboEdit responsibleField;
    
  
    private XTextArea noteField;

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CashIncomeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	
	TabFolder tabFolder;
	TabItem noteTabItem;
	Composite composite;
	Label label;
	GridLayout gridLayout;


	
	GridData gridData;
	setTitle(Messages.getString("CashIncomeEditForm.title")); //$NON-NLS-1$
	setLayout(new FillLayout());
	
	
    	
    

    	tabFolder = new TabFolder(this, SWT.NONE);

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CashIncomeEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("CashIncomeEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	documentNoField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 60;
    	documentDateLabel.setLayoutData(gridData);
    	documentDateLabel.setText(Messages.getString("CashIncomeEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
    	documentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	//label = new Label(composite, SWT.NONE);
    	//label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

    	contractorLabel = new Label(composite, SWT.NONE);
    	contractorLabel.setText(Messages.getString("CashIncomeEditForm.contractorLabel.text")); //$NON-NLS-1$

    	contractorField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	contractorField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
       	currencyAmountLabel = new Label(composite, SWT.NONE);
    	currencyAmountLabel.setLayoutData(new GridData());
    	currencyAmountLabel.setText(Messages.getString("CashIncomeEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);

    	
    	
    	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	taxLabel.setText(Messages.getString("CashIncomeEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XTaxCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxField.setLayoutData(gridData);    	

    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
    	
    	currencyTaxAmountLabel = new Label(composite, SWT.NONE);
    	currencyTaxAmountLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyTaxAmountLabel.setText(Messages.getString("CashIncomeEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

    	currencyTaxAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
   	
    	paymentMissingLabel = new Label(composite, SWT.NONE);
    	paymentMissingLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	paymentMissingLabel.setText(Messages.getString("CashIncomeEditForm.paymentMissingLabel.text")); //$NON-NLS-1$

    	paymentMissingField = new XTextArea(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1);
    	gridData.heightHint = 50;
    	gridData.widthHint = 250;
    	paymentMissingField.setLayoutData(gridData);
    	paymentMissingField.setTextLimit(128);
    	
    	
    	responsibleLabel = new Label(composite, SWT.NONE);
    	responsibleLabel.setText(Messages.getString("CashIncomeEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

       	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CashIncomeEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
	this.setSize(new Point(470, 108));
	this.contractorField.setAssociationValueClass(Contractor.class);

	currencyAmountField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
        	calculateTaxAmount();
            }
        });
	
	taxField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		calculateTaxAmount();
	    }
	});
	
	taxField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                calculateTaxAmount();
        }
    });

	initResponsibleField(responsibleField);

    }
    
 
    protected void beforeUpdateData() throws ApplicationException {
	calculateTaxAmount();
    }
    
    protected void afterUpdateData() throws ApplicationException {
	getCashDocument().initContractor();
	getFinanceDocument().calculate();
    }
    
    protected CashDocument getCashDocument() {
	return (CashDocument) getEntity();
    }
    
    
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(contractorField, "contractor", contractorLabel, REQUIRED);
	bindControl(currencyAmountField, "currencyEnterAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	bindControl(paymentMissingField, "paymentMissing", paymentMissingLabel, REQUIRED);
	bindControl(responsibleField, "responsible");
	bindControl(noteField, "note");
    }
    
    /**
     * Calculate tax amount by tax percent and amount
     * 
     */
    protected void calculateTaxAmount() {
	float taxPercent = taxField.getTaxPercent();
	float amount = currencyAmountField.floatValue();
	float tax = (float) MoneyCalculator.calculateTaxAmount(taxPercent, amount, isIncludeTaxInAmount());
	currencyTaxAmountField.setValue(tax);
    }
    

}  //  @jve:decl-index=0:visual-constraint="10,10"
