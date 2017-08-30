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
package org.plazmaforge.bsolution.product.common.beans;

import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * The price type of product
 */

/**
 * @author Oleh Hapon
 * Date: 25.08.2004
 * Time: 9:12:27
 * $Id: PriceType.java,v 1.5 2010/04/28 06:24:21 ohapon Exp $
 */
public class PriceType extends Dictionary {

    /** Discount price **/
    public static final String DSC = "DSC";
    
    /** Mark Up price **/
    public static final String MUP = "MUP";

    /** All: Discount and Mark Up price **/
    public static final String ALL = "ALL";

    
    public static final int COST_PRICE = 100;
    
    public static final int LIST_PRICE = 200;
    
    
    public static final int BASE_PRICE = 1;
    
    public static final int SMALL_WHOLESALE_PRICE = 2;
    
    public static final int WHOLESALE_PRICE = 3;
    
    public static final int RETAIL_PRICE = 4;
    
    public static final int PURCHASING_PRICE = 5;
    

    private float pricePercent;


    public float getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(float pricePercent) {
        this.pricePercent = pricePercent;
    }

    public static boolean isPriceType(int type, PriceType priceType) {
	if (priceType == null || priceType.getId() == null) {
	    return false;
	}
	return type == priceType.getId().intValue();
    }
    
    public static boolean isBasePrice(PriceType priceType) {
	return isPriceType(BASE_PRICE, priceType);
    }
    
    public static boolean isSmallWholesalePrice(PriceType priceType) {
	return isPriceType(SMALL_WHOLESALE_PRICE, priceType);
    }
    
    public static boolean isWholesalePrice(PriceType priceType) {
	return isPriceType(WHOLESALE_PRICE, priceType);
    }

    public static boolean isRetailPrice(PriceType priceType) {
	return isPriceType(RETAIL_PRICE, priceType);
    }

    public static boolean isPurchasingPrice(PriceType priceType) {
	return isPriceType(PURCHASING_PRICE, priceType);
    }

}
