/*
 * Copyright (C) 2005-2006 Oleh Hapon ohapon@users.sourceforge.net
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
 * Created on 04.02.2007
 *
 */

package org.plazmaforge.bsolution.document.client.swt.forms;


import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.beans.JournalDocument;
import org.plazmaforge.bsolution.document.common.services.JournalDocumentService;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.platform.EntityEnvironment;
import org.plazmaforge.framework.report.IReportAction;

/** 
 * @author Oleh Hapon
 * $Id: DocumentListForm.java,v 1.8 2010/05/26 07:16:46 ohapon Exp $
 */

public class DocumentListForm extends AbstractDocumentListForm {

    private Table table;
    

    
    
    public DocumentListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("DocumentListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        TableColumn documentNoColumn;
        TableColumn documentDateColumn;
        TableColumn documentTypeColumn;
        TableColumn partnerColumn;
        TableColumn documentStatusColumn;   
        TableColumn userColumn;        

        setLayout(new FillLayout(SWT.VERTICAL));
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	documentNoColumn = new TableColumn(table, SWT.NONE);
    	documentNoColumn.setMoveable(true);
    	documentNoColumn.setWidth(100);
    	documentNoColumn.setText(Messages.getString("DocumentListForm.documentNoColumn.text")); //$NON-NLS-1$

    	documentDateColumn = new TableColumn(table, SWT.NONE);
    	documentDateColumn.setMoveable(true);
    	documentDateColumn.setWidth(100);
    	documentDateColumn.setText(Messages.getString("DocumentListForm.documentDateColumn.text")); //$NON-NLS-1$
    	
 	documentTypeColumn = new TableColumn(table, SWT.NONE);
    	documentTypeColumn.setMoveable(true);
    	documentTypeColumn.setWidth(300);
    	documentTypeColumn.setText(Messages.getString("DocumentListForm.documentTypeColumn.text")); //$NON-NLS-1$
    	
 	partnerColumn = new TableColumn(table, SWT.NONE);
 	partnerColumn.setMoveable(true);
 	partnerColumn.setWidth(300);
 	partnerColumn.setText(Messages.getString("DocumentListForm.partnerColumn.text")); //$NON-NLS-1$

 	documentStatusColumn = new TableColumn(table, SWT.NONE);
    	documentStatusColumn.setMoveable(true);
    	documentStatusColumn.setWidth(100);
    	documentStatusColumn.setText(Messages.getString("DocumentListForm.documentStatusColumn.text")); //$NON-NLS-1$


    	userColumn = new TableColumn(table, SWT.NONE);
    	userColumn.setMoveable(true);
    	userColumn.setWidth(200);
    	userColumn.setText(Messages.getString("DocumentListForm.responsibleColumn.text"));    	 //$NON-NLS-1$

      	
        this.setSize(new Point(600, 300));
        

        // Register all document types
        List<DocumentType> types = DocumentEnvironment.getDocumentTypes();
        for (DocumentType type : types) {
            registerEntityProvider(type.getEntityId());
        }
        
        setEntityClass(JournalDocument.class);
        setEntityServiceClass(JournalDocumentService.class);
        getModel().setAutoConfigureEntityForm(false);
        
        // DISABLE
        setFlexiblePagingMode();
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "documentNo");	
	bindColumn("documentDate", getDateFormat());
	bindColumn("documentTypeName");
	bindColumn("partnerName");
	bindColumn("documentStatusName");
	bindColumn("responsibleName");
    }
 
    protected Object getEntityProviderView(Object key) {
	return EntityEnvironment.getEntityById((String) key);
    }
    
    protected Object getEntityProviderKey(Object view) {
	return getEntityConfigId(view);
    }   
 
    protected String getTitleString() {
	return getPartner() == null ? null : getPartner().getName();
    }    
    
    
    protected boolean isSupportAddByObjectAction() {
	return false;
    }
    
    public DocumentType getEntityDocumentType() {
	return null;
    }
    
    @Override
    public List<IReportAction> getReportActions() {
	return getSelectedEntityProviderReportActions();
    }

    @Override
    public boolean hasReportActions() {
	return !getSelectedEntityProviderReportActions().isEmpty();
    }
    


    
    
}  //  @jve:decl-index=0:visual-constraint="10,10"
