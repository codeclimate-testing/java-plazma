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
/*
 * Created on 22.03.2005
 *
 */
package org.plazmaforge.framework.client.swing.gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


/**
 * @author Oleh Hapon
 *
 */
public class XDefaultComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List data;

    private Object selectedObject;

    
    public XDefaultComboBoxModel() {
        super();
    }
    
    public XDefaultComboBoxModel(List data) {
        this.data = data;
    }

    public int getSize() {
        return data == null ? 0 : data.size();
    }

    public Object getElementAt(int i) {
        return data.get(i);
    }

    public Object getSelectedItem() {
        return selectedObject;
    }

    public void setSelectedItem(Object item) {
        selectedObject = item;
    }
    
    protected List getData() {
        return data;
    }
    
    public void initData(List data) {
        this.data = data;
        this.fireContentsChanged(this, 0, data.size());
    }

    public void clearData() {
        this.data = null;
    }
    

}
