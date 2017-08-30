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

import java.util.Date;
import java.util.Locale;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.plazmaforge.framework.platform.PlatformEnvironment;


/**
 * DateCombo widget. This class represents a date field editor that combines
 * a text field and a calendar. Implementation is based on <code>DateFormatter</code>
 * and <code>CCalendar</code>.<p>
 * 
 * Issues notification when the text content is modified or when a date is
 * selected in the calendar.<p>
 * 
 * <dl>
 * <dt><b>Styles:</b>
 * <dd>BORDER, READ_ONLY, FLAT</dd>
 * <dt><b>Events:</b>
 * <dd>Modify</dd>
 * <dd>Selection</dd>
 * </dl>
 */
public class XDateCombo extends AbstractCombo {
  
    
    protected static final String IMAGE = "/org/plazmaforge/framework/client/swt/controls/DateChooser.png";

    /** Default image for the button */
    protected static Image buttonImage;

    
    static {
	buttonImage = new Image(Display.getCurrent(), XDateCombo.class.getResourceAsStream(IMAGE));
    }
    
    /**
     * Constructs a new instance of this class given its parent and a style value
     * describing its behavior and appearance.<p>
     * 
     * The widget is initialized with a default image for the button, and a
     * default <code>DateFormatter</code>.
     * 
     * @param parent a composite control which will be the parent of the new instance (cannot be null)
     * @param style the style of control to construct
     */
    
    public XDateCombo(Composite parent, int style) {
	super(parent, style);
	initialize();
	setImage(buttonImage);
	pack();
    }

    private void initialize() {
	setValueClass(Date.class);
    }
     
    /**
     * Called just before the popup is droppped. The selected date of the
     * 
     * calendar is setted to the current date present in the formatted text.
     * 
     * @see org.plazmaforge.framework.client.swt.controls.AbstractCombo#beforeDrop()
     */
    @Override
    protected void beforeDrop() {
        Date d = (Date) getFormatterValue();
        CCalendar cal = (CCalendar) popupContent;
        cal.setSelectedDate(d != null ? d : cal.getTodayDate());
    }

    /**
     * Manages popup content events. Extend the selection behaviour, adding the
     * selected date in the <code>data</code> attribute of the event.
     * 
     * @param event event
     * @see org.plazmaforge.framework.client.swt.controls.AbstractCombo#contentEvent(org.eclipse.swt.widgets.Event)
     */
      
    @Override
    protected void contentEvent(Event event) {
	switch (event.type) {
	    case SWT.Selection :
		super.contentEvent(event);
                if ( event.doit ) {
                    setFormatterValue(event.data);
                    dropDown(false);
                    text.setFocus();
                }
                break;
            default :
                super.contentEvent(event);
                break;
        }
    }

    
    protected void handleKeyReleased(KeyEvent e) {
	    int keyCode = e.keyCode;
	    if (keyCode == 32) {
		dropDown(true);
                text.setFocus();
                return;
	    }
	    super.handleKeyReleased(e);
    }
    
    /**
     * Creates the button widget. The default appearence with an arrow is
     * replaced by a button with an image.
     * 
     * @param style button style
     * @see org.plazmaforge.framework.client.swt.controls.AbstractCombo#createPopupControl(int)
     */
    
     
     
     protected void createPopupControl(int style) {
         //style &= ~(SWT.ARROW | SWT.DOWN);
         super.createPopupControl(style);
     }
     
     

     /**
      * Creates the popup content. The content is a <code>CCalendar</code>.
      * 
      * @see org.plazmaforge.framework.client.swt.controls.AbstractCombo#createPopupContent()
      */
     @Override
     protected void createPopupContent() {
         popupContent = new CCalendar(popup, SWT.NONE);
         initPopupContentListener();
     }
     

     /**
      * Creates the text widget. Overrides the default implementation to create a
      * <code>FormattedText</code> with the default formatter for <code>Date</code>
      * values.
      * The formatter is provided by <code>DefaultFormatterFactory</code>. By default
      * a <code>DateFormatter</code> is returned. This can be changed by
      * registering a new formatter for Date class.
      * 
      * @param style text style
      * @see org.plazmaforge.framework.client.swt.controls.AbstractCombo#createTextControl(int)
      */
     @Override
     protected void createTextControl(int style) {
	 super.createTextControl(style);
	 setFormatter(createFormatter());
         setEditable(true);
         
         //initKeyListener();
         initModifyListener();
     }

     protected String getDefaultPattern() {
	return PlatformEnvironment.getDatePattern(); 
     }
     
     protected ITextFormatter createFormatter(String pattern) {
	 return new DateFormatter(pattern);
     }


     /**
      * Returns the current <code>Date</code> value of the widget.<p>
      * 
      * @return Current value
      */
     public Date getDate() {
	 return (Date) getFormatterValue();
	 
     }

     /**
      *  Returns true if grid is visible in the calendar popup.
      * 
      * @return Returns the grid visible status.
      */
     public boolean isGridVisible() {
	 return ((CCalendar) popupContent).isGridVisible();
     }
     
     
    /**
     * Sets the grid visible or not in the calendar popup. By default, the grid
     * is visible.
     * 
     * @param gridVisible <code>true</code> to set grid visible, else <code>false</code>
     */
    public void setGridVisible(boolean gridVisible) {
	((CCalendar) popupContent).setGridVisible(gridVisible);
	popup.pack();
    }

    private boolean isFixImage;
     
    /**
     * Sets a new image to display on the button, replacing the default one.
     * 
     * @param image new image
     */
    public void setImage(Image image) {
	if (popupControl == null || !isFixImage) {
	    return;
	}
	setToolControlImage(popupControl, image);
    }

    /**
     * Sets the locale used both by the input mask and the calendar.
     * 
     * @param loc locale
     */
    public void setLocale(Locale loc) {
        DateFormatter formatter = (DateFormatter) getFormatter();
        if (formatter != null) {
            formatter.setLocale(loc);
        }
        ((CCalendar) popupContent).setLocale(loc);
    }

    /**
     * Sets the theme to apply to the calendar popup.
     * 
     * @param theme new theme (must not be null)
     */
    public void setTheme(CalendarTheme theme) {
	((CCalendar) popupContent).setTheme(theme);
    }

    /**
     * Sets a new <code>Date</code> value.
     * 
     * @param value new date value
     */
    public void setDate(Date value) {
	super.setValue(value);
	setFormatterValue(value);
    }
    
    public void setValue(Object value) {
	if (!(value instanceof Date)) {
	    throw new IllegalArgumentException("Value must be Date");
	}
	setDate((Date) value);
    }
    
    public Object getValue() {
	return getDate();
    }
	
    protected Control getTextParent() {
	return text;
    }
    
    public void setEditable(boolean editable) {
	super.setEditable(editable);
	setPopupControlEnabled(editable);
    }
    
  
}
