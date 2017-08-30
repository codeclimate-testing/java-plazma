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


import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;

import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.LedgerAccountRest;
import org.plazmaforge.bsolution.finance.common.services.LedgerAccountRestService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;
import java.util.*;

/*
 * Created on 11.10.2006
 *
 */

/**
 * 
 * @author Oleh Hapon
 * 
 * $Id: LedgerAccountRestList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 *
 */
public class LedgerAccountRestList extends AbstractFinanceDocumentList {

    public LedgerAccountRestList() {
        super(GUIFinanceEnvironment.getResources());
        initialize();
    }

    public LedgerAccountRestList(Window window) {
        super(window, GUIFinanceEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(LedgerAccountRest.class);
        this.setEntityServiceClass(LedgerAccountRestService.class);
        this.setEntityEditFormClass(LedgerAccountRestEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(950, DEFAULT_HEIGHT);
    }

    protected java.util.List createTableColumnProperties() throws ApplicationException {

        java.util.List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-ledger-account.name"));
        d.setFieldName("accountName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-debit-amount.name"));
        d.setFieldName("debitAmount");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-credit-amount.name"));
        d.setFieldName("creditAmount");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
        JTable table = super.createTable(model);
        TableColumn column = table.getColumnModel().getColumn(1);
        column.setCellRenderer(new CurrencyCellRenderer());
        column = table.getColumnModel().getColumn(2);
        column.setCellRenderer(new CurrencyCellRenderer());
        return table;
    }

}
