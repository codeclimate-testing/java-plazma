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

import org.plazmaforge.bsolution.finance.common.beans.IWarehouseDocument;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;

/**
 * @author Oleh Hapon
 * $Id: WarehouseProductDocument.java,v 1.2 2010/04/28 06:24:21 ohapon Exp $
 */

public class WarehouseProductDocument extends ProductDocument implements IWarehouseDocument {
    
    private Warehouse warehouse;
    
    private MtrlResponsible mtrlResponsible;

    
    public Warehouse getWarehouse() {
        return warehouse;
    }
    
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    
    public String getWarehouseName() {
        return warehouse == null ? null : warehouse.getName();
    }
    
    public MtrlResponsible getMtrlResponsible() {
        return mtrlResponsible;
    }


    public String getMtrlResponsibleName() {
        return mtrlResponsible == null ? null : mtrlResponsible.getName();
    }
    
    public void setMtrlResponsible(MtrlResponsible mtrlResponsible) {
        this.mtrlResponsible = mtrlResponsible;
    }

 
    /**
     * Return true if synchronize Document Responsible with Material Responsible
     * @return
     */
    public boolean isSyncDocumentResponsible() {
	return true;
    }
    

}
