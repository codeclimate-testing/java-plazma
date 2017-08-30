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

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;

/**
 * The item of report of finding car material
 * @author Oleh Hapon
 * $Id: CarMtrlFindReportItem.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarMtrlFindReportItem extends ProductDocumentItem {

    private List<CarMtrlFindReportPrice> priceList;
    
    
    public CarMtrlFindReport getCarMtrlFindReport() {
        return (CarMtrlFindReport) getProductDocument();
    }

    public void setCarMtrlFindReport(CarMtrlFindReport carMtrlFindReport) {
        setProductDocument(carMtrlFindReport);
    }
    
    public boolean isCorrectedPriceItem() {
	return true;
    }

    public List<CarMtrlFindReportPrice> getPriceList() {
	if (priceList == null) {
	    priceList = new ArrayList<CarMtrlFindReportPrice>();
	}
        return priceList;
    }

    public void setPriceList(List<CarMtrlFindReportPrice> priceList) {
        this.priceList = priceList;
    }
    
    public void addPrice(CarMtrlFindReportPrice price) {
	price.setItem(this);
	getPriceList().add(price);
    }

    public void removePrice(CarMtrlFindReportPrice price) {
	getPriceList().remove(price);
    }
    
    public void init() {
	super.init();

	// Force initialize
	getPriceList() .size();
    }

}
