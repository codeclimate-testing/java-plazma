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

package org.plazmaforge.framework.client.swing.gui.table;


import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;

import org.plazmaforge.framework.client.swing.controls.GradientPercentPainter;

import java.awt.*;

/**
 * Created 23.05.2006
 */
public class GradientPercentCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    private GradientPercentPainter painter = new GradientPercentPainter();

    public void setValue(Object value) {
        if (value != null && value instanceof Number) {
            painter.setPercent(((Number) value).floatValue());
        } else {
            painter.setPercent(0);
        }
    }

    private boolean isSelected;

    private boolean hasFocus;

    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        this.isSelected = isSelected;
        this.hasFocus = hasFocus;
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }


    public void paint(Graphics g) {

        super.paint(g);

        painter.setX(0);
        painter.setY(0);
        painter.setWidth(getWidth());
        painter.setHeight(getHeight());

        // TODO: Set gradient color by isSelected
        
        painter.paint(g);

    }

}
