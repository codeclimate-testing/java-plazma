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


import java.util.List;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 09.07.2004
 * Time: 8:06:18
 * $Id: ChooseActionDialog.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */

public final class ChooseActionDialog extends ChooseDialog {

    public ChooseActionDialog(List elements) {
        super(elements);
    }

    public ChooseActionDialog(Frame owner, List elements) {
        super(owner, elements);
    }

    public Action getSelectedAction() {
        return (Action) this.getSelectedValue();
    }

}
