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

package org.plazmaforge.framework.client.swing.controls;

import javax.swing.*;

import org.plazmaforge.framework.client.swing.gui.XDefaultComboBoxModel;


import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

/**
 * @author Oleh Hapon Date: 20.10.2004 Time: 8:22:50 $Id: XComboBox.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */
public class XComboBox extends JComboBox implements XControl {

    private int preferredWidth;

    private int preferredHeight;

    public XComboBox(List items) {
	super();
	setModel(new XDefaultComboBoxModel(items));
    }

    public XComboBox(ComboBoxModel aModel) {
	super(aModel);
    }

    public XComboBox(final Object items[]) {
	super(items);
    }

    public XComboBox(Vector items) {
	super(items);
    }

    public XComboBox() {
    }

    public void setValue(Object value) {
	this.setSelectedItem(value);
    }

    public Object getValue() {
	return this.getSelectedItem();
    }

    public int getPreferredWidth() {
	return preferredWidth;
    }

    public void setPreferredWidth(int preferredWidth) {
	this.preferredWidth = preferredWidth;
    }

    public int getPreferredHeight() {
	return preferredHeight;
    }

    public void setPreferredHeight(int preferredHeight) {
	this.preferredHeight = preferredHeight;
    }

    public Dimension getPreferredSize() {
	Dimension d = super.getPreferredSize();
	if (preferredWidth > 0)
	    d.width = preferredWidth;
	if (preferredHeight > 0)
	    d.height = preferredHeight;
	return d;
    }

}
