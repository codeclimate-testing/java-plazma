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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 13.11.2004
 * Time: 8:17:15
 * $Id: PreferencesDialog.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class PreferencesDialog extends OptionDialog {

    private JCheckBox  cbColReorderingAllowed;
    private JCheckBox  cbHorizontalLines;
    private JCheckBox  cbVerticalLines;
    private JCheckBox  cbColSelectionAllowed;
    private JCheckBox  cbRowSelectionAllowed;

    private JComboBox  cbSelectionMode;
    private JComboBox  cbResizeMode;


    private ListForm listForm;

    public PreferencesDialog(Frame frame, ListForm listForm) throws HeadlessException {
        super(frame);
        setListForm(listForm);
        setModal(true);
     }

    public void setListForm(ListForm listForm) {
        this.listForm = listForm;
        this.resources = listForm.getResources();
    }

    private ListForm getListForm() {
        return this.listForm;
    }

    private JTable getTable() {
        return getListForm().getTable();
    }

    protected JPanel createDialogPanel() {
        JPanel p = new JPanel(new FlowLayout());
        Border border = createDialogPanelBorder();
        if (border!=null) {
          p.setBorder(border);
        }

        cbColReorderingAllowed = new JCheckBox(getString("ColReorderingAllowed"), getTable().getTableHeader().getReorderingAllowed());
        cbHorizontalLines      = new JCheckBox(getString("HorizontalLines"), getTable().getShowHorizontalLines());
        cbVerticalLines        = new JCheckBox(getString("VerticalLines"), getTable().getShowVerticalLines());
        cbColSelectionAllowed  = new JCheckBox(getString("ColSelectionAllowed"), getTable().getColumnSelectionAllowed());
        cbRowSelectionAllowed  = new JCheckBox(getString("RowSelectionAllowed"), getTable().getRowSelectionAllowed());

        cbSelectionMode = new JComboBox();
        cbSelectionMode.addItem(getString("SelectionMode.1"));
        cbSelectionMode.addItem(getString("SelectionMode.2"));
        cbSelectionMode.addItem(getString("SelectionMode.3"));
        cbSelectionMode.setSelectedIndex( getTable().getSelectionModel().getSelectionMode());

        cbResizeMode = new JComboBox();
        cbResizeMode.addItem(getString("AutoResizeMode.1"));
        cbResizeMode.addItem(getString("AutoResizeMode.2"));
        cbResizeMode.addItem(getString("AutoResizeMode.3"));
        cbResizeMode.addItem(getString("AutoResizeMode.4"));
        cbResizeMode.addItem(getString("AutoResizeMode.5"));
        cbResizeMode.setSelectedIndex(getTable().getAutoResizeMode());

        JPanel plCheck = new JPanel();
        JPanel plCombo = new JPanel();

        plCheck.setLayout(new BoxLayout(plCheck, BoxLayout.Y_AXIS));
        plCheck.add(cbColReorderingAllowed);
        plCheck.add(cbHorizontalLines);
        plCheck.add(cbVerticalLines);
        plCheck.add(cbColSelectionAllowed);
        plCheck.add(cbRowSelectionAllowed);

        plCombo.setLayout(new BoxLayout(plCombo, BoxLayout.Y_AXIS));

        JPanel selectMode = new JPanel();
        selectMode.setBorder(new TitledBorder(getString("SelectionMode")));
        selectMode.add(cbSelectionMode);

        plCombo.add(selectMode);

        JPanel resizeMode = new JPanel();
        resizeMode.setBorder(new TitledBorder(getString("AutoResizeMode")));
        resizeMode.add(cbResizeMode);

        plCombo.add(resizeMode);
        p.add(BorderLayout.WEST,plCheck);
        p.add(BorderLayout.EAST,plCombo);

        return p;
    }

    protected void doOkAction() {
        getTable().getTableHeader().setReorderingAllowed(cbColReorderingAllowed.isSelected());
        getTable().setShowHorizontalLines(cbHorizontalLines.isSelected());
        getTable().setShowVerticalLines(cbVerticalLines.isSelected());
        getTable().setColumnSelectionAllowed(cbColSelectionAllowed.isSelected());
        getTable().setRowSelectionAllowed(cbRowSelectionAllowed.isSelected());
        //
        getTable().setSelectionMode(cbSelectionMode.getSelectedIndex());
        getTable().setAutoResizeMode(cbResizeMode.getSelectedIndex());
        //
        getTable().repaint();
        close();
    }


    public String getString(String key) {
        return getResources().getString("GUIPreferences.common.gui.table." + key);
    }

}
