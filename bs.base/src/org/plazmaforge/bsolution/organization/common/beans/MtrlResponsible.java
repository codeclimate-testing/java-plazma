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

package org.plazmaforge.bsolution.organization.common.beans;

import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;

/**
 * @author Oleh Hapon
 * Date: 06.05.2004
 * Time: 11:29:34
 * $Id: Responsible.java,v 1.2 2010/04/28 06:24:16 ohapon Exp $
 */
public class MtrlResponsible extends AbstractStructurable implements IStructurable {

    /** Class ID **/
    public static final String CLASS_ID = "MTRL_RESPONSIBLE";

  
    private Warehouse warehouse;

    private ContactTitle contact;
    

    protected String getClassId() {
	return CLASS_ID;
    }
    
  
    public ContactTitle getContact() {
	return contact;
    }

    public Integer getContactId() {
	return contact == null ? null : contact.getId();
    }

    public String getContactName() {
	return contact == null ? null : contact.getFullName();
    }

    public void setContact(ContactTitle contact) {
	this.contact = contact;
    }


    public Warehouse getWarehouse() {
	return warehouse;
    }

    public Integer getWarehouseId() {
	return warehouse == null ? null : getWarehouse().getId();
    }

    public String getWarehouseName() {
	return warehouse == null ? null : getWarehouse().getName();
    }

    public void setWarehouse(Warehouse warehouse) {
	this.warehouse = warehouse;
    }

    public String getName() {
	return getFullName();
    }

    public String getFullName() {
	return getContactName();
	//        if (getWarehouseName() == null) {
	//            return getContactName();
	//        } else {
	//            return getContactName() + "/" + getWarehouseName();
	//        }
    }

}
