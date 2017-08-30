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

package org.plazmaforge.bsolution.personality.common.beans;

import java.util.Date;

import org.plazmaforge.bsolution.base.common.beans.BusinessableElement;
import org.plazmaforge.bsolution.base.common.beans.Country;
import org.plazmaforge.bsolution.base.common.beans.IBusinessable;
import org.plazmaforge.bsolution.base.common.beans.IBusinessableOwner;
import org.plazmaforge.bsolution.base.common.beans.Language;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.IContactableOwner;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.config.object.IEntityConfigurable;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.IFileHolder;
import org.plazmaforge.framework.platform.EntityEnvironment;



/**
 * @author Oleh Hapon
 * Date: 02.07.2003
 * Time: 12:48:58
 */
public class Person extends Contact implements IPersonHeader, IAttributeHolder, IFileHolder, IEntityConfigurable, IContactableOwner, IBusinessableOwner, IBusinessable {

    public static final String CLASS_ID = "PERSON";

    private static IEntityConfig entity;
    
    private static IEntityConfig contactEntity;

    private String personCode;
    
    private PersonMilitary personMilitary = new PersonMilitary(this);

    
    private BusinessableElement businessableElement;
    
 
    ////
    
    public static final int EDUCATION_DIPLOMA_TYPE = 1;

    public static final int EDUCATION_CERTIFICAT_TYPE = 2;

    private String idn;

    private FamilyStatus familyStatus;

    private Country nationality;

    private Country countryResidence;

    private Language language;

    private PersonDocumentType personDocumentType;

    private String documentSeries;

    private String documentNo;

    private Date documentDate;

    private String documentGiven;

    private int diplomaTypeId;

    private String diplomaSeries;

    private String diplomaNo;

    private Date diplomaDate;

    private Speciality diplomaSpeciality;

    private String diplomaQualification;


    public Person() {
	businessableElement = new BusinessableElement(this);
    }

    protected String getClassId() {
	return CLASS_ID;
    }
    
    
    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public PersonMilitary getPersonMilitary() {
	return personMilitary;
    }

    public void setPersonMilitary(PersonMilitary personMilitary) {
	this.personMilitary = personMilitary == null ? new PersonMilitary() : personMilitary;
	this.personMilitary.setPerson(this);
    }

    protected ContactableElement createContactableElement(IContactableOwner owner) {
	return new ContactableElement(owner);
    }


    protected void initContactableElement(ContactableElement contactableElement) {
	if (contactableElement == null) {
	    return;
	}
       super.initContactableElement(contactableElement);
    }

    
    // Businessable 
    public BusinessableElement getBusinessableElement() {
	return businessableElement;
    }

    public void setBusinessableElement(BusinessableElement businessableElement) {
	this.businessableElement = businessableElement == null ? new BusinessableElement() : businessableElement;
	this.businessableElement.setOwner(this);
    }
    
    
    public Integer getOwnerId() {
	return getId();
    }
    
    public Integer getBusinessableId() {
	return getId();
    }
    
    public String getBusinessableName() {
	return getFullName();
    }    
 
//    public String getNote() {
//	return note;
//    }
//
//    public void setNote(String note) {
//	this.note = note;
//    }

    public void init() {
	super.init();

	//Force initialize		
	this.getPersonMilitary();
    }

    public MilitaryRank getMilitaryRank() {
	return personMilitary.getMilitaryRank();
    }

    public String getMilitaryRankName() {
	return personMilitary.getMilitaryRankName();
    }

    public String getMilitaryRegistration() {
	return personMilitary.getMilitaryRegistration();
    }

    public MilitarySpeciality getMilitarySpeciality() {
	return personMilitary.getMilitarySpeciality();
    }

    public String getMilitarySpecialityName() {
	return personMilitary.getMilitarySpecialityName();
    }

    public MilitaryStatus getMilitaryStatus() {
	return personMilitary.getMilitaryStatus();
    }

    public String getMilitaryStatusName() {
	return personMilitary.getMilitaryStatusName();
    }

    public String getSpecialRecord() {
	return personMilitary.getSpecialRecord();
    }

    public int getValidStatusId() {
	return personMilitary.getValidStatusId();
    }

    public void setMilitaryRank(MilitaryRank militaryRank) {
	personMilitary.setMilitaryRank(militaryRank);
    }

    public void setMilitaryRegistration(String militaryRegistration) {
	personMilitary.setMilitaryRegistration(militaryRegistration);
    }

    public void setMilitarySpeciality(MilitarySpeciality militarySpeciality) {
	personMilitary.setMilitarySpeciality(militarySpeciality);
    }

    public void setMilitaryStatus(MilitaryStatus militaryStatus) {
	personMilitary.setMilitaryStatus(militaryStatus);
    }

    public void setSpecialRecord(String specialRecord) {
	personMilitary.setSpecialRecord(specialRecord);
    }

    public void setValidStatusId(int validStatusId) {
	personMilitary.setValidStatusId(validStatusId);
    }
    
    
   
    
    //////////////////////////////////////////////////////////

    public IEntityConfig getEntity() {
	if (entity == null) {
	    entity = EntityEnvironment.getEntityById(getClassId());
	}
	return entity;
    }
    
    public String getEntityConfigId() {
	return getEntity() == null ? null : getEntity().getConfigId();
    }

    public String getEntityName() {
	return getEntity() == null ? null : getEntity().getConfigName();
    }
    
    public IEntityConfig getContactEntity() {
	if (contactEntity == null) {
	    contactEntity = EntityEnvironment.getEntityById(Contact.CLASS_ID);
	}
	return contactEntity;
    }
    
    //////////////////////////////////////////////////////////
    
    public String getIdn() {
	return idn;
    }

    public void setIdn(String idn) {
	this.idn = idn;
    }

    public String getDocumentSeries() {
	return documentSeries;
    }

    public void setDocumentSeries(String documentSeries) {
	this.documentSeries = documentSeries;
    }

    public String getDocumentNo() {
	return documentNo;
    }

    public void setDocumentNo(String documentNumber) {
	this.documentNo = documentNumber;
    }

    public Date getDocumentDate() {
	return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
	this.documentDate = documentDate;
    }

    public String getDocumentGiven() {
	return documentGiven;
    }

    public void setDocumentGiven(String documentGiven) {
	this.documentGiven = documentGiven;
    }

    public int getDiplomaTypeId() {
	return diplomaTypeId;
    }

    public void setDiplomaTypeId(int diplomaTypeId) {
	this.diplomaTypeId = diplomaTypeId;
    }

    public String getDiplomaSeries() {
	return diplomaSeries;
    }

    public void setDiplomaSeries(String diplomaSeries) {
	this.diplomaSeries = diplomaSeries;
    }

    public String getDiplomaNo() {
	return diplomaNo;
    }

    public void setDiplomaNo(String diplomaNumber) {
	this.diplomaNo = diplomaNumber;
    }

    public Date getDiplomaDate() {
	return diplomaDate;
    }

    public void setDiplomaDate(Date diplomaDate) {
	this.diplomaDate = diplomaDate;
    }

    public String getDiplomaQualification() {
	return diplomaQualification;
    }

    public void setDiplomaQualification(String diplomaQualification) {
	this.diplomaQualification = diplomaQualification;
    }

    public String getFamilyStatusName() {
	return this.getFamilyStatus() == null ? null : this.getFamilyStatus()
		.getName();
    }

    public String getNationalityName() {
	return this.getNationality() == null ? null : this.getNationality()
		.getName();
    }

    public String getCountryResidenceName() {
	return this.getCountryResidence() == null ? null : this
		.getCountryResidence().getName();
    }

    public String getLanguageName() {
	return this.getLanguage() == null ? null : this.getLanguage().getName();
    }

    public String getDocumentTypeName() {
	return this.getPersonDocumentType() == null ? null
		: getPersonDocumentType().getName();
    }

    public String getDiplomaSpecialityName() {
	return getDiplomaSpeciality() == null ? null : getDiplomaSpeciality()
		.getName();
    }

    public Speciality getDiplomaSpeciality() {
	return diplomaSpeciality;
    }

    public void setDiplomaSpeciality(Speciality diplomaSpeciality) {
	this.diplomaSpeciality = diplomaSpeciality;
    }

    public PersonDocumentType getPersonDocumentType() {
	return personDocumentType;
    }

    public void setPersonDocumentType(PersonDocumentType documentType) {
	this.personDocumentType = documentType;
    }

    public FamilyStatus getFamilyStatus() {
	return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
	this.familyStatus = familyStatus;
    }

    public Language getLanguage() {
	return language;
    }

    public void setLanguage(Language language) {
	this.language = language;
    }

    public Country getNationality() {
	return nationality;
    }

    public void setNationality(Country nationality) {
	this.nationality = nationality;
    }

    public Country getCountryResidence() {
	return countryResidence;
    }

    public void setCountryResidence(Country countryResidence) {
	this.countryResidence = countryResidence;
    }

    
    
}
