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

package org.plazmaforge.bsolution.personality.client.swing.forms;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.common.beans.AcademicDegree;
import org.plazmaforge.bsolution.personality.common.beans.EducationForm;
import org.plazmaforge.bsolution.personality.common.beans.EducationInstitute;
import org.plazmaforge.bsolution.personality.common.beans.EducationType;
import org.plazmaforge.bsolution.personality.common.beans.PersonEducation;
import org.plazmaforge.bsolution.personality.common.services.EducationFormService;
import org.plazmaforge.bsolution.personality.common.services.EducationTypeService;
import org.plazmaforge.bsolution.personality.common.services.PersonEducationService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 16:07:28
 * $Id: PersonEducationEdit.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonEducationEdit extends AbstractPersonableEdit {

    private JLabel educationTypeLabel;
    private JLabel educationFormLabel;
    private JLabel educationInstituteLabel;
    private JLabel endDateLabel;
    private JLabel facultyLabel;
    private JLabel academicDegreeLabel;

    private XComboBox educationTypeComboBox;
    private XComboBox educationFormComboBox;
    private XComboEdit educationInstituteComboEdit;
    private XDateField endDateField;
    private XTextField facultyField;
    private XComboEdit academicDegreeComboEdit;

    public PersonEducationEdit() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonEducation.class);
        this.setEntityServiceClass(PersonEducationService.class);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));

        educationTypeLabel = new JLabel(getString("panel.label-education-type.text"));
        educationFormLabel = new JLabel(getString("panel.label-education-form.text"));
        educationInstituteLabel = new JLabel(getString("panel.label-education-institute.text"));
        endDateLabel = new JLabel(getString("panel.label-end-date.text"));
        facultyLabel = new JLabel(getString("panel.label-faculty.text"));
        academicDegreeLabel = new JLabel(getString("panel.label-academic-degree.text"));

        educationTypeComboBox = new XComboBox(getEducationTypeService().findAll());
        educationFormComboBox = new XComboBox(getEducationFormService().findAll());
        educationInstituteComboEdit = new XComboEdit();
        endDateField = new XDateField();
        facultyField = new XTextField(30);
        academicDegreeComboEdit = new XComboEdit(true);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(educationTypeLabel);
        editPanel.addByY(educationFormLabel);
        editPanel.addByY(educationInstituteLabel);
        editPanel.addByY(facultyLabel);
        editPanel.addByY(academicDegreeLabel);
        editPanel.addByY(endDateLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(educationTypeComboBox);
        editPanel.addByY(educationFormComboBox);
        editPanel.addByY(educationInstituteComboEdit);
        editPanel.addByY(facultyField);
        editPanel.addByY(academicDegreeComboEdit);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(endDateField);
		

        add(editPanel);

        educationInstituteComboEdit.initListFormAction(this, EducationInstituteList.class);
        academicDegreeComboEdit.initListFormAction(this, AcademicDegreeList.class);
    }

    private PersonEducation getPersonEducation() {
        return (PersonEducation) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        //appendTitle(details.getName());
        educationTypeComboBox.setValue(getPersonEducation().getEducationType());
        educationFormComboBox.setValue(getPersonEducation().getEducationForm());
        educationInstituteComboEdit.setValue(getPersonEducation().getEducationInstitute());
        endDateField.setDate(getPersonEducation().getEndDate());
        facultyField.setText(getPersonEducation().getFaculty());
        academicDegreeComboEdit.setValue(getPersonEducation().getAcademicDegree());
    }


    protected void populateData() throws ApplicationException {
        getPersonEducation().setEducationType((EducationType) educationTypeComboBox.getValue());
        getPersonEducation().setEducationForm((EducationForm) educationFormComboBox.getValue());
        getPersonEducation().setEducationInstitute((EducationInstitute) educationInstituteComboEdit.getValue());
        getPersonEducation().setEndDate(endDateField.getDate());
        getPersonEducation().setFaculty(facultyField.getText());
        getPersonEducation().setAcademicDegree((AcademicDegree) academicDegreeComboEdit.getValue());
    }

    private EducationTypeService getEducationTypeService() {
        return (EducationTypeService) getSERVICE(EducationTypeService.class);
    }

    private EducationFormService getEducationFormService() {
        return (EducationFormService) getSERVICE(EducationFormService.class);
    }

}
