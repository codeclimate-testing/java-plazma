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
package org.plazmaforge.bsolution.project.client.swing.forms;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.project.client.swing.GUIProjectEnvironment;
import org.plazmaforge.bsolution.project.common.beans.ProjectStage;
import org.plazmaforge.bsolution.project.common.services.ProjectStageService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.IntegerCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class ProjectStageList extends EXTListForm {

    public ProjectStageList() throws ApplicationException {
	super(GUIProjectEnvironment.getResources());
	initialize();
    }

    public ProjectStageList(Window window) throws ApplicationException {
	super(window, GUIProjectEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(ProjectStage.class);
	this.setEntityServiceClass(ProjectStageService.class);
	this.setEntityEditFormClass(ProjectStageEdit.class);
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
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(60);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-order-number.name"));
	d.setFieldName("orderNumber");
	d.setColumnClass(Integer.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-averange-duration.name"));
	d.setFieldName("averangeDuration");
	d.setColumnClass(Integer.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-from-begin.name"));
	d.setFieldName("fromBegin");
	d.setColumnClass(Integer.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	table.getColumn(getString("table.column-order-number.name")).setCellRenderer(new IntegerCellRenderer());
	table.getColumn(getString("table.column-averange-duration.name")).setCellRenderer(new IntegerCellRenderer());
	table.getColumn(getString("table.column-from-begin.name")).setCellRenderer(new IntegerCellRenderer());
	return table;
    }

}
