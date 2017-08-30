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

/*
 * Created on 15.05.2006
 *
 */

package org.plazmaforge.bsolution.finance.common.beans;

/**
 * @author Oleh Hapon
 * 
 * $Id: WarehouseMove.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */

public class WarehouseMove extends AbstractMove {

    private Integer mtrlResponsibleId;

    private Integer warehouseId;

    private String moveType;

    public Integer getMtrlResponsibleId() {
	return mtrlResponsibleId;
    }

    public void setMtrlResponsibleId(Integer mtrlResponsibleId) {
	this.mtrlResponsibleId = mtrlResponsibleId;
    }

    public Integer getWarehouseId() {
	return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
	this.warehouseId = warehouseId;
    }

    public String getMoveType() {
	return moveType;
    }

    public void setMoveType(String moveType) {
	this.moveType = moveType;
    }

}
