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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.util.ObjectCreator;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.ObjectCreator.ObjectValue;

public class SimpleFilterPanel<T, C, R> extends FilterPanel<T, C, R> {

    // UTILS CANDIDATE: BEGIN
    private static Map<String, String> clauseMap = new HashMap<String, String>();
    
    static {
	clauseMap.put(ICriteria.EQ, "eq");
	clauseMap.put(ICriteria.NEQ, "neq");
	clauseMap.put(ICriteria.LIKE, "like");
	clauseMap.put(ICriteria.NOTLIKE, "notlike");
	clauseMap.put(ICriteria.LT, "lt");
	clauseMap.put(ICriteria.LTE, "lte");
	clauseMap.put(ICriteria.GT, "gt");
	clauseMap.put(ICriteria.GTE, "gte");
	clauseMap.put(ICriteria.IN, "in");
	clauseMap.put(ICriteria.NIN, "nin");
	clauseMap.put(ICriteria.ISNULL, "isnull");
	clauseMap.put(ICriteria.ISNOTNULL, "isnotnull");
    }

    public static String getClauseKey(String clause) {
	return clauseMap.get(clause);
    }
    // UTILS CANDIDATE: END
    
    
    private List<ControlItem> controlList;
    
    
    
    public SimpleFilterPanel(FilterDialog<T, C, R> filterDialog, Composite parent) {
	super(filterDialog, parent);
	
	
    }

    public void createContent() {
	createFilterPanel(this);
    }
    
    protected SimpleFilterPanel<T, C, R> getFilterPanel() {
	return this;
    }

    
    protected void createFilterPanel(Composite parent) {
	controlList = createFilterControlList(parent);
	if (controlList.size() > 0) {
	    controlList.get(0).setFocus();
	}
    }
    
    protected List<ControlItem> createFilterControlList(Composite parent) {
	List<ControlItem> controlList = new ArrayList<ControlItem>();
	parent.setLayout(createFilterPanelLayout(3));
	for (ColumnSetting<T, C, R> c : getColumnSettings()) {
	    ControlItem controlItem = createControlItem(parent, c);
	    controlList.add(controlItem);
	}
	return controlList;
    }
    
    protected Layout createFilterPanelLayout(int columnCount) {
	GridLayout gridLayout = new GridLayout();
	gridLayout.numColumns = columnCount;
	return gridLayout;
    }
    
    protected ControlItem createControlItem(Composite parent, ColumnSetting<T, C, R> cs) {
	return new ControlItem(parent, cs);
    }
    

    public List<ControlItem> getControlList() {
        return controlList;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    
    protected class ControlItem {
	
	private boolean visible = true;
	
	public Label labelControl;
	public CCombo clauseControl;
	public Text textControl;
	
	public String field;
	public String displayField;
	
	public Class valueClass;
	public int columnIndex;
	public C column;

	public ControlItem() {
	    
	}
	
	public ControlItem(Composite parent, ColumnSetting<T, C, R> cs) {
	    init(cs);
	    createControls(parent);
	}
	
	public boolean isVisible() {
	    return visible;
	}
	
	public void hide() {
	    this.visible = false;
	}

	protected void init(int index) {
	    ColumnSetting<T, C, R> cs = getColumnSettings().get(index);
	    init(cs);
	}
	
	protected void init(ColumnSetting<T, C, R> cs) {
	    if (cs == null) {
		return;
	    }
	    columnIndex = getView().getColumnIndex(cs);
	    valueClass = getView().getTableProvider().getColumnClass(columnIndex);
	    field = getView().getTableProvider().getColumnPropertyName(columnIndex);
	    column = cs.getColumn();
	    displayField = getView().getColumnText(column);
	}
	
	protected void createControls(Composite parent) {
	    createLabelControl(parent);
	    createClauseControl(parent);
	    createTextControl(parent);
	}
	
	protected void createLabelControl(Composite parent) {
	    labelControl = new Label(parent, SWT.NONE);
	    if (displayField != null) {
		labelControl.setText(displayField);
	    }
	}
	
	protected void createClauseControl(Composite parent) {
	    clauseControl = createFilterClauseControl(parent, valueClass);
	}

	protected void createTextControl(Composite parent) {
	    textControl = new Text(parent, SWT.BORDER);
	    initTextControl(textControl);
	    
	    GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	    gridData.widthHint = 300;
	    textControl.setLayoutData(gridData);
	}

	public boolean setFocus() {
	    if (textControl == null) {
		return false;
	    }
	    return textControl.setFocus();
	}
	
	public boolean isEmpty() {
	    if (textControl == null) {
		return true;
	    }
	    return StringUtils.isEmpty(textControl.getText());
	}
	
	public String getValueString() {
	    if (textControl == null) {
		return null;
	    }
	    return textControl.getText();
	}
	
	public String getClause() {
	    if (clauseControl == null) {
		return null;
	    }
	    
	    List<ClauseItem> data = (List<ClauseItem>) clauseControl.getData();
	    if (data == null) {
		return null;
	    }
	    int index = clauseControl.getSelectionIndex();
	    if (index < 0 || index >= data.size()) {
		return null;
	    }
	    return data.get(index).getClause();
	}
	
	public void prepare() {}
    }

    
    ////////////////////////////////////////////////////
    
    protected void initTextControl(Text text) {
	if (text == null) {
	    return;
	}
	text.addKeyListener(new KeyAdapter() {
	    public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.CR) {
		    getFilterDialog().doOkAction();
		}
	    }
	});
	
    }
    
    
    protected CCombo createFilterClauseControl(Composite parent, Class valueClass) {
	CCombo combo = new CCombo(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	combo.setLayoutData(gridData);
	populateClauseControl(combo, valueClass, true);
	return combo;
    }
    
    protected void populateClauseControl(CCombo combo, Class valueClass, boolean isNew) {
	if (combo == null) {
	    return;
	}
	int index = 0;
	int itemCount = 0;
	
	if (!isNew) {
	    index = combo.getSelectionIndex();
	    if (index < 0) {
		index = 0;
	    }
	    itemCount = combo.getItemCount();
	    if (itemCount > 0) {
		combo.removeAll();
	    }
	}

	List<ClauseItem> data = getClauseList(valueClass);
	itemCount = data.size();
	
	for (ClauseItem item : data) {
	    combo.add(item.getDisplayClause()); 
	}
	combo.setData(data);
	
	if (itemCount > 0) {
	    if (index >= itemCount) {
		index = 0;
	    }
	    combo.select(index);
	}

    }
    
    ///////////////////////////////////////////////////
    
    
    protected List<ClauseItem> getClauseList(Class valueClass) {
	if (valueClass == null) {
	    return getDefaultClauseList();
	}
	if (String.class == valueClass) {
	    return getStringClauseList();
	}
	return getDefaultClauseList();
    }
    
    protected List<ClauseItem> getDefaultClauseList() {
	List<ClauseItem> list = new ArrayList<ClauseItem>();
	list.add(new ClauseItem(ICriteria.EQ));
	list.add(new ClauseItem(ICriteria.NEQ));
	list.add(new ClauseItem(ICriteria.LT));
	list.add(new ClauseItem(ICriteria.GT));
	list.add(new ClauseItem(ICriteria.LTE));
	list.add(new ClauseItem(ICriteria.GTE));
	return list;
    }

    protected List<ClauseItem> getStringClauseList() {
	List<ClauseItem> list = new ArrayList<ClauseItem>();
	list.add(new ClauseItem(ICriteria.EQ));
	list.add(new ClauseItem(ICriteria.NEQ));
	list.add(new ClauseItem(ICriteria.LIKE));
	//list.add(new ClauseItem(ICriteria.NOTLIKE));
	return list;
    }

    protected List<ClauseItem> getNumberClauseList() {
	List<ClauseItem> list = new ArrayList<ClauseItem>();
	list.add(new ClauseItem(ICriteria.EQ));
	list.add(new ClauseItem(ICriteria.NEQ));
	list.add(new ClauseItem(ICriteria.LT));
	list.add(new ClauseItem(ICriteria.GT));
	list.add(new ClauseItem(ICriteria.LTE));
	list.add(new ClauseItem(ICriteria.GTE));
	return list;
    }

    protected List<ClauseItem> getDateClauseList() {
	List<ClauseItem> list = new ArrayList<ClauseItem>();
	list.add(new ClauseItem(ICriteria.EQ));
	list.add(new ClauseItem(ICriteria.NEQ));
	list.add(new ClauseItem(ICriteria.LT));
	list.add(new ClauseItem(ICriteria.GT));
	list.add(new ClauseItem(ICriteria.LTE));
	list.add(new ClauseItem(ICriteria.GTE));
	return list;
    }

    
    protected class ClauseItem {
	
	
	private String clause;
	private String displayClause;
	
	public ClauseItem(String clause) {
	    this.clause = clause;
	    this.displayClause = getDisplayClause(clause);
	}

	public ClauseItem(String clause, String displayClause) {
	    super();
	    this.clause = clause;
	    this.displayClause = displayClause;
	}
	
	protected String getDisplayClause(String clause) {
	    String key = getClauseKey(clause);
	    if (key == null) {
		return clause;
	    }
	    String value = Messages.getString("clause." + key);
	    return value;
	}

	public String getClause() {
	    return clause;
	}

	public String getDisplayClause() {
	    return displayClause;
	}
	
	
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public List<TableFilterItem<C>> getFilterItems() {
	List<TableFilterItem<C>> items = new ArrayList<TableFilterItem<C>>();
	
	List<ControlItem> visibleControlList = getVisibleControlList();
	for (ControlItem controlItem : visibleControlList) {
	    controlItem.prepare();
	    
	    String valueString = controlItem.getValueString();
	    if (controlItem.isEmpty()) {
		continue;
	    }
	    String clause = controlItem.getClause();
	    C column = controlItem.column;
	    int columnIndex = controlItem.columnIndex;
	    Class valueClass = controlItem.valueClass;
	    
	    Object value = getValue(valueString, valueClass, clause);
	    
	    if (value == null) {
		continue;
	    }
	    
	    TableFilterItem<C> item = new TableFilterItem<C>();
	    
	    item.setColumn(column);
	    item.setColumnIndex(columnIndex);
	    item.setClause(clause);
	    item.setValueString(valueString);
	    item.setValueClass(valueClass);
	    item.setValue(value);
	    
	    
	    items.add(item);
	}
	return items;
    }
    
    protected Object getValue(String str, Class klass, String clause) {
	ObjectValue objectValue = getObjectCreator().createObjectValueByString(klass, str);
	if (objectValue == null) {
	    return null;
	}
	return objectValue.getValue();
    }
    
    private ObjectCreator objectCreator;
    
    
    private ObjectCreator getObjectCreator() {
	if (objectCreator == null) {
	    objectCreator = new ObjectCreator();
	    if (getDateFormat() != null) {
		objectCreator.setDateFormat(getDateFormat());
	    }
	}
	return objectCreator;
    }

  


    protected List<ControlItem> getVisibleControlList() {
	return getControlList();
    }
    protected int getVisibleContrilCount() {
	List list = getVisibleControlList();
	if (list == null) {
	    return 0;
	}
	return list.size();
    }

    
}
