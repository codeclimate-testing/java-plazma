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
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarMtrlPurchaseReportItem.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarMtrlPurchaseReportItem extends ProductDocumentItem {

    /** Supplier **/
    private PartnerHeader supplier;
    
    /** Date of delivery **/
    private Date deliveryDate;
    
    public CarMtrlPurchaseReport getCarMtrlPurchaseReport() {
        return (CarMtrlPurchaseReport) getProductDocument();
    }

    public void setCarMtrlPurchaseReport(CarMtrlPurchaseReport carMtrlPurchaseReport) {
        setProductDocument(carMtrlPurchaseReport);
    }
    
    public boolean isCorrectedPriceItem() {
	return true;
    }

    public PartnerHeader getSupplier() {
        return supplier;
    }

    public void setSupplier(PartnerHeader supplier) {
        this.supplier = supplier;
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
