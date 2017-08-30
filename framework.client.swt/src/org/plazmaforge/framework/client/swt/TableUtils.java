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
 * Created on 13.08.2007
 *
 */

package org.plazmaforge.framework.client.swt;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/** 
 * @author Oleh Hapon
 * $Id: TableUtils.java,v 1.3 2010/10/27 07:18:22 ohapon Exp $
 */

public class TableUtils {

    
    public static int getMouseEventColumn(MouseEvent e) {
	Table table = (Table) e.widget;
	int x = e.x;
	int y = e.y;
	return getMouseEventColumn(table, x, y);
    }

    public static int getMouseEventColumn(Table table, int x, int y) {
	int index = table.getSelectionIndex();
	if (index < 0) {
	    return -1;
	}
	TableItem item = table.getItem(index);
	int columnCount = table.getColumnCount();
	for (int i = 0; i < columnCount; i++) {
	    Rectangle rec = item.getBounds(i);
	    if (rec.contains(x, y)) {
		return i;
	    }
	}
	return -1;
    }
    
    public static int getMouseEventColumn(Tree tree, int x, int y) {
	TreeItem[] items = tree.getSelection();
	if (items == null || items.length == 0) {
	    return -1;
	}
	TreeItem item = items[0];
	int columnCount = tree.getColumnCount();
	for (int i = 0; i < columnCount; i++) {
	    Rectangle rec = item.getBounds(i);
	    if (rec.contains(x, y)) {
		return i;
	    }
	}
	return -1;
    }

}
