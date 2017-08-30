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

import org.plazmaforge.bsolution.bank.common.services.BankService;
import org.plazmaforge.bsolution.partner.client.swing.GUIPartnerEnvironment;
import org.plazmaforge.bsolution.partner.client.swing.forms.PartnerEdit;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.client.swing.forms.EXTListForm;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 18.03.2004
 * Time: 10:37:22
 * $Id: PartnerList.java,v 1.3 2010/12/05 07:56:43 ohapon Exp $
 */
public class PartnerList extends EXTListForm {

    public PartnerList() throws ApplicationException {
        super(GUIPartnerEnvironment.getResources());
        initialize();
    }

    public PartnerList(Window window) throws ApplicationException {
        super(window, GUIPartnerEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Partner.class);
        this.setEntityServiceClass(PartnerService.class);
        this.setEntityEditFormClass(PartnerEdit.class);        
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(900, 400);
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
        d.setSize(20);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-name.name"));
        d.setFieldName("name");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-partner-group-name.name"));
        d.setFieldName("partnerGroupName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-phone-string.name"));
        d.setFieldName("phoneString");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);
		
        d = new ColumnProperty();
        d.setName(getString("table.column-address-string.name"));
        d.setFieldName("localityAddressString");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        return columns;
    }

    //private PartnerService getPartnerService() {
    //    return (PartnerService) getEntityService();
    //}

    private BankService bankService;
    
    private BankService getBankService() {
	if (bankService == null) {
	    bankService = (BankService) getSERVICE(BankService.class);
	}
	return bankService;
    }

    protected void delCommand(Object ID) throws ApplicationException {
	Object object = getSelectedObject();
	if (object == null) {
	    super.delCommand(ID);
	    return;
	}
	PartnerHeader partner = (PartnerHeader) object;
	String descriminator = partner.getDescriminator();
	if (descriminator == null) {
	    super.delCommand(ID);
	    return;
	}
	if ("BANK".equals(descriminator.trim())) {
	    getBankService().removeById((Integer) ID);
	} else {
	    super.delCommand(ID);
	}
    }

    //protected void loadData() throws ApplicationException {
    //    refreshTableModel(getPartnerService().findWithoutPartnerId(EnterpriseEnvironment.getOrganizationId()));
    //}

}
