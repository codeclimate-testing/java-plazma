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
 * Created on 13.06.2007
 *
 */

package org.plazmaforge.bsolution.product.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.client.swt.views.TableViewFactory;

/** 
 * @author Oleh Hapon
 * $Id: ProductGroupListForm.java,v 1.4 2010/10/31 08:45:54 ohapon Exp $
 */

public class ProductGroupListForm extends AbstractListForm {

    private Tree tree;
    

    
    public ProductGroupListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("ProductGroupListForm.title")); //$NON-NLS-1$
        TreeColumn column;
        TreeColumn codeColumn;
        TreeColumn nameColumn;
  
        setLayout(new FillLayout());
 

    	tree = new Tree(this, SWTToolkit.TABLE_STYLE);
    	tree.setLinesVisible(true);
    	tree.setHeaderVisible(true);

    	column = new TreeColumn(tree, SWT.NONE);
    	column.setResizable(false);
    	column.setWidth(20);

    	codeColumn = new TreeColumn(tree, SWT.NONE);
    	tree.setSortColumn(codeColumn);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("ProductGroupListForm.codeColumn.text")); //$NON-NLS-1$
    	
 	nameColumn = new TreeColumn(tree, SWT.NONE);
    	tree.setSortColumn(codeColumn);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("ProductGroupListForm.nameColumn.text")); //$NON-NLS-1$
    	
 
        this.setSize(new Point(600, 300));
    }
    
    public Tree getTable() {
	return tree;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");
	bindColumn(2, "name");
    }
 
    protected String getViewType() {
	return TableViewFactory.TREE_VIEW;
    }

 
}  //  @jve:decl-index=0:visual-constraint="10,10"



