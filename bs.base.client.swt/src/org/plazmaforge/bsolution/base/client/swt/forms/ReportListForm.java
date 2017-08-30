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
 * Created on 01.04.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.forms;

import java.io.Serializable;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.action.ActionDescriptor;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.client.swt.views.ImageTableCellRenderer;
import org.plazmaforge.framework.config.configurer.ReportConfigurer;
import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.config.object.ReportConfig;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.IReportAction;
import org.plazmaforge.framework.report.IReportEditorProvider;
import org.plazmaforge.framework.report.ReportFactory;
import org.plazmaforge.framework.util.ClassUtilsExt;


/** 
 * @author Oleh Hapon
 * $Id: ReportListForm.java,v 1.6 2010/12/05 07:57:20 ohapon Exp $
 */

public class ReportListForm extends AbstractListForm implements IOwnCriteriaImplementator  {
    
    private Table table;
    
    private IReportEditorProvider editorProvider;
    
    
    public ReportListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	
	setEntityClass(ReportConfig.class);
	setEntityEditFormClass(ReportEditForm.class);
	
        //setReadOnly(true);
       setDataSourceSupport(false);

        
	setTitle(Messages.getString("ReportListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        TableColumn nameColumn;
        TableColumn captionColumn;
        TableColumn pathColumn;
        TableColumn independentColumn;
        TableColumn customColumn; 

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("ReportListForm.nameColumn.text")); //$NON-NLS-1$

    	captionColumn = new TableColumn(table, SWT.NONE);
    	captionColumn.setWidth(200);
    	captionColumn.setText(Messages.getString("ReportListForm.captionColumn.text")); //$NON-NLS-1$
    	
   	pathColumn = new TableColumn(table, SWT.NONE);
    	pathColumn.setWidth(150);
    	pathColumn.setText(Messages.getString("ReportListForm.pathColumn.text")); //$NON-NLS-1$
    	
    	independentColumn = new TableColumn(table, SWT.CENTER);
    	independentColumn.setWidth(100);
    	independentColumn.setText(Messages.getString("ReportListForm.independentColumn.text")); //$NON-NLS-1$
	
	customColumn = new TableColumn(table, SWT.CENTER);
	customColumn.setWidth(100);
	customColumn.setText(Messages.getString("ReportListForm.customColumn.text")); //$NON-NLS-1$

	table.setSortColumn(independentColumn);
	table.setSortDirection(SWT.UP);
	
        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "name");	
	bindColumn(2, "caption");
	bindColumn(3, "path");
	bindColumn(4, "independent");
	bindColumn(5, "custom");
	
        addCellRenderer(4, new ImageTableCellRenderer());
        addCellRenderer(5, new ImageTableCellRenderer());
    }
 
    private List getReportList() {
    	//return ReportFactory.getReportConfigsBySingle(false);
    	return ReportFactory.getReportConfigs();
    }
    
    protected IReportConfig getSelectedReportConfig()  {
	return (IReportConfig) getSelectedEntity();
    }
    
    protected void executeReport() throws ApplicationException {
    	IReportConfig reportConfig = getSelectedReportConfig();
    	if (reportConfig == null) {
    	    return;
    	}
 	
    	if (!reportConfig.isIndependent()) {
    	    openWarningDialog("Warning", Messages.getString("ReportListForm.execute.report.warning"));
    	    return;
    	}
    	
    	//if (config.isSingle()) {
    	//	return;
    	//}
    	
    	IReportAction action = ReportFactory.getReportAction(reportConfig);
    	if (action == null) {
    		return;
    	}
    	action.execute();
    }
    
    protected List loadDataList() throws ApplicationException {
	return getReportList();
    }
    
    public void doLoadEntity() throws ApplicationException {
	super.doLoadEntity();
	doRefreshAction();
    }
    
    public void doPrintAction() throws ApplicationException  {
	executeReport();
    }
    
    public void doEnterAction() throws ApplicationException  {
	executeReport();
    }        
    
    protected ReportConfigurer getReportConfigurer() {
	return (ReportConfigurer) ReportFactory.getInstance().getConfigurer();
    }
    
    public void doRemoveRow() throws ApplicationException {
	super.doRemoveRow();
	doRefreshAction();
    }
    
    protected void removeEntity() throws ApplicationException {
	IReportConfig reportConfig = getSelectedReportConfig();
	getReportConfigurer().removeObject(reportConfig);
	getReportConfigurer().storeObjects();
    }
    
    protected Object loadEntityById(Serializable id) throws ApplicationException {
	if (id == null) {
	    return null;
	}
	return getReportConfigurer().getObjectById((String) id);
    }
    
    /////
    protected boolean isSupportEntityDelMode(Object entity) {
	if (entity == null) {
	    return false;
	}
	IReportConfig reportConfig = (IReportConfig) entity;
	if (!reportConfig.isCustom()) {
	    openWarningDialog("Title", "Can't delete report. Report isn't custom.");
	    return false;
	}
	return true;
    }
    
    protected boolean isSupportEntityEditMode(Object entity) {
	if (entity == null) {
	    return false;
	}
	/*
	DefaultReportConfig reportConfig = (DefaultReportConfig) entity;
	if (!reportConfig.isCustom()) {
	    openWarningDialog("Title", "Can't edit report. Report isn't custom.");
	    return false;
	}
	*/
	return true;
    }
    
    protected boolean isSupportReportEditor() {
	if (editorProvider != null) {
	    return true;
	}
	String providerClassName = PlatformEnvironment.getProperty(IReportEditorProvider.PROPERTY_NAME);
	if (isEmpty(providerClassName)) {
	    return false;
	}
	try {
	    editorProvider = (IReportEditorProvider) ClassUtilsExt.getClassInstance(providerClassName);
	    return true;
	} catch (Throwable ex) {
	    logger.error(ex);
	}
	
	return false;
    }

    public void init() throws ApplicationException {
	initReportEditorAction();
	super.init();
    }
    
    protected void initReportEditorAction() {
	if (!isSupportReportEditor()) {
	    return;
	}
	ReportEditorAction action = new ReportEditorAction();
	action.setName("Report Editor");
	action.setImageUrl("/org/plazmaforge/framework/client/images/fw/page_white_h.png");
	
	ActionDescriptor actionDescriptor = new ActionDescriptor(); 
	actionDescriptor.setAction(action);
	actionDescriptor.setControlType("item");
	
	actionDescriptor.setControlPosition("after");
	actionDescriptor.setControlRelative(EDIT_ACTION);
	
	addActionDescriptor(actionDescriptor);
    }
    
    private class ReportEditorAction extends DefaultAction {
	public void execute() throws ApplicationException {
	    if (editorProvider == null) {
		openMessageDialog("Report Editor is not set");
		return;
	    }
	    
	    IReportConfig reportConfig = getSelectedReportConfig();
	    if (reportConfig == null) {
		return;
	    }
	    IReport report = ReportFactory.getReportByConfig(reportConfig);
	    if (report == null) {
		return;
	    }
	    editorProvider.openReportEditor(report);
	}
    }
    
   
 
}  //  @jve:decl-index=0:visual-constraint="10,10"
