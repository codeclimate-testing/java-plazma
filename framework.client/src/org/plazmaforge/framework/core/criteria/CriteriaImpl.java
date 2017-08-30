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


/**
 * 
 * @author Oleh Hapon
 * $Id: Criteria.java,v 1.1 2010/12/05 07:51:26 ohapon Exp $
 */
public class CriteriaImpl implements ICriteria {


    private CriteriaFilterSet filterSet;
    
    private CriteriaSorterSet sorterSet;
    
    private int from;
    
    private int size;


    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CriteriaFilterSet getFilterSet() {
        return filterSet;
    }

    public void setFilterSet(CriteriaFilterSet filterSet) {
        this.filterSet = filterSet;
    }

    public CriteriaSorterSet getSorterSet() {
        return sorterSet;
    }

    public void setSorterSet(CriteriaSorterSet sorterSet) {
        this.sorterSet = sorterSet;
    }
    
    public boolean isPaging() {
	return getSize() > 0 && getFrom() > -1;
    }
    
    public boolean hasFilter() {
	return filterSet != null && filterSet.hasItems();
    }
    
    public boolean hasSorter() {
	return sorterSet != null && sorterSet.hasItems();
    }
    
}
