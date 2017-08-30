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


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;


/**
 * @author Oleh Hapon
 * Date: 24.10.2004
 * Time: 15:40:38
 * $Id: EmployeeVacation.java,v 1.2 2010/04/28 06:24:19 ohapon Exp $
 */
public class EmployeeVacation extends Document {

    public static final String CLASS_ID = "EMPLOYEE_VACATION";
    
    
    private EmployeeHeader employee;
    private Date startDate;
    private Date endDate;
    private int day;
    private int addDay;
    private Date workStartDate;
    private Date workEndDate;
    private double averangeAmount;
    
    private VacationType vacationType;
    private VacationAverangeType vacationAverangeType;
    private VacationCalculate vacationCalculate;
    private VacationCalculate addVacationCalculate;
    
    private double quarterPremium;
    private double yearPremium;
    private double singlePremium;

    private List averangeItems;




    public VacationCalculate getAddVacationCalculate() {
        return addVacationCalculate;
    }
    
    public void setAddVacationCalculate(VacationCalculate addVacationCalculate) {
        this.addVacationCalculate = addVacationCalculate;
    }
    
    public EmployeeHeader getEmployee() {
        return employee;
    }
    
    public void setEmployee(EmployeeHeader employee) {
        this.employee = employee;
    }
    
    public VacationAverangeType getVacationAverangeType() {
        return vacationAverangeType;
    }
    
    public void setVacationAverangeType(VacationAverangeType vacationAverangeType) {
        this.vacationAverangeType = vacationAverangeType;
    }
    
    public VacationCalculate getVacationCalculate() {
        return vacationCalculate;
    }
    
    public void setVacationCalculate(VacationCalculate vacationCalculate) {
        this.vacationCalculate = vacationCalculate;
    }
    
    public VacationType getVacationType() {
        return vacationType;
    }
    
    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getAddDay() {
        return addDay;
    }

    public void setAddDay(int addDay) {
        this.addDay = addDay;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public Date getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(Date workEndDate) {
        this.workEndDate = workEndDate;
    }

    public double getAverangeAmount() {
        return averangeAmount;
    }

    public void setAverangeAmount(double averangeAmount) {
        this.averangeAmount = averangeAmount;
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


    public String getVacationTypeName() {
        return getVacationType() == null ? null : getVacationType().getName();
    }


    public String getVacationAverangeTypeName() {
        return getVacationAverangeType() == null ? null : getVacationAverangeType().getName();
    }


    public String getVacationCalculateName() {
        return getVacationCalculate() == null ? null : getVacationCalculate().getName();
    }


    public String getAddVacationCalculateName() {
        return getAddVacationCalculate() == null ? null : getAddVacationCalculate().getName();
    }

    public List getAverangeItems() {
        if (averangeItems == null) {
            averangeItems = new ArrayList();
        }
        return averangeItems;
    }

    public void setAverangeItems(List averangeItems) {
        this.averangeItems = averangeItems;
    }


    public void addAverangeItem(EmployeeVacationAverange item) {
        item.setEmployeeVacation(this);
        this.getAverangeItems().add(item);
    }


    public void removeAverangeItem(EmployeeVacationAverange item) {
	item.setEmployeeVacation(null);
	this.getAverangeItems().remove(item);
    }

    public void init() {
	super.init();

	this.getAverangeItems().size();
    }


}
