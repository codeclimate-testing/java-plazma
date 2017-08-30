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

package org.plazmaforge.framework.client.swt.views;


import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TableItem;


/** 
 * @author Oleh Hapon
 * $Id: ImageTableCellRenderer.java,v 1.2 2010/04/28 06:36:48 ohapon Exp $
 */

/**
 * The Image render of table cell
 */
public class ImageTableCellRenderer implements ITableCellRenderer {
    
    private int columnIndex;
    
    
    public int getColumnIndex() {
        return columnIndex;
    }


    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }


    
 
    protected Image getItemImage(TableItem item, int columnIndex) {
	return (Image) item.getData(CELL_IMAGE + columnIndex);
    }

    
    
    public void measureCell(Event event) {
	
    }
    
    public void eraseCell(Event event) {
	//event.detail &= ~SWT.FOREGROUND;
	//TableItem item = (TableItem) event.item;
	//Table table = item.getParent();
	//int clientWidth = table.getClientArea().width; 
        //event.gc.fillRectangle(0, event.y, clientWidth, event.height); 
    }
    
    public void paintCell(Event event) {
	TableItem item = (TableItem) event.item;
	Image image = getItemImage(item, columnIndex);
	if (image == null) {
	    return;
	}

	Rectangle cellRec = item.getBounds(columnIndex);
	Rectangle imageRec = image.getBounds();

	int dx = cellRec.width - imageRec.width;
	int dy = cellRec.height - imageRec.height;

	if (dx < 0 || dy < 0) {
	    return;
	}
	int x = dx / 2;
	int y = dy / 2;
	event.gc.drawImage(image, event.x + x, event.y + y);
    }
    
    
    
    
    /*
    public void paintCell(GC gc, TableItem item, int index, int columnIndex) {
	
	
	Image image = getItemImage(item, columnIndex);
	if (image == null) {
	    return;
	}
	
	Rectangle cellRec = item.getBounds(columnIndex);
	Rectangle imageRec = image.getBounds();

	int dx = cellRec.width - imageRec.width;
	int dy = cellRec.height - imageRec.height;
	
	if (dx < 0 || dy < 0) {
	    return;
	}
	int x = dx / 2;
	int y = dy / 2;

	
//	Table table = item.getParent();
//	
//	boolean isSelected = false;
//	
//	TableColumn sortColumn = table.getSortColumn();
//	boolean isSortColumn = false;
//	
//	if (sortColumn != null && table.indexOf(sortColumn) == columnIndex) {
//	    isSortColumn = true;
//	}
//
//        if (table.isSelected(index)) {
//	    isSelected = true;
//	}
//	Color color = gc.getBackground();
//	if (isSelected) {
//	    gc.setBackground(table.isFocusControl() ? SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION) : SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
//	} else {
//	    if (isSortColumn) {
//		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
//	    } else {
//		gc.setBackground(item.getBackground(columnIndex));
//	    }
//	}
//	gc.fillRectangle(cellRec.x, cellRec.y, cellRec.width, cellRec.height);
	
	
	
	
	gc.drawImage(image, cellRec.x + x, cellRec.y + y);
	

//	if (isSelected) {
//	    gc.setBackground(color);
//	}
	
    }
    */


}
