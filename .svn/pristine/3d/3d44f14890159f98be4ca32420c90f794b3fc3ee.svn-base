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
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 29.9.2003
 * Time: 15:37:03
 */
public class ToolButton extends JButton {

    public static final int PREFERRED_WIDTH = 22;
	
    public static final int PREFERRED_HEIGHT = 22;

    public ToolButton() {
        super();
        setPreferredSize(new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT));
        setFocusPainted(false);
    }

    public ToolButton(Action action) {
        this();
        setAction(action);
    }


    public ToolButton(Icon icon) {
        this();
        setIcon(icon);
    }

    public ToolButton(String text) {
        this();
        setText(text);
    }

    public ToolButton(String text, Icon icon) {
        this();
        setIcon(icon);
        setText(text);
    }

    public Insets getInsets() {return new Insets(0,0,0,0);}


    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

}
