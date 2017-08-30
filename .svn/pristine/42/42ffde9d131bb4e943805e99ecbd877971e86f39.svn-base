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

package org.plazmaforge.framework.client.swing.gui.table;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Oleh Hapon
 * 
 * $Id: BooleanImageCellRenderer.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 * 
 */

public class BooleanImageCellRenderer extends DefaultTableCellRenderer {

    private Icon booleanIcon;

    public BooleanImageCellRenderer() {
	super();
	setHorizontalAlignment(JLabel.CENTER);
    }

    public BooleanImageCellRenderer(Icon booleanIcon) {
	this();
	this.booleanIcon = booleanIcon;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	if (booleanIcon == null) {
	    setIcon(null);
	} else {
	    if (getBoolean(value)) {
		setIcon(booleanIcon);
	    } else {
		setIcon(null);
	    }
	}
	return super.getTableCellRendererComponent(table, value, isSelected,
		hasFocus, row, column);
    }

    protected void setValue(Object value) {
	//
    }

    private boolean getBoolean(Object value) {
	if (value == null) {
	    return false;
	}
	if (value instanceof Boolean) {
	    return ((Boolean) value).booleanValue();
	}
	return false;
    }

    public Icon getBooleanIcon() {
	return booleanIcon;
    }

    public void setBooleanIcon(Icon booleanIcon) {
	this.booleanIcon = booleanIcon;
    }

}
