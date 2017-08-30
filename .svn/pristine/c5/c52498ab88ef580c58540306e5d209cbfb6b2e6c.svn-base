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
package org.plazmaforge.bs.document.shared.entities;

import org.plazmaforge.bs.organization.shared.entities.IOrganizable;
import org.plazmaforge.bs.organization.shared.entities.IOrganizationTitle;
import org.plazmaforge.bs.partner.shared.entities.IPartnerTitle;
import org.plazmaforge.bs.security.shared.entities.UserHeader;

/**
 * 
 * @author ohapon
 *
 */
public class JournalDocument extends DocumentHeader implements IOrganizable {
	
    private static final long serialVersionUID = 6530760064979407866L;
    
    

    private IOrganizationTitle organization;
    
    private Integer periodId;
    
    private IPartnerTitle partner;    
   
    private UserHeader user;
    
    private String reason;
    
    private String note;

   
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public IOrganizationTitle getOrganization() {
	return organization;
    }

    public void setOrganization(IOrganizationTitle organization) {
	this.organization = organization;
    }
    
    public Integer getOrganizationId() {
	return organization == null ? null : organization.getId();
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
    public UserHeader getUser() {
        return user;
    }

    // TODO: Used attribute login !!!
    public String getUserName() {
        return user == null ? null : user.getLogin();
    }
  
    public void setUser(UserHeader user) {
        this.user = user;
    }
    
    public Integer getPeriodId() {
        return periodId;
    }
    
    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }
    
    public IPartnerTitle getPartner() {
        return partner;
    }

    public void setPartner(IPartnerTitle partner) {
        this.partner = partner;
    }
    
    public String getPartnerName() {
        return partner == null ? null : partner.getName();
    }    

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void populate(DocumentHeader header) {
        header.setId(getId());
        header.setDocumentType(getDocumentType());    
        header.setDocumentNo(getDocumentNo());
        header.setDocumentDate(getDocumentDate());
    }
	

}
