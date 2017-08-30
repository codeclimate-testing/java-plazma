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
 * Created on 02.04.2007
 *
 */

package org.plazmaforge.bsolution.finance.client.swt.forms;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.employee.common.beans.Employee;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.platform.EntityEnvironment;


/** 
 * @author Oleh Hapon
 * $Id: ContractorListForm.java,v 1.2 2010/04/28 06:31:06 ohapon Exp $
 */

public class ContractorListForm extends AbstractListForm {

    private Table table;
    

    
    
    public ContractorListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("ContractorListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn fullNameColumn;
        TableColumn entityNameColumn;

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	fullNameColumn = new TableColumn(table, SWT.NONE);
    	fullNameColumn.setMoveable(true);
    	fullNameColumn.setWidth(300);
    	fullNameColumn.setText(Messages.getString("ContractorListForm.fullNameColumn.text")); //$NON-NLS-1$

    	entityNameColumn = new TableColumn(table, SWT.NONE);
    	entityNameColumn.setMoveable(true);
    	entityNameColumn.setWidth(200);
    	entityNameColumn.setText(Messages.getString("ContractorListForm.entityNameColumn.text")); //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        
        registerEntityProvider(Partner.CLASS_ID, Partner.class);
	registerEntityProvider(Employee.CLASS_ID, Employee.class);
        
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "fullName");	
	bindColumn(2, "entityName");
    }
 
    
    protected Object getEntityProviderView(Object key) {
	return EntityEnvironment.getEntityById((String) key);
    }
    
    protected Object getEntityProviderKey(Object view) {
	return getEntityConfigId(view);
    }
    
//    OLD HISTORY: SELECTED ENTITY TYPE     
//    protected IEntityType getSelectedEntityType() {
//        Contractor contractor = getSelectedContractor();
//        if (contractor == null) {
//            return null;
//        }
//        return getEntityType(contractor.getEntityCode());
//    }

//    OLD HISTORY: OWNER    
//    protected Object loadEntityById(Serializable id) throws ApplicationException {
//	if (id == null) {
//	    return null;
//	}
//	return getContractorService().findByOwnerId((Integer) id);
//    }
    
 
}  //  @jve:decl-index=0:visual-constraint="10,10"
