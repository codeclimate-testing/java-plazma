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
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReportItem;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReportPrice;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentItemEditForm;
import org.plazmaforge.bsolution.product.client.swt.forms.common.XProductUnitCombo;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/** 
 * @author Oleh Hapon
 * $Id: CarMtrlFindReportItemEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */

public class CarMtrlFindReportItemEditForm extends AbstractGoodsDocumentItemEditForm {

    private Label goodsLabel;
    private Label unitLabel;
    private Label unitRateLabel;
    private Label quantityLabel;
    private Label currencyPriceLabel;
    private Label currencyAmountLabel;
     
 
    private XComboEdit goodsField;
    private XProductUnitCombo unitField;
    private XCurrencyField unitRateField;
    private XCurrencyField quantityField;
    private XCurrencyField currencyPriceField;     
    private XCurrencyField currencyAmountField;
     
    ////
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    private Table priceListTable;


    public  CarMtrlFindReportItemEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {

	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	//setTitle(Messages.getString("CarMtrlFindReportEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	
	Composite topPanel = new Composite(this, SWT.NONE);
	topPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
	

	gridLayout = new GridLayout();
	gridLayout.numColumns = 4;
	topPanel.setLayout(gridLayout);	
	

    	goodsLabel = new Label(topPanel, SWT.NONE);
	goodsLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.goodsLabel.text")); //$NON-NLS-1$

    	goodsField = new XComboEdit(topPanel, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 300;
    	goodsField.setLayoutData(gridData);

    	Label label = new Label(topPanel, SWT.HORIZONTAL | SWT.SEPARATOR);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
   	
    	
    	
	unitLabel = new Label(topPanel, SWT.NONE);
    	unitLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.unitLabel.text")); //$NON-NLS-1$

    	unitField = new XProductUnitCombo(topPanel, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	unitField.setLayoutData(gridData);
    	
	unitRateLabel = new Label(topPanel, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 40;
	unitRateLabel.setLayoutData(gridData);
	unitRateLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.unitRateLabel.text")); //$NON-NLS-1$

    	unitRateField = new XCurrencyField(topPanel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	unitRateField.setLayoutData(gridData);

    	quantityLabel = new Label(topPanel, SWT.NONE);
	quantityLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.quantityLabel.text")); //$NON-NLS-1$

    	quantityField = new XCurrencyField(topPanel, SWT.BORDER); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	quantityField.setLayoutData(gridData);
    	
   	

    	currencyPriceLabel = new Label(topPanel, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 40;
    	currencyPriceLabel.setLayoutData(gridData);
	currencyPriceLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.currencyPriceLabel.text")); //$NON-NLS-1$

    	currencyPriceField = new XCurrencyField(topPanel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 100;
	currencyPriceField.setLayoutData(gridData);
	
	
	label = new Label(topPanel, SWT.NONE);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
	
	
 	currencyAmountLabel = new Label(topPanel, SWT.NONE);
 	gridData = new GridData();
 	gridData.horizontalIndent = 40;
 	currencyAmountLabel.setLayoutData(gridData);
	currencyAmountLabel.setText(Messages.getString("CarMtrlFindReportItemEditForm.currencyAmountLabel.text")); //$NON-NLS-1$

	currencyAmountField = new XCurrencyField(topPanel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyAmountField.setLayoutData(gridData);
    	
    	
    	////
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	//createSummaryPanel();
    	
    	/////
	    	
    	this.setSize(new Point(470, 108)); 
    	
    	// ITEM INIT
    	initGoodsField(goodsField);
    	initUnitField(unitField);
    	initUnitRateField(unitRateField);
    	initQuantityField(quantityField);
    	initCurrencyPriceField(currencyPriceField);
    	initCurrencyAmountField(currencyAmountField);
    
    	initNoEditableField(unitRateField);
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new PriceItemProvider());
    }
    
    protected void bindControls() {
	
	//addMapControl(goodsField, "product", goodsLabel, REQUIRED);
	
	bindControl(goodsField, "product");
	bindControl(unitField, "unit", unitLabel, REQUIRED);
	bindControl(unitRateField, "unitRate");
	bindControl(quantityField, "quantity");
	bindControl(currencyPriceField, "enterCurrencyPrice");
	bindControl(currencyAmountField, "enterCurrencyAmount");

    }    
    
    ////////////////////
    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
 
        GridLayout gridLayout;
        TabItem priceListTabItem;
        
          
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
        gridData.widthHint = 450;
        itemsTabFolder.setLayoutData(gridData);

        priceListTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        priceListTabItem.setText(Messages.getString("CarMtrlFindReportItemEditForm.priceListTabItem.text")); //$NON-NLS-1$

         
        priceListTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        priceListTable.setHeaderVisible(true);
        priceListTable.setLinesVisible(true);
        priceListTabItem.setControl(priceListTable);

   
        TableColumn tableColumn = new TableColumn(priceListTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn supplierColumn = new TableColumn(priceListTable, SWT.NONE);
        supplierColumn.setWidth(230);
        supplierColumn.setText(Messages.getString("CarMtrlFindReportItemEditForm.supplierColumn.text")); //$NON-NLS-1$

        TableColumn currencyPriceColumn = new TableColumn(priceListTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarMtrlFindReportItemEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn deliveryDateColumn = new TableColumn(priceListTable, SWT.RIGHT);
        deliveryDateColumn.setWidth(100);
        deliveryDateColumn.setText(Messages.getString("CarMtrlFindReportItemEditForm.deliveryDateColumn.text"));  //$NON-NLS-1$
        
     
    }
    
    /*
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
    	currencyTotalLabel.setText(Messages.getString("CarMtrlFindReportEditForm.currencyTotalLabel.text")); //$NON-NLS-1$

    	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalField.setLayoutData(gridData);
    	
    	initNoEditableField(currencyTotalField);
    }
    */
    
 
   
    protected class PriceItemProvider extends TableEntityProvider {
	
	public PriceItemProvider() {
	    setParentEntityClass(CarMtrlFindReportItem.class); // OWNER
	    setEntityClass(CarMtrlFindReportPrice.class); // FORM ID
	    setListProperty("priceList");
	    setAddMethod("addPrice", CarMtrlFindReportPrice.class);
	}
	
	protected Table getTable() {
	    return priceListTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "supplierName");
	    bindColumn(2, "price"); //bindColumn(2, "currencyPrice");
	    bindColumn(3, "deliveryDate", getDateFormat());
	}
    }
    
    
    
    
    protected Object getSelectedEntityProviderKey() {
	if (itemsTabFolder == null) {
	    return null;
	}
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    
/*    protected void updateAmountControls() {
	currencyTotalField.updateView();
    }
  
      

    protected XComboEdit getCurrencyField() {
	return this.currencyField;
    }    
*/  


}  //  @jve:decl-index=0:visual-constraint="25,19"

