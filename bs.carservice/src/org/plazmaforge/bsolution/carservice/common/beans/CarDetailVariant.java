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

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarDetailVariant.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarDetailVariant extends BaseEntity {

    private CarDetail carDetail;



    
    private CarDetailServAttribute carDetailServAttribute = new CarDetailServAttribute();
    
    private List<CarDetailVariantPart> partList;
    private List<CarDetailVariantServ> servList;
    private List<CarDetailVariantPaint> paintList;
    
    
    public void init() {
	super.init();
	
	getPartList().size();
	getServList().size();
	getPaintList().size();
    }
    
    
    /**
     * @return
     */
    public CarDetail getCarDetail() {
	return carDetail;
    }

    /**
     * @param carDetail
     */
    public void setCarDetail(CarDetail carDetail) {
	this.carDetail = carDetail;
    }

    
    

    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public boolean isDamageLevelReplace() {
	return carDetailServAttribute.isDamageLevelReplace(); 
    }

    
    public boolean isDamageLevel1() {
	return carDetailServAttribute.isDamageLevel1();
    }
    
    public boolean isDamageLevel2() {
	return carDetailServAttribute.isDamageLevel2();
    }

    public boolean isDamageLevel3() {
	return carDetailServAttribute.isDamageLevel3();
    }

    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    public List<CarDetailVariantPart> getPartList() {
	if (partList == null) {
	    partList = new ArrayList<CarDetailVariantPart>();
	}
        return partList;
    }

    public void setPartList(List<CarDetailVariantPart> partList) {
        this.partList = partList;
    }

    public void addPart(CarDetailVariantPart part) {
	part.setCarDetailVariant(this);
	getPartList().add(part);
    }

    
    
    
    public List<CarDetailVariantServ> getServList() {
	if (servList == null) {
	    servList = new ArrayList<CarDetailVariantServ>();
	}	
        return servList;
    }

    public void setServList(List<CarDetailVariantServ> servList) {
        this.servList = servList;
    }
    
    public void addServ(CarDetailVariantServ serv) {
	serv.setCarDetailVariant(this);
	getServList().add(serv);
    }

    
    

    public List<CarDetailVariantPaint> getPaintList() {
	if (paintList == null) {
	    paintList = new ArrayList<CarDetailVariantPaint>();
	}	
        return paintList;
    }

    public void setPaintList(List<CarDetailVariantPaint> paintList) {
        this.paintList = paintList;
    }
    
    public void addPaint(CarDetailVariantPaint paint) {
	paint.setCarDetailVariant(this);
	getPaintList().add(paint);
    }


    public CarDetailServAttribute getCarDetailServAttribute() {
        return carDetailServAttribute;
    }

    ////////////////////////////////////////////////////////////////////////////////
    
    public CarDamageLevel getCarDamageLevel() {
        return carDetailServAttribute.getCarDamageLevel();
    }

    public void setCarDamageLevel(CarDamageLevel carDamageLevel) {
	carDetailServAttribute.setCarDamageLevel(carDamageLevel);
    }

    public String getCarDamageLevelName() {
        return carDetailServAttribute.getCarDamageLevelName();
    }
    
    
    public boolean isPnt() {
        return carDetailServAttribute.isPnt();
    }

    public void setPnt(boolean pnt) {
	carDetailServAttribute.setPnt(pnt);
    }

    public boolean isMat() {
        return carDetailServAttribute.isMat();
    }

    public void setMat(boolean mat) {
	carDetailServAttribute.setMat(mat);
    }

    public boolean isPol() {
        return carDetailServAttribute.isPol();
    }

    public void setPol(boolean pol) {
	carDetailServAttribute.setPol(pol);
    }    
    
}
