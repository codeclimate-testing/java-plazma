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
package org.plazmaforge.bsolution.finance.client.swing.forms.common;


import javax.swing.*;

import org.plazmaforge.bsolution.finance.client.swing.GUIFinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.OperationRegister;
import org.plazmaforge.framework.client.swing.gui.XOptionComboBoxModel;
import org.plazmaforge.framework.core.data.Item;
import org.plazmaforge.framework.resources.Resources;


import java.util.List;
import java.util.ArrayList;

/**
 * @author Oleh Hapon
 * Date: 17.08.2004
 * Time: 8:54:23
 * $Id: OperationTypeComboBox.java,v 1.3 2010/12/05 07:56:49 ohapon Exp $
 */
public class OperationTypeComboBox  extends JComboBox {

    public OperationTypeComboBox() {
        super();
        Item item;
        List list = new ArrayList();
        Resources res = GUIFinanceEnvironment.getResources();

        item = new Item(OperationRegister.DEBIT, res.getString("operation.type.debit") );
        list.add(item);
        item = new Item(OperationRegister.CREDIT, res.getString("operation.type.credit") );
        list.add(item);
        setModel(new XOptionComboBoxModel(list));
        this.setSelectedIndex(0);
    }

    public void setSelectedOperationType(String type) {
        if (OperationRegister.DEBIT.equals(type)) {
            this.setSelectedIndex(0);
        } else if (OperationRegister.CREDIT.equals(type)) {
            this.setSelectedIndex(1);
        }
    }

    public String getSelectedOperationType() {
        int index = this.getSelectedIndex();
        if (index == 0) {
            return OperationRegister.DEBIT;
        } else if (index == 1) {
            return OperationRegister.CREDIT;
        }
        return "";
    }

}
