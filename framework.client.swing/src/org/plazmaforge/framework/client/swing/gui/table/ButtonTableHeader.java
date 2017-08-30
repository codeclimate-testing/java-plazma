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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;

import org.plazmaforge.framework.resources.LibraryResources;
import org.plazmaforge.framework.resources.ResourcesConstants;


import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.*;

/**
 * @author Oleh Hapon Date: 01.06.2004 Time: 12:05:19 $Id: ButtonTableHeader.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class ButtonTableHeader extends JTableHeader implements
	ResourcesConstants {

    private static Icon ascIcon;

    private static Icon descIcon;

    private TableDataListener dataListener = new TableDataListener();

    private boolean pressed;

    private boolean dragged;

    private int pressedColumnIndex;

    private int releasedColumnIndex;

    private Icon currentSortedColumnIcon;

    private int currentSortedColumnIndex = -1;

    static {
	try {
	    LibraryResources rsrc = LibraryResources.getInstance();
	    descIcon = rsrc.getIcon(LibraryResources.TABLE_DESCENDING);
	    ascIcon = rsrc.getIcon(LibraryResources.TABLE_ASCENDING);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    /**
         * Constructor for ButtonTableHeader.
         */
    public ButtonTableHeader() {
	super();
	pressed = false;
	dragged = false;
	pressedColumnIndex = -1;
	releasedColumnIndex = -1;

	setDefaultRenderer(new ButtonTableRenderer(getFont()));

	HeaderListener hl = new HeaderListener();
	addMouseListener(hl);
	addMouseMotionListener(hl);
    }

    public void setTable(JTable table) {
	JTable oldTable = getTable();
	if (oldTable != null) {
	    Object obj = oldTable.getModel();
	    if (obj instanceof XAbstractTableModel) {
		XAbstractTableModel model = (XAbstractTableModel) obj;
		model.removeTableModelListener(dataListener);
	    }
	}

	super.setTable(table);

	if (table != null) {
	    Object obj = table.getModel();
	    if (obj instanceof XAbstractTableModel) {
		XAbstractTableModel model = (XAbstractTableModel) obj;
		model.addTableModelListener(dataListener);
	    }
	}
	currentSortedColumnIcon = null;
	currentSortedColumnIndex = -1;
    }

    public String getToolTipText(MouseEvent e) {
	int col = columnAtPoint(e.getPoint());
	String retStr = null;

	if (col >= 0) {
	    TableColumn tcol = getColumnModel().getColumn(col);
	    int colWidth = tcol.getWidth();
	    TableCellRenderer h = tcol.getHeaderRenderer();

	    if (h == null) {
		h = getDefaultRenderer();
	    }

	    Component c = h.getTableCellRendererComponent(table, tcol
		    .getHeaderValue(), false, false, -1, col);

	    int prefWidth = c.getPreferredSize().width;
	    if (prefWidth > colWidth) {
		retStr = tcol.getHeaderValue().toString();
	    }
	}
	return retStr;
    }

    private final class TableDataListener implements TableModelListener {
	public void tableChanged(TableModelEvent evt) {
	    // NONSTABLE
	    // currentSortedColumnIcon = null;
	    // currentSortedColumnIndex = -1;
	}

    }

    class HeaderListener extends MouseAdapter implements MouseMotionListener {

	/*
         * @see MouseListener#mousePressed(MouseEvent)
         */
	public void mousePressed(MouseEvent e) {
	    pressed = true;
	    pressedColumnIndex = columnAtPoint(e.getPoint());
	    repaint();
	}

	/*
         * @see MouseListener#mouseReleased(MouseEvent)
         */
	public void mouseReleased(MouseEvent e) {
	    pressed = false;
	    releasedColumnIndex = columnAtPoint(e.getPoint());
	    currentSortedColumnIcon = null;
	    int column = getTable().convertColumnIndexToModel(
		    pressedColumnIndex);
	    int releasedColumn = getTable().convertColumnIndexToModel(
		    releasedColumnIndex);

	    if (column > -1 && column < table.getModel().getColumnCount()
		    && table.getModel() instanceof XAbstractTableModel) {

		XAbstractTableModel model = (XAbstractTableModel) table
			.getModel();
		if (dragged) {
		    if (model.isSingleSort()
			    && model.getSortParameter().getColumnIndex() == releasedColumn) {
			initSortColumn(model, releasedColumnIndex);
		    }
		} else {
		    model.sortByColumn(column);
		    model.fireTableDataChanged();
		    initSortColumn(model, pressedColumnIndex);
		}
	    }

	    repaint();
	    dragged = false;
	}

	/*
         * @see MouseMotionListener#mouseDragged(MouseEvent)
         */
	public void mouseDragged(MouseEvent e) {
	    dragged = true;
	}

	/*
         * @see MouseMotionListener#mouseMoved(MouseEvent)
         */
	public void mouseMoved(MouseEvent e) {
	    dragged = false;
	}

    }

    protected class ButtonTableRenderer implements TableCellRenderer {

	JButton buttonRaised;

	JButton buttonLowered;

	ButtonTableRenderer(Font font) {
	    buttonRaised = new JButton();
	    buttonRaised.setMargin(new Insets(0, 0, 0, 0));
	    buttonRaised.setFont(font);
	    buttonLowered = new JButton();
	    buttonLowered.setMargin(new Insets(0, 0, 0, 0));
	    buttonLowered.setFont(font);
	    buttonLowered.getModel().setArmed(true);
	    buttonLowered.getModel().setPressed(true);

	    buttonLowered.setMinimumSize(new Dimension(50, 25));
	    buttonRaised.setMinimumSize(new Dimension(50, 25));
	}

	/*
         * @see TableCellRenderer#getTableCellRendererComponent(JTable, Object,
         *      boolean, boolean, int, int)
         */
	public Component getTableCellRendererComponent(JTable table,
		Object value, boolean isSelected, boolean hasFocus, int row,
		int column) {

	    if (value == null) {
		value = "";
	    }

	    // Rendering the column that the mouse has been pressed in.
	    if (pressedColumnIndex == column && pressed) {
		buttonLowered.setText(value.toString());

		// If this is the column that the table is currently is
		// currently sorted by then display the sort icon.
		if (column == currentSortedColumnIndex
			&& currentSortedColumnIcon != null) {
		    buttonLowered.setIcon(currentSortedColumnIcon);
		} else {
		    buttonLowered.setIcon(null);
		}
		return buttonLowered;
	    }

	    // This is not the column that the mouse has been pressed in.
	    buttonRaised.setText(value.toString());
	    if (currentSortedColumnIcon != null
		    && column == currentSortedColumnIndex) {
		buttonRaised.setIcon(currentSortedColumnIcon);
	    } else {
		buttonRaised.setIcon(null);
	    }
	    return buttonRaised;
	}
    }

    // // SEE
    protected TableCellRenderer createDefaultRenderer() {
	DefaultTableCellRenderer label = new DefaultTableCellRenderer() {
	    public Component getTableCellRendererComponent(JTable table,
		    Object value, boolean isSelected, boolean hasFocus,
		    int row, int column) {
		if (table != null) {
		    JTableHeader header = table.getTableHeader();
		    if (header != null) {
			setForeground(header.getForeground());
			setBackground(header.getBackground());
			setFont(header.getFont());
		    }
		}

		setText((value == null) ? "" : value.toString());
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		return this;
	    }
	};

	label.setHorizontalAlignment(JLabel.CENTER);

	return label;

    }

    protected void initSortColumn(XAbstractTableModel model, int columnIndex) {
	initSortColumn(columnIndex, model.isSortAscending());
    }

    public void initSortColumn() {
	if (getTable().getModel() instanceof XAbstractTableModel) {
	    XAbstractTableModel model = (XAbstractTableModel) getTable()
		    .getModel();
	    if (!model.isSingleSort()
		    || model.getSortParameter().getColumnIndex() < 0) {
		resetSortColumn();
		repaint();
		return;
	    }
	    SortParameter prm = model.getSortParameter();
	    initSortColumn(getTable().convertColumnIndexToView(
		    prm.getColumnIndex()), prm.isAscending());
	} else {
	    resetSortColumn();
	}
	repaint();
    }

    public void initSortColumn(int columnIndex, boolean isAscending) {
	currentSortedColumnIcon = isAscending ? ascIcon : descIcon;
	currentSortedColumnIndex = columnIndex;
    }

    public void resetSortColumn() {
	currentSortedColumnIcon = null;
	currentSortedColumnIndex = -1;
    }

}
