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

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeResultService;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.forms.ListableMode;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Input payroll of Employee by organization and period
 * 
 * @author Oleh Hapon
 * Date: 30.10.2004
 * Time: 11:52:11
 * $Id: InputPayrollList.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class InputPayrollList extends AbstractDocumentList {

    public InputPayrollList() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    public InputPayrollList(Window window) throws ApplicationException {
	super(window, GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {

	this.setPeriodId(EnterpriseEnvironment.getPayrollPeriodId());

	this.setEntityClass(EmployeeResult.class);
	this.setEntityServiceClass(EmployeeResultService.class);

    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(950, DEFAULT_HEIGHT);
    }

    protected void initActions() throws ApplicationException {
	super.initActions();
	initModifyActionOnlyEdit();
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-employee-code.name"));
	d.setFieldName("employeeCode");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-employee-name.name"));
	d.setFieldName("employeeName");
	d.setColumnClass(String.class);
	d.setSize(60);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-department-name.name"));
	d.setFieldName("departmentName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-work-day.name"));
	d.setFieldName("workDay");
	d.setColumnClass(Integer.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-work-hour.name"));
	d.setFieldName("workHour");
	d.setColumnClass(Float.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-increment-amount.name"));
	d.setFieldName("incrementAmount");
	d.setColumnClass(Double.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-decrement-amount.name"));
	d.setFieldName("decrementAmount");
	d.setColumnClass(Double.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-payroll-amount.name"));
	d.setFieldName("payrollAmount");
	d.setColumnClass(Double.class);
	d.setSize(15);
	columns.add(d);

	return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	TableColumnModel columnModel = table.getColumnModel();
	columnModel.getColumn(4).setCellRenderer(new CurrencyCellRenderer());
	columnModel.getColumn(5).setCellRenderer(new CurrencyCellRenderer());
	columnModel.getColumn(6).setCellRenderer(new CurrencyCellRenderer());
	columnModel.getColumn(7).setCellRenderer(new CurrencyCellRenderer());
	return table;
    }

    protected EditForm getEditForm() throws ApplicationException {
	return null;
    }

    protected void delCommand(Object ID) throws ApplicationException {
    }

    public void doEditCommand(int mode) throws ApplicationException {
	Object obj = this.getSelectedObject();
	if (obj == null) {
	    return;
	}
	EmployeePayrollList listForm = (EmployeePayrollList) this.getLIST(
		EmployeePayrollList.class, SwingEnvironment.getFrame(),
		ListableMode.LIST);

	listForm.setOrganizationId(this.getOrganizationId());
	listForm.setPeriodId(this.getPeriodId());
	listForm.setEmployee(((EmployeeResult) obj).getEmployee());

	listForm.setLoadData(false);
	listForm.showList();
    }

}
