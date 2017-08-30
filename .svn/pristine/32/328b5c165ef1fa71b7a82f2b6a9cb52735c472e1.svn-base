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

package org.plazmaforge.bsolution.inventory.client.swt.forms;


import org.eclipse.swt.SWT;
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
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryIncome;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryIncomeItem;
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

/** 
 * @author Oleh Hapon
 * $Id: InventoryIncomeEditForm.java,v 1.7 2010/12/05 07:57:21 ohapon Exp $
 */

public class InventoryIncomeEditForm extends AbstractGoodsDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label partnerLabel;
    private Label warehouseLabel;
    private Label mtrlResponsibleLabel;
    private Label contractLabel;
    private Label reasonDocumentLabel;
    private Label reasonLabel;
    private Label currencyLabel;
    private Label currencyRateLabel;
    private Label currencyRateDateLabel;
    private Label currencyTotalLabel;
    private Label currencyTaxTotalLabel;
    private Label currencyTotalWithTaxLabel;

    
        
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit partnerField;
    private XComboEdit warehouseField;
    private XComboEdit mtrlResponsibleField; 
    private XComboEdit contractDocumentField;
    private XComboEdit reasonDocumentField;
    private XTextField reasonField; 
    private XComboEdit currencyField;
    private XNumberField currencyRateField;
    private XDateCombo currencyRateDateField;    
    private XCurrencyField currencyTotalField;
    private XCurrencyField currencyTaxTotalField;
    private XCurrencyField currencyTotalWithTaxField;
    
    private XTextArea noteField;
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    private Table productTable;
    

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public InventoryIncomeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	TabItem noteTabItem;
	Composite composite;
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("InventoryIncomeEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("InventoryIncomeEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 6;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("InventoryIncomeEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("InventoryIncomeEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	//STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	label.setLayoutData(gridData);
    	
    	
    	partnerLabel = new Label(composite, SWT.NONE);
    	partnerLabel.setLayoutData(new GridData());
    	partnerLabel.setText(Messages.getString("InventoryIncomeEditForm.partnerLabel.text")); //$NON-NLS-1$

    	partnerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	partnerField.setLayoutData(gridData);

    	warehouseLabel = new Label(composite, SWT.NONE);
	warehouseLabel.setText(Messages.getString("InventoryIncomeEditForm.warehouseLabel.text")); //$NON-NLS-1$

    	warehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	warehouseField.setLayoutData(gridData);

    	mtrlResponsibleLabel = new Label(composite, SWT.NONE);
	mtrlResponsibleLabel.setText(Messages.getString("InventoryIncomeEditForm.mtrlResponsibleLabel.text")); //$NON-NLS-1$

    	mtrlResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	mtrlResponsibleField.setLayoutData(gridData);
    	
	contractLabel = new Label(composite, SWT.NONE);
	contractLabel.setText(Messages.getString("InventoryIncomeEditForm.contractLabel.text")); //$NON-NLS-1$

    	contractDocumentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	contractDocumentField.setLayoutData(gridData);
    	
	reasonDocumentLabel = new Label(composite, SWT.NONE);
	reasonDocumentLabel.setText(Messages.getString("InventoryIncomeEditForm.reasonDocumentLabel.text")); //$NON-NLS-1$

	reasonDocumentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	reasonDocumentField.setLayoutData(gridData);

	reasonLabel = new Label(composite, SWT.NONE);
	reasonLabel.setText(Messages.getString("InventoryIncomeEditForm.reasonLabel.text")); //$NON-NLS-1$

	reasonField = new XTextField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	reasonField.setLayoutData(gridData);
    	reasonField.setTextLimit(64);
    	
    	currencyLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateDateField.setLayoutData(gridData);
    	

    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("InventoryIncomeEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	createSummaryPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, InventoryIncome.class);
    	
    	this.setSize(new Point(600, 350));    	

    	
    	initPartnerField(partnerField);
    	initWarehouseField(warehouseField);
    	initContractDocumentField(contractDocumentField);
    	initReasonDocumentField(reasonDocumentField);
    	
    	initCurrencyField(currencyField);
    	initCurrencyRateField(currencyRateField);
    	initCurrencyRateDateField(currencyRateDateField);
    	
    	
    	//initPriceTypeField(priceTypeField);
    	//initPricePercentField(pricePercentField);

    	registerEntityProvider(itemsTabFolder.getItem(0), new ProductItemProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), attributeView.getEntityProvider());
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(partnerField, "partner", partnerLabel, REQUIRED);
	bindControl(warehouseField, "warehouse", warehouseLabel, REQUIRED);
	bindControl(mtrlResponsibleField, "mtrlResponsible");
	bindControl(contractDocumentField, "contractDocument");
	bindControl(reasonDocumentField, "reasonDocument");
	bindControl(reasonField, "reason");
	
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	bindControl(currencyRateDateField, "currencyRateDate");
	
	bindControl(currencyTotalField, "currencyTotal");
	bindControl(currencyTaxTotalField, "currencyTaxTotal");
	bindControl(currencyTotalWithTaxField, "currencyTotalWithTax");
    
	bindControl(noteField, "note");
    }

    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
 
        GridLayout gridLayout;
        TabItem productTabItem;
        
          
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
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 600;
        itemsTabFolder.setLayoutData(gridData);

        productTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        productTabItem.setText(Messages.getString("InventoryIncomeEditForm.productTabItem.text")); //$NON-NLS-1$

         
        productTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productTable.setHeaderVisible(true);
        productTable.setLinesVisible(true);
        productTabItem.setControl(productTable);

   
        TableColumn tableColumn = new TableColumn(productTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(productTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("InventoryIncomeEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(productTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("InventoryIncomeEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("InventoryIncomeEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(productTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("InventoryIncomeEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyPriceColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("InventoryIncomeEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("InventoryIncomeEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("InventoryIncomeEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
        
    }
    
    
    private void createSummaryPanel() {
	Composite composite = new Composite(this, SWT.NONE);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.heightHint = 30;
	composite.setLayoutData(gridData);
    	GridLayout gridLayout = new GridLayout();
    	gridLayout.numColumns = 7;
    	composite.setLayout(gridLayout);
    	
    	// STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	label.setLayoutData(gridData);
    	
    	currencyTotalLabel = new Label(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	currencyTotalLabel.setLayoutData(gridData);
    	currencyTotalLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyTotalLabel.text")); //$NON-NLS-1$

    	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalField.setLayoutData(gridData);

    	currencyTaxTotalLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	currencyTaxTotalLabel.setLayoutData(gridData);
    	currencyTaxTotalLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyTaxTotalLabel.text")); //$NON-NLS-1$

    	currencyTaxTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxTotalField.setLayoutData(gridData);

    	currencyTotalWithTaxLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	currencyTotalWithTaxLabel.setLayoutData(gridData);
    	currencyTotalWithTaxLabel.setText(Messages.getString("InventoryIncomeEditForm.currencyTotalWithTaxLabel.text")); //$NON-NLS-1$

    	currencyTotalWithTaxField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalWithTaxField.setLayoutData(gridData);
    	
 	///---
    	initNoEditableField(currencyTotalField);
    	initNoEditableField(currencyTaxTotalField);
    	initNoEditableField(currencyTotalWithTaxField);
    }
    
    
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemProvider() {
	    setParentEntityClass(InventoryIncome.class); // OWNER
	    setEntityClass(InventoryIncomeItem.class); // FORM ID
	    initProductItemType(this);
	}
	
	protected Table getTable() {
	    return productTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    bindColumn(5, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(6, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(7, "currencyTaxAmount", getCurrencyFormat());
	}
    }
    
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    protected void updateAmountControls() {
	currencyTotalField.updateView();
	currencyTaxTotalField.updateView();
	currencyTotalWithTaxField.updateView();
    }
    
    private InventoryIncome getInventoryIncome() {
        return (InventoryIncome) getEntity();
    }

    protected void initData() throws ApplicationException {
        super.initData();
        getInventoryIncome().setPartner(EnterpriseEnvironment.getSupplier());
        getInventoryIncome().setWarehouse(EnterpriseEnvironment.getIncomeWharehouse());
        getInventoryIncome().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
    }  
  

    
}  //  @jve:decl-index=0:visual-constraint="10,10"


