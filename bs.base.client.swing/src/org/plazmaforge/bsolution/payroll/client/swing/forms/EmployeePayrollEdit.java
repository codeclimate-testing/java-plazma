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

import org.plazmaforge.bsolution.employee.client.swing.forms.AbstractEmployableEdit;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeePayroll;
import org.plazmaforge.bsolution.payroll.common.beans.Payroll;
import org.plazmaforge.bsolution.payroll.common.services.EmployeePayrollService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.NumberUtils;

/**
 * @author Oleh Hapon
 * Date: 30.10.2004
 * Time: 11:52:42
 * $Id: EmployeePayrollEdit.java,v 1.5 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeePayrollEdit extends AbstractEmployableEdit {

    private JLabel employeeNameLabel;

    private JLabel payrollLabel;

    private JLabel dayLabel;

    private JLabel hourLabel;

    private JLabel amountLabel;

    private XTextField employeeNameField;

    private XComboEdit payrollComboEdit;

    private XNumberField dayField;

    private XNumberField hourField;

    private XNumberField amountField;

    public EmployeePayrollEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeePayroll.class);
	this.setEntityServiceClass(EmployeePayrollService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	employeeNameLabel = new JLabel(getString("panel.label-employee-name.text"));
	payrollLabel = new JLabel(getString("panel.label-payroll-name.text"));
	dayLabel = new JLabel(getString("panel.label-day.text"));
	hourLabel = new JLabel(getString("panel.label-hour.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));

	employeeNameField = new XTextField(30);
	employeeNameField.setEditable(false);
	employeeNameField.setFocusable(false);
	payrollComboEdit = new XComboEdit();
	payrollComboEdit.setColumns(30);
	dayField = new XNumberField(20);
	dayField.setInteger(true);
	hourField = new XNumberField(20);
	amountField = new XNumberField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(employeeNameLabel);
	editPanel.addByY(payrollLabel);
	editPanel.addByY(dayLabel);
	editPanel.addByY(hourLabel);
	editPanel.addByY(amountLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.addByX(employeeNameField);
	editPanel.addByY(payrollComboEdit);
	gbc.gridwidth = 1;
	gbc.fill = GridBagConstraints.NONE;
	editPanel.addByY(dayField);
	editPanel.addByY(hourField);
	editPanel.addByY(amountField);

	payrollComboEdit.initListFormAction(this, PayrollList.class);
	add(editPanel);
    }

    private EmployeePayroll getEmployeePayroll() {
	return (EmployeePayroll) this.getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getEmployeePayroll().setOrganizationId(this.getOrganizationId());
	getEmployeePayroll().setPeriodId(this.getPeriodId());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getEmployeePayroll().getEmployeeName());
	employeeNameField.setText(getEmployeePayroll().getEmployeeName());
	payrollComboEdit.setValue(getEmployeePayroll().getPayroll());
	dayField.setValue(getEmployeePayroll().getPayrollDay());
	hourField.setValue(getEmployeePayroll().getPayrollHour());
	amountField.setValue(getEmployeePayroll().getAmount());
    }

    protected void populateData() throws ApplicationException {
	getEmployeePayroll().setPayroll((Payroll) payrollComboEdit.getValue());
	getEmployeePayroll().setPayrollDay(dayField.intValue());
	getEmployeePayroll().setPayrollHour(NumberUtils.roundTime(hourField.floatValue()));
	getEmployeePayroll().setAmount(amountField.intValue());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployeePayroll().getPayroll(), payrollLabel.getText());
	checkError(buf);
    }

}
