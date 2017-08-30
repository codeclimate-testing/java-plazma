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
import java.util.List;


import org.eclipse.nebula.widgets.ganttchart.ColorCache;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.IMyForm;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractResponsableListForm;
import org.plazmaforge.bsolution.partner.client.swt.forms.IPartnerableForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.bsolution.project.common.beans.Project;
import org.plazmaforge.bsolution.project.common.services.ProjectService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: ProjectListForm.java,v 1.6 2010/12/05 07:57:20 ohapon Exp $
 */

public class ProjectListForm extends AbstractResponsableListForm implements IMyForm, IPartnerableForm, IOwnCriteriaImplementator {

    private IPartnerTitle partner; 
    
    
    private TabFolder tabFolder;
    
    private Table table;
    
    private GanttChart ganttChart;
    
    
    public ProjectListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("ProjectListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn projectNoColumn;
        TableColumn nameColumn;
        TableColumn partnerColumn;
        TableColumn projectStatusColumn;
        TableColumn startDateColumn;
        TableColumn endDateColumn;
        TableColumn currencyTotalWithTaxColumn;
        TableColumn currencyColumn; 
        TableColumn totalWithTaxColumn;
        TableColumn responsibleColumn;
        

        setLayout(new FillLayout(SWT.VERTICAL));
 
        // Create Tab Folder
    	tabFolder = new TabFolder(this, SWT.NONE);

    	// Create table tab item
    	TabItem tablelTabItem = new TabItem(tabFolder, SWT.NONE);
    	tablelTabItem.setText(Messages.getString("ProjectListForm.table")); //$NON-NLS-1$

    	table = new Table(tabFolder, SWTToolkit.TABLE_STYLE);
    	tablelTabItem.setControl(table);
    	
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	projectNoColumn = new TableColumn(table, SWT.NONE);
    	projectNoColumn.setMoveable(true);
    	projectNoColumn.setWidth(100);
    	projectNoColumn.setText(Messages.getString("ProjectListForm.projectNoColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setMoveable(true);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("ProjectListForm.nameColumn.text")); //$NON-NLS-1$

    	partnerColumn = new TableColumn(table, SWT.NONE);
    	partnerColumn.setMoveable(true);
    	partnerColumn.setWidth(300);
    	partnerColumn.setText(Messages.getString("ProjectListForm.partnerColumn.text")); //$NON-NLS-1$
    	
 	projectStatusColumn = new TableColumn(table, SWT.NONE);
    	projectStatusColumn.setMoveable(true);
    	projectStatusColumn.setWidth(100);
    	projectStatusColumn.setText(Messages.getString("ProjectListForm.projectStatusColumn.text"));   //$NON-NLS-1$

	startDateColumn = new TableColumn(table, SWT.NONE);
    	startDateColumn.setMoveable(true);
    	startDateColumn.setWidth(100);
    	startDateColumn.setText(Messages.getString("ProjectListForm.startDateColumn.text"));     //$NON-NLS-1$
    	
	endDateColumn = new TableColumn(table, SWT.NONE);
    	endDateColumn.setMoveable(true);
    	endDateColumn.setWidth(100);
    	endDateColumn.setText(Messages.getString("ProjectListForm.endDateColumn.text"));        	 //$NON-NLS-1$

    	
    	
        currencyTotalWithTaxColumn = new TableColumn(table, SWT.RIGHT);
        currencyTotalWithTaxColumn.setMoveable(true);
        currencyTotalWithTaxColumn.setWidth(120);
        currencyTotalWithTaxColumn.setText(Messages.getString("ProjectListForm.currencyTotalWithTaxColumn.text"));    	 //$NON-NLS-1$
    	
        currencyColumn = new TableColumn(table, SWT.CENTER);
        currencyColumn.setMoveable(true);
        currencyColumn.setWidth(70);
        currencyColumn.setText(Messages.getString("ProjectListForm.currencyColumn.text")); //$NON-NLS-1$
        
        totalWithTaxColumn = new TableColumn(table, SWT.RIGHT);
        totalWithTaxColumn.setMoveable(true);
        totalWithTaxColumn.setWidth(120);
        totalWithTaxColumn.setText(Messages.getString("ProjectListForm.totalWithTaxColumn.text")); //$NON-NLS-1$

 	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("ProjectListForm.responsibleColumn.text"));  //$NON-NLS-1$
    	

    	// Create Gantt Chart tab item
    	TabItem chartTabItem = new TabItem(tabFolder, SWT.NONE);
    	chartTabItem.setText(Messages.getString("ProjectListForm.ganttChart")); //$NON-NLS-1$

    	ganttChart = new GanttChart(tabFolder, SWT.NONE);
    	chartTabItem.setControl(ganttChart);
    	
    	ganttChart.getGanttComposite();
    	
    	////
      	
        this.setSize(new Point(600, 300));
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "projectNo");
	bindColumn("name");	
	bindColumn("partnerName");
	bindColumn("projectStatusName");
	bindColumn("startDate", getDateFormat());
	bindColumn("endDate", getDateFormat());
	bindColumn("currencyTotalWithTax", getCurrencyFormat());
	bindColumn("currencyName");
	bindColumn("totalWithTax", getCurrencyFormat());
	bindColumn("responsibleName");
    }
 
    public IPartnerTitle getPartner() {
	if (partner == null) {
	    if (getParentEntity() instanceof IPartnerTitle) {
		return (IPartnerTitle) getParentEntity();
	    }
	}
        return partner;
    }

    public void setPartner(IPartnerTitle partner) {
        this.partner = partner;
    }
    
    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }
    
    public Integer getPartnerId() {
	return getPartner() == null ? null : getPartner().getId();
    }
    
    protected ProjectService getProjectService() {
        return (ProjectService) getEntityService();
    }    
    
    ////
    
    protected List loadDataList() throws ApplicationException {
	if (isMyFormEmpty()) {
	    return getEmptyDataList();
	}
        return getProjectService().findByOrganizationId(getOrganizationId(), getPartnerId(), getResponsibleId());
    }
 
    protected List loadDataList(Criteria criteria) throws ApplicationException {
	if (isMyFormEmpty()) {
	    return getEmptyDataList();
	}
        return getProjectService().findByOrganizationId(getOrganizationId(), getPartnerId(), getResponsibleId(), criteria);
    }
    
    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    getDecorator().setTitle(Messages.getString("MyProjectListForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    
    
    ////
    
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
	    Project project = (Project) elements.get(i);
	    GanttEvent projectEvent = createGantEvent(project);
	    if (projectEvent == null) {
		continue;
	    }
	    if (startDate == null || projectEvent.getStartDate().before(startDate)) {
		startDate = projectEvent.getStartDate();
	    }
	    if (i == 0) {
		firstEvent = projectEvent;
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
     * Create GanttEvent by Project
     * @param project
     * @return
     */
    protected GanttEvent createGantEvent(Project project) {
	
	if (project == null) {
	    return null;
	}
	
	Date startDate = project.getStartDate();
	Date endDate = project.getEndDate();
	if (startDate == null || endDate == null) {
	    return null;
	}
	Calendar start = Calendar.getInstance();
	start.setTime(startDate);

	Calendar end = Calendar.getInstance();
	end.setTime(endDate);
	
	MyGanttEvent projectEvent = new MyGanttEvent(ganttChart, project, project.getName(), start, end, 0);
	projectEvent.setMoveMode(false);
	//setColor2(projectEvent);
	
	return projectEvent;
    }

    protected void updateProjectEvent(Project project) {
	
	if (project == null) {
	    return;
	}
	
	GanttEvent projectEvent = findProjectEventById(project.getId());
	
	if (projectEvent == null) {
	    return;
	}
	
	Date startDate = project.getStartDate();
	Date endDate = project.getEndDate();
	if (startDate == null || endDate == null) {
	    return;
	}
	Calendar start = Calendar.getInstance();
	start.setTime(startDate);

	Calendar end = Calendar.getInstance();
	end.setTime(endDate);
	
	projectEvent.setData(project);
	projectEvent.setName(project.getName());
	projectEvent.setStartDate(start);
	projectEvent.setEndDate(end);

    }
    
    protected void deleteProjectEvent(Project project) {
	deleteProjectEventById(project.getId());
    }

    protected void deleteProjectEventById(Serializable id) {
	if (id == null) {
	    return;
	}
	
	GanttEvent projectEvent = findProjectEventById(id);
	
	if (projectEvent == null) {
	    return;
	}
	ganttChart.getGanttComposite().removeEvent(projectEvent);
    }

    protected GanttEvent findProjectEventById(Serializable id) {
	if (id == null) {
	    return null;
	}
	List events = ganttChart.getGanttComposite().getEvents();
	if (events == null || events.size() == 0) {
	    return null;
	}
	for (int i = 0; i < events.size(); i++) {
	    GanttEvent ganttEvent = (GanttEvent) events.get(i);
	    Project project = (Project) ganttEvent.getData();
	    if (project == null) {
		continue;
	    }
	    if (id.equals(project.getId())) {
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
	deleteProjectEventById(id);
    }
    
    
    // Override
    protected void addEntityToView(Object entity) {
	super.addEntityToView(entity);
	createGantEvent((Project) entity);
    }
    
    // Override
    protected void setEntityToView(Object entity) {
	super.setEntityToView(entity);
	updateProjectEvent((Project) entity);
    }
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
