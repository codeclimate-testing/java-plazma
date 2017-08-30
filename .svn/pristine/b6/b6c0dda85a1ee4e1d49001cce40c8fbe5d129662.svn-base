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


import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;

import org.plazmaforge.bsolution.bank.client.swing.GUIBankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.PaymentOutcome;
import org.plazmaforge.bsolution.bank.common.services.PaymentOutcomeService;
import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentList;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.CurrencyCellRenderer;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.Window;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleh Hapon
 * Date: 21.07.2004
 * Time: 9:19:38
 * $Id: PaymentOutcomeList.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 */
public class PaymentOutcomeList extends AbstractDocumentList {

    public PaymentOutcomeList() throws ApplicationException {
        super(GUIBankEnvironment.getResources());
        initialize();
    }

    public PaymentOutcomeList(Window window) throws ApplicationException {
        super(window, GUIBankEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
		
        this.setEntityClass(PaymentOutcome.class);
        this.setEntityServiceClass(PaymentOutcomeService.class);
        this.setEntityEditFormClass(PaymentOutcomeEdit.class);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(950, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {

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
        d.setName(getString("table.column-amount.name"));
        d.setFieldName("currencyEnterTotal");
        d.setColumnClass(Double.class);
        d.setSize(20);
        columns.add(d);


        return columns;
    }

    protected JTable createTable(TableModel model) throws ApplicationException {
        JTable table = super.createTable(model);
        TableColumn column = table.getColumn(getString("table.column-amount.name"));
        column.setCellRenderer(new CurrencyCellRenderer());
        return table;
    }

	
}
