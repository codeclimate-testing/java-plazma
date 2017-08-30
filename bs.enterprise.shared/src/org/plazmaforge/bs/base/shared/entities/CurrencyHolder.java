package org.plazmaforge.bs.base.shared.entities;

import java.util.Date;

/**
 * 
 * @author ohapon
 *
 */
public class CurrencyHolder implements ICurrencyHolder {

    
    private static final long serialVersionUID = 8399286154544098319L;


    /**
     * Currency
     */
    private Currency currency;


    /**
     * Currency rate
     */
    private double currencyRate = 1d;

    
    /**
     * Currency rate date
     */
    private Date currencyRateDate;

    
    
    
    public Currency getCurrency() {
	if (currency == null) {
	    currency = new Currency();
	}
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    
    public double getCurrencyRate() {
	return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
	this.currencyRate = currencyRate;
    }

    public Date getCurrencyRateDate() {
	return currencyRateDate;
    }

    public void setCurrencyRateDate(Date currencyRateDate) {
	this.currencyRateDate = currencyRateDate;
    }

    public String getCurrencyCode() {
	return getCurrency().getCode();
    }

    public String getCurrencyName() {
	return getCurrency().getName();
    }

}
