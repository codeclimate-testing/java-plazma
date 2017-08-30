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

package org.plazmaforge.bsolution.base.client.swing.forms.common;


import javax.swing.*;

import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XIntegerField;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.ext.model.DataType;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created on 25.05.2006
 */
public class DataTypeController {

    private XTextField stringValueField;

    private XIntegerField integerValueField;

    private XNumberField floatValueField;

    private XDateField dateValueField;

    private XDateField dateTimeValueField;

    private JCheckBox booleanValueField;

    private XComboEdit dictionaryValueField;

    private List componentList;

    private Map componentMap;

    private DataType dataType;

    public DataTypeController() {

	stringValueField = new XTextField(20);
	integerValueField = new XIntegerField();
	floatValueField = new XNumberField();
	dateValueField = new XDateField();
	dateTimeValueField = new XDateField();
	booleanValueField = new JCheckBox();
	dictionaryValueField = new XComboEdit();

	componentList = new ArrayList();
	componentList.add(stringValueField);
	componentList.add(integerValueField);
	componentList.add(floatValueField);
	componentList.add(dateValueField);
	componentList.add(dateTimeValueField);
	componentList.add(booleanValueField);
	componentList.add(dictionaryValueField);

	componentMap = new HashMap();
	componentMap.put(DataType.STRING_TYPE, stringValueField);
	componentMap.put(DataType.INTEGER_TYPE, integerValueField);
	componentMap.put(DataType.FLOAT_TYPE, floatValueField);
	componentMap.put(DataType.DATE_TYPE, dateValueField);
	componentMap.put(DataType.DATETIME_TYPE, dateTimeValueField);
	componentMap.put(DataType.BOOLEAN_TYPE, booleanValueField);
	componentMap.put(DataType.REFERENCE_TYPE, dictionaryValueField);

    }

    public List getComponents() {
	return componentList;
    }

    public JComponent getComponent() {
	return getComponentByDataType(getDataType());
    }

    public JComponent getComponentByDataType(DataType dataType) {
	if (dataType == null) {
	    return null;
	}
	String key = dataType.getId();
	if (key != null) {
	    key = key.trim();
	}
	return (JComponent) componentMap.get(key);
    }

    public void invisibleComponents() {
	for (int i = 0; i < componentList.size(); i++) {
	    ((JComponent) componentList.get(i)).setVisible(false);
	}
    }

    public void setDataType(DataType dataType) {
	this.dataType = dataType;
	invisibleComponents();
	JComponent comp = getComponentByDataType(dataType);
	if (comp == null) {
	    return;
	}
	comp.setVisible(true);
    }

    public DataType getDataType() {
	return this.dataType;
    }

    public Object getValue() {
	JComponent comp = this.getComponent();
	if (comp == null) {
	    return null;
	}
	if (comp instanceof XTextField) {
	    return ((XTextField) comp).getText();
	} else if (comp instanceof XIntegerField) {
	    return new Integer(((XIntegerField) comp).intValue());
	} else if (comp instanceof XNumberField) {
	    return new Float(((XNumberField) comp).floatValue());
	} else if (comp instanceof XDateField) {
	    return ((XDateField) comp).getDate();
	} else if (comp instanceof JCheckBox) {
	    return new Boolean(((JCheckBox) comp).isSelected());
	} else if (comp instanceof XComboEdit) {
	    return ((XComboEdit) comp).getValue();
	}
	return null;
    }

    public void setValue(Object value) {
	JComponent comp = this.getComponent();
	if (comp == null) {
	    return;
	}
	if (comp instanceof XTextField) {
	    ((XTextField) comp).setText((String) value);
	} else if (comp instanceof XNumberField) {
	    ((XNumberField) comp).setValue(new Double(((Number) value)
		    .doubleValue()));
	} else if (comp instanceof XDateField) {
	    ((XDateField) comp).setDate((Date) value);
	} else if (comp instanceof JCheckBox) {
	    ((JCheckBox) comp).setSelected(((Boolean) value).booleanValue());
	} else if (comp instanceof XComboEdit) {
	    ((XComboEdit) comp).setValue(value);
	}
    }

    public XComboEdit getDictionaryValueField() {
	return dictionaryValueField;
    }
}
