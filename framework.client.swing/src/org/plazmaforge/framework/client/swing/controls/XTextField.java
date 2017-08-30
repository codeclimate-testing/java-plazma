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
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/**
 * @author Oleh Hapon Date: 20.10.2003 Time: 16:01:06
 */
public class XTextField extends JTextField {

    private boolean textTrim;

    private int maxChar;

    public XTextField() {
	super();
	initialize();
    }

    public XTextField(String str) {
	super(str);
	initialize();
    }

    public XTextField(int columns) {
	super(columns);
	initialize();
    }

    public XTextField(String text, int columns) {
	super(text, columns);
	initialize();
    }

    public XTextField(Document doc, String text, int columns) {
	super(doc, text, columns);
	initialize();
    }

    public int getMaxChar() {
	return maxChar;
    }

    public void setMaxChar(int maxChar) {
	this.maxChar = maxChar;
    }

    public boolean isTextTrim() {
	return textTrim;
    }

    public void setTextTrim(boolean textTrim) {
	this.textTrim = textTrim;
    }

    private void initialize() {
	textTrim = true;
	addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent evt) {
		// selectAll();
	    }

	    public void focusLost(FocusEvent evt) {
		// setText(getText());
		// select(0, 0);
		// setCaretPosition(0);
	    }
	});

    }

    public void setText(String text) {
	if (textTrim && text != null) {
	    super.setText(text.trim());
	} else {
	    super.setText(text);
	}
	setCaretPosition(0);
    }

    public String getText() {
	if (textTrim) {
	    return super.getText().trim();
	}
	return super.getText();
    }

    protected Document createDefaultModel() {
	return new XTextDocument();
    }

    private class XTextDocument extends PlainDocument {

	public void insertString(int offs, String str, AttributeSet a)
		throws BadLocationException {
	    if (str == null) {
		super.insertString(offs, str, a);
	    } else {
		String currentText = getText(0, getLength());
		String beforeOffset = currentText.substring(0, offs);
		String afterOffset = currentText.substring(offs, currentText
			.length());
		String proposedResult = beforeOffset + str + afterOffset;
		if ((maxChar > 0) && (proposedResult.length() > maxChar)) {
		    super.remove(0, currentText.length());
		    super.insertString(0, proposedResult.substring(0, maxChar),
			    a);
		} else {
		    super.insertString(offs, str, a);
		}
	    }
	}
    }

}
