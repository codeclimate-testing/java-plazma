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

import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.framework.util.MoneyEnvironment;


/**
 * @author Oleh Hapon
 * Date: 26.12.2004
 * Time: 11:28:30
 * $Id: Contract.java,v 1.3 2010/04/28 06:24:25 ohapon Exp $
 */
public class Contract extends FinanceDocument {

    public static final String CLASS_ID = "CONTRACT";
    
    private String name;
    
    
    private Date endDate;
    
    private double currencyPrepayAmount;
    
    private double prepayAmount;
    
    /*
     * Document file name 
     */
    private String fileName;
    
    
    private ContractDetails organizationDetails;
    
    private ContractDetails partnerDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public double getCurrencyPrepayAmount() {
        return currencyPrepayAmount;
    }

    public void setCurrencyPrepayAmount(double currencyPrepayAmount) {
        this.currencyPrepayAmount = currencyPrepayAmount;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrepayAmount() {
        return prepayAmount;
    }

    public void setPrepayAmount(double prepayAmount) {
        this.prepayAmount = prepayAmount;
    }

   
    public void calculateNationalAmountValues() {
	super.calculateNationalAmountValues();
	setPrepayAmount(MoneyEnvironment.roundMoney(getCurrencyPrepayAmount() * getCurrencyRate()));
    }

    
    ///////
    
    
    public ContractDetails getOrganizationDetails() {
	if (organizationDetails == null) {
	    organizationDetails = new ContractDetails(); 
	}
        return organizationDetails;
    }

    public void setOrganizationDetails(ContractDetails organizationDetails) {
        this.organizationDetails = organizationDetails;
    }

    public ContractDetails getPartnerDetails() {
	if (partnerDetails == null) {
	    partnerDetails = new ContractDetails(); 
	}
        return partnerDetails;
    }

    public void setPartnerDetails(ContractDetails partnerDetails) {
        this.partnerDetails = partnerDetails;
    }
    
    //////////////////////////////////////// Organization //////////////////////////////////////////
    
    
    public ContactTitle getOrganizationContact() {
        return getOrganizationDetails().getContact();
    }

    public void setOrganizationContact(ContactTitle contact) {
	getOrganizationDetails().setContact(contact);
    }
    
    public BankAccount getOrganizationBankAccount() {
        return getOrganizationDetails().getBankAccount();
    }

    public void setOrganizationBankAccount(BankAccount bankAccount) {
	getOrganizationDetails().setBankAccount(bankAccount);
    }

    ////////
    
    public String getOrganizationPerson() {
        return getOrganizationDetails().getPerson();
    }

    public void setOrganizationPerson(String person) {
	getOrganizationDetails().setPerson(person);
    }

    //
    
    public String getOrganizationPersonEn() {
        return getOrganizationDetails().getPersonEn();
    }

    public void setOrganizationPersonEn(String personEn) {
	getOrganizationDetails().setPersonEn(personEn);
    }

    //
    
    public String getOrganizationPersonDetail() {
        return getOrganizationDetails().getPersonDetail();
    }

    public void setOrganizationPersonDetail(String personDetail) {
	getOrganizationDetails().setPersonDetail(personDetail);
    }

    //
    
    public String getOrganizationPersonDetailEn() {
        return getOrganizationDetails().getPersonDetailEn();
    }

    public void setOrganizationPersonDetailEn(String personDetailEn) {
	getOrganizationDetails().setPersonDetailEn(personDetailEn);
    }

    ////////
    
    public String getOrganizationPersonOnBasis() {
        return getOrganizationDetails().getPersonOnBasis();
    }

    public void setOrganizationPersonOnBasis(String personOnBasis) {
	getOrganizationDetails().setPersonOnBasis(personOnBasis);
    }

    public String getOrganizationPersonOnBasisEn() {
        return getOrganizationDetails().getPersonOnBasisEn();
    }

    public void setOrganizationPersonOnBasisEn(String personOnBasisEn) {
	getOrganizationDetails().setPersonOnBasisEn(personOnBasisEn);
    }
    
    ////
    
    public String getOrganizationAddress() {
        return getOrganizationDetails().getAddress();
    }

    public void setOrganizationAddress(String address) {
	getOrganizationDetails().setAddress(address);
    }

    public String getOrganizationAddressEn() {
        return getOrganizationDetails().getAddressEn();
    }

    public void setOrganizationAddressEn(String addressEn) {
	getOrganizationDetails().setAddressEn(addressEn);
    }

    public String getOrganizationPhone() {
        return getOrganizationDetails().getPhone();
    }

    public void setOrganizationPhone(String phone) {
	getOrganizationDetails().setPhone(phone);
    }
    
    public String getOrganizationFax() {
        return getOrganizationDetails().getFax();
    }

    public void setOrganizationFax(String fax) {
	getOrganizationDetails().setFax(fax);
    }
    
    ////

    public String getOrganizationBankName() {
        return getOrganizationDetails().getBankName();
    }

    public void setOrganizationBankName(String bankName) {
	getOrganizationDetails().setBankName(bankName);
    }

    public String getOrganizationBankNameEn() {
	return getOrganizationDetails().getBankNameEn();
    }

    public void setOrganizationBankNameEn(String bankNameEn) {
	getOrganizationDetails().setBankNameEn(bankNameEn);
    }

    
    
  //////////////////////////////////////// Partner //////////////////////////////////////////
    
    
    public ContactTitle getPartnerContact() {
        return getPartnerDetails().getContact();
    }

    public void setPartnerContact(ContactTitle contact) {
	getPartnerDetails().setContact(contact);
    }
    
    public BankAccount getPartnerBankAccount() {
        return getPartnerDetails().getBankAccount();
    }

    public void setPartnerBankAccount(BankAccount bankAccount) {
	getPartnerDetails().setBankAccount(bankAccount);
    }

    ////////
    
    public String getPartnerPerson() {
        return getPartnerDetails().getPerson();
    }

    public void setPartnerPerson(String person) {
	getPartnerDetails().setPerson(person);
    }

    //
    
    public String getPartnerPersonEn() {
        return getPartnerDetails().getPersonEn();
    }

    public void setPartnerPersonEn(String personEn) {
	getPartnerDetails().setPersonEn(personEn);
    }

    //
    
    public String getPartnerPersonDetail() {
        return getPartnerDetails().getPersonDetail();
    }

    public void setPartnerPersonDetail(String personDetail) {
	getPartnerDetails().setPersonDetail(personDetail);
    }

    //
    
    public String getPartnerPersonDetailEn() {
        return getPartnerDetails().getPersonDetailEn();
    }

    public void setPartnerPersonDetailEn(String personDetailEn) {
	getPartnerDetails().setPersonDetailEn(personDetailEn);
    }

    ////////
    
    public String getPartnerPersonOnBasis() {
        return getPartnerDetails().getPersonOnBasis();
    }

    public void setPartnerPersonOnBasis(String personOnBasis) {
	getPartnerDetails().setPersonOnBasis(personOnBasis);
    }

    public String getPartnerPersonOnBasisEn() {
        return getPartnerDetails().getPersonOnBasisEn();
    }

    public void setPartnerPersonOnBasisEn(String personOnBasisEn) {
	getPartnerDetails().setPersonOnBasisEn(personOnBasisEn);
    }
    
    ////
    
    public String getPartnerAddress() {
        return getPartnerDetails().getAddress();
    }

    public void setPartnerAddress(String address) {
	getPartnerDetails().setAddress(address);
    }

    public String getPartnerAddressEn() {
        return getPartnerDetails().getAddressEn();
    }

    public void setPartnerAddressEn(String addressEn) {
	getPartnerDetails().setAddressEn(addressEn);
    }

    public String getPartnerPhone() {
        return getPartnerDetails().getPhone();
    }

    public void setPartnerPhone(String phone) {
	getPartnerDetails().setPhone(phone);
    }
    
    public String getPartnerFax() {
        return getPartnerDetails().getFax();
    }

    public void setPartnerFax(String fax) {
	getPartnerDetails().setFax(fax);
    }
    
    ////

    public String getPartnerBankName() {
        return getPartnerDetails().getBankName();
    }

    public void setPartnerBankName(String bankName) {
	getPartnerDetails().setBankName(bankName);
    }

    public String getPartnerBankNameEn() {
	return getPartnerDetails().getBankNameEn();
    }

    public void setPartnerBankNameEn(String bankNameEn) {
	getPartnerDetails().setBankNameEn(bankNameEn);
    }

    public boolean isCalculateAccountEntry() {
	return false; // NO CALC ACCOUNT ENTIRES
    }
}
