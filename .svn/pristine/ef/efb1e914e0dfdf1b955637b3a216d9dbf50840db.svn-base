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


import java.awt.GridBagConstraints;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentEdit;
import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeCategory;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeRank;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeReception;
import org.plazmaforge.bsolution.employee.common.services.EmployeeCategoryService;
import org.plazmaforge.bsolution.employee.common.services.EmployeeRankService;
import org.plazmaforge.bsolution.employee.common.services.EmployeeReceptionService;
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
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.ServiceNotFoundException;


/**
 * @author Oleh Hapon
 * Date: 15.10.2004
 * Time: 8:57:18
 * $Id: EmployeeReceptionEdit.java,v 1.4 2010/12/05 07:56:45 ohapon Exp $
 */

public class EmployeeReceptionEdit extends AbstractDocumentEdit {

    private JLabel personLabel;
    private JLabel codeLabel;
    private JLabel dateLabel;
    private JLabel employeeCodeLabel;
    private JLabel departmentLabel;
    private JLabel receptionDateLabel;
    private JLabel employeeCategoryLabel;
    private JLabel employeeRankLabel;
    private JLabel payrollFormLabel;
    private JLabel salaryLabel;
    private JLabel tariffLabel;
    private JLabel premiumPercentLabel;
    private JLabel sickPercentLabel;


    private XComboEdit personComboEdit;
    private XTextField codeField;
    private XDateField dateField;
    private XTextField employeeCodeField;
    private XComboEdit departmentComboEdit;
    private XDateField receptionDateField;
    private XComboBox employeeCategoryComboBox;
    private XComboBox employeeRankComboBox;
    private XComboBox payrollFormComboBox;

    private XNumberField salaryField;
    private XNumberField tariffField;
    private XNumberField premiumPercentField;
    private XNumberField sickPercentField;

    public EmployeeReceptionEdit() throws ApplicationException {
        super(GUIEmployeeEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(EmployeeReception.class);
        this.setEntityServiceClass(EmployeeReceptionService.class);
        this.setEntityCode(EmployeeReception.CLASS_ID);		
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        JTabbedPane tp = new JTabbedPane();
        tp.addTab(getString("panel.title.common.text"), createCommonPanel());
        tp.addTab(getString("panel.title.account.text"), createAccountPanel());
        add(tp);
    }

    private JPanel createCommonPanel() throws ApplicationException {

        codeLabel = new JLabel(getString("panel.label-code.text"));
        dateLabel = new JLabel(getString("panel.label-date.text"));
        personLabel = new JLabel(getString("panel.label-person.text"));
        employeeCodeLabel = new JLabel(getString("panel.label-employee-code.text"));
        departmentLabel = new JLabel(getString("panel.label-department.text"));
        receptionDateLabel = new JLabel(getString("panel.label-reception-date.text"));

        codeField = new XTextField(10);
        codeField.setMaxChar(10);
        dateField = new XDateField();
        personComboEdit = new XComboEdit();
        personComboEdit.setColumns(30);
        employeeCodeField = new XTextField(10);
        employeeCodeField.setMaxChar(10);
        departmentComboEdit = new XComboEdit(true);
        departmentComboEdit.setColumns(30);
        receptionDateField = new XDateField();

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(codeLabel);
        editPanel.addByY(dateLabel);
        editPanel.addByY(personLabel);
        editPanel.addByY(employeeCodeLabel);
        editPanel.addByY(departmentLabel);
        editPanel.addByY(receptionDateLabel);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.addByX(codeField);
        editPanel.addByY(dateField);
        gbc.gridwidth = 2;
        editPanel.addByY(personComboEdit);
        gbc.gridwidth = 1;
        editPanel.addByY(employeeCodeField);
        gbc.gridwidth = 2;
        editPanel.addByY(departmentComboEdit);
        gbc.gridwidth = 1;
        editPanel.addByY(receptionDateField);

        personComboEdit.initListFormAction(this, PersonList.class, "fullName");
        departmentComboEdit.initListFormAction(this, DepartmentList.class);

        return editPanel;
    }

    private JPanel createAccountPanel() throws ApplicationException {

        employeeCategoryLabel = new JLabel(getString("panel.label-employee-category.text"));
        employeeRankLabel = new JLabel(getString("panel.label-employee-rank.text"));
        payrollFormLabel = new JLabel(getString("panel.label-payroll-form.text"));
        salaryLabel = new JLabel(getString("panel.label-salary.text"));
        tariffLabel = new JLabel(getString("panel.label-tariff.text"));
        premiumPercentLabel = new JLabel(getString("panel.label-premium-percent.text"));
        sickPercentLabel = new JLabel(getString("panel.label-sick-percent.text"));

        employeeCategoryComboBox = new XComboBox(getEmployeeCategoryService().findAll());
        employeeRankComboBox = new XComboBox(getEmployeeRankService().findAll());
        payrollFormComboBox = new XComboBox(getPayrollTypeService().findAll());
        salaryField = new XNumberField();
        tariffField = new XNumberField();
        premiumPercentField = new XNumberField();
        sickPercentField = new XNumberField();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();
        
		gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        editPanel.add(employeeCategoryLabel);
        editPanel.addByY(employeeRankLabel);
        editPanel.addByY(payrollFormLabel);
        editPanel.addByY(salaryLabel);
        editPanel.addByY(tariffLabel);
        editPanel.addByY(premiumPercentLabel);
        editPanel.addByY(sickPercentLabel);

        gbc.weightx = 0;
        gbc.gridy = 0;
        editPanel.addByX(employeeCategoryComboBox);
        editPanel.addByY(employeeRankComboBox);
        editPanel.addByY(payrollFormComboBox);
        editPanel.addByY(salaryField);
        editPanel.addByY(tariffField);
        editPanel.addByY(premiumPercentField);
        editPanel.addByY(sickPercentField);

        return editPanel;
    }

    private EmployeeReception getEmployeeReception() {
        return (EmployeeReception) this.getEntity();
    }

    protected void initData() throws ApplicationException {
        super.initData();
        getEmployeeReception().setReceptionDate(new Date());
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getEmployeeReception().getPersonName());
        personComboEdit.setValue(getEmployeeReception().getPerson());
        codeField.setText(getEmployeeReception().getDocumentNo());
        dateField.setDate(getEmployeeReception().getDocumentDate());
        employeeCodeField.setText(getEmployeeReception().getEmployeeCode());
        departmentComboEdit.setValue(getEmployeeReception().getDepartment());
        receptionDateField.setDate(getEmployeeReception().getReceptionDate());
        employeeCategoryComboBox.setValue(getEmployeeReception().getEmployeeCategory());
        employeeRankComboBox.setValue(getEmployeeReception().getEmployeeRank());
        payrollFormComboBox.setValue(getEmployeeReception().getPayrollForm());
        salaryField.setValue(getEmployeeReception().getSalary());
        tariffField.setValue(getEmployeeReception().getTariff());
        premiumPercentField.setValue(getEmployeeReception().getPremiumPercent());
        sickPercentField.setValue(getEmployeeReception().getSickPercent());
    }


    protected void populateData() throws ApplicationException {
        getEmployeeReception().setPerson((PersonHeader) personComboEdit.getValue());
        getEmployeeReception().setDocumentNo(codeField.getText());
        getEmployeeReception().setDocumentDate(dateField.getDate());
        getEmployeeReception().setEmployeeCode(employeeCodeField.getText());
        getEmployeeReception().setDepartment((Department) departmentComboEdit.getValue());

        getEmployeeReception().setReceptionDate(receptionDateField.getDate());
        
        getEmployeeReception().setEmployeeCategory((EmployeeCategory) employeeCategoryComboBox.getValue());
        getEmployeeReception().setEmployeeRank((EmployeeRank) employeeRankComboBox.getValue());
        getEmployeeReception().setPayrollForm((PayrollForm) payrollFormComboBox.getValue());
        
        getEmployeeReception().setSalary(salaryField.getValue());
        getEmployeeReception().setTariff(tariffField.getValue());
        getEmployeeReception().setPremiumPercent(premiumPercentField.floatValue());
        getEmployeeReception().setSickPercent(sickPercentField.floatValue());
    }

    private PayrollFormService getPayrollTypeService() {
        return (PayrollFormService) getSERVICE(PayrollFormService.class);
    }

    private EmployeeCategoryService getEmployeeCategoryService()  {
        return (EmployeeCategoryService) getSERVICE(EmployeeCategoryService.class);
    }

    private EmployeeRankService getEmployeeRankService()  {
        return (EmployeeRankService) getSERVICE(EmployeeRankService.class);
    }

	
    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployeeReception().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getEmployeeReception().getPerson(), personLabel.getText());
	checkError(buf);
    }
	
}
