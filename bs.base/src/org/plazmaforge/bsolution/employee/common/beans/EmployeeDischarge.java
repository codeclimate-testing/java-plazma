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


/**
 * @author Oleh Hapon
 * Date: 08.10.2004
 * Time: 8:21:09
 * $Id: EmployeeDischarge.java,v 1.2 2010/04/28 06:24:23 ohapon Exp $
 */
public class EmployeeDischarge extends Document {

    public static final String CLASS_ID = "EMPLOYEE_DISCHARGE";
    
    private EmployeeHeader employee;
    private DischargeType dischargeType;
    private Date dischargeDate;
    private int compensationDay;
    private int outputDay;
    private double pensionAmount;


    public DischargeType getDischargeType() {
        return dischargeType;
    }
    
    public String getDischargeTypeName() {
        return dischargeType == null ? null : dischargeType.getName();
    }
    
    
    public void setDischargeType(DischargeType dischargeType) {
        this.dischargeType = dischargeType;
    }
    
    public EmployeeHeader getEmployee() {
        return employee;
    }

    public String getEmployeeName() {
        return employee == null ? null : employee.getFullName();
    }

    
    public void setEmployee(EmployeeHeader employee) {
        this.employee = employee;
    }
    
    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }


    public int getCompensationDay() {
        return compensationDay;
    }

    public void setCompensationDay(int compensationDay) {
        this.compensationDay = compensationDay;
    }

    public int getOutputDay() {
        return outputDay;
    }

    public void setOutputDay(int outputDay) {
        this.outputDay = outputDay;
    }

    public double getPensionAmount() {
        return pensionAmount;
    }

    public void setPensionAmount(double pensionAmount) {
        this.pensionAmount = pensionAmount;
    }





}
