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
 * Created on 09.05.2008
 *
 */

package org.plazmaforge.bsolution.carservice.client.swt.forms;

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
 * $Id: CarListForm.java,v 1.2 2010/04/28 06:23:01 ohapon Exp $
 */

public class CarListForm extends AbstractListForm {

    private Table table;
    

    
    public CarListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        
        
        TableColumn markColumn;
        TableColumn modelColumn;  
        
        //disable: customer request
        //TableColumn classColumn;
        
        TableColumn regNumberColumn;
        TableColumn chassisNumberColumn;
        TableColumn engineVolumeColumn;
        TableColumn manufactureYearColumn;
        TableColumn ownerColumn;
        
        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);


    	markColumn = new TableColumn(table, SWT.NONE);
    	markColumn.setWidth(150);
    	markColumn.setText(Messages.getString("CarListForm.markColumn.text")); //$NON-NLS-1$

    	modelColumn = new TableColumn(table, SWT.NONE);
    	modelColumn.setWidth(150);
    	modelColumn.setText(Messages.getString("CarListForm.modelColumn.text")); //$NON-NLS-1$
    	
    	//disable: customer request
    	//classColumn = new TableColumn(table, SWT.NONE);
    	//classColumn.setWidth(50);
    	//classColumn.setText(Messages.getString("CarListForm.classColumn.text")); //$NON-NLS-1$

    	//
    	
    	regNumberColumn = new TableColumn(table, SWT.NONE);
    	regNumberColumn.setWidth(140);
    	regNumberColumn.setText(Messages.getString("CarListForm.regNumberColumn.text")); //$NON-NLS-1$
    	
    	chassisNumberColumn = new TableColumn(table, SWT.NONE);
    	chassisNumberColumn.setWidth(140);
    	chassisNumberColumn.setText(Messages.getString("CarListForm.chassisNumberColumn.text")); //$NON-NLS-1$
    	
	engineVolumeColumn = new TableColumn(table, SWT.RIGHT);
	engineVolumeColumn.setWidth(120);
	engineVolumeColumn.setText(Messages.getString("CarListForm.engineVolumeColumn.text")); //$NON-NLS-1$
    	    	
    	manufactureYearColumn = new TableColumn(table, SWT.RIGHT);
    	manufactureYearColumn.setWidth(120);
    	manufactureYearColumn.setText(Messages.getString("CarListForm.manufactureYearColumn.text")); //$NON-NLS-1$
    	

    	ownerColumn = new TableColumn(table, SWT.NONE);
    	ownerColumn.setWidth(250);
    	ownerColumn.setText(Messages.getString("CarListForm.ownerColumn.text")); //$NON-NLS-1$

        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	
	
	bindColumn(1, "carMarkName");
	bindColumn("carModelName");
	
	//bindColumn("carClassName"); // disable: customer request
	
	bindColumn("regNumber");
	bindColumn("chassisNumber");
	bindColumn("engineVolume", getIntegerFormat());
	bindColumn("manufactureYear");
	bindColumn("ownerName");
    }
}
