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
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;

/**
 *  
 * @author Oleh Hapon
 * $Id: EmailTableView.java,v 1.3 2010/04/28 06:31:04 ohapon Exp $
 */

public class EmailTableView extends AbstractTableView {

    private Table emailTable;
    
    public EmailTableView(Composite parent, Class viewClass) {
	super(parent, viewClass);
	
	
	TabItem emailTabItem = new TabItem(getTabFolder(), SWT.NONE);
    	emailTabItem.setText(Messages.getString("EmailTableView.emailTabItem.text")); //$NON-NLS-1$

    	emailTable = new Table(getTabFolder(), SWTToolkit.TABLE_STYLE);
    	emailTable.setLinesVisible(true);
    	emailTable.setHeaderVisible(true);
    	emailTabItem.setControl(emailTable);

    	TableColumn tableColumn = new TableColumn(emailTable, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	final TableColumn emailColumn = new TableColumn(emailTable, SWT.NONE);
    	emailColumn.setWidth(349);
    	emailColumn.setText(Messages.getString("EmailTableView.emailColumn.text")); //$NON-NLS-1$
    	
    }

    protected class EmailProvider extends TableEntityProvider {
	
	public EmailProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("emailList");
	    setAddMethod("addEmail");
	    
	    setEntityClass(Email.class); // FORM ID
	    setEntityFormClass(EmailEditForm.class);
	    
	    setForceRefreshAll(true); // VERY IMPORTANT FOR REFRESH DEFAULT BOOLEAN FLAG
	}
	
	protected Table getTable() {
	    return emailTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "defaultItem");
	    bindColumn(1, "emailAddress");
	}
    }
    
    protected TableEntityProvider createTableEntityProvider() {
	return new EmailProvider();
	
    }
}
