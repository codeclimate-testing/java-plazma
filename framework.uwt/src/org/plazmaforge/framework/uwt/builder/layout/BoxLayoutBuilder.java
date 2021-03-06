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

package org.plazmaforge.framework.uwt.builder.layout;

import org.plazmaforge.framework.core.data.object.IData;
import org.plazmaforge.framework.uwt.UIObject;
import org.plazmaforge.framework.uwt.builder.UIBuilder;
import org.plazmaforge.framework.uwt.layout.BoxLayout;
import org.plazmaforge.framework.uwt.widget.Layout;
import org.plazmaforge.framework.uwt.widget.Style.Orientation;

public class BoxLayoutBuilder extends AbstractLayoutBuilder {

    @Override
    public boolean accept(String type) {
	return type == null ? false: (UIBuilder.BOX_LAYOUT_TYPE.equals(type) || "BoxLayout".equals(type));
    }

    @Override
    protected Layout createLayout(IData data) {
	Orientation orientation = getOrientation(data, BoxLayout.PROPERTY_ORIENTATION);
	if (orientation != null) {
	    return new BoxLayout(orientation);
	}
	return new BoxLayout();
    }
        
    protected void populate(IData data, UIObject element) {
	if (data == null || element == null) {
	    return;
	}
	populateMargin(data, element);
    }


  

}
