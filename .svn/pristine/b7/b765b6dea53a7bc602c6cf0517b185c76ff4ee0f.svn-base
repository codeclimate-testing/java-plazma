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
 * Created on 07.07.2008
 *
 */

package org.plazmaforge.bsolution.carservice.common.beans;

import org.plazmaforge.framework.ext.model.BaseEntity;

/** 
 * @author Oleh Hapon
 * $Id: CarServOrderPaintType.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */

public class CarServOrderPaintType extends BaseEntity {

    private CarServOrder carServOrder;
    
    private CarServOrderInventory inventory;
    
    private Integer carServOrderInventoryId;

    private CarPaintType carPaintType;
    
    
    public CarServOrder getCarServOrder() {
        return carServOrder;
    }

    public void setCarServOrder(CarServOrder carServOrder) {
        this.carServOrder = carServOrder;
    }

    public Integer getCarServOrderInventoryId() {
        return carServOrderInventoryId;
    }

    public void setCarServOrderInventoryId(Integer carServOrderInventoryId) {
        this.carServOrderInventoryId = carServOrderInventoryId;
    }

    public CarServOrderInventory getInventory() {
        return inventory;
    }

    public void setInventory(CarServOrderInventory inventory) {
        this.inventory = inventory;
    }

    public CarPaintType getCarPaintType() {
        return carPaintType;
    }

    public void setCarPaintType(CarPaintType carPaintType) {
        this.carPaintType = carPaintType;
    }
    
    public String getCarPaintTypeName() {
        return carPaintType == null ? null :  carPaintType.getName();
    }

    public Integer getCarPaintTypeId() {
        return carPaintType == null ? null :  carPaintType.getId();
    }

    
}
