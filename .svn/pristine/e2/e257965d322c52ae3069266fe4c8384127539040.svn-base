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

package org.plazmaforge.bsolution.carservice.common.beans;

import java.util.Date;

import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * The price variant of item of report of finding car material
 * @author Oleh Hapon
 * $Id: CarMtrlFindReportPrice.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarMtrlFindReportPrice extends BaseEntity {
    
    private CarMtrlFindReportItem item;
    
    /** Supplier **/
    private PartnerHeader supplier;
    
    /** Price **/
    private double price;
    
    /** Price in currency **/
    private double currencyPrice;
    
    /** Date of delivery **/
    private Date deliveryDate;

    public CarMtrlFindReportItem getItem() {
        return item;
    }

    public void setItem(CarMtrlFindReportItem item) {
        this.item = item;
    }

    public PartnerHeader getSupplier() {
        return supplier;
    }

    public void setSupplier(PartnerHeader supplier) {
        this.supplier = supplier;
    }

    public double getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(double currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public String getSupplierName() {
	return supplier == null ? null : supplier.getName();
    }
    
    

}
