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
import java.util.List;

import org.plazmaforge.bsolution.base.common.beans.BusinessableElement;
import org.plazmaforge.bsolution.base.common.beans.IBusinessableOwner;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountOwner;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollForm;
import org.plazmaforge.framework.config.object.IEntityConfigurable;


/**
 * @author Oleh Hapon Date: 02.07.2003 Time: 12:58:48
 */
public class Employee extends EmployeeHeader implements /*IEntityConfigurable,*/ IContactableOwner, IBusinessableOwner, LedgerAccountOwner {

    /** Class ID **/
    public static final String CLASS_ID = "EMPLOYEE";


    private Date startDate;

    private Date endDate;

    private boolean tax;

    private EmployeeCategory employeeCategory;

    private EmployeeRank employeeRank;

    private PayrollForm payrollForm;

    private String employeeAccount;

    private int taxPrivilege;

    private double salary;

    private double tariff;

    private double advance;

    private float premiumPercent;

    private float sickPercent;

    private int totalSeniorityYear;

    private int totalSeniorityMonth;

    private int totalSeniorityDay;

    private int unbrokenSeniorityYear;

    private int unbrokenSeniorityMonth;

    private int unbrokenSeniorityDay;

    private ContactableElement contactableElement;

    private BusinessableElement businessableElement;

    private LedgerAccount ledgerAccount;

    public Employee() {
	contactableElement = new ContactableElement(this);
	businessableElement = new BusinessableElement(this);
    }

    protected String getClassId() {
	return CLASS_ID;
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

    public boolean isTax() {
	return tax;
    }

    public void setTax(boolean tax) {
	this.tax = tax;
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

    public String getEmployeeAccount() {
	return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
	this.employeeAccount = employeeAccount;
    }

    public int getTaxPrivilege() {
	return taxPrivilege;
    }

    public void setTaxPrivilege(int taxPrivilege) {
	this.taxPrivilege = taxPrivilege;
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

    public double getAdvance() {
	return advance;
    }

    public void setAdvance(double advance) {
	this.advance = advance;
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

    public int getTotalSeniorityYear() {
	return totalSeniorityYear;
    }

    public void setTotalSeniorityYear(int totalSeniorityYear) {
	this.totalSeniorityYear = totalSeniorityYear;
    }

    public int getTotalSeniorityMonth() {
	return totalSeniorityMonth;
    }

    public void setTotalSeniorityMonth(int totalSeniorityMonth) {
	this.totalSeniorityMonth = totalSeniorityMonth;
    }

    public int getTotalSeniorityDay() {
	return totalSeniorityDay;
    }

    public void setTotalSeniorityDay(int totalSeniorityDay) {
	this.totalSeniorityDay = totalSeniorityDay;
    }

    public int getUnbrokenSeniorityYear() {
	return unbrokenSeniorityYear;
    }

    public void setUnbrokenSeniorityYear(int unbrokenSeniorityYear) {
	this.unbrokenSeniorityYear = unbrokenSeniorityYear;
    }

    public int getUnbrokenSeniorityMonth() {
	return unbrokenSeniorityMonth;
    }

    public void setUnbrokenSeniorityMonth(int unbrokenSeniorityMonth) {
	this.unbrokenSeniorityMonth = unbrokenSeniorityMonth;
    }

    public int getUnbrokenSeniorityDay() {
	return unbrokenSeniorityDay;
    }

    public void setUnbrokenSeniorityDay(int unbrokenSeniorityDay) {
	this.unbrokenSeniorityDay = unbrokenSeniorityDay;
    }

    public ContactableElement getContactableElement() {
	return contactableElement;
    }

    // Contactable
    public void setContactableElement(ContactableElement contactableElement) {
	this.contactableElement = contactableElement == null ? new ContactableElement()	: contactableElement;
	this.contactableElement.setOwner(this);
    }

    // Businessable
    public BusinessableElement getBusinessableElement() {
	return businessableElement;
    }

    public void setBusinessableElement(BusinessableElement businessableElement) {
	this.businessableElement = businessableElement == null ? new BusinessableElement() : businessableElement;
	this.businessableElement.setOwner(this);
    }
    
    public Integer getBusinessableId() {
	return getId();
    }    

    public String getBusinessableName() {
	return getFullName();
    }
    
    
    public void init() {
	super.init();

	// Force initialize
	getContactableElement().init();
    }

    public LedgerAccount getLedgerAccount() {
	return ledgerAccount;
    }

    public void setLedgerAccount(LedgerAccount ledgerAccount) {
	this.ledgerAccount = ledgerAccount;
    }

    
    
    //

    public List getAddressList() {
	return getContactableElement().getAddressList();
    }
    
    public void setAddressList(List addressList) {
	getContactableElement().setAddressList(addressList);
    }
    
    
    
    public List getEmailList() {
	return getContactableElement().getEmailList();
    }
    
    public void setEmailList(List emailList) {
	getContactableElement().setEmailList(emailList);
    }
    
    
    
    public List getWebList() {
	return getContactableElement().getWebList();
    }
    
    public void setWebList(List webList) {
	getContactableElement().setWebList(webList);
    }
    
    
    
    public List getPhoneList() {
	return getContactableElement().getPhoneList();
    }
    
    public void setPhoneList(List phoneList) {
	getContactableElement().setPhoneList(phoneList);
    }
    
    
    //
    
    public void addAddress(Address address) {
	getContactableElement().addAddress(address);
    }
    
    public void addEmail(Email email) {
	getContactableElement().addEmail(email);
    }
   
    public void addWeb(Web web) {
	getContactableElement().addWeb(web);
    }
    
    public void addPhone(Phone phone) {
	getContactableElement().addPhone(phone);
    }
    
    //
}
