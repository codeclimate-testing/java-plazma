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
package org.plazmaforge.bsolution.partner.common.services;


import java.util.List;

import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.base.common.services.AttributeServiceHolder;
import org.plazmaforge.bsolution.base.common.services.BusinessableService;
import org.plazmaforge.bsolution.base.common.services.FileServiceHolder;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;



/**
 * @author Oleh Hapon
 * Date: 18.03.2004
 * Time: 10:32:16
 * $Id: PartnerService.java,v 1.4 2010/12/05 07:56:03 ohapon Exp $
 */
public interface PartnerService extends BusinessableService<Partner, Integer>,  AttributeServiceHolder, FileServiceHolder {
    
    List findWithoutPartnerId(Integer partnerId) throws DAOException;
    
    List findWithoutPartnerId(Integer partnerId, Criteria criteria) throws DAOException;
    
    
    List findOnlyPartners() throws DAOException;
    
    List findOnlyPartners(Criteria criteria) throws DAOException;
    
    
    List<BankAccount> findBankAccounts(Integer partnerId) throws DAOException;
    
    BankAccount findDefaultBankAccount(Integer partnerId) throws DAOException, FinderException;
    
    BankAccount findDefaultBankAccount(Integer partnerId, boolean forceFind) throws DAOException, FinderException;
}
