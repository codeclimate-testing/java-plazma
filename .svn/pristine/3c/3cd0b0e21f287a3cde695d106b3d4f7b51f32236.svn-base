/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 04.02.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: ContractListForm.java,v 1.6 2010/12/05 07:57:18 ohapon Exp $
 */

public class ContractListForm extends AbstractFinanceDocumentListForm {

    private Table table;
    

    
    
    public ContractListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {

	setTitle(Messages.getString("ContractListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn endDateColumn;
        TableColumn nameColumn;
        TableColumn partnerColumn;
        TableColumn currencyTotalColumn;
        TableColumn currencyColumn;
        TableColumn totalColumn;
        TableColumn responsibleColumn;
        TableColumn projectColumn;

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
        documentNoColumn.setWidth(100);
        documentNoColumn.setText(Messages.getString("ContractListForm.documentNoColumn.text")); //$NON-NLS-1$

        documentDateColumn = new TableColumn(table, SWT.NONE);
        documentDateColumn.setMoveable(true);
        documentDateColumn.setWidth(100);
        documentDateColumn.setText(Messages.getString("ContractListForm.documentDateColumn.text")); //$NON-NLS-1$

        endDateColumn = new TableColumn(table, SWT.NONE);
        endDateColumn.setMoveable(true);
        endDateColumn.setWidth(100);
        endDateColumn.setText(Messages.getString("ContractListForm.endDateColumn.text")); //$NON-NLS-1$

        nameColumn = new TableColumn(table, SWT.NONE);
        nameColumn.setMoveable(true);
        nameColumn.setWidth(200);
        nameColumn.setText(Messages.getString("ContractListForm.nameColumn.text")); //$NON-NLS-1$
        
        partnerColumn = new TableColumn(table, SWT.NONE);
        partnerColumn.setMoveable(true);
        partnerColumn.setWidth(250);
        partnerColumn.setText(Messages.getString("ContractListForm.partnerColumn.text")); //$NON-NLS-1$
    	
        currencyTotalColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalColumn.setMoveable(true);
        currencyTotalColumn.setWidth(100);
        currencyTotalColumn.setText(Messages.getString("ContractListForm.currencyTotalColumn.text")); //$NON-NLS-1$
    	
        currencyColumn = new TableColumn(table, SWT.CENTER);
        currencyColumn.setMoveable(true);
        currencyColumn.setWidth(100);
        currencyColumn.setText(Messages.getString("ContractListForm.currencyColumn.text")); //$NON-NLS-1$
    	
        totalColumn = new TableColumn(table, SWT.RIGHT);
        totalColumn.setMoveable(true);
        totalColumn.setWidth(100);
        totalColumn.setText(Messages.getString("ContractListForm.totalColumn.text"));    	 //$NON-NLS-1$
    	
        responsibleColumn = new TableColumn(table, SWT.NONE);
        responsibleColumn.setMoveable(true);
        responsibleColumn.setWidth(100);
        responsibleColumn.setText(Messages.getString("ContractListForm.responsibleColumn.text")); //$NON-NLS-1$
        
        projectColumn = new TableColumn(table, SWT.NONE);
        projectColumn.setMoveable(true);
        projectColumn.setWidth(150);
        projectColumn.setText(Messages.getString("ContractListForm.projectColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("endDate", getDateFormat());
	bindColumn("name");
	bindColumn("partnerName");
	bindColumn("currencyTotalWithTax", getCurrencyFormat());
	bindColumn("currencyName");
	bindColumn("totalWithTax", getCurrencyFormat());
	bindColumn("responsibleName");
	
	bindColumn("projectName");
    }
 

    private String amountVar = "totalWithTax";

    
    protected void initAggregateVariables() {
	setAggregateVariable(amountVar, 0d);
    }
    
    protected void calculateAggregateVariablesByEntity(Object entity) throws ApplicationException {
	String varName = amountVar;
	Double amount = (Double) getEntityValue(varName, entity);
	double summa = (Double) getAggregateVariable(varName);
	summa += amount;
	setAggregateVariable(varName, summa);
    }

    protected String getAggregateVariablesText() {
	double amount = (Double) getAggregateVariable(amountVar);
	return  getAggregateVariablesLabel() + getCurrencyFormat().format(amount);
    }

    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }
 
    protected boolean isEntryItemsAction() {
	return false;
    }
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
