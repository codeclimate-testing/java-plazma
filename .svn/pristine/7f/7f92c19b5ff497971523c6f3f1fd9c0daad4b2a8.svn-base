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
 * Created on 10.08.2007
 *
 */

package org.plazmaforge.framework.core.criteria;

import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 * $Id: CriteriaFilter.java,v 1.1 2010/12/05 07:51:26 ohapon Exp $
 */

public class CriteriaFilter  extends CriteriaElement implements ICriteriaFilter {

    private String operator = ICriteria.AND;
    
    private String clause = ICriteria.EQ;
    
    private Object value;
    
    
    private Class valueClass;
    
    private String valueString;

    private String likeRegex; // ONLY FOR LIKE clause 

    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
        this.likeRegex = ICriteria.LIKE.equals(clause) ? normalizeLikeRegex() : null;
    }
    
    
    public Class getValueClass() {
        return valueClass;
    }

    public void setValueClass(Class valueClass) {
        this.valueClass = valueClass;
    }
    
    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }
        
    
    public boolean isEmpty() {
	return getValue() == null;
    }
    
    public boolean isFilter(Object inputValue) {
	if (value == null && inputValue == null) {
	    return true;
	}
	if (value == null) {
	    return false;
	}
	return isFilterByClause(inputValue);
    }
    
    protected boolean isFilterByClause(Object inputValue) {
	if (ICriteria.EQ.equals(clause)) {
	    return isEQ(inputValue);
	    
	} else if (ICriteria.NEQ.equals(clause)) {
	    return isNEQ(inputValue);
	    
	} else if (ICriteria.LIKE.equals(clause)) {
	    return isLIKE(inputValue);
	    
	} else if (ICriteria.NOTLIKE.equals(clause)) {
	    return isNOTLIKE(inputValue);
	    
	} else if (ICriteria.LT.equals(clause)) {
	    return isLT(inputValue);
	    
	} else if (ICriteria.LTE.equals(clause)) {
	    return isLTE(inputValue);
	    
	} else if (ICriteria.GT.equals(clause)) {
	    return isGT(inputValue);
	    
	} else if (ICriteria.GTE.equals(clause)) {
	    return isGTE(inputValue);
	}
	
	// Default
	return isEQ(inputValue);
    }
    
    protected boolean isEQ(Object inputValue) {
	return value.equals(inputValue);
    }
    
    protected boolean isNEQ(Object inputValue) {
	return !isEQ(inputValue);
    }
    
    protected boolean isLIKE(Object inputValue) {
	if (inputValue == null) {
	    return false;
	}
	if (inputValue instanceof String) {
	    return isLIKEString((String) inputValue);
	}
	return isEQ(inputValue);
    }
    
    protected boolean isLIKEString(String inputValue) {
	if (likeRegex == null) {
	    return false;
	}
	return StringUtils.likeRegex(inputValue, likeRegex.toString());
    }
    
    

    protected boolean isNOTLIKE(Object inputValue) {
	return !isLIKE(inputValue);
    }
    
    protected boolean isLT(Object inputValue) {
	if (!isComparableValue()) {
	    return false;
	}
	if (!isComparableValue(inputValue)) {
	    return true;
	}
	int result = compareValue(inputValue);
	return result == 1;
    }

    protected boolean isLTE(Object inputValue) {
	if (isEQ(inputValue)) {
	    return true;
	}
	return isLT(inputValue);
    }
    
    protected boolean isGT(Object inputValue) {
	if (!isComparableValue()) {
	    return false;
	}
	if (!isComparableValue(inputValue)) {
	    return true;
	}
	int result = compareValue(inputValue);
	return result == -1;
    }

    protected boolean isGTE(Object inputValue) {
	if (isEQ(inputValue)) {
	    return true;
	}
	return isGT(inputValue);
    }
    
    
    
    //
    protected boolean isComparableValue() {
	return isComparableValue(getValue());
    }
    
    protected boolean isComparableValue(Object inputValue) {
	return inputValue != null && inputValue instanceof Comparable;
    }
    
    protected Comparable getComparableValue() {
	return (Comparable) getValue();
    }
    
    protected Comparable getComparableValue(Object inputValue) {
	return (Comparable) inputValue;
    }

    protected int compareValue(Object inputValue) {
	return getComparableValue().compareTo(getComparableValue(inputValue));
    }

    public Object clone() {
	ICriteriaFilter filterItem = new CriteriaFilter();
	populate(filterItem);
	return filterItem;

    }
    
    public void populate(ICriteriaFilter filterItem) {
	filterItem.setOperator(getOperator());
	filterItem.setClause(getClause());
	filterItem.setValueClass(getValueClass());
	filterItem.setValueString(getValueString());
	filterItem.setValue(getValue());
	filterItem.setField(getField());
    }
    
    private String normalizeLikeRegex() {
	return value == null ? null : StringUtils.normalizeLikeRegex(value.toString(), "*", null, true);
    }
}
