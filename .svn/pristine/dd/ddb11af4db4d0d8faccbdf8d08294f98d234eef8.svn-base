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
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryMove;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryMoveItem;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/** 
 * @author Oleh Hapon
 * $Id: InventoryMoveEditForm.java,v 1.4 2010/04/28 06:31:08 ohapon Exp $
 */

public class InventoryMoveEditForm extends AbstractGoodsDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label outcomeWarehouseLabel;
    private Label outcomeMtrlResponsibleLabel;
    private Label incomeWarehouseLabel;
    private Label incomeMtrlResponsibleLabel;    
    private Label currencyAmountLabel;

    
    private XTextField codeField;
    private XDateCombo dateField;
    private XComboEdit outcomeWarehouseField;
    private XComboEdit outcomeMtrlResponsibleField;
    private XComboEdit incomeWarehouseField;
    private XComboEdit incomeMtrlResponsibleField;     
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
    public InventoryMoveEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("InventoryMoveEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("InventoryMoveEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("InventoryMoveEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 50;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("InventoryMoveEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	dateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	dateField.setLayoutData(gridData);
    	
    	//STRUTS
    	//final Label label = new Label(composite, SWT.NONE);
    	//gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	//label.setLayoutData(gridData);
    	
    	
       	outcomeWarehouseLabel = new Label(composite, SWT.NONE);
	outcomeWarehouseLabel.setText(Messages.getString("InventoryMoveEditForm.outcomeWarehouseLabel.text")); //$NON-NLS-1$

    	outcomeWarehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	outcomeWarehouseField.setLayoutData(gridData);

    	outcomeMtrlResponsibleLabel = new Label(composite, SWT.NONE);
	outcomeMtrlResponsibleLabel.setText(Messages.getString("InventoryMoveEditForm.outcomeMtrlResponsibleLabel.text")); //$NON-NLS-1$

    	outcomeMtrlResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	outcomeMtrlResponsibleField.setLayoutData(gridData);
    	
	//
 	incomeWarehouseLabel = new Label(composite, SWT.NONE);
 	incomeWarehouseLabel.setText(Messages.getString("InventoryMoveEditForm.incomeWarehouseLabel.text")); //$NON-NLS-1$

 	incomeWarehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	incomeWarehouseField.setLayoutData(gridData);

    	incomeMtrlResponsibleLabel = new Label(composite, SWT.NONE);
    	incomeMtrlResponsibleLabel.setText(Messages.getString("InventoryMoveEditForm.incomeMtrlResponsibleLabel.text")); //$NON-NLS-1$

    	incomeMtrlResponsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	incomeMtrlResponsibleField.setLayoutData(gridData);
    	    	
    	//
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("InventoryMoveEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
    	createSummaryPanel();
    	
    	this.setSize(new Point(600, 350));    	


    	initWarehouseField(outcomeWarehouseField);
    	initWarehouseField(incomeWarehouseField);
   	
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new ProductItemProvider());
    }
    
   
    protected void bindControls() {
	bindControl(codeField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(dateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(outcomeWarehouseField, "outcomeWarehouse", outcomeWarehouseLabel, REQUIRED);
	bindControl(outcomeMtrlResponsibleField, "outcomeMtrlResponsible");
	bindControl(incomeWarehouseField, "incomeWarehouse", incomeWarehouseLabel, REQUIRED);
	bindControl(incomeMtrlResponsibleField, "incomeMtrlResponsible");
	
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
        productTabItem.setText(Messages.getString("InventoryMoveEditForm.productTabItem.text")); //$NON-NLS-1$

         
        productTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productTable.setHeaderVisible(true);
        productTable.setLinesVisible(true);
        productTabItem.setControl(productTable);

   
        TableColumn tableColumn = new TableColumn(productTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(productTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("InventoryMoveEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(productTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("InventoryMoveEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("InventoryMoveEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(productTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("InventoryMoveEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyPriceColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("InventoryMoveEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("InventoryMoveEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
    
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
    	currencyAmountLabel.setText(Messages.getString("InventoryMoveEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

    	currencyAmountField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	
 	///---
    	initNoEditableField(currencyAmountField);
    	
    }
    
    
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemProvider() {
	    setParentEntityClass(InventoryMove.class); // OWNER
	    setEntityClass(InventoryMoveItem.class); // FORM ID
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
  

    
}  //  @jve:decl-index=0:visual-constraint="10,10"

