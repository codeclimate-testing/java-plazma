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

package org.plazmaforge.bsolution.personality.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.client.swing.forms.PersonEdit;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;
import org.plazmaforge.bsolution.personality.common.services.PersonService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 08.03.2004
 * Time: 17:43:40
 * $Id: PersonList.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonList extends EXTListForm {

    public PersonList() throws ApplicationException {
	super(GUIPersonalityEnvironment.getResources());
	initialize();
    }

    public PersonList(Window window) throws ApplicationException {
	super(window, GUIPersonalityEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(PersonHeader.class);
	this.setEntityServiceClass(PersonService.class);
	this.setEntityEditFormClass(PersonEdit.class);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(700, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	String nameVariant = LocaleManager.getNameVariant();
	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName(columns);
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName(columns);
	} else {
	    addFLName(columns);
	}

	return columns;
    }

    // NAME -----------------------------------------------------------------------------------------------
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
	d.setSize(50);
	columns.add(d);

    }

    private void addLastName(List columns) {
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-last-name.name"));
	d.setFieldName("lastName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

    }

    private void addMiddleName(List columns) {
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-middle-name.name"));
	d.setFieldName("middleName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);
    }

}
