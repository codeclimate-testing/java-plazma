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
package org.plazmaforge.bsolution.document.client.swing.forms;

import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.bank.common.beans.PaymentIncome;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.cash.common.beans.CashIncome;
import org.plazmaforge.bsolution.cash.common.beans.CashOutcome;
import org.plazmaforge.bsolution.document.client.swing.GUIDocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.JournalDocument;
import org.plazmaforge.bsolution.document.common.services.JournalDocumentService;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeDischarge;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeReception;
import org.plazmaforge.bsolution.finance.common.beans.Contract;
import org.plazmaforge.bsolution.goods.common.beans.GoodsIncome;
import org.plazmaforge.bsolution.goods.common.beans.GoodsOutcome;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryMove;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryRest;
import org.plazmaforge.bsolution.inventory.common.beans.InventoryWriteoff;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeSicklist;
import org.plazmaforge.bsolution.payroll.common.beans.EmployeeVacation;
import org.plazmaforge.bsolution.sale.common.beans.SaleInvoice;
import org.plazmaforge.framework.client.swing.forms.EntityType;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Oleh Hapon Date: 26.12.2004 Time: 9:29:07 
 * $Id: DocumentList.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class DocumentList extends AbstractDocumentList {

    public DocumentList() throws ApplicationException {
	super(GUIDocumentEnvironment.getResources());
	initialize();
    }

    public DocumentList(Window window) throws ApplicationException {
	super(window, GUIDocumentEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	setEntityServiceClass(JournalDocumentService.class);

	registerEntityType(InventoryRest.CLASS_ID);
	registerEntityType(GoodsOutcome.CLASS_ID);
	registerEntityType(GoodsIncome.CLASS_ID);
	registerEntityType(InventoryMove.CLASS_ID);
	registerEntityType(InventoryWriteoff.CLASS_ID);
	registerEntityType(PaymentIncome.CLASS_ID);
	registerEntityType(PaymentOutcome.CLASS_ID);
	registerEntityType(EmployeeReception.CLASS_ID);
	registerEntityType(EmployeeDischarge.CLASS_ID);
	registerEntityType(EmployeeVacation.CLASS_ID);
	registerEntityType(EmployeeSicklist.CLASS_ID);

	registerEntityType(SaleInvoice.CLASS_ID);
	registerEntityType(Contract.CLASS_ID);

	registerEntityType(CashIncome.CLASS_ID);
	registerEntityType(CashOutcome.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(750, DEFAULT_HEIGHT);
    }

    protected TableModel createTableModel() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(10);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-date.name"));
	d.setFieldName("date");
	d.setColumnClass(Date.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-document-type-name.name"));
	d.setFieldName("documentTypeName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	/*
         * d = new ColumnProperty();
         * d.setName(getString("table.column-reason.name"));
         * d.setFieldName("reason"); d.setColumnClass(String.class);
         * d.setSize(30); columns.add(d);
         */

	d = new ColumnProperty();
	d.setName(getString("table.column-user-name.name"));
	d.setFieldName("userName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return createObjectTableModel(JournalDocument.class, columns);
    }

    // private JournalDocumentService getDocumentService() {
    // return (JournalDocumentService)
        // getSERVICE(JournalDocumentService.class);
    // }

    // protected void loadData() throws ApplicationException {
    // refreshTableModel(getDocumentService().findByOrganizationIdAndPeriodId(
    // EnterpriseEnvironment.getOrganizationId(),
    // EnterpriseEnvironment.getPeriodId()));
    // }

    // NEW
        // ---------------------------------------------------------------------

    private JournalDocument getSelectedDocument() {
	return (JournalDocument) getSelectedObject();
    }

    /** EntityType */
    protected void delCommand(Object ID) throws ApplicationException {
	getEntityType().delCommand(ID);
    }

    /**
     * Get selected EntityType
     */
    protected EntityType getEntityType() {
	JournalDocument document = getSelectedDocument();
	if (document == null) {
	    return getNULLEntityType();
	}
	return getEntityType(document.getDocumentType().getEntity().getCode());
    }

    // TODO: You must up method
    protected Object getEntityView(Object entityCode) {
	return EntityEnvironment.getEntityById((String) entityCode);
    }

    // TODO: You must up method
    protected EntityType getDialogEntityType(Object selectedValue) {
	return getEntityType(((EntityConfig) selectedValue).getCode());
    }

}
