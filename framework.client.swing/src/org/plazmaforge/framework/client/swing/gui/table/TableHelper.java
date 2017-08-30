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


import javax.swing.table.TableModel;
import javax.swing.*;

import org.plazmaforge.framework.util.ObjectCreator;

import java.util.List;
import java.util.ArrayList;

/**
 * Created on 01.06.2006
 */
public class TableHelper {

    public int findRowByTextFields(TableModel model, List fields) {
	List stringValues = createValuesByTextFields(fields);
	List criteria = createCriteriaByValues(model, stringValues);
	return findRowByCriteria(model, criteria);
    }

    public int findRowByCriteria(TableModel model, List criteria) {

	int findRow = -1;
	int count = model.getRowCount();

	for (int row = 0; row < count; row++) {

	    boolean isBreakColumn = false;
	    for (int j = 0; j < criteria.size(); j++) {

		ColumnParameter parameter = (ColumnParameter) criteria.get(j);
		int col = parameter.getColumnIndex();
		Object originalValue = model.getValueAt(row, col);

		if (!isFound(parameter, originalValue)) {
		    isBreakColumn = true;
		    break; // Break analize column
		}
	    }

	    if (!isBreakColumn) {
		findRow = row;
		break; // Break analize row
	    }
	}

	return findRow;

    }

    public boolean isFound(ColumnParameter parameter, Object originalValue) {

	if (originalValue == null || parameter == null
		|| parameter.getValue() == null) {
	    return false;
	}

	Object findValue = parameter.getValue();

	if (parameter.isForceStringType()) {
	    return findValue.toString().equals(originalValue.toString());
	} else {
	    return findValue.equals(originalValue);
	}
    }

    public List createValuesByTextFields(List fields) {
	ArrayList values = new ArrayList();
	JTextField field = null;
	for (int i = 0; i < fields.size(); i++) {
	    field = (JTextField) fields.get(i);
	    String text = field.getText().trim();
	    values.add(text);
	}

	return values;
    }

    public List createCriteriaByFields(TableModel model, List fields) {
	List stringValues = createValuesByTextFields(fields);
	return createCriteriaByValues(model, stringValues);
    }

    public List createCriteriaByValues(TableModel model, List values) {
	ObjectCreator creator = new ObjectCreator();
	List criteria = new ArrayList();

	ColumnProperty[] columnProperty = null;
	if (model instanceof StateTableModel) {
	    StateTableModel stateTableModel = (StateTableModel) model;
	    columnProperty = stateTableModel.getColumns();
	}

	for (int i = 0; i < values.size(); i++) {

	    Class klass = model.getColumnClass(i);
	    if (klass == null) {
		continue;
	    }

	    String str = (String) values.get(i);
	    if ("".equals(str)) {
		continue;
	    }

	    ObjectCreator.ObjectValue objectValue = creator
		    .createObjectValueByString(klass, str);
	    if (objectValue == null || objectValue.getValue() == null) {
		continue;
	    }
	    ColumnParameter parameter = new ColumnParameter();
	    parameter.setValue(objectValue.getValue());
	    parameter.setForceStringType(objectValue.isForceStringType());

	    if (columnProperty != null) {
		parameter.setColumnName(columnProperty[i].getFieldName());
	    }
	    parameter.setColumnIndex(i);

	    criteria.add(parameter);

	}

	return criteria;
    }

}
