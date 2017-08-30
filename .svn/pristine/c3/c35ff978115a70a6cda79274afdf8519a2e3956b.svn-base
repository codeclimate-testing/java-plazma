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
 * Created on 29.09.2008
 *
 */

package org.plazmaforge.framework.client.swt.controls;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

/** 
 * @author Oleh Hapon
 * $Id: ToolButton.java,v 1.2 2010/04/28 06:36:48 ohapon Exp $
 */

public class ToolButton extends Composite {

    private static final int SPACING = 0; //4;

    private static final int MARGIN_WIDTH = 0; //9;

    private static final int MARGIN_HEIGHT = 0; //2;

    
    private final Color startBackColor = new Color(Display.getCurrent(), new RGB(255, 255, 255));

    private final Color endBackColor = new Color(Display.getCurrent(), new RGB(177, 176, 181));

    private final Color foreColorDisabled = new Color(Display.getCurrent(), 159, 159, 159);

    private String text;

    
    
    private final Set<SelectionListener> selectionListeners = new LinkedHashSet<SelectionListener>();

    private boolean isPressed = false;

    private Image image;

    private int buttonStyle = SWT.NONE;
    
    public ToolButton(Composite parent, int style) {
	super(parent, SWT.NONE);
	buttonStyle = style;
	
        addDisposeListener(new DisposeListener() {
            /**
             * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
             */
            public void widgetDisposed(DisposeEvent e) {
                ToolButton.this.disposeControl();
            }
        });
        addMouseListener(new MouseAdapter() {
            /**
             * @see org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt.events.MouseEvent)
             */
            public void mouseDown(MouseEvent e) {
        	ToolButton.this.mouseDowned(e);
            }

            /**
             * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
             */
            public void mouseUp(MouseEvent e) {
        	ToolButton.this.mouseUped(e);
            }
        });
        addPaintListener(new PaintListener() {
            /**
             * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
             */
            public void paintControl(PaintEvent e) {
        	ToolButton.this.paintControl(e.gc);
            }
        });
	
    }

    
    /**
     * Adds the selection listener.
     * 
     * @param listener -
     *            The listener.
     */
    public void addSelectionListener(SelectionListener listener) {
        selectionListeners.add(listener);
    }

    /**
     * @see org.eclipse.swt.widgets.Composite#computeSize(int, int, boolean)
     */
    public Point computeSize(int wHint, int hHint, boolean changed) {
        int width = 0;
        int height = 0;
        if (text != null) {
            final GC gc = new GC(this);
            final Point extent = gc.stringExtent(text);
            gc.dispose();
            width += extent.x;
            height += extent.y;
        }
        if (image != null) {
            width += image.getBounds().width + SPACING;
            height = Math.max(height, image.getBounds().height);
        }
        width += MARGIN_WIDTH * 2;
        height += MARGIN_HEIGHT * 2;
        if (wHint != SWT.DEFAULT) {
            width = wHint;
        }
        if (hHint != SWT.DEFAULT) {
            height = hHint;
        }
        return new Point(width, height);
    }

    protected void disposeControl() {
        if (!foreColorDisabled.isDisposed()) {
            foreColorDisabled.dispose();
        }
        if (!startBackColor.isDisposed()) {
            startBackColor.dispose();
        }
        if (!endBackColor.isDisposed()) {
            endBackColor.dispose();
        }
    }

    public String getText() {
        return text;
    }

    protected void mouseDowned(MouseEvent e) {
        isPressed = true;
        redraw();
    }

    protected void mouseUped(MouseEvent e) {
        isPressed = false;
        redraw();
        for (SelectionListener selectionListener : selectionListeners) {
            final Event selectionEvent = new Event();
            selectionEvent.widget = ToolButton.this;
            selectionListener.widgetSelected(new SelectionEvent(selectionEvent));
        }
    }
    
    protected boolean isFlatButtonStyle() {
	return (buttonStyle & SWT.FLAT) != 0;
    }

    /**
     * Paints border around the text widget.
     * 
     * @param gc - Graphics context.
     */
    private void paintControl(GC gc) {
        final Rectangle clientArea = getClientArea();

        // Paint gradient rectangle
        gc.setForeground(isPressed ? endBackColor : startBackColor);
        gc.setBackground(isPressed ? startBackColor : endBackColor);
        
        boolean flatStyle = isFlatButtonStyle(); 
        if (!flatStyle || (flatStyle && isPressed)) {
            gc.fillGradientRectangle(clientArea.x, clientArea.y, clientArea.width, clientArea.height, true);
        }
        
        // Paint border
        /*
        // 1
        gc.setForeground(new Color(Display.getCurrent(), new RGB(188, 188, 190)));
        gc.drawRectangle(clientArea.x, clientArea.y, clientArea.width - 1, clientArea.height - 1);

        gc.setForeground(new Color(Display.getCurrent(), new RGB(252, 252, 254)));
        gc.drawLine(clientArea.x, clientArea.y + clientArea.height - 6, clientArea.x, clientArea.y + clientArea.height
                - 1);
        gc.drawLine(clientArea.x, clientArea.y + clientArea.height - 1, clientArea.x + clientArea.width - 1,
                clientArea.y + clientArea.height - 1);
        gc.drawLine(clientArea.x + clientArea.width - 1, clientArea.y + clientArea.height - 6, clientArea.x
                + clientArea.width - 1, clientArea.y + clientArea.height - 1);

        // 2
        gc.setForeground(new Color(Display.getCurrent(), new RGB(97, 97, 97)));
        gc.drawRectangle(clientArea.x + 1, clientArea.y + 1, clientArea.width - 3, clientArea.height - 3);

        // 3
        gc.setForeground(new Color(Display.getCurrent(), new RGB(225, 225, 225)));
        gc.drawRectangle(clientArea.x + 2, clientArea.y + 2, clientArea.x + clientArea.width - 5, clientArea.y
                + clientArea.height - 5);

        gc.setForeground(new Color(Display.getCurrent(), new RGB(182, 184, 183)));
        gc.drawLine(clientArea.x + 2, clientArea.y + clientArea.height - 3, clientArea.x + clientArea.width - 3,
                clientArea.y + clientArea.height - 3);
        
        */
        
        

        int imageStartX = 0;
        int imageStartY = 0;
        int textStartX = 0;
        int textStartY = 0;

        if (image != null) {
            final Rectangle imageBounds = image.getBounds();
            if (text != null) {
                imageStartX = clientArea.x + (clientArea.width - gc.textExtent(text).x - imageBounds.width - SPACING) / 2;
            } else {
                imageStartX = clientArea.x + (clientArea.width - imageBounds.width) / 2;
            }
            imageStartY = clientArea.y + (clientArea.height - imageBounds.height) / 2;
            gc.drawImage(image, imageStartX, imageStartY);
        }

        if (text != null) {
            final Point extent = gc.textExtent(text);
            if (image != null) {
                textStartX = imageStartX + image.getBounds().width + SPACING;
            } else {
                textStartX = clientArea.x + clientArea.width / 2 - extent.x / 2;
            }
            textStartY = clientArea.y + clientArea.height / 2 - extent.y / 2;
            gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
            gc.drawString(text, textStartX, textStartY + 1, true);
            gc.setForeground(getForeground());
            gc.drawString(text, textStartX, textStartY, true);
        }
    }

    public void setImage(Image image) {
        this.image = image;
        redraw();
    }

    public void setText(String text) {
        this.text = text;
        redraw();
    }

    public boolean getSelection() {
        return false;
    }

    public void setSelection(boolean b) {
	//
    } 

    
}
