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
package org.plazmaforge.framework.client.swing.dialogs;


import javax.swing.*;
import javax.swing.border.Border;

import org.plazmaforge.framework.client.swing.gui.IndicatorListCellRenderer;
import org.plazmaforge.framework.resources.LibraryResources;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

/**
 * Created on 06.06.2006
 */

public class SelectItemDialog extends OptionDialog {

    private JLabel inputLabel;

    private JLabel outputLabel;

    private JList inputList;

    private JList outputList;


    private JButton addButton;

    private JButton removeButton;

    private JButton allAddButton;

    private JButton allRemoveButton;


    public SelectItemDialog() throws HeadlessException {
        initialize();
    }

    public SelectItemDialog(Frame owner) throws HeadlessException {
        super(owner);
        initialize();
    }

    public SelectItemDialog(Frame owner, boolean modal) throws HeadlessException {
        super(owner, modal);
    }

    private void initialize() {

        inputLabel = new JLabel("Input:");
        outputLabel = new JLabel("Output:");

        inputList = new JList(createListModel());
        outputList = new JList(createListModel());

        addButton = new JButton(">");
        removeButton = new JButton("<");
        allAddButton = new JButton(">>");
        allRemoveButton = new JButton("<<");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doAddAction();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doRemoveAction();
            }
        });

        allAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doAllAddAction();
            }
        });

        allRemoveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doAllRemoveAction();
            }
        });

        setPack(false);
    }

    protected void initComponents() {
        super.initComponents();
        setModal(true);
        this.setSize(550, 400);
    }


    protected JPanel createDialogPanel() {
        JPanel p = new JPanel(new GridLayout(1, 3));

        Border border = createDialogPanelBorder();
        if (border != null) {
            p.setBorder(border);
        }

        //registerListKeyboardAction();
        //registerListMouseListener();

        JScrollPane inputScroll = new JScrollPane();
        inputScroll.getViewport().add(inputList);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScroll, BorderLayout.CENTER);
        p.add(inputPanel);


        JPanel controlPanel  = new JPanel(new GridLayout(6, 1));
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        controlPanel.add(allAddButton);
        controlPanel.add(allRemoveButton);

        JPanel pp = new JPanel(new FlowLayout());
        pp.add(controlPanel);
        p.add(pp);

        JScrollPane outputScroll = new JScrollPane();
        outputScroll.getViewport().add(outputList);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScroll, BorderLayout.CENTER);
        p.add(outputPanel);

        return p;
    }

    protected ListModel createListModel() {
        return new ItemListModel();
    }

    public static class ItemListModel extends AbstractListModel {

        private List list;

        public ItemListModel() {
        }

        public ItemListModel(List list) {
            this.list = list;
        }

        public int getSize() {
            return list == null ? 0 : list.size();
        }

        public Object getElementAt(int i) {
            return list.get(i);
        }

        public void setList(List list) {
            this.list = list;
            fireContentsChanged();
        }

        public List getList() {
            if (list == null) {
                list = new ArrayList();
            }
            return list;
        }

        public void fireContentsChanged() {
            int index0 = 0;
            int index1 = getSize() - 1;
            if (index1 < 0) {
                index1 = 0;
            }
            this.fireContentsChanged(this, index0, index1);
        }
    }


    public JList getInputList() {
        return inputList;
    }

    public JList getOutputList() {
        return outputList;
    }

    public ItemListModel getInputModel() {
        return ((ItemListModel) getInputList().getModel());
    }

    public ItemListModel getOutputModel() {
        return ((ItemListModel) getOutputList().getModel());
    }

    public void setInputData(List list) {
        getInputModel().setList(list);
    }

    public void setOutputData(List list) {
        getOutputModel().setList(list);
    }

    public void setData(List input, List output) {
        setInputData(input);
        setOutputData(output);
    }

    public JLabel getInputLabel() {
        return inputLabel;
    }

    public JLabel getOutputLabel() {
        return outputLabel;
    }

    protected void doAddAction() {
        int index = getInputList().getSelectedIndex();
        if (index < 0) {
            return;
        }
        if (index >= getInputModel().getSize()) {
            return;
        }
        Object object = getInputList().getSelectedValue();
        getInputModel().getList().remove(index);
        getInputModel().fireContentsChanged();

        getOutputModel().getList().add(object);
        getOutputModel().fireContentsChanged();
    }

    protected void doAllAddAction() {
        List input = getInputModel().getList();
        if (input == null || input.size() == 0) {
            return;
        }
        int size  = input.size();
        List output = getOutputModel().getList();
        for (int i = 0; i < size; i++) {
            output.add(input.get(i));
        }
        input.clear();

        getInputModel().fireContentsChanged();
        getOutputModel().fireContentsChanged();
    }

    protected void doRemoveAction() {
        int index = getOutputList().getSelectedIndex();
        if (index < 0) {
            return;
        }
        if (index >= getOutputModel().getSize()) {
            return;
        }
        Object object = getOutputList().getSelectedValue();
        getOutputModel().getList().remove(index);
        getOutputModel().fireContentsChanged();

        getInputModel().getList().add(object);
        getInputModel().fireContentsChanged();
    }

    protected void doAllRemoveAction() {
        List output = getOutputModel().getList();
        if (output == null || output.size() == 0) {
            return;
        }
        int size  = output.size();
        List input = getInputModel().getList();
        for (int i = 0; i < size; i++) {
            input.add(output.get(i));
        }
        output.clear();

        getInputModel().fireContentsChanged();
        getOutputModel().fireContentsChanged();
    }

    public List getSelectItems() {
        return getOutputModel().getList();
    }


    public static void main(String[] args) {
        SelectItemDialog d = new SelectItemDialog();
        List list1 = new ArrayList();

        list1.add("String1");
        list1.add("String2");
        list1.add("String3");
        list1.add("String4");
        list1.add("String5");
        list1.add("String6");
        list1.add("String7");
        list1.add("String8");
        list1.add("String9");

        d.setInputData(list1);
        d.getOutputList().setCellRenderer(new IndicatorListCellRenderer());
        d.getOutputLabel().setText("Selected items:");
        d.setVisible(true);
    }

}

