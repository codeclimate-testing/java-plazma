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
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 07.12.2003
 * Time: 8:06:27
 */
public class XLabel extends JLabel {

    protected int fixedWidth;

    public XLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public XLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public XLabel(String text) {
        super(text);
    }

    public XLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public XLabel(Icon image) {
        super(image);
    }

    public XLabel() {
    }

    public XLabel(int fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public int getFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(int fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        if (fixedWidth > 0) d.width = fixedWidth;
        return d;
    }
}
