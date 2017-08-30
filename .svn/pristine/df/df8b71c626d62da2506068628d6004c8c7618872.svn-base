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

import org.plazmaforge.framework.util.SystemUtils;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 31.12.2003
 * Time: 14:42:15
 */
public class MemoryPanel extends JLabel {

    private Timer timer;

  
    public MemoryPanel() {
        super("", JLabel.CENTER);
    }

    public void addNotify() {
        super.addNotify();
        updateMemoryStatus();
        ToolTipManager.sharedInstance().registerComponent(this);
        timer = new Timer(2000, new TimerListener());
        timer.start();
    }

   
    public void removeNotify() {
        super.removeNotify();
        ToolTipManager.sharedInstance().unregisterComponent(this);
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

   
    public String getToolTipText() {
        final Runtime rt = Runtime.getRuntime();
        final long totalMemory = rt.totalMemory();
        final long freeMemory = rt.freeMemory();
        final long usedMemory = totalMemory - freeMemory;
        StringBuffer buf = new StringBuffer();
        buf.append(SystemUtils.formatSize(usedMemory))
            .append(" used from ")
            .append(SystemUtils.formatSize(totalMemory))
            .append(" total leaving ")
            .append(SystemUtils.formatSize(freeMemory))
            .append(" free");
        return buf.toString();
    }

   
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        FontMetrics fm = getFontMetrics(getFont());
        dim.width = fm.stringWidth("99.9MB/99.9MB");
        Border border = getBorder();
        if (border != null) {
            Insets ins = border.getBorderInsets(this);
            if (ins != null) {
                dim.width += (ins.left + ins.right);
            }
        }
        Insets ins = getInsets();
        if (ins != null) {
            dim.width += (ins.left + ins.right);
        }
        return dim;
    }

  
    private void updateMemoryStatus() {
        final Runtime rt = Runtime.getRuntime();
        final long totalMemory = rt.totalMemory();
        final long freeMemory = rt.freeMemory();
        final long usedMemory = totalMemory - freeMemory;
        StringBuffer buf = new StringBuffer();
        buf.append(SystemUtils.formatSize(usedMemory, 1)).append("/")
            .append(SystemUtils.formatSize(totalMemory, 1));
        setText(buf.toString());
    }

   
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            updateMemoryStatus();
        }
    }

}
