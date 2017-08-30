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
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.bank.client.swing.GUIBankEnvironment;
import org.plazmaforge.bsolution.bank.common.beans.Bank;
import org.plazmaforge.bsolution.bank.common.services.BankService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 13.07.2004
 * Time: 9:23:49
 * $Id: BankList.java,v 1.3 2010/12/05 07:56:46 ohapon Exp $
 */
public class BankList extends EXTListForm {

    public BankList() throws ApplicationException {
        super(GUIBankEnvironment.getResources());
        initialize();
    }

    public BankList(Window window) throws ApplicationException {
        super(window, GUIBankEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Bank.class);
        this.setEntityServiceClass(BankService.class);
        this.setEntityEditFormClass(BankEdit.class);
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(650, 400);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-code.name"));
        d.setFieldName("code");
        d.setColumnClass(String.class);
        d.setSize(10);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-name.name"));
        d.setFieldName("name");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-bank-swift-code.name"));
        d.setFieldName("bankSwiftCode");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-correspondent-account.name"));
        d.setFieldName("correspondentAccount");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        return columns;
    }


    
}
