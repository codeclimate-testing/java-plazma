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
 * Created on 12.02.2008
 *
 */

package org.plazmaforge.framework.client.swt.dialogs.dataexport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.dialogs.IValidator;
import org.plazmaforge.framework.datawarehouse.ITransferService;

/** 
 * @author Oleh Hapon
 * $Id: TablesSelectionPanel.java,v 1.4 2010/05/19 14:08:53 ohapon Exp $
 */

public class TablesSelectionPanel extends Composite {

    protected final Logger logger = Logger.getLogger(getClass());
    
    private static final int ADD_TABLE_ACTION = 1;
    
    private static final int REMOVE_TABLE_ACTION = 2;
    
    private static final int ADD_ALL_ACTION = 3;
    
    private static final int REMOVE_ALL_ACTION = 4;

    
    
    private List availableList;
    private List selectedList;
    
    private TableViewer availableViewer;
    private TableViewer selectedViewer;
    
    
    private Button addTable;
   
    private Button addAllTable;
    
    private Button removeTable;
    
    private Button removeAllTable;
    
    private ITransferService transferService;
    
    private IValidator validator;
    
    public TablesSelectionPanel(Composite parent, int style, ITransferService transferService) {
	super(parent, style);
	
	this.transferService = transferService;
	
	///
	
	GridLayout gridlayout = new GridLayout(3, false);
        setLayout(gridlayout);
        
        if (availableList == null) {
            loadAvailableTables();
        } else {
            availableList = new ArrayList();
        }
        
        selectedList = new ArrayList();
        
            
        availableViewer = createTableList(this, Messages.getString("ExportDialog.available.tables")); //$NON-NLS-1$
        availableViewer.setInput(availableList);
        createManagerButtonBar(this);
        selectedViewer = createTableList(this, Messages.getString("ExportDialog.selected.tables")); //$NON-NLS-1$
        selectedViewer.setInput(selectedList);
    }

    
    protected void loadAvailableTables() {
        try {
            availableList = new ArrayList();
            ITransferService service = getTransferService();
            if (service == null) {
        	return;
            }
            String[][] s = service.getTableNames();
            if (s == null) {
        	return;
            }
            for (int i = 0; i < s.length; i++) {
        	availableList.add(s[i][0]);
            }
        } catch (Exception ex) {
            logger.error("Loading Data Error", ex);
        }
        
    }
    
    private void createManagerButtonBar(Composite parent)  {
        Composite composite = new Composite(parent, 0);
        composite.setLayout(new FillLayout(SWT.VERTICAL));
        
        addTable = new Button(composite, SWT.NONE);
        addTable.setText(Messages.getString("ExportDialog.add")); //$NON-NLS-1$
        addTable.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(ADD_TABLE_ACTION);
            }
        });
        
        addAllTable = new Button(composite, SWT.NONE);
        addAllTable.setText(Messages.getString("ExportDialog.add.all")); //$NON-NLS-1$
        addAllTable.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(ADD_ALL_ACTION);
            }
        });
        
        removeTable = new Button(composite, SWT.NONE);
        removeTable.setText(Messages.getString("ExportDialog.remove")); //$NON-NLS-1$
        removeTable.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(REMOVE_TABLE_ACTION);
            }
        });
        
        removeAllTable = new Button(composite, SWT.NONE);
        removeAllTable.setText(Messages.getString("ExportDialog.remove.all")); //$NON-NLS-1$
        removeAllTable.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	doAction(REMOVE_ALL_ACTION);
            }
        });
        
    }
    
    private TableViewer createTableList(Composite composite, String s) {
	Composite composite1 = new Composite(composite, 0);
	composite1.setLayout(new GridLayout(1, false));
	GridData griddata = new GridData();
	composite1.setLayoutData(griddata);
	Label label = new Label(composite1, 0);
	label.setText(s);
	Table table = new Table(composite1, SWT.BORDER);
	griddata = new GridData();
	griddata.heightHint = 200; //300;
	griddata.widthHint = 200;
	table.setLayoutData(griddata);
	TableViewer tableviewer = new TableViewer(table);
	tableviewer.setContentProvider(new IStructuredContentProvider() {

	    public Object[] getElements(Object obj) {
		if (obj instanceof Collection)
		    return ((Collection) obj).toArray();
		else
		    return null;
	    }

	    public void dispose() {
	    }

	    public void inputChanged(Viewer viewer, Object obj, Object obj1) {
	    }

	});
	tableviewer.setLabelProvider(new TableLabelProvider());

	tableviewer.addDoubleClickListener(new IDoubleClickListener() {

	    public void doubleClick(DoubleClickEvent doubleclickevent) {
		IStructuredSelection selection = (IStructuredSelection) doubleclickevent.getSelection();

		 Object  element  = selection.getFirstElement();
		 if (element == null) {
		     return;
		 }
		 
		 if(availableList.contains(element)) {
		     availableList.remove(element);
		     selectedList.add(element);
		 } else {
		     selectedList.remove(element);
		     availableList.add(element);
		 }
		 
		 refreshLists();
		 validate();
		 
	    }

	});
	tableviewer.setSorter(new TableSorter());
	return tableviewer;
    }
    
    class TableLabelProvider extends LabelProvider {
	
	 public Image getImage(Object obj) {
	     return getResourceImage("/org/plazmaforge/framework/client/images/eclipse/rdb/table.gif");   
	 }
	 public String getText(Object obj) {
	     return obj.toString();
	 }
    }

    class TableSorter extends ViewerSorter {

        public int compare(Viewer viewer, Object obj, Object obj1) {
            return obj.toString().compareTo(obj1.toString());
        }
    }
    
    
    public void setAvailableList(List availableList) {
        this.availableList = availableList;
    }
    
    
    public List getSelectedList() {
        return selectedList;
    }


      
    protected void moveAll(List from, List to) {
	to.addAll(from);
	from.clear();
    }

    protected void moveElement(List from, List to, Object element) {
	from.remove(element);
	to.add(element);
    }

    protected void moveElements(List from, List to, Iterator elements) {
	if (from == null || to == null || elements == null) {
	    return;
	}
	while (elements.hasNext()) {
	    Object element = elements.next();
	    moveElement(from, to, element);
	}
    }

    protected void doAction(int action) {
        if(ADD_ALL_ACTION == action) {
            moveAll(availableList, selectedList);
            refreshLists();
            validate();
        } else if(REMOVE_ALL_ACTION == action) {
            moveAll(selectedList, availableList);
            refreshLists();
            validate();
        } else  if(ADD_TABLE_ACTION == action) {
            
            if (availableViewer.getSelection().isEmpty()) {
        	return;
            }
            Iterator iterator = ((IStructuredSelection) availableViewer.getSelection()).iterator();
            moveElements(availableList, selectedList, iterator);
            refreshLists();
            validate();
        } else  if(REMOVE_TABLE_ACTION == action)  {
            
            if(selectedViewer.getSelection().isEmpty()) {
        	return;
            }
            Iterator iterator = ((IStructuredSelection) selectedViewer.getSelection()).iterator();
            moveElements(selectedList, availableList, iterator);
            refreshLists();
            validate();
        }
        
      
    }
    
    private void refreshLists()  {
        availableViewer.setInput(availableList);
        selectedViewer.setInput(selectedList);
    }

    ////
    
    public Image getResourceImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }


    public ITransferService getTransferService() {
        return transferService;
    }
    
    public void setTransferService(ITransferService databaseService) {
        this.transferService = databaseService;
    }
    


    /**
     * Return array of selection table names
     * @return
     */
    public String[] getTableNames() {
	List<String> tableNames = new ArrayList<String>();
	if (selectedList == null || selectedList.isEmpty()) {
	    return new String[0];
	}

	int size = selectedList.size();

	for (int i = 0; i < size; i++) {
	    Object e = selectedList.get(i);
	    String tableName = e.toString();
	    tableNames.add(tableName);
	}
	return tableNames.toArray(new String[0]);
    }

    protected void validate() {
	if (getValidator() == null) {
	    return;
	}
	getValidator().validate();
    }
    
    public IValidator getValidator() {
        return validator;
    }


    public void setValidator(IValidator validator) {
        this.validator = validator;
    }
    

    
}
