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

import org.plazmaforge.framework.ext.model.BaseEntity;

/**
 * @author Oleh Hapon
 * Date: 18.09.2004
 * Time: 8:05:50
 * $Id: PersonMilitary.java,v 1.3 2010/12/05 07:56:05 ohapon Exp $
 */
public class PersonMilitary extends BaseEntity {

    public static final int YES_VALID_STATUS    = 1;
    public static final int NO_VALID_STATUS     = 2;
    public static final int TMP_VALID_STATUS    = 3;

    private Person person;

    private MilitarySpeciality militarySpeciality;
    private MilitaryRank militaryRank;
    private MilitaryStatus militaryStatus;
    
    private int validStatusId;
    
    private String militaryRegistration;
    private String specialRecord;


    
    public PersonMilitary() {
    }
    
    public PersonMilitary(Person person) {
        this.person = person;
    }
    
    public int getValidStatusId() {
        return validStatusId;
    }

    public void setValidStatusId(int validStatusId) {
        this.validStatusId = validStatusId;
    }

    public String getMilitaryRegistration() {
        return militaryRegistration;
    }

    public void setMilitaryRegistration(String militaryRegistration) {
        this.militaryRegistration = militaryRegistration;
    }

    public String getSpecialRecord() {
        return specialRecord;
    }

    public void setSpecialRecord(String specialRecord) {
        this.specialRecord = specialRecord;
    }


    public String getMilitarySpecialityName() {
        return getMilitarySpeciality() == null ? null : getMilitarySpeciality().getName();
    }

    public String getMilitaryRankName() {
        return getMilitaryRank() == null ? null : getMilitaryRank().getName();
    }

    public String getMilitaryStatusName() {
        return getMilitaryStatus() == null ? null : getMilitaryStatus().getName();
    }

   
    public MilitaryRank getMilitaryRank() {
        return militaryRank;
    }
    
    public void setMilitaryRank(MilitaryRank militaryRank) {
        this.militaryRank = militaryRank;
    }
    
    public MilitarySpeciality getMilitarySpeciality() {
        return militarySpeciality;
    }
    
    public void setMilitarySpeciality(MilitarySpeciality militarySpeciality) {
        this.militarySpeciality = militarySpeciality;
    }
    
    public MilitaryStatus getMilitaryStatus() {
        return militaryStatus;
    }
    
    public void setMilitaryStatus(MilitaryStatus militaryStatus) {
        this.militaryStatus = militaryStatus;
    }
    
    
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
