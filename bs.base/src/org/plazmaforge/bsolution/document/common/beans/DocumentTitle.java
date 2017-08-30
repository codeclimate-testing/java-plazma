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
 * Created on 02.04.2005
 *
 */
package org.plazmaforge.bsolution.document.common.beans;

import java.util.Date;


import org.plazmaforge.framework.ext.model.ComplexEntity;
import org.plazmaforge.framework.ext.model.IHistoryEntity;
import org.plazmaforge.framework.ext.model.IStringPresentation;
import org.plazmaforge.framework.util.DocumentFormat;



/**
 * @author hapon
 *
 */
public class DocumentTitle extends ComplexEntity implements IHistoryEntity, IStringPresentation {

    private DocumentType documentType;
    
    private String documentNo;
	
    private Date documentDate;

    
    public DocumentType getDocumentType() {
        return documentType;
    }

    public Integer getDocumentTypeId() {
        return documentType == null ? null : documentType.getId();
    }

    public String getDocumentTypeCode() {
        return documentType == null ? null : documentType.getCode();
    }
    
    public String getDocumentTypeName() {
        return documentType == null ? null : documentType.getName();
    }
    
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
    
    public String getDocumentNo() {
        return documentNo;
    }
    
    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }
    
    public Date getDocumentDate() {
        return documentDate;
    }
    
    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getTitle() {
        return formatTitle(getDocumentTypeName(), getDocumentNo(), getDocumentDate());
    }
    
    public String getShortTitle() {
        return formatTitle(null, getDocumentNo(), getDocumentDate());
    }
    
    private String formatTitle(String name, String code, Date date) {
        return DocumentFormat.formatTitle(name, code, date);
    }
    
  
    public String getStringPresentation() {
	return getTitle();
    }

    public String getCodeStringPresentation() {
	return getStringPresentation();
    }

}
