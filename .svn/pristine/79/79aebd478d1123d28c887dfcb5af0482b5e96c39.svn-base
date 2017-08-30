/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 04.02.2007
 * 
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;

import java.util.List;

import org.eclipse.swt.SWT;


import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.bank.client.swt.forms.BankAccountHelper;
import org.plazmaforge.bsolution.bank.client.swt.forms.BankAccountHelperProvider;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.client.swt.forms.ContactListForm;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerBankAccountListForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.LoadListener;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;


/** 
 * @author Oleh Hapon
 * $Id: ContractEditForm.java,v 1.6 2010/12/05 07:57:18 ohapon Exp $
 */


public class ContractEditForm extends AbstractFinanceDocumentEditForm {

    private Label documentNoLabel;
    private Label documentDateLabel;
    private Label endDateLabel;
    private Label nameLabel;    
    private Label partnerLabel;
    private Label responsibleLabel;
    private Label projectLabel;
    private Label currencyLabel;
    private Label currencyRateLabel;
    private Label currencyRateDateLabel;
    private Label currencyAmountLabel;
    private Label currencyTaxAmountLabel;
    
    private Label currencyPreAmountLabel;
     
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XDateCombo endDateField;
    private XTextField nameField;    
    private XComboEdit partnerField;
    private XComboEdit responsibleField;
    private XComboEdit projectField;
    private XComboEdit currencyField;
    private XCurrencyField currencyRateField;
    private XDateCombo currencyRateDateField;    
    private XCurrencyField currencyAmountField;
    private XCurrencyField currencyTaxAmountField;
  
    private XCurrencyField currencyPrepayAmountField;
    
    private XTextArea noteField;
    private XTaxCombo taxField;
    private Label taxLabel;
    
    
    ////
    private Composite itemsPanel;

    private TabFolder itemsTabFolder;

    ////
    
    private ContractDetailsPanel organizationDetailsPanel;
    
    private ContractDetailsPanel partnerDetailsPanel;
    
    
    ////
    
    private XComboEdit organizationBankAccountField;
    private XComboEdit partnerBankAccountField;
    

    private XComboEdit organizationContactField;
    private XComboEdit partnerContactField;

    private boolean isUpdateForm;
    
    private BankAccountHelper bankAccountHelper;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ContractEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("ContractEditForm.title"));	 //$NON-NLS-1$
	
	TabFolder tabFolder;
	TabItem noteTabItem;
	Composite composite;
	Label label;
	GridLayout gridLayout;

	GridData gridData;
	//setLayout(new FillLayout());
	
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	

	setLayout(gridLayout);

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("ContractEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 6;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
    	
    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("ContractEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	documentNoField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	documentDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	documentDateLabel.setText(Messages.getString("ContractEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
    	documentDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

       	endDateLabel = new Label(composite, SWT.NONE);
    	endDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	endDateLabel.setText(Messages.getString("ContractEditForm.endDateLabel.text")); //$NON-NLS-1$

    	endDateField = new XDateCombo(composite, SWT.BORDER);
    	endDateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    
    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setText(Messages.getString("ContractEditForm.nameLabel.text")); //$NON-NLS-1$
    	
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

    	
	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
    	
    	
    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setText(Messages.getString("ContractEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	partnerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

    	responsibleLabel = new Label(composite, SWT.NONE);
    	responsibleLabel.setText(Messages.getString("ContractEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

	//
	if (isProjectInDocument()) {
	    projectLabel = new Label(composite, SWT.NONE);
	    projectLabel.setText(Messages.getString("ContractEditForm.projectLabel.text")); //$NON-NLS-1$

	    projectField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    projectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
	    projectField.setAssociationValueClass(Project.class);
	}
	//
	
	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
    	
    	currencyLabel = new Label(composite, SWT.NONE);
    	currencyLabel.setLayoutData(new GridData());
    	currencyLabel.setText(Messages.getString("ContractEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyField.setLayoutData(gridData);

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	currencyRateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyRateLabel.setText(Messages.getString("ContractEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XCurrencyField(composite, SWT.BORDER);
    	currencyRateField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	currencyRateDateLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyRateDateLabel.setText(Messages.getString("ContractEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateDateField.setLayoutData(gridData);

    	currencyAmountLabel = new Label(composite, SWT.NONE);
    	currencyAmountLabel.setLayoutData(new GridData());
    	currencyAmountLabel.setText(Messages.getString("ContractEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);

    	
    	
    	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	taxLabel.setText(Messages.getString("ContractEditForm.taxLabel.text")); //$NON-NLS-1$

    	taxField = new XTaxCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxField.setLayoutData(gridData);    	
    	//
    	
    	
    	currencyTaxAmountLabel = new Label(composite, SWT.NONE);
    	currencyTaxAmountLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
    	currencyTaxAmountLabel.setText(Messages.getString("ContractEditForm.currencyTaxAmountLabel.text")); //$NON-NLS-1$

    	currencyTaxAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxAmountField.setLayoutData(gridData);
   	
    	
	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
    	
    	////
    	
    	currencyPreAmountLabel = new Label(composite, SWT.NONE);
    	currencyPreAmountLabel.setLayoutData(new GridData());
    	currencyPreAmountLabel.setText(Messages.getString("ContractEditForm.currencyPreAmountLabel.text")); //$NON-NLS-1$

    	currencyPrepayAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyPrepayAmountField.setLayoutData(gridData);    	
    	
    	////
    	
    	TabItem organizationDetailsTabItem = new TabItem(tabFolder, SWT.NONE);
    	organizationDetailsTabItem.setText(Messages.getString("ContractEditForm.organizationDetailsTabItem.text")); //$NON-NLS-1$
    	organizationDetailsPanel = new ContractDetailsPanel(tabFolder, SWT.NONE);
    	organizationDetailsTabItem.setControl(organizationDetailsPanel);
    	
    	//
    	
    	TabItem partnerDetailsTabItem = new TabItem(tabFolder, SWT.NONE);
    	partnerDetailsTabItem.setText(Messages.getString("ContractEditForm.partnerDetailsTabItem.text")); //$NON-NLS-1$
    	partnerDetailsPanel = new ContractDetailsPanel(tabFolder, SWT.NONE);
    	partnerDetailsTabItem.setControl(partnerDetailsPanel);
		    
    	////
		    
		    
       	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("ContractEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteTabItem.setControl(noteField);
    	
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, Contract.class);
    	FileView fileView = new FileView(itemsTabFolder, Contract.class);
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), fileView.getEntityProvider());
    	
	this.setSize(new Point(470, 108));
	this.partnerField.setAssociationValueClass(Partner.class);

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
	
	
	
	
	
	initPartnerField(partnerField);
	initBankAccountField(organizationDetailsPanel.getBankAccountField());
	initBankAccountField(partnerDetailsPanel.getBankAccountField());
	initContactField(organizationDetailsPanel.getContactField());
	initContactField(partnerDetailsPanel.getContactField());
	
	initOrganizationBankAccountField(organizationDetailsPanel.getBankAccountField());
	initPartnerBankAccountField(partnerDetailsPanel.getBankAccountField());
	
	initOrganizationContactField(organizationDetailsPanel.getContactField());
	initPartnerContactField(partnerDetailsPanel.getContactField());
	
    	initCurrencyField(currencyField);
    	initCurrencyRateField(currencyRateField);
    	initCurrencyRateDateField(currencyRateDateField);

    	initResponsibleField(responsibleField);
    

    }
    
    
    private void createItemPanel() {
	 
        GridLayout gridLayout;
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 150;
        
        
        itemsPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        itemsPanel.setLayout(gridLayout);
        itemsPanel.setLayoutData(gridData);
        
        itemsTabFolder = new TabFolder(itemsPanel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 550;
        itemsTabFolder.setLayoutData(gridData);
     }

    
    
    private Contract getContract() {
        return (Contract) this.getEntity();
    }

    
    public void updateData() throws ApplicationException {
	calculateTaxAmount();
	
	super.updateData();
	getContract().calculate();
    }      
 
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(endDateField, "endDate");
	bindControl(nameField, "name", nameLabel, REQUIRED);	
	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(responsibleField, "responsible");
	bindControl(projectField, "project");
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	bindControl(currencyRateDateField, "currencyRateDate");
	bindControl(currencyAmountField, "currencyEnterAmount");
	bindControl(taxField, "taxId");
	bindControl(currencyTaxAmountField, "currencyTaxAmount");
	bindControl(currencyPrepayAmountField, "currencyPrepayAmount");
	
	////
	
	bindControl(organizationDetailsPanel.getContactField(), "organizationContact");
	bindControl(organizationDetailsPanel.getBankAccountField(), "organizationBankAccount");
	
	bindControl(organizationDetailsPanel.getPersonField(), "organizationPerson");
	bindControl(organizationDetailsPanel.getPersonEnField(), "organizationPersonEn");
	bindControl(organizationDetailsPanel.getPersonDetailField(), "organizationPersonDetail");
	bindControl(organizationDetailsPanel.getPersonDetailEnField(), "organizationPersonDetailEn");
	bindControl(organizationDetailsPanel.getPersonOnBasisField(), "organizationPersonOnBasis");
	bindControl(organizationDetailsPanel.getPersonOnBasisEnField(), "organizationPersonOnBasisEn");
	
	bindControl(organizationDetailsPanel.getAddressField(), "organizationAddress");
	bindControl(organizationDetailsPanel.getAddressEnField(), "organizationAddressEn");
	
	bindControl(organizationDetailsPanel.getPhoneField(), "organizationPhone");
	bindControl(organizationDetailsPanel.getFaxField(), "organizationFax");
	
	bindControl(organizationDetailsPanel.getBankNameField(), "organizationBankName");
	bindControl(organizationDetailsPanel.getBankNameEnField(), "organizationBankNameEn");
	
	////
	
	bindControl(partnerDetailsPanel.getContactField(), "partnerContact");
	bindControl(partnerDetailsPanel.getBankAccountField(), "partnerBankAccount");
	
	bindControl(partnerDetailsPanel.getPersonField(), "partnerPerson");
	bindControl(partnerDetailsPanel.getPersonEnField(), "partnerPersonEn");
	bindControl(partnerDetailsPanel.getPersonDetailField(), "partnerPersonDetail");
	bindControl(partnerDetailsPanel.getPersonDetailEnField(), "partnerPersonDetailEn");
	bindControl(partnerDetailsPanel.getPersonOnBasisField(), "partnerPersonOnBasis");
	bindControl(partnerDetailsPanel.getPersonOnBasisEnField(), "partnerPersonOnBasisEn");
	
	bindControl(partnerDetailsPanel.getAddressField(), "partnerAddress");
	bindControl(partnerDetailsPanel.getAddressEnField(), "partnerAddressEn");
	
	bindControl(partnerDetailsPanel.getPhoneField(), "partnerPhone");
	bindControl(partnerDetailsPanel.getFaxField(), "partnerFax");
	
	bindControl(partnerDetailsPanel.getBankNameField(), "partnerBankName");
	bindControl(partnerDetailsPanel.getBankNameEnField(), "partnerBankNameEn");	
	
	////
	
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
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void loadBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner) {
	updateBankAccountField(bankAccountField, partner);
	getBankAccountHelper().loadBankAccountsByPartnerField(bankAccountField, partner);
    }

    protected void updateBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner) {
	updateBankAccountField(bankAccountField, partner, false);
    }
    
    protected void updateBankAccountField(XComboEdit bankAccountField, IPartnerTitle partner, boolean isChangePartner) {
	
	boolean isDefaultLoad = updatePartnerableField(bankAccountField, partner, isChangePartner);
	
	if (isChangePartner) {
	    getBankAccountHelper().loadBankAccountsByPartnerField(bankAccountField, partner);
	}
	
	if (isDefaultLoad) {
	    bankAccountField.setValue(getBankAccountHelper().getBankAccount(partner));
	}
	
    }

    
    protected void initBankAccountField(final XComboEdit field) {
	if (field == null) {
	    return;
	}
	field.setSupportService(false);
	field.setListFormClass(PartnerBankAccountListForm.class);
	field.setDisplayValueProperty("accountNo");
	//bankAccountField.setTrimText(false); // Disable trim text: getText(). AccountNo is CHAR() field in table.
    }    
    
    protected void initContactField(final XComboEdit field) {
	if (field == null) {
	    return;
	}
	field.setListFormClass(ContactListForm.class);
	field.setSupportService(false);
    }  

    protected PartnerService getPartnerService() {
	return (PartnerService) getService(PartnerService.class);
    }
    
    protected BankAccountService getBankAccountService() {
	return (BankAccountService) getService(BankAccountService.class);
    }
    
    protected ContactService getContactService() {
	return (ContactService) getService(ContactService.class);
    }
    
    public List getBankAccountsByPartner(IPartnerTitle partner) {
	return getBankAccountHelper().getBankAccountsByPartner(partner);
    }
    
    
    public List getContactsByPartner(IPartnerTitle partner) {
	if (partner == null) {
	    return null;
	}
	Integer partnerId = partner.getId();
	try {
	    return getContactService().findByOrganizationId(getOrganization().getId(), partnerId);
	} catch (ApplicationException ex) {
	    logger.error(ex);
	    return null;
	}
	
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Organization
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initOrganizationBankAccountField(final XComboEdit field) {
	this.organizationBankAccountField = field;
	if (field == null) {
	    return;
	}
	
	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getBankAccountsByPartner(getDocumentOrganization()));
	    }
	}));

	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onOrganizationBankAccountFieldAction();
	    }
	}));
	

	
    }
    
    protected void onOrganizationBankAccountFieldAction() {
	if (!organizationBankAccountField.isModify()) {
	    return;
	}
	updateBankAccountField(organizationBankAccountField, getDocumentOrganization());
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Partner
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initPartnerBankAccountField(final XComboEdit field) {
	this.partnerBankAccountField = field;
	if (field == null) {
	    return;
	}

	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getBankAccountsByPartner(getPartnerFieldValue()));
	    }
	}));
	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onPartnerBankAccountFieldAction();
	    }
	}));
	
	
    }
    
    protected void onPartnerBankAccountFieldAction() {
	if (!partnerBankAccountField.isModify()) {
	    return;
	}
	updateBankAccountField(partnerBankAccountField, getPartnerFieldValue());
    }    
    

    ////
    
    
    protected void beforeUpdateForm() throws ApplicationException {
	isUpdateForm = false;
	super.beforeUpdateForm();
	loadBankAccountField(organizationBankAccountField, getDocumentOrganization());
	loadBankAccountField(partnerBankAccountField, getDocumentPartner());
	
	loadContactField(organizationContactField, getDocumentOrganization());
	loadContactField(partnerContactField, getDocumentPartner());
    }
      
    protected void afterUpdateForm() throws ApplicationException {
	super.afterUpdateForm();
	isUpdateForm = true;
    }
    
    protected void initPartnerField(final XComboEdit partnerField) {
	super.initPartnerField(partnerField);
	partnerField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		IPartnerTitle partner = (IPartnerTitle) partnerField.getValue();
		updateBankAccountField(partnerBankAccountField, partner, true);
	    }
	});
    }

    ////
    
    public BankAccountHelper getBankAccountHelper() {
	if (bankAccountHelper == null) {
	    final ContractEditForm thisForm = this;
	    bankAccountHelper = new BankAccountHelper(new BankAccountHelperProvider() {
		
		public PartnerService getPartnerService() {
		    return thisForm.getPartnerService();
		}
		
		public BankAccountService getBankAccountService() {
		    return thisForm.getBankAccountService();
		}
		    
		public IPartnerTitle getDocumentOrganization() {
		    return thisForm.getDocumentOrganization();
		}
		    
		public IPartnerTitle getDocumentPartner() {
		    return thisForm.getDocumentPartner();
		}
	    });
	}
        return bankAccountHelper;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Contact fields
    // 
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void loadContactField(XComboEdit field, IPartnerTitle partner) {
	updateContactField(field, partner);
	loadContactsByPartnerField(field, partner);
    }

    protected void updateContactField(XComboEdit field, IPartnerTitle partner) {
	updateContactField(field, partner, false);
    }
    
    protected void updateContactField(XComboEdit field, IPartnerTitle partner, boolean isChangePartner) {
	
	boolean isDefaultLoad = updatePartnerableField(field, partner, isChangePartner);
	
	if (isChangePartner) {
	    loadContactsByPartnerField(field, partner);
	}
	
	if (isDefaultLoad) {
	    //field.setValue(getContact(partner));
	}
	
    }

    protected void loadContactsByPartnerField(XComboEdit field, IPartnerTitle partner) {
	List dataList = getContactsByPartner(partner);
	if (dataList != null) {
	    field.setDataList(dataList);  
	}
    }
    
    protected void setPersonName(final XComboEdit field, final ContractDetailsPanel detailsPanel) {
	String personName = "";
	Contact c = (Contact) field.getValue();
	if (c != null && c.getName() != null) {
	    personName = c.getName().trim();
	}
	detailsPanel.getPersonField().setText(personName);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Organization
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initOrganizationContactField(final XComboEdit field) {
	this.organizationContactField = field;
	if (field == null) {
	    return;
	}
	
	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getContactsByPartner(getDocumentOrganization()));
	    }
	}));

	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onOrganizationContactFieldAction();
	    }
	}));
	
	field.addSelectionListener((new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		setPersonName(organizationContactField, organizationDetailsPanel);
	    }
	}));
	
    }
    
    protected void onOrganizationContactFieldAction() {
	if (!organizationContactField.isModify()) {
	    return;
	}
	updateContactField(organizationContactField, getDocumentOrganization());
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Partner
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void initPartnerContactField(final XComboEdit field) {
	this.partnerContactField = field;
	if (field == null) {
	    return;
	}

	field.addLoadListener((new LoadListener() {
	    public void load(LoadEvent e) {
		if (!isUpdateForm) {
		    return;
		}
		field.setDataList(getContactsByPartner(getPartnerFieldValue()));
	    }
	}));
	
	field.addUpdateListener((new UpdateListener() {
	    public void update(UpdateEvent e) {
		onPartnerContactFieldAction();
	    }
	}));
	
	field.addSelectionListener((new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		setPersonName(partnerContactField, partnerDetailsPanel);
	    }
	}));

	
    }
    
    protected void onPartnerContactFieldAction() {
	if (!partnerContactField.isModify()) {
	    return;
	}
	updateContactField(partnerContactField, getPartnerFieldValue());
    }    
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
