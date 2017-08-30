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

import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.framework.ext.model.BaseEntity;



/**
 * 
 * <code>Unit</code> of <code>Product</code>
 * 
 * @author Oleh Hapon
 * Date: 02.07.2003
 * Time: 13:37:14
 */


public class ProductUnit extends BaseEntity {

    private Product product;
    
    private Unit unit;
    
    private double rate;
    
    private String barCode;
    
    public static double DEFAULT_RATE = 1d;
    
    

    public ProductUnit() {
	super();
    }

    
    public ProductUnit(Product product, Unit unit) {
	super();
	this.product = product;
	this.unit = unit;
	this.setDefaultRate();
    }


    public ProductUnit(Unit unit) {
	this(null, unit);
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    public Unit getUnit() {
        return unit;
    }

    public Integer getUnitId() {
        return unit == null ? null : unit.getId();
    }
    public String getUnitName() {
        return unit == null ? null : unit.getName();
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDefaultRate() {
	setRate(DEFAULT_RATE);
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String toString() {
        return getUnitName();
    }
    
    public String getName() {
        return getUnitName();
    }
}