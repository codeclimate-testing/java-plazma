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

import java.util.Date;

import org.plazmaforge.framework.ext.model.BaseEntity;


/**
 * Register of anything Register don't have currency. 
 * All amount presents in national many
 */

/**
 * @author Oleh Hapon 
 * Date: 16.08.2004 
 * Time: 20:45:17 
 * $Id: Register.java,v 1.3 2010/12/05 07:55:58 ohapon Exp $
 */
public class Register extends BaseEntity {

    /** Oraganization ID **/
    private Integer organizationId;

    /** Period ID **/
    private Integer periodId;

    /** Register date **/
    private Date registerDate;

    public Integer getOrganizationId() {
	return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
	this.organizationId = organizationId;
    }

    public Integer getPeriodId() {
	return periodId;
    }

    public void setPeriodId(Integer periodId) {
	this.periodId = periodId;
    }

    public Date getRegisterDate() {
	return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
	this.registerDate = registerDate;
    }

}
