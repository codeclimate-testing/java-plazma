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

import org.plazmaforge.bsolution.employee.client.swing.forms.AbstractEmployableEdit;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeTotal;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeTotalService;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.NumberUtils;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 29.10.2004
 * Time: 9:25:17
 * $Id: InputWorktimeEdit.java,v 1.4 2010/12/05 07:56:47 ohapon Exp $
 */
public class InputWorktimeEdit extends AbstractEmployableEdit {

    private JLabel employeeNameLabel;

    private JLabel workDayLabel;

    private JLabel workHourLabel;

    private XTextField employeeNameField;

    private XNumberField workDayField;

    private XNumberField workHourField;

    private EmployeeResult employeeResult;

    private boolean newEmployeeTotal;

    public InputWorktimeEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeeTotal.class);
	this.setEntityServiceClass(EmployeeTotalService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	employeeNameLabel = new JLabel(getString("panel.label-employee-name.text"));
	workDayLabel = new JLabel(getString("panel.label-work-day.text"));
	workHourLabel = new JLabel(getString("panel.label-work-hour.text"));

	employeeNameField = new XTextField(30);
	employeeNameField.setEditable(false);
	employeeNameField.setFocusable(false);
	workDayField = new XNumberField(20);
	workDayField.setInteger(true);
	workHourField = new XNumberField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(employeeNameLabel);
	editPanel.addByY(workDayLabel);
	editPanel.addByY(workHourLabel);

	gbc.gridy = 0;
	editPanel.addByX(employeeNameField);
	editPanel.addByY(workDayField);
	editPanel.addByY(workHourField);

	add(editPanel);
    }

    private EmployeeTotal getEmployeeTotal() {
	return (EmployeeTotal) this.getEntity();
    }

    protected void initData() throws ApplicationException {/* NOT SUPPORTED */
    }

    protected void loadData(Object value) throws ApplicationException {
	this.setEmployeeResult((EmployeeResult) value);
	if (this.getEmployeeResult().getEmployeeTotalId() == null) {
	    newEmployeeTotal = true;
	    EmployeeTotal total = new EmployeeTotal();
	    total.setPeriodId(this.getPeriodId());
	    total.setEmployee(this.getEmployeeResult().getEmployee());
	    this.setEntity(total);
	} else {
	    newEmployeeTotal = false;
	    super.loadData(this.getEmployeeResult().getEmployeeTotalId());
	}
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getEmployeeTotal().getEmployeeName());
	employeeNameField.setText(getEmployeeTotal().getEmployeeName());
	workDayField.setValue(getEmployeeTotal().getWorkDay());
	workHourField.setValue(getEmployeeTotal().getWorkHour());
    }

    private EmployeeTotalService getEmployeeTotalService() {
	return (EmployeeTotalService) this.getEntityService();
    }

    protected void populateData() throws ApplicationException {
	getEmployeeTotal().setWorkDay(workDayField.intValue());
	getEmployeeTotal().setWorkHour(NumberUtils.roundTime(workHourField.floatValue()));
    }

    protected Object createData() throws ApplicationException {/* NOT SUPPORTED */
	return null;
    }

    protected void storeData() throws ApplicationException {
	if (isNewEmployeeTotal()) {
	    getEmployeeTotalService().create(getEmployeeTotal());
	} else {
	    getEmployeeTotalService().store(getEmployeeTotal());
	}
    }

    private boolean isNewEmployeeTotal() {
	return newEmployeeTotal;
    }

    private EmployeeResult getEmployeeResult() {
	return employeeResult;
    }

    private void setEmployeeResult(EmployeeResult employeeResult) {
	this.employeeResult = employeeResult;
    }

}
