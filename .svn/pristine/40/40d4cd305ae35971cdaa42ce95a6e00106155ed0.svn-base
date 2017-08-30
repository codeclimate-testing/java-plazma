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


import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * @author Oleh Hapon
 * Date: 14.11.2003
 * Time: 8:42:01
 */



public class ArrayTableModel extends XAbstractTableModel {


    public ArrayTableModel() {
    }

    public ArrayTableModel(List rows) {
        super(rows);
    }

    public Object getValueAt(int row, int col) {
        Object[] record = (Object[]) getRow(row);
        return getFieldValue(record, col);
    }


    protected Object getFieldValue(Object record, int col) {
        if (record == null) return null;
        Object[] row = (Object[]) record;
        return row[col];

    }


    public void addData(Collection c) {
        _clear();
        if (c == null) return;
        Iterator iter = c.iterator();
        while(iter.hasNext()) {
            _addRow((Object[]) iter.next());
        }
        fireTableDataChanged();
    }


    public void updateData(Object data) throws Exception {
        if (data instanceof Collection) {
            addData((Collection) data);
        }
    }
}
