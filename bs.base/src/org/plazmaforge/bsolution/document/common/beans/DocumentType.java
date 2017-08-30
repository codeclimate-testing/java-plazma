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
package org.plazmaforge.bsolution.document.common.beans;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.ext.model.Dictionary;


/**
 * @author Oleh Hapon Date: 07.02.2003 Time: 13:45:58
 */
public class DocumentType extends Dictionary /*implements IEntityConfigurable*/ {

    private IEntityConfig entity;

    private String documentSection;

    private String documentCategory;
    
    private String documentNoPrefix;
    
    private String documentNoSuffix;
    
    private Integer lastDocumentNumber;
    
    private boolean useNumerator;
    
    private boolean uniqueDocumentNo; //DISABLE
    
    private String numeratorClass; //DISABLE

    private boolean documentNoReadOnly;
    
    private boolean documentDateReadOnly;
    
    private List<DocumentStatus> statuses;
    
    private List<DocumentRelation> relations;
    

    public DocumentType() {
    }

    public DocumentType(Integer id, String entityCode) {
	setId(id);
	getEntity().setCode(entityCode);
    }

    public void init() {
	super.init();
	getRelations().size();
	getStatuses().size();
    }
    
    public IEntityConfig getEntity() {
	return entity;
    }

    public void setEntity(IEntityConfig entity) {
	this.entity = entity;
    }

    public String getCode() {
	return entity == null ? null : entity.getCode();
    }

    public String getName() {
	return entity == null ? null : entity.getName();
    }
    
    public String getEntityId() {
	return entity == null ? null : entity.getId();
    }
    

    public void setName(String name) {
	throw new UnsupportedOperationException("setName method is not support");
    }

    public String getDocumentSection() {
	return documentSection;
    }

    public void setDocumentSection(String documentSection) {
	this.documentSection = documentSection;
    }

    public String getDocumentCategory() {
	return documentCategory;
    }

    public void setDocumentCategory(String documentCategory) {
	this.documentCategory = documentCategory;
    }

    public String getDocumentNoPrefix() {
        return documentNoPrefix;
    }

    public void setDocumentNoPrefix(String documentNoPrefix) {
        this.documentNoPrefix = documentNoPrefix;
    }

    public String getDocumentNoSuffix() {
        return documentNoSuffix;
    }

    public void setDocumentNoSuffix(String documentNoSuffix) {
        this.documentNoSuffix = documentNoSuffix;
    }

    public Integer getLastDocumentNumber() {
        return lastDocumentNumber;
    }

    public void setLastDocumentNumber(Integer lastDocumentNumber) {
        this.lastDocumentNumber = lastDocumentNumber;
    }

    public boolean isUseNumerator() {
        return useNumerator;
    }

    public void setUseNumerator(boolean useNumerator) {
        this.useNumerator = useNumerator;
    }

    public boolean isUniqueDocumentNo() {
        return uniqueDocumentNo;
    }

    public void setUniqueDocumentNo(boolean uniqueDocumentNo) {
        this.uniqueDocumentNo = uniqueDocumentNo;
    }

    public String getNumeratorClass() {
        return numeratorClass;
    }

    public void setNumeratorClass(String numeratorClass) {
        this.numeratorClass = numeratorClass;
    }

    public boolean isDocumentNoReadOnly() {
        return documentNoReadOnly;
    }

    public void setDocumentNoReadOnly(boolean documentNoReadOnly) {
        this.documentNoReadOnly = documentNoReadOnly;
    }

    public boolean isDocumentDateReadOnly() {
        return documentDateReadOnly;
    }

    public void setDocumentDateReadOnly(boolean documentDateReadOnly) {
        this.documentDateReadOnly = documentDateReadOnly;
    }

    public List<DocumentRelation> getRelations() {
	if (relations == null) {
	    relations = new ArrayList<DocumentRelation>();
	}
        return relations;
    }

    public void setRelations(List<DocumentRelation> relations) {
        this.relations = relations;
    }

    public void addRelation(DocumentRelation relation) {
	relation.setParentType(this);
	getRelations().add(relation);
    }
    
    public void removeRelation(DocumentRelation relation) {
	relation.setParentType(null);
	getRelations().remove(relation);
    }

    public List<DocumentStatus> getStatuses() {
	if (statuses == null) {
	    statuses = new ArrayList<DocumentStatus>();
	}
        return statuses;
    }

    public void setStatuses(List<DocumentStatus> statuses) {
        this.statuses = statuses;
    }
    
    public void addStatus(DocumentStatus status) {
	status.setDocumentType(this);
	getStatuses().add(status);
    }

    public void removeStatus(DocumentStatus status) {
	status.setDocumentType(null);
	getStatuses().remove(status);
    }
    
    

}
