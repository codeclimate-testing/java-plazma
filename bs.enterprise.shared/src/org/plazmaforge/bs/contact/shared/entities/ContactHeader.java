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

package org.plazmaforge.bs.contact.shared.entities;

import org.plazmaforge.bs.organization.shared.entities.IOrganizationTitle;
import org.plazmaforge.bs.partner.shared.entities.PartnerTitle;

/**
 * 
 * @author ohapon
 *
 */
public class ContactHeader extends ContactTitle implements IContactHeader {

    
    private static final long serialVersionUID = -8106753060343108475L;
    
    

    private ContactType contactType;

    private PartnerTitle partner;

    
    private Byte gender;
    
    ////
    
    private ContactTitle responsible;
    
    ////
    
    private DefContactPhone defPhone;

    private DefContactAddress defAddress;

    ////
    

    private IOrganizationTitle organization;

    public ContactType getContactType() {
	return contactType;
    }

    public void setContactType(ContactType contactType) {
	this.contactType = contactType;
    }

    public String getContactTypeName() {
	return contactType == null ? null : contactType.getName();
    }

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }
    
    public String getPartnerName() {
	return partner == null ? null : partner.getName();
    }
    
    public IOrganizationTitle getOrganization() {
	return organization;
    }

    public void setOrganization(IOrganizationTitle organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

    ////
    
    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }
    
    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }

    public String getResponsibleName() {
	return responsible == null ? null : responsible.getName();
    }
    
    ////
    
    public DefContactPhone getDefPhone() {
	return defPhone;
    }

    public void setDefPhone(DefContactPhone defPhone) {
	this.defPhone = defPhone;
    }

    public String getPhoneString() {
	return this.defPhone == null ? null : this.defPhone.getPhoneString();
    }

    public DefContactAddress getDefAddress() {
	return defAddress;
    }

    public void setDefAddress(DefContactAddress defContactableAddress) {
	this.defAddress = defContactableAddress;
    }

    public String getAddressString() {
	return this.defAddress == null ? null : this.defAddress.getAddressString();
    }

    public String getLocalityAddressString() {
	return this.defAddress == null ? null : this.defAddress.getLocalityAddressString();
    }
    
    public String getFullAddressString() {
	return this.defAddress == null ? null : this.defAddress.getFullAddressString();
    }
    
    
    public String getCityName() {
	return this.defAddress == null ? null : this.defAddress.getCityName();
    }
    
    public String getLocalityName() {
	return this.defAddress == null ? null : this.defAddress.getLocalityName();
    }     
    
    ////
    

}
