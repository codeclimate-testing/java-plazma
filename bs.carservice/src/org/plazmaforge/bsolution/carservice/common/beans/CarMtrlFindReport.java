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

import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;

/**
 * The result of find car material
 * @author Oleh Hapon
 * $Id: CarMtrlFindReport.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarMtrlFindReport extends ProductDocument {

    public static final String CLASS_ID = "CAR_MTRL_FIND_REPORT";
    
    private DocumentHeader carMtrlFindRequest;

    private DocumentHeader carServOrder;
    
    ////
    
    public DocumentHeader getCarMtrlFindRequest() {
        return carMtrlFindRequest;
    }

    public void setCarMtrlFindRequest(DocumentHeader carMtrlFindRequest) {
        this.carMtrlFindRequest = carMtrlFindRequest;
    }
    
    public String getCarMtrlFindRequestTitle() {
        return carMtrlFindRequest == null ? "" : carMtrlFindRequest.getShortTitle();
    }

    ////

    public DocumentHeader getCarServOrder() {
        return carServOrder;
    }

    public void setCarServOrder(DocumentHeader carServOrder) {
        this.carServOrder = carServOrder;
    }

    public String getCarServOrderTitle() {
        return carServOrder == null ? "" : carServOrder.getShortTitle();
    }
    
    ////
    
    
    public void init() {
	super.init();

	// Force initialize
	List<ProductDocumentItem> items = getProductItems();
	for (ProductDocumentItem item : items) {
	    CarMtrlFindReportItem orderItem = ((CarMtrlFindReportItem) item);
	    orderItem.init();
	}
    }


}
