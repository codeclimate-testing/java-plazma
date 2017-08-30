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

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.goods.common.beans.Goods;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServ.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarServ extends Goods {

    /** Class ID **/
    public static final String CLASS_ID = "CAR_SERV";
    
    private CarServType carServType;
    
    private List<CarServLink> carServLinks;

    
    protected String getClassId() {
	return CLASS_ID;
    }
    
    
    public CarServType getCarServType() {
        return carServType;
    }


    public void setCarServType(CarServType carServType) {
        this.carServType = carServType;
    }
    
    public String getCarServTypeName() {
        return carServType == null ? null : carServType.getName();
    }

    public List<CarServLink> getCarServLinks() {
	if (carServLinks == null) {
	    carServLinks = new ArrayList<CarServLink>();
	}
        return carServLinks;
    }

    public void setCarServLinks(List<CarServLink> carServLinks) {
        this.carServLinks = carServLinks;
    }
    
    
    public void addCarServLink(CarServLink link) {
	link.setCarServ(this);
	getCarServLinks().add(link);
    }

    public void removeCarServLink(CarServLink link) {
	link.setCarServ(null);
	getCarServLinks().remove(link);
    }
    
    
}
