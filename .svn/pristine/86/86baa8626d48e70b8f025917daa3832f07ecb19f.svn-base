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

import org.plazmaforge.framework.config.object.IEntityConfig;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Oleh Hapon
 * Date: 19.12.2004
 * Time: 9:34:09
 * $Id: ChooseDialog.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */
public class ChooseDialog  extends OptionDialog {

    private JList list;

    public ChooseDialog() throws HeadlessException {
    }

    public ChooseDialog(Frame owner) throws HeadlessException {
        super(owner);
    }


    public ChooseDialog(List elements) {
        if ((elements == null) || (elements.size() == 0)) {
            throw new IllegalArgumentException("Elements is empty");
        }
        list = new JList(createListModel(elements));
    }

    public ChooseDialog(Frame owner, List elements) {
        super(owner);
        if ((elements == null)||(elements.size() == 0)) {
            throw new IllegalArgumentException("Elements is empty");
        }
        Collections.sort(elements, new Comparator() {
            
            public int compare(Object o1, Object o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                String name1 = ((IEntityConfig) o1).getName();
                String name2 = ((IEntityConfig) o2).getName();
                
                if (name1 == null && name2 == null) {
                    return 0;
                }
                if (name1 == null) {
                    return -1;
                }
                if (name2 == null) {
                    return 1;
                }
                return name1.compareTo(name2);
            }

           
//            public boolean equals(Object obj) {
//               return false; 
//            }
        });
        list = new JList(createListModel(elements));
    }

    protected void initComponents() {
        super.initComponents();
		setPack(false);		
        setModal(true);
        setSize(500, 400);
    }

    public JList getList() {
        if (list == null) {
            list = createList();
        }
        return list;
    }

    public void setList(JList list) {
        this.list = list;
    }

    protected JList createList() {
        return new JList();
    }

    protected ListModel createListModel(final List list) {
        return new AbstractListModel() {
                public int getSize() { return list.size(); }
                public Object getElementAt(int i) { return list.get(i); }
            };
    }

    public int getSelectedIndex() {
        return getList().getSelectedIndex();
    }

    public Object getSelectedValue() {
        return getList().getSelectedValue();
    }

    public void setSelectedIndex(int index) {
         getList().setSelectedIndex(index);
    }

    public void setSelectedValue(Object value) {
        getList().setSelectedValue(value, true);
    }

    protected JPanel createDialogPanel() {
        JPanel p = new JPanel(new GridLayout());
        Border border = createDialogPanelBorder();
        if (border != null) {
            p.setBorder(border);
        }

        registerListKeyboardAction();
        registerListMouseListener();

        JScrollPane sc = new JScrollPane();
        sc.getViewport().add(getList());
        p.add(sc, BorderLayout.CENTER);
        return p;
    }

    protected Border createDialogPanelBorder()  {
        return null;
    }


    protected void registerListKeyboardAction() {
        // Init Keys
        getList().registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireOkAction();
            }
        },  KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    protected void registerListMouseListener() {
        // Init Mouse
        getList().addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() != 2) return;
                fireOkAction();
            }

            public void mousePressed(MouseEvent e) {

            }
            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
