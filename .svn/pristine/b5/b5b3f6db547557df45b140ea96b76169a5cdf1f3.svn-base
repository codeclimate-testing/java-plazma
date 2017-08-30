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

package org.plazmaforge.bsolution.product.server.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.plazmaforge.bsolution.base.common.MoveConstants;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.beans.ProductInfo;
import org.plazmaforge.bsolution.product.common.beans.ProductMoveInfo;
import org.plazmaforge.bsolution.product.common.beans.ProductStateInfo;
import org.plazmaforge.bsolution.product.common.services.ProductManagerService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.DBUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


/**
 * @author Oleh Hapon
 * $Id: ProductManagerServiceImpl.java,v 1.8 2010/12/05 07:55:56 ohapon Exp $
 */

public class ProductManagerServiceImpl extends JdbcDaoSupport implements ProductManagerService, MoveConstants {

    public ProductStateInfo getStateInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductStateInfo info =  new ProductStateInfo();
	info.setAvailableQuantity(getAvailableQuantity(periodId, productId));
	info.setReserveQuantity(getReserveQuantity(periodId, productId));
	info.setAwaitQuantity(getAwaitQuantity(periodId, productId));
	return info;
    }
    
    public ProductMoveInfo getMoveInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductMoveInfo info =  new ProductMoveInfo();
	ProductInfo[] list = getInfoList(periodId, productId);
	
	info.setStartQuantity(list[0].getIncomeQuantity() + list[1].getIncomeQuantity());
	info.setStartAmount(list[0].getIncomeAmount() + list[1].getIncomeAmount());
	
	info.setIncomeQuantity(list[2].getIncomeQuantity());
	info.setIncomeAmount(list[2].getIncomeAmount());

	info.setOutcomeQuantity(list[3].getOutcomeQuantity());
	info.setOutcomeAmount(list[3].getOutcomeAmount());
	
	info.setEndQuantity(info.getStartQuantity() + info.getIncomeQuantity() - info.getOutcomeQuantity());
	info.setEndAmount(info.getStartAmount() + info.getIncomeAmount() - info.getOutcomeAmount());
	
	return info;
    }
    
    /// -------------
    
    
    public double getAvailableQuantity(Integer periodId, Integer productId)  throws ApplicationException {
	checkParameters(periodId, productId);
	ProductInfo info = getTotalInfo(periodId, productId);
	return info.getIncomeQuantity() - info.getOutcomeQuantity();
    }
    
    
    public double getReserveQuantity(Integer periodId, Integer productId)  throws ApplicationException {
	checkParameters(periodId, productId);
	ProductInfo info = getReserveInfo(periodId, productId);
	return info.getOutcomeQuantity();
    }

    public double getAwaitQuantity(Integer periodId, Integer productId) throws ApplicationException {
	checkParameters(periodId, productId);
	ProductInfo info = getAwaitInfo(periodId, productId);
	return info.getIncomeQuantity();

    }
    
    protected double getDoubleValue(String sql) throws ApplicationException {
	return 0;
    }
    
    protected void checkParameters(Integer periodId, Integer productId) throws ApplicationException {
	if (periodId == null) {
	    throw new ApplicationException("PeriodId is null");
	}
	if (productId == null) {
	    throw new ApplicationException("ProductId is null");
	}
    }
    
    protected ProductInfoValue getProductInfoValue(String type, Integer periodId, Integer productId)  throws ApplicationException {
	String sql = " SELECT " +
	" SUM(pm.account_quantity)," + // " SUM(pm.quantity * pm.unit_rate)," +
	" SUM(pm.amount)" +
	" FROM product_move pm" +
	" INNER JOIN document d ON d.id = pm.owner_id" +
	" INNER JOIN document_type t ON t.id = d.document_type_id" +
	" INNER JOIN finance_document_type ft ON ft.document_type_id = t.id" +
	" WHERE ft.move_type = '" + type + "' AND d.period_id = " + periodId + " AND pm.product_id =" + productId;
	
	return getProductInfoValue(sql);

    }
    
    protected ProductInfoValue getProductInfoValue(String sql) throws ApplicationException {
	Statement stm = null;
	ResultSet rs = null;
	ProductInfoValue value = new ProductInfoValue(); 
	try {
	    stm = getConnection().createStatement();
	    rs = stm.executeQuery(sql);
	    if (rs.next()) {
		value.quantity = rs.getDouble(1);
		value.amount = rs.getDouble(2);
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(rs);
	    close(stm);
	}
	return value;
    }
    
    protected ProductInfo getRegisterInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("REGISTER");
	
	String sql = " SELECT "
		+ " debit_quantity,"
		+ " credit_quantity,"
		+ " debit_amount,"
		+ " credit_amount"
		+ " FROM product_register "
		+ " WHERE product_id = " + productId
		+ " AND period_id = " + periodId;
	
	Statement stm = null;
	ResultSet rs = null;
	try {
	    stm = getConnection().createStatement();
	    rs = stm.executeQuery(sql);
	    if (rs.next()) {
		info.setOutcomeQuantity(rs.getDouble(1));
		info.setIncomeQuantity(rs.getDouble(2));
		info.setOutcomeAmount(rs.getDouble(3));
		info.setIncomeAmount(rs.getDouble(4));
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(rs);
	    close(stm);
	}
	return info;
    }
    
    protected ProductInfo getRestInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("REST");
	ProductInfoValue value = getProductInfoValue(REST, periodId, productId);
	info.setIncomeQuantity(value.quantity); // INCOME
	info.setIncomeAmount(value.amount); // INCOME
	return info;
    }
    
    protected ProductInfo getIncomeInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("INCOME");
	ProductInfoValue value = getProductInfoValue(INPUT, periodId, productId);
	info.setIncomeQuantity(value.quantity); // INCOME
	info.setIncomeAmount(value.amount); // INCOME
	return info;
    }
    
    protected ProductInfo getOutcomeInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("OUTCOME");
	ProductInfoValue value = getProductInfoValue(OUTPUT, periodId, productId);
	info.setOutcomeQuantity(value.quantity); // OUTCOME
	info.setOutcomeAmount(value.amount); // OUTCOME
	return info;
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected ProductInfo getAwaitInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("EXPECTED");
	ProductInfoValue value = getProductInfoValue(ORDER_INPUT, periodId, productId);
	info.setIncomeQuantity(value.quantity); // INCOME
	info.setIncomeAmount(value.amount); // INCOME
	return info;
    }

    protected ProductInfo getReserveInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo info = new ProductInfo();
	info.setType("RESERVED");
	ProductInfoValue value = getProductInfoValue(ORDER_OUTPUT, periodId, productId);
	info.setOutcomeQuantity(value.quantity); // OUTCOME
	info.setOutcomeAmount(value.amount); // OUTCOME
	return info;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    protected ProductInfo[] getInfoList(Integer periodId, Integer productId)  throws ApplicationException {
	List<ProductInfo> list = new ArrayList<ProductInfo>();
	list.add(getRegisterInfo(periodId, productId));
	list.add(getRestInfo(periodId, productId));
	list.add(getIncomeInfo(periodId, productId));
	list.add(getOutcomeInfo(periodId, productId));
	return (ProductInfo[]) list.toArray(new ProductInfo[0]);
    }
    
    protected ProductInfo getTotalInfo(Integer periodId, Integer productId)  throws ApplicationException {
	ProductInfo[] list = getInfoList(periodId, productId);
	ProductInfo result = new ProductInfo();
	for (ProductInfo line : list ) {
	    result.addIncomeQuantity(line.getIncomeQuantity());
	    result.addOutcomeQuantity(line.getOutcomeQuantity());
	    result.addIncomeAmount(line.getIncomeAmount());
	    result.addOutcomeAmount(line.getOutcomeAmount());
	}
	return result;
    }
    
    protected void close(ResultSet rs) {
	DBUtils.close(rs);
    }

    protected void close(Statement stm) {
	DBUtils.close(stm);
    }
    
    
    public void calculateRest(Integer periodId) throws ApplicationException {
	Map<Integer, ProductInfo> productInfoMap = createProductInfoMap(periodId);
	if (productInfoMap.isEmpty()) {
	    return;
	}
	
	updateProductQuantity(productInfoMap, REST);
	updateProductQuantity(productInfoMap, ORDER_INPUT);
	updateProductQuantity(productInfoMap, ORDER_OUTPUT);
	
    }

    protected void updateProductQuantity(Map<Integer, ProductInfo> productInfoMap, String type) throws ApplicationException {

	if (productInfoMap.isEmpty()) {
	    return;
	}

	String quantityFieldName = getQuantityFieldNameByMoveType(type);
	
	PreparedStatement stm = null;
	
	try {
	    stm = getConnection().prepareStatement("UPDATE PRODUCT SET " + quantityFieldName + " = ? WHERE ID = ?");
	    
	    Set<Integer> keys = productInfoMap.keySet();
	    for (Integer productId : keys) {
		ProductInfo info = productInfoMap.get(productId);
		stm.setDouble(1, getQuantityValueByMoveType(type, info));
		stm.setInt(2, productId);
		stm.execute();
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(stm);
	}
    }

    protected double getQuantityValueByMoveType(String moveType, ProductInfo info) {
	
	if (moveType == null) {
	    return 0d;
	}
	
	if (MoveConstants.REST.equals(moveType) /*|| MoveConstants.INPUT.equals(moveType) || MoveConstants.OUTPUT.equals(moveType)*/) {
	    return info.getIncomeQuantity() - info.getOutcomeQuantity();
	}
	
	if (MoveConstants.ORDER_INPUT.equals(moveType)) {
	    return info.getExpectedQuantity();
	}

	if (MoveConstants.ORDER_OUTPUT.equals(moveType)) {
	    return info.getReservedQuantity();
	}
	
	return 0d;
	
    }
    
    
    protected String getQuantityFieldNameByMoveType(String moveType) {
	if (moveType == null) {
	    return null;
	}
	
	if (MoveConstants.REST.equals(moveType) /* || MoveConstants.INPUT.equals(moveType) || MoveConstants.OUTPUT.equals(moveType)*/) {
	    return Product.AVAILABLE_QUANTITY;
	}
	
	if (MoveConstants.ORDER_INPUT.equals(moveType)) {
	    return Product.EXPECTED_QUANTITY;
	}

	if (MoveConstants.ORDER_OUTPUT.equals(moveType)) {
	    return Product.RESERVED_QUANTITY;
	}
	
	return null;

    }

    
    protected Map<Integer, ProductInfo> createProductInfoMap(Integer periodId) throws ApplicationException {
	Map<Integer, ProductInfo> productInfoMap = new HashMap<Integer, ProductInfo>();
	populateProductInfoMap(productInfoMap, periodId);
	
	
	return productInfoMap;
    }
    
    protected void populateProductInfoMap(Map<Integer, ProductInfo> productInfoMap, Integer periodId) throws ApplicationException {
	
	populateRegisterInfo(productInfoMap, periodId); // REGISTER
	
	// Real moving
	populateProductInfo(productInfoMap, REST, periodId); // REST
	
	populateProductInfo(productInfoMap, INPUT, periodId); // INPUT
	
	populateProductInfo(productInfoMap, OUTPUT, periodId); // OUTPUT
	
	// Only for orders
	
	populateProductInfo(productInfoMap, ORDER_INPUT, periodId); // INPUT
	
	populateProductInfo(productInfoMap, ORDER_OUTPUT, periodId); // OUTPUT
    }
    
    
    protected void populateRegisterInfo(Map<Integer, ProductInfo> productInfoMap, Integer periodId)  throws ApplicationException {
	String sql = " SELECT "
	        + " product_id,"
		+ " debit_quantity,"
		+ " credit_quantity"
		+ " FROM product_register "
		+ " WHERE period_id = " + periodId;
	
	Statement stm = null;
	ResultSet rs = null;
	Integer productId = null;
	ProductInfo info = null;
	
	try {
	    stm = getConnection().createStatement();
	    rs = stm.executeQuery(sql);
	    while (rs.next()) {
		productId = rs.getInt(1);
		info = productInfoMap.get(productId);
		if (info == null) {
		    info = new ProductInfo();
		    productInfoMap.put(productId, info);
		}
		info.setOutcomeQuantity(rs.getDouble(2));
		info.setIncomeQuantity(rs.getDouble(3));
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(rs);
	    close(stm);
	}
    }
    
    
    protected void populateProductInfo(Map<Integer, ProductInfo> productInfoMap, String type, Integer periodId)  throws ApplicationException {
	
	String sql = " SELECT " +
	" product_id," +
	" SUM(pm.account_quantity)" + // " SUM(pm.quantity * pm.unit_rate)," +
	" FROM product_move pm" +
	" INNER JOIN document d ON d.id = pm.owner_id" +
	" INNER JOIN document_type t ON t.id = d.document_type_id" +
	" INNER JOIN finance_document_type ft ON ft.document_type_id = t.id" +
	" WHERE ft.move_type = '" + type + "' AND d.period_id = " + periodId +
	" GROUP BY pm.product_id";
	
	Statement stm = null;
	ResultSet rs = null;
	Integer productId = null;
	ProductInfo info = null;
	
	try {
	    stm = getConnection().createStatement();
	    rs = stm.executeQuery(sql);
	    while (rs.next()) {
		productId = rs.getInt(1);
		info = productInfoMap.get(productId);
		if (info == null) {
		    info = new ProductInfo();
		    productInfoMap.put(productId, info);
		}
		double quantity = rs.getDouble(2);
		if (REST.equals(type) || INPUT.equals(type)) {
		    info.addIncomeQuantity(quantity); // ADD QUANTITY
		    
		} else if (OUTPUT.equals(type)) {
		    info.addOutcomeQuantity(quantity); // ADD QUANTITY
		    
		} else if (ORDER_INPUT.equals(type)) {
		    info.setExpectedQuantity(quantity); // REPLACE QUANTITY
		    
		} else if (ORDER_OUTPUT.equals(type)) {
		    info.setReservedQuantity(quantity); // REPLACE QUANTITY
		}
		
		
	    }
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	} finally {
	    close(rs);
	    close(stm);
	}

    }
    
    private class ProductInfoValue {
	
	double quantity;
	
	double amount;
    }
    
    
    @Override
    public void setInfo(String info)  {
	
    }
    
    @Override
    public String getInfo() {
	return null;
    }
}
