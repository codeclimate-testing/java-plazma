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

package org.plazmaforge.bsolution.finance.client.swing.forms;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.Contractor;
import org.plazmaforge.bsolution.finance.common.services.ContractorService;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.forms.EntityType;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;


/**
 * @author Oleh Hapon
 * 
 * $Id: ContractorList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 * 
 */

public class ContractorList extends EXTListForm /* AbstractOrganizableList */{

    public ContractorList() throws ApplicationException {
	super(GUIFinanceEnvironment.getResources());
	initialize();
    }

    public ContractorList(Window window) throws ApplicationException {
	super(window, GUIFinanceEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityServiceClass(ContractorService.class);

	this.registerEntityType(Partner.CLASS_ID);
	this.registerEntityType(Employee.CLASS_ID);
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(700, DEFAULT_HEIGHT);
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

	return createObjectTableModel(Contractor.class, columns);
    }

    /** Override ID (ID -> OwnerID) */

    protected Object findObject(Object ID) throws ApplicationException {
	if (ID == null)
	    return null;
	return ((ContractorService) getEntityService())
		.findByOwnerId(((Integer) ID).intValue());
    }

    /** EntityType */

    protected void delCommand(Object ID) throws ApplicationException {
	getEntityType().delCommand(ID);
    }

    private Contractor getSelectedContractor() {
	return (Contractor) getSelectedObject();
    }

    /** Override ID (OwnerID -> ID) */
    protected Object getOwnerID() {
	return getSelectedContractor().getOwnerId();
    }

    /**
     * Get selected EntityType
     */
    protected EntityType getEntityType() {
	Contractor contractor = getSelectedContractor();
	if (contractor == null) {
	    return getNULLEntityType();
	}
	return getEntityType(contractor.getEntity().getCode());
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
