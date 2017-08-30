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
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Oleh Hapon
 * Date: 19.02.2004
 * Time: 9:13:13
 * $Id: FileFormatChooser.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class FileFormatChooser extends JDialog {

    private String[][] info;

    private int option;

    public FileFormatChooser(Frame owner, String[][] info) throws HeadlessException {
        super(owner, true);
        setInfo(info);
        createGUI();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public String[][] getInfo() {
        return info;
    }

    public void setInfo(String[][] info) {
        this.info = info;
        if (info == null) throw new IllegalArgumentException("Info is null");
        int len = info.length;
        if (len<1) throw new IllegalArgumentException("Info Row is empty");
        for(int i=0;i<len;i++) {
            if (info[i].length<3) {
                throw new IllegalArgumentException("Info Cell is empty");
            }
        }
    }

    private ButtonGroup group;


    protected void createGUI() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));


        group = new ButtonGroup();
        int len = info.length;
        for(int i=0;i<len;i++) {
            JRadioButton rb = new JRadioButton(info[i][1]);
            rb.setActionCommand(String.valueOf(i));
            p.add(rb);
            group.add(rb);
        }

        c.add(p,BorderLayout.CENTER);
        c.add(createButtonPanel(),BorderLayout.SOUTH);
        pack();
    }

    public void resetData() {
        ButtonModel model = group.getSelection();
        if (model!=null) {
            model.setSelected(false);
        }

    }

    protected JPanel createButtonPanel() {
        JPanel p = new JPanel();
        p.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                performOk();
            }
        });
        p.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                performCancel();
            }
        });
        p.add(cancelButton);
        return p;
    }

    private int index;

    public String getFormatName() {
        if (index<0) return null;
        return info[index][0];
    }

    public String getFormatDescription() {
        if (index<0) return null;
        return info[index][1];
    }

    public String getFileExt() {
        if (index<0) return null;
        return info[index][2];
    }

    protected void performOk() {
        option = JOptionPane.OK_OPTION;
        index = Integer.parseInt(group.getSelection().getActionCommand());
        doClose();
    }

    protected void performCancel() {
        option = JOptionPane.CANCEL_OPTION;
        doClose();
    }

    protected void doClose() {
        int op = this.getDefaultCloseOperation();
        if (op==HIDE_ON_CLOSE) {
            hide();
        } else if (op==DISPOSE_ON_CLOSE) {
            dispose();
        }
    }
    public int showDialog() {
        setLocationRelativeTo(null);
        super.show();
        return option;
    }
}
