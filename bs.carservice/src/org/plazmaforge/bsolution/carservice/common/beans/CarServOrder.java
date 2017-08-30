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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.finance.common.beans.IPartnerableDocument;
import org.plazmaforge.bsolution.partner.common.beans.PartnerRepresentative;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.bsolution.product.common.beans.WarehouseProductDocument;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrder.java,v 1.2 2010/04/28 06:22:48 ohapon Exp $
 */
public class CarServOrder extends WarehouseProductDocument implements IPartnerableDocument {

    
    public static final String CLASS_ID = "CAR_SERV_ORDER";
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // SPECIAL ITEM TYPES
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public final static String SERVICE_ITEM = "SERVICE";
    
    public final static String MATERIAL_ITEM = "MATERIAL";
    
    public final static String PART_ITEM = "PART"; // WE USE PART ITEMS FOR DETAIL IETMS TOO IN INVENTORY (OPIS)
    
    public final static String PAINT_ITEM = "PAINT"; // ENABLE AFTER DISABLE :)
    
    
    public final static String DETAIL_ITEM = PART_ITEM; // Temp value. Must use DETAIL value
    
    
    
    
    private final static String[] supportItemTypes = new String[] {SERVICE_ITEM, MATERIAL_ITEM, PART_ITEM, PAINT_ITEM};
    
    
    private Car car;
    


    /**
     * Car income date
     */
    private Date carIncomeDate;
    
    /**
     * Car outcome date
     */
    private Date carOutcomeDate;
    
    
    /**
     * Person who got the car. (Representative of partner) 
     */
    private PartnerRepresentative incomeRepresentative;
    
    /**
     * Person who gave the car. (Representative of partner)
     */
    private PartnerRepresentative outcomeRepresentative;
    
    
    private boolean paid;
    
    /** Damage list **/
    private List<CarServOrderDamage> damageList;
    
    private List<CarServOrderPaintType> paintTypeList;

    
    private List<CarServOrderImage> imageList;
    
    
    
    
    /**
     * The special damage Id for additional repair
     */
    private Integer additionalRepairId;
    
    /**
     * The special damage for additional repair
     */
    private CarServOrderDamage additionalRepair;
    


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getCarIncomeDate() {
        return carIncomeDate;
    }

    public void setCarIncomeDate(Date carIncomeDate) {
        this.carIncomeDate = carIncomeDate;
    }

    public Date getCarOutcomeDate() {
        return carOutcomeDate;
    }

    public void setCarOutcomeDate(Date carOutcomeDate) {
        this.carOutcomeDate = carOutcomeDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public List<CarServOrderDamage> getSimpleDamageList() {
	List<CarServOrderDamage> list = getDamageList();
	if (list == null || additionalRepair == null) {
	    return list;
	}
	List<CarServOrderDamage> result = new ArrayList<CarServOrderDamage>();
	for (CarServOrderDamage damage: list) {
	    if (additionalRepair != damage) {
		result.add(damage);
	    }
	}
	return result;
	
    }
    
    /**
     * Return first simple (real and not additional repair) damage
     * @return
     */
    public CarServOrderDamage getFirstDamage() {
	List<CarServOrderDamage> list = getSimpleDamageList();
	if (list == null || list.isEmpty()) {
	    return null;
	}
	return list.get(0);
    }
    
    /**
     * Return first simple (real and not total inventory) inventory
     * @return
     */
    public CarServOrderInventory getFirstInventory() {
	CarServOrderDamage firstDamage = getFirstDamage();
	if (firstDamage == null) {
	    return null;
	}
	List<CarServOrderInventory> list = firstDamage.getSimpleInventoryList();
	if (list == null || list.isEmpty()) {
	    return null;
	}
	return list.get(0);
	
    }
    
    public List<CarServOrderDamage> getDamageList() {
	if (damageList == null) {
	    damageList = new ArrayList<CarServOrderDamage>();
	}
        return damageList;
    }

    public void setDamageList(List<CarServOrderDamage> damageList) {
        this.damageList = damageList;
    }    
    
    public void addDamage(CarServOrderDamage damage) {
	getDamageList().add(damage);
	damage.setCarServOrder(this);
    }
    
    public void removeDamage(CarServOrderDamage damage) {
	getDamageList().remove(damage);
	
	if (additionalRepair != null && additionalRepair == damage) {
	    additionalRepairId = null;
	    additionalRepair = null;
	}
	
	//damage.setCarServOrder(null); // TODO
    } 
    
    public boolean isEmptyDamages() {
	return (damageList == null || damageList.isEmpty());
    }
    
    public boolean isEmptySimpleDamages() {
	if (isEmptyDamages()) {
	    return true;
	}
	List list = getSimpleDamageList();
	return (list == null || list.isEmpty());
    }
    
    public int getSimpleDamageCount() {
	if (isEmptyDamages()) {
	    return 0;
	}
	List list = getSimpleDamageList();
	return (list == null ? 0 : list.size());
    }
    

    ////

    // ALL - 1
    public List<ProductDocumentItem> getServiceItems() {
	return getProductItemsByType(SERVICE_ITEM);
    }

    // ALL - 2
    public List<ProductDocumentItem> getMaterialItems() {
	return getProductItemsByType(MATERIAL_ITEM);
    }
    
    // ALL - 3
    public List<ProductDocumentItem> getPartItems() {
	return getProductItemsByType(PART_ITEM);
    }
    
    // ALL - 4
    public List<ProductDocumentItem> getPaintItems() {
	return getProductItemsByType(PAINT_ITEM);
    }
    

    //////////////////////////////////////////////////////////
    
    // REPAIR - 1
    public List<ProductDocumentItem> getRepairServiceItems() {
	return getRepairProductItems(getServiceItems());
    }

    // REPAIR - 2
    public List<ProductDocumentItem> getRepairMaterialItems() {
	return getRepairProductItems(getMaterialItems());
    }
    
    // REPAIR - 3
    public List<ProductDocumentItem> getRepairPartItems() {
	return getRepairProductItems(getPartItems());
    }
    
    // REPAIR - 4
    public List<ProductDocumentItem> getRepairPaintItems() {
	return getRepairProductItems(getPaintItems());
    }
    

    //////////////////////////////////////////////////////////
    
    /**
     * Return ONLY REPAIR product items.
     * The Inventory is null in the repair item. 
     */
    protected List<ProductDocumentItem> getRepairProductItems(List<ProductDocumentItem> inputList) {
	List<ProductDocumentItem> outputList = new ArrayList<ProductDocumentItem>();
	for (ProductDocumentItem item : inputList) {
	    CarServOrderItem orderItem = (CarServOrderItem) item;
	    // Add only null-inventory items 
	    if (orderItem.getInventory() == null) {
		outputList.add(item);
	    }
	}
	return outputList;
    }
    
    //////////////////////////////////////////////////////////
    
    public void addServiceItem(ProductDocumentItem item) {
	super.addProductItem(item);
	item.setItemType(SERVICE_ITEM);
    }
    
    public void addMaterialItem(ProductDocumentItem item) {
	super.addProductItem(item);
	item.setItemType(MATERIAL_ITEM);
    }

    public void addPartItem(ProductDocumentItem item) {
	super.addProductItem(item);
	item.setItemType(PART_ITEM);
    }

    public void addPaintItem(ProductDocumentItem item) {
	super.addProductItem(item);
	item.setItemType(PAINT_ITEM);
    }


    ///
    
    public String[] getSupportItemTypes() {
	return supportItemTypes;
    }
    
    
    public void init() {
	super.init();
	
	// Initialize paint types
	getPaintTypeList().size();
	
	// Initialize damages
	initDamages();
	loadInventoriesToItems();
	
	getImageList().size();
    }
    
    public void initDamages() {
	// Force initialize damages
	List<CarServOrderDamage> damages = getDamageList();
	damages.size();
	for (CarServOrderDamage damage : damages) {
	    if (additionalRepairId != null && additionalRepairId.equals(damage.getId())) {
		additionalRepair = damage;
	    }
	    damage.init();
	}
    }

    public void normalizeDamages() {
	
	/*
	if (!isEmptyDamages()) {
	    return;
	}
	*/
	
	if (isEmptySimpleDamages()) {
	    // Add first empty damage
	    addEmptyDamage();
	}
	
	if (additionalRepair == null) {
	    // Add additional repair (special damage)
	    additionalRepair = addEmptyDamage();
	}

	List<CarServOrderDamage> damages = getDamageList();
	for (CarServOrderDamage damage : damages) {
	    damage.normalizeDamage();
	}

	
    }

    public void denormalizeDamages() {
	
	List<CarServOrderDamage> list = getSimpleDamageList();
	
	if (list == null) {
	    return;
	}
	
	// We can senormalize only one damage
	if (list.size() != 1) {
	    return;
	}
	CarServOrderDamage damage = list.get(0);
	if (!damage.isEmpty()) {
	    return;
	}
	removeDamage(damage);
	
	
	/*
	// We can senormalize only one damage
	if (getDamageList().size() != 1) {
	    return;
	}
	CarServOrderDamage damage = getDamageList().get(0);
	if (!damage.isEmpty()) {
	    return;
	}
	removeDamage(damage);
	*/
    }

    
    public CarServOrderDamage addEmptyDamage() {
	CarServOrderDamage damage = new CarServOrderDamage();
	damage.normalizeDamage();
	/*
	if (damage.isEmptyInventories()) {
	    CarServOrderInventory inventory = new CarServOrderInventory();
	    damage.addInventory(inventory);
	}
	*/
	addDamage(damage);
	return damage;
    }
    
    public void resetInventoryIds() {
	
	// Reset inventory ids in car serv order items 
	List<ProductDocumentItem> items = getProductItems();
	for (ProductDocumentItem item : items) {
	    ((CarServOrderItem) item).setCarServOrderInventoryId(null);
	}
	
	// Reset inventory ids in paint types
	List<CarServOrderPaintType> paintTypes = getPaintTypeList();
	for (CarServOrderPaintType type : paintTypes) {
	    type.setCarServOrderInventoryId(null);
	}
	
    }
    
    public void resetAdditionalRepairId() {
	
	// Reset additional repair Id
	additionalRepairId = null;
    }
    
    public void setInventoryIds() {

	CarServOrderInventory inventory = null;
	Integer inventoryId = null;

	// Reset inventory ids in car serv order items
	List<ProductDocumentItem> items = getProductItems();
	for (ProductDocumentItem item : items) {
	    CarServOrderItem orderItem = ((CarServOrderItem) item);
	    inventory = orderItem.getInventory();
	    inventoryId = inventory == null ? null : inventory.getId();
	    orderItem.setCarServOrderInventoryId(inventoryId);
	    /*
	    if (inventory != null) {
		orderItem.setCarServOrderInventoryId(inventory.getId());
	    }
	    */
	    
	    
	}

	// Reset inventory ids in paint types
	List<CarServOrderPaintType> paintTypes = getPaintTypeList();
	for (CarServOrderPaintType type : paintTypes) {
	    inventory = type.getInventory();
	    inventoryId = inventory == null ? null : inventory.getId();  
	    type.setCarServOrderInventoryId(inventoryId);
	}
	
    }
    
    
    public void setAdditionalRepairId() {
	additionalRepairId = (additionalRepair == null) ? null : additionalRepair.getId();
    }
    
    private void loadInventoriesToItems() {
	List<ProductDocumentItem> items = getProductItems();
	List<CarServOrderDamage> damages = getDamageList();
	if (damages.isEmpty()) {
	    return;
	}
	Map<Integer, CarServOrderInventory> map = new HashMap<Integer, CarServOrderInventory>();
	
	// Initialize inventory map (inventoryId, inventory)
	for (CarServOrderDamage damage : damages) {
	    List<CarServOrderInventory> inventories = damage.getInventoryList();
	    if (inventories.isEmpty()) {
		continue;
	    }
	    for (CarServOrderInventory inventory : inventories) {
		map.put(inventory.getId(), inventory);
	    }
	}

	// Set inventory to CarServOrderItem 
	for (ProductDocumentItem item : items) {
	    CarServOrderItem orderItem = ((CarServOrderItem) item);
	    Integer id = orderItem.getCarServOrderInventoryId();
	    orderItem.setInventory(map.get(id));
	}

	// Set inventory to CarServOrderPaintType 
	List<CarServOrderPaintType> paintTypes =  getPaintTypeList();
	for (CarServOrderPaintType item : paintTypes) {
	    Integer id = item.getCarServOrderInventoryId();
	    item.setInventory(map.get(id));
	}
	
    }
    
    
    public void resetTotalInventoryIds() {
	List<CarServOrderDamage> damages = getDamageList();
	for (CarServOrderDamage damage : damages) {
	    damage.resetTotalInventoryId();
	}
    }
    
    public void setTotalInventoryIds() {
	List<CarServOrderDamage> damages = getDamageList();
	for (CarServOrderDamage damage : damages) {
	    damage.setTotalInventoryId();
	}
    }
    
    //////////////////////////////////////////////

    public String getCarName() {
        return car == null ? null : car.getName();
    }

    
    public String getCarRegNumber() {
        return car == null ? null : car.getRegNumber();
    }

    public String getCarChassisNumber() {
        return car == null ? null : car.getChassisNumber();
    }

    public int getCarManufactureYear() {
        return car == null ? null : car.getManufactureYear();
    }

    public String getCarOwnerName() {
        return car == null ? null : car.getOwnerName();
    }

    
    /////////////////////////////////////////////
    
    
    public List<CarServOrderPaintType> getPaintTypeList() {
	if (paintTypeList == null) {
	    paintTypeList = new ArrayList<CarServOrderPaintType>();
	}
        return paintTypeList;
    }

    public void setPaintTypeList(List<CarServOrderPaintType> paintTypeList) {
        this.paintTypeList = paintTypeList;
    }

    public void addPaintType(CarServOrderPaintType paintType) {
	getPaintTypeList().add(paintType);
	paintType.setCarServOrder(this);
    }

    public void removePaintType(CarServOrderPaintType paintType) {
	getPaintTypeList().remove(paintType);
    }
    
    
    public PartnerRepresentative getIncomeRepresentative() {
        return incomeRepresentative;
    }

    public void setIncomeRepresentative(PartnerRepresentative incomeRepresentative) {
        this.incomeRepresentative = incomeRepresentative;
    }
    
    public String getIncomeRepresentativeName() {
        return incomeRepresentative == null ? null : incomeRepresentative.getName();
    }
    
    public String getIncomeRepresentativePhone() {
        return incomeRepresentative == null ? null : incomeRepresentative.getPhone();
    }

    
    
    public PartnerRepresentative getOutcomeRepresentative() {
        return outcomeRepresentative;
    }

    public void setOutcomeRepresentative(PartnerRepresentative outcomeRepresentative) {
        this.outcomeRepresentative = outcomeRepresentative;
    }
    
    public String getOutcomeRepresentativeName() {
        return outcomeRepresentative == null ? null : outcomeRepresentative.getName();
    }
    
    public String getOutcomeRepresentativePhone() {
        return outcomeRepresentative == null ? null : outcomeRepresentative.getPhone();
    }

    public CarServOrderDamage getAdditionalRepair() {
        return additionalRepair;
    }

    public void setAdditionalRepair(CarServOrderDamage additionalRepair) {
        this.additionalRepair = additionalRepair;
    }

    public Integer getAdditionalRepairId() {
        return additionalRepairId;
    }

    public void setAdditionalRepairId(Integer additionalRepairId) {
        this.additionalRepairId = additionalRepairId;
    }
    
    public boolean isAdditionalRepair(CarServOrderDamage damage) {
	if (damage == null || additionalRepair == null) {
	    return false;
	}
	return additionalRepair == damage;
    }

    
    public List<CarServOrderImage> getImageList() {
	if (imageList == null) {
	    imageList = new ArrayList<CarServOrderImage>();
	}
        return imageList;
    }
    
    
    public List<CarServOrderImage> getImageList(String recordType) {
	List<CarServOrderImage> allImages = getImageList();
	if (recordType == null) {
	    return allImages;
	}
	List<CarServOrderImage> result = new ArrayList<CarServOrderImage>();
	if (allImages == null || allImages.isEmpty() || recordType == null) {
	    return result;
	}
	for (CarServOrderImage item : allImages) {
	    if (recordType.equals(item.getRecordType())) {
		result.add(item);
	    }
	}
	return result;
    }

    public void setImageList(List<CarServOrderImage> imageList) {
        this.imageList = imageList;
    }
    
    
    public void addImage(CarServOrderImage image) {
	getImageList().add(image);
	image.setCarServOrder(this);
    }

    public void removeImage(CarServOrderImage image) {
	getImageList().remove(image);
    }

    public boolean isSyncDocumentResponsible() {
	return false;
    }

}
