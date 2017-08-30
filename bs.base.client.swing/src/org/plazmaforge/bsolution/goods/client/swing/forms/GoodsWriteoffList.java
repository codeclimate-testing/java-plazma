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


import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentList;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.goods.client.swing.forms.GoodsWriteoffEdit;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoff;
import org.plazmaforge.bsolution.inventory.common.services.InventoryWriteoffService;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.Window;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 28.06.2004
 * Time: 20:02:34
 * $Id: GoodsWriteoffList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsWriteoffList extends AbstractFinanceDocumentList  {

    public GoodsWriteoffList() throws ApplicationException {
        super(GUIGoodsEnvironment.getResources());
        initialize();
    }

    public GoodsWriteoffList(Window window) throws ApplicationException {
        super(window, GUIGoodsEnvironment.getResources());
        initialize();
    }
    
    
    private void initialize() {
        this.setEntityClass(InventoryWriteoff.class);
        this.setEntityServiceClass(InventoryWriteoffService.class);
        this.setEntityEditFormClass(GoodsWriteoffEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(950, DEFAULT_HEIGHT);
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
        d.setFieldName("currencyDocumentTotal");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);

        return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
        JTable table = super.createTable(model);
        table.getColumn(getString("table.column-currency-amount.name")).setCellRenderer(GUIEnvironment.createCurrencyTableCellRenderer());
        return table;
    }



}
