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
import org.plazmaforge.bsolution.finance.client.swt.forms.AbstractFinanceDocumentListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderListForm.java,v 1.4 2010/12/05 07:53:48 ohapon Exp $
 */
public class CarServOrderListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public CarServOrderListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarServOrderListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn carColumn;
        
        TableColumn carRegNumberColumn;
        TableColumn carChassisNumberColumn;
        TableColumn carManufactureYearColumn;
        TableColumn carOwnerNameColumn;
        
        TableColumn currencyTotalColumn;
        TableColumn currencyColumn; 
        TableColumn totalColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
    	
        this.setSize(new Point(600, 300));
 

        table = new Table(this, SWTToolkit.TABLE_STYLE);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setResizable(false);
        tableColumn.setWidth(20);

        documentNoColumn = new TableColumn(table, SWT.NONE);
        documentNoColumn.setMoveable(true);
        documentNoColumn.setWidth(70);
        documentNoColumn.setText(Messages.getString("CarServOrderListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(70);
        documentDateColumn.setText(Messages.getString("CarServOrderListForm.documentDateColumn.text")); //$NON-NLS-1$

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        carColumn = new TableColumn(table, SWT.NONE);
        carColumn.setMoveable(true);
        carColumn.setWidth(200);
        carColumn.setText(Messages.getString("CarServOrderListForm.carColumn.text")); //$NON-NLS-1$

        carRegNumberColumn = new TableColumn(table, SWT.NONE);
        carRegNumberColumn.setMoveable(true);
        carRegNumberColumn.setWidth(140);
        carRegNumberColumn.setText(Messages.getString("CarServOrderListForm.carRegNumberColumn.text")); //$NON-NLS-1$

        carChassisNumberColumn = new TableColumn(table, SWT.NONE);
        carChassisNumberColumn.setMoveable(true);
        carChassisNumberColumn.setWidth(140);
        carChassisNumberColumn.setText(Messages.getString("CarServOrderListForm.carChassisNumberColumn.text")); //$NON-NLS-1$

        carManufactureYearColumn = new TableColumn(table, SWT.RIGHT);
        carManufactureYearColumn.setMoveable(true);
        carManufactureYearColumn.setWidth(80);
        carManufactureYearColumn.setText(Messages.getString("CarServOrderListForm.carManufactureYearColumn.text")); //$NON-NLS-1$

        // Car Owner (Partner)
        carOwnerNameColumn = new TableColumn(table, SWT.NONE);
        carOwnerNameColumn.setMoveable(true);
        carOwnerNameColumn.setWidth(200);
        carOwnerNameColumn.setText(Messages.getString("CarServOrderListForm.carOwnerNameColumn.text")); //$NON-NLS-1$

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(110);
        currencyTotalColumn.setText(Messages.getString("CarServOrderListForm.currencyTotalColumn.text"));    	 //$NON-NLS-1$
    	
        currencyColumn = new TableColumn(table, SWT.CENTER);
        currencyColumn.setMoveable(true);
        currencyColumn.setWidth(70);
        currencyColumn.setText(Messages.getString("CarServOrderListForm.currencyColumn.text")); //$NON-NLS-1$
        
        totalColumn = new TableColumn(table, SWT.RIGHT);
        totalColumn.setMoveable(true);
        totalColumn.setWidth(110);
        totalColumn.setText(Messages.getString("CarServOrderListForm.totalColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentNoDate", getDateFormat());
	bindColumn("carName");
	bindColumn("carRegNumber");
	bindColumn("carChassisNumber");
	bindColumn("carManufactureYear");
	bindColumn("carOwnerName"); // Owner (Partner)
	bindColumn("currencyEnterTotal", getCurrencyFormat());
	bindColumn("currencyName");
	bindColumn("enterTotal", getCurrencyFormat());

    }
 
    ////
    
    private String amountVar = "enterTotal";

    
    protected void initAggregateVariables() {
	setAggregateVariable(amountVar, 0d);
    }
    
    protected void calculateAggregateVariablesByEntity(Object entity) throws ApplicationException {
	calculateVariableSum(amountVar, entity);
    }

    protected String getAggregateVariablesText() {
	double amount = (Double) getAggregateVariable(amountVar);
	return  getAggregateVariablesLabel() + formatCurrency(amount);
    }

    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }
    
    protected boolean isEntryItemsAction() {
	return false;
    }

}
