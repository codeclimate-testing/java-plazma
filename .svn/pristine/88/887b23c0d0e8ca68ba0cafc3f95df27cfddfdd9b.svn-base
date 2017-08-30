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
 * Date: 13.11.2003
 * Time: 9:24:07
 */
public class XMenuItem extends JMenuItem {

    public static final int ICON_MARGIN = 16;

    protected int iconMargin = ICON_MARGIN;
	
    protected Insets marginInsets;
	
    protected Insets defaultInsets;


    public XMenuItem() {
        super();
        defaultInsets = super.getInsets();
        setIconMargin(iconMargin);
    }

    public XMenuItem(String text) {
        this();
        setText(text);
    }

    public Insets getInsets() {
        return marginInsets;
    }

    public void setIcon(Icon icon) {
        super.setIcon(icon);
        int margin = (icon == null) ? iconMargin : 0;
        setIconMargin(margin);
    }

    public void setIconMargin(int margin) {
        int top = defaultInsets.top;
        int left = defaultInsets.left;
        int bottom = defaultInsets.bottom;
        int right = defaultInsets.right;
        marginInsets = new Insets(top, left, bottom, right);
        if (getIcon() == null) {
            iconMargin = margin;
            marginInsets.left += iconMargin + getIconTextGap();
        } else {
            iconMargin = 0;
        }

    }


}
