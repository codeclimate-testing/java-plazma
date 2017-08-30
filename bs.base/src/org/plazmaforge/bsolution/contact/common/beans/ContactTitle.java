package org.plazmaforge.bsolution.contact.common.beans;

import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.ext.model.Dictionary;

public class ContactTitle extends Dictionary {

    private String code;

    private String titleName;
    
    private String name;
    
    private String lastName;

    private String firstName;

    private String middleName;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    
    public String getName() {
	if (name == null || name.trim().length() == 0) {
	    name = generateName();
	}
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }
    
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
    
    
    public String getFullName() {
	return getName();
    }
    
    public String generateName() {
	return LocaleManager.getPersonName(getFirstName(), getLastName(), getMiddleName());
    }


    ////

}
