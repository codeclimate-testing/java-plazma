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

/* 
 * Created on 17.05.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.AttributeValueView;
import org.plazmaforge.bsolution.base.client.swt.forms.FileView;
import org.plazmaforge.bsolution.contact.ContactEnvironment;
import org.plazmaforge.bsolution.contact.client.swt.forms.AddressEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.EmailEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.PhoneEditForm;
import org.plazmaforge.bsolution.contact.client.swt.forms.WebEditForm;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableItem;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableEditForm;
import org.plazmaforge.bsolution.personality.common.beans.Person;
import org.plazmaforge.bsolution.personality.common.beans.Speciality;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.XCombo;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XDateCombo;
import org.plazmaforge.framework.client.swt.controls.XTextArea;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ImagePanel;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;



/** 
 * @author Oleh Hapon
 * $Id: PersonEditForm.java,v 1.9 2010/12/05 07:57:19 ohapon Exp $
 */

public class PersonEditForm extends AbstractOrganizableEditForm {

    private Table webTable;
    private Table emailTable;
    private Table phoneTable;
    private Table addressTable;
    
    private Label codeLabel;
    private Label firstNameLabel;
    private Label middleNameLabel;
    private Label lastNameLabel;
    private Label nationalityLabel;
    private Label birthDateLabel;  
    private Label genderLabel;
    private Label familyStatusLabel;
    private Label countryResidenceLabel;
    private Label languageLabel;
    private Label idnLabel;    
    private Label responsibleLabel;
    
    private XTextField codeField;    
    private XTextField firstNameField;    
    private XTextField middleNameField;
    private XTextField lastNameField;    
    private XComboEdit nationalityField;
    private XDateCombo birthDateField;
    private XComboEdit familyStatusField;
    private XComboEdit countryResidenceField;
    private XComboEdit languageField;    
    private XTextField idnField;
    private XComboEdit responsibleField;
    
    private XTextArea noteField;
 

    private XCombo genderField;
    
    // Document
    private XComboEdit documentTypeField;
    private XTextField documentSeriesField;
    private XTextField documentNoField;
    private XDateCombo documentDateField;
    private XTextField documentGivenField;
    
    // Diploma
    private XComboEdit diplomaTypeField;
    private XTextField diplomaSeriesField;
    private XTextField diplomaNoField;
    private XDateCombo diplomaDateField;
    private XComboEdit diplomaSpecialityField;
    private XTextField diplomaQualificationField;

 
    // Military
    private XComboEdit militaryStatusField;
    private XComboEdit militaryRankField;
    private XComboEdit militarySpecialityField;
    private XComboEdit validStatusField;
    private XTextField militaryRegistrationField;
    private XTextField specialRecordField;
    
    private TabFolder itemTabFolder;
    
    private String nameVariant;
    
    
    ////
    
    
    private ImagePanel imagePanel;

    
    public PersonEditForm(Composite parent, int style) {
	super(parent, style);
	
	initialize();
    }
    
    protected void initialize() {
	nameVariant = LocaleManager.getNameVariant();
	setTitle(Messages.getString("PersonEditForm.title")); //$NON-NLS-1$
	
	TabFolder tabFolder;
	GridData gridData;
	Composite composite;
	TabItem documentsTabItem;
	TabItem noteTabItem;
	GridLayout gridLayout;
	
	
	Group identityGroup;
	Group diplomaGroup;
	Label qualificationLabel;
	Label validStatusLabel;
	Label specialRecordLabel;
	gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;		
	setLayout(gridLayout);

       	tabFolder = new TabFolder(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
       	tabFolder.setLayoutData(gridData);

    	TabItem generalTabItem = new TabItem(tabFolder, SWT.NONE);
    	generalTabItem.setText(Messages.getString("PersonEditForm.generalTabItem.text"));  //$NON-NLS-1$ //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	   	
    	gridLayout.numColumns = 4;
    	composite.setLayout(gridLayout);
    	generalTabItem.setControl(composite);

    	codeLabel = new Label(composite, SWT.NONE);
	codeLabel.setText(Messages.getString("PersonEditForm.codeLabel.text"));   //$NON-NLS-1$

    	codeField = new XTextField(composite, SWT.BORDER);
    	codeField.setTextLimit(10);
	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 100;
    	codeField.setLayoutData(gridData);

	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName(composite);
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName(composite);
	} else {
	    addFLName(composite);
	}
    	
	
    	nationalityLabel = new Label(composite, SWT.NONE);
	nationalityLabel.setText(Messages.getString("PersonEditForm.nationalityLabel.text"));   //$NON-NLS-1$

    	nationalityField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	nationalityField.setLayoutData(gridData);

    	birthDateLabel = new Label(composite, SWT.NONE);
	birthDateLabel.setText(Messages.getString("PersonEditForm.birthDateLabel.text"));   //$NON-NLS-1$

    	birthDateField = new XDateCombo(composite, SWT.BORDER);
    	birthDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	genderLabel = new Label(composite, SWT.RIGHT);
    	gridData = new GridData();
    	gridData.horizontalIndent = 100;
    	genderLabel.setLayoutData(gridData);
    	genderLabel.setText(Messages.getString("PersonEditForm.genderLabel.text"));   //$NON-NLS-1$

    	genderField = new XCombo(composite, SWT.BORDER);
    	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	genderField.setLayoutData(gridData);

	//
    	familyStatusLabel = new Label(composite, SWT.NONE);
    	familyStatusLabel.setText(Messages.getString("PersonEditForm.familyStatusLabel.text"));   //$NON-NLS-1$

    	familyStatusField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 350;
    	familyStatusField.setLayoutData(gridData);
	
    	countryResidenceLabel = new Label(composite, SWT.NONE);
    	countryResidenceLabel.setText(Messages.getString("PersonEditForm.countryResidenceLabel.text"));   //$NON-NLS-1$

    	countryResidenceField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 350;
    	countryResidenceField.setLayoutData(gridData);
	
	languageLabel = new Label(composite, SWT.NONE);
	languageLabel.setText(Messages.getString("PersonEditForm.languageLabel.text"));   //$NON-NLS-1$

	languageField = new XComboEdit(composite, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	languageField.setLayoutData(gridData);	
    	//


	idnLabel = new Label(composite, SWT.NONE);
	idnLabel.setText(Messages.getString("PersonEditForm.idnLabel.text"));   //$NON-NLS-1$

    	idnField = new XTextField(composite, SWT.BORDER);
    	idnField.setTextLimit(10);
    	gridData = new GridData(SWT.DEFAULT, SWT.CENTER, false, false, 3, 1);
    	gridData.widthHint = 100;
    	idnField.setLayoutData(gridData);
	
	if (isResponsibleInPersonForm()) {
	    responsibleLabel = new Label(composite, SWT.NONE);
	    responsibleLabel.setText(Messages.getString("PersonEditForm.responsibleLabel.text")); //$NON-NLS-1$

	    responsibleField = new XComboEdit(composite, SWT.BORDER, PWT.VIEW_BUTTON | PWT.DELETE_BUTTON);
	    responsibleField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	}
	
    	documentsTabItem = new TabItem(tabFolder, SWT.NONE);
    	documentsTabItem.setText(Messages.getString("PersonEditForm.documentsTabItem.text"));   //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());
    	documentsTabItem.setControl(composite);

    	identityGroup = new Group(composite, SWT.NONE);
    	gridLayout = new GridLayout();
	 	
    	gridLayout.numColumns = 6;
    	
    	identityGroup.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	identityGroup.setLayoutData(gridData);
    	identityGroup.setText(Messages.getString("PersonEditForm.identityGroup.text"));   //$NON-NLS-1$

    	Label documentTypeLabel = new Label(identityGroup, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 90;
    	documentTypeLabel.setLayoutData(gridData);
    	documentTypeLabel.setText(Messages.getString("PersonEditForm.documentTypeLabel.text"));  //$NON-NLS-1$

    	documentTypeField = new XComboEdit(identityGroup, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	gridData.widthHint = 300;
    	documentTypeField.setLayoutData(gridData);

    	Label documentSeriesLabel = new Label(identityGroup, SWT.NONE);
    	documentSeriesLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentSeriesLabel.setText(Messages.getString("PersonEditForm.documentSeriesLabel.text"));  //$NON-NLS-1$

    	documentSeriesField = new XTextField(identityGroup, SWT.BORDER);
	documentSeriesField.setLayoutData(new GridData(100, SWT.DEFAULT));
	documentSeriesField.setTextLimit(10);

    	Label documentNoLabel = new Label(identityGroup, SWT.NONE);
    	documentNoLabel.setText(Messages.getString("PersonEditForm.documentNoLabel.text"));  //$NON-NLS-1$

    	documentNoField = new XTextField(identityGroup, SWT.BORDER);
	documentNoField.setLayoutData(new GridData(100, SWT.DEFAULT));
	documentNoField.setTextLimit(10);

    	Label documentDateLabel = new Label(identityGroup, SWT.NONE);
    	documentDateLabel.setText(Messages.getString("PersonEditForm.documentDateLabel.text"));  //$NON-NLS-1$

    	documentDateField = new XDateCombo(identityGroup, SWT.BORDER);
    	documentDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	Label documentGivenLabel = new Label(identityGroup, SWT.NONE);
    	documentGivenLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	documentGivenLabel.setText(Messages.getString("PersonEditForm.documentGivenLabel.text"));  //$NON-NLS-1$

    	documentGivenField = new XTextField(identityGroup, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	gridData.widthHint = 300;
    	documentGivenField.setLayoutData(gridData);
    	documentGivenField.setTextLimit(100);

    	diplomaGroup = new Group(composite, SWT.NONE);
    	diplomaGroup.setText(Messages.getString("PersonEditForm.diplomaGroup.text"));  //$NON-NLS-1$
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	diplomaGroup.setLayoutData(gridData);
    	
    	
    	gridLayout = new GridLayout();
    	   	
    	gridLayout.numColumns = 6;
    	diplomaGroup.setLayout(gridLayout);

    	Label diplomaTypeLabel = new Label(diplomaGroup, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 90;
    	diplomaTypeLabel.setLayoutData(gridData);
    	diplomaTypeLabel.setText(Messages.getString("PersonEditForm.diplomaTypeLabel.text"));  //$NON-NLS-1$

    	diplomaTypeField = new XComboEdit(diplomaGroup, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
    	gridData.widthHint = 300;
    	diplomaTypeField.setLayoutData(gridData);

    	Label diplomaSeriesLabel = new Label(diplomaGroup, SWT.NONE);
    	diplomaSeriesLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    	diplomaSeriesLabel.setText(Messages.getString("PersonEditForm.diplomaSeriesLabel.text"));  //$NON-NLS-1$

    	diplomaSeriesField = new XTextField(diplomaGroup, SWT.BORDER);
	diplomaSeriesField.setLayoutData(new GridData(100, SWT.DEFAULT));
	diplomaSeriesField.setTextLimit(10);

    	Label diplomaNoLabel = new Label(diplomaGroup, SWT.NONE);
    	diplomaNoLabel.setText(Messages.getString("PersonEditForm.diplomaNoLabel.text"));  //$NON-NLS-1$

    	diplomaNoField = new XTextField(diplomaGroup, SWT.BORDER);
	diplomaNoField.setLayoutData(new GridData(100, SWT.DEFAULT));
	diplomaNoField.setTextLimit(10);

    	Label diplomaDateLabel = new Label(diplomaGroup, SWT.NONE);
    	diplomaDateLabel.setText(Messages.getString("PersonEditForm.diplomaDateLabel.text"));  //$NON-NLS-1$

    	diplomaDateField = new XDateCombo(diplomaGroup, SWT.BORDER);
	diplomaDateField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	Label diplomaSpecialityLabel = new Label(diplomaGroup, SWT.NONE);
    	diplomaSpecialityLabel.setText(Messages.getString("PersonEditForm.diplomaSpecialityLabel.text"));  //$NON-NLS-1$

    	diplomaSpecialityField = new XComboEdit(diplomaGroup, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	diplomaSpecialityField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

    	qualificationLabel = new Label(diplomaGroup, SWT.NONE);
    	qualificationLabel.setText(Messages.getString("PersonEditForm.qualificationLabel.text"));  //$NON-NLS-1$

    	diplomaQualificationField = new XTextField(diplomaGroup, SWT.BORDER);
	diplomaQualificationField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
	diplomaQualificationField.setTextLimit(30);
    	
	
	
	TabItem militaryTabItem = new TabItem(tabFolder, SWT.NONE);
	militaryTabItem.setText(Messages.getString("PersonEditForm.militaryTabItem.text"));  //$NON-NLS-1$

    	composite = new Composite(tabFolder, SWT.NONE);
    	composite.setLayout(new GridLayout());
    	militaryTabItem.setControl(composite);

    	Group militaryGroup = new Group(composite, SWT.NONE);
    	militaryGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    	gridLayout = new GridLayout();
    	gridLayout.numColumns = 2;
	
    	
    	militaryGroup.setLayout(gridLayout);

    	Label militaryStatusLabel = new Label(militaryGroup, SWT.NONE);
    	militaryStatusLabel.setText(Messages.getString("PersonEditForm.militaryStatusLabel.text"));  //$NON-NLS-1$

    	militaryStatusField = new XComboEdit(militaryGroup, SWT.BORDER);
    	militaryStatusField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	Label militaryRankLabel = new Label(militaryGroup, SWT.NONE);
    	militaryRankLabel.setText(Messages.getString("PersonEditForm.militaryRankLabel.text"));  //$NON-NLS-1$

    	militaryRankField = new XComboEdit(militaryGroup, SWT.BORDER);
    	militaryRankField.setLayoutData(new GridData(300, SWT.DEFAULT));

    	Label militarySpecialityLabel = new Label(militaryGroup, SWT.NONE);
    	militarySpecialityLabel.setText(Messages.getString("PersonEditForm.militarySpecialityLabel.text"));  //$NON-NLS-1$

    	militarySpecialityField = new XComboEdit(militaryGroup, SWT.BORDER);
    	militarySpecialityField.setLayoutData(new GridData(300, SWT.DEFAULT));

    	validStatusLabel = new Label(militaryGroup, SWT.NONE);
    	validStatusLabel.setText(Messages.getString("PersonEditForm.validStatusLabel.text"));  //$NON-NLS-1$

    	validStatusField = new XComboEdit(militaryGroup, SWT.BORDER);
    	validStatusField.setLayoutData(new GridData(100, SWT.DEFAULT));

    	Label militaryRegistrationLabel = new Label(militaryGroup, SWT.NONE);
    	militaryRegistrationLabel.setText(Messages.getString("PersonEditForm.militaryRegistrationLabel.text"));  //$NON-NLS-1$

    	militaryRegistrationField = new XTextField(militaryGroup, SWT.BORDER);
    	militaryRegistrationField.setLayoutData(new GridData(300, SWT.DEFAULT));

    	specialRecordLabel = new Label(militaryGroup, SWT.NONE);
    	specialRecordLabel.setText(Messages.getString("PersonEditForm.specialRecordLabel.text"));  //$NON-NLS-1$

    	specialRecordField = new XTextField(militaryGroup, SWT.BORDER);
	specialRecordField.setLayoutData(new GridData(300, SWT.DEFAULT));
    	
    	

    	//////////////////////////////////////////////////////
    	
    	TabItem imageTabItem = new TabItem(tabFolder, SWT.NONE);
    	imageTabItem.setText(Messages.getString("Photo.text")); //$NON-NLS-1$
    	imagePanel = new ImagePanel(tabFolder, Messages.getString("Photo.text"));
    	imageTabItem.setControl(imagePanel);
    	
    	//////////////////////////////////////////////////////

    	
    	
    	noteTabItem = new TabItem(tabFolder, SWT.NONE);
    	noteTabItem.setText(Messages.getString("PersonEditForm.noteTabItem.text"));  //$NON-NLS-1$

    	
    	noteField = new XTextArea(tabFolder, SWT.NONE | SWT.MULTI);
    	noteField.setTextLimit(255);
    	noteField.setFixedHeight(100);
    	
    	noteField.setTextLimit(255);
	noteTabItem.setControl(noteField);

    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this);
    	itemToolPanel.setForm(this);

    	createItemPanel();
    	AttributeValueView attributeView = new AttributeValueView(itemTabFolder, Person.class);
    	FileView fileView = new FileView(itemTabFolder, Person.class);


    	//TODO
    	genderField.addValue((byte) 1, Messages.getString("PersonEditForm.0"));  //$NON-NLS-1$
    	genderField.addValue((byte) 2, Messages.getString("PersonEditForm.1"));  //$NON-NLS-1$
    	
    	diplomaSpecialityField.setEntityClass(Speciality.class);
    	
    	registerEntityProvider(itemTabFolder.getItem(0), new AddressProvider());
    	registerEntityProvider(itemTabFolder.getItem(1), new PhoneProvider());
    	registerEntityProvider(itemTabFolder.getItem(2), new EmailProvider());
    	registerEntityProvider(itemTabFolder.getItem(3), new WebProvider());
    	registerEntityProvider(itemTabFolder.getItem(4), attributeView.getEntityProvider());
    	registerEntityProvider(itemTabFolder.getItem(5), fileView.getEntityProvider());
    
    	initResponsibleField(responsibleField);
    }
    
    private void addFLName(Composite composite) {
	addFirstName(composite);
	addLastName(composite);
    }

    private void addLFMName(Composite composite) {
	addLastName(composite);
	addFirstName(composite);
	addMiddleName(composite);
    }

    private void addFLMName(Composite composite) {
	addFirstName(composite);
	addLastName(composite);
	addMiddleName(composite);
    }
    
    private void addFirstName(Composite composite) {
    	firstNameLabel = new Label(composite, SWT.NONE);
	firstNameLabel.setText(Messages.getString("PersonEditForm.firstNameLabel.text"));   //$NON-NLS-1$

    	firstNameField = new XTextField(composite, SWT.BORDER);
    	firstNameField.setTextLimit(30);
    	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
    	firstNameField.setLayoutData(gridData);
    }

    private void addMiddleName(Composite composite) {
    	middleNameLabel = new Label(composite, SWT.NONE);
	middleNameLabel.setText(Messages.getString("PersonEditForm.middleNameLabel.text"));   //$NON-NLS-1$

	middleNameField = new XTextField(composite, SWT.BORDER);
	middleNameField.setTextLimit(30);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	middleNameField.setLayoutData(gridData);
    }

    
    private void addLastName(Composite composite) {
	lastNameLabel = new Label(composite, SWT.NONE);
	lastNameLabel.setText(Messages.getString("PersonEditForm.lastNameLabel.text"));   //$NON-NLS-1$

	lastNameField = new XTextField(composite, SWT.BORDER);
	lastNameField.setTextLimit(30);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
	gridData.widthHint = 350;
	lastNameField.setLayoutData(gridData);
    }

    
    protected void bindControls() {
	bindControl(codeField, "personCode");
	
	bindControl(firstNameField, "firstName", firstNameLabel, REQUIRED);
	if (middleNameField != null) {
	    bindControl(middleNameField, "middleName");
	}
	bindControl(lastNameField, "lastName");
	
	bindControl(nationalityField, "nationality");
	bindControl(birthDateField, "birthDate");
	bindControl(genderField, "gender", genderLabel, REQUIRED);
	bindControl(familyStatusField, "familyStatus");
	bindControl(countryResidenceField, "countryResidence");
	bindControl(languageField, "language");
	bindControl(idnField, "idnCode");	
	
	//
	bindControl(documentTypeField, "documentType");
	bindControl(documentSeriesField, "documentSeries"); 
	bindControl(documentNoField, "documentNo");
	bindControl(documentDateField, "documentDate");
	bindControl(documentGivenField, "documentGiven");

	//
	bindControl(diplomaTypeField, "diplomaType");
	bindControl(diplomaSeriesField, "diplomaSeries");
	bindControl(diplomaNoField, "diplomaNo");
	bindControl(diplomaDateField, "diplomaDate");
	bindControl(diplomaSpecialityField, "diplomaSpeciality");
	bindControl(diplomaQualificationField, "diplomaQualification");
	
	//
	bindControl(militaryRankField, "militaryRank");
	bindControl(militarySpecialityField, "militarySpeciality"); 
	bindControl(militaryRegistrationField, "militaryRegistration");
	bindControl(specialRecordField, "specialRecord");
   	
	if (isResponsibleInPersonForm()) {
	    bindControl(responsibleField, "responsible");
	}
	
	bindControl(noteField, "note");
	
    }
    
    private void createItemPanel() {
	
	TabItem addressTabItem;
	TabItem phoneTabItem;
	TabItem emailTabItem;
	TabItem webTabItem;
	
	
  	GridData gridData;
  	Composite itemPanel = new Composite(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    	gridData.heightHint = 150;
    	itemPanel.setLayoutData(gridData);
    	itemPanel.setLayout(new FillLayout());

    	itemTabFolder = new TabFolder(itemPanel, SWT.NONE);
	addressTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	addressTabItem.setText(Messages.getString("PersonEditForm.addressTabItem.text"));  //$NON-NLS-1$

    	addressTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	addressTable.setLinesVisible(true);
    	addressTable.setHeaderVisible(true);
    	addressTabItem.setControl(addressTable);

    	TableColumn tableColumn = new TableColumn(addressTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn addressTypeColumn = new TableColumn(addressTable, SWT.NONE);
    	addressTypeColumn.setWidth(100);
    	addressTypeColumn.setText(Messages.getString("PersonEditForm.addressTypeColumn.text"));  //$NON-NLS-1$

    	final TableColumn fullAddressStringColumn = new TableColumn(addressTable, SWT.NONE);
    	fullAddressStringColumn.setWidth(337);
    	fullAddressStringColumn.setText(Messages.getString("PersonEditForm.fullAddressString.text"));  //$NON-NLS-1$

    	phoneTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	phoneTabItem.setText(Messages.getString("PersonEditForm.phoneTabItem.text"));  //$NON-NLS-1$

    	phoneTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	phoneTable.setLinesVisible(true);
    	phoneTable.setHeaderVisible(true);
    	phoneTabItem.setControl(phoneTable);

    	tableColumn = new TableColumn(phoneTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn phoneTypeColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneTypeColumn.setWidth(100);
    	phoneTypeColumn.setText(Messages.getString("PersonEditForm.phoneTypeColumn.text"));  //$NON-NLS-1$

    	final TableColumn phoneStringColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneStringColumn.setWidth(343);
    	phoneStringColumn.setText(Messages.getString("PersonEditForm.phoneStringColumn.text"));  //$NON-NLS-1$

    	emailTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	emailTabItem.setText(Messages.getString("PersonEditForm.emailTabItem.text"));  //$NON-NLS-1$

    	emailTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	emailTable.setLinesVisible(true);
    	emailTable.setHeaderVisible(true);
    	emailTabItem.setControl(emailTable);

    	tableColumn = new TableColumn(emailTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn emailColumn = new TableColumn(emailTable, SWT.NONE);
    	emailColumn.setWidth(349);
    	emailColumn.setText(Messages.getString("PersonEditForm.emailColumn.text"));  //$NON-NLS-1$

    	webTabItem = new TabItem(itemTabFolder, SWT.NONE);
    	webTabItem.setText(Messages.getString("PersonEditForm.webTabItem.text"));  //$NON-NLS-1$

    	webTable = new Table(itemTabFolder, SWTToolkit.TABLE_STYLE);
    	webTable.setLinesVisible(true);
    	webTable.setHeaderVisible(true);
    	webTabItem.setControl(webTable);

    	tableColumn = new TableColumn(webTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn urlColumn = new TableColumn(webTable, SWT.NONE);
    	urlColumn.setWidth(377);
    	urlColumn.setText(Messages.getString("PersonEditForm.urlColumn.text"));  //$NON-NLS-1$

     	

    }

    
    protected class AddressProvider extends TableEntityProvider {
	
	public AddressProvider() {
	    setParentEntityClass(Person.class); // OWNER
	    setListProperty("addressList");
	    setAddMethod("addAddress");
	    
	    setEntityClass(Address.class); // FORM ID
	    setEntityFormClass(AddressEditForm.class);
	}
	
	protected Table getTable() {
	    return addressTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "addressTypeName");
	    bindColumn(2, "fullAddressString");
	}
    }
    
    protected class PhoneProvider extends TableEntityProvider {
	
	public PhoneProvider() {
	    setParentEntityClass(Person.class); // OWNER
	    setListProperty("phoneList");
	    setAddMethod("addPhone");
	    
	    setEntityClass(Phone.class); // FORM ID
	    setEntityFormClass(PhoneEditForm.class);
	}
	
	protected Table getTable() {
	    return phoneTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "phoneTypeName"); 
	    bindColumn(2, "phoneString"); 
	}
    }

    protected class EmailProvider extends TableEntityProvider {
	
	public EmailProvider() {
	    setParentEntityClass(Person.class); // OWNER
	    setListProperty("emailList");
	    setAddMethod("addEmail"); 
	    
	    setEntityClass(Email.class); // FORM ID
	    setEntityFormClass(EmailEditForm.class);
	}
	
	protected Table getTable() {
	    return emailTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "emailAddress");
	}
    }
    
    
    protected class WebProvider extends TableEntityProvider {
	
	public WebProvider() {
	    setParentEntityClass(Person.class); // OWNER
	    setListProperty("webList");
	    setAddMethod("addWeb"); 
	    
	    setEntityClass(Web.class); // FORM ID
	    setEntityFormClass(WebEditForm.class);
	}
	
	protected Table getTable() {
	    return webTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "url"); 
	}
    }
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = itemTabFolder.getSelectionIndex();
        return itemTabFolder.getItem(index);
    }
    
    protected void afterModifyItem(Object item) throws ApplicationException {
	refreshEntityProviderViewByItemAndClass(item, ContactableItem.class);
    }
    
    protected Person getPerson() {
	return (Person) getEntity();
    }

    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	imagePanel.setData(getPerson().getImageEntry().getBinaryData());
    }

    public void updateData() throws ApplicationException {
	getPerson().getImageEntry().setBinaryData(imagePanel.getData());
	getPerson().getImageEntry().setFileExt(imagePanel.getFileExt());
	super.updateData();
	getPerson().setName(getPerson().generateName());
    }
    
    public void initData() throws ApplicationException {
	super.initData();
	
	//TODO
	getPerson().setContactType(ContactEnvironment.getContactType());
	//getPerson().setResponsible(ContactEnvironment.getResponsible());
    }
    

    protected boolean isResponsibleInPersonForm() {
	return false;
    }
    
}

