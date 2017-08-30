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
 * Created on 26.12.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/** 
 * @author Oleh Hapon
 * $Id: ResultDialog.java,v 1.2 2010/04/28 06:36:49 ohapon Exp $
 */

public class ResultDialog extends AbstractJFaceDialog {

    private Table table;
    
    private List list;
    
    private Object selectedItem;
    
    private List selectedItems;
    
    private String labelColumnName;
    
    private String valueColumnName;
    
    private boolean checkMode;
    
    private int valueColumnStyle = SWT.NONE;
    
    public ResultDialog (Shell parent, int style) {
	super (parent); //JFace
	//super (parent, style);
	initialize();
    }
    
    public ResultDialog (Shell parent) {
	this (parent, 0);
    }
    
    private void initialize() {
	//setText(Messages.getString("ChooseDialog.title")); //$NON-NLS-1$
	setPackMode(false);
    }
    
    // JFace
    protected Control createDialogArea(Composite parent) {
	Composite comp = createContentPanel(parent);
	createContent(comp);
	return comp;
    }
    
    
    protected void okPressed() {
	performOkAction();
	super.okPressed();
    }
    
    // JFace
    protected Point getInitialSize() {
	return new Point(300, 300);
    }
    
    protected void performOkAction() {

    }
    
     
    protected Composite createContentPanel(Composite parent) {
	Composite composite = new Composite(parent, SWT.NONE);
	composite.setLayout(new FillLayout());
	composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));	
	return composite;
    }
    
    
    
    protected void createContent(Composite parent) {
	int style = SWT.BORDER | SWT.FULL_SELECTION;
	if (isCheckMode()) {
	    style |= SWT.CHECK;
	}
	table = new Table(parent, style);
	table.addMouseListener(new MouseAdapter() {
		public void mouseDoubleClick(MouseEvent e) {
		    okPressed();
		    //doOkAction();
		}
	});
	table.addKeyListener(new KeyListener() {
	    public void keyPressed(KeyEvent e) {
		
	    }
	    public void keyReleased(KeyEvent e) {
		if (e.keyCode == SWT.CR) {
		    //doOkAction();
		    okPressed();
		}
	    }
	});
	table.setLinesVisible(true);
	table.setHeaderVisible(true);
	

	if (isCheckMode()) {
	    TableColumn entityColumn = new TableColumn(table, SWT.CHECK);
	    entityColumn.setWidth(20);
	}
	
	TableColumn labelColumn = new TableColumn(table, SWT.NONE);
	labelColumn.setWidth(140);
	labelColumn.setText(getLabelColumnName());

	TableColumn valueColumn = new TableColumn(table, valueColumnStyle);
	valueColumn.setWidth(150);
	valueColumn.setText(getValueColumnName());

	initTable();	
    }
    
    
    protected void initTable() {
	
	//tableView.updateTable(this.getList());
	
	List list = this.getList();
	int count = list.size();
	table.setItemCount(count);

	int labelColumnIndex = isCheckMode() ? 1 : 0; 
	int valueColumnIndex = labelColumnIndex + 1;
	for (int i = 0 ; i < count; i++) {
	    TableItem item = table.getItem(i);
	    Object data = list.get(i);
	    if (data == null) {
		continue;
	    }
	    Object[] row = (Object[]) data;
	    item.setData(data);
	    item.setText(labelColumnIndex, row[0].toString());
	    item.setText(valueColumnIndex, row[1].toString());
	    
	    item.setChecked(true);
	}
	if (count > 0) {
	    table.setSelection(0);
	}
	table.setFocus();
    }
    

    public List getList() {
	if (list == null) {
	    list = new ArrayList();
	}
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object getSelectedItem() {
        return selectedItem;
    }

    public List getSelectedItems() {
        return isCheckMode() ? selectedItems : null;
    }
    
    public String getLabelColumnName() {
	if (labelColumnName == null) {
	    labelColumnName = "Name";
	}
        return labelColumnName;
    }

    public void setLabelColumnName(String labelColumnName) {
        this.labelColumnName = labelColumnName;
    }

    
    public String getValueColumnName() {
	if (valueColumnName == null) {
	    valueColumnName = "Value";
	}
        return valueColumnName;
    }

    public void setValueColumnName(String valueColumnName) {
        this.valueColumnName = valueColumnName;
    }    
    public boolean isCheckMode() {
        return checkMode;
    }

    public void setCheckMode(boolean checkMode) {
        this.checkMode = checkMode;
    }

    public void setValueColumnStyle(int valueColumnStyle) {
        this.valueColumnStyle = valueColumnStyle;
    }
 
    
}
