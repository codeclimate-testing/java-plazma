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
package org.plazmaforge.bsolution.employee.client.swing.forms;

import javax.swing.*;


import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.contact.client.swing.forms.AbstractContactableEdit;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeCategory;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeRank;
import org.plazmaforge.bsolution.employee.common.beans.JobPosition;
import org.plazmaforge.bsolution.employee.common.services.EmployeeCategoryService;
import org.plazmaforge.bsolution.employee.common.services.EmployeeRankService;
import org.plazmaforge.bsolution.employee.common.services.EmployeeService;
import org.plazmaforge.bsolution.organization.OrganizationEnvironment;
import org.plazmaforge.bsolution.organization.client.swing.forms.DepartmentList;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollForm;
import org.plazmaforge.bsolution.payroll.common.services.PayrollFormService;
import org.plazmaforge.bsolution.personality.client.swing.forms.PersonList;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon Date: 08.03.2004 Time: 12:12:18 $Id: EmployeeEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class EmployeeEdit extends AbstractContactableEdit {

    private JLabel personLabel;

    private JLabel codeLabel;

    private JLabel departmentLabel;

    private JLabel positionLabel;

    private JLabel employeeCategoryLabel;

    private JLabel startDateLabel;

    private JLabel endDateLabel;

    private JLabel taxLabel;

    private JLabel payrollFormLabel;

    private JLabel employeeRankLabel;

    private JLabel salaryLabel;

    private JLabel tariffLabel;

    private JLabel advanceLabel;

    private JLabel premiumPercentLabel;

    private JLabel sickPercentLabel;

    private JLabel stockLabel;

    private JLabel employeeAccountLabel;

    private JLabel totalSeniorityLabel;

    private JLabel totalSeniorityYearLabel;

    private JLabel totalSeniorityMonthLabel;

    private JLabel totalSeniorityDayLabel;

    private JLabel unbrokenSeniorityLabel;

    private JLabel unbrokenSeniorityYearLabel;

    private JLabel unbrokenSeniorityMonthLabel;

    private JLabel unbrokenSeniorityDayLabel;

    private XComboEdit personComboEdit;

    private XTextField codeField;

    private XComboEdit departmentComboEdit;

    private XComboEdit positionComboEdit;

    private XComboBox employeeCategoryComboBox;

    private XDateField startDateField;

    private XDateField endDateField;

    private JCheckBox taxField;

    private XComboBox payrollFormComboBox;

    private XComboBox employeeRankComboBox;

    private XNumberField salaryField;

    private XNumberField tariffField;

    private XNumberField advanceField;

    private XNumberField premiumPercentField;

    private XNumberField sickPercentField;

    private XNumberField stockField;

    private XTextField employeeAccountField;

    private XNumberField totalSeniorityYearField;

    private XNumberField totalSeniorityMonthField;

    private XNumberField totalSeniorityDayField;

    private XNumberField unbrokenSeniorityYearField;

    private XNumberField unbrokenSeniorityMonthField;

    private XNumberField unbrokenSeniorityDayField;

    private XTextEdit noteField;

    public EmployeeEdit() throws ApplicationException {
	super(GUIEmployeeEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Employee.class);
	this.setEntityServiceClass(EmployeeService.class);
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
	tp.addTab(getString("panel.title.account.text"), createAccountPanel());
	tp.addTab(getString("panel.title.additional.text"), createAdditionalPanel());
	tp.addTab(getString("panel.title.seniority.text"), createSeniorityPanel());
	tp.addTab(getString("panel.title.note.text"), createNotePanel());
	return tp;
    }

    private JPanel createCommonPanel() throws ApplicationException {

	personLabel = new JLabel(getString("panel.label-person.text"));
	codeLabel = new JLabel(getString("panel.label-code.text"));
	departmentLabel = new JLabel(getString("panel.label-department.text"));
	positionLabel = new JLabel(getString("panel.label-position.text"));
	employeeCategoryLabel = new JLabel(getString("panel.label-employee-category.text"));
	startDateLabel = new JLabel(getString("panel.label-start-date.text"));
	endDateLabel = new JLabel(getString("panel.label-end-date.text"));
	taxLabel = new JLabel(getString("panel.label-tax.text"));

	personComboEdit = new XComboEdit();
	personComboEdit.setColumns(30);
	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	departmentComboEdit = new XComboEdit(true);
	positionComboEdit = new XComboEdit(true);
	employeeCategoryComboBox = new XComboBox(getEmployeeCategoryService().findAll());
	startDateField = new XDateField();
	endDateField = new XDateField();
	taxField = new JCheckBox();

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(personLabel);
	editPanel.addByY(codeLabel);
	editPanel.addByY(departmentLabel);
	editPanel.addByY(positionLabel);
	editPanel.addByY(employeeCategoryLabel);
	editPanel.addByY(startDateLabel);
	editPanel.addByY(endDateLabel);
	editPanel.addByY(taxLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(personComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(departmentComboEdit);
	editPanel.addByY(positionComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(employeeCategoryComboBox);
	editPanel.addByY(startDateField);
	editPanel.addByY(endDateField);
	editPanel.addByY(taxField);

	personComboEdit.initListFormAction(this, PersonList.class, "fullName");
	departmentComboEdit.initListFormAction(this, DepartmentList.class);
	positionComboEdit.initListFormAction(this, PositionList.class);

	return editPanel;

    }

    private JPanel createAccountPanel() throws ApplicationException {

	payrollFormLabel = new JLabel(getString("panel.label-payroll-form.text"));
	employeeRankLabel = new JLabel(	getString("panel.label-employee-rank.text"));
	salaryLabel = new JLabel(getString("panel.label-salary.text"));
	tariffLabel = new JLabel(getString("panel.label-tariff.text"));
	advanceLabel = new JLabel(getString("panel.label-advance.text"));
	premiumPercentLabel = new JLabel(getString("panel.label-premium-percent.text"));
	sickPercentLabel = new JLabel(getString("panel.label-sick-percent.text"));

	payrollFormComboBox = new XComboBox(getPayrollTypeService().findAll());
	employeeRankComboBox = new XComboBox(getEmployeeRankService().findAll());
	salaryField = new XNumberField(20);
	tariffField = new XNumberField(20);
	advanceField = new XNumberField(20);
	premiumPercentField = new XNumberField(20);
	sickPercentField = new XNumberField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(payrollFormLabel);
	editPanel.addByY(employeeRankLabel);
	editPanel.addByY(salaryLabel);
	editPanel.addByY(tariffLabel);
	editPanel.addByY(advanceLabel);
	editPanel.addByY(premiumPercentLabel);
	editPanel.addByY(sickPercentLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(payrollFormComboBox);
	editPanel.addByY(employeeRankComboBox);
	// gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(salaryField);
	editPanel.addByY(tariffField);
	editPanel.addByY(advanceField);
	editPanel.addByY(premiumPercentField);
	editPanel.addByY(sickPercentField);

	return editPanel;

    }

    private JPanel createAdditionalPanel() throws ApplicationException {

	stockLabel = new JLabel(getString("panel.label-stock.text"));
	employeeAccountLabel = new JLabel(getString("panel.label-employee-account.text"));

	stockField = new XNumberField(20);
	stockField.setInteger(true);
	employeeAccountField = new XTextField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(stockLabel);
	editPanel.addByY(employeeAccountLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(stockField);
	editPanel.addByY(employeeAccountField);

	return editPanel;
    }

    private JPanel createSeniorityPanel() throws ApplicationException {

	totalSeniorityLabel = new JLabel(getString("panel.label-total-seniority.text"));
	totalSeniorityYearLabel = new JLabel(getString("panel.label-seniority-year.text"));
	totalSeniorityMonthLabel = new JLabel(getString("panel.label-seniority-month.text"));
	totalSeniorityDayLabel = new JLabel(getString("panel.label-seniority-day.text"));
	unbrokenSeniorityLabel = new JLabel(getString("panel.label-unbroken-seniority.text"));
	unbrokenSeniorityYearLabel = new JLabel(getString("panel.label-seniority-year.text"));
	unbrokenSeniorityMonthLabel = new JLabel(getString("panel.label-seniority-month.text"));
	unbrokenSeniorityDayLabel = new JLabel(getString("panel.label-seniority-day.text"));

	totalSeniorityYearField = new XNumberField(3);
	totalSeniorityYearField.setInteger(true);
	totalSeniorityMonthField = new XNumberField(3);
	totalSeniorityMonthField.setInteger(true);
	totalSeniorityDayField = new XNumberField(3);
	totalSeniorityDayField.setInteger(true);
	unbrokenSeniorityYearField = new XNumberField(3);
	unbrokenSeniorityYearField.setInteger(true);
	unbrokenSeniorityMonthField = new XNumberField(3);
	unbrokenSeniorityMonthField.setInteger(true);
	unbrokenSeniorityDayField = new XNumberField(3);
	unbrokenSeniorityDayField.setInteger(true);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(totalSeniorityLabel);
	editPanel.addByX(totalSeniorityYearField);
	editPanel.addByX(totalSeniorityYearLabel);
	editPanel.addByX(totalSeniorityMonthField);
	editPanel.addByX(totalSeniorityMonthLabel);
	editPanel.addByX(totalSeniorityDayField);
	editPanel.addByX(totalSeniorityDayLabel);

	gbc.gridx = 0;
	editPanel.addByY(unbrokenSeniorityLabel);
	editPanel.addByX(unbrokenSeniorityYearField);
	editPanel.addByX(unbrokenSeniorityYearLabel);
	editPanel.addByX(unbrokenSeniorityMonthField);
	editPanel.addByX(unbrokenSeniorityMonthLabel);
	editPanel.addByX(unbrokenSeniorityDayField);
	editPanel.addByX(unbrokenSeniorityDayLabel);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private JTabbedPane createItemsTabbedPane() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(130);
	tp.addTab(getString("table-phone.name"), createPhonePanel());
	tp.addTab(getString("table-email.name"), createEmailPanel());
	return tp;
    }

    private Employee getEmployee() {
	return (Employee) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	OrganizationEnvironment.initOrganizable(getEmployee(), SessionEnvironment.getContext());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getEmployee().getFullName());
	// personComboEdit.setKeyValue(getEmployee().getPersonId());
	personComboEdit.setValue(getEmployee().getPerson());
	String name = getEmployee().getFullName();
	personComboEdit.setText(name);

	codeField.setText(getEmployee().getCode());
	departmentComboEdit.setValue(getEmployee().getDepartment());
	positionComboEdit.setValue(getEmployee().getPosition());
	positionComboEdit.setText(getEmployee().getPositionName());
	employeeCategoryComboBox.setValue(getEmployee().getEmployeeCategory());
	startDateField.setDate(getEmployee().getStartDate());
	endDateField.setDate(getEmployee().getEndDate());
	taxField.setSelected(getEmployee().isTax());

	// FinanceLedger block
	payrollFormComboBox.setValue(getEmployee().getPayrollForm());
	employeeRankComboBox.setValue(getEmployee().getEmployeeRank());
	salaryField.setValue(getEmployee().getSalary());
	tariffField.setValue(getEmployee().getTariff());
	advanceField.setValue(getEmployee().getAdvance());
	premiumPercentField.setValue(getEmployee().getPremiumPercent());
	sickPercentField.setValue(getEmployee().getSickPercent());

	updatePhoneTable();
	updateEmailTable();

	//
	employeeAccountField.setText(getEmployee().getEmployeeAccount());
	//
	totalSeniorityYearField.setValue(getEmployee().getTotalSeniorityYear());
	totalSeniorityMonthField.setValue(getEmployee()	.getTotalSeniorityMonth());
	totalSeniorityDayField.setValue(getEmployee().getTotalSeniorityDay());
	unbrokenSeniorityYearField.setValue(getEmployee().getUnbrokenSeniorityYear());
	unbrokenSeniorityMonthField.setValue(getEmployee().getUnbrokenSeniorityMonth());
	unbrokenSeniorityDayField.setValue(getEmployee().getUnbrokenSeniorityDay());

	noteField.setText(getEmployee().getNote());

    }

    protected void populateData() throws ApplicationException {
	// getEmployee().getPerson().setId(personComboEdit.getIntValue());
	getEmployee().setPerson((PersonHeader) personComboEdit.getValue());
	getEmployee().setCode(codeField.getText());
	getEmployee().setDepartment((Department) departmentComboEdit.getValue());
	getEmployee().setPosition((JobPosition) positionComboEdit.getValue());
	getEmployee().setEmployeeCategory((EmployeeCategory) employeeCategoryComboBox.getValue());
	getEmployee().setStartDate(startDateField.getDate());
	getEmployee().setEndDate(endDateField.getDate());
	getEmployee().setTax(taxField.isSelected());
	getEmployee().setPayrollForm((PayrollForm) payrollFormComboBox.getValue());
	getEmployee().setEmployeeRank((EmployeeRank) employeeRankComboBox.getValue());
	getEmployee().setSalary(salaryField.getValue());
	getEmployee().setTariff(tariffField.getValue());
	getEmployee().setAdvance(advanceField.getValue());
	getEmployee().setPremiumPercent(premiumPercentField.floatValue());
	getEmployee().setSickPercent(sickPercentField.floatValue());

	//
	getEmployee().setEmployeeAccount(employeeAccountField.getText());
	getEmployee().setTotalSeniorityYear(totalSeniorityYearField.intValue());
	getEmployee().setTotalSeniorityMonth(totalSeniorityMonthField.intValue());
	getEmployee().setTotalSeniorityDay(totalSeniorityDayField.intValue());
	getEmployee().setUnbrokenSeniorityYear(unbrokenSeniorityYearField.intValue());
	getEmployee().setUnbrokenSeniorityMonth(unbrokenSeniorityMonthField.intValue());
	getEmployee().setUnbrokenSeniorityDay(unbrokenSeniorityDayField.intValue());

	getEmployee().setNote(noteField.getText());

    }

    protected ContactableElement getContactableElement() {
	return getEmployee().getContactableElement();
    }

    private EmployeeCategoryService getEmployeeCategoryService() {
	return (EmployeeCategoryService) getSERVICE(EmployeeCategoryService.class);
    }

    private EmployeeRankService getEmployeeRankService() {
	return (EmployeeRankService) getSERVICE(EmployeeRankService.class);
    }

    private PayrollFormService getPayrollTypeService() {
	return (PayrollFormService) getSERVICE(PayrollFormService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployee().getPerson(), personLabel.getText());
	checkError(buf);
    }

}
