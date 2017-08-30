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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * @author Oleh Hapon
 * Date: 31.12.2003
 * Time: 14:38:00
 */

public class TimePanel extends JLabel implements ActionListener {

    private Timer timer;

    private DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);

    public TimePanel() {
        super("", JLabel.CENTER);
    }

    public void addNotify() {
        super.addNotify();
        timer = new Timer(1000, this);
        timer.start();
    }

  
    public void removeNotify()  {
        super.removeNotify();
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

   
    public void actionPerformed(ActionEvent evt) {
        setText(fmt.format(Calendar.getInstance().getTime()));
    }

   
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        FontMetrics fm = getFontMetrics(getFont());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        dim.width = fm.stringWidth(fmt.format(cal.getTime()));
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

}
