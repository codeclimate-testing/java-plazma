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

import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklist;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklistAverange;
import org.plazmaforge.framework.client.swing.controls.XCurrencyField;
import org.plazmaforge.framework.client.swing.controls.XIntegerField;
import org.plazmaforge.framework.client.swing.forms.EXTChildEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 04.11.2004
 * Time: 9:11:38
 * $Id: EmployeeSicklistAverangeEdit.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeeSicklistAverangeEdit extends EXTChildEditForm {

    private JLabel monthLabel;

    private JLabel workDayLabel;

    private JLabel amountLabel;

    private XIntegerField monthField;

    private XIntegerField workDayField;

    private XCurrencyField amountField;

    public EmployeeSicklistAverangeEdit() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeeSicklistAverange.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	monthLabel = new JLabel(getString("panel.label-month.text"));
	workDayLabel = new JLabel(getString("panel.label-work-day.text"));
	amountLabel = new JLabel(getString("panel.label-amount.text"));

	monthField = new XIntegerField(20);
	workDayField = new XIntegerField(20);
	amountField = new XCurrencyField(20);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(monthLabel);
	editPanel.addByY(workDayLabel);
	editPanel.addByY(amountLabel);

	gbc.gridy = 0;
	editPanel.addByX(monthField);
	editPanel.addByY(workDayField);
	editPanel.addByY(amountField);

	add(editPanel);
    }

    public EmployeeSicklistAverange getEmployeeSicklistAverange() {
	return (EmployeeSicklistAverange) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	monthField.setValue(getEmployeeSicklistAverange().getMonth());
	workDayField.setValue(getEmployeeSicklistAverange().getWorkDay());
	amountField.setValue(getEmployeeSicklistAverange().getAmount());
    }

    protected void populateData() throws ApplicationException {
	getEmployeeSicklistAverange().setMonth(monthField.intValue());
	getEmployeeSicklistAverange().setWorkDay(workDayField.intValue());
	getEmployeeSicklistAverange().setAmount(amountField.floatValue());
    }

    private EmployeeSicklist employeeSicklist;

    public EmployeeSicklist getEmployeeSicklist() {
	return employeeSicklist;
    }

    public void setEmployeeSicklist(EmployeeSicklist employeeSicklist) {
	this.employeeSicklist = employeeSicklist;
    }

    protected void addChild() throws ApplicationException {
	getEmployeeSicklist().addAverangeItem(getEmployeeSicklistAverange());
    }

}
