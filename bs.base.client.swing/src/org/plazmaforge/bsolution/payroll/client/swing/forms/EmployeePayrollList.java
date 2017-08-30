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


import javax.swing.table.TableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.*;

import org.plazmaforge.bsolution.employee.client.swing.forms.AbstractEmployableList;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeePayroll;
import org.plazmaforge.bsolution.payroll.common.services.EmployeePayrollService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Payroll list of Employee 
 * This is child form. Parent is @seeInputPayrollList form
 * 
 * @author Oleh Hapon
 * Date: 30.10.2004
 * Time: 11:52:29
 * $Id: EmployeePayrollList.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeePayrollList extends AbstractEmployableList {

    public EmployeePayrollList() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    public EmployeePayrollList(Window window) throws ApplicationException {
	super(window, GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {

	this.setEntityClass(EmployeePayroll.class);
	this.setEntityServiceClass(EmployeePayrollService.class);
	this.setEntityEditFormClass(EmployeePayrollEdit.class);

    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(650, DEFAULT_HEIGHT);
    }

    protected void initActions() throws ApplicationException {
	super.initActions();
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-payroll-code.name"));
	d.setFieldName("payrollCode");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-payroll-name.name"));
	d.setFieldName("payrollName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-payroll-type.name"));
	d.setFieldName("payrollTypeName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-day.name"));
	d.setFieldName("day");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-hour.name"));
	d.setFieldName("hour");
	d.setColumnClass(Float.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-amount.name"));
	d.setFieldName("amount");
	d.setColumnClass(Double.class);
	d.setSize(15);
	columns.add(d);

	return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	TableColumnModel columnModel = table.getColumnModel();
	columnModel.getColumn(3).setCellRenderer(new CurrencyCellRenderer());
	columnModel.getColumn(4).setCellRenderer(new CurrencyCellRenderer());
	return table;
    }

}
