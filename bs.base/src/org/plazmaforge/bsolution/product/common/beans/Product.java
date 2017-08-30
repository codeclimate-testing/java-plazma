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
package org.plazmaforge.bsolution.product.common.beans;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.base.common.beans.BusinessableElement;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.base.common.beans.IBusinessable;
import org.plazmaforge.bsolution.base.common.beans.IBusinessableOwner;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountOwner;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryHolder;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;


/**
 * @author Oleh Hapon
 * Date: 02.07.2003
 * Time: 13:22:20
 * 
 * The Product of Organization
 */


public class Product extends ProductHeader implements IBusinessableOwner, IBusinessable, LedgerAccountOwner, ImageEntryHolder {

    /** Class ID **/
    private static final String CLASS_ID = "PRODUCT";

    
    
    public static final String AVAILABLE_QUANTITY = "AVAILABLE_QUANTITY"; 
    
    public static final String RESERVED_QUANTITY = "RESERVED_QUANTITY";
    
    public static final String EXPECTED_QUANTITY = "EXPECTED_QUANTITY";
    
    


    private ProductGroup productGroup;


    private Date startDate;

    private Date endDate;

    //-------------------------------------------------------
    // Code block
    // ------------------------------------------------------
    
 
    
    //
    

    private IPartnerTitle manufacturer;


    
    //-------------------------------------------------------
    // Quantity block
    // ------------------------------------------------------
    private double minQuantity;
    
    

    private double availableQuantity;

    private double reservedQuantity;

    private double expectedQuantity;
    
    //-------------------------------------------------------
    // Dimension block
    // ------------------------------------------------------    
    
    private Float width;
    
    private Float height;
    
    private Float length;
    
    private Unit dimensionUnit;
    
    // ------------------------------------------------------
    
    private Float weight;

    private Unit weightUnit;
    
    // ------------------------------------------------------
    
    private Integer warrantyPeriod;
    
    private Unit warrantyUnit;
    
    //  ------------------------------------------------------
    
    private List<ProductUnit> unitList;

    private List<ProductPrice> priceList;
    
    private List<ProductInstance> instanceList;

    private BusinessableElement businessableElement;

    private LedgerAccount ledgerAccount;

    ////
    
    private ImageEntry imageEntry;
    
    
    
    public Product() {
	businessableElement = createBusinessableElement();
	businessableElement.setOwner(this);
    }

    ////
    
    protected String getClassId() {
	return CLASS_ID;
    }

    ////

    

  

    public ProductGroup getProductGroup() {
	return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
	this.productGroup = productGroup;
    }
    
    public Integer getProductGroupId() {
	return productGroup == null ? null : productGroup.getId();
    }
    
    public String getProductGroupName() {
	return productGroup == null ? null : productGroup.getName();
    }

    
    

    
    
    

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }



    public List<ProductUnit> getUnitList() {
	if (unitList == null) {
	    unitList = new ArrayList<ProductUnit>();
	}
	return unitList;
    }

    public void setUnitList(List<ProductUnit> unitList) {
	this.unitList = unitList;
    }

    public void addUnit(ProductUnit item) {
	item.setProduct(this);
	getUnitList().add(item);
    }

    public void removeUnit(ProductUnit item) {
	item.setProduct(null);
	getUnitList().remove(item);
    }

    public boolean isFoundUnit(Unit unit) {
	if (unit == null) {
	    return false;
	}
	return isFoundUnit(unit.getId());
    }

    public boolean isFoundUnit(Integer unitId) {
	if (unitId == null) {
	    return false;
	}
	List<ProductUnit> productUnits = getUnitList();
	if (productUnits == null) {
	    return false;
	}
	for (ProductUnit pu : productUnits) {
	    if (pu.isDeleted()) {
		continue;
	    }
	    Integer id = pu.getUnit().getId();
	    if (unitId.equals(id)) {
		return true;
	    }
	}
	return false;
    }

    public List<ProductPrice> getPriceList() {
	if (priceList == null) {
	    priceList = new ArrayList<ProductPrice>();
	}
	return priceList;
    }

    public void setPriceList(List<ProductPrice> priceList) {
	this.priceList = priceList;
    }

    public void addPrice(ProductPrice item) {
	item.setProduct(this);
	getPriceList().add(item);
    }

    public void removePrice(ProductPrice item) {
	item.setProduct(null);
	getPriceList().remove(item);
    }

    
    ///
    public List<ProductInstance> getInstanceList() {
	if (instanceList == null) {
	    instanceList = new ArrayList<ProductInstance>();
	}
	return instanceList;
    }

    public void setInstanceList(List<ProductInstance> instanceList) {
	this.instanceList = instanceList;
    }

    public void addInstance(ProductInstance item) {
	item.setProduct(this);
	getInstanceList().add(item);
    }

    public void removeInstance(ProductInstance item) {
	item.setProduct(null);
	getInstanceList().remove(item);
    }
    
    ///
    
    public void init() {
	super.init();

	// Force initialize
	getUnitList().size();
	getPriceList().size();
	getInstanceList().size();
    }

    public Integer getBusinessableId() {
	return getId();
    }

    public String getBusinessableName() {
	return getFullName();
    }
    
    public Integer getOwnerId() {
	return getId();
    }

    public BusinessableElement getBusinessableElement() {
	return businessableElement;
    }

    public void setBusinessableElement(BusinessableElement businessableElement) {
	this.businessableElement = businessableElement == null ? createBusinessableElement() : businessableElement;
	this.businessableElement.setOwner(this);

    }

    protected BusinessableElement createBusinessableElement() {
	return new BusinessableElement();
    }

    public IPartnerTitle getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(IPartnerTitle manufacturer) {
	this.manufacturer = manufacturer;
    }

  

    public double getMinQuantity() {
	return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
	this.minQuantity = minQuantity;
    }

    public double getAvailableQuantity() {
	return availableQuantity;
    }

    public void setAvailableQuantity(double availableQuantity) {
	this.availableQuantity = availableQuantity;
    }

    public double getReservedQuantity() {
	return reservedQuantity;
    }

    public void setReservedQuantity(double reservedQuantity) {
	this.reservedQuantity = reservedQuantity;
    }

    public double getExpectedQuantity() {
	return expectedQuantity;
    }

    public void setExpectedQuantity(double expectedQuantity) {
	this.expectedQuantity = expectedQuantity;
    }

    public LedgerAccount getLedgerAccount() {
	return ledgerAccount;
    }

    public void setLedgerAccount(LedgerAccount ledgerAccount) {
	this.ledgerAccount = ledgerAccount;
    }

    ////
    
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }
    
    public Unit getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(Unit dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    ///
    
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Unit getWarrantyUnit() {
        return warrantyUnit;
    }

    public void setWarrantyUnit(Unit warrantyUnit) {
        this.warrantyUnit = warrantyUnit;
    }
    
    ////
    
    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Unit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(Unit weightUnit) {
        this.weightUnit = weightUnit;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    
    

    public double getPrice(PriceType priceType) {
	if (priceType == null) {
	    return getPrice();
	}
	
	
	if (PriceType.isBasePrice(priceType)) {
	    return getPrice();
	} else if (PriceType.isSmallWholesalePrice(priceType)) {
	    return getSmallWholesalePrice();	    
	} else if (PriceType.isWholesalePrice(priceType)) {
	    return getWholesalePrice();
	} else if (PriceType.isRetailPrice(priceType)) {
	    return getRetailPrice();
	}
	
	
	return 0d;
    }  

    
    /**
     * Return price in currency by price type
     * @param priceType
     * @return
     */

    public double getCurrencyPrice(PriceType priceType) {
	if (priceType == null) {
	    return getCurrencyPrice();
	}
	
	
	if (PriceType.isBasePrice(priceType)) {
	    return getCurrencyPrice();
	} else if (PriceType.isSmallWholesalePrice(priceType)) {
	    return getCurrencySmallWholesalePrice();	    
	} else if (PriceType.isWholesalePrice(priceType)) {
	    return getCurrencyWholesalePrice();
	} else if (PriceType.isRetailPrice(priceType)) {
	    return getCurrencyRetailPrice();
	}
	
	
	return 0d;
    }

    public double findPrice(PriceType priceType, Currency currency, Unit unit) {
	return findPrice(priceList,  priceType, currency, unit);
    }
    
    public double findPrice(List<ProductPrice> priceList,  PriceType priceType, Currency currency, Unit unit) {
	if (priceType == null || currency == null || unit == null) {
	    return 0d;
	}
	Integer priceTypeId = priceType.getId();
	Integer currencyId = currency.getId();
	Integer unitId = unit.getId();
	if (priceTypeId == null || currencyId == null || unitId == null) {
	    return 0d;
	}
	if (priceList == null || priceList.isEmpty()) {
	    return 0d; 
	}
	for (ProductPrice u : priceList) {
	    Integer uPriceTypeId = u.getPriceTypeId();
	    Integer uCurrencyId = u.getCurrencyId();
	    Integer uUnitId = u.getUnitId();
	    if (priceTypeId.equals(uPriceTypeId) && currencyId.equals(uCurrencyId) && unitId.equals(uUnitId)) {
		return u.getPrice();
	    }
	}
	return 0d;
    }

    //////////////////////////////////////////////////////////
    //
    // IMAGE ENTRY
    //
    //////////////////////////////////////////////////////////

    
    public ImageEntry getImageEntry() {
	if (imageEntry == null) {
	    imageEntry = new ImageEntryImpl();
	}
        return imageEntry;
    }

    public void setImageEntry(ImageEntry imageEntry) {
        this.imageEntry = imageEntry;
    }

    public String getImageFileName() {
	return getImageEntry().getFileName();
    }
    
    public void setImageFileName(String fileName) {
	getImageEntry().setFileName(fileName);
    }

    public String getImageAbsoluteFileName() {
	return getImageEntry().getAbsoluteFileName();
    }
    
    public void setImageAbsoluteFileName(String absoluteFileName) {
	getImageEntry().setAbsoluteFileName(absoluteFileName);
    }
    
    //////////////////////////////////////////////////////////

    
}
