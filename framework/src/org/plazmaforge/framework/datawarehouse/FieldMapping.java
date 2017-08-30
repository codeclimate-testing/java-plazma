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

package org.plazmaforge.framework.datawarehouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.util.StringUtils;

public class FieldMapping implements Serializable, Cloneable {

    /**
     * Field result type
     */
    public static final int FIELD_RESULT_TYPE = 1;
    
    /**
     * Value result type
     */
    public static final int VALUE_RESULT_TYPE = 2;
    
    /**
     * Expression result type
     */
    public static final int EXPRESSION_RESULT_TYPE = 3;
    
    
    /**
     * Result type: FIELD_RESULT_TYPE/VALUE_RESULT_TYPE/EXPRESSION_RESULT_TYPE
     */
    private int resultType = FIELD_RESULT_TYPE;
    
    /**
     * Source Field
     */
    private DSField sourceField;
    
    
    /**
     * Target Field
     */
    private DSField targetField;
    
    
    /**
     * Value (Only for VALUE_RESULT_TYPE and EXPRESSION_RESULT_TYPE)
     */
    private Object value;
    
    
    
    private IExpressionCalculator expressionCalculator;
    
    
    /**
     * Unique key flag (May be not primary key)
     */
    private boolean key;
    

    public int getResultType() {
	if (resultType < 1 || resultType > 3) {
	    resultType = FIELD_RESULT_TYPE;
	}
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public DSField getSourceField() {
        return sourceField;
    }

    public DSField getTargetField() {
        return targetField;
    }

    public String getTargetFieldName() {
	return targetField == null ? null : targetField.getName();
    }
    
    public String getTargetFieldDisplayName() {
	return targetField == null ? null : targetField.getDisplayName();
    }
    
  
    
    public String getTargetFieldType() {
        return targetField ==  null  ? null : targetField.getDataType();
    }
    ////

    public void setSourceField(DSField sourceField) {
        this.sourceField = sourceField;
    }

    public void setTargetField(DSField targetField) {
        this.targetField = targetField;
    }

    public String getSourceFieldName() {
	return sourceField == null ? null : sourceField.getName();
    }
    
    public String getSourceFieldDisplayName() {
	return sourceField == null ? null : sourceField.getDisplayName();
    }

    
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    
    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    /**
     * Return true if field result type
     * @return
     */
    public boolean isFieldResultType() {
	return getResultType() == FIELD_RESULT_TYPE;
    }
    
    /**
     * Return true if value result type
     * @return
     */
    public boolean isValueResultType() {
	return getResultType() == VALUE_RESULT_TYPE;
    }

    /**
     * Return true if expression result type
     * @return
     */
    public boolean isExpressionResultType() {
	return getResultType() == EXPRESSION_RESULT_TYPE;
    }

    /**
     * Return expression
     * @return
     */
    public String getExpression() {
	if (!isExpressionResultType()) {
	    return null;
	}
	return getValue() == null ? null : getValue().toString();
    }
    
    /**
     * Normalize mapping list
     * Remove invalid items  
     * @param mapping
     * @return
     */
    public static List<FieldMapping> normalizeMapping(List<FieldMapping> mapping) {
	List<FieldMapping> normalizeMapping = new ArrayList<FieldMapping>();
	if (mapping == null) {
	    return normalizeMapping;
	}
	for (FieldMapping cm : mapping) {
	    if (!isValid(cm)) {
		continue;
	    }
	    normalizeMapping.add(cm);
	}
	return normalizeMapping;
    }

    public static boolean isValid(List<FieldMapping> mapping) {
	
	// Empty mapping is not valid
	if (mapping == null || mapping.isEmpty()) {
	    return false;
	}
	int invalidCount = 0;
	for (FieldMapping cm : mapping) {
	    if (!isValid(cm)) {
		invalidCount++;
	    }
	}
	return invalidCount < mapping.size();
    }

    public static boolean isValid(FieldMapping cm) {
	if (cm == null) {
	    return false;
	}
	return cm.isValid();
    }
    
    public boolean isValid() {
	if (isEmpty(getTargetFieldName())) {
	    return false;
	}
	if (getTargetFieldType() == null) {
	    return false;
	}
	
	if (getResultType() == FIELD_RESULT_TYPE) {
	    if (isEmpty(getSourceFieldName())) {
		return false;
	    }
	} else if (getResultType() == EXPRESSION_RESULT_TYPE) {
	    if (getExpression() == null && getExpressionCalculator() == null) {
		return false;
	    }
	}
	return true;
    }
    
    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }
    
    public Object clone() {
	FieldMapping fieldMapping = new FieldMapping();
	fieldMapping.setResultType(resultType);
	fieldMapping.setSourceField(sourceField == null ? null : (DSField) sourceField.clone());
	fieldMapping.setTargetField(targetField == null ? null : (DSField) targetField.clone());
	fieldMapping.setKey(key);
	fieldMapping.setValue(value);
	return fieldMapping;
    }

    public IExpressionCalculator getExpressionCalculator() {
        return expressionCalculator;
    }

    public void setExpressionCalculator(IExpressionCalculator expressionCalculator) {
        this.expressionCalculator = expressionCalculator;
    }
    
    
}
