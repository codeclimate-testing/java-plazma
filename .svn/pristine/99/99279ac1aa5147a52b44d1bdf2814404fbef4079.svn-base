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
/**
 * @author Oleh Hapon
 * Date: 12.12.2004
 * Time: 14:12:58
 * $Id: DocumentEnvironment.java,v 1.5 2010/12/05 07:55:59 ohapon Exp $
 */
package org.plazmaforge.bsolution.document;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentRelation;
import org.plazmaforge.bsolution.document.common.beans.DocumentStatus;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentRelationService;
import org.plazmaforge.bsolution.document.common.services.DocumentStatusService;
import org.plazmaforge.bsolution.document.common.services.DocumentTypeService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.ext.service.ServiceFactory;
import org.plazmaforge.framework.platform.Environment;


public class DocumentEnvironment extends Environment {

    private final static Logger logger = Logger.getLogger(DocumentEnvironment.class);
    
    private static DocumentEnvironment ourInstance;

    private static Map<String, DocumentType> documentTypeMap = new HashMap<String, DocumentType>();
    private static List<DocumentType> documentTypeList = new ArrayList<DocumentType>();

    private static Map<String, List<String>> documentRelations = new HashMap<String, List<String>>();
    private static Set<String> documentRelationKeys = null;
    private static Map<String, String> documentCreators = new HashMap<String, String>(); 

    
    private static boolean isRecursiveRelation = false;
    
    public synchronized static DocumentEnvironment getInstance() {
	if (ourInstance == null) {
	    ourInstance = new DocumentEnvironment();
	}
	return ourInstance;
    }

    private DocumentEnvironment() {
    }

    public static void addDocumentType(DocumentType documentType) {
	String key = EntityManager.getEntityId(documentType);
	if (key == null) {
	    return;
	}
	documentTypeMap.put(key.trim(), documentType);
	documentTypeList.add(documentType);
    }

    public static void addDocumentTypes(List<DocumentType> types) {
	if (types == null) {
	    return;
	}
	for (DocumentType type : types) {
	    addDocumentType(type);
	}
    }
    
    public static List<DocumentType> getDocumentTypes() {
	return documentTypeList;
    }    

    public static DocumentType getDocumentType(String key) {
	return documentTypeMap.get(key);
    }

    public static Integer getDocumentTypeId(String key) {
	DocumentType type = documentTypeMap.get(key);
	if (type == null) {
	    return null;
	}
	return type.getId();
    }

    
    public static DocumentType getDocumentType(Class documentClass) {
	if (documentClass == null) {
	    return null;
	}
	Association association = AssociationManager.getAssociationByBeanClass(documentClass);
	if (association == null) {
	    return null;
	}
	return DocumentEnvironment.getDocumentType(association.getId());
    }

    
    public static void addDocumentRelation(DocumentRelation documentRelation) {
	if (documentRelation == null) {
	    return;
	}
	addDocumentRelation(documentRelation.getParentTypeCode(), documentRelation.getChildTypeCode(), documentRelation.getCreatorClassName());
    }

    
    public static void addDocumentRelations(List<DocumentRelation> relations) {
	if (relations == null) {
	    return;
	}
	for (DocumentRelation relation : relations) {
	    addDocumentRelation(relation);
	}
    }

    
    public static void loadContext() throws ApplicationException {
	logInfo(LOG_LINE);
	logInfo("Loading DocumentContext...");
	
	
	DocumentTypeService documentTypeService = (DocumentTypeService) ServiceFactory.getService(DocumentTypeService.class);
	List<DocumentType> types = documentTypeService.sysLoadDocumentTypes();
	addDocumentTypes(types);
	
	DocumentRelationService documentRelationService = (DocumentRelationService) ServiceFactory.getService(DocumentRelationService.class);
	List<DocumentRelation> relations = documentRelationService.sysLoadDocumentRelations();
	addDocumentRelations(relations);
	
	logInfo("DocumentContext was loaded. Type count = ["	+ types.size() + "]");
    }

    public static void clearContext() throws ApplicationException {
	documentTypeList.clear();
	documentTypeMap.clear();
	
	documentRelations.clear();
	documentRelationKeys = null;
	documentCreators.clear();
	
	logInfo("DocumentContext was cleared.");
    }

    public static void refreshContext() throws ApplicationException {
	clearContext();
	loadContext();
    }

    /**
     * Initialize document
     *  - Set default attributes
     *  - Set document type
     * @param document
     * @param entityCode
     * @param context
     */
    public static void initDocument(Document document, String entityCode, SessionContext context) {
	document.setOrganization(EnterpriseEnvironment.getOrganization(context));
	document.setPeriodId(EnterpriseEnvironment.getPeriodId());
	document.setDocumentDate(EnterpriseEnvironment.getDate());
	document.setDocumentType(getDocumentType(entityCode));
	document.setUser(EnterpriseEnvironment.getUser(context));
	
	setNewDocumentNo(document);
    }

    /**
     * Generate new Document No
     * @param document
     */
    public static void setNewDocumentNo(Document document) {
	if (document == null) {
	    return;
	}
	DocumentType documentType = document.getDocumentType();
	if (documentType == null) {
	    return;
	}
	DocumentTypeService service = (DocumentTypeService) getService(DocumentTypeService.class);
	service.setNewDocumentNo(document);
    }
    
    
    private static void addDocumentRelation(String parentKey, String childKey, String creatorClassName) {
	if (parentKey == null || childKey == null) {
	    return;
	}
	List<String> children = documentRelations.get(parentKey);
	if (children == null) {
	    children = new ArrayList<String>(); 
	}
	children.add(childKey);
	documentRelations.put(parentKey, children);
	documentRelationKeys = null;
	documentCreators.put(parentKey + "." + childKey, creatorClassName);
	
    }
    
    private static Set<String> getDocumentRelationKeys() {
	if (documentRelationKeys == null) {
	    documentRelationKeys = documentRelations.keySet();
	}
	return documentRelationKeys;
    }
    
    public static String getDocumentCreatorClass(String key) {
	return documentCreators.get(key);
    }
    
    public static List<DocumentType> getChildDocumntTypes(String parentKey) {
	List<String> keys = getChildDocumntTypeKeys(parentKey);
	return getDocumntTypesByKeys(keys);	
    }
    
    public static List<DocumentType> getParentDocumntTypes(String childKey) {
	List<String> keys = getParentDocumntTypeKeys(childKey);
	return getDocumntTypesByKeys(keys);
    }
    
    public static List<DocumentType> getDocumntTypesByKeys(List<String> keys) {
	if (keys == null || keys.size() == 0) {
	    return null;
	}
	List<DocumentType> types = new ArrayList<DocumentType>();
	for (String key : keys) {
	    DocumentType type = getDocumentType(key);
	    if (type == null) {
		continue;
	    }
	    types.add(type);
	}
	return types;
    }    

    public static List<String> getChildDocumntTypeKeys(String parentKey) {
	if (parentKey == null) {
	    return null;
	}
	Set<String> set = new LinkedHashSet<String>();
	populateChildDocumntTypes(set, parentKey);
	
	if (set.isEmpty()) {
	    return null;
	}
	List<String> list = new ArrayList<String>();
	for (String s : set) {
	    list.add(s);
	}
	return list;
    }
    
    private static void populateChildDocumntTypes(Set<String> set, String parentKey) {
	List<String> children = documentRelations.get(parentKey);
	if (children == null || children.size() == 0) {
	    return;
	}
	for (String child : children) {
	    if (set.contains(child)) { // anti cycle
		continue;
	    }
	    set.add(child);
	    if (isRecursiveRelation) {
		populateChildDocumntTypes(set, child);
	    }
	    
	}
    }
    
    
    public static List<String> getParentDocumntTypeKeys(String childKey) {
	if (childKey == null) {
	    return null;
	}
	Set<String> set = new LinkedHashSet<String>();
	populateParentDocumentTypes(set, childKey);
	
	if (set.isEmpty()) {
	    return null;
	}
	
	List<String> list = new ArrayList<String>();
	for (String s : set) {
	    list.add(s);
	}
	return list;	
    }
    
    private static void populateParentDocumentTypes(Set<String> set, String childKey) {
	
	if (childKey == null) {
	    return;
	}
	Set<String> keys = getDocumentRelationKeys(); //documentRelations.keySet();
	if (keys.isEmpty()) {
	    return;
	}
	for (String key : keys) {
	    List<String> children = documentRelations.get(key);
	    if (children == null || children.size() == 0) {
		continue;
	    }
	    for (String child : children) {
		if (childKey.equals(child)) {
		    if (set.contains(key)) { // anti cycle
			continue;
		    }
		    set.add(key); // add parent
		    populateParentDocumentTypes(set, key);
		}
	    }
	}
    }    
    
    
    protected static void logInfo(Object message) {
	logInfo(logger, message);
    }
    
    
    public  static List<DocumentStatus> getDocumentStatusesByType(String documentType) throws ApplicationException {
	if (documentType == null) {
	    return null;
	}
	DocumentStatusService service = (DocumentStatusService) getService(DocumentStatusService.class);
	return service.findByType(documentType);
    }
    
  
    public static interface IDataListLoader {
	
	
    }
}
