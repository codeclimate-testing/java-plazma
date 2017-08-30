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
package org.plazmaforge.bsolution.document.common.services;

import java.util.List;

import org.plazmaforge.bsolution.document.common.beans.Document;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.ext.service.EntityService;




/**
 * @author Oleh Hapon
 * Date: 08.05.2004
 * Time: 20:06:36
 * $Id: DocumentTypeService.java,v 1.4 2010/12/05 07:56:05 ohapon Exp $
 */
public interface DocumentTypeService extends EntityService<DocumentType, Integer> {
    
    List<DocumentType> sysLoadDocumentTypes() throws DAOException;
    
    
    void setNewDocumentNo(Document document);
    
    
    String generateDocumentNo(Document document);

    String generateDocumentNo(DocumentType documentType);
	
    String generateDocumentNo(String entityId);
    
}
