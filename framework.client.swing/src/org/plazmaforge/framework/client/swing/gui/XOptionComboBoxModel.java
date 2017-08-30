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


import java.util.List;
import java.util.Iterator;

import org.plazmaforge.framework.core.data.Item;


/**
 * @author Oleh Hapon
 * Date: 21.03.2004
 * Time: 16:25:18
 * $Id: XOptionComboBoxModel.java,v 1.3 2010/12/05 07:52:08 ohapon Exp $
 */
public class XOptionComboBoxModel extends XDefaultComboBoxModel {


    public XOptionComboBoxModel(List data) {
        super(data);
    }

    public void setSelectedKey(Object key) {
        if (key == null || getData() == null) return;
        Iterator itr = getData().iterator();
        boolean f = false;
        while (itr.hasNext()) {
            Item item = (Item)itr.next();
            if (item.getKey() == null) {
                continue;
            }
            if (item.getKey().toString().equals(key.toString())) {
            //if (item.getKey().equals(key)) {
                setSelectedItem(item);
                f = true;
                break;
            }
        }
        if (!f) {
            setSelectedItem(null);
        }
    }


    public void setSelectedIntKey(Integer key) {
        setSelectedKey(key);
    }

    public Object getSelectedKey() {
        Object obj = getSelectedItem();
        if (obj == null) return null;
        return ((Item) obj).getKey();
    }

    public Integer getSelectedIntKey() {
        //return  (getSelectedKey() == null) ? 0: Integer.valueOf(getSelectedKey().toString()).intValue();
        return  (getSelectedKey() == null) ? null: (Integer) getSelectedKey();
    }


}
