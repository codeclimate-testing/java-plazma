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

import org.plazmaforge.framework.ext.model.Dictionary;

/**
 * @author Oleh Hapon
 * Date: 24.10.2004
 * Time: 14:31:45
 * $Id: Payroll.java,v 1.3 2010/04/28 06:24:19 ohapon Exp $
 */
public class Payroll extends Dictionary {

    private PayrollType payrollType;
    private PayrollAlgoritmType payrollAlgoritmType;
    private PayrollAlgoritm payrollAlgoritm;
    private PayrollGroup payrollGroup;
    private PayrollMode payrollMode;    
    
    private int priority;
    private float payrollPercent;

    private boolean time;
    private boolean pension;
    private boolean tax;
    private boolean vacation;
    private boolean sick;
    private boolean fundSalary;
    private boolean fundHelp;
    private boolean fundInsurance;
    private boolean fundWork;
    private boolean salary13;
    private boolean salary12;
    private boolean addPay;




    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public float getPayrollPercent() {
        return payrollPercent;
    }

    public void setPayrollPercent(float percent) {
        this.payrollPercent = percent;
    }

    public boolean isTime() {
        return time;
    }

    public void setTime(boolean time) {
        this.time = time;
    }

    public boolean isPension() {
        return pension;
    }

    public void setPension(boolean pension) {
        this.pension = pension;
    }

    public boolean isTax() {
        return tax;
    }

    public void setTax(boolean tax) {
        this.tax = tax;
    }

    public boolean isVacation() {
        return vacation;
    }

    public void setVacation(boolean vacation) {
        this.vacation = vacation;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public boolean isFundSalary() {
        return fundSalary;
    }

    public void setFundSalary(boolean fundSalary) {
        this.fundSalary = fundSalary;
    }

    public boolean isFundHelp() {
        return fundHelp;
    }

    public void setFundHelp(boolean fundHelp) {
        this.fundHelp = fundHelp;
    }

    public boolean isFundInsurance() {
        return fundInsurance;
    }

    public void setFundInsurance(boolean fundInsurance) {
        this.fundInsurance = fundInsurance;
    }

    public boolean isFundWork() {
        return fundWork;
    }

    public void setFundWork(boolean fundWork) {
        this.fundWork = fundWork;
    }

    public boolean isSalary13() {
        return salary13;
    }

    public void setSalary13(boolean salary13) {
        this.salary13 = salary13;
    }

    public boolean isSalary12() {
        return salary12;
    }

    public void setSalary12(boolean salary12) {
        this.salary12 = salary12;
    }

    public boolean isAddPay() {
        return addPay;
    }

    public void setAddPay(boolean addPay) {
        this.addPay = addPay;
    }


    public String getPayrollTypeName() {
        return getPayrollType() == null ? null : getPayrollType().getName();
    }

    public String getPayrollAlgoritmTypeName() {
        return getPayrollAlgoritmType() == null ? null : getPayrollAlgoritmType().getName();
    }


    public String getPayrollAlgoritmName() {
        return getPayrollAlgoritm() == null ? null: getPayrollAlgoritm().getName();
    }


    public String getPayrollGroupName() {
        return getPayrollGroup() == null ? null : getPayrollGroup().getName();
    }


    public String getPayrollModeName() {
        return getPayrollMode() == null ? null : getPayrollMode().getName();
    }

    
    public PayrollAlgoritm getPayrollAlgoritm() {
        return payrollAlgoritm;
    }
    
    public void setPayrollAlgoritm(PayrollAlgoritm payrollAlgoritm) {
        this.payrollAlgoritm = payrollAlgoritm;
    }
    
    public PayrollAlgoritmType getPayrollAlgoritmType() {
        return payrollAlgoritmType;
    }
    
    public void setPayrollAlgoritmType(PayrollAlgoritmType payrollAlgoritmType) {
        this.payrollAlgoritmType = payrollAlgoritmType;
    }
    
    public PayrollGroup getPayrollGroup() {
        return payrollGroup;
    }
    
    public void setPayrollGroup(PayrollGroup payrollGroup) {
        this.payrollGroup = payrollGroup;
    }
    
    public PayrollMode getPayrollMode() {
        return payrollMode;
    }
    
    public void setPayrollMode(PayrollMode payrollMode) {
        this.payrollMode = payrollMode;
    }
    
    public PayrollType getPayrollType() {
        return payrollType;
    }
    
    public void setPayrollType(PayrollType payrollType) {
        this.payrollType = payrollType;
    }
}
