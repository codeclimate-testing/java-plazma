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

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class XTextArea extends JTextArea implements XControl, XTextControl {

    public XTextArea() {
	super();
	initialize();
    }

    public XTextArea(Document doc, String text, int rows, int columns) {
	super(doc, text, rows, columns);
	initialize();
    }

    public XTextArea(Document doc) {
	super(doc);
	initialize();
    }

    public XTextArea(int rows, int columns) {
	super(rows, columns);
	initialize();
    }

    public XTextArea(String text, int rows, int columns) {
	super(text, rows, columns);
	initialize();
    }

    public XTextArea(String text) {
	super(text);
	initialize();
    }

    private void initialize() {
	setLineWrap(true);
	this.setTabSize(0);
    }

    /*
         * public Dimension getPreferredSize() { Dimension d =
         * super.getPreferredSize(); if (getColumns() != 0) { //d.width =
         * Math.max(d.width, getColumns() * getColumnWidth()); d.width =
         * getColumns() * getColumnWidth(); } if (getRows() != 0) { //d.height =
         * Math.max(d.height, getRows() * getRowHeight()); d.height = getRows() *
         * getRowHeight(); } return d; }
         */

    public void setValue(Object value) {
	if (value == null) {
	    setText(null);
	    return;
	}
	setText(value.toString());
    }

    public Object getValue() {
	return getText();
    }

}
