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


import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentParentEdit;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacation;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacationAverange;
import org.plazmaforge.bsolution.payroll.common.beans.VacationAverangeType;
import org.plazmaforge.bsolution.payroll.common.beans.VacationCalculate;
import org.plazmaforge.bsolution.payroll.common.beans.VacationType;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeVacationService;
import org.plazmaforge.bsolution.payroll.common.services.VacationAverangeTypeService;
import org.plazmaforge.bsolution.payroll.common.services.VacationCalculateService;
import org.plazmaforge.bsolution.payroll.common.services.VacationTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.GridBagConstraints;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 03.11.2004
 * Time: 7:57:35
 * $Id: EmployeeLeaveEdit.java,v 1.4 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeeLeaveEdit extends AbstractDocumentParentEdit {

    private JLabel codeLabel;

    private JLabel dateLabel;

    private JLabel employeeLabel;

    private JLabel startDateLabel;

    private JLabel endDateLabel;

    private JLabel dayLabel;

    private JLabel addDayLabel;

    private JLabel workStartDateLabel;

    private JLabel workEndDateLabel;

    private JLabel averangeAmountLabel;

    private JLabel leaveTypeLabel;

    private JLabel leaveAverangeTypeLabel;

    private JLabel leaveCalculateLabel;

    private JLabel addLeaveCalculateLabel;

    private JLabel quarterPremiumLabel;

    private JLabel yearPremiumLabel;

    private JLabel singlePremiumLabel;

    private XTextField codeField;

    private XDateField dateField;

    private XComboEdit employeeComboEdit;

    private XDateField startDateField;

    private XDateField endDateField;

    private XNumberField dayField;

    private XNumberField addDayField;

    private XDateField workStartDateField;

    private XDateField workEndDateField;

    private XNumberField averangeAmountField;

    private XComboBox leaveTypeComboBox;

    private XComboBox leaveAverangeTypeComboBox;

    private XComboBox leaveCalculateComboBox;

    private XComboBox addLeaveCalculateComboBox;

    private XNumberField quarterPremiumField;

    private XNumberField yearPremiumField;

    private XNumberField singlePremiumField;

    public EmployeeLeaveEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeeVacation.class);
	this.setEntityServiceClass(EmployeeVacationService.class);
	this.setEntityCode(EmployeeVacation.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	employeeLabel = new JLabel(getString("panel.label-employee.text"));
	startDateLabel = new JLabel(getString("panel.label-start-date.text"));
	endDateLabel = new JLabel(getString("panel.label-end-date.text"));
	dayLabel = new JLabel(getString("panel.label-day.text"));
	addDayLabel = new JLabel(getString("panel.label-add-day.text"));
	workStartDateLabel = new JLabel(getString("panel.label-work-start-date.text"));
	workEndDateLabel = new JLabel(getString("panel.label-work-end-date.text"));
	leaveTypeLabel = new JLabel(getString("panel.label-leave-type.text"));
	leaveAverangeTypeLabel = new JLabel(getString("panel.label-leave-averange-type.text"));
	leaveCalculateLabel = new JLabel(getString("panel.label-leave-calculate.text"));
	addLeaveCalculateLabel = new JLabel(getString("panel.label-add-leave-calculate.text"));
	quarterPremiumLabel = new JLabel(getString("panel.label-quarter-premium.text"));
	yearPremiumLabel = new JLabel(getString("panel.label-year-premium.text"));
	singlePremiumLabel = new JLabel(getString("panel.label-single-premium.text"));
	averangeAmountLabel = new JLabel(getString("panel.label-averange-amount.text"));

	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	employeeComboEdit = new XComboEdit();
	employeeComboEdit.setColumns(30);
	startDateField = new XDateField();
	endDateField = new XDateField();
	dayField = new XNumberField(8);
	dayField.setInteger(true);
	addDayField = new XNumberField(8);
	addDayField.setInteger(true);
	workStartDateField = new XDateField();
	workEndDateField = new XDateField();
	leaveTypeComboBox = new XComboBox(getLeaveTypeService().findAll());
	leaveAverangeTypeComboBox = new XComboBox(getLeaveAverangeTypeService().findAll());
	leaveCalculateComboBox = new XComboBox(getLeaveCalculateService().findAll());
	addLeaveCalculateComboBox = new XComboBox(getLeaveCalculateService().findAll());
	quarterPremiumField = new XNumberField(10);
	yearPremiumField = new XNumberField(10);
	singlePremiumField = new XNumberField(10);
	averangeAmountField = new XNumberField(10);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	int anchor = gbc.anchor;
	editPanel.add(codeLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(dateLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(employeeLabel);
	editPanel.addByY(startDateLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(endDateLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(dayLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(addDayLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(workStartDateLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(workEndDateLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(leaveTypeLabel);
	editPanel.addByY(leaveAverangeTypeLabel);
	editPanel.addByY(leaveCalculateLabel);
	editPanel.addByY(addLeaveCalculateLabel);

	editPanel.addByY(quarterPremiumLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(singlePremiumLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(yearPremiumLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(averangeAmountLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	editPanel.add(codeField);
	gbc.gridx = 3;
	editPanel.add(dateField);
	gbc.gridx = 1;
	gbc.gridwidth = 3;
	editPanel.addByY(employeeComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(startDateField);
	gbc.gridx = 3;
	editPanel.add(endDateField);
	gbc.gridx = 1;
	editPanel.addByY(dayField);
	gbc.gridx = 3;
	editPanel.add(addDayField);
	gbc.gridx = 1;
	editPanel.addByY(workStartDateField);
	gbc.gridx = 3;
	editPanel.add(workEndDateField);
	gbc.gridx = 1;
	gbc.gridwidth = 3;
	editPanel.addByY(leaveTypeComboBox);
	editPanel.addByY(leaveAverangeTypeComboBox);
	editPanel.addByY(leaveCalculateComboBox);
	editPanel.addByY(addLeaveCalculateComboBox);

	gbc.gridwidth = 1;
	editPanel.addByY(quarterPremiumField);
	gbc.gridx = 3;
	editPanel.add(singlePremiumField);
	gbc.gridx = 1;
	editPanel.addByY(yearPremiumField);
	gbc.gridx = 3;
	editPanel.add(averangeAmountField);

	employeeComboEdit.initListFormAction(this, EmployeeList.class, "fullName");

	getParentPane().add(editPanel);
	tabbedPane = createItems();
	setChildrenTabbedPane(tabbedPane);
	addChildrenTabbedPane();

    }

    private JTabbedPane tabbedPane;

    private JTabbedPane createItems() throws ApplicationException {
	JTabbedPane tp = createTabbedPane(600, 200);
	tp.addTab(getString("table-averange-item.name"), createItemPanel());
	return tp;
    }

    private JTable averangeItemTable;

    private JComponent createItemPanel() throws ApplicationException {
	averangeItemTable = createChildTable(createItemTableModel());

	TableColumn column = averangeItemTable.getColumnModel().getColumn(3);
	column.setCellRenderer(new CurrencyCellRenderer());
	column = averangeItemTable.getColumnModel().getColumn(4);
	column.setCellRenderer(new CurrencyCellRenderer());

	JScrollPane scroll = new JScrollPane(averangeItemTable);
	this.registerEntityType(scroll, new AverangeItemType());
	return scroll;
    }

    protected TableModel createItemTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();

	d.setName(getString("table-averange-item.column-month.name"));
	d.setFieldName("month");
	d.setColumnClass(Integer.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-averange-item.column-work-day.name"));
	d.setFieldName("workDay");
	d.setColumnClass(Integer.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-averange-item.column-leave-day.name"));
	d.setFieldName("leaveDay");
	d.setColumnClass(Integer.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-averange-item.column-add-leave-day.name"));
	d.setFieldName("addLeaveDay");
	d.setColumnClass(Integer.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-averange-item.column-amount.name"));
	d.setFieldName("amount");
	d.setColumnClass(Double.class);
	d.setSize(20);
	columns.add(d);

	return createObjectTableModel(EmployeeVacationAverange.class, columns);
    }

    private EmployeeVacation getEmployeeLeave() {
	return (EmployeeVacation) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getEmployeeLeave().getEmployeeName());
	codeField.setText(getEmployeeLeave().getDocumentNo());
	dateField.setDate(getEmployeeLeave().getDocumentDate());
	employeeComboEdit.setValue(getEmployeeLeave().getEmployee());

	startDateField.setDate(getEmployeeLeave().getStartDate());
	endDateField.setDate(getEmployeeLeave().getEndDate());
	dayField.setValue(getEmployeeLeave().getDay());
	addDayField.setValue(getEmployeeLeave().getAddDay());
	workStartDateField.setDate(getEmployeeLeave().getWorkStartDate());
	workEndDateField.setDate(getEmployeeLeave().getWorkEndDate());
	averangeAmountField.setValue(getEmployeeLeave().getAverangeAmount());

	leaveTypeComboBox.setValue(getEmployeeLeave().getVacationType());
	leaveAverangeTypeComboBox.setValue(getEmployeeLeave().getVacationAverangeType());
	leaveCalculateComboBox.setValue(getEmployeeLeave().getVacationCalculate());
	addLeaveCalculateComboBox.setValue(getEmployeeLeave().getAddVacationCalculate());

	quarterPremiumField.setValue(getEmployeeLeave().getQuarterPremium());
	yearPremiumField.setValue(getEmployeeLeave().getYearPremium());
	singlePremiumField.setValue(getEmployeeLeave().getSinglePremium());

	((StateTableModel) averangeItemTable.getModel()).addData(getEmployeeLeave().getAverangeItems());
    }

    protected void populateData() throws ApplicationException {
	getEmployeeLeave().setDocumentNo(codeField.getText());
	getEmployeeLeave().setDocumentDate(dateField.getDate());
	getEmployeeLeave().setEmployee((EmployeeHeader) employeeComboEdit.getValue());

	getEmployeeLeave().setStartDate(startDateField.getDate());
	getEmployeeLeave().setEndDate(endDateField.getDate());
	getEmployeeLeave().setDay(dayField.intValue());
	getEmployeeLeave().setAddDay(addDayField.intValue());
	getEmployeeLeave().setWorkStartDate(workStartDateField.getDate());
	getEmployeeLeave().setWorkEndDate(workEndDateField.getDate());

	getEmployeeLeave().setAverangeAmount(averangeAmountField.getValue());

	getEmployeeLeave().setVacationType((VacationType) leaveTypeComboBox.getValue());
	getEmployeeLeave().setVacationAverangeType((VacationAverangeType) leaveAverangeTypeComboBox.getValue());
	getEmployeeLeave().setVacationCalculate((VacationCalculate) leaveCalculateComboBox.getValue());
	getEmployeeLeave().setAddVacationCalculate((VacationCalculate) addLeaveCalculateComboBox.getValue());

	getEmployeeLeave().setQuarterPremium(quarterPremiumField.getValue());
	getEmployeeLeave().setYearPremium(yearPremiumField.getValue());
	getEmployeeLeave().setSinglePremium(singlePremiumField.getValue());
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	((EmployeeLeaveAverangeEdit) form).setEmployeeLeave(getEmployeeLeave());
	return form;
    }

    private class AverangeItemType extends AbstractChildType {
	public JTable getTable() {
	    return averangeItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(EmployeeLeaveAverangeEdit.class);
	}
    }

    private VacationTypeService getLeaveTypeService() throws ApplicationException {
	return (VacationTypeService) getSERVICE(VacationTypeService.class);
    }

    private VacationCalculateService getLeaveCalculateService() throws ApplicationException {
	return (VacationCalculateService) getSERVICE(VacationCalculateService.class);
    }

    private VacationAverangeTypeService getLeaveAverangeTypeService() throws ApplicationException {
	return (VacationAverangeTypeService) getSERVICE(VacationAverangeTypeService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployeeLeave().getEmployee(), employeeLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getVacationAverangeType(), leaveAverangeTypeLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getVacationCalculate(), leaveCalculateLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getVacationType(), leaveTypeLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getStartDate(), startDateLabel.getText());
	validateRequiredField(buf, getEmployeeLeave().getEndDate(), endDateLabel.getText());
	checkError(buf);
    }

}
