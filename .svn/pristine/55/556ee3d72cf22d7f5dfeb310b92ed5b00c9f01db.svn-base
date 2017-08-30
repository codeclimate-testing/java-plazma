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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.carservice.common.beans.Car;
import org.plazmaforge.bsolution.carservice.common.beans.CarClass;
import org.plazmaforge.bsolution.carservice.common.beans.CarDamageLevel;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetail;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariant;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantPaint;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantPart;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantServ;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerConsumablesPrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerContractVariant;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPaintTypeVolume;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaint;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintDetailType;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintMark;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintType;
import org.plazmaforge.bsolution.carservice.common.beans.CarPart;
import org.plazmaforge.bsolution.carservice.common.beans.CarServ;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrder;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderDamage;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderImage;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderInventory;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderItem;
import org.plazmaforge.bsolution.carservice.common.services.CarClassService;
import org.plazmaforge.bsolution.carservice.common.services.CarDetailService;
import org.plazmaforge.bsolution.carservice.common.services.CarInsurerContractVariantService;
import org.plazmaforge.bsolution.carservice.common.services.CarPaintTypeService;
import org.plazmaforge.bsolution.carservice.common.services.CarServOrderService;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerEditForm;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerListForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.partner.common.beans.PartnerRepresentative;
import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormInitializer;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.forms.IListFormInitializer;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XPercentField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ImageTablePanel;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;
import org.plazmaforge.framework.ext.model.ImageStorage;
import org.plazmaforge.framework.util.MoneyEnvironment;
/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderEditForm.java,v 1.11 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderEditForm extends AbstractGoodsDocumentEditForm {


    private final static String REPAIR_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.repairItem.text");
    private final static String ADDITIONAL_REPAIR_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.additionalRepairItem.text");
    private final static String DAMAGE_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.damageItem.text");
    private final static String INVENTORY_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.inventoryItem.text");
    private final static String TOTAL_INVENTORY_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.totalInventoryItem.text");
    private final static String INVOICE_FOLDER_TEXT = Messages.getString("CarServOrderEditForm.invoiceItem.text");
    
    
    
    // MESSAGE CONSTANTS
    private final static String ADD_TOTAL_ROWS_MESSAGE = Messages.getString("CarServOrderEditForm.addTotalRows.message");
    private final static String REMOVE_TOTAL_ROWS_MESSAGE = Messages.getString("CarServOrderEditForm.removeTotalRows.message");
    private final static String CONFIRM_ADD_TOTAL_ROWS_MESSAGE = Messages.getString("CarServOrderEditForm.confirmAddTotalRows.message");
    private final static String CONFIRM_REMOVE_TOTAL_ROWS_MESSAGE = Messages.getString("CarServOrderEditForm.confirmRemoveTotalRows.message");
    
    private final static String CONFIRM_REMOVE_DAMAGE_MESSAGE = Messages.getString("CarServOrderEditForm.confirmRemoveDamage.message");
    private final static String CONFIRM_REMOVE_INVENTORY_MESSAGE = Messages.getString("CarServOrderEditForm.confirmRemoveInventory.message");
    private final static String DAMAGE_NOT_SELECTED_MESSAGE = Messages.getString("CarServOrderEditForm.damageNotSelected.message");
    private final static String INVENTORY_NOT_SELECTED_MESSAGE = Messages.getString("CarServOrderEditForm.inventoryNotSelected.message");
    
    private final static String CANT_REMOVE_DAMAGE_MESSAGE = Messages.getString("CarServOrderEditForm.cantRemoveDamage.message");
    private final static String CANT_REMOVE_INVENTORY_MESSAGE = Messages.getString("CarServOrderEditForm.cantRemoveInventory.message");

    private final static String MAX_DAMAGE_COUNT_MESSAGE = Messages.getString("CarServOrderEditForm.maxDamageCount.message");
    private final static String MAX_INVENTORY_COUNT_MESSAGE = Messages.getString("CarServOrderEditForm.maxInventoryCount.message");
    

    
    
    private final static String ADD_DAMAGE = "ADD_DAMAGE";
    private final static String REMOVE_DAMAGE = "REMOVE_DAMAGE";
    private final static String ADD_INVENTORY = "ADD_INVENTORY";
    private final static String REMOVE_INVENTORY = "REMOVE_INVENTORY";
    
    private final static int MAX_DAMAGE_COUNT = 20;
    private final static int MAX_INVENTORY_COUNT = 20;

    private final static int LABEL_WIDTH = 100;
    private final static int FIELD_WIDTH = 100;
    private final static int BIG_FIELD_WIDTH = 130;
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    // DAMAGE
    
    private static String DAMAGE_CODE_FIELD = "damageCodeField";
    
    private static String INSURER_FIELD = "insurerField";
    
    private static String BROKER_FIELD = "brokerField";
    
    private static String CAR_CLASS_FIELD = "carClassField";
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label currencyLabel;
    private Label currencyRateLabel;
    private Label currencyRateDateLabel;
    private Label currencyTotalLabel;
    private Label currencyTaxTotalLabel;
    private Label currencyTotalWithTaxLabel;
    private Label priceTypeLabel;
    private Label pricePercentLabel;
    
    private Label carLabel;
    private Label carRegNumberLabel;
    private Label carChassisNumberLabel;
    private Label carManufactureYearLabel;
    private Label carOwnerNameLabel; // Owner (Partner)
    
    private Label carIncomeDateLabel;
    private Label carOutcomeDateLabel;
    
    
    private Label incomeRepresentativeLabel;
    private Label incomeRepresentativePhoneLabel;
    
    private Label outcomeRepresentativeLabel;
    private Label outcomeRepresentativePhoneLabel;    
    
    
        
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit warehouseField;
    private XComboEdit responsibleField; 
    private XComboEdit contractDocumentField;
    private XComboEdit reasonDocumentField;
    private XComboEdit currencyField;
    private XNumberField currencyRateField;
    private XDateCombo currencyRateDateField;    
    private XCurrencyField currencyTotalField;
    private XCurrencyField currencyTaxTotalField;
    private XCurrencyField currencyTotalWithTaxField;
    private XComboEdit priceTypeField;
    private XPercentField pricePercentField;
    
    
    private XComboEdit carField;
    private XTextField carRegNumberField;
    private XTextField carChassisNumberField;
    private XIntegerField carManufactureYearField;
    private XTextField carOwnerNameField; // Owner (partner)
    
    private XDateCombo carIncomeDateField;
    private XDateCombo carOutcomeDateField;

    
    private XComboEdit incomeRepresentativeField;
    private XTextField incomeRepresentativePhoneField;
    
    private XComboEdit outcomeRepresentativeField;
    private XTextField outcomeRepresentativePhoneField;    

    
    
    private XTextArea noteField;
    
    private boolean isSimpleMode = false;
    
    /** General top tab folder. We use the tab folder when mode is complex (damages and inventories) **/ 
    private TabFolder topTabFolder;
    
    /** The virtual root damage type. Children of the root are damage types of service order **/
    private PanelType rootDamageType;
    

    private IPartnerTitle partner;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarServOrderEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	
	
	TabItem generalTabItem;
	TabItem currencyTabItem;
	TabItem incomeTabItem;
	TabItem outcomeTabItem;
	TabItem noteTabItem;
	
	
	Composite composite;
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("CarServOrderEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	//gd.widthHint = 500; // WARNING GENERAL WORF WIDTH
    	tabFolder.setLayoutData(gd);

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarServOrderEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 6;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("CarServOrderEditForm.documentNoLabel.text")); //$NON-NLS-1$
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = LABEL_WIDTH;
    	documentNoLabel.setLayoutData(gridData);

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = FIELD_WIDTH;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	//gridData = new GridData();
    	//gridData.horizontalIndent = 10;
    	
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("CarServOrderEditForm.documentDateLabel.text")); //$NON-NLS-1$
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	gridData.horizontalIndent = 10;
    	gridData.widthHint = LABEL_WIDTH;
    	documentDateLabel.setLayoutData(gridData);

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	documentDateField.setLayoutData(gridData);
    	
    	//STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	label.setLayoutData(gridData);
    	
    	
    	//// CAR SERVICE BLOCK: BEGIN
    	
    	carLabel = new Label(composite, SWT.NONE);
    	carLabel.setLayoutData(new GridData());
    	carLabel.setText(Messages.getString("CarServOrderEditForm.carLabel.text")); //$NON-NLS-1$

    	carField = new XComboEdit(composite, SWT.BORDER, PWT.ADD_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	carField.setLayoutData(gridData);
    	
    	
    	//// =======================================================================    	
    	//// CAR SUB BLOCK: BEGIN
    	//// =======================================================================
    	
    	carRegNumberLabel = new Label(composite, SWT.NONE);
    	carRegNumberLabel.setText(Messages.getString("CarServOrderEditForm.carRegNumberLabel.text")); //$NON-NLS-1$

    	carRegNumberField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = BIG_FIELD_WIDTH;
    	carRegNumberField.setLayoutData(gridData);
    	
    	
    	carChassisNumberLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	carChassisNumberLabel.setLayoutData(gridData);
    	carChassisNumberLabel.setText(Messages.getString("CarServOrderEditForm.carChassisNumberLabel.text")); //$NON-NLS-1$

    	carChassisNumberField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = BIG_FIELD_WIDTH;
    	carChassisNumberField.setLayoutData(gridData);
    	

    	carManufactureYearLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	carManufactureYearLabel.setLayoutData(gridData);
    	carManufactureYearLabel.setText(Messages.getString("CarServOrderEditForm.carManufactureYearLabel.text")); //$NON-NLS-1$

    	carManufactureYearField = new XIntegerField(composite, SWT.BORDER);
    	carManufactureYearField.setPattern("###0");
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	carManufactureYearField.setLayoutData(gridData);
    	
    	////
    	
    	carOwnerNameLabel = new Label(composite, SWT.NONE);
    	carOwnerNameLabel.setLayoutData(new GridData());
    	carOwnerNameLabel.setText(Messages.getString("CarServOrderEditForm.carOwnerNameLabel.text")); //$NON-NLS-1$

    	carOwnerNameField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	carOwnerNameField.setLayoutData(gridData);

    	//// =======================================================================    	
    	//// CAR SUB BLOCK: END
    	//// =======================================================================
    	
    	
    	
    	
    	carIncomeDateLabel = new Label(composite, SWT.NONE);
    	carIncomeDateLabel.setText(Messages.getString("CarServOrderEditForm.carIncomeDateLabel.text")); //$NON-NLS-1$

    	carIncomeDateField = new XDateCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	carIncomeDateField.setLayoutData(gridData);
    	carIncomeDateField.setTextLimit(20);

    	carOutcomeDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	carOutcomeDateLabel.setLayoutData(gridData);
    	carOutcomeDateLabel.setText(Messages.getString("CarServOrderEditForm.carOutcomeDateLabel.text")); //$NON-NLS-1$

    	carOutcomeDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	carOutcomeDateField.setLayoutData(gridData);
    	
    	new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
    	
    	
    	Label separator = new Label(composite, SWT.HORIZONTAL);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1);
    	separator.setLayoutData(gridData);
    	
   	
    	//// CAR SERVICE BLOCK: END

    	
    	
    	// oha: disable: customer requirements 2008-07-07
    	
    	/*
    	warehouseLabel = new Label(composite, SWT.NONE);
	warehouseLabel.setText(Messages.getString("CarServOrderEditForm.warehouseLabel.text")); //$NON-NLS-1$

    	warehouseField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	warehouseField.setLayoutData(gridData);

    	responsibleLabel = new Label(composite, SWT.NONE);
	responsibleLabel.setText(Messages.getString("CarServOrderEditForm.responsibleLabel.text")); //$NON-NLS-1$

    	responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	responsibleField.setLayoutData(gridData);
    	
	contractLabel = new Label(composite, SWT.NONE);
	contractLabel.setText(Messages.getString("CarServOrderEditForm.contractLabel.text")); //$NON-NLS-1$

    	contractDocumentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	contractDocumentField.setLayoutData(gridData);
    	*/
    	
    	
    	
    	/*
	reasonDocumentLabel = new Label(composite, SWT.NONE);
	reasonDocumentLabel.setText(Messages.getString("CarServOrderEditForm.reasonDocumentLabel.text")); //$NON-NLS-1$

	reasonDocumentField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	reasonDocumentField.setLayoutData(gridData);

	reasonLabel = new Label(composite, SWT.NONE);
	reasonLabel.setText(Messages.getString("CarServOrderEditForm.reasonLabel.text")); //$NON-NLS-1$

	reasonField = new XTextField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	reasonField.setLayoutData(gridData);
    	reasonField.setTextLimit(64);
    	*/
    	
    	
    	
    	
    	
    	
    	// oha: disable: customer requirements 2008-07-07
    	/*
    	currencyLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarServOrderEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarServOrderEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("CarServOrderEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateDateField.setLayoutData(gridData);
    	*/
    	
    	
    	
    	
    	
    	

    	////
    	priceTypeLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	priceTypeLabel.setLayoutData(gridData);
	priceTypeLabel.setText(Messages.getString("CarServOrderEditForm.priceTypeLabel.text")); //$NON-NLS-1$

	priceTypeField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
	priceTypeField.setLayoutData(new GridData(100 /*120*/, SWT.DEFAULT)); //oha: width = 100: 2008-07-07

	pricePercentLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	pricePercentLabel.setLayoutData(gridData);
    	pricePercentLabel.setText(Messages.getString("CarServOrderEditForm.pricePercentLabel.text")); //$NON-NLS-1$

    	pricePercentField = new XPercentField(composite, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	pricePercentField.setLayoutData(gridData);
    	

    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	//
    	// INCOME TAB ITEM
    	//
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	incomeTabItem = new TabItem(tabFolder, SWT.NONE);
    	incomeTabItem.setText(Messages.getString("CarServOrderEditForm.incomeTabItem.text")); //$NON-NLS-1$
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	incomeTabItem.setControl(composite);

        incomeRepresentativeLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	incomeRepresentativeLabel.setLayoutData(gridData);
	incomeRepresentativeLabel.setText(Messages.getString("CarServOrderEditForm.representativeLabel.text")); //$NON-NLS-1$

	incomeRepresentativeField = new XComboEdit(composite, SWT.BORDER, PWT.ADD_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	incomeRepresentativeField.setLayoutData(new GridData(300, SWT.DEFAULT));


        incomeRepresentativePhoneLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 10;
	incomeRepresentativePhoneLabel.setLayoutData(gridData);
	incomeRepresentativePhoneLabel.setText(Messages.getString("CarServOrderEditForm.representativePhoneLabel.text")); //$NON-NLS-1$

	incomeRepresentativePhoneField = new XTextField(composite, SWT.BORDER);
	incomeRepresentativePhoneField.setLayoutData(new GridData(150, SWT.DEFAULT));
	initNoEditableField(incomeRepresentativePhoneField);

	incomeRepresentativeField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateRepresentative(incomeRepresentativeField, incomeRepresentativePhoneField);
    	    }
    	});

	incomeRepresentativeField.setListFormInitializer(new IListFormInitializer() {
    	    public void initListForm(IListForm editForm) {
    		if (editForm == null) {
    		    return;
    		}
    		editForm.setParentEntity(getPartner());
    		editForm.setSupportParentEntity(true);
    	    }
    	});

	incomeRepresentativeField.setEditFormInitializer(new IEditFormInitializer() {
    	    public void initEditForm(IEditForm editForm) {
    		if (editForm == null || !editForm.isAddMode()) {
    		    return;
    		}
    		// Reset child mode because this form by default has child mode = true
    		editForm.setChildFormMode(false);
    		editForm.setParentEntity(getPartner());
    		editForm.setSupportParentEntity(true);
    	    }
    	});

	gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
	
	incomeImagePanel = new ImageTablePanel(composite, Messages.getString("CarServOrderEditForm.photos"));
	incomeImagePanel.setLayoutData(gridData);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	//
    	// OUTCOME TAB ITEM
    	//
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
	outcomeTabItem = new TabItem(tabFolder, SWT.NONE);
	outcomeTabItem.setText(Messages.getString("CarServOrderEditForm.outcomeTabItem.text")); //$NON-NLS-1$
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	outcomeTabItem.setControl(composite);

        outcomeRepresentativeLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	outcomeRepresentativeLabel.setLayoutData(gridData);
	outcomeRepresentativeLabel.setText(Messages.getString("CarServOrderEditForm.representativeLabel.text")); //$NON-NLS-1$

	outcomeRepresentativeField = new XComboEdit(composite, SWT.BORDER, PWT.ADD_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	outcomeRepresentativeField.setLayoutData(new GridData(300, SWT.DEFAULT));
    	

	////
	
	outcomeRepresentativePhoneLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
	gridData.horizontalIndent = 10;
	outcomeRepresentativePhoneLabel.setLayoutData(gridData);
	outcomeRepresentativePhoneLabel.setText(Messages.getString("CarServOrderEditForm.representativePhoneLabel.text")); //$NON-NLS-1$

	outcomeRepresentativePhoneField = new XTextField(composite, SWT.BORDER);
	outcomeRepresentativePhoneField.setLayoutData(new GridData(150, SWT.DEFAULT));
	initNoEditableField(outcomeRepresentativePhoneField);

	
	outcomeRepresentativeField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateRepresentative(outcomeRepresentativeField, outcomeRepresentativePhoneField);
    	    }
    	});
	
	outcomeRepresentativeField.setListFormInitializer(new IListFormInitializer() {
    	    public void initListForm(IListForm editForm) {
    		if (editForm == null) {
    		    return;
    		}
    		editForm.setParentEntity(getPartner());
    		editForm.setSupportParentEntity(true);
    	    }
    	});
	
    	
	outcomeRepresentativeField.setEditFormInitializer(new IEditFormInitializer() {
    	    public void initEditForm(IEditForm editForm) {
    		if (editForm == null || !editForm.isAddMode()) {
    		    return;
    		}
    		// Reset child mode because this form by default has child mode = true
    		editForm.setChildFormMode(false);
    		editForm.setParentEntity(getPartner());
    		editForm.setSupportParentEntity(true);
    	    }
    	});
	
	
	gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1);
	
	outcomeImagePanel = new ImageTablePanel(composite, Messages.getString("CarServOrderEditForm.photos"));
	outcomeImagePanel.setLayoutData(gridData);
    	
    	////
    	//// CAR SERVICE
    	
    	//new Label(composite, SWT.NONE); new Label(composite, SWT.NONE);
    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	

    	currencyTabItem = new TabItem(tabFolder, SWT.NONE);
    	currencyTabItem.setText(Messages.getString("CarServOrderEditForm.currencyTabItem.text")); //$NON-NLS-1$

    	
    	
    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	currencyTabItem.setControl(composite);

    	currencyLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarServOrderEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	//gridData.horizontalIndent = 10;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarServOrderEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	currencyRateField.setLayoutData(gridData);

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	//gridData.horizontalIndent = 10;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("CarServOrderEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = FIELD_WIDTH;
    	currencyRateDateField.setLayoutData(gridData);
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	
    	////
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarServOrderEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);

    	noteTabItem.setControl(noteField);
    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	
    	
    	ItemToolBar itemToolPanel = null;
    
    	if (isSimpleMode) {
    	    itemToolPanel = new ItemToolBar(this); // Create standard tool bar 
    	    // Create static components 
    	    selectedItemPanelType = createBodyItemPanel(this);
    	} else {
    	    itemToolPanel = new MyItemToolBar(this); // Create special tool bar (Add/Remove damage buttons, Add/Remove inventory button)
    	    
    	    topTabFolder = createTopTabFolder(this); // NEW LINE
    	    
    	    
    	    // Create dynamic components
    	    // But we will create dynamic components later, because components correspondent with data  
    	    // See updateForm() method
    	    
    	    /*
    	    TabFolder topTabFolder = createTopTabFolder(this);
    	    TabItem tabItem = null;
    	    PanelType paneType = null;
    	    
    	    
    	    // Repair car folder
    	    tabItem = createTabItem(topTabFolder, Messages.getString("CarServOrderEditForm.repairItem.text"));
    	    paneType = createBodyItemPanel(topTabFolder);
    	    tabItem.setControl(paneType.getContainer());
    	    selectedItemPanelType = paneType;
    	    

    	    // Damage car folder
    	    tabItem = createTabItem(topTabFolder, Messages.getString("CarServOrderEditForm.damageItem.text")  + " 1");
    	    paneType = createDamagePanel(topTabFolder);
    	    tabItem.setControl(paneType.getContainer());
    	
    	    tabItem = createTabItem(paneType.getTabFolder(), Messages.getString("CarServOrderEditForm.inventoryItem.text") + " 1");
    	
    	    paneType = createInventoryPanel(paneType.getTabFolder());
    	    tabItem.setControl(paneType.getContainer());
    	    */

    	}
    	
    	itemToolPanel.setForm(this);
    	
    	createSummaryPanel();
    	
    	
    	// DISABLE ATTRIBUTE VIEW
    	//AttributeView attributeView = new AttributeView(getSelectedItemTabFolder(), CarServOrder.class);
    	
    	this.setSize(new Point(600, 350));    	

    	
    	//initPartnerField(partnerField);
    	
    	if (warehouseField != null) initWarehouseField(warehouseField);
    	if (contractDocumentField != null) initContractDocumentField(contractDocumentField);
    	if (reasonDocumentField != null) initReasonDocumentField(reasonDocumentField);
    	
    	if (currencyField != null) initCurrencyField(currencyField);
    	if (currencyRateField != null) initCurrencyRateField(currencyRateField);
    	if (currencyRateDateField != null) initCurrencyRateDateField(currencyRateDateField);
    	
    	
    	initPriceTypeField(priceTypeField);
    	initPricePercentField(pricePercentField);
    	
   	
    
    	
    	///////////////////
    	
    	initNoEditableField(carRegNumberField);
    	initNoEditableField(carChassisNumberField); 
    	initNoEditableField(carManufactureYearField);
    	initNoEditableField(carOwnerNameField);
    	//initNoEditableField(carOwnerPhoneField);
    	
    	carField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateCar();
    	    }
    	});
    	
    	///////////////////
    	
    	//registerEntityProvider(getSelectedItemTabFolder().getItem(0), t0);
    	//registerEntityProvider(getSelectedItemTabFolder().getItem(1), t1);
    	//registerEntityProvider(getSelectedItemTabFolder().getItem(2), t2);
    	
    	
    	//registerEntityProvider(getSelectedItemTabFolder().getItem(3), attributeView.getEntityProvider());
    }
    
    private void updateCar() {
	if (!isLoadData) {
	    return;
	}
	Car car = (Car) carField.getValue();
	
	if (car == null) {
	    partner = null;
	    carRegNumberField.setValue("");
	    carChassisNumberField.setValue("");
	    carManufactureYearField.setValue(0);
	    carOwnerNameField.setValue("");
	    
	    //carOwnerPhoneField.setValue("");
	    
	} else {
	    partner = car.getPartner();
	    carRegNumberField.setValue(car.getRegNumber() == null ? "" : car.getRegNumber());
	    carChassisNumberField.setValue(car.getChassisNumber() == null ? "" : car.getChassisNumber());
	    carManufactureYearField.setValue(car.getManufactureYear());
	    carOwnerNameField.setValue(car.getOwnerName() == null ? "" : car.getOwnerName());
	    
	    //carOwnerPhoneField.setValue(car.getOwnerPhone() == null ? "" : car.getOwnerPhone());
	}
	
	
	updateRepresentatives(car);
    }
    
    private void updateRepresentatives(Car car) {
	if (car == null) {
	    resetRepresentatives();
	    disableRepresentatives();
	    return;
	}
	
	IPartnerTitle p = car.getPartner();
	if (p == null) {
	    resetRepresentatives();
	    disableRepresentatives();
	    return;
	}
	
	enableRepresentatives();
	
	setRepresentativeField(p, incomeRepresentativeField);
	setRepresentativeField(p, outcomeRepresentativeField);
	
    }
    
    private void resetRepresentatives() {
	resetRepresentative(incomeRepresentativeField);
	resetRepresentative(outcomeRepresentativeField);
    }

    private void enableRepresentatives() {
	
	if (bg == null) {
	    bg = incomeRepresentativeField.getBackground();
	}
	
	incomeRepresentativeField.setEnabled(true);
	outcomeRepresentativeField.setEnabled(true);
	
	incomeRepresentativeField.setBackground(bg);
	outcomeRepresentativeField.setBackground(bg);
    }
    
    private Color bg; 
    
    private void disableRepresentatives() {
	
	if (bg == null) {
	    bg = incomeRepresentativeField.getBackground();
	}
	
	incomeRepresentativeField.setEnabled(false);
	outcomeRepresentativeField.setEnabled(false);
	
	incomeRepresentativeField.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	outcomeRepresentativeField.setBackground(getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	
    }
    
    private void setRepresentativeField(IPartnerTitle partner, XComboEdit representativeField) {
	if (partner == null) {
	    resetRepresentative(representativeField);
	    return;
	}
	PartnerRepresentative partenrRepresentative  = (PartnerRepresentative) representativeField.getValue();
	if (partenrRepresentative == null) {
	    return;
	}
	IPartnerTitle p = partenrRepresentative.getPartner();
	if (p == null || p.getId() == null) {
	    return;
	}
	if (!p.getId().equals(partner.getId())) {
	    resetRepresentative(representativeField);
	}
    }
    
    private void resetRepresentative(XComboEdit representativeField) {
	// RESET AND DISABLE
	representativeField.setValue(null);
	representativeField.notifyUpdateListener(new UpdateEvent(""));
    }
    
    /**
     * Special Too Bar to damage and inventory 
     */
    class MyItemToolBar extends ItemToolBar {

	public MyItemToolBar(Composite parent, int style, int toolStyle) {
	    super(parent, style, toolStyle);
	}

	public MyItemToolBar(Composite parent, int style) {
	    super(parent, style);
	}

	public MyItemToolBar(Composite parent) {
	    super(parent);
	}

	protected void populateToolBar(ToolBar toolBar) {
	    super.populateToolBar(toolBar);
	    createToolItemSeparator(toolBar);
	    createToolItem(toolBar, ADD_DAMAGE, Messages.getString("CarServOrderEditForm.addDamageButton.text"), "/org/plazmaforge/richclient/images/eclipse/form/addtsk_tsk_h.gif");
	    createToolItem(toolBar, REMOVE_DAMAGE, Messages.getString("CarServOrderEditForm.removeDamageButton.text"), "/org/plazmaforge/richclient/images/eclipse/form/remtsk_tsk_h.gif");
	    createToolItemSeparator(toolBar);
	    createToolItem(toolBar, ADD_INVENTORY, Messages.getString("CarServOrderEditForm.addInventoryButton.text"), "/org/plazmaforge/richclient/images/eclipse/form/addtsk_tsk_h.gif");
	    createToolItem(toolBar, REMOVE_INVENTORY, Messages.getString("CarServOrderEditForm.removeInventoryButton.text"), "/org/plazmaforge/richclient/images/eclipse/form/remtsk_tsk_h.gif");
	}
    }
    
    private ToolItem createToolItemSeparator(final ToolBar toolBar) {
	    ToolItem toolItem = new ToolItem(toolBar, SWT.SEPARATOR);
	    return toolItem;
    }
    
    private ToolItem createToolItem(final ToolBar toolBar, final String type, final String text, final String imageUrl) {
	    ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
	    toolItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doSectionAction(type);
		}
	    });
	    toolItem.setImage(getImage(imageUrl));
	    toolItem.setToolTipText(text);
	    return toolItem;
    }
    
    private void doSectionAction(String type) {
	if (ADD_DAMAGE.equals(type)) {
	    doAddDamageAction();
	} else if (REMOVE_DAMAGE.equals(type)) {
	    doRemoveDamageAction();
	} else if (ADD_INVENTORY.equals(type)) {
	    doAddInventoryAction();
	} else if (REMOVE_INVENTORY.equals(type)) {
	    doRemoveInventoryAction();
	}
    }
    
    private void doAddDamageAction() {
	addDamageFolder();
    }
    
    private void doRemoveDamageAction() {
	PanelType damageType = getSelectedDamageType();
	if (damageType == null) {
	    openMessageDialog(DAMAGE_NOT_SELECTED_MESSAGE);
	    return;
	}
	removeDamageFolder(damageType);
    }
    
    private void doAddInventoryAction() {
	addInventoryFolder();
    }
    
    private void doRemoveInventoryAction() {
	PanelType damageType = getSelectedDamageType();
	if (damageType == null) {
	    openMessageDialog(DAMAGE_NOT_SELECTED_MESSAGE);
	    return;
	}
	PanelType inventoryType = getSelectedInventoryType(damageType);
	if (inventoryType == null) {
	    openMessageDialog(INVENTORY_NOT_SELECTED_MESSAGE);
	    return;
	}
	removeInventoryFolder(inventoryType);
    }
    
    
    // USE FOR REPAIR FOLDER OR SIMPEL MODE
    
    private PanelType createBodyItemPanel(Composite parent) {
	
	ComplexTableEntityProvider t0 = new  CarServItemProviderRP(null);
    	ComplexTableEntityProvider t1 = new  CarPartItemProviderRP(null);
    	ComplexTableEntityProvider t2 = new  CarMaterialItemProviderRP(null);
    	ComplexTableEntityProvider t3 = new  CarPaintItemProviderRP(null);
    	
    	PanelType panelType = createItemPanel(parent, t0, t1, t2, t3);
    	
    	registerEntityProvider(panelType.getTabFolder().getItem(0), t0);
    	registerEntityProvider(panelType.getTabFolder().getItem(1), t1);
    	registerEntityProvider(panelType.getTabFolder().getItem(2), t2);
    	registerEntityProvider(panelType.getTabFolder().getItem(3), t3);
    	
    	if (isSimpleMode) {
    	    return panelType;
    	}
    	
    	// Init type here because we create type after general init
    	initEntityProvider(t0);
    	initEntityProvider(t1);
    	initEntityProvider(t2);
    	initEntityProvider(t3);
    	
    	return panelType;

    }

    /**
     * Create Inventory (OPIS) or Total Inventory (PROFORM F.) panel
     * @param parent
     * @param inventory
     * @return
     */
    private PanelType createInventoryPanel(Composite parent, CarServOrderInventory inventory) {
	
	/*
	//ComplexTableEntityProvider t0 = new  CarServItemProvider(inventory); // NEW oha: disabled: customer requirement: 2008-10-22
    	ComplexTableEntityProvider t1 = new  CarPartItemProvider(inventory);
    	
    	//ComplexTableEntityProvider t2 = new  CarMaterialItemProvider(inventory); // oha: disabled: customer requirements: 2008-07-07
    	//ComplexTableEntityProvider t3 = new  CarPaintItemProvider(inventory); // oha: disabled: customer requirements: 2008-07-07
    	
    	//ComplexTableEntityProvider t3 = new  CarPaintTypeItemProvider(inventory); // NEW oha: disabled: customer requirement: 2008-10-22 // oha: add: customer requirements: 2008-07-07
    	
    	//PanelType panelType = createInventoryPanel(parent, t0, t1, null /t2/, t3); // oha: disabled: customer requirements: 2008-07-07
    	PanelType panelType = createInventoryPanel(parent, null, t1, null /t2/, null);
    	
    	panelType.setData(inventory);
    	
    	
    	//registerEntityProvider(panelType.getTabFolder().getItem(2), t2); // oha: disabled: customer requirements: 2008-07-07
    	//registerEntityProvider(panelType.getTabFolder().getItem(3), t3); // oha: disabled: customer requirements: 2008-07-07

    	//registerEntityProvider(panelType.getTabFolder().getItem(0), t0);
    	//registerEntityProvider(panelType.getTabFolder().getItem(1), t1);

    	
    	registerEntityProvider(panelType.getTabFolder().getItem(0), t1);

    	//registerEntityProvider(panelType.getTabFolder().getItem(2), t3); // oha: add: customer requirements: 2008-07-07
    	
    	// Init type here because we create type after general init
    	//initEntityProvider(t0);
    	initEntityProvider(t1);
    	
    	//initEntityProvider(t2); // oha: disabled: customer requirements: 2008-07-07
    	//initEntityProvider(t3);
    	*/
    	
    	if (inventory == null) {
    	    return null;
    	}
    	PanelType panelType = null;
    	
    	if (inventory.isTotalInventory()) {
    	    
    	    // TOTAL INVENTORY (PROFORM F.)
    	    ComplexTableEntityProvider t0 = new  CarServItemProvider(inventory); // (USLUGI)
    	    ComplexTableEntityProvider t1 = new  CarPartItemProvider(inventory); // (ZAPCHASTI)
    	    ComplexTableEntityProvider t3 = new  CarPaintItemProvider(inventory); // (KRASKA)
    	
    	    panelType = createInventoryPanel(parent, inventory, t0, t1, null, t3);
    	    panelType.setData(inventory);
            	

    	    registerEntityProvider(panelType.getTabFolder().getItem(0), t0);
            registerEntityProvider(panelType.getTabFolder().getItem(1), t1);
            registerEntityProvider(panelType.getTabFolder().getItem(2), t3);
            

            initEntityProvider(t0);
            initEntityProvider(t1);
            initEntityProvider(t3);
    	    
    	} else {
    	    
    	    // INVENTORY (OPIS)
    	    // WE USE ONLY DETAIL (PARTS LIKE PART) PANEL FOR INVENTORY
    	    ComplexTableEntityProvider t1 = new  CarDetailItemProvider(inventory); // (DETALI)
            panelType = createInventoryPanel(parent, inventory, null, t1, null , null);
            	
            panelType.setData(inventory);
            registerEntityProvider(panelType.getTabFolder().getItem(0), t1);
            initEntityProvider(t1);
    	    
            // FIX 2008-10-24
            try {
        	t1.updateView();
            } catch (Exception ex) {
        	
            }
            
    	}
    	
    	return panelType;

    }

   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	
	///
	bindControl(carField, "car", carLabel, REQUIRED);
	
	bindControl(carRegNumberField, "carRegNumber");
	bindControl(carChassisNumberField, "carChassisNumber");
	bindControl(carManufactureYearField, "carManufactureYear");
	bindControl(carOwnerNameField, "carOwnerName");
	
	///
	
	bindControl(carIncomeDateField, "carIncomeDate");
	bindControl(carOutcomeDateField, "carOutcomeDate");

	bindControl(warehouseField, "warehouse");
	bindControl(responsibleField, "responsible");
	bindControl(contractDocumentField, "contractDocument");
	
	bindControl(currencyField, "currency");
	bindControl(currencyRateField, "currencyRate");
	bindControl(currencyRateDateField, "currencyRateDate");
	
	bindControl(currencyTotalField, "currencyTotal");
	bindControl(currencyTaxTotalField, "currencyTaxTotal");
	bindControl(currencyTotalWithTaxField, "currencyTotalWithTax");

	bindControl(priceTypeField, "priceType");
	bindControl(pricePercentField, "pricePercent");

	
	///
	bindControl(incomeRepresentativeField, "incomeRepresentative");
	bindControl(outcomeRepresentativeField, "outcomeRepresentative");
	
	bindControl(incomeRepresentativePhoneField, "incomeRepresentativePhone");
	bindControl(outcomeRepresentativePhoneField, "outcomeRepresentativePhone");
	
	bindControl(noteField, "note");
    }

    
    private TabFolder createTopTabFolder(Composite parent) {
	 
        GridLayout gridLayout;
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 250; // 181 // !!! GENERAL HEIGHT !!!
        
        Composite panel = new Composite(parent, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        panel.setLayout(gridLayout);
        panel.setLayoutData(gridData);
        
        TabFolder tabFolder = new TabFolder(panel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 600;
        tabFolder.setLayoutData(gridData);

        return tabFolder;
    }

    
    private TabItem createTabItem(TabFolder parent, String text, int index) {
	TabItem tabItem = new TabItem(parent, SWT.NONE, index < 0 ? parent.getItemCount() : index);
	tabItem.setText(text);
	return tabItem;
    }
    
    private TabItem createTabItem(TabFolder parent, String text) {
	return createTabItem(parent, text, parent.getItemCount());
    }
    
    private void createEmptyLabel(Composite parent, int topMargin, int leftMargin, int width) {
	Label label = new Label(parent, SWT.NONE);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = width;
	label.setLayoutData(gridData);
    }
    
    private PanelType createDamagePanel(Composite parent, CarServOrderDamage damage) {

	boolean isAdditionalRepair = damage.isAdditionalRepair();
	
	PanelType type = new PanelType();
	type.setData(damage);
	
	GridLayout gridLayout;

	GridData gridData = null; // new GridData(SWT.FILL, SWT.FILL,
                                        // true, true, 1, 2);
	// gridData.heightHint = 181;

	// Create container for elements
	
	int COLUMN_COUNT = 6;
	
	Composite panel = new Composite(parent, SWT.NONE);
	gridLayout = new GridLayout();
	
	gridLayout.verticalSpacing = 0;
	gridLayout.marginWidth = 0;
	gridLayout.marginHeight = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.numColumns = COLUMN_COUNT;

	panel.setLayout(gridLayout);
	int leftMargin = 5;
	int topMargin = 5;

	
	// ========================================================================================================
	// ROW 1
	// ========================================================================================================
	
	Label label = null;
	XTextField damageCodeField = null;
	XDateCombo damageDateField = null;
	XComboEdit carClassField = null;
	XComboEdit insurerField = null;
	XComboEdit brokerField = null;
	
	if (isAdditionalRepair) {
	    createEmptyLabel(panel, topMargin, leftMargin, LABEL_WIDTH);
	    createEmptyLabel(panel, topMargin, leftMargin, LABEL_WIDTH);
	    createEmptyLabel(panel, topMargin, leftMargin, LABEL_WIDTH);
	    createEmptyLabel(panel, topMargin, leftMargin, LABEL_WIDTH);
	} else {
	    
	
	//// CODE
	label = new Label(panel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.damageItem.damageCodeLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = LABEL_WIDTH;
	label.setLayoutData(gridData);
	
	damageCodeField = new XTextField(panel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = FIELD_WIDTH;
	damageCodeField.setLayoutData(gridData);

	
	
	//// DATE
	label = new Label(panel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.damageItem.damageDateLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin + 10;
	gridData.widthHint = LABEL_WIDTH;
	label.setLayoutData(gridData);
	
	damageDateField = new XDateCombo(panel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = FIELD_WIDTH;
	damageDateField.setLayoutData(gridData);
	
	}

	label = new Label(panel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.damageItem.carClassLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin + 10;
	label.setLayoutData(gridData);

	
	carClassField = new XComboEdit(panel, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	carClassField.setLayoutData(gridData);

	
	
	// ========================================================================================================	
	// ROW 2
	// ========================================================================================================	
	
	label = new Label(panel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.damageItem.insurerLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = LABEL_WIDTH;
	label.setLayoutData(gridData);

	
	insurerField = new XComboEdit(panel, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON | PWT.ADD_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	insurerField.setLayoutData(gridData);


	
	// ========================================================================================================	
	// ROW 3
	// ========================================================================================================	
	
	if (!isAdditionalRepair) {
	    label = new Label(panel, SWT.NONE);
	    label.setText(Messages.getString("CarServOrderEditForm.damageItem.brokerLabel.text")); //$NON-NLS-1$
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin;
	    gridData.widthHint = LABEL_WIDTH;
	    label.setLayoutData(gridData);
	    	

	    brokerField = new XComboEdit(panel, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON | PWT.ADD_BUTTON);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin;
	    brokerField.setLayoutData(gridData);

	}
	

	// END ROWS
	
	
	
	TabFolder tabFolder = new TabFolder(panel, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.FILL, true, true, COLUMN_COUNT, 1);
	gridData.verticalIndent = topMargin;
	gridData.widthHint = 600;
	tabFolder.setLayoutData(gridData);

	type.setContainer(panel);
	type.setTabFolder(tabFolder);
	
	////
	
	//carClassField.setListFormClass(CarClassListForm.class);
	carClassField.setDataList(getCarClassList());
	
	insurerField.setListFormClass(PartnerListForm.class);
	insurerField.setEditFormClass(PartnerEditForm.class); // FOR ADDING
	
	if (brokerField != null) {
	    brokerField.setListFormClass(PartnerListForm.class);
	    brokerField.setEditFormClass(PartnerEditForm.class); // FOR ADDING
	}
	
	type.setData("damageCodeField", damageCodeField);
	type.setData("damageDateField", damageDateField);
	type.setData("insurerField", insurerField);
	if (brokerField != null) {
	    type.setData("brokerField", brokerField);
	}
	type.setData("carClassField", carClassField);
	
	return type;

    }
    
    private List<CarClass> carClassList;
    
    
    private List<CarClass> getCarClassList() {
	if (carClassList == null) {
	    try {
		carClassList = ((CarClassService) getService(CarClassService.class)).findAll();
	    } catch (Exception ex) {
		carClassList = new ArrayList<CarClass>();
		logger.error(ex);
	    }
	}
	return carClassList;
    }

    
    
    
    private List<CarPaintType> carPaintTypeList;
    
    
    private List<CarPaintType> getCarPaintTypeList() {
	if (carPaintTypeList == null) {
	    try {
		carPaintTypeList = ((CarPaintTypeService) getService(CarPaintTypeService.class)).findAll();
	    } catch (Exception ex) {
		carPaintTypeList = new ArrayList<CarPaintType>();
		logger.error(ex);
	    }
	}
	return carPaintTypeList;
    }
    
    /**
     * Create simple items panel (Only for repair the car)	
     *
     */
    private PanelType createItemPanel(Composite parent, ComplexTableEntityProvider t0, ComplexTableEntityProvider t1, 	ComplexTableEntityProvider t2, ComplexTableEntityProvider t3) {
 
	PanelType type = new PanelType();
	
        GridLayout gridLayout;
          
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 181;
        
        
        Composite itemsPanel = new Composite(parent, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        
        itemsPanel.setLayout(gridLayout);
        itemsPanel.setLayoutData(gridData);
        

        
        TabFolder itemsTabFolder = new TabFolder(itemsPanel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.widthHint = 600;
        itemsTabFolder.setLayoutData(gridData);

        type.setContainer(itemsPanel);
        type.setTabFolder(itemsTabFolder);
        
        createCarServPanelRP(itemsTabFolder, t0);
        createCarPartPanelRP(itemsTabFolder, t1);
        createCarMaterialPanelRP(itemsTabFolder, t2);
        createCarPaintPanelRP(itemsTabFolder, t3);
        
        return type;
    }

    /**
     * Create Inventory or Total Inventory (PROFORM F.) panel (Only for damage)
     * @param parent
     * @param t0
     * @param t1
     * @param t2
     * @param t3
     * @return
     */
    private PanelType createInventoryPanel(Composite parent, final CarServOrderInventory inventory, final ComplexTableEntityProvider t0, final ComplexTableEntityProvider t1, final ComplexTableEntityProvider t2, final ComplexTableEntityProvider t3) {
	 
	//final CarServOrderInventory inventory = t1.getInventory(); // t0
	
	boolean isTotal = inventory == null ? false: inventory.isTotalInventory();
	
	final PanelType type = new PanelType();
	
        GridLayout gridLayout;
          
        GridData gridData = null;
        //GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        //gridData.heightHint = 181;
        
        //int INVENTORY_COLUMN_COUNT = isTotal ? 4: 2;
        
        int INVENTORY_COLUMN_COUNT = 4;
        if (isTotal) {
            INVENTORY_COLUMN_COUNT += 2; // Two buttons for total mode
        }
        
        Composite itemsPanel = new Composite(parent, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        gridLayout.numColumns = INVENTORY_COLUMN_COUNT; 
        
        itemsPanel.setLayout(gridLayout);
        //itemsPanel.setLayoutData(gridData);
        

        int leftMargin = 5;
	int topMargin = 5;

	Label label = new Label(itemsPanel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.inventoryItem.inventoryDateLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	label.setLayoutData(gridData);
	
	XDateCombo inventoryDateField = new XDateCombo(itemsPanel, SWT.BORDER);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = 100;
	inventoryDateField.setLayoutData(gridData);
        
	////
	
	
	XComboEdit carPaintTypeField = null;
	if (!isTotal) {
	    
	    label = new Label(itemsPanel, SWT.NONE);
	    label.setText(Messages.getString("CarServOrderEditForm.inventoryItem.carPaintTypeLabel.text"));
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin + 10;
	    label.setLayoutData(gridData);

		
	    carPaintTypeField = new XComboEdit(itemsPanel, SWT.BORDER);
	    gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin;
	    gridData.widthHint = 100;
	    carPaintTypeField.setLayoutData(gridData);
	}
	
	// PROFORM F.
	if (isTotal) {
	    
	    // ADD SPECIAL BUTTONS FOR PROMORM
	    // ADD/REMOVE TOTAL ROWS
	    
	    Button button = new Button(itemsPanel, SWT.NONE);
	    button.setText(ADD_TOTAL_ROWS_MESSAGE);
	    gridData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin;
	    gridData.widthHint = 100;
	    button.setLayoutData(gridData);
		
		
	    button.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAddTotalInventory2(type, inventory, t0, t1, t2, t3);
		}
	    });
	    
	    //button.setEnabled(false);
	    
	    
	    
	    Button button2 = new Button(itemsPanel, SWT.NONE);
	    button2.setText(REMOVE_TOTAL_ROWS_MESSAGE);
	    gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	    gridData.verticalIndent = topMargin;
	    gridData.horizontalIndent = leftMargin;
	    gridData.widthHint = 100;
	    button2.setLayoutData(gridData);
	    
	    button2.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doRemoveTotalInventory(inventory, t0, t1, t2, t3);
		}
	    });
	    
	    button2.setEnabled(false);
	}
	
	
        TabFolder itemsTabFolder = new TabFolder(itemsPanel, SWT.NONE);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, true, INVENTORY_COLUMN_COUNT, 1);
        gridData.verticalIndent = topMargin;
        gridData.widthHint = 600;
        itemsTabFolder.setLayoutData(gridData);

        type.setContainer(itemsPanel);
        type.setTabFolder(itemsTabFolder);
        
        // ADD CAR SERVICE PANEL
        if (t0 != null) {
            createCarServPanel(itemsTabFolder, t0);
        }
        
        
        if (t1 != null) {
            if (isTotal) {
        	
        	// ADD CAR PART PANEL. ONLY FOR TOTAL (PROFORM F.)
                createCarPartPanel(itemsTabFolder, t1);
            } else {
        	
        	// ADD CAR DETAIL PANEL
                createCarDetailPanel(itemsTabFolder, t1);
            }
        }
        
        
        /*
        if (t2 != null) {
            createCarMaterialDetailPanel(itemsTabFolder, t2); // oha: disabled: customer requirements: 2008-07-07
        }
        */
        
        if (t3 != null) {
            createCarPaintPanel(itemsTabFolder, t3); // oha: disabled: customer requirements: 2008-07-07
        }
        
        /*
        if (t3 != null) {
            createCarPaintTypeDetailPanel(itemsTabFolder, t3); // oha: add: customer requirements: 2008-07-07
        }
        */
        
	////
	
	type.setData("inventoryDateField", inventoryDateField);
	
	if (carPaintTypeField != null) {
	    type.setData("carPaintTypeField", carPaintTypeField);
	    carPaintTypeField.setDataList(getCarPaintTypeList());
	    //carPaintTypeField.setListFormClass(CarPaintType.class);
	}
	
	
        return type;
    }
    
    private void doAddTotalInventory(CarServOrderInventory inventory, final TableEntityProvider t0, final TableEntityProvider t1, final TableEntityProvider t2, final TableEntityProvider t3) {
	if (inventory == null || inventory.getDamage() == null) {
	    return;
	}
	if (!openConfirmYesNoDialog(CONFIRM_ADD_TOTAL_ROWS_MESSAGE) ) {
	    return;
	}
	
	try {
	    inventory.getDamage().addTotalInventory();
	    refreshAllViews(t0, t1, t2, t3);
	    updateTotalAmount(inventory.getDamage().getTotalInventory());
	} catch (Throwable ex) {
	    openErrorDialog(ex);
	}
    }

    private static final String CANT_CALCULATE_TOTAL = "Can't calculate total: ";
	
    private void doAddTotalInventory2(PanelType inventoryType, CarServOrderInventory inventory, final TableEntityProvider t0, final TableEntityProvider t1, final TableEntityProvider t2, final TableEntityProvider t3) {
	if (inventory == null || inventory.getDamage() == null || inventoryType == null || inventoryType.getParent() == null) {
	    return;
	}
	if (!openConfirmYesNoDialog(CONFIRM_ADD_TOTAL_ROWS_MESSAGE) ) {
	    return;
	}
	
	// 1. VALIDATE: CAR 
	Car car = (Car) carField.getValue();
	if (car == null) {
	    openMessageDialog(CANT_CALCULATE_TOTAL + "Car is empty");
	    return;
	}
	
	
	PanelType damageType = inventoryType.getParent();
	
	// 2. VALIDATE: CAR CLASS
	XComboEdit carClassField = (XComboEdit) damageType.getData(CAR_CLASS_FIELD);
	CarClass carClass = (CarClass) carClassField.getValue();
	if (carClass == null) {
	    openMessageDialog(CANT_CALCULATE_TOTAL + "Car class is empty");
	    return;
	}

	// 3. VALIDATE: INSURER
	XComboEdit insurerField = (XComboEdit) damageType.getData(INSURER_FIELD);
	PartnerTitle insurer = (PartnerTitle) insurerField.getValue();
	if (insurer == null) {
	    openMessageDialog(CANT_CALCULATE_TOTAL + "Insurer is empty");
	    return;
	}
	
	
	CarServOrderDamage damage = inventory.getDamage();
	try {
	    CarInsurerContractVariantService contractService = getCarInsurerContractVariantService();
	    
	    CarInsurerContractVariant contract = contractService.getLastContractByInsurer(insurer.getId());
	 
	    // 4. VALIDATE: CONTRACT
	    if (contract == null) {
		openMessageDialog(CANT_CALCULATE_TOTAL + "Contract not found");
		return;
	    }
	    
	    calcualteByDamage(car, carClass, damageType, damage, contract);
	    
	    refreshAllViews(t0, t1, t2, t3);
	    updateTotalAmount(inventory.getDamage().getTotalInventory());
	} catch (Throwable ex) {
	    openErrorDialog(ex);
	}
    }
    
    
    
    
    private void calcualteByDamage(Car car, CarClass carClass, PanelType damageType, CarServOrderDamage damage, CarInsurerContractVariant contract) {
	try {
	    
	    CarServOrderInventory total = damage.getTotalInventory();
	    damage.removeTotalInventoryProductItems(); // REMOVE ALL ITEMS FROM TOTAL INVENTORY

	    List<CarServOrderInventory> inventories = damage.getSimpleInventoryList();
	    
	    Map<Integer, CarDetail> carDetalMap = new HashMap<Integer, CarDetail>();
	    Map<CarServOrderInventory, CarPaintType> carPaintMap = new HashMap<CarServOrderInventory, CarPaintType>();
	
	    List<PanelType> inventoryTypes = damageType.getChildren();
	    for (CarServOrderInventory inventory : inventories) {
		for (PanelType type : inventoryTypes) {
		    if (inventory != type.getData()) {
			continue;
		    }
		    XComboEdit field = (XComboEdit) type.getData("carPaintTypeField");
		    if (field == null) {
			continue;
		    }
		    CarPaintType carPaintType = (CarPaintType) field.getValue();
		    if (carPaintType == null) {
			continue;
		    }
		    carPaintMap.put(inventory, carPaintType);
		}
	    }
	    
	    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	    int manufactureYear = car.getManufactureYear();
	    int carAge = manufactureYear > currentYear ? 0 : currentYear - manufactureYear;
	    
	    CarDetailService service = getCarDetailService();
	    for (CarServOrderInventory inventory : inventories) {
		calcualteByInventory(carAge, carClass, damage, contract, total, inventory, service, carDetalMap, carPaintMap);
	    }
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }
    
    private void calcualteByInventory(int carAge, CarClass carClass, CarServOrderDamage damage, CarInsurerContractVariant contract, CarServOrderInventory total, CarServOrderInventory inventory, CarDetailService service, Map<Integer, CarDetail> carDetalMap, Map<CarServOrderInventory, CarPaintType> carPaintMap) throws Exception {

	List<CarServOrderItem> list = damage.convertProductItemToOrderItem(inventory.getDetailItems());

	Integer carClassId = carClass.getId();
	CarPaintType carPaintType = carPaintMap.get(inventory);
	
	
	
	float basePaintVolume = 0f;
	double baseConsumablePrice = 0d;
	
	//Map<CarServOrderItem, CarServOrderItem> nonBasePaint1 = new HashMap<CarServOrderItem, CarServOrderItem>(); // DISABLE
	Map<CarServOrderItem, CarInsurerPaintTypeVolume> nonBasePaint2 = new HashMap<CarServOrderItem, CarInsurerPaintTypeVolume>();
	
	Map<CarServOrderItem, CarInsurerConsumablesPrice> nonBaseConsumable2 = new HashMap<CarServOrderItem, CarInsurerConsumablesPrice>();

	for (CarServOrderItem detailItem : list) {
	    Integer productId = detailItem.getProductId();
	    if (productId == null) {
		// PRODUCT NOT FOUND
		continue;
	    }

	    CarDetail d = carDetalMap.get(productId);
	    if (d == null) {
		d = service.findById(productId);
		carDetalMap.put(productId,d);
	    }
	    
	    CarDetailVariant variant = d.findVariantByAttribute(detailItem.getCarDetailServAttribute());
	    if (variant == null) {
		// VARIANT NOT FOUND
		continue;
	    }

	    CarDamageLevel carDamageLevel  = variant.getCarDamageLevel();
	    
	    double itemQuantity = detailItem.getQuantity();
	    
	    // PART SECTION
	    List<CarDetailVariantPart> variantParts = variant.getPartList();
	    
	    for (CarDetailVariantPart variantPart : variantParts) {

		CarServOrderItem carServOrderItem = new CarServOrderItem();
		carServOrderItem.setItemType(CarServOrder.PART_ITEM);
		carServOrderItem.setProduct(variantPart.getCarPart());
		carServOrderItem.setUnit(detailItem.getUnit());
		carServOrderItem.setUnitRate(detailItem.getUnitRate());

		carServOrderItem.setQuantity(itemQuantity);

		// FINDER
		float discount = contract.findDiscountOfPartPrice(carAge);
		
		// SET DEFAULT PRICE FROM DICTIONARY
		setItemPrices(carServOrderItem, variantPart.getCarPart(), discount);
		
		calcualteItemAmounts(carServOrderItem);
		
		total.addProductItem(carServOrderItem);
	    }

	    // SERV SECTION
	    List<CarDetailVariantServ> variantServs = variant.getServList();
	    for (CarDetailVariantServ variantServ : variantServs) {

		// FILTER BY CAR CLASS
		if (!carClassId.equals(variantServ.getCarClassId())) {
		    continue;
		}
		
		CarServ carServ = variantServ.getCarServ();
		CarServOrderItem carServOrderItem = new CarServOrderItem();
		carServOrderItem.setItemType(CarServOrder.SERVICE_ITEM);
		carServOrderItem.setProduct(carServ);
		carServOrderItem.setUnit(detailItem.getUnit());
		carServOrderItem.setUnitRate(detailItem.getUnitRate());

		carServOrderItem.setQuantity(itemQuantity * variantServ.getWorkHour());

		
		
		// FINDER: GET PRICE OF SERV
		Double price = contract.findPriceOfServ(carAge, carServ.getCarServType());
		
		if (price == null) {
		    // SET DEFAULT PRICE FROM DICTIONARY
		    setItemPrices(carServOrderItem, variantServ.getCarServ());
		} else {
		    setItemPrices(carServOrderItem, price, 0);
		}

		calcualteItemAmounts(carServOrderItem);
		
		total.addProductItem(carServOrderItem);
	    }

	    // PAINT SECTION
	    
	    List<CarDetailVariantPaint> variantPaints = variant.getPaintList();
	    for (CarDetailVariantPaint variantPaint : variantPaints) {

		CarPaint carPaint = variantPaint.getCarPaint();
		
		CarServOrderItem carServOrderItem = new CarServOrderItem();
		carServOrderItem.setItemType(CarServOrder.PAINT_ITEM);
		carServOrderItem.setProduct(carPaint);
		carServOrderItem.setUnit(detailItem.getUnit());
		carServOrderItem.setUnitRate(detailItem.getUnitRate());

		CarPaintDetailType carPaintDetailType = variantPaint.getCarPaintDetailType();
		boolean isBaseType = carPaintDetailType.isBaseType();
		boolean isCalculateAmount = true;
		
		
		if (!carPaint.isConsumable()) {
		    // ONLY FOR PAINT
		    
		    //FINDER: GET VOLUME OF PAINT
		    Float volume = null;
		    CarInsurerPaintTypeVolume contractPaintVolume = contract.findPaintVolumeVariant(carClass, carPaintDetailType);
		    if (contractPaintVolume != null) {
			if (isBaseType) { // IGNORE PERCENT
			    volume = contractPaintVolume.getVolume();
			    //basePaintVolume += volume; // STORE BASE !!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!
			    basePaintVolume = volume; // STORE BASE
			} else {
			    if (contractPaintVolume.getPercentOfBasic() > 0) {
				isCalculateAmount = false;
				//nonBasePaint1.put(carServOrderItem, detailItem); // DISABLE
				nonBasePaint2.put(carServOrderItem, contractPaintVolume);
			    } else {
				volume = contractPaintVolume.getVolume();
			    }
			}
		    }
		    if (volume == null) {
			volume = 0f;
		    }
		    
		    carServOrderItem.setQuantity(itemQuantity * volume);

		    CarPaintMark carPaintMark = carPaint.getCarPaintMark();
			
		    // FINDER: GET PRICE OF PAINT
		    Double price = contract.findPriceOfPaint(carPaintType, carPaintMark);
			
		    if (price == null) {
			// SET DEFAULT PRICE FROM DICTIONARY
			setItemPrices(carServOrderItem, variantPaint.getCarPaint());
		    } else {
			setItemPrices(carServOrderItem, price, 0);
		    }
		    
		} else {
		    // ONLY FO CONSUMABLE
		    
		    carServOrderItem.setQuantity(itemQuantity);
		    
		  //FINDER
		  Double price = null;
		  CarInsurerConsumablesPrice contractConsumablePrice = contract.findConsumablePriceVariant(carClass, carPaintDetailType, carDamageLevel);
		  if (contractConsumablePrice != null) {
			if (isBaseType) { // IGNORE PERCENT
			    price = new Double(contractConsumablePrice.getPrice());
			    baseConsumablePrice = price; // STORE BASE
			} else {
			    if (contractConsumablePrice.getPercent() > 0) {
				isCalculateAmount = false;
				nonBaseConsumable2.put(carServOrderItem, contractConsumablePrice);
			    } else {
				price = new Double(contractConsumablePrice.getPrice());
			    }
			}
		  }
		  
		  
		  if (contractConsumablePrice == null) {
			// SET DEFAULT PRICE FROM DICTIONARY
			setItemPrices(carServOrderItem, variantPaint.getCarPaint());
		    } else if (price != null) {
			setItemPrices(carServOrderItem, price, 0);
		    }
		}
		
		

		if (isCalculateAmount) {
		    calcualteItemAmounts(carServOrderItem);
		}
		
		
		total.addProductItem(carServOrderItem);
	    }
	    
	    
	    //////////////////////////////////////////////////////////////////////////////////
	    if (!nonBasePaint2.isEmpty()) {
		Set<CarServOrderItem> items = nonBasePaint2.keySet();
		for (CarServOrderItem carServOrderItem : items) {
		    CarInsurerPaintTypeVolume typeVolume = nonBasePaint2.get(carServOrderItem);
		    float volume = typeVolume.getPercentOfBasic() / 100 * basePaintVolume;
		    carServOrderItem.setQuantity(detailItem.getQuantity() * volume);
		    calcualteItemAmounts(carServOrderItem); // RECALCULATE
		}
	    }

	    if (!nonBaseConsumable2.isEmpty()) {
		Set<CarServOrderItem> items = nonBaseConsumable2.keySet();
		for (CarServOrderItem carServOrderItem : items) {
		    CarInsurerConsumablesPrice typeVolume = nonBaseConsumable2.get(carServOrderItem);
		    double price = typeVolume.getPercent() / 100 * baseConsumablePrice;
		    setItemPrices(carServOrderItem, price, 0);
		    calcualteItemAmounts(carServOrderItem); // RECALCULATE
		}
	    }
	}
	
	

    }
    
    private void setItemPrices(CarServOrderItem item, Goods goods) {
	setItemPrices(item, goods, 0);
    }
    
    private void setItemPrices(CarServOrderItem item, Goods goods, float discountPercent) {
	double currencyBasePrice = goods.getCurrencyListPrice();
	setItemPrices(item, currencyBasePrice, discountPercent);
    }

    private void setItemPrices(CarServOrderItem item, double currencyBasePrice, float discountPercent) {
	
	item.setCurrencyBasePrice(currencyBasePrice);
	item.setCurrencyBasePriceWithTax(currencyBasePrice);
	
	item.setDiscountPercent(discountPercent);
	
	double currencyPrice = (discountPercent > 0) ?  MoneyEnvironment.roundMoney(currencyBasePrice - (currencyBasePrice * discountPercent / 100)) : currencyBasePrice;
	item.setCurrencyPrice(currencyPrice);
	item.setCurrencyPriceWithTax(currencyPrice);
    }

    private void calcualteItemAmounts(CarServOrderItem item) {
	double quantity = item.getQuantity();
	item.setCurrencyAmount(item.getCurrencyPrice() * quantity);
	item.setCurrencyAmountWithTax(item.getCurrencyPriceWithTax() * quantity);
    }

    
    
    
    private CarDetailService getCarDetailService() {
	return (CarDetailService) getService(CarDetailService.class);
    }

    private CarInsurerContractVariantService getCarInsurerContractVariantService() {
	return (CarInsurerContractVariantService) getService(CarInsurerContractVariantService.class);
    }

    
    
    
    private void doRemoveTotalInventory(CarServOrderInventory inventory, final TableEntityProvider t0, final TableEntityProvider t1, final TableEntityProvider t2, final TableEntityProvider t3) {
	if (inventory == null || inventory.getDamage() == null) {
	    return;
	}
	if (!openConfirmYesNoDialog(CONFIRM_REMOVE_TOTAL_ROWS_MESSAGE) ) {
	    return;
	}

	try {
	    inventory.getDamage().removeTotalInventory();
	    refreshAllViews(t0, t1, t2, t3);
	    updateTotalAmount(inventory.getDamage().getTotalInventory());
	} catch (Throwable ex) {
	    openErrorDialog(ex);
	}
    }
    
    private void refreshAllViews(final TableEntityProvider t0, final TableEntityProvider t1, final TableEntityProvider t2, final TableEntityProvider t3) throws ApplicationException {
	refreshView(t0);
	refreshView(t1);
	refreshView(t2);
	refreshView(t3);
    }

    private void refreshView(TableEntityProvider type) throws ApplicationException {
	if (type == null) {
	    return;
	}
	type.updateView();
    }
    
    private PanelType selectedItemPanelType;
    
    protected PanelType getSelectedItemPanelType() {
	if (isSimpleMode) {
	    return selectedItemPanelType;    
	}
	PanelType damageType = getSelectedDamageType();
	if (damageType == null) {
	    return getRepairType();
	}
	PanelType inventoryType = getSelectedInventoryType(damageType);
	return inventoryType;
    }
    
    ////
    
    
    protected PanelType getSelectedDamageType() {
	if (topTabFolder == null) {
	    return null;
	}
	int index = topTabFolder.getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	
	TabItem selectedTopFolder = topTabFolder.getItem(index);
	Object objectType = selectedTopFolder.getData("type");
	if ( objectType == null || (!(objectType instanceof PanelType))) {
	    return null;
	}
	PanelType damageType = (PanelType) objectType;
	return damageType;
    }


    protected PanelType getSelectedInventoryType(PanelType damageType) {
	if (damageType == null) {
	    return null;
	}
	TabFolder innerTabFolder = damageType.getTabFolder();
	if (innerTabFolder == null) {
	    return null;
	}
	
	int index = innerTabFolder.getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	
	TabItem selectedTopFolder = innerTabFolder.getItem(index);
	Object objectType = selectedTopFolder.getData("type");
	if ( objectType == null || (!(objectType instanceof PanelType))) {
	    return null;
	}
	PanelType inventoryType = (PanelType) objectType;
	return inventoryType;
    }

    ////
    
    protected PanelType getRepairType() {
	return selectedItemPanelType;
    }

    protected TabFolder getSelectedItemTabFolder() {
	return getSelectedItemPanelType().getTabFolder();
    }

    
    protected class PanelType {
	
	/** Bean data **/
	private Object data;
	
	/** Container panel **/
	private Composite container;
	
	private TabItem tabItem;
	
	/** Parent Tab Folder **/
	private TabFolder tabFolder;

	/** Parent type **/
	private PanelType parent;
	
	/** Child types **/
	private List<PanelType> children = new ArrayList<PanelType>();
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public Composite getContainer() {
	    return container;
	}

	public void setContainer(Composite container) {
	    this.container = container;
	}

	public TabItem getTabItem() {
	    return tabItem;
	}

	public void setTabItem(TabItem tabItem) {
	    this.tabItem = tabItem;
	}

	public TabFolder getTabFolder() {
	    return tabFolder;
	}

	public void setTabFolder(TabFolder tabFolder) {
	    this.tabFolder = tabFolder;
	}

	public Object getData() {
	    return data;
	}

	public void setData(Object data) {
	    this.data = data;
	}

	public Object getData(String key) {
	    return dataMap.get(key);
	}

	
	public void setData(String key, Object value) {
	    dataMap.put(key, value);
	}

	
	public List<PanelType> getChildren() {
	    return children;
	}

	public void addChild(PanelType child) {
	    getChildren().add(child);
	    child.setParent(this);
	}

	public void removeChild(PanelType child) {
	    getChildren().remove(child);
	    child.setParent(null);
	}
	
	public PanelType getParent() {
	    return parent;
	}

	public void setParent(PanelType parent) {
	    this.parent = parent;
	}
	
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CAR SERVICE PANEL
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void createCarServPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carServTabItem = new TabItem(parent, SWT.NONE);
        carServTabItem.setText(Messages.getString("CarServOrderEditForm.carServTabItem.text")); //$NON-NLS-1$

         
        Table carServTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carServTable.setHeaderVisible(true);
        carServTable.setLinesVisible(true);
        carServTabItem.setControl(carServTable);

        type.setTable(carServTable);
   
        TableColumn tableColumn = new TableColumn(carServTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carServTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        /*
        TableColumn unitNameColumn = new TableColumn(carServTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carServTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$
        */

        TableColumn quantityColumn = new TableColumn(carServTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.workHourColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyBasePriceColumn = new TableColumn(carServTable, SWT.RIGHT);
        currencyBasePriceColumn.setWidth(80);
        currencyBasePriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyBasePriceColumn.text")); //$NON-NLS-1$

        TableColumn pricePercentColumn = new TableColumn(carServTable, SWT.RIGHT);
        pricePercentColumn.setWidth(80);
        pricePercentColumn.setText(Messages.getString("CarServOrderEditForm.pricePercentColumn.text")); //$NON-NLS-1$

        
        TableColumn currencyPriceColumn = new TableColumn(carServTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(carServTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(carServTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
        
        /*
        TableColumn workerColumn = new TableColumn(carServTable, SWT.NONE);
        workerColumn.setWidth(200);
        workerColumn.setText(Messages.getString("CarServOrderEditForm.workerColumn.text"));         //$NON-NLS-1$

        TableColumn carServComplexityColumn = new TableColumn(carServTable, SWT.NONE);
        carServComplexityColumn.setWidth(150);
        carServComplexityColumn.setText(Messages.getString("CarServOrderEditForm.carServComplexityColumn.text"));         //$NON-NLS-1$

        
        TableColumn workHourColumn = new TableColumn(carServTable, SWT.RIGHT);
        workHourColumn.setWidth(80);
        workHourColumn.setText(Messages.getString("CarServOrderEditForm.workHourColumn.text"));         //$NON-NLS-1$
        */
        
    }

    
    private void createCarServPanelRP(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carServTabItem = new TabItem(parent, SWT.NONE);
        carServTabItem.setText(Messages.getString("CarServOrderEditForm.carServTabItem.text")); //$NON-NLS-1$

         
        Table carServTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carServTable.setHeaderVisible(true);
        carServTable.setLinesVisible(true);
        carServTabItem.setControl(carServTable);

        type.setTable(carServTable);
   
        TableColumn tableColumn = new TableColumn(carServTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carServTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$
        
        TableColumn workHourColumn = new TableColumn(carServTable, SWT.RIGHT);
        workHourColumn.setWidth(80);
        workHourColumn.setText(Messages.getString("CarServOrderEditForm.workHourColumn.text"));         //$NON-NLS-1$
        
        TableColumn workerColumn = new TableColumn(carServTable, SWT.NONE);
        workerColumn.setWidth(200);
        workerColumn.setText(Messages.getString("CarServOrderEditForm.workerColumn.text"));         //$NON-NLS-1$

        TableColumn noteColumn = new TableColumn(carServTable, SWT.NONE);
        noteColumn.setWidth(200);
        noteColumn.setText(Messages.getString("CarServOrderEditForm.noteColumn.text"));         //$NON-NLS-1$

    }


    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CAR PART PANEL
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void createCarPartPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carPartTabItem = new TabItem(parent, SWT.NONE);
        carPartTabItem.setText(Messages.getString("CarServOrderEditForm.carPartTabItem.text")); //$NON-NLS-1$

         
        Table carPartTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carPartTable.setHeaderVisible(true);
        carPartTable.setLinesVisible(true);
        carPartTabItem.setControl(carPartTable);

        type.setTable(carPartTable);
        
        TableColumn tableColumn = new TableColumn(carPartTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPartTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carPartTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carPartTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPartTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyBasePriceColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyBasePriceColumn.setWidth(80);
        currencyBasePriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyBasePriceColumn.text")); //$NON-NLS-1$

        TableColumn pricePercentColumn = new TableColumn(carPartTable, SWT.RIGHT);
        pricePercentColumn.setWidth(80);
        pricePercentColumn.setText(Messages.getString("CarServOrderEditForm.pricePercentColumn.text")); //$NON-NLS-1$

        
        TableColumn currencyPriceColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
        
    }
    

    
    
    private void createCarPartPanelRP(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carPartTabItem = new TabItem(parent, SWT.NONE);
        carPartTabItem.setText(Messages.getString("CarServOrderEditForm.carPartTabItem.text")); //$NON-NLS-1$

         
        Table carPartTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carPartTable.setHeaderVisible(true);
        carPartTable.setLinesVisible(true);
        carPartTabItem.setControl(carPartTable);

        type.setTable(carPartTable);
        
        TableColumn tableColumn = new TableColumn(carPartTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPartTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carPartTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carPartTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPartTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        
        TableColumn supplierColumn = new TableColumn(carPartTable, SWT.LEFT);
        supplierColumn.setWidth(100);
        supplierColumn.setText(Messages.getString("CarServOrderEditForm.supplierColumn.text")); //$NON-NLS-1$

        TableColumn docNumberColumn = new TableColumn(carPartTable, SWT.LEFT);
        docNumberColumn.setWidth(100);
        docNumberColumn.setText(Messages.getString("CarServOrderEditForm.docNumberColumn.text")); //$NON-NLS-1$

        TableColumn responsibleColumn = new TableColumn(carPartTable, SWT.LEFT);
        responsibleColumn.setWidth(100);
        responsibleColumn.setText(Messages.getString("CarServOrderEditForm.responsibleColumn.text")); //$NON-NLS-1$

        
        
        
        TableColumn noteColumn = new TableColumn(carPartTable, SWT.NONE);
        noteColumn.setWidth(200);
        noteColumn.setText(Messages.getString("CarServOrderEditForm.noteColumn.text"));         //$NON-NLS-1$

    }

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CAR MATERIAL PANEL
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void createCarMaterialPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carMaterialTabItem = new TabItem(parent, SWT.NONE);
        carMaterialTabItem.setText(Messages.getString("CarServOrderEditForm.carMaterialTabItem.text")); //$NON-NLS-1$

         
        Table carMaterialTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carMaterialTable.setHeaderVisible(true);
        carMaterialTable.setLinesVisible(true);
        carMaterialTabItem.setControl(carMaterialTable);

        type.setTable(carMaterialTable);
   
        TableColumn tableColumn = new TableColumn(carMaterialTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carMaterialTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carMaterialTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyBasePriceColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        currencyBasePriceColumn.setWidth(80);
        currencyBasePriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyBasePriceColumn.text")); //$NON-NLS-1$

        TableColumn pricePercentColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        pricePercentColumn.setWidth(80);
        pricePercentColumn.setText(Messages.getString("CarServOrderEditForm.pricePercentColumn.text")); //$NON-NLS-1$

        
        TableColumn currencyPriceColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
        
    }
    

    private void createCarMaterialPanelRP(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carMaterialTabItem = new TabItem(parent, SWT.NONE);
        carMaterialTabItem.setText(Messages.getString("CarServOrderEditForm.carMaterialTabItem.text")); //$NON-NLS-1$

         
        Table carMaterialTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carMaterialTable.setHeaderVisible(true);
        carMaterialTable.setLinesVisible(true);
        carMaterialTabItem.setControl(carMaterialTable);

        type.setTable(carMaterialTable);
   
        TableColumn tableColumn = new TableColumn(carMaterialTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carMaterialTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carMaterialTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carMaterialTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn noteColumn = new TableColumn(carMaterialTable, SWT.NONE);
        noteColumn.setWidth(200);
        noteColumn.setText(Messages.getString("CarServOrderEditForm.noteColumn.text"));         //$NON-NLS-1$
        
        
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CAR PAINT PANEL
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void createCarPaintPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carPaintTabItem = new TabItem(parent, SWT.NONE);
        carPaintTabItem.setText(Messages.getString("CarServOrderEditForm.carPaintTabItem.text")); //$NON-NLS-1$

         
        Table carPaintTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carPaintTable.setHeaderVisible(true);
        carPaintTable.setLinesVisible(true);
        carPaintTabItem.setControl(carPaintTable);

        type.setTable(carPaintTable);
   
        TableColumn tableColumn = new TableColumn(carPaintTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPaintTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carPaintTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyBasePriceColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        currencyBasePriceColumn.setWidth(80);
        currencyBasePriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyBasePriceColumn.text")); //$NON-NLS-1$

        TableColumn pricePercentColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        pricePercentColumn.setWidth(80);
        pricePercentColumn.setText(Messages.getString("CarServOrderEditForm.pricePercentColumn.text")); //$NON-NLS-1$

        
        TableColumn currencyPriceColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
     

    }

    
    private void createCarPaintPanelRP(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carPaintTabItem = new TabItem(parent, SWT.NONE);
        carPaintTabItem.setText(Messages.getString("CarServOrderEditForm.carPaintTabItem.text")); //$NON-NLS-1$

         
        Table carPaintTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carPaintTable.setHeaderVisible(true);
        carPaintTable.setLinesVisible(true);
        carPaintTabItem.setControl(carPaintTable);

        type.setTable(carPaintTable);
   
        TableColumn tableColumn = new TableColumn(carPaintTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPaintTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carPaintTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPaintTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn noteColumn = new TableColumn(carPaintTable, SWT.NONE);
        noteColumn.setWidth(200);
        noteColumn.setText(Messages.getString("CarServOrderEditForm.noteColumn.text"));         //$NON-NLS-1$

        
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // SPECIAL DETAIL PANEL. LIKE PART PANEL
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    private void createCarDetailPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem carPartTabItem = new TabItem(parent, SWT.NONE);
        carPartTabItem.setText(Messages.getString("CarServOrderEditForm.carDetailTabItem.text")); //$NON-NLS-1$

         
        Table carPartTable = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        carPartTable.setHeaderVisible(true);
        carPartTable.setLinesVisible(true);
        carPartTabItem.setControl(carPartTable);

        type.setTable(carPartTable);
        
        TableColumn tableColumn = new TableColumn(carPartTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPartTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPartTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$

        
        
        TableColumn damageLevelReplaceColumn = new TableColumn(carPartTable, SWT.CENTER);
        damageLevelReplaceColumn.setWidth(50);
        damageLevelReplaceColumn.setText(Messages.getString("CarServOrderEditForm.damageLevelReplaceColumn.text")); //$NON-NLS-1$

        TableColumn damageLevel1Column = new TableColumn(carPartTable, SWT.CENTER);
        damageLevel1Column.setWidth(50);
        damageLevel1Column.setText("1");

        TableColumn damageLevel2Column = new TableColumn(carPartTable, SWT.CENTER);
        damageLevel2Column.setWidth(50);
        damageLevel2Column.setText("2");

        TableColumn damageLevel3Column = new TableColumn(carPartTable, SWT.CENTER);
        damageLevel3Column.setWidth(50);
        damageLevel3Column.setText("3");
        

        //
        
        TableColumn serviceTypePNTColumn = new TableColumn(carPartTable, SWT.CENTER);
        serviceTypePNTColumn.setWidth(50);
        serviceTypePNTColumn.setText(Messages.getString("CarServOrderEditForm.serviceTypePNTColumn.text"));
        
        TableColumn serviceTypeMATColumn = new TableColumn(carPartTable, SWT.CENTER);
        serviceTypeMATColumn.setWidth(50);
        serviceTypeMATColumn.setText(Messages.getString("CarServOrderEditForm.serviceTypeMATColumn.text"));

        TableColumn serviceTypePOLColumn = new TableColumn(carPartTable, SWT.CENTER);
        serviceTypePOLColumn.setWidth(50);
        serviceTypePOLColumn.setText(Messages.getString("CarServOrderEditForm.serviceTypePOLColumn.text"));

        /////
        
        /*
        TableColumn tableColumn = new TableColumn(carPartTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(carPartTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(carPartTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarServOrderEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(carPartTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarServOrderEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(carPartTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarServOrderEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        TableColumn currencyBasePriceColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyBasePriceColumn.setWidth(80);
        currencyBasePriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyBasePriceColumn.text")); //$NON-NLS-1$

        TableColumn pricePercentColumn = new TableColumn(carPartTable, SWT.RIGHT);
        pricePercentColumn.setWidth(80);
        pricePercentColumn.setText(Messages.getString("CarServOrderEditForm.pricePercentColumn.text")); //$NON-NLS-1$

        
        TableColumn currencyPriceColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarServOrderEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
        TableColumn currencyTaxAmountColumn = new TableColumn(carPartTable, SWT.RIGHT);
        currencyTaxAmountColumn.setWidth(80);
        currencyTaxAmountColumn.setText(Messages.getString("CarServOrderEditForm.currencyTaxAmountColumn.text"));         //$NON-NLS-1$
        */
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // PAINT TYPE
    // IT IS NOT PAINT !!!
    
    /*
    private void createCarPaintTypeDetailPanel(TabFolder parent, ComplexTableEntityProvider type) {
	 
        TabItem tabItem = new TabItem(parent, SWT.NONE);
        tabItem.setText(Messages.getString("CarServOrderEditForm.carPaintTabItem.text")); //$NON-NLS-1$

         
        Table table = new Table(parent, SWT.MULTI | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        tabItem.setControl(table);

        type.setTable(table);
   
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(table, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarServOrderEditForm.productNameColumn.text")); //$NON-NLS-1$
        
    }
    */
    
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
    	currencyTotalLabel.setText(Messages.getString("CarServOrderEditForm.currencyTotalLabel.text")); //$NON-NLS-1$

    	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalField.setLayoutData(gridData);
    	
    

    	currencyTaxTotalLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	currencyTaxTotalLabel.setLayoutData(gridData);
    	currencyTaxTotalLabel.setText(Messages.getString("CarServOrderEditForm.currencyTaxTotalLabel.text")); //$NON-NLS-1$

    	currencyTaxTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTaxTotalField.setLayoutData(gridData);
    	

    	currencyTotalWithTaxLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	gridData.horizontalIndent = 20;
    	currencyTotalWithTaxLabel.setLayoutData(gridData);
    	currencyTotalWithTaxLabel.setText(Messages.getString("CarServOrderEditForm.currencyTotalWithTaxLabel.text")); //$NON-NLS-1$

    	currencyTotalWithTaxField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalWithTaxField.setLayoutData(gridData);
    	
    	
    	///---
    	initNoEditableField(currencyTotalField);
    	initNoEditableField(currencyTaxTotalField);
    	initNoEditableField(currencyTotalWithTaxField);
    }
    
    
    
 
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Car Service provider
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected class CarServItemProvider extends ComplexTableEntityProvider {
	
	public CarServItemProvider(CarServOrderInventory inventory) {
	    super(inventory);
	    
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairServiceItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("serviceItems");
	    }
	    
	    setAddMethod("addServiceItem", ProductDocumentItem.class);
	    setEntityFormClass(CarServOrderItemServiceEditForm.class);
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}

	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    
	    //bindColumn(2, "unitName");
	    //bindColumn(3, "unitRate", getCoefficientFormat());
	    
	    bindColumn(2, "quantity", getQuantityFormat());
	    
	    bindColumn(3, "enterCurrencyBasePrice", getCurrencyFormat());
	    bindColumn(4, "pricePercent", getCurrencyFormat());
	    
	    bindColumn(5, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(6, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(7, "currencyTaxAmount", getCurrencyFormat());
	    
	    //bindColumn(10, "workerName");
	    //bindColumn(11, "carServComplexityName");
	    //bindColumn(12, "workHour", getCurrencyFormat());
	}
    }
    
    // ONLY FOR REPAIR
    protected class CarServItemProviderRP extends ComplexTableEntityProvider {
	
	public CarServItemProviderRP(CarServOrderInventory inventory) {
	    super(inventory);
	    
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairServiceItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("serviceItems");
	    }
	    setAddMethod("addServiceItem", ProductDocumentItem.class);
	    setEntityFormClass(CarServOrderItemServiceEditFormRP.class);
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}

	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    //bindColumn(2, "workHour", getCurrencyFormat());
	    bindColumn(2, "quantity", getQuantityFormat());
	    bindColumn(3, "workerName");
	    bindColumn(4, "note");
	    
	}
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Car Part provider
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected class CarPartItemProvider extends ComplexTableEntityProvider {
	
	public CarPartItemProvider(CarServOrderInventory inventory) {
	    super(inventory);
	    
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairPartItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("partItems");
	    }
	    setAddMethod("addPartItem", ProductDocumentItem.class);
	}
	
	protected IEditForm createEditForm(Class formClass) {
	    IEditForm editForm = super.createEditForm(formClass);
	    if (editForm != null) {
		editForm.setData("entity.type", CarPart.CLASS_ID);
	    }
	    return editForm;
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    
	    bindColumn(5, "enterCurrencyBasePrice", getCurrencyFormat());
	    bindColumn(6, "pricePercent", getCurrencyFormat());
	    
	    bindColumn(7, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(8, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(9, "currencyTaxAmount", getCurrencyFormat());
	}
    }
    

    // ONLY FOR REPAIR
    protected class CarPartItemProviderRP extends ComplexTableEntityProvider {
	
	public CarPartItemProviderRP(CarServOrderInventory inventory) {
	    super(inventory);
	    
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairPartItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("partItems");
	    }
	    setAddMethod("addPartItem", ProductDocumentItem.class);
	    setEntityFormClass(CarServOrderItemPartEditFormRP.class);
	}
	
	protected IEditForm createEditForm(Class formClass) {
	    IEditForm editForm = super.createEditForm(formClass);
	    if (editForm != null) {
		editForm.setData("entity.type", CarPart.CLASS_ID);
	    }
	    return editForm;
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    
	    bindColumn(5, "supplierName");
	    bindColumn(6, "documentTitle");
	    bindColumn(7, "responsibleName");
	    
	    
	    bindColumn(8, "note");
	}
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Car Material provider
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected class CarMaterialItemProvider extends ComplexTableEntityProvider {
	
	public CarMaterialItemProvider(CarServOrderInventory inventory) {
	    super(inventory);

	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairMaterialItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("materialItems");
	    }
	    setAddMethod("addMaterialItem", ProductDocumentItem.class);
	    
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    
	    bindColumn(5, "enterCurrencyBasePrice", getCurrencyFormat());
	    bindColumn(6, "pricePercent", getCurrencyFormat());
	    
	    bindColumn(7, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(8, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(9, "currencyTaxAmount", getCurrencyFormat());
	}
    }

    // ONLY FOR REPAIR
    protected class CarMaterialItemProviderRP extends ComplexTableEntityProvider {
	
	public CarMaterialItemProviderRP(CarServOrderInventory inventory) {
	    super(inventory);

	    setEntityClass(CarServOrderItem.class); // FORM ID
	    setParentEntityClass(CarServOrder.class); // OWNER
	    setListProperty("repairMaterialItems");

		
	    /*
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairMaterialItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("materialItems");
	    }
	    */
	    
	    
	    setAddMethod("addMaterialItem", ProductDocumentItem.class);
	    setEntityFormClass(CarServOrderItemMaterialEditFormRP.class);
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    bindColumn(5, "note");
	    
	}
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Car Paint provider
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected class CarPaintItemProvider extends ComplexTableEntityProvider {
	
	public CarPaintItemProvider(CarServOrderInventory inventory) {
	    super(inventory);

	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairPaintItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("paintItems");
	    }
	    setAddMethod("addPaintItem", ProductDocumentItem.class);

	}
	
	protected IEditForm createEditForm(Class formClass) {
	    IEditForm editForm = super.createEditForm(formClass);
	    if (editForm != null) {
		editForm.setData("entity.type", CarPaint.CLASS_ID);
	    }
	    return editForm;
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    
	    bindColumn(5, "enterCurrencyBasePrice", getCurrencyFormat());
	    bindColumn(6, "pricePercent", getCurrencyFormat());
	    
	    bindColumn(7, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(8, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(9, "currencyTaxAmount", getCurrencyFormat());
	}
    }
    

    // ONLY FOR REPAIR
    protected class CarPaintItemProviderRP extends ComplexTableEntityProvider {
	
	public CarPaintItemProviderRP(CarServOrderInventory inventory) {
	    super(inventory);

	    setEntityClass(CarServOrderItem.class); // FORM ID
	    setParentEntityClass(CarServOrder.class); // OWNER
	    setListProperty("repairPaintItems");
	    
	    
	    /*
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairPaintItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("paintItems");
	    }
	    */
	    
	    
	    
	    setAddMethod("addPaintItem", ProductDocumentItem.class);
	    setEntityFormClass(CarServOrderItemPaintEditFormRP.class);
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    bindColumn(5, "note");
	}
    }

    
    
    
    
    
    
    // PAINT TYPE: DISABLE. MUST USE CarPaintItemProvider
    
    /*
    protected class CarPaintTypeItemProvider extends ComplexTableEntityProvider {
	
	public CarPaintTypeItemProvider(CarServOrderInventory inventory) {
	    super(inventory);

	    setEntityClass(CarServOrderPaintType.class); // FORM ID
	    setParentEntityClass(CarServOrderInventory.class); // OWNER
	    setListProperty("paintTypes");
	    setAddMethod("addPaintType", CarServOrderPaintType.class);
	}
	
	public Object getParentEntity() {
	    return getInventory();
	}
	
	protected void bindTable() {
	    bindColumn(1, "carPaintTypeName");
	}
    }
    */

    
    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Car Detail provider (ONLY FOR INVENTORY (OPIS). WE DON'T USE IT FOR REPAIR)
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    protected class CarDetailItemProvider extends ComplexTableEntityProvider {
	
	public CarDetailItemProvider(CarServOrderInventory inventory) {
	    super(inventory);
	    
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    if (inventory == null) {
		setParentEntityClass(CarServOrder.class); // OWNER
		setListProperty("repairPartItems");
	    } else {
		setParentEntityClass(CarServOrderInventory.class); // OWNER
		setListProperty("partItems");
	    }
	    
	    setEntityFormClass(CarServOrderItemDetailEditForm.class);
	    setAddMethod("addPartItem", ProductDocumentItem.class);
	}
	
	protected IEditForm createEditForm(Class formClass) {
	    IEditForm editForm = super.createEditForm(formClass);
	    if (editForm != null) {
		editForm.setData("entity.type", CarPart.CLASS_ID);
	    }
	    return editForm;
	}
	
	public Object getParentEntity() {
	    return getInventory() == null ? super.getParentEntity() : getInventory();
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "quantity", getQuantityFormat());
	    bindColumn(3, "damageLevelReplace");
	    bindColumn(4, "damageLevel1");
	    bindColumn(5, "damageLevel2");
	    bindColumn(6, "damageLevel3");
	    
	    bindColumn(7, "pnt");
	    bindColumn(8, "mat");
	    bindColumn(9, "pol");	    

	}
    }

    
    
    


    protected class ComplexTableEntityProvider extends TableEntityProvider {
	
	private CarServOrderInventory inventory;
	
	
	private Table table;
    
	public ComplexTableEntityProvider(CarServOrderInventory inventory) {
	    super();
	    this.inventory = inventory;
	}

	protected Table getTable() {
	    return table;
	}

	protected void setTable(Table table) {
	    this.table = table;
	}

	public CarServOrderInventory getInventory() {
	    return inventory;
	}

	
    }
    
    /*
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemType() {
	    setParentEntityClass(CarServOrder.class); // OWNER
	    setEntityClass(CarServOrderItem.class); // FORM ID
	    initProductItemType(this);
	}
	
	protected Table getTable() {
	    return productTable;
	}
	
	protected void mapTable() {
	    bindColumn(1, "detailProductName");
	    bindColumn(2, "unitName");
	    bindColumn(3, "unitRate", getCoefficientFormat());
	    bindColumn(4, "quantity", getQuantityFormat());
	    
	    bindColumn(5, "enterCurrencyBasePrice", getCurrencyFormat());
	    bindColumn(6, "pricePercent", getCurrencyFormat());
	    
	    bindColumn(7, "enterCurrencyPrice", getCurrencyFormat());
	    bindColumn(8, "enterCurrencyAmount", getCurrencyFormat());
	    bindColumn(9, "currencyTaxAmount", getCurrencyFormat());
	}
    }
    */

    
    protected Object getSelectedEntityProviderKey() {
        int index = getSelectedItemPanelType().getTabFolder().getSelectionIndex();
        return getSelectedItemPanelType().getTabFolder().getItem(index);
    }
    
    protected void updateAmountControls() {
	currencyTotalField.updateView();
	currencyTaxTotalField.updateView();
	currencyTotalWithTaxField.updateView();
    }
  
    private CarServOrder getCarServOrder() {
        return (CarServOrder) getEntity();
    }
    
    protected void initData() throws ApplicationException {
        super.initData();
        getCarServOrder().setPartner(EnterpriseEnvironment.getCustomer());
        getCarServOrder().setMtrlResponsible(EnterpriseEnvironment.getMtrlResponsible());
        getCarServOrder().setWarehouse(EnterpriseEnvironment.getOutcomeWharehouse());
        
        // Normalize damages
        getCarServOrder().normalizeDamages();
        
        Date date = getCarServOrder().getDocumentDate();
        if (date != null && getCarServOrder().getFirstInventory() != null) {
            getCarServOrder().getFirstInventory().setInventoryDate(date);
        }
        
    } 

    protected XComboEdit getCurrencyField() {
	return this.currencyField;
    }
    
    private boolean isLoadData = false;
    
    public void updateForm() throws ApplicationException {
	
	
	// Normalize damages
	getCarServOrder().normalizeDamages();
	
	// SET PARTNER TO FROM
	partner = getCarServOrder().getPartner();
	
	// Create tab folders of top level
	createTabFolders(topTabFolder);
	
	super.updateForm();
	
	List<PanelType> damagePanels = getDamagePanels();
	for (PanelType damagePanel : damagePanels) {
	    updateDamagePanel(damagePanel);
	    List<PanelType> inventoryPanels = damagePanel.getChildren();
	    for (PanelType inventoryPanel : inventoryPanels) {
		updateInventoryPanel(inventoryPanel);
	    }
	}
	
	
	isLoadData = true;
	
	if (isDocumentCodeReadOnly()) {
	    initNoEditableField(documentNoField);
	}
	
	if (isDocumentDateReadOnly()) {
	    initNoEditableField(documentDateField);
	}
	
	/*
	ImageStorageImpl storage = new ImageStorageImpl();
	ImageEntryImpl data = new ImageEntryImpl();
	data.setName("Photo 1");
	data.setBinaryData(new byte[] {1,2,3});
	storage.addImage(data);
	*/

	
	ImageStorage incomeStorage = createImageStorage(getCarServOrder(), CarServOrderImage.INCOME_TYPE);
	incomeImagePanel.setImageStorage(incomeStorage);
	
	ImageStorage outcomeStorage = createImageStorage(getCarServOrder(), CarServOrderImage.OUTCOME_TYPE);
	outcomeImagePanel.setImageStorage(outcomeStorage);
	
	
	Car car = (Car) carField.getValue();
	updateRepresentatives(car);
    }
    
    
    public void updateData() throws ApplicationException {
	
	
	super.updateData();

	// SET PARTNER TO DATA
	getCarServOrder().setPartner(partner);

	List<PanelType> damagePanels = getDamagePanels();
	for (PanelType damagePanel : damagePanels) {
	    updateDamageData(damagePanel);
	    List<PanelType> inventoryPanels = damagePanel.getChildren();
	    for (PanelType inventoryPanel : inventoryPanels) {
		updateInventoryData(inventoryPanel);
	    }
	}
	
    }
    
    private void updateDamagePanel(PanelType damagePanel) {
	CarServOrderDamage damage = (CarServOrderDamage) damagePanel.getData();
	if (damage == null) {
	    return;
	}

	XTextField codeField = (XTextField) damagePanel.getData("damageCodeField");
	if (codeField != null) {
	    codeField.setValue(damage.getDamageCode() == null ? "" : damage.getDamageCode());
	}

	XDateCombo dateField = (XDateCombo) damagePanel.getData("damageDateField");
	if (dateField != null) {
	    dateField.setDate(damage.getDamageDate());
	}
	
	XComboEdit insurerField = (XComboEdit) damagePanel.getData("insurerField");
	if (insurerField != null) {
	    insurerField.setValue(damage.getInsurer());
	}

	XComboEdit brokerField = (XComboEdit) damagePanel.getData("brokerField");
	if (brokerField != null) {
	    brokerField.setValue(damage.getBroker());
	}

	XComboEdit carClassField = (XComboEdit) damagePanel.getData("carClassField");
	if (carClassField != null) {
	    carClassField.setValue(damage.getCarClass());
	}
	
	// Special panel (Invoice)
	XCurrencyField currencyTotalAmountField = (XCurrencyField) damagePanel.getData("currencyTotalAmountField");
	if (currencyTotalAmountField != null) {
	    currencyTotalAmountField.setValue(damage.getCurrencyTotalAmount());
	}
	
    }
    
    private void updateInventoryPanel(PanelType inventoryPanel) {
	CarServOrderInventory inventory = (CarServOrderInventory) inventoryPanel.getData();
	if (inventory == null) {
	    return;
	}
	
	XDateCombo dateField = (XDateCombo) inventoryPanel.getData("inventoryDateField");
	if (dateField != null) {
	    dateField.setDate(inventory.getInventoryDate());
	}

	XComboEdit carPaintTypeField = (XComboEdit) inventoryPanel.getData("carPaintTypeField");
	if (carPaintTypeField != null) {
	    carPaintTypeField.setValue(inventory.getCarPaintType());
	}
	
    }
    

    private void updateDamageData(PanelType damagePanel) {
	CarServOrderDamage damage = (CarServOrderDamage) damagePanel.getData();
	if (damage == null) {
	    return;
	}

	XTextField codeField = (XTextField) damagePanel.getData("damageCodeField");
	if (codeField != null) {
	    damage.setDamageCode(codeField.getText());
	}

	XDateCombo dateField = (XDateCombo) damagePanel.getData("damageDateField");
	if (dateField != null) {
	    damage.setDamageDate(dateField.getDate());
	}
	
	XComboEdit insurerField = (XComboEdit) damagePanel.getData("insurerField");
	if (insurerField != null) {
	    damage.setInsurer((IPartnerTitle) insurerField.getValue());
	}

	XComboEdit brokerField = (XComboEdit) damagePanel.getData("brokerField");
	if (brokerField != null) {
	    damage.setBroker((IPartnerTitle) brokerField.getValue());
	}

	XComboEdit carClassField = (XComboEdit) damagePanel.getData("carClassField");
	if (carClassField != null) {
	    damage.setCarClass((CarClass) carClassField.getValue());
	}

	
	// Special panel (Invoice)
	XCurrencyField currencyTotalAmountField = (XCurrencyField) damagePanel.getData("currencyTotalAmountField");
	if (currencyTotalAmountField != null) {
	    damage.setCurrencyTotalAmount(currencyTotalAmountField.doubleValue());
	}

    }
    
    private void updateInventoryData(PanelType inventoryPanel) {
	CarServOrderInventory inventory = (CarServOrderInventory) inventoryPanel.getData();
	if (inventory == null) {
	    return;
	}
	
	XDateCombo dateField = (XDateCombo) inventoryPanel.getData("inventoryDateField");
	if (dateField != null) {
	    inventory.setInventoryDate(dateField.getDate());
	}

	
	XComboEdit carPaintTypeField = (XComboEdit) inventoryPanel.getData("carPaintTypeField");
	if (carPaintTypeField != null) {
	    inventory.setCarPaintType((CarPaintType) carPaintTypeField.getValue());
	}

    }

    protected List<PanelType> getDamagePanels() {
	return getRootDamageType().getChildren();
    }

    protected List<PanelType> getInventoryPanels(PanelType damageType) {
	if (damageType == null) {
	    return null;
	}
	return damageType.getChildren();
    }
    
    protected PanelType getDamagePanel(CarServOrderDamage damage) {
	if (damage == null) {
	    return null;
	}
	List<PanelType> types = getDamagePanels();
	if (types == null) {
	    return null;
	}
	for (PanelType damageType : types) {
	    if (damage == damageType.getData()) {
		return damageType;
	    }
	}
	return null;
    }
    
    /**
     * Create tab folder of top level: Repair, Damages
     * @param parentTabFolder
     */
    protected void createTabFolders(TabFolder parentTabFolder) {

	TabItem tabItem = null;
	PanelType panelType = null;

	///////////////////////////////////////////////////////////////////////////////////////////////////
	// Repair car folder
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//tabItem = createTabItem(parentTabFolder, REPAIR_FOLDER_TEXT);
	//panelType = createBodyItemPanel(parentTabFolder);
	//tabItem.setControl(panelType.getContainer());
	//selectedItemPanelType = panelType;

	//////////////////////////////////////////////////////////////////////////////////////////////////
	// 1. Damage folders
	//////////////////////////////////////////////////////////////////////////////////////////////////
	PanelType inventoryType = null;
	PanelType rootType = getRootDamageType();
	
	//List<CarServOrderDamage> damages = getCarServOrder().getDamageList();
	List<CarServOrderDamage> damages = getCarServOrder().getSimpleDamageList();
	
	int damageIndex = 0;
	PanelType damageType = null;
	for (CarServOrderDamage damage : damages) {

	    // Damage folder
	    damageIndex++;
	    damageType = createDamageFolder(rootType, parentTabFolder, damage, damageIndex);
	    createDamageInventoryFolders(damageType, damage); // NEW*
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// 2. Additional Repair car folder
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	CarServOrderDamage additionalRepair = getCarServOrder().getAdditionalRepair();
	if (additionalRepair != null) {
	    damageType = createDamageFolder(rootType, parentTabFolder, additionalRepair, -1);
	    createDamageInventoryFolders(damageType, additionalRepair); // NEW*
	}

	    
	selectedItemPanelType = null; //inventoryType;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// 3. Repair car folder
	///////////////////////////////////////////////////////////////////////////////////////////////////
	tabItem = createTabItem(parentTabFolder, REPAIR_FOLDER_TEXT);
	panelType = createBodyItemPanel(parentTabFolder);
	tabItem.setControl(panelType.getContainer());
	
	selectedItemPanelType = panelType; // FIX 2008-10-22 !!!

    }
    
    protected PanelType createDamageFolder(PanelType rootType, TabFolder parentTabFolder, CarServOrderDamage damage, int damageIndex) {
	String title = damage.isAdditionalRepair() ? ADDITIONAL_REPAIR_FOLDER_TEXT: DAMAGE_FOLDER_TEXT + " " + damageIndex; 
	TabItem tabItem = createTabItem(parentTabFolder, title, damageIndex - 1);
	PanelType damageType = createDamagePanel(parentTabFolder, damage);
	rootType.addChild(damageType);
	tabItem.setControl(damageType.getContainer());
	tabItem.setData("type", damageType);
	damageType.setTabItem(tabItem);
	return damageType;
    }

    protected PanelType[] createDamageInventoryFolders(PanelType damageType, CarServOrderDamage damage) {
	PanelType inventoryType = null;
	List<CarServOrderInventory> inventories = damage.getSimpleInventoryList();
	List<PanelType> inventoryTypes = new ArrayList<PanelType>();
	int inventoryIndex = 0;
	
	// 1. Add inventory folders 
	for (CarServOrderInventory inventory : inventories) {
	    
	    // Inventory folder
	    inventoryIndex++;
	    inventoryType = createInventoryFolder(damageType, damageType.getTabFolder(), inventory, inventoryIndex);
	    inventoryTypes.add(inventoryType);
	}

	// 2. Add total inventory (PROFORM F.)
	CarServOrderInventory totalInventory = damage.getTotalInventory();
	if (totalInventory != null) {
	    inventoryType = createInventoryFolder(damageType, damageType.getTabFolder(), totalInventory, -1);
	    inventoryTypes.add(inventoryType);
	    damageType.setData("totalInventoryType", inventoryType);
	}

	// 3. Invoice Folder (F.-RE)
	// Invoice folder has not own PanelType
	// It is GUI folder
	createInvoiceFolder(damageType, damageType.getTabFolder(), damage);
	
	
	return inventoryTypes.toArray(new PanelType[0]);
    }

    protected PanelType createInventoryFolder(PanelType damageType, TabFolder parentTabFolder, CarServOrderInventory inventory, int inventoryIndex) {
	
	String title = null;
	
	CarServOrderDamage damage = inventory.getDamage();
	if (damage != null && damage.isAdditionalRepair() && !inventory.isTotalInventory()) {
	    title = INVENTORY_FOLDER_TEXT;
	}
	
	if (title == null) {
	    title = inventory.isTotalInventory() ? TOTAL_INVENTORY_FOLDER_TEXT: INVENTORY_FOLDER_TEXT + " " + inventoryIndex;
	}
	
	
	
	//TabItem tabItem  = createTabItem(parentTabFolder, INVENTORY_FOLDER_TEXT + " " + inventoryIndex);
	TabItem tabItem  = createTabItem(parentTabFolder, title, inventoryIndex - 1);
	PanelType inventoryType = createInventoryPanel(parentTabFolder, inventory);
	damageType.addChild(inventoryType);
	tabItem.setControl(inventoryType.getContainer());
	tabItem.setData("type", inventoryType);
	inventoryType.setTabItem(tabItem);
	return inventoryType;
    }
    

    protected PanelType createInvoiceFolder(PanelType damageType, TabFolder parentTabFolder, CarServOrderDamage damage) {
	TabItem tabItem  = createTabItem(parentTabFolder, INVOICE_FOLDER_TEXT);
	
	
	Composite invoicePanel = createInvoicePanel(parentTabFolder, damageType, damage);
	tabItem.setControl(invoicePanel);
	
	// Invoice folder has not own PanelType
	// It is GUI folder
	return null;
    }
    
    
    private Composite createInvoicePanel(Composite parent, PanelType damageType, CarServOrderDamage damage) {

	GridLayout gridLayout;

	GridData gridData = null;
	
	int COLUMN_COUNT = 2;
	
	Composite panel = new Composite(parent, SWT.NONE);
	gridLayout = new GridLayout();
	
	gridLayout.verticalSpacing = 0;
	gridLayout.marginWidth = 0;
	gridLayout.marginHeight = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.numColumns = COLUMN_COUNT;

	panel.setLayout(gridLayout);
	int leftMargin = 5;
	int topMargin = 5;

	
	// ========================================================================================================
	// ROW 1
	// ========================================================================================================
	
	Label label = null;
	XCurrencyField currencyTotalAmountField = null;
	
	//// CURRENCY TOTAL AMOUNT
	label = new Label(panel, SWT.NONE);
	label.setText(Messages.getString("CarServOrderEditForm.invoiceItem.currencyTotalAmountLabel.text"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = LABEL_WIDTH;
	label.setLayoutData(gridData);
	
	currencyTotalAmountField = new XCurrencyField(panel, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.verticalIndent = topMargin;
	gridData.horizontalIndent = leftMargin;
	gridData.widthHint = FIELD_WIDTH;
	currencyTotalAmountField.setLayoutData(gridData);
	initNoEditableField(currencyTotalAmountField);
	
	// END ROWS

	
	damageType.setData("currencyTotalAmountField", currencyTotalAmountField);
	
	return panel;

    }

    
    protected void addDamageFolder() {
	TabFolder parent = topTabFolder;
	PanelType rootType = getRootDamageType();
	addDamageFolder(rootType, parent);
    }
    
    //777
    protected void addDamageFolder(PanelType rootType, TabFolder parentTabFolder) {
	
	int count = getCarServOrder().getSimpleDamageCount(); // rootType.getChildren().size();
	if (count + 1 > MAX_DAMAGE_COUNT) {
	    openMessageDialog(MAX_DAMAGE_COUNT_MESSAGE + " " + MAX_DAMAGE_COUNT);
	    return;
	}

	CarServOrderDamage damage = getCarServOrder().addEmptyDamage();
	//int damageIndex = getCarServOrder().getDamageList().size();
	int damageIndex = getCarServOrder().getSimpleDamageCount();
	PanelType damageType = createDamageFolder(rootType, parentTabFolder, damage, damageIndex);

	createDamageInventoryFolders(damageType, damage); // NEW*
    }

    
    protected void addInventoryFolder() {
	TabFolder parent = topTabFolder;
	PanelType damageType = getSelectedDamageType();
	addInventoryFolder(damageType, parent);
    }

    protected void addInventoryFolder(PanelType damageType, TabFolder parentTabFolder) {
	if (damageType == null || damageType.getData() == null) {
	    return;
	}
	if (!(damageType.getData() instanceof CarServOrderDamage)) {
	    return;
	}
	CarServOrderDamage damage = (CarServOrderDamage) damageType.getData();
	CarServOrder order = damage.getCarServOrder();
	
	// Check additional repair
	if (order != null) {
	    if (order.isAdditionalRepair(damage)) {
		openMessageDialog("Can not add inventory to additional repair");
		return;
	    }
	}
	
	int count = damage.getSimpleInventoryCount(); //damageType.getChildren().size();
	
	if (count + 1 > MAX_INVENTORY_COUNT) {
	    openMessageDialog(MAX_INVENTORY_COUNT_MESSAGE + " " + MAX_INVENTORY_COUNT);
	    return;
	}
	
	CarServOrderInventory inventory = new CarServOrderInventory();
	damage.addInventory(inventory);
	
	//int inventoryIndex = damage.getInventoryList().size();
	int inventoryIndex = damage.getSimpleInventoryCount();
	PanelType p = createInventoryFolder(damageType, damageType.getTabFolder(), inventory, inventoryIndex);
	
    }


    ///////
    
    protected void removeDamageFolder(PanelType damageType) {
	if (damageType == null) {
	    return;
	}
	CarServOrder order = null;
	CarServOrderDamage damage = (CarServOrderDamage) damageType.getData();
	if (damage != null) {
	    order = (CarServOrder) damage.getCarServOrder();
	}
	
	if (order != null && order.isAdditionalRepair(damage)) {
	    openMessageDialog(DAMAGE_NOT_SELECTED_MESSAGE);
	    return;
	}
	
	if (order.getSimpleDamageCount() == 1) {
	    openMessageDialog(CANT_REMOVE_DAMAGE_MESSAGE);
	    return;
	}
	
	
	
	if (!openConfirmYesNoDialog(CONFIRM_REMOVE_DAMAGE_MESSAGE) ) {
	    return;
	}

	
	List<PanelType> inventoryTypes = damageType.getChildren();
	Iterator<PanelType> itr = inventoryTypes.iterator();
	while(itr.hasNext()) {
	    PanelType inventoryType = itr.next();
	    removeInventoryFolder(inventoryType, false);
	    itr.remove();
	}
	
	//// REMOVE DATA ////
	if (order != null) {
	    order.removeDamage(damage);
	}
	damageType.setData(null);
	
	//// REMOVE TREE MODEL ////	
	PanelType rootType = damageType.getParent();
	if (rootType != null) {
	    rootType.removeChild(damageType);
	}
	
	//// DISPOSE CONTROLS ////
	TabItem tabItem = damageType.getTabItem();
	Composite container = damageType.getContainer();
	if (container != null) {
	    container.dispose();
	}
	if (tabItem != null) {
	    tabItem.dispose();
	}
	
    }

    protected void removeInventoryFolder(PanelType inventoryType) {
	removeInventoryFolder(inventoryType, true);
    }
    
    
    protected void removeInventoryFolder(PanelType inventoryType, boolean isSingleRemove) {
	
	if (inventoryType == null) {
	    return;
	}
	
	// Get parent type
	PanelType damageType = inventoryType.getParent();
		
	if (isSingleRemove && damageType == null) {
	    openErrorDialog("Error", "Can not remove panel. The panel has not parent.");
	    return;
	}
	CarServOrderDamage damage = (CarServOrderDamage) damageType.getData();
	CarServOrderInventory inventory = (CarServOrderInventory) inventoryType.getData();
	
	if (isSingleRemove  && damage.isTotalInventory(inventory)) {
	    openMessageDialog(INVENTORY_NOT_SELECTED_MESSAGE);
	    return;
	}
	
	int count = 0;
	
	//count = damageType.getChildren().size();
	if (isSingleRemove /* && count == 1*/ ) {
	    count = damage.getSimpleInventoryCount();
	    if (count == 1) {
		// Single panel. We can not remove single panel
		openMessageDialog(CANT_REMOVE_INVENTORY_MESSAGE);
		return;
	    }
	}
	
	
	
	if (isSingleRemove && !openConfirmYesNoDialog(CONFIRM_REMOVE_INVENTORY_MESSAGE) ) {
	    return;
	}

	
	
	//// REMOVE DATA ////
	if (inventory != null) {
	    
	    //inventory.setDeletedAllProductItems();
	    inventory.setDeletedAllChildren(); // VERY IMPORTANT !!!
	    
	    //CarServOrderDamage damage = inventory.getDamage(); // NEW*
	    if (damage != null) {
		damage.removeInventory(inventory);
	    }
	    inventoryType.setData(null);
	}

	//// REMOVE TREE MODEL ////	
	
	if (isSingleRemove) {
	    damageType.removeChild(inventoryType);
	}
	
	//// DISPOSE CONTROLS ////
	TabItem tabItem = inventoryType.getTabItem();
	Composite container = inventoryType.getContainer();
	if (container != null) {
	    container.dispose();
	}
	if (tabItem != null) {
	    tabItem.dispose();
	}
    }

    
    protected void beforeSave() throws ApplicationException {
	super.beforeSave();
	
	// TODO
	getCarServOrder().denormalizeDamages();
	
    }

    public PanelType getRootDamageType() {
	if (rootDamageType == null) {
	    rootDamageType = new PanelType();
	}
        return rootDamageType;
    }
    
    
    private void updateRepresentative(XComboEdit representativeField, XTextField phoneField) {
	if (!isLoadData) {
	    return;
	}
	PartnerRepresentative partenrRepresentative  = (PartnerRepresentative) representativeField.getValue();
	String phone = partenrRepresentative == null ? "" : partenrRepresentative.getPhone();
	if (phone == null) {
	    phone = "";
	}
	phoneField.setText(phone);
    }

    public IPartnerTitle getPartner() {
        return partner;
    }
    
    
    protected void afterModifyItem(Object item) throws ApplicationException {
	super.afterModifyItem(item);
	if (item == null || (!(item instanceof CarServOrderItem))) {
	    return;
	}
	afterModifyTotalInventoryItem((CarServOrderItem) item);
    }
    
    protected void afterModifyTotalInventoryItem(CarServOrderItem item) throws ApplicationException {
	if (item == null) {
	    return;
	}
	CarServOrderInventory inventory = item.getInventory();
	updateTotalAmount(inventory);
    }
    
    protected void updateTotalAmount(CarServOrderInventory inventory) throws ApplicationException {
	
	if (inventory == null || !inventory.isTotalInventory()) {
	    return;
	}
	CarServOrderDamage damage = inventory.getDamage();
	if (damage == null) {
	    return;
	}
	damage.calculateTotalAmount();
	
	PanelType damageType = getDamagePanel(damage);
	if (damageType == null) {
	    return;
	}
	
	XCurrencyField currencyTotalAmountField = (XCurrencyField) damageType.getData("currencyTotalAmountField");
	if (currencyTotalAmountField == null) {
	    return;
	}
	currencyTotalAmountField.setValue(damage.getCurrencyTotalAmount());
	
    }
    
    private ImageStorage createImageStorage(CarServOrder carServOrder, String recordType) {
	if (carServOrder == null) {
	    return null;
	}
	return new OrderImageStorage(carServOrder, recordType);
	
    }
    
    class OrderImageStorage implements ImageStorage {
	
	private CarServOrder carServOrder;
	
	private String recordType;
	
	private String namePrefix = "Photo";
	

	public OrderImageStorage(CarServOrder carServOrder, String recordType) {
	    super();
	    this.carServOrder = carServOrder;
	    this.recordType = recordType;
	}
	
	public List<ImageEntry> getImages() {
	    List<ImageEntry> images = new ArrayList<ImageEntry>();
	    List<CarServOrderImage> imageItems = getImageItems();
	    if (imageItems == null || imageItems.isEmpty()) {
		return images;
	    }
	    
	    for (CarServOrderImage item : imageItems) {
		ImageEntry e = item.getImageEntry();
		e.setId(item.getId());
		
		images.add(e);
	    }
	    
	    return images;
	}

	public void addImage(ImageEntry imageData) {
	    imageData.setImageDirty(true);
	    CarServOrderImage ci = new CarServOrderImage();
	    ci.setImageEntry(imageData);
	    ci.setRecordType(recordType);
	    
	    carServOrder.addImage(ci);
	}
	
	protected List<CarServOrderImage> getImageItems() {
	    return carServOrder.getImageList(recordType);
	}
	

	public void removeImage(ImageEntry imageData) {
	    if (imageData == null) {
		return;
	    }
	    List<CarServOrderImage> imageItems = getImageItems();
	    for (CarServOrderImage item : imageItems) {
		if (imageData == item.getImageEntry()) {
		    carServOrder.removeImage(item);
		    return;
		}
	    }
	}
	
	public void loadImageData(ImageEntry imageEntry) {
	    if (imageEntry == null) {
		return;
	    }
	    
	    Integer id = imageEntry.getId(); 
	    if (id == null) {
		return;
	    }
	    try {
		imageEntry.setBinaryData(getCarServOrderService().loadImage(id));
	    } catch (Throwable ex) {
		openErrorDialog(ex);
	    }
	    
	}
	
	public ImageEntry createImage() {
	    ImageEntryImpl image = new ImageEntryImpl();
	    image.setName(generateName());
	    return image;
	}
	
	private String generateName() {
	    int index = 1;
	    String name = getNamePrefix() + " " + index;
	    List<CarServOrderImage> imageItems = getImageItems();
	    if (imageItems == null || imageItems.isEmpty()) {
		return name;
	    }
	    int k = 0;
	    while (true) {
		k++;
		if (k > 1000) {
		    // STUB
		    // TODO
		}
		
		if (!findName(imageItems, name)) {
		    return name; 
		}
		index++;
		name = getNamePrefix() + " " + index;
	    }
	    
	}

	private boolean findName(List<CarServOrderImage> imageItems, String name) {
	    for (CarServOrderImage item : imageItems) {
		String n = item.getImageName();
		if (n == null) {
		    continue;
		}
		n = n.trim();
		if (name.equals(n)) {
		    return true;
		}
	    }
	    return false;
	}
	
	public String getNamePrefix() {
	    return namePrefix;
	}
	
	
    }
    
    ImageTablePanel incomeImagePanel;
    
    ImageTablePanel outcomeImagePanel;

    protected CarServOrderService getCarServOrderService() {
	return (CarServOrderService) getEntityService();
    }
}
