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

public class DocumentRelationListForm extends AbstractListForm {

    private Table table;
    

    
    
    public DocumentRelationListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("DocumentRelationListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn parentTypeCodeColumn;
        TableColumn parentTypeNameColumn;
        TableColumn childTypeCodeColumn;
        TableColumn childTypeNameColumn;
        

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);


    	parentTypeCodeColumn = new TableColumn(table, SWT.NONE);
    	parentTypeCodeColumn.setMoveable(true);
    	parentTypeCodeColumn.setWidth(150);
    	parentTypeCodeColumn.setText(Messages.getString("DocumentRelationListForm.parentTypeCodeColumn.text")); //$NON-NLS-1$

    	parentTypeNameColumn = new TableColumn(table, SWT.NONE);
    	parentTypeNameColumn.setMoveable(true);
    	parentTypeNameColumn.setWidth(300);
    	parentTypeNameColumn.setText(Messages.getString("DocumentRelationListForm.parentTypeNameColumn.text")); //$NON-NLS-1$
    	
    	childTypeCodeColumn = new TableColumn(table, SWT.NONE);
    	childTypeCodeColumn.setMoveable(true);
    	childTypeCodeColumn.setWidth(150);
    	childTypeCodeColumn.setText(Messages.getString("DocumentRelationListForm.childTypeCodeColumn.text")); //$NON-NLS-1$

    	childTypeNameColumn = new TableColumn(table, SWT.NONE);
    	childTypeNameColumn.setMoveable(true);
    	childTypeNameColumn.setWidth(300);
    	childTypeNameColumn.setText(Messages.getString("DocumentRelationListForm.childTypeNameColumn.text")); //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "parentTypeCode");	
	bindColumn(2, "parentTypeName");
	bindColumn(3, "childTypeCode");	
	bindColumn(4, "childTypeName");
    }
 

    protected void fireUpdateData() throws ApplicationException {
	super.fireUpdateData();
	DocumentEnvironment.refreshContext();
    }

}
