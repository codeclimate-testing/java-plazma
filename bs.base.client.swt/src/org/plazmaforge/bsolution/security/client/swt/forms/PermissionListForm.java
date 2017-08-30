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
 * Created on 13.07.2007
 *
 */

package org.plazmaforge.bsolution.security.client.swt.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.bsolution.security.common.services.PermissionService;
import org.plazmaforge.bsolution.security.common.services.PermissionViewService;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.client.swt.views.ImageTableCellRenderer;
import org.plazmaforge.framework.core.criteria.IDisableCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.Dictionary;
import org.plazmaforge.framework.ext.model.EntityObject;

/** 
 * @author Oleh Hapon
 * $Id: PermissionListForm.java,v 1.11 2010/12/05 07:57:22 ohapon Exp $
 */

public class PermissionListForm extends AbstractListForm implements IDisableCriteriaImplementator {
    
    private Tree tree;
    
    private Table table;
    
    
    private Role role;

    
    public PermissionListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	
	setTitle(Messages.getString("PermissionListForm.title")); //$NON-NLS-1$
	setDisablePagingMode();
	
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn objectIdColumn;
        TableColumn objectTypeColumn;
        TableColumn readColumn;        
        TableColumn writeColumn;
        TableColumn executeColumn;

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

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("PermissionListForm.nameColumn.text")); //$NON-NLS-1$

    	
    	objectIdColumn = new TableColumn(table, SWT.NONE);
    	objectIdColumn.setMoveable(true);
    	objectIdColumn.setWidth(200);
    	objectIdColumn.setText(Messages.getString("PermissionListForm.idColumn.text")); //$NON-NLS-1$
    	
    	objectTypeColumn = new TableColumn(table, SWT.NONE);
    	objectTypeColumn.setMoveable(true);
    	objectTypeColumn.setWidth(100);
    	objectTypeColumn.setText(Messages.getString("PermissionListForm.objectTypeColumn.text")); //$NON-NLS-1$
    	
   	readColumn = new TableColumn(table, SWT.NONE);
   	readColumn.setMoveable(true);
    	readColumn.setWidth(70);
    	readColumn.setText(Messages.getString("PermissionListForm.readColumn.text")); //$NON-NLS-1$

    	writeColumn = new TableColumn(table, SWT.NONE);
    	writeColumn.setMoveable(true);
    	writeColumn.setWidth(70);
    	writeColumn.setText(Messages.getString("PermissionListForm.writeColumn.text")); //$NON-NLS-1$

    	executeColumn = new TableColumn(table, SWT.NONE);
    	executeColumn.setMoveable(true);
    	executeColumn.setWidth(70);
    	executeColumn.setText(Messages.getString("PermissionListForm.executeColumn.text")); //$NON-NLS-1$

        this.setSize(new Point(800, 600));
        
        setSupportOnlyEditMode();
        
        setEntityClass(PermissionView.class);
	setEntityServiceClass(PermissionViewService.class);
	setEntityEditFormClass(PermissionEditForm.class);
	
	
	// TREE: object type
	setTreeEntityClass(Dictionary.class);
	setTreeItemRefIdProperty("objectType");
	
	sashForm.setWeights(new int[] {1, 5 });
    }
    
    
    public Tree getTree() {
	return tree;
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");
	bindColumn(2, "objectId");	
	bindColumn(3, "objectType");
	bindColumn(4, "read");
	bindColumn(5, "write");
	bindColumn(6, "exec");
	
	addCellRenderer(7, new ImageTableCellRenderer());
        addCellRenderer(8, new ImageTableCellRenderer());
        addCellRenderer(9, new ImageTableCellRenderer());
    }
 
    private PermissionViewService getPermissionViewService() {
	return (PermissionViewService) getEntityService();
    }

      
    protected List loadDataList() throws ApplicationException {
	Integer roleId = getRoleId();
	if (roleId == null) {
	    throw new ApplicationException("Role is null");
	}
	return getPermissionViewService().findByRole(roleId);
    }
    
    
    protected List loadTreeList() throws ApplicationException {
	List<ObjectType> types = new ArrayList<ObjectType>();
	types.add(new ObjectType("ENTITY", Messages.getString("PermissionListForm.entities")));
	types.add(new ObjectType("ACTION", Messages.getString("PermissionListForm.actions")));
	types.add(new ObjectType("REPORT", Messages.getString("PermissionListForm.reports")));
	return types;
    }
    
    protected String getTreeRootName() {
	return Messages.getString("PermissionListForm.objectTypes");
    }
    
    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    public Integer getRoleId() {
	return role == null ? null : role.getId();
    }
    protected void initTableProvider(ITableProvider tableProvider) {
	super.initTableProvider(tableProvider);
	tableProvider.setBooleanImage(getImage("/org/plazmaforge/framework/resources/images/olmari/Permission.gif"));
    }
    
    private PermissionView getPermissionView() {
	return (PermissionView) getSelectedEntity();
    }
    
    protected void initEditForm(IEditForm form ) throws ApplicationException {
	super.initEditForm(form);
	if (form == null) {
	    return;
	}
	Role role = getRole();
	if (role == null) {
	    throw new ApplicationException("Role is null");
	}
	PermissionEditForm editForm = (PermissionEditForm) form;
	PermissionView permissionView = getPermissionView();
	SecureObject secureObject = permissionView.createSecureObject();

	editForm.setRole(role);
	editForm.setPermissionView(permissionView);
	editForm.setSecureObject(secureObject);
	
    }
    
    
    protected void afterClose() throws ApplicationException {
	if (isModify()) {
	    openMessageDialog("Message", Messages.getString("PermissionListForm.permissionsModified"));
	    PermissionService service = (PermissionService) getService(PermissionService.class);
	    service.loadContext();
	}
    }
    
    // Override
    protected Object loadEntityById(Serializable id) throws ApplicationException {
	return getPermissionViewService().findByRoleAndId(getRoleId(),	(Integer) id);
    }

    class ObjectType extends EntityObject<String> {
	
	

	public ObjectType() {
	    super();
	    // TODO Auto-generated constructor stub
	}

	public ObjectType(String id, String name) {
	    setId(id);
	    this.name = name;
	}
	
	private String name;

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}
	
	
	public String toString(){
	    return getName();
	}
	
    }
    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
