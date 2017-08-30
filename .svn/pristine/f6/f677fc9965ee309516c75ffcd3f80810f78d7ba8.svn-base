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
package org.plazmaforge.bsolution.partner.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerGroupEdit;
import org.plazmaforge.bsolution.partner.common.beans.PartnerGroup;
import org.plazmaforge.bsolution.partner.common.services.PartnerGroupService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 15.09.2004
 * Time: 7:49:33
 * $Id: PartnerGroupList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerGroupList extends EXTListForm {

    public PartnerGroupList() throws ApplicationException {
        super(GUIPartnerEnvironment.getResources());
        initialize();
    }

    public PartnerGroupList(Window window) throws ApplicationException {
        super(window, GUIPartnerEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PartnerGroup.class);
        this.setEntityServiceClass(PartnerGroupService.class);
        this.setEntityEditFormClass(PartnerGroupEdit.class);
    }


    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(310, DEFAULT_HEIGHT);
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
        d.setSize(50);
        columns.add(d);

        return columns;
    }

}
