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

import org.plazmaforge.framework.client.swing.dialogs.ChooseDialog;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 07.11.2004
 * Time: 13:52:16
 * $Id: ChooseFrameDialog.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */
public final class ChooseFrameDialog extends ChooseDialog {

    private JDesktopPane desktop;

    public ChooseFrameDialog(JDesktopPane desktop) {
        if (desktop == null) {
            throw new IllegalArgumentException("Desktop is empty");
        }
        this.desktop = desktop;
    }

    public ChooseFrameDialog(Frame owner, JDesktopPane desktop) {
        super(owner);
        if (desktop == null) {
            throw new IllegalArgumentException("Desktop is empty");
        }
        this.desktop = desktop;
    }


    public int showDialog() {
        return showDialog(desktop.getAllFrames());
    }

    public int showDialog(JInternalFrame[] frames) {
        if (frames == null) {
            throw new IllegalArgumentException("frames must be non null");
        }
        final FrameObject[] frameObjects = new FrameObject[frames.length];
        for(int i = 0; i < frames.length; i++) {
            frameObjects[i] = new FrameObject(frames[i]);
        }
        getList().setModel(new AbstractListModel() {
                public int getSize() { return frameObjects.length; }
                public Object getElementAt(int i) { return frameObjects[i]; }
            });
        return super.showDialog();
    }



    public JInternalFrame getSelectedFrame() {
        if (getSelectedValue() == null) {
            return null;
        }
        return ((FrameObject) getSelectedValue()).getFrame();
    }

    private class FrameObject {

        private JInternalFrame frame;

        public FrameObject(JInternalFrame frame) {
            this.frame = frame;
        }

        public JInternalFrame getFrame() {
            return frame;
        }

        public String toString() {
            return this.frame.getTitle();
        }
    }

}
