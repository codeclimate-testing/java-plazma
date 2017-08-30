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

package org.plazmaforge.bsolution.document.client.swt.forms;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.ContactTitle;
import org.plazmaforge.bsolution.document.DocumentEnvironment;
import org.plazmaforge.bsolution.document.DocumentManager;
import org.plazmaforge.bsolution.document.common.beans.DocumentHeader;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentService;
import org.plazmaforge.bsolution.partner.client.swt.forms.IPartnerableForm;
import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;
import org.plazmaforge.framework.action.DefaultAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IListForm;
import org.plazmaforge.framework.client.models.FormAdapter;
import org.plazmaforge.framework.client.models.FormEvent;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.IOwnCriteriaImplementator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.config.EntityManager;


/** 
 * @author Oleh Hapon
 * $Id: AbstractDocumentListForm.java,v 1.11 2010/12/05 07:57:19 ohapon Exp $
 */

public abstract class AbstractDocumentListForm extends AbstractListForm implements IPartnerableForm, IOwnCriteriaImplementator {


    public static final String DOCUMENT_NOT_SELECTED_MESSAGE = Messages.getString("AbstractDocumentListForm.documnet.notselected");
	
	
	
    /** Organization ID **/
    private Integer organizationId;

    /** Period ID **/
    private Integer periodId;
    
    /** Partner **/
    private IPartnerTitle partner; 

    /** DocumentType of entity of concrete document list form **/
    private DocumentType entityDocumentType;
    
    
    public AbstractDocumentListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    private void initialize() {
        setOrganizationId(getContextOrganizationId());
        setPeriodId(EnterpriseEnvironment.getPeriodId());
        setSupportPeriodFilter(true);
    }    
    
    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPeriodId() {
	if (isResetPeriodFilter()) {
	    return null;
	}
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    
    public IPartnerTitle getPartner() {
	if (partner == null) {
	    if (getParentEntity() instanceof IPartnerTitle) {
		return (IPartnerTitle) getParentEntity();
	    }
	}
        return partner;
    }

    public void setPartner(IPartnerTitle partner) {
        this.partner = partner;
    }
    
    public Integer getPartnerId() {
	return getPartner() == null ? null : getPartner().getId();
    }

    protected DocumentService getDocumentService() {
        return (DocumentService) getEntityService();
    }

    public DocumentHeader getSelectedDocument() {
	return (DocumentHeader) getSelectedEntity();
    }

    public DocumentType getSelectedDocumentType() {
	DocumentHeader document = getSelectedDocument();
	return document == null ? null : document.getDocumentType();
    }    
    
    protected List loadDataList() throws ApplicationException {
	if (getStartDate() != null || getEndDate() != null) {
            return getDocumentService().findByOrganizationIdAndInterval(getOrganizationId(), getStartDate(), getEndDate(), getPartnerId());
        } else {
            return  getDocumentService().findByOrganizationIdAndPeriodId(getOrganizationId(), getPeriodId(), getPartnerId());
        }
	
    }

    protected List loadDataList(Criteria criteria) throws ApplicationException {
	if (getStartDate() != null || getEndDate() != null) {
            return getDocumentService().findByOrganizationIdAndInterval(getOrganizationId(), getStartDate(), getEndDate(), getPartnerId(), criteria);
        } else {
            return  getDocumentService().findByOrganizationIdAndPeriodId(getOrganizationId(), getPeriodId(), getPartnerId(), criteria);
        }
	
    }


    protected boolean isSupportAddByObjectAction() {
	return true;
    }
    
    protected boolean isSupportAddOtherObjectsAction() {
	return true;
    }
    

    
    public DocumentType getEntityDocumentType() {
	if (entityDocumentType == null) {
	    entityDocumentType = DocumentEnvironment.getDocumentType(getEntityClass());
	}
	return entityDocumentType;
    }
    
    public void doAddByObjectAction() throws ApplicationException {
	
	if (!isSupportAddByObjectAction()) {
	    return;
	}
	
	DocumentType documentType = getEntityDocumentType();
	if (documentType == null) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.document.type.empty"));
	    return;
	}
	
	List<DocumentType> documentTypes = DocumentEnvironment.getParentDocumntTypes(getEntityConfigId(documentType));
	if (documentTypes == null || documentTypes.size() == 0) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.reason.document.notfound"));
	    return;
	}

	DocumentType selectedType = (DocumentType) getChooseObject(documentTypes);

	if (selectedType == null) {
	    return;
	}
	
	Association a = AssociationManager.getAssociationByEntity(selectedType.getEntity());
	if (a == null) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.document.association.notfound"));
	    return;
	}
	Class listFormClass = a.getElementByType(IListForm.class);
	if (listFormClass == null) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.document.listform.notfound"));
	    return;
	}
	IListForm listForm = getChooseListForm(listFormClass, new DocumentFormListener());
	listForm.setParentForm(this);
	Toolkit.openForm(null, listForm);
	
    }
    
    
    
    
    
    private class DocumentFormListener extends FormAdapter {

	public void updateForm(FormEvent event) throws ApplicationException {

	    IForm form = event.getForm();

	    if (form == null) {
		return;
	    }

	    Object entity = form.getEntity();
	    if (entity == null) {
		return;
	    }

	    // Hide list form
	    if (!form.isDisposed()) {
		form.getDecorator().setVisible(false);
	    }

	    if (!(entity instanceof DocumentHeader)) {
		return;
	    }

	    DocumentHeader parentDocument = (DocumentHeader) entity;
	    Serializable parentDocumentId = parentDocument.getId();
	    DocumentType parentDocumentType = parentDocument.getDocumentType();

	    List<DocumentType> selectedTypes = new ArrayList<DocumentType>();

	    DocumentType documentType = getEntityDocumentType();
	    if (documentType == null) {
		return;
	    }
	    selectedTypes.add(documentType);

	    // /--

	    String[] messages = new String[1];

	    // CALL SERVICE METHOD
	    DocumentManager.createDocumentsByParent(parentDocumentId, parentDocumentType, selectedTypes, messages);

	    List<String> results = new ArrayList<String>();
	    results.add("" + selectedTypes.get(0).getName() + " - " + messages[0]);
	    openResultDialog(results);

	    doRefreshAction();
	}
    }

    
    public void doAddOtherObjectsAction() throws ApplicationException {
	
	if (!isSupportAddOtherObjectsAction()) {
	    return;
	}

	DocumentType documentType = getEntityDocumentType();
	
	// For multitype documents
	if (documentType == null) {
	    documentType = getSelectedDocumentType();
	}
	
	if (documentType == null) {
	    openMessageDialog(DOCUMENT_NOT_SELECTED_MESSAGE);
	    return;
	}
	Serializable id = getSelectedEntityId();
	if (id == null) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.documnet.id.empty"));
	    return;
	}
	List<DocumentType> documentTypes = DocumentEnvironment.getChildDocumntTypes(getEntityConfigId(documentType));
	if (documentTypes == null || documentTypes.size() == 0) {
	    openMessageDialog(Messages.getString("AbstractDocumentListForm.dependent.documnet.notfound"));
	    return;
	}
	List<DocumentType> selectedTypes = getChooseObjectList(documentTypes);

	if (selectedTypes == null || selectedTypes.size() == 0) {
	    return;
	}

	String[] messages = new String[documentTypes.size()];
	
	// CALL SERVICE METHOD
	DocumentManager.createDocumentsByParent(id, documentType, selectedTypes, messages);
	
	List<String> results = new ArrayList<String>();
	int i = -1;
	for (DocumentType type : selectedTypes) {
	    i++;
	    results.add("" + type.getName() + " - " + messages[i]);
	}
	
	openResultDialog(results);
    }
    
    public void configureForm(){
	initDocumentActions();
	super.configureForm();
    }
    
    protected void initDocumentActions() {
	initDocumentAction1();
	initDocumentAction2();
    }
    
    /**
     * Add new object by other object
     */
    protected void initDocumentAction1() {
	
	if (!isSupportAddByObjectAction()) {
	    return;
	}
	
	DocumentType documentType = getEntityDocumentType();
	if (documentType != null) {
	    List<DocumentType> documentTypes = DocumentEnvironment.getParentDocumntTypes(getEntityConfigId(documentType));
	    if (documentTypes == null || documentTypes.size() == 0) {
		return;
	    }
	}
	Action1 action1 = new Action1();
	action1.setText(Messages.getString("AbstractDocumentListForm.doAddByObjectAction"));
	addAction(action1);
	
    }
    
    /**
     * Add new objects to other storage by selected object
     */
    protected void initDocumentAction2() {
	
	if (!isSupportAddOtherObjectsAction()) {
	    return;
	}

	DocumentType documentType = getEntityDocumentType();
	if (documentType != null) {
	    List<DocumentType> documentTypes = DocumentEnvironment.getChildDocumntTypes(getEntityConfigId(documentType));
	    if (documentTypes == null || documentTypes.size() == 0) {
		return;
	    }
	}
	Action2 action2 = new Action2();
	action2.setText(Messages.getString("AbstractDocumentListForm.doAddOtherObjectsAction"));
	addAction(action2);
    }
    
    /**
     * Add new object by other object
     * @author ohapon
     *
     */
    private class Action1 extends DefaultAction {
	public void execute() throws ApplicationException {
	    doAddByObjectAction();
	}
    }
    
    /**
     * Add new objects to other storage by selected object
     * @author ohapon
     *
     */
    private class Action2 extends DefaultAction {
	public void execute() throws ApplicationException {
	    doAddOtherObjectsAction();
	}
    }
    
  

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected SessionContext getSessionContext() {
	return SessionEnvironment.getContext();
    }

    public Integer getContextOrganizationId() {
	return EnterpriseEnvironment.getOrganizationId(getSessionContext());
    }

    public Integer getContextUserId() {
	return EnterpriseEnvironment.getUserId(getSessionContext());
    }
    
    public Integer getContextResponsibleId() {
	return EnterpriseEnvironment.getResponsibleId(getSessionContext());
    }

    public Integer getDefaultResponsibleId() {
	return EnterpriseEnvironment.getDefaultResponsibleId(getSessionContext());
    }

    public ContactTitle getDefaultResponsible() {
	return EnterpriseEnvironment.getDefaultResponsible(getSessionContext());
    }
    
    protected String getEntityConfigId(Object object) {
	return EntityManager.getEntityId(object);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
}
