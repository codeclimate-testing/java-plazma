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
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarPaintEditForm.java,v 1.6 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarPaintEditForm extends AbstractGoodsEditForm {

//  ---------------------------------------------
    // Labels
    //---------------------------------------------

    private Label codeLabel;
    
    private Label barCodeLabel;    
    
    private Label nameLabel;
    
    private Label productGroupLabel;


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

    private Label manufacturerLabel;

    private Label supplierLabel;

    private Label minQuantityLabel;

    private Label availabilityQuantityLabel;

    private Label reserveQuantityLabel;

    private Label awaitQuantityLabel;
    
    private Label ledgerAccountLabel;
    
    ////
    

    private Label lengthLabel;

    private Label widthLabel;

    private Label heightLabel;
    
    private Label weightLabel;

    private Label warrantyPeriodLabel;
    
    
    
    //private Label carPaintTypeLabel;
    
    private Label carPaintMarkLabel;
    
    private Label consumableLabel;
    
    //---------------------------------------------
    // Fields
    //---------------------------------------------
    private XTextField codeField;
    
    private XTextField barCodeField;    
    
    private XTextField nameField;
    
    private XComboEdit productGroupField;
    
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

    
    private XComboEdit manufacturerField;
    
    private XComboEdit supplierField;
    
    private XCurrencyField minQuantityField;
    
    private XCurrencyField availabilityQuantityField;
    
    private XCurrencyField reserveQuantityField;
    
    private XCurrencyField awaitQuantityField;
    
    private XComboEdit ledgerAccountField;    
    
    private XTextArea noteField;

    
    ////
    
    private XNumberField lengthField;
    
    private XNumberField widthField;
    
    private XNumberField heightField;
    
    private XNumberField weightField;
    
    private XNumberField warrantyPeriodField;
    
    
    /////////////////////////////////////////////////////////////////
    
    //private XComboEdit carPaintTypeField;
    
    private XComboEdit carPaintMarkField;    
    
    private XCheckBox consumableField; 
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarPaintEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("CarPaintEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarPaintEditForm.generalTabItem.text")); //$NON-NLS-1$

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
    	codeLabel.setText(Messages.getString("CarPaintEditForm.codeLabel.text")); //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);
    	codeField.setTextLimit(20);

    	int HORIZAONTAL_INDENT = 30;    	
    	
    	barCodeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
  	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	barCodeLabel.setLayoutData(gridData);
    	barCodeLabel.setText(Messages.getString("CarPaintEditForm.barCodeLabel.text")); //$NON-NLS-1$

    	barCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	barCodeField.setLayoutData(gridData);
    	barCodeField.setTextLimit(20);

    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("CarPaintEditForm.nameLabel.text")); //$NON-NLS-1$

    	
    	nameField = new XTextField(composite, SWT.BORDER);
    	
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	
    	

    	productGroupLabel = new Label(composite, SWT.NONE);
	productGroupLabel.setText(Messages.getString("CarPaintEditForm.productGroupLabel.text")); //$NON-NLS-1$

    	productGroupField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	productGroupField.setLayoutData(gridData);

    	//oha: car-part: disable 
    	//unitLabel = new Label(composite, SWT.NONE);
    	//gridData = new GridData();
    	//gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	
    	//unitLabel.setLayoutData(gridData /*new GridData(125, SWT.DEFAULT)*/);
    	//unitLabel.setText(Messages.getString("CarPaintEditForm.unitLabel.text")); //$NON-NLS-1$

    	//unitField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	//gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	//gridData.widthHint = 100;
    	//unitField.setLayoutData(gridData);
    	//oha: car-part: disable
    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	//new Label(composite, SWT.NONE);

    	// PAINT TYPE
    	/*
    	carPaintTypeLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	carPaintTypeLabel.setLayoutData(gridData);
    	carPaintTypeLabel.setText(Messages.getString("CarPaintEditForm.typeLabel.text")); //$NON-NLS-1$

    	carPaintTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	carPaintTypeField.setLayoutData(gridData);
    	new Label(composite, SWT.NONE);
    	*/
    	
    	// PAINT MARK
    	//new Label(composite, SWT.NONE);
	carPaintMarkLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	//gridData.horizontalAlignment = SWT.RIGHT;
    	carPaintMarkLabel.setLayoutData(gridData);
	carPaintMarkLabel.setText(Messages.getString("CarPaintEditForm.markLabel.text")); //$NON-NLS-1$

	carPaintMarkField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	//gridData.horizontalIndent = HORIZAONTAL_INDENT;
	carPaintMarkField.setLayoutData(gridData);
	
	new Label(composite, SWT.NONE);
	
	
	
	consumableLabel = new Label(composite, SWT.NONE);
	consumableLabel.setText(Messages.getString("CarPaintEditForm.consumableLabel.text")); //$NON-NLS-1$

	consumableField = new XCheckBox(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
	consumableField.setLayoutData(gridData);
    	
	Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
    	
    	
	
    	////////////////////////////////////////////////////////////////////////////////////////////////

    	currencyLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarPaintEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarPaintEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);
    	
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(composite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	////
    	
	currencyCostPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyCostPriceLabel.setLayoutData(gridData);
    	currencyCostPriceLabel.setText(Messages.getString("CarPaintEditForm.currencyCostPriceLabel.text")); //$NON-NLS-1$

    	currencyCostPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyCostPriceField.setLayoutData(gridData);
    	
    	//
    	
    	costPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	costPriceLabel.setLayoutData(gridData);
    	costPriceLabel.setText(Messages.getString("CarPaintEditForm.costPriceLabel.text")); //$NON-NLS-1$

    	costPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	costPriceField.setLayoutData(gridData);
    	
    	
	////
    	
	currencyListPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyListPriceLabel.setLayoutData(gridData);
    	currencyListPriceLabel.setText(Messages.getString("CarPaintEditForm.currencyListPriceLabel.text")); //$NON-NLS-1$

    	currencyListPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyListPriceField.setLayoutData(gridData);
    	
    	//
    	
    	listPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	listPriceLabel.setLayoutData(gridData);
    	listPriceLabel.setText(Messages.getString("CarPaintEditForm.listPriceLabel.text")); //$NON-NLS-1$

    	listPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	listPriceField.setLayoutData(gridData);
    	

    	////

    	
    	// tax
	taxPercentLabel = new Label(composite, SWT.NONE);
	taxPercentLabel.setText(Messages.getString("CarPaintEditForm.taxPercentLabel.text")); //$NON-NLS-1$

    	taxPercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxPercentField.setLayoutData(gridData);

    	addPricePercentLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	addPricePercentLabel.setLayoutData(gridData);
    	addPricePercentLabel.setText(Messages.getString("CarPaintEditForm.addPricePercentLabel.text")); //$NON-NLS-1$

    	addPricePercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	addPricePercentField.setLayoutData(gridData);
    	
    	
    	TabItem additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	additionalTabItem.setText(Messages.getString("CarPaintEditForm.additionalTabItem.text")); //$NON-NLS-1$

    	Composite additionalComposite = new Composite(tabFolder, SWT.NONE);
    	GridLayout gridLayout_1 = new GridLayout();
 	gridLayout_1.marginBottom = 10;
	gridLayout_1.marginTop = 10;
	    	
    	gridLayout_1.numColumns = 4;
    	additionalComposite.setLayout(gridLayout_1);
    	additionalTabItem.setControl(additionalComposite);

    	manufacturerLabel = new Label(additionalComposite, SWT.NONE);
	manufacturerLabel.setText(Messages.getString("CarPaintEditForm.manufacturerLabel.text")); //$NON-NLS-1$

    	manufacturerField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	manufacturerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	supplierLabel = new Label(additionalComposite, SWT.NONE);
	supplierLabel.setText(Messages.getString("CarPaintEditForm.supplierLabel.text")); //$NON-NLS-1$

    	supplierField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	supplierField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	minQuantityLabel = new Label(additionalComposite, SWT.NONE);
	minQuantityLabel.setText(Messages.getString("CarPaintEditForm.minQuantityLabel.text")); //$NON-NLS-1$

    	minQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	minQuantityField.setLayoutData(gridData);

    	availabilityQuantityLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	availabilityQuantityLabel.setLayoutData(gridData);
    	availabilityQuantityLabel.setText(Messages.getString("CarPaintEditForm.availabilityQuantityLabel.text")); //$NON-NLS-1$

    	availabilityQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	availabilityQuantityField.setLayoutData(gridData);

    	reserveQuantityLabel = new Label(additionalComposite, SWT.NONE);
	reserveQuantityLabel.setText(Messages.getString("CarPaintEditForm.reserveQuantityLabel.text")); //$NON-NLS-1$

    	reserveQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	reserveQuantityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	awaitQuantityLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	awaitQuantityLabel.setLayoutData(gridData);
    	awaitQuantityLabel.setText(Messages.getString("CarPaintEditForm.awaitQuantityLabel.text")); //$NON-NLS-1$

    	awaitQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	awaitQuantityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	////
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	////
    	
    	lengthLabel = new Label(additionalComposite, SWT.NONE);
    	lengthLabel.setText(Messages.getString("CarPaintEditForm.lengthLabel.text")); //$NON-NLS-1$

    	lengthField = new XNumberField(additionalComposite, SWT.BORDER);
    	lengthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	weightLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	weightLabel.setLayoutData(gridData);
    	weightLabel.setText(Messages.getString("CarPaintEditForm.weightLabel.text")); //$NON-NLS-1$

    	weightField = new XNumberField(additionalComposite, SWT.BORDER);
    	weightField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	////
    	
    	widthLabel = new Label(additionalComposite, SWT.NONE);
    	widthLabel.setText(Messages.getString("CarPaintEditForm.widthLabel.text")); //$NON-NLS-1$

    	widthField = new XNumberField(additionalComposite, SWT.BORDER);
    	widthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	new Label(additionalComposite, SWT.NONE);
    	new Label(additionalComposite, SWT.NONE);
    	
    	////
    	
    	heightLabel = new Label(additionalComposite, SWT.NONE);
    	heightLabel.setText(Messages.getString("CarPaintEditForm.heightLabel.text")); //$NON-NLS-1$

    	heightField = new XNumberField(additionalComposite, SWT.BORDER);
    	heightField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	warrantyPeriodLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	warrantyPeriodLabel.setLayoutData(gridData);
    	warrantyPeriodLabel.setText(Messages.getString("CarPaintEditForm.warrantyPeriodLabel.text")); //$NON-NLS-1$

    	warrantyPeriodField = new XNumberField(additionalComposite, SWT.BORDER);
    	warrantyPeriodField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	////
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	
    	ledgerAccountLabel = new Label(additionalComposite, SWT.NONE);
	ledgerAccountLabel.setText(Messages.getString("CarPaintEditForm.ledgerAccountLabel.text")); //$NON-NLS-1$

    	ledgerAccountField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	ledgerAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarPaintEditForm.noteTabItem.text")); //$NON-NLS-1$

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
    	
    	
    	manufacturerField.setAssociationValueClass(Partner.class); // Set association value class because class of property is PartherHeader
    	supplierField.setAssociationValueClass(Partner.class); // Set association value class because class of property is PartherHeader
    	
    	
    	initCurrencyPriceField(currencyCostPriceField, costPriceField, currencyRateField);
    	initCurrencyPriceField(currencyListPriceField, listPriceField, currencyRateField);
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }
    
    @Override
    public void updateForm() throws ApplicationException {
        super.updateForm();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void bindControls() {
	bindControl(codeField, "code");
	bindControl(barCodeField, "barCode");
	
	bindControl(nameField, "name", nameLabel, REQUIRED);
	bindControl(productGroupField, "productGroup");
	
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

	bindControl(manufacturerField, "manufacturer");
	bindControl(supplierField, "supplier");
	bindControl(minQuantityField, "minQuantity");
	bindControl(availabilityQuantityField, "availabilityQuantity");
	bindControl(reserveQuantityField, "reserveQuantity");
	bindControl(awaitQuantityField, "awaitQuantity");
	
	bindControl(lengthField, "length");
	bindControl(widthField, "width");
	bindControl(heightField, "height");
	bindControl(weightField, "weight");
	bindControl(warrantyPeriodField, "warrantyPeriod");
	
	bindControl(ledgerAccountField, "ledgerAccount");
	    
	bindControl(noteField, "note");
	
	
	////////////////////////////////////////////
	
	
	//bindControl(carPaintTypeField, "carPaintType");
	bindControl(carPaintMarkField, "carPaintMark");
	bindControl(consumableField, "consumable");

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
        unitTabItem.setText(Messages.getString("CarPaintEditForm.unitTabItem.text")); //$NON-NLS-1$

         
        productUnitTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productUnitTable.setHeaderVisible(true);
        productUnitTable.setLinesVisible(true);
        unitTabItem.setControl(productUnitTable);

        TableColumn tableColumn = new TableColumn(productUnitTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn unitNameColumn = new TableColumn(productUnitTable, SWT.CENTER);
        unitNameColumn.setWidth(100);
        unitNameColumn.setText(Messages.getString("CarPaintEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productUnitTable, SWT.RIGHT);
        unitRateColumn.setWidth(100);
        unitRateColumn.setText(Messages.getString("CarPaintEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn barCodeColumn = new TableColumn(productUnitTable, SWT.NONE);
        barCodeColumn.setWidth(300);
        barCodeColumn.setText(Messages.getString("CarPaintEditForm.barCodeColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem priceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        priceTabItem.setText(Messages.getString("CarPaintEditForm.priceTabItem.text")); //$NON-NLS-1$

        productPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productPriceTable.setLinesVisible(true);
        productPriceTable.setHeaderVisible(true);
        priceTabItem.setControl(productPriceTable);

        tableColumn = new TableColumn(productPriceTable, SWT.NONE);
        tableColumn.setWidth(20);
        tableColumn.setResizable(false);

        TableColumn priceTypeColumn = new TableColumn(productPriceTable, SWT.NONE);
        priceTypeColumn.setWidth(100);
        priceTypeColumn.setText(Messages.getString("CarPaintEditForm.priceTypeColumn.text")); //$NON-NLS-1$

        TableColumn currencyColumn = new TableColumn(productPriceTable, SWT.CENTER);
        currencyColumn.setWidth(100);
        currencyColumn.setText(Messages.getString("CarPaintEditForm.currencyColumn.text")); //$NON-NLS-1$

        TableColumn unitColumn = new TableColumn(productPriceTable, SWT.CENTER);
        unitColumn.setWidth(100);
        unitColumn.setText(Messages.getString("CarPaintEditForm.unitColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn = new TableColumn(productPriceTable, SWT.RIGHT);
        priceColumn.setWidth(100);
        priceColumn.setText(Messages.getString("CarPaintEditForm.priceColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem instanceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        instanceTabItem.setText(Messages.getString("CarPaintEditForm.instanceTabItem.text")); //$NON-NLS-1$
        
        productInstanceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productInstanceTable.setLinesVisible(true);
        productInstanceTable.setHeaderVisible(true);
        instanceTabItem.setControl(productInstanceTable);

        TableColumn productInstanceColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceColumn.setWidth(20);
        productInstanceColumn.setResizable(false);

        TableColumn productInstanceSerialNumberColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceSerialNumberColumn.setWidth(100);
        productInstanceSerialNumberColumn.setText(Messages.getString("CarPaintEditForm.productInstanceSerialNumberColumn.text")); //$NON-NLS-1$

        TableColumn productInstanceNameColumn = new TableColumn(productInstanceTable, SWT.CENTER);
        productInstanceNameColumn.setWidth(200);
        productInstanceNameColumn.setText(Messages.getString("CarPaintEditForm.productInstanceNameColumn.text")); //$NON-NLS-1$
    }
    
    
    
    
    protected GoodsType getDefaultGoodsType() {
	GoodsType goodsType = new GoodsType();
	goodsType.setId(1);
	return goodsType;
    }
    
   

   


}