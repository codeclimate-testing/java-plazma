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
 * Created on 14.06.2007
 *
 */

package org.plazmaforge.bsolution.contact.client.swt.forms;



import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.swt.forms.IMyForm;
import org.plazmaforge.bsolution.contact.common.services.ContactService;
import org.plazmaforge.bsolution.organization.client.swt.forms.AbstractResponsableListForm;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: ContactListForm.java,v 1.5 2010/12/05 07:57:22 ohapon Exp $
 */

public class ContactListForm extends AbstractResponsableListForm implements IMyForm, IOwnCriteriaImplementator {

    private PartnerHeader partner; 
  
    private Table table;
    

    
    public ContactListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("ContactListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn contactTypeColumn;
        TableColumn partnerNameColumn;
        TableColumn phoneColumn; 
        TableColumn cityColumn; 
        TableColumn addressColumn; 
        TableColumn responsibleColumn;

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(50);
    	codeColumn.setText(Messages.getString("ContactListForm.codeColumn.text")); //$NON-NLS-1$
    	
    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("ContactListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	contactTypeColumn = new TableColumn(table, SWT.NONE);
    	contactTypeColumn.setWidth(150);
    	contactTypeColumn.setText(Messages.getString("ContactListForm.contactTypeColumn.text")); //$NON-NLS-1$
    	
    	partnerNameColumn = new TableColumn(table, SWT.NONE);
    	partnerNameColumn.setWidth(150);
    	partnerNameColumn.setText(Messages.getString("ContactListForm.partnerColumn.text")); //$NON-NLS-1$
    	
	phoneColumn = new TableColumn(table, SWT.NONE);
    	phoneColumn.setWidth(100);
    	phoneColumn.setText(Messages.getString("ContactListForm.phoneColumn.text")); //$NON-NLS-1$
    	
	cityColumn = new TableColumn(table, SWT.NONE);
    	cityColumn.setWidth(150);
    	cityColumn.setText(Messages.getString("ContactListForm.cityColumn.text")); //$NON-NLS-1$
    	    	
	addressColumn = new TableColumn(table, SWT.NONE);
    	addressColumn.setWidth(250);
    	addressColumn.setText(Messages.getString("ContactListForm.addressColumn.text"));  //$NON-NLS-1$

    	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("ContactListForm.responsibleColumn.text"));  //$NON-NLS-1$
    	
        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");
	bindColumn(2, "name");
	bindColumn(3, "contactTypeName");
	
	bindColumn(4, "partnerName");
	bindColumn(5, "phoneString");
	bindColumn(6, "cityName");	
	bindColumn(7, "localityAddressString");
	bindColumn(8, "responsibleName");
    }
 
    public PartnerHeader getPartner() {
	if (partner == null) {
	    if (getParentEntity() instanceof PartnerHeader) {
		return (PartnerHeader) getParentEntity();
	    }
	}
        return partner;
    }

    public void setPartner(PartnerHeader partner) {
        this.partner = partner;
    }
    
    public Integer getPartnerId() {
	return getPartner() == null ? null : getPartner().getId();
    }
    
    protected ContactService getContactService() {
        return (ContactService) getEntityService();
    }    

    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }

    ////
    
    protected List loadDataList() throws ApplicationException {
	if (isMyFormEmpty()) {
	    return getEmptyDataList();
	}
        return getContactService().findByOrganizationId(getOrganizationId(), getPartnerId(), getResponsibleId());
    }

    protected List loadDataList(Criteria criteria) throws ApplicationException {
	if (isMyFormEmpty()) {
	    return getEmptyDataList();
	}
        return getContactService().findByOrganizationId(getOrganizationId(), getPartnerId(), getResponsibleId(), criteria);
    }

    protected void updateTitle(String title) {
	if (isMyFormMode()) {
	    getDecorator().setTitle(Messages.getString("MyContactListForm.title"));
	    return;
	}
	super.updateTitle(title);
    }
    

 
}  //  @jve:decl-index=0:visual-constraint="10,10"