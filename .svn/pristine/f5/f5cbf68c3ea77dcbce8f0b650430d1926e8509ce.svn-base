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
 * $Id: PersonEducationListForm.java,v 1.2 2010/04/28 06:31:02 ohapon Exp $
 */

public class PersonEducationListForm extends AbstractPersonableList {

    private Table table;
    
    public PersonEducationListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
	setTitle(Messages.getString("PersonEducationListForm.title")); //$NON-NLS-1$

        setLayout(new FillLayout());

        TableColumn tableColumn;
	TableColumn educationTypeColumn;
	TableColumn educationFormColumn;
	TableColumn educationInstituteColumn;
	TableColumn endDateColumn;
	TableColumn facultyColumn;
	TableColumn academicDegreeColumn;

	table = new Table(this, SWTToolkit.TABLE_STYLE);
	table.setLinesVisible(true);
	table.setHeaderVisible(true);

	tableColumn = new TableColumn(table, SWT.NONE);
	tableColumn.setResizable(false);
	tableColumn.setWidth(20);

	educationTypeColumn = new TableColumn(table, SWT.NONE);
	educationTypeColumn.setWidth(200);
	educationTypeColumn.setText(Messages.getString("PersonEducationListForm.educationTypeColumn.text")); //$NON-NLS-1$

	educationFormColumn = new TableColumn(table, SWT.NONE);
	educationFormColumn.setWidth(100);
	educationFormColumn.setText(Messages.getString("PersonEducationListForm.educationFormColumn.text")); //$NON-NLS-1$
    	
	educationInstituteColumn = new TableColumn(table, SWT.NONE);
	educationInstituteColumn.setWidth(300);
	educationInstituteColumn.setText(Messages.getString("PersonEducationListForm.educationInstituteColumn.text")); //$NON-NLS-1$
    	
	endDateColumn = new TableColumn(table, SWT.NONE);
	endDateColumn.setWidth(100);
	endDateColumn.setText(Messages.getString("PersonEducationListForm.endDateColumn.text")); //$NON-NLS-1$
    	
	facultyColumn = new TableColumn(table, SWT.NONE);
	facultyColumn.setWidth(200);
	facultyColumn.setText(Messages.getString("PersonEducationListForm.facultyColumn.text")); //$NON-NLS-1$

	academicDegreeColumn = new TableColumn(table, SWT.NONE);
	academicDegreeColumn.setWidth(200);
	academicDegreeColumn.setText(Messages.getString("PersonEducationListForm.AcademicDegreeColumn.text")); //$NON-NLS-1$
	
        this.setSize(new Point(800, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "educationTypeName");
	bindColumn(2, "educationFormName");
	bindColumn(3, "educationInstituteName");
	bindColumn(4, "endDate", getDateFormat());
	bindColumn(5, "faculty");
	bindColumn(6, "academicDegreeName");
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"

