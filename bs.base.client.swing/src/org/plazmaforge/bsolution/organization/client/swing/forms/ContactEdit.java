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

package org.plazmaforge.bsolution.organization.client.swing.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.plazmaforge.bsolution.contact.client.swing.forms.AbstractContactableEdit;
import org.plazmaforge.bsolution.contact.common.beans.Contact;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.contact.common.beans.ContactType;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.employee.client.swing.forms.PositionList;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.beans.JobPosition;
import org.plazmaforge.bsolution.organization.OrganizationEnvironment;
import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.organization.common.beans.IOrganizable;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.personality.client.swing.forms.common.GenderComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class ContactEdit extends AbstractContactableEdit {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel dearLabel;

    private JLabel genderLabel;

    private JLabel partnerLabel;

    private JLabel departmentLabel;

    private JLabel positionLabel;

    private JLabel fullPositionNameLabel;

    private JLabel responsibleLabel;

    private JLabel contactTypeLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XTextField dearField;

    private GenderComboBox genderComboBox;

    private XComboEdit partnerComboEdit;

    private XComboEdit departmentComboEdit;

    private XComboEdit positionComboEdit;

    private XTextField fullPositionNameField;

    private XComboEdit responsibleComboEdit;

    private XComboEdit contactTypeComboEdit;

    private XTextEdit noteField;

    public ContactEdit() throws ApplicationException {
	super(GUIOrganizationEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Contact.class);
	this.setEntityServiceClass(ContactService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	setParentTabbedPane(createMasterTabbedPane());
	addParentTabbedPane();
	getChildrenPane().setMaximumSize(new Dimension(100, 50));
	setChildrenTabbedPane(createItemsTabbedPane());
	addChildrenTabbedPane();

    }

    private JTabbedPane createMasterTabbedPane() throws ApplicationException {
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.general.text"), createGeneralPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createGeneralPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	dearLabel = new JLabel(getString("panel.label-dear.text"));
	genderLabel = new JLabel(getString("panel.label-gender.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	departmentLabel = new JLabel(getString("panel.label-department.text"));
	positionLabel = new JLabel(getString("panel.label-position.text"));
	fullPositionNameLabel = new JLabel(getString("panel.label-position-full-name.text"));
	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));
	contactTypeLabel = new JLabel(getString("panel.label-contact-type.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(40);
	nameField.setMaxChar(50);
	dearField = new XTextField(20);
	dearField.setMaxChar(20);
	genderComboBox = new GenderComboBox();
	partnerComboEdit = new XComboEdit(true);
	departmentComboEdit = new XComboEdit(true);
	positionComboEdit = new XComboEdit(true);
	fullPositionNameField = new XTextField();
	fullPositionNameField.setMaxChar(50);
	responsibleComboEdit = new XComboEdit();
	contactTypeComboEdit = new XComboEdit();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(dearLabel);
	editPanel.addByY(genderLabel);
	editPanel.addByY(partnerLabel);
	editPanel.addByY(departmentLabel);
	editPanel.addByY(positionLabel);
	editPanel.addByY(fullPositionNameLabel);
	editPanel.addByY(responsibleLabel);
	editPanel.addByY(contactTypeLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	gbc.gridwidth = 1;
	editPanel.addByY(dearField);
	editPanel.addByY(genderComboBox);
	gbc.gridwidth = 2;
	editPanel.addByY(partnerComboEdit);
	editPanel.addByY(departmentComboEdit);
	editPanel.addByY(positionComboEdit);
	editPanel.addByY(fullPositionNameField);
	editPanel.addByY(responsibleComboEdit);
	editPanel.addByY(contactTypeComboEdit);

	partnerComboEdit.initListFormAction(this, PartnerList.class);
	departmentComboEdit.initListFormAction(this, DepartmentList.class);
	positionComboEdit.initListFormAction(this, PositionList.class);
	responsibleComboEdit.initListFormAction(this, EmployeeList.class, "fullName");
	contactTypeComboEdit.initListFormAction(this, ContactTypeList.class);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(150);
	tp.addTab(getString("table-address.name"), createAddressPanel());
	tp.addTab(getString("table-phone.name"), createPhonePanel());
	tp.addTab(getString("table-email.name"), createEmailPanel());
	tp.addTab(getString("table-web.name"), createWebPanel());
	return tp;
    }

    private Contact getContact() {
	return (Contact) this.getEntity();
    }

    protected IOrganizable getOrganizable() {
	return (IOrganizable) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	OrganizationEnvironment.initOrganizable(getOrganizable(), getEnterpriseContext());
    }

    protected ContactableElement getContactableElement() {
	return getContact().getContactableElement();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getContact().getName());
	codeField.setText(getContact().getCode());
	nameField.setText(getContact().getName());
	dearField.setText(getContact().getTitleName());
	genderComboBox.setSelectedGender(getContact().getGender());
	partnerComboEdit.setValue(getContact().getPartner());
	departmentComboEdit.setValue(getContact().getDepartment());
	positionComboEdit.setValue(getContact().getPosition());
	fullPositionNameField.setText(getContact().getFullPositionName());
	responsibleComboEdit.setValue(getContact().getResponsible());
	contactTypeComboEdit.setValue(getContact().getContactType());
	noteField.setText(getContact().getNote());
	updateTables();
    }

    protected void populateData() throws ApplicationException {
	getContact().setCode(codeField.getText());
	getContact().setName(nameField.getText());
	getContact().setTitleName(dearField.getText());
	getContact().setGender(genderComboBox.getSelectedGender());
	getContact().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getContact().setDepartment((Department) departmentComboEdit.getValue());
	getContact().setPosition((JobPosition) positionComboEdit.getValue());
	getContact().setFullPositionName(fullPositionNameField.getText());
	getContact().setResponsible((ContactHeader) responsibleComboEdit.getValue());
	getContact().setContactType((ContactType) contactTypeComboEdit.getValue());
	getContact().setNote(noteField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getContact().getName(), nameLabel.getText());
	validateRequiredField(buf, getContact().getGender() != 0, genderLabel.getText());
	validateRequiredField(buf, getContact().getResponsible(), responsibleLabel.getText());
	validateRequiredField(buf, getContact().getContactType(), contactTypeLabel.getText());
	checkError(buf);
    }

}
