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


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.AddressType;
import org.plazmaforge.bsolution.contact.common.services.AddressTypeService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 9/10/2003
 * Time: 13:23:23
 */
public class AddressTypeList extends EXTListForm {

    public AddressTypeList() throws ApplicationException {
         super(GUIContactEnvironment.getResources());
         initialize();
    }

    public AddressTypeList(Window window) throws ApplicationException {
        super(window, GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(AddressType.class);
        this.setEntityServiceClass(AddressTypeService.class);
        this.setEntityEditFormClass(AddressTypeEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-name.name"));
        d.setFieldName("name");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        return columns;
    }


}