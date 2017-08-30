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
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/**
 *  
 * @author Oleh Hapon
 * $Id: AddressTableView.java,v 1.3 2010/04/28 06:31:05 ohapon Exp $
 */
public class AddressTableView extends AbstractTableView {

    private Table addressTable;
    
    public AddressTableView(Composite parent, Class viewClass) {
	super(parent, viewClass);
	
	
	TabItem  addressTabItem = new TabItem(getTabFolder(), SWT.NONE);
    	addressTabItem.setText(Messages.getString("AddressTableView.addressTabItem.text")); //$NON-NLS-1$

    	addressTable = new Table(getTabFolder(), SWTToolkit.TABLE_STYLE);
    	addressTable.setLinesVisible(true);
    	addressTable.setHeaderVisible(true);
    	addressTabItem.setControl(addressTable);

    	TableColumn tableColumn = new TableColumn(addressTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn addressTypeColumn = new TableColumn(addressTable, SWT.NONE);
    	addressTypeColumn.setWidth(100);
    	addressTypeColumn.setText(Messages.getString("AddressTableView.addressTypeColumn.text")); //$NON-NLS-1$

    	final TableColumn fullAddressStringColumn = new TableColumn(addressTable, SWT.NONE);
    	fullAddressStringColumn.setWidth(337);
    	fullAddressStringColumn.setText(Messages.getString("AddressTableView.fullAddressStringColumn.text")); //$NON-NLS-1$
    }

    protected class AddressProvider extends TableEntityProvider {
	
	public AddressProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("addressList");
	    setAddMethod("addAddress");
	    
	    setEntityClass(Address.class); // FORM ID
	    setEntityFormClass(AddressEditForm.class);
	    
	    setForceRefreshAll(true); // VERY IMPORTANT FOR REFRESH DEFAULT BOOLEAN FLAG
	}
	
	protected Table getTable() {
	    return addressTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "addressTypeName");
	    bindColumn(2, "fullAddressString");
	}
    }
    
    protected TableEntityProvider createTableEntityProvider() {
	return new AddressProvider();
	
    }
}
