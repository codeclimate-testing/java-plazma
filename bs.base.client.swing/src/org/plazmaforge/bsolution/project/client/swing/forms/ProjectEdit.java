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
package org.plazmaforge.bsolution.project.client.swing.forms;

import java.awt.*;

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.CurrencyList;
import org.plazmaforge.bsolution.base.client.swing.forms.common.XTaxComboBox;
import org.plazmaforge.bsolution.base.common.beans.Currency;
import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.organization.client.swing.forms.AbstractOrganizableEdit;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerList;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.project.ProjectEnvironment;
import org.plazmaforge.bsolution.project.client.swing.GUIProjectEnvironment;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.beans.ProjectStatus;
import org.plazmaforge.bsolution.project.common.beans.ProjectType;
import org.plazmaforge.bsolution.project.common.services.ProjectService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class ProjectEdit extends AbstractOrganizableEdit {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JLabel contractLabel;

    private JLabel startDateLabel;

    private JLabel closeDateLabel;

    private JLabel actualCloseDateLabel;

    private JLabel propabilityLabel;

    private JLabel partnerLabel;

    private JLabel projectStateLabel;

    private JLabel projectTypeLabel;

    private JLabel responsibleLabel;

    private JLabel currencyLabel;

    private JLabel amountLabel;

    private JLabel taxPercentLabel;

    private JLabel taxAmountLabel;

    private JLabel amountWithTaxLabel;

    private JLabel discountPercentLabel;

    private JLabel discountAmountLabel;

    private JLabel currencyRateLabel;

    private JLabel currencyRateDateLabel;

    private JLabel currencyAmountLabel;

    private JLabel currencyTaxAmountLabel;

    private JLabel currencyAmountWithTaxLabel;

    private JLabel currencyDiscountAmountLabel;

    private XTextField codeField;

    private XTextField nameField;

    private XTextField contractField;

    private XDateField startDateField;

    private XDateField closeDateField;

    private XDateField actualCloseDateFiled;

    private XNumberField propabilityField;

    private XComboEdit partnerComboEdit;

    private XComboEdit projectStateComboEdit;

    private XComboEdit projectTypeComboEdit;

    private XComboEdit responsibleComboEdit;

    private XComboEdit currencyComboEdit;

    private XNumberField amountField;

    private XTaxComboBox taxPercentField;

    private XNumberField taxAmountField;

    private XNumberField amountWithTaxField;

    private XNumberField discountPercentField;

    private XNumberField discountAmountField;

    private XNumberField currencyRateField;

    private XDateField currencyRateDateField;

    private XNumberField currencyAmountField;

    private XNumberField currencyTaxAmountField;

    private XNumberField currencyAmountWithTaxField;

    private XNumberField currencyDiscountAmountField;

    private XTextEdit noteField;

    public ProjectEdit() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Project.class);
	this.setEntityServiceClass(ProjectService.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	JTabbedPane tp = new JTabbedPane();
	tp.addTab(getString("panel.title.common.text"), createCommonPanel());
	tp.addTab(getString("panel.title.finance.text"), createFinancePanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	add(tp);
    }

    protected JPanel createCommonPanel() throws ApplicationException {

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));
	contractLabel = new JLabel(getString("panel.label-contract.text"));
	startDateLabel = new JLabel(getString("panel.label-start-date.text"));
	closeDateLabel = new JLabel(getString("panel.label-close-date.text"));
	actualCloseDateLabel = new JLabel(getString("panel.label-actual-close-date.text"));
	propabilityLabel = new JLabel(getString("panel.label-propability.text"));
	partnerLabel = new JLabel(getString("panel.label-partner.text"));
	projectStateLabel = new JLabel(getString("panel.label-project-state.text"));
	projectTypeLabel = new JLabel(getString("panel.label-project-type.text"));
	responsibleLabel = new JLabel(getString("panel.label-responsible.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);
	contractField = new XTextField(20);
	contractField.setMaxChar(20);
	startDateField = new XDateField();
	closeDateField = new XDateField();
	actualCloseDateFiled = new XDateField();
	propabilityField = new XNumberField(20);
	partnerComboEdit = new XComboEdit(true);
	projectStateComboEdit = new XComboEdit();
	projectTypeComboEdit = new XComboEdit();
	responsibleComboEdit = new XComboEdit();

	partnerComboEdit.initListFormAction(this, PartnerList.class);
	projectStateComboEdit.initListFormAction(this, ProjectStateList.class);
	projectTypeComboEdit.initListFormAction(this, ProjectTypeList.class);
	responsibleComboEdit.initListFormAction(this, EmployeeList.class,
		"fullName");

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	// COLUMN 0
	editPanel.add(nameLabel);
	editPanel.addByY(codeLabel);
	editPanel.addByY(contractLabel);
	editPanel.addByY(partnerLabel);
	editPanel.addByY(startDateLabel);
	editPanel.addByY(closeDateLabel);

	// COLUMN 1
	gbc.gridx = 2;
	gbc.gridy = 1;
	editPanel.add(projectTypeLabel);
	editPanel.addByY(responsibleLabel);
	editPanel.addByY(projectStateLabel);
	editPanel.addByY(propabilityLabel);
	editPanel.addByY(actualCloseDateLabel);

	// COLUMN 0
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = 3;
	editPanel.add(nameField);
	gbc.gridwidth = 1;
	editPanel.addByY(codeField);
	gbc.gridwidth = 1;
	editPanel.addByY(contractField);
	editPanel.addByY(partnerComboEdit);
	editPanel.addByY(startDateField);
	editPanel.addByY(closeDateField);

	// COLUMN 1
	gbc.gridx = 3;
	gbc.gridy = 1;
	editPanel.add(projectTypeComboEdit);
	editPanel.addByY(responsibleComboEdit);
	editPanel.addByY(projectStateComboEdit);
	editPanel.addByY(propabilityField);
	editPanel.addByY(actualCloseDateFiled);

	return editPanel;

    }

    protected JPanel createFinancePanel() throws ApplicationException {

	currencyLabel = new JLabel(getString("panel.label-currency.text"));
	currencyRateLabel = new JLabel(getString("panel.label-currency-rate.text"));
	currencyAmountLabel = new JLabel(getString("panel.label-currency-amount.text"));
	discountPercentLabel = new JLabel(getString("panel.label-discount-percent.text"));
	discountAmountLabel = new JLabel(getString("panel.label-discount-amount.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));
	taxPercentLabel = new JLabel(getString("panel.label-tax-percent.text"));
	taxAmountLabel = new JLabel(getString("panel.label-tax-amount.text"));
	amountWithTaxLabel = new JLabel(getString("panel.label-amount-with-tax.text"));

	currencyComboEdit = new XComboEdit();
	currencyComboEdit.setColumns(20);
	currencyRateField = new XNumberField(20);
	currencyAmountField = new XNumberField(20);
	discountPercentField = new XNumberField(20);
	discountAmountField = new XNumberField(20);
	amountField = new XNumberField(20);
	taxPercentField = new XTaxComboBox();
	taxAmountField = new XNumberField(20);
	amountWithTaxField = new XNumberField(20);

	currencyComboEdit.initListFormAction(this, CurrencyList.class);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	// COLUMN 0
	editPanel.add(currencyLabel);

	// COLUMN 1
	gbc.gridx = 2;
	gbc.gridy = 0;
	editPanel.add(currencyRateLabel);
	editPanel.addByY(currencyAmountLabel);

	// COLUMN 0
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(currencyComboEdit);

	// COLUMN 1
	gbc.gridx = 3;
	gbc.gridy = 0;
	editPanel.add(currencyRateField);
	editPanel.addByY(currencyAmountField);

	editPanel.addSeparator(4);

	// COLUMN 0
	gbc.gridx = 0;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(discountPercentLabel);
	int y = gbc.gridy;

	// COLUMN 1
	gbc.gridx = 2;
	gbc.gridy = y;
	editPanel.add(discountAmountLabel);
	editPanel.addByY(amountLabel);

	// COLUMN 0
	gbc.gridx = 1;
	gbc.gridy = y;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(discountPercentField);

	// COLUMN 1
	gbc.gridx = 3;
	gbc.gridy = y;
	editPanel.add(discountAmountField);
	editPanel.addByY(amountField);

	editPanel.addSeparator(4);

	// COLUMN 0
	gbc.gridx = 0;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(taxPercentLabel);
	y = gbc.gridy;

	// COLUMN 1
	gbc.gridx = 2;
	gbc.gridy = y;
	editPanel.add(taxAmountLabel);
	editPanel.addByY(amountWithTaxLabel);

	// COLUMN 0
	gbc.gridx = 1;
	gbc.gridy = y;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(taxPercentField);

	// COLUMN 1
	gbc.gridx = 3;
	gbc.gridy = y;
	editPanel.add(taxAmountField);
	editPanel.addByY(amountWithTaxField);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Project getProject() {
	return (Project) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getProject().getName());
	codeField.setText(getProject().getProjectNo());
	nameField.setText(getProject().getName());
	contractField.setText(getProject().getContractDocumentNo());
	startDateField.setDate(getProject().getStartDate());
	closeDateField.setDate(getProject().getEndDate());
	actualCloseDateFiled.setDate(getProject().getActualEndDate());
	propabilityField.setValue(getProject().getPropability());
	partnerComboEdit.setValue(getProject().getPartner());
	projectStateComboEdit.setValue(getProject().getProjectStatus());
	projectTypeComboEdit.setValue(getProject().getProjectType());
	responsibleComboEdit.setValue(getProject().getResponsible());
	currencyComboEdit.setValue(getProject().getCurrency());
	currencyRateField.setValue(getProject().getCurrencyRate());
	currencyAmountField.setValue(getProject().getCurrencyAmount());
	discountPercentField.setValue(getProject().getDiscountPercent());
	discountAmountField.setValue(getProject().getDiscountAmount());
	amountField.setValue(getProject().getAmount());

	//taxPercentField.setValue(getProject().getTaxPercent());
	taxPercentField.setTaxId(getProject().getTaxId());

	taxAmountField.setValue(getProject().getTaxAmount());
	amountWithTaxField.setValue(getProject().getAmountWithTax());
	noteField.setText(getProject().getDescription());
    }

    protected void populateData() throws ApplicationException {
	getProject().setProjectNo(codeField.getText());
	getProject().setName(nameField.getText());
	if (getProject().getContractDocument() != null) {
	    getProject().getContractDocument().setDocumentNo(contractField.getText());
	}
	

	getProject().setStartDate(startDateField.getDate());
	getProject().setEndDate(closeDateField.getDate());
	getProject().setActualEndDate(actualCloseDateFiled.getDate());
	getProject().setPropability(propabilityField.doubleValue());

	getProject().setPartner((PartnerHeader) partnerComboEdit.getValue());
	getProject().setProjectStatus((ProjectStatus) projectStateComboEdit.getValue());
	getProject().setProjectType((ProjectType) projectTypeComboEdit.getValue());
	getProject().setResponsible((ContactHeader) responsibleComboEdit.getValue());
	getProject().setCurrency((Currency) currencyComboEdit.getValue());
	getProject().setCurrencyRate(currencyRateField.doubleValue());
	getProject().setCurrencyAmount(currencyAmountField.doubleValue());
	getProject().setDiscountPercent(discountPercentField.doubleValue());
	getProject().setDiscountAmount(discountAmountField.doubleValue());
	getProject().setAmount(amountField.doubleValue());

	//getProject().setTaxPercent(taxPercentField.floatValue());
	getProject().setTaxId(taxPercentField.getTaxId());

	getProject().setTaxAmount(taxAmountField.doubleValue());
	getProject().setAmountWithTax(amountWithTaxField.doubleValue());

	getProject().setDescription(noteField.getText());

    }

    protected void initData() throws ApplicationException {
	super.initData();
	getProject().setCurrency(ProjectEnvironment.getCurrency());
	getProject().setCurrencyRate(DEFAULT_CURRENCY_RATE);
	getProject().setCurrencyRateDate(EnterpriseEnvironment.getDate());

	getProject().setStartDate(EnterpriseEnvironment.getDate());
	getProject().setEndDate(EnterpriseEnvironment.getDate());

	getProject().setPartner(ProjectEnvironment.getPartner());
	getProject().setProjectType(ProjectEnvironment.getProjectType());
	getProject().setProjectStage(ProjectEnvironment.getProjectStage());
	getProject().setProjectStatus(ProjectEnvironment.getProjectStatus());
	//getProject().setResponsible(ProjectEnvironment.getResponsible());

    }

    private static final int DEFAULT_CURRENCY_RATE = 1;

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getProject().getName(), nameLabel.getText());
	validateRequiredField(buf, getProject().getStartDate(), startDateLabel.getText());
	validateRequiredField(buf, getProject().getEndDate(), closeDateLabel.getText());
	validateRequiredField(buf, getProject().getProjectType(), projectTypeLabel.getText());
	validateRequiredField(buf, getProject().getResponsible(), responsibleLabel.getText());
	validateRequiredField(buf, getProject().getProjectStatus(), projectStateLabel.getText());
	checkError(buf);
    }

}
