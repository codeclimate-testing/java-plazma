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
package org.plazmaforge.bsolution.partner.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.bank.common.services.BankAccountService;
import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 15.07.2004
 * Time: 9:28:57
 * $Id: PartnerBankAccountList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerBankAccountList extends AbstractPartnerableList {

    private Integer defBankAccountId;

    public PartnerBankAccountList() throws ApplicationException {
	super(GUIPartnerEnvironment.getResources());
	initialize();
    }

    public PartnerBankAccountList(Window window) throws ApplicationException {
	super(window, GUIPartnerEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(BankAccount.class);
	this.setEntityServiceClass(BankAccountService.class);
	this.setEntityEditFormClass(PartnerBankAccountEdit.class);
    }

    protected void initComponents() throws ApplicationException {
	super.initComponents();
	setTitle(getString("title"));
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(500, DEFAULT_HEIGHT);
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(getString("table.column-name.name"));
	d.setFieldName("name");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-bank-name.name"));
	d.setFieldName("bankName");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table.column-account-no.name"));
	d.setFieldName("accountNo");
	d.setColumnClass(String.class);
	d.setSize(30);
	columns.add(d);

	return columns;
    }

    public void setDefBankAccountId(Integer defBankAccountId) {
	this.defBankAccountId = defBankAccountId;
    }

    public Integer getDefBankAccountId() {
	return defBankAccountId;
    }

    protected EditForm getEditForm() throws ApplicationException {
	EditForm form = super.getEditForm();
	((PartnerBankAccountEdit) form).setDefBankAccountId(this.getDefBankAccountId());
	return form;
    }

    protected void afterEditForm(EditForm editForm) throws ApplicationException {
	setDefBankAccountId(((PartnerBankAccountEdit) editForm).getDefBankAccountId());
    }
}
