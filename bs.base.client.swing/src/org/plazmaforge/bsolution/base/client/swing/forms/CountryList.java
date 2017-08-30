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
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Country;
import org.plazmaforge.bsolution.base.common.services.CountryService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 6/10/2003 Time: 18:42:35 $Id: CountryList.java,v 1.1
 *         2007/03/02 07:06:41 ohapon Exp $
 */
public class CountryList extends EXTListForm {

    public CountryList() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    public CountryList(Window window) throws ApplicationException {
	super(window, GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Country.class);
	this.setEntityServiceClass(CountryService.class);
	this.setEntityEditFormClass(CountryEdit.class);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(400, 600);
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

	d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	return columns;
    }

}
