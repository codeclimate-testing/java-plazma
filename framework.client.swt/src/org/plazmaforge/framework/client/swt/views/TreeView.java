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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.plazmaforge.framework.client.models.IDataModel;
import org.plazmaforge.framework.client.swt.TableUtils;
import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.controls.TreeProvider;
import org.plazmaforge.framework.util.StringUtils;

public class TreeView extends AbstractSWTTableView<Tree, TreeColumn, TreeItem> {

    private TreeViewer tableViewer;
    

    
    protected void initTable() {
	super.initTable();
	if (getTable() == null) {
	    return;
	}
	tableViewer = new JFaceTreeViewer(getTree());
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
	
	int index = -1; // TODO: getTable().getSelectionIndex(); // Store selection index
	
	setDataList(dataList); // Set data list and create index map
	
	int rowCount = getEntityCount();
	
	if (dataList != null && rowCount > 0) {
	    refreshTable();
	}
	updateTable(index); // Update position by selection index	
    }
    
    
    
    protected void setDataListToModel(List dataList) {
	super.setDataListToModel(dataList);
	tableViewer.setInput(getDataModel());
	tableViewer.expandAll();
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

    
    ////////////////////////////////////////////////////////////////////////
    
    public void setPosition(int index) {
	//TODO: STUB
	if (isForceFocus()) {
	    getTable().setFocus();	    
	}
    }  
    
    public void setPositionByEntity(Object entity) {
	tableViewer.setSelection(new StructuredSelection(entity));
    }
    
    public int getPositionByEntity(Object entity) {
	//TODO: STUB
	return -1;
    }
    
    
    public int getEntityCount() {
	return getTable().getItemCount();
    }

    public Object getEntityByRow(TreeItem row) {
	if (row == null) {
	    return null;
	}
	return row.getData();
    }
    
    public Object getEntityByIndex(int index) {
	return null; // TODO: treeViewer.getElementAt(index);
    }
    
    protected Item getItemByEntity(Object entity) {
	if (entity == null) {
	    return null;
	}
	return (Item) tableViewer.testFindItem(entity);
    }   
    
    
  
    
    ////////////////////////////////////////////////////////////////////////
    
    
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
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public Tree getTree() {
        return getTable();
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected int getSortDirection(Tree tree) {
	return tree.getSortDirection();
    }
    
    protected void setSortDirection(Tree tree, int direction) {
	tree.setSortDirection(direction);
    }

    public int indexOfColumn(TreeColumn column) {
	if (column == null) {
	    return -1;
	}
	Tree tree = column.getParent();
	return tree.indexOf(column);
    }
    
    public int indexOfColumnItem(IColumnItem<TreeColumn> item) {
	if (item == null) {
	    return -1;
	}
	return indexOfColumn(item.getColumn());
    }
    
    public boolean isSortColumn() {
	return getTable().getSortColumn() != null;
    }
    
    public void setDownSort(boolean isDown) {
	getTree().setSortDirection(getSortDirection(isDown));
    }

    public TreeColumn getSortColumn(Tree tree) {
	return tree.getSortColumn();
    }
    
    public void setSortColumn(Tree tree, TreeColumn column) {
	tree.setSortColumn(column);
    }

    
    public boolean isColumnVisible(TreeColumn column) {
	if (column == null) {
	    return false;
	}
	return !(column.getWidth() == 0 && !column.getResizable());
    }
    
    public int getColumnWidth(TreeColumn column) {
	return column.getWidth(); 
    }
    
    public void setColumnWidth(TreeColumn column, int width) {
	column.setWidth(width);
    }

    public int getColumnAlignment(TreeColumn column) {
	return column.getAlignment(); 
    }
    
    public boolean isColumnResizable(TreeColumn column) {
	return column.getResizable();
    }
    
    public void setColumnResizable(TreeColumn column, boolean resizable) {
	column.setResizable(resizable);
    }

    public String getColumnText(TreeColumn column) {
	return column.getText();
    }
    
    public TreeColumn[] getColumns() {
	return getTree().getColumns();
    }
    
    public int[] getColumnOrder() {
	return getTree().getColumnOrder();
    }
    
    public void setColumnOrder(int[] columnOrder) {
	getTree().setColumnOrder(columnOrder);
    }

    // SWT Tree
    public TreeColumn getColumn(int x, int y) {
	int columnIndex = TableUtils.getMouseEventColumn(getTree(), x, y);
	if (columnIndex < 0) {
	    return null;
	}
	return getTree().getColumn(columnIndex);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public TreeItem getSelectedRow() {
	TreeItem[] items = getTree().getSelection();
	if (items == null || items.length == 0) {
	    return null;
	}
	return items[0];
    }   
    
    public int getSelectionIndex() {
	TreeItem item = getSelectedRow();
	if (item == null) {
	    return -1;
	}
	return getTree().indexOf(item); // TODO: Invalid index 
    }
    
    protected void setDefaultColumnOrder() {
	Tree tree = getTree();
	if (tree == null) {
	    return;
	}
	int[] order = tree.getColumnOrder();
	if (order == null || order.length == 0) {
	    return;
	}
	for (int i = 0; i < order.length; i++) {
	    order[i] = i;
	}
	tree.setColumnOrder(order);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public Menu getMenu() {
	return getTree().getMenu();
    }
    
    public void addSelectionListener(SelectionListener listener) {
	getTree().addSelectionListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorSelectionListener(listener);
    }
    
    public void addKeyListener(KeyListener listener) {
	getTree().addKeyListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorKeyListener(listener);
    }
    
    public void addMouseListener(MouseListener listener) {
	getTree().addMouseListener(listener);
	if (getViewHelper() == null) {
	    return;
	}
	getViewHelper().addCursorMouseListener(listener);
	
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    public int getRowCount() {
	return getTree().getItemCount(); // TODO: Invalid count
    }
    
    public boolean setTableFocus() {
	Tree tree = getTree();
	if (tree == null || tree.isDisposed()) {
	    return false;
	}
	return tree.setFocus();
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////////////////////////////////////////////////////////
    
    protected ITableProvider<TreeItem> createTableProvider() {
	ITableProvider<TreeItem> tableProvider = new TreeProvider();
	return tableProvider;
    }

    // Only SWT Table
    protected void initColumn(final Tree tree, final TreeColumn column) {
	
	column.addSelectionListener(new SelectionListener() {
	    public void widgetSelected(SelectionEvent e) {
		
		if (StringUtils.isEmpty(column.getText())) {
		    return;
		}
		doSortColumnAction(tree, column);
	    }

	    public void widgetDefaultSelected(SelectionEvent e) {
	    }	    
	});
	getColumnSettingMap().put(column, new ColumnSetting<Tree, TreeColumn, TreeItem>(this, column));
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
    
    class JFaceTreeViewer extends TreeViewer {

	public JFaceTreeViewer(Composite parent, int style) {
	    super(parent, style);
	}

	public JFaceTreeViewer(Composite parent) {
	    super(parent);
	}

	public JFaceTreeViewer(Tree tree) {
	    super(tree);
	}

	protected void mapElement(Object element, Widget item) {
	    super.mapElement(element, item);
	    if (element == null || item == null) {
		return;
	    }
	    if (item instanceof TreeItem) {
		TreeItem treeItem = (TreeItem) item;
		int count = getTableProvider().getColumnCount();
		for (int i = 0; i < count; i++) {
		    getTableProvider().getCellImage(treeItem, i, element);
		}
	    }
	}
    }

    
    
    //// -------------------------------------------------------------------------------------
    
    class JFaceContentProvider implements ITreeContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	    
	}

	public void dispose() {
	    
	}

	public Object getParent(Object child) {
	    Object parentId = getParentId(child);
	    if (parentId == null){
		return null;
	    }
	    return getElementById(getDataList(), parentId);
	}
	
	public boolean hasChildren(Object parent) {
	    if (parent == null) {
		return false;
	    }
	    Object id = getId(parent);
	    List children = getChildrenByParentId(getDataList(), id); 
	    if (children == null || children.isEmpty()) {
		return false;
	    }
	    return true;
	}
	
	public Object[] getChildren(Object parent) {
	    if (parent == null) {
		return new Object[0];
	    }
	    Object id = getId(parent);
	    List children = getChildrenByParentId(getDataList(), id); 
	    if (children == null) {
		return new Object[0];
	    }
	    return children.toArray();
	    
	}
	
	public Object[] getElements(Object parent) {
	    return getChildren(parent);
	}
	
	private List getDataList() {
	    IDataModel model = getDataModel();
	    if (model == null) {
		return null;
	    }
	    return model.getDataList();
	}

    }

    protected Object getId(Object element) {
	return getBeanValue("id", element);
    }

    protected Object getParentId(Object element) {
	return getBeanValue("parentId", element);
    }

    protected Object getElementById(List list, Object id) {
	if (id == null || list == null || list.isEmpty()) {
	    return null;
	}
	for (int i = 0; i < list.size() ; i++) {
	    Object element = list.get(i);
	    Object elementId = getId(element);
	    if (id.equals(elementId)) {
		return element;
	    }
	}
	return null;
    }
    
    protected List getChildrenByParentId(List list, Object parentId) {
	if (list == null || list.isEmpty()) {
	    return null;
	}
	List children = new ArrayList();
	for (int i = 0; i < list.size() ; i++) {
	    Object element = list.get(i);
	    Object elementParentId = getParentId(element);
	    if (parentId == null) {
		if (elementParentId == null) {
		    children.add(element);
		}
	    } else if (parentId.equals(elementParentId)) {
		children.add(element);
	    }
	}
	return children;
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
