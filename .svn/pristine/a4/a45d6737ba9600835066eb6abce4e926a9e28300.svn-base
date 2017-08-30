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
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 13.11.2004
 * Time: 10:37:21
 * $Id: GUIPreferencesDialog.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class GUIPreferencesDialog extends OptionDialog {

    private JCheckBox  cbColReorderingAllowed;
    private JCheckBox  cbHorizontalLines;
    private JCheckBox  cbVerticalLines;
    private JCheckBox  cbColSelectionAllowed;
    private JCheckBox  cbRowSelectionAllowed;

    private JComboBox  cbSelectionMode;
    private JComboBox  cbResizeMode;


    public GUIPreferencesDialog(Frame frame) throws HeadlessException {
        super(frame);
        setModal(true);
        setPack(false);
    }


    protected void initComponents() {
        super.initComponents();
        this.setResizable(true);
        this.setSize(500, 400);
    }

    private GUIEnvironment.TablePreferences getTablePreferences() {
        return GUIEnvironment.getTablePreferences();
    }

    protected JPanel createDialogPanel() {
        JPanel p = new JPanel(new BorderLayout());


        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(" " + getString("common.name"));
        DefaultMutableTreeNode guiNode = new DefaultMutableTreeNode(getString("common.gui.name"));
        DefaultMutableTreeNode tableNode = new DefaultMutableTreeNode(getString("common.gui.table.name"));

        rootNode.add(guiNode);
        guiNode.add(tableNode);

        JTree tree = new JTree(rootNode);
        class MyDefaultTreeCellRenderer extends DefaultTreeCellRenderer {
             public Icon getOpenIcon() {
              	return null;
             }

             public Icon getClosedIcon() {
	            return null;
             }
             public Icon getLeafIcon() {
 	            return null;
             }
        }
        tree.setCellRenderer(new MyDefaultTreeCellRenderer());
        //tree.setRootVisible(false);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent e) {
                    //pack();
                }
            }
        );

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        new JScrollPane(tree), createTablePreferencesPanel());
        split.setDividerLocation(150);
        split.setDividerSize(5);
        split.setOneTouchExpandable(true);
        p.add(split);

        return p;
    }

    protected JPanel createTablePreferencesPanel() {
        JPanel p = new JPanel(new FlowLayout());
        Border border = createDialogPanelBorder();
        if (border!=null) {
          p.setBorder(border);
        }

        cbColReorderingAllowed = new JCheckBox(getString("common.gui.table.ColReorderingAllowed"), getTablePreferences().isColReorderingAllowed());
        cbHorizontalLines      = new JCheckBox(getString("common.gui.table.HorizontalLines"), getTablePreferences().isHorizontalLines());
        cbVerticalLines        = new JCheckBox(getString("common.gui.table.VerticalLines"), getTablePreferences().isVerticalLines());
        cbColSelectionAllowed  = new JCheckBox(getString("common.gui.table.ColSelectionAllowed"), getTablePreferences().isColSelectionAllowed());
        cbRowSelectionAllowed  = new JCheckBox(getString("common.gui.table.RowSelectionAllowed"), getTablePreferences().isRowSelectionAllowed());

        cbSelectionMode = new JComboBox();
        cbSelectionMode.addItem(getString("common.gui.table.SelectionMode.1"));
        cbSelectionMode.addItem(getString("common.gui.table.SelectionMode.2"));
        cbSelectionMode.addItem(getString("common.gui.table.SelectionMode.3"));
        cbSelectionMode.setSelectedIndex( getTablePreferences().getSelectionMode());

        cbResizeMode = new JComboBox();
        cbResizeMode.addItem(getString("common.gui.table.AutoResizeMode.1"));
        cbResizeMode.addItem(getString("common.gui.table.AutoResizeMode.2"));
        cbResizeMode.addItem(getString("common.gui.table.AutoResizeMode.3"));
        cbResizeMode.addItem(getString("common.gui.table.AutoResizeMode.4"));
        cbResizeMode.addItem(getString("common.gui.table.AutoResizeMode.5"));
        cbResizeMode.setSelectedIndex(getTablePreferences().getAutoResizeMode());

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
        selectMode.setBorder(new TitledBorder(getString("common.gui.table.SelectionMode")));
        selectMode.add(cbSelectionMode);

        plCombo.add(selectMode);

        JPanel resizeMode = new JPanel();
        resizeMode.setBorder(new TitledBorder(getString("common.gui.table.AutoResizeMode")));
        resizeMode.add(cbResizeMode);

        plCombo.add(resizeMode);
        p.add(BorderLayout.WEST,plCheck);
        p.add(BorderLayout.EAST,plCombo);

        return p;
    }

    protected void doOkAction() {
        getTablePreferences().setColReorderingAllowed(cbColReorderingAllowed.isSelected());
        getTablePreferences().setHorizontalLines(cbHorizontalLines.isSelected());
        getTablePreferences().setVerticalLines(cbVerticalLines.isSelected());
        getTablePreferences().setColSelectionAllowed(cbColSelectionAllowed.isSelected());
        getTablePreferences().setRowSelectionAllowed(cbRowSelectionAllowed.isSelected());
        //
        getTablePreferences().setSelectionMode(cbSelectionMode.getSelectedIndex());
        getTablePreferences().setAutoResizeMode(cbResizeMode.getSelectedIndex());
        //
        close();
    }



    public String getString(String key) {
        //return getResources().getString("GUIPreferences.table." + key);
	return getResources().getString("GUIPreferences." + key);
    }



}
