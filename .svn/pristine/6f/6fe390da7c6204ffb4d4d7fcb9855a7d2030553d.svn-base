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

/* 
 * Created on 09.06.2007
 *
 */

package org.plazmaforge.bsolution.product.client.swt.forms.common;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.common.beans.Unit;
import org.plazmaforge.bsolution.base.common.services.UnitService;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.beans.ProductUnit;
import org.plazmaforge.bsolution.product.common.services.ProductService;
import org.plazmaforge.framework.client.Environment;
import org.plazmaforge.framework.client.swt.controls.XCombo;

/** 
 * @author Oleh Hapon
 * $Id: XProductUnitCombo.java,v 1.2 2010/04/28 06:31:10 ohapon Exp $
 */

public class XProductUnitCombo extends XCombo {

    private boolean editableGoods = true;
    
    public XProductUnitCombo(Composite parent, int style) {
	super(parent, style);
	setKeyValueProperty("unit");
	setDisplayValueProperty("name");
    }

    public XProductUnitCombo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
	setKeyValueProperty("unit");
	setDisplayValueProperty("name");
    }
    
    public void init() {
	super.init();
	setKeyValueProperty("unit");
	setDisplayValueProperty("name");
    }
    
    
    public void initByProductId(Integer productId) {
	initByProductId(productId, false, null);
    }
    
    
    public void initByProductId(Integer productId, boolean isSetCurr, Unit unit) {
	try {
	    Unit currUnit = (Unit) getValue();
	    List<ProductUnit> dataList = null;
	    if (productId != null) {
		ProductService service = (ProductService) Environment.getServiceFactory().getService(ProductService.class);
		dataList = service.findUnitByProductId(productId);
	    } else {
		if (isEditableGoods()) {
		    UnitService service = (UnitService) Environment.getServiceFactory().getService(UnitService.class);
		    List<Unit> units = service.findAll();
		    dataList = new ArrayList<ProductUnit>();
		    for (Unit u : units) {
			ProductUnit pu = new ProductUnit();
			pu.setUnit(u);
			pu.setDefaultRate();
			dataList.add(pu);
		    }
		}
	    }
	    setFlatDataList(dataList);
	    
	    /*
	    if (isSetCurr && dataList != null && dataList.size() > 0) {
		ProductUnit pu = (ProductUnit) dataList.get(0);
		if (pu != null) {
		    Unit currUnit = pu.getUnit();
		    setValue(currUnit);

		}
	    }
	    */
	    
	    
	    if (dataList != null && dataList.size() > 0) {
		ProductUnit newProductUnit = null;
		
		/*
		if (isSetCurr) {
		    if (currUnit != null && currUnit.getId() != null) {
			Integer unitId = currUnit.getId();
			for (ProductUnit pu : dataList) {
			    if (unitId.equals(pu.getUnitId())) {
				newProductUnit = pu;
				break;
			    }
			}
		    }
		}
		*/
		
		
		
		if (unit != null) {
			Integer unitId = unit.getId();
			for (ProductUnit pu : dataList) {
			    if (unitId.equals(pu.getUnitId())) {
				newProductUnit = pu;
				break;
			    }
			}
		}
		
		
		if (newProductUnit == null) {
		    newProductUnit = dataList.get(0);
		}
		
		if (newProductUnit != null) {
		    currUnit = newProductUnit.getUnit();
		    setValue(currUnit);

		}
	    }

	    
	} catch (Exception ex) {
	    logger.error(ex);
	}
	
    }
    
    public String getDisplayText(Object value) {
	if (value == null) {
	    return getNullTextValue();
	}
	
	return ((Unit) value).getName();
    }
    
    public void initByProduct(Product product) {
	if (product == null) {
	    setFlatDataList(null);
	}
	List dataList = product.getUnitList();
	setFlatDataList(dataList);
    }
    
    /*
    public String getFormatText(String value) {
	if (value == null) {
	    return getNullTextValue();
	}
	return super.getFormatText(value);
    }
    */
    
    public double getRate() {
	Object refValue = getRefValue();
	if (refValue == null) {
	    return 0f;
	}
	if (!(refValue instanceof ProductUnit)) {
	    return 1d;
	}
	return ((ProductUnit) refValue).getRate();
    }
    
    ////
    
    public boolean isEditableGoods() {
        return editableGoods;
    }

    public void setEditableGoods(boolean editableGoods) {
        this.editableGoods = editableGoods;
    }

}
