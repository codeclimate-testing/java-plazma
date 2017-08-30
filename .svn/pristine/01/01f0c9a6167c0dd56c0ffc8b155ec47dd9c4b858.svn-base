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


import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;
import javax.swing.*;

import org.plazmaforge.bsolution.goods.client.swing.GUIGoodsEnvironment;
import org.plazmaforge.bsolution.goods.client.swing.forms.GoodsEdit;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.services.GoodsService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 23.03.2004
 * Time: 20:27:38
 * $Id: GoodsList.java,v 1.4 2010/12/05 07:56:43 ohapon Exp $
 */
public class GoodsList extends EXTListForm {

    public GoodsList() throws ApplicationException {
	super(GUIGoodsEnvironment.getResources());
	initialize();
    }

    public GoodsList(Window window) throws ApplicationException {
	super(window, GUIGoodsEnvironment.getResources());
	initialize();
    }
	
    private void initialize() {
        this.setEntityClass(Goods.class);
        this.setEntityServiceClass(GoodsService.class);
        this.setEntityEditFormClass(GoodsEdit.class);
    }	

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(750, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-code.name"));
        d.setFieldName("code");
        d.setColumnClass(String.class);
        d.setSize(15);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-name.name"));
        d.setFieldName("name");
        d.setColumnClass(String.class);
        d.setSize(99);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-goods-type-name.name"));
        d.setFieldName("goodsTypeName");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-unit-name.name"));
        d.setFieldName("unitName");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-price.name"));
        d.setFieldName("price");
        d.setColumnClass(Float.class);
        d.setSize(30);
        columns.add(d);

        return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
        JTable table = super.createTable(model);
        TableColumn column = table.getColumnModel().getColumn(4);
        column.setCellRenderer(new CurrencyCellRenderer());
        return table;
    }

}
