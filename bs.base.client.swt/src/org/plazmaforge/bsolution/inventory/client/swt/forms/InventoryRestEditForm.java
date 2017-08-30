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
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryRest;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryRestItem;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: InventoryRestEditForm.java,v 1.5 2010/12/05 07:57:21 ohapon Exp $
 */

public class InventoryRestEditForm extends AbstractGoodsDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label warehouseLabel;
    private Label mtrlResponsibleLabel;
    private Label currencyAmountLabel;

    
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit warehouseField;
    private XComboEdit mtrlResponsibleField; 
    private XCurrencyField currencyAmountField;
    
    private XTextArea noteField;
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    private Table productTable;
    

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public InventoryRestEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("InventoryRestEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("InventoryRestEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("InventoryRestEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 50;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("InventoryRestEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	//STRUTS
    	//final Label label = new Label(composite, SWT.NONE);
    	//gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	//label.setLayoutData(gridData);
    	
    	
       	warehouseLabel = new Label(composite, SWT.NONE);
	warehouseLabel.setText(Messages.getString("InventoryRestEditForm.warehouseLabel.text")); //$NON-NLS-1$

    	warehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	warehouseField.setLayoutData(gridData);

    	mtrlResponsibleLabel = new Label(composite, SWT.NONE);
	mtrlResponsibleLabel.setText(Messages.getString("InventoryRestEditForm.mtrlResponsibleLabel.text")); //$NON-NLS-1$

    	mtrlResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	mtrlResponsibleField.setLayoutData(gridData);
    	
	    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("InventoryRestEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
    	createSummaryPanel();
    	
    	this.setSize(new Point(600, 350));    	


    	initWarehouseField(warehouseField);
   	
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new ProductItemProvider());
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(warehouseField, "warehouse", warehouseLabel, REQUIRED);
	bindControl(mtrlResponsibleField, "mtrlResponsible");
	
	bindControl(currencyAmountField, "currencyAmount");
   
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
        productTabItem.setText(Messages.getString("InventoryRestEditForm.productTabItem.text")); //$NON-NLS-1$

         
        productTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productTable.setHeaderVisible(true);
        productTable.setLinesVisible(true);
        productTabItem.setControl(productTable);

   
        TableColumn tableColumn = new TableColumn(productTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(productTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("InventoryRestEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(productTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("InventoryRestEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("InventoryRestEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(productTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("InventoryRestEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyPriceColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("InventoryRestEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("InventoryRestEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
    
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
    	
    	currencyAmountLabel = new Label(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	currencyAmountLabel.setLayoutData(gridData);
    	currencyAmountLabel.setText(Messages.getString("InventoryRestEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	
 	///---
    	initNoEditableField(currencyAmountField);

    }
    
    
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemProvider() {
	    setParentEntityClass(InventoryRest.class); // OWNER
	    setEntityClass(InventoryRestItem.class); // FORM ID
	    initProductItemType(this);
	}
	
	protected Table getTable() {
	    return productTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "productName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    bindColumn(5, "currencyPrice", getCurrencyFormat());
	    bindColumn(6, "currencyAmount", getCurrencyFormat());
	}
    }
    
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
    protected void updateAmountControls() {
	currencyAmountField.updateView();
    }

    private InventoryRest getInventoryRest() {
	return (InventoryRest) getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getInventoryRest().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
    }

    
}  //  @jve:decl-index=0:visual-constraint="10,10"

