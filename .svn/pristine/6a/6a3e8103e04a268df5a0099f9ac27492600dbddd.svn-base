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
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsEditForm;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServEditForm.java,v 1.5 2010/10/10 11:17:11 ohapon Exp $
 */
public class CarServEditForm extends AbstractGoodsEditForm {

//  ---------------------------------------------
    // Labels
    //---------------------------------------------

    private Label codeLabel;
    
    private Label barCodeLabel;    
    
    private Label nameLabel;
    
    private Label productGroupLabel;
    
    private Label carServTypeLabel;

    private Label currencyLabel;
    
    private Label currencyRateLabel;
    

    //oha: car-part: disable
    //private Label unitLabel;
    

    ////
    
    private Label costPriceLabel;
    
    private Label listPriceLabel;
    
    
    
    private Label currencyCostPriceLabel;
    
    private Label currencyListPriceLabel;
    
    ////
    
    
    private Label taxPercentLabel;

    private Label addPricePercentLabel;

    private Label ledgerAccountLabel;
    
    ////
    

   
    //---------------------------------------------
    // Fields
    //---------------------------------------------
    private XTextField codeField;
    
    private XTextField barCodeField;    
    
    private XTextField nameField;
    
    private XComboEdit productGroupField;
    
    private XComboEdit carServTypeField;
    
    private XComboEdit currencyField;
    
    private XNumberField currencyRateField;
    
    

    //oha: car-part: disable
    //private XComboEdit unitField;
    
    ////

    private XCurrencyField costPriceField;
    
    private XCurrencyField listPriceField;
    
    ////
    
    private XCurrencyField currencyCostPriceField;
    
    private XCurrencyField currencyListPriceField;
    
    ////
    
    

    private XCurrencyField taxPercentField;
    
    private XCurrencyField addPricePercentField;

    
    private XComboEdit ledgerAccountField;    
    
    private XTextArea noteField;

    
    ////
    
    private XNumberField lengthField;
    
    private XNumberField widthField;
    
    private XNumberField heightField;
    
    private XNumberField weightField;
    
    private XNumberField warrantyPeriodField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarServEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("CarServEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarServEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	 	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	codeLabel.setLayoutData(gridData);
    	codeLabel.setText(Messages.getString("CarServEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(20);

    	int HORIZAONTAL_INDENT = 70; //30;
    	
    	barCodeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
  	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	barCodeLabel.setLayoutData(gridData);
    	barCodeLabel.setText(Messages.getString("CarServEditForm.barCodeLabel.text")); //$NON-NLS-1$

    	barCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	barCodeField.setLayoutData(gridData);
    	barCodeField.setTextLimit(20);

    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("CarServEditForm.nameLabel.text")); //$NON-NLS-1$

    	
    	nameField = new XTextField(composite, SWT.BORDER);
    	
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	
    	

    	productGroupLabel = new Label(composite, SWT.NONE);
	productGroupLabel.setText(Messages.getString("CarServEditForm.productGroupLabel.text")); //$NON-NLS-1$

    	productGroupField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	productGroupField.setLayoutData(gridData);

    	//oha: car-part: disable 
    	//unitLabel = new Label(composite, SWT.NONE);
    	//gridData = new GridData();
    	//gridData.horizontalIndent = 70;
    	
    	//unitLabel.setLayoutData(gridData /*new GridData(125, SWT.DEFAULT)*/);
    	//unitLabel.setText(Messages.getString("CarServEditForm.unitLabel.text")); //$NON-NLS-1$

    	//unitField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	//gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	//gridData.widthHint = 100;
    	//unitField.setLayoutData(gridData);
    	//oha: car-part: disable
    	
    	carServTypeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	carServTypeLabel.setLayoutData(gridData);
    	carServTypeLabel.setText(Messages.getString("CarServEditForm.carServTypeLabel.text")); //$NON-NLS-1$

    	carServTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	carServTypeField.setLayoutData(gridData);
    	new Label(composite, SWT.NONE);

    	
    	currencyLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarServEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarServEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);
    	
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	Label label = new Label(composite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	////
    	
	currencyCostPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyCostPriceLabel.setLayoutData(gridData);
    	currencyCostPriceLabel.setText(Messages.getString("CarServEditForm.currencyCostPriceLabel.text")); //$NON-NLS-1$

    	currencyCostPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyCostPriceField.setLayoutData(gridData);
    	
    	//
    	
    	costPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	costPriceLabel.setLayoutData(gridData);
    	costPriceLabel.setText(Messages.getString("CarServEditForm.costPriceLabel.text")); //$NON-NLS-1$

    	costPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	costPriceField.setLayoutData(gridData);
    	
    	
	////
    	
	currencyListPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyListPriceLabel.setLayoutData(gridData);
    	currencyListPriceLabel.setText(Messages.getString("CarServEditForm.currencyListPriceLabel.text")); //$NON-NLS-1$

    	currencyListPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyListPriceField.setLayoutData(gridData);
    	
    	//
    	
    	listPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	listPriceLabel.setLayoutData(gridData);
    	listPriceLabel.setText(Messages.getString("CarServEditForm.listPriceLabel.text")); //$NON-NLS-1$

    	listPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	listPriceField.setLayoutData(gridData);
    	

    	////

    	
    	// tax
	taxPercentLabel = new Label(composite, SWT.NONE);
	taxPercentLabel.setText(Messages.getString("CarServEditForm.taxPercentLabel.text")); //$NON-NLS-1$

    	taxPercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxPercentField.setLayoutData(gridData);

    	addPricePercentLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 70;
    	addPricePercentLabel.setLayoutData(gridData);
    	addPricePercentLabel.setText(Messages.getString("CarServEditForm.addPricePercentLabel.text")); //$NON-NLS-1$

    	addPricePercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	addPricePercentField.setLayoutData(gridData);
    	
    	
    	TabItem additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	additionalTabItem.setText(Messages.getString("CarServEditForm.additionalTabItem.text")); //$NON-NLS-1$

    	Composite additionalComposite = new Composite(tabFolder, SWT.NONE);
    	GridLayout gridLayout_1 = new GridLayout();
 	gridLayout_1.marginBottom = 10;
	gridLayout_1.marginTop = 10;
	    	
    	gridLayout_1.numColumns = 4;
    	additionalComposite.setLayout(gridLayout_1);
    	additionalTabItem.setControl(additionalComposite);

    	////
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	
    	ledgerAccountLabel = new Label(additionalComposite, SWT.NONE);
	ledgerAccountLabel.setText(Messages.getString("CarServEditForm.ledgerAccountLabel.text")); //$NON-NLS-1$

    	ledgerAccountField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 300;
    	ledgerAccountField.setLayoutData(gridData);
    	
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarServEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
    	
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, Goods.class);
    	FileView fileView = new FileView(itemsTabFolder, Goods.class);
    	
    	this.setSize(new Point(600, 350));    	
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), fileView.getEntityProvider());
    	
    	
    	initCurrencyPriceField(currencyCostPriceField, costPriceField, currencyRateField);
    	initCurrencyPriceField(currencyListPriceField, listPriceField, currencyRateField);
    	
    }
    
   
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(barCodeField, "barCode");
	
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(productGroupField, "productGroup");
	bindControl(carServTypeField, "carServType");
	
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	
	//oha: car-part: disable
	//addMapControl(unitField, "unit", unitLabel, REQUIRED);
	
	bindControl(currencyCostPriceField, "currencyCostPrice");
	bindControl(currencyListPriceField, "currencyListPrice");
	bindControl(costPriceField, "costPrice");
	bindControl(listPriceField, "listPrice");
	
	bindControl(taxPercentField, "taxPercent");
	bindControl(addPricePercentField, "addPricePercent");	

	bindControl(lengthField, "length");
	bindControl(widthField, "width");
	bindControl(heightField, "height");
	bindControl(weightField, "weight");
	bindControl(warrantyPeriodField, "warrantyPeriod");
	
	bindControl(ledgerAccountField, "ledgerAccount");
	    
	bindControl(noteField, "note");
    }

    private boolean isItemFolders = false;
    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
 
        GridLayout gridLayout;
        TabItem unitTabItem;
        
          
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

        if (!isItemFolders) {
            return;
        }
        
        unitTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        unitTabItem.setText(Messages.getString("CarServEditForm.unitTabItem.text")); //$NON-NLS-1$

         
        productUnitTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productUnitTable.setHeaderVisible(true);
        productUnitTable.setLinesVisible(true);
        unitTabItem.setControl(productUnitTable);

        TableColumn tableColumn = new TableColumn(productUnitTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn unitNameColumn = new TableColumn(productUnitTable, SWT.CENTER);
        unitNameColumn.setWidth(100);
        unitNameColumn.setText(Messages.getString("CarServEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productUnitTable, SWT.RIGHT);
        unitRateColumn.setWidth(100);
        unitRateColumn.setText(Messages.getString("CarServEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn barCodeColumn = new TableColumn(productUnitTable, SWT.NONE);
        barCodeColumn.setWidth(300);
        barCodeColumn.setText(Messages.getString("CarServEditForm.barCodeColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem priceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        priceTabItem.setText(Messages.getString("CarServEditForm.priceTabItem.text")); //$NON-NLS-1$

        productPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productPriceTable.setLinesVisible(true);
        productPriceTable.setHeaderVisible(true);
        priceTabItem.setControl(productPriceTable);

        tableColumn = new TableColumn(productPriceTable, SWT.NONE);
        tableColumn.setWidth(20);
        tableColumn.setResizable(false);

        TableColumn priceTypeColumn = new TableColumn(productPriceTable, SWT.NONE);
        priceTypeColumn.setWidth(100);
        priceTypeColumn.setText(Messages.getString("CarServEditForm.priceTypeColumn.text")); //$NON-NLS-1$

        TableColumn currencyColumn = new TableColumn(productPriceTable, SWT.CENTER);
        currencyColumn.setWidth(100);
        currencyColumn.setText(Messages.getString("CarServEditForm.currencyColumn.text")); //$NON-NLS-1$

        TableColumn unitColumn = new TableColumn(productPriceTable, SWT.CENTER);
        unitColumn.setWidth(100);
        unitColumn.setText(Messages.getString("CarServEditForm.unitColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn = new TableColumn(productPriceTable, SWT.RIGHT);
        priceColumn.setWidth(100);
        priceColumn.setText(Messages.getString("CarServEditForm.priceColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem instanceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        instanceTabItem.setText(Messages.getString("CarServEditForm.instanceTabItem.text")); //$NON-NLS-1$
        
        productInstanceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productInstanceTable.setLinesVisible(true);
        productInstanceTable.setHeaderVisible(true);
        instanceTabItem.setControl(productInstanceTable);

        TableColumn productInstanceColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceColumn.setWidth(20);
        productInstanceColumn.setResizable(false);

        TableColumn productInstanceSerialNumberColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceSerialNumberColumn.setWidth(100);
        productInstanceSerialNumberColumn.setText(Messages.getString("CarServEditForm.productInstanceSerialNumberColumn.text")); //$NON-NLS-1$

        TableColumn productInstanceNameColumn = new TableColumn(productInstanceTable, SWT.CENTER);
        productInstanceNameColumn.setWidth(200);
        productInstanceNameColumn.setText(Messages.getString("CarServEditForm.productInstanceNameColumn.text")); //$NON-NLS-1$
    }
    
    
    protected GoodsType getDefaultGoodsType() {
	GoodsType goodsType = new GoodsType();
	goodsType.setId(2); // SERVICE;
	return goodsType;
    }

    

    
   
    
}
