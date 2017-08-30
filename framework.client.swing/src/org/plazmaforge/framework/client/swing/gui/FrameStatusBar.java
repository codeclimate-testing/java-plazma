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




import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * <code>FrameStatusBar</code> of <code>GUI Application</code>
 * 
 * @author Oleh Hapon
 * Date: 20.10.2003
 * Time: 16:20:39
 */
public class FrameStatusBar extends StatusBar {



    protected MemoryPanel memoryPanel;

    protected TimePanel timePanel;


    public FrameStatusBar() {
        super(new GridBagLayout());
    }

  
    public synchronized void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Font == null");
        }
        super.setFont(font);
        updateContainerFont(this, font);
    }


    public synchronized void clearText() {
        statusLabel.setText(" ");
    }

    protected void createGUI() {
        statusLabel = new JLabel();
        statusLabel.setBorder(createComponentBorder());
        clearText();

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;


        gbc.gridx = 0;
        add(statusLabel, gbc);

        memoryPanel = new MemoryPanel();
        memoryPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    System.gc();
                    //setText("Garbage collection requested");
                }
            }
        });
        memoryPanel.setBorder(createComponentBorder());
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        ++gbc.gridx;
        add(memoryPanel, gbc);

        timePanel = new TimePanel();
        timePanel.setBorder(createComponentBorder());
        ++gbc.gridx;
        add(timePanel, gbc);

    }


    private static void updateContainerFont(Container cont, Font font) {
        Component[] comps = cont.getComponents();
        for (int i = 0; i < comps.length; ++i) {
            comps[i].setFont(font);
            if (comps[i] instanceof Container) {
                updateContainerFont((Container) comps[i], font);
            }
        }
    }


}
