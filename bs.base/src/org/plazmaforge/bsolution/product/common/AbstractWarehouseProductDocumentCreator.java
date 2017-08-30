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

package org.plazmaforge.bsolution.product.common;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.product.common.beans.WarehouseProductDocument;
import org.plazmaforge.framework.core.exception.ApplicationException;

public abstract class AbstractWarehouseProductDocumentCreator extends ProductDocumentCreator {

    protected void populate(Document parentDocument, Document document) throws ApplicationException {
	if (parentDocument == null || document == null) {
	    return;
	}
	super.populate(parentDocument, document);
	
	WarehouseProductDocument productWarehouseDocument = (WarehouseProductDocument) document;
	
	Warehouse warehouse = getWarehouse();
	if (warehouse == null) {
	    throw new ApplicationException("Warehouse is null");
	}
	MtrlResponsible responsible = EnterpriseEnvironment.getMtrlResponsible();
	productWarehouseDocument.setWarehouse(warehouse);
	productWarehouseDocument.setMtrlResponsible(responsible);

    }	

    protected abstract Warehouse getWarehouse();
}
