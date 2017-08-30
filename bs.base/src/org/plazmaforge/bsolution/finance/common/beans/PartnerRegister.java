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
package org.plazmaforge.bsolution.finance.common.beans;

import org.plazmaforge.bsolution.partner.common.beans.PartnerTitle;

/**
 * Partner register
 */

/**
 * @author Oleh Hapon 
 * Date: 16.08.2004 
 * Time: 20:49:22 
 * $Id: PartnerRegister.java,v 1.2 2010/04/28 06:24:25 ohapon Exp $
 */
public class PartnerRegister extends OperationRegister {

    /** Partner **/
    private PartnerTitle partner;

    public PartnerTitle getPartner() {
	return partner;
    }

    public void setPartner(PartnerTitle partner) {
	this.partner = partner;
    }

    public String getPartnerName() {
	return partner == null ? null : partner.getName();
    }

}