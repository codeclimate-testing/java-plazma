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

package org.plazmaforge.bsolution.bank.client.swing.forms;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.bank.client.swing.GUIBankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.JournalPayment;
import org.plazmaforge.bsolution.bank.common.beans.PaymentIncome;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.bank.common.services.JournalPaymentService;
import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.framework.client.swing.forms.EntityType;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.EntityEnvironment;


/**
 * @author Oleh Hapon
 * 
 * $Id: PaymentList.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 * 
 */

public class PaymentList extends AbstractDocumentList {

    public PaymentList() throws ApplicationException {
	super(GUIBankEnvironment.getResources());
	initialize();
    }

    public PaymentList(Window window) throws ApplicationException {
	super(window, GUIBankEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	setEntityServiceClass(JournalPaymentService.class);

	registerEntityType(PaymentIncome.CLASS_ID);
	registerEntityType(PaymentOutcome.CLASS_ID);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(850, DEFAULT_HEIGHT);
    }

    protected TableModel createTableModel() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-code.name"));
	d.setFieldName("code");
	d.setColumnClass(String.class);
	d.setSize(20);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-date.name"));
	d.setFieldName("date");
	d.setColumnClass(Date.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-account-no.name"));
	d.setFieldName("bankAccountNo");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-partner.name"));
	d.setFieldName("partnerName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-payment-missing.name"));
	d.setFieldName("paymentMissing");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-debit-amount.name"));
	d.setFieldName("debitAmount");
	d.setColumnClass(Double.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-credit-amount.name"));
	d.setFieldName("creditAmount");
	d.setColumnClass(Double.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-document-type-name.name"));
	d.setFieldName("documentTypeName");
	d.setColumnClass(String.class);
	d.setSize(50);
	columns.add(d);

	return createObjectTableModel(JournalPayment.class, columns);
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
	JTable table = super.createTable(model);
	CurrencyCellRenderer currencyRenderer = new CurrencyCellRenderer();
	TableColumn column = table.getColumn(getString("table.column-debit-amount.name"));
	column.setCellRenderer(currencyRenderer);

	column = table.getColumn(getString("table.column-credit-amount.name"));
	column.setCellRenderer(currencyRenderer);

	return table;
    }

    private JournalPayment getSelectedDocument() {
	return (JournalPayment) getSelectedObject();
    }

    /** EntityType */
    protected void delCommand(Object ID) throws ApplicationException {
	getEntityType().delCommand(ID);
    }

    /**
     * Get selected EntityType
     */
    protected EntityType getEntityType() {
	JournalPayment document = getSelectedDocument();
	if (document == null) {
	    return getNULLEntityType();
	}
	String typeCode = document.getDocumentTypeCode();
	if (typeCode == null) {
	    return null;
	}
	return getEntityType(typeCode);
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
