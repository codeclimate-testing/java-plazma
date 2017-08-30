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
 * Created on 18.11.2008
 *
 */

package org.plazmaforge.bsolution.carservice.common.beans;

/** 
 * @author Oleh Hapon
 * $Id: CarDetailVariantServ.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */

public class CarDetailVariantServ  extends CarDetailVariantItem {

    private CarClass carClass;
    
    private CarServ carServ;
    
    private float workHour;

    
    public CarClass getCarClass() {
	return carClass;
    }

    
    public void setCarClass(CarClass carClass) {
	this.carClass = carClass;
    }
    
    public String getCarClassName() {
	return carClass == null ? null : carClass.getName();
    }

    public Integer getCarClassId() {
	return carClass == null ? null : carClass.getId();
    }

    public CarServ getCarServ() {
        return carServ;
    }

    public void setCarServ(CarServ carServ) {
        this.carServ = carServ;
    }
    
    public String getName() {
	return carServ == null ? null : carServ.getName();
    }

    public float getWorkHour() {
        return workHour;
    }

    public void setWorkHour(float workHour) {
        this.workHour = workHour;
    }

    
}
