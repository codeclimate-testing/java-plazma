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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableCombo extends AbstractExtCombo {

    /**
     * The Table Control
     */
    private Table table;
    
  
    
 
    public TableCombo(Composite parent, int style) {
	super(parent, style);
    }
    
    

    public TableCombo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
    }



    @Override
    protected void createPopupContent() {
	
	int style = getStyle ();
	int listStyle = SWT.SINGLE | SWT.V_SCROLL;
	if ((style & SWT.FLAT) != 0) listStyle |= SWT.FLAT;
	if ((style & SWT.RIGHT_TO_LEFT) != 0) listStyle |= SWT.RIGHT_TO_LEFT;
	if ((style & SWT.LEFT_TO_RIGHT) != 0) listStyle |= SWT.LEFT_TO_RIGHT;
	
	table = new Table(popup, listStyle);
	new TableColumn(table, 0);
	table.setHeaderVisible(false);
	table.setLinesVisible(true);
	
	popupContent = table;
	initPopupContentListener();

    }
    
    
    
    @Override
    protected Control getTextParent() {
	return text;
    }

    
    protected void doControlAdd(String string) {
    	doControlAdd(string, null);
    }
    
    protected void doControlAdd(String string, int index) {
    	TableItem item = table.getItem(index);
    	item.setText(string);
    }
    
    protected void doControlRemove(int index) {
	table.remove(index);
    }
    
    protected void doControlRemove(int start, int end) {
    	table.remove (start, end);
    }

    protected void doControlRemoveAll() {
    	table.removeAll();
    }

    protected void doControlDeselect(int index) {
    	table.deselect(index);
    }

    protected void doControlDeselectAll() {
    	table.deselectAll();
    }
    
    protected String doControlGetItem(int index) {
    	return table.getItem(index).getText();
    }
    
    protected int doControlGetItemCount() {
    	return table.getItemCount();
    }
    
    protected int doControlGetItemHeight() {
    	return table.getItemHeight();
    }
    
    protected String[] doControlGetItems() {
	TableItem[] items = table.getItems();
	String[] array = new String[items.length];
        for(int i = 0; i < items.length; i++) {
            array[i] = items[i].getText();
        }
    	return array;
    }
    
    protected int doControlGetSelectionIndex () {
    	return table.getSelectionIndex();
    }
    
    protected void doControlSetSelectionIndex(int index) {
    	table.setSelection(index);
    }
    
    protected void doControlShowSelection() {
	table.showSelection();
    }
    
    protected int doControlIndexOf(String string) {
	if(string == null) {
	    return -1;
	}
        TableItem items[] = table.getItems();
        for(int i = 0; i < items.length; i++) {
            TableItem item = items[i];
            if(item.getText().equalsIgnoreCase(string))
                return i;
        }
        return -1;
    }

    ////
    
    protected void doControlAdd(String string, Image image) {
    	TableItem item = new TableItem(table, 0);
        item.setText(string);
        item.setImage(image);
    }
    
    ////
    
    public void add(String string, Image image) {
        checkWidget();
        doControlAdd(string, image);
    }
    
    
    ////
    
    @Override
    protected void beforeDrop() {
	super.beforeDrop();
	
	Rectangle rect = getClientArea();
	int width = rect.width;
	
	Control[] buttons = getToolButtons();
	int buttonCount = buttons == null ? 0 : buttons.length;

	int toolBarWidth = 0;
	
	if (buttonCount > 0) {
	    for (int i = 0; i < buttonCount; i++) {
		Control button = buttons[i];
		if (button == null || button.isDisposed()) {
		    continue;
		}
		Point buttonSize = computeToolButtonSize(-1, -1, false);
		toolBarWidth += buttonSize.x;
	    }
	}
	if (toolBarWidth > 0) {
	    width = width - toolBarWidth; 
	}
	
	table.getColumn(0).setWidth(width - 5);
    }
}
