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

import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.resources.Resources;


import java.awt.event.ActionEvent;
import java.awt.*;
import java.beans.PropertyVetoException;

/**
 * @author Oleh Hapon
 * Date: 17.02.2004
 * Time: 9:07:14
 * $Id: TitleInternalFramesAction.java,v 1.2 2010/04/28 06:36:12 ohapon Exp $
 */
public abstract class TitleInternalFramesAction extends DesktopAction {

    public TitleInternalFramesAction(JDesktopPane desktop, Resources res) {
        super(desktop, res);
    }

    public TitleInternalFramesAction(Resources res) {
        super(res);
    }


    public void actionPerformed(ActionEvent evt) {
        if (getDesktop() != null) {
            JInternalFrame[] children = GUIUtilities.getNonMinimizedNonToolWindows(getDesktop().getAllFrames());
            final int cells = children.length;
            if (cells > 0) {
                final RowColumnCount rcc = getRowColumnCount(cells);
                final int rows = rcc._rowCount;
                final int cols = rcc._columnCount;

                final Dimension desktopSize = desktop.getSize();
                final int width = desktopSize.width / cols;
                final int height = desktopSize.height / rows;
                int xPos = 0;
                int yPos = 0;

                for (int y = 0; y < rows; ++y) {
                    for (int x = 0; x < cols; ++x) {
                        final int idx = y + (x * rows);
                        if (idx >= cells) {
                            break;
                        }
                        JInternalFrame frame = children[idx];
                        if (!frame.isClosed())  {
                            if (frame.isIcon()) {
                                try {
                                    frame.setIcon(false);
                                } catch (PropertyVetoException ignore) {
                                }
                            } else if (frame.isMaximum())  {
                                try {
                                    frame.setMaximum(false);
                                } catch (PropertyVetoException ignore) {
                                }
                            }

                            frame.reshape(xPos, yPos, width, height);
                            xPos += width;
                        }
                    }
                    xPos = 0;
                    yPos += height;
                }
            }
        }
    }

    /**
     * Retrieve the number of rows and columns that the internal frames
     * should be rearranged into.
     *
     * @param	internalFrameCount	Number of internal frames to be rearranged.
     */
    protected abstract RowColumnCount getRowColumnCount(int internalFrameCount);

    public final static class RowColumnCount {
        protected final int _rowCount;
        protected final int _columnCount;

        public RowColumnCount(int rowCount, int columnCount) {
            _rowCount = rowCount;
            _columnCount = columnCount;
        }
    }




}
