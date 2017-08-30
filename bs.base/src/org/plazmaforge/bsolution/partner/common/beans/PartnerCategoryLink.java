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
package org.plazmaforge.bsolution.partner.common.beans;

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * @author Oleh Hapon
 * Date: 14.09.2004
 * Time: 8:48:27
 * $Id: PartnerCategoryLink.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 */
public class PartnerCategoryLink extends BaseEntity {


    private PartnerHeader partner;

    private PartnerCategory partnerCategory;



    
    public PartnerHeader getPartner() {
        return partner;
    }
    
    public void setPartner(PartnerHeader partner) {
        this.partner = partner;
    }
    
    public PartnerCategory getPartnerCategory() {
        return partnerCategory;
    }
    
    public void setPartnerCategory(PartnerCategory partnerCategory) {
        this.partnerCategory = partnerCategory;
    }
    
    public String getPartnerCategoryName() {
        return partnerCategory == null ? null : partnerCategory.getName();
    }
    
}
