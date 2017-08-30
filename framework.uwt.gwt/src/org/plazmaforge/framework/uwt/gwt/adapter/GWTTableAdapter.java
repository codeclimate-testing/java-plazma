/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

package org.plazmaforge.framework.uwt.gwt.adapter;

import org.plazmaforge.framework.uwt.UIObject;
import org.plazmaforge.framework.uwt.widget.table.Table;



public class GWTTableAdapter extends GWTCompositeAdapter {

    public Object createDelegate(UIObject parent, UIObject element) {
	com.google.gwt.user.client.ui.Panel parentDelegate = (com.google.gwt.user.client.ui.Panel) getParentContent(parent.getDelegate());
	com.google.gwt.user.client.ui.Grid delegate = new com.google.gwt.user.client.ui.Grid();
	parentDelegate.add(delegate); // Add to parent
	return delegate;
    }

    protected com.google.gwt.user.client.ui.Grid getGrid(Object delegate) {
	return (com.google.gwt.user.client.ui.Grid) delegate;
    }
    
    @Override
    public void setProperty(UIObject element, String name, Object value) {
	super.setProperty(element, name, value);
	//com.google.gwt.user.client.ui.Grid grid = getGrid(element.getDelegate());
	//if (grid == null) {
	//    return;
	//}
	//if (Table.PROPERTY_TEXT.equals(name)) {
	//   grid.setText(value == null ? "" : (String) value);
	//} 
    }
    
}
