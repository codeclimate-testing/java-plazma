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
 * Created on 14.02.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;
import org.plazmaforge.bsolution.personality.common.services.PersonService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.LocaleManager;

/** 
 * @author Oleh Hapon
 * $Id: PersonListForm.java,v 1.3 2010/12/05 07:57:19 ohapon Exp $
 */

public class PersonListForm extends AbstractListForm {
    
    
    private Table table;
    
    private TableColumn tableColumn;
    private TableColumn codeColumn;
    private TableColumn firstNameColumn;
    private TableColumn middleNameColumn;    
    private TableColumn lastNameColumn;
    private TableColumn phoneColumn;
    
    
    private String nameVariant;
    
    
    public PersonListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	setEntityClass(PersonHeader.class); // We use PersonHeader.class because have error with load value personCode 
	setEntityServiceClass(PersonService.class);
	
	nameVariant = LocaleManager.getNameVariant();
	
	setTitle(Messages.getString("PersonListForm.title")); //$NON-NLS-1$
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
    	codeColumn.setText(Messages.getString("PersonListForm.codeColumn.text")); //$NON-NLS-1$

	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    addLFMName();
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    addFLMName();
	} else {
	    addFLName();
	}
	phoneColumn = new TableColumn(table, SWT.NONE);
    	phoneColumn.setWidth(100);
    	phoneColumn.setText(Messages.getString("PersonListForm.phoneColumn.text")); //$NON-NLS-1$
    	
        this.setSize(new Point(600, 300));
        
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
    	firstNameColumn.setText(Messages.getString("PersonListForm.firstNameColumn.text")); //$NON-NLS-1$
    }
    
    private void addMiddleNameColumn() {
    	middleNameColumn = new TableColumn(table, SWT.NONE);
    	middleNameColumn.setMoveable(true);
    	middleNameColumn.setWidth(230);
    	middleNameColumn.setText(Messages.getString("PersonListForm.middleNameColumn.text")); //$NON-NLS-1$
    }
    
    private void addLastNameColumn() {
    	lastNameColumn = new TableColumn(table, SWT.NONE);
    	lastNameColumn.setMoveable(true);
    	lastNameColumn.setWidth(230);
    	lastNameColumn.setText(Messages.getString("PersonListForm.lastNameColumn.text")); //$NON-NLS-1$
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "personCode");
	
	if (LocaleManager.LAST_FIRST_MIDDLE.equals(nameVariant)) {
	    bindColumn("lastName");	    
	    bindColumn("firstName");
	    bindColumn("middleName");
	} else if (LocaleManager.FIRST_LAST_MIDDLE.equals(nameVariant)) {
	    bindColumn("firstName");
	    bindColumn("lastName");
	    bindColumn("middleName");
	} else {
	    bindColumn("firstName");
	    bindColumn("lastName");
	}
	bindColumn("phoneString");

    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
