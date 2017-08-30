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

package org.plazmaforge.framework.client.swt.views;

import java.io.Serializable;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.plazmaforge.framework.client.swt.TableUtils;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.controls.TableProvider;
import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTTableView extends AbstractSWTTableView<Table, TableColumn, TableItem> implements ISWTTableView<Table, TableColumn, TableItem> {
    
    
   
    
      
    

    /**
     * Update the table.
     * Load new data from data list.
     */
    public void updateTable(List dataList) {
	
	int index = getTable().getSelectionIndex(); // Store selection index
	
	clearKeyRowMap(); // Clear row map
	getTable().setItemCount(0); // Reset row count
	
	setDataList(dataList); // Set data list and create index map
	
	int rowCount = getEntityCount();
	
	if (dataList != null && rowCount > 0) {
	    refreshTable();
	}
	updateTable(index); // Update position by selection index	
    }
    
    /**
     * Refresh the table.
     * Reload data from model.
     *
     */
    public void refreshTable() {
	int rowCount = getEntityCount();
	getTable().setItemCount(rowCount);
	
	if (isVirtualTable()) {
	    return;
	}
	for(int i = 0; i < rowCount; i++) {
	    TableItem item = getTable().getItem(i);
	    Object entity = getEntityFromModel(i);
	    updateTableItem(item, entity);
	}
	getTable().redraw();
    }

    /**
     * Return true when table is virtual
     * @return
     */
    protected boolean isVirtualTable() {
	return (getTable().getStyle() & SWT.VIRTUAL) != 0;
    }
    
    
    protected void updateTableItem(TableItem item, Object entity) {
	putKeyRow(item, getEntityId(entity));
        mapRow(item, entity);
    }
    
 
    

    public void setPosition(int index) {
	if (isForceFocus()) {
	    getTable().setFocus();  
	}
	int count = getTable().getItemCount();
	if (count == 0) {
	    return;
	}
	if (index < 0) {
	    getTable().setSelection(0);
	    return;
	}
	if (index < count) {
	    getTable().setSelection(index);
	} else if (count > 0) {
	    // Set last position
	    getTable().setSelection(count - 1);
	}	
    }  
    
    
    
    public int getPositionByEntity(Object entity) {
	int pos = -1;
	if (entity == null) {
	    return pos;
	}
	Serializable entityId = getEntityId(entity);
	if (entityId == null) {
	    return pos;
	}
	
        int count = getEntityCount();
	
	for (int i = 0; i < count; i++) {
	    Object curEntity = getEntityFromModel(i);
	    Serializable curEntityId = getEntityId(curEntity);
	    if (entityId.equals(curEntityId)) {
		return i;
	    }
	}
	return pos;
    }
    
     
    // ------------------------------------------------------------------------------------------------------------
    //
    // General change methods
    //
    // ------------------------------------------------------------------------------------------------------------
    
    
    /**
     * Add entity to view.
     * Add entity to model and update table item
     */
    public void addEntity(Object entity) {
	
	// Add entity to model
	addEntityToModel(entity);
	
	getTable().setItemCount(getTable().getItemCount() + 1);
	
	// Update Table Item if table in not virtual
	if (!isVirtualTable()) {
	    TableItem item = getTable().getItem(getTable().getItemCount() - 1);
	    updateTableItem(item, entity);
	}
	
	setPosition(getTable().getItemCount());
	
	updateTableState();
    }
    
    /**
     * Set entity to view.
     * Set entity to model and update table item.
     */
    public void setEntity(Object entity) {
	TableItem item = getSelectedRow();
	if (item == null) {
	    return;
        }
	int index = getSelectionIndex();
	
	// Set entity to model
	setEntityToModel(index, entity);
	
        mapRow(item, entity);
        
        getTable().redraw();
    }
    
 
    /**
     * Remove current entity from view.
     */
    public void removeEntity() {
	int index = getSelectionIndex();
	if (index < 0) {
	    return;
	}
	removeEntity(index);
    }
    
    /**
     * Remove entity by current index position.
     * Remove entity from model and update table.
     * @param index
     */
    public void removeEntity(int index) {
	removeEntityFromModel(index);
	getTable().remove(index);
	updateTable(index);
    }

    
    /**
     * Refresh view
     *
     */
    public void refresh() {
	refreshMaps();
	refreshTable();
    }

    
    /**
     * Refresh maps
     *
     */
    protected void refreshMaps() {
	fireModelChanged();
	clearKeyRowMap();
    }
    
    
    

    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected int getSortDirection(Table table) {
	return table.getSortDirection();
    }
    
    protected void setSortDirection(Table table, int direction) {
	table.setSortDirection(direction);
    }

    public int indexOfColumn(TableColumn column) {
	if (column == null) {
	    return -1;
	}
	Table table = column.getParent();
	return table.indexOf(column);
    }
    
    
    public int indexOfColumnItem(IColumnItem<TableColumn> item) {
	if (item == null) {
	    return -1;
	}
	return indexOfColumn(item.getColumn());
    }
    
    public boolean isSortColumn() {
	return getTable().getSortColumn() != null;
    }
    
    public void setDownSort(boolean isDown) {
	getTable().setSortDirection(getSortDirection(isDown));
    }
    
    public TableColumn getSortColumn(Table table) {
	return table.getSortColumn();
    }
    
    public void setSortColumn(Table table, TableColumn column) {
	table.setSortColumn(column);
    }
    
    public boolean isColumnVisible(TableColumn column) {
	if (column == null) {
	    return false;
	}
	return !(column.getWidth() == 0 && !column.getResizable());
    }
    
    public int getColumnWidth(TableColumn column) {
	return column.getWidth(); 
    }
    
    public void setColumnWidth(TableColumn column, int width) {
	column.setWidth(width);
    }

    public int getColumnAlignment(TableColumn column) {
	return column.getAlignment(); 
    }
    
    public boolean isColumnResizable(TableColumn column) {
	return column.getResizable();
    }
    
    public void setColumnResizable(TableColumn column, boolean resizable) {
	column.setResizable(resizable);
    }

    public String getColumnText(TableColumn column) {
	return column.getText();
    }
    
    public TableColumn[] getColumns() {
	return getTable().getColumns();
    }

    public int[] getColumnOrder() {
	return getTable().getColumnOrder();
    }
 
    public void setColumnOrder(int[] columnOrder) {
	getTable().setColumnOrder(columnOrder);
    }

    // SWT Table
    public TableColumn getColumn(int x, int y) {
	int columnIndex = TableUtils.getMouseEventColumn(getTable(), x, y);
	if (columnIndex < 0) {
	    return null;
	}
	return getTable().getColumn(columnIndex);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public TableItem getSelectedRow() {
	int index = getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	return getTable().getItem(index);
    }   
    
    public Object getEntityByRow(TableItem row) {
	if (row == null) {
	    return null;
	}
        int index = getTable().indexOf(row);
        return getEntityByIndex(index);
    }
    
    public int getSelectionIndex() {
	return getTable().getSelectionIndex();
    }
    
    protected void setDefaultColumnOrder() {
	Table table = getTable();
	if (table == null) {
	    return;
	}
	int[] order = table.getColumnOrder();
	if (order == null || order.length == 0) {
	    return;
	}
	for (int i = 0; i < order.length; i++) {
	    order[i] = i;
	}
	table.setColumnOrder(order);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public Menu getMenu() {
	return getTable().getMenu();
    }
     
    public void addSelectionListener(SelectionListener listener) {
	getTable().addSelectionListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorSelectionListener(listener);
    }
    
    public void addKeyListener(KeyListener listener) {
	getTable().addKeyListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorKeyListener(listener);
    }
    
    public void addMouseListener(MouseListener listener) {
	getTable().addMouseListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorMouseListener(listener);
	
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public int getRowCount() {
	return getTable().getItemCount();
    }
    
    public boolean setTableFocus() {
	Table table = getTable();
	if (table == null || table.isDisposed()) {
	    return false;
	}
	return table.setFocus();
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected ITableProvider<TableItem> createTableProvider() {
	ITableProvider<TableItem> tableProvider = new TableProvider();
	return tableProvider;
    }

    // Only SWT Table
    protected void initColumn(final Table table, final TableColumn column) {
	
	column.addSelectionListener(new SelectionListener() {
	    public void widgetSelected(SelectionEvent e) {
		
		if (StringUtils.isEmpty(column.getText())) {
		    return;
		}
		doSortColumnAction(table, column);
	    }

	    public void widgetDefaultSelected(SelectionEvent e) {
	    }	    
	});
	getColumnSettingMap().put(column, new ColumnSetting<Table, TableColumn, TableItem>(this, column));
    }

    protected TableViewHelper<Table, TableColumn, TableItem> createViewHelper() {
	return new TableViewHelper<Table, TableColumn, TableItem>(this);
    }

    
    
}
