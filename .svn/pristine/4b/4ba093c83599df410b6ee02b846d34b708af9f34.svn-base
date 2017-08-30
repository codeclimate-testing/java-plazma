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
 * Created on 18.06.2005
 *
 */
package org.plazmaforge.framework.client.swing.forms;

import java.awt.Component;
import java.awt.Window;
import java.util.List;

import javax.swing.Action;

import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.FormConfigurer;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IFormConfig;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.report.IReport;


/**
 * 
 * 
 * @author Oleh Hapon
 * 
 */
public class EXTFormWorker {

    private IFORMFactory formFactory = new FORMBaseFactory();

    private ISERVICEFactory serviceFactory = new SERVICEBaseFactory();

    private IACTIONFactory actionFactory = new ACTIONBaseFactory();

    private IREPORTFactory reportFactory = new REPORTBaseFactory();

    private Class entityClass;

    private Class entityServiceClass;

    private Class entityEditFormClass;

    public Form getFORM(Class klass) {
	return formFactory.getFORM(klass);
    }

    public Form getFORM(Class klass, Window window) {
	return formFactory.getFORM(klass, window);
    }

    public EditForm getEDIT(Class klass) {
	return formFactory.getEDIT(klass);
    }

    public EditForm getEDIT(Class klass, Window window) {
	return formFactory.getEDIT(klass, window);
    }

    public ListForm getLIST(Class klass) {
	return formFactory.getLIST(klass);
    }

    public ListForm getLIST(Class klass, Window window) {
	return formFactory.getLIST(klass, window);
    }

    public ListForm getLIST(Class klass, Window window, int listableMode) {
	return formFactory.getLIST(klass, window, listableMode);
    }

    public Object getSERVICE(Class klass) {
	return serviceFactory.getSERVICE(klass);
    }

    public Component getMessageFrame() {
	return SwingEnvironment.getFrame();
    }

    public Class getEntityClass() {
	return entityClass;
    }

    public void setEntityClass(Class entityClass) {
	this.entityClass = entityClass;
    }

    public Class getEntityEditFormClass() {
	return entityEditFormClass;
    }

    public void setEntityEditFormClass(Class entityFormClass) {
	this.entityEditFormClass = entityFormClass;
    }

    public Class getEntityServiceClass() {
	return entityServiceClass;
    }

    public void setEntityServiceClass(Class entityServiceClass) {
	this.entityServiceClass = entityServiceClass;
    }

    public EntityService getEntityService() {
	return (EntityService) getSERVICE(entityServiceClass);
    }

    public IReport getReportById(String id) {
	return (IReport) reportFactory.getReportById(id);
    }

    public ReportAction getReportActionById(String id) {
	return (ReportAction) reportFactory.getReportActionById(id);
    }

    public Action getActionById(String id) {
	return actionFactory.getActionById(id);
    }

    public FormConfigurer getFormConfigurer() {
	return (FormConfigurer) ConfigurerManager.getConfigurer(FormConfigurer.NAME);
    }

    public IFormConfig getFormConfig(IConfigIdentifier configIdentifier) {
	FormConfigurer formConfigurer = getFormConfigurer();
	if (formConfigurer == null) {
	    return null;
	}
	return (IFormConfig) formConfigurer.getObjectById(configIdentifier.getConfigId());
    }

    /**
     * Configure form
     * 
     * @param form
     */
    protected void configure(Form form) {
	IFormConfig formConfig = getFormConfig(form.getConfigIdentifier());
	if (formConfig == null) {
	    return;
	}
	configureReports(form, formConfig);
	configureActions(form, formConfig);
    }

    /**
     * Configure reports
     * 
     * @param form
     * @param formConfig
     */
    protected void configureReports(Form form, IFormConfig formConfig) {
	List reports = formConfig.getReportDescriptors();
	if (reports == null) {
	    return;
	}
	for (int i = 0; i < reports.size(); i++) {
	    IConfigIdentifier idn = (IConfigIdentifier) reports.get(i);
	    form.addReportAction(getReportActionById(idn.getConfigId()));
	}
    }

    /**
     * Configure actions
     * 
     * @param form
     * @param formConfig
     */
    protected void configureActions(Form form, IFormConfig formConfig) {
	List actions = formConfig.getActionDescriptors();
	if (actions == null) {
	    return;
	}
	for (int i = 0; i < actions.size(); i++) {
	    IConfigIdentifier idn = (IConfigIdentifier) actions.get(i);
	    form.addAction(getActionById(idn.getConfigId()));
	}
    }

}
