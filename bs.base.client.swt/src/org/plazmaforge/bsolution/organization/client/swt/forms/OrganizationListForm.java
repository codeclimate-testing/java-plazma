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

package org.plazmaforge.bsolution.organization.client.swt.forms;



import java.io.Serializable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.client.SWTClientApplicationManager;
import org.plazmaforge.bsolution.organization.common.beans.OrganizationHeader;
import org.plazmaforge.bsolution.organization.common.services.OrganizationService;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerEditForm;
import org.plazmaforge.bsolution.partner.client.swt.forms.PartnerListForm;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.models.FormAdapter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

/** 
 * @author Oleh Hapon
 * $Id: OrganizationListForm.java,v 1.7 2010/12/05 07:57:22 ohapon Exp $
 */

public class OrganizationListForm extends AbstractListForm {

    private Table table;
    

    
    public OrganizationListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("OrganizationListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;        

        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(50);
    	codeColumn.setText(Messages.getString("OrganizationListForm.codeColumn.text")); //$NON-NLS-1$
    	
    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("OrganizationListForm.nameColumn.text")); //$NON-NLS-1$
    	

        this.setSize(new Point(600, 300));
        
        this.setEntityClass(OrganizationHeader.class);
        this.setEntityServiceClass(OrganizationService.class);
        this.setEntityEditFormClass(PartnerEditForm.class);
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");
	bindColumn(2, "name");
    }
    
    protected OrganizationService getOrganizationService() {
	return ((OrganizationService) getEntityService()); 
    }
    
    
    public void doAddAction() throws ApplicationException {
	IListForm listForm = getChooseListForm(PartnerListForm.class, new PartnerFormListener());
	Toolkit.openForm(null, listForm);
    }
    
    private class PartnerFormListener extends FormAdapter {
	
	public void updateForm(FormEvent event) throws ApplicationException {
	    Object entity = event.getForm().getEntity();
	    if (entity == null) {
		return;
	    }

	    PartnerHeader partner = (PartnerHeader) entity;
	    Integer id = partner.getId();
	    getOrganizationService().addOrganizationToSystem(id);

	    setEntityId(event.getForm().getEntityId());
	    setMode(PWT.ADD_MODE);

	    doLoadEntity();
	}
    }

    protected void updateByEditForm() throws ApplicationException {
	IEditForm editForm = getEditForm();
	if (editForm == null) {
	    return;
	}
	if (editForm.isModify() && editForm.isEditMode()) {
	    reloadOrganization((Partner) editForm.getEntity());
	}
	super.updateByEditForm();
    }
 
    protected void reloadOrganization(Partner partner) throws ApplicationException {
    	// organizationId = partnerId
    	Integer organizationId = partner == null ? null : partner.getId();
    	if (organizationId == null) {
    	    return;
    	}
    	SWTClientApplicationManager manager = new SWTClientApplicationManager();
    	manager.reloadOrganization(organizationId);
    }
    
    protected void removeEntityById(Serializable id) throws ApplicationException {
	getOrganizationService().removeOrganizationFromSystem((Integer) id);
    }

 
}  //  @jve:decl-index=0:visual-constraint="10,10"