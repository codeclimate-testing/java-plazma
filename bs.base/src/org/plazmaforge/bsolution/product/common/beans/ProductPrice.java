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

import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.framework.ext.model.BaseEntity;



/**
 * <code>Price</code> of <code>Product</code>
 * 
 * @author Oleh Hapon
 * Date: 23.08.2004
 * Time: 19:29:08
 * $Id: ProductPrice.java,v 1.6 2010/12/05 07:55:57 ohapon Exp $
 */


public class ProductPrice extends BaseEntity {

    private Product product;
    
    private PriceType priceType;
    
    private Currency currency;
    
    private Unit unit;
    
    private float pricePercent;
    
    private double price;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public float getPricePercent() {
        return pricePercent;
    }

    public void setPricePercent(float pricePercent) {
        this.pricePercent = pricePercent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    public Currency getCurrency() {
        return currency;
    }

    public String getCurrencyName() {
        return currency == null ? null : currency.getName();
    }

    public Integer getCurrencyId() {
        return currency == null ? null : currency.getId();
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public PriceType getPriceType() {
        return priceType;
    }

    public String getPriceTypeName() {
        return priceType == null ? null : priceType.getName();
    }

    public Integer getPriceTypeId() {
        return priceType == null ? null : priceType.getId();
    }

    
    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }
    
    public Unit getUnit() {
        return unit;
    }

    public String getUnitName() {
        return unit == null ? null : unit.getName();
    }

    public Integer getUnitId() {
        return unit == null ? null : unit.getId();
    }

    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
