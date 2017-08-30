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

package org.plazmaforge.framework.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.util.SystemInfo;


/** 
 * @author Oleh Hapon
 * $Id: ItemToolBar.java,v 1.3 2010/06/24 12:57:59 ohapon Exp $
 *
 */

public class ItemToolBar extends Composite implements IFormConstants {

    public static final Image ADD_ITEM_IMAGE = AbstractFormDecorator.ADD_ITEM_IMAGE;
    
    public static final Image EDIT_ITEM_IMAGE = AbstractFormDecorator.EDIT_ITEM_IMAGE;
    
    public static final Image COPY_ITEM_IMAGE = AbstractFormDecorator.COPY_ITEM_IMAGE;
    
    public static final Image DELETE_ITEM_IMAGE = AbstractFormDecorator.DELETE_ITEM_IMAGE;
    
    
    private CoolBar coolBar;
    
    private IForm form;
    
    private int toolStyle;
    
    public ItemToolBar(Composite parent) {
	this(parent, SWT.NONE);
    }
    
    public ItemToolBar(Composite parent, int style) {
	this(parent, style, PWT.ADD_BUTTON | PWT.EDIT_BUTTON | PWT.DELETE_BUTTON);
    }
    
    public ItemToolBar(Composite parent, int style, int toolStyle) {
	
	super(parent, style);
	
	this.toolStyle = toolStyle;
	
	initParent(parent);
	
	setLayout(new FillLayout());
    	setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	coolBar = new CoolBar(this, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);


	CoolItem newItemCoolItem = new CoolItem(coolBar, SWT.NONE);

	ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT);
	newItemCoolItem.setControl(toolBar);

	populateToolBar(toolBar);

	Point size = toolBar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	newItemCoolItem.setSize(newItemCoolItem.computeSize(size.x, size.y));
	
	
    }
    
    
    protected void populateToolBar(ToolBar toolBar) {
	
	ToolItem editToolItem;
	ToolItem delToolItem;

	ToolItem addToolItem = new ToolItem(toolBar, SWT.PUSH);
	addToolItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_ADD_ACTION);
		}
	});
	addToolItem.setSelection(true);
	addToolItem.setImage(ADD_ITEM_IMAGE);
	
	addToolItem.setToolTipText(Messages.getString("ItemToolBar.add")); //$NON-NLS-1$

	////
	
	editToolItem = new ToolItem(toolBar, SWT.PUSH);
	editToolItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_EDIT_ACTION);
		}
	});
	editToolItem.setImage(EDIT_ITEM_IMAGE);
	editToolItem.setToolTipText(Messages.getString("ItemToolBar.edit")); //$NON-NLS-1$

	// todo: copy action
	
	
	delToolItem = new ToolItem(toolBar, SWT.PUSH);
	delToolItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_DEL_ACTION);
		}
	});
	delToolItem.setImage(DELETE_ITEM_IMAGE);
	delToolItem.setToolTipText(Messages.getString("ItemToolBar.delete")); //$NON-NLS-1$
	

	
	
	if (!isAddMode()){
	    addToolItem.setEnabled(false);
	}

	if (!isEditMode()){
	    editToolItem.setEnabled(false);
	}

	if (!isDeleteMode()){
	    delToolItem.setEnabled(false);
	}
	
    }

    protected void doAction(String action) {
	if (form == null) {
	    return;
	}
	form.doAction(action);
    }
    
    public IForm getForm() {
        return form;
    }

    public void setForm(IForm form) {
	if (this.form != null) {
	    ((AbstractForm) form).setItemToolBar(null);
	}
        this.form = form;
        ((AbstractForm) form).setItemToolBar(this);
    }
    
    private void initParent(Composite parent) {
	if (parent instanceof IForm) {
	    setForm((IForm) parent);
	}
    }
    
      
    public void initTable(Table table) {
	if (table == null) {
	    return;
	}
	Menu menu = table.getMenu();
	if (menu != null) {
	    return;
	}
	menu = createPopupMenu(table);
	table.setMenu(menu);
    }
    
    
    protected Menu createPopupMenu(Control parent) {
	Menu menu = new Menu(parent);
	MenuItem addMenuItem = new MenuItem(menu, SWT.CASCADE);
    	addMenuItem.setImage(ADD_ITEM_IMAGE);
    	addMenuItem.setText(Messages.getString("ItemToolBar.add")); //$NON-NLS-1$
    	addMenuItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_ADD_ACTION);
		}
	});
    	
    	
    	MenuItem editMenuItem = new MenuItem(menu, SWT.CASCADE);
    	editMenuItem.setImage(EDIT_ITEM_IMAGE);
    	editMenuItem.setText(Messages.getString("ItemToolBar.edit")); //$NON-NLS-1$
    	editMenuItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_EDIT_ACTION);
		}
	});
    	
    	//todo: copy action
    	
    	MenuItem delMenuItem = new MenuItem(menu, SWT.CASCADE);
    	delMenuItem.setImage(DELETE_ITEM_IMAGE);
    	delMenuItem.setText(Messages.getString("ItemToolBar.delete")); //$NON-NLS-1$
    	delMenuItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doAction(ITEM_DEL_ACTION);
		}
	});
    	
    	
    	if (!isAddMode()){
	    addMenuItem.setEnabled(false);
	}

	if (!isEditMode()){
	    editMenuItem.setEnabled(false);
	}

	if (!isDeleteMode()){
	    delMenuItem.setEnabled(false);
	}
  
	return menu;
    }
    
    protected boolean isAddMode() {
	return (getToolStyle() & PWT.ADD_BUTTON) != 0;
    }

    protected boolean isEditMode() {
	return (getToolStyle() & PWT.EDIT_BUTTON) != 0;
    }

    protected boolean isDeleteMode() {
	return (getToolStyle() & PWT.DELETE_BUTTON) != 0;
    }

    protected Image getImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }

    public int getToolStyle() {
        return toolStyle;
    }
    
    
    
    

}
