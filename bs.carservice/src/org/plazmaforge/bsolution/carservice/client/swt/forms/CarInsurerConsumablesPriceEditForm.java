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
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerConsumablesPrice;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintDetailType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerConsumablesPriceEditForm.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */

public class CarInsurerConsumablesPriceEditForm extends AbstractEditForm {

    private Label carClassLabel;
    
    private Label carPaintDetailTypeLabel;
    
    private Label carDamageLevelLabel;
    
    private Label priceLabel;
    
    private Label percentLabel;
    
    
    
    private XComboEdit carClassField;
    
    private XComboEdit carPaintDetailTypeField;
    
    private XComboEdit carDamageLevelField;
    
    private XCurrencyField priceField;
    
    private XCurrencyField percentField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerConsumablesPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerConsumablesPriceEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	carClassLabel = new Label(this, SWT.NONE);
    	carClassLabel.setText(Messages.getString("CarInsurerConsumablesPriceEditForm.carClassLabel.text")); //$NON-NLS-1$

    	carClassField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON );
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carClassField.setLayoutData(gridData);

    	////
    	carPaintDetailTypeLabel = new Label(this, SWT.NONE);
    	carPaintDetailTypeLabel.setText(Messages.getString("CarInsurerConsumablesPriceEditForm.carPaintDetailTypeLabel.text")); //$NON-NLS-1$

    	carPaintDetailTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPaintDetailTypeField.setLayoutData(gridData);

    	
    	////
    	carDamageLevelLabel = new Label(this, SWT.NONE);
    	carDamageLevelLabel.setText(Messages.getString("CarInsurerConsumablesPriceEditForm.carDamageLevelLabel.text")); //$NON-NLS-1$

    	carDamageLevelField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carDamageLevelField.setLayoutData(gridData);

    	
    	////
    	priceLabel = new Label(this, SWT.NONE);
    	priceLabel.setText(Messages.getString("CarInsurerConsumablesPriceEditForm.priceLabel.text")); //$NON-NLS-1$

    	priceField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	priceField.setLayoutData(gridData);
    	priceField.setTextLimit(100);

    	
    	////
    	percentLabel = new Label(this, SWT.NONE);
    	percentLabel.setText(Messages.getString("CarInsurerConsumablesPriceEditForm.percentLabel.text")); //$NON-NLS-1$

    	percentField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	percentField.setLayoutData(gridData);
    	percentField.setTextLimit(100);

    	this.setSize(new Point(574, 298));
    	
    	carPaintDetailTypeField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		CarPaintDetailType carPaintDetailType = (CarPaintDetailType) carPaintDetailTypeField.getValue();
    		updatePercentField(carPaintDetailType);
    	    }
    	});
    }
    
    public void updateForm()  throws ApplicationException {
	super.updateForm();
	CarPaintDetailType carPaintDetailType = getCarInsurerConsumablesPrice().getCarPaintDetailType();
	updatePercentField(carPaintDetailType);
    }
   
    protected void updatePercentField(CarPaintDetailType carPaintDetailType) {
	boolean isBaseType = carPaintDetailType == null ? false: carPaintDetailType.isBaseType(); 
	percentField.setEnabled(!isBaseType);
    }
    
    protected CarInsurerConsumablesPrice getCarInsurerConsumablesPrice() {
	return  (CarInsurerConsumablesPrice) getEntity();
    }
    
    protected void bindControls() {
	
	bindControl(carClassField, "carClass", carClassLabel, REQUIRED);
	bindControl(carPaintDetailTypeField, "carPaintDetailType", carPaintDetailTypeLabel, REQUIRED);
	bindControl(carDamageLevelField, "carDamageLevel", carDamageLevelLabel, REQUIRED);
	
	bindControl(priceField, "price");
	bindControl(percentField, "percent");
	
    }
    
   

}
