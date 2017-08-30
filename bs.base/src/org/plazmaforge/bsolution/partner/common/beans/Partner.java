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
package org.plazmaforge.bsolution.partner.common.beans;


import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.base.common.beans.BusinessableElement;
import org.plazmaforge.bsolution.base.common.beans.IBusinessable;
import org.plazmaforge.bsolution.base.common.beans.IBusinessableOwner;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.bsolution.finance.common.beans.IContractor;
import org.plazmaforge.framework.config.object.IEntityConfigurable;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryHolder;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;


/**
 * @author Oleh Hapon
 * Date: 02.07.2003
 * Time: 12:49:04
 */
public class Partner extends PartnerHeader implements /*IEntityConfigurable,*/ IContactableOwner, IBusinessableOwner, IBusinessable, IContractor, ImageEntryHolder {

    /** Class ID **/
    public static final String CLASS_ID = "PARTNER";


    private int yearCreate;

    private float saleVolume;

    private String workTime;

    private FormProperty formProperty;

    private Industry industry;

    private ContactableElement contactableElement;
    
    private BusinessableElement businessableElement;



    private List<PartnerCategoryLink> partnerCategoryLinkList;

    private List<PartnerActivityTypeLink> partnerActivityTypeLinkList;
    
    private List<PartnerRepresentative> partnerRepresentativeList;
    
    private boolean person;

    
    private ImageEntry imageEntry;
    
   
    
    public Partner() {
	contactableElement = new ContactableElement(this);
	businessableElement = new BusinessableElement(this);
    }

    protected String getClassId() {
	return CLASS_ID;
    }
    
    
    public Integer getOwnerId() {
	return getId();
    }

    public int getYearCreate() {
	return yearCreate;
    }

    public void setYearCreate(int yearCreation) {
	this.yearCreate = yearCreation;
    }

    public float getSaleVolume() {
	return saleVolume;
    }

    public void setSaleVolume(float saleVolume) {
	this.saleVolume = saleVolume;
    }

    public String getWorkTime() {
	return workTime;
    }

    public void setWorkTime(String workTime) {
	this.workTime = workTime;
    }

    
    public ContactableElement getContactableElement() {
	return contactableElement;
    }

    
    
    public void setContactableElement(ContactableElement contactableElement) {
	this.contactableElement = contactableElement == null ? new ContactableElement() : contactableElement;
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
	return getName();
    }
    
    public FormProperty getFormProperty() {
	return formProperty;
    }

    public void setFormProperty(FormProperty formProperty) {
	this.formProperty = formProperty;
    }

    public String getFormPropertyName() {
	return formProperty == null ? null : formProperty.getName();
    }

    protected List createList() {
	return new ArrayList();
    }

    public void init() {
	super.init();

	// Force initialize
	getPartnerCategoryLinkList().size();
	getPartnerActivityTypeLinkList().size();
	getPartnerRepresentativeList().size();
	
	getContactableElement().init();
	
    }

    public Industry getIndustry() {
	return industry;
    }

    public void setIndustry(Industry industry) {
	this.industry = industry;
    }

    public String getIndustryName() {
	return industry == null ? null : industry.getName();
    }
    
    public List<PartnerCategoryLink> getPartnerCategoryLinkList() {
	if (partnerCategoryLinkList == null) {
	    partnerCategoryLinkList = new ArrayList<PartnerCategoryLink>();
	}
	return partnerCategoryLinkList;
    }

    public void setPartnerCategoryLinkList(List<PartnerCategoryLink> partnerCategoryLinkList) {
	this.partnerCategoryLinkList = partnerCategoryLinkList;
    }

    public void addPartnerCategoryLink(PartnerCategoryLink partnerCategoryLink) {
	partnerCategoryLink.setPartner(this);
	this.getPartnerCategoryLinkList().add(partnerCategoryLink);
    }

    public List<PartnerActivityTypeLink> getPartnerActivityTypeLinkList() {
	if (partnerActivityTypeLinkList == null) {
	    partnerActivityTypeLinkList = new ArrayList<PartnerActivityTypeLink>();
	}
	return partnerActivityTypeLinkList;
    }

    public void setPartnerActivityTypeLinkList(List<PartnerActivityTypeLink> partnerActivityTypeLinkList) {
	this.partnerActivityTypeLinkList = partnerActivityTypeLinkList;
    }

    public void addPartnerActivityTypeLink(PartnerActivityTypeLink partnerActivityTypeLink) {
	partnerActivityTypeLink.setPartner(this);
	getPartnerActivityTypeLinkList().add(partnerActivityTypeLink);
    }
    
    
    ////
    
    public List<PartnerRepresentative> getPartnerRepresentativeList() {
	if (partnerRepresentativeList == null) {
	    partnerRepresentativeList = new ArrayList<PartnerRepresentative>();
	}
	return partnerRepresentativeList;
    }

    public void setPartnerRepresentativeList(List<PartnerRepresentative> partnerrRepresentativeList) {
	this.partnerRepresentativeList = partnerrRepresentativeList;
    }

    public void addPartnerRepresentative(PartnerRepresentative partnerRepresentative) {
	partnerRepresentative.setPartner(this);
	this.getPartnerRepresentativeList().add(partnerRepresentative);
    }
    
    ////

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

    public boolean isPerson() {
        return person;
    }

    public void setPerson(boolean person) {
        this.person = person;
    }
    
    /// IContractorHeader
    
    public boolean isPartner() {
	return true;
    }
    
    public boolean isEmployee() {
	return false;
    }
    
    
    
    //////////////////////////////////////////////////////////
    //
    // IMAGE ENTRY
    //
    //////////////////////////////////////////////////////////
    
    public ImageEntry getImageEntry() {
	if (imageEntry == null) {
	    imageEntry = new ImageEntryImpl();
	}
        return imageEntry;
    }

    public void setImageEntry(ImageEntry imageEntry) {
        this.imageEntry = imageEntry;
    }

    public String getImageFileName() {
	return getImageEntry().getFileName();
    }
    
    public void setImageFileName(String fileName) {
	getImageEntry().setFileName(fileName);
    }

    public String getImageAbsoluteFileName() {
	return getImageEntry().getAbsoluteFileName();
    }
    
    public void setImageAbsoluteFileName(String absoluteFileName) {
	getImageEntry().setAbsoluteFileName(absoluteFileName);
    }
    
   
    
}
