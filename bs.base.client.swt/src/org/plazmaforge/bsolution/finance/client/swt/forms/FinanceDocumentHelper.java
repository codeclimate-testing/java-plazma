package org.plazmaforge.bsolution.finance.client.swt.forms;

import java.util.Date;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.services.CurrencyRateService;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.forms.AbstractForm;

public class FinanceDocumentHelper {

    private AbstractForm form;
    
    
    private XComboEdit currencyField;
    
    private XNumberField currencyRateField;
    
    private XDateCombo currencyRateDateField;  

    
    
    public FinanceDocumentHelper(AbstractForm form) {
	super();
	this.form = form;
    }

    public void initCurrencyField(final XComboEdit currencyField) {
	this.currencyField = currencyField;
	if (currencyField == null) {
	    return;
	}
	currencyField.addUpdateListener(new UpdateListener() {
	    public void update(UpdateEvent evt) {
		if (currencyRateField == null) {
		    return;
		}
		
		if (form.isDoubleEvent("currencyField")) {
		    return;
		}
		
		if (!EnterpriseEnvironment.isAutoSetCurrencyRate()) {
		    return;
		}
		Currency currency = (Currency) currencyField.getValue();
		if (currency == null) {
		    return;
		}
		Currency baseCurrency = EnterpriseEnvironment.getCurrency();
		try {
		    CurrencyRateService serv = (CurrencyRateService) form.getService(CurrencyRateService.class);
		    Object[] record = serv.getLastCurrencyRateAndDate(baseCurrency.getId(), currency.getId());
		    if (record == null || record.length < 1 || record[0] == null || record[1] == null) {
			return;
		    }
		    double rate = (Double) record[0];
		    Date date = (Date) record[1];
		    
		    if (rate <= 0) {
			return;
		    }
		    
		    currencyRateField.setValue(rate);
		    
		    if (currencyRateDateField != null) {
			currencyRateDateField.setValue(date);
		    }
		    
		} catch (Throwable e) {
		    form.logError(e);
		}
	    }
	});
    }

    public void initCurrencyRateField(XNumberField currencyRateField) {
	this.currencyRateField = currencyRateField;
    }

    
    public void initCurrencyRateDateField(XDateCombo currencyRateDateField) {
	this.currencyRateDateField = currencyRateDateField;
    }

    public XNumberField getCurrencyRateField() {
        return currencyRateField;
    }

    public XDateCombo getCurrencyRateDateField() {
        return currencyRateDateField;
    }

    public XComboEdit getCurrencyField() {
        return currencyField;
    }

    
    
}
