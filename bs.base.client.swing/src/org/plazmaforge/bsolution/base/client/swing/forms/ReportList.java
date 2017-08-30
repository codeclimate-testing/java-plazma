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

package org.plazmaforge.bsolution.base.client.swing.forms;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.config.object.ReportConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.ReportFactory;


/**
 * @author Oleh Hapon
 * 
 * $Id: ReportList.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 * 
 */

public class ReportList extends EXTListForm {

    public ReportList() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    public ReportList(Window window) throws ApplicationException {
	super(window, GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(ReportConfig.class);
	// this.setEntityServiceClass(SystemEntityService.class);

	// this.setEntityEditFormClass(SystemEntityEdit.class);

	this.setReadOnly(true);
	// chooseAction.setEnabled(true);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(650, DEFAULT_HEIGHT);
    }

    protected void prepareListableShow() {
	super.prepareListableShow();
	setEnabledAction(chooseAction, true);
    }

    protected List createTableColumnProperties() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-entity-folder.name"));
	d.setFieldName("folder");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	return columns;
    }

    protected void loadData() throws ApplicationException {
	refreshTableModel(getReportList());
    }

    private List getReportList() {
	return ReportFactory.getReportConfigsBySingle(false);
    }

    protected void performEnter() throws ApplicationException {
	IReportConfig config = (IReportConfig) getSelectedObject();
	if (config == null) {
	    return;
	}

	// if (config.isSingle()) {
	// return;
	// }

	ReportAction action = (ReportAction) ReportFactory.getReportAction(config);
	if (action == null) {
	    return;
	}
	action.actionPerformed(new ActionEvent(this, 0, ""));
    }

    public void doChooseCommand() throws ApplicationException {
	performEnter();
    }
}
