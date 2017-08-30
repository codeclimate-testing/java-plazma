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

package org.plazmaforge.bsolution.document.common;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/** 
 * @author Oleh Hapon
 * $Id: AbstractDocumentCreator.java,v 1.4 2010/12/05 07:56:03 ohapon Exp $
 */

public abstract class AbstractDocumentCreator {

    private String id;
    
    private Class documentClass;

    private DocumentType documentType;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public Class getDocumentClass() {
        return documentClass;
    }

    public void setDocumentClass(Class documentClass) {
        this.documentClass = documentClass;
    }

    
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    protected void populate(Document parentDocument, Document document)  throws ApplicationException {
	if (parentDocument == null || document == null) {
	    return;
	}
	if (getDocumentType() == null) {
	    throw new ApplicationException("Document Type is null");
	}
	
	populateDocumentNo(parentDocument, document);
	document.setDocumentDate(parentDocument.getDocumentDate());
	document.setDocumentType(getDocumentType());
	
	// Set reason (parent) document
	document.setReasonDocument(parentDocument);
	populateReason(parentDocument, document);
	
	document.setOrganization(parentDocument.getOrganization());
	document.setPeriodId(parentDocument.getPeriodId());
	    
	document.setUser(parentDocument.getUser()); // TODO: ????
	document.setResponsible(parentDocument.getResponsible()); // TODO: ????
	document.setProject(parentDocument.getProject());
	
	document.setContractDocument(parentDocument.getContractDocument());
	document.setProject(parentDocument.getProject());
	document.setPartner(parentDocument.getPartner());
	
	document.setNote(parentDocument.getNote());	
    }
    
    protected void populateDocumentNo(Document parentDocument, Document document)  throws ApplicationException {
	document.setDocumentNo(parentDocument.getDocumentNo());
    }
    
    protected void populateReason(Document parentDocument, Document document)  throws ApplicationException {
	document.setReason(parentDocument.getTitle());	// TODO: ????
    }

    
    protected Object getService(Class serviceInterface) {
	return ServiceFactory.getService(serviceInterface);
    }
}
