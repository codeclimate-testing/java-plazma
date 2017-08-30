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

import org.plazmaforge.framework.client.swing.desktop.CascadeInternalFramePositioner;
import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.resources.Resources;


import java.awt.event.ActionEvent;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 17.02.2004
 * Time: 9:09:14
 * $Id: CascadeInternalFramesAction.java,v 1.2 2010/04/28 06:36:12 ohapon Exp $
 */
public class CascadeInternalFramesAction extends DesktopAction {

    protected CascadeInternalFramePositioner positioner;

    public CascadeInternalFramesAction(JDesktopPane desktop, Resources res) {
        super(desktop,res);
    }

    public CascadeInternalFramesAction(Resources res) {
        super(res);
    }


    public void actionPerformed(ActionEvent evt) {
        if (getDesktop() != null)  {
            Dimension cs = null; 

            // Init begin position
            getPositioner().initPosition();

            JInternalFrame[] children = GUIUtilities.getOpenNonToolWindows(getDesktop().getAllFrames());
            for (int i = children.length - 1; i >= 0; --i) {
                JInternalFrame child = children[i];
                if (cs == null && child.getParent() != null) {
                    cs = child.getParent().getSize();
                    cs.setSize((int) (cs.width * 0.8d), (int) (cs.height * 0.8d));
                } if (cs != null) {
                    child.setSize(cs);
                    getPositioner().positionInternalFrame(child);
                }
            }
        }
    }


    protected CascadeInternalFramePositioner getPositioner() {
        if (positioner == null) {
            positioner =  new CascadeInternalFramePositioner();
        }
        return positioner;
    }
}
