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
import javax.swing.table.TableColumn;
import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeResult;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeResultService;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 29.10.2004
 * Time: 9:25:07
 * $Id: InputWorktimeList.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class InputWorktimeList extends AbstractDocumentList {

    public InputWorktimeList() throws ApplicationException {
	super(GUIPayrollEnvironment.getResources());
	initialize();
    }

    public InputWorktimeList(Window window) throws ApplicationException {
	super(window, GUIPayrollEnvironment.getResources());
	initialize();
    }

    private void initialize() {

	this.setPeriodId(EnterpriseEnvironment.getPayrollPeriodId());

	this.setEntityClass(EmployeeResult.class);
	this.setEntityServiceClass(EmployeeResultService.class);
	this.setEntityEditFormClass(InputWorktimeEdit.class);

    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(700, DEFAULT_HEIGHT);
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

	return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	TableColumn column = table.getColumnModel().getColumn(4);
	column.setCellRenderer(new CurrencyCellRenderer());
	return table;
    }

    protected EditForm getEditForm() throws ApplicationException {
	InputWorktimeEdit form = (InputWorktimeEdit) super.getEditForm();
	form.setOrganizationId(this.getOrganizationId());
	form.setPeriodId(this.getPeriodId());
	return form;
    }

    // TODO: Object or ID !!!
    protected Object findObject(Object object) throws ApplicationException {
	if (object == null)  {
	    return null;
	}
	return this.getEntityService().findHeaderById(((EmployeeResult) object).getId());
    }

    protected void delCommand(Object ID) throws ApplicationException {/* NOT SUPPORTED */
    }

    // TODO: TransferObject = Real selected object
    protected Object getTransferObject() {
	return getSelectedObject();
    }

}
