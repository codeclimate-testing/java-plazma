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
package org.plazmaforge.bsolution.contact.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;


import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.City;
import org.plazmaforge.bsolution.contact.common.beans.Locality;
import org.plazmaforge.bsolution.contact.common.beans.LocalityType;
import org.plazmaforge.bsolution.contact.common.services.LocalityService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EntityType;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;


/**
 * @author Oleh Hapon
 * Date: 28.11.2004
 * Time: 12:53:27
 * $Id: LocalityList.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class LocalityList extends EXTListForm {

    public LocalityList() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }

    public LocalityList(Window window) throws ApplicationException {
	super(window, GUIContactEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Locality.class);
	this.setEntityServiceClass(LocalityService.class);
	//this.setEntityEditFormClass(LocalityEdit.class);

	registerEntityType(Locality.CLASS_ID);
	registerEntityType(City.CLASS_ID);

    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(950, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties()
	    throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();
	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-locality-type-full-name.name"));
	d.setFieldName("localityTypeFullName");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(40);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-country.name"));
	d.setFieldName("countryName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-region.name"));
	d.setFieldName("regionName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return columns;
    }

    // NEW ---------------------------------------------------------------------

    private Locality getSelectedLocality() {
	return (Locality) getSelectedObject();
    }

    /** EntityType */
    protected void delCommand(Object ID) throws ApplicationException {
	getEntityType().delCommand(ID);
    }

    /**
     * Get selected EntityType
     */
    protected EntityType getEntityType() {
	Locality document = getSelectedLocality();
	if (document == null) {
	    return getNULLEntityType();
	}
	String entityCode;
	if (document.getLocalityType().getId() == LocalityType.CITY) {
	    entityCode = City.CLASS_ID;
	} else {
	    entityCode = Locality.CLASS_ID;
	}
	//return getEntityType(document.getDocumentType().getEntity().getCode());
	return getEntityType(entityCode);
    }

    // TODO: You must up method	
    protected Object getEntityView(Object entityCode) {
	return EntityEnvironment.getEntityById((String) entityCode);
    }

    // TODO: You must up method
    protected EntityType getDialogEntityType(Object selectedValue) {
	return getEntityType(((EntityConfig) selectedValue).getCode());
    }


}
