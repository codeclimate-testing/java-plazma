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


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.widgets.ganttchart.ColorCache;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.GanttEventListenerAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.bsolution.base.client.swt.forms.IMyForm;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarHelper;
import org.plazmaforge.bsolution.base.client.swt.forms.common.CalendarSource;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractResponsableListForm;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.beans.Task;
import org.plazmaforge.bsolution.project.common.services.ProjectService;
import org.plazmaforge.bsolution.project.common.services.TaskService;
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
 * $Id: TaskListForm.java,v 1.4 2010/12/05 07:57:20 ohapon Exp $
 */

public class TaskListForm extends AbstractResponsableListForm implements IMyForm {

    private static final int CALENDAR_ITEM_INDEX = 2;
    
    
    private TabFolder tabFolder;
    
    private Tree tree;
    
    private Table table;
    
    private GanttChart ganttChart;

    private OzCalendar ozCalendar; 
	
    private boolean supportTree = true;
    
    ////
    
    private TabItem tablelTabItem;
    
    private TabItem chartTabItem;
    
    private TabItem ozCalendarTabItem;
    

    ////
    
    private IEntitySelector chartSelector;
    
    private IEntitySelector calendarSelector;
    
    ////
    
    private Task selectedChartTask;
    
    
    public TaskListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	setTitle(Messages.getString("TaskListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn taskPriorityColumn;
        TableColumn taskNoColumn;        
        TableColumn nameColumn;
        TableColumn startDateTimeColumn;
        TableColumn endDateTimeColumn;
        TableColumn percentCompleteColumn;
        TableColumn reporterColumn;
        TableColumn responsibleColumn;
        TableColumn partnerColumn;        

        setLayout(new FillLayout(SWT.VERTICAL));
        
        SashForm sashForm = null;
        if (supportTree) {
   
            setTreeEntityClass(Project.class);
            setTreeServiceClass(ProjectService.class);
            setTreeItemRefIdProperty("projectId");
            
            sashForm = new SashForm(this, SWT.NONE);

            // Create Group Tree 
            tree = new Tree(sashForm, SWT.BORDER);
        }
        
        
        
        // Create Tab Folder
    	tabFolder = new TabFolder(sashForm == null ? this : sashForm, SWT.NONE);

    	// Create table tab item
    	tablelTabItem = new TabItem(tabFolder, SWT.NONE);
    	tablelTabItem.setText(Messages.getString("ProjectListForm.table")); //$NON-NLS-1$
    	
    	
    	

    	table = new Table(tabFolder, SWTToolkit.TABLE_STYLE);
    	tablelTabItem.setControl(table);
    	
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);
    	
    	taskPriorityColumn = new TableColumn(table, SWT.NONE);
    	taskPriorityColumn.setMoveable(true);
    	taskPriorityColumn.setWidth(100);
    	taskPriorityColumn.setText(Messages.getString("TaskListForm.taskPriorityColumn.text")); //$NON-NLS-1$

    	taskNoColumn = new TableColumn(table, SWT.NONE);
    	taskNoColumn.setMoveable(true);
    	taskNoColumn.setWidth(70);
    	taskNoColumn.setText(Messages.getString("TaskListForm.taskNoColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("TaskListForm.nameColumn.text")); //$NON-NLS-1$

    	
	startDateTimeColumn = new TableColumn(table, SWT.NONE);
    	startDateTimeColumn.setMoveable(true);
    	startDateTimeColumn.setWidth(100);
    	startDateTimeColumn.setText(Messages.getString("TaskListForm.startDateTimeColumn.text"));     //$NON-NLS-1$
    	
	endDateTimeColumn = new TableColumn(table, SWT.NONE);
    	endDateTimeColumn.setMoveable(true);
    	endDateTimeColumn.setWidth(100);
    	endDateTimeColumn.setText(Messages.getString("TaskListForm.endDateTimeColumn.text")); //$NON-NLS-1$
    	
	percentCompleteColumn = new TableColumn(table, SWT.RIGHT);
    	percentCompleteColumn.setMoveable(true);
    	percentCompleteColumn.setWidth(70);
    	percentCompleteColumn.setText(Messages.getString("TaskListForm.percentCompleteColumn.text"));        	 //$NON-NLS-1$
      	
    	
    	
    	// Create Gantt Chart tab item
    	chartTabItem = new TabItem(tabFolder, SWT.NONE);
    	chartTabItem.setText(Messages.getString("ProjectListForm.ganttChart")); //$NON-NLS-1$

    	ganttChart = new GanttChart(tabFolder, SWT.NONE);
    	chartTabItem.setControl(ganttChart);
    	
    	ganttChart.getGanttComposite().addGanttEventListener(new GanttEventListenerAdapter() {
    	    public void eventDoubleClicked(GanttEvent event, MouseEvent me) {
    		Task task = (Task) event.getData();
    		selectedChartTask = task;
    		doEditEvent();
    	    }
    	});

    	
    	////
    	
    	// Create OzCalendar tab item
    	ozCalendarTabItem = new TabItem(tabFolder, SWT.NONE);
    	ozCalendarTabItem.setText(Messages.getString("TaskListForm.calendar")); //$NON-NLS-1$

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
    	
    	
    	chartSelector = new ChartSelector();
    	calendarSelector = CalendarHelper.createEntitySelector(ozCalendar);
    	
    	tabFolder.addSelectionListener(new SelectionListener() {
    	    public void widgetSelected(SelectionEvent e) {
    		if (e.item == chartTabItem) {
    		    setEntitySelector(chartSelector);
    		    return;
    		} else if (e.item == ozCalendarTabItem) {
    		    setEntitySelector(calendarSelector);
    		    doUpdateCalendar();
    		    return;
    		}   
    		setEntitySelector(null);
    	    }
    	    
	    public void widgetDefaultSelected(SelectionEvent e) {
	    }
    	});
    	
    	////
    	
    	if (sashForm != null) {
    	    sashForm.setWeights(new int[] {1, 5 });
    	}

 	reporterColumn = new TableColumn(table, SWT.NONE);
 	reporterColumn.setWidth(200);
 	reporterColumn.setText(Messages.getString("TaskListForm.reporterColumn.text"));  //$NON-NLS-1$

 	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("TaskListForm.responsibleColumn.text"));  //$NON-NLS-1$

    	partnerColumn = new TableColumn(table, SWT.NONE);
    	partnerColumn.setMoveable(true);
    	partnerColumn.setWidth(200);
    	partnerColumn.setText(Messages.getString("TaskListForm.partnerColumn.text")); //$NON-NLS-1$

    	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "taskPriorityName");
	bindColumn("taskNo");		
	bindColumn("name");	
	bindColumn("startDateTime", getDateTimeFormat());
	bindColumn("endDateTime", getDateTimeFormat());
	bindColumn("percentComplete", getPercentFormat());
	bindColumn("reporterName");	
	bindColumn("responsibleName");
	bindColumn("partnerName");
    }
 
    protected TaskService getTaskService() {
        return (TaskService) getEntityService();
    }  
    
    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    getDecorator().setTitle(Messages.getString("MyTaskListForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    
    
    ////////////////////////////////////////////////////////////////////////
    //
    // TREE
    //
    ////////////////////////////////////////////////////////////////////////
    
    public Tree getTree() {
	return tree;
    }
    
    protected String getTreeRootName() {
	return Messages.getString("TaskListForm.projects");
    }

    
    ////////////////////////////////////////////////////////////////////////
    //
    // GANTT
    //
    ////////////////////////////////////////////////////////////////////////    
    
    
    protected void updateGanttChart() {
	List elements = getView().getDataModel().getDataList();
	updateGanttChart(elements);
    }
    
    protected void updateGanttChart(List elements) {
	if (ganttChart == null) {
	    return;
	}
	ganttChart.clearEvents();
	if (elements == null || elements.size() == 0) {
	    return;
	}
	GanttEvent firstEvent = null;
	Calendar startDate = null;
	
	for (int i = 0; i < elements.size(); i++) {
	    Task ganttData = (Task) elements.get(i);
	    GanttEvent ganttEvent = createGanttEvent(ganttData);
	    if (ganttEvent == null) {
		continue;
	    }
	    if (startDate == null || ganttEvent.getStartDate().before(startDate)) {
		startDate = ganttEvent.getStartDate();
	    }
	    if (i == 0) {
		firstEvent = ganttEvent;
	    }
	}
	
	if (startDate != null && isAutoPosition()) {
	    Calendar start = Calendar.getInstance();
	    start.setTime(startDate.getTime());
	    ganttChart.getGanttComposite().setDate(start);
	}
	
    }
    
    protected boolean isAutoPosition() {
	return true;
    }
    
    

    /**
     * Create GanttEvent by Task
     * @param task
     * @return
     */
    protected GanttEvent createGanttEvent(Task task) {
	
	if (task == null) {
	    return null;
	}
	
	Date startDate = task.getStartDateTime();
	Date endDate = task.getEndDateTime();
	if (startDate == null || endDate == null) {
	    return null;
	}
	Calendar start = Calendar.getInstance();
	start.setTime(startDate);

	Calendar end = Calendar.getInstance();
	end.setTime(endDate);
	
	MyGanttEvent ganttEvent = new MyGanttEvent(ganttChart, task, task.getName(), start, end, (int) task.getPercentComplete());
	ganttEvent.setMoveMode(false);
	//setColor2(ganttEvent);
	
	return ganttEvent;
    }

    protected void updateGanttEvent(Task ganttData) {
	
	if (ganttData == null) {
	    return;
	}
	
	GanttEvent ganttEvent = findGanttEventById(ganttData.getId());
	
	if (ganttEvent == null) {
	    return;
	}
	
	Date startDate = ganttData.getStartDateTime();
	Date endDate = ganttData.getEndDateTime();
	if (startDate == null || endDate == null) {
	    return;
	}
	Calendar start = Calendar.getInstance();
	start.setTime(startDate);

	Calendar end = Calendar.getInstance();
	end.setTime(endDate);
	
	ganttEvent.setData(ganttData);
	ganttEvent.setName(ganttData.getName());
	ganttEvent.setStartDate(start);
	ganttEvent.setEndDate(end);
	ganttEvent.setPercentComplete((int) ganttData.getPercentComplete());

    }
    
    protected void removeGanttEvent(Task ganttData) {
	removeGanttEventById(ganttData.getId());
    }

    protected void removeGanttEventById(Serializable id) {
	if (id == null) {
	    return;
	}
	
	GanttEvent ganttEvent = findGanttEventById(id);
	
	if (ganttEvent == null) {
	    return;
	}
	ganttChart.getGanttComposite().removeEvent(ganttEvent);
    }

    protected GanttEvent findGanttEventById(Serializable id) {
	if (id == null) {
	    return null;
	}
	List events = ganttChart.getGanttComposite().getEvents();
	if (events == null || events.size() == 0) {
	    return null;
	}
	for (int i = 0; i < events.size(); i++) {
	    GanttEvent ganttEvent = (GanttEvent) events.get(i);
	    Task ganttData = (Task) ganttEvent.getData();
	    if (ganttData == null) {
		continue;
	    }
	    if (id.equals(ganttData.getId())) {
		return ganttEvent;
	    }
	}
	return null;
    }
    
    private void setColor1(GanttEvent ganttEvent) {
	ganttEvent.setStatusColor(ColorCache.getColor(246, 159, 82));
	ganttEvent.setGradientStatusColor(ColorCache.getColor(252, 225, 201));
    }
    
    private void setColor2(GanttEvent ganttEvent) {
	ganttEvent.setStatusColor(ColorCache.getColor(255, 204, 0));
	ganttEvent.setGradientStatusColor(ColorCache.getColor(255, 244, 202));
    }
    
    public void updateForm() throws ApplicationException {
	super.updateForm();
	updateGanttChart();
    }
    
    private class MyGanttEvent extends  GanttEvent {

	private boolean moveMode = true;
	
	public boolean isMoveMode() {
	    return moveMode;
	}

	public void setMoveMode(boolean moveMode) {
	    this.moveMode = moveMode;
	}

	@Override
	public boolean canMove() {
	    return isMoveMode();
	    //return super.canMove();
	}
	
	public MyGanttEvent(GanttChart parent, Object data, String name, Calendar startDate, Calendar endDate, Calendar revisedStart, Calendar revisedEnd, int percentComplete) {
	    super(parent, data, name, startDate, endDate, revisedStart, revisedEnd,
	    	percentComplete);
	}

	public MyGanttEvent(GanttChart parent, Object data, String name, Calendar startDate, Calendar endDate, int percentComplete) {
	    super(parent, data, name, startDate, endDate, percentComplete);
	}

	public MyGanttEvent(GanttChart parent, Object data, String name, Calendar date, Image picture) {
	    super(parent, data, name, date, picture);
	}

	public MyGanttEvent(GanttChart parent, Object data, String name, Calendar date) {
	    super(parent, data, name, date);
	}

	public MyGanttEvent(GanttChart parent, Object data, String name) {
	    super(parent, data, name);
	}
	
    }
    
    // Override
    protected void removeEntityById(Serializable id) throws ApplicationException {
	super.removeEntityById(id);
	removeGanttEventById(id);
    }
    
    
    // Override
    protected void addEntityToView(Object entity) {
	super.addEntityToView(entity);
	createGanttEvent((Task) entity);
    }
    
    // Override
    protected void setEntityToView(Object entity) {
	super.setEntityToView(entity);
	updateGanttEvent((Task) entity);
    }

    public void doInternalFilterAction() throws ApplicationException {
	super.doInternalFilterAction();
	updateGanttChart();
    }
 
    
    /////////////////////////////////////////////////////////////////////////

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

	    IOzCalendarSource[] sources = CalendarSource.getCalendarSources(getTaskService(), parameters);
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
	if (tabFolder.getSelectionIndex() == CALENDAR_ITEM_INDEX) {
	    updateCalendar();
	}
    }

    class ChartSelector implements IEntitySelector {

	public Object getSelectedEntity() {
	    return null;
	}

	public Serializable getSelectedEntityId() {
	    return selectedChartTask == null ? null : selectedChartTask.getId();
	}

	public boolean isSelected() {
	    return selectedChartTask != null;
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
