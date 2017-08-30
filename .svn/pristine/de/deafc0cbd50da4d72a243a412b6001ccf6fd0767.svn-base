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

package org.plazmaforge.framework.client.swing.desktop.actions;


import javax.swing.*;

import org.plazmaforge.framework.client.swing.dialogs.ChooseFrameDialog;
import org.plazmaforge.framework.resources.Resources;


import java.awt.event.ActionEvent;

/**
 * @author Oleh Hapon
 * Date: 07.11.2004
 * Time: 15:36:03
 * $Id: ChooseInternalFramesAction.java,v 1.2 2010/04/28 06:36:12 ohapon Exp $
 */
public class ChooseInternalFramesAction extends DesktopAction {

    private ChooseFrameDialog dialog;

    public ChooseInternalFramesAction(JDesktopPane desktop, Resources res) {
        super(desktop,res);
    }

    public ChooseInternalFramesAction(Resources res) {
        super(res);
    }


    public void actionPerformed(ActionEvent evt) {
        if (getDesktop() == null)  {
            return;
        }
        JInternalFrame[] frames = getDesktop().getAllFrames();
        if (frames == null || frames.length == 0) {
            return;
        }
        try {
            if (dialog == null) {
                dialog = new ChooseFrameDialog(getDesktop());
                dialog.setCenter(true);
            }
            if ((dialog.showDialog(frames) == JOptionPane.OK_OPTION) && (dialog.getSelectedFrame() != null)) {
                dialog.getSelectedFrame().show();
                dialog.getSelectedFrame().toFront();
                dialog.getSelectedFrame().setSelected(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
