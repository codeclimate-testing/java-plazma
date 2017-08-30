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
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created on 07.06.2006
 */
public class IndicatorListCellRenderer  extends DefaultListCellRenderer {


    private Icon defaultIcon;


    public IndicatorListCellRenderer() {
    }

    public Icon getDefaultIcon() {
        return defaultIcon;
    }

    public void setDefaultIcon(Icon defaultIcon) {
        this.defaultIcon = defaultIcon;
    }

    public Component getListCellRendererComponent(JList list,  Object value,  int index,  boolean isSelected,  boolean cellHasFocus) {

        setComponentOrientation(list.getComponentOrientation());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setIcon(getIcon(list,  value,  index, isSelected, cellHasFocus));
        setText((value == null) ? "" : value.toString());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        Border border = null;
        if (cellHasFocus) {
            if (isSelected) {
                border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
            }
            if (border == null) {
                border = UIManager.getBorder("List.focusCellHighlightBorder");
            }
        } else {
            border = noFocusBorder; //getNoFocusBorder();
        }
        setBorder(border);

        return this;
    }

    protected Icon getIcon(JList list,  Object value,  int index,  boolean isSelected,  boolean cellHasFocus) {
        return getDefaultIcon();
    }

}
