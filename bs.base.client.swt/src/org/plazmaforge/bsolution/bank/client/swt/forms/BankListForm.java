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

package org.plazmaforge.bsolution.bank.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.bank.common.beans.BankHeader;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.resources.RegionMessages;

/** 
 * @author Oleh Hapon
 * $Id: BankListForm.java,v 1.4 2010/04/28 06:31:08 ohapon Exp $
 */
public class BankListForm extends AbstractListForm {

    private Table table;
    

    
    public BankListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("BankListForm.title")); //$NON-NLS-1$
	
	setEntityClass(BankHeader.class);
	
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn bicColumn;
        TableColumn phoneColumn;
        TableColumn cityColumn;
        TableColumn addressColumn;        

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("BankListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("BankListForm.nameColumn.text")); //$NON-NLS-1$

    	bicColumn = new TableColumn(table, SWT.NONE);
    	bicColumn.setWidth(100);
    	bicColumn.setText(RegionMessages.getString(RegionMessages.BIC_KEY)); //$NON-NLS-1$

	phoneColumn = new TableColumn(table, SWT.NONE);
    	phoneColumn.setWidth(100);
    	phoneColumn.setText(Messages.getString("BankListForm.phoneColumn.text"));        	 //$NON-NLS-1$
    	
	cityColumn = new TableColumn(table, SWT.NONE);
    	cityColumn.setWidth(150);
    	cityColumn.setText(Messages.getString("BankListForm.cityColumn.text")); //$NON-NLS-1$
    	    	
	addressColumn = new TableColumn(table, SWT.NONE);
    	addressColumn.setWidth(250);
    	addressColumn.setText(Messages.getString("BankListForm.addressColumn.text")); //$NON-NLS-1$
    	    	

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn(2, "name");
	bindColumn(3, "bic");
	bindColumn(4, "phoneString");
	bindColumn(5, "cityName");	
	bindColumn(6, "localityAddressString");
	
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"

