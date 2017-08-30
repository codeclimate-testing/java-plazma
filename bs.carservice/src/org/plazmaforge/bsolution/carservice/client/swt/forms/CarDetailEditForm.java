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
import org.plazmaforge.bsolution.carservice.common.beans.CarDetail;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariant;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsEditForm;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarDetailEditForm.java,v 1.6 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarDetailEditForm extends AbstractGoodsEditForm {

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
    
    
    // oha:disable: customer requirement
    //private Label markLabel;
    //private Label modelLabel;
    
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
    
    
    private Table variantTable;
    
    /////////////////////////////////////////////////////////////////
    
    // oha:disable: customer requirement
    //private XComboEdit markField;
    //private XComboEdit modelField;    
    
    
    // oha:disable: customer requirement
    //private CarMarkAndModelProvider carMarkAndModelProvider = new CarMarkAndModelProvider();
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarDetailEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("CarDetailEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarDetailEditForm.generalTabItem.text")); //$NON-NLS-1$

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
    	codeLabel.setText(Messages.getString("CarDetailEditForm.codeLabel.text")); //$NON-NLS-1$

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
    	barCodeLabel.setText(Messages.getString("CarDetailEditForm.barCodeLabel.text")); //$NON-NLS-1$

    	barCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	barCodeField.setLayoutData(gridData);
    	barCodeField.setTextLimit(20);

    	
    	
    	nameLabel = new Label(composite, SWT.NONE);
    	nameLabel.setLayoutData(new GridData());
    	nameLabel.setText(Messages.getString("CarDetailEditForm.nameLabel.text")); //$NON-NLS-1$

    	
    	nameField = new XTextField(composite, SWT.BORDER);
    	
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	nameField.setLayoutData(gridData);
    	
    	

    	productGroupLabel = new Label(composite, SWT.NONE);
	productGroupLabel.setText(Messages.getString("CarDetailEditForm.productGroupLabel.text")); //$NON-NLS-1$

    	productGroupField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	productGroupField.setLayoutData(gridData);


    	//unitLabel = new Label(composite, SWT.NONE);
    	//gridData = new GridData();
    	//gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	
    	//unitLabel.setLayoutData(gridData /*new GridData(125, SWT.DEFAULT)*/);
    	//unitLabel.setText(Messages.getString("CarDetailEditForm.unitLabel.text")); //$NON-NLS-1$

    	//unitField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	//gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	//gridData.widthHint = 100;
    	//unitField.setLayoutData(gridData);
    	//oha: car-part: disable
    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	//new Label(composite, SWT.NONE);
    	
        // oha:disable: customer requirement
    	/*
    	markLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	markLabel.setLayoutData(gridData);
    	markLabel.setText(Messages.getString("CarDetailEditForm.markLabel.text")); //$NON-NLS-1$

    	markField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    	markField.setLayoutData(gridData);
    	new Label(composite, SWT.NONE);
    	
    	//new Label(composite, SWT.NONE);
	modelLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	modelLabel.setLayoutData(gridData);
	modelLabel.setText(Messages.getString("CarDetailEditForm.modelLabel.text")); //$NON-NLS-1$

	modelField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	modelField.setLayoutData(gridData);
	new Label(composite, SWT.NONE);
	*/
    	
	Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
    	label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
    	
    	
	
    	////////////////////////////////////////////////////////////////////////////////////////////////

    	currencyLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarDetailEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarDetailEditForm.currencyRateLabel.text")); //$NON-NLS-1$

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
    	currencyCostPriceLabel.setText(Messages.getString("CarDetailEditForm.currencyCostPriceLabel.text")); //$NON-NLS-1$

    	currencyCostPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyCostPriceField.setLayoutData(gridData);
    	
    	//
    	
    	costPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	costPriceLabel.setLayoutData(gridData);
    	costPriceLabel.setText(Messages.getString("CarDetailEditForm.costPriceLabel.text")); //$NON-NLS-1$

    	costPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	costPriceField.setLayoutData(gridData);
    	
   	
	////
    	
	currencyListPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	currencyListPriceLabel.setLayoutData(gridData);
    	currencyListPriceLabel.setText(Messages.getString("CarDetailEditForm.currencyListPriceLabel.text")); //$NON-NLS-1$

    	currencyListPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyListPriceField.setLayoutData(gridData);
    	
    	//
    	
    	listPriceLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	listPriceLabel.setLayoutData(gridData);
    	listPriceLabel.setText(Messages.getString("CarDetailEditForm.listPriceLabel.text")); //$NON-NLS-1$

    	listPriceField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	listPriceField.setLayoutData(gridData);
    	

    	// tax
	taxPercentLabel = new Label(composite, SWT.NONE);
	taxPercentLabel.setText(Messages.getString("CarDetailEditForm.taxPercentLabel.text")); //$NON-NLS-1$

    	taxPercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	taxPercentField.setLayoutData(gridData);

    	addPricePercentLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = HORIZAONTAL_INDENT;
    	addPricePercentLabel.setLayoutData(gridData);
    	addPricePercentLabel.setText(Messages.getString("CarDetailEditForm.addPricePercentLabel.text")); //$NON-NLS-1$

    	addPricePercentField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	addPricePercentField.setLayoutData(gridData);
    	
    	
    	TabItem additionalTabItem = new TabItem(tabFolder, SWT.NONE);
    	additionalTabItem.setText(Messages.getString("CarDetailEditForm.additionalTabItem.text")); //$NON-NLS-1$

    	Composite additionalComposite = new Composite(tabFolder, SWT.NONE);
    	GridLayout gridLayout_1 = new GridLayout();
 	gridLayout_1.marginBottom = 10;
	gridLayout_1.marginTop = 10;
	    	
    	gridLayout_1.numColumns = 4;
    	additionalComposite.setLayout(gridLayout_1);
    	additionalTabItem.setControl(additionalComposite);

    	manufacturerLabel = new Label(additionalComposite, SWT.NONE);
	manufacturerLabel.setText(Messages.getString("CarDetailEditForm.manufacturerLabel.text")); //$NON-NLS-1$

    	manufacturerField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	manufacturerField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	supplierLabel = new Label(additionalComposite, SWT.NONE);
	supplierLabel.setText(Messages.getString("CarDetailEditForm.supplierLabel.text")); //$NON-NLS-1$

    	supplierField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	supplierField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

    	minQuantityLabel = new Label(additionalComposite, SWT.NONE);
	minQuantityLabel.setText(Messages.getString("CarDetailEditForm.minQuantityLabel.text")); //$NON-NLS-1$

    	minQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	minQuantityField.setLayoutData(gridData);

    	availabilityQuantityLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	availabilityQuantityLabel.setLayoutData(gridData);
    	availabilityQuantityLabel.setText(Messages.getString("CarDetailEditForm.availabilityQuantityLabel.text")); //$NON-NLS-1$

    	availabilityQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	availabilityQuantityField.setLayoutData(gridData);

    	reserveQuantityLabel = new Label(additionalComposite, SWT.NONE);
	reserveQuantityLabel.setText(Messages.getString("CarDetailEditForm.reserveQuantityLabel.text")); //$NON-NLS-1$

    	reserveQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	reserveQuantityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	awaitQuantityLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	awaitQuantityLabel.setLayoutData(gridData);
    	awaitQuantityLabel.setText(Messages.getString("CarDetailEditForm.awaitQuantityLabel.text")); //$NON-NLS-1$

    	awaitQuantityField = new XCurrencyField(additionalComposite, SWT.BORDER);
    	awaitQuantityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	////
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	////
    	
    	lengthLabel = new Label(additionalComposite, SWT.NONE);
    	lengthLabel.setText(Messages.getString("CarDetailEditForm.lengthLabel.text")); //$NON-NLS-1$

    	lengthField = new XNumberField(additionalComposite, SWT.BORDER);
    	lengthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	weightLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	weightLabel.setLayoutData(gridData);
    	weightLabel.setText(Messages.getString("CarDetailEditForm.weightLabel.text")); //$NON-NLS-1$

    	weightField = new XNumberField(additionalComposite, SWT.BORDER);
    	weightField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	
    	////
    	
    	widthLabel = new Label(additionalComposite, SWT.NONE);
    	widthLabel.setText(Messages.getString("CarDetailEditForm.widthLabel.text")); //$NON-NLS-1$

    	widthField = new XNumberField(additionalComposite, SWT.BORDER);
    	widthField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	new Label(additionalComposite, SWT.NONE);
    	new Label(additionalComposite, SWT.NONE);
    	
    	////
    	
    	heightLabel = new Label(additionalComposite, SWT.NONE);
    	heightLabel.setText(Messages.getString("CarDetailEditForm.heightLabel.text")); //$NON-NLS-1$

    	heightField = new XNumberField(additionalComposite, SWT.BORDER);
    	heightField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	
    	warrantyPeriodLabel = new Label(additionalComposite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	warrantyPeriodLabel.setLayoutData(gridData);
    	warrantyPeriodLabel.setText(Messages.getString("CarDetailEditForm.warrantyPeriodLabel.text")); //$NON-NLS-1$

    	warrantyPeriodField = new XNumberField(additionalComposite, SWT.BORDER);
    	warrantyPeriodField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	////
    	
    	gridData = new GridData();
    	gridData.horizontalSpan = 4;
    	label = new Label(additionalComposite, SWT.NONE);
    	label.setLayoutData(gridData);
    	
    	
    	ledgerAccountLabel = new Label(additionalComposite, SWT.NONE);
	ledgerAccountLabel.setText(Messages.getString("CarDetailEditForm.ledgerAccountLabel.text")); //$NON-NLS-1$

    	ledgerAccountField = new XComboEdit(additionalComposite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	ledgerAccountField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
    	
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarDetailEditForm.noteTabItem.text")); //$NON-NLS-1$

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
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new VariantProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), attributeView.getEntityProvider());
    	registerEntityProvider(itemsTabFolder.getItem(2), fileView.getEntityProvider());
    	
    	
    	manufacturerField.setAssociationValueClass(Partner.class); // Set association value class because class of property is PartherHeader
    	supplierField.setAssociationValueClass(Partner.class); // Set association value class because class of property is PartherHeader
    	
    	initCurrencyPriceField(currencyCostPriceField, costPriceField, currencyRateField);
    	initCurrencyPriceField(currencyListPriceField, listPriceField, currencyRateField);
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
        // oha:disable: customer requirement
    	//carMarkAndModelProvider.setMarkField(markField);
    	//carMarkAndModelProvider.setModelField(modelField);
    	//carMarkAndModelProvider.init();
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }
    
    
    @Override
    public void updateForm() throws ApplicationException {
        super.updateForm();
        // oha:disable: customer requirement
        //carMarkAndModelProvider.refresh();
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
	
        // oha:disable: customer requirement
	//bindControl(markField, "carMark");
	//bindControl(modelField, "carModel");

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

        // VARIANT TABLE 
        createVariantItem();
        
        if (!isItemFolders) {
            return;
        }
        
        unitTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        unitTabItem.setText(Messages.getString("CarDetailEditForm.unitTabItem.text")); //$NON-NLS-1$

         
        productUnitTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productUnitTable.setHeaderVisible(true);
        productUnitTable.setLinesVisible(true);
        unitTabItem.setControl(productUnitTable);

        TableColumn tableColumn = new TableColumn(productUnitTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn unitNameColumn = new TableColumn(productUnitTable, SWT.CENTER);
        unitNameColumn.setWidth(100);
        unitNameColumn.setText(Messages.getString("CarDetailEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productUnitTable, SWT.RIGHT);
        unitRateColumn.setWidth(100);
        unitRateColumn.setText(Messages.getString("CarDetailEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn barCodeColumn = new TableColumn(productUnitTable, SWT.NONE);
        barCodeColumn.setWidth(300);
        barCodeColumn.setText(Messages.getString("CarDetailEditForm.barCodeColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem priceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        priceTabItem.setText(Messages.getString("CarDetailEditForm.priceTabItem.text")); //$NON-NLS-1$

        productPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productPriceTable.setLinesVisible(true);
        productPriceTable.setHeaderVisible(true);
        priceTabItem.setControl(productPriceTable);

        tableColumn = new TableColumn(productPriceTable, SWT.NONE);
        tableColumn.setWidth(20);
        tableColumn.setResizable(false);

        TableColumn priceTypeColumn = new TableColumn(productPriceTable, SWT.NONE);
        priceTypeColumn.setWidth(100);
        priceTypeColumn.setText(Messages.getString("CarDetailEditForm.priceTypeColumn.text")); //$NON-NLS-1$

        TableColumn currencyColumn = new TableColumn(productPriceTable, SWT.CENTER);
        currencyColumn.setWidth(100);
        currencyColumn.setText(Messages.getString("CarDetailEditForm.currencyColumn.text")); //$NON-NLS-1$

        TableColumn unitColumn = new TableColumn(productPriceTable, SWT.CENTER);
        unitColumn.setWidth(100);
        unitColumn.setText(Messages.getString("CarDetailEditForm.unitColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn = new TableColumn(productPriceTable, SWT.RIGHT);
        priceColumn.setWidth(100);
        priceColumn.setText(Messages.getString("CarDetailEditForm.priceColumn.text")); //$NON-NLS-1$

        ////
        
        TabItem instanceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        instanceTabItem.setText(Messages.getString("CarDetailEditForm.instanceTabItem.text")); //$NON-NLS-1$
        
        productInstanceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productInstanceTable.setLinesVisible(true);
        productInstanceTable.setHeaderVisible(true);
        instanceTabItem.setControl(productInstanceTable);

        TableColumn productInstanceColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceColumn.setWidth(20);
        productInstanceColumn.setResizable(false);

        TableColumn productInstanceSerialNumberColumn = new TableColumn(productInstanceTable, SWT.NONE);
        productInstanceSerialNumberColumn.setWidth(100);
        productInstanceSerialNumberColumn.setText(Messages.getString("CarDetailEditForm.productInstanceSerialNumberColumn.text")); //$NON-NLS-1$

        TableColumn productInstanceNameColumn = new TableColumn(productInstanceTable, SWT.CENTER);
        productInstanceNameColumn.setWidth(200);
        productInstanceNameColumn.setText(Messages.getString("CarDetailEditForm.productInstanceNameColumn.text")); //$NON-NLS-1$
    }
    
    private void createVariantItem() {
	
        TabItem variantTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        variantTabItem.setText(Messages.getString("CarDetailEditForm.variantTabItem.text")); //$NON-NLS-1$

        variantTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        variantTable.setLinesVisible(true);
        variantTable.setHeaderVisible(true);
        variantTabItem.setControl(variantTable);

        TableColumn tableColumn = new TableColumn(variantTable, SWT.NONE);
        tableColumn.setWidth(20);
        tableColumn.setResizable(false);


        TableColumn damageLevelReplaceColumn = new TableColumn(variantTable, SWT.CENTER);
        damageLevelReplaceColumn.setWidth(50);
        damageLevelReplaceColumn.setText(Messages.getString("CarDetailEditForm.damageLevelReplaceColumn.text")); //$NON-NLS-1$

        TableColumn damageLevel1Column = new TableColumn(variantTable, SWT.CENTER);
        damageLevel1Column.setWidth(50);
        damageLevel1Column.setText("1");

        TableColumn damageLevel2Column = new TableColumn(variantTable, SWT.CENTER);
        damageLevel2Column.setWidth(50);
        damageLevel2Column.setText("2");

        TableColumn damageLevel3Column = new TableColumn(variantTable, SWT.CENTER);
        damageLevel3Column.setWidth(50);
        damageLevel3Column.setText("3");
        

        //
        
        TableColumn serviceTypePNTColumn = new TableColumn(variantTable, SWT.CENTER);
        serviceTypePNTColumn.setWidth(50);
        serviceTypePNTColumn.setText(Messages.getString("CarDetailEditForm.serviceTypePNTColumn.text"));
        
        TableColumn serviceTypeMATColumn = new TableColumn(variantTable, SWT.CENTER);
        serviceTypeMATColumn.setWidth(50);
        serviceTypeMATColumn.setText(Messages.getString("CarDetailEditForm.serviceTypeMATColumn.text"));

        TableColumn serviceTypePOLColumn = new TableColumn(variantTable, SWT.CENTER);
        serviceTypePOLColumn.setWidth(50);
        serviceTypePOLColumn.setText(Messages.getString("CarDetailEditForm.serviceTypePOLColumn.text"));

        /////
        

    }
    
    
    

  protected class VariantProvider extends TableEntityProvider {

	public VariantProvider() {
	    setParentEntityClass(CarDetail.class); // OWNER
	    setListProperty("variantList");
	    setAddMethod("addVariant");

	    setEntityClass(CarDetailVariant.class); // FORM ID
	}

	protected Table getTable() {
	    return variantTable;
	}

	protected void bindTable() {
	   
	    bindColumn(1, "damageLevelReplace");
	    bindColumn(2, "damageLevel1");
	    bindColumn(3, "damageLevel2");
	    bindColumn(4, "damageLevel3");
	    
	    bindColumn(5, "pnt");
	    bindColumn(6, "mat");
	    bindColumn(7, "pol");	    
	}
    }    

    protected GoodsType getDefaultGoodsType() {
	GoodsType goodsType = new GoodsType();
	goodsType.setId(1);
	return goodsType;
    }
   

  


}
