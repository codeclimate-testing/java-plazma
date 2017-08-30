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

package org.plazmaforge.framework.client.swt.controls;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TreeItem;
import org.plazmaforge.framework.client.swt.views.ITableCellRenderer;

public class TreeProvider extends AbstractTableProvider<TreeItem> implements ITableProvider<TreeItem>{

    public int indexOfRow(TreeItem item) {
	return item.getParent().indexOf(item);
    }
    
    
    protected void setRowText(TreeItem treeItem, int columnIndex, String text) {
	treeItem.setText(columnIndex, text);
    }

    protected void setRowImage(TreeItem treeItem, int columnIndex, Image image) {
	treeItem.setImage(columnIndex, image);
    }

    protected void setRowDataImage(TreeItem treeItem, int columnIndex, Image image) {
	treeItem.setData(ITableCellRenderer.CELL_IMAGE + columnIndex, image);
    }

}
