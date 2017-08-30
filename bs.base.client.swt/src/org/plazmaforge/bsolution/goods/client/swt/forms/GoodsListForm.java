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
package org.plazmaforge.bsolution.goods.client.swt.forms;


import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.bsolution.goods.GoodsEnvironment;
import org.plazmaforge.bsolution.product.common.beans.ProductGroup;
import org.plazmaforge.bsolution.product.common.services.ProductGroupService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.platform.EntityEnvironment;

/** 
 * @author Oleh Hapon
 * $Id: GoodsListForm.java,v 1.6 2010/04/28 06:31:00 ohapon Exp $
 */

public class GoodsListForm extends AbstractListForm {

    private Tree tree;
    
    private Table table;
    

    
    public GoodsListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("GoodsListForm.title")); //$NON-NLS-1$
	
	// 
	setTreeEntityClass(ProductGroup.class);
	setTreeServiceClass(ProductGroupService.class);
	setTreeItemRefIdProperty("productGroupId");
	setTreeItemParentIdProperty("parentId");
	    
        TableColumn tableColumn;
        
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn goodsTypeColumn;
        TableColumn unitColumn;
        TableColumn currencyColumn;
        
        TableColumn currencyCostPriceColumn;
        TableColumn currencyListPriceColumn;
        
        TableColumn productGroupColumn;
        
        
        TableColumn availableQuantityColumn;
        TableColumn reservedQuantityColumn;
        TableColumn expectedQuantityColumn;
        TableColumn responsibleColumn;
        
        

        setLayout(new FillLayout());
 
        SashForm sashForm = new SashForm(this, SWT.NONE);
	
	// Create Group Tree 
        tree = new Tree(sashForm, SWT.BORDER);


    	table = new Table(sashForm, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("GoodsListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("GoodsListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	goodsTypeColumn = new TableColumn(table, SWT.NONE);
    	goodsTypeColumn.setWidth(100);
    	goodsTypeColumn.setText(Messages.getString("GoodsListForm.goodsTypeColumn.text")); //$NON-NLS-1$
    	
    	unitColumn = new TableColumn(table, SWT.CENTER);
    	unitColumn.setWidth(100);
    	unitColumn.setText(Messages.getString("GoodsListForm.unitColumn.text")); //$NON-NLS-1$
    	
    	currencyColumn = new TableColumn(table, SWT.CENTER);
    	currencyColumn.setWidth(100);
    	currencyColumn.setText(Messages.getString("GoodsListForm.currencyColumn.text")); //$NON-NLS-1$
    	
    	currencyCostPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyCostPriceColumn.setWidth(100);
    	currencyCostPriceColumn.setText(Messages.getString("GoodsListForm.currencyCostPriceColumn.text")); //$NON-NLS-1$


    	currencyListPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyListPriceColumn.setWidth(100);
    	currencyListPriceColumn.setText(Messages.getString("GoodsListForm.currencyListPriceColumn.text")); //$NON-NLS-1$

    	productGroupColumn = new TableColumn(table, SWT.NONE);
    	productGroupColumn.setWidth(100);
    	productGroupColumn.setText(Messages.getString("GoodsListForm.productGroupColumn.text")); //$NON-NLS-1$

    	
    	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        availableQuantityColumn = new TableColumn(table, SWT.RIGHT);
        availableQuantityColumn.setWidth(100);
        availableQuantityColumn.setText(Messages.getString("GoodsListForm.availableQuantityColumn.text")); //$NON-NLS-1$

        reservedQuantityColumn = new TableColumn(table, SWT.RIGHT);
        reservedQuantityColumn.setWidth(100);
        reservedQuantityColumn.setText(Messages.getString("GoodsListForm.reservedQuantityColumn.text")); //$NON-NLS-1$

        expectedQuantityColumn = new TableColumn(table, SWT.RIGHT);
        expectedQuantityColumn.setWidth(100);
        expectedQuantityColumn.setText(Messages.getString("GoodsListForm.expectedQuantityColumn.text")); //$NON-NLS-1$

 	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("GoodsListForm.responsibleColumn.text"));  //$NON-NLS-1$

    	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	sashForm.setWeights(new int[] {1, 5 });
    	
        this.setSize(new Point(600, 300));
        
        setFlexiblePagingMode();   
        
        if (!GoodsEnvironment.isMoreEntities()) {
            return;
        }
        
        Set<String> goodsEntities = GoodsEnvironment.getGoodsEntities();
        for (String entity : goodsEntities) {
            registerEntityProvider(entity);
        }
        
     
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn("name");
	bindColumn("goodsTypeName");
	bindColumn("unitName");
	bindColumn("currencyName");
	bindColumn("currencyCostPrice", getCurrencyFormat());
	bindColumn("currencyListPrice", getCurrencyFormat());
	bindColumn("productGroupName");
	
	bindColumn("availableQuantity", getQuantityFormat());
	bindColumn("reservedQuantity", getQuantityFormat());
	bindColumn("expectedQuantity", getQuantityFormat());
	
	bindColumn("responsibleName");
    }
 
    ////
    
    public Tree getTree() {
	return tree;
    }
    
   

    ////
    
    protected Object getEntityProviderView(Object key) {
	return EntityEnvironment.getEntityById((String) key);
    }
    
    protected Object getEntityProviderKey(Object view) {
	return getEntityConfigId(view);
    }   

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
