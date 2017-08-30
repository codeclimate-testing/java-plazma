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

import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;


/**
 * Result information of Employee by period and organization
 * 
 * @author hapon
 *
 */
public class EmployeeResult extends BaseEntity {

    /** OrganizationHeader ID * */
    private Integer organizationId;

    /** Period ID * */
    private Integer periodId;

    /** Employee * */
    private EmployeeHeader employee;

    /** Employee Total ID * */
    private Integer employeeTotalId;

    private Integer workDay;

    private Float workHour;

    private Integer totalDay;

    private Float totalHour;

    private Double startBalance;

    private Double endBalance;

    private Double incrementAmount;

    private Double decrementAmount;

    private Double payrollAmount;
    
    

    public EmployeeHeader getEmployee() {
	return employee;
    }

    public void setEmployee(EmployeeHeader employee) {
	this.employee = employee;
    }

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

    public Integer getEmployeeTotalId() {
	return employeeTotalId;
    }

    public void setEmployeeTotalId(Integer employeeTotalId) {
	this.employeeTotalId = employeeTotalId;
    }

    public Double getDecrementAmount() {
	return decrementAmount;
    }

    public void setDecrementAmount(Double decrementAmount) {
	this.decrementAmount = decrementAmount;
    }

    public Double getEndBalance() {
	return endBalance;
    }

    public void setEndBalance(Double endBalance) {
	this.endBalance = endBalance;
    }

    public Double getIncrementAmount() {
	return incrementAmount;
    }

    public void setIncrementAmount(Double incrementAmount) {
	this.incrementAmount = incrementAmount;
    }

    public Double getPayrollAmount() {
	return payrollAmount;
    }

    public void setPayrollAmount(Double payrollAmount) {
	this.payrollAmount = payrollAmount;
    }

    public Double getStartBalance() {
	return startBalance;
    }

    public void setStartBalance(Double startBalance) {
	this.startBalance = startBalance;
    }

    public Integer getTotalDay() {
	return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
	this.totalDay = totalDay;
    }

    public Float getTotalHour() {
	return totalHour;
    }

    public void setTotalHour(Float totalHour) {
	this.totalHour = totalHour;
    }

    public Integer getWorkDay() {
	return workDay;
    }

    public void setWorkDay(Integer workDay) {
	this.workDay = workDay;
    }

    public Float getWorkHour() {
	return workHour;
    }

    public void setWorkHour(Float workHour) {
	this.workHour = workHour;
    }

    public String getEmployeeName() {
	return getEmployee() == null ? null : getEmployee().getFullName();
    }

    public String getEmployeeCode() {
	return getEmployee() == null ? null : getEmployee().getCode();
    }

    public String getDepartmentName() {
	return getEmployee() == null ? null : getEmployee().getDepartmentName();
    }

}
