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

package org.plazmaforge.bsolution.partner.client.swt.forms;

import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.partner.common.beans.PartnerGroup;
import org.plazmaforge.bsolution.partner.common.services.PartnerGroupService;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
//import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.RegionMessages;

/** 
 * @author Oleh Hapon
 * $Id: PartnerListForm.java,v 1.6 2010/12/05 07:57:19 ohapon Exp $
 */

public class PartnerListForm extends AbstractListForm implements IOwnCriteriaImplementator {

    
    public final int VIEW_ALL = 0;
    
    public final int VIEW_ONLY_PARTNERS = 1;
    
    public final int VIEW_ONLY_PARTNERS_WITHOUT_CURRENT = 2;
    
    
    
    
    private int partnerViewMode = VIEW_ONLY_PARTNERS_WITHOUT_CURRENT;  
    
    
    private Tree tree;
    
    private Table table;
    

    
    public PartnerListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("PartnerListForm.title")); //$NON-NLS-1$
	
	// TREE: partner group
	setTreeEntityClass(PartnerGroup.class);
	setTreeServiceClass(PartnerGroupService.class);
	setTreeItemRefIdProperty("partnerGroupId");
	    
	    
	    
        TableColumn tableColumn;
        TableColumn codeColumn;
        TableColumn nameColumn;
        TableColumn necColumn;
        TableColumn partnerGroupColumn;
        TableColumn phoneStringColumn;
        TableColumn cityColumn;
        TableColumn localityAddressColumn;
        TableColumn responsibleColumn;

        setLayout(new FillLayout());
 
        
        SashForm sashForm = new SashForm(this, SWT.NONE);
	
	// Create Group Tree 
        tree = new Tree(sashForm, SWT.BORDER);
    	

    	table = new Table(sashForm, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(50);
    	codeColumn.setText(Messages.getString("PartnerListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("PartnerListForm.nameColumn.text")); //$NON-NLS-1$

    	necColumn = new TableColumn(table, SWT.NONE);
    	necColumn.setWidth(100);
    	necColumn.setText(RegionMessages.getString(RegionMessages.NEC_KEY)); //$NON-NLS-1$

	partnerGroupColumn = new TableColumn(table, SWT.NONE);
    	partnerGroupColumn.setWidth(200);
    	partnerGroupColumn.setText(Messages.getString("PartnerListForm.partnerGroupColumn.text")); //$NON-NLS-1$
    	
    	phoneStringColumn = new TableColumn(table, SWT.NONE);
    	phoneStringColumn.setWidth(100);
    	phoneStringColumn.setText(Messages.getString("PartnerListForm.phoneStringColumn.text"));        	 //$NON-NLS-1$
    	
	cityColumn = new TableColumn(table, SWT.NONE);
    	cityColumn.setWidth(150);
    	cityColumn.setText(Messages.getString("PartnerListForm.cityColumn.text")); //$NON-NLS-1$
    	    	
	localityAddressColumn = new TableColumn(table, SWT.NONE);
    	localityAddressColumn.setWidth(250);
    	localityAddressColumn.setText(Messages.getString("PartnerListForm.localityAddressColumn.text")); //$NON-NLS-1$
    	
    	responsibleColumn = new TableColumn(table, SWT.NONE);
    	responsibleColumn.setWidth(200);
    	responsibleColumn.setText(Messages.getString("PartnerListForm.responsibleColumn.text"));  //$NON-NLS-1$	   	
    	
    	sashForm.setWeights(new int[] {1, 5 });
    	

        this.setSize(new Point(700, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {

	bindColumn(1, "code");	
	bindColumn(2, "name");
	bindColumn(3, "nec");
	bindColumn(4, "partnerGroupName");

	bindColumn(5, "phoneString");
	bindColumn(6, "cityName");	
	bindColumn(7, "localityAddressString");
	bindColumn(8, "responsibleName");

    }
 
    private PartnerService getPartnerService() {
	return ((PartnerService) getEntityService());
    }
    
    protected List loadDataList() throws ApplicationException {
	PartnerService service = getPartnerService();
	
	if (partnerViewMode == VIEW_ALL) {
	    return service.findAll();
	} else if (partnerViewMode == VIEW_ONLY_PARTNERS) {
	    return service.findOnlyPartners();
	} else if (partnerViewMode == VIEW_ONLY_PARTNERS_WITHOUT_CURRENT) {
	    return service.findWithoutPartnerId(getOrganizationId());
	} else  {
	    return service.findAll();
	}
    }
    
    
    protected List loadDataList(Criteria criteria) throws ApplicationException {
	PartnerService service = getPartnerService();
	
	if (partnerViewMode == VIEW_ALL) {
	    return service.findByCriteria(criteria);
	} else if (partnerViewMode == VIEW_ONLY_PARTNERS) {
	    return service.findOnlyPartners(criteria);
	} else if (partnerViewMode == VIEW_ONLY_PARTNERS_WITHOUT_CURRENT) {
	    return service.findWithoutPartnerId(getOrganizationId(), criteria);
	} else  {
	    return service.findByCriteria(criteria);
	}
    }

    
    
    
    protected Integer getOrganizationId() {
	return EnterpriseEnvironment.getOrganizationId(SessionEnvironment.getContext());
    }
    
    
    ////
    
    public Tree getTree() {
	return tree;
    }

   

    public int getPartnerViewMode() {
        return partnerViewMode;
    }


    public void setPartnerViewMode(int partnerViewMode) {
        this.partnerViewMode = partnerViewMode;
    }

    
 
}  //  @jve:decl-index=0:visual-constraint="10,10"
