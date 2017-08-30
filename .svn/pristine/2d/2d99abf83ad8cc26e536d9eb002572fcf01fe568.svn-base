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

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.plazmaforge.bsolution.base.client.swing.forms.CountryList;
import org.plazmaforge.bsolution.base.client.swing.forms.LanguageList;
import org.plazmaforge.bsolution.base.common.beans.Country;
import org.plazmaforge.bsolution.base.common.beans.Language;

import org.plazmaforge.bsolution.contact.client.swing.forms.AbstractContactableEdit;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.client.swing.forms.common.EducationDocumentTypeComboBox;
import org.plazmaforge.bsolution.personality.client.swing.forms.common.GenderComboBox;
import org.plazmaforge.bsolution.personality.client.swing.forms.common.MilitaryValidStatusComboBox;
import org.plazmaforge.bsolution.personality.common.beans.FamilyStatus;
import org.plazmaforge.bsolution.personality.common.beans.MilitaryRank;
import org.plazmaforge.bsolution.personality.common.beans.MilitarySpeciality;
import org.plazmaforge.bsolution.personality.common.beans.MilitaryStatus;
import org.plazmaforge.bsolution.personality.common.beans.Person;
import org.plazmaforge.bsolution.personality.common.beans.PersonDocumentType;
import org.plazmaforge.bsolution.personality.common.beans.Speciality;
import org.plazmaforge.bsolution.personality.common.services.MilitaryStatusService;
import org.plazmaforge.bsolution.personality.common.services.PersonService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XLabel;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractPanelController;
import org.plazmaforge.framework.client.swing.forms.PanelController;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 08.03.2004
 * Time: 17:46:11
 * $Id: PersonEdit.java,v 1.4 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonEdit extends AbstractContactableEdit {

    private JLabel codeLabel;

    private JLabel lastNameLabel;

    private JLabel firstNameLabel;

    private JLabel middleNameLabel;

    private JLabel nationalityLabel;

    private JLabel birthDateLabel;

    private JLabel genderLabel;

    private JLabel familyStatusLabel;

    private JLabel countryResidenceLabel;

    private JLabel languageLabel;

    private JLabel taxCodeLabel;

    private XTextField codeField;

    private XTextField lastNameField;

    private XTextField firstNameField;

    private XTextField middleNameField;

    private XComboEdit nationalityComboEdit;

    private XDateField birthDateField;

    private GenderComboBox genderComboBox;

    private XComboEdit familyStatusComboEdit;

    private XComboEdit countryResidenceComboEdit;

    private XComboEdit languageComboEdit;

    private XTextField taxCodeField;

    // Document panel
    private XLabel documentTypeLabel;

    private XLabel documentSeriesLabel;

    private XLabel documentNumberLabel;

    private XLabel documentDateLabel;

    private XLabel documentGivenLabel;

    private XComboEdit documentTypeComboEdit;

    private XTextField documentSeriesField;

    private XTextField documentNumberField;

    private XDateField documentDateField;

    private XTextField documentGivenField;

    // Diploma panel
    private XLabel diplomaTypeLabel;

    private XLabel diplomaSeriesLabel;

    private XLabel diplomaNumberLabel;

    private XLabel diplomaDateLabel;

    private XLabel diplomaSpecialityLabel;

    private XLabel diplomaQualificationLabel;

    private EducationDocumentTypeComboBox diplomaTypeComboBox;

    private XTextField diplomaSeriesField;

    private XTextField diplomaNumberField;

    private XDateField diplomaDateField;

    private XComboEdit diplomaSpecialityComboEdit;

    private XTextField diplomaQualificationField;

    // Military panel
    private JLabel militaryStatusLabel;

    private JLabel militaryRankLabel;

    private JLabel militarySpecialityLabel;

    private JLabel validStatusLabel;

    private JLabel militaryRegistrationLabel;

    private JLabel specialRecordLabel;

    private XComboBox militaryStatusComboBox;

    private XComboEdit militaryRankComboEdit;

    private XComboEdit militarySpecialityComboEdit;

    private MilitaryValidStatusComboBox validStatusComboBox;

    private XTextField militaryRegistrationField;

    private XTextField specialRecordField;

    private XTextEdit noteField;

    private final int LABEL_WIDTH = 100;

    /** Name PanelController */
    private PanelController panelController;

    public PersonEdit() throws ApplicationException {
	super(GUIPersonalityEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Person.class);
	this.setEntityServiceClass(PersonService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	this.getParentPane().setLayout(new BorderLayout());
	setParentTabbedPane(createMasterTabbedPane());
	addParentTabbedPane();
	setChildrenTabbedPane(createItemsTabbedPane());
	addChildrenTabbedPane();
    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.document.text"), createDocumentPanel());
	tp.addTab(getString("panel.title.military.text"), createMilitaryPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	lastNameLabel = new JLabel(getString("panel.label-last-name.text"));
	firstNameLabel = new JLabel(getString("panel.label-first-name.text"));
	middleNameLabel = new JLabel(getString("panel.label-middle-name.text"));
	nationalityLabel = new JLabel(getString("panel.label-nationality.text"));
	birthDateLabel = new JLabel(getString("panel.label-birth-date.text"));
	genderLabel = new JLabel(getString("panel.label-gender.text"));
	familyStatusLabel = new JLabel(getString("panel.label-family-status.text"));
	countryResidenceLabel = new JLabel(getString("panel.label-country-residence.text"));
	languageLabel = new JLabel(getString("panel.label-language.text"));
	taxCodeLabel = new JLabel(getString("panel.label-tax-code.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	lastNameField = new XTextField(45);
	lastNameField.setMaxChar(50);
	firstNameField = new XTextField(45);
	firstNameField.setMaxChar(50);
	middleNameField = new XTextField(45);
	middleNameField.setMaxChar(50);
	nationalityComboEdit = new XComboEdit(true);
	birthDateField = new XDateField();
	genderComboBox = new GenderComboBox();
	familyStatusComboEdit = new XComboEdit(true);
	countryResidenceComboEdit = new XComboEdit(true);
	languageComboEdit = new XComboEdit(true);
	taxCodeField = new XTextField(10);
	taxCodeField.setMaxChar(10);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);

	// Initialize labels
	getPanelController().initLabel(editPanel);

	editPanel.addByY(nationalityLabel);
	editPanel.addByY(birthDateLabel);
	editPanel.addByY(genderLabel);
	editPanel.addByY(familyStatusLabel);
	editPanel.addByY(countryResidenceLabel);
	editPanel.addByY(languageLabel);
	editPanel.addByY(taxCodeLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(codeField);
	gbc.gridwidth = 2;

	// Initialize fieldss
	getPanelController().initField(editPanel);

	editPanel.addByY(nationalityComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(birthDateField);
	editPanel.addByY(genderComboBox);

	gbc.gridwidth = 2;
	editPanel.addByY(familyStatusComboEdit);
	editPanel.addByY(countryResidenceComboEdit);
	editPanel.addByY(languageComboEdit);

	gbc.gridwidth = 1;
	editPanel.addByY(taxCodeField);

	nationalityComboEdit.initListFormAction(this, CountryList.class);
	familyStatusComboEdit.initListFormAction(this, FamilyStatusList.class);
	countryResidenceComboEdit.initListFormAction(this, CountryList.class);
	languageComboEdit.initListFormAction(this, LanguageList.class);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Box createDocumentPanel() throws ApplicationException {
	Box box = new Box(BoxLayout.Y_AXIS);
	box.add(createIdentityPanel());
	box.add(createDiplomaPanel());
	return box;
    }

    private JPanel createIdentityPanel() throws ApplicationException {

	documentTypeLabel = new XLabel(getString("panel.label-document-type.text"));
	documentSeriesLabel = new XLabel(getString("panel.label-document-series.text"));
	documentNumberLabel = new XLabel(getString("panel.label-document-number.text"));
	documentDateLabel = new XLabel(getString("panel.label-document-date.text"));
	documentGivenLabel = new XLabel(getString("panel.label-document-given.text"));

	documentTypeLabel.setFixedWidth(LABEL_WIDTH);
	documentSeriesLabel.setFixedWidth(LABEL_WIDTH);
	documentNumberLabel.setFixedWidth(LABEL_WIDTH);
	documentDateLabel.setFixedWidth(LABEL_WIDTH);
	documentGivenLabel.setFixedWidth(LABEL_WIDTH);

	documentTypeComboEdit = new XComboEdit(true);
	documentTypeComboEdit.setColumns(30);
	documentSeriesField = new XTextField(10);
	documentSeriesField.setMaxChar(10);
	documentNumberField = new XTextField(10);
	documentNumberField.setMaxChar(10);
	documentDateField = new XDateField();
	documentGivenField = new XTextField(30);
	documentGivenField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	editPanel.setBorder(BorderFactory
		.createTitledBorder(getString("panel.title.identity.text")));
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(documentTypeLabel);
	editPanel.addByY(documentSeriesLabel);
	editPanel.addByY(documentNumberLabel);
	editPanel.addByY(documentDateLabel);
	editPanel.addByY(documentGivenLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(documentTypeComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(documentSeriesField);
	editPanel.addByY(documentNumberField);
	editPanel.addByY(documentDateField);
	gbc.gridwidth = 2;
	editPanel.addByY(documentGivenField);

	documentTypeComboEdit
		.initListFormAction(this, PersonDocumentType.class);

	return editPanel;
    }

    private JPanel createMilitaryPanel() throws ApplicationException {

	militaryStatusLabel = new XLabel(getString("panel.label-military-status.text"));
	militaryRankLabel = new XLabel(getString("panel.label-military-rank.text"));
	militarySpecialityLabel = new XLabel(getString("panel.label-military-speciality.text"));
	validStatusLabel = new XLabel(getString("panel.label-valid-status.text"));
	militaryRegistrationLabel = new XLabel(getString("panel.label-military-registration.text"));
	specialRecordLabel = new XLabel(getString("panel.label-special-record.text"));

	militaryStatusComboBox = new XComboBox(getMilitaryStatusService().findAll());
	militaryRankComboEdit = new XComboEdit(true);
	militaryRankComboEdit.setColumns(35);
	militarySpecialityComboEdit = new XComboEdit(true);
	militarySpecialityComboEdit.setColumns(35);
	validStatusComboBox = new MilitaryValidStatusComboBox();
	militaryRegistrationField = new XTextField(30);
	militaryRegistrationField.setMaxChar(50);
	specialRecordField = new XTextField(30);
	specialRecordField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(militaryStatusLabel);
	editPanel.addByY(militaryRankLabel);
	editPanel.addByY(militarySpecialityLabel);
	editPanel.addByY(validStatusLabel);
	editPanel.addByY(militaryRegistrationLabel);
	editPanel.addByY(specialRecordLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(militaryStatusComboBox);
	gbc.gridwidth = 2;
	editPanel.addByY(militaryRankComboEdit);
	editPanel.addByY(militarySpecialityComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(validStatusComboBox);
	gbc.gridwidth = 2;
	editPanel.addByY(militaryRegistrationField);
	editPanel.addByY(specialRecordField);

	militaryRankComboEdit.initListFormAction(this, MilitaryRankList.class);
	militarySpecialityComboEdit.initListFormAction(this,
		MilitarySpecialityList.class);

	return editPanel;
    }

    private JPanel createDiplomaPanel() throws ApplicationException {

	diplomaTypeLabel = new XLabel(getString("panel.label-diploma-type.text"));
	diplomaSeriesLabel = new XLabel(getString("panel.label-diploma-series.text"));
	diplomaNumberLabel = new XLabel(getString("panel.label-diploma-number.text"));
	diplomaDateLabel = new XLabel(getString("panel.label-diploma-date.text"));
	diplomaSpecialityLabel = new XLabel(getString("panel.label-diploma-speciality.text"));
	diplomaQualificationLabel = new XLabel(getString("panel.label-diploma-qualification.text"));

	diplomaTypeLabel.setFixedWidth(LABEL_WIDTH);
	diplomaSeriesLabel.setFixedWidth(LABEL_WIDTH);
	diplomaNumberLabel.setFixedWidth(LABEL_WIDTH);
	diplomaDateLabel.setFixedWidth(LABEL_WIDTH);
	diplomaSpecialityLabel.setFixedWidth(LABEL_WIDTH);
	diplomaQualificationLabel.setFixedWidth(LABEL_WIDTH);
	diplomaTypeComboBox = new EducationDocumentTypeComboBox();
	diplomaSeriesField = new XTextField(10);
	diplomaSeriesField.setMaxChar(10);
	diplomaNumberField = new XTextField(10);
	diplomaNumberField.setMaxChar(10);
	diplomaDateField = new XDateField();
	diplomaSpecialityComboEdit = new XComboEdit(true);
	diplomaSpecialityComboEdit.setColumns(30);
	diplomaQualificationField = new XTextField(30);
	diplomaQualificationField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	editPanel.setBorder(BorderFactory.createTitledBorder(getString("panel.title.diploma.text")));
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(diplomaTypeLabel);
	editPanel.addByY(diplomaSeriesLabel);
	editPanel.addByY(diplomaNumberLabel);
	editPanel.addByY(diplomaDateLabel);
	editPanel.addByY(diplomaSpecialityLabel);
	editPanel.addByY(diplomaQualificationLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(diplomaTypeComboBox);
	editPanel.addByY(diplomaSeriesField);
	editPanel.addByY(diplomaNumberField);
	editPanel.addByY(diplomaDateField);
	gbc.gridwidth = 2;
	editPanel.addByY(diplomaSpecialityComboEdit);
	editPanel.addByY(diplomaQualificationField);

	diplomaSpecialityComboEdit.initListFormAction(this, SpecialityList.class);

	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(130);
	tp.addTab(getString("table-address.name"), createAddressPanel());
	tp.addTab(getString("table-phone.name"), createPhonePanel());
	tp.addTab(getString("table-email.name"), createEmailPanel());
	tp.addTab(getString("table-web.name"), createWebPanel());
	return tp;
    }

    private Person getPerson() {
	return (Person) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPerson().getFullName());
	codeField.setText(getPerson().getCode());
	lastNameField.setText(getPerson().getLastName());
	firstNameField.setText(getPerson().getFirstName());
	middleNameField.setText(getPerson().getMiddleName());
	nationalityComboEdit.setValue(getPerson().getNationality());
	birthDateField.setDate(getPerson().getBirthDate());
	genderComboBox.setSelectedGender(getPerson().getGender());
	familyStatusComboEdit.setValue(getPerson().getFamilyStatus());
	countryResidenceComboEdit.setValue(getPerson().getCountryResidence());
	languageComboEdit.setValue(getPerson().getLanguage());
	languageComboEdit.setText(getPerson().getLanguageName());
	taxCodeField.setText(getPerson().getIdn());

	// Document
	documentTypeComboEdit.setValue(getPerson().getPersonDocumentType());
	documentTypeComboEdit.setText(getPerson().getDocumentTypeName());
	documentSeriesField.setText(getPerson().getDocumentSeries());
	documentNumberField.setText(getPerson().getDocumentNo());
	documentDateField.setDate(getPerson().getDocumentDate());
	documentGivenField.setText(getPerson().getDocumentGiven());

	// Document
	diplomaTypeComboBox.setSelectedId(getPerson().getDiplomaTypeId());
	diplomaSeriesField.setText(getPerson().getDiplomaSeries());
	diplomaNumberField.setText(getPerson().getDiplomaNo());
	diplomaDateField.setDate(getPerson().getDiplomaDate());
	diplomaSpecialityComboEdit.setValue(getPerson().getDiplomaSpeciality());
	diplomaQualificationField.setText(getPerson().getDiplomaQualification());

	// Military
	militaryStatusComboBox.setValue(getPerson().getPersonMilitary().getMilitaryStatus());
	militaryRankComboEdit.setValue(getPerson().getPersonMilitary().getMilitaryRank());
	militarySpecialityComboEdit.setValue(getPerson().getPersonMilitary().getMilitarySpeciality());
	validStatusComboBox.setSelectedId(getPerson().getPersonMilitary().getValidStatusId());
	militaryRegistrationField.setText(getPerson().getPersonMilitary().getMilitaryRegistration());
	specialRecordField.setText(getPerson().getPersonMilitary().getSpecialRecord());

	noteField.setText(getPerson().getNote());
	updateTables();

    }

    protected void populateData() throws ApplicationException {
	getPerson().setCode(codeField.getText());
	getPerson().setLastName(lastNameField.getText());
	getPerson().setFirstName(firstNameField.getText());
	getPerson().setMiddleName(middleNameField.getText());

	getPerson().setNationality((Country) nationalityComboEdit.getValue());
	getPerson().setFamilyStatus((FamilyStatus) familyStatusComboEdit.getValue());
	getPerson().setCountryResidence((Country) countryResidenceComboEdit.getValue());
	getPerson().setLanguage((Language) languageComboEdit.getValue());

	getPerson().setBirthDate(birthDateField.getDate());
	getPerson().setGender(genderComboBox.getSelectedGender());
	getPerson().setIdn(taxCodeField.getText());

	// Document
	getPerson().setPersonDocumentType((PersonDocumentType) documentTypeComboEdit.getValue());

	getPerson().setDocumentSeries(documentSeriesField.getText());
	getPerson().setDocumentNo(documentNumberField.getText());
	getPerson().setDocumentDate(documentDateField.getDate());
	getPerson().setDocumentGiven(documentGivenField.getText());

	// Diploma
	getPerson().setDiplomaTypeId(diplomaTypeComboBox.getSelectedId());
	getPerson().setDiplomaSeries(diplomaSeriesField.getText());
	getPerson().setDiplomaNo(diplomaNumberField.getText());
	getPerson().setDiplomaDate(diplomaDateField.getDate());
	getPerson().setDiplomaSpeciality((Speciality) diplomaSpecialityComboEdit.getValue());
	getPerson().setDiplomaQualification(diplomaQualificationField.getText());

	// Military
	getPerson().getPersonMilitary().setMilitaryStatus((MilitaryStatus) militaryStatusComboBox.getValue());

	getPerson().getPersonMilitary().setMilitaryRank((MilitaryRank) militaryRankComboEdit.getValue());
	getPerson().getPersonMilitary().setMilitarySpeciality((MilitarySpeciality) militarySpecialityComboEdit.getValue());
	getPerson().getPersonMilitary().setValidStatusId(validStatusComboBox.getSelectedId());
	getPerson().getPersonMilitary().setMilitaryRegistration(militaryRegistrationField.getText());
	getPerson().getPersonMilitary().setSpecialRecord(specialRecordField.getText());

	getPerson().setNote(noteField.getText());

    }

    protected ContactableElement getContactableElement() {
	return getPerson().getContactableElement();
    }

    private MilitaryStatusService getMilitaryStatusService() {
	return (MilitaryStatusService) getSERVICE(MilitaryStatusService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getPerson().getFirstName(), firstNameLabel.getText());
	validateRequiredField(buf, getPerson().getLastName(), lastNameLabel.getText());
	validateRequiredField(buf, getPerson().getGender() != 0, genderLabel.getText());
	checkError(buf);
    }

    /**
     * Get Panel Controller
     * 
     * @return
     */
    private PanelController getPanelController() {
	if (panelController == null) {
	    if (LocaleManager.LAST_FIRST_MIDDLE.equals(LocaleManager.getNameVariant())) {
		panelController = new LFMNameController();
	    } else if (LocaleManager.FIRST_LAST_MIDDLE.equals(LocaleManager.getNameVariant())) {
		panelController = new FLMNameController();
	    } else {
		panelController = new FLNameController();
	    }
	}
	return panelController;
    }

    private class FLNameController extends AbstractPanelController {

	public void initLabel(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(firstNameLabel);
	    editPanel.addByY(lastNameLabel);
	}

	public void initField(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(firstNameField);
	    editPanel.addByY(lastNameField);
	}

    }

    private class LFMNameController extends AbstractPanelController {

	public void initLabel(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(lastNameLabel);
	    editPanel.addByY(firstNameLabel);
	    editPanel.addByY(middleNameLabel);
	}

	public void initField(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(lastNameField);
	    editPanel.addByY(firstNameField);
	    editPanel.addByY(middleNameField);
	}

    }

    private class FLMNameController extends AbstractPanelController {

	public void initLabel(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(firstNameLabel);
	    editPanel.addByY(lastNameLabel);
	    editPanel.addByY(middleNameLabel);
	}

	public void initField(JPanel panel) {
	    GridBagPanel editPanel = (GridBagPanel) panel;
	    editPanel.addByY(firstNameField);
	    editPanel.addByY(lastNameField);
	    editPanel.addByY(middleNameField);
	}

    }

}
