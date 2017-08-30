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

/*
 * Create on 24.04.2006
 */

package org.plazmaforge.framework.report.engine.jasperreports;

import java.util.HashMap;

import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;

public class TableDataSource implements JRRewindableDataSource {

    private TableModel tableModel = null;

    private int index = -1;

    private HashMap columnNames = new HashMap();

    public TableDataSource(TableModel model) {
	this.tableModel = model;

	if (this.tableModel == null) {
	    return;
	}
	for (int i = 0; i < tableModel.getColumnCount(); i++) {
	    this.columnNames.put("COLUMN_" + i, new Integer(i));
	}
    }

    public boolean next() throws JRException {
	this.index++;
	if (this.tableModel == null) {
	    return false;
	}
	return (this.index < this.tableModel.getRowCount());
    }

    public Object getFieldValue(JRField jrField) throws JRException {
	String fieldName = jrField.getName();

	Integer columnIndex = (Integer) this.columnNames.get(fieldName);

	if (columnIndex != null) {
	    return this.tableModel.getValueAt(index, columnIndex.intValue());
	} else if (fieldName.startsWith("COLUMN_")) {
	    return this.tableModel.getValueAt(index, Integer.parseInt(fieldName
		    .substring(7)));
	} else {
	    throw new JRException("Unknown column name : " + fieldName);
	}
    }

    public void moveFirst() throws JRException {
	this.index = -1;
    }

}
