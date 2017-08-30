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

import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.forms.DefaultEntityProvider;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.data.ICustomEntityType;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: CustomEntityListForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class CustomEntityListForm extends AbstractListForm {

    private Table table;
    

    
    public CustomEntityListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	getModel().setEntityClass(EntityConfig.class);
        getModel().setEntityServiceClass(SystemEntityService.class);
        
        setSupportAddMode(true);
        setSupportEditMode(true);
        setSupportDelMode(true);
        
	setTitle(Messages.getString("CustomEntityListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn typeColumn;
        TableColumn packageColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(150);
    	codeColumn.setText(Messages.getString("CustomEntityListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("CustomEntityListForm.nameColumn.text")); //$NON-NLS-1$
    	
   	typeColumn = new TableColumn(table, SWT.NONE);
    	typeColumn.setWidth(300);
    	typeColumn.setText(Messages.getString("CustomEntityListForm.typeColumn.text")); //$NON-NLS-1$

   	packageColumn = new TableColumn(table, SWT.NONE);
    	packageColumn.setWidth(300);
    	packageColumn.setText(Messages.getString("CustomEntityListForm.packageColumn.text")); //$NON-NLS-1$

        this.setSize(new Point(600, 300));
        
        registerEntityProvider(ICustomEntityType.CUSTOM_ATTRIBUTE, new CustomEntityProvider(ICustomEntityType.CUSTOM_ATTRIBUTE));
        registerEntityProvider(ICustomEntityType.ENUMERATION, new CustomEntityProvider(ICustomEntityType.ENUMERATION));
        registerEntityProvider(ICustomEntityType.LOOKUP, new CustomEntityProvider(ICustomEntityType.LOOKUP));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn(2, "name");
	bindColumn(3, "entityTypeName");
	bindColumn(4, "entityPackage");
    }
 
    public List loadDataList() throws ApplicationException {
	return ((SystemEntityService) getEntityService()).findByCustomize();
    }

    
    public List loadDataList(Criteria criteria) throws ApplicationException {
	return ((SystemEntityService) getEntityService()).findByCustomize(criteria);
    }
 
    protected Object getSelectedEntityConfigurableProviderKey() {
	if (!hasEntityProviders()) {
	    return null;
	}
	Object entity = getSelectedEntity();
	if (entity == null) {
	    return null;
	}
	IEntityConfig entityConfig = ((IEntityConfig) entity);
	if (isCustom(entityConfig)) {
	    return entityConfig.getEntityType().getCode();
	}
	if (isCustomAttribute(entityConfig)) {
	    return ICustomEntityType.CUSTOM_ATTRIBUTE;
	}
	return null;
    }
    
    protected boolean isCustom(IEntityConfig entity) {
	if (entity == null) {
	    return false;
	}
	if (entity.isCustom()) {
	    return true;
	}
	String ID = entity.getConfigId();
	return (ICustomEntityType.ENUMERATION.equals(ID) || ICustomEntityType.LOOKUP.equals(ID));
    }
    
    protected boolean isCustomAttribute(IEntityConfig entity) {
	if (entity == null) {
	    return false;
	}
	return entity.isCustomAttribute();
    }

    
    private class CustomEntityProvider extends DefaultEntityProvider {

	public CustomEntityProvider() {
	    super();
	}

	public CustomEntityProvider(String code) {
	    this(code, CustomEntityEditForm.class);
	}

	public CustomEntityProvider(String code, Class formClass) {
	    super();
	    setEntityCode(code);
	    setEntityFormClass(formClass);
	    setEntityServiceClass(getModel().getEntityServiceClass());
	}
	
	
    }
    
    protected boolean isAssignEntityProviderKey(Object key) {
	return !ICustomEntityType.CUSTOM_ATTRIBUTE.equals(key);
    }
    
    protected boolean isSupportEntityDelMode(Object entity) {
	if (entity == null) {
	    return true;
	}
	return ((IEntityConfig) entity).isCustom();
    }

    
}  //  @jve:decl-index=0:visual-constraint="10,10"

