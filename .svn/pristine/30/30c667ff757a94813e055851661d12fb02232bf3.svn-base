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
 * Created on 06.06.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;



import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.document.client.swt.forms.AbstractDocumentEditForm;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 * $Id: AbstractFinanceDocumentEditForm.java,v 1.8 2010/12/05 07:57:18 ohapon Exp $
 */

public abstract class AbstractFinanceDocumentEditForm extends AbstractDocumentEditForm {
    
    private FinanceDocumentHelper financeDocumentHelper = new FinanceDocumentHelper(this);
    
    public AbstractFinanceDocumentEditForm(Composite parent, int style) {
	super(parent, style);
    }

    protected FinanceDocument getFinanceDocument() {
	return (FinanceDocument) getDocument();
    }

    /**
     * Initialize Document
     */
    protected void initDocument() {
	FinanceEnvironment.initFinanceDocument(getFinanceDocument(), getEntityCode(), getSessionContext());
    }
    
    

    protected void initCurrencyField(final XComboEdit currencyField) {
	financeDocumentHelper.initCurrencyField(currencyField);
    }

    protected void initCurrencyRateField(XNumberField currencyRateField) {
	financeDocumentHelper.initCurrencyRateField(currencyRateField);
    }

    
    protected void initCurrencyRateDateField(XDateCombo currencyRateDateField) {
	financeDocumentHelper.initCurrencyRateDateField(currencyRateDateField);
    }
    
    // ----
    
    protected void afterUpdateData() throws ApplicationException {
	super.afterUpdateData();
	calculateGeneral();
    }
    
    protected void calculateGeneral() {} 
    
    protected boolean isIncludeTaxInAmount() {
	return getFinanceDocument() == null ? false : getFinanceDocument().isIncludeTaxInAmount();
    }
    

    protected XComboEdit getCurrencyField() {
        return financeDocumentHelper.getCurrencyField();
    }

    public XNumberField getCurrencyRateField() {
        return financeDocumentHelper.getCurrencyRateField();
    }
    
    protected XDateCombo getCurrencyRateDateField() {
        return financeDocumentHelper.getCurrencyRateDateField();
    }
    
    ////
    
    public Currency getCurrencyValue() {
	if (getCurrencyField() == null) {
	    return getFinanceDocument() == null ? null : getFinanceDocument().getCurrency();
	}
	return (Currency) getCurrencyField().getValue();
    }
    
    public double getCurrencyRateValue() {
	if (getCurrencyRateField() == null) {
	    return getFinanceDocument() == null ? 1d : getFinanceDocument().getCurrencyRate();
	}
	return getCurrencyRateField().doubleValue();
    }

}
