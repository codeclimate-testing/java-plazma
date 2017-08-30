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
 * Date: 13.8.2003
 * Time: 16:31:45
 */
public class LayoutUtilities {

    public static void setConstraints(GridBagLayout layout, JComponent component,GridBagConstraints gbc, int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        layout.setConstraints(component, gbc);
    }

    public static void add(JComponent container, JComponent component, GridBagLayout layout, GridBagConstraints gbc, int x, int y, int width, int height) {
        setConstraints(layout, component, gbc, x, y, width, height);
        container.add(component);
    }

    public static void add(JComponent container, JComponent component, GridBagConstraints gbc, int x, int y, int width, int height) {
        LayoutManager lm = container.getLayout();
        if (!(lm instanceof GridBagLayout)) throw new IllegalArgumentException();
        GridBagLayout layout = (GridBagLayout)lm;
        setConstraints(layout, component, gbc, x, y, width, height);
        container.add(component);
    }

    public static void add(JComponent container, JComponent component, GridBagLayout layout, GridBagConstraints gbc, int x, int y) {
        setConstraints(layout, component, gbc, x, y, 1, 1);
        container.add(component);
    }

    public static void add(JComponent container, JComponent component, GridBagConstraints gbc, int x, int y) {
        add(container, component, gbc, x, y, 1, 1);
    }




}
