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
import java.util.Date;
import java.util.List;

import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderInventory.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderInventory extends BaseEntity {

    /** Parent damage **/
    private CarServOrderDamage damage;
    
    /** date of inventory **/
    private Date inventoryDate;
    
    private CarPaintType carPaintType;
    
    

    public CarServOrderDamage getDamage() {
        return damage;
    }

    public void setDamage(CarServOrderDamage damage) {
        this.damage = damage;
    }

    public Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }
    
    ////
    
    public CarPaintType getCarPaintType() {
        return carPaintType;
    }

    public void setCarPaintType(CarPaintType carPaintType) {
        this.carPaintType = carPaintType;
    }
   
    
    ////
    
    public CarServOrder getCarServOrder() {
        return damage == null ? null : damage.getCarServOrder();
    }
    
 
    public List<ProductDocumentItem> getProductItemsByType(String filterType) {
	CarServOrder carServOrder = getCarServOrder();
	if (carServOrder == null) {
	    return createEmptyList();
	}
	return getInvProductItems(carServOrder.getProductItemsByType(filterType));
    }

    // ITEM - 1
    public List<ProductDocumentItem> getServiceItems() {
	return getProductItemsByType(CarServOrder.SERVICE_ITEM);
    }

    // ITEM - 2
    public List<ProductDocumentItem> getMaterialItems() {
	return getProductItemsByType(CarServOrder.MATERIAL_ITEM);
    }
    
    // ITEM - 3
    public List<ProductDocumentItem> getPartItems() {
	return getProductItemsByType(CarServOrder.PART_ITEM);
    }
    
    // OHA: ENABLE AFTER DISABLE PAINT ITEMS - CUSTOMER REQUIREMENTS 
    // ITEM - 4
    public List<ProductDocumentItem> getPaintItems() {
	return getProductItemsByType(CarServOrder.PAINT_ITEM);
    }



    // NEW* 
    // ITEM - 5
    public List<ProductDocumentItem> getDetailItems() {
	return getProductItemsByType(CarServOrder.DETAIL_ITEM);
    }

    
    
    // ITEM - PAINT TYPE
    public List<CarServOrderPaintType> getPaintTypes() {
	CarServOrder carServOrder = getCarServOrder();
	if (carServOrder == null) {
	    return  new ArrayList<CarServOrderPaintType>();
	}
	return getInvPaintTypes(carServOrder.getPaintTypeList());
    }
    
    
    
    
    private List<ProductDocumentItem> createEmptyList() {
	return new ArrayList<ProductDocumentItem>();
    }
    
    
    //////////////////////////////////////////////////////////
    
    protected List<ProductDocumentItem> getInvProductItems(List<ProductDocumentItem> inputList) {
	List<ProductDocumentItem> outputList = new ArrayList<ProductDocumentItem>();
	for (ProductDocumentItem item : inputList) {
	    CarServOrderItem orderItem = (CarServOrderItem) item;
	    // Add only this-inventory items 
	    if (this == orderItem.getInventory()) {
		outputList.add(item);
	    }

	}
	return outputList;
    }

    protected List<CarServOrderPaintType> getInvPaintTypes(List<CarServOrderPaintType> inputList) {
	List<CarServOrderPaintType> outputList = new ArrayList<CarServOrderPaintType>();
	for (CarServOrderPaintType paintType : inputList) {
	    // Add only this-inventory items 
	    if (this == paintType.getInventory()) {
		outputList.add(paintType);
	    }

	}
	return outputList;
    }

    //////////////////////////////////////////////////////////
    
    // ITEM - 1 
    public void addServiceItem(ProductDocumentItem item) {
	setInventory(item);
	getCarServOrder().addServiceItem(item);
    }
    
    // ITEM - 2
    public void addMaterialItem(ProductDocumentItem item) {
	setInventory(item);
	getCarServOrder().addMaterialItem(item);
    }

    // ITEM - 3
    public void addPartItem(ProductDocumentItem item) {
	setInventory(item);
	getCarServOrder().addPartItem(item);
    }

    //  OHA: ENABLE AFTER DISABLE PAINT ITEMS - CUSTOMER REQUIREMENTS :)
    
    //ITEM - 4
    public void addPaintItem(ProductDocumentItem item) {
	setInventory(item);
	getCarServOrder().addPaintItem(item);
    }

    
    
    
    // ITEM - ANY
    public void addProductItem(ProductDocumentItem item) {
	setInventory(item);
	getCarServOrder().addProductItem(item);
    }
    
    
    public void addPaintType(CarServOrderPaintType type) {
	type.setInventory(this);
	getCarServOrder().addPaintType(type);
    }
    
    /////////////////////////////////////////////////////////////
    
    protected void setInventory(ProductDocumentItem item) {
	CarServOrderItem orderItem = (CarServOrderItem) item;
	orderItem.setInventory(this);
    }
    
    /////////////////////////////////////////////////////////////
    
    public List<ProductDocumentItem> getProductItems() {
	CarServOrder carServOrder = getCarServOrder();
	if (carServOrder == null) {
	    return createEmptyList();
	}
	return getInvProductItems(carServOrder.getProductItems());
    }

    
    public void setDeletedAllProductItems() {
	//CarServOrder carServOrder = getCarServOrder();
	List<ProductDocumentItem> items = getProductItems();
	for (ProductDocumentItem item : items) {
	    CarServOrderItem orderItem = (CarServOrderItem) item;
	    orderItem.setInventory(null);
	    orderItem.setCarServOrderInventoryId(null);
	    orderItem.setDeleted();
	    //carServOrder.removeProductItem(orderItem, false);
	}
    }

    public void setDeletedAllPaintTypes() {
	//CarServOrder carServOrder = getCarServOrder();
	List<CarServOrderPaintType> paintTypes = getPaintTypes();
	for (CarServOrderPaintType paintType : paintTypes) {
	    
	    paintType.setInventory(null);
	    paintType.setCarServOrderInventoryId(null);
	    paintType.setDeleted();
	    //carServOrder.removePaintType(paintType, false);
	}
    }

    
    public void setDeletedAllChildren() {
	setDeletedAllProductItems();
	setDeletedAllPaintTypes();
    }
    
    public boolean isTotalInventory() {
	if (getDamage() == null) {
	    return false;
	}
	return getDamage().isTotalInventory(this);
    }
    
}
