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


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.organization.client.swing.GUIOrganizationEnvironment;
import org.plazmaforge.bsolution.organization.client.swing.forms.ResponsibleEdit;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.services.MtrlResponsibleService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 06.05.2004
 * Time: 16:24:45
 * $Id: ResponsibleList.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class ResponsibleList extends AbstractOrganizableList {

    public ResponsibleList() throws ApplicationException {
        super(GUIOrganizationEnvironment.getResources());
        initialize();
    }

    public ResponsibleList(Window window) throws ApplicationException {
        super(window, GUIOrganizationEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(MtrlResponsible.class);
        this.setEntityServiceClass(MtrlResponsibleService.class);
        this.setEntityEditFormClass(ResponsibleEdit.class);
        
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(550, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-employee-name.name"));
        d.setFieldName("employeeName");
        d.setColumnClass(String.class);
        d.setSize(100);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-storable-name.name"));
        d.setFieldName("warehouseName");
        d.setColumnClass(String.class);
        d.setSize(60);
        columns.add(d);

        return columns;
    }


}
