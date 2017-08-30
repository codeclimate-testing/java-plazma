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
 * Created on 04.07.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.plazmaforge.bsolution.bank.BankContext;
import org.plazmaforge.bsolution.bank.common.services.BankContextService;
import org.plazmaforge.bsolution.base.EnterpriseContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.SWTClientApplicationManager;
import org.plazmaforge.bsolution.base.common.beans.SystemPreference;
import org.plazmaforge.bsolution.base.common.services.EnterpriseContextService;
import org.plazmaforge.bsolution.base.common.services.SystemPreferenceService;
import org.plazmaforge.bsolution.contact.ContactContext;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.services.ContactContextService;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.project.ProjectContext;
import org.plazmaforge.bsolution.project.TaskContext;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.services.ProjectContextService;
import org.plazmaforge.bsolution.project.common.services.TaskContextService;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.AbstractControl;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.SystemFormat;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.util.FormatUtils;

/** 
 * @author Oleh Hapon
 * $Id: SystemInfoEditForm.java,v 1.7 2010/12/05 07:57:20 ohapon Exp $
 */

public class SystemInfoEditForm extends AbstractEditForm {

    

    private Label periodLabel;  
    private Label payrollPeriodLabel; 
    private Label currencyLabel;
    private Label unitLabel;
    private Label taxLabel; 
    
    private Label internationalAttributesLabel;
    private Label multiCurrenciesLabel;
    private Label autoSetCurrencyRateLabel;
    private Label projectInDocumentLabel;
    private Label autoCalculateProdRestLabel;
    

    private Label partnerLabel;
    private Label supplierLabel;
    private Label customerLabel;
    private Label responsibleLabel;   
    private Label mtrlResponsibleLabel; 
    private Label warehouseLabel;
    private Label incomeWarehouseLabel;
    private Label outcomeWarehouseLabel;

    private Label contactResponsibleLabel;
    private Label contactTypeLabel;
    private Label addressTypeLabel;
    private Label phoneTypeLabel;

    private Label bankPartnerLabel;
    private Label bankIncomePartnerLabel;
    private Label bankOutcomePartnerLabel;
    private Label paymentTypeLabel;
    private Label taxPrintTypeLabel;
    
    private Label projectPartnerLabel;
    private Label projectResponsibleLabel;  
    private Label projectStageLabel;
    private Label projectStatusLabel;
    private Label projectTypeLabel;
    private Label projectCurrencyLabel;
    
    private Label taskPartnerLabel;
    private Label taskResponsibleLabel;  
    private Label projectLabel;
    private Label taskPriorityLabel;
    private Label taskStatusLabel;
    private Label taskTypeLabel;
    private Label taskResultLabel;
  
    
    
  
    private XComboEdit periodField;
    private XComboEdit payrollPeriodField;
    private XComboEdit currencyField;
    private XComboEdit unitField;
    private XComboEdit taxField;    
    
    
    private XCheckBox internationalAttributesField;
    private XCheckBox multiCurrenciesField;
    private XCheckBox autoSetCurrencyRateField;
    private XCheckBox projectInDocumentField;
    private XCheckBox autoCalculateProdRestField;

    private XComboEdit partnerField;
    private XComboEdit supplierField;
    private XComboEdit customerField;    
    private XComboEdit responsibleField; 
    private XComboEdit mtrlResponsibleField;
    private XComboEdit warehouseField;
    private XComboEdit incomeWarehouseField;
    private XComboEdit outcomeWarehouseField;
    
    private XComboEdit contactResponsibleField;
    private XComboEdit contactTypeField;
    private XComboEdit addressTypeField;
    private XComboEdit phoneTypeField;
    
    private XComboEdit bankPartnerField;
    private XComboEdit bankIncomePartnerField;
    private XComboEdit bankOutcomePartnerField;
    private XComboEdit paymentTypeField;
    private XComboEdit taxPrintTypeField;
    
    private XComboEdit projectPartnerField;
    private XComboEdit projectResponsibleField;
    private XComboEdit projectStageField;
    private XComboEdit projectStatusField;
    private XComboEdit projectTypeField;
    private XComboEdit projectCurrencyField;
    
    private XComboEdit taskPartnerField;
    private XComboEdit taskResponsibleField;
    private XComboEdit projectField;
    private XComboEdit taskPriorityField;
    private XComboEdit taskStatusField;
    private XComboEdit taskTypeField;
    private XComboEdit taskResultField;


    //
    
    private Label dateFormatLabel;
    private Label timeFormatLabel;
    private Label numberFormatLabel;
    private Label currencyFormatLabel;
    private Label percentFormatLabel;
    private Label quantityFormatLabel;
    private Label coefficientFormatLabel;
    
    
    private XComboEdit dateFormatField;
    private XComboEdit timeFormatField;
    private XComboEdit numberFormatField;
    private XComboEdit currencyFormatField;
    private XComboEdit percentFormatField;
    private XComboEdit quantityFormatField;
    private XComboEdit coefficientFormatField;

    private Label dateFormatExample;
    private Label timeFormatExample;
    private Label numberFormatExample;
    
    private Label currencyFormatExample;
    private Label percentFormatExample;
    private Label quantityFormatExample;
    private Label coefficientFormatExample;
    
    //

    private Label calculateAccountingLabel;
    private XCheckBox calculateAccountingField;
    
    //
    
    private EnterpriseContext enterpriseContext;
    private EnterpriseContextService enterpriseContextService;
    
    private ContactContext contactContext;
    private ContactContextService contactContextService;

    private BankContext bankContext;
    private BankContextService bankContextService;

    private ProjectContext projectContext;
    private ProjectContextService projectContextService;

    private TaskContext taskContext;
    private TaskContextService taskContextService;
    
    private SystemPreferenceService systemPreferenceService;
    
    //
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public SystemInfoEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	
	TabItem generalTabItem;
	TabItem additionalTabItem;
	TabItem contactTabItem;
	TabItem bankTabItem;
	TabItem projectTabItem;
	TabItem taskTabItem;
	TabItem accountingTabItem;
	TabItem formatTabItem;
	
	
	Composite composite;
	GridLayout gridLayout;
	

	setTitle(Messages.getString("SystemInfoEditForm.title")); //$NON-NLS-1$
	setLayout(new FillLayout());
	GridData gridData;

    	tabFolder = new TabFolder(this, SWT.NONE);

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("SystemInfoEditForm.generalTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	periodLabel = new Label(composite, SWT.NONE);
    	periodLabel.setLayoutData(new GridData());
    	periodLabel.setText(Messages.getString("SystemInfoEditForm.periodLabel.text"));  //$NON-NLS-1$

    	periodField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	periodField.setLayoutData(gridData);
    	
 	
    	payrollPeriodLabel = new Label(composite, SWT.NONE);
    	payrollPeriodLabel.setLayoutData(new GridData());
    	payrollPeriodLabel.setText(Messages.getString("SystemInfoEditForm.payrollPeriodLabel.text"));  //$NON-NLS-1$

    	payrollPeriodField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	payrollPeriodField.setLayoutData(gridData);
    	
    	
    	currencyLabel = new Label(composite, SWT.NONE);
    	currencyLabel.setLayoutData(new GridData());
    	currencyLabel.setText(Messages.getString("SystemInfoEditForm.currencyLabel.text"));  //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	currencyField.setLayoutData(gridData);
    	
    	
    	
	unitLabel = new Label(composite, SWT.NONE);
	unitLabel.setLayoutData(new GridData());
	unitLabel.setText(Messages.getString("SystemInfoEditForm.unitLabel.text"));  //$NON-NLS-1$

	unitField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	unitField.setLayoutData(gridData);
    	
    	
    	
  	
	taxLabel = new Label(composite, SWT.NONE);
	taxLabel.setLayoutData(new GridData());
	taxLabel.setText(Messages.getString("SystemInfoEditForm.taxLabel.text"));  //$NON-NLS-1$

	taxField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	taxField.setLayoutData(gridData);

    	internationalAttributesLabel = new Label(composite, SWT.NONE);
    	internationalAttributesLabel.setText(Messages.getString("SystemInfoEditForm.internationalAttributesLabel.text")); //$NON-NLS-1$
    	
    	internationalAttributesField = new XCheckBox(composite, SWT.NONE);
    	internationalAttributesField.setLayoutData(new GridData());


    	//
    	
	multiCurrenciesLabel = new Label(composite, SWT.NONE);
	multiCurrenciesLabel.setText(Messages.getString("SystemInfoEditForm.multiCurrenciesLabel.text")); //$NON-NLS-1$
    	
	multiCurrenciesField = new XCheckBox(composite, SWT.NONE);
	multiCurrenciesField.setLayoutData(new GridData());
	
	//
    	
	autoSetCurrencyRateLabel = new Label(composite, SWT.NONE);
	autoSetCurrencyRateLabel.setText(Messages.getString("SystemInfoEditForm.autoSetCurrencyRateLabel.text")); //$NON-NLS-1$
    	
	autoSetCurrencyRateField = new XCheckBox(composite, SWT.NONE);
	autoSetCurrencyRateField.setLayoutData(new GridData());
    	//

	projectInDocumentLabel = new Label(composite, SWT.NONE);
	projectInDocumentLabel.setText(Messages.getString("SystemInfoEditForm.projectInDocumentLabel.text")); //$NON-NLS-1$
    	
	projectInDocumentField = new XCheckBox(composite, SWT.NONE);
	projectInDocumentField.setLayoutData(new GridData());
	
    	//

	autoCalculateProdRestLabel = new Label(composite, SWT.NONE);
	autoCalculateProdRestLabel.setText(Messages.getString("SystemInfoEditForm.autoCalculateProdRestLabel.text")); //$NON-NLS-1$
    	
	autoCalculateProdRestField = new XCheckBox(composite, SWT.NONE);
	autoCalculateProdRestField.setLayoutData(new GridData());
	
    	//

	additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	additionalTabItem.setText(Messages.getString("SystemInfoEditForm.additionalTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	additionalTabItem.setControl(composite);
        	
  	

    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setLayoutData(new GridData());
    	partnerLabel.setText(Messages.getString("SystemInfoEditForm.partnerLabel.text"));  //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	
    	partnerField.setLayoutData(gridData);
    	partnerField.setAssociationValueClass(Partner.class);
    	
    	
    	
    	supplierLabel = new Label(composite, SWT.NONE);
    	supplierLabel.setLayoutData(new GridData());
    	supplierLabel.setText(Messages.getString("SystemInfoEditForm.supplierLabel.text"));  //$NON-NLS-1$

    	supplierField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	supplierField.setLayoutData(gridData);
    	supplierField.setAssociationValueClass(Partner.class);
    	
    	
    	
    	
    	customerLabel = new Label(composite, SWT.NONE);
    	customerLabel.setLayoutData(new GridData());
    	customerLabel.setText(Messages.getString("SystemInfoEditForm.customerLabel.text"));  //$NON-NLS-1$

    	customerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	customerField.setLayoutData(gridData);
    	customerField.setAssociationValueClass(Partner.class);
    	
    	
    	

    	responsibleLabel = new Label(composite, SWT.NONE);
    	responsibleLabel.setLayoutData(new GridData());
    	responsibleLabel.setText(Messages.getString("SystemInfoEditForm.responsibleLabel.text"));  //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	initResponsibleField(responsibleField);
    	
    	
    	
	mtrlResponsibleLabel = new Label(composite, SWT.NONE);
	mtrlResponsibleLabel.setLayoutData(new GridData());
	mtrlResponsibleLabel.setText(Messages.getString("SystemInfoEditForm.mtrlResponsibleLabel.text"));  //$NON-NLS-1$

	mtrlResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	mtrlResponsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	 
	
	warehouseLabel = new Label(composite, SWT.NONE);
	warehouseLabel.setLayoutData(new GridData());
	warehouseLabel.setText(Messages.getString("SystemInfoEditForm.warehouseLabel.text"));  //$NON-NLS-1$

	warehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	warehouseField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
	
	
	incomeWarehouseLabel = new Label(composite, SWT.NONE);
	incomeWarehouseLabel.setLayoutData(new GridData());
	incomeWarehouseLabel.setText(Messages.getString("SystemInfoEditForm.incomeWarehouseLabel.text"));  //$NON-NLS-1$

	incomeWarehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	incomeWarehouseField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	
	
	
	
	outcomeWarehouseLabel = new Label(composite, SWT.NONE);
	outcomeWarehouseLabel.setLayoutData(new GridData());
	outcomeWarehouseLabel.setText(Messages.getString("SystemInfoEditForm.outcomeWarehouseLabel.text"));  //$NON-NLS-1$

	outcomeWarehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	outcomeWarehouseField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	
	
    	//
	
 	//
	contactTabItem = new TabItem(tabFolder, SWT.NONE);
	contactTabItem.setText(Messages.getString("SystemInfoEditForm.contactTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	contactTabItem.setControl(composite);
    	
    	contactResponsibleLabel = new Label(composite, SWT.NONE);
    	contactResponsibleLabel.setLayoutData(new GridData());
    	contactResponsibleLabel.setText(Messages.getString("SystemInfoEditForm.contactResponsibleLabel.text")); //$NON-NLS-1$

    	contactResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData= new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	contactResponsibleField.setLayoutData(gridData);
    	initResponsibleField(contactResponsibleField);
    	
    	
    	contactTypeLabel = new Label(composite, SWT.NONE);
    	contactTypeLabel.setLayoutData(new GridData());
    	contactTypeLabel.setText(Messages.getString("SystemInfoEditForm.contactTypeLabel.text")); //$NON-NLS-1$

    	contactTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	contactTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	    	
    	
    	addressTypeLabel = new Label(composite, SWT.NONE);
    	addressTypeLabel.setLayoutData(new GridData());
    	addressTypeLabel.setText(Messages.getString("SystemInfoEditForm.addressTypeLabel.text")); //$NON-NLS-1$

    	addressTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	addressTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	
    	phoneTypeLabel = new Label(composite, SWT.NONE);
    	phoneTypeLabel.setLayoutData(new GridData());
    	phoneTypeLabel.setText(Messages.getString("SystemInfoEditForm.phoneTypeLabel.text")); //$NON-NLS-1$

    	phoneTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	phoneTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	//
	bankTabItem = new TabItem(tabFolder, SWT.NONE);
    	bankTabItem.setText(Messages.getString("SystemInfoEditForm.bankTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	bankTabItem.setControl(composite);
    	
    	bankPartnerLabel = new Label(composite, SWT.NONE);
    	bankPartnerLabel.setLayoutData(new GridData());
    	bankPartnerLabel.setText(Messages.getString("SystemInfoEditForm.bankPartnerLabel.text"));  //$NON-NLS-1$

    	bankPartnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	
    	bankPartnerField.setLayoutData(gridData);
    	bankPartnerField.setAssociationValueClass(Partner.class);
    	
    	
    	
  	bankIncomePartnerLabel = new Label(composite, SWT.NONE);
    	bankIncomePartnerLabel.setLayoutData(new GridData());
    	bankIncomePartnerLabel.setText(Messages.getString("SystemInfoEditForm.bankIncomePartnerLabel.text"));  //$NON-NLS-1$

    	bankIncomePartnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	bankIncomePartnerField.setLayoutData(gridData);
    	bankIncomePartnerField.setAssociationValueClass(Partner.class);

    	
    	
  	bankOutcomePartnerLabel = new Label(composite, SWT.NONE);
    	bankOutcomePartnerLabel.setLayoutData(new GridData());
    	bankOutcomePartnerLabel.setText(Messages.getString("SystemInfoEditForm.bankOutcomePartnerLabel.text"));  //$NON-NLS-1$

    	bankOutcomePartnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	bankOutcomePartnerField.setLayoutData(gridData);
    	bankOutcomePartnerField.setAssociationValueClass(Partner.class);

    	
	//
    	paymentTypeLabel = new Label(composite, SWT.NONE);
    	paymentTypeLabel.setText(Messages.getString("SystemInfoEditForm.paymentTypeLabel.text")); //$NON-NLS-1$

    	paymentTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
    	paymentTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    
    	taxPrintTypeLabel = new Label(composite, SWT.NONE);
    	taxPrintTypeLabel.setText(Messages.getString("SystemInfoEditForm.taxPrintTypeLabel.text")); //$NON-NLS-1$

    	taxPrintTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
    	taxPrintTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
 	//
	projectTabItem = new TabItem(tabFolder, SWT.NONE);
	projectTabItem.setText(Messages.getString("SystemInfoEditForm.projectTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	projectTabItem.setControl(composite);
    	
	projectPartnerLabel = new Label(composite, SWT.NONE);
	projectPartnerLabel.setLayoutData(new GridData());
	projectPartnerLabel.setText(Messages.getString("SystemInfoEditForm.projectPartnerLabel.text"));  //$NON-NLS-1$

	projectPartnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	
    	projectPartnerField.setLayoutData(gridData);
    	projectPartnerField.setAssociationValueClass(Partner.class);
    	
    	
    	projectResponsibleLabel = new Label(composite, SWT.NONE);
    	projectResponsibleLabel.setLayoutData(new GridData());
    	projectResponsibleLabel.setText(Messages.getString("SystemInfoEditForm.projectResponsibleLabel.text"));  //$NON-NLS-1$

    	projectResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectResponsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	initResponsibleField(projectResponsibleField);
    	
    	
    	projectStageLabel = new Label(composite, SWT.NONE);
    	projectStageLabel.setLayoutData(new GridData());
    	projectStageLabel.setText(Messages.getString("SystemInfoEditForm.projectStageLabel.text"));  //$NON-NLS-1$

    	projectStageField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectStageField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	    	
    	
    	
    	projectStatusLabel = new Label(composite, SWT.NONE);
    	projectStatusLabel.setLayoutData(new GridData());
    	projectStatusLabel.setText(Messages.getString("SystemInfoEditForm.projectStatusLabel.text"));  //$NON-NLS-1$

    	projectStatusField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectStatusField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	
    	projectTypeLabel = new Label(composite, SWT.NONE);
    	projectTypeLabel.setLayoutData(new GridData());
    	projectTypeLabel.setText(Messages.getString("SystemInfoEditForm.projectTypeLabel.text"));  //$NON-NLS-1$

    	projectTypeField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	
    	
    	
	projectCurrencyLabel = new Label(composite, SWT.NONE);
    	projectCurrencyLabel.setLayoutData(new GridData());
    	projectCurrencyLabel.setText(Messages.getString("SystemInfoEditForm.projectCurrencyLabel.text"));  //$NON-NLS-1$

    	projectCurrencyField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectCurrencyField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
      	
    	
 	//
	taskTabItem = new TabItem(tabFolder, SWT.NONE);
	taskTabItem.setText(Messages.getString("SystemInfoEditForm.taskTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	taskTabItem.setControl(composite);
    	
	taskPartnerLabel = new Label(composite, SWT.NONE);
	taskPartnerLabel.setLayoutData(new GridData());
	taskPartnerLabel.setText(Messages.getString("SystemInfoEditForm.taskPartnerLabel.text"));  //$NON-NLS-1$

	taskPartnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	
    	taskPartnerField.setLayoutData(gridData);
    	taskPartnerField.setAssociationValueClass(Partner.class);
    	
    	
    	taskResponsibleLabel = new Label(composite, SWT.NONE);
    	taskResponsibleLabel.setLayoutData(new GridData());
    	taskResponsibleLabel.setText(Messages.getString("SystemInfoEditForm.taskResponsibleLabel.text"));  //$NON-NLS-1$

    	taskResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	taskResponsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	initResponsibleField(taskResponsibleField);
    	
    	
    	
    	projectLabel = new Label(composite, SWT.NONE);
    	projectLabel.setText(Messages.getString("SystemInfoEditForm.projectLabel.text")); //$NON-NLS-1$

    	projectField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	projectField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	projectField.setAssociationValueClass(Project.class);
    	
    	
    	
	taskPriorityLabel = new Label(composite, SWT.NONE);
    	taskPriorityLabel.setLayoutData(new GridData());
    	taskPriorityLabel.setText(Messages.getString("SystemInfoEditForm.taskPriorityLabel.text"));  //$NON-NLS-1$

    	taskPriorityField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	taskPriorityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	
    	taskStatusLabel = new Label(composite, SWT.NONE);
    	taskStatusLabel.setLayoutData(new GridData());
    	taskStatusLabel.setText(Messages.getString("SystemInfoEditForm.taskStatusLabel.text"));  //$NON-NLS-1$

    	taskStatusField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	taskStatusField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	
    	taskTypeLabel = new Label(composite, SWT.NONE);
    	taskTypeLabel.setLayoutData(new GridData());
    	taskTypeLabel.setText(Messages.getString("SystemInfoEditForm.taskTypeLabel.text"));  //$NON-NLS-1$

    	taskTypeField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	taskTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	taskResultLabel = new Label(composite, SWT.NONE);
    	taskResultLabel.setLayoutData(new GridData());
    	taskResultLabel.setText(Messages.getString("SystemInfoEditForm.taskResultLabel.text"));  //$NON-NLS-1$

    	taskResultField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	taskResultField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	//
    	
    	// Accounting
	accountingTabItem = new TabItem(tabFolder, SWT.NONE);
	accountingTabItem.setText(Messages.getString("SystemInfoEditForm.accountingTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 3;
    	composite.setLayout(gridLayout);
    	accountingTabItem.setControl(composite);

    	
    	calculateAccountingLabel = new Label(composite, SWT.NONE);
    	calculateAccountingLabel.setLayoutData(new GridData());
    	calculateAccountingLabel.setText(Messages.getString("SystemInfoEditForm.calculateAccountingLabel.text")); //$NON-NLS-1$

    	calculateAccountingField = new XCheckBox(composite, SWT.NONE);
    	calculateAccountingField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	
 	//
    	
	formatTabItem = new TabItem(tabFolder, SWT.NONE);
	formatTabItem.setText(Messages.getString("SystemInfoEditForm.formatTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 3;
    	composite.setLayout(gridLayout);
    	formatTabItem.setControl(composite);

    	
    	dateFormatLabel = new Label(composite, SWT.NONE);
	dateFormatLabel.setLayoutData(new GridData());
    	dateFormatLabel.setText(Messages.getString("SystemInfoEditForm.dateFormatLabel.text")); //$NON-NLS-1$

    	dateFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	dateFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	dateFormatField.setEditable(true);
    	
    	populate(dateFormatField, FormatUtils.getDatePatterns());
    	
    	//dateFormatField.add("dd.MM.yyyy");
    	//dateFormatField.add("dd/MM/yyyy");
    	//dateFormatField.add("d/M/yyyy");
    	//dateFormatField.add("yyyy-MM-dd");
    	//dateFormatField.add("M/d/yyyy");
    	
    	dateFormatExample = new Label(composite, SWT.NONE);
	dateFormatExample.setLayoutData(new GridData());
    	dateFormatExample.setText("");

    	dateFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatDate(dateFormatField, dateFormatExample);
    	    }
    	});
    	
    	////

    	timeFormatLabel = new Label(composite, SWT.NONE);
    	timeFormatLabel.setLayoutData(new GridData());
    	timeFormatLabel.setText(Messages.getString("SystemInfoEditForm.timeFormatLabel.text")); //$NON-NLS-1$

    	timeFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	timeFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	timeFormatField.setEditable(true);
    	
    	
    	populate(timeFormatField, FormatUtils.getTimePatterns());
    	
    	//timeFormatField.add("hh:mm:ss");
    	//timeFormatField.add("h:m:s");
    	//timeFormatField.add("HH:mm:ss");
    	//timeFormatField.add("H:m:s");

    	
    	timeFormatExample = new Label(composite, SWT.NONE);
    	timeFormatExample.setLayoutData(new GridData());
    	timeFormatExample.setText("");
    	
    	timeFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatDate(timeFormatField, timeFormatExample);
    	    }
    	});

    	////

    	numberFormatLabel = new Label(composite, SWT.NONE);
    	numberFormatLabel.setLayoutData(new GridData());
    	numberFormatLabel.setText(Messages.getString("SystemInfoEditForm.numberFormatLabel.text")); //$NON-NLS-1$

    	numberFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	numberFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	numberFormatField.setEditable(true);
    	
    	populate(numberFormatField, FormatUtils.getNumberPatterns());
    	
    	//numberFormatField.add("#,##0.###");
    	//numberFormatField.add("#,##0.000");
    	//numberFormatField.add("###0.###");
    	//numberFormatField.add("###0.000");

    	
    	numberFormatExample = new Label(composite, SWT.NONE);
    	numberFormatExample.setLayoutData(new GridData());
    	numberFormatExample.setText("");
    	
    	numberFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatNumber(numberFormatField, numberFormatExample);
    	    }
    	});

    	////

    	currencyFormatLabel = new Label(composite, SWT.NONE);
    	currencyFormatLabel.setLayoutData(new GridData());
    	currencyFormatLabel.setText(Messages.getString("SystemInfoEditForm.currencyFormatLabel.text")); //$NON-NLS-1$

    	currencyFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	currencyFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	currencyFormatField.setEditable(true);
    	
    	populate(currencyFormatField, FormatUtils.getCurrencyPatterns());
    	
    	//currencyFormatField.add("#,##0.##");
    	//currencyFormatField.add("#,##0.00");
    	//currencyFormatField.add("###0.##");
    	//currencyFormatField.add("###0.00");

    	
    	currencyFormatExample = new Label(composite, SWT.NONE);
    	currencyFormatExample.setLayoutData(new GridData());
    	currencyFormatExample.setText("");
    	
    	currencyFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatNumber(currencyFormatField, currencyFormatExample);
    	    }
    	});

    	//// percent

    	percentFormatLabel = new Label(composite, SWT.NONE);
    	percentFormatLabel.setLayoutData(new GridData());
    	percentFormatLabel.setText(Messages.getString("SystemInfoEditForm.percentFormatLabel.text")); //$NON-NLS-1$

    	percentFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	percentFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	percentFormatField.setEditable(true);
    	
    	populate(percentFormatField, FormatUtils.getPercentPatterns());
    	
    	//percentFormatField.add("#,##0.##");
    	//percentFormatField.add("#,##0.00");
    	//percentFormatField.add("###0.##");
    	//percentFormatField.add("###0.00");

    	
    	percentFormatExample = new Label(composite, SWT.NONE);
    	percentFormatExample.setLayoutData(new GridData());
    	percentFormatExample.setText("");
    	
    	percentFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatNumber(percentFormatField, percentFormatExample);
    	    }
    	});

    	//// quantity

    	quantityFormatLabel = new Label(composite, SWT.NONE);
    	quantityFormatLabel.setLayoutData(new GridData());
    	quantityFormatLabel.setText(Messages.getString("SystemInfoEditForm.quantityFormatLabel.text")); //$NON-NLS-1$

    	quantityFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	quantityFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	quantityFormatField.setEditable(true);
    	
    	populate(quantityFormatField, FormatUtils.getQuantityPatterns());
    	
    	//quantityFormatField.add("#,##0.##");
    	//quantityFormatField.add("#,##0.00");
    	//quantityFormatField.add("###0.##");
    	//quantityFormatField.add("###0.00");

    	
    	quantityFormatExample = new Label(composite, SWT.NONE);
    	quantityFormatExample.setLayoutData(new GridData());
    	quantityFormatExample.setText("");
    	
    	quantityFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatNumber(quantityFormatField, quantityFormatExample);
    	    }
    	});

    	//// coefficient

    	coefficientFormatLabel = new Label(composite, SWT.NONE);
    	coefficientFormatLabel.setLayoutData(new GridData());
    	coefficientFormatLabel.setText(Messages.getString("SystemInfoEditForm.coefficientFormatLabel.text")); //$NON-NLS-1$

    	coefficientFormatField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON);
    	coefficientFormatField.setLayoutData(new GridData(150, SWT.DEFAULT));
    	coefficientFormatField.setEditable(true);
    	
    	populate(coefficientFormatField, FormatUtils.getCoefficientPatterns());
    	
    	//coefficientFormatField.add("#,##0.##");
    	//coefficientFormatField.add("#,##0.00");
    	//coefficientFormatField.add("###0.##");
    	//coefficientFormatField.add("###0.00");

    	
    	coefficientFormatExample = new Label(composite, SWT.NONE);
    	coefficientFormatExample.setLayoutData(new GridData());
    	coefficientFormatExample.setText("");
    	
    	coefficientFormatField.addModifyListener(new ModifyListener() {
    	    public void modifyText(ModifyEvent e) {
    		exampleFormatNumber(coefficientFormatField, coefficientFormatExample);
    	    }
    	});

    	this.setSize(new Point(590, 261));    	
    }
    
    
    protected void bindControls() {
	
	// ENTERPRISE CONTEXT
	bindControl(periodField, "period");
	bindControl(payrollPeriodField, "payrollPeriod");
	bindControl(currencyField, "currency");
	bindControl(unitField, "unit");
	bindControl(taxField, "tax");

	bindControl(internationalAttributesField, "internationalAttributes");
	bindControl(multiCurrenciesField, "multiCurrencies");
	bindControl(autoSetCurrencyRateField, "autoSetCurrencyRate");
	bindControl(projectInDocumentField, "projectInDocument");
	bindControl(autoCalculateProdRestField, "autoCalculateProdRest");
	
	bindControl(partnerField, "partner");
	bindControl(supplierField, "supplier");
	bindControl(customerField, "customer");
	bindControl(responsibleField, "responsible");
	bindControl(mtrlResponsibleField, "mtrlResponsible");	
	bindControl(warehouseField, "warehouse");
	bindControl(incomeWarehouseField, "incomeWarehouse");
	bindControl(outcomeWarehouseField, "outcomeWarehouse");
	bindControl(calculateAccountingField, "calculateAccounting");

	
	// CONTACT CONTEXT
	bindControl(contactResponsibleField, "responsible");
	bindControl(contactTypeField, "contactType");
	bindControl(addressTypeField, "addressType");
	bindControl(phoneTypeField, "phoneType");	
	
	
	// BANK CONTEXT
	bindControl(bankPartnerField, "partner");
	bindControl(bankIncomePartnerField, "incomePartner");
	bindControl(bankOutcomePartnerField, "outcomePartner");
	bindControl(paymentTypeField, "paymentType");
	bindControl(taxPrintTypeField, "taxPrintType");
	
	
	// PROJECT CONTEXT
	bindControl(projectPartnerField, "partner");
	bindControl(projectResponsibleField, "responsible");
	bindControl(projectStageField, "projectStage");
	bindControl(projectStatusField, "projectStatus");
	bindControl(projectTypeField, "projectType");
	bindControl(projectCurrencyField, "currency");
	
	
	// TASK CONTEXT
	bindControl(taskPartnerField, "partner");
	bindControl(taskResponsibleField, "responsible");
	bindControl(projectField, "project");
	bindControl(taskPriorityField, "taskPriority");
	bindControl(taskStatusField, "taskStatus");
	bindControl(taskTypeField, "taskType");
	bindControl(taskResultField, "taskResult");

	
	///////////////////////////////////////////////////////////////
	// INITIALIZE CONTEXT FIELDS
	///////////////////////////////////////////////////////////////
	
	// ENTERPRISE CONTEXT
	initEnterpriseContextField(periodField);
	initEnterpriseContextField(payrollPeriodField);
	initEnterpriseContextField(currencyField);
	initEnterpriseContextField(unitField);
	initEnterpriseContextField(taxField);

	initEnterpriseContextField(internationalAttributesField);
	initEnterpriseContextField(multiCurrenciesField);
	initEnterpriseContextField(autoSetCurrencyRateField);
	initEnterpriseContextField(projectInDocumentField);
	initEnterpriseContextField(autoCalculateProdRestField);
	
	initEnterpriseContextField(partnerField);
	initEnterpriseContextField(supplierField);
	initEnterpriseContextField(customerField);
	initEnterpriseContextField(responsibleField);
	initEnterpriseContextField(mtrlResponsibleField);	
	initEnterpriseContextField(warehouseField);
	initEnterpriseContextField(incomeWarehouseField);
	initEnterpriseContextField(outcomeWarehouseField);
	initEnterpriseContextField(calculateAccountingField);
	
	
	// CONTACT CONTEXT
	initContactContextField(contactResponsibleField);
	initContactContextField(contactTypeField);
	initContactContextField(addressTypeField);
	initContactContextField(phoneTypeField);
	
	
	// BANK CONTEXT
	initBankContextField(bankPartnerField);
	initBankContextField(bankIncomePartnerField);
	initBankContextField(bankOutcomePartnerField);
	initBankContextField(paymentTypeField);
	initBankContextField(taxPrintTypeField);
	
	
	// PROJECT CONTEXT
	initProjectContextField(projectPartnerField);
	initProjectContextField(projectResponsibleField);
	initProjectContextField(projectStageField);
	initProjectContextField(projectStatusField);
	initProjectContextField(projectTypeField);
	initProjectContextField(projectCurrencyField);
	
	
	// TASK CONTEXT
	initTaskContextField(taskPartnerField);
	initTaskContextField(taskResponsibleField);
	initTaskContextField(projectField);
	initTaskContextField(taskPriorityField);
	initTaskContextField(taskStatusField);
	initTaskContextField(taskTypeField);
	initTaskContextField(taskResultField);
	
	
    }

    private void initContextField(AbstractControl field, Class entityClass) {
	field.setAnotherDataSource(true);
	field.setEntityClass(entityClass);
    }
    
    private void initEnterpriseContextField(AbstractControl field) {
	initContextField(field, EnterpriseContext.class);
    }
    
    private void initContactContextField(AbstractControl field) {
	initContextField(field, ContactContext.class);
    }
    
    private void initBankContextField(AbstractControl field) {
	initContextField(field, BankContext.class);
    }
  
    private void initProjectContextField(AbstractControl field) {
	initContextField(field, ProjectContext.class);
    }
    
    private void initTaskContextField(AbstractControl field) {
	initContextField(field, TaskContext.class);
    }
    
    
    
    
    protected void loadData() throws ApplicationException {
	//
	super.loadData();
	enterpriseContext = getEnterpriseContextService().load();
	contactContext = getContactContextService().load();
	bankContext = getBankContextService().load();
	projectContext = getProjectContextService().load();
	taskContext = getTaskContextService().load();
	
	loadSystemFormat();
    }
    
    protected void loadSystemFormat() throws ApplicationException {
	SystemFormat systemFormat = PlatformEnvironment.getSystemFormat();
	
	dateFormatField.setText(systemFormat.getDatePattern());
	timeFormatField.setText(systemFormat.getTimePattern());
	numberFormatField.setText(systemFormat.getNumberPattern());
	currencyFormatField.setText(systemFormat.getCurrencyPattern());
	percentFormatField.setText(systemFormat.getPercentPattern());
	quantityFormatField.setText(systemFormat.getQuantityPattern());
	coefficientFormatField.setText(systemFormat.getCoefficientPattern());
	
	
	exampleFormatDate(dateFormatField, dateFormatExample);
	exampleFormatDate(timeFormatField, timeFormatExample);
	exampleFormatNumber(numberFormatField, numberFormatExample);
	exampleFormatNumber(currencyFormatField, currencyFormatExample);
	exampleFormatNumber(percentFormatField, percentFormatExample);
	exampleFormatNumber(quantityFormatField, quantityFormatExample);	
	exampleFormatNumber(coefficientFormatField, coefficientFormatExample);
    }
    
    protected void storeData() throws ApplicationException {
	//
	super.storeData();
	getEnterpriseContextService().store(getEnterpriseContext());
	getContactContextService().store(getContactContext());
	getBankContextService().store(getBankContext());
	getProjectContextService().store(getProjectContext());
	getTaskContextService().store(getTaskContext());
	EnterpriseEnvironment.refresh();
	
	storeSystemFormat();
	
	
	// Update UI (status bar)
	SWTClientApplicationManager manager = new SWTClientApplicationManager();
	manager.updateStatusBar();
    }
    
    protected void storeSystemFormat() throws ApplicationException {
	// STUB
	SystemFormat systemFormat = PlatformEnvironment.getSystemFormat();
	boolean isModify = false;
	
	String oldDateFormat = systemFormat.getDatePattern();
	String newDateFormat = dateFormatField.getText();
	if (!oldDateFormat.equals(newDateFormat)) {
	    isModify = true;
	    systemFormat.setDatePattern(newDateFormat);
	}

	String oldTimeFormat = systemFormat.getTimePattern();
	String newTimeFormat = timeFormatField.getText();
	if (!oldTimeFormat.equals(newTimeFormat)) {
	    isModify = true;
	    systemFormat.setTimePattern(newTimeFormat);
	}
	
	String oldNumberFormat = systemFormat.getNumberPattern();
	String newNumberFormat = numberFormatField.getText();
	if (!oldNumberFormat.equals(newNumberFormat)) {
	    isModify = true;
	    systemFormat.setNumberPattern(newNumberFormat);
	}

	String oldCurrencyFormat = systemFormat.getCurrencyPattern();
	String newCurrencyFormat = currencyFormatField.getText();
	if (!oldCurrencyFormat.equals(newCurrencyFormat)) {
	    isModify = true;
	    systemFormat.setCurrencyPattern(newCurrencyFormat);
	}

	////
	
	String oldPercentFormat = systemFormat.getPercentPattern();
	String newPercentFormat = percentFormatField.getText();
	if (!oldPercentFormat.equals(newPercentFormat)) {
	    isModify = true;
	    systemFormat.setCurrencyPattern(newPercentFormat);
	}

	String oldQuantityFormat = systemFormat.getQuantityPattern();
	String newQuantityFormat = quantityFormatField.getText();
	if (!oldQuantityFormat.equals(newQuantityFormat)) {
	    isModify = true;
	    systemFormat.setCurrencyPattern(newQuantityFormat);
	}

	String oldCoefficientFormat = systemFormat.getCoefficientPattern();
	String newCoefficientFormat = coefficientFormatField.getText();
	if (!oldCoefficientFormat.equals(newCoefficientFormat)) {
	    isModify = true;
	    systemFormat.setCurrencyPattern(newCoefficientFormat);
	}

	if (isModify) {
	    SystemPreference systemPreference = getSystemPreferenceService().load();
	    systemPreference.loadFormat(systemFormat);
	    getSystemPreferenceService().store(systemPreference);
	}
    }
    
    protected void validateControls() throws ApplicationException {
	FormatUtils.checkDatePattern(dateFormatField.getText(),  FormatUtils.getDefaultDateCharSequence());
	FormatUtils.checkTimePattern(timeFormatField.getText(),  FormatUtils.getDefaultTimeCharSequence());
	super.validateControls();
    }
    
    protected void exampleFormatDate(XComboEdit edit, Label label) {
	if (edit == null || label == null) {
	    return;
	}
	String result = FormatUtils.formatExampleDate(edit.getText());
	if (result == null) {
	    result = "";
	}
	label.setText(result);
	label.getParent().layout();
    }

    protected void exampleFormatNumber(XComboEdit edit, Label label) {
	if (edit == null || label == null) {
	    return;
	}
	String result = FormatUtils.formatExampleNumber(edit.getText());
	if (result == null) {
	    result = "";
	}
	label.setText(result);
	label.getParent().layout();
    }
    
    
    

//    protected String formatDate(String pattern) {
//	String result = "";
//	try {
//	    SimpleDateFormat f = new SimpleDateFormat(pattern);
//	    result = f.format(new Date());
//	} catch (Exception ex) {
//	    
//	}
//	return result;
//    }
//    
//    protected String formatNumber(String pattern) {
//	String result = "";
//	try {
//	    DecimalFormat f = new DecimalFormat(pattern);
//	    result = f.format(1234567.890);
//	} catch (Exception ex) {
//	    
//	}
//	return result;
//    }

    
//    protected void checkDatePattern(String pattern) throws ApplicationException {
//	if (!FormatUtils.isValidDatePattern(pattern, FormatUtils.getDefaultDateCharSequence())) { // "dMy./- "
//	    throw new ApplicationException("Date format is invalid");
//	}
//    }
//
//    protected void checkTimePattern(String pattern) throws ApplicationException {
//	if (!FormatUtils.isValidTimePattern(pattern, FormatUtils.getDefaultTimeCharSequence())) { // "hHmst: "
//	    throw new ApplicationException("Date format is invalid");
//	}
//    }
//
//    protected void checkNumberPattern(String pattern) throws ApplicationException {
//	if (!FormatUtils.isValidNumberPattern(pattern, FormatUtils.getDefaultNumberCharSequence())) { // "#0., "
//	    throw new ApplicationException("Number format is invalid");
//	}
//    }

    
    
    
    public void updateForm() throws ApplicationException {

	////
	
	periodField.setEntity(getEnterpriseContext());
	payrollPeriodField.setEntity(getEnterpriseContext());
	currencyField.setEntity(getEnterpriseContext());
	unitField.setEntity(getEnterpriseContext());
	taxField.setEntity(getEnterpriseContext());

	internationalAttributesField.setEntity(getEnterpriseContext());
	multiCurrenciesField.setEntity(getEnterpriseContext());
	autoSetCurrencyRateField.setEntity(getEnterpriseContext());
	projectInDocumentField.setEntity(getEnterpriseContext());
	autoCalculateProdRestField.setEntity(getEnterpriseContext());
	
	partnerField.setEntity(getEnterpriseContext());
	supplierField.setEntity(getEnterpriseContext());
	customerField.setEntity(getEnterpriseContext());
	responsibleField.setEntity(getEnterpriseContext());
	mtrlResponsibleField.setEntity(getEnterpriseContext());	
	warehouseField.setEntity(getEnterpriseContext());
	incomeWarehouseField.setEntity(getEnterpriseContext());
	outcomeWarehouseField.setEntity(getEnterpriseContext());
	calculateAccountingField.setEntity(getEnterpriseContext());	
	
	////
	contactResponsibleField.setEntity(getContactContext());
	contactTypeField.setEntity(getContactContext());
	addressTypeField.setEntity(getContactContext());
	phoneTypeField.setEntity(getContactContext());	

	bankPartnerField.setEntity(getBankContext());
	bankIncomePartnerField.setEntity(getBankContext());
	bankOutcomePartnerField.setEntity(getBankContext());
	paymentTypeField.setEntity(getBankContext());
	taxPrintTypeField.setEntity(getBankContext());
	
	projectPartnerField.setEntity(getProjectContext());
	projectResponsibleField.setEntity(getProjectContext());
	projectStageField.setEntity(getProjectContext());
	projectStatusField.setEntity(getProjectContext());
	projectTypeField.setEntity(getProjectContext());
	projectCurrencyField.setEntity(getProjectContext());
	
	
	taskPartnerField.setEntity(getTaskContext());
	taskResponsibleField.setEntity(getTaskContext());
	projectField.setEntity(getTaskContext());
	taskPriorityField.setEntity(getTaskContext());
	taskStatusField.setEntity(getTaskContext());
	taskTypeField.setEntity(getTaskContext());
	taskResultField.setEntity(getTaskContext());
	
	super.updateForm();
    }
    
    
    public void updateData() throws ApplicationException {
	super.updateData();
    }

    
    
    public EnterpriseContextService getEnterpriseContextService() {
	if (enterpriseContextService == null) {
	    enterpriseContextService = (EnterpriseContextService) getService(EnterpriseContextService.class);
	}
	return enterpriseContextService;
    }

    public EnterpriseContext getEnterpriseContext() {
	return enterpriseContext;
    }   

    
    public ContactContextService getContactContextService() {
	if (contactContextService == null) {
	    contactContextService = (ContactContextService) getService(ContactContextService.class);
	}
	return contactContextService;
    }

    public ContactContext getContactContext() {
	return contactContext;
    }   
    
    
    
    
    
    public BankContextService getBankContextService() {
	if (bankContextService == null) {
	    bankContextService = (BankContextService) getService(BankContextService.class);
	}
	return bankContextService;
    }

    public BankContext getBankContext() {
	return bankContext;
    }

    public ProjectContextService getProjectContextService() {
	if (projectContextService == null) {
	    projectContextService = (ProjectContextService) getService(ProjectContextService.class);
	}
	return projectContextService;
    }

    public ProjectContext getProjectContext() {
	return projectContext;
    }

    public TaskContext getTaskContext() {
	return taskContext;
    }

    public TaskContextService getTaskContextService() {
	if (taskContextService == null) {
	    taskContextService = (TaskContextService) getService(TaskContextService.class);
	}
	return taskContextService;
    }

    public SystemPreferenceService getSystemPreferenceService() {
	if (systemPreferenceService == null) {
	    systemPreferenceService = (SystemPreferenceService) getService(SystemPreferenceService.class);
	}
	return systemPreferenceService;
    }

    private void populate(XComboEdit  comboEdit, String[] values )  {
	if (comboEdit == null || values == null || values.length == 0) {
	    return;
	}
	for (String value: values) {
	    comboEdit.add(value);
	}
    }

    private void initResponsibleField(XComboEdit field) {
	if (field == null) {
	    return;
	}
	field.setAssociationValueClass(Contact.class);
    }
    
}  //  @jve:decl-index=0:visual-constraint="10,10"

