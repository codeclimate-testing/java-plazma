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

package org.plazmaforge.framework.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.framework.client.swing.gui.table.TableHelper;

import java.util.List;
import java.awt.*;


/**
 * @author Oleh Hapon
 * Date: 06.06.2006
 * Time: 8:12:21
 * $Id: TableFilterDialog.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class TableFilterDialog extends TableFindDialog {

    private List criteria;

    public TableFilterDialog(Frame frame, JTable table) {
        super(frame, table);
    }

    public TableFilterDialog(Frame frame, JTable table, boolean modal) {
        super(frame, table, modal);
    }

    protected void doOkAction() {
        if (getTable() == null || getFields() == null) return;

        TableHelper helper = new TableHelper();
        criteria = helper.createCriteriaByFields(getTable().getModel(), getFields());

        close();
    }

    public List getCriteria() {
        return criteria;
    }

}
