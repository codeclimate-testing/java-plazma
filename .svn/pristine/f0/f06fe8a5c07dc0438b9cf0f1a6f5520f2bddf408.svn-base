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

import java.text.DecimalFormat;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerPaintTypeVolume.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarInsurerPaintTypeVolume extends CarInsurerContractItem {

    private CarClass carClass;
    
    private CarPaintDetailType carPaintDetailType;

    private float volume;
    
    private float volumeTo;
    
    private boolean range;
    
    private int valueType;
    

    /**
     * Percent of basic if it is non basic entity
     */
    private float percentOfBasic;
    
    
    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }
    
    public String getCarClassName() {
        return carClass == null ? null : carClass.getName();
    }
    
    
    

    public CarPaintDetailType getCarPaintDetailType() {
        return carPaintDetailType;
    }

    public void setCarPaintDetailType(CarPaintDetailType carPaintDetailType) {
        this.carPaintDetailType = carPaintDetailType;
    }
    
    public String getCarPaintDetailTypeName() {
        return carPaintDetailType == null ? null : carPaintDetailType.getName();
    }
    
    
    

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getVolumeTo() {
        return volumeTo;
    }

    public void setVolumeTo(float volumeTo) {
        this.volumeTo = volumeTo;
    }

    public float getPercentOfBasic() {
        return percentOfBasic;
    }

    public void setPercentOfBasic(float percentOfBasic) {
        this.percentOfBasic = percentOfBasic;
    }

    public boolean isRange() {
        return range;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }
    
    public String getVolumeString() {
	return range ? (formatVolume(volume) + " - " + formatVolume(volumeTo)) : formatVolume(volume); 
    }
    
    private String formatVolume(float volume) {
	return getDecimalFormat().format(volume);
    }
    
    private DecimalFormat volumeFormat;
    
    private DecimalFormat getDecimalFormat() {
	if (volumeFormat == null) {
	    volumeFormat = new DecimalFormat("#,###,##0.000");
	}
	return volumeFormat;
    }
    
    public boolean isAccept(CarClass carClass , CarPaintDetailType carPaintDetailType)  {
	if (carClass == null || carPaintDetailType == null) {
	    return false;
	}
	if (this.carClass == null || this.carPaintDetailType == null) {
	    return false;
	}
	Integer thisClassId = this.carClass.getId();
	Integer thisTypeId = this.carPaintDetailType.getId();
	if (thisClassId == null || thisTypeId == null) {
	    return false;
	}
	
	return thisClassId.equals(carClass.getId()) && thisTypeId.equals(carPaintDetailType.getId());
    }
    
    
    public boolean isBaseType() {
	if (carPaintDetailType == null) {
	    return false;
	}
	return carPaintDetailType.isBaseType();
    }
}
