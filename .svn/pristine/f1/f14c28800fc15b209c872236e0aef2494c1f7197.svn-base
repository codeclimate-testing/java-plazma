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

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class XTable extends JTable {

    private boolean enableVirtualRows = true;

    public XTable() {
	super();
	initialize();
    }

    public XTable(TableModel dm) {
	super(dm);
	initialize();
    }

    public XTable(TableModel dm, TableColumnModel cm) {
	super(dm, cm);
	initialize();
    }

    public XTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
	super(dm, cm, sm);
	initialize();
    }

    public XTable(int numRows, int numColumns) {
	super(numRows, numColumns);
	initialize();
    }

    public XTable(Vector rowData, Vector columnNames) {
	super(rowData, columnNames);
	initialize();
    }

    public XTable(Object[][] rowData, Object[] columnNames) {
	super(rowData, columnNames);
	initialize();
    }

    private void initialize() {
	// TODO: HARD CODE. Must use UIManager.getColor("...");
	setBackground(Color.WHITE);
    }

    public boolean isEnableVirtualRows() {
	return enableVirtualRows;
    }

    public void setEnableVirtualRows(boolean enableVirtualRow) {
	this.enableVirtualRows = enableVirtualRow;
    }

    public void paint(Graphics g) {
	super.paint(g);
	paintVirtualRows(g);
    }

    public void paintVirtualRows(Graphics g) {
	if (/* !this.isEnableVirtualRows() || */getColumnCount() <= 0) {
	    return;
	}
	/*
         * if (getRowCount() <= 0 || getColumnCount() <= 0) { return; }
         */
	Rectangle clip = g.getClipBounds();
	Point upperLeft = clip.getLocation();
	Point lowerRight = new Point(clip.x + clip.width - 1, clip.y
		+ clip.height - 1);
	int rMin = rowAtPoint(upperLeft);
	int rMax = rowAtPoint(lowerRight);

	// This should never happen.
	if (rMin == -1) {
	    rMin = 0;
	}

	// If the table does not have enough rows to fill the view we'll get -1.
	// Replace this with the index of the last row.
	if (rMax == -1) {
	    rMin = getRowCount() - 1;
	    rMax = getHeight() / getRowHeight(); // getRowCount() + 10;
                                                        // // getRowCount()-1;
	} else {
	    return;
	}

	boolean ltr = getComponentOrientation().isLeftToRight();
	int cMin = columnAtPoint(ltr ? upperLeft : lowerRight);
	int cMax = columnAtPoint(ltr ? lowerRight : upperLeft);

	// This should never happen.
	if (cMin == -1) {
	    cMin = 0;
	}

	// If the table does not have enough columns to fill the view we'll get
        // -1.
	// Replace this with the index of the last column.
	if (cMax == -1) {
	    cMax = getColumnCount() - 1;
	}

	// Paint the grid.
	paintGrid(g, rMin, rMax, cMin, cMax);

	// Paint the cells.
	// paintCells(g, rMin, rMax, cMin, cMax);
    }

    /*
         * Paints the grid lines within <I>aRect</I>, using the grid color set
         * with <I>setGridColor</I>. Paints vertical lines if <code>getShowVerticalLines()</code>
         * returns true and paints horizontal lines if <code>getShowHorizontalLines()</code>
         * returns true.
         */
    private void paintGrid(Graphics g, int rMin, int rMax, int cMin, int cMax) {
	g.setColor(getGridColor());

	Rectangle minCell = getCellRect(rMin, cMin, true);
	Rectangle maxCell = getCellRect(rMax, cMax, true);
	Rectangle damagedArea = minCell.union(maxCell);

	if (getShowHorizontalLines()) {
	    int tableWidth = damagedArea.x + damagedArea.width;
	    int y = damagedArea.y;
	    for (int row = rMin; row <= rMax; row++) {
		y += getRowHeight(); // getRowHeight(row);
		g.drawLine(damagedArea.x, y - 1, tableWidth - 1, y - 1);
	    }
	}
	if (getShowVerticalLines()) {
	    TableColumnModel cm = getColumnModel();
	    int tableHeight = damagedArea.y + damagedArea.height;
	    int x;
	    if (getComponentOrientation().isLeftToRight()) {
		x = damagedArea.x;
		for (int column = cMin; column <= cMax; column++) {
		    int w = cm.getColumn(column).getWidth();
		    x += w;
		    g.drawLine(x - 1, 0, x - 1, tableHeight - 1);
		}
	    } else {
		x = damagedArea.x + damagedArea.width;
		for (int column = cMin; column < cMax; column++) {
		    int w = cm.getColumn(column).getWidth();
		    x -= w;
		    g.drawLine(x - 1, 0, x - 1, tableHeight - 1);
		}
		x -= cm.getColumn(cMax).getWidth();
		g.drawLine(x, 0, x, tableHeight - 1);
	    }
	}

    }

    public Dimension getPreferredSize() {
	Dimension dimension = super.getPreferredSize();
	Container parent = getParent();
	if (parent == null || !(parent instanceof JViewport)
		|| !isEnableVirtualRows()) {
	    return dimension;
	}
	int parentHeight = parent.getSize().height;
	if (dimension.height < parentHeight) {
	    dimension.height = parentHeight;
	}
	return dimension;

    }

}
