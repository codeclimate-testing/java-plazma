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

package org.plazmaforge.framework.client.swing.forms;

import javax.swing.*;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 31.07.2004
 * Time: 12:26:48
 * $Id: ShellType.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public abstract class ShellType {

    public static final int FRAME                 = 1;
    public static final int DIALOG                = 2;
    public static final int INTERNAL_FRAME        = 3;
    public static final int MODAL_INTERNAL_FRAME  = 4;

    public abstract int getType();
    public abstract Container createShell();
    public abstract Container getContentPane();
    public abstract void setShellMenuBar(JMenuBar m);
    public abstract void setShellTitle(String title);
    public abstract String getShellTitle();
    public abstract void close();


}
