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

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.models.IObjectStore;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.views.AbstractTableView;
import org.plazmaforge.framework.client.views.IViewHolder;
import org.plazmaforge.framework.config.ConfigUtils;
import org.plazmaforge.framework.core.criteria.CriteriaImpl;
import org.plazmaforge.framework.core.criteria.CriteriaFilter;
import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.criteria.ICriteriaFilter;
import org.plazmaforge.framework.core.criteria.CriteriaFilterSet;
import org.plazmaforge.framework.core.criteria.CriteriaSorterSet;
import org.plazmaforge.framework.core.criteria.InCriteriaFilter;
import org.plazmaforge.framework.core.datastorage.DSArrayDataSet;
import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.util.ClassUtilsExt;
import org.plazmaforge.framework.util.StringUtils;

public abstract class AbstractSWTTableView<T, C, R> extends AbstractTableView<T> implements ISWTTableView<T, C, R> {

    
    /**
     * Table Provider
     */
    private ITableProvider<R> tableProvider;
    
    /**
     * Table Sorter
     */
    private TableSorter<T, C, R> tableSorter;
    
    /**
     * Table Filter
     */
    private TableFilter<T, C, R> tableFilter;
    
    /**
     * Table Finder
     */
    private TableFinder<T, C, R> tableFinder;
    
    
    /**
     * Internal Filter. Use for filter by group/category id or tree selection
     */
    private CriteriaFilterSet internalFilter;
    
    
    private Map<C, ColumnSetting<T, C, R>> columnSettingMap;
    
    
    
    private boolean supportRowListeners;
    
    
    private boolean supportCursor;
    
    
    private List<ITableCellRenderer> cellRenderers;
    
    private TableViewHelper<T, C, R> viewHelper;
    
    
    ////
    
    protected TableViewHelper<T, C, R> getViewHelper() {
	if (viewHelper == null) {
	    viewHelper = createViewHelper();
	}
	return viewHelper;
    }
    
    protected TableViewHelper<T, C, R> createViewHelper() {
	return null;
    }
    
    
    public boolean isSupportRowListeners() {
        return supportRowListeners;
    }

    public void setSupportRowListeners(boolean supportRowListeners) {
        this.supportRowListeners = supportRowListeners;
    }

    public boolean isSupportCursor() {
        return supportCursor;
    }

    public void setSupportCursor(boolean supportCursor) {
        this.supportCursor = supportCursor;
    }

    ////
    
    public ITableProvider<R> getTableProvider() {
	if (tableProvider == null) {
	    tableProvider = createTableProvider();
	}
        return tableProvider;
    }

   
    public List<ITableCellRenderer> getCellRenderers() {
	if (cellRenderers == null)  {
	    cellRenderers = new ArrayList<ITableCellRenderer>();
	}
	return cellRenderers;
    }
    
    public boolean isEmptyCellRenderers() {
	return cellRenderers == null || cellRenderers.size() == 0;
    }
    
    public void addCellRenderer(int column, ITableCellRenderer r) {
	r.setColumnIndex(column);
	getCellRenderers().add(r);
    }
    
    
    public ITableCellRenderer getCellRenderer(int column) {
	if (cellRenderers == null || cellRenderers.isEmpty())  {
	    return null;
	}
	for (ITableCellRenderer r : cellRenderers){
	    if (r.getColumnIndex() == column) {
		return r;
	    }
	}
	return null;
    }
    
    protected boolean isFilter(int rowIndex, Object entity) {
	
	boolean isInternalFilter = isInternalFilter(rowIndex, entity);
	
	if (!isInternalFilter) {
	    return false;
	}
	
	if (tableFilter == null || tableFilter.isReset() || tableProvider == null) {
	    return true;
	}
	
	List<TableFilterItem<C>> items = tableFilter.getItems();
	
	for (TableFilterItem<C> item : items) {
	    int columnIndex = item.getColumnIndex();
	    if (item.isEmpty()) {
		continue;
	    }
	    Object dataValue = tableProvider.getCellValue(null, columnIndex, entity);
	    boolean flag = item.isFilter(dataValue);
	    if (!flag) {
		return false;
	    }
		
	}
	return true;
    }

    protected boolean isInternalFilter(int rowIndex, Object entity) {
	if (internalFilter == null || internalFilter.isReset()) {
	    return true;
	}
	
	List<ICriteriaFilter> items = internalFilter.getItems();
	
	// TODO: STUB
	boolean isOnlyOR = internalFilter.isOnlyOR();
	if (isOnlyOR) {
	    return isInternalFilterOR(items, entity);
	}
	return isInternalFilterAND(items, entity);
    }
    
    protected boolean isInternalFilterAND(List<ICriteriaFilter> items, Object entity) {
	for (ICriteriaFilter item : items) {
	    if (item.isEmpty()) {
		continue;
	    }
	    boolean flag = true;
	    Object dataValue = getEntityValue(entity, item);
	    if (dataValue != null) {
		flag = item.isFilter(dataValue);
	    }
	 
	    if (!flag) {
		return false;
	    }
	}
	return true;
    }
    
    protected boolean isInternalFilterOR(List<ICriteriaFilter> items, Object entity) {
	for (ICriteriaFilter item : items) {
	    if (item.isEmpty()) {
		continue;
	    }
	    boolean flag = false;
	    Object dataValue = getEntityValue(entity, item);
	    if (dataValue != null) {
		flag = item.isFilter(dataValue);
	    }
	    
	    if (flag) {
		return true;
	    }
	    
	}
	return false;
    }
    
    private Object getEntityValue(Object entity, ICriteriaFilter item) {
	return getBeanValue(item.getField(), entity);
    }
    
    public TableSorter<T, C, R> getTableSorter() {
	if (tableSorter == null) {
	    tableSorter = new TableSorter<T, C, R>(this);
	}
	return tableSorter;
    }

    public TableFilter<T, C, R> getTableFilter() {
	if (tableFilter == null) {
	    tableFilter = new TableFilter<T, C, R>(this);
	}
	return tableFilter;
    }
    
    public TableFinder<T, C, R> getTableFinder() {
	if (tableFinder == null) {
	    tableFinder = new TableFinder<T, C, R>(this);
	}
	return tableFinder;
    }

    
    public CriteriaFilterSet getInternalFilter() {
	if (internalFilter == null) {
	    internalFilter = new CriteriaFilterSet();
	}
	return internalFilter;
    }

    
    
    public void find() {
	int findIndex = findIndex();
	if (findIndex < 0) {
	    return;
	}
	setPosition(findIndex);
    }
    
    protected int findIndex() {
	if (tableFinder == null || tableFinder.isReset() || tableProvider == null) {
	    return -1;
	}
	
	int rowCount = getEntityCount();
	for(int i = 0; i < rowCount; i++) {
	    Object entity = getEntityByIndex(i);
	    boolean isFind = isFinder(i, entity);
	    if (isFind) {
		return i;
	    }
	    
	}	
	return -1;
    }
    
    
    protected boolean isFinder(int rowIndex, Object entity) {
	if (tableFinder == null || tableFinder.isReset() || tableProvider == null) {
	    return false;
	}
	
	List<TableFilterItem<C>> items = tableFinder.getItems();
	
	for (TableFilterItem<C> item : items) {
	    int columnIndex = item.getColumnIndex();
	    //FIX 1
	    if (item.isEmpty()) {
		continue;
	    }
	    Object dataValue = tableProvider.getCellValue(null, columnIndex, entity);
	    // FIX 2
	    boolean flag = item.isFilter(dataValue);
	    if (!flag) {
		return false;
	    }
		
	}
	return true;
    }
    
    ////
    
    protected void initTable() {
	if (getTable() == null) {
	    return;
	}
	
	initColumns();
	
	initPaintListener();
 	
	initRowListeners();
	
	initSetDataListener();
 	
   	initCursor();
    }
    
    
    protected void initColumns() {
	clearColumnSettings();
	T table = getTable();
	final C[] columns = getColumns();
	for (int i = 0; i < columns.length; i++) {
	    initColumn(table, columns[i]);
	}
    }

    protected abstract void initColumn(T table, C column);
    
    protected void doSortColumnAction(T table, C column) {
	
	int direction = getSortDirection(table);
	if (column == getSortColumn(table)) {
	    direction = inverseSortDirection(direction);
	} else {
	    setSortColumn(table, column);
	    direction = getDefaultSortDirection();
	}
	setSortDirection(table, direction);
	sort(table, column, isDownSort(direction));
    }

    /**
     * Initialize Paint Listener
     */
    protected void initPaintListener() {

	if (isSupportRowListeners()) {
	    return;
	}
	
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().initPaintListener();
    }
  
    /**
     * Initialize Row Listeners
     */
    protected void initRowListeners() {
	
	if (!isSupportRowListeners()) {
	    return;
	}
	
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().initRowListeners();
    }
    
        
    protected void initSetDataListener() {
	//if (!isSupportSetDataListener()) {
	//    return;
	//}
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().initSetDataListener();
    }
    
    
    protected void initCursor() {
	if (!isSupportCursor()) {
	    return;
	}
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().initCursor();
    }
    

    ////
    
    
    public void initContextMenu() {
	super.initContextMenu();
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().setCursorMenu(getMenu());
    }
    
    protected Map<C, ColumnSetting<T, C, R>> getColumnSettingMap() {
	if (columnSettingMap == null) {
	    columnSettingMap = createColumnSettingMap();
	}
	return columnSettingMap;
    }
    
    protected void clearColumnSettings() {
	columnSettingMap = new HashMap<C, ColumnSetting<T, C, R>>();
    }
    
    protected void recreateColumnSettings() {
	columnSettingMap = createColumnSettingMap();
    }
    
    protected Map<C, ColumnSetting<T, C, R>> createColumnSettingMap() {
	Map<C, ColumnSetting<T, C, R>> map = new HashMap<C, ColumnSetting<T, C, R>>();
	C[] columns = getColumns();
	for (C c : columns) {
	    map.put(c, new ColumnSetting<T, C, R>(this, c));
	}
	return map;
    }
   
    public List<ColumnSetting<T, C, R>> getAvailableColumnSettings() {
	List<ColumnSetting<T, C, R>> columnSettings = new ArrayList<ColumnSetting<T, C, R>>();
	C[] columns = getColumns();
	Map<C, ColumnSetting<T, C, R>> map = getColumnSettingMap();
	for (C c : columns) {
	    if (StringUtils.isEmpty(getColumnText(c))) {
		continue;
	    }
	    columnSettings.add(map.get(c));
	}
	return columnSettings;
    }
    
    public List<ColumnSetting<T, C, R>> getVisibleColumnSettings(boolean flag) {
	List<ColumnSetting<T, C, R>> availableSettings = this.getAvailableColumnSettings();
	List<ColumnSetting<T, C, R>> settings = new ArrayList<ColumnSetting<T, C, R>>();
	for (ColumnSetting<T, C, R> c : availableSettings) {
	    if (c.isVisible(this) != flag) {
		continue;
	    }
	    settings.add(c);
	}
	return settings;
    }    
    
    public List<ColumnSetting<T, C, R>> getSortColumnSettings() {
	return getColumnSettingsBySorting(true);
    }

    public List<ColumnSetting<T, C, R>> getUnSortColumnSettings() {
	return getColumnSettingsBySorting(false);
    }    

    public List<ColumnSetting<T, C, R>> getColumnSettingsBySorting(boolean flag) {
	List<ColumnSetting<T, C, R>> availableSettings = getAvailableColumnSettings();
	List<ColumnSetting<T, C, R>> settings = new ArrayList<ColumnSetting<T, C, R>>();
	if (availableSettings.size() == 0) {
	    return availableSettings;
	}
	TableSorter<T, C, R> sorter = getTableSorter();
	for (ColumnSetting<T, C, R> c : availableSettings) {
	    if (sorter.isSortColumn(c.getColumn()) != flag) {
		continue;
	    }
	    settings.add(c);
	}
	return settings;
    }
    
    public List<ColumnSetting<T, C, R>> getVisibleColumnSettings() {
	return getVisibleColumnSettings(true);
    }
    
        
    protected void setDefaultColumnSettings() {
	List<ColumnSetting<T, C, R>> settings = getAvailableColumnSettings();
	if (settings == null) {
	    return;
	}
	for (int i = 0; i < settings.size(); i++) {
	    ColumnSetting<T, C, R> c = settings.get(i);
	    c.setDefaultSetting(this);
	}
	
	
    }    
    
    public void initCellRenderers(Class entityClass) {
	ITableProvider<R> tableProvider = getTableProvider();
	if (tableProvider == null) {
	    return;
	}
	int count = tableProvider.getColumnCount();
	if (count == 0) {
	    return;
	}
	
	// Auto initialize cell renders for boolean columns
	for (int i = 0; i < count; i++) {
	    ITableCellRenderer renderer = getCellRenderer(i);
	    if (renderer != null) {
		continue;
	    }
	    Class columnClass = tableProvider.getColumnClass(i);
	    if (columnClass == null) {
		String propertyName = tableProvider.getColumnPropertyName(i);
		columnClass = getColumnClass(entityClass, propertyName);
	    }

	    if (columnClass == null) {
		continue;
	    }
	    
	    if (ClassUtilsExt.isBoolean(columnClass)) {
		addCellRenderer(i, new ImageTableCellRenderer());
	    }
	}
    }
   
    protected Class getColumnClass(Class entityClass, String propertyName) {
	return ClassUtilsExt.getBeanPropertyTypeWithNull(entityClass, propertyName);
    }
    
    ////
    
    public void doFastFilter(int x, int y) {
	C column = getColumn(x, y);
	if (column == null) {
	    return;
	}
	int columnIndex = indexOfColumn(column);
	Object entity = getSelectedEntity();
	R  row  = getSelectedRow();
	Object value = getTableProvider().getCellValue(row, columnIndex, entity);
	String valueString = getTableProvider().getCellText(row, columnIndex, entity);
	Class valueClass = getTableProvider().getColumnClass(columnIndex);
	getTableFilter().reset();
	TableFilterItem<C> item = new TableFilterItem<C>();
	item.setColumnIndex(columnIndex);
	item.setColumn(column);
	item.setValue(value);
	item.setValueString(valueString);
	item.setValueClass(valueClass);
	
	getTableFilter().addItem(item);
	
	//refresh();
	refilter();
    }
    
    public void doInternalFilter(String property, Object value) {
	List values = null;
	if (value != null) {
	    values = new ArrayList();
	    values.add(value);
	}
	doInternalFilter(property, values);
    }
    
    public void doInternalFilter(String property, List values) {

	getInternalFilter().reset();

	if (property == null || values == null || values.isEmpty()) {
	    refilter();
	    return;
	}

	/*
	for (int i = 0; i < values.size(); i++) {
	    Object value = values.get(i);
	    CriteriaFilter item = new CriteriaFilterImpl();
	    
	    item.setOperator(Criteria.OR);
	    item.setField(property);
	    item.setValue(value);

	    getInternalFilter().addItem(item);

	}
	*/

	
	int count = values.size();
	if (count == 1) {
	    CriteriaFilter item = new CriteriaFilter();
	    item.setOperator(ICriteria.OR);
	    item.setField(property);
	    item.setValue(values.get(0));
	    getInternalFilter().addItem(item);
	} else {
	    InCriteriaFilter item = new InCriteriaFilter();
	    item.setOperator(ICriteria.OR);
	    item.setField(property);

	    Object[] valueArray = new Object[count];
	    for (int i = 0; i < count; i++) {
		valueArray[i] = values.get(i);
	    }
	    item.setValues(valueArray);
	    
	    getInternalFilter().addItem(item);
	}
	
	refilter();
    }

    
    //////////////////////////////////////////////////////////////////////////////////////
    
   
    
    public ICriteria createCriteria() {
	CriteriaImpl criteria = new CriteriaImpl();
	TableSorter<T, C, R> sorter = getTableSorter();
	if (sorter != null) {
	    CriteriaSorterSet sorterSet = sorter.createCriteriaSorterSet(getTableProvider());
	    criteria.setSorterSet(sorterSet);
	}
	
	// Total filter = Internal filter + Base filter 
	CriteriaFilterSet filterSet = new CriteriaFilterSet();
	
	// Add Internal filter
	CriteriaFilterSet internalFilter = getInternalFilter();
	if (internalFilter != null) {
	    filterSet.addFilterSet(internalFilter);
	}
	
	// Add Base filter
	TableFilter<T, C, R> filter = getTableFilter();
	if (filter != null) {
	    CriteriaFilterSet baseFilter = filter.createCriteriaFilterSet(getTableProvider());
	    filterSet.addFilterSet(baseFilter);
	    //criteria.setFilterSet(filterSet);
	}
	
	// Set total filter
	criteria.setFilterSet(filterSet);
	
	return criteria;
    }
    
    ///////////////////////////////////////////////
    
    protected void updateTableState() {
	if (getViewHolder() != null) {
            ((SWTTableViewHolder) getViewHolder()).updateTableState();
        }
    }
    /////////////////////////////////////////////
    
    /**
     * Resort table.
     *
     */
    public void resort() {
	
	if (isServerCriteriaMode()) {
	    forceLoadData();
	    return;
	}
	
	refresh();
    }
    
    public void refilter() {
	getInternalFilter().compile();
	
	if (isServerCriteriaMode()) {
	    forceLoadData();
	    return;
	}
	
	refresh();
    }
    
    /**
     * Refresh view
     *
     */
    public void refresh() {
	fireModelChanged();
	refreshTable();
    }

    //////////////////////////////////////////////////////////////////

    //deprecated
    public Object getSelectedTableRow() {
	return getSelectedRow();
    }

    public void resetColumnSettings() {
	setDefaultColumnSettings();
	setDefaultColumnOrder();
    }
    
    public Serializable getSelectedEntityId() {
	Object entity = getSelectedEntity();
	if (entity == null) {
	    return null;
	}
	return getEntityId(entity);
    }
    
    //////////////////////////////////////////////////////////////////
    
    protected IObjectStore createEntityStore() {
	return new IObjectStore() {
	    public int size() {
		return getRowCount();
	    }
		
	    public Object getObject(int index) {
		return getEntityByIndex(index);
	    }
	};
    }

    public DSDataSet createDataSet() {
	return createDataSet(createEntityStore());
    }
    
    public DSDataSet createDataSet(IObjectStore store) {
	
	if (store == null) {
	    throw new IllegalArgumentException("EntityStore must be not null");
	}
	
	int columnCount = getTableProvider().getColumnCount();
	int selectColumnCount = columnCount;
	
	int rowCount = store.size() ; // getRowCount(); // IEntityStore injection 
	
	DSArrayDataSet dataSet = new DSArrayDataSet();
	IViewHolder viewHolder = this.getViewHolder();
	if (viewHolder != null && viewHolder instanceof IForm) {
	    dataSet.setCaption(((IForm) viewHolder).getTitle()); 
	}

	Class entityClass = getTableProvider().getEntityClass();
	if (entityClass != null) {
	    dataSet.setName(ConfigUtils.createIdByClass(entityClass));
	}
	int startColumn = 0;
	
	C[] tableColumns = getColumns();
	
	if (columnCount > 0) {
	    C firstColumn = tableColumns[0];
	    String columnText = getColumnText(firstColumn);
	    if (columnText == null || columnText.length() == 0) {
		startColumn = 1;
		selectColumnCount = columnCount - 1;
	    }
	}
	
	List<DSField> columns = new ArrayList<DSField>();
	for (int i = startColumn; i < columnCount; i++) {
	    String name = getTableProvider().getColumnPropertyName(i);

	    Class klass = getTableProvider().getColumnClass(i);
	    String type = TypeUtils.getType(klass);
	    Format format = getTableProvider().getColumnFormat(i);
	    
	    C tableColumn = tableColumns[i];
	    String displayName = getColumnText(tableColumn);
	    int alignment = getColumnAlignment(tableColumn);
	    int displaySize = getColumnWidth(tableColumn);
	    
	    if (SWT.LEFT == alignment) {
		alignment = DSField.LEFT_ALIGN;
	    } else if (SWT.CENTER == alignment) {
		alignment = DSField.CENTER_ALIGN;
	    } else if (SWT.RIGHT == alignment) {
		alignment = DSField.RIGHT_ALIGN;
	    }
	    
	    DSField column = new DSField();
	    column.setName(ConfigUtils.generateIdByCode(name));
	    column.setCaption(displayName);
	    column.setAlign(alignment);
	    column.setDisplaySize(displaySize);
	    
	    column.setDataType(type);
	    column.setFormat(format);
	    columns.add(column);
	}
	dataSet.setFields(columns);
	
	List<Object[]> rows = new ArrayList<Object[]>();
	for (int j = 0; j < rowCount; j++) {
	    Object values[] = new Object[selectColumnCount];
	    Object entity = store.getObject(j); // getEntityByIndex(j); // IEntityStore injection
	    int index = -1;
	    for (int i = startColumn; i < columnCount; i++) {
		Object val = getTableProvider().getCellValue(null, i, entity);
		values[++index] = val;
	    }
	    rows.add(values);
	}
	dataSet.setData(rows);
	return dataSet;
    }
    
    // SWT
    public void openColumnSettingDialog(Shell shell) {
	ColumnSettingDialog<T, C, R> dialog = new ColumnSettingDialog<T, C, R>(shell);
	dialog.setView(this);
	dialog.open();
    }
    
    // SWT
    public void openSortDialog(Shell shell) {
	SortDialog<T, C, R> dialog = new SortDialog<T, C, R>(shell);
	dialog.setView(this);
	dialog.open();
    }

    // SWT
    public void openFindDialog(Shell shell, DateFormat dateFormat) {
	FindDialog<T, C, R> dialog = new FindDialog<T, C, R>(shell);
	dialog.setView(this);
	dialog.setDateFormat(dateFormat); // STUB
	dialog.open();
	
    }

    // SWT
    public void openFilterDialog(Shell shell, DateFormat dateFormat) {
	FilterDialog<T, C, R> dialog = new FilterDialog<T, C, R>(shell);
	dialog.setView(this);
	dialog.setDateFormat(dateFormat); // STUB
	dialog.open();
    }

    // SWT
    public void openAdvancedFilterDialog(Shell shell, DateFormat dateFormat) {
	FilterDialog<T, C, R> dialog = new FilterDialog<T, C, R>(shell);
	dialog.setFilterType(FilterPanel.ADVANCED_TYPE);
	dialog.setView(this);
	dialog.setDateFormat(dateFormat); // STUB
	dialog.open();
    }

    ///
    public void resetSortColumn() {
	setSortColumn(null);
    }
    
    // SWT
    protected int inverseSortDirection(int direction) {
	return (direction == SWT.NONE || direction == SWT.UP) ? SWT.DOWN : SWT.UP;
    }
    
    // SWT
    protected int getDefaultSortDirection() {
	return SWT.UP;
    }
    
    //SWT
    protected boolean isDownSort(int direction) {
	return direction == SWT.DOWN ? false : true; // Inverse 
    }
    
    //SWT
    protected int getSortDirection(boolean isDown) {
	return isDown ? SWT.UP : SWT.DOWN; // Inverse 
    }
    
    //SWT
    protected int getSortDirection() {
	return getSortDirection(getTable());
    }
    
    //SWT
    protected void setSortDirection(int direction) {
	setSortDirection(getTable(), direction);
    }
    
    public C getSortColumn() {
	return getSortColumn(getTable());
    }
    
    public void setSortColumn(C column) {
	setSortColumn(getTable(), column);
    }
    
    
    //SWT
    protected abstract int getSortDirection(T table);
    
    //SWT
    protected abstract void setSortDirection(T table, int direction);
    
    //SWT
    protected abstract C getSortColumn(T table);
    
    //SWT
    protected abstract void setSortColumn(T table, C column);
    
    
    public boolean isDownSort() {
	C column = getSortColumn();
	if (column == null) {
	    return true;
	}
	return isDownSort(getSortDirection());
    }
    
    /**
     * Initialize column by sorter properties
     *
     */
    public void initSortColumn() {
	TableSorter<T, C, R> sorter = getTableSorter();
	if (sorter.isReset()) {
	    resetSortColumn();
	    return;
	}
	
	// TODO: You must initialize all column
	TableSorterItem<C> item = sorter.getItem(0);
	setSortColumn(item.getColumn());
	setDownSort(item.isDown());
    }

    /**
     * Sort table by column and direction
     * @param table
     * @param column
     * @param isDown
     */
    protected void sort(T table, C column, boolean isDown) {
	if (column == null) {
	    return;
	}
	getTableSorter().setItem(column, isDown);
	resort();
    }

    protected abstract ITableProvider<R> createTableProvider();
    
    protected abstract void setDefaultColumnOrder();
    
    public void loadPreferences(Properties preferences) throws ApplicationException {
	C[] columns = getColumns();
	if (columns == null || columns.length == 0) {
	    return;
	}
	int[] columnOrder = getColumnOrder();
	for (int i = 0; i < columns.length; i++) {
	    C column = columns[i];
	    Integer integerValue = null;
	    String columnName = "table.column." + i;
	    integerValue = getIntegerValue(preferences, columnName + ".width");
	    if (integerValue != null) {
		int width = integerValue.intValue();
		setColumnWidth(column, width);
		if (getColumnWidth(column) == 0) {
		    setColumnResizable(column, false);
		}
	    }
	    integerValue = getIntegerValue(preferences, columnName + ".order");
	    if (integerValue != null && i < columnOrder.length) {
		columnOrder[i] = integerValue.intValue();
	    }
	}
	setColumnOrder(columnOrder);
    }
    
    public void storePreferences(Properties preferences) throws ApplicationException {
	C[] columns = getColumns();
	if (columns == null || columns.length == 0) {
	    return;
	}
	int[] columnOrder = getColumnOrder();
	for (int i = 0; i < columns.length; i++) {
	    C column = columns[i];

	    int width = getColumnWidth(column);
	    String columnName = "table.column." + i;

	    preferences.setProperty(columnName + ".width", "" + width);
	    preferences.setProperty(columnName + ".order", "" + columnOrder[i]);
	}

    }    
    
    public int getColumnIndex(ColumnSetting<T, C, R> cs) {
	if (cs == null) {
	    return -1;
	}
	C column = cs.getColumn();
	if (column == null) {
	    return -1;
	}
	return indexOfColumn(column);
    }
    
    public void updateTable() {
	updateTable(-1);
    }
    
    public void updateTable(int index) {
	setPosition(index);
	updateTableState();
    }

    public void setPositionByEntity(Object entity) {
	int pos = getPositionByEntity(entity);
	if (pos < 0) {
	    return;
	}
	setPosition(pos);
    }
    
    public int getPosition() {
	return getSelectionIndex();
    }
  
    public boolean isSelected() {
	return getSelectionIndex() >= 0;
    }
    
    public Object getSelectedEntity() {
	return getEntityByRow(getSelectedRow());
    }
    
    public abstract int getPositionByEntity(Object entity);
    
    
    public void mapRow(R row, Object entity) {
	
	putKeyRow(row, getEntityId(entity)); // Only for key row map 
	
        if (getTableProvider() != null) {
            getTableProvider().mapRow(row, entity);
        }
        if (getViewHolder() != null) {
            ((SWTTableViewHolder) getViewHolder()).mapRow(row, entity);
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Only for non sortable and filterable view
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected Map<Integer, Integer> createIndexMap() {
	if (!getTableSorter().isReset()) {
	    return createSortIndexMap();
	}
	return createDefaultIndexMap();
    }
    
    protected Map<Integer, Integer> createDefaultIndexMap() {
	Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
	List allList =  getDataModel().getDataList();
	if (allList == null) {
	    return indexMap;
	}
	List<Integer> filterIndexes = createFilterIndexes();
	int rowCount = filterIndexes.size();
	for (int i = 0; i < rowCount; i++) {
	    indexMap.put(i, filterIndexes.get(i));
	}
	return indexMap;
    }    

    
    protected Map<Integer, Integer> createSortIndexMap() {
	
	// If sorter is reset the create default index map
	if (getTableSorter().isReset()) {
	    return createDefaultIndexMap();
	}
	
	
	Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
	List allList = getDataModel().getDataList();
	if (allList == null) {
	    return indexMap;
	}
	
	// ------------------------------------------------------------------
	EntityValueComparator comparator = new EntityValueComparator();
	// ------------------------------------------------------------------	
	
	List<Integer> filterIndexes = createFilterIndexes();
	
	int rowCount = filterIndexes.size();
	
	List<EntityValue> columnValues = new ArrayList<EntityValue>();
	
	for (int i = 0; i < rowCount; i++) {
	    int index = filterIndexes.get(i); // Get real index
	    Object entity = allList.get(index);
	    
	    
	    EntityValue entityValue = createEntityValue(entity, comparator, index);
	    columnValues.add(entityValue);
	    
	}
	
	Collections.sort(columnValues, comparator);
	
	for (int i = 0; i < rowCount; i++) {
	    EntityValue entityValue = columnValues.get(i);
	    int oldIndex = entityValue.index;
	    indexMap.put(i, oldIndex);
	}
	return indexMap;	
	
    }
    
    protected List<Integer> createFilterIndexes() {
	List list = getDataModel().getDataList();
	int rowCount = list.size();
	List<Integer> indexes = new ArrayList<Integer>();
	for (int i = 0; i < rowCount; i++) {
	    Object entity = list.get(i);
	    if (isFilter(i, entity)) {
		indexes.add(i);
	    }
	}
	return indexes;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected EntityValue createEntityValue(Object entity, EntityValueComparator comparator, int index) {
	final ITableProvider<R> tableProvider = getTableProvider();
	
	EntityValue entityValue = new EntityValue(index); //(i) // store index
	entityValue.values = new Object[comparator.sorterItemCount];
	    
	for (int k = 0; k < comparator.sorterItemCount; k++) {
	    Object value = tableProvider.getCellValue(null, comparator.columnIndexes[k], entity);
	    entityValue.values[k] = value;
	}
	return entityValue;    
    }
    
    protected class EntityValueComparator implements Comparator<EntityValue> {
	
	int sorterItemCount;
	int[] columnIndexes;
	boolean[] downValues;
	

	public EntityValueComparator() {
	    init();
	}

	protected void init() {
	    // ------------------------------------------------------------------
	    final TableSorter<T, C, R> tableSorter = getTableSorter();
	    List<TableSorterItem<C>> sorterItems = tableSorter.getItems();
	    sorterItemCount = sorterItems.size();
	    columnIndexes = new int[sorterItemCount];
	    downValues = new boolean[sorterItemCount];

	    for (int i = 0; i < sorterItemCount; i++) {
		TableSorterItem<C> item = sorterItems.get(i);
		C column = item.getColumn();
		columnIndexes[i] = indexOfColumn(column);
		downValues[i] = item.isDown();
	    }
	    // ------------------------------------------------------------------
	}

	public int compare(EntityValue o1, EntityValue o2) {

	    int result = 0;
	    for (int i = 0; i < sorterItemCount; i++) {
		Object v1 = o1.values[i];
		Object v2 = o2.values[i];

		result = compareValues(v1, v2, downValues[i]);
		if (result != 0) {
		    return result;
		}

	    }
	    return result;
	}
	    
	    
	protected int compareValues(Object v1, Object v2, boolean isDown) {
	    if (v1 == null && v2 == null) {
		return 0;
	    }
	    if (v1 == null) {
		return isDown ? 1 : -1;
	    }
	    if (v2 == null) {
		return isDown ? -1 : 1;
	    }
	    int result = 0;
	    if (v1 instanceof Comparable) {
		result = ((Comparable) v1).compareTo(v2);
		if (!isDown) {
		    result = result * -1;
		}
		return result;
	    }
	    if (v2 instanceof Comparable) {
		result = ((Comparable) v2).compareTo(v1);
		if (!isDown) {
		    result = result * -1;
		}
		return result;

	    }
	    return 0;
	}
    }
    
    /**
     * Class for store values of row/table item
     *
     */
    protected class EntityValue {
	
	/**
	 * Index of item
	 */
	int index;
	
	/**
	 * Value of cell;
	 */
	Object[] values;
	
	
	EntityValue(int index) {
	    this.index = index;
	}
	
	EntityValue(int index, Object[] value) {
	    this.index = index;
	    this.values = value;
	}
	
    }
}
