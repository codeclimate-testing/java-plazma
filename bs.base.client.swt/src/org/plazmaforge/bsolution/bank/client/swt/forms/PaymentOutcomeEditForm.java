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

package org.plazmaforge.bsolution.bank.client.swt.forms;


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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.bank.BankContext;
import org.plazmaforge.bsolution.bank.BankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.purchase.client.swt.forms.PurchaseInvoiceListForm;
import org.plazmaforge.bsolution.purchase.client.swt.forms.PurchaseOrderListForm;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;

/** 
 * @author Oleh Hapon
 * $Id: PaymentOutcomeEditForm.java,v 1.7 2010/12/05 07:57:18 ohapon Exp $
 */

public class PaymentOutcomeEditForm extends AbstractPaymentDocumentEditForm {

    private Label documentNoLabel;
    private Label documentDateLabel;
    private Label organizationBankAccountLabel;
    private Label partnerLabel;
    private Label partnerBankAccountLabel;
    private Label currencyAmountLabel;
    private Label taxLabel;
    private Label currencyTaxAmountLabel;
    private Label paymentMissingLabel; 
    private Label paymentTypeLabel;
    private Label paymentDateLabel;
    private Label taxPrintTypeLabel;
    private Label responsibleLabel;
    private Label projectLabel;
     
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit organizationBankAccountField;
    private XComboEdit partnerBankAccountField;
    private XComboEdit partnerField;
    private XCurrencyField currencyAmountField;
    private XTaxCombo taxField;
    private XCurrencyField currencyTaxAmountField;
    private XTextArea paymentMissingField;
    private XComboEdit paymentTypeField;
    private XDateCombo paymentDateField;
    private XComboEdit taxPrintTypeField;
    private XComboEdit responsibleField;
    private XComboEdit projectField;
  
    private XTextArea noteField;

    
    private Composite documentPanel;
    private TabFolder documentTabFolder;
    private Table documentTable;

    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public PaymentOutcomeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("PaymentOutcomeEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	
	TabItem generalTabItem;
	TabItem documentTabItem;
	TabItem noteTabItem;
	Composite composite;
	Label label;
	GridLayout gridLayout;


	
	GridData gridData;

	setLayout(new FillLayout());
	
    	tabFolder = new TabFolder(this, SWT.NONE);

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PaymentOutcomeEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("PaymentOutcomeEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	documentNoField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.horizontalIndent = 60;
    	documentDateLabel.setLayoutData(gridData);
    	documentDateLabel.setText(Messages.getString("PaymentOutcomeEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
    	documentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	//label = new Label(composite, SWT.NONE);
    	//label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

    	organizationBankAccountLabel = new Label(composite, SWT.NONE);
    	organizationBankAccountLabel.setText(Messages.getString("PaymentOutcomeEditForm.organizationBankAccountLabel.text")); //$NON-NLS-1$

    	organizationBankAccountField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	organizationBankAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setText(Messages.getString("PaymentOutcomeEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	partnerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
	partnerBankAccountLabel = new Label(composite, SWT.NONE);
	partnerBankAccountLabel.setText(Messages.getString("PaymentOutcomeEditForm.partnerBankAccountLabel.text")); //$NON-NLS-1$

	partnerBankAccountField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
	partnerBankAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
       	currencyAmountLabel = new Label(composite, SWT.NONE);
    	currencyAmountLabel.setLayoutData(new GridData());
    	currencyAmountLabel.setText(Messages.getString("PaymentOutcomeEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);

    	
    	
    	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	taxLabel.setText(Messages.getString("PaymentOutcomeEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XTaxCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxField.setLayoutData(gridData);    	

    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
    	
    	currencyTaxAmountLabel = new Label(composite, SWT.NONE);
    	currencyTaxAmountLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyTaxAmountLabel.setText(Messages.getString("PaymentOutcomeEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

    	currencyTaxAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
   	
    	paymentMissingLabel = new Label(composite, SWT.NONE);
    	paymentMissingLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    	paymentMissingLabel.setText(Messages.getString("PaymentOutcomeEditForm.paymentMissingLabel.text")); //$NON-NLS-1$

    	paymentMissingField = new XTextArea(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1);
    	gridData.heightHint = 50;
    	gridData.widthHint = 250;
    	paymentMissingField.setLayoutData(gridData);
    	paymentMissingField.setTextLimit(128);
    	
    	//
    	paymentTypeLabel = new Label(composite, SWT.NONE);
    	paymentTypeLabel.setText(Messages.getString("PaymentOutcomeEditForm.paymentTypeLabel.text")); //$NON-NLS-1$

    	paymentTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	paymentTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	paymentDateLabel = new Label(composite, SWT.NONE);
    	paymentDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	paymentDateLabel.setText(Messages.getString("PaymentOutcomeEditForm.paymentDateLabel.text")); //$NON-NLS-1$

    	paymentDateField = new XDateCombo(composite, SWT.BORDER);
    	paymentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	taxPrintTypeLabel = new Label(composite, SWT.NONE);
    	taxPrintTypeLabel.setText(Messages.getString("PaymentOutcomeEditForm.taxPrintTypeLabel.text")); //$NON-NLS-1$

    	taxPrintTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	taxPrintTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	responsibleLabel = new Label(composite, SWT.NONE);
    	responsibleLabel.setText(Messages.getString("PaymentOutcomeEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	//
	if (isProjectInDocument()) {
	    projectLabel = new Label(composite, SWT.NONE);
	    projectLabel.setText(Messages.getString("PaymentOutcomeEditForm.projectLabel.text")); //$NON-NLS-1$

	    projectField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    projectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	    projectField.setAssociationValueClass(Project.class);
	}
	//

	
    	////
       	documentTabItem = new TabItem(tabFolder, SWT.NONE);
       	documentTabItem.setText(Messages.getString("PaymentOutcomeEditForm.documentTabItem.text")); //$NON-NLS-1$

       	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	
    	composite.setLayout(gridLayout);
    	documentTabItem.setControl(composite);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(composite, SWT.NONE, PWT.ADD_BUTTON | PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
    	createDocumentPanel(composite);
	
	////
       	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PaymentOutcomeEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
	this.setSize(new Point(470, 108));

	

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

	documentDateField.addFocusListener(new FocusAdapter(){
    	    public void focusLost(FocusEvent e) {
    		updatePaymentDate(documentDateField, paymentDateField);
    	    }
    	});

	initPartnerField(partnerField);
	initBankAccountField(organizationBankAccountField);
	initBankAccountField(partnerBankAccountField);
	
	initOrganizationBankAccountField(organizationBankAccountField);
	initPartnerBankAccountField(partnerBankAccountField);
	
	initResponsibleField(responsibleField);
	
	////
	
	registerEntityProvider(documentTabFolder.getItem(0), new DocumentItemProvider());
	
    }
    
    
    private void createDocumentPanel(Composite parent) {
	 
        GridLayout gridLayout;
        TabItem productTabItem;
        
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 181;
        
        
        documentPanel = new Composite(parent, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        documentPanel.setLayout(gridLayout);
        documentPanel.setLayoutData(gridData);
        

        
        documentTabFolder = new TabFolder(documentPanel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 500;
        documentTabFolder.setLayoutData(gridData);

        productTabItem = new TabItem(documentTabFolder, SWT.NONE);
        productTabItem.setText(Messages.getString("PaymentOutcomeEditForm.reasonDocumentTabItem.text")); //$NON-NLS-1$

         
        documentTable = new Table(documentTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        documentTable.setHeaderVisible(true);
        documentTable.setLinesVisible(true);
        productTabItem.setControl(documentTable);

   
        TableColumn newColumnTableColumn = new TableColumn(documentTable, SWT.NONE);
        newColumnTableColumn.setResizable(false);
        newColumnTableColumn.setWidth(20);

        TableColumn documentCodeColumn = new TableColumn(documentTable, SWT.NONE);
        documentCodeColumn.setWidth(50);
        documentCodeColumn.setText(Messages.getString("PaymentOutcomeEditForm.documentNoColumn.text")); //$NON-NLS-1$

        TableColumn documentDateColumn = new TableColumn(documentTable, SWT.NONE);
        documentDateColumn.setWidth(70);
        documentDateColumn.setText(Messages.getString("PaymentOutcomeEditForm.documentDateColumn.text")); //$NON-NLS-1$

        TableColumn documentPartnerColumn = new TableColumn(documentTable, SWT.NONE);
        documentPartnerColumn.setWidth(200);
        documentPartnerColumn.setText(Messages.getString("PaymentOutcomeEditForm.documentPartnerColumn.text")); //$NON-NLS-1$

        TableColumn documentAmountColumn = new TableColumn(documentTable, SWT.RIGHT);
        documentAmountColumn.setWidth(90);
        documentAmountColumn.setText(Messages.getString("PaymentOutcomeEditForm.documentAmountColumn.text")); //$NON-NLS-1$

    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	documentDate = documentDateField.getDate();
	paymentDate = paymentDateField.getDate();
    }
 
    protected void beforeUpdateData() throws ApplicationException {
	calculateTaxAmount();
    }
    
    protected void afterUpdateData() throws ApplicationException {
	getFinanceDocument().calculate();
    }
    
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(organizationBankAccountField, "organizationBankAccount", organizationBankAccountLabel, REQUIRED);
	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(partnerBankAccountField, "partnerBankAccount", partnerBankAccountLabel, REQUIRED);
	bindControl(currencyAmountField, "currencyEnterAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	bindControl(paymentMissingField, "paymentMissing", paymentMissingLabel, REQUIRED);
	bindControl(paymentTypeField, "paymentType", paymentTypeLabel, REQUIRED);
	bindControl(paymentDateField, "paymentDate", paymentDateLabel, REQUIRED);
	bindControl(taxPrintTypeField, "taxPrintType", taxPrintTypeLabel, REQUIRED);
	bindControl(responsibleField, "responsible");
	bindControl(projectField, "project");
	
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
    
    

    protected void initDocument() {
	super.initDocument();

	getPaymentDocument().setOrganizationBankAccount(getBankAccount(getOrganization()));
	
	PartnerTitle partner = BankEnvironment.getOutcomePartner();
	getPaymentDocument().setPartner(partner);
	getPaymentDocument().setPartnerBankAccount(getBankAccount(partner));
    } 
     
    
    protected Object getSelectedEntityProviderKey() {
        int index = documentTabFolder.getSelectionIndex();
        return documentTabFolder.getItem(index);
    }
    
    protected class DocumentItemProvider extends TableEntityProvider {
	
	public DocumentItemProvider() {
	    setParentEntityClass(PaymentOutcome.class); // OWNER
	    setEntityClass(FinanceDocument.class); // FORM ID
	    setListProperty("reasonDocuments");
	    setAddMethod("addReasonDocument", FinanceDocument.class);
	    setSupportEditForm(false);
	}
	
	protected Table getTable() {
	    return documentTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "documentNo");
	    bindColumn(2, "documentDate", getDateFormat());
	    bindColumn(3, "partnerName");
	    bindColumn(4, "enterTotal", getCurrencyFormat());
	}
    }
    
    

    public void doItemAddAction() throws ApplicationException {
	Class listFormClass = getReasonDocumentListFormClass();
	if (listFormClass == null) {
	    return;
	}
	doItemAddListForm(listFormClass);
    }

    
    protected Class getReasonDocumentListFormClass() {
	if (isInvoiceAndOrderReason()) {
	    String doc = getChooseReasonDocument();
	    if (BankContext.INVOICE_REASON_DOCUMENT.equals(doc)) {
		return PurchaseInvoiceListForm.class;
	    } else if (BankContext.ORDER_REASON_DOCUMENT.equals(doc)) {
		return PurchaseOrderListForm.class;
	    }
	    return null;
	} else if (isInvoiceReason()) {
	    return PurchaseInvoiceListForm.class;
	} else if (isOrderReason()) {
	    return PurchaseOrderListForm.class;
	}
	return null;
    }


}  //  @jve:decl-index=0:visual-constraint="10,10"

