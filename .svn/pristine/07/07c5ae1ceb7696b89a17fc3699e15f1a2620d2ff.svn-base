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
package org.plazmaforge.bsolution.contact.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.AbstractTableView;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/**
 *  
 * @author Oleh Hapon
 * $Id: PhoneTableView.java,v 1.3 2010/04/28 06:31:05 ohapon Exp $
 */

public class PhoneTableView extends AbstractTableView {

    private Table phoneTable;
    
    public PhoneTableView(Composite parent, Class viewClass) {
	super(parent, viewClass);
	
	
	TabItem phoneTabItem = new TabItem(getTabFolder(), SWT.NONE);
    	phoneTabItem.setText(Messages.getString("PhoneTableView.phoneTabItem.text")); //$NON-NLS-1$
  

    	phoneTable = new Table(getTabFolder(), SWTToolkit.TABLE_STYLE);
    	phoneTable.setLinesVisible(true);
    	phoneTable.setHeaderVisible(true);
    	phoneTabItem.setControl(phoneTable);

    	TableColumn  tableColumn = new TableColumn(phoneTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn phoneTypeColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneTypeColumn.setWidth(100);
    	phoneTypeColumn.setText(Messages.getString("PhoneTableView.phoneTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn phoneStringColumn = new TableColumn(phoneTable, SWT.NONE);
    	phoneStringColumn.setWidth(343);
    	phoneStringColumn.setText(Messages.getString("PhoneTableView.phoneStringColumn.text")); //$NON-NLS-1$
    	
    }

    protected class PhoneProvider extends TableEntityProvider {
	
	public PhoneProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("phoneList");
	    setAddMethod("addPhone");
	    
	    setEntityClass(Phone.class); // FORM ID
	    setEntityFormClass(PhoneEditForm.class);
	    
	    setForceRefreshAll(true); // VERY IMPORTANT FOR REFRESH DEFAULT BOOLEAN FLAG
	}
	
	protected Table getTable() {
	    return phoneTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "phoneTypeName");
	    bindColumn(2, "phoneString");
	}
    }
    
    protected TableEntityProvider createTableEntityProvider() {
	return new PhoneProvider();
	
    }
}
