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

import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarMtrlPurchaseRequest.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarMtrlPurchaseRequest extends ProductDocument {

    public static final String CLASS_ID = "CAR_MTRL_PURCHASE_REQUEST";
    
    private DocumentHeader carMtrlFindReport;
    

    public DocumentHeader getCarMtrlFindReport() {
        return carMtrlFindReport;
    }

    public void setCarMtrlFindReport(DocumentHeader carMtrlFindResult) {
        this.carMtrlFindReport = carMtrlFindResult;
    }


    public String getCarMtrlFindReportTitle() {
        return carMtrlFindReport == null ? "" : carMtrlFindReport.getShortTitle();
    }

}