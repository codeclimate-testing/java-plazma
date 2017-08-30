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
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.TableItem;
import org.plazmaforge.framework.client.swt.views.ITableCellRenderer;


/** 
 * @author Oleh Hapon
 *
 */

public class TableProvider extends AbstractTableProvider<TableItem> implements ITableProvider<TableItem> {
    
    
    public int indexOfRow(TableItem item) {
	return item.getParent().indexOf(item);
    }
    
    
    protected void setRowText(TableItem tableItem, int columnIndex, String text) {
	tableItem.setText(columnIndex, text);
    }

    protected void setRowImage(TableItem tableItem, int columnIndex, Image image) {
	tableItem.setImage(columnIndex, image);
    }

    protected void setRowDataImage(TableItem tableItem, int columnIndex, Image image) {
	tableItem.setData(ITableCellRenderer.CELL_IMAGE + columnIndex, image);
    }

  
    // disable: don't use
    protected Image getTrImage(TableItem tableItem, Image img) {
	ImageData ideaData = img.getImageData();
	int whitePixel = ideaData.palette.getPixel(new RGB(255, 255, 255));
	ideaData.transparentPixel = whitePixel;
	Image transparentIdeaImage = new Image(tableItem.getDisplay(), ideaData);
	return transparentIdeaImage;
    }
    
    
   
}
