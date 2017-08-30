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

/**
 * @author Oleh Hapon
 * Date: 18.01.2004
 * Time: 15:29:38
 * $Id: ToolBar.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */

public class ToolBar extends JToolBar {


    public void setUseRolloverButtons(boolean value) {
        putClientProperty("JToolBar.isRollover", value ? Boolean.TRUE : Boolean.FALSE);
    }


    protected JButton createActionComponent(Action action) {
        JButton btn = super.createActionComponent(action);
        if (btn != null) {
            btn.setRequestFocusEnabled(false);
            btn.setFocusable(false);

            //btn.setRequestFocusEnabled(true);

            String tt = null;
            if (action != null) {
                tt = (String) action.getValue(Action.SHORT_DESCRIPTION);
            }
            btn.setToolTipText(tt != null ? tt : "");
            if (action != null) {
                //Icon icon = getIconFromAction(action, BaseAction.ROLLOVER_ICON);
                Icon icon = null;
                if (icon != null) {
                    btn.setRolloverIcon(icon);
                    btn.setRolloverSelectedIcon(icon);
                }
                //icon = getIconFromAction(action, BaseAction.DISABLED_ICON);
                icon = null;
                if (icon != null) {
                    btn.setDisabledIcon(icon);
                }
            }

            if (btn.getIcon() != null) {
                btn.setText("");
                Dimension dim = btn.getPreferredSize();
                dim.width = dim.height;
                btn.setPreferredSize(dim);
                btn.setMaximumSize(dim);
            }

        }
        return btn;
    }


    protected Icon getIconFromAction(Action action, String key) {

        Object obj = action.getValue(key);
        if (obj != null) {
            if (obj instanceof Icon) {
                return (Icon) obj;
            }
            StringBuffer msg = new StringBuffer();
            msg.append("Non icon object of type ").append(obj.getClass().getName())
                .append(" was stored in an Action of type ")
                .append(action.getClass().getName())
                .append(" using the key ").append(key).append(".");
            // TODO: Hapon
            System.err.println(msg.toString());
        }
        return null;
    }


}
