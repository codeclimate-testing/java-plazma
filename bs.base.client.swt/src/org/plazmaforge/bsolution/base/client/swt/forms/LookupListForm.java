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
 * Created on 25.09.2007
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
import org.plazmaforge.bsolution.base.common.services.LookupService;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 */

public class LookupListForm extends AbstractListForm {

    private Table table;
    

    private IEntityConfig entityConfig;
    
    
    public LookupListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("LookupListForm.title")); // Don't change this title //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("LookupListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("LookupListForm.nameColumn.text")); //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        
    }
    
    public void init() throws ApplicationException {
	super.init();
	IEntityConfig entity = getEntityConfig();
	if (entity != null && entity.getConfigName() != null) {
	    setTitle(entity.getConfigName());
	}
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn(2, "name");
    }
    
    protected String getEntityConfigCode() {
	return getArgument();
    }

    
    protected IEntityConfig getEntityConfig() throws ApplicationException {
	if (entityConfig == null) {
	    String id = getEntityConfigCode();
	    if (id != null) {
		entityConfig = ((SystemEntityService) getService(SystemEntityService.class)).findById(id);
	    }
	}
	return entityConfig;
    }

    protected List loadDataListForm() throws ApplicationException {
	IEntityConfig entity = getEntityConfig();
	if (entity == null) {
	    throw new ApplicationException("Lookup type is null");
	}
	return ((LookupService) getEntityService()).findByEntity(entity);
    }
    
    protected void initEditFormParent(IEditForm form) throws ApplicationException {
	super.initEditFormParent(form);
	if (form == null) {
	    return;
	}
	IEntityConfig entity = getEntityConfig();
	if (entity != null) {
	    form.setParentEntity(entity);
	}
    }
    
 
}  //  @jve:decl-index=0:visual-constraint="10,10"

