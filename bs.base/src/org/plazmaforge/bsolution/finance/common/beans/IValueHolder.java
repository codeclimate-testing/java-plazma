package org.plazmaforge.bsolution.finance.common.beans;

import java.io.Serializable;

/**
 * 
 * Use for Amount, Price, Total
 * 
 * @author ohapon
 *
 */
public interface IValueHolder extends Serializable {

    
    double getTaxValue();

    double getValueWithTax();
    

    double getValue();

    void setTaxValue(double taxValue);
    

    void setValueWithTax(double valueWithTax);

    void setValue(double value);
  

}
