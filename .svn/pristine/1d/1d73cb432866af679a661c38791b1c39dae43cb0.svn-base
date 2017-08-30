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
 * Created on 09.09.2007
 *
 */

package org.plazmaforge.framework.client.swt.views;


/** 
 * @author Oleh Hapon
 * $Id: TableViewFactory.java,v 1.5 2010/10/27 10:30:37 ohapon Exp $
 */

public class TableViewFactory {

    public static final String SIMPLE_VIEW = "SIMPLE"; 
    
    public static final String JFACE_VIEW = "JFACE";
    
    public static final String TREE_VIEW = "TREE";
    
    public static final String KTABLE_VIEW = "KTABLE";
    
    
    public static ISWTTableView getSimpleView() {
	ISWTTableView tableView = new SWTTableView();
	return tableView;
    }
    
    public static ISWTTableView getJFaceView() {
	ISWTTableView tableView = new TableView();
	return tableView;
    }
    
    public static ISWTTableView getTreeView() {
	ISWTTableView tableView = new TreeView();
	return tableView;
    }
    
    
    public static ISWTTableView getDefaultView() {
	return getSimpleView();
    }

    
    public static ISWTTableView getView(String viewType) {
	if (SIMPLE_VIEW.equals(viewType)) {
	    return getSimpleView();
	} else if (JFACE_VIEW.equals(viewType)) {
	    return getJFaceView();
	} else if (TREE_VIEW.equals(viewType)) {
	    return getTreeView();
	}
	return getDefaultView();
    }

}
