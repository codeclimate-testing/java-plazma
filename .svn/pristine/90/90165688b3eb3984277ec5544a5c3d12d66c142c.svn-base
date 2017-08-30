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


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.sql.JDBCEnvironment;
import org.plazmaforge.framework.sql.ResultSetReader;
import org.plazmaforge.framework.sql.ResultSetReaderInfo;


/**
 * @author Oleh Hapon
 * Date: 14.11.2003
 * Time: 9:08:30
 */
public class ResultSetTableModel extends ArrayTableModel {

    private int[] columnIndices = null;
	
    private ResultSetReaderInfo readerInfo;

    public ResultSetTableModel() {
        super();
    }

    public ResultSetTableModel(ResultSet rs) throws SQLException {
        super();
        initColumns(rs);
        updateData(rs);
    }

    public ResultSetTableModel(ResultSet rs, int[] rsidx) throws SQLException {
        super();
        this.columnIndices = rsidx;
        initColumns(rs);
        updateData(rs);
    }

    public ResultSetTableModel(ResultSet rs, String[] rscols) throws SQLException {
        super();
        this.columnIndices = createIndex(rs,rscols);
        initColumns(rs);
        updateData(rs);
    }

    private int[] createIndex(ResultSet rs, String[] cols) {
        if (cols == null) return null;
        int[] idx = null;
        try {
            ArrayList list = new ArrayList();
            for(int i=0;i<cols.length;i++) {
                String s = cols[i];
                try {
                    list.add(new Integer(s));
                } catch (NumberFormatException ex) {
                    list.add(new Integer(rs.findColumn(s)));

                }
            }
            if (list.size()>0) {
                idx = new int[list.size()];
                for(int i=0;i<list.size();i++) {
                    int c = ((Integer)list.get(i)).intValue();
                    idx[i] = c;
                }
            }
        } catch (SQLException ex) {
            return null;
        }
        return idx;
    }


    public void initColumns(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();


        int count = columnIndices == null ? meta.getColumnCount(): columnIndices.length;

        ColumnProperty[] cd = new ColumnProperty[count];
        for(int i = 0; i < count; i++) {
            int idx = columnIndices != null ? columnIndices[i] : i + 1;
            ColumnProperty d = new ColumnProperty();
            d.setName(meta.getColumnName(idx));
            d.setColumnClass(JDBCEnvironment.getClass(meta.getColumnType(idx)));
            d.setSize(meta.getColumnDisplaySize(idx));
            cd[i] = d;
        }
        setColumns(cd);
    }

    public void addData(ResultSet rs, boolean isReloadCol) throws SQLException {
        if (isReloadCol) {
            initColumns(rs);
        }
        ResultSetReader reader = new ResultSetReader(rs,getReaderInfo(),columnIndices);
        List list = reader.readData();
        setRows(list);
        //fireTableDataChanged();
    }


    public void addData(ResultSet rs) throws SQLException {
        addData(rs,true);
    }

    public void updateData(ResultSet rs) throws SQLException {
        addData(rs,false);
    }

    public void updateData(Object data ) throws Exception {
        if (data instanceof ResultSet) {
            updateData((ResultSet)data);
        }
    }

    public int[] getColumnIndices() {
        return columnIndices;
    }

    public void setColumnIndices(int[] columnIndices) {
        if (columnIndices != null && columnIndices.length == 0) {
            this.columnIndices = null;
        } else {
            this.columnIndices = columnIndices;
        }

    }

    public void setColumnIndices(ResultSet rs, String[] columnNames) {
        setColumnIndices(createIndex(rs,columnNames));
    }

    public ResultSetReaderInfo getReaderInfo() {
        return readerInfo;
    }

    public void setReaderInfo(ResultSetReaderInfo readerInfo) {
        this.readerInfo = readerInfo;
    }
}
