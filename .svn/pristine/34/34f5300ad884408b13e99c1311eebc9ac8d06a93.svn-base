package org.plazmaforge.framework.core.criteria;


public class InCriteriaFilter extends CriteriaFilter {

    private Object[] values;

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
        setValue(getFirstValue());
    }
    
    protected Object getFirstValue() {
        if (values == null || values.length == 0) {
            setValue(null);
            return null;
        }
        return values[1];
    }
    
    
    public boolean isEmptyValues() {
	return values == null || values.length == 0;
    }
    
    public boolean isFilter(Object inputValue) {
	if (isEmptyValues() && inputValue == null) {
	    return true;
	}
	if (isEmptyValues()) {
	    return false;
	}
	Object v = getValue();
	try {
	    int len = values.length;
	    for (int i = 0; i < len; i++) {
		setValue(values[i]);
		if (isFilterByClause(inputValue)) {
		    return true;
		}
	    }
	} finally {
	    setValue(v);
	}

	return false;
    }
    
    public Object clone() {
	InCriteriaFilter filterItem = new InCriteriaFilter();
	populate(filterItem);
	filterItem.setValues(getValues());
	return filterItem;
    }
}
