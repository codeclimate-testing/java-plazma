package org.plazmaforge.framework.client.swt.controls;



import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TypedListener;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.DataFilter;
import org.plazmaforge.framework.client.models.UpdateEvent;



/**
 * Abstract class for combo widgets composed of a <code>Text</code>, a
 * <code>Button</code> and a popup associated to the button.<p>
 * 
 * The creation of text, button and popup content is delegated to abstract
 * methods.<p>
 * 
 * Note that although this class is a subclass of <code>Composite</code>,
 * it does not make sense to add children to it, or set a layout on it.<p>
 * 
 * <dl>
 * <dt><b>Styles:</b>
 * <dd>BORDER, READ_ONLY, FLAT</dd>
 * <dt><b>Events:</b>
 * <dd>Selection</dd>
 * </dl>
 */
public abstract class AbstractCombo extends AbstractTextControl {
    

	/** Popup shell for the selection */
	protected Shell popup;
	
	/** Control opening the popup */
	protected Control popupControl;
	
	/** Content of the popup */
	protected Control popupContent;
	
	/** Listener for all internal events */
	protected Listener listener;
	
	/** Listener for external events */
	protected Listener filter;
	
	/** Flag indicating if the widget has focus or not */
	protected boolean hasFocus;
	
        /** The tool style (tool button) **/
	private int toolStyle;	
	
	/** Text control event marker **/
	private final String TEXT_CONTROL_EVENT = "TEXT_CONTROL";
	
	
	/** Select event marker **/
	private final String SELECT_EVENT = "SELECT";

	    
	private java.util.List<DataFilter> dataFilters;
	
	public AbstractCombo(Composite parent, int style) {
	    this(parent, style, PWT.POPUP_BUTTON);
	}

	/**
	 * Constructs a new instance of this class given its parent
	 * and a style value describing its behavior and appearance.<p>
	 * 
	 * @param parent a widget which will be the parent of the new instance (cannot be null)
	 * @param style the style of widget to construct
	 */
	public AbstractCombo(Composite parent, int style, int toolStyle) {
	    
		super(parent, style);
		
		
		
		setEditable(false);
		
		this.toolStyle = toolStyle;
				
		
		int textStyle = SWT.SINGLE;
		if ( (style & SWT.READ_ONLY) != 0 ) textStyle |= SWT.READ_ONLY;
		if ( (style & SWT.FLAT) != 0 ) textStyle |= SWT.FLAT;
		
		// Create the Text widget
		createTextControl(textStyle);
		
		// Create the ToolBar
		createToolBar();
		
		if (getTextParent() != null) {
		    setTabList(new Control[] {getTextParent()});
		}
	
		listener = new Listener () {
			public void handleEvent (Event event) {
				if ( popup == event.widget ) {
					popupEvent(event);
					return;
				}
				if ( text == event.widget ) {
					textEvent(event);
					return;
				}
				if ( popupContent == event.widget ) {
				    if (event.keyCode == SWT.ESC) { // FIXED OHA
					event.doit = false;
					dropDown(false);
					return;
				    }
				    contentEvent(event);
				    return;
				}
				if ( popupControl == event.widget ) {
					buttonEvent(event);
					return;
				}
				if ( AbstractCombo.this == event.widget ) {
					comboEvent(event);
					return;
				}
				if ( getShell() == event.widget ) {
					handleFocus(SWT.FocusOut);
				}
			}
		};
		filter = new Listener() {
			public void handleEvent(Event event) {
				Shell shell = ((Control)event.widget).getShell ();
				if ( shell == AbstractCombo.this.getShell() ) {
					handleFocus(SWT.FocusOut);
				}
			}
		};

		// Create the Popup Shell
		popup = new Shell(getShell(), SWT.TOOL | SWT.ON_TOP);
		popup.setLayout(new FillLayout());
		
		// Create the Popup Content (List, Calendar and etc.)
		createPopupContent();
		popup.pack();

		// Add listeners
  	        addListener(SWT.Dispose, listener);
		addListener(SWT.Move, listener);
		addListener(SWT.Resize, listener);
		
		text.addListener(SWT.Modify, listener);
		
		if (hasPopupControl()) {
			popupControl.addListener(SWT.Selection, listener);
			popupControl.addListener(SWT.FocusIn, listener);
			
			//text.addListener(SWT.Modify, listener);
			
			popup.addListener(SWT.Deactivate, listener);
			popupContent.addListener(SWT.Selection, listener);
		}
		
		super.setBackground(getTextParent().getBackground());
		
		
		
		////////////////////////////////////////////////
		//
		// TODO: Stub solution. Only for update listener
		//
		////////////////////////////////////////////////
		
		addSelectionListener(new SelectionAdapter() {
		    public void widgetSelected(SelectionEvent e) {
			if (!forceUpdateListener) {
			    return;
			}
			notifyUpdateListener(new UpdateEvent(SELECT_EVENT));
		    }
		});
		
		
	}
	
	// TODO: Stub
	private boolean forceUpdateListener = true;
	
	
	
	
	
	protected boolean hasPopupControl() {
	    return (toolStyle & PWT.POPUP_BUTTON) != 0;
	}

	
	/**
	 * Create the ToolBar
	 *
	 */
	protected void createToolBar() {
	    
	    if (hasPopupControl()) {
		    
		// Create the Popup control (Button arrow, image and etc.)
		int buttonStyle = SWT.ARROW | SWT.DOWN;
		if ( (getStyle() & SWT.FLAT) != 0 ) {
		    buttonStyle |= SWT.FLAT;
		}
		createPopupControl(buttonStyle);
	    }
	    
	}
	
	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when the receiver's text is modified, by sending
	 * it one of the messages defined in the <code>ModifyListener</code>
	 * interface.
	 *
	 * @param lsnr the listener which should be notified
	 * @see ModifyListener
	 * @see #removeModifyListener
	 */
	public void addModifyListener(ModifyListener lsnr) {
		checkWidget();
		if ( lsnr == null ) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(lsnr);
		addListener(SWT.Modify, typedListener);
	}

	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when the receiver's selection changes, by sending
	 * it one of the messages defined in the <code>SelectionListener</code>
	 * interface.
	 * <p>
	 * <code>widgetSelected</code> is called when the combo's list selection changes.
	 * <code>widgetDefaultSelected</code> is typically called when ENTER is pressed the combo's text area.
	 * </p>
	 *
	 * @param lsnr the listener which should be notified
	 * @see SelectionListener
	 * @see #removeSelectionListener
	 */
	public void addSelectionListener(SelectionListener lsnr) {
		checkWidget();
		if ( lsnr == null ) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(lsnr);
		addListener(SWT.Selection,typedListener);
		addListener(SWT.DefaultSelection,typedListener);
	}

	
	
	
	/**
	 * Called just before the popup is droppped. Override to execute actions
	 * before the apparition of the popup.<p>
	 * 
	 * By default, do nothing.
	 */
	protected void beforeDrop() {
	}

	/**
	 * Manages button events.
	 * 
	 * @param event event
	 */
	protected void buttonEvent(Event event) {
		switch (event.type) {
			case SWT.FocusIn :
				handleFocus(SWT.FocusIn);
				break;
			case SWT.Selection :
				dropDown(!isDropped());
				break;
		}
	}

	/**
	 * Manages global combo events.
	 * 
	 * @param event event
	 */
	protected void comboEvent(Event event) {
		switch (event.type) {
			case SWT.Dispose :
				if (popup != null && !popup.isDisposed ()) {
					popupContent.removeListener(SWT.Dispose, listener);
					popup.dispose ();
				}
				Shell shell = getShell();
				shell.removeListener(SWT.Deactivate, listener);
				Display display = getDisplay();
				display.removeFilter(SWT.FocusIn, filter);
				popup				 = null;
				text				 = null;
				popupContent = null;
				popupControl			 = null;
				break;
			case SWT.Move :
				dropDown(false);
				break;
			case SWT.Resize :
				internalLayout();
				break;
				
		}
	}

	/**
	 * Manages popup content events. SelectionEvent are notified to all registered
	 * SelectionListeners of the combo.
	 * 
	 * @param event event
	 */
	protected void contentEvent(Event event) {
		switch (event.type) {
			case SWT.Selection :
				Event e = new Event();
				e.time			= event.time;
				e.stateMask = event.stateMask;
				e.doit			= event.doit;
				e.data			= event.data;
				notifyListeners(SWT.Selection, e);
				event.doit = e.doit;
				break;
		}
	}

	/**
	 * Creates the arrow button widget. Override to change appearance or
	 * behaviour of the button.
	 * 
	 * @param style button style
	 */
	protected void createPopupControl(int style) {
	    createButtonPopupControl(style);
	}

	protected void createButtonPopupControl(int style) {
		//style &= ~(SWT.ARROW | SWT.DOWN);
	    	popupControl = new Button(this, style | SWT.FLAT);
	    	//popupControl = new Button(this, SWT.ARROW);
	}
	
	
	/**
	 * Creates the popup content. The popup is dependent of each implementation.
	 * Content can be a <code>List</code>, a <code>Table</code> or every other
	 * control.<br>
	 * The <code>popupContent</code> attribute must be setted with the created
	 * control. The parent must be the <code>shell</code> attribute, that is
	 * initialized by default with a <code>FillLayout</code>.
	 */
	protected abstract void createPopupContent();
	
        protected void initPopupContentListener() {
            int [] popupEvents = {SWT.Close, SWT.Paint, SWT.Deactivate};
	    for (int i = 0; i < popupEvents.length; i++) popup.addListener (popupEvents [i], listener);
	    int [] listEvents = {SWT.MouseUp, SWT.Selection, SWT.Traverse, SWT.KeyDown, SWT.KeyUp, SWT.FocusIn, SWT.Dispose};
	    for (int i = 0; i < listEvents.length; i++) popupContent.addListener (listEvents [i], listener);         
        }
	

        protected int keyEnter;
        
	protected void handleKeyReleased(KeyEvent e) {
	    
	    // Call the popup window
	    if ((e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_RIGHT) && e.stateMask == SWT.ALT && hasPopupControl()) {
		popupShow();
		return;
	    }
	    
	    if (isPushKeyCode(e.keyCode)) {
		pushButton();
	    }
	}
	
	protected boolean pushButton() {
	    return popupShow();
	}
	
	protected boolean popupShow() {
	    if (hasPopupControl()) {
		dropDown(true);
		return true;
	    }
	    return false;
	}
	
	protected boolean isEnterKeyCode(int keyCode) {
	    return keyCode == SWT.CR;
	}
	
	protected boolean isPushKeyCode(int keyCode) {
	    // Ignore key when editable mode
	    if (getEditable()) {
		return false;
	    }
	    return keyCode == 32;
	}
	
	
	/**
	 * Manages drop down of the popup.
	 * 
	 * @param drop <code>true</code> to drop the popup, <code>false</code> to close
	 */
	protected void dropDown(boolean drop) {
		if ( drop == isDropped() ) return;
		if ( !drop ) {
			popup.setVisible(false);
   		        if ( !isDisposed() && isPopupControlFocus() ) {
				text.setFocus();
			}
			return;
		}

		setPopupLocation();
		setPopupSize();
		beforeDrop();
		popup.setVisible(true);
		popupContent.setFocus();
	}



	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Widget#getStyle()
	 */
	@Override
	public int getStyle() {
		int style = super.getStyle();
		style &= ~SWT.READ_ONLY;
		if ( !text.getEditable() ) style |= SWT.READ_ONLY; 
		return style;
	}


	/**
	 * Manages the focus on the combo.
	 * 
	 * @param type SWT.FocusIn or SWT.FocusOut
	 */
	protected void handleFocus(int type) {
		if ( isDisposed() ) return;
		switch (type) {
			case SWT.FocusIn : {
				if ( hasFocus ) return;
				if ( getEditable() ) text.selectAll();
				hasFocus = true;
				Shell shell = getShell();
				shell.removeListener(SWT.Deactivate, listener);
				shell.addListener(SWT.Deactivate, listener);
				Display display = getDisplay();
				display.removeFilter(SWT.FocusIn, filter);
				display.addFilter(SWT.FocusIn, filter);
				Event e = new Event();
				notifyListeners(SWT.FocusIn, e);
				break;
			}
			case SWT.FocusOut : {
				if ( !hasFocus ) return;
				Control focusControl = getDisplay().getFocusControl();
				if ( focusControl == popupControl || focusControl == popupContent || focusControl == text) return;
				hasFocus = false;
				Shell shell = getShell();
				shell.removeListener(SWT.Deactivate, listener);
				Display display = getDisplay();
				display.removeFilter(SWT.FocusIn, filter);
				Event e = new Event();
				notifyListeners(SWT.FocusOut, e);
				break;
			}
		}
	}

	/**
	 * Returns <code>true</code> if popup is dropped (visible), else <code>false</code>.
	 * 
	 * @return boolean indicating if popup is dropped
	 */
	protected boolean isDropped() {
		return popup.getVisible();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#isFocusControl()
	 */
	@Override
	public boolean isFocusControl() {
		checkWidget();
		//if ( text.isFocusControl() || popupControl.isFocusControl()
		if ( text.isFocusControl()
			|| isPopupControlFocus()
			|| (popupContent != null && popupContent.isFocusControl())
			|| (popup != null && popup.isFocusControl()) ) {
			return true;
		} 
		return super.isFocusControl();
	}

	/**
	 * Manages popup shell events.
	 * 
	 * @param event event
	 */
	protected void popupEvent(Event event) {
		switch (event.type) {
			case SWT.Deactivate :
				dropDown(false);
				break;
		}
	}

	/**
	 * Removes the listener from the collection of listeners who will
	 * be notified when the receiver's text is modified.
	 *
	 * @param lsnr the listener which should no longer be notified
	 * @see ModifyListener
	 * @see #addModifyListener
	 */
	public void removeModifyListener(ModifyListener lsnr) {
		checkWidget();
		if ( lsnr == null ) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Modify, lsnr);	
	}

	/**
	 * Removes the listener from the collection of listeners who will
	 * be notified when the receiver's selection changes.
	 *
	 * @param lsnr the listener which should no longer be notified
	 * @see SelectionListener
	 * @see #addSelectionListener
	 */
	public void removeSelectionListener(SelectionListener lsnr) {
		checkWidget();
		if ( lsnr == null ) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		removeListener(SWT.Selection, lsnr);
		removeListener(SWT.DefaultSelection,lsnr);	
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setBackground(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		if ( popupContent != null ) popupContent.setBackground(color);
	}

	

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setEnabled(boolean)
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if ( popup != null ) popup.setVisible(false);
		if ( popupControl != null ) setPopupControlEnabled(enabled);
	}



	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	public void setFont(Font font) {
	    super.setFont(font);
	    //text.setFont(font); // TODAY
	    popupContent.setFont(font);
	    pack();
	    popup.pack();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setForeground(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setForeground(Color color) {
		super.setForeground(color);
		if ( popupContent != null ) popupContent.setForeground(color);
	}

	/**
	 * Sets the layout which is associated with the receiver to be
	 * the argument which may be null.
	 * <p>
	 * Note : No Layout can be set on this Control because it already
	 * manages the size and position of its children.
	 * </p>
	 *
	 * @param layout the receiver's new layout or null
	 */
	@Override
	public void setLayout(Layout layout) {
		checkWidget();
		return;
	}

	/**
	 * Calculates and returns the location of popup.<br>
	 * Called just before than the popup is dropped.
	 */
	protected void setPopupLocation() {
	    Rectangle r = getBounds();
	    Point p = Display.getCurrent().map(this, null, 0, r.height);
	    popup.setLocation(p.x, p.y);
        }

	 protected void setPopupSize() {
	     
	 }


	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if ( !visible ) popup.setVisible(false);
	}

	/**
	 * Manages text widget events. ModifyEvent are notified to all registered
	 * ModifyListener of the combo.
	 * 
	 * @param event event
	 */
	protected void textEvent(Event event) {
		switch (event.type) {
			case SWT.Modify :
				Event e = new Event ();
				e.time = event.time;
				e.data = TEXT_CONTROL_EVENT;
				notifyListeners(SWT.Modify, e);
				break;
		}
	}
	
	/**
	 * Returns true if <code>TypedEvent</code> is marked by TEXT
	 * @param event
	 * @return
	 */
	public boolean isTextControlEvent(TypedEvent event) {
	    if (event == null) {
		return false;
	    }
	    return TEXT_CONTROL_EVENT.equals(event.data);
	}
	
	
	protected abstract Control getTextParent();
	
	
	protected int getToolStyle() {
	    return toolStyle;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// Popup Control methods
        // -----------------------------------------------------------------------------------------------------------------
	
	protected boolean isPopupControlFocus() {
	    if (popupControl == null) {
		return false;
	    }
	    return popupControl.isFocusControl();
	}
	
	protected void setPopupControlEnabled(boolean enabled) {
	    if (popupControl == null) {
		return;
	    }
	    popupControl.setEnabled(enabled);
	}

	
	protected Control[] getToolButtons() {
	    return new Control[] {popupControl};
	}



	
	protected Point computeToolButtonSize(int wHint, int hHint, boolean changed) {
	    int h = hHint;
	    // TODO: STUB
	    if (h < getFixHeight() + 2) {
		h = getFixHeight() + 2;
	    }
	    return new Point(h, h);
	}

	// FIX 2010-04-01
    public Point computeSize(int wHint, int hHint, boolean changed) {
	checkWidget();
	int width = 0;
	int height = 0;
	int borderWidth = getBorderWidth();
	
	// FIXED 2010-04-13
	Point textSize = getTextParent().computeSize(wHint, -1, changed);
	//Point textSize = text.computeSize(wHint, -1, changed);
	
	Control[] buttons = getToolButtons();
	int buttonCount = buttons == null ? 0 : buttons.length;

	int toolBarHeight = 0;
	int toolBarWidth = 0;
	
	if (buttonCount > 0) {
	    for (int i = 0; i < buttonCount; i++) {
		Control button = buttons[i];
		if (button == null || button.isDisposed()) {
		    continue;
		}
		//Point buttonSize = button.computeSize(-1, -1, changed);
		Point buttonSize = computeToolButtonSize(wHint, hHint, changed);
		toolBarHeight = Math.max(toolBarHeight, buttonSize.y);
		toolBarWidth += buttonSize.x;
	    }
	}
	
	height = Math.max(hHint, Math.max(textSize.y, toolBarHeight) + 2 * borderWidth);
	width = Math.max(wHint, textSize.x + toolBarWidth + 2 * borderWidth);
	return new Point(width, height);
    }

    // FIX 2010-04-01
    private void internalLayout() {
	if (isDropped()) {
	    dropDown(false);
	}

	Rectangle rect = getClientArea();
	int width = rect.width;
	int height = rect.height;
	Control[] buttons = getToolButtons();
	int buttonCount = buttons == null ? 0 : buttons.length;
	Point[] buttonSizes = null;
	int toolBarWidth = 0;

	if (buttonCount > 0) {
	    buttonSizes = new Point[buttonCount];
	    for (int i = 0; i < buttonCount; i++) {
		Control button = buttons[i];
		if (button == null || button.isDisposed()) {
		    continue;
		}
		//buttonSizes[i] = button.computeSize(-1, height);
		buttonSizes[i] = computeToolButtonSize(height, height, false);
		toolBarWidth += buttonSizes[i].x;
	    }
	}
	
	// FIXED 2010-04-13
	getTextParent().setBounds(rect.x, rect.y, width - toolBarWidth, height);
	//text.setBounds(rect.x, rect.y, width - toolBarWidth, height);
	
	if (buttonSizes == null) {
	    return;
	}
	int len = toolBarWidth;
	for (int i = 0; i < buttonCount; i++) {
	    if (buttonSizes[i] == null) {
		continue;
	    }
	    buttons[i].setBounds((rect.x + width) - len, rect.y, buttonSizes[i].x, buttonSizes[i].y);
	    len -= buttonSizes[i].x;
	}
    }

    protected void setToolControlImage(Control control, Image image) {
	if (control == null) {
	    return;
	}
	if (control instanceof Label) {
	    ((Label) control).setImage(image);
	} else if (control instanceof Button) {
	    ((Button) control).setImage(image);
	} else if (control instanceof ToolButton) {
	    ((ToolButton) control).setImage(image);
	}
	
    }
    
    ////
    
    
    public String getDisplayText(Object value) {
	return getModel().getDisplayText(value);
    }
    
    public String getFormatText(Object value) {
	return getModel().getFormatText(value);
    }    
    
    public Object getDisplayValue(Object value) {
	return getModel().getDisplayValue(value);
    }

    public java.util.List<DataFilter> getDataFilters() {
	if (dataFilters == null) {
	    dataFilters = new ArrayList<DataFilter>();
	}
        return dataFilters;
    }

    public void addDataFilter(DataFilter dataFilter) {
	getDataFilters().add(dataFilter);
    }
    
    public boolean hasDataFilters() {
	return dataFilters != null && !dataFilters.isEmpty();
    }



}
