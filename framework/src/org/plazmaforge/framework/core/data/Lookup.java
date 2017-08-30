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

/* 
 * Created on 08.08.2007
 *
 */

package org.plazmaforge.framework.core.data;

import java.util.List;

import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeContainer;
import org.plazmaforge.framework.ext.model.AttributeValue;



/** 
 * @author Oleh Hapon
 */

public class Lookup extends Enumeration implements ILookup {
    
    private AttributeContainer attributeContainer;
    
    public AttributeContainer getAttributeContainer() {
	if (attributeContainer == null) {
	    attributeContainer = new AttributeContainer();
	}
        return attributeContainer;
    }

    public void setAttributeContainer(AttributeContainer attributeContainer) {
        this.attributeContainer = attributeContainer;
    }
    
    public List<Attribute> getDeclareAttributes() {
	return getAttributeContainer().getDeclareAttributes();
    }

    public void setDeclareAttributes(List<Attribute> declareAttributes) {
	getAttributeContainer().setDeclareAttributes(declareAttributes);
    }
    
    public List<Attribute> getUnusedAttributes() {
	return getAttributeContainer().getUnusedAttributes();
    }


    public AttributeValue getAttribute(String code) {
	return getAttributeContainer().getAttribute(code);
    }
    
    public Object getAttributeValue(String code) {
	return getAttributeContainer().getAttributeValue(code);
    }

    public void setAttributeValue(String code, Object value) {
	getAttributeContainer().setAttributeValue(code, value);
    }
    
    public List<AttributeValue> getAttributes() {
	return getAttributeContainer().getAttributes();
    }

    public void setAttributes(List<AttributeValue> attributes) {
	 getAttributeContainer().setAttributes(attributes);
    }
    
    public void addAttribute(AttributeValue attribute) {
	getAttributeContainer().addAttribute(attribute);
    }
    
    public boolean removeAttribute(AttributeValue attribute) {
	return getAttributeContainer().removeAttribute(attribute);
   }


}
