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



import java.awt.event.MouseEvent;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 18.01.2004
 * Time: 17:02:30
 * $Id: XPopupMenu.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */

public class XPopupMenu extends JPopupMenu {


    public void show(MouseEvent evt) {
        Point pt = GUIUtilities.computePopupLocation(evt, evt.getComponent(), this);
        //Point pt = new Point( evt.getX(), evt.getY() );
        show(evt.getComponent(), pt.x, pt.y);
    }

}
