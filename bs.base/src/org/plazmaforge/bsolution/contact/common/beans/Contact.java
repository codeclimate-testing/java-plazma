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

package org.plazmaforge.bsolution.contact.common.beans;

import java.util.Date;
import java.util.List;

import org.plazmaforge.bsolution.employee.common.beans.JobPosition;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.IFileHolder;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryHolder;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;
import org.plazmaforge.framework.platform.EntityEnvironment;



public class Contact extends ContactHeader implements IContact, IContactableOwner, IAttributeHolder, IFileHolder, ImageEntryHolder {

    public static final String CLASS_ID = "CONTACT";

    private static IEntityConfig entity;

    
    private String fullPositionName;

    private String note;


    private JobPosition position;

    private Department department;

    private Date birthDate;
    
    
    private ContactableElement contactableElement;
    
    
    private ImageEntry imageEntry;
    
    public Contact() {
	contactableElement = createContactableElement(this);
    }

    ////
    
    protected String getClassId() {
	return CLASS_ID;
    }
    
    public IEntityConfig getEntity() {
	if (entity == null) {
	    entity = EntityEnvironment.getEntityById(getClassId());
	}
	return entity;
    }
    
    ////
    
    public String getEntityConfigId() {
	return getEntity() == null ? null : getEntity().getConfigId();
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

  
    // Contactable
    public ContactableElement getContactableElement() {
	return contactableElement;
    }

    public void setContactableElement(ContactableElement contactableElement) {
	this.contactableElement = contactableElement == null ? createContactableElement() : contactableElement;
	initContactableElement(this.contactableElement);
    }

    protected ContactableElement createContactableElement(IContactableOwner owner) {
	return new ContactableElement(owner);
    }

    protected ContactableElement createContactableElement() {
	return new ContactableElement();
    }

    protected void initContactableElement(ContactableElement contactableElement) {
	if (contactableElement == null) {
	    return;
	}
	contactableElement.setOwner(this);
    }
    
    ////
    

    public void init() {
	super.init();

	// Force initialize
	this.getContactableElement().init();
    }
    
    //--
    
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
    
        
    
    //--
    
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
