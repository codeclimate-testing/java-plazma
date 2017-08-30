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

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import org.plazmaforge.bsolution.contact.common.beans.ContactHeader;
import org.plazmaforge.bsolution.employee.client.swing.forms.EmployeeList;
import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.bsolution.organization.common.services.MtrlResponsibleService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 06.05.2004
 * Time: 19:55:55
 * $Id: ResponsibleEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class ResponsibleEdit extends AbstractOrganizableEdit {

    private JLabel employeeLabel;
    private JLabel warehouseLabel;

    private XComboEdit employeeComboEdit;
    private XComboEdit warehouseComboEdit;

    public ResponsibleEdit() throws ApplicationException {
        super(GUIOrganizationEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(MtrlResponsible.class);
        this.setEntityServiceClass(MtrlResponsibleService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        employeeLabel = new JLabel(getString("panel.label-employee-name.text"));
        warehouseLabel = new JLabel(getString("panel.label-storable-name.text"));
        
        employeeComboEdit = new XComboEdit();
        employeeComboEdit.setColumns(40);
        warehouseComboEdit = new XComboEdit(true);
        warehouseComboEdit.setColumns(40);

        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(employeeLabel);
        editPanel.addByY(warehouseLabel);
        gbc.gridy = 0;
        editPanel.addByX(employeeComboEdit);
        editPanel.addByY(warehouseComboEdit);

        employeeComboEdit.initListFormAction(this, EmployeeList.class, "fullName");
        warehouseComboEdit.initListFormAction(this, StorableList.class);

        add(editPanel);
    }

    private MtrlResponsible getResponsible() {
        return (MtrlResponsible) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getResponsible().getFullName());
        warehouseComboEdit.setValue(getResponsible().getWarehouse());
        employeeComboEdit.setValue(getResponsible().getContact());
    }

    protected void populateData() throws ApplicationException {
        getResponsible().setWarehouse((Warehouse) warehouseComboEdit.getValue());
        getResponsible().setContact((ContactHeader) employeeComboEdit.getValue());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getResponsible().getContact(), employeeLabel.getText());
	checkError(buf);
    }

}
