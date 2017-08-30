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

package org.plazmaforge.framework.core.criteria;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractCriteriaWorker<T> implements Serializable {
    
    private List<T> items;

    
    
    public List<T> getItems() {
	if (items == null) {
	    items = new ArrayList<T>();
	}
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
    
    public int getItemCount() {
	return items == null ? 0 : items.size();
    }
    
    public void addItem(T item) {
	getItems().add(item);
    }

    public T getItem(int index) {
	return getItems().get(index);
    }
    

    /**
     * Set the item.
     * Reset all items and set one item.
     * @param item
     */
    public void setItem(T item) {
	if (isSingle()) {
	    getItems().set(0, item);
	    return;
	}
	reset();
	getItems().add(item);
    }
    
    /**
     * Reset (clear) items
     *
     */
    public void reset() {
	if (items != null) {
	    items.clear();
	}
    }
    
    /**
     * Return true when count of items is zero.
     * @return
     */
    public boolean isReset() {
	return getItemCount() == 0;
    }
    
    
    /**
     * Return true when count of items is 1.
     * @return
     */
    public boolean isSingle() {
	return getItemCount() == 1;
    }

    public boolean isEmpty() {
	return items == null || items.isEmpty();
    }
    
    public boolean hasItems() {
	return !isEmpty();
    }

}
