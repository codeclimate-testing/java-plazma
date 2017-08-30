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

package org.plazmaforge.bsolution.base.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.CurrencyRate;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CurrencyRateEditForm.java,v 1.6 2010/12/05 07:57:20 ohapon Exp $
 */
public class CurrencyRateEditForm extends AbstractEditForm {

    
    private Label baseCurrencyLabel;
    
    private Label currencyLabel;
    
    private Label dateLabel;
    
    private Label rateLabel;
    
    
       
    private XComboEdit baseCurrencyField;
    
    private XComboEdit currencyField;    
    
    private XDateCombo dateField;
    
    private XNumberField rateField;

       
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CurrencyRateEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
		
	setTitle(Messages.getString("CurrencyRateEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	baseCurrencyLabel = new Label(this, SWT.NONE);
    	baseCurrencyLabel.setText(Messages.getString("CurrencyRateEditForm.baseCurrecnyLabel.text")); //$NON-NLS-1$

    	baseCurrencyField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	baseCurrencyField.setLayoutData(gridData);
    	baseCurrencyField.setTextLimit(3);
    	
    	currencyLabel = new Label(this, SWT.NONE);
    	currencyLabel.setText(Messages.getString("CurrencyRateEditForm.currencyLabel.text")); //$NON-NLS-1$

    	currencyField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
  	gridData.widthHint = 100;
    	currencyField.setLayoutData(gridData);
    	currencyField.setTextLimit(3);

    	dateLabel = new Label(this, SWT.NONE);
    	dateLabel.setText(Messages.getString("CurrencyRateEditForm.dateLabel.text")); //$NON-NLS-1$

    	dateField = new XDateCombo(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.grabExcessHorizontalSpace = false;
    	dateField.setLayoutData(gridData);
    	dateField.setTextLimit(10);
    	
  	rateLabel = new Label(this, SWT.NONE);
  	rateLabel.setText(Messages.getString("CurrencyRateEditForm.rateLabel.text")); //$NON-NLS-1$

    	rateField = new XNumberField(this, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
     	gridData.grabExcessHorizontalSpace = false;
    	rateField.setLayoutData(gridData);    	
    	rateField.setTextLimit(20);
    	
    	this.setSize(new Point(395, 108));
    }
    
    protected void bindControls() {
	bindControl(baseCurrencyField, "baseCurrency", baseCurrencyLabel, REQUIRED);
	bindControl(currencyField, "currency", currencyLabel, REQUIRED);
	bindControl(dateField, "date", dateLabel, REQUIRED);
	bindControl(rateField, "rate", rateLabel, REQUIRED);
    }

    protected CurrencyRate getCurrencyRate() {
	return (CurrencyRate) getEntity(); 
    }
    
    protected void initData() throws ApplicationException {
	super.initData();
	getCurrencyRate().setBaseCurrency(EnterpriseEnvironment.getCurrency());
	getCurrencyRate().setDate(EnterpriseEnvironment.getDate());
	getCurrencyRate().setRate(1d);
    }
    
}  //  @jve:decl-index=0:visual-constraint="10,10"

