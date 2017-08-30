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

package org.plazmaforge.bsolution.carservice.server.services;

import org.plazmaforge.bsolution.carservice.common.beans.CarMtrlFindRequest;
import org.plazmaforge.bsolution.carservice.common.services.CarMtrlFindRequestService;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;

import org.plazmaforge.bsolution.goods.server.services.AbstractGoodsDocumentService;

public class CarMtrlFindRequestServiceImpl extends AbstractGoodsDocumentService<CarMtrlFindRequest, Integer> implements CarMtrlFindRequestService {

    protected Class getEntityClass() {
        return CarMtrlFindRequest.class;
    }

    protected void preparePartnerMove(final FinanceDocument document) {
        //preparePartnerMoveByPartnerableDocument((PartnerableDocument) document);
    }


    protected void prepareWarehouseMove(FinanceDocument document) {
        //prepareWarehouseMoveByWarehouseDocument((WarehouseDocument) document);
    }

}
