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


import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentParentEdit;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklist;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklistAverange;
import org.plazmaforge.bsolution.payroll.common.beans.SickType;
import org.plazmaforge.bsolution.payroll.common.beans.SicklistAverangeType;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeSicklistService;
import org.plazmaforge.bsolution.payroll.common.services.SickTypeService;
import org.plazmaforge.bsolution.payroll.common.services.SicklistAverangeTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
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


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 04.11.2004
 * Time: 9:11:21
 * $Id: EmployeeSicklistEdit.java,v 1.5 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeeSicklistEdit extends AbstractDocumentParentEdit {

    private JLabel seriesLabel;

    private JLabel codeLabel;

    private JLabel dateLabel;

    private JLabel employeeLabel;

    private JLabel startDateLabel;

    private JLabel endDateLabel;

    private JLabel sickTypeLabel;

    private JLabel sicklistAverangeTypeLabel;

    private JLabel quarterPremiumLabel;

    private JLabel yearPremiumLabel;

    private JLabel singlePremiumLabel;

    private JLabel averangeAmountLabel;

    private JLabel percentLabel;

    private XTextField seriesField;

    private XTextField codeField;

    private XDateField dateField;

    private XComboEdit employeeComboEdit;

    private XDateField startDateField;

    private XDateField endDateField;

    private XComboBox sickTypeComboBox;

    private XComboBox sicklistAverangeTypeComboBox;

    private XCurrencyField quarterPremiumField;

    private XCurrencyField yearPremiumField;

    private XCurrencyField singlePremiumField;

    private XCurrencyField averangeAmountField;

    private XNumberField percentField;

    public EmployeeSicklistEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeeSicklist.class);
	this.setEntityServiceClass(EmployeeSicklistService.class);
	this.setEntityCode(EmployeeSicklist.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	seriesLabel = new JLabel(getString("panel.label-series.text"));
	codeLabel = new JLabel(getString("panel.label-code.text"));
	dateLabel = new JLabel(getString("panel.label-date.text"));
	employeeLabel = new JLabel(getString("panel.label-employee.text"));
	startDateLabel = new JLabel(getString("panel.label-start-date.text"));
	endDateLabel = new JLabel(getString("panel.label-end-date.text"));
	sickTypeLabel = new JLabel(getString("panel.label-sick-type.text"));
	sicklistAverangeTypeLabel = new JLabel(getString("panel.label-sicklist-averange-type.text"));
	quarterPremiumLabel = new JLabel(getString("panel.label-quarter-premium.text"));
	yearPremiumLabel = new JLabel(getString("panel.label-year-premium.text"));
	singlePremiumLabel = new JLabel(getString("panel.label-single-premium.text"));
	averangeAmountLabel = new JLabel(getString("panel.label-averange-amount.text"));
	percentLabel = new JLabel(getString("panel.label-percent.text"));

	seriesField = new XTextField(10);
	seriesField.setMaxChar(10);
	codeField = new XTextField(10);
	codeField.setMaxChar(10);
	dateField = new XDateField();
	employeeComboEdit = new XComboEdit();
	employeeComboEdit.setColumns(30);
	startDateField = new XDateField();
	endDateField = new XDateField();
	sickTypeComboBox = new XComboBox(getSickTypeService().findAll());
	sicklistAverangeTypeComboBox = new XComboBox(getSicklistAverangeTypeService().findAll());

	quarterPremiumField = new XCurrencyField(10);
	yearPremiumField = new XCurrencyField(10);
	singlePremiumField = new XCurrencyField(10);
	averangeAmountField = new XCurrencyField(10);
	percentField = new XNumberField(10);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	int anchor = gbc.anchor;
	editPanel.add(seriesLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(codeLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(dateLabel);
	editPanel.addByY(employeeLabel);
	editPanel.addByY(startDateLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(endDateLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(sickTypeLabel);
	editPanel.addByY(sicklistAverangeTypeLabel);

	editPanel.addByY(quarterPremiumLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(averangeAmountLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(yearPremiumLabel);
	gbc.gridx = 2;
	gbc.anchor = GridBagConstraints.EAST;
	editPanel.add(percentLabel);
	gbc.gridx = 0;
	gbc.anchor = anchor;
	editPanel.addByY(singlePremiumLabel);

	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridx = 1;
	gbc.gridy = 0;
	editPanel.add(seriesField);
	gbc.gridx = 3;
	editPanel.add(codeField);
	gbc.gridx = 1;
	editPanel.addByY(dateField);
	gbc.gridwidth = 3;
	editPanel.addByY(employeeComboEdit);
	gbc.gridwidth = 1;
	editPanel.addByY(startDateField);
	gbc.gridx = 3;
	editPanel.add(endDateField);
	gbc.gridx = 1;
	gbc.gridwidth = 3;
	editPanel.addByY(sickTypeComboBox);
	editPanel.addByY(sicklistAverangeTypeComboBox);
	gbc.gridwidth = 1;

	editPanel.addByY(quarterPremiumField);
	gbc.gridx = 3;
	editPanel.add(averangeAmountField);
	gbc.gridx = 1;
	editPanel.addByY(yearPremiumField);
	gbc.gridx = 3;
	editPanel.add(percentField);
	gbc.gridx = 1;
	editPanel.addByY(singlePremiumField);

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

	TableColumn column = averangeItemTable.getColumnModel().getColumn(2);
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
	d.setName(getString("table-averange-item.column-amount.name"));
	d.setFieldName("amount");
	d.setColumnClass(Double.class);
	d.setSize(20);
	columns.add(d);

	return createObjectTableModel(EmployeeSicklistAverange.class, columns);
    }

    private EmployeeSicklist getEmployeeSicklist() {
	return (EmployeeSicklist) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getEmployeeSicklist().getEmployeeName());
	seriesField.setText(getEmployeeSicklist().getSeries());
	codeField.setText(getEmployeeSicklist().getDocumentNo());
	dateField.setDate(getEmployeeSicklist().getDocumentDate());
	employeeComboEdit.setValue(getEmployeeSicklist().getEmployee());

	startDateField.setDate(getEmployeeSicklist().getStartDate());
	endDateField.setDate(getEmployeeSicklist().getEndDate());

	sickTypeComboBox.setValue(getEmployeeSicklist().getSickType());
	sicklistAverangeTypeComboBox.setValue(getEmployeeSicklist().getSicklistAverangeType());

	quarterPremiumField.setValue(getEmployeeSicklist().getQuarterPremium());
	yearPremiumField.setValue(getEmployeeSicklist().getYearPremium());
	singlePremiumField.setValue(getEmployeeSicklist().getSinglePremium());
	averangeAmountField.setValue(getEmployeeSicklist().getAverangeAmount());
	percentField.setValue(getEmployeeSicklist().getSicklistPercent());

	((StateTableModel) averangeItemTable.getModel()).addData(getEmployeeSicklist().getAverangeItems());
    }

    private EmployeeSicklistService getEmployeeSicklistBIZ() {
	return (EmployeeSicklistService) getSERVICE(EmployeeSicklistService.class);
    }

    protected void populateData() throws ApplicationException {
	getEmployeeSicklist().setSeries(seriesField.getText());
	getEmployeeSicklist().setDocumentNo(codeField.getText());
	getEmployeeSicklist().setDocumentDate(dateField.getDate());
	getEmployeeSicklist().setEmployee((EmployeeHeader) employeeComboEdit.getValue());

	getEmployeeSicklist().setStartDate(startDateField.getDate());
	getEmployeeSicklist().setEndDate(endDateField.getDate());

	getEmployeeSicklist().setSickType((SickType) sickTypeComboBox.getValue());
	getEmployeeSicklist().setSicklistAverangeType((SicklistAverangeType) sicklistAverangeTypeComboBox.getValue());

	getEmployeeSicklist().setQuarterPremium(quarterPremiumField.getValue());
	getEmployeeSicklist().setYearPremium(yearPremiumField.getValue());
	getEmployeeSicklist().setSinglePremium(singlePremiumField.getValue());
	getEmployeeSicklist().setAverangeAmount(averangeAmountField.getValue());
	getEmployeeSicklist().setSicklistPercent(percentField.floatValue());
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	((EmployeeSicklistAverangeEdit) form).setEmployeeSicklist(getEmployeeSicklist());
	return form;
    }

    protected class AverangeItemType extends AbstractChildType {
	public JTable getTable() {
	    return averangeItemTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(EmployeeSicklistAverangeEdit.class);
	}
    }

    private SickTypeService getSickTypeService() throws ApplicationException {
	return (SickTypeService) getSERVICE(SickTypeService.class);
    }

    private SicklistAverangeTypeService getSicklistAverangeTypeService() throws ApplicationException {
	return (SicklistAverangeTypeService) getSERVICE(SicklistAverangeTypeService.class);
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmployeeSicklist().getEmployee(),	employeeLabel.getText());
	validateRequiredField(buf, getEmployeeSicklist().getSicklistAverangeType(), sicklistAverangeTypeLabel.getText());
	validateRequiredField(buf, getEmployeeSicklist().getSickType(),	sickTypeLabel.getText());
	validateRequiredField(buf, getEmployeeSicklist().getDocumentDate(), dateLabel.getText());
	validateRequiredField(buf, getEmployeeSicklist().getStartDate(), startDateLabel.getText());
	validateRequiredField(buf, getEmployeeSicklist().getEndDate(), endDateLabel.getText());
	checkError(buf);
    }

}
