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

import org.plazmaforge.framework.client.swing.gui.table.BooleanImageCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.NumberCellRenderer;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 06.11.2004
 * Time: 9:03:37
 * $Id: GUIEnvironment.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */

public class GUIEnvironment implements GUIConstants {


    private static boolean limitTableColumnSize;
    private static TablePreferences tablePreferences;

    private static int gridLayoutLabelAnchor;
    private static Insets emptyBordertInsets;
    private static Insets gridLayoutInsets;


    private static GUIEnvironment ourInstance;

    static {

        limitTableColumnSize = false;

        tablePreferences = new TablePreferences();
        tablePreferences.setColReorderingAllowed(DEFAULT_TABLE_COL_REORDERING_ALLOWED);
        tablePreferences.setHorizontalLines(DEFAULT_TABLE_HORIZONTAL_LINES);
        tablePreferences.setVerticalLines(DEFAULT_TABLE_VERTICAL_LINES);
        tablePreferences.setColSelectionAllowed(DEFAULT_TABLE_COL_SELECTION_ALLOWED);
        tablePreferences.setRowSelectionAllowed(DEFAULT_TABLE_ROW_SELECTION_ALLOWED);
        tablePreferences.setSelectionMode(DEFAULT_TABLE_SELECTION_MODE);
        tablePreferences.setAutoResizeMode(DEFAULT_TABLE_AUTO_RESIZE_MODE);

        gridLayoutLabelAnchor = DEFAULT_GRID_LAYOUT_LABEL_ANCHOR;
        emptyBordertInsets    = DEFAULT_EMPTY_BORDER_INSETS;
        gridLayoutInsets      = DEFAULT_GRID_LAYOUT_INSETS;
    }

    public synchronized static GUIEnvironment getInstance() {
        if (ourInstance == null) {
            ourInstance = new GUIEnvironment();
        }
        return ourInstance;
    }

    private GUIEnvironment() {
    }

    public static boolean isLimitTableColumnSize() {
        return limitTableColumnSize;
    }

    /**
     * Setting limit Table Column Size
     * @param limitTableColumnSize
     */
    public static void setLimitTableColumnSize(boolean limitTableColumnSize) {
        GUIEnvironment.limitTableColumnSize = limitTableColumnSize;
    }

    public static TablePreferences getTablePreferences() {
        return tablePreferences;
    }

    public static class TablePreferences {

        private boolean colReorderingAllowed;
        private boolean horizontalLines;
        private boolean verticalLines;
        private boolean colSelectionAllowed;
        private boolean rowSelectionAllowed;
        private int selectionMode;
        private int autoResizeMode;

        public boolean isColReorderingAllowed() {
            return colReorderingAllowed;
        }

        public void setColReorderingAllowed(boolean colReorderingAllowed) {
            this.colReorderingAllowed = colReorderingAllowed;
        }

        public boolean isHorizontalLines() {
            return horizontalLines;
        }

        public void setHorizontalLines(boolean horizontalLines) {
            this.horizontalLines = horizontalLines;
        }

        public boolean isVerticalLines() {
            return verticalLines;
        }

        public void setVerticalLines(boolean verticalLines) {
            this.verticalLines = verticalLines;
        }

        public boolean isColSelectionAllowed() {
            return colSelectionAllowed;
        }

        public void setColSelectionAllowed(boolean colSelectionAllowed) {
            this.colSelectionAllowed = colSelectionAllowed;
        }

        public boolean isRowSelectionAllowed() {
            return rowSelectionAllowed;
        }

        public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
            this.rowSelectionAllowed = rowSelectionAllowed;
        }

        public int getSelectionMode() {
            return selectionMode;
        }

        public void setSelectionMode(int selectionMode) {
            this.selectionMode = selectionMode;
        }

        public int getAutoResizeMode() {
            return autoResizeMode;
        }

        public void setAutoResizeMode(int autoResizeMode) {
            this.autoResizeMode = autoResizeMode;
        }
    }


    public static CurrencyCellRenderer createCurrencyTableCellRenderer() {
        return new CurrencyCellRenderer();
    }

    public static NumberCellRenderer createNumberTableCellRenderer(int decimal) {
        return new NumberCellRenderer(decimal);
    }

    public static BooleanImageCellRenderer createBooleanImageCellRenderer(Icon icon) {
        return new BooleanImageCellRenderer(icon);
    }    
    
    
    public static int getGridLayoutLabelAnchor() {
        return gridLayoutLabelAnchor;
    }

    public static void setGridLayoutLabelAnchor(int gridLayoutLabelAnchor) {
        GUIEnvironment.gridLayoutLabelAnchor = gridLayoutLabelAnchor;
    }

    public static Insets getEmptyBordertInsets() {
        return emptyBordertInsets;
    }

    public static void setEmptyBordertInsets(Insets emptyBordertInsets) {
        GUIEnvironment.emptyBordertInsets = emptyBordertInsets;
    }

    public static Insets getGridLayoutInsets() {
        return gridLayoutInsets;
    }

    public static void setGridLayoutInsets(Insets gridLayoutInsets) {
        GUIEnvironment.gridLayoutInsets = gridLayoutInsets;
    }

    public static Border createEmptyBorder() {
        return BorderFactory.createEmptyBorder(emptyBordertInsets.top, emptyBordertInsets.left, emptyBordertInsets.bottom, emptyBordertInsets.right);
    }

    public static Insets createGridLayoutInsets() {
        return new Insets(gridLayoutInsets.top, gridLayoutInsets.left, gridLayoutInsets.bottom, gridLayoutInsets.right);
    }
}

