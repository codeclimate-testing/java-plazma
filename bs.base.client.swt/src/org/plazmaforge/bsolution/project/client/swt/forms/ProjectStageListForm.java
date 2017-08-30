/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 06.02.2007
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
 * $Id: ProjectStageListForm.java,v 1.2 2010/10/31 08:20:56 ohapon Exp $
 */

public class ProjectStageListForm extends AbstractListForm {

    private Table table;
    

    
    
    public ProjectStageListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("ProjectStageListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn orderNumberColumn;
        TableColumn fromBeginColumn;
        TableColumn averangeDurationColumn;
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
    	nameColumn.setText(Messages.getString("ProjectStageListForm.nameColumn.text")); //$NON-NLS-1$

  	orderNumberColumn = new TableColumn(table, SWT.RIGHT);
    	orderNumberColumn.setMoveable(true);
    	orderNumberColumn.setWidth(100);
    	orderNumberColumn.setText(Messages.getString("ProjectStageListForm.orderNumberColumn.text")); //$NON-NLS-1$

  	fromBeginColumn = new TableColumn(table, SWT.RIGHT);
    	fromBeginColumn.setMoveable(true);
    	fromBeginColumn.setWidth(100);
    	fromBeginColumn.setText(Messages.getString("ProjectStageListForm.fromBeginColumn.text")); //$NON-NLS-1$

  	averangeDurationColumn = new TableColumn(table, SWT.RIGHT);
    	averangeDurationColumn.setMoveable(true);
    	averangeDurationColumn.setWidth(100);
    	averangeDurationColumn.setText(Messages.getString("ProjectStageListForm.averangeDurationColumn.text")); //$NON-NLS-1$

    	
    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("ProjectStageListForm.codeColumn.text")); //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");
	bindColumn(2, "orderNumber");
	bindColumn(3, "fromBegin");
	bindColumn(4, "averangeDuration");	
	bindColumn(5, "code");
    }
  
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
