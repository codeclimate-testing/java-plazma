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
package org.plazmaforge.bsolution.payroll.common.beans;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;


/**
 * @author Oleh Hapon
 * Date: 24.10.2004
 * Time: 14:50:18
 * $Id: EmployeeSicklist.java,v 1.3 2010/04/28 06:24:19 ohapon Exp $
 */
public class EmployeeSicklist extends Document {

    public static final String CLASS_ID = "EMPLOYEE_SICKLIST";

    private EmployeeHeader employee;

    private Date startDate;

    private Date endDate;

    private float sicklistPercent;

    private double averangeAmount;

    private SicklistType sicklistType;

    private SickType sickType;

    private String series;

    private SicklistAverangeType sicklistAverangeType;

    private double quarterPremium;

    private double yearPremium;

    private double singlePremium;

    private List<EmployeeSicklistAverange> averangeItems;

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

    public float getSicklistPercent() {
	return sicklistPercent;
    }

    public void setSicklistPercent(float sicklistPercent) {
	this.sicklistPercent = sicklistPercent;
    }

    public double getAverangeAmount() {
	return averangeAmount;
    }

    public void setAverangeAmount(double averangeAmount) {
	this.averangeAmount = averangeAmount;
    }

    public String getSeries() {
	return series;
    }

    public void setSeries(String series) {
	this.series = series;
    }

    public double getQuarterPremium() {
	return quarterPremium;
    }

    public void setQuarterPremium(double quarterPremium) {
	this.quarterPremium = quarterPremium;
    }

    public double getYearPremium() {
	return yearPremium;
    }

    public void setYearPremium(double yearPremium) {
	this.yearPremium = yearPremium;
    }

    public double getSinglePremium() {
	return singlePremium;
    }

    public void setSinglePremium(double singlePremium) {
	this.singlePremium = singlePremium;
    }

    public String getEmployeeName() {
	return getEmployee() == null ? null : getEmployee().getFullName();
    }

    public String getSicklistCalculateName() {
	return null;
    }

    public String getSicklistTypeName() {
	return getSicklistType() == null ? null : getSicklistType().getName();
    }

    public String getSickTypeName() {
	return getSickType() == null ? null : getSickType().getName();
    }

    public List<EmployeeSicklistAverange> getAverangeItems() {
	if (averangeItems == null) {
	    averangeItems = new ArrayList<EmployeeSicklistAverange>();
        }
	return averangeItems;
    }

    public void setAverangeItems(List<EmployeeSicklistAverange> averangeItems) {
	this.averangeItems = averangeItems;
    }

    public void addAverangeItem(EmployeeSicklistAverange item) {
	item.setEmployeeSicklist(this);
	this.getAverangeItems().add(item);
    }

    public void removeAverangeItem(EmployeeSicklistAverange item) {
	item.setEmployeeSicklist(null);
	this.getAverangeItems().remove(item);
    }

    public EmployeeHeader getEmployee() {
	return employee;
    }

    public void setEmployee(EmployeeHeader employee) {
	this.employee = employee;
    }

    public SicklistAverangeType getSicklistAverangeType() {
	return sicklistAverangeType;
    }

    public void setSicklistAverangeType(SicklistAverangeType sicklistAverangeType) {
	this.sicklistAverangeType = sicklistAverangeType;
    }

    public SicklistType getSicklistType() {
	return sicklistType;
    }

    public void setSicklistType(SicklistType sicklistType) {
	this.sicklistType = sicklistType;
    }

    public SickType getSickType() {
	return sickType;
    }

    public void setSickType(SickType sickType) {
	this.sickType = sickType;
    }

    public void init() {
	super.init();

	this.getAverangeItems().size();
    }

}
