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
package org.plazmaforge.bsolution.payroll.client.swing.forms;



import java.awt.*;
import javax.swing.*;

import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.Payroll;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollAlgoritmType;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollGroup;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollMode;
import org.plazmaforge.bsolution.payroll.common.beans.PayrollType;
import org.plazmaforge.bsolution.payroll.common.services.PayrollAlgoritmTypeService;
import org.plazmaforge.bsolution.payroll.common.services.PayrollGroupService;
import org.plazmaforge.bsolution.payroll.common.services.PayrollModeService;
import org.plazmaforge.bsolution.payroll.common.services.PayrollService;
import org.plazmaforge.bsolution.payroll.common.services.PayrollTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * @author Oleh Hapon
 * Date: 27.10.2004
 * Time: 9:39:45
 * $Id: PayrollEdit.java,v 1.4 2010/12/05 07:56:47 ohapon Exp $
 */
public class PayrollEdit extends EXTEditForm {

    private JLabel codeLabel;
    private JLabel nameLabel;
    private JLabel payrollTypeLabel;
    private JLabel payrollAlgoritmTypeLabel;
    private JLabel payrollAlgoritmLabel;
    private JLabel payrollGroupLabel;
    private JLabel priorityLabel;
    private JLabel percentLabel;
    private JLabel payrollModeLabel;

    private XTextField codeField;
    private XTextField nameField;
    
    private XComboBox payrollTypeComboBox;
    private XComboBox payrollAlgoritmTypeComboBox;
    private XComboBox payrollAlgoritmComboBox;
    private XComboBox payrollGroupComboBox;
    
    private XNumberField priorityField;
    private XNumberField percentField;
    private XComboBox payrollModeComboBox;

    private JCheckBox timeCheckBox;
    private JCheckBox pensionCheckBox;
    private JCheckBox taxCheckBox;
    private JCheckBox leaveCheckBox;
    private JCheckBox sickCheckBox;
    private JCheckBox fundSalaryCheckBox;
    private JCheckBox fundHelpCheckBox;
    private JCheckBox fundInsuranceCheckBox;
    private JCheckBox fundWorkCheckBox;
    private JCheckBox salary13CheckBox;
    private JCheckBox salary12CheckBox;
    private JCheckBox addPayCheckBox;

    public PayrollEdit() throws ApplicationException {
        super(GUIPayrollEnvironment.getResources());
		initialize();
    }

    private void initialize() {
        this.setEntityClass(Payroll.class);
        this.setEntityServiceClass(PayrollService.class);
    }
	
    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        JTabbedPane tp = new JTabbedPane();
        tp.addTab(getString("panel.title.common.text"), createCommonPanel());
        tp.addTab(getString("panel.title.acumulate.text"), createAcumulatePanel());
        add(tp);
    }

    private JPanel createCommonPanel() throws ApplicationException {

        codeLabel = new JLabel(getString("panel.label-code.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));
        payrollTypeLabel = new JLabel(getString("panel.label-payroll-type.text"));
        payrollAlgoritmTypeLabel = new JLabel(getString("panel.label-payroll-algoritm-type.text"));
        payrollAlgoritmLabel = new JLabel(getString("panel.label-payroll-algoritm.text"));
        payrollGroupLabel = new JLabel(getString("panel.label-payroll-group.text"));
        priorityLabel = new JLabel(getString("panel.label-priority.text"));
        percentLabel = new JLabel(getString("panel.label-percent.text"));
        payrollModeLabel = new JLabel(getString("panel.label-payroll-mode.text"));
        codeField = new XTextField(10);
        codeField.setMaxChar(10);

        nameField = new XTextField(40);
        nameField.setMaxChar(60);
        payrollTypeComboBox = new XComboBox(getPayrollTypeService().findAll());
        payrollAlgoritmTypeComboBox = new XComboBox(getPayrollAlgoritmTypeService().findAll());
        //payrollAlgoritmComboBox = new XComboBox(getPayrollAlgoritmBIZ().findAll());
        payrollAlgoritmComboBox = new XComboBox();
        payrollGroupComboBox = new XComboBox(getPayrollGroupService().findAll());
        priorityField = new XNumberField();
        priorityField.setInteger(true);
        percentField = new XNumberField();
        payrollModeComboBox = new XComboBox(getPayrollModeService().findAll());

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(codeLabel);
        editPanel.addByY(nameLabel);
        editPanel.addByY(payrollTypeLabel);
        editPanel.addByY(payrollAlgoritmTypeLabel);
        editPanel.addByY(payrollAlgoritmLabel);
        editPanel.addByY(payrollGroupLabel);
        editPanel.addByY(priorityLabel);
        editPanel.addByY(percentLabel);
        editPanel.addByY(payrollModeLabel);

        gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.addByX(codeField);
        gbc.gridwidth = 2;
        editPanel.addByY(nameField);
        gbc.gridwidth = 1;
        editPanel.addByY(payrollTypeComboBox);
        editPanel.addByY(payrollAlgoritmTypeComboBox);
        editPanel.addByY(payrollAlgoritmComboBox);
        editPanel.addByY(payrollGroupComboBox);
        editPanel.addByY(priorityField);
        editPanel.addByY(percentField);
        editPanel.addByY(payrollModeComboBox);

        return editPanel;

    }

    private JPanel createAcumulatePanel() {

        timeCheckBox = new JCheckBox(getString("panel.label-time.text"));
        pensionCheckBox = new JCheckBox(getString("panel.label-pension.text"));
        taxCheckBox = new JCheckBox(getString("panel.label-tax.text"));
        leaveCheckBox = new JCheckBox(getString("panel.label-leave.text"));
        sickCheckBox = new JCheckBox(getString("panel.label-sick.text"));
        fundSalaryCheckBox = new JCheckBox(getString("panel.label-fund-salary.text"));
        fundHelpCheckBox = new JCheckBox(getString("panel.label-fund-help.text"));
        fundInsuranceCheckBox = new JCheckBox(getString("panel.label-fund-insurance.text"));
        fundWorkCheckBox = new JCheckBox(getString("panel.label-fund-work.text"));
        salary13CheckBox = new JCheckBox(getString("panel.label-salary13.text"));
        salary12CheckBox = new JCheckBox(getString("panel.label-salary12.text"));
        addPayCheckBox = new JCheckBox(getString("panel.label-add-pay.text"));

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(timeCheckBox);
        editPanel.addByY(pensionCheckBox);
        editPanel.addByY(taxCheckBox);
        editPanel.addByY(leaveCheckBox);
        editPanel.addByY(sickCheckBox);
        editPanel.addByY(fundSalaryCheckBox);
		gbc.gridx = 1;
		gbc.gridy = 0;
        editPanel.add(fundHelpCheckBox);
        editPanel.addByY(fundInsuranceCheckBox);
        editPanel.addByY(fundWorkCheckBox);
        editPanel.addByY(salary13CheckBox);
        editPanel.addByY(salary12CheckBox);
        editPanel.addByY(addPayCheckBox);

        return editPanel;

    }

    private Payroll getPayroll() {
        return (Payroll) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getPayroll().getName());
        codeField.setText(getPayroll().getCode());
        nameField.setText(getPayroll().getName());
        payrollTypeComboBox.setValue(getPayroll().getPayrollType());
        payrollAlgoritmTypeComboBox.setValue(getPayroll().getPayrollAlgoritmType());
        //payrollAlgoritmComboBox.setValue(details.getPayrollAlgoritm());
        payrollGroupComboBox.setValue(getPayroll().getPayrollGroup());
        priorityField.setValue(getPayroll().getPriority());
        percentField.setValue(getPayroll().getPayrollPercent());
        payrollModeComboBox.setValue(getPayroll().getPayrollMode());

        timeCheckBox.setSelected(getPayroll().isTime());
        pensionCheckBox.setSelected(getPayroll().isPension());
        taxCheckBox.setSelected(getPayroll().isTax());
        leaveCheckBox.setSelected(getPayroll().isVacation());
        sickCheckBox.setSelected(getPayroll().isSick());
        fundSalaryCheckBox.setSelected(getPayroll().isFundSalary());
        fundHelpCheckBox.setSelected(getPayroll().isFundHelp());
        fundInsuranceCheckBox.setSelected(getPayroll().isFundInsurance());
        fundWorkCheckBox.setSelected(getPayroll().isFundWork());
        salary13CheckBox.setSelected(getPayroll().isSalary13());
        salary12CheckBox.setSelected(getPayroll().isSalary12());
        addPayCheckBox.setSelected(getPayroll().isAddPay());
    }

    protected void populateData() throws ApplicationException {
        getPayroll().setCode(codeField.getText());
        getPayroll().setName(nameField.getText());
        getPayroll().setPayrollType((PayrollType) payrollTypeComboBox.getValue());
        getPayroll().setPayrollAlgoritmType((PayrollAlgoritmType) payrollAlgoritmTypeComboBox.getValue());
        //getDetails().setPayrollAlgoritm(payrollAlgoritmComboBox.getValue());
        getPayroll().setPayrollGroup((PayrollGroup) payrollGroupComboBox.getValue());
        getPayroll().setPriority(priorityField.intValue());
        getPayroll().setPayrollPercent(percentField.floatValue());
        getPayroll().setPayrollMode((PayrollMode) payrollModeComboBox.getValue());

        getPayroll().setTime(timeCheckBox.isSelected());
        getPayroll().setPension(pensionCheckBox.isSelected());
        getPayroll().setTax(taxCheckBox.isSelected());
        getPayroll().setVacation(leaveCheckBox.isSelected());
        getPayroll().setSick(sickCheckBox.isSelected());
        getPayroll().setFundSalary(fundSalaryCheckBox.isSelected());
        getPayroll().setFundHelp(fundHelpCheckBox.isSelected());
        getPayroll().setFundInsurance(fundInsuranceCheckBox.isSelected());
        getPayroll().setFundWork(fundWorkCheckBox.isSelected());
        getPayroll().setSalary13(salary13CheckBox.isSelected());
        getPayroll().setSalary12(salary12CheckBox.isSelected());
        getPayroll().setAddPay(addPayCheckBox.isSelected());
    }

    private PayrollTypeService getPayrollTypeService() {
        return (PayrollTypeService) getSERVICE(PayrollTypeService.class);
    }

    private PayrollAlgoritmTypeService getPayrollAlgoritmTypeService() {
        return (PayrollAlgoritmTypeService) getSERVICE(PayrollAlgoritmTypeService.class);
    }
    private PayrollGroupService getPayrollGroupService() {
        return (PayrollGroupService) getSERVICE(PayrollGroupService.class);
    }

    private PayrollModeService getPayrollModeService() {
        return (PayrollModeService) getSERVICE(PayrollModeService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getPayroll().getName(), nameLabel.getText());
	validateRequiredField(buf, getPayroll().getPayrollType(), payrollTypeLabel.getText());
	validateRequiredField(buf, getPayroll().getPayrollAlgoritmType(), payrollAlgoritmTypeLabel.getText());
	validateRequiredField(buf, getPayroll().getPayrollMode(), payrollModeLabel.getText());
	checkError(buf);
    }


}
