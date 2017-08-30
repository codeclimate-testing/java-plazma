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
 * Created on 25.02.2004
 *
 */
package org.plazmaforge.framework.client.swing.forms;

import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.ReportAction;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.service.EntityService;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.ReportProcessor;
import org.plazmaforge.framework.resources.Resources;


import java.awt.Component;
import java.awt.Window;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Oleh Hapon $Id: EXTListForm.java,v 1.5 2010/12/05 07:52:08 ohapon Exp $
 * 
 * Enterprise ListForm
 * 
 */
public abstract class EXTListForm extends ListForm implements IFORMFactory,
	ISERVICEFactory {

    public static final int DEFAULT_CODE_COLUMN_WIDTH = 10;

    public static final int DEFAULT_DATE_COLUMN_WIDTH = 15;

    public static final int DEFAULT_SHORT_NAME_COLUMN_WIDTH = 30;

    public static final int DEFAULT_LONG_NAME_COLUMN_WIDTH = 50;

    public static final int DEFAULT_USER_NAME_COLUMN_WIDTH = 30;

    public static final int DEFAULT_CURRENCY_CHAR_COLUMN_WIDTH = 5;

    public static final int DEFAULT_AMOUNT_COLUMN_WIDTH = 20;

    private final EXTFormWorker formWoker = new EXTFormWorker();

    public EXTListForm() {
	super(SwingEnvironment.getDesktopPane());
    }

    public EXTListForm(JDesktopPane desktop, Resources resources) {
	super(desktop, resources);
    }

    public EXTListForm(Resources resources) {
	super(SwingEnvironment.getDesktopPane(), resources);
    }

    public EXTListForm(JDesktopPane jDesktopPane, String s) {
	super(jDesktopPane, s);
    }

    public EXTListForm(String s) {
	super(SwingEnvironment.getDesktopPane(), s);
    }

    public EXTListForm(Window window, Resources resources) {
	super(window, resources);
    }

    protected JTable createTable() throws ApplicationException {
	JTable table = super.createTable();
	GUIUtilities.prepareColumn(table);
	return table;
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Form segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public Form getFORM(Class klass) {
	return formWoker.getFORM(klass);
    }

    public Form getFORM(Class klass, Window window) {
	return formWoker.getFORM(klass, window);
    }

    public EditForm getEDIT(Class klass) {
	return formWoker.getEDIT(klass);
    }

    public EditForm getEDIT(Class klass, Window window) {
	return formWoker.getEDIT(klass, window);
    }

    public ListForm getLIST(Class klass) {
	return formWoker.getLIST(klass);
    }

    public ListForm getLIST(Class klass, Window window) {
	return formWoker.getLIST(klass, window);
    }

    public ListForm getLIST(Class klass, Window window, int listableMode) {
	return formWoker.getLIST(klass, window, listableMode);
    }

    public Object getSERVICE(Class klass) {
	return formWoker.getSERVICE(klass);
    }

    public Component getMessageFrame() {
	return formWoker.getMessageFrame();
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Entity segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public Class getEntityClass() {
	return formWoker.getEntityClass();
    }

    public void setEntityClass(Class entityClass) {
	formWoker.setEntityClass(entityClass);
    }

    public Class getEntityEditFormClass() {
	return formWoker.getEntityEditFormClass();
    }

    public void setEntityEditFormClass(Class entityEditFormClass) {
	formWoker.setEntityEditFormClass(entityEditFormClass);
    }

    public Class getEntityServiceClass() {
	return formWoker.getEntityServiceClass();
    }

    public void setEntityServiceClass(Class entityServiceClass) {
	formWoker.setEntityServiceClass(entityServiceClass);
    }

    public EntityService getEntityService() {
	return formWoker.getEntityService();
    }

    protected void loadData() throws ApplicationException {
	refreshTableModel(this.getEntityService().findAll());
    }

    // TYPE POINT
    protected Object findObject(Object ID) throws ApplicationException {
	if (ID == null)
	    return null;
	// return this.getEntityService().findHeaderById(((Integer)ID));
	return this.getEntityService().findHeaderById((Serializable) ID);
    }

    protected EditForm getEditForm() throws ApplicationException {
	return getEDIT(this.getEntityEditFormClass());
    }

    // TYPE POINT
    protected void delCommand(Object ID) throws ApplicationException {
	// getEntityService().removeById(((Integer)ID));
	getEntityService().removeById((Serializable) ID);
    }

    protected TableModel createTableModel() throws ApplicationException {
	return createObjectTableModel(this.getEntityClass(),
		createTableColumnProperties());
    }

    protected java.util.List<ColumnProperty> createTableColumnProperties()
	    throws ApplicationException {
	return new ArrayList<ColumnProperty>();
    }

    protected boolean isSupportReportAction(ReportAction action) {
	IReport report = action.getReport();
	return (report != null && ReportProcessor.isSupported(report));
    }

    protected class ListEntityType extends EXTAbstractEntityType {

	public EntityService getEntityService() {
	    return (EntityService) getSERVICE(getEntityServiceClass());
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEDIT(getEntityEditFormClass());
	}

	// TYPE POINT
	public void delCommand(Object ID) throws ApplicationException {
	    // getEntityService().removeEntityById(((Integer) ID));
	    getEntityService().removeById((Serializable) ID);
	}

	// TYPE POINT
	public Object findObject(Object ID) throws ApplicationException {
	    // return getEntityService().findHeaderById(((Integer) ID));
	    return getEntityService().findHeaderById((Serializable) ID);
	}
    }

    protected ListEntityType createListEntityType(String entityTypeCode) {
	ListEntityType listEntityType = new ListEntityType();
	Association association = getAssociation(entityTypeCode);
	listEntityType.setEntityEditFormClass(association
		.getElementByType(EditForm.class));
	listEntityType.setEntityServiceClass(association
		.getElementByType(Service.class));
	return listEntityType;
    }

    protected void registerEntityType(String entityTypeCode) {
	this.registerEntityType(entityTypeCode,
		createListEntityType(entityTypeCode));
    }

    protected Association getAssociation(String id) {
	return AssociationManager.getAssociation(id);
    }

    protected EntityType getInnerEntityType(Object entityTypeCode) {
	EntityType type = super.getInnerEntityType(entityTypeCode);
	if (type == null) {
	    type = createListEntityType((String) entityTypeCode);
	    registerEntityType((String) entityTypeCode, type);
	}
	return type;
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Report segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    protected IReport getReportById(String id) {
	return formWoker.getReportById(id);
    }

    protected ReportAction getReportActionById(String id) {
	return formWoker.getReportActionById(id);
    }


    // ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Configure segment
    //
    // ///////////////////////////////////////////////////////////////////////////////////////////////////////

    protected void configure() {
	formWoker.configure(this);
    }

}
