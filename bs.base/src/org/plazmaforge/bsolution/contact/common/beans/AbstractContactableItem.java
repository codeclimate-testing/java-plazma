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
 * Created on 22.06.2005
 *
 */
package org.plazmaforge.bsolution.contact.common.beans;

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * @author hapon
 * 
 * Abstract class for <code>ContactableItem</code>
 */
public abstract class AbstractContactableItem extends BaseEntity	implements ContactableItem {

    private ContactableElement contactableElement;

    private String note;
    
    private boolean isNewDef;

    public ContactableElement getContactableElement() {
	return contactableElement;
    }

    public void setContactableElement(ContactableElement contactableElement) {
	this.contactableElement = contactableElement;
	if (isNewDef) {
	    isNewDef = false;
	    setDefaultItem(true);
	}
    }

    public Integer getContactableId() {
	return getContactableElement().getId();
    }

    public boolean isDefaultItem() {
	if (getContactableElement() == null) {
	    return false;
	}
	return getContactableElement().isDefaultItem(this);
    }

    public void setDefaultItem(boolean b) {
	if (getContactableElement() == null) {
	    if (b) {
		isNewDef = true; // Save state
	    }
	    return;
	}
	if (b) {
	    getContactableElement().setDefaultItem(this);
	} else {
	    getContactableElement().resetDefaultItem(this);
	}

    }

    public void destroy() {
	super.destroy();

	getContactableElement().resetDefaultItem(this);
	// We have problem when use Hibernate
	// Property contactableElement must be not null
	// this.contactableElement = null;
    }

    public String getNote() {
	return note;
    }

    public void setNote(String note) {
	this.note = note;
    }

}
