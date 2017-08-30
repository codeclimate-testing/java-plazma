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

package org.plazmaforge.framework.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.framework.client.swing.dialogs.SelectItemDialog;
import org.plazmaforge.framework.client.swing.gui.IndicatorListCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.SortParameter;
import org.plazmaforge.framework.client.swing.gui.table.XAbstractTableModel;
import org.plazmaforge.framework.resources.LibraryResources;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Created on 06.06.2006
 */

public class TableSortDialog extends SelectItemDialog {

    private JTable table;

    public TableSortDialog(Frame frame, JTable table) {
        super(frame);
        this.table = table;
        setModal(true);
        //registerKeyEnter();
        initialize();
    }

    public TableSortDialog(Frame frame, JTable table, boolean modal) {
        super(frame, modal);
        this.table = table;
        //registerKeyEnter();
        initialize();
    }

    private void initialize() {
        getOutputList().setCellRenderer(new SortListCellRenderer());
        //getOutputLabel().setText("Selected items:");

        getOutputList().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e){
                if (e.getClickCount() == 2) {
                    doInverseSortAction();
                }
            }

            public void mousePressed(MouseEvent e){}

            public void mouseReleased(MouseEvent e){}

            public void mouseEntered(MouseEvent e){}

            public void mouseExited(MouseEvent e){}

        });
    }

    public void initData() {
        XAbstractTableModel model = (XAbstractTableModel) this.table.getModel();

        List output = new ArrayList();
        List sortParameters = model.getSortParameters();
        int[] indexes = new int[sortParameters.size()];
        for (int i = 0; i < sortParameters.size(); i++) {
            SortParameter p = (SortParameter) sortParameters.get(i);
            int columnIndex = p.getColumnIndex();
            SortDisplay display = new SortDisplay();
            display.setColumnIndex(columnIndex);
            display.setAscending(p.isAscending());
            display.setColumnName(model.getColumnName(columnIndex));
            output.add(display);
            indexes[i] = columnIndex;
        }

        List input = new ArrayList();
        for(int i = 0; i < model.getColumnCount(); i++) {

            boolean b = false;
            for (int j = 0; j < indexes.length; j++) {
                if (indexes[j] == i) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                SortDisplay display = new SortDisplay();
                display.setAscending(true);
                display.setColumnIndex(i);
                display.setColumnName(model.getColumnName(i));
                input.add(display);
            }
        }

        setData(input, output);

    }

    private class SortDisplay extends SortParameter {

        private String columnName;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String toString() {
            return getColumnName();
        }
    }

    private class SortListCellRenderer extends IndicatorListCellRenderer {

        private Icon descIcon;
        private Icon ascIcon;

        public SortListCellRenderer() {
            LibraryResources rsrc = LibraryResources.getInstance();
            descIcon =	rsrc.getIcon(LibraryResources.TABLE_DESCENDING);
            ascIcon = rsrc.getIcon(LibraryResources.TABLE_ASCENDING);
        }

        protected Icon getIcon(JList list,  Object value,  int index,  boolean isSelected,  boolean cellHasFocus) {
            if (value != null && value instanceof SortDisplay) {
                return getIcon(((SortDisplay)value).isAscending());
            }
            return getIcon(false);
        }

        protected Icon getIcon(boolean isAscending) {
            return isAscending ? ascIcon : descIcon;
        }

    }

    protected void doInverseSortAction() {
        int index = getOutputList().getSelectedIndex();
        if (index < 0) {
            return;
        }
        if (index >= getOutputModel().getSize()) {
            return;
        }
        Object object = getOutputList().getSelectedValue();
        SortDisplay display = (SortDisplay) object;
        if (display == null) {
            return;
        }
        display.setAscending(!display.isAscending());
        getOutputList().repaint();
    }

}
