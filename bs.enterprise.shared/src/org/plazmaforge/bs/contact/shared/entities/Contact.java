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

package org.plazmaforge.bs.contact.shared.entities;

import java.util.Date;
import java.util.List;

import org.plazmaforge.bs.organization.shared.entities.Department;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryHolder;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.IFileHolder;


/**
 * 
 * @author ohapon
 *
 */
public class Contact extends ContactHeader implements IContact, IContactableOwner, IAttributeHolder, IFileHolder, ImageEntryHolder {

    private static final long serialVersionUID = 249640863863496886L;

    
    private String fullPositionName;

    private String note;

    private JobPosition position;

    private Department department;

    private Date birthDate;
    
    private ContactableElement contactableElement;
    
    private ImageEntry imageEntry;
    
    
    public Contact() {
    }

    public String getNote() {
	return note;
    }

    public void setNote(String note) {
	this.note = note;
    }

    public String getFullPositionName() {
	return fullPositionName;
    }

    public void setFullPositionName(String fullPositionName) {
	this.fullPositionName = fullPositionName;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    public JobPosition getPosition() {
	return position;
    }
    
    public void setPosition(JobPosition position) {
	this.position = position;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
  
    public ContactableElement getContactableElement() {
	if (contactableElement == null){
	    contactableElement = new ContactableElement(this);
	}
	return contactableElement;
    }

    public void setContactableElement(ContactableElement contactableElement) {
	this.contactableElement = contactableElement;
    }

    public void init() {
	super.init();

	// Force initialize
	getContactableElement().init();
    }
    
    public List<Address> getAddressList() {
	return getContactableElement().getAddressList();
    }
    
    public void setAddressList(List<Address> addressList) {
	getContactableElement().setAddressList(addressList);
    }
    
    public List<Email> getEmailList() {
	return getContactableElement().getEmailList();
    }
    
    public void setEmailList(List<Email> emailList) {
	getContactableElement().setEmailList(emailList);
    }
    
    public List<Web> getWebList() {
	return getContactableElement().getWebList();
    }
    
    public void setWebList(List<Web> webList) {
	getContactableElement().setWebList(webList);
    }
    
    public List<Phone> getPhoneList() {
	return getContactableElement().getPhoneList();
    }
    
    public void setPhoneList(List<Phone> phoneList) {
	getContactableElement().setPhoneList(phoneList);
    }
    
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

    
    //--
    
    
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
