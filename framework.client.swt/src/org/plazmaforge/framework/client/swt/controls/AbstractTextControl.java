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

package org.plazmaforge.framework.client.swt.controls;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.framework.client.Environment;

/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractTextControl extends AbstractControl<Text> implements ISWTTextControl  {

    /**
     * The Control
     */
    protected Text text;
    
    private boolean trimText = true;
    
    private boolean isEditableText = true;
    
    public AbstractTextControl(Composite parent, int style) {
	super(parent, style);
    }
    
    public Text getUIControl() {
	return text;
    }

    
    public void setText(String str) {
	if (str == null) {
	    text.setText("");
	    return;
	}
	//text.setText(str == null || !trimText ? str : str.trim());
	text.setText(!trimText ? str : str.trim());
    }

    public void setTextLimit(int limit) {
	text.setTextLimit(limit);
    }
    
    public int getTextLimit() {
	return text.getTextLimit();
    }
    
    public boolean isTrimText() {
        return trimText;
    }

    public void setTrimText(boolean trimText) {
        this.trimText = trimText;
    }
    
    // -----------------------------------------------------------------------------------------------------------------------------------
    // Text methods    
    // -----------------------------------------------------------------------------------------------------------------------------------

    
    
 

    /* (non-Javadoc)
     * @see org.eclipse.swt.widgets.Control#setFocus()
     */
    @Override
    public boolean setFocus() {
	checkWidget();
        return text.setFocus();
    }
    
  
    /*
    public boolean getEditable() {
	checkWidget();
	return text.getEditable();
    }
    
  
    public void setEditable(boolean editable) {
	checkWidget();
	text.setEditable(editable);
    }
    */
    
    /**
     * Gets the editable state.
     *
     * @return whether or not the reciever is editable
     */    
    public boolean getEditable() {
	checkWidget();
	return this.isEditableText;
    }
    
    /**
     * Sets the editable state.
     *
     * @param editable the new editable state
     */	
    public void setEditable(boolean editable) {
	checkWidget();
	if (text != null) text.setEditable(editable);
	this.isEditableText = editable;
    }    
    
    /**
     * Returns a <code>Point</code> whose x coordinate is the start of the
     * selection in the receiver's text field, and whose y coordinate is the end
     * of the selection. The returned values are zero-relative. An "empty"
     * selection as indicated by the the x and y coordinates having the same
     * value.
     *
     * @return a point representing the selection start and end
     */
    public Point getSelection() {
        checkWidget();
        return text.getSelection();
    }
    
    /**
     * Sets the selection in the receiver's text field to the
     * range specified by the argument whose x coordinate is the
     * start of the selection and whose y coordinate is the end
     * of the selection. 
     *
     * @param selection a point representing the new selection start and end
     */
    public void setSelection(Point selection) {
        checkWidget();
        if ( selection == null ) SWT.error (SWT.ERROR_NULL_ARGUMENT);
        text.setSelection(selection.x, selection.y);
    }
    
    
    /**
     * Returns a string containing a copy of the contents of the receiver's text
     * field.
     *
     * @return the receiver's text
     */
    public String getText() {
	checkWidget();
	String str = text.getText(); 
        return str == null || !trimText ? str : str.trim();
    }

    /**
      * Returns the height of the receivers's text field.
      *
      * @return the text height
      */
    public int getTextHeight() {
         checkWidget();
         return text.getLineHeight();
    }
    
     
    public void addVerifyListener(VerifyListener listener) {
	text.addVerifyListener(listener);
    }

    public void removeVerifyListener(VerifyListener listener) {
	text.removeVerifyListener(listener);
    }
    
    

    /**
     * Creates the text widget. Override to change appearance or behaviour
     * of the text.
     * 
     * @param style
     * text style
     */
    protected void createTextControl(int style) {
	text = new Text(this, style);
	// text = new Text(this, SWT.NONE);
	initListener();
    }
	
    protected void initListener() {
	initFocusListener();
	initKeyListener();
	initModifyListener();
    }

    protected void initModifyListener() {
	text.addModifyListener(new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		setModify(true);
            }
	});		
    }

    protected void initFocusListener() {
	text.addFocusListener(new FocusAdapter() {
	    public void focusGained(FocusEvent e) {
		handleFocusGained(e);
            }
	});		
    }
    
    protected void handleFocusGained(FocusEvent e) {
	if (Environment.isSelectValueWhenFocus()) {
	    ((Text) e.getSource()).selectAll();
	}	
    }
    
    protected void initKeyListener() {
	text.addKeyListener(new KeyListener() {
	    public void keyPressed(KeyEvent e) {
		handleKeyPressed(e);
	    }
	    public void keyReleased(KeyEvent e) {
		handleKeyReleased(e);
	    }
	});	
    }
    
    protected void handleKeyPressed(KeyEvent e) {
	if (isEditableText) {
	    return;
	}
	e.doit = false;
    }
	
    //protected void handleKeyPressed(KeyEvent e) {
	/*
	String string = "";
	switch (e.character) {
	    case 0: string += " '\\0'"; break;
	    case SWT.BS: string += " '\\b'"; break;
	    case SWT.CR: string += " '\\r'"; break;
	    case SWT.DEL: string += " DEL"; break;
	    case SWT.ESC: string += " ESC"; break;
	    case SWT.LF: string += " '\\n'"; break;
	    default: string += " '" + e.character +"'";
	    break;
	}
	System.out.println (string);
	*/
    //}
    
    protected void handleKeyReleased(KeyEvent e) {
	//STUB
    }
    
    
    public void addFocusListener (FocusListener listener) {
	text.addFocusListener(listener);
    }
    
    public void removeFocusListener(FocusListener listener) {
	text.removeFocusListener(listener);
    }
    
    
    ///---
    protected void resetBackgroundByText() {
	if (text == null) {
	    return;
	}
	Color color = this.getBackground();
	//setControlBackground(color);
	//text.setBackground(color);
    }
    
    protected void setControlBackground(Color color) {
	super.setBackground(color);
    }
    
    
    
    
    
    ///---
    
    
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setBackground(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		if ( text != null ) text.setBackground(color);
	}

	

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if ( text != null ) text.setEnabled(enabled);
		//resetBackgroundByText();
	}


	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font font) {
	    super.setFont(font);
	    text.setFont(font);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setForeground(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForeground(Color color) {
		super.setForeground(color);
		if ( text != null ) text.setForeground(color);
	}    
	
	
	public void notifyTextListeners (int eventType, Event event) {
	    if (text == null) {
		return;
	    }
	    text.notifyListeners(eventType, event);
	}

	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	 /**
	  * Associates a formatter to the widget.
	  * 
	  * @param formatter formatter
	  */
	public void setFormatter(ITextFormatter formatter) {
	    AbstractTextFormatter.initFormatter(text, formatter);
	}
	    
	public ITextFormatter getFormatter() {
	    return AbstractTextFormatter.getFormatter(text);
	}
	
	protected Object getFormatterValue() {
	     return AbstractTextFormatter.getValue(text);
	}
	
	protected void setFormatterValue(Object value) {
	    AbstractTextFormatter.setValue(text, value);
	}

	///////////////////////////////////////////////////////////////////////////////////

	public void setPattern(String pattern) {
	    ITextFormatter formatter = createFormatter(pattern);
	    setFormatter(formatter);
	}


	protected ITextFormatter createFormatter() {
	    return createFormatter(getDefaultPattern());
	}

	protected String getDefaultPattern() {
	    return null;
	}

	protected ITextFormatter createFormatter(String pattern) {
	    return null;
	}
	
}
