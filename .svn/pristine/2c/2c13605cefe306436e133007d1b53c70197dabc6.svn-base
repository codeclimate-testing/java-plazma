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
 * Created on 06.03.2005
 *
 */
package org.plazmaforge.bsolution.partner.common.beans;

import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountOwner;


/**
 * @author hapon
 *
 */
public class PartnerHeader extends PartnerTitle implements IPartnerHeader, LedgerAccountOwner {


    private PartnerGroup partnerGroup;

    private LedgerAccount ledgerAccount;

    private DefPartnerPhone defPhone;

    private DefPartnerAddress defAddress;

    private Integer bankAccountId;
    
    private PartnerType partnerType;
    
    ////
    
    private ContactTitle responsible;
    
    ////

    public PartnerGroup getPartnerGroup() {
	return partnerGroup;
    }

    public void setPartnerGroup(PartnerGroup partnerGroup) {
	this.partnerGroup = partnerGroup;
    }

    public String getPartnerGroupName() {
	return partnerGroup == null ? null : partnerGroup.getName();
    }

    public Integer getPartnerGroupId() {
	return partnerGroup == null ? null : partnerGroup.getId();
    }

    
    public LedgerAccount getLedgerAccount() {
	return ledgerAccount;
    }

    public void setLedgerAccount(LedgerAccount ledgerAccount) {
	this.ledgerAccount = ledgerAccount;
    }

    public void populate(PartnerHeader partnerHeader) {
	super.populate(partnerHeader);
	partnerHeader.setNec(getNec());
	partnerHeader.setTax(isTax());
	partnerHeader.setTaxDocNo(getTaxDocNo());
	partnerHeader.setIdn(getIdn());
	partnerHeader.setDescriminator(getDescriminator());
	partnerHeader.setPartnerGroup(getPartnerGroup());
	partnerHeader.setLedgerAccount(partnerHeader.getLedgerAccount());
	partnerHeader.setDefPhone(getDefPhone());
	partnerHeader.setDefAddress(getDefAddress());

    }

    ////
    
    public DefPartnerPhone getDefPhone() {
	return defPhone;
    }

    public void setDefPhone(DefPartnerPhone defPhone) {
	this.defPhone = defPhone;
    }

    public String getPhoneString() {
	return getDefPhone() == null ? null : getDefPhone().getPhoneString();
    }

    public DefPartnerAddress getDefAddress() {
	return defAddress;
    }

    public void setDefAddress(DefPartnerAddress defContactableAddress) {
	this.defAddress = defContactableAddress;
    }

    public String getAddressString() {
	return getDefAddress() == null ? null : getDefAddress().getAddressString();
    }

    public String getLocalityAddressString() {
	return getDefAddress() == null ? null : getDefAddress().getLocalityAddressString();
    }
    
    public String getFullAddressString() {
	return getDefAddress() == null ? null : getDefAddress().getFullAddressString();
    }
    
    
    public String getCityName() {
	return getDefAddress() == null ? null : getDefAddress().getCityName();
    }
    
    public String getLocalityName() {
	return getDefAddress() == null ? null : getDefAddress().getLocalityName();
    }    
    
    ////
    
    public Integer getBankAccountId() {
	return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
	this.bankAccountId = bankAccountId;
    }
    
    

    public PartnerType getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(PartnerType partnerType) {
        this.partnerType = partnerType;
    }

    public Integer getPartnerTypeId() {
        return partnerType == null ? null : partnerType.getId();
    }

    //////////////////////////////////////////////////////////
    
    public ContactTitle getResponsible() {
	return responsible;
    }

    public void setResponsible(ContactTitle responsible) {
	this.responsible = responsible;
    }
    
    public String getResponsibleName() {
	return responsible == null ? null : responsible.getName();
    }

}
