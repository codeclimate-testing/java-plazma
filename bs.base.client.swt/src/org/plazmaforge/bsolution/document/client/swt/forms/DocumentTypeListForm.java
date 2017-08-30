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
 * Created on 04.02.2007
 *
 */

package org.plazmaforge.bsolution.document.client.swt.forms;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: DocumentTypeListForm.java,v 1.1 2008/12/01 12:27:32 ohapon Exp $
 */

public class DocumentTypeListForm extends AbstractListForm {

    private Table table;
    

    
    
    public DocumentTypeListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("DocumentTypeListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn documentSectionColumn;
        TableColumn documentCategoryColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setMoveable(true);
    	codeColumn.setWidth(150);
    	codeColumn.setText(Messages.getString("DocumentTypeListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("DocumentTypeListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	documentSectionColumn = new TableColumn(table, SWT.NONE);
    	documentSectionColumn.setMoveable(true);
    	documentSectionColumn.setWidth(200);
    	documentSectionColumn.setText(Messages.getString("DocumentTypeListForm.documentSectionColumn.text")); //$NON-NLS-1$

    	documentCategoryColumn = new TableColumn(table, SWT.NONE);
    	documentCategoryColumn.setMoveable(true);
    	documentCategoryColumn.setWidth(200);
    	documentCategoryColumn.setText(Messages.getString("DocumentTypeListForm.documentCategoryColumn.text")); //$NON-NLS-1$
    	

      	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn(2, "name");
	bindColumn(3, "documentSection");
	bindColumn(4, "documentCategory");
    }
 

    protected void fireUpdateData() throws ApplicationException {
	super.fireUpdateData();
	DocumentEnvironment.refreshContext();
    }
 
}  //  @jve:decl-index=0:visual-constraint="10,10"