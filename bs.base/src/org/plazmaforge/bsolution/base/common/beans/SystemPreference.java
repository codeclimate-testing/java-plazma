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
 * Created on 24.08.2007
 *
 */

package org.plazmaforge.bsolution.base.common.beans;

import org.plazmaforge.framework.core.SystemFormat;
import org.plazmaforge.framework.ext.model.BaseEntity;


/** 
 * @author Oleh Hapon
 * $Id: SystemPreference.java,v 1.3 2010/12/05 07:55:59 ohapon Exp $
 */

public class SystemPreference extends BaseEntity {

    private String dateFormat;
    
    private String timeFormat;
    
    
    private String numberFormat;
    
    private String integerFormat;
    
    private String currencyFormat;
    
    private String percentFormat;
    
    private String quantityFormat;
    
    private String coefficientFormat;

    private boolean valid;
    
    public String getCoefficientFormat() {
        return coefficientFormat;
    }

    public void setCoefficientFormat(String coefficientFormat) {
        this.coefficientFormat = coefficientFormat;
    }

    public String getCurrencyFormat() {
        return currencyFormat;
    }

    public void setCurrencyFormat(String currencyFormat) {
        this.currencyFormat = currencyFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getIntegerFormat() {
        return integerFormat;
    }

    public void setIntegerFormat(String integerFormat) {
        this.integerFormat = integerFormat;
    }

    public String getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
    }

    public String getPercentFormat() {
        return percentFormat;
    }

    public void setPercentFormat(String percentFormat) {
        this.percentFormat = percentFormat;
    }

    public String getQuantityFormat() {
        return quantityFormat;
    }

    public void setQuantityFormat(String quantityFormat) {
        this.quantityFormat = quantityFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }
    
    
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void populateFormat(SystemFormat systemFormat) {
	valid = false;
	int k = 0;
	int filedCount = 8;
	
	// 1
	try {
	    systemFormat.setDatePattern(getDateFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 2
	try {
	    systemFormat.setTimePattern(getTimeFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	
	if (k == 2) { // valid Date and DateTime
	    try {
		systemFormat.setDateTimePattern("" + getDateFormat() + " " + getTimeFormat());
	    } catch (Exception ex) {
		
	    }
	}
	
	// 3
	try {
	    systemFormat.setNumberPattern(getNumberFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 4
	try {
	    systemFormat.setIntegerPattern(getIntegerFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 5
	try {
	    systemFormat.setCurrencyPattern(getCurrencyFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 6
	try {
	    systemFormat.setPercentPattern(getPercentFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 7
	try {
	    systemFormat.setQuantityPattern(getQuantityFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	// 8
	try {
	    systemFormat.setCoefficientPattern(getCoefficientFormat());
	    k++;
	} catch (Exception ex) {
	    
	}
	if (k == filedCount) {
	    valid = true;
	}
    }

    public void loadFormat(SystemFormat systemFormat) {
	setDateFormat(systemFormat.getDatePattern());
	setTimeFormat(systemFormat.getTimePattern());
	setNumberFormat(systemFormat.getNumberPattern());
	setIntegerFormat(systemFormat.getIntegerPattern());
	
	setCurrencyFormat(systemFormat.getCurrencyPattern());
	setPercentFormat(systemFormat.getPercentPattern());
	setQuantityFormat(systemFormat.getQuantityPattern());
	setCoefficientFormat(systemFormat.getCoefficientPattern());
    }

}
