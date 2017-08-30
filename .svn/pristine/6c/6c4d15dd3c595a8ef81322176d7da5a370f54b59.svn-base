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
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerPrepareHourEditForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarInsurerPrepareHourEditForm extends AbstractEditForm {

    
    private Label carPrepareTypeLabel;
    
    private Label carDamageLevelLabel;
    
    private Label hourLabel;
    
    
    
    private XComboEdit carPrepareTypeField;
    
    private XComboEdit carDamageLevelField;
    
    private XCurrencyField hourField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerPrepareHourEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerPrepareHourEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	carPrepareTypeLabel = new Label(this, SWT.NONE);
    	carPrepareTypeLabel.setText(Messages.getString("CarInsurerPrepareHourEditForm.carPrepareTypeLabel.text")); //$NON-NLS-1$

    	carPrepareTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON );
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPrepareTypeField.setLayoutData(gridData);

    	
    	////
    	carDamageLevelLabel = new Label(this, SWT.NONE);
    	carDamageLevelLabel.setText(Messages.getString("CarInsurerPrepareHourEditForm.carDamageLevelLabel.text")); //$NON-NLS-1$

    	carDamageLevelField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carDamageLevelField.setLayoutData(gridData);

    	
    	
    	////
    	hourLabel = new Label(this, SWT.NONE);
    	hourLabel.setText(Messages.getString("CarInsurerPrepareHourEditForm.hourLabel.text")); //$NON-NLS-1$

    	hourField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	hourField.setLayoutData(gridData);
    	hourField.setTextLimit(100);

    	this.setSize(new Point(574, 298));
    	
    	
    }
    
   
    
    protected void bindControls() {
	bindControl(carPrepareTypeField, "carPrepareType", carPrepareTypeLabel, REQUIRED);
	bindControl(carDamageLevelField, "carDamageLevel", carDamageLevelLabel, REQUIRED);
	bindControl(hourField, "hour");
    }

}
