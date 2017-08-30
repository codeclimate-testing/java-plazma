package org.plazmaforge.bsolution.finance.common.beans;

/**
 * Use for Amount, Price, Total
 * 
 * @author ohapon
 *
 */
public class ValueHolder implements IValueHolder {

    
    private double taxValue;

    private double valueWithTax; // value + taxValue

    private double value;

    
    
    public double getTaxValue() {
        return taxValue;
    }

    public double getValueWithTax() {
        return valueWithTax;
    }

    public double getValue() {
        return value;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public void setValueWithTax(double valueWithTax) {
        this.valueWithTax = valueWithTax;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
    
}
