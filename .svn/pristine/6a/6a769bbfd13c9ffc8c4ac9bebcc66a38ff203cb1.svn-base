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

package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarInsurerContractVariantListForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */
public class CarInsurerContractVariantListForm extends AbstractListForm {

    
    private Table table;
    
    public CarInsurerContractVariantListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
	setTitle(Messages.getString("CarInsurerContractVariantListForm.title")); //$NON-NLS-1$
	
	// Set COPY MODE
	setSupportCopyMode(true);
	
        TableColumn tableColumn;
        
        TableColumn contractCodeColumn;
        TableColumn variantCodeColumn;
        TableColumn contractDateColumn;
        TableColumn variantDateColumn;
        TableColumn insurerColumn;
        TableColumn organizationColumn;
        

        setLayout(new FillLayout(SWT.VERTICAL));
    	
        this.setSize(new Point(600, 300));
 

        table = new Table(this, SWTToolkit.TABLE_STYLE);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        contractCodeColumn = new TableColumn(table, SWT.NONE);
        contractCodeColumn.setMoveable(true);
        contractCodeColumn.setWidth(100);
        contractCodeColumn.setText(Messages.getString("CarInsurerContractVariantListForm.contractCodeColumn.text")); //$NON-NLS-1$
        
        contractDateColumn = new TableColumn(table, SWT.NONE);
        contractDateColumn.setMoveable(true);
        contractDateColumn.setWidth(100);
        contractDateColumn.setText(Messages.getString("CarInsurerContractVariantListForm.contractDateColumn.text")); //$NON-NLS-1$

        
        variantCodeColumn = new TableColumn(table, SWT.NONE);
        variantCodeColumn.setMoveable(true);
        variantCodeColumn.setWidth(100);
        variantCodeColumn.setText(Messages.getString("CarInsurerContractVariantListForm.variantCodeColumn.text")); //$NON-NLS-1$

        variantDateColumn = new TableColumn(table, SWT.NONE);
        variantDateColumn.setMoveable(true);
        variantDateColumn.setWidth(100);
        variantDateColumn.setText(Messages.getString("CarInsurerContractVariantListForm.variantDateColumn.text")); //$NON-NLS-1$

        
        insurerColumn = new TableColumn(table, SWT.NONE);
        insurerColumn.setMoveable(true);
        insurerColumn.setWidth(200);
        insurerColumn.setText(Messages.getString("CarInsurerContractVariantListForm.insurerColumn.text")); //$NON-NLS-1$

        organizationColumn = new TableColumn(table, SWT.NONE);
        organizationColumn.setMoveable(true);
        organizationColumn.setWidth(200);
        organizationColumn.setText(Messages.getString("CarInsurerContractVariantListForm.organizationColumn.text")); //$NON-NLS-1$

    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "contractCode");
	bindColumn("contractDate", getDateFormat());
	bindColumn("variantCode");
	bindColumn("variantDate", getDateFormat());	
	bindColumn("insurerName");
	bindColumn("organizationName");
    }
    

 

}
