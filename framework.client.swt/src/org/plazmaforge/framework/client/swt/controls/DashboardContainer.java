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

package org.plazmaforge.framework.client.swt.controls;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

public class DashboardContainer extends Composite {

    private int DEFAULT_COLUMN_COUNT = 2;
    
    private int MIN_COLUMN_COUNT = 1;
    
    private int MAX_COLUMN_COUNT = 10;
    
   
    public DashboardContainer(Composite parent, int style) {
	super(parent, style);
	GridLayout layout = new GridLayout(DEFAULT_COLUMN_COUNT, true);
	super.setLayout(layout);
    }
    
    public int getColumnCount() {
	return getGridLayout().numColumns;
    }
    
    public void setColumnCount(int columnCount) {
	if (columnCount < MIN_COLUMN_COUNT) {
	    columnCount = MIN_COLUMN_COUNT;
	} else if (columnCount > MAX_COLUMN_COUNT) {
	    columnCount = MAX_COLUMN_COUNT;
	}
	getGridLayout().numColumns = columnCount;
	layout();
    }
    
    
    private GridLayout getGridLayout() {
	return (GridLayout) getLayout();
    }
    
    public void setLayout(Layout layout) {
	// do nothing
    }
   
    public IDashboardWidget[] getWidgets() {
	Control[] children = getChildren();
	if (children == null || children.length == 0) {
	    return new IDashboardWidget[0]; 
	}
	List<IDashboardWidget> widgets = new ArrayList<IDashboardWidget>();
	for (Control child: children) {
	    if (!(child instanceof IDashboardWidget)) {
		continue;
	    }
	    widgets.add((IDashboardWidget) child); 
	}
	return widgets.toArray(new IDashboardWidget[0]);
    }
   
}
