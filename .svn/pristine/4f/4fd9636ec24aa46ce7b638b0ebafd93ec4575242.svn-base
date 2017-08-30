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
 * Created on 21.09.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.IAttributeHolder;


/** 
 * @author Oleh Hapon
 * $Id: AttributeView.java,v 1.7 2010/12/05 07:57:20 ohapon Exp $
 */

public class AttributeView {
    
    private Composite parent;
    
    private TabFolder tabFolder;
    
    private Table attributeTable;
    
    private Class viewClass;
    
    private TableEntityProvider entityProvider;
    
    public AttributeView(Composite parent, Class viewClass) {
	this.parent = parent;
	this.viewClass = viewClass;
	
	if (parent instanceof TabFolder) {
	    this.tabFolder = (TabFolder) parent;
	}
	
	TabItem attributeTabItem = new TabItem(tabFolder, SWT.NONE);
	attributeTabItem.setText(Messages.getString("AttributeView.title")); //$NON-NLS-1$

	attributeTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
	attributeTable.setLinesVisible(true);
	attributeTable.setHeaderVisible(true);
	attributeTabItem.setControl(attributeTable);

	TableColumn attrColumn = new TableColumn(attributeTable, SWT.NONE);
	attrColumn.setWidth(20);
	attrColumn.setResizable(false);

	TableColumn nameColumn = new TableColumn(attributeTable, SWT.NONE);
	nameColumn.setWidth(200);
	nameColumn.setText(Messages.getString("AttributeView.name")); //$NON-NLS-1$

	TableColumn typeColumn = new TableColumn(attributeTable, SWT.NONE);
	typeColumn.setWidth(200);
	typeColumn.setText(Messages.getString("AttributeView.type")); //$NON-NLS-1$
    }

    
    
    protected class AttributeEntityProvider extends TableEntityProvider {
	
	public AttributeEntityProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("attributes");
	    //setAddMethod("addAttribute");
	    
	    setEntityClass(Attribute.class); // FORM ID
	    setEntityFormClass(AttributeEditForm.class);
	}
	
	protected void addEntityToModel(Object entity) throws ApplicationException {
	    addEntityToList(entity);
	}
	
	protected Table getTable() {
	    return attributeTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "name");
	    bindColumn(2, "dataTypeName");
	}
    }
    
    protected Shell getShell(IForm formHolder) {
	return ((Control) formHolder).getShell();
    }
    
    
    protected IAttributeHolder getAttributeHolder(IForm formHolder) {
	return (IAttributeHolder) formHolder.getEntity();
    }




    public Class getViewClass() {
        return viewClass;
    }

    public void setViewClass(Class viewClass) {
        this.viewClass = viewClass;
    }

    public TableEntityProvider getEntityProvider() {
        if (entityProvider == null) {
            entityProvider = new AttributeEntityProvider();
        }
        return entityProvider;
    }

    public void setEntityProvider(TableEntityProvider entityProvider) {
        this.entityProvider = entityProvider;
    }    


}
