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

package org.plazmaforge.bsolution.carservice.client.swt.forms;

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
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReport;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlPurchaseRequest;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlPurchaseRequestItem;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarMtrlPurchaseRequestEditForm.java,v 1.6 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarMtrlPurchaseRequestEditForm extends AbstractGoodsDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label carMtrlFindReportLabel;
    private Label currencyLabel;
    private Label currencyRateLabel;
    private Label currencyRateDateLabel;
    private Label currencyTotalLabel;
         
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit carMtrlFindReportField;
    private XComboEdit currencyField;
    private XNumberField currencyRateField;
    private XDateCombo currencyRateDateField;    
    private XCurrencyField currencyTotalField;
     
    
    private XTextArea noteField;
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    private Table productTable;
    

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarMtrlPurchaseRequestEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("CarMtrlPurchaseRequestEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 6;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	//STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	label.setLayoutData(gridData);
    	

	carMtrlFindReportLabel = new Label(composite, SWT.NONE);
	carMtrlFindReportLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.carMtrlFindReportLabel.text")); //$NON-NLS-1$

    	carMtrlFindReportField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	carMtrlFindReportField.setLayoutData(gridData);

    	
    	currencyLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateDateField.setLayoutData(gridData);

    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	createSummaryPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, CarMtrlPurchaseRequest.class);
    	
    	this.setSize(new Point(600, 350));    	

    	
    	initCarMtrlFindResul(carMtrlFindReportField);
    	
    	initCurrencyField(currencyField);
    	initCurrencyRateField(currencyRateField);
    	initCurrencyRateDateField(currencyRateDateField);
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new ProductItemProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), attributeView.getEntityProvider());
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(carMtrlFindReportField, "carMtrlFindReport");
	
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	bindControl(currencyRateDateField, "currencyRateDate");
	
	bindControl(currencyTotalField, "currencyTotal");

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
        productTabItem.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.productTabItem.text")); //$NON-NLS-1$

         
        productTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productTable.setHeaderVisible(true);
        productTable.setLinesVisible(true);
        productTabItem.setControl(productTable);

   
        TableColumn tableColumn = new TableColumn(productTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(productTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(productTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(productTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        
        TableColumn currencyPriceColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        
        TableColumn supplierColumn = new TableColumn(productTable, SWT.NONE);
        supplierColumn.setWidth(200);
        supplierColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.supplierColumn.text")); //$NON-NLS-1$
        
        TableColumn deliveryDateColumn = new TableColumn(productTable, SWT.NONE);
        deliveryDateColumn.setWidth(100);
        deliveryDateColumn.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.deliveryDateColumn.text"));   

     
    }
    
    
    private void createSummaryPanel() {
	Composite composite = new Composite(this, SWT.NONE);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.heightHint = 30;
	composite.setLayoutData(gridData);
    	GridLayout gridLayout = new GridLayout();
    	gridLayout.numColumns = 3;
    	composite.setLayout(gridLayout);
    	
    	// STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	label.setLayoutData(gridData);
    	
    	currencyTotalLabel = new Label(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	currencyTotalLabel.setLayoutData(gridData);
    	currencyTotalLabel.setText(Messages.getString("CarMtrlPurchaseRequestEditForm.currencyTotalLabel.text")); //$NON-NLS-1$

    	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalField.setLayoutData(gridData);
    	
    	initNoEditableField(currencyTotalField);
    }
    
 
    
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemProvider() {
	    setParentEntityClass(CarMtrlPurchaseRequest.class); // OWNER
	    setEntityClass(CarMtrlPurchaseRequestItem.class); // FORM ID
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
	    
	    bindColumn(7, "supplierName");
	    bindColumn(8, "deliveryDate", getDateFormat());
	    
	}
    }
    
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    protected void updateAmountControls() {
	currencyTotalField.updateView();
    }
  
      

    protected XComboEdit getCurrencyField() {
	return this.currencyField;
    }

    ///
    
    protected void initCarMtrlFindResul(XComboEdit field) {
	if (field == null) {
	    return;
	}
 	field.setDisplayValueProperty("shortTitle");
    	field.setAssociationValueClass(CarMtrlFindReport.class);
   }

}
