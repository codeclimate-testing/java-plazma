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
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Oleh Hapon Date: 14.11.2003 Time: 8:34:51
 */

/**
 * This Abstract class implements interface <code>TableModel</code>
 */
public abstract class XAbstractTableModel extends AbstractTableModel {

    private List rows;

    protected ColumnProperty[] columns;

    private int columnCount;

    private int[] indexes = new int[0];

    private List sortParameters;

    private MyTableModelListener listener = new MyTableModelListener();

    public XAbstractTableModel() {
	addTableModelListener(listener);
	setRows(new ArrayList());
    }

    public XAbstractTableModel(List rows) {
	addTableModelListener(listener);
	setRows(rows);
    }

    public int getColumnCount() {
	return columns == null ? columnCount : columns.length;
    }

    public void setColumnCount(int columnCount) {
	this.columnCount = columnCount;
    }

    public int getRowCount() {
	return rows == null || indexes == null ? 0 : indexes.length;
    }

    public String getColumnName(int column) {
	String name = super.getColumnName(column);
	if (columns != null && column < columns.length) {
	    name = columns[column].getName();
	}
	return name;
    }

    public Class getColumnClass(int column) {
	Class klass = super.getColumnClass(column);
	if (columns != null && column < columns.length
		&& columns[column].getColumnClass() != null) {
	    klass = columns[column].getColumnClass();
	}
	return klass;
    }

    public Object getRow(int row) {
	return (rows == null || indexes == null) ? null : rows
		.get(indexes[row]);
    }

    protected Object _row(int row) {
	return (rows == null) ? null : rows.get(row);
    }

    protected List _rows() {
	return rows;
    }

    protected void setRows(List rows) {
	this.rows = rows;
	fireTableDataChanged();
    }

    public ColumnProperty[] getColumns() {
	return columns;
    }

    public void setColumns(ColumnProperty[] columns) {
	this.columns = columns;
    }

    protected int[] _createIndexes() {
	if (rows == null)
	    return new int[0];
	int[] ind = new int[rows.size()];
	for (int i = 0; i < ind.length; ++i) {
	    ind[i] = i;
	}
	return ind;
    }

    /**
     * Create new indexes. Clear sorting
     * 
     * @return
     */
    protected int[] createIndexes() {
	int[] ind = _createIndexes();
	return ind;
    }

    protected class MyTableModelListener implements TableModelListener {
	public void tableChanged(TableModelEvent evt) {
	    if (!isChangeIndexes) {
		indexes = createIndexes();
		sort();
	    }
	    isChangeIndexes = false;
	}
    }

    protected void _clear() {
	if (rows != null)
	    rows.clear();
    }

    protected void _removeRow(int row) {
	if (rows != null)
	    rows.remove(row);
    }

    protected void _addRow(int index, Object value) {
	if (rows != null)
	    rows.add(index, value);
    }

    protected void _addRow(Object value) {
	if (rows != null)
	    rows.add(value);
    }

    protected void _setRow(int index, Object value) {
	if (rows != null)
	    rows.set(index, value);
    }

    public void clear() {
	_clear();
	fireTableDataChanged();
    }

    public void removeRow(int row) {
	_removeRow(row);
	fireTableDataChanged();
	// fireTableRowsDeleted(row, row);
    }

    public void addRow(int row, Object value) {
	_addRow(row, value);
	fireTableDataChanged();
	// fireTableRowsInserted(row, row);
    }

    public void addRow(Object value) {
	_addRow(value);
	fireTableDataChanged();
    }

    public void setRow(int row, Object value) {
	_setRow(row, value);
	fireTableDataChanged();
    }

    public int[] getIndexes() {
	return indexes;
    }

    protected abstract Object getFieldValue(Object record, int col);

    protected Object _valueAt(int row, int col) {
	Object record = _row(row);
	return getFieldValue(record, col);
    }

    public abstract void updateData(Object data) throws Exception;

    public boolean sortByColumn(int column) {
	boolean b = true;
	SortParameter sortParameter = getSortParameter();
	if (column == sortParameter.getColumnIndex()) {
	    b = !sortParameter.isAscending();
	}
	sortByColumn(column, b);
	return b;
    }

    public void sortByColumn(int column, boolean ascending) {
	SortParameter sortParameter = null;
	if (getSortParameters().size() == 1) {
	    sortParameter = (SortParameter) getSortParameters().get(0);
	    sortParameter.setColumnIndex(column);
	    sortParameter.setAscending(ascending);
	    sort();
	} else {
	    List prms = new ArrayList();
	    sortParameter = new SortParameter();
	    sortParameter.setColumnIndex(column);
	    sortParameter.setAscending(ascending);
	    prms.add(sortParameter);
	    sort(prms);
	}

    }

    public void sort(List sortParameters) {
	setSortParameters(sortParameters);
	sort();
    }

    protected boolean isChangeIndexes;

    public void sort() {
	if (!isSort()) {
	    return;
	}
	SortParameter[] sortPrms = (SortParameter[]) getSortParameters()
		.toArray(new SortParameter[0]);
	TableModelComparator comparator = new TableModelComparator(sortPrms);

	// This is a must if sorting is done in a thread! ??
	Integer[] ind = new Integer[indexes.length];
	for (int i = 0; i < indexes.length; i++) {
	    ind[i] = new Integer(indexes[i]);
	}
	Arrays.sort(ind, comparator);

	for (int i = 0; i < indexes.length; i++) {
	    indexes[i] = ind[i].intValue();
	}
	isChangeIndexes = true;
    }

    private class TableModelComparator implements Comparator {

	private SortParameter[] sortPrms;

	public TableModelComparator(SortParameter[] sortPrms) {
	    this.sortPrms = sortPrms;
	}

	public int compare(Object o1, Object o2) {
	    final Integer i1 = (Integer) o1;
	    final Integer i2 = (Integer) o2;

	    for (int i = 0; i < sortPrms.length; i++) {
		int columnIndex = sortPrms[i].getColumnIndex();
		int intAscending = sortPrms[i].intAscending();
		final Object data1 = _valueAt(i1.intValue(), columnIndex);
		final Object data2 = _valueAt(i2.intValue(), columnIndex);
		int val = compareValue(data1, data2, intAscending);
		if (val != 0) {
		    return val;
		}
	    }
	    return 0;

	}

	private int compareValue(Object data1, Object data2, int _iAscending) {
	    try {
		if (data1 == null && data2 == null) {
		    return 0;
		}
		if (data1 == null) {
		    return 1 * _iAscending;
		}
		if (data2 == null) {
		    return -1 * _iAscending;
		}
		Comparable c1 = (Comparable) data1;
		return c1.compareTo(data2) * _iAscending;
	    } catch (ClassCastException ex) {
		return data1.toString().compareTo(data2.toString())
			* _iAscending;
	    }
	}

    }

    public int indexOfRow(Object obj) {
	if (rows == null)
	    return -1;
	return rows.indexOf(obj);
    }

    public SortParameter getSortParameter() {
	List parameters = getSortParameters();
	if (parameters.size() == 0) {
	    parameters.add(new SortParameter());
	}
	return (SortParameter) parameters.get(0);
    }

    public List getSortParameters() {
	if (sortParameters == null) {
	    sortParameters = new ArrayList();
	}
	return sortParameters;
    }

    public void setSortParameters(List sortParameters) {
	this.sortParameters = sortParameters;
    }

    public boolean isSortAscending() {
	return getSortParameter().isAscending();
    }

    public int getSortColumnIndex() {
	return getSortParameter().getColumnIndex();
    }

    public boolean isSort() {
	if (sortParameters == null || sortParameters.size() == 0) {
	    return false;
	}
	if (sortParameters.size() == 1) {
	    return ((SortParameter) sortParameters.get(0)).getColumnIndex() > -1;
	}
	return true;
    }

    public boolean isSingleSort() {
	return sortParameters != null
		&& sortParameters.size() == 1
		&& ((SortParameter) sortParameters.get(0)).getColumnIndex() > -1;
    }
}
