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

package org.plazmaforge.bsolution.goods.server.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.IExpressionCalculator;
import org.plazmaforge.framework.datawarehouse.TransferEvent;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.TransferTriggerAdapter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;
import org.plazmaforge.framework.sql.IDGenerator;
import org.plazmaforge.framework.util.StringUtils;

public class GoodsImporter extends AbstractDataSetImporter implements IDataSetImporter {

    private static String GOODS = "GOODS";
    
    private static String PRODUCT = "PRODUCT";
    
    private static String ID = "ID";
    
    private static String CODE = "CODE";
    
    private static String NAME = "NAME";
    
    private static String PRODUCT_GROUP_CODE = "PRODUCT_GROUP_CODE";
    
    private static String PRODUCT_GROUP_NAME = "PRODUCT_GROUP_NAME";
    
    private static String UNIT_NAME = "UNIT_NAME";
    
    private static String CURRENCY_CODE = "CURRENCY_CODE";
    
    private static String CURRENCY_PRICE = "CURRENCY_PRICE";
    
    private static String PRICE = "PRICE";
    
    
    private static String CURRENCY_ID = "CURRENCY_ID";
    
    private static String ORGANIZATION_ID = "ORGANIZATION_ID";
    
    private static String UNIT_ID = "UNIT_ID";
    
    private static String TAX_PERCENT = "TAX_PERCENT";
    
    private static String ADDPRICE_PERCENT = "ADDPRICE_PERCENT";
    
    private static String CURRENCY_RATE = "CURRENCY_RATE";
    
    private static String PRODUCT_GROUP_ID = "PRODUCT_GROUP_ID";
    
    
    
    private static String[] BASE_COLUMNS = {ID, CODE, NAME}; // Only PRODUCT columns
    
    private static String[] KEY_COLUMNS = {CODE}; // CODE is unique column of PRODUCT table
    
    
    private int CODE_COLUMN_INDEX = -1;
    
    private int NAME_COLUMN_INDEX = -1;
    
    private int CURRENCY_CODE_COLUMN_INDEX = -1;
    
    private int UNIT_NAME_COLUMN_INDEX = -1;
    
    private int CURRENCY_PRICE_COLUMN_INDEX = -1;
    
    private int PRODUCT_GROUP_CODE_COLUMN_INDEX = -1;
    
    
    private static Integer DEF_CURRENCY_ID = 1;
    
    private static Integer DEF_ORGANIZATION_ID = 1;
    
    private static Integer DEF_UNIT_ID = 1;
    
    
    
    private static Integer GOODS_TYPE_ID = GoodsType.GOODS_TYPE;
    
    public GoodsImporter() {
	super();
	setEnableClearTable(false);
	setEnableAutoPrimaryKey(false);
	setAutoPrimaryKey(true);
    }

    public void importDataSet(IImporter importer) throws ApplicationException {
	
	DSDataSet dataSet = getDataSet();
	
	TransferInfo transferInfo = getTransferInfo();
	transferInfo.setTableName(PRODUCT);
	transferInfo.setClearTable(false);
	transferInfo.setAutoPrimaryKey(true);
	transferInfo.setIdGenerateStrategy(IDGenerator.SEQUENCE_STRATEGY);
	transferInfo.setSequanceName("BUSINESSABLE_SEQUENCE");
	
	transferInfo.setSupportsUpdate(false); // NO UPDATE FOR BASE TABLE (BANK)
	
	List<FieldMapping> inputMapping = transferInfo.getMapping();
	
	CODE_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, CODE);
	NAME_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, NAME);
	CURRENCY_CODE_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, CURRENCY_CODE);
	UNIT_NAME_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, UNIT_NAME);
	CURRENCY_PRICE_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, CURRENCY_PRICE);
	PRODUCT_GROUP_CODE_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, PRODUCT_GROUP_CODE);
	
	GoodsTrigger trigger = new GoodsTrigger(); 
	List<FieldMapping> columnMapping = getTransformColumnMapping(inputMapping);
	addPrimaryKeyColumnMappingIfNeed(columnMapping, ID, Integer.class);

	addValueColumnMappingIfNeed(columnMapping, ORGANIZATION_ID, Integer.class, 1);
	addExpressionColumnMappingIfNeed(columnMapping, CURRENCY_ID, Integer.class, CURRENCY_ID, trigger);
	addExpressionColumnMappingIfNeed(columnMapping, UNIT_ID, Integer.class, UNIT_ID, trigger);
	addExpressionColumnMappingIfNeed(columnMapping, PRICE, Float.class, PRICE, trigger);
	addExpressionColumnMappingIfNeed(columnMapping, CURRENCY_PRICE, Float.class, CURRENCY_PRICE, trigger);
	addExpressionColumnMappingIfNeed(columnMapping, PRODUCT_GROUP_ID, Integer.class, PRODUCT_GROUP_ID, trigger);
	
	addValueColumnMappingIfNeed(columnMapping, TAX_PERCENT, Float.class, 0f);
	addValueColumnMappingIfNeed(columnMapping, ADDPRICE_PERCENT, Float.class, 0f);
	addValueColumnMappingIfNeed(columnMapping, CURRENCY_RATE, Float.class, 1f);

	
	transferInfo.setMapping(columnMapping);
	transferInfo.setTrigger(trigger);
	
	TransferResult transferResult = getTransferService().updateTable(dataSet, transferInfo);
	
	setTransferResult(transferResult);
    }

    protected String[] getBaseColumns() {
	return BASE_COLUMNS; 
    }

    protected String[] getKeyColumns() {
	return KEY_COLUMNS; 
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    
    class GoodsTrigger extends TransferTriggerAdapter implements IExpressionCalculator {

	
	private PreparedStatement businessableInsertStm;
	private PreparedStatement goodsInsertStm;
	
	private PreparedStatement businessableUpdateStm;
	
	private Object[] row;
	

	private PreparedStatement currencyLookupStm;
	private PreparedStatement unitLookupStm;
	private PreparedStatement productGroupLookupStm;
	
	private Map<String, Object> currencyMap = new HashMap<String, Object>(); 
	private Map<String, Object> unitMap = new HashMap<String, Object>();
	private Map<String, Object> productGroupMap = new HashMap<String, Object>();
	
	public Object getValue(String expression) throws ApplicationException {
	    if (expression == null) {
		return null;
	    }
	    try {
		if (CURRENCY_ID.equals(expression)) {
		    return getLookupId(currencyLookupStm, row, CURRENCY_CODE_COLUMN_INDEX, currencyMap, DEF_CURRENCY_ID);
		} else if (UNIT_ID.equals(expression)) {
		    return getLookupId(unitLookupStm, row, UNIT_NAME_COLUMN_INDEX, unitMap, DEF_UNIT_ID);
		} else if (CURRENCY_PRICE.equals(expression)) {
		    return getCurrencyPrice();
		} else if (PRICE.equals(expression)) {
		    // TODO: Must calculate price by currency rate
		    return getCurrencyPrice();
		} else if (PRODUCT_GROUP_ID.equals(expression)) {
		    return getLookupId(productGroupLookupStm, row, PRODUCT_GROUP_CODE_COLUMN_INDEX, productGroupMap, null);
		}
	    } catch (SQLException ex) {
		throw new ApplicationException("Calculate expression error: " + ex.getMessage());
	    }
	    return null;
	}

	private Object getCurrencyPrice() {
	    try {
		    Object value = getValue(row, CURRENCY_PRICE_COLUMN_INDEX);
		    if (value == null) {
			return 0f;
		    }
		    //TODO
		    if (value instanceof Number) {
			return ((Number) value).floatValue();
		    }
		    value = getConverter().convert((String) value, Float.class);
		    return (value == null) ? 0f : value;
	    } catch (Throwable t) {
		return 0f;
	    } 
	}
	
	
	public Object[] getRow() {
	    return row;
	}

	public void setRow(Object[] row) {
	    this.row = row;
	}

	
	
	public void init() throws ApplicationException, SQLException {
	    businessableInsertStm = getConnection().prepareStatement("INSERT INTO BUSINESSABLE (ID, ENTITY_ID, OWNER_ID, NAME) VALUES (?, ?, ?, ?)");
	    goodsInsertStm = getConnection().prepareStatement("INSERT INTO GOODS (ID, GOODS_TYPE_ID) VALUES (?, ?)");
	    businessableUpdateStm = getConnection().prepareStatement("UPDATE BUSINESSABLE SET NAME = ? WHERE ID IN (SELECT ID FROM PRODUCT WHERE CODE = ?)");
	    currencyLookupStm = getConnection().prepareStatement("SELECT ID FROM CURRENCY WHERE CODE = ?");
	    unitLookupStm = getConnection().prepareStatement("SELECT ID FROM UNIT WHERE NAME = ?");
	    productGroupLookupStm = getConnection().prepareStatement("SELECT ID FROM PRODUCT_GROUP WHERE CODE = ?");
	}

	public void dispose() throws ApplicationException, SQLException {
	    close(businessableInsertStm);
	    close(goodsInsertStm);
	    close(businessableUpdateStm);
	    close(currencyLookupStm);
	    close(unitLookupStm);
	    close(productGroupLookupStm);
	}

	public void doBeforeInsert(TransferEvent event) throws ApplicationException, SQLException {
	    
	    Object id = getId(event);
	    String name = getName(event);

	    businessableInsertStm.setObject(1, id);
	    businessableInsertStm.setObject(2, GOODS);
	    businessableInsertStm.setObject(3, id);
	    businessableInsertStm.setObject(4, name);

	    businessableInsertStm.executeUpdate();
	    
	}

	public void doAfterInsert(TransferEvent event) throws ApplicationException, SQLException {
	    Object id = getId(event);

	    goodsInsertStm.setObject(1, id);
	    goodsInsertStm.setObject(2, GOODS_TYPE_ID);
	    goodsInsertStm.executeUpdate();
	}

	public void doBeforeUpdate(TransferEvent event) throws ApplicationException, SQLException {
	    
	    String code = getCode(event);
	    
	    // We can't update row with empty CODE
	    if (StringUtils.isEmpty(code)) {
		return;
	    }
	    String name = getName(event);

	    businessableUpdateStm.setObject(1, name);
	    businessableUpdateStm.setObject(2, code);

	    businessableUpdateStm.executeUpdate();
	    
	}

	///////////////////////////////////////////////////////////////////////////////
	
	private Object getId(TransferEvent event) {
	    return event.pkValues[0];
	}
	
	private String getCode(TransferEvent event) {
	    return (String) event.row[CODE_COLUMN_INDEX];
	}
	
	private String getName(TransferEvent event) {
	    return (String) event.row[NAME_COLUMN_INDEX];
	}
	

	
    }
    
    
	

}
