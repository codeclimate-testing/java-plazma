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


import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderItem.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarServOrderItem extends ProductDocumentItem {

    
    
    
    
    
    
    
    
    
    private CarServOrderInventory inventory;
    
    private Integer carServOrderInventoryId;
    
    private EmployeeHeader worker;
    
    private float workHour;
    
    private CarServComplexity carServComplexity;
    
    
    private Warehouse warehouse;
    
    
    
    
    
    
    

    ///////////////////////////////////////////////////////////////////////
    //
    // ONLY FOR INVENTORY ITEMS
    //
    ///////////////////////////////////////////////////////////////////////
    
    private CarDetailServAttribute carDetailServAttribute = new CarDetailServAttribute();
    
    
    
    public CarServOrder getCarServOrder() {
        return (CarServOrder) getProductDocument();
    }

    public void setCarServOrder(CarServOrder carServOrder) {
        setProductDocument(carServOrder);
    }
    
    public boolean isCorrectedPriceItem() {
	return true;
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

    public EmployeeHeader getWorker() {
        return worker;
    }

    public void setWorker(EmployeeHeader worker) {
        this.worker = worker;
    }
    
    public Integer getWorkerId() {
        return worker == null ? null : worker.getId();
    }
    

    public float getWorkHour() {
        return workHour;
    }

    public void setWorkHour(float workHour) {
        this.workHour = workHour;
    }

    public String getWorkerName() {
	return worker == null ? null : worker.getFullName();
    }

    public CarServComplexity getCarServComplexity() {
        return carServComplexity;
    }

    public void setCarServComplexity(CarServComplexity carServComplexity) {
        this.carServComplexity = carServComplexity;
    }
    
    public String getCarServComplexityName() {
	return carServComplexity == null ? null : carServComplexity.getName(); 
    }
    
    public Integer getCarServComplexityId() {
	return carServComplexity == null ? null : carServComplexity.getId(); 
    }
    
    ////
    
    public Warehouse getWarehouse() {
        return warehouse;
    }
    
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    
    public String getWarehouseName() {
        return warehouse == null ? null : warehouse.getName();
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
