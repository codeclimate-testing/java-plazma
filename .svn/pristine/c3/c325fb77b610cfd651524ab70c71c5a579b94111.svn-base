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

import org.plazmaforge.bsolution.employee.common.beans.Employable;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.framework.ext.model.BaseEntity;


/**
 * The Payroll of Employee.
 * The Employee has more payrolls. (Increment and decrement)
 * 
 * 
 * @author Oleh Hapon
 * Date: 24.10.2004
 * Time: 14:39:54
 * $Id: EmployeePayroll.java,v 1.4 2010/12/05 07:55:59 ohapon Exp $
 */
public class EmployeePayroll extends BaseEntity implements Employable {

    /**
     * Organization ID
     */
    private Integer organizationId;
    
    /**
     * Period ID
     */
    private Integer periodId;

    /**
     * Employee who has the payroll
     */
    private EmployeeHeader employee;

    /**
     * Payroll
     */
    private Payroll payroll;
    
    
    
    
    /**
     * Payroll date
     */
    private Date payrollDate;

    /**
     * Payroll/work day
     */
    private int payrollDay;

    /**
     * Payroll/work hour
     */
    private float payrollHour;
    
    /**
     * Payroll percent
     */
    private float payrollPercent;
    
    /**
     * Amount
     */
    private double amount;
    
    private String ownerType;
    
    private Integer ownerId;
    
    private double amountInc;
    
    private double amountDec;
    
    private int overrideMode;
    
    private boolean blockCalculate;
    
    private boolean blockWork;



    public EmployeeHeader getEmployee() {
        return employee;
    }
    
    public Integer getEmployeeId() {
        return getEmployee() == null ? null : getEmployee().getId();
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
    
    public Payroll getPayroll() {
        return payroll;
    }
    
    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }
    
    public Integer getPeriodId() {
        return periodId;
    }
    
    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }
    
    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date date) {
        this.payrollDate = date;
    }

    public int getPayrollDay() {
        return payrollDay;
    }

    public void setPayrollDay(int payrollDay) {
        this.payrollDay = payrollDay;
    }

    public float getPayrollHour() {
        return payrollHour;
    }

    public void setPayrollHour(float payrollHour) {
        this.payrollHour = payrollHour;
    }

    public float getPayrollPercent() {
        return payrollPercent;
    }

    public void setPayrollPercent(float payrollPercent) {
        this.payrollPercent = payrollPercent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }


    public Integer getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
    
    public double getAmountInc() {
        return amountInc;
    }

    public void setAmountInc(double amountInc) {
        this.amountInc = amountInc;
    }

    public double getAmountDec() {
        return amountDec;
    }

    public void setAmountDec(double amountDec) {
        this.amountDec = amountDec;
    }

    public int getOverrideMode() {
        return overrideMode;
    }

    public void setOverrideMode(int overrideMode) {
        this.overrideMode = overrideMode;
    }

    public boolean isBlockCalculate() {
        return blockCalculate;
    }

    public void setBlockCalculate(boolean blockCalculate) {
        this.blockCalculate = blockCalculate;
    }

    public boolean isBlockWork() {
        return blockWork;
    }

    public void setBlockWork(boolean blockWork) {
        this.blockWork = blockWork;
    }




    public String getPayrollCode() {
        return getPayroll() == null ? null : getPayroll().getCode();
    }


    public String getPayrollName() {
        return getPayroll() == null ? null : getPayroll().getName();
    }
    
    public String getPayrollTypeName() {
        return getPayroll() == null ? null : getPayroll().getPayrollTypeName();
    }
    

    public String getEmployeeCode() {
        return getEmployee() == null ? null : getEmployee().getCode();
    }

    public String getEmployeeName() {
        return getEmployee() == null ? null : getEmployee().getFullName();
    }


    public String getDepartmentName() {
        return getEmployee() == null ? null : getEmployee().getDepartmentName();
    }

}
