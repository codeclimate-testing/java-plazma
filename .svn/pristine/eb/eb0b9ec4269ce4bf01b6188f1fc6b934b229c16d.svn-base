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

import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarAssurerPrice.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarAssurerPrice extends BaseEntity {

    private PartnerHeader assurer;
    
    private CarAge carAge;
    
    private float price;

    public PartnerHeader getAssurer() {
        return assurer;
    }

    public void setAssurer(PartnerHeader assurer) {
        this.assurer = assurer;
    }

    public CarAge getCarAge() {
        return carAge;
    }

    public void setCarAge(CarAge carAge) {
        this.carAge = carAge;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getAssurerName() {
        return assurer == null ? null : assurer.getName();
    }
    
    public String getCarAgeName() {
        return carAge == null ? null : carAge.getName();
    }    
    
    
}
