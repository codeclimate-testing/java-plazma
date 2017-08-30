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

import java.io.Serializable;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarDetailServAttribute.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarDetailServAttribute implements Serializable {

 
    public final Integer DAMAGE_LEVEL_REPLACE = 0;;
    
    public final Integer DAMAGE_LEVEL_1 = 1;
    
    public final Integer DAMAGE_LEVEL_2 = 2;
    
    public final Integer DAMAGE_LEVEL_3 = 3;


      
    ///////////////////////////////////////////////////////////////////////

    
    
   
    private CarDamageLevel carDamageLevel;
    
    private boolean pnt;
    
    private boolean mat;
    
    private boolean pol;
    

    public boolean isDamageLevelReplace() {
	return DAMAGE_LEVEL_REPLACE.equals(getCarDamageLevelId()); 
    }

    
    public boolean isDamageLevel1() {
	return DAMAGE_LEVEL_1.equals(getCarDamageLevelId()); 
    }
    
    public boolean isDamageLevel2() {
	return DAMAGE_LEVEL_2.equals(getCarDamageLevelId()); 
    }

    public boolean isDamageLevel3() {
	return DAMAGE_LEVEL_3.equals(getCarDamageLevelId()); 
    }

    
        
    ///////////////////////////////////////////////

    public void populate(CarDetailServAttribute attribute) {
	if (attribute == null) {
	    reset();
	    return;
	}

	setCarDamageLevel(attribute.getCarDamageLevel());
	setPnt(attribute.isPnt());
	setMat(attribute.isMat());
	setPol(attribute.isPol());

    }
    
    protected void reset() {
	setCarDamageLevel(null);
	setPnt(false);
	setMat(false);
	setPol(false);
    }
    
    
    public CarDamageLevel getCarDamageLevel() {
        return carDamageLevel;
    }

    public void setCarDamageLevel(CarDamageLevel carDamageLevel) {
        this.carDamageLevel = carDamageLevel;
    }

    public String getCarDamageLevelName() {
        return carDamageLevel == null ? null : carDamageLevel.getName();
    }
    
    public Integer getCarDamageLevelId() {
        return carDamageLevel == null ? null : carDamageLevel.getId();
    }
    
    public boolean isPnt() {
        return pnt;
    }

    public void setPnt(boolean pnt) {
        this.pnt = pnt;
    }

    public boolean isMat() {
        return mat;
    }

    public void setMat(boolean mat) {
        this.mat = mat;
    }

    public boolean isPol() {
        return pol;
    }

    public void setPol(boolean pol) {
        this.pol = pol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        CarDetailServAttribute castedObj = (CarDetailServAttribute) o;
        Integer thisId = this.carDamageLevel == null ? null : this.carDamageLevel.getId();
        Integer castedId = castedObj.carDamageLevel == null ? null : castedObj.carDamageLevel.getId();
        
        return ((thisId == null
        	? castedId == null
        	: thisId.equals(castedId))
        	
            && (this.pnt == castedObj.pnt) && (this.mat == castedObj.mat) && (this.pol == castedObj.pol));
    }

    
}
