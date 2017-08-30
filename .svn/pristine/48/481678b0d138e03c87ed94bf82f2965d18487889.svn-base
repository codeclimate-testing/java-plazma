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
 * Created on 03.09.2007
 *
 */

package org.plazmaforge.bsolution.bank.common.services;

import java.util.List;

import org.plazmaforge.bsolution.bank.common.beans.PaymentDocument;
import org.plazmaforge.bsolution.bank.common.beans.PaymentDocumentLink;
import org.plazmaforge.framework.core.exception.CreateException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.core.exception.RemoveException;
import org.plazmaforge.framework.ext.service.EntityService;


/** 
 * @author Oleh Hapon
 * $Id: PaymentDocumentLinkService.java,v 1.4 2010/12/05 07:56:01 ohapon Exp $
 */

public interface PaymentDocumentLinkService extends EntityService<PaymentDocumentLink, Integer> {

    List<PaymentDocumentLink> findByOwner(Integer ownerId) throws DAOException;
    
    
    void loadLinks(PaymentDocument holder) throws DAOException, FinderException;
    
    void storeLinks(PaymentDocument holder) throws DAOException, CreateException, FinderException, RemoveException;
    
    void removeLinks(PaymentDocument holder) throws DAOException, RemoveException;
    


}
