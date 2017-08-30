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
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindRequest;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReport;
import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindReportItem;
import org.plazmaforge.bsolution.carservice.common.services.CarMtrlFindReportService;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentEditForm;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class CarMtrlFindReportEditForm extends AbstractGoodsDocumentEditForm {



    private Label documentNoLabel;
    private Label documentDateLabel;    
    private Label carMtrlFindRequestLabel;
    private Label carServOrderLabel;
    private Label currencyLabel;
    private Label currencyRateLabel;
    private Label currencyRateDateLabel;
    private Label currencyTotalLabel;
         
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XComboEdit carMtrlFindRequestField;
    private XTextField carServOrderField;
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
    public CarMtrlFindReportEditForm(Composite parent, int style) {
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
	
	setTitle(Messages.getString("CarMtrlFindReportEditForm.title")); //$NON-NLS-1$
	setLayout(gridLayout);
	

    	tabFolder = new TabFolder(this, SWT.NONE);
    	tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    	generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("CarMtrlFindReportEditForm.generalTabItem.text")); //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 6;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	documentNoLabel = new Label(composite, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("CarMtrlFindReportEditForm.documentNoLabel.text")); //$NON-NLS-1$

    	documentNoField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    	gridData.widthHint = 100;
    	documentNoField.setLayoutData(gridData);
    	documentNoField.setTextLimit(20);

    	documentDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	documentDateLabel.setLayoutData(gridData);
	documentDateLabel.setText(Messages.getString("CarMtrlFindReportEditForm.documentDateLabel.text")); //$NON-NLS-1$

    	documentDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	documentDateField.setLayoutData(gridData);
    	
    	//STRUTS
    	final Label label = new Label(composite, SWT.NONE);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
    	label.setLayoutData(gridData);
    	

	carMtrlFindRequestLabel = new Label(composite, SWT.NONE);
	carMtrlFindRequestLabel.setText(Messages.getString("CarMtrlFindReportEditForm.carMtrlFindRequestLabel.text")); //$NON-NLS-1$

    	carMtrlFindRequestField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	carMtrlFindRequestField.setLayoutData(gridData);

    	///
    	
	carServOrderLabel = new Label(composite, SWT.NONE);
	carServOrderLabel.setText(Messages.getString("CarMtrlFindReportEditForm.carServOrderLabel.text")); //$NON-NLS-1$

	carServOrderField = new XTextField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
	carServOrderField.setLayoutData(gridData);

    	///
    	
    	currencyLabel = new Label(composite, SWT.NONE);
	gridData = new GridData();
    	currencyLabel.setLayoutData(gridData);
    	currencyLabel.setText(Messages.getString("CarMtrlFindReportEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	currencyField.setLayoutData(new GridData(120, SWT.DEFAULT));

    	currencyRateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateLabel.setLayoutData(gridData);
	currencyRateLabel.setText(Messages.getString("CarMtrlFindReportEditForm.currencyRateLabel.text")); //$NON-NLS-1$

    	currencyRateField = new XNumberField(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateField.setLayoutData(gridData);

    	currencyRateDateLabel = new Label(composite, SWT.NONE);
    	gridData = new GridData();
    	gridData.horizontalIndent = 10;
    	currencyRateDateLabel.setLayoutData(gridData);
	currencyRateDateLabel.setText(Messages.getString("CarMtrlFindReportEditForm.currencyRateDateLabel.text")); //$NON-NLS-1$

    	currencyRateDateField = new XDateCombo(composite, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyRateDateField.setLayoutData(gridData);

    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("CarMtrlFindReportEditForm.noteTabItem.text")); //$NON-NLS-1$

    	noteField = new XTextArea(tabFolder, SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteTabItem.setControl(noteField);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);
    	
    	createItemPanel();
    	createSummaryPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemsTabFolder, CarMtrlFindReport.class);
    	
    	this.setSize(new Point(600, 350));    	

    	
    	initCarMtrlFindRequestField(carMtrlFindRequestField);
    	
    	initCurrencyField(currencyField);
    	initCurrencyRateField(currencyRateField);
    	initCurrencyRateDateField(currencyRateDateField);
    	
    	registerEntityProvider(itemsTabFolder.getItem(0), new ProductItemProvider());
    	registerEntityProvider(itemsTabFolder.getItem(1), attributeView.getEntityProvider());
    }
    
   
    protected void bindControls() {
	bindControl(documentNoField, "documentNo", documentNoLabel, REQUIRED);
	bindControl(documentDateField, "documentDate", documentDateLabel, REQUIRED);
	bindControl(carMtrlFindRequestField, "carMtrlFindRequest");
	bindControl(carServOrderField, "carServOrderTitle");
	
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
        productTabItem.setText(Messages.getString("CarMtrlFindReportEditForm.productTabItem.text")); //$NON-NLS-1$

         
        productTable = new Table(itemsTabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        productTable.setHeaderVisible(true);
        productTable.setLinesVisible(true);
        productTabItem.setControl(productTable);

   
        TableColumn tableColumn = new TableColumn(productTable, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        TableColumn productNameColumn = new TableColumn(productTable, SWT.NONE);
        productNameColumn.setWidth(230);
        productNameColumn.setText(Messages.getString("CarMtrlFindReportEditForm.productNameColumn.text")); //$NON-NLS-1$

        TableColumn unitNameColumn = new TableColumn(productTable, SWT.CENTER);
        unitNameColumn.setWidth(60);
        unitNameColumn.setText(Messages.getString("CarMtrlFindReportEditForm.unitNameColumn.text")); //$NON-NLS-1$

        TableColumn unitRateColumn = new TableColumn(productTable, SWT.RIGHT);
        unitRateColumn.setWidth(50);
        unitRateColumn.setText(Messages.getString("CarMtrlFindReportEditForm.unitRateColumn.text")); //$NON-NLS-1$

        TableColumn quantityColumn = new TableColumn(productTable, SWT.RIGHT);
        quantityColumn.setWidth(80);
        quantityColumn.setText(Messages.getString("CarMtrlFindReportEditForm.quantityColumn.text")); //$NON-NLS-1$
         
        
        TableColumn currencyPriceColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyPriceColumn.setWidth(80);
        currencyPriceColumn.setText(Messages.getString("CarMtrlFindReportEditForm.currencyPriceColumn.text")); //$NON-NLS-1$
        
        TableColumn currencyAmountColumn = new TableColumn(productTable, SWT.RIGHT);
        currencyAmountColumn.setWidth(80);
        currencyAmountColumn.setText(Messages.getString("CarMtrlFindReportEditForm.currencyAmountColumn.text"));       //$NON-NLS-1$
        
     
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
    	currencyTotalLabel.setText(Messages.getString("CarMtrlFindReportEditForm.currencyTotalLabel.text")); //$NON-NLS-1$

    	currencyTotalField = new XCurrencyField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	currencyTotalField.setLayoutData(gridData);
    	
    	initNoEditableField(currencyTotalField);
    	initNoEditableField(carServOrderField);
    	
    	carMtrlFindRequestField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		updateCarServOrder();
    	    }
    	});
    }
    
    protected void updateCarServOrder() {
	if (!isLoadData) {
	    return;
	}
	CarMtrlFindReportService service = (CarMtrlFindReportService) getEntityService();
	DocumentHeader requestDoc  = (DocumentHeader) carMtrlFindRequestField.getValue();
	Integer requestId = requestDoc == null ? null : requestDoc.getId(); 
	if (requestId == null) {
	    carServOrderField.setText("");
	    return;
	}
	DocumentHeader doc = null;
	try {
	    doc = service.findCarServOrderByRequestId(requestId);	    
	} catch (Exception ex){
	    ex.printStackTrace();
	}

	carServOrderField.setText(doc == null ? "" : doc.getShortTitle());
    }
    
    
    private boolean isLoadData = false;
    
    @Override
    public void updateForm() throws ApplicationException {
        // TODO Auto-generated method stub
        super.updateForm();
        
        isLoadData = true;
    }
 
    
    protected class ProductItemProvider extends TableEntityProvider {
	
	public ProductItemProvider() {
	    setParentEntityClass(CarMtrlFindReport.class); // OWNER
	    setEntityClass(CarMtrlFindReportItem.class); // FORM ID
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
    
    protected void initCarMtrlFindRequestField(XComboEdit field) {
	if (field == null) {
	    return;
	}
 	field.setDisplayValueProperty("shortTitle");
    	field.setAssociationValueClass(CarMtrlFindRequest.class);
   }
}
