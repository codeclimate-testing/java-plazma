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
 * Created on 26.07.2007
 *
 */

package org.plazmaforge.bsolution.contact;

import org.plazmaforge.bsolution.contact.common.beans.AddressType;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.beans.ContactType;
import org.plazmaforge.bsolution.contact.common.beans.PhoneType;
import org.plazmaforge.framework.ext.model.BaseEntity;
import org.plazmaforge.framework.platform.structure.ModuleContext;


/** 
 * @author Oleh Hapon
 * $Id: ContactContext.java,v 1.3 2010/12/05 07:55:56 ohapon Exp $
 */

public class ContactContext  extends BaseEntity implements ModuleContext {
    
    private ContactHeader responsible;
    
    private ContactType contactType;
    
    private AddressType addressType;
    
    private PhoneType phoneType;

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public ContactHeader getResponsible() {
        return responsible;
    }

    public void setResponsible(ContactHeader responsible) {
        this.responsible = responsible;
    }
    
    
    
    

}
