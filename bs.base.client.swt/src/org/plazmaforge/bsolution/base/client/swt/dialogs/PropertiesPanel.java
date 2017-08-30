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
 * Created on 16.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.ConfigApplication;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: PropertiesPanel.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class PropertiesPanel extends TableItemPanel {


    public static final String PROPERTIES_FILE = "plazma.properties";

    private List<PropertyElement> data;

    public PropertiesPanel(Composite parent, String title) {
	super(parent, title);

    }

      protected PropertyManager createPropertyManager() {
	return createPropertyManager(ConfigApplication.getRootDir() + "/" + ConfigApplication.getFilePrefix() +  PROPERTIES_FILE);
    }

    
    public void loadData() {
	try {
	    getPropertyManager().load();
	    data = (getPropertyManager().getPropertyList());
	    getViewer().setInput(data);
	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
    }

    protected TableViewer createTableViewer(Composite parent) {
	TableViewer viewer = new TableViewer(parent);

	Table table = viewer.getTable();
	table.setHeaderVisible(true);

	TableColumn nameColumn = new TableColumn(table, SWT.NONE);
	nameColumn.setText(Messages.getString("ConfigPanel.properties.property"));
	nameColumn.setWidth(200);
	TableColumn valueColumn = new TableColumn(table, SWT.NONE);
	valueColumn.setText(Messages.getString("ConfigPanel.properties.value"));
	valueColumn.setWidth(200);

	viewer.setContentProvider(new PropertyContentProvider());
	viewer.setLabelProvider(new PropertyLabelProvider());
	
	table.addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		doEditAction();
	    } 
	});
	return viewer;
    }

    class PropertyContentProvider implements IStructuredContentProvider {

	    public Object[] getElements(Object obj) {
		return data == null ? new Object[0] : data.toArray(new PropertyElement[0]);
	    }

	    public void dispose() {
	    }

	    public void inputChanged(Viewer viewer, Object obj, Object obj1) {
	    }

    }
    
    class PropertyLabelProvider extends LabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
	    if (element == null) { 
		return "";
	    }
	    if (columnIndex == 0) {
		return ((PropertyElement) element).getName();
	    }
	    return ((PropertyElement) element).getValue();
	}

	public Image getColumnImage(Object element, int columnIndex) {
	    return null; 
	}

    }
    
    protected Object createElement() {
	PropertyElement element = new PropertyElement();
	element.setName("");
	element.setValue("");
	return element;
    }
    
    protected void removeElement() {
	if (data == null) {
	    return;
	}
	data.remove(getSelectionFirstElement());
    }
    
    public List<PropertyElement> getData() {
	if (data == null) {
	    data = new ArrayList<PropertyElement>();
	}
        return data;
    }

    public void storeData() {
	Properties properties = new Properties();
	List<PropertyElement> list = getData();
	for (PropertyElement element : list) {
	    properties.setProperty(element.getName(), element.getValue());
	}
	setProperties(properties);
	storeProperties();
    }
    
    protected void openEditDialog(String mode, Object element) {
	if (element == null) {
	    return;
	}
	PropertyElement propertyElement = (PropertyElement) element;
        PropertyEditDialog dialog = new PropertyEditDialog(getShell(), mode, propertyElement);
        if (ADD.equals(mode)) {
            dialog.setData(getData());
        }
        dialog.open();
    }
}
