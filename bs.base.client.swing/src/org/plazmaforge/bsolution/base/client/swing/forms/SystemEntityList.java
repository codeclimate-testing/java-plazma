package org.plazmaforge.bsolution.base.client.swing.forms;


import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * @author Oleh Hapon Date: 03.06.2006 Time: 10:57:40 $Id: SystemEntityList.java,v 1.2 2010/12/05 07:56:44 ohapon Exp $
 */
public class SystemEntityList extends EXTListForm {

    public SystemEntityList() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    public SystemEntityList(Window window) throws ApplicationException {
	super(window, GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EntityConfig.class);
	this.setEntityServiceClass(SystemEntityService.class);

	// this.setEntityEditFormClass(SystemEntityEdit.class);

	this.setReadOnly(true);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(650, DEFAULT_HEIGHT);
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
	d.setName(getString("table.column-entity-package.name"));
	d.setFieldName("entityPackage");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	return columns;
    }

}
