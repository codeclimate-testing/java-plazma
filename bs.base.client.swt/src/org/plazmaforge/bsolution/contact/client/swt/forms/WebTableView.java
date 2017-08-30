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
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/**
 *  
 * @author Oleh Hapon
 * $Id: WebTableView.java,v 1.3 2010/04/28 06:31:05 ohapon Exp $
 */

public class WebTableView extends AbstractTableView {

    private Table webTable;
    
    public WebTableView(Composite parent, Class viewClass) {
	super(parent, viewClass);
	
	
	TabItem webTabItem = new TabItem(getTabFolder(), SWT.NONE);
    	webTabItem.setText(Messages.getString("WebTableView.webTabItem.text")); //$NON-NLS-1$

    	webTable = new Table(getTabFolder(), SWTToolkit.TABLE_STYLE);
    	webTable.setLinesVisible(true);
    	webTable.setHeaderVisible(true);
    	webTabItem.setControl(webTable);

    	TableColumn tableColumn = new TableColumn(webTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn urlColumn = new TableColumn(webTable, SWT.NONE);
    	urlColumn.setWidth(377);
    	urlColumn.setText(Messages.getString("WebTableView.urlColumn.text")); //$NON-NLS-1$
    }
    
    protected class WebProvider extends TableEntityProvider {
	
	public WebProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("webList");
	    setAddMethod("addWeb");
	    
	    setEntityClass(Web.class); // FORM ID
	    setEntityFormClass(WebEditForm.class);
	    
	    setForceRefreshAll(true); // VERY IMPORTANT FOR REFRESH DEFAULT BOOLEAN FLAG
	}
	
	protected Table getTable() {
	    return webTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "url");
	}
    }
    
    protected TableEntityProvider createTableEntityProvider() {
	return new WebProvider();
	
    }
}
