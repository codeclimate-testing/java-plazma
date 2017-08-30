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
 * Created on 18.11.2008
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
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariant;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantPaint;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantPart;
import org.plazmaforge.bsolution.carservice.common.beans.CarDetailVariantServ;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: CarDetailVariantEditForm.java,v 1.4 2010/12/05 07:53:48 ohapon Exp $
 */

public class CarDetailVariantEditForm extends AbstractEditForm {


    private Label damageLevelLabel;
    private Label pntLabel;
    private Label matLabel;
    private Label polLabel;
    
 
    private XComboEdit damageLevelField;
    private XCheckBox pntField;
    private XCheckBox matField;
    private XCheckBox polField;
    
    

    private Composite itemPanel;

    private Table partTable;
    private Table servTable;
    private Table paintTable;
    
    private TabFolder tabFolder;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarDetailVariantEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setDataSourceSupport(false);
	
	Composite composite;

	GridData gridData;


	setTitle(Messages.getString("CarDetailVariantEditForm.title")); //$NON-NLS-1$

	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	setLayout(gridLayout);
    	
    	

    	composite = new Composite(this, SWT.NONE);
    	
    	gridLayout = new GridLayout();
       	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
    	

    	////
    	damageLevelLabel = new Label(composite, SWT.NONE);
    	damageLevelLabel.setText(Messages.getString("CarServOrderItemEditForm.damageLevelLabel.text")); //$NON-NLS-1$

    	damageLevelField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 150;
    	damageLevelField.setLayoutData(gridData);
    
    	////
    	
	pntLabel = new Label(composite, SWT.NONE);
	pntLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypePNT")); //$NON-NLS-1$

	pntField = new XCheckBox(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	pntField.setLayoutData(gridData);

    	////
    	
	matLabel = new Label(composite, SWT.NONE);
	matLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypeMAT")); //$NON-NLS-1$

	matField = new XCheckBox(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	matField.setLayoutData(gridData);

    	////
    	
	polLabel = new Label(composite, SWT.NONE);
	polLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypePOL")); //$NON-NLS-1$

	polField = new XCheckBox(composite, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	polField.setLayoutData(gridData);
	
    	ItemToolBar itemToolPanel = new ItemToolBar(this, SWT.NONE, PWT.ADD_BUTTON | PWT.EDIT_BUTTON  |PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
  
    	createItemPanel();
    	
    	
    	this.setSize(new Point(550, 264));
    	
    	registerEntityProvider(tabFolder.getItem(0), new PartProvider());
    	registerEntityProvider(tabFolder.getItem(1), new ServProvider());
    	registerEntityProvider(tabFolder.getItem(2), new PaintProvider());

    
    }
    
   

    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
	
        TableColumn newColumnTableColumn;
        GridLayout gridLayout;

        TabItem partTabItem;
        TabItem servTabItem;
        TabItem paintTabItem;
               
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 120;
        itemPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        itemPanel.setLayout(gridLayout);
        itemPanel.setLayoutData(gridData);
        

        
        tabFolder = new TabFolder(itemPanel, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        // PART TABLE
        
        partTabItem = new TabItem(tabFolder, SWT.NONE);
        partTabItem.setText(Messages.getString("CarDetailVariantEditForm.partTabItem.text")); //$NON-NLS-1$

         
        partTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        partTable.setHeaderVisible(true);
        partTable.setLinesVisible(true);
        partTabItem.setControl(partTable);
        
        newColumnTableColumn = new TableColumn(partTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("CarDetailVariantEditForm.nameTableColumn.text")); //$NON-NLS-1$

        
        
        
        // SERV TABLE
        
        servTabItem = new TabItem(tabFolder, SWT.NONE);
        servTabItem.setText(Messages.getString("CarDetailVariantEditForm.servTabItem.text")); //$NON-NLS-1$

         
        servTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        servTable.setHeaderVisible(true);
        servTable.setLinesVisible(true);
        servTabItem.setControl(servTable);
        
        TableColumn carClassColumn = new TableColumn(servTable, SWT.NONE);
        carClassColumn.setWidth(150);
        carClassColumn.setText(Messages.getString("CarDetailVariantEditForm.carClassColumn.text"));

        newColumnTableColumn = new TableColumn(servTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("CarDetailVariantEditForm.nameTableColumn.text")); //$NON-NLS-1$

        newColumnTableColumn = new TableColumn(servTable, SWT.RIGHT);
        newColumnTableColumn.setWidth(70);
        newColumnTableColumn.setText(Messages.getString("CarDetailVariantEditForm.workHourTableColumn.text")); //$NON-NLS-1$
        
        

        // PAINT TABLE
        paintTabItem = new TabItem(tabFolder, SWT.NONE);
        paintTabItem.setText(Messages.getString("CarDetailVariantEditForm.paintTabItem.text")); //$NON-NLS-1$

         
        paintTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        paintTable.setHeaderVisible(true);
        paintTable.setLinesVisible(true);
        paintTabItem.setControl(paintTable);
        
        newColumnTableColumn = new TableColumn(paintTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("CarDetailVariantEditForm.nameTableColumn.text")); //$NON-NLS-1$

        TableColumn carPaintDetailTypeColumn = new TableColumn(paintTable, SWT.NONE);
        carPaintDetailTypeColumn.setWidth(200);
        carPaintDetailTypeColumn.setText(Messages.getString("CarDetailVariantEditForm.carPaintDetailTypeTableColumn.text")); //$NON-NLS-1$
        
    }

    
    
   
    protected class PartProvider extends TableEntityProvider {
	
	public PartProvider() {
	    setParentEntityClass(CarDetailVariant.class);
	    setListProperty("partList");
	    setAddMethod("addPart");
	    
	    setEntityClass(CarDetailVariantPart.class);
	}
	
	
	
	protected Table getTable() {
	    return partTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "name");
	}
	
    }

    protected class ServProvider extends TableEntityProvider {
	
	public ServProvider() {
	    setParentEntityClass(CarDetailVariant.class);
	    setListProperty("servList");
	    setAddMethod("addServ");
	    
	    setEntityClass(CarDetailVariantServ.class);
	}
	
	
	
	protected Table getTable() {
	    return servTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "carClassName");
	    bindColumn(1, "name");
	    bindColumn(2, "workHour", getQuantityFormat());
	}
	
    }

    protected class PaintProvider extends TableEntityProvider {
	
	public PaintProvider() {
	    setParentEntityClass(CarDetailVariant.class);
	    setListProperty("paintList");
	    setAddMethod("addPaint");
	    
	    setEntityClass(CarDetailVariantPaint.class);
	}
	
	
	
	protected Table getTable() {
	    return paintTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "name");
	    bindColumn(1, "carPaintDetailTypeName");
	}
	
    }

       
    
    protected void initData() throws ApplicationException {
	super.initData();
    }
    
    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }
    

    protected void bindControls() {
	bindControl(damageLevelField, "carDamageLevel");
	bindControl(pntField, "pnt");
	bindControl(matField, "mat");
	bindControl(polField, "pol");
    }    


}
