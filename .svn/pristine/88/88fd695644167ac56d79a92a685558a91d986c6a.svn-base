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

package org.plazmaforge.bsolution.organization.client.swing.forms;


import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.Department;
import org.plazmaforge.bsolution.organization.common.beans.IWarehouse;
import org.plazmaforge.bsolution.organization.common.beans.Store;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.organization.common.services.WarehouseService;
import org.plazmaforge.framework.client.swing.forms.EntityType;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.platform.EntityEnvironment;


import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Oleh Hapon
 * Date: 18.12.2004
 * Time: 11:54:45
 * $Id: StorableList.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class StorableList extends AbstractOrganizableList {

    public StorableList() throws ApplicationException {
	super(GUIOrganizationEnvironment.getResources());
	initialize();
    }

    public StorableList(Window window) throws ApplicationException {
	super(window, GUIOrganizationEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityServiceClass(WarehouseService.class);

	this.registerEntityType(Store.CLASS_ID);
	this.registerEntityType(Department.CLASS_ID);
    }

    protected TableModel createTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("fullName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-entity-name.name"));
	d.setFieldName("entityName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(Warehouse.class, columns);
    }

    /** Override ID (ID -> OwnerID) */
    protected Object findObject(Object ID) throws ApplicationException {
	if (ID == null) {
	    return null;
	}
	return ((WarehouseService) getEntityService()).findByOwnerId(((Integer) ID).intValue());
    }

    /** EntityType */
    protected void delCommand(Object ID) throws ApplicationException {
	getEntityType().delCommand(ID);
    }

    private IWarehouse getSelectedWarehouse() {
	return (Warehouse) getSelectedObject();
    }

    /** Override ID (OwnerID -> ID) */
    protected Object getOwnerID() {
	return getSelectedWarehouse().getOwnerId();
    }

    /**
     * Get selected EntityType
     */
    protected EntityType getEntityType() {
	IWarehouse warehouse = getSelectedWarehouse();
	if (warehouse == null) {
	    return getNULLEntityType();
	}
	return getEntityType(EntityManager.getEntityId(warehouse));
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
