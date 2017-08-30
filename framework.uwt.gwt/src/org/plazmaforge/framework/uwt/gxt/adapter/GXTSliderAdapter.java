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

package org.plazmaforge.framework.uwt.gxt.adapter;

import org.plazmaforge.framework.uwt.UIObject;
import org.plazmaforge.framework.uwt.widget.Slider;

public class GXTSliderAdapter extends GXTControlAdapter {
    
    public Object createDelegate(UIObject parent, UIObject element) {
	com.extjs.gxt.ui.client.widget.Slider xSlider = new com.extjs.gxt.ui.client.widget.Slider();
	com.extjs.gxt.ui.client.widget.form.SliderField xSliderField = new com.extjs.gxt.ui.client.widget.form.SliderField(xSlider);
	addToParent(getContent(parent.getDelegate()), xSliderField, element); // Add to parent
	return xSliderField;
    }

    protected com.extjs.gxt.ui.client.widget.form.SliderField getSliderField(Object delegate) {
	return (com.extjs.gxt.ui.client.widget.form.SliderField) delegate;
    }
    
    @Override
    public void setProperty(UIObject element, String name, Object value) {
	com.extjs.gxt.ui.client.widget.form.SliderField xSliderField = getSliderField(element.getDelegate());
	if (xSliderField == null) {
	    return;
	}
	if (Slider.PROPERTY_VALUE.equals(name)) {
	    xSliderField.setValue(intValue(value));
	    return;
	} 
	super.setProperty(element, name, value);
    }

    
    @Override
    public Object getProperty(UIObject element, String name) {
	com.extjs.gxt.ui.client.widget.form.SliderField xSliderField = getSliderField(element.getDelegate());
	if (xSliderField == null) {
	    return null;
	}
	if (Slider.PROPERTY_VALUE.equals(name)) {
	    return xSliderField.getValue();
	} 
	return super.getProperty(element, name);
    }

}