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

import java.text.DateFormat;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public abstract class FilterPanel<T, C, R> extends Composite {

    
    public static int ALL_TYPE = 0;
    
    public static int SIMPLE_TYPE = 1;
    
    public static int ADVANCED_TYPE = 2;
    
    
    
    private FilterDialog<T, C, R> filterDialog;
    
    private ISWTTableView<T, C, R> view;
    
    private List<ColumnSetting<T, C, R>> columnSettings;
    
    // STUB
    private DateFormat dateFormat;
    
    
    
    public FilterPanel(FilterDialog<T, C, R> filterDialog, Composite parent) {
	super(parent, SWT.NONE);
	this.filterDialog = filterDialog;
	this.view = filterDialog.getView();
	this.columnSettings = view.getAvailableColumnSettings();
    }
    
    public abstract void createContent();
    
    public abstract List<TableFilterItem<C>> getFilterItems();
    
    public List<ColumnSetting<T, C, R>> getColumnSettings() {
        return columnSettings;
    }

    public FilterDialog<T, C, R> getFilterDialog() {
        return filterDialog;
    }

    public ISWTTableView<T, C, R> getView() {
        return view;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    
}
