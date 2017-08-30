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
import java.util.Date;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeDischarge;
import org.plazmaforge.bsolution.employee.common.services.EmployeeDischargeService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 14.10.2004
 * Time: 9:53:49
 * $Id: EmployeeDischargeList.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class EmployeeDischargeList extends AbstractDocumentList {

    public EmployeeDischargeList() throws ApplicationException {
        super(GUIEmployeeEnvironment.getResources());
        initiaize();
    }

    public EmployeeDischargeList(Window window) throws ApplicationException {
        super(window, GUIEmployeeEnvironment.getResources());
        initiaize();
    }
    
    private void initiaize() {
        this.setEntityClass(EmployeeDischarge.class);
        this.setEntityServiceClass(EmployeeDischargeService.class);
        this.setEntityEditFormClass(EmployeeDischargeEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(600, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-code.name"));
        d.setFieldName("code");
        d.setColumnClass(String.class);
        d.setSize(10);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-date.name"));
        d.setFieldName("date");
        d.setColumnClass(Date.class);
        d.setSize(15);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-employee-name.name"));
        d.setFieldName("employeeName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        return columns;
    }

}
