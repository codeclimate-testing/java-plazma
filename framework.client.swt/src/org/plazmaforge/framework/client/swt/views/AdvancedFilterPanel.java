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

package org.plazmaforge.framework.client.swt.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class AdvancedFilterPanel<T, C, R> extends SimpleFilterPanel<T, C, R> {

    
    private int gridColumnCount = 3;
    
    private int defaultLine = 5;
    
    private int maxLine = 10;
    
    private boolean isAutoChange = true;
    
    
    private List<ControlItem> columnItems;
    
    
    
    public AdvancedFilterPanel(FilterDialog<T, C, R> filterDialog, Composite parent) {
	super(filterDialog, parent);
    }
    
    public class ExtControlItem extends ControlItem {

	private CCombo columnControl;
	
	private boolean isValid;
	

	
	public ExtControlItem() {
	    super();
	}

	public ExtControlItem(Composite parent) {
	    createControls(parent);
	}
	

	
	public void remove() {
	    hideControls();
	    hide();
	}
	
	protected void createControls(Composite parent) {
	    //createOperatorControl(parent);
	    createColumnControl(parent);
	    createClauseControl(parent);
	    createTextControl(parent);
	}

	protected void createColumnControl(Composite parent) {
	    columnControl = createFilterColumnControl(parent, this);
	}
	
	public void prepare() {
	    super.prepare();
	    isValid = false;
	    if (columnControl == null || !columnControl.getEnabled() || !isEnabledEdit()) {
		return;
	    }
	    int index = columnControl.getSelectionIndex();
	    if (index < 1) {
		return;
	    }
	    init(--index);
	    isValid = true;
	}
	
	public String getValueString() {
	    if (isValid == false) {
		return null;
	    }
	    return super.getValueString();
	}
	
	public void setEnabledEdit(boolean enabled) {
	    if (clauseControl != null) clauseControl.setEnabled(enabled);
	    if (textControl != null) textControl.setEnabled(enabled);
	}

	public void setEnabled(boolean enabled) {
	    //if (operatorControl != null) operatorControl.setEnabled(enabled);
	    if (columnControl != null) columnControl.setEnabled(enabled);
	    setEnabledEdit(enabled);
	}
	
	
	public boolean isEnabled() {
	    return  (columnControl != null) && columnControl.isEnabled();
	}

	public boolean isEnabledEdit() {
	    return  (textControl != null) && textControl.isEnabled();
	}
	
	public boolean isUsable() {
	    return  isEnabledEdit() && isUsableColumn();
	}
	
	public boolean isUsableColumn() {
	    return columnControl!= null && columnControl.getSelectionIndex() > 0;
	}
	
	private Control[] getControls() {
	    Control[] controls = new Control[gridColumnCount];
	    controls[0] = columnControl;
	    controls[1] = clauseControl;
	    controls[2] = textControl;
	    return controls;
	}
	
	private void hideControls() {
	    Control[] controls = getControls();
	    if (controls == null) {
		return;
	    }
	    for (Control control : controls) {
		if (control == null) {
		    continue;
		}
		control.setVisible(false);
	    }
	}
    }
    
    protected void initColumnControl(CCombo columnControl) {
	
    }
    
    protected CCombo createFilterColumnControl(Composite parent, ExtControlItem data) {
	CCombo combo = new CCombo(parent, SWT.BORDER);
	
	List<ControlItem> items = getColumnItems();
	for (ControlItem item : items) {
	    combo.add(item.displayField); 
	}

	combo.select(0);
	combo.setData(data);

	combo.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		CCombo thisObject = (CCombo) e.widget;
		ExtControlItem controlItem = (ExtControlItem) thisObject.getData();
		Class oldValueClass = controlItem.valueClass; // (Class) thisObject.getData("valueClass");
		Class newValueClass = null;
		int index = thisObject.getSelectionIndex();
		List<ControlItem> items = null;
		if (index > -1) {
		    items = getColumnItems();
		    if (items != null) {
			ControlItem item = items.get(index);
			newValueClass = item.valueClass;
		    }
		}
		
		//thisObject.setData("valueClass", newValueClass);
		controlItem.valueClass = newValueClass;
		
		if (!equalsClass(oldValueClass, newValueClass)) {
		    populateClauseControl(controlItem.clauseControl, newValueClass, false);
		}
		boolean enabled = index > 0;
		controlItem.setEnabledEdit(enabled);
		handleControlItem(controlItem, enabled);
	    }
        });
	
	return combo;
    }
    
    protected boolean equalsClass(Class c1, Class c2) {
	if (c1 == null && c2 == null) {
	    return true;
	}
	if (c1 == null || c2 == null) {
	    return false;
	}
	return c1 == c2;
    }
    
    protected void handleControlItem(ExtControlItem controlItem, boolean enabled) {
	if (enabled) {
	    handleEnableControlItem(controlItem);
	} else {
	    handleDisableControlItem(controlItem);
	}
    }
    
    protected void handleEnableControlItem(ExtControlItem controlItem) {
	ExtControlItem next = getNextControlItem(controlItem);
	if (next == null) {
	    
	    // TRY ADD NEW LINE
	    if (!isAutoChange) {
		return;
	    }
	    int currLineNumber = getLineNumber(controlItem);
	    int nextLineNumber = currLineNumber + 1;
	    if (nextLineNumber > maxLine - 1) {
		return;
	    }
	    if (nextLineNumber < defaultLine) {
		return;
	    }
	    
	    // ADD NEW LINE
	    ExtControlItem newControlItem = createExtControlItem(getFilterPanel());
	    newControlItem.setEnabledEdit(false);
	    getControlList().add(newControlItem);
	    
	    getFilterPanel().layout();
	    getShell().pack(); // important method

	    
	    return;
	}
	if (!next.isEnabled()) {
	    next.setEnabled(true);
	}
	
	
    }
    
    
    protected void handleDisableControlItem(ExtControlItem controlItem) {
	List<ExtControlItem> nextList = getNextNotUsable(controlItem);
	if (nextList == null || nextList.size() == 0) {
	    return;
	}
	for (ExtControlItem nextItem : nextList) {
	    nextItem.setEnabled(false);
	}
	
	// TODO: Must add implementation delete/disable free not usable last lines
	// DELETE LAST NOT USABLE LINES
    }
    
    protected int getLineNumber(ExtControlItem currControlItem) {
	if (currControlItem == null) {
	    return -1;
	}
	List<ControlItem> controlList = getVisibleControlList();
	int i = -1;
	for (ControlItem controlItem : controlList) {
	    i++;
	    if (currControlItem == controlItem) {
		return i; 
	    }
	}
	return -1;
    }
    
    protected ExtControlItem getNextControlItem(ExtControlItem currControlItem) {
	if (currControlItem == null) {
	    return null;
	}
	List<ControlItem> controlList = getVisibleControlList();
	boolean found = false;
	for (ControlItem controlItem : controlList) {
	    if (currControlItem == controlItem) {
		found = true;
		continue;
	    }
	    if (found) {
		return (ExtControlItem) controlItem;
	    }
	}
	return null;
    }

    protected List<ExtControlItem> getNextNotUsable(ExtControlItem currControlItem) {
	if (currControlItem == null) {
	    return null;
	}
	List<ControlItem> controlList = getVisibleControlList();
	List<ExtControlItem> result = new ArrayList<ExtControlItem>();
	boolean found = false;
	for (ControlItem controlItem : controlList) {
	    if (currControlItem == controlItem) {
		found = true;
		continue;
	    }
	    if (found) {
		ExtControlItem extItem = (ExtControlItem) controlItem;
       	        if (!extItem.isUsable()) {
		    result.add(extItem);
		} else {
		    return null;
		}
	    }
	}
	return result;
    }

    protected List<ExtControlItem> getLastNotUsable() {
	List<ControlItem> controlList = getVisibleControlList();
	if (controlList == null) {
	    return null;
	}
	List<ExtControlItem> result = new ArrayList<ExtControlItem>();
	int count = controlList.size();
	if (count == 0) {
	    return null;
	}
	for (int i = count -1; i > -1; i--) {
	    ExtControlItem extItem = result.get(i);
       	    if (!extItem.isUsable()) {
       		result.add(extItem);
   	    } else {
   		return result;
   	    }
	}
	return result;
    }

    
    protected List<ControlItem> createFilterControlList(Composite parent) {
	List<ControlItem> controlList = new ArrayList<ControlItem>();
	parent.setLayout(createFilterPanelLayout(3));

	for (int i = 0; i < defaultLine; i++) {
	    ExtControlItem controlItem = createExtControlItem(parent);
	    if (i > 0) {
		controlItem.setEnabled(false);
	    }
	    controlList.add(controlItem);
	}
	return controlList;
    }

    protected ExtControlItem createExtControlItem(Composite parent) {
	return new ExtControlItem(parent);
    }

    
    protected List<ControlItem> getVisibleControlList() {
	List<ControlItem> controlList = getControlList();
	if (controlList == null) {
	    return null;
	}
	List<ControlItem> visibleControlList = new ArrayList<ControlItem>();
	for (ControlItem item : controlList) {
	    if (item.isVisible()) {
		visibleControlList.add(item);
	    }
	}
	return visibleControlList;
    }

    private List<ControlItem> getColumnItems() {
	if (columnItems == null) {
	    columnItems = createColumnItems(true); 
	}
	return columnItems;
    }
    
    private List<ControlItem> createColumnItems(boolean isAddEmpty) {
	
	List<ControlItem> columnItems = new ArrayList<ControlItem>();
	List<ColumnSetting<T, C, R>> columnSettings = getColumnSettings();
	
	ControlItem item = null;
	if (isAddEmpty) {
	    item = new ControlItem();
	    item.displayField = "-"; // Add empty item
	    columnItems.add(item);
	}

	for (ColumnSetting<T, C, R> cs : columnSettings) {
	    item = new ControlItem();
	    item.init(cs);
	    columnItems.add(item);
	}

	return columnItems;
    }

}
