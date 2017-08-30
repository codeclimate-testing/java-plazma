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
package org.plazmaforge.bsolution.employee.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractOrganizableListForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.LocaleManager;

/** 
 * @author Oleh Hapon
 * $Id: EmployeeListForm.java,v 1.3 2010/12/05 07:57:21 ohapon Exp $
 */
public class EmployeeListForm extends AbstractOrganizableListForm {

    private Table table;
    
    private TableColumn tableColumn;
    private TableColumn codeColumn;
    private TableColumn firstNameColumn;
    private TableColumn middleNameColumn;    
    private TableColumn lastNameColumn;        
    private TableColumn departmentColumn; 
    private TableColumn positionColumn;
    
    private String nameVariant;
    
    public EmployeeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	nameVariant = LocaleManager.getNameVariant();
	
	setTitle(Messages.getString("EmployeeListForm.title")); //$NON-NLS-1$
        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("EmployeeListForm.codeColumn.text")); //$NON-NLS-1$

	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName();
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName();
	} else {
	    addFLName();
	}
    	
    	departmentColumn = new TableColumn(table, SWT.NONE);
    	departmentColumn.setMoveable(true);
    	departmentColumn.setWidth(230);
    	departmentColumn.setText(Messages.getString("EmployeeListForm.departmentColumn.text")); //$NON-NLS-1$
      	
    	positionColumn = new TableColumn(table, SWT.NONE);
    	positionColumn.setMoveable(true);
    	positionColumn.setWidth(230);
    	positionColumn.setText(Messages.getString("EmployeeListForm.positionColumn.text")); //$NON-NLS-1$
    	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    private void addFLName() {
	addFirstNameColumn();
	addLastNameColumn();
    }

    private void addLFMName() {
	addLastNameColumn();
	addFirstNameColumn();
	addMiddleNameColumn();
    }

    private void addFLMName() {
	addFirstNameColumn();
	addLastNameColumn();
	addMiddleNameColumn();
    }
    
    private void addFirstNameColumn() {
    	firstNameColumn = new TableColumn(table, SWT.NONE);
    	firstNameColumn.setMoveable(true);
    	firstNameColumn.setWidth(230);
    	firstNameColumn.setText(Messages.getString("EmployeeListForm.firstNameColumn.text")); //$NON-NLS-1$
    }
    
    private void addMiddleNameColumn() {
    	middleNameColumn = new TableColumn(table, SWT.NONE);
    	middleNameColumn.setMoveable(true);
    	middleNameColumn.setWidth(230);
    	middleNameColumn.setText(Messages.getString("EmployeeListForm.middleNameColumn.text")); //$NON-NLS-1$
    }
    
    private void addLastNameColumn() {
    	lastNameColumn = new TableColumn(table, SWT.NONE);
    	lastNameColumn.setMoveable(true);
    	lastNameColumn.setWidth(230);
    	lastNameColumn.setText(Messages.getString("EmployeeListForm.lastNameColumn.text")); //$NON-NLS-1$
    }
    
    
    protected void bindTable() {
	int i = 0;
	bindColumn(++i, "code");
	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    bindColumn(++i, "lastName");	    
	    bindColumn(++i, "firstName");
	    bindColumn(++i, "middleName");
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    bindColumn(++i, "firstName");
	    bindColumn(++i, "lastName");
	    bindColumn(++i, "middleName");
	} else {
	    bindColumn(++i, "firstName");
	    bindColumn(++i, "lastName");
	}	
	bindColumn(++i, "departmentName");
	bindColumn(++i, "position");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"