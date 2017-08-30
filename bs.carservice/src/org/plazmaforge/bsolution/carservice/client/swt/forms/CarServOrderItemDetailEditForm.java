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
import org.plazmaforge.bsolution.carservice.common.beans.CarDetail;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderItem;
import org.plazmaforge.bsolution.goods.client.swt.forms.AbstractGoodsDocumentItemEditForm;
import org.plazmaforge.bsolution.product.common.beans.PriceType;

import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * Detal Edit Form. 
 * Only for Inventory mode.
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderItemDetailEditForm.java,v 1.4 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderItemDetailEditForm extends AbstractGoodsDocumentItemEditForm {

    private Label goodsLabel;
    private Label quantityLabel;
    
    private Label damageLevelLabel;
    private Label pntLabel;
    private Label matLabel;
    private Label polLabel;
    
 
    private XComboEdit goodsField;
    private XCurrencyField quantityField;
    
    
    private XComboEdit damageLevelField;
    private XCheckBox pntField;
    private XCheckBox matField;
    private XCheckBox polField;
    
 

    public  CarServOrderItemDetailEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {

	
	setEntityClass(CarServOrderItem.class);
	
	
	GridData gridData;
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = 3; // 4;
	setLayout(gridLayout);	
	
    	goodsLabel = new Label(this, SWT.NONE);
	goodsLabel.setText(Messages.getString("CarServOrderItemEditForm.carDetailLabel.text")); //$NON-NLS-1$

    	goodsField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1); // 3, 1
	gridData.widthHint = 300;
    	goodsField.setLayoutData(gridData);

    	////
    	
    	quantityLabel = new Label(this, SWT.NONE);
	quantityLabel.setText(Messages.getString("CarServOrderItemEditForm.quantityLabel.text")); //$NON-NLS-1$

    	quantityField = new XCurrencyField(this, SWT.BORDER); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	//gridData.widthHint = 70;
    	quantityField.setLayoutData(gridData);

    	Label label = new Label(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	label.setLayoutData(gridData);

    	
    	
    	
    	damageLevelLabel = new Label(this, SWT.NONE);
    	damageLevelLabel.setText(Messages.getString("CarServOrderItemEditForm.damageLevelLabel.text")); //$NON-NLS-1$

    	damageLevelField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.DELETE_BUTTON); 
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	damageLevelField.setLayoutData(gridData);
    	
    	label = new Label(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	label.setLayoutData(gridData);

    	////
    	
	pntLabel = new Label(this, SWT.NONE);
	pntLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypePNT")); //$NON-NLS-1$

	pntField = new XCheckBox(this, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	pntField.setLayoutData(gridData);

    	////
    	
	matLabel = new Label(this, SWT.NONE);
	matLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypeMAT")); //$NON-NLS-1$

	matField = new XCheckBox(this, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	matField.setLayoutData(gridData);

    	////
    	
	polLabel = new Label(this, SWT.NONE);
	polLabel.setText(Messages.getString("CarServOrderItemEditForm.serviceTypePOL")); //$NON-NLS-1$

	polField = new XCheckBox(this, SWT.NONE);
	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
	polField.setLayoutData(gridData);
	
    	label = new Label(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 100;
    	label.setLayoutData(gridData);

    	
    	
    	
    	this.setSize(new Point(470, 108)); 
    	
    	// ITEM INIT
    	initGoodsField(goodsField);
    	initQuantityField(quantityField);
    }


    public void init() throws ApplicationException {
	goodsField.setAssociationValueClass(CarDetail.class);
	super.init();
    }


    protected void bindControls() {
	bindControl(goodsField, "product");
	bindControl(quantityField, "quantity");
	bindControl(damageLevelField, "carDamageLevel");
	bindControl(pntField, "pnt");
	bindControl(matField, "mat");
	bindControl(polField, "pol");
    }    
    
    
    protected int getDefaultPriceType() {
	return PriceType.LIST_PRICE;
    }
  
}
