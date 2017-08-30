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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderDamage.java,v 1.3 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderDamage extends BaseEntity {

    /** Parent damage **/
    private CarServOrder carServOrder;
    
    private String damageCode;
    
    private Date damageDate;
    
    private IPartnerTitle insurer;
    
    private IPartnerTitle broker;
    
    private CarClass carClass;
    
    
    
    /** List of inventory **/
    private List<CarServOrderInventory> inventoryList;

    
    /**
     * Special CarServOrderInventory Id for total inventory
     */
    private Integer totalInventoryId;
    
    /**
     * Special CarServOrderInventory for total inventory
     */
    private CarServOrderInventory totalInventory;
    
    
    private double totalAmount;
    
    private double currencyTotalAmount;
    
    
    public CarServOrder getCarServOrder() {
        return carServOrder;
    }

    public void setCarServOrder(CarServOrder carServOrder) {
        this.carServOrder = carServOrder;
    }

    public String getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(String damageCode) {
        this.damageCode = damageCode;
    }

    public Date getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(Date damageDate) {
        this.damageDate = damageDate;
    }

    public IPartnerTitle getInsurer() {
        return insurer;
    }

    public void setInsurer(IPartnerTitle insurer) {
        this.insurer = insurer;
    }

    
    public IPartnerTitle getBroker() {
        return broker;
    }

    public void setBroker(IPartnerTitle broker) {
        this.broker = broker;
    }

    public String getBrokerName() {
        return broker == null ? null : broker.getName();
    }

    
    
    
    
    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }
    
    public String getCarClassName() {
        return carClass == null ? null : carClass.getName();
    }

    
    
    

    public List<CarServOrderInventory> getInventoryList() {
	if (inventoryList == null) {
	    inventoryList = new ArrayList<CarServOrderInventory>();
	}
        return inventoryList;
    }

    public void setInventoryList(List<CarServOrderInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    public void addInventory(CarServOrderInventory inventory) {
	getInventoryList().add(inventory);
	inventory.setDamage(this);
    }
    
    public void removeInventory(CarServOrderInventory inventory) {
	getInventoryList().remove(inventory);
	
	if (totalInventory != null && totalInventory == inventory) {
	    totalInventoryId = null; // NEW*
	    totalInventory = null;
	}

	//inventory.setDamage(null); // TODO
    }
    
    public boolean isEmptyInventories() {
	return (inventoryList == null || inventoryList.isEmpty());
    }
    
    public void init() {
	super.init();
	
	// Force initialize inventories
	getInventoryList().size();
	
	initInventories();
    }
    
    public void initInventories() {
	// Force initialize inventories
	List<CarServOrderInventory> inventories = getInventoryList();
	
	for (CarServOrderInventory inventory : inventories) {
	    if (totalInventoryId != null && totalInventoryId.equals(inventory.getId())) {
		totalInventory = inventory;
	    }
	    inventory.init();
	}
    }    

    public boolean isEmpty() {
	return (damageDate == null && insurer == null && isEmptyInventories());
    }
    
    public boolean isAdditionalRepair() {
	if (getCarServOrder() == null) {
	    return false;
	}
	return getCarServOrder().isAdditionalRepair(this);
    }

    public Integer getTotalInventoryId() {
        return totalInventoryId;
    }

    public void setTotalInventoryId(Integer totalInventoryId) {
        this.totalInventoryId = totalInventoryId;
    }

    public CarServOrderInventory getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(CarServOrderInventory totalInventory) {
        this.totalInventory = totalInventory;
    }

    public boolean isTotalInventory(CarServOrderInventory inventory) {
	if (inventory == null || totalInventory == null) {
	    return false;
	}
	return totalInventory == inventory;
    }
    
    
    public List<CarServOrderInventory> getSimpleInventoryList() {
	List<CarServOrderInventory> list = getInventoryList();
	if (list == null || totalInventory == null) {
	    return list;
	}
	List<CarServOrderInventory> result = new ArrayList<CarServOrderInventory>();
	for (CarServOrderInventory inventory: list) {
	    if (totalInventory != inventory) {
		result.add(inventory);
	    }
	}
	return result;
	
    }
    
    
    public boolean isEmptySimpleInventories() {
	if (isEmptyInventories()) {
	    return true;
	}
	List list = getSimpleInventoryList();
	return (list == null || list.isEmpty());
    }
    
    public int getSimpleInventoryCount() {
	if (isEmptyInventories()) {
	    return 0;
	}
	List list = getSimpleInventoryList();
	return (list == null ? 0 : list.size());
    }
    
    public void normalizeDamage() {
	if (isEmptySimpleInventories()) {
	    addEmptyInventory();
	}
	
	if (totalInventory == null) {
	    // Add total inventory (special inventory)
	    totalInventory = addEmptyInventory();
	}
    }
    
    public CarServOrderInventory addEmptyInventory() {
	CarServOrderInventory inventory = new CarServOrderInventory();
	addInventory(inventory);
	return inventory;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCurrencyTotalAmount() {
        return currencyTotalAmount;
    }

    public void setCurrencyTotalAmount(double currencyTotalAmount) {
        this.currencyTotalAmount = currencyTotalAmount;
    }
    
    public void resetTotalInventoryId() {
	this.totalInventoryId = null;
    }
    
    public void setTotalInventoryId() {
	totalInventoryId = totalInventory == null ? null : totalInventory.getId();
    }
    
    public void calculateTotalAmount() {
	if (totalInventory == null) {
	    setCurrencyTotalAmount(0);
	    setTotalAmount(0);
	    return;
	}
	List<ProductDocumentItem> items = totalInventory.getProductItems();
	double currencyAmount = 0;
	double amount = 0;
	for (ProductDocumentItem item : items) {
	    if (item.isDeleted()) {
		continue;
	    }
	    currencyAmount += item.getCurrencyAmountWithTax();
	    amount += item.getAmountWithTax();
	}
	setCurrencyTotalAmount(currencyAmount);
	setTotalAmount(amount);
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void removeTotalInventoryProductItems() {
	removeTotalInventoryProductItems(false);
    }
    
    public void removeTotalInventoryProductItems(boolean isAll) {
	if (totalInventory == null) {
	    return;
	}
	List<ProductDocumentItem> items = totalInventory.getProductItems();
	
	// We haven't any concurrent exception because we use different list
	// We iterate items (part of global list) but remove from global list 
	
	for (ProductDocumentItem item : items) {
	    
	    // STUB
	    /*
	    if (isAll || (!isAll && item.isAuto())) {
		removeProductItem(totalInventory, item);
	    }
	    */
	    
	    removeProductItem(totalInventory, item);
	}
    }

    public void removeAllTotalInventoryProductItems() {
	removeTotalInventoryProductItems(true);
    }
    
    protected void removeProductItem(CarServOrderInventory inventory, ProductDocumentItem item) {
	inventory.getCarServOrder().removeProductItem(item, false);
	//item.setDeleted();
    }
    
    private String generateTotalKey(CarServOrderItem item) {
	return "" + item.getProductId() + "." + item.getUnitId() + "." + item.getCarServComplexityId() + "." + item.getWorkerId();
    }

    private String generateTotalDetailKey(CarServOrderItem item) {
	return "" + item.getProductId() + "." + item.getUnitId();
    }

    
    public void addTotalInventoryProductItems() {
	
	if (totalInventory == null) {
	    return;
	}
	
	removeTotalInventoryProductItems();
	
	
	List<CarServOrderInventory> inventories = getSimpleInventoryList();
	String[] types = {CarServOrder.SERVICE_ITEM, CarServOrder.MATERIAL_ITEM, CarServOrder.PART_ITEM};
	for (String type: types) {
	    
	    
	    // Load product items from all inventories
	    List<ProductDocumentItem> typeItems = new ArrayList<ProductDocumentItem>();
	    for (CarServOrderInventory inventory:  inventories) {
		List<ProductDocumentItem> items = inventory.getProductItemsByType(type);
		if (items != null && !items.isEmpty()) {
		    typeItems.addAll(items);
		}
	    }
	    
	    // Create total product items
	    Map<String, CarServOrderItem> totalMap = new HashMap<String, CarServOrderItem>();
	    for (ProductDocumentItem productItem : typeItems) {
		
		CarServOrderItem item = (CarServOrderItem) productItem;
		String key = generateTotalKey(item);
		
		CarServOrderItem carServOrderItem = totalMap.get(key);
		if (carServOrderItem == null) {
		    
		    carServOrderItem = new CarServOrderItem();
		    carServOrderItem.setItemType(type);
		    carServOrderItem.setProduct(item.getProduct());
		    carServOrderItem.setUnit(item.getUnit());
		    carServOrderItem.setUnitRate(item.getUnitRate());
		
		    // ONLY FOR SERVICE
		    carServOrderItem.setCarServComplexity(item.getCarServComplexity());
		    carServOrderItem.setWorker(item.getWorker());
		    
		    
		    totalMap.put(key, carServOrderItem);
		}
		
		carServOrderItem.setQuantity(carServOrderItem.getQuantity() + item.getQuantity());
		
		// CURRENCY AMOUNT
		carServOrderItem.setCurrencyAmount(carServOrderItem.getCurrencyAmount() + item.getCurrencyAmount());
		carServOrderItem.setCurrencyAmountWithTax(carServOrderItem.getCurrencyAmountWithTax() + item.getCurrencyAmountWithTax());

		// AMOUNT
		carServOrderItem.setAmount(carServOrderItem.getAmount() + item.getAmount());
		carServOrderItem.setAmountWithTax(carServOrderItem.getAmountWithTax() + item.getAmountWithTax());
		
		// WORK HOUR: ONLY FOR SERVICE
		carServOrderItem.setWorkHour(carServOrderItem.getWorkHour() + item.getWorkHour());
		
		

	    }
	    
	    Collection<CarServOrderItem> totalItems = totalMap.values();
	    
	    for (CarServOrderItem item : totalItems) {
		double quantity = item.getQuantity(); 
		if (quantity != 0){
		    
		    // CURRENCY PRICE
		    item.setCurrencyPrice(item.getCurrencyAmount() / quantity);
		    item.setCurrencyPriceWithTax(item.getCurrencyAmountWithTax() / quantity);

		    // CURRENCY BASE PRICE (without discount and etc.)
		    // In total items we don't use discount
		    // base price in currency = price in currency 
		    item.setCurrencyBasePrice(item.getCurrencyPrice());
		    item.setCurrencyBasePriceWithTax(item.getCurrencyPriceWithTax());

		    
		    // PRICE
		    item.setPrice(item.getAmount() / quantity);
		    item.setPriceWithTax(item.getAmountWithTax() / quantity);
		    
		    // BASE PRICE
		    // base price = price
		    item.setBasePrice(item.getPrice());
		    item.setBasePriceWithTax(item.getPriceWithTax());
		    

		    // CURRENCY TAX
		    item.setCurrencyTaxAmount(item.getCurrencyAmountWithTax() - item.getCurrencyAmount());
		    item.setCurrencyTaxPrice(item.getCurrencyPriceWithTax() - item.getCurrencyPrice());
		    item.setCurrencyTaxBasePrice(item.getCurrencyBasePriceWithTax() - item.getCurrencyBasePrice());

		    // TAX
		    item.setTaxAmount(item.getAmountWithTax() - item.getAmount());
		    item.setTaxPrice(item.getPriceWithTax() - item.getPrice());
		    item.setTaxBasePrice(item.getBasePriceWithTax() - item.getBasePrice());
		    
		    
		    
		}
		
		totalInventory.addProductItem(item);
	    }
	    
	}
	    //
    }


    public CarServOrderItem createCarServOrderItem(String type, CarServOrderItem item) {
	CarServOrderItem carServOrderItem = new CarServOrderItem();
	carServOrderItem.setItemType(type);

	    
	// Populate car detail service attribute
	carServOrderItem.getCarDetailServAttribute().populate(item.getCarDetailServAttribute());
	    
	carServOrderItem.setProduct(item.getProduct());
	carServOrderItem.setUnit(item.getUnit());
	carServOrderItem.setUnitRate(item.getUnitRate());

	return carServOrderItem;
    }
    
    /**
     * Return grouping car detail list
     * @return
     */
    public List<CarServOrderItem> generateCarDetailList() {

	if (totalInventory == null) {
	    return null;
	}

	List<CarServOrderItem> resultList = new ArrayList<CarServOrderItem>();

	List<CarServOrderInventory> inventories = getSimpleInventoryList();
	String type = CarServOrder.DETAIL_ITEM;

	// Load product items from all inventories
	List<ProductDocumentItem> typeItems = new ArrayList<ProductDocumentItem>();
	for (CarServOrderInventory inventory : inventories) {
	    List<ProductDocumentItem> items = inventory.getDetailItems();
	    if (items != null && !items.isEmpty()) {
		typeItems.addAll(items);
	    }
	}

	// Create total product items
	Map<String, CarServOrderItem> totalMap = new HashMap<String, CarServOrderItem>();
	for (ProductDocumentItem productItem : typeItems) {

	    CarServOrderItem item = (CarServOrderItem) productItem;
	    String key = generateTotalDetailKey(item);

	    CarServOrderItem carServOrderItem = totalMap.get(key);
	    if (carServOrderItem == null) {

		carServOrderItem = createCarServOrderItem(type, item);
		carServOrderItem.setItemType(type);
		totalMap.put(key, carServOrderItem);
	    }
	    carServOrderItem.setQuantity(carServOrderItem.getQuantity() + item.getQuantity());

	}

	Collection<CarServOrderItem> totalItems = totalMap.values();

	for (CarServOrderItem item : totalItems) {
	    // TODO: Calculate values
	    resultList.add(item);
	}

	return resultList;
    }

    public List<CarServOrderItem> convertProductItemToOrderItem(List<ProductDocumentItem> items) {
	if (items == null) {
	    return null;
	}
	List<CarServOrderItem> resultList = new ArrayList<CarServOrderItem>();
	for (ProductDocumentItem item : items) {
	    resultList.add((CarServOrderItem) item);
	}
	return resultList;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public void removeTotalInventoryPaintTypes() {
	removeTotalInventoryPaintTypes(false);
    }
    
    public void removeTotalInventoryPaintTypes(boolean isAll) {
	if (totalInventory == null) {
	    return;
	}
	List<CarServOrderPaintType> paintTypes = totalInventory.getPaintTypes();
	if (paintTypes == null) {
	    return;
	}

	// We haven't any concurrent exception because we use different list
	// We iterate paintTypes (part of global list) but remove from global list 
	for (CarServOrderPaintType paintType : paintTypes) {
	    
	    // STUB
	    /*
	    if (isAll || (!isAll && paintType.isAuto())) {
		removePaintType(totalInventory, paintType);
	    }
	    */
	    
	    removePaintType(totalInventory, paintType);
	}
    }

    public void removeAllTotalInventoryPaintTypes() {
	removeTotalInventoryPaintTypes(true);
    }
    
    protected void removePaintType(CarServOrderInventory inventory, CarServOrderPaintType paintType) {
	inventory.getCarServOrder().removePaintType(paintType);
	//item.setDeleted();
    }
    
    private String generateTotalPaintTypeKey(CarServOrderPaintType paintType) {
	return "" + paintType.getCarPaintTypeId();
    }

    public void addTotalInventoryPaintTypes() {
	
	if (totalInventory == null) {
	    return;
	}
	
	removeTotalInventoryPaintTypes();
	
	if (getCarServOrder() == null) {
	    return;
	}
	
	
	List<CarServOrderPaintType> paintTypes = getCarServOrder().getPaintTypeList();
	if (paintTypes == null) {
	    return;
	}
	
	// Create total product items
	Map<String, CarServOrderPaintType> totalMap = new HashMap<String, CarServOrderPaintType>();
	
	
	for (CarServOrderPaintType paintType : paintTypes) {
	    
	    String key = generateTotalPaintTypeKey(paintType);
		
	    CarServOrderPaintType carServOrderPaintType = totalMap.get(key);
	    if (carServOrderPaintType == null) {
		
		carServOrderPaintType = new CarServOrderPaintType();
		carServOrderPaintType.setCarPaintType(paintType.getCarPaintType());
		
		totalMap.put(key, carServOrderPaintType);
		

	    }
		
	    // ELSE - IGNORE
	    
	 }
	
	
	Collection<CarServOrderPaintType> totalPaintTypes = totalMap.values();
	for (CarServOrderPaintType paintType : totalPaintTypes) {
	    totalInventory.addPaintType(paintType);
	}

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void addTotalInventory() {
	addTotalInventoryProductItems();
	addTotalInventoryPaintTypes();
    }
    

    public void removeTotalInventory() {
	removeTotalInventoryProductItems();
	removeTotalInventoryPaintTypes();
    }

    
}
