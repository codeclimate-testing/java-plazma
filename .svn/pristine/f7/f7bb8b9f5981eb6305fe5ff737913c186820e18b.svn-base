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

package org.plazmaforge.bsolution.goods.client.swing.forms;


import javax.swing.*;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentList;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.purchase.common.beans.PurchaseOrder;
import org.plazmaforge.bsolution.purchase.common.services.PurchaseOrderService;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;
import java.util.*;

/**
 * Created 31.05.2006
 */

public class PurchaseOrderList extends AbstractFinanceDocumentList {

    public PurchaseOrderList() throws ApplicationException {
        super(GUIGoodsEnvironment.getResources());
        initialize();
    }

    public PurchaseOrderList(Window window) throws ApplicationException {
        super(window, GUIGoodsEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(PurchaseOrder.class);
        this.setEntityServiceClass(PurchaseOrderService.class);
        this.setEntityEditFormClass(PurchaseOrderEdit.class);
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
        d.setName(getString("table.column-partner.name"));
        d.setFieldName("partnerName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);
        
        d = new ColumnProperty();
        d.setName(getString("table.column-storable.name"));
        d.setFieldName("warehouseName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-responsible.name"));
        d.setFieldName("responsibleName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table.column-currency-amount.name"));
        d.setFieldName("currencyEnterTotal");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(EnterpriseEnvironment.getCurrencyLabel());
        d.setFieldName("currencyName");
        d.setColumnClass(String.class);
        d.setSize(5);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table.column-amount.name"));
        d.setFieldName("enterTotal");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
        JTable table = super.createTable(model);
        table.getColumn(getString("table.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        table.getColumn(getString("table.column-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        return table;
    }

}
