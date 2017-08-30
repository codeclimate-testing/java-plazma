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

package org.plazmaforge.framework.client.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.datastorage.DSDataSet;


/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractTableView<T> extends AbstractView implements ITableView<T> {
    

    
    private T table;
    
    
    private boolean forceRefreshAll;
    
    
    /**
     * Criteria mode (Client Mode, Server Mode)
     * Client Mode: Use filter and sorter at Client
     * Server Mode: Use filter and sorter at Server  
     */
    private int criteriaMode = CLIENT_CRITERIA_MODE;
    
    
    /**
     * Special index map for sort and filter mode
     * Use only for non sortable and filterable view 
     */
    protected Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    
    
    /**
     * Key Row map (TableItem, Serializable[ID])
     */
    private Map<Object, Serializable> keyRowMap = new HashMap<Object, Serializable>();
    
    
    /**
     * Flag to support index map
     */
    private boolean supportIndexMap;
    
    /**
     * Flag to support key row map
     */
    private boolean supportKeyRowMap;
    
    
    
    public boolean isForceRefreshAll() {
        return forceRefreshAll;
    }


    public void setForceRefreshAll(boolean forceRefreshAll) {
        this.forceRefreshAll = forceRefreshAll;
    }


    public T getTable() {
        return table;
    }


    public void setTable(T table) {
        this.table = table;
        initTable();
    }

    protected void initTable() {
	
    }

    public void updateView() {
	updateTable();
    }
    
    
    // -------------------------------------------------------------------------------------------------------------
    //
    // Model methods definition
    //
    // -------------------------------------------------------------------------------------------------------------
    
    protected void addEntityToModel(Object entity) {
	getModelDataList().add(entity);
	fireModelChanged();
    }
    
    protected void setEntityToModel(int index, Object entity) {
	getModelDataList().set(convertViewIndexToModelIndex(index), entity);
	fireModelChanged();
    }
    
    protected void removeEntityFromModel(int index) {
	int realIndex = convertViewIndexToModelIndex(index);
	int size = getModelDataList().size();
	// Check index
	if (realIndex >= 0 && realIndex < size) {
	    getModelDataList().remove(realIndex);
	}
	fireModelChanged();
    }    

    protected Object getEntityFromModel(int index) {
	return getModelDataList().get(convertViewIndexToModelIndex(index));
    }

    
    public Object getEntityByIndex(int index) {
	return getEntityFromModel(index);
    }

    
    /**
     * Return real count of entity (after filter)
     */
    public int getEntityCount() {
	return getIndexMap().size();
    }
    
    protected void setDataList(List dataList) {
	setDataListToModel(dataList);
	fireModelChanged();
    }
    
    protected void setDataListToModel(List dataList) {
	
	if (dataList == null) {
	    setModelDataList(null);
	} else {
	    List newList = new ArrayList();
	    newList.addAll(dataList);
	    setModelDataList(newList);
	}
	
    }
    
    protected int convertViewIndexToModelIndex(int index) {
	Integer v = getIndexMap().get(index);
	if (v == null) {
	    return index;
	}
	return v;
    }
    
    
    
    
    
    
    
    protected void fireModelChanged() {
	recreateIndexMap();
	afterChangeModel();
    }
    
    protected void afterChangeModel() {
	if (getViewHolder() == null) {
	    return;
	}
	getViewHolder().afterChangeModel();
    }

    public abstract void refresh();
    
    public void initContextMenu() {
	
    }
    
    public DSDataSet createDataSet() {
	return null;
    }


    public int getCriteriaMode() {
	if (criteriaMode < CLIENT_CRITERIA_MODE || criteriaMode > SERVER_CRITERIA_MODE) {
	    criteriaMode = CLIENT_CRITERIA_MODE;
	}
        return criteriaMode;
    }


    public void setCriteriaMode(int criteriaMode) {
        this.criteriaMode = criteriaMode;
    }


    public boolean isClientCriteriaMode() {
	return getCriteriaMode() == CLIENT_CRITERIA_MODE;
    }

    public boolean isServerCriteriaMode() {
	return getCriteriaMode() == SERVER_CRITERIA_MODE;
    }


    public void setClientCriteriaMode() {
	setCriteriaMode(CLIENT_CRITERIA_MODE);
    }

    public void setServerCriteriaMode() {
	setCriteriaMode(SERVER_CRITERIA_MODE);
    }
    
    protected void forceLoadData() {
	try {
	    ICriteria criteria = createCriteria();
	    getViewHolder().forceLoadDataByCriteria(criteria);
	    return;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public abstract ICriteria createCriteria();


    public boolean isSupportIndexMap() {
        return supportIndexMap;
    }


    public void setSupportIndexMap(boolean supportIndexMap) {
        this.supportIndexMap = supportIndexMap;
    }
    
    
    public boolean isSupportKeyRowMap() {
        return supportKeyRowMap;
    }


    public void setSupportKeyRowMap(boolean supportKeyRowMap) {
        this.supportKeyRowMap = supportKeyRowMap;
    }


    
    protected Map<Integer, Integer> getIndexMap() {
	if (indexMap == null) {
	    indexMap = createIndexMap();
	}
	return indexMap;
    }

    protected void recreateIndexMap() {
	if (!isSupportIndexMap()) {
	    return;
	}
	indexMap = createIndexMap();
    }
    
    
    protected Map<Integer, Integer> createIndexMap() {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	List list =  getDataModel().getDataList();
	if (list == null) {
	    return map;
	}
	for (int i = 0; i < list.size(); i++) {
	    map.put(i, i);
	}
	return map;
    }
    
    public Map<Object, Serializable> getKeyRowMap() {
	return keyRowMap;
    }
   
    protected void clearKeyRowMap() {
	if (!isSupportKeyRowMap() || keyRowMap == null) {
	    return;
	}
	keyRowMap.clear();
    }
    
    public void putKeyRow(Object row, Serializable id) {
	if (!isSupportKeyRowMap()) {
	    return;
	}
	getKeyRowMap().put(row, id);
    }
}
