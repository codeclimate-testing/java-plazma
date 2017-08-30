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

package org.plazmaforge.framework.core.data;


import java.util.Date;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.model.DataType;
import org.plazmaforge.framework.ext.model.Dictionary;
import org.plazmaforge.framework.ext.model.IValueHolder;
import org.plazmaforge.framework.ext.model.ValueHolder;


public class Variable extends Dictionary implements IValueHolder {



    private IValueHolder valueHolder = new ValueHolder();

    private boolean enable;

    
    public IValueHolder getValueHolder() {
        return valueHolder;
    }

    public String getStringValue() {
	return getValueHolder().getStringValue();
    }

    public void setStringValue(String stringValue) {
	getValueHolder().setStringValue(stringValue);
    }

    public Integer getIntegerValue() {
	return getValueHolder().getIntegerValue();
    }

    public void setIntegerValue(Integer integerValue) {
	getValueHolder().setIntegerValue(integerValue);
    }

    public Float getFloatValue() {
	return getValueHolder().getFloatValue();
    }

    public void setFloatValue(Float floatValue) {
	getValueHolder().setFloatValue(floatValue);
    }

    public Date getDateValue() {
	return getValueHolder().getDateValue();
    }

    public void setDateValue(Date dateValue) {
	getValueHolder().setDateValue(dateValue);
    }

    public Date getDateTimeValue() {
	return getValueHolder().getDateTimeValue();
    }

    public void setDateTimeValue(Date dateTimeValue) {
	getValueHolder().setDateTimeValue(dateTimeValue);
    }

    public Boolean getBooleanValue() {
	return getValueHolder().getBooleanValue();
    }

    public void setBooleanValue(Boolean booleanValue) {
	getValueHolder().setBooleanValue(booleanValue);
    }

    public IEntityConfig getValueEntity() {
	return getValueHolder().getValueEntity();
    }

    public void setValueEntity(IEntityConfig dictionaryEntity) {
	getValueHolder().setValueEntity(dictionaryEntity);
    }

    public DataType getDataType() {
	return getValueHolder().getDataType();
    }

    public void setDataType(DataType dataType) {
	getValueHolder().setDataType(dataType);
    }

    public void clearValues() {
	getValueHolder().clearValues();
    }

    public Object getValue() {
	return getValueHolder().getValue();
    }

    public void setValue(Object value) {
	getValueHolder().setValue(value);
    }

    public void setExpression(String exp) {
	getValueHolder().setExpression(exp);
    }

    public String getExpression() {
	return getValueHolder().getExpression();
    }

    public boolean isReference() {
	return getValueHolder().isReference();
    }

    public Object getDisplayValue() {
	return getValueHolder().getDisplayValue();
    }
    
    public String getStringDisplayValue() {
	return getValueHolder().getStringDisplayValue();
    }
    
    
    public boolean isEnable() {
	return enable;
    }

    public void setEnable(boolean enable) {
	this.enable = enable;
    }

}
