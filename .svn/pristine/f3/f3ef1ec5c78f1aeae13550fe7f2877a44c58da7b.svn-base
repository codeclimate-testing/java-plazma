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

package org.plazmaforge.bsolution.employee.common.beans;


import java.util.Date;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollForm;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;


/**
 * @author Oleh Hapon
 * Date: 08.10.2004
 * Time: 8:20:57
 * $Id: EmployeeReception.java,v 1.2 2010/04/28 06:24:23 ohapon Exp $
 */
public class EmployeeReception extends Document {

    public static final String CLASS_ID = "EMPLOYEE_RECEPTION";

    private PersonHeader person;
    private Department department;
    private String employeeCode;
    private Date receptionDate;
    private EmployeeCategory employeeCategory;
    private EmployeeRank employeeRank;
    private PayrollForm payrollForm;
    private double salary;
    private double tariff;
    private float premiumPercent;
    private float sickPercent;


    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public EmployeeCategory getEmployeeCategory() {
        return employeeCategory;
    }
    
    public void setEmployeeCategory(EmployeeCategory employeeCategory) {
        this.employeeCategory = employeeCategory;
    }
    
    public EmployeeRank getEmployeeRank() {
        return employeeRank;
    }
    
    public void setEmployeeRank(EmployeeRank employeeRank) {
        this.employeeRank = employeeRank;
    }
    
    public PayrollForm getPayrollForm() {
        return payrollForm;
    }
    
    public void setPayrollForm(PayrollForm payrollForm) {
        this.payrollForm = payrollForm;
    }
    
    public PersonHeader getPerson() {
        return person;
    }
    
    public void setPerson(PersonHeader person) {
        this.person = person;
    }
    
    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getEmployeeRankName() {
        return employeeRank == null ? null : employeeRank.getName();
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public float getPremiumPercent() {
        return premiumPercent;
    }

    public void setPremiumPercent(float premiumPercent) {
        this.premiumPercent = premiumPercent;
    }

    public float getSickPercent() {
        return sickPercent;
    }

    public void setSickPercent(float sickPercent) {
        this.sickPercent = sickPercent;
    }

    public String getPersonName() {
        return person == null ? null : person.getFullName();
    }

    public String getDepartmentName() {
        return department == null ? null : department.getName();
    }


    public String getEmployeeCategoryName() {
        return employeeCategory == null ? null : employeeCategory.getName();
    }



    public String getPayrollFormName() {
        return payrollForm == null ? null : payrollForm.getName();
    }


}
