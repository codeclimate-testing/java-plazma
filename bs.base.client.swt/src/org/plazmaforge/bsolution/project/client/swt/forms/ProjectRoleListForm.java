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
 * Created on 21.08.2007
 *
 */

package org.plazmaforge.bsolution.project.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

/** 
 * @author Oleh Hapon
 * $Id: ProjectRoleListForm.java,v 1.2 2010/04/28 06:31:01 ohapon Exp $
 */

public class ProjectRoleListForm extends AbstractListForm {

    private Table table;
    

    
    
    public ProjectRoleListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle("Project roles");
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn descriptionColumn;
        TableColumn codeColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("ProjectRoleListForm.nameColumn.text")); //$NON-NLS-1$

    	descriptionColumn = new TableColumn(table, SWT.NONE);
    	descriptionColumn.setMoveable(true);
    	descriptionColumn.setWidth(300);
    	descriptionColumn.setText(Messages.getString("ProjectRoleListForm.descriptionColumn.text")); //$NON-NLS-1$
    	
 	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("ProjectRoleListForm.codeColumn.text")); //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");	
	bindColumn(2, "description");
	bindColumn(3, "code");	
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
