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

import org.plazmaforge.bsolution.carservice.common.beans.CarPaintMark;
import org.plazmaforge.bsolution.goods.common.beans.Goods;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarPaint.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarPaint extends Goods {

    /** Class ID **/
    public static final String CLASS_ID = "CAR_PAINT";
    
    
    private CarPaintType carPaintType;

    private CarPaintMark carPaintMark;

    private boolean consumable;
    
    protected String getClassId() {
	return CLASS_ID;
    }
    
    public CarPaintType getCarPaintType() {
	return carPaintType;
    }

    public void setCarPaintType(CarPaintType carPaintType) {
	this.carPaintType = carPaintType;
    }

    public String getCarPaintTypeName() {
	return carPaintType == null ? null : carPaintType.getName();
    }

    
    
    
    
    public CarPaintMark getCarPaintMark() {
	return carPaintMark;
    }

    public void setCarPaintMark(CarPaintMark carPaintMark) {
	this.carPaintMark = carPaintMark;
    }

    public String getCarPaintMarkName() {
	return carPaintMark == null ? null : carPaintMark.getName();
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    
}
