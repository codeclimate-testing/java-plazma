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

import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeEdit;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeHeader;
import org.plazmaforge.bsolution.employee.common.services.EmployeeService;
import org.plazmaforge.bsolution.organization.client.swing.forms.AbstractOrganizableList;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 9/10/2003 Time: 17:02:02
 */
public class EmployeeList extends AbstractOrganizableList {

    public EmployeeList() throws ApplicationException {
	super(GUIEmployeeEnvironment.getResources());
	initialize();
    }

    public EmployeeList(Window window) throws ApplicationException {
	super(window, GUIEmployeeEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EmployeeHeader.class);
	this.setEntityServiceClass(EmployeeService.class);
	this.setEntityEditFormClass(EmployeeEdit.class);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(900, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties()
	    throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	String nameVariant = LocaleManager.getNameVariant();
	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName(columns);
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName(columns);
	} else {
	    addFLName(columns);
	}

	d = new ColumnProperty();
	d.setName(getString("table.column-position.name"));
	d.setFieldName("positionName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-department.name"));
	d.setFieldName("departmentName");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	return columns;
    }

    // NAME
    // -----------------------------------------------------------------------------------------------
    
    private void addFLName(List columns) {
	addFirstName(columns);
	addLastName(columns);
    }

    private void addLFMName(List columns) {
	addLastName(columns);
	addFirstName(columns);
	addMiddleName(columns);
    }

    private void addFLMName(List columns) {
	addFirstName(columns);
	addLastName(columns);
	addMiddleName(columns);
    }

    private void addFirstName(List columns) {
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-first-name.name"));
	d.setFieldName("firstName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

    }

    private void addLastName(List columns) {
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-last-name.name"));
	d.setFieldName("lastName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

    }

    private void addMiddleName(List columns) {
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-middle-name.name"));
	d.setFieldName("middleName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);
    }

}
