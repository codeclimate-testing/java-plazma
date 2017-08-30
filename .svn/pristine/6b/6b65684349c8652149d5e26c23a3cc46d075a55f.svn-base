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

import org.eclipse.swt.widgets.Event;


/** 
 * @author Oleh Hapon
 *
 */

/**
 * The Render of table cell.
 * If you want create cutom render you have to implement this interface.
 * For example:
 * 
 * ITableCellRenderer myCellRenderer = new ITableCellRenderer() {
 * 
 *   public void measureCell(Event event) {
 *   }
 *   
 *   public void eraseCell(Event event) {
 *   }
 *   
 *   public void paintCell(Event event) {
 *     ...
 *   }
 * }
 * 
 * 
 * IListForm myListForm = new MyListForm(parenr, SWT.NONE);
 * myListForm.addCellRenderer(1, new myTableCellRenderer);
 * 
 * .....
 * 
 * ITableView tableView = new SWTTableViw();
 * tableView.addCellRenderer(1, new myTableCellRenderer);
 * 
 */


public interface ITableCellRenderer {

    /** Special <code>TableItem</code> property for store cell image **/
    String CELL_IMAGE = "cell.image";
    
    int getColumnIndex();
    
    void setColumnIndex(int columnIndex);
    
    
    void measureCell(Event event);
    
    void eraseCell(Event event);
    
    void paintCell(Event event);
}
