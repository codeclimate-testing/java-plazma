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


import org.plazmaforge.framework.core.criteria.CriteriaSorter;

/** 
 * @author Oleh Hapon
 *
 */

public class TableSorterItem<C> extends CriteriaSorter implements IColumnItem<C> {
    
    private C column;
    
    public TableSorterItem() {
	super();
    }
    
    public TableSorterItem(C column) {
	this(column, true);
    }

    public TableSorterItem(C column, boolean down) {
	super();
	this.column = column;
	setDown(down);
    }


    public C getColumn() {
        return column;
    }

    public void setColumn(C column) {
        this.column = column;
    }

    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	TableSorterItem item = (TableSorterItem) obj;
	C c1 = this.column;
	C c2 = (C) item.getColumn();
	boolean b1 = (c1 == c2);
	boolean b2 = item.isDown() == isDown();
	return b1 && b2;
    }

}
