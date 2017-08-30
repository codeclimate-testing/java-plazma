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

package org.plazmaforge.framework.datawarehouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.sql.IDGenerator;

/**
 * Table transfer info
 * 
 * @author ohapon
 *
 */
public class TransferInfo implements Serializable {

    
    /**
     * Only INSERT 
     */
    public static String INSERT_ACTION = "INSERT";
    
    /**
     * Only UPDATE
     */
    public static String UPDATE_ACTION = "UPDATE";
    
    /**
     * UPDATE or INSERT
     */
    public static String UPDATE_INSERT_ACTION = "UPDATE_INSERT";
    
   
    /**
     * UPDATE (old found rows), INSERT (new rows), DELETE (old not fount rows)
     */
    public static String SYNC_ACTION = "SYNC_UPDATE";
    
    
    /**
     *  DELETE
     */
    public static String DELETE_ACTION = "DELETE";

    
    
 
    
    /**
     * Name of table
     */
    private String tableName;
    
    /**
     * Name of sequence (only for sequence strategy generate PK)
     */
    private String sequanceName;
    
    
    /**
     * Field mapping SOURCE -> TARGET
     */
    private List<FieldMapping> mapping;
    
    /**
     * Transfer action 
     */
    
    private String action;
    
    /**
     * Clear table before action
     */
    private boolean clearTable;
    
    /**
     * Auto generate primary key 
     */
    private boolean autoPrimaryKey;

    
    private String idGenerateStrategy = IDGenerator.INCREMENT_STRATEGY;
    
    /**
     * Transfer trigger of row action
     */
    private ITransferTrigger trigger;

    
    private boolean supportsInsert = true;
    
    private boolean supportsUpdate = true;
    
    private boolean supportsDelete = true;
    
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSequanceName() {
        return sequanceName;
    }

    public void setSequanceName(String sequanceName) {
        this.sequanceName = sequanceName;
    }

    public List<FieldMapping> getMapping() {
        return mapping;
    }

    public void setMapping(List<FieldMapping> mapping) {
        this.mapping = mapping;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isClearTable() {
        return clearTable;
    }

    public void setClearTable(boolean clearTable) {
        this.clearTable = clearTable;
    }

    public boolean isAutoPrimaryKey() {
        return autoPrimaryKey;
    }

    public void setAutoPrimaryKey(boolean autoPrimaryKey) {
        this.autoPrimaryKey = autoPrimaryKey;
    }
    

    public static List<FieldMapping> getKeyMapping(List<FieldMapping> mapping, boolean isKey) {
	if (mapping == null || mapping.isEmpty()) {
	    return null;
	}
	List<FieldMapping> result = new ArrayList<FieldMapping>();
	for (FieldMapping c : mapping) {
	    if ((isKey && !c.isKey()) || (!isKey && c.isKey())) {
		continue;
	    }
	    result.add(c);
	}

	return result.isEmpty() ? null : result;
    }

    /**
     * Return list of mapping for KEYS (key = true)
     * @param mapping
     * @return
     */
    public static List<FieldMapping> getKeyMapping(List<FieldMapping> mapping) {
	return getKeyMapping(mapping, true);
    }
    
    public static boolean hasKeys(List<FieldMapping> mapping) {
	List<FieldMapping> keyMapping = getKeyMapping(mapping);
	return keyMapping != null && !keyMapping.isEmpty();
    }
    
    /**
     * Return list of mapping for UPDATE (key = false)
     * @param mapping
     * @return
     */
    public static List<FieldMapping> getUpdateMapping(List<FieldMapping> mapping) {
	return getKeyMapping(mapping, false);
    }

    
    public static boolean isInsertActionType(String action) {
	if (action == null) {
	    return true;
	}
	return  INSERT_ACTION.equals(action) || UPDATE_INSERT_ACTION.equals(action) || SYNC_ACTION.equals(action);
    }
    
    public static boolean isUpdateActionType(String action) {
	if (action == null) {
	    return true;
	}
	return  UPDATE_ACTION.equals(action) || UPDATE_INSERT_ACTION.equals(action) || SYNC_ACTION.equals(action);
    }
    
    public static boolean isKeyActionType(String action) {
	if (action == null) {
	    return true;
	}
	return  UPDATE_ACTION.equals(action) || UPDATE_INSERT_ACTION.equals(action) || SYNC_ACTION.equals(action) || DELETE_ACTION.equals(action);
    }


    public static boolean isAutoIncrementPK(String type) {
	if (type == null) {
	    return false;
	}
	// TODO: Must implement for Long type too
	return TypeUtils.isIntegerType(type);
    }

    public String getIdGenerateStrategy() {
        return idGenerateStrategy;
    }

    public void setIdGenerateStrategy(String idGenerateStrategy) {
        this.idGenerateStrategy = idGenerateStrategy;
    }

    public ITransferTrigger getTrigger() {
        return trigger;
    }

    public void setTrigger(ITransferTrigger trigger) {
        this.trigger = trigger;
    }

    public boolean isSupportsInsert() {
        return supportsInsert;
    }

    public void setSupportsInsert(boolean supportsInsert) {
        this.supportsInsert = supportsInsert;
    }

    public boolean isSupportsUpdate() {
        return supportsUpdate;
    }

    public void setSupportsUpdate(boolean supportsUpdate) {
        this.supportsUpdate = supportsUpdate;
    }

    public boolean isSupportsDelete() {
        return supportsDelete;
    }

    public void setSupportsDelete(boolean supportsDelete) {
        this.supportsDelete = supportsDelete;
    }

    
    
}
