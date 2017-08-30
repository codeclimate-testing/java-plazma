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

import java.awt.Window;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.finance.client.swing.forms.AbstractFinanceDocumentList;
import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.sale.common.beans.SaleServ;
import org.plazmaforge.bsolution.sale.common.services.SaleServService;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * 
 * @author Oleh Hapon
 * 
 * $Id: ExecWorkList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 *
 */
public class ExecWorkList extends AbstractFinanceDocumentList  {

    public ExecWorkList() throws ApplicationException {
        super(GUIGoodsEnvironment.getResources());
        initialize();
    }

    public ExecWorkList(Window window) throws ApplicationException {
        super(window, GUIGoodsEnvironment.getResources());
        initialize();
    }
    
    
    private void initialize() {
        this.setEntityClass(SaleServ.class);
        this.setEntityServiceClass(SaleServService.class);
        this.setEntityEditFormClass(ExecWorkEdit.class);
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
        d.setName(getString("table.column-partner.name"));
        d.setFieldName("partnerName");
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
        d.setSize(3);
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
