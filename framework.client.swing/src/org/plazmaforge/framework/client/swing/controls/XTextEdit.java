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

import javax.swing.JScrollPane;

public class XTextEdit extends JScrollPane implements XControl, XTextControl {

    public static final int DEFAULT_ROWS = 10;

    private XTextArea textArea;

    public XTextEdit(int rows, int cols) {
	super();
	initialize();
	textArea.setRows(rows);
	textArea.setColumns(cols);
    }

    public XTextEdit() {
	super();
	initialize();
    }

    private void initialize() {
	textArea = new XTextArea();
	setViewportView(textArea);
	textArea.setRows(DEFAULT_ROWS);
    }

    public XTextArea getTextArea() {
	return textArea;
    }

    public void setValue(Object value) {
	getTextArea().setValue(value);
    }

    public Object getValue() {
	return getTextArea().getValue();
    }

    public void setText(String text) {
	getTextArea().setText(text);
    }

    public String getText() {
	return getTextArea().getText();
    }

    public int getColumns() {
	return getTextArea().getColumns();
    }

    public void setColumns(int columns) {
	getTextArea().setColumns(columns);
    }

    public int getRows() {
	return getTextArea().getRows();
    }

    public void setRows(int rows) {
	getTextArea().setRows(rows);
    }

}
