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
package org.plazmaforge.framework.client.swing.gui;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.XAbstractTableModel;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon Date: 18.01.2004 Time: 15:32:17 $Id: GUIUtilities.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */

public class GUIUtilities {

    public static final int MIN_COLUMN_WIDTH = 10;

    public static final int MAX_COLUMN_WIDTH = 50;

    private static final String STRING_DATA = "THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG";

    private static GUIUtilities instance;

    private GUIUtilities() {
    }

    public static GUIUtilities getInstance() {
	if (instance == null) {
	    instance = new GUIUtilities();
	}
	return instance;
    }

    public static void centerWithinParent(Window window) {
	if (window == null) {
	    throw new IllegalArgumentException("Window is null");
	}
	final Container parent = window.getParent();
	if (parent != null && parent.isVisible()) {
	    center(window, new Rectangle(parent.getLocationOnScreen(), parent
		    .getSize()));
	} else {
	    centerWithinScreen(window);
	}
    }

    public static void centerWithinDesktop(JInternalFrame frame) {
	if (frame == null) {
	    throw new IllegalArgumentException("Frame is null");
	}
	final Container parent = frame.getDesktopPane();
	if (parent != null && parent.isVisible()) {
	    center(frame, new Rectangle(new Point(0, 0), parent.getSize()));
	}
    }

    public static void centerWithinScreen(Window window) {
	if (window == null) {
	    throw new IllegalArgumentException("Window is null");
	}
	final Toolkit toolKit = Toolkit.getDefaultToolkit();
	final Rectangle rcScreen = new Rectangle(toolKit.getScreenSize());
	final Dimension windSize = window.getSize();
	final Dimension parentSize = new Dimension(rcScreen.width,
		rcScreen.height);
	if (windSize.height > parentSize.height) {
	    windSize.height = parentSize.height;
	}
	if (windSize.width > parentSize.width) {
	    windSize.width = parentSize.width;
	}
	center(window, rcScreen);
    }

    public static Frame getParentFrame(Component component) {
	if (component == null) {
	    throw new IllegalArgumentException("Component is null");
	}

	if (component instanceof Frame) {
	    return (Frame) component;
	}
	return getParentFrame(SwingUtilities.windowForComponent(component));
    }

    public static boolean isToolWindow(JInternalFrame frame) {
	if (frame == null) {
	    throw new IllegalArgumentException("Frame is null");
	}
	final Object obj = frame.getClientProperty("JInternalFrame.isPalette");
	return obj != null && obj == Boolean.TRUE;
    }

    public static void makeToolWindow(JInternalFrame frame, boolean isToolWindow) {
	if (frame == null) {
	    throw new IllegalArgumentException("Frame is null");
	}
	frame.putClientProperty("JInternalFrame.isPalette",
		isToolWindow ? Boolean.TRUE : Boolean.FALSE);
    }

    public static void setJButtonSizesTheSame(JButton[] buttons) {
	if (buttons == null) {
	    throw new IllegalArgumentException("Buttons is null");
	}

	final Dimension maxSize = new Dimension(0, 0);
	for (int i = 0; i < buttons.length; ++i) {
	    final JButton btn = buttons[i];
	    final FontMetrics fm = btn.getFontMetrics(btn.getFont());
	    Rectangle2D bounds = fm.getStringBounds(btn.getText(), btn
		    .getGraphics());
	    int boundsHeight = (int) bounds.getHeight();
	    int boundsWidth = (int) bounds.getWidth();
	    maxSize.width = boundsWidth > maxSize.width ? boundsWidth
		    : maxSize.width;
	    maxSize.height = boundsHeight > maxSize.height ? boundsHeight
		    : maxSize.height;
	}

	Insets insets = buttons[0].getInsets();
	maxSize.width += insets.left + insets.right;
	maxSize.height += insets.top + insets.bottom;

	for (int i = 0; i < buttons.length; ++i) {
	    JButton btn = buttons[i];
	    btn.setPreferredSize(maxSize);
	}
    }

    public static JInternalFrame[] getOpenToolWindows(JInternalFrame[] frames) {
	if (frames == null) {
	    throw new IllegalArgumentException("Frames is null");
	}
	List framesList = new ArrayList();
	for (int i = 0; i < frames.length; ++i) {
	    JInternalFrame fr = frames[i];
	    if (isToolWindow(fr) && !fr.isClosed()) {
		framesList.add(frames[i]);
	    }
	}
	return (JInternalFrame[]) framesList
		.toArray(new JInternalFrame[framesList.size()]);
    }

    public static JInternalFrame[] getOpenNonToolWindows(JInternalFrame[] frames) {
	if (frames == null) {
	    throw new IllegalArgumentException("Frames is null");
	}
	List framesList = new ArrayList();
	for (int i = 0; i < frames.length; ++i) {
	    JInternalFrame fr = frames[i];
	    if (!isToolWindow(fr) && !fr.isClosed()) {
		framesList.add(frames[i]);
	    }
	}
	return (JInternalFrame[]) framesList
		.toArray(new JInternalFrame[framesList.size()]);
    }

    public static JInternalFrame[] getNonMinimizedNonToolWindows(
	    JInternalFrame[] frames) {
	if (frames == null) {
	    throw new IllegalArgumentException("Frames is null");
	}
	List framesList = new ArrayList();
	for (int i = 0; i < frames.length; ++i) {
	    JInternalFrame fr = frames[i];
	    if (!isToolWindow(fr) && !fr.isClosed() && !fr.isIcon()) {
		framesList.add(frames[i]);
	    }
	}
	return (JInternalFrame[]) framesList
		.toArray(new JInternalFrame[framesList.size()]);
    }

    public static boolean isWithinParent(Component component) {
	if (component == null) {
	    throw new IllegalArgumentException("Component is null");
	}

	Component parent = component.getParent();
	Rectangle parentRect = null;
	if (parent != null) {
	    parentRect = new Rectangle(parent.getSize());
	} else {
	    parentRect = new Rectangle(Toolkit.getDefaultToolkit()
		    .getScreenSize());
	}
	Rectangle windowBounds = component.getBounds();
	if (windowBounds.x > (parentRect.width - 20)
		|| windowBounds.y > (parentRect.height - 20)
		|| (windowBounds.x + windowBounds.width) < 20
		|| (windowBounds.y + windowBounds.height) < 20) {
	    return false;
	}
	return true;
    }

    private static void center(Component wind, Rectangle rect) {
	if (wind == null || rect == null) {
	    throw new IllegalArgumentException("Window or Rectangle is null");
	}
	Dimension windSize = wind.getSize();
	int x = ((rect.width - windSize.width) / 2) + rect.x;
	int y = ((rect.height - windSize.height) / 2) + rect.y;
	if (y < rect.y) {
	    y = rect.y;
	}
	wind.setLocation(x, y);
    }

    public static void prepareColumn(JTable table, int minColumnWidth,
	    int maxColumnWidth) {

	if (!(table.getModel() instanceof XAbstractTableModel))
	    return;
	XAbstractTableModel model = (XAbstractTableModel) table.getModel();
	ColumnProperty[] cd = model.getColumns();

	TableColumnModel cm = table.getColumnModel();

	int _multiplier = Toolkit.getDefaultToolkit().getFontMetrics(
		table.getFont()).stringWidth(STRING_DATA)
		/ STRING_DATA.length();
	// int _multiplier =
        // table.getFont().getLineMetrics().stringWidth(STRING_DATA) /
        // STRING_DATA.length();

	int count = cm.getColumnCount();
	int max = maxColumnWidth * _multiplier;
	int min = minColumnWidth * _multiplier;
	for (int i = 0; i < count; i++) {
	    int w = cd[i].getSize() * _multiplier;
	    if (GUIEnvironment.isLimitTableColumnSize()) {
		if (w > max) {
		    w = max;
		} else if (w < min) {
		    w = min;
		}
	    }
	    cm.getColumn(i).setPreferredWidth(w);
	    cm.getColumn(i).setWidth(w);
	}

    }

    public static void prepareColumn(JTable table) {
	prepareColumn(table, MIN_COLUMN_WIDTH, MAX_COLUMN_WIDTH);
    }

    public static Point computePopupLocation(MouseEvent event, Component rel,
	    JPopupMenu popup) {
	Dimension psz = popup.getSize();
	Dimension ssz = Toolkit.getDefaultToolkit().getScreenSize();
	Point gLoc = rel.getLocationOnScreen();
	Point result = new Point(event.getX(), event.getY());

	gLoc.x += event.getX();
	gLoc.y += event.getY();

	if (psz.width == 0 || psz.height == 0) {
	    // DRAT! Now we need to "estimate"...
	    int items = popup.getSubElements().length;
	    psz.height = (items * 22);
	    psz.width = 100;
	}

	psz.height += 5;

	if ((gLoc.x + psz.width) > ssz.width) {
	    result.x -= ((gLoc.x + psz.width) - ssz.width);
	    if ((gLoc.x + result.x) < 0)
		result.x = -(gLoc.x + event.getX());
	}

	if ((gLoc.y + psz.height) > ssz.height) {
	    result.y -= ((gLoc.y + psz.height) - ssz.height);
	    if ((gLoc.y + result.y) < 0)
		result.y = -gLoc.y;
	}

	return result;
    }

    public static Rectangle getMaximumWindowRectangle() {
	return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    }

    public static Dimension getMaximumWindowSize() {
	Rectangle rectangle = getMaximumWindowRectangle();
	return new java.awt.Dimension(rectangle.width, rectangle.height);
    }

}
