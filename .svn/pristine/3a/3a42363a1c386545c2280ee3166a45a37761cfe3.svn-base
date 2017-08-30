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
 * Created on 28.02.2004
 *
 */
package org.plazmaforge.framework.client.swing.forms;

import java.awt.Component;
import java.awt.Window;
import java.io.Serializable;

import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.IEntityObject;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.resources.Resources;


/**
 * @author Oleh Hapon $Id: EXTEditForm.java,v 1.3 2010/12/05 07:52:08 ohapon Exp $
 */
public abstract class EXTEditForm extends EditForm implements IFORMFactory,
	ISERVICEFactory {

    /**
     * Unique entity code
     */
    private String entityCode;

    /**
     * <code>FormWorker</code> for release form and service factory
     */
    private final EXTFormWorker formWorker = new EXTFormWorker();

    public EXTEditForm(Resources resources) {
	super(SwingEnvironment.getFrame(), resources);
    }

    public EXTEditForm() {
	super(SwingEnvironment.getFrame());
    }

    protected void initAll() throws ApplicationException {
	super.initAll();
	getDialog().setResizable(false);
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Form segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public Form getFORM(Class klass) {
	return formWorker.getFORM(klass);
    }

    public Form getFORM(Class klass, Window window) {
	return formWorker.getFORM(klass, window);
    }

    public EditForm getEDIT(Class klass) {
	return formWorker.getEDIT(klass);
    }

    public EditForm getEDIT(Class klass, Window window) {
	return formWorker.getEDIT(klass, window);
    }

    public ListForm getLIST(Class klass) {
	return formWorker.getLIST(klass);
    }

    public ListForm getLIST(Class klass, Window window) {
	return formWorker.getLIST(klass, window);
    }

    public ListForm getLIST(Class klass, Window window, int listableMode) {
	return formWorker.getLIST(klass, window, listableMode);
    }

    public Object getSERVICE(Class klass) {
	return formWorker.getSERVICE(klass);
    }

    public Component getMessageFrame() {
	return formWorker.getMessageFrame();
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Entity segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public Class getEntityClass() {
	return formWorker.getEntityClass();
    }

    public void setEntityClass(Class entityClass) {
	formWorker.setEntityClass(entityClass);
    }

    public Class getEntityServiceClass() {
	return formWorker.getEntityServiceClass();
    }

    public void setEntityServiceClass(Class entityServiceClass) {
	formWorker.setEntityServiceClass(entityServiceClass);
    }

    public EntityService getEntityService() {
	return formWorker.getEntityService();
    }

    protected IEntityObject getEntityBean() {
	return (IEntityObject) getEntity();
    }

    public String getEntityCode() {
	return entityCode;
    }

    public void setEntityCode(String entityCode) {
	this.entityCode = entityCode;
    }

    /**
     * Initialize entity
     */
    protected void initData() throws ApplicationException {
	try {
	    setEntityId(null);
	    setEntity(this.getEntityClass().newInstance());
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
    }

    /**
     * Load entity by ID
     */
    // TYPE POINT
    protected void loadData(Object value) throws ApplicationException {
	// Integer id = (Integer) value;
	Serializable id = (Serializable) value;
	setEntityId(id);
	// setEntity(getEntityService().findEntityById(id));
	setEntity(getEntityService().findById(id));
    }

    /**
     * Create entity
     */
    // TYPE POINT
    protected Object createData() throws ApplicationException {
	// return getEntityService().createEntity(getEntity());
	return getEntityService().create(getEntity());
    }

    /**
     * Store entity
     */
    // TYPE POINT
    protected void storeData() throws ApplicationException {
	// getEntityService().storeEntity(getEntity());
	getEntityService().store(getEntity());
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Report segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    protected IReport getReportById(String id) {
	return formWorker.getReportById(id);
    }

    protected ReportAction getReportActionById(String id) {
	return formWorker.getReportActionById(id);
    }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Configure segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    protected void configure() {
	formWorker.configure(this);
    }

}
