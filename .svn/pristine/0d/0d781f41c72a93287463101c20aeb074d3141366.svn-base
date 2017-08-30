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
 * Created on 08.12.2008
 *
 */

package org.plazmaforge.bsolution.product.common.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author Oleh Hapon
 * $Id: ProductStock.java,v 1.2 2010/04/28 06:24:21 ohapon Exp $
 */

public class ProductStock implements Serializable {

    private Integer productId;
	
    private double quantity;
	
	
    private double oldQuantity;
	
    private double newQuantity;

    
    private List<ProductStockWarehouse> productStockWarehouse;
    
    
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getOldQuantity() {
        return oldQuantity;
    }

    public void setOldQuantity(double oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public double getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(double newQuantity) {
        this.newQuantity = newQuantity;
    }

    public List<ProductStockWarehouse> getProductStockWarehouse() {
	if (productStockWarehouse == null) {
	    productStockWarehouse = new ArrayList<ProductStockWarehouse>();
	}
        return productStockWarehouse;
    }

    public void setProductStockWarehouse(List<ProductStockWarehouse> productStockWarehouse) {
        this.productStockWarehouse = productStockWarehouse;
    }
    
    
    
}
