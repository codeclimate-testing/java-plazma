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
 * Created on 08.09.2007
 *
 */

package org.plazmaforge.framework.client.swt.views;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.plazmaforge.framework.client.models.IDataModel;
import org.plazmaforge.framework.client.swt.TableUtils;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.controls.TableProvider;
import org.plazmaforge.framework.util.StringUtils;



/** 
 * @author Oleh Hapon
 * $Id: TableView.java,v 1.4 2010/10/31 08:20:20 ohapon Exp $
 */

public class TableView extends AbstractSWTTableView<Table, TableColumn, TableItem> {

    private TableViewer tableViewer;
    

    
    protected void initTable() {
	super.initTable();
	if (getTable() == null) {
	    return;
	}
	tableViewer = new JFaceTableViewer(getTable());
	tableViewer.setContentProvider(new JFaceContentProvider());
	tableViewer.setLabelProvider(new JFaceLabelProvider());
	tableViewer.setColumnProperties(getTableProvider().getColumnPropertyNames());
	
	tableViewer.setComparer(new EntityComparer());

    }
    
    
    /**
     * Update the table.
     * Load new data from data list.
     */
    public void updateTable(List dataList) {
	
	int index = getTable().getSelectionIndex(); // Store selection index
	
	setDataList(dataList); // Set data list and create index map
	//tableViewer.setInput(getDataModel()); // FIX 2008-12-07: Migrate to setDataListToModel method
	
	int rowCount = getEntityCount();
	
	if (dataList != null && rowCount > 0) {
	    refreshTable();
	}
	updateTable(index); // Update position by selection index	
    }
    
    protected void setDataListToModel(List dataList) {
	super.setDataListToModel(dataList);
	tableViewer.setInput(getDataModel());
    }
    
    
    /**
     * Refresh the table.
     * Reload data from model.
     *
     */
    public void refreshTable() {
	//tableViewer.refresh();
	//
	getTable().redraw();
    }

    /**
     * Resort table.
     *
     */
    public void resort() {
	if (isServerCriteriaMode()) {
	    forceLoadData();
	    return;
	}
	tableViewer.setSorter(new JFaceViewerSorter());
    }
    
    public void refilter() {
	
	getInternalFilter().compile();
	if (isServerCriteriaMode()) {
	    forceLoadData();
	    return;
	}

	
	//tableViewer.resetFilters();
	//tableViewer.addFilter(new JFaceViewerFilter());
	
	ViewerFilter[] filters = tableViewer.getFilters();
	if (filters == null || filters.length == 0) {
	    ViewerFilter filter = new JFaceViewerFilter();
	    tableViewer.addFilter(filter);
	}
	tableViewer.refresh();
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    
    public void setPosition(int index) {
	if (isForceFocus()) {
	    getTable().setFocus();  
	}
	int count = getTable().getItemCount();
	if (count == 0) {
	    return;
	}
	if (index < 0) {
	    getTable().setSelection(0);
	    return;
	}
	if (index < count) {
	    getTable().setSelection(index);
	} else if (count > 0) {
	    // Set last position
	    getTable().setSelection(count - 1);
	}	
    }  
    
    
    public int getPositionByEntity(Object entity) {
	int pos = -1;
	if (entity == null) {
	    return pos;
	}
	Serializable entityId = getEntityId(entity);
	if (entityId == null) {
	    return pos;
	}
	
        int count = getEntityCount();
	
	for (int i = 0; i < count; i++) {
	    Object curEntity = getEntityFromModel(i);
	    Serializable curEntityId = getEntityId(curEntity);
	    if (entityId.equals(curEntityId)) {
		return i;
	    }
	}
	return pos;
    }
    
    
    public int getEntityCount() {
	return getTable().getItemCount();
    }

    public Object getEntityByRow(TableItem row) {
	if (row == null) {
	    return null;
	}
	return row.getData();
    }
    
    public Object getEntityByIndex(int index) {
	return tableViewer.getElementAt(index);
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    
    public void addEntity(Object entity) {

	getModelDataList().add(entity); //ADD : FIX 2008-09-04
	
	// Add entity to viewer
	//tableViewer.add(entity); // DISABLE : FIX 2008-09-04
	
	tableViewer.refresh(); // ADD : FIX 2008-09-04
	getTable().redraw(); // FIX 2008-10-19
	
	fireModelChanged();
	
	setPosition(getTable().getItemCount());
	updateTableState();
    }
    
    public void setEntity(Object entity) {
	
	int index = indexOfEntityInModel(entity); // getTable().getSelectionIndex(); // Store selectiion index
	if (index > -1) {
	    getModelDataList().set(index, entity); // FIX 2009-01-23: Restore after FIX 2008-09-04
	}
	
	
	// Update entity
	tableViewer.update(entity, null);
	if (isForceRefreshAll()) {
	    tableViewer.refresh(); // Force for special items with image
	}
	
	/*
	else {
	    //tableViewer.refresh(entity); // FIX 2009-01-23: We had problems with refresh elements after sort
	}
	*/
	
	getTable().redraw(); // FIX 2008-10-19: We had problems with redraw image after update TableItem
	
	fireModelChanged();
    }
    
    public void removeEntity() {
	Object entity = getSelectedEntity();
	if (entity == null) {
	    return;
	}
	getModelDataList().remove(entity); // FIX 2008-09-04
	
	tableViewer.refresh(); // ADD : FIX 2008-09-04
	getTable().redraw(); // FIX 2008-10-19
	
	// Remove entity
	//tableViewer.remove(entity); // DISABLE : FIX 2008-09-04
	
	fireModelChanged();
    }
    
    /**
     * Return index of entity in data model list.
     * To find we use comparer of TableView
     * @param entity
     * @return
     */
    protected int indexOfEntityInModel(Object entity) {
	if (entity == null) {
	    return -1;
	}
	List list = getModelDataList();
	if (list == null || list.isEmpty()) {
	    return -1;
	}
	IElementComparer comparator = tableViewer.getComparer();
	int size = list.size();
	for (int i = 0; i < size; i++) {
	    Object o = list.get(i);
	    if (comparator.equals(o, entity)) {
		return i;
	    }
	    /*
	    if (o.equals(entity)) {
		return i;
	    }
	    */
	}
	return -1;
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected int getSortDirection(Table table) {
	return table.getSortDirection();
    }
    
    protected void setSortDirection(Table table, int direction) {
	table.setSortDirection(direction);
    }
    
    public int indexOfColumn(TableColumn column) {
	if (column == null) {
	    return -1;
	}
	Table table = column.getParent();
	return table.indexOf(column);
    }
    
    
    public int indexOfColumnItem(IColumnItem<TableColumn> item) {
	if (item == null) {
	    return -1;
	}
	return indexOfColumn(item.getColumn());
    }
    
    public boolean isSortColumn() {
	return getTable().getSortColumn() != null;
    }
    
    public void setDownSort(boolean isDown) {
	getTable().setSortDirection(getSortDirection(isDown));
    }
    
    public TableColumn getSortColumn(Table table) {
	return table.getSortColumn();
    }
    
    public void setSortColumn(Table table, TableColumn column) {
	table.setSortColumn(column);
    }
    
    public boolean isColumnVisible(TableColumn column) {
	if (column == null) {
	    return false;
	}
	return !(column.getWidth() == 0 && !column.getResizable());
    }
    
    public int getColumnWidth(TableColumn column) {
	return column.getWidth(); 
    }
    
    public void setColumnWidth(TableColumn column, int width) {
	column.setWidth(width);
    }

    public int getColumnAlignment(TableColumn column) {
	return column.getAlignment(); 
    }
    
    public boolean isColumnResizable(TableColumn column) {
	return column.getResizable();
    }
    
    public void setColumnResizable(TableColumn column, boolean resizable) {
	column.setResizable(resizable);
    }

    public String getColumnText(TableColumn column) {
	return column.getText();
    }
    
    public TableColumn[] getColumns() {
	return getTable().getColumns();
    }

    public int[] getColumnOrder() {
	return getTable().getColumnOrder();
    }
 
    public void setColumnOrder(int[] columnOrder) {
	getTable().setColumnOrder(columnOrder);
    }

    // SWT Table
    public TableColumn getColumn(int x, int y) {
	int columnIndex = TableUtils.getMouseEventColumn(getTable(), x, y);
	if (columnIndex < 0) {
	    return null;
	}
	return getTable().getColumn(columnIndex);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public TableItem getSelectedRow() {
	int index = getSelectionIndex();
	if (index < 0) {
	    return null;
	}
	return getTable().getItem(index);
    }   
    
    
    public int getSelectionIndex() {
	return getTable().getSelectionIndex();
    }
    
    protected void setDefaultColumnOrder() {
	Table table = getTable();
	if (table == null) {
	    return;
	}
	int[] order = table.getColumnOrder();
	if (order == null || order.length == 0) {
	    return;
	}
	for (int i = 0; i < order.length; i++) {
	    order[i] = i;
	}
	table.setColumnOrder(order);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public Menu getMenu() {
	return getTable().getMenu();
    }
     
    public void addSelectionListener(SelectionListener listener) {
	getTable().addSelectionListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorSelectionListener(listener);
    }
    
    public void addKeyListener(KeyListener listener) {
	getTable().addKeyListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorKeyListener(listener);
    }
    
    public void addMouseListener(MouseListener listener) {
	getTable().addMouseListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorMouseListener(listener);
	
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public int getRowCount() {
	return getTable().getItemCount();
    }
    
    public boolean setTableFocus() {
	Table table = getTable();
	if (table == null || table.isDisposed()) {
	    return false;
	}
	return table.setFocus();
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected ITableProvider<TableItem> createTableProvider() {
	ITableProvider<TableItem> tableProvider = new TableProvider();
	return tableProvider;
    }

    // Only SWT Table
    protected void initColumn(final Table table, final TableColumn column) {
	
	column.addSelectionListener(new SelectionListener() {
	    public void widgetSelected(SelectionEvent e) {
		if (StringUtils.isEmpty(column.getText())) {
		    return;
		}
		doSortColumnAction(table, column);
	    }

	    public void widgetDefaultSelected(SelectionEvent e) {
	    }	    
	});
	getColumnSettingMap().put(column, new ColumnSetting<Table, TableColumn, TableItem>(this, column));
    }
    

    protected TableViewHelper<Table, TableColumn, TableItem> createViewHelper() {
	return new TableViewHelper<Table, TableColumn, TableItem>(this);
    }

    
    //// -------------------------------------------------------------------------------------
    
    class EntityComparer implements IElementComparer {
	
	public boolean equals(Object a, Object b) {
	    if (a == null || b == null) {
		return false;
	    }
	    if (a == b) {
		return true;
	    }
	    
	    Serializable aId = getEntityId(a);
	    Serializable bId = getEntityId(b);
	    if (aId == null || bId == null) {
		return false;
	    }
	    if (aId == bId) {
		return true;
	    }
	    return aId.equals(bId);
	}

	
	public int hashCode(Object element) {
	    return element == null? 0 : element.hashCode();
	}
    }
    
    
    //// -------------------------------------------------------------------------------------
    
    class JFaceTableViewer extends TableViewer {

	public JFaceTableViewer(Composite parent, int style) {
	    super(parent, style);
	}

	public JFaceTableViewer(Composite parent) {
	    super(parent);
	}

	public JFaceTableViewer(Table table) {
	    super(table);
	}

	protected void mapElement(Object element, Widget item) {
	    super.mapElement(element, item);
	    if (element == null || item == null) {
		return;
	    }
	    if (item instanceof TableItem) {
		TableItem tabeItem = (TableItem) item;
		int count = getTableProvider().getColumnCount();
		for (int i = 0; i < count; i++) {
		    getTableProvider().getCellImage(tabeItem, i, element);
		}
	    }
	}
    }

    
    
    //// -------------------------------------------------------------------------------------
    
    class JFaceContentProvider implements IStructuredContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	    
	}

	public void dispose() {
	    
	}

	public Object[] getElements(Object parent) {
	    
	    IDataModel model = getDataModel();
	    if (model == null) {
		return new Object[0];
	    }
	    
	    List list = model.getDataList();
	    if (list == null) {
		return new Object[0];
	    }
	    
	    return list.toArray();
	}

    }

    
    //// -------------------------------------------------------------------------------------
    
    public class JFaceLabelProvider extends LabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
	    return getTableProvider().getCellText(null, columnIndex, element);
	}

	public Image getColumnImage(Object element, int columnIndex) {
	    return null; // TODO: STUB 
	    // return getTableProvider().getCellImage(null, columnIndex, element);
	}

    }

    ////-------------------------------------------------------------------------------------
    
    class JFaceViewerSorter extends ViewerSorter {
	
	private boolean isReset;
	private EntityValueComparator valueComparator;
	
	public JFaceViewerSorter() {
	    super();
	    isReset = getTableSorter().isReset();
	    if (isReset) {
		return;
	    }
	    init();
	}
	
	protected void init() {
	    valueComparator = new EntityValueComparator();
	}

	public int compare(Viewer viewer, Object o1, Object o2) {
	    if (valueComparator == null) {
		return 0;
	    }
	    EntityValue e1 = createEntityValue(o1, valueComparator, -1);
	    EntityValue e2 = createEntityValue(o2, valueComparator, -1);
	    return valueComparator.compare(e1, e2);
	}
    }

    ////-------------------------------------------------------------------------------------
    
    class JFaceViewerFilter extends ViewerFilter {
	
	public boolean select(Viewer viewer, Object parentElement, Object element) {
	    return isFilter(-1, element);
	}
	
    }
}
