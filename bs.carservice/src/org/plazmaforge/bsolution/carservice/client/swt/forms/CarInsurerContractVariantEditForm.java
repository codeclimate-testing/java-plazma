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
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerConsumablesPrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerContractVariant;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPaintBoxPrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPaintTypePrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPaintTypeVolume;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPartPrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPrepareHour;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerServPrice;
import org.plazmaforge.bsolution.organization.common.beans.Organization;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerContractVariantEditForm.java,v 1.4 2010/12/05 07:53:48 ohapon Exp $
 */

public class CarInsurerContractVariantEditForm extends AbstractEditForm {



    private Label organizationLabel;
    private Label contractCodeLabel;
    private Label contractDateLabel;
    private Label variantCodeLabel;
    private Label variantDateLabel;
    private Label insurerLabel;

    
    private XComboEdit organizationField;
    private XTextField contractCodeField;
    private XDateCombo contractDateField;
    private XTextField variantCodeField;
    private XDateCombo variantDateField;
    
    private XComboEdit insurerField;
    
    private Composite itemsPanel;
    private TabFolder itemsTabFolder;
    
    
    private Table servPriceTable;
    private Table paintTypePriceTable;
    private Table paintTypeVolumeTable;
    private Table consumablesPriceTable;
    private Table paintBoxPriceTable;
    private Table partPriceTable;
    private Table prepareHourTable;    
    

    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerContractVariantEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	TabFolder tabFolder;
	TabItem generalTabItem;
	Composite composite;
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;	
	
	setTitle(Messages.getString("CarInsurerContractVariantEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	
    	////
       	organizationLabel = new Label(composite, SWT.NONE);
       	organizationLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.organizationLabel.text")); //$NON-NLS-1$

       	organizationField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	organizationField.setLayoutData(gridData);
    	organizationField.setAssociationValueClass(Organization.class);

    	
    	////
    	
    	contractCodeLabel = new Label(composite, SWT.NONE);
    	contractCodeLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.contractCodeLabel.text")); //$NON-NLS-1$

    	contractCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	contractCodeField.setLayoutData(gridData);
    	contractCodeField.setTextLimit(20);

    	contractDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 50;
    	contractDateLabel.setLayoutData(gridData);
	contractDateLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.contractDateLabel.text")); //$NON-NLS-1$

    	contractDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	contractDateField.setLayoutData(gridData);

    	////
    	
    	variantCodeLabel = new Label(composite, SWT.NONE);
    	variantCodeLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.variantCodeLabel.text")); //$NON-NLS-1$

    	variantCodeField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	variantCodeField.setLayoutData(gridData);
    	variantCodeField.setTextLimit(20);

    	variantDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 50;
    	variantDateLabel.setLayoutData(gridData);
    	variantDateLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.variantDateLabel.text")); //$NON-NLS-1$

    	variantDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	variantDateField.setLayoutData(gridData);

    	////
       	insurerLabel = new Label(composite, SWT.NONE);
	insurerLabel.setText(Messages.getString("CarInsurerContractVariantEditForm.insurerLabel.text")); //$NON-NLS-1$

    	insurerField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	insurerField.setLayoutData(gridData);
    	insurerField.setAssociationValueClass(Partner.class);

    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	
    	this.setSize(new Point(600, 350));    	


    	registerEntityProvider(itemsTabFolder.getItem(0), new ServPriceProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), new PaintTypePriceProvider());
    	registerEntityProvider(itemsTabFolder.getItem(2), new PaintTypeVolumeProvider());
    	registerEntityProvider(itemsTabFolder.getItem(3), new ConsumablesPriceProvider());
    	registerEntityProvider(itemsTabFolder.getItem(4), new PaintBoxPriceProvider());
    	registerEntityProvider(itemsTabFolder.getItem(5), new PartPriceProvider());
    	registerEntityProvider(itemsTabFolder.getItem(6), new PrepareHourProvider());

    }
    
   
    protected void bindControls() {

	bindControl(organizationField, "organization", organizationLabel, REQUIRED);
	
	bindControl(contractCodeField, "contractCode", contractCodeLabel, REQUIRED);
	bindControl(contractDateField, "contractDate", contractDateLabel, REQUIRED);
	
	bindControl(variantCodeField, "variantCode");
	bindControl(variantDateField, "variantDate");
	
	bindControl(insurerField, "insurer", insurerLabel, REQUIRED);
   
    }

    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
 
        GridLayout gridLayout;
        
        /////
        TabItem servPriceTabItem;
        TabItem paintTypePriceTabItem;
        TabItem paintTypeVolumeTabItem;
        TabItem consumablesPriceTabItem;
        TabItem paintBoxPriceTabItem;
        TabItem partPriceTabItem;
        TabItem prepareHourTabItem;
        
        ///////////
        
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

        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 1.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        servPriceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        servPriceTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.servPriceTabItem.text")); //$NON-NLS-1$

         
        servPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        servPriceTable.setHeaderVisible(true);
        servPriceTable.setLinesVisible(true);
        servPriceTabItem.setControl(servPriceTable);

   
        TableColumn tableColumn = new TableColumn(servPriceTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carAgeColumn = new TableColumn(servPriceTable, SWT.NONE);
        carAgeColumn.setWidth(100);
        carAgeColumn.setText(Messages.getString("CarInsurerContractVariantEditForm.carAgeeColumn.text")); //$NON-NLS-1$

        TableColumn carServTypeColumn = new TableColumn(servPriceTable, SWT.NONE);
        carServTypeColumn.setWidth(300);
        carServTypeColumn.setText(Messages.getString("CarInsurerContractVariantEditForm.carServTypeColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn = new TableColumn(servPriceTable, SWT.RIGHT);
        priceColumn.setWidth(100);
        priceColumn.setText(Messages.getString("CarInsurerContractVariantEditForm.priceColumn.text")); //$NON-NLS-1$


        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 2.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        paintTypePriceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        paintTypePriceTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.paintTypePriceTabItem.text")); //$NON-NLS-1$

         
        paintTypePriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        paintTypePriceTable.setHeaderVisible(true);
        paintTypePriceTable.setLinesVisible(true);
        paintTypePriceTabItem.setControl(paintTypePriceTable);

   
        tableColumn = new TableColumn(paintTypePriceTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carPaintTypeColumn2 = new TableColumn(paintTypePriceTable, SWT.NONE);
        carPaintTypeColumn2.setWidth(200);
        carPaintTypeColumn2.setText(Messages.getString("CarInsurerContractVariantEditForm.carPaintTypeColumn.text")); //$NON-NLS-1$
                
        TableColumn carPaintMarkColumn2 = new TableColumn(paintTypePriceTable, SWT.NONE);
        carPaintMarkColumn2.setWidth(200);
        carPaintMarkColumn2.setText(Messages.getString("CarInsurerContractVariantEditForm.carPaintMarkColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn2 = new TableColumn(paintTypePriceTable, SWT.RIGHT);
        priceColumn2.setWidth(100);
        priceColumn2.setText(Messages.getString("CarInsurerContractVariantEditForm.priceColumn.text")); //$NON-NLS-1$

        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 3.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        paintTypeVolumeTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        paintTypeVolumeTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.paintTypeVolumeTabItem.text")); //$NON-NLS-1$

         
        paintTypeVolumeTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        paintTypeVolumeTable.setHeaderVisible(true);
        paintTypeVolumeTable.setLinesVisible(true);
        paintTypeVolumeTabItem.setControl(paintTypeVolumeTable);

   
        tableColumn = new TableColumn(paintTypeVolumeTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carClassColumn3 = new TableColumn(paintTypeVolumeTable, SWT.NONE);
        carClassColumn3.setWidth(200);
        carClassColumn3.setText(Messages.getString("CarInsurerContractVariantEditForm.carClassColumn.text")); //$NON-NLS-1$
                
        TableColumn carPaintDetailTypeColumn3 = new TableColumn(paintTypeVolumeTable, SWT.NONE);
        carPaintDetailTypeColumn3.setWidth(200);
        carPaintDetailTypeColumn3.setText(Messages.getString("CarInsurerContractVariantEditForm.carPaintDetailTypeColumn.text")); //$NON-NLS-1$

        TableColumn volumeStringColumn3 = new TableColumn(paintTypeVolumeTable, SWT.RIGHT);
        volumeStringColumn3.setWidth(130);
        volumeStringColumn3.setText(Messages.getString("CarInsurerContractVariantEditForm.volumeStringColumn.text")); //$NON-NLS-1$

        TableColumn percentOfBasicColumn3 = new TableColumn(paintTypeVolumeTable, SWT.RIGHT);
        percentOfBasicColumn3.setWidth(130);
        percentOfBasicColumn3.setText(Messages.getString("CarInsurerContractVariantEditForm.percentOfBasicColumn.text")); //$NON-NLS-1$
        
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 4.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        consumablesPriceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        consumablesPriceTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.consumablesPriceTabItem.text")); //$NON-NLS-1$

         
        consumablesPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        consumablesPriceTable.setHeaderVisible(true);
        consumablesPriceTable.setLinesVisible(true);
        consumablesPriceTabItem.setControl(consumablesPriceTable);

   
        tableColumn = new TableColumn(consumablesPriceTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carClassColumn4 = new TableColumn(consumablesPriceTable, SWT.NONE);
        carClassColumn4.setWidth(100);
        carClassColumn4.setText(Messages.getString("CarInsurerContractVariantEditForm.carClassColumn.text")); //$NON-NLS-1$
                
        TableColumn carPaintDetailTypeColumn4 = new TableColumn(consumablesPriceTable, SWT.NONE);
        carPaintDetailTypeColumn4.setWidth(200);
        carPaintDetailTypeColumn4.setText(Messages.getString("CarInsurerContractVariantEditForm.carPaintDetailTypeColumn.text")); //$NON-NLS-1$

        TableColumn carDamageLevelColumn4 = new TableColumn(consumablesPriceTable, SWT.NONE);
        carDamageLevelColumn4.setWidth(150);
        carDamageLevelColumn4.setText(Messages.getString("CarInsurerContractVariantEditForm.carDamageLevelColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn4 = new TableColumn(consumablesPriceTable, SWT.RIGHT);
        priceColumn4.setWidth(100);
        priceColumn4.setText(Messages.getString("CarInsurerContractVariantEditForm.priceColumn.text")); //$NON-NLS-1$
        
        TableColumn percentColumn4 = new TableColumn(consumablesPriceTable, SWT.RIGHT);
        percentColumn4.setWidth(100);
        percentColumn4.setText(Messages.getString("CarInsurerContractVariantEditForm.percentColumn.text")); //$NON-NLS-1$

        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 5.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        paintBoxPriceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        paintBoxPriceTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.paintBoxPriceTabItem.text")); //$NON-NLS-1$

         
        paintBoxPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        paintBoxPriceTable.setHeaderVisible(true);
        paintBoxPriceTable.setLinesVisible(true);
        paintBoxPriceTabItem.setControl(paintBoxPriceTable);

   
        tableColumn = new TableColumn(paintBoxPriceTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carPaintDetailTypeColumn5 = new TableColumn(paintBoxPriceTable, SWT.NONE);
        carPaintDetailTypeColumn5.setWidth(200);
        carPaintDetailTypeColumn5.setText(Messages.getString("CarInsurerContractVariantEditForm.carPaintDetailTypeColumn.text")); //$NON-NLS-1$


        TableColumn ageFrom5 = new TableColumn(paintBoxPriceTable, SWT.RIGHT);
        ageFrom5.setWidth(80);
        ageFrom5.setText(Messages.getString("CarInsurerContractVariantEditForm.ageFromColumn.text")); //$NON-NLS-1$
        
        TableColumn ageTo5 = new TableColumn(paintBoxPriceTable, SWT.RIGHT);
        ageTo5.setWidth(80);
        ageTo5.setText(Messages.getString("CarInsurerContractVariantEditForm.ageToColumn.text")); //$NON-NLS-1$

        TableColumn priceColumn5 = new TableColumn(paintBoxPriceTable, SWT.RIGHT);
        priceColumn5.setWidth(100);
        priceColumn5.setText(Messages.getString("CarInsurerContractVariantEditForm.priceColumn.text")); //$NON-NLS-1$

        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 6.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        partPriceTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        partPriceTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.partPriceTabItem.text")); //$NON-NLS-1$

         
        partPriceTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        partPriceTable.setHeaderVisible(true);
        partPriceTable.setLinesVisible(true);
        partPriceTabItem.setControl(partPriceTable);

   
        tableColumn = new TableColumn(partPriceTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn ageFrom6 = new TableColumn(partPriceTable, SWT.RIGHT);
        ageFrom6.setWidth(80);
        ageFrom6.setText(Messages.getString("CarInsurerContractVariantEditForm.ageFromColumn.text")); //$NON-NLS-1$
        
        TableColumn ageTo6 = new TableColumn(partPriceTable, SWT.RIGHT);
        ageTo6.setWidth(80);
        ageTo6.setText(Messages.getString("CarInsurerContractVariantEditForm.ageToColumn.text")); //$NON-NLS-1$

        TableColumn discontPercentColumn6 = new TableColumn(partPriceTable, SWT.RIGHT);
        discontPercentColumn6.setWidth(100);
        discontPercentColumn6.setText(Messages.getString("CarInsurerContractVariantEditForm.discountPercentColumn.text")); //$NON-NLS-1$

        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 7.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prepareHourTabItem = new TabItem(itemsTabFolder, SWT.NONE);
        prepareHourTabItem.setText(Messages.getString("CarInsurerContractVariantEditForm.prepareHourTabItem.text")); //$NON-NLS-1$

         
        prepareHourTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        prepareHourTable.setHeaderVisible(true);
        prepareHourTable.setLinesVisible(true);
        prepareHourTabItem.setControl(prepareHourTable);

   
        tableColumn = new TableColumn(prepareHourTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn carPrepareTypeColumn7 = new TableColumn(prepareHourTable, SWT.NONE);
        carPrepareTypeColumn7.setWidth(200);
        carPrepareTypeColumn7.setText(Messages.getString("CarInsurerContractVariantEditForm.carPrepareTypeColumn.text")); //$NON-NLS-1$
        
        TableColumn carDamageLevelColumn7 = new TableColumn(prepareHourTable, SWT.NONE);
        carDamageLevelColumn7.setWidth(150);
        carDamageLevelColumn7.setText(Messages.getString("CarInsurerContractVariantEditForm.carDamageLevelColumn.text")); //$NON-NLS-1$

        TableColumn hourColumn7 = new TableColumn(prepareHourTable, SWT.RIGHT);
        hourColumn7.setWidth(100);
        hourColumn7.setText(Messages.getString("CarInsurerContractVariantEditForm.hourColumn.text")); //$NON-NLS-1$

    }
    
    // 1.
    protected class ServPriceProvider extends TableEntityProvider {
	
	public ServPriceProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerServPrice.class); // FORM ID
	    setListProperty("servPriceList");
	    setAddMethod("addServPrice");

	}
	
	protected Table getTable() {
	    return servPriceTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "carAgeName");
	    bindColumn(2, "carServTypeName");
	    bindColumn(3, "price", getCurrencyFormat());
	}
    }

    // 2.
    protected class PaintTypePriceProvider extends TableEntityProvider {
	
	public PaintTypePriceProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerPaintTypePrice.class); // FORM ID
	    setListProperty("paintTypePriceList");
	    setAddMethod("addPaintTypePrice");

	}
	
	protected Table getTable() {
	    return paintTypePriceTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "carPaintTypeName");
	    bindColumn(2, "carPaintMarkName");
	    bindColumn(3, "price", getCurrencyFormat());
	}
    }

    
    // 3.
    protected class PaintTypeVolumeProvider extends TableEntityProvider {
	
	public PaintTypeVolumeProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerPaintTypeVolume.class); // FORM ID
	    setListProperty("paintTypeVolumeList");
	    setAddMethod("addPaintTypeVolume");
	}
	
	protected Table getTable() {
	    return paintTypeVolumeTable;
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "carClassName");
	    bindColumn(2, "carPaintDetailTypeName");
	    bindColumn(3, "volumeString");
	    bindColumn(4, "percentOfBasic", getPercentFormat());
	    
	}
    }

    
    //  4.
    protected class ConsumablesPriceProvider extends TableEntityProvider {
	
	public ConsumablesPriceProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerConsumablesPrice.class); // FORM ID
	    setListProperty("consumablesPriceList");
	    setAddMethod("addConsumablesPrice");
	}
	
	protected Table getTable() {
	    return consumablesPriceTable;
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "carClassName");
	    bindColumn(2, "carPaintDetailTypeName");
	    bindColumn(3, "carDamageLevelName");
	    bindColumn(4, "price", getCurrencyFormat());
	    bindColumn(5, "percent", getPercentFormat());	    
	}
    }

    
    //  5.
    protected class PaintBoxPriceProvider extends TableEntityProvider {
	
	public PaintBoxPriceProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerPaintBoxPrice.class); // FORM ID
	    setListProperty("paintBoxPriceList");
	    setAddMethod("addPaintBoxPrice");
	}
	
	protected Table getTable() {
	    return paintBoxPriceTable;
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "carPaintDetailTypeName");
	    bindColumn(2, "ageFrom");
	    bindColumn(3, "ageTo");
	    bindColumn(4, "price", getCurrencyFormat());	    
	}
    }
    
    
    //  6.
    protected class PartPriceProvider extends TableEntityProvider {
	
	public PartPriceProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerPartPrice.class); // FORM ID
	    setListProperty("partPriceList");
	    setAddMethod("addPartPrice");
	}
	
	protected Table getTable() {
	    return partPriceTable;
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "ageFrom");
	    bindColumn(2, "ageTo");
	    bindColumn(3, "discountPercent", getPercentFormat());	    
	}
    }

    
    //  7.
    protected class PrepareHourProvider extends TableEntityProvider {
	
	public PrepareHourProvider() {
	    setParentEntityClass(CarInsurerContractVariant.class); // OWNER
	    setEntityClass(CarInsurerPrepareHour.class); // FORM ID
	    setListProperty("prepareHourList");
	    setAddMethod("addPrepareHour");
	}
	
	protected Table getTable() {
	    return prepareHourTable;
	}
	
	protected void bindTable() {
	    
	    bindColumn(1, "carPrepareTypeName");
	    bindColumn(2, "carDamageLevelName");
	    bindColumn(3, "hour");	    
	}
    }


   
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemsTabFolder.getSelectionIndex();
        return itemsTabFolder.getItem(index);
    }
    

    protected CarInsurerContractVariant getCarInsurerContractVariant() {
	return (CarInsurerContractVariant) getEntity();
    }

    
    protected void initData() throws ApplicationException {
	CarInsurerContractVariant contract = getCarInsurerContractVariant();
	if (contract == null) {
	    return;
	}
	if (contract.getOrganization() == null) {
	    contract.setOrganization(EnterpriseEnvironment.getOrganization(SessionEnvironment.getContext()));
	}

    }

}
