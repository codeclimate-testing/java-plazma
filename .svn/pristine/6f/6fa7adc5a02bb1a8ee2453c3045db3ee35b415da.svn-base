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
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 14.02.2004
 * Time: 14:16:41
 * $Id: StatusBar.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class StatusBar extends JPanel {
	
   
    private String messageWhenEmpty = " ";

    protected JLabel statusLabel;

    public StatusBar() {
        super(new BorderLayout());
        createGUI();
    }

    public StatusBar(LayoutManager layout) {
        super(layout);
        createGUI();
    }

    public synchronized void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Font == null");
        }
        super.setFont(font);
        if (statusLabel != null) {
            statusLabel.setFont(font);
        }
    }


    public synchronized void setText(String text) {
        String myText = null;
        if (text != null) {
            myText = text.trim();
        } if (myText != null && myText.length() > 0) {
            statusLabel.setText(myText);
        } else {
            clearText();
        }
    }

    public synchronized void clearText() {
        statusLabel.setText(messageWhenEmpty);
    }

    public synchronized void setTextWhenEmpty(String value) {
        final boolean wasEmpty = statusLabel.getText().equals(messageWhenEmpty);
        if (value != null && value.length() > 0) {
            messageWhenEmpty = value;
        } else {
            messageWhenEmpty = " ";
        } if (wasEmpty) {
            clearText();
        }
    }

    protected void createGUI() {
        statusLabel = new JLabel();
        statusLabel.setBorder(createComponentBorder());
        add(statusLabel, BorderLayout.CENTER);
        clearText();
    }

    public static Border createComponentBorder()  {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createBevelBorder(BevelBorder.LOWERED),
            BorderFactory.createEmptyBorder(0, 4, 0, 4));
    }


}
