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


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.plazmaforge.framework.core.data.WrapEntityBean;
import org.plazmaforge.framework.ext.model.Statable;



/**
 * @author Oleh Hapon
 * Date: 25.6.2003
 * Time: 12:05:53
 */
public abstract class AbstractStateTableModel extends XAbstractTableModel implements StateTableModel {

    public AbstractStateTableModel() {
        super();
    }

    public Object getRowObject(int rowIndex) {
        Object obj = getRow(rowIndex);
        if (obj instanceof WrapEntityBean) {
            return ((WrapEntityBean)obj).getData();
        }
        return obj;
    }

    protected Object _rowObject(int rowIndex) {
        Object obj = _row(rowIndex);
        if (obj instanceof WrapEntityBean) {
            return ((WrapEntityBean)obj).getData();
        }
        return obj;
    }


    protected void _addRow(Object data) {
        if (data instanceof Statable) {
            super._addRow(data);
        } else {
            WrapEntityBean row = new WrapEntityBean(data);
            super._addRow(row);
        }
    }

    public void addRow(Object data) {
        if (data instanceof Statable) {
            super.addRow(data);
        } else {
            WrapEntityBean row = new WrapEntityBean(data);
            super.addRow(row);
        }
    }

    public void setRow(int index, Object data) {
        if (data instanceof Statable) {
            super.setRow(index, data);
        } else {
            WrapEntityBean row = new WrapEntityBean(data);
            super.setRow(index, row);
        }
    }
	
    public void addDataCollection(Collection c) {
        _clear();
        if (c == null) return;
        Iterator iter = c.iterator();
        while(iter.hasNext()) {
            _addRow(iter.next());
        }
        fireTableDataChanged();
    }


    public void addData(List list) {
        setRows(list);
    }



    /**
     * @return list
     */
    public List getRowObjects() {
        int count = getRowCount();
        if (count < 1) return null;
        ArrayList list = new ArrayList();
        for(int i = 0; i < count; i++) {
            list.add(getRowObject(i));
        }
        return list;
    }


    public Object getRowID(int rowIndex) {
        return getStateData(rowIndex).getId();
    }


    // Implementation interface StateTableModel

    protected Statable _stateData(int rowIndex) {
        return ((Statable) _row(rowIndex));
    }

    public Statable getStateData(int rowIndex) {
        return ((Statable) getRow(rowIndex));
    }

    public boolean isNormalRow(int rowIndex) {
        return getStateData(rowIndex).isNormal();
    }

    public boolean isModifiedRow(int rowIndex) {
        return getStateData(rowIndex).isModified();
    }

    public boolean isDeletedRow(int rowIndex) {
        return getStateData(rowIndex).isDeleted();
    }

    public boolean isCreatedRow(int rowIndex) {
        return getStateData(rowIndex).isCreated();
    }


    public void setNormalRow(int rowIndex) {
        getStateData(rowIndex).setNormal();
    }

    public void setModifiedRow(int rowIndex) {
        getStateData(rowIndex).setModified();
    }

    public void setDeletedRow(int rowIndex) {
        getStateData(rowIndex).setDeleted();
    }

    public void setCreatedRow(int rowIndex) {
        getStateData(rowIndex).setCreated();
    }

    public void updateData(Object data) throws Exception {
        if (data instanceof Collection) {
            addDataCollection((Collection) data);
        } else if (data instanceof List) {
            addData((List) data);
        }
    }


    protected int[] createIndexes() {
        if (_rows() == null) return new int[0];

        int count =_rows().size();
        ArrayList list = new ArrayList();
        for (int i = 0; i < count; ++i) {
            Statable data = _stateData(i);
            //if (data == null || !data.isDeleted()) {
            if (data == null || isViewRecord(data)) {
                list.add(new Integer(i));
            }
        }
        if (list.size() == 0) return new int[0];
        count = list.size();
        int[] ind = new int[count];
        for(int i = 0; i < count; i++) {
            ind[i] = ((Integer) list.get(i)).intValue();
        }
        return ind;
    }

    private List staticFilterCriteria;

    private List filterCriteria;

    private TableHelper tableHelper = new TableHelper();



    public List getStaticFilterCriteria() {
        return staticFilterCriteria;
    }

    public List getFilterCriteria() {
        return filterCriteria;
    }

    public void addStaticCriteria(ColumnParameter parameter) {
        if (staticFilterCriteria == null) {
            staticFilterCriteria = new ArrayList();
        }
        staticFilterCriteria.add(parameter);
    }

    public void addCriteria(ColumnParameter parameter) {
        if (filterCriteria == null) {
            filterCriteria = new ArrayList();
        }
        filterCriteria.add(parameter);
    }

    public void clearCriteria() {
        if (filterCriteria == null) {
            return;
        }
        filterCriteria.clear();
        filterCriteria = null;
    }

    public boolean isStaticFilterMode() {
        return  staticFilterCriteria != null && staticFilterCriteria.size() > 0;
    }

    public boolean isFilterMode() {
        return  filterCriteria != null && filterCriteria.size() > 0;
    }

    public boolean isFullFilterMode() {
        return  isFilterMode() || isStaticFilterMode();
    }

    protected boolean isViewRecord(Statable data) {
        return !data.isDeleted() && isViewRecordByCriteria(getStaticFilterCriteria(), data) && isViewRecordByCriteria(getFilterCriteria(), data);
    }

    protected boolean isViewRecordByCriteria(List criteria, Statable data) {
        if (criteria == null || data == null) {
            return true;
        }
        for (int i = 0; i < criteria.size(); i++) {
            ColumnParameter parameter = (ColumnParameter) criteria.get(i);
           if (!isFound(parameter, data)) {
              return false;
           }
        }
        return true;
    }

    protected boolean isFound(ColumnParameter parameter, Object data) {
        Object originalValue = getFindValue(parameter, data);
        return tableHelper.isFound(parameter, originalValue);
    }

    protected Object getFindValue(ColumnParameter parameter, Object data) {
        return null;
    }

}
