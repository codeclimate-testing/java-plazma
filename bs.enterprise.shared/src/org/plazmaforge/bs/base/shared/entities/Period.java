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
package org.plazmaforge.bs.base.shared.entities;

import java.util.Date;

import org.plazmaforge.framework.ext.model.BaseEntity;

public class Period extends BaseEntity {

    private static final long serialVersionUID = 1402705146773118725L;
    

    private PeriodType periodType = new PeriodType();

    private Integer prevPeriodId;

    private Date startDate;

    private Date endDate;

    private String name;

    public PeriodType getPeriodType() {
	return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
	this.periodType = periodType;
    }

    public Integer getPrevPeriodId() {
	return prevPeriodId;
    }

    public void setPrevPeriodId(Integer prevPeriodId) {
	this.prevPeriodId = prevPeriodId;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
