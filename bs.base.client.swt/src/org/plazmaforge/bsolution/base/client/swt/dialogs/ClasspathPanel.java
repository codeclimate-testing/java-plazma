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
 * Created on 17.02.2008
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


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

/** 
 * @author Oleh Hapon
 * $Id: ClasspathPanel.java,v 1.2 2010/04/28 06:31:03 ohapon Exp $
 */

public class ClasspathPanel extends TableItemPanel {


    public static final String CLASSPATH_FILE = "plazma.classpath";

 

    private List<String> data;

    public ClasspathPanel(Composite parent, String title) {
	super(parent, title);

    }

    
 

    protected String getClasspathFileName() {
	return ConfigApplication.getRootDir() + "/" + ConfigApplication.getFilePrefix() +  CLASSPATH_FILE;
    }

    
    public void loadData() {
	BufferedReader reader = null;
	data = new ArrayList<String>();
	try {
	    String fileName = getClasspathFileName();
	    File file = new File(fileName);
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    reader = new BufferedReader(new FileReader(file));

	    String line = null;
	    while (reader.ready()) {
		line = reader.readLine();
		if (line != null) {
		    line = line.trim();
		    if (line.length() == 0 || line.startsWith("#")) {
			continue;
		    }
		    data.add(line);
		}
	    }
	    
	    getViewer().setInput(data);
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    try {
		if (reader != null) {
		    reader.close();
		}
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
    }
    
    public void storeData() {
	BufferedWriter writer = null;
	List<String> data = getData();
	try {
	    String fileName = getClasspathFileName();
	    File file = new File(fileName);
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    writer = new BufferedWriter(new FileWriter(file));
	    for (String line : data) {
		writer.write(line + "\n");
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	} finally {
	    try {
		if (writer != null) {
		    writer.close();
		}
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
    }

    protected TableViewer createTableViewer(Composite parent) {
	TableViewer viewer = new TableViewer(parent);

	Table table = viewer.getTable();
	table.setHeaderVisible(true);

	TableColumn classpathColumn = new TableColumn(table, SWT.NONE);
	classpathColumn.setText("Classpath");
	classpathColumn.setWidth(400);

	viewer.setContentProvider(new ClasspathContentProvider());
	viewer.setLabelProvider(new ClasspathLabelProvider());
	
	table.addMouseListener(new MouseAdapter() {
	    public void mouseDoubleClick(MouseEvent e) {
		doEditAction();
	    } 
	});
	return viewer;
    }

    class ClasspathContentProvider implements IStructuredContentProvider {

	    public Object[] getElements(Object obj) {
		return data == null ? new Object[0] : data.toArray(new String[0]);
	    }

	    public void dispose() {
	    }

	    public void inputChanged(Viewer viewer, Object obj, Object obj1) {
	    }

    }
    
    class ClasspathLabelProvider extends LabelProvider implements ITableLabelProvider {

	public String getColumnText(Object element, int columnIndex) {
	    if (element == null) { 
		return "";
	    }
	    return element.toString();
	}

	public Image getColumnImage(Object element, int columnIndex) {
	    return null; 
	}

    }
    
    protected Object createElement() {
	return new String("");
    }
    
    protected void removeElement() {
	if (data == null) {
	    return;
	}
	data.remove(getSelectionFirstElement());
    }
    
    public List<String> getData() {
	if (data == null) {
	    data = new ArrayList<String>();
	}
        return data;
    }

      
    protected void openEditDialog(String mode, Object element) {
	if (element == null) {
	    return;
	}
	String propertyElement = (String) element;
        ClasspathEditDialog dialog = new ClasspathEditDialog(getShell(), mode, propertyElement);
        if (ADD.equals(mode)) {
            dialog.setData(getData());
        }
        dialog.open();
    }
}
