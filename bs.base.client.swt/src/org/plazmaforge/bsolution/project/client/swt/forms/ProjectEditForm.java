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
 * Created on 06.02.2007
 *
 */

package org.plazmaforge.bsolution.project.client.swt.forms;


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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.finance.client.swt.forms.FinanceDocumentHelper;
import org.plazmaforge.bsolution.finance.client.swt.forms.common.XTaxCombo;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.project.ProjectEnvironment;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.beans.ProjectContactLink;
import org.plazmaforge.bsolution.project.common.beans.ProjectStageLink;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.MoneyCalculator;
import org.plazmaforge.framework.util.MoneyEnvironment;


/** 
 * @author Oleh Hapon
 * $Id: ProjectEditForm.java,v 1.10 2010/12/05 07:57:20 ohapon Exp $
 */

public class ProjectEditForm extends AbstractOrganizableEditForm {

    private static final int DEFAULT_CURRENCY_RATE = 1;
    
    private FinanceDocumentHelper financeDocumentHelper = new FinanceDocumentHelper(this);
    
    
    private Label nameLabel;

    private Label projectNoLabel;
    
    private Label projectTypeLabel;
    
    private Label contractDocumentLabel;

    private Label responsibleLabel;
    
    private Label partnerLabel;
    
    private Label projectStatusLabel;
    
    private Label startDateLabel;
    
    private Label endDateLabel;
    
    private Label actualEndLabel;
    
    private Label propabilityLabel;
    
    private Label currencyLabel;
    
    private Label currencyRateLabel;
    
    private Label currencyRateDateLabel;    
    
    private Label currencyAmountLabel;
    
    private Label discountPercentLabel;
    
    private Label currencyDiscountAmountLabel;    
    
    private Label currencyTotalLabel;

    private Label taxLabel;
    
    private Label currencyTaxTotalLabel;    
    
    private Label currencyTotalWithTaxLabel;

    
    private XTextField nameField;
    
    private XTextField projectNoField;
    
    private XComboEdit projectTypeField;
    
    private XComboEdit contractDocumentField;
    
    private XComboEdit responsibleField;
    
    private XComboEdit partnerField;
    
    private XComboEdit projectStatusField;
    
    private XDateCombo startDateField;
    
    private XDateCombo closeDateField;
    
    private XDateCombo actualEndDateField;
    
    private XNumberField propabilityField;  
    
    private XComboEdit currencyField;
    
    private XCurrencyField currencyRateField;
    
    private XDateCombo currencyRateDateField;
    
    private XCurrencyField currencyAmountField;
    
    private XCurrencyField discountPercentField;
    
    private XCurrencyField currencyDiscountAmountField;
    
    private XCurrencyField currencyTotalField;

    private XTaxCombo taxField;
    
    private XCurrencyField currencyTaxTotalField;    
    
    private XCurrencyField currencyTotalWithTaxField; 
    
    
    private XTextArea descriptionField;

    ////
    private Composite itemsPanel;

    private TabFolder itemsTabFolder;
    
    ////
    private TabItem contactTabItem;
    private TabItem stageTabItem;
         
    private Table contactTable;
    private Table stageTable;    

    
    private double currencyTaxAmount;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public ProjectEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem financeTabItem;
	TabItem descriptionTabItem;
	Composite composite;
	GridLayout gridLayout;
	Label label;
	
	setTitle(Messages.getString("ProjectEditForm.title")); //$NON-NLS-1$
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	

	setLayout(gridLayout);
	
	//setLayout(new FillLayout());
	GridData gridData;

    	int COLUMN_COUNT = 6;
    	int COLUMN_MARGIN = 20;
    	int FIELD_SIZE = 100;

    	
    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("ProjectEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setText(Messages.getString("ProjectEditForm.nameLabel.text")); //$NON-NLS-1$
    
    	nameField = new XTextField(composite, SWT.BORDER);
    	nameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	nameField.setTextLimit(50);

    	projectNoLabel = new Label(composite, SWT.NONE);
    	projectNoLabel.setText(Messages.getString("ProjectEditForm.projectNoLabel.text")); //$NON-NLS-1$

    	projectNoField = new XTextField(composite, SWT.BORDER);
    	projectNoField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	projectNoField.setTextLimit(20);

    	projectTypeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	projectTypeLabel.setLayoutData(gridData);
    	projectTypeLabel.setText(Messages.getString("ProjectEditForm.projectTypeLabel.text")); //$NON-NLS-1$

    	projectTypeField = new XComboEdit(composite, SWT.BORDER);
    	projectTypeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	contractDocumentLabel = new Label(composite, SWT.NONE);
    	contractDocumentLabel.setText(Messages.getString("ProjectEditForm.contractNoLabel.text")); //$NON-NLS-1$

    	contractDocumentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	contractDocumentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	contractDocumentField.setTextLimit(20);

    	responsibleLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	responsibleLabel.setLayoutData(gridData);
    	responsibleLabel.setText(Messages.getString("ProjectEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setText(Messages.getString("ProjectEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	partnerField.setLayoutData(gridData);

    	projectStatusLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	projectStatusLabel.setLayoutData(gridData);
    	projectStatusLabel.setText(Messages.getString("ProjectEditForm.projectStatusLabel.text")); //$NON-NLS-1$

    	projectStatusField = new XComboEdit(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 200;
    	projectStatusField.setLayoutData(gridData);

    	startDateLabel = new Label(composite, SWT.NONE);
    	startDateLabel.setText(Messages.getString("ProjectEditForm.startDateLabel.text")); //$NON-NLS-1$

    	startDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	startDateField.setLayoutData(gridData);

    	propabilityLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	propabilityLabel.setLayoutData(gridData);
    	propabilityLabel.setText(Messages.getString("ProjectEditForm.propabilityLabel.text")); //$NON-NLS-1$

    	propabilityField = new XNumberField(composite, SWT.BORDER);
    	propabilityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	endDateLabel = new Label(composite, SWT.NONE);
    	endDateLabel.setText(Messages.getString("ProjectEditForm.endDateLabel.text")); //$NON-NLS-1$

    	closeDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	closeDateField.setLayoutData(gridData);

    	actualEndLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	actualEndLabel.setLayoutData(gridData);
    	actualEndLabel.setText(Messages.getString("ProjectEditForm.actualEndLabel.text")); //$NON-NLS-1$

    	actualEndDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	actualEndDateField.setLayoutData(gridData);
    

    	financeTabItem = new TabItem(tabFolder, SWT.NONE);
    	financeTabItem.setText(Messages.getString("ProjectEditForm.financeTabItem.text")); //$NON-NLS-1$

    	
    	
    	//--
    	COLUMN_COUNT = 6;
    	FIELD_SIZE = 100;
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = COLUMN_COUNT;
    	composite.setLayout(gridLayout);
    	financeTabItem.setControl(composite);

    	currencyLabel = new Label(composite, SWT.NONE);
    	currencyLabel.setText(Messages.getString("ProjectEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_SIZE;
    	currencyField.setLayoutData(gridData);

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	currencyRateLabel.setLayoutData(gridData);
    	currencyRateLabel.setText(Messages.getString("ProjectEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	
    	currencyRateField = new XCurrencyField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_SIZE;
    	currencyRateField.setLayoutData(gridData);

   

    	// NEW:BEGIN
    	
    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("ProjectEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData();
    	gridData.widthHint = FIELD_SIZE;
    	currencyRateDateField.setLayoutData(gridData);

    	// NEW:END
    	
    	
    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, COLUMN_COUNT - 2, 1));
    	
 	currencyAmountLabel = new Label(composite, SWT.NONE);
 	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
 	currencyAmountLabel.setLayoutData(gridData);
    	currencyAmountLabel.setText(Messages.getString("ProjectEditForm.currencyAmountLabel.text")); //$NON-NLS-1$
    	
    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	currencyAmountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	// HORIZONTAL SEPARATOR
    	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, COLUMN_COUNT, 1));
    	
    	discountPercentLabel = new Label(composite, SWT.NONE);
    	discountPercentLabel.setText(Messages.getString("ProjectEditForm.discountPercentLabel.text")); //$NON-NLS-1$

    	discountPercentField = new XCurrencyField(composite, SWT.BORDER);
    	discountPercentField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	

    	
    	currencyDiscountAmountLabel = new Label(composite, SWT.NONE);
 	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	currencyDiscountAmountLabel.setLayoutData(gridData);
    	currencyDiscountAmountLabel.setText(Messages.getString("ProjectEditForm.discountAmountLabel.text")); //$NON-NLS-1$

    	currencyDiscountAmountField = new XCurrencyField(composite, SWT.BORDER);
    	currencyDiscountAmountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));


    	
     	currencyTotalLabel = new Label(composite, SWT.NONE);
 	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
     	currencyTotalLabel.setLayoutData(gridData);
     	currencyTotalLabel.setText(Messages.getString("ProjectEditForm.currencyTotalLabel.text")); //$NON-NLS-1$
    	
     	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
     	currencyTotalField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

     	
     	// HORIZONTAL SEPARATOR
    	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, COLUMN_COUNT, 1));
    	//--    	
    	
  	//--
    	taxLabel = new Label(composite, SWT.NONE);
    	taxLabel.setText(Messages.getString("ProjectEditForm.taxPercentLabel.text")); //$NON-NLS-1$

    	taxField = new XTaxCombo(composite, SWT.BORDER);;
    	taxField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	currencyTaxTotalLabel = new Label(composite, SWT.NONE);
 	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
    	currencyTaxTotalLabel.setLayoutData(gridData);
    	currencyTaxTotalLabel.setText(Messages.getString("ProjectEditForm.taxAmountLabel.text")); //$NON-NLS-1$

    	currencyTaxTotalField = new XCurrencyField(composite, SWT.BORDER);
    	currencyTaxTotalField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

   

     	currencyTotalWithTaxLabel = new Label(composite, SWT.NONE);
 	gridData = new GridData();
    	gridData.horizontalIndent = COLUMN_MARGIN;
     	currencyTotalWithTaxLabel.setLayoutData(gridData);
     	currencyTotalWithTaxLabel.setText(Messages.getString("ProjectEditForm.currencyTotalWithTaxLabel.text")); //$NON-NLS-1$
    	
     	currencyTotalWithTaxField = new XCurrencyField(composite, SWT.BORDER);
     	currencyTotalWithTaxField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, COLUMN_COUNT, 1));
    	//--
    	
    	
    	
    	
    	
    	
    	
    	

    	descriptionTabItem = new TabItem(tabFolder, SWT.NONE);
    	descriptionTabItem.setText(Messages.getString("ProjectEditForm.descriptionTabItem.text")); //$NON-NLS-1$

    	descriptionField = new XTextArea(tabFolder, SWT.MULTI);
    	descriptionField.setTextLimit(255);
    	descriptionField.setFixedHeight(100);
    	descriptionTabItem.setControl(descriptionField);
    	
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, Project.class);
    	FileView fileView = new FileView(itemsTabFolder, Project.class);
    	
    	this.setSize(new Point(590, 261));    	

    	registerEntityProvider(itemsTabFolder.getItem(0), new ProjectContactProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), new ProjectStageProvider());
    	registerEntityProvider(itemsTabFolder.getItem(2), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(3), fileView.getEntityProvider());
    	
    	initPartnerField(partnerField);
    	initContractField(contractDocumentField);
    	initResponsibleField(responsibleField);
    	
    	initCurrencyField(currencyField);
    	initCurrencyRateField(currencyRateField);
    	initCurrencyRateDateField(currencyRateDateField);
    	
    	
    	initCurrencyAmountField(currencyAmountField);
    	initDiscountPercentField(discountPercentField);
    	initCurrencyDiscountAmountField(currencyDiscountAmountField);
    	initTaxField(taxField);

    }
    
    private void createItemPanel() {
	 
        GridLayout gridLayout;
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 181;
        
        
        itemsPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        itemsPanel.setLayout(gridLayout);
        itemsPanel.setLayoutData(gridData);
        
        itemsTabFolder = new TabFolder(itemsPanel, SWT.NONE);
        itemsTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        TableColumn tableColumn = null;
        
        ////
        
        contactTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        contactTabItem.setText(Messages.getString("ProjectEditForm.contactTabItem.text")); //$NON-NLS-1$

         
        contactTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        contactTable.setHeaderVisible(true);
        contactTable.setLinesVisible(true);
        contactTabItem.setControl(contactTable);

        tableColumn = new TableColumn(contactTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn contactTableColumn = new TableColumn(contactTable, SWT.NONE);
        contactTableColumn.setWidth(300);
        contactTableColumn.setText(Messages.getString("ProjectEditForm.contactTableColumn.text")); //$NON-NLS-1$

        TableColumn contactRoleTableColumn = new TableColumn(contactTable, SWT.NONE);
        contactRoleTableColumn.setWidth(200);
        contactRoleTableColumn.setText(Messages.getString("ProjectEditForm.contactRoleTableColumn.text")); //$NON-NLS-1$

        ////
        
        stageTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        stageTabItem.setText(Messages.getString("ProjectEditForm.stageTabItem.text")); //$NON-NLS-1$

         
        stageTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        stageTable.setHeaderVisible(true);
        stageTable.setLinesVisible(true);
        stageTabItem.setControl(stageTable);

        tableColumn = new TableColumn(stageTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn stageNameTableColumn = new TableColumn(stageTable, SWT.NONE);
        stageNameTableColumn.setWidth(100);
        stageNameTableColumn.setText(Messages.getString("ProjectEditForm.projectStageNameTableColumn.text")); //$NON-NLS-1$

        TableColumn projectStageNameTableColumn = new TableColumn(stageTable, SWT.NONE);
        projectStageNameTableColumn.setWidth(200);
        projectStageNameTableColumn.setText(Messages.getString("ProjectEditForm.stageNameTableColumn.text")); //$NON-NLS-1$

        
        TableColumn stageStartDateTableColumn = new TableColumn(stageTable, SWT.NONE);
        stageStartDateTableColumn.setWidth(100);
        stageStartDateTableColumn.setText(Messages.getString("ProjectEditForm.stageStartDateTableColumn.text")); //$NON-NLS-1$

        TableColumn stageEndDateTableColumn = new TableColumn(stageTable, SWT.NONE);
        stageEndDateTableColumn.setWidth(100);
        stageEndDateTableColumn.setText(Messages.getString("ProjectEditForm.stageEndDateTableColumn.text")); //$NON-NLS-1$

        TableColumn stageActualStartDateTableColumn = new TableColumn(stageTable, SWT.NONE);
        stageActualStartDateTableColumn.setWidth(100);
        stageActualStartDateTableColumn.setText(Messages.getString("ProjectEditForm.stageActualStartDateTableColumn.text")); //$NON-NLS-1$

        TableColumn stageActualEndDateTableColumn = new TableColumn(stageTable, SWT.NONE);
        stageActualEndDateTableColumn.setWidth(100);
        stageActualEndDateTableColumn.setText(Messages.getString("ProjectEditForm.stageActualEndDateTableColumn.text")); //$NON-NLS-1$

    }

    protected class ProjectContactProvider extends TableEntityProvider {
	
	public ProjectContactProvider() {
	    setParentEntityClass(Project.class); // OWNER
	    setListProperty("projectContactLinks");
	    setAddMethod("addProjectContactLink");
	    
	    setEntityClass(ProjectContactLink.class); // FORM ID
	}
	
	protected Table getTable() {
	    return contactTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "contactName");
	    bindColumn(2, "projectRole");
	}
    }
    
    protected class ProjectStageProvider extends TableEntityProvider {
	
	public ProjectStageProvider() {
	    setParentEntityClass(Project.class); // OWNER
	    setListProperty("projectStageLinks");
	    setAddMethod("addProjectStageLink");
	    
	    setEntityClass(ProjectStageLink.class); // FORM ID
	}
	
	protected Table getTable() {
	    return stageTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "projectStageName");
	    bindColumn(2, "name");
	    bindColumn(3, "startDate", getDateFormat());
	    bindColumn(4, "endDate", getDateFormat());
	    bindColumn(5, "actualStartDate", getDateFormat());
	    bindColumn(6, "actualEndDate", getDateFormat());
	}
    }
    
    private Project getProject() {
	return (Project) getEntity();
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	
	getProject().setCurrency(ProjectEnvironment.getCurrency());
	getProject().setCurrencyRate(DEFAULT_CURRENCY_RATE);
	getProject().setCurrencyRateDate(EnterpriseEnvironment.getDate());

	getProject().setStartDate(EnterpriseEnvironment.getDate());
	getProject().setEndDate(EnterpriseEnvironment.getDate());

	getProject().setPartner(ProjectEnvironment.getPartner());
	getProject().setProjectType(ProjectEnvironment.getDefaultProjectType());
	getProject().setProjectStage(ProjectEnvironment.getProjectStage());
	getProject().setProjectStatus(ProjectEnvironment.getDefaultProjectStatus());
	getProject().setResponsible(getDefaultResponsible());
    }
    
    protected void bindControls() {
	bindControl(projectNoField, "projectNo");
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(projectTypeField, "projectType", projectTypeLabel, REQUIRED);	
	bindControl(contractDocumentField, "contractDocument");
	bindControl(responsibleField, "responsible", responsibleLabel, REQUIRED);	
	bindControl(partnerField, "partner");	
	bindControl(projectStatusField, "projectStatus", projectStatusLabel, REQUIRED);	
	bindControl(startDateField, "startDate");	
	bindControl(closeDateField, "endDate");	
	bindControl(actualEndDateField, "actualEndDate");
	bindControl(propabilityField, "propability");
	
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	bindControl(currencyRateDateField, "currencyRateDate");
	
	bindControl(currencyAmountField, "currencyAmount");
	
	bindControl(discountPercentField, "discountPercent");
	bindControl(currencyDiscountAmountField, "currencyDiscountAmount");
	bindControl(currencyTotalField, "currencyTotal");
	
	bindControl(taxField, "taxId");
	bindControl(currencyTaxTotalField, "currencyTaxTotal");	
	bindControl(currencyTotalWithTaxField, "currencyTotalWithTax");
	
	bindControl(descriptionField, "description");
    }

    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }

    protected void afterLoadData() {
	currencyTaxAmount = getProject().getCurrencyTaxAmount();
    }

    protected void afterUpdateData() throws ApplicationException {
	super.afterUpdateData();
	getProject().setCurrencyTaxAmount(currencyTaxAmount);
	calculate();
    }
    
    protected void calculate() {
	getProject().calculate();
    }
    
    ////
    
    protected void initCurrencyField(final XComboEdit currencyField) {
	financeDocumentHelper.initCurrencyField(currencyField);
    }

    protected void initCurrencyRateField(XNumberField currencyRateField) {
	financeDocumentHelper.initCurrencyRateField(currencyRateField);
    }

    
    protected void initCurrencyRateDateField(XDateCombo currencyRateDateField) {
	financeDocumentHelper.initCurrencyRateDateField(currencyRateDateField);
    }


    
    protected void initCurrencyAmountField(final XCurrencyField currencyAmountField) {
	if (currencyAmountField == null) {
	    return;
	}
	currencyAmountField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculateCurrencyDiscountAmount(); // 1.
		calculateCurrencyTotal();          // 2.
		calculateTaxAmountAndTotal();      // 3.
		currencyTotalWithTax();            // 4.
	    }
	});
    }

    
    protected void initDiscountPercentField(final XCurrencyField discountPercentField) {
	if (discountPercentField == null) {
	    return;
	}
	discountPercentField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculateCurrencyDiscountAmount(); // 1.
		calculateCurrencyTotal();          // 2.
		calculateTaxAmountAndTotal();      // 3.
		currencyTotalWithTax();            // 4.
	    }
	});
    }


    protected void initCurrencyDiscountAmountField(final XCurrencyField currencyDiscountAmountField) {
	if (currencyDiscountAmountField == null) {
	    return;
	}
	currencyDiscountAmountField.addFocusListener(new FocusAdapter() {
	    public void focusLost(FocusEvent e) {
		calculateCurrencyTotal();          // 2.
		calculateTaxAmountAndTotal();      // 3.
		currencyTotalWithTax();            // 4.
	    }
	});
    }

    
    protected void initTaxField(final XTaxCombo taxField) {
	if (taxField == null) {
	    return;
	}
	taxField.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		calculateTaxAmountAndTotal(); // 3.
		currencyTotalWithTax();       // 4.
	    }
	});
    }  

    
    
    
    //1.
    protected void calculateCurrencyDiscountAmount() {
	if (currencyDiscountAmountField == null) {
	    return;
	}
	double discountPercent = discountPercentField == null ? 0 : discountPercentField.doubleValue();
	double currencyAmount = currencyAmountField == null ? 0 : currencyAmountField.doubleValue();
	double currencyDiscountAmount = MoneyEnvironment.roundMoney(discountPercent * currencyAmount / 100);
	currencyDiscountAmountField.setValue(currencyDiscountAmount);
    }
    
    //2.
    protected void calculateCurrencyTotal() {
	if (currencyTotalField == null) {
	    return;
	}
	double currencyAmount = currencyAmountField == null ? 0 : currencyAmountField.doubleValue();
	double currencyDiscountAmount = currencyDiscountAmountField == null ? 0 : currencyDiscountAmountField.doubleValue();
	currencyTotalField.setValue(currencyAmount - currencyDiscountAmount);
    }


    //3.
    protected void calculateTaxAmountAndTotal() {
	if (currencyTaxTotalField == null) {
	    return;
	}	
	double taxPercent = taxField == null ?  0 : taxField.getTaxPercent();
	double currencyAmount = currencyAmountField == null ? 0 : currencyAmountField.doubleValue();
	double currencyTotal = currencyTotalField == null ? 0 : currencyTotalField.doubleValue();
	
	currencyTaxAmount = MoneyCalculator.calculateTaxAmount(taxPercent, currencyAmount, false);
	double currencyTaxTotal = MoneyCalculator.calculateTaxAmount(taxPercent, currencyTotal, false);
	
	currencyTaxTotalField.setValue(currencyTaxTotal);
    }

    //4.
    protected void currencyTotalWithTax() {
	if (currencyTotalWithTaxField == null) {
	    return;
	}	
	double currencyTotal = currencyTotalField == null ? 0 : currencyTotalField.doubleValue();
	double currencyTaxTotal = currencyTaxTotalField == null ? 0 : currencyTaxTotalField.doubleValue();
	currencyTotalWithTaxField.setValue(currencyTotal + currencyTaxTotal);
    }
    
    public double getAmountWithDiscount(double discount, double amount) {
	return MoneyEnvironment.roundMoney(discount * amount / 100);
    }


}  //  @jve:decl-index=0:visual-constraint="10,10"