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

package org.plazmaforge.bsolution.document;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.plazmaforge.bsolution.document.common.IDocumentCreator;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.util.ClassUtilsExt;


/** 
 * @author Oleh Hapon
 * $Id: DocumentManager.java,v 1.5 2010/12/05 07:55:59 ohapon Exp $
 */

public class DocumentManager {

    private static final Log logger = LogFactory.getLog(DocumentManager.class);
    
    
     
    
    public static IDocumentCreator getDocumentCreator(String key1, String key2) {
	if (key1 == null || key2 == null) {
	    return null;
	}
	IDocumentCreator creator = null;
	try {
	    String key = key1 + "." + key2;
	    String creatorClassName = DocumentEnvironment.getDocumentCreatorClass(key);
	    if (creatorClassName == null) {
		return null;
	    }
	    creator = (IDocumentCreator) ClassUtilsExt.getClassInstance(creatorClassName);
	    if (creator == null) {
		return null;
	    }
	    Class documentClass = getClassByEntityCode(key2);
	    //creator.setId(key);
	    creator.setDocumentClass(documentClass);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return creator;
	
    }
    
    
    
    
    ///
    
    
    // SERVICE METHOD
    public static void createDocumentsByParent(Serializable parentDocumentId, DocumentType parentDocumentType, List<DocumentType> documentTypes, String[] messages) throws ApplicationException {
	if (parentDocumentId == null) {
	    throw new ApplicationException("Parent Document ID is null");
	}
	if (parentDocumentType == null) {
	    throw new ApplicationException("Parent Document Type is null");
	}
	if (documentTypes == null || documentTypes.size() == 0) {
	    throw new ApplicationException("Document Type list is empty");
	}
	
	Class parentServiceClass = getServiceClassByEntityCode(getEntityConfigId(parentDocumentType));
	if (parentServiceClass == null) {
	    throw new ApplicationException("Parent Document Service Class not found: CODE=" + getEntityConfigId(parentDocumentType));
	}
	
	DocumentService parentService = (DocumentService) getService(parentServiceClass);
	if (parentService == null) {
	    throw new ApplicationException("Parent Document Service not found: CLASS=" + parentServiceClass);
	}
	
	
	Document parentDocument = (Document) parentService.findById(parentDocumentId);
	if (parentDocument == null) {
	    throw new ApplicationException("Parent Document not found: ID=" + parentDocumentId);
	}
	
	int i = -1;
	for (DocumentType type : documentTypes) {
	    i++;
	    try {
		createDocumentByParent(parentDocument, type);
		messages[i] = "OK";
	    } catch (Exception ex) {
		logger.error("CreateDocument Error", ex);
		messages[i] = "Error: " + ex.getMessage();
	    }
	}
	
	
    }

    public static void createDocumentByParent(Document parentDocument, DocumentType type) throws ApplicationException {
	    String code = getEntityConfigId(type);
	    Class serviceClass = getServiceClassByEntityCode(code);
	    DocumentService service = (DocumentService) getService(serviceClass);
	    if (service == null) {
		throw new ApplicationException("Document Service not found: CLASS=" + serviceClass);
	    }
	    createDocumentByParent(parentDocument, type, service);
    }
    
    public static  void createDocumentByParent(Document parentDocument, DocumentType documentType, DocumentService documentService) throws ApplicationException {
	if (parentDocument == null || documentType == null || documentService == null) {
	    return;
	}
	IDocumentCreator creator = getDocumentCreator(parentDocument.getDocumentType(), documentType);
	if (creator == null) {
	    throw new ApplicationException("Document Creator not found");
	}
	Document document = creator.createDocument(parentDocument);
	if (document == null) {
	    return;
	}
	documentService.create(document);
    }
    
    public static IDocumentCreator getDocumentCreator(DocumentType parentDocumentType, DocumentType documentType) {
	if (parentDocumentType == null || documentType == null) {
	    return null;
	}
	String key1 = getEntityConfigId(parentDocumentType);
	String key2 = getEntityConfigId(documentType);
	IDocumentCreator creator = getDocumentCreator(key1, key2);
	if (creator == null) {
	    return null;
	}
	creator.setDocumentType(documentType);
	return creator;
    }
    
    
    
    
    

    // --------------------------------------------------------------------------------------------------
    //
    // Helper Methods
    //
    // --------------------------------------------------------------------------------------------------
    
    private static String getEntityConfigId(Object object) {
	return EntityManager.getEntityId(object);
    }
    
    private static Class getClassByEntityCode(String code) {
	if (code == null) {
	    return null;
	}
	Association association = AssociationManager.getAssociation(code);
	if (association == null) {
	    return null;
	}
	return association.getBeanClass();
    }

    private static Class getServiceClassByEntityCode(String code) {
	if (code == null) {
	    return null;
	}
	return getServiceClassByAssociation(AssociationManager.getAssociation(code));
    }
    
    private static Class getServiceClassByAssociation(Association association) {
	Class serviceType = getServiceType();
	return association.getElementByType(serviceType);
    }

    
    
    // --------------------------------------------------------------------------------------------------
    //
    // Service Methods
    //
    // --------------------------------------------------------------------------------------------------
    
    public static DocumentService getDocumentService(Class serviceClass) {
	return (DocumentService) getService(serviceClass);
    }
    
    public static Object getService(Class serviceClass) {
	return ServiceFactory.getService(serviceClass);
    }
    
    public static Class getServiceType() {
	return Service.class;
    }
    

}
