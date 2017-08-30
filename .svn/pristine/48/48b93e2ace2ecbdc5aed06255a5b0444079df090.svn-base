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
package org.plazmaforge.framework.client.swing.gui.table;

import java.util.StringTokenizer;
import java.util.ArrayList;


/**
 * @author Oleh Hapon
 * Date: 04.01.2004
 * Time: 9:49:50
 */
public class StringTokenizerTableModel extends ArrayTableModel {

    public StringTokenizerTableModel() {
        super();
    }

    public StringTokenizerTableModel(StringTokenizer tk, String colName) {
        super();
        initColumns(colName);
        updateData(tk);
    }

    public void initColumns(String colName) {
        ColumnProperty[] cd = new ColumnProperty[1];
        ColumnProperty d = new ColumnProperty();
        d.setName(colName);
        d.setColumnClass(String.class);
        d.setSize(ColumnProperty.MAX_COLUMN_WIDTH);

        cd[0] = d;
        setColumns(cd);
    }


    public void addData(StringTokenizer tk, String colName) {
        if (colName != null) {
            initColumns(colName);
        }
        clear();
        ArrayList rows = new ArrayList();
        while(tk.hasMoreTokens()) {
            String[] r = new String[1];
            r[0] = tk.nextToken();
            rows.add(r);
        }
        if (rows.size()>0) {
            setRows(rows);
        } else {
            setRows(null);
        }
        //fireTableDataChanged();
    }

    public void updateData(StringTokenizer tk) {
        addData(tk, null);
    }

    public void updateData(Object data) throws Exception {
        if (data instanceof StringTokenizer) {
            updateData((StringTokenizer)data);
        }
    }

}
