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



package org.plazmaforge.bsolution.pim.client.swt.forms;



import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.IMyForm;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarHelper;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarSource;
import org.plazmaforge.bsolution.base.common.services.CalendarService;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractResponsableListForm;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.controls.IOzCalendarSource;
import org.plazmaforge.framework.client.swt.controls.OzCalendar;
import org.plazmaforge.framework.client.swt.controls.OzCalendarEvent;
import org.plazmaforge.framework.client.swt.controls.OzCalendar.IOzCalendarMenuBuilder;
import org.plazmaforge.framework.client.swt.controls.OzCalendar.OzCalendarAdapter;
import org.plazmaforge.framework.client.swt.forms.IEntitySelector;
import org.plazmaforge.framework.core.exception.ApplicationException;


/** 
 * @author Oleh Hapon
 */

public class PIMAppointmentListForm extends AbstractResponsableListForm implements IMyForm {

    private TabFolder tabFolder;
    
    private TabItem tablelTabItem;
    
    private TabItem ozCalendarTabItem;
    
    
    private Table table;
    
    private OzCalendar ozCalendar; 
    
    private IEntitySelector calendarSelector;
    
    public PIMAppointmentListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PIMAppointmentListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn appointmentPriorityColumn;
        TableColumn subjectColumn;
        TableColumn startDateTimeColumn;
        TableColumn endDateTimeColumn;
        TableColumn responsibleColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
 

        // Create Tab Folder
    	tabFolder = new TabFolder(this, SWT.NONE);

    	// Create table tab item
    	tablelTabItem = new TabItem(tabFolder, SWT.NONE);
    	tablelTabItem.setText(Messages.getString("table")); //$NON-NLS-1$
    	
    	table = new Table(tabFolder, SWTToolkit.TABLE_STYLE);
    	tablelTabItem.setControl(table);

    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	appointmentPriorityColumn = new TableColumn(table, SWT.NONE);
    	appointmentPriorityColumn.setMoveable(true);
    	appointmentPriorityColumn.setWidth(100);
    	appointmentPriorityColumn.setText(Messages.getString("PIMAppointmentListForm.appointmentPriorityColumn.text")); //$NON-NLS-1$
    	
    	subjectColumn = new TableColumn(table, SWT.NONE);
    	subjectColumn.setMoveable(true);
    	subjectColumn.setWidth(300);
    	subjectColumn.setText(Messages.getString("PIMAppointmentListForm.subjectColumn.text")); //$NON-NLS-1$

    	startDateTimeColumn = new TableColumn(table, SWT.NONE);
    	startDateTimeColumn.setMoveable(true);
    	startDateTimeColumn.setWidth(100);
    	startDateTimeColumn.setText(Messages.getString("PIMAppointmentListForm.startDateTimeColumn.text"));     //$NON-NLS-1$
    	
	endDateTimeColumn = new TableColumn(table, SWT.NONE);
    	endDateTimeColumn.setMoveable(true);
    	endDateTimeColumn.setWidth(100);
    	endDateTimeColumn.setText(Messages.getString("PIMAppointmentListForm.endDateTimeColumn.text")); //$NON-NLS-1$
      	
    	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("PIMAppointmentListForm.responsibleColumn.text"));  //$NON-NLS-1$
    	
    	
    	// Create OzCalendar tab item
    	ozCalendarTabItem = new TabItem(tabFolder, SWT.NONE);
    	ozCalendarTabItem.setText(Messages.getString("calendar")); //$NON-NLS-1$

    	ozCalendar = new OzCalendar(tabFolder, SWT.NONE);
    	ozCalendarTabItem.setControl(ozCalendar);
    	ozCalendar.addCalendarListener(new OzCalendarAdapter() {
    	    public void eventDoubleClicked(OzCalendarEvent event) {
    		doEditEvent();
    	    }
    	});
	ozCalendar.setMenuBuilder(new IOzCalendarMenuBuilder() {
	    public void buildMenu(OzCalendarEvent event, Menu menu) {
		buildCalendarMenu(event, menu);
	    }
	});
    	
    	
    	calendarSelector = CalendarHelper.createEntitySelector(ozCalendar);
    	
    	tabFolder.addSelectionListener(new SelectionListener() {
    	    public void widgetSelected(SelectionEvent e) {
    		if (e.item == ozCalendarTabItem) {
    		    setEntitySelector(calendarSelector);
    		    doUpdateCalendar();
    		    return;
    		}   
    		setEntitySelector(null);
    	    }
    	    
	    public void widgetDefaultSelected(SelectionEvent e) {
	    }
    	});
    	
    	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "appointmentPriorityName");
	bindColumn("subject");
	bindColumn("startDateTime", getDateTimeFormat());
	bindColumn("endDateTime", getDateTimeFormat());
	bindColumn("responsibleName");
    }
 
    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    getDecorator().setTitle(Messages.getString("MyPIMAppointmentListForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////
    
    private boolean dirtyCalendar = true;
    
    private boolean initCalendarSources = false;
    
    protected void doUpdateCalendar() {
	try {
	    updateCalendar();
	} catch(ApplicationException e) {
	    
	}
    }
    
    protected void updateCalendar() throws ApplicationException {
	if (ozCalendar == null || !dirtyCalendar) {
	    return;
	}
	dirtyCalendar = false;
	if (!initCalendarSources) {
	    initCalendarSources = true;
	    Map<String, Object> parameters = new HashMap<String, Object>();
	    populateMyFormCriteria(parameters);

	    IOzCalendarSource[] sources = CalendarSource.getCalendarSources((CalendarService) getEntityService(), parameters);
	    ozCalendar.setSources(sources);
	} else {
	    ozCalendar.update();
	}
    }

    protected void doEditEvent() {
	try {
	    doEditAction();
	} catch (ApplicationException e) {
	    openErrorDialog(e);
	}
    }
    
    
    protected void fireUpdateData() throws ApplicationException {
	super.fireUpdateData();
	
	//TODO: Must update only one event
	dirtyCalendar = true;
	if (tabFolder.getSelectionIndex() == 1) {
	    updateCalendar();
	}
    }
    
    /////////////////////////////////////////////////////////////
    
    protected void buildCalendarMenu(OzCalendarEvent event, Menu menu) {
	CalendarHelper.buildCalendarMenu(event, menu, getDecorator());
    }
    
    protected void initEditForm(IEditForm form) {
	CalendarHelper.initCalendarEditForm(ozCalendar, form, getDecorator());
    }
 
}  //  @jve:decl-index=0:visual-constraint="10,10"

