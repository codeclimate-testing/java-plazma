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



package org.plazmaforge.bsolution.base.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.common.services.FileService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.ext.model.File;
import org.plazmaforge.framework.ext.model.IEntityObject;
import org.plazmaforge.framework.ext.model.IFileHolder;

/** 
 * @author Oleh Hapon
 * $Id: FileView.java,v 1.3 2010/12/05 07:57:20 ohapon Exp $
 */

public class FileView {

    private Composite parent;
    
    private TabFolder tabFolder;
    
    private Table fileTable;
    
    private Class viewClass;
    
    private TableEntityProvider entityProvider;
    
    public FileView(Composite parent, Class viewClass) {
	this.parent = parent;
	this.viewClass = viewClass;
	
	if (parent instanceof TabFolder) {
	    this.tabFolder = (TabFolder) parent;
	}
	
	TabItem fileTabItem = new TabItem(tabFolder, SWT.NONE);
	fileTabItem.setText(Messages.getString("FileView.files")); //$NON-NLS-1$

	fileTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
	fileTable.setLinesVisible(true);
	fileTable.setHeaderVisible(true);
	fileTabItem.setControl(fileTable);

	TableColumn attrColumn = new TableColumn(fileTable, SWT.NONE);
	attrColumn.setWidth(20);
	attrColumn.setResizable(false);

	TableColumn fileNameColumn = new TableColumn(fileTable, SWT.NONE);
	fileNameColumn.setWidth(200);
	fileNameColumn.setText(Messages.getString("FileView.fileName")); //$NON-NLS-1$

	TableColumn nameColumn = new TableColumn(fileTable, SWT.NONE);
	nameColumn.setWidth(200);
	nameColumn.setText(Messages.getString("FileView.name")); //$NON-NLS-1$
    }

    
    
    protected class FileEntityProvider extends TableEntityProvider {
	
	public FileEntityProvider() {
	    setParentEntityClass(getViewClass()); // OWNER
	    setListProperty("files");
	    setAddMethod("addFile");
	    
	    setEntityClass(File.class); // FORM ID
	    setEntityFormClass(FileEditForm.class);
	    setEntityServiceClass(FileService.class);
	}
	
	protected Table getTable() {
	    return fileTable;
	}
	
	protected void bindTable() {
	    bindColumn(1, "fileName");
	    bindColumn(2, "name");
	}
	
	
	public IEditForm getEditForm() {
	    if (isAddMode()) {
		Object parentEntity = getParentEntity();
		boolean isCreated = false;
		
		if (parentEntity != null && parentEntity instanceof IEntityObject) {
		    IEntityObject entityBean = (IEntityObject) parentEntity; 
		    isCreated = entityBean.isCreated() || entityBean.getId() == null;
		}
		
		
		/*
		AttributeType attributeType = getAttributeType(getFormHolder(), isCreated);
		if (attributeType == null) {
		    return null;
		}
		if (attributeType.getId() == null) {
		    attributeType = null;
		}
		*/
		
		
		
		IEditForm editForm = super.getEditForm();
		if (editForm == null) {
		    return null;
		}
		
		
		//((AttributeEdit) editForm).setAttributeType(attributeType);
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
     * Returns <code>IFileHolder</code>
     * @return
     */
    protected IFileHolder getFileHolder(IForm formHolder) {
	return (IFileHolder) formHolder.getEntity();
    }

   



    public Class getViewClass() {
        return viewClass;
    }

    public void setViewClass(Class viewClass) {
        this.viewClass = viewClass;
    }

    public TableEntityProvider getEntityProvider() {
        if (entityProvider == null) {
            entityProvider = new FileEntityProvider();
        }
        return entityProvider;
    }

    public void setEntityProvider(TableEntityProvider entityProvider) {
        this.entityProvider = entityProvider;
    }    

}
