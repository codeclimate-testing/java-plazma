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

/**
 * @author Oleh Hapon
 * Date: 18.01.2004
 * Time: 14:32:32
 * $Id: SortedListModel.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class SortedListModel extends DefaultListModel {

 
    public SortedListModel() {
        super();
    }

  
    public void add(int index, Object obj) {
        addElement(obj);
    }

  
    public void insertElementAt(int index, Object obj) {
        addElement(obj);
    }

 
    public void addElement(Object obj) {
        super.add(getIndexInList(obj), obj);
    }

    public Object remove(int index) {
        Object obj = get(index);
        removeElement(obj);
        return obj;
    }

    public void removeElementAt(int index) {
        removeElement(get(index));
    }

    public void removeRange(int fromIndex, int toIndex) {
        for (int i = fromIndex; i <= toIndex; ++i) {
            remove(i);
        }
    }

    protected int getIndexInList(Object obj) {
        final int limit = getSize();
        final String objStr = obj.toString();
        for (int i = 0; i < limit; ++i) {
            if (objStr.compareToIgnoreCase(get(i).toString()) <= 0) {
                return i;
            }
        }
        return limit;
    }


    public void fireDataChanged() {
        fireContentsChanged(this, 0, getSize());
    }

    public void fireDataAdded() {
        int size = getSize();
        fireIntervalAdded(this, 0, size);
    }

    public void fireDataRemoved() {
        fireIntervalRemoved(this, 0, getSize());
    }


}
