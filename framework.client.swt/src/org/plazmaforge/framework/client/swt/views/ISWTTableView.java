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
 * Created on 27.11.2008
 *
 */

package org.plazmaforge.framework.client.swt.views;

import java.text.DateFormat;
import java.util.List;

import org.plazmaforge.framework.client.swt.controls.ITableProvider;
import org.plazmaforge.framework.client.swt.views.ColumnSetting;
import org.plazmaforge.framework.client.swt.views.ITableCellRenderer;
import org.plazmaforge.framework.client.swt.views.TableFilter;
import org.plazmaforge.framework.client.swt.views.TableFinder;
import org.plazmaforge.framework.client.swt.views.TableSorter;
import org.plazmaforge.framework.client.views.ITableView;
import org.plazmaforge.framework.core.criteria.CriteriaFilterSet;


import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

/** 
 * @author Oleh Hapon
 * $Id: ISWTTableView.java,v 1.15 2010/12/05 07:52:25 ohapon Exp $
 */

public interface ISWTTableView<T, C, R> extends ITableView<T> {

    void initCellRenderers(Class entityClass);
    
    void addCellRenderer(int column, ITableCellRenderer r);
    
    ITableCellRenderer getCellRenderer(int column);
    
    List<ITableCellRenderer> getCellRenderers();
    
    boolean isEmptyCellRenderers();
    
    ITableProvider<R> getTableProvider();
    
    //
    
    List<ColumnSetting<T, C, R>> getAvailableColumnSettings();
    
    List<ColumnSetting<T, C, R>> getSortColumnSettings();

    List<ColumnSetting<T, C, R>> getUnSortColumnSettings();
    
    //
    
    TableSorter<T, C, R> getTableSorter();

    TableFilter<T, C, R> getTableFilter();
    
    TableFinder<T, C, R> getTableFinder();
    

    CriteriaFilterSet getInternalFilter();
    

    //
    
    int getColumnIndex(ColumnSetting<T, C, R> cs);
    
    C getColumn(int x, int y);
    
    C[] getColumns();
    
    int indexOfColumn(C column);
    
    int indexOfColumnItem(IColumnItem<C> item);

    int[] getColumnOrder();
    
    void setColumnOrder(int[] columnOrder);
    
    
    R getSelectedRow();
    
    Object getEntityByRow(R row);

    //
    
    void addSelectionListener (SelectionListener listener);
    
    void addKeyListener (KeyListener listener);
    
    void addMouseListener (MouseListener listener);

    
    
    boolean isSortColumn();
    
    C getSortColumn();
    
    void setSortColumn(C column);
    
    void resetSortColumn();
    
    boolean isDownSort();
    
    void setDownSort(boolean isDown);
    
    
    boolean isColumnVisible(C column);
    
    int getColumnWidth(C column);
    
    void setColumnWidth(C column, int width);

    int getColumnAlignment(C column);
    
    boolean isColumnResizable(C column);
    
    void setColumnResizable(C column, boolean resizable);
    
    String getColumnText(C column);

    
    void openColumnSettingDialog(Shell shell);
    
    void openSortDialog(Shell shell);
    
    void openFindDialog(Shell shell, DateFormat dateFormat);

    void openFilterDialog(Shell shell, DateFormat dateFormat);

    void openAdvancedFilterDialog(Shell shell, DateFormat dateFormat);
    
    
    void mapRow(R row, Object entity);
    
    // SWT
    Menu getMenu();
    
}
