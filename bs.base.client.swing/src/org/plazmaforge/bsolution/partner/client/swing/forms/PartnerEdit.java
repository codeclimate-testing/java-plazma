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
package org.plazmaforge.bsolution.partner.client.swing.forms;


import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.contact.client.swing.forms.AbstractContactableEdit;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.finance.client.swing.forms.LedgerAccountList;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccount;
import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerCategoryLinkEdit;
import org.plazmaforge.bsolution.partner.common.beans.FormProperty;
import org.plazmaforge.bsolution.partner.common.beans.Industry;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerActivityTypeLink;
import org.plazmaforge.bsolution.partner.common.beans.PartnerCategoryLink;
import org.plazmaforge.bsolution.partner.common.beans.PartnerGroup;
import org.plazmaforge.bsolution.partner.common.services.FormPropertyService;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleh Hapon
 * Date: 19.03.2004
 * Time: 10:33:36
 * $Id: PartnerEdit.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerEdit extends AbstractContactableEdit {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel fullNameLabel;

    private JLabel formPropertyLabel;

    private JLabel swiftCodeLabel;

    private JLabel taxCodeLabel;

    private JLabel taxDocNoLabel;

    private JLabel taxLabel;

    private JLabel partnerGroupLabel;

    private JLabel industryLabel;

    private JLabel yearCreateLabel;

    private JLabel workTimeLabel;

    private JLabel ledgerAccountLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XTextField fullNameField;

    private XComboBox formPropertyComboBox;

    private XTextField swiftCodeField;

    private XTextField taxCodeField;

    private XTextField taxDocNoField;

    private JCheckBox taxField;

    private XComboEdit partnerGroupComboEdit;

    private XComboEdit industryComboEdit;

    private XTextField yearCreateField;

    private XTextField workTimeField;

    private XComboEdit ledgerAccountComboEdit;

    private XTextEdit noteField;

    public PartnerEdit() throws ApplicationException {
	super(GUIPartnerEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Partner.class);
	this.setEntityServiceClass(PartnerService.class);
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
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.other.text"), createOtherPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	fullNameLabel = new JLabel(getString("panel.label-full-name.text"));
	formPropertyLabel = new JLabel(getString("panel.label-form-property.text"));
	swiftCodeLabel = new JLabel(getString("panel.label-swift-code.text"));
	taxCodeLabel = new JLabel(getString("panel.label-tax-code.text"));
	taxDocNoLabel = new JLabel(getString("panel.label-tax-doc-no.text"));
	taxLabel = new JLabel(getString("panel.label-tax.text"));
	partnerGroupLabel = new JLabel(getString("panel.label-partner-group.text"));
	industryLabel = new JLabel(getString("panel.label-industry.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(10);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);
	fullNameField = new XTextField(50);
	fullNameField.setMaxChar(100);
	formPropertyComboBox = new XComboBox(getFormPropertyService().findAll());
	swiftCodeField = new XTextField(20);
	swiftCodeField.setMaxChar(20);
	taxCodeField = new XTextField(20);
	taxCodeField.setMaxChar(12);
	taxDocNoField = new XTextField(20);
	taxDocNoField.setMaxChar(20);
	taxField = new JCheckBox();
	partnerGroupComboEdit = new XComboEdit(true);
	industryComboEdit = new XComboEdit(true);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);
	editPanel.addByY(fullNameLabel);
	editPanel.addByY(formPropertyLabel);
	editPanel.addByY(swiftCodeLabel);
	editPanel.addByY(taxCodeLabel);
	editPanel.addByY(taxDocNoLabel);
	editPanel.addByY(taxLabel);
	editPanel.addByY(partnerGroupLabel);
	editPanel.addByY(industryLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);
	editPanel.addByY(fullNameField);
	gbc.gridwidth = 1;
	editPanel.addByY(formPropertyComboBox);
	editPanel.addByY(swiftCodeField);
	editPanel.addByY(taxCodeField);
	editPanel.addByY(taxDocNoField);
	editPanel.addByY(taxField);
	gbc.gridwidth = 2;
	editPanel.addByY(partnerGroupComboEdit);
	editPanel.addByY(industryComboEdit);

	partnerGroupComboEdit.initListFormAction(this, PartnerGroupList.class);
	industryComboEdit.initListFormAction(this, IndustryList.class);

	return editPanel;
    }

    private JPanel createOtherPanel() throws ApplicationException {

	yearCreateLabel = new JLabel(getString("panel.label-year-create.text"));
	workTimeLabel = new JLabel(getString("panel.label-work-time.text"));
	ledgerAccountLabel = new JLabel(getString("panel.label-ledger-account.text"));

	yearCreateField = new XTextField(4);
	yearCreateField.setMaxChar(4);
	workTimeField = new XTextField(30);
	workTimeField.setMaxChar(50);
	ledgerAccountComboEdit = new XComboEdit(true);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(yearCreateLabel);
	editPanel.addByY(workTimeLabel);
	editPanel.addByY(ledgerAccountLabel);

	gbc.gridy = 0;
	editPanel.addByX(yearCreateField);
	editPanel.addByY(workTimeField);
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByY(ledgerAccountComboEdit);

	ledgerAccountComboEdit.initListFormAction(this,	LedgerAccountList.class, "accountName");

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
	tp.addTab(getString("table-category.name"), createCategoryPanel());
	tp.addTab(getString("table-activity-type.name"), createActivityTypePanel());
	return tp;
    }

    private Partner getPartner() {
	return (Partner) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPartner().getName());
	codeField.setText(getPartner().getCode());
	nameField.setText(getPartner().getName());
	fullNameField.setText(getPartner().getFullName());
	formPropertyComboBox.setValue(getPartner().getFormProperty());

	swiftCodeField.setText(getPartner().getNec());
	taxCodeField.setText(getPartner().getIdn());
	taxDocNoField.setText(getPartner().getTaxDocNo());
	taxField.setSelected(getPartner().isTax());
	partnerGroupComboEdit.setValue(getPartner().getPartnerGroup());
	industryComboEdit.setValue(getPartner().getIndustry());

	yearCreateField.setText(String.valueOf(getPartner().getYearCreate()));
	workTimeField.setText(getPartner().getWorkTime());
	ledgerAccountComboEdit.setValue(getPartner().getLedgerAccount());
	noteField.setText(getPartner().getNote());

	updateTables();

    }

    protected void updateTables() {
	super.updateTables();
	List categoryList = getPartner().getPartnerCategoryLinkList();
	((StateTableModel) categoryTable.getModel()).addData(categoryList);

	List activityTypeList = getPartner().getPartnerActivityTypeLinkList();
	((StateTableModel) activityTypeTable.getModel()).addData(activityTypeList);

    }

    private FormPropertyService getFormPropertyService() {
	return (FormPropertyService) getSERVICE(FormPropertyService.class);
    }

    protected void populateData() throws ApplicationException {
	getPartner().setCode(codeField.getText());
	getPartner().setName(nameField.getText());
	getPartner().setFullName(fullNameField.getText());
	getPartner().setFormProperty((FormProperty) formPropertyComboBox.getValue());
	getPartner().setNec(swiftCodeField.getText());
	getPartner().setIdn(taxCodeField.getText());
	getPartner().setTaxDocNo(taxDocNoField.getText());
	getPartner().setTax(taxField.isSelected());
	getPartner().setPartnerGroup((PartnerGroup) partnerGroupComboEdit.getValue());
	getPartner().setIndustry((Industry) industryComboEdit.getValue());

	getPartner().setYearCreate(Integer.valueOf(yearCreateField.getText()).intValue());
	getPartner().setWorkTime(workTimeField.getText());
	getPartner().setLedgerAccount((LedgerAccount) ledgerAccountComboEdit.getValue());

	getPartner().setNote(noteField.getText());
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	if (form instanceof PartnerCategoryLinkEdit) {
	    ((PartnerCategoryLinkEdit) form).setPartner(getPartner());
	} else if (form instanceof PartnerActivityTypeLinkEdit) {
	    ((PartnerActivityTypeLinkEdit) form).setPartner(getPartner());
	}
	return form;
    }

    protected ContactableElement getContactableElement() {
	return getPartner().getContactableElement();
    }

    /*****************************************************************************************************************/
    /* Partner Category Link Item                                                                                     */
    /*****************************************************************************************************************/

    protected JTable categoryTable;

    protected JTable activityTypeTable;

    protected JComponent createCategoryPanel() throws ApplicationException {
	categoryTable = createChildTable(createCategoryTableModel());
	JScrollPane scroll = new JScrollPane(categoryTable);
	this.registerEntityType(scroll, new CategoryItemType());
	return scroll;
    }

    protected TableModel createCategoryTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table-category.column-partner-category.name"));
	d.setFieldName("partnerCategoryName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(PartnerCategoryLink.class, columns);
    }

    protected PartnerCategoryLinkEdit getCategoryEdit()
	    throws ApplicationException {
	return (PartnerCategoryLinkEdit) getEDIT(PartnerCategoryLinkEdit.class);
    }

    protected class CategoryItemType extends AbstractChildType {
	public JTable getTable() {
	    return categoryTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getCategoryEdit();
	}
    }

    protected JComponent createActivityTypePanel() throws ApplicationException {
	activityTypeTable = createChildTable(createActivityTypeTableModel());
	JScrollPane scroll = new JScrollPane(activityTypeTable);
	this.registerEntityType(scroll, new ActivityTypeItemType());
	return scroll;
    }

    protected TableModel createActivityTypeTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table-activity-type.column-activity-type.name"));
	d.setFieldName("activityTypeName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(PartnerActivityTypeLink.class, columns);
    }

    protected PartnerActivityTypeLinkEdit getActivityTypeEdit() throws ApplicationException {
	return (PartnerActivityTypeLinkEdit) getEDIT(PartnerActivityTypeLinkEdit.class);
    }

    protected class ActivityTypeItemType extends AbstractChildType {
	public JTable getTable() {
	    return activityTypeTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getActivityTypeEdit();
	}
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getPartner().getName(), nameLabel.getText());
	checkError(buf);
    }

}
