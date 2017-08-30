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
 * Created on 19.08.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;

import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.common.services.AttributeValueService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.ext.model.Attribute;
import org.plazmaforge.framework.ext.model.AttributeValue;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.IEntityObject;
import org.plazmaforge.framework.ext.service.ServiceFactory;

/** 
 * @author Oleh Hapon
 * $Id: AttributeValueView.java,v 1.6 2010/12/05 07:57:20 ohapon Exp $
 */

public class AttributeValueView {

    private Composite parent;
    
    private TabFolder tabFolder;
    
    private Table attributeTable;
    
    private Class viewClass;
    
    private TableEntityProvider entityProvider;
    
    public AttributeValueView(Composite parent, Class viewClass) {
	this.parent = parent;
	this.viewClass = viewClass;
	
	if (parent instanceof TabFolder) {
	    this.tabFolder = (TabFolder) parent;
	}
	
	TabItem attributeTabItem = new TabItem(tabFolder, SWT.NONE);
	attributeTabItem.setText(Messages.getString("AttributeValueView.attributes")); //$NON-NLS-1$

	attributeTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
	attributeTable.setLinesVisible(true);
	attributeTable.setHeaderVisible(true);
	attributeTabItem.setControl(attributeTable);

	TableColumn attrColumn = new TableColumn(attributeTable, SWT.NONE);
	attrColumn.setWidth(20);
	attrColumn.setResizable(false);

	TableColumn attributeColumn = new TableColumn(attributeTable, SWT.NONE);
	attributeColumn.setWidth(200);
	attributeColumn.setText(Messages.getString("AttributeValueView.attribute")); //$NON-NLS-1$

	TableColumn valueColumn = new TableColumn(attributeTable, SWT.NONE);
	valueColumn.setWidth(200);
	valueColumn.setText(Messages.getString("AttributeValueView.value")); //$NON-NLS-1$
    }

    
    
    protected class AttributeEntityProvider extends TableEntityProvider {
	
	public AttributeEntityProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("attributes");
	    setAddMethod("addAttribute");
	    
	    setEntityClass(AttributeValue.class); // FORM ID
	    setEntityFormClass(AttributeValueEditForm.class);
	    setEntityServiceClass(AttributeValueService.class);
	}
	
	protected Table getTable() {
	    return attributeTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "name");
	    bindColumn(2, "stringDisplayValue");
	}
	
	
	public IEditForm getEditForm() {
	    if (isAddMode()) {
		Object parentEntity = getParentEntity();
		boolean isCreated = false;
		if (parentEntity != null && parentEntity instanceof IEntityObject) {
		    IEntityObject entityBean = (IEntityObject) parentEntity; 
		    isCreated = entityBean.isCreated() || entityBean.getId() == null;
		}
		Attribute attribute = getAttribute(getFormHolder(), isCreated);
		if (attribute == null) {
		    return null;
		}
		if (attribute.getId() == null) {
		    attribute = null;
		}
		IEditForm editForm = super.getEditForm();
		if (editForm == null) {
		    return null;
		}
		((AttributeValueEditForm) editForm).setAttribute(attribute);
		return editForm;
	    } else {
		return super.getEditForm();
	    }
	}
	
    }
    
    protected Shell getShell(IForm formHolder) {
	return ((Control) formHolder).getShell();
    }
    
    /**
     * Returns <code>IAttributeHolder</code>
     * @return
     */
    protected IAttributeHolder getAttributeHolder(IForm formHolder) {
	return (IAttributeHolder) formHolder.getEntity();
    }

    /**
     * Returns declared <code>Attribute</code> of this class
     * @return
     */
    protected Attribute getAttribute(IForm formHolder, boolean isCreated) {

	IAttributeHolder holder = getAttributeHolder(formHolder);
	if (holder == null) {
	    return null;
	}
	
	if (isCreated) {
	    try {
		AttributeValueService serv = (AttributeValueService) ServiceFactory.getService(AttributeValueService.class);
		holder.setDeclareAttributes(serv.findAttributesByEntity(holder.getAttributeEntity()));
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
	
	List<Attribute> unusedAttributes = holder.getUnusedAttributes();
	if (unusedAttributes == null || unusedAttributes.size() == 0){
	    return new Attribute();
	}
	
	ChooseDialog dialog = new ChooseDialog(getShell(formHolder));
	Attribute newAttribute = new Attribute();
	newAttribute.setName(Messages.getString("AttributeValueView.new")); //$NON-NLS-1$
	unusedAttributes.add(newAttribute);
        dialog.setList(unusedAttributes);
        dialog.open();
	Object selectedItem = dialog.getSelectedItem();
	return (Attribute) selectedItem;
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
