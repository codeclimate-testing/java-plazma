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
import java.util.List;

import org.plazmaforge.framework.client.models.IObjectStore;
import org.plazmaforge.framework.core.datastorage.DSDataSet;



/** 
 * @author Oleh Hapon
 *
 */

public interface ITableView<T> extends IView {

    int CLIENT_CRITERIA_MODE = 1;
    
    int SERVER_CRITERIA_MODE = 2;
    

    int getCriteriaMode();

    void setCriteriaMode(int criteriaMode);
    
    
    void setClientCriteriaMode();

    void setServerCriteriaMode();
    
    
    
    boolean isForceRefreshAll();

    void setForceRefreshAll(boolean forceRefreshAll);
    
    
    
    T getTable();
    
    void setTable(T Table);
    
    
    
    void updateTable();
    
    void updateTable(List list);
    
    void updateTable(int index);
    
    
    
    void setPosition(int index); 
    
    int getPosition();
    
    int getSelectionIndex();
    
    Object getEntityByIndex(int index);
    
    int getEntityCount();
    
    void setPositionByEntity(Object entity);
    
    
    
    
    
    
    
    void initSortColumn();
    
    void resort();
    
    void find();
    
    void refresh();
    
    void refilter();
    
    void refreshTable();
    //
    
    
   
    Serializable getSelectedEntityId();
    
    Object getSelectedTableRow();
    
    Object getSelectedEntity();
    
    
    ////
    

    //
    
    public int getRowCount();
    
    boolean setTableFocus();
    
    void doFastFilter(int x, int y);
    
    void doInternalFilter(String property, Object value);
    
    void doInternalFilter(String property, List values);
    
    void initContextMenu();
    
    DSDataSet createDataSet();
    
    DSDataSet createDataSet(IObjectStore store);
    
    void resetColumnSettings();
    
   
}
