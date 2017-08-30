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

package org.plazmaforge.framework.client.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.Action;
import javax.swing.ImageIcon;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Widget;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemInfo;

/** 
 * @author Oleh Hapon
 * $Id: SWTUtils.java,v 1.2 2010/04/28 06:36:49 ohapon Exp $
 */

public class SWTUtils {
    

    public static final String TRUE = "true";
	
    public static final String FALSE = "false";
	
    public static final String VISIBLE = "visible";
    
    public static int MIN_TOOLBAR_HEIGHT = 25; 

    
    public static void centerWindow(Shell shell) {
	
	Rectangle displayArea; // area to center in
	try {
	    displayArea = shell.getMonitor().getClientArea();
	} catch (NoSuchMethodError e) {
	    displayArea = shell.getDisplay().getClientArea();
	}

	Rectangle shellRect = shell.getBounds();

	if (shellRect.height > displayArea.height) {
	    shellRect.height = displayArea.height;
	}
	if (shellRect.width > displayArea.width - 50) {
	    shellRect.width = displayArea.width;
	}

	shellRect.x = displayArea.x + (displayArea.width - shellRect.width) / 2;
	shellRect.y = displayArea.y + (displayArea.height - shellRect.height) / 2;

	shell.setBounds(shellRect);
	
    }

    
    public static int computeEMBase(Composite comp) {
      GC gc = new GC(comp);
      try
      {
        return gc.getFontMetrics().getHeight();
      }
      finally { gc.dispose(); }
    }
    
    
    
    
    /**
     * Returns the name of Swing action
     * @param action
     * @return name
     */
    public static String getActionName(Action action) {
        return (String) action.getValue(Action.NAME);
    }
    
    /**
     * Returns the name of action
     * @param action
     * @return
     */
    public static String getActionName(IAction action) {
        return action.getName();
    }    
    
    /**
     * Get SWT image from Swing action 
     * @param action
     * @return
     */
    public static Image getActionImage(Action action){
	ImageIcon icon = (ImageIcon) action.getValue(Action.SMALL_ICON);
	if (icon == null) {
	    return null;
	}
       	String path = icon.toString();
       	int index = path.indexOf("!");       	
       	if (index > -1) {
       	    path = path.substring(index + 1);
       	}
       	return getImage(path);
    }
    
    /**
     * Get SWT image from IAction
     */
    public static Image getActionImage(IAction action) {
	String path = action.getImageUrl();
	if (isEmpty(path)) {
	    return null;
	}
	return getImage(path);
    }
    
    protected static Image getImage(String path) {
	return SWTResourceManager.getImage(SWTResourceManager.class, path);
    }
    
    private static boolean isEmpty(String str) {
	return StringUtils.isEmpty(str); 
    }

    
    public static void setFixedWidth(Control control, int width) {
	if (control == null) {
	    return;
	}
	Object layoutData = control.getLayoutData();
	if (layoutData == null) {
	    return;
	}
	if (layoutData instanceof GridData) {
	    ((GridData) layoutData).widthHint = width;
	}
   }
    
    public static void setMaxWidth(Control[] controls) {
	if (controls == null || controls.length == 0) {
	    return;
	}
	int count = controls.length;
	
	int max = 0;
	for (int i = 0; i < count; i++) {
	    int width = computeWidth(controls[i]);
	    max = Math.max(max, width);
	}
	
	for (int i = 0; i < count; i++) {
	    setFixedWidth(controls[i], max);
	}
	
    }
    
    public static Point computeSize(Control control) {
	if (control == null) {
	    return null;
	}
	return control.computeSize(-1, -1);
    }
    
    public static int computeWidth(Control control) {
	Point size = computeSize(control);
	return size == null ? 0 : size.x;
    }
    
    public static int computeHeight(Control control) {
	Point size = computeSize(control);
	return size == null ? 0 : size.y;
    }

    ////----
    
    public static Color getDisabledColor(Color color) {
	return getDisabledColor(null, color);
    }

    public static Color getDisabledColor(Display display, Color color) {
	if (display == null) {
	    display = Display.getCurrent();
	}
	int red = getDisabledColorAmount(color.getRed());
	int green = getDisabledColorAmount(color.getGreen());
	int blue = getDisabledColorAmount(color.getBlue());

	return new Color(display, red, green, blue);
    }

    public static int getDisabledColorAmount(int amount) {
	int result = getFixColorAmount(amount);
	result = result + (int) (((255 - result) / getDisabledColorCoef())); 
	return getFixColorAmount(result);
    }

    public static int getFixColorAmount(int amount) {
	int result = amount;
	if (amount > 255) {
	    result = 255;
	}
	if (amount < 0) {
	    result = 0;
	}
	return result;
    }

    public static float getDisabledColorCoef() {
	return isMacOS() ? 2f : 1.5f;
    }

    public static boolean isSupportEnableLabel() {
	return !isMacOS();
    }

    public static boolean isMacOS() {
	return SystemInfo.isMac; // Platform.getOS().equals(Platform.OS_MACOSX);
    }

    public static void setData(Widget widget, String key, Object value) {
	if (widget == null) {
	    return;
	}
	widget.setData(key, value);
    }

    public static Object getData(Widget widget, String key) {
	if (widget == null) {
	    return null;
	}
	return widget.getData(key);
    }

    public static void setVisible(Control control, boolean visible) {
	setVisible(control, visible, false);
    }

    public static void setVisible(Control control, boolean visible,
	    boolean setData) {
	if (control == null) {
	    return;
	}
	control.setVisible(visible);
	Object layoutData = control.getLayoutData();
	if (layoutData == null) {
	    return;
	}
	// Update GridData
	if (layoutData instanceof GridData) {
	    ((GridData) layoutData).exclude = !visible;
	}
	if (setData) {
	    setVisibleData(control, visible);
	}
    }

    public static void setVisibleData(Control control, boolean visible) {
	if (control == null) {
	    return;
	}
	control.setData(VISIBLE, visible ? TRUE : FALSE);
    }

    public static boolean isVisibleData(Control control) {
	if (control == null) {
	    return false;
	}
	return TRUE.equals(control.getData(VISIBLE));
    }

    public static String getText(String[] lines) {

	if (lines == null || lines.length == 0) {
	    return null;
	}
	StringBuffer buf = new StringBuffer();
	for (int i = 0; i < lines.length; i++) {
	    if (i > 0) {
		buf.append("\n");
	    }
	    buf.append(lines[i]);
	}
	return buf.toString();
    }

    public static String[] getTextLines(GC gc, String text, int width) {
	if (gc == null || text == null) {
	    return null;
	}
	if (text.length() == 0) {
	    return null;
	}

	text = text.trim();
	if (text.length() == 0) {
	    return null;
	}
	String delim = " "; // ",. \n"
	StringTokenizer t = new StringTokenizer(text, delim);

	int tokenCount = 0;
	String token = null;
	int b = gc.stringExtent(" ").x;
	int limit = width - b;
	if (limit < 0) {
	    limit = width;
	}

	String line = "";
	String testLine = "";
	int lineLen = 0;
	int lineCount = 0;

	List outputLines = new ArrayList();
	while (t.hasMoreTokens()) {

	    token = t.nextToken();

	    if (tokenCount == 0) {
		testLine = token;
	    } else {
		testLine = line + " " + token;
	    }

	    lineLen = gc.stringExtent(testLine).x;
	    if (lineLen > limit) {
		outputLines.add(line);
		lineCount++;
		line = token;
	    } else {
		line = testLine;
	    }
	    tokenCount++;
	}

	// Add last line
	if (tokenCount > 0 && line != null && line.length() > 0) {
	    outputLines.add(line);
	}

	return (String[]) outputLines.toArray(new String[0]);
    }	
    
    
    public static void initSize(CoolItem coolItem, ToolBar toolBar, int minHeight) {
	if (coolItem == null || toolBar == null) {
	    return;
	}
	Point toolBarSize = toolBar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	if (toolBarSize.y < minHeight) {
	    toolBarSize.y = minHeight;
	}
	Point preferredSize = coolItem.computeSize(toolBarSize.x, toolBarSize.y);
	coolItem.setPreferredSize(preferredSize);
	coolItem.setSize(preferredSize);
    }
    
    public static void initSize(CoolItem coolItem, ToolBar toolBar) {
	initSize(coolItem, toolBar, MIN_TOOLBAR_HEIGHT);
    }
}
