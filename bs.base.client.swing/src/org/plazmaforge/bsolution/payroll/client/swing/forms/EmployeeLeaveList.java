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
package org.plazmaforge.bsolution.payroll.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.bsolution.payroll.client.swing.GUIPayrollEnvironment;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacation;
import org.plazmaforge.bsolution.payroll.common.services.EmployeeVacationService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 02.11.2004
 * Time: 9:06:58
 * $Id: EmployeeLeaveList.java,v 1.3 2010/12/05 07:56:47 ohapon Exp $
 */
public class EmployeeLeaveList extends AbstractDocumentList {

    public EmployeeLeaveList() throws ApplicationException {
        super(GUIPayrollEnvironment.getResources());
        initialize();        
    }

    public EmployeeLeaveList(Window window) throws ApplicationException {
        super(window, GUIPayrollEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(EmployeeVacation.class);
        this.setEntityServiceClass(EmployeeVacationService.class);
        this.setEntityEditFormClass(EmployeeLeaveEdit.class);        
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


        d = new ColumnProperty();
        d.setName(getString("table.column-start-date.name"));
        d.setFieldName("startDate");
        d.setColumnClass(Date.class);
        d.setSize(15);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-end-date.name"));
        d.setFieldName("endDate");
        d.setColumnClass(Date.class);
        d.setSize(15);
        columns.add(d);


        return columns;
    }


}
