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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;

/**
 * 
 * @author Oleh Hapon
 * $Id: XTextArea.java,v 1.3 2010/04/28 06:36:48 ohapon Exp $
 */
public class XTextArea extends XTextField {

    private int fixedHeight = 0;
    
    public XTextArea(Composite parent, int style) {
	super(parent, style);
    }

    public XTextArea(Composite parent) {
	super(parent);
    }

    protected void createTextControl(int style) {
	if ((style & SWT.H_SCROLL) == 0) {
	    style |= SWT.H_SCROLL;
	}
	if ((style & SWT.V_SCROLL) == 0) {
	    style |= SWT.V_SCROLL;
	}
	super.createTextControl(style);
	initTextScrollBars();
    }
    
    private void initTextScrollBars() {
	if (text == null) {
	    return;
	}
	text.getHorizontalBar().setVisible(false);
	text.getVerticalBar().setVisible(false);
	
	text.addListener(SWT.Resize, new Listener() {
	    public void handleEvent (Event event)  {
		changeScrollBarsState(text);
	    }
	});
	text.addListener(SWT.Modify, new Listener() {
	    public void handleEvent (Event event)  {
		changeScrollBarsState(text);
	    }
	});
    }
    
    private void changeScrollBarsState(Scrollable scrollable) {
	Rectangle clientRec = scrollable.getClientArea();
	
	ScrollBar hBar = scrollable.getHorizontalBar();
	ScrollBar vBar = scrollable.getVerticalBar();
	
	Point hBarSize = hBar.getSize();
	Point vBarSize = vBar.getSize();
	
	Point p = scrollable.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	
	int borderWidth = scrollable.getBorderWidth() * 2;
	
	int hBarWidh = clientRec.width + vBarSize.x + borderWidth;
	int vBarWidh = clientRec.height + hBarSize.y + borderWidth;
	
	hBar.setVisible(p.x > hBarWidh);
	vBar.setVisible(p.y > vBarWidh);
    }

    public Point computeSize(int wHint, int hHint, boolean changed) {
	checkWidget();
	Point size = super.computeSize(wHint, hHint, changed);
	if (fixedHeight > 0) {
	    size.y = fixedHeight; 
	}
	return size;
    }

    public int getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(int fixedHeight) {
        this.fixedHeight = fixedHeight;
    }	
    
    
}
