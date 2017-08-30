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

package org.plazmaforge.bsolution.security.client.swt.forms;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.beans.RoleInterface;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.dialogs.ChooseDialog;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.client.swt.forms.ItemToolBar;
import org.plazmaforge.framework.client.swt.forms.TableEntityProvider;
import org.plazmaforge.framework.config.InterfaceConfigManager;
import org.plazmaforge.framework.config.object.IInterfaceConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: RoleEditForm.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public class RoleEditForm extends AbstractEditForm {
    
    private Label nameLabel;
    
    private XTextField nameField;

    
    private Composite itemPanel;

    private Table roleInterfaceTable;
    
    private TabFolder tabFolder;    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public RoleEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	
	setTitle(Messages.getString("RoleEditForm.title")); //$NON-NLS-1$
	Composite composite;
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginWidth = 0;
	gridLayout.horizontalSpacing = 0;
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	setLayout(gridLayout);
    	
	composite = new Composite(this, SWT.NONE);
    	
    	gridLayout = new GridLayout();
    	gridLayout.marginTop = 10;
    	gridLayout.marginBottom = 10;
       	gridLayout.numColumns = 2;
    	composite.setLayout(gridLayout);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	composite.setLayoutData(gridData);
    	
       	nameLabel = new Label(composite, SWT.NONE);
	nameLabel.setText(Messages.getString("RoleEditForm.nameLabel.text")); //$NON-NLS-1$

    	nameField = new XTextField(composite, SWT.BORDER);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
    	gridData.widthHint = 350;
    	nameField.setLayoutData(gridData);
    	nameField.setTextLimit(50);
    	
    	ItemToolBar itemToolPanel = new ItemToolBar(this, SWT.NONE, PWT.ADD_BUTTON | PWT.DELETE_BUTTON);
    	itemToolPanel.setForm(this);
  
    	createItemPanel();
    	
    	this.setSize(new Point(470, 108));
    	
    	registerEntityProvider(tabFolder.getItem(0), new RoleInterfaceProvider());
    }
    
    protected void bindControls() {
	bindControl(nameField, "name", nameLabel, REQUIRED);
    }
    
    /**
     * This method initializes itemPanel	
     *
     */
    private void createItemPanel() {
        TableColumn newColumnTableColumn;
        GridLayout gridLayout;

        TabItem rolesTabItem;
               
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gridData.heightHint = 120;
        itemPanel = new Composite(this, SWT.NONE);
        gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 0;
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        gridLayout.horizontalSpacing = 0;
        itemPanel.setLayout(gridLayout);
        itemPanel.setLayoutData(gridData);
        

        
        tabFolder = new TabFolder(itemPanel, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        rolesTabItem = new TabItem(tabFolder, SWT.NONE);
        rolesTabItem.setText(Messages.getString("RoleEditForm.roleUITabItem.text")); //$NON-NLS-1$

         
        //rolesTable = new Table(itemPanel, SWTToolkit.TABLE_STYLE);
        roleInterfaceTable = new Table(tabFolder, SWT.MULTI | SWT.FULL_SELECTION);
        roleInterfaceTable.setHeaderVisible(true);
        roleInterfaceTable.setLinesVisible(true);
        rolesTabItem.setControl(roleInterfaceTable);
        
        //rolesTable.setLayoutData(gridData2);

        newColumnTableColumn = new TableColumn(roleInterfaceTable, SWT.NONE);
        newColumnTableColumn.setWidth(300);
        newColumnTableColumn.setText(Messages.getString("RoleEditForm.nameTableColumn.text")); //$NON-NLS-1$

        
    }

    private List<IInterfaceConfig> interfaces;
    
    private List<IInterfaceConfig> getInterfaces() {
	if (interfaces == null) {
	    interfaces = InterfaceConfigManager.getInterfaces();
	    if (interfaces == null) {
		interfaces = new ArrayList<IInterfaceConfig>();
	    }
	}
	return interfaces;
    }
    
    private Role getRole() {
	return (Role) getEntity();
    }
    
    
    public void doItemAddAction()  throws ApplicationException {
	List<IInterfaceConfig> uis = getInterfaces();
	if (uis == null || uis.isEmpty()) {
	    openMessageDialog(Messages.getString("RoleEditForm.userInterfacesNotFound"));
	    return;
	}
	ChooseDialog dialog = new ChooseDialog(getShell());
	dialog.setItemLabelProperty("name");
        dialog.setList(uis);
        dialog.open();
	Object selectedItem = dialog.getSelectedItem();
	if (selectedItem == null) {
	    return;
	}
	IInterfaceConfig ui = (IInterfaceConfig) selectedItem;
	
	if (getRole().isExistRoleInterface(ui.getId())) {
	    openMessageDialog(Messages.getString("RoleEditForm.duplicateInterface") + " [" + ui.getName() + "]");
	    return;
	}

	RoleInterface roleInterface = new RoleInterface();
	roleInterface.setInterfaceId(ui.getId());
	roleInterface.setInterfaceName(ui.getName());
	
	doUpdateItem(roleInterface, PWT.ADD_MODE);
    }
   
    
    public void doItemEditAction()  throws ApplicationException {
	
    }
    
    
    protected class RoleInterfaceProvider extends TableEntityProvider {
	
	public RoleInterfaceProvider() {
	    setParentEntityClass(Role.class);
	    setListProperty("roleInterfaces");
	    setAddMethod("addRoleInterface");
	    
	    setEntityClass(RoleInterface.class);
	}
	
	protected Table getTable() {
	    return roleInterfaceTable;
	}
	
	protected void bindTable() {
	    bindColumn(0, "interfaceName");
	    
	}
    }
    
    
    protected Object getSelectedEntityProviderKey() {
        int index = tabFolder.getSelectionIndex();
        return tabFolder.getItem(index);
    }    

    protected void validateControls(StringBuffer buf) throws ApplicationException {
	super.validateControls(buf);
	validateEmptyInterfaces(buf);
    }
    
    private void validateEmptyInterfaces(StringBuffer buf) {
	// disable: 2010-04-20
	//if (getRole().isEmptyRoleInterfaces()) {
	//    addError(buf, Messages.getString("RoleEditForm.noUserInterfaces"));
	//}
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"

