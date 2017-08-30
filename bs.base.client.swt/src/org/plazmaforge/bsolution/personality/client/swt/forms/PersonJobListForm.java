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
 * Created on 11.07.2007
 *
 */

package org.plazmaforge.bsolution.personality.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;

/** 
 * @author Oleh Hapon
 * $Id: PersonJobListForm.java,v 1.2 2010/04/28 06:31:02 ohapon Exp $
 */

public class PersonJobListForm extends AbstractPersonableList {

    private Table table;
    
    public PersonJobListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
	setTitle(Messages.getString("PersonJobListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn startDateColumn;
        TableColumn endDateColumn;
        TableColumn organizationColumn;
        TableColumn positionColumn;
     
        setLayout(new FillLayout());

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	startDateColumn = new TableColumn(table, SWT.NONE);
    	startDateColumn.setWidth(100);
    	startDateColumn.setText(Messages.getString("PersonJobListForm.startDateColumn.text")); //$NON-NLS-1$

    	endDateColumn = new TableColumn(table, SWT.NONE);
    	endDateColumn.setWidth(100);
    	endDateColumn.setText(Messages.getString("PersonJobListForm.endDateColumn.text")); //$NON-NLS-1$
    	
    	organizationColumn = new TableColumn(table, SWT.NONE);
    	organizationColumn.setWidth(300);
    	organizationColumn.setText(Messages.getString("PersonJobListForm.organizationColumn.text")); //$NON-NLS-1$
    	
    	positionColumn = new TableColumn(table, SWT.NONE);
    	positionColumn.setWidth(200);
    	positionColumn.setText(Messages.getString("PersonJobListForm.positionColumn.text")); //$NON-NLS-1$
    	
        this.setSize(new Point(700, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "startDate", getDateFormat());
	bindColumn(2, "endDate", getDateFormat());
	bindColumn(3, "organization");
	bindColumn(4, "position");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"


