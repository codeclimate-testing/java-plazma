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
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;


/** 
 * @author Oleh Hapon
 * $Id: DefaultDocumentCreator.java,v 1.4 2010/12/05 07:56:03 ohapon Exp $
 */

public class DocumentCreator extends AbstractDocumentCreator implements IDocumentCreator {

    public Document createDocument(Document parentDocument) throws ApplicationException {
	if (parentDocument == null) {
	    return null;
	}
	if (getDocumentClass() == null) {
	    return null;
	}
	Document document = (Document) ClassUtilsExt.getClassInstance(getDocumentClass());
	if (document == null) {
	    return null;
	}
	
	populate(parentDocument, document);
	
	return document;
    }
}
