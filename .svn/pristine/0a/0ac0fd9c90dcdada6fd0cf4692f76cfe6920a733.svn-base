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
 * @author Oleh Hapon Date: 7.10.2003 Time: 12:12:15
 */
public class DialogSeparator extends JLabel {

    public static final int OFFSET = 15;

    public DialogSeparator() {
    }

    public DialogSeparator(String text) {
	super(text);
    }

    public Dimension getPreferredSize() {
	return new Dimension(getParent().getWidth(), 20);
    }

    public Dimension getMinimumSize() {
	return getPreferredSize();
    }

    public Dimension getMaximumSize() {
	return getPreferredSize();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(getBackground());
	g.fillRect(0, 0, getWidth(), getHeight());

	Dimension d = getSize();
	int y = (d.height - 3) / 2;
	g.setColor(Color.white);
	g.drawLine(1, y, d.width - 1, y);
	y++;
	g.drawLine(0, y, 1, y);
	g.setColor(Color.gray);
	g.drawLine(d.width - 1, y, d.width, y);
	y++;
	g.drawLine(1, y, d.width - 1, y);

	String text = getText();
	if (text.length() == 0)
	    return;

	g.setFont(getFont());
	FontMetrics fm = g.getFontMetrics();
	y = (d.height + fm.getAscent()) / 2;
	int l = fm.stringWidth(text);

	g.setColor(getBackground());
	g.fillRect(OFFSET - 5, 0, OFFSET + l, d.height);

	g.setColor(getForeground());
	g.drawString(text, OFFSET, y);
    }

}
