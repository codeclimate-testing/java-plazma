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
import org.plazmaforge.bsolution.employee.common.beans.DischargeType;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeDischarge;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.services.DischargeTypeService;
import org.plazmaforge.bsolution.employee.common.services.EmployeeDischargeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 19.10.2004
 * Time: 9:40:48
 * $Id: EmployeeDischargeEdit.java,v 1.4 2010/12/05 07:56:45 ohapon Exp $
 */

public class EmployeeDischargeEdit extends AbstractDocumentEdit {

    private JLabel employeeLabel;
    private JLabel codeLabel;
    private JLabel dateLabel;
    private JLabel dischargeDateLabel;
    private JLabel dischargeTypeLabel;
    private JLabel compensationDayLabel;
    private JLabel outputDayLabel;
    private JLabel pensionAmountLabel;

    private XComboEdit employeeComboEdit;
    private XTextField codeField;
    private XDateField dateField;
    private XDateField dischargeDateField;
    private XComboBox dischargeTypeComboBox;
    private XNumberField compensationDayField;
    private XNumberField outputDayField;
    private XNumberField pensionAmountField;

    public EmployeeDischargeEdit() throws ApplicationException {
        super(GUIEmployeeEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(EmployeeDischarge.class);
        this.setEntityServiceClass(EmployeeDischargeService.class);
        this.setEntityCode(EmployeeDischarge.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        JTabbedPane tp = new JTabbedPane();
        tp.addTab(getString("panel.title.common.text"), createCommonPanel());
        //tp.addTab(getString("panel.title.account.text"), createAccountPanel());
        add(tp);
    }

    private JPanel createCommonPanel() throws ApplicationException {

        codeLabel = new JLabel(getString("panel.label-code.text"));
        dateLabel = new JLabel(getString("panel.label-date.text"));
        employeeLabel = new JLabel(getString("panel.label-employee.text"));
        dischargeDateLabel = new JLabel(getString("panel.label-discharge-date.text"));
        dischargeTypeLabel = new JLabel(getString("panel.label-discharge-type.text"));
        compensationDayLabel = new JLabel(getString("panel.label-compensation-day.text"));
        outputDayLabel = new JLabel(getString("panel.label-output-day.text"));
        pensionAmountLabel = new JLabel(getString("panel.label-pension-amount.text"));

        codeField = new XTextField(10);
        codeField.setMaxChar(10);
        dateField = new XDateField();
        employeeComboEdit = new XComboEdit();
        employeeComboEdit.setColumns(30);
        dischargeDateField = new XDateField();
        dischargeTypeComboBox = new XComboBox(getDischargeTypeService().findAll());
        dischargeTypeComboBox.setPreferredWidth(70);
        compensationDayField = new XNumberField();
        outputDayField = new XNumberField();
        pensionAmountField = new XNumberField();

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(codeLabel);
        editPanel.addByY(dateLabel);
        editPanel.addByY(employeeLabel);
        editPanel.addByY(dischargeDateLabel);
        editPanel.addByY(dischargeTypeLabel);
        editPanel.addByY(compensationDayLabel);
        editPanel.addByY(outputDayLabel);
        editPanel.addByY(pensionAmountLabel);

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.addByX(codeField);
        editPanel.addByY(dateField);
        gbc.gridwidth = 2;
        editPanel.addByY(employeeComboEdit);
        gbc.gridwidth = 1;
        editPanel.addByY(dischargeDateField);

        gbc.gridwidth = 2;
        editPanel.addByY(dischargeTypeComboBox);
        gbc.gridwidth = 1;
        editPanel.addByY(compensationDayField);
        editPanel.addByY(outputDayField);
        editPanel.addByY(pensionAmountField);

        employeeComboEdit.initListFormAction(this, EmployeeList.class, "fullName");

        return editPanel;
    }


    private EmployeeDischarge getEmployeeDischarge() {
        return (EmployeeDischarge) this.getEntity();
    }


    protected void initData() throws ApplicationException {
        super.initData();
        getEmployeeDischarge().setDischargeDate(new Date());
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getEmployeeDischarge().getEmployeeName());
        employeeComboEdit.setValue(getEmployeeDischarge().getEmployee());
        codeField.setText(getEmployeeDischarge().getDocumentNo());
        dateField.setDate(getEmployeeDischarge().getDocumentDate());
        dischargeDateField.setDate(getEmployeeDischarge().getDischargeDate());
        dischargeTypeComboBox.setValue(getEmployeeDischarge().getDischargeType());
        compensationDayField.setValue(getEmployeeDischarge().getCompensationDay());
        outputDayField.setValue(getEmployeeDischarge().getOutputDay());
        pensionAmountField.setValue(getEmployeeDischarge().getPensionAmount());
    }


    protected void populateData() throws ApplicationException {
        getEmployeeDischarge().setEmployee((EmployeeHeader) employeeComboEdit.getValue());
        getEmployeeDischarge().setDocumentNo(codeField.getText());
        getEmployeeDischarge().setDocumentDate(dateField.getDate());
        getEmployeeDischarge().setDischargeDate(dischargeDateField.getDate());
        getEmployeeDischarge().setDischargeType((DischargeType) dischargeTypeComboBox.getValue());
        getEmployeeDischarge().setCompensationDay(compensationDayField.intValue());
        getEmployeeDischarge().setOutputDay(outputDayField.intValue());
        getEmployeeDischarge().setPensionAmount(pensionAmountField.doubleValue());
    }

    private DischargeTypeService getDischargeTypeService() throws ApplicationException {
	return (DischargeTypeService) getSERVICE(DischargeTypeService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployeeDischarge().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getEmployeeDischarge().getEmployee(), employeeLabel.getText());
	validateRequiredField(buf, getEmployeeDischarge().getDischargeType(), dischargeTypeLabel.getText());
	checkError(buf);
    }

}
