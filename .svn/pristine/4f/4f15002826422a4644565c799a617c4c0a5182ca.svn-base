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
 * Created on 29.12.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.dialogs;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.plazmaforge.bsolution.finance.common.beans.EntryItem;
import org.plazmaforge.framework.client.swt.dialogs.AbstractJFaceDialog;
import org.plazmaforge.framework.platform.PlatformEnvironment;


/** 
 * @author Oleh Hapon
 * $Id: EntryItemsDialog.java,v 1.2 2010/04/28 06:31:05 ohapon Exp $
 */

public class EntryItemsDialog extends AbstractJFaceDialog {
    
    private Table table;
    
    private List list;
    
    
    public EntryItemsDialog (Shell parent, int style) {
	super (parent); //JFace
	initialize();
    }
    
    public EntryItemsDialog (Shell parent) {
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
	return new Point(900, 300);
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
	table = new Table(parent, style);
	table.setLinesVisible(true);
	table.setHeaderVisible(true);
	

	TableColumn debitColumn = new TableColumn(table, SWT.NONE);
	debitColumn.setWidth(50);
	debitColumn.setText("Debit");

	TableColumn debitObjectColumn = new TableColumn(table, SWT.NONE);
	debitObjectColumn.setWidth(220);
	debitObjectColumn.setText("Debit Object");

	TableColumn creditColumn = new TableColumn(table, SWT.NONE);
	creditColumn.setWidth(50);
	creditColumn.setText("Credit");

	TableColumn creditObjectColumn = new TableColumn(table, SWT.NONE);
	creditObjectColumn.setWidth(220);
	creditObjectColumn.setText("Credit Object");

	TableColumn contentColumn = new TableColumn(table, SWT.NONE);
	contentColumn.setWidth(250);
	contentColumn.setText("Content");

	TableColumn amountColumn = new TableColumn(table, SWT.RIGHT);
	amountColumn.setWidth(100);
	amountColumn.setText("Amount");

	initTable();	
    }
    
    
    protected void initTable() {
	
	List list = getList();
	int count = list == null ? 0 : list.size();
	table.setItemCount(count);

	NumberFormat format = PlatformEnvironment.getCurrencyFormat();
	
	for (int i = 0 ; i < count; i++) {
	    TableItem item = table.getItem(i);
	    Object data = list.get(i);
	    if (data == null) {
		continue;
	    }
	    EntryItem entryItem =  (EntryItem) data;
	    item.setData(data);
	    setItemText(item, 0, entryItem.getDebitLedgerAccount().getAccount());
	    setItemText(item, 1, entryItem.getDebitObjectName());
	    setItemText(item, 2, entryItem.getCreditLedgerAccount().getAccount());
	    setItemText(item, 3, entryItem.getCreditObjectName());
	    setItemText(item, 4, entryItem.getContent());
	    setItemText(item, 5, format.format(entryItem.getAmount()));
	}
	if (count > 0) {
	    table.setSelection(0);
	}
	table.setFocus();
    }
    
    protected void setItemText(TableItem item, int index, String text) {
	if (item == null || text == null) {
	    return;
	}
	item.setText(index, text);
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

  
}