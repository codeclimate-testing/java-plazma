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
 * Created on 09.07.2008
 *
 */

package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
//import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
//import org.eclipse.swt.widgets.Tree;
//import org.plazmaforge.bsolution.product.common.services.ProductGroupService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

/** 
 * @author Oleh Hapon
 * $Id: CarPartListForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */

public class CarPartListForm extends AbstractListForm {

    //private Tree tree;
    
    private Table table;
    

    
    public CarPartListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarPartListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn codeColumn;
        TableColumn nameColumn;
        //TableColumn goodsTypeColumn;
        TableColumn unitColumn;
        TableColumn currencyColumn;
        TableColumn currencyCostPriceColumn;
        TableColumn currencyListPriceColumn;
        
        TableColumn carMarkColumn;
        TableColumn carModelColumn;

        setLayout(new FillLayout());
 
        //SashForm sashForm = new SashForm(this, SWT.NONE);
	
	// Create Group Tree 
        //tree = new Tree(sashForm, SWT.BORDER);


    	table = new Table(this/*sashForm*/, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("CarPartListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("CarPartListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	//goodsTypeColumn = new TableColumn(table, SWT.NONE);
    	//goodsTypeColumn.setWidth(100);
    	//goodsTypeColumn.setText(Messages.getString("CarPartListForm.goodsTypeColumn.text")); //$NON-NLS-1$
    	
    	unitColumn = new TableColumn(table, SWT.CENTER);
    	unitColumn.setWidth(100);
    	unitColumn.setText(Messages.getString("CarPartListForm.unitColumn.text")); //$NON-NLS-1$
    	
    	currencyColumn = new TableColumn(table, SWT.CENTER);
    	currencyColumn.setWidth(100);
    	currencyColumn.setText(Messages.getString("CarPartListForm.currencyColumn.text")); //$NON-NLS-1$
    	
    	currencyCostPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyCostPriceColumn.setWidth(100);
    	currencyCostPriceColumn.setText(Messages.getString("CarPartListForm.currencyCostPriceColumn.text")); //$NON-NLS-1$

    	currencyListPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyListPriceColumn.setWidth(100);
    	currencyListPriceColumn.setText(Messages.getString("CarPartListForm.currencyListPriceColumn.text")); //$NON-NLS-1$

    	carMarkColumn = new TableColumn(table, SWT.NONE);
    	carMarkColumn.setWidth(150);
    	carMarkColumn.setText(Messages.getString("CarPartListForm.carMarkColumn.text")); //$NON-NLS-1$
    	
    	carModelColumn = new TableColumn(table, SWT.NONE);
    	carModelColumn.setWidth(150);
    	carModelColumn.setText(Messages.getString("CarPartListForm.carModelColumn.text")); //$NON-NLS-1$
    	
    	
    	//sashForm.setWeights(new int[] {1, 5 });
    	
        this.setSize(new Point(600, 300));
        
        
        
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn("name");
	//bindColumn("goodsTypeName");
	bindColumn("unitName");
	bindColumn("currencyName");
	bindColumn("currencyCostPrice", getCurrencyFormat());
	bindColumn("currencyListPrice", getCurrencyFormat());

	
	bindColumn("carMarkName");
	bindColumn("carModelName");
    }
 
    ////
    
    /*
    protected Tree getTree() {
	return tree;
    }
    
    protected Class getTreeServiceClass() {
	return ProductGroupService.class;
    }
    
    protected String getTreeItemRefIdProperty() {
	return "productGroupId";
    }
    
    protected String getTreeItemParentIdProperty() {
	return "parentId";
    }
    */

    ////
    
   

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
