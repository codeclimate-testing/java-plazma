package org.plazmaforge.framework.client.swt.controls;

import java.awt.Toolkit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.swt.widgets.Text;

// [WD]
public abstract class AbstractTextFormatter implements ITextFormatter {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    
    private Class valueClass;
    
    public static final String TEXT_FORMATTER = "TEXT_FORMATTER";
    
    
    /** Exception text for invalid edit masks */
    protected static final String INVALID_PATTERN = "EditMask is invalid : "; //$NON-NLS-1$
    
    /** Exception text for invalid values */
    protected static final String INVALID_VALUE = "Invalid value"; //$NON-NLS-1$
    
    /** Space character */
    protected static final char SPACE = ' ';
    
    /** Empty String */
    protected static final String EMPTY = ""; //$NON-NLS-1$
    
    
    
    protected Text text;
    
    protected boolean ignore;
    
    
    protected void beep() {
	    Toolkit.getDefaultToolkit().beep();
    }
    
    public void detach() {
	
    }
    

    public void setText(Text text) {
        this.text = text;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }
    
    protected void updateText(String str) {
	updateText(str, text.getCaretPosition());
    }
    
    
    protected void updateText(String str, int pos) {
	ignore = true;
        text.setText(str);
        text.setSelection(pos);
        ignore = false;
    }

    public Class getValueClass() {
        return valueClass;
    }

    public void setValueClass(Class valueClass) {
        this.valueClass = valueClass;
    }
    
    public static void initFormatter(Text text, ITextFormatter formatter) {
	if (text == null) {
	    return;
	}
	
	// Detach formatter
	ITextFormatter oldFormatter = getFormatter(text);
	if ( oldFormatter != null ) {
	    text.removeVerifyListener(oldFormatter);
	    oldFormatter.detach();
	    if (formatter != null && formatter.getValueClass() == null) {
		formatter.setValueClass(oldFormatter.getValueClass());
	    }
    	}
	
	// Attach formatter
        setFormatter(text, formatter);
        
        if (formatter == null) {
            return;
        }
        formatter.setText(text);
        
        text.addVerifyListener(formatter);
        formatter.setIgnore(true);
        text.setText(formatter.getDisplayString());
        formatter.setIgnore(false);
    }
    
    
    public static void setValue(Text text, ITextFormatter formatter, Object value) {
	if (text == null || formatter == null) {
	    return;
	}
        formatter.setValue(value);
        formatter.setIgnore(true);
        String strValue = text.isFocusControl() ? formatter.getEditString() : formatter.getDisplayString();
        text.setText(strValue);
        formatter.setIgnore(false);
    }
    
    public static void setValue(Text text, Object value) {
	ITextFormatter formatter = getFormatter(text);
	setValue(text, formatter, value);
    }
    
    public static Object getValue(Text text) {
	ITextFormatter formatter = getFormatter(text);
	return formatter == null ? null : formatter.getValue();
    }
    

    public static ITextFormatter getFormatter(Text text) {
	return text == null ? null : (ITextFormatter) text.getData(TEXT_FORMATTER); 
    }
    
    public static void setFormatter(Text text, ITextFormatter formatter) {
	text.setData(TEXT_FORMATTER, formatter); 
    }

}
