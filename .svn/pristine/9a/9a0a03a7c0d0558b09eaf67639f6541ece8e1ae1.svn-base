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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/** 
 * @author Oleh Hapon
 *
 */

public class XCombo extends Combo {

    public XCombo(Composite parent, int style) {
	super(parent, style);
    }

    public XCombo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
    }

    
    protected void setPopupSize() {
	if (popup == null || text == null) {
	    return;
	}
	Point size = popup.getSize();
	Point textSize = getSize();
	popup.setSize(textSize.x, size.y);
    }
  
}
