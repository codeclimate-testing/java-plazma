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

import java.util.List;

import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.core.criteria.AbstractCriteriaWorker;
import org.plazmaforge.framework.core.criteria.CriteriaSorter;
import org.plazmaforge.framework.core.criteria.ICriteriaSorter;
import org.plazmaforge.framework.core.criteria.CriteriaSorterSet;

/** 
 * @author Oleh Hapon
 *
 */

public class TableSorter<T, C, R> extends AbstractCriteriaWorker<TableSorterItem<C>> {

    private ISWTTableView<T, C, R> view;
    
    
    public TableSorter(ISWTTableView<T, C, R> view) {
	super();
	this.view = view;
	reset(view);
    }
    
    private void reset(ISWTTableView<T, C, R> view) {
	reset();
	
	// If no sort mode
	if (!view.isSortColumn()) {
	    return;
	}
	setItem(view.getSortColumn(), view.isDownSort());
    }
    
    public void setItem(C column, boolean isDown) {
	if (column == null) {
	    return;
	}
	TableSorterItem<C> item = new TableSorterItem<C>();
	item.setColumn(column);
	item.setDown(isDown);
	
	setItem(item);
    }

    public boolean isSortColumn(Object column) {
	if (column == null) {
	    return false;
	}
	if (isReset()) {
	    return false;
	}
	List<TableSorterItem<C>> items = getItems();
	for (TableSorterItem<C> item : items) {
	    if (column == item.getColumn()) {
		return true;
	    }
	}
	return false;
    }
    
    public boolean equals(List<TableSorterItem<C>> items) {
	if (items == null) {
	    return false;
	}
	if (items.size() != this.getItemCount()) {
	    return false;
	}
	int count = items.size(); 
	for (int i = 0; i < count; i++) {
	    TableSorterItem<C> item1 = items.get(i);
	    TableSorterItem<C> item2 = getItem(i);
	    if (!item1.equals(item2)) {
		return false;
	    }
	}
	return true;
    }

    public CriteriaSorterSet createCriteriaSorterSet(ITableProvider<R> tableProvider) {
	CriteriaSorterSet set = new CriteriaSorterSet();
	List<TableSorterItem<C>> items = getItems();
	if (items == null || items.isEmpty()) {
	    return set;
	}
	for (TableSorterItem<C> item : items) {
	    
	    ICriteriaSorter sorterItem = new CriteriaSorter();
	    sorterItem.setField(item.getField());
	    sorterItem.setDown(item.isDown());
	    set.addItem(sorterItem);
	    
	    
	    if (sorterItem.getField() != null) {
		continue;
	    }

	    int index = view.indexOfColumnItem(item);
	    if (index > -1) {
		String field = tableProvider.getColumnPropertyName(index);
		sorterItem.setField(field);
	    }

	    
	}
	return set;
    }
    
 

}
