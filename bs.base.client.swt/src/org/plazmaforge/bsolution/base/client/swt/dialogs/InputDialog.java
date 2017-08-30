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

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.List;


import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.config.object.IInterfaceConfig;


/** 
 * @author Oleh Hapon
 * $Id: InputDialog.java,v 1.4 2010/06/18 12:30:06 ohapon Exp $
 */

public class InputDialog extends TitleAreaDialog {

    
    private SessionContext context;
    
    private List<OrganizationHeader> organizations;
    
    private List<IInterfaceConfig> userIterfaces;
    
    private boolean isAvailableOrganizations;
    
    private boolean isAvailableUserInterfaces;
    
    
    private Combo combo;
    
    private Table table;
    
    
    private boolean organizationsMode = true;
    
    private boolean userInterfacesMode = true;
    
    
    private boolean modify;
    
    private boolean selected;
    
    public InputDialog(Shell parentShell) {
	super(parentShell);
    }

    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("InputDialog.title")); //$NON-NLS-1$
    }
    
    protected Control createDialogArea(Composite parent) {
	
	Composite parentComposite = (Composite) super.createDialogArea(parent);
	
        Composite composite = new Composite(parentComposite, SWT.BORDER);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
        
        GridLayout layout = new GridLayout();
        composite.setLayout(layout);
        
        loadData();
        
        if (isAvailableOrganizations) {
            createOrganizationsControl(composite);
        }

        if (isAvailableUserInterfaces) {
            createUserInterfacesControl(composite);
        }
        
        composite.pack();
        //parent.layout();
        
        return composite;
    }
    
    protected void loadData() {
	resetData();
	
	context = SessionEnvironment.getContext();
	if (isOrganizationsMode()) {
	    isAvailableOrganizations = EnterpriseEnvironment.isAvailableOrganizations(context);
	    organizations = context.getAvailableOrganizations();
	}
	if (isUserInterfacesMode()) {
	    isAvailableUserInterfaces = EnterpriseEnvironment.isAvailableUserInterfaces(context);
	    userIterfaces = context.getAvailableUserInterfaces();
	}
    }
    
    protected void resetData() {
	modify = false;
	
	context = null;
	isAvailableOrganizations = false;
	isAvailableUserInterfaces = false;
	
	organizations = null;
	userIterfaces = null;
    }

    /*
    protected Point getInitialSize() {
	Point size = super.getInitialSize();
	size.x = 300;
	return size;
	//return new Point(300, 230);
    }
    */
    
    
    protected Point getInitialSize() {
        Point shellSize = getShell().computeSize(-1, -1, true); //super.getInitialSize();
        return new Point(Math.max(convertHorizontalDLUsToPixels(200), shellSize.x), Math.max(convertVerticalDLUsToPixels(200), shellSize.y));
    }
    

    
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    protected void  createOrganizationsControl(Composite parent) {
	if (!isAvailableUserInterfaces) {
	    new Label(parent, SWT.NONE);
	}
	Label label = new Label(parent, SWT.NONE);
	label.setText(Messages.getString("InputDialog.organizationsLabel.text")); //$NON-NLS-1$
	combo = new Combo(parent, SWT.READ_ONLY);
	combo.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
	for (int i= 0 ; i < organizations.size(); i++) {
	    combo.add(organizations.get(i).toString());
	}
	combo.select(0);
	if (!isAvailableUserInterfaces) {
	    new Label(parent, SWT.NONE);
	}
    }
    
    protected void  createUserInterfacesControl(Composite parent) {
	if (isAvailableOrganizations) {
	    new Label(parent, SWT.NONE);
	}
	Label label = new Label(parent, SWT.NONE);
	label.setText(Messages.getString("InputDialog.interfacesLabel.text")); //$NON-NLS-1$
	table = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
	//table.setHeaderVisible(true);
	
	final TableColumn nameColumn = new TableColumn(table, SWT.NONE);
	nameColumn.setWidth(200);
	nameColumn.setResizable(false);
	GridData gridData = new GridData(SWT.FILL, SWT.NONE, true, false);
	table.setLayoutData(gridData);
	for (int i= 0 ; i < userIterfaces.size(); i++) {
	    TableItem item = new TableItem(table, SWT.NONE);
	    String name = userIterfaces.get(i).getCaption(); 
	    item.setText(name == null ? "<Empty>" : name);
	}
	table.setSelection(0);
	table.addListener(SWT.Resize, new Listener() {
	    public void handleEvent (Event event) {
		int width = table.getClientArea().width;
		nameColumn.setWidth(width);
	    }
	});
	
	table.addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		okPressed();
	    }
	});
	
	if (userIterfaces.size() <= 3) {
	    gridData.heightHint = 100;
	}
    }
  
    
    public boolean isSelected() {
	return selected;
    }
    
    
    protected void okPressed() {
	
	selected = true;
	
	if (context == null) {
	    return;
	}
	if (isAvailableOrganizations && combo != null) {
	    int index = combo.getSelectionIndex();
	    if (index > -1) {
		
		// Set selected Organization
		OrganizationHeader org = organizations.get(index);
		Integer newOrgId = org.getId();
		if (newOrgId != null) {
		    Integer oldOrgId = context.getOrganizationId();
		    if (oldOrgId == null || newOrgId.intValue() != oldOrgId.intValue()) {
			context.setOrganization(org);
			modify = true;
		    }
		}
	    }
	}
	
	if (isAvailableUserInterfaces && table != null) {
	    int index = table.getSelectionIndex();
	    if (index > -1) {
		
		// Set selected UI
		IInterfaceConfig ui = userIterfaces.get(index);
		context.setUserInterface(ui);
		AppEnvironment.setUserInterface(context.getUserInterface().getName());
		
	    }
	}
	
	super.okPressed();
    }

    public boolean isOrganizationsMode() {
        return organizationsMode;
    }

    public void setOrganizationsMode(boolean organizationsMode) {
        this.organizationsMode = organizationsMode;
    }

    public boolean isUserInterfacesMode() {
        return userInterfacesMode;
    }

    public void setUserInterfacesMode(boolean userInterfacesMode) {
        this.userInterfacesMode = userInterfacesMode;
    }

    public boolean isModify() {
        return modify;
    }
    
    
}
