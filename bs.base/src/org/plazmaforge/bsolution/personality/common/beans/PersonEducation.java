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


/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 14:48:45
 * $Id: PersonEducation.java,v 1.2 2010/04/28 06:24:20 ohapon Exp $
 */
public class PersonEducation extends AbstractPersonableItem {

    
    private EducationType educationType;
    private EducationForm educationForm;
    private EducationInstitute educationInstitute;
    
    private Date endDate;
    private String faculty;
    private AcademicDegree academicDegree;


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }
    
    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getAcademicDegreeName() {
        return getAcademicDegree() == null ? null : getAcademicDegree().getName();
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }
    
    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public String getEducationFormName() {
        return getEducationForm() == null ? null : getEducationForm().getName();
    }
    
    public EducationInstitute getEducationInstitute() {
        return educationInstitute;
    }
    
    public void setEducationInstitute(EducationInstitute educationInstitute) {
        this.educationInstitute = educationInstitute;
    }
    
    public String getEducationInstituteName() {
        return getEducationInstitute() == null ? null : getEducationInstitute().getName();
    }
    
    public EducationType getEducationType() {
        return educationType;
    }
    
    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }
    
    public String getEducationTypeName() {
        return getEducationType() == null ? null : getEducationType().getName();
    }
    
}
