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

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Oleh Hapon
 * Date: 18.01.2004
 * Time: 13:53:00
 * $Id: SortableTableModel.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class SortableTableModel extends AbstractTableModel {


    private MyTableModelListener actualModelListener = new MyTableModelListener();

    protected int iColumn = -1;

    protected boolean bAscending;

    private TableModel actualModel;

    public TableModel getActualModel() {
        return actualModel;
    }

    private Integer[] indexes = new Integer[0];

    public SortableTableModel() {
        this(null);
    }

    public SortableTableModel(TableModel model) {
        super();
        setActualModel(model);
    }

    public void setActualModel(TableModel newModel) {
        if (actualModel != null) {
            actualModel.removeTableModelListener(actualModelListener);
        }
        actualModel = newModel;
        if (actualModel != null) {
            actualModel.addTableModelListener(actualModelListener);
        }
    }

    public int getRowCount() {
        return actualModel != null ? actualModel.getRowCount() : 0;
    }

    public int getColumnCount() {
        return actualModel != null ? actualModel.getColumnCount() : 0;
    }

    public Object getValueAt(int row, int col) {
        return actualModel.getValueAt(indexes[row].intValue(), col);
    }

    public void setValueAt(Object value, int row, int col) {
        actualModel.setValueAt(value, indexes[row].intValue(), col);
    }

    public String getColumnName(int col) {
        return actualModel.getColumnName(col);
    }

    public Class getColumnClass(int col) {
        return actualModel.getColumnClass(col);
    }

    public boolean isCellEditable(int row, int col) {
        return actualModel.isCellEditable(row,col);
    }

    public boolean sortByColumn(int column) {
        boolean b = true;
        if (column == iColumn) {
            b = !bAscending;
        }
        sortByColumn(column, b);
        return b;
    }

    public void sortByColumn(int column, boolean ascending) {
        iColumn = column;
        bAscending = ascending;
        TableModelComparator comparator =
            new TableModelComparator(column, ascending);
        Arrays.sort(indexes, comparator);
        fireTableDataChanged();
    }

    class TableModelComparator implements Comparator {
        private int _iColumn;
        private int _iAscending;

        public TableModelComparator(int iColumn) {
            this(iColumn, true);
        }

        public TableModelComparator(int iColumn, boolean ascending)  {
            _iColumn = iColumn;
            if (ascending) {
                _iAscending = 1;
            } else {
                _iAscending = -1;
            }
        }

 
        public int compare(Object o1, Object o2) {
            final Integer i1 = (Integer)o1;
            final Integer i2 = (Integer)o2;

            final Object data1 = actualModel.getValueAt(i1.intValue(), _iColumn);
            final Object data2 = actualModel.getValueAt(i2.intValue(), _iColumn);
            try {
                if (data1 == null && data2 == null) {
                    return 0;
                } if (data1 == null) {
                    return 1 * _iAscending;
                } if (data2 == null) {
                    return -1 * _iAscending;
                }
                Comparable c1 = (Comparable)data1;
                return c1.compareTo(data2) * _iAscending;
            } catch (ClassCastException ex) {
                return data1.toString().compareTo(data2.toString()) * _iAscending;
            }
        }

    }

    protected class MyTableModelListener implements TableModelListener {
        public void tableChanged(TableModelEvent evt) {
            indexes = new Integer[getRowCount()];
            for (int i = 0; i < indexes.length; ++i) {
                indexes[i] = new Integer(i);
            }
        }
    }



}
