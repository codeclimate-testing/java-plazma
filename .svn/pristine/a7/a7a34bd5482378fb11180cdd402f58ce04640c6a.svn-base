package org.plazmaforge.bsolution.partner.server.services;

import java.util.List;

import org.plazmaforge.bsolution.bank.common.beans.BankAccount;
import org.plazmaforge.bsolution.base.common.services.AttributeValueService;
import org.plazmaforge.bsolution.base.common.services.FileService;
import org.plazmaforge.bsolution.partner.common.beans.Partner;
import org.plazmaforge.bsolution.partner.common.beans.PartnerHeader;
import org.plazmaforge.bsolution.partner.common.services.PartnerService;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.ext.service.OwnCriteriaService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class PartnerServiceImpl extends AbstractEntityService<Partner, Integer> implements PartnerService, OwnCriteriaService {

    public void setAttributeValueService(AttributeValueService attributeValueService) {
	//stub
    }
    
    public void setFileService(FileService fileService) {
	//stub
    }
    
    protected Class getEntityClass() {
	return Partner.class;
    }

    protected Class getEntityHeaderClass() {
	return PartnerHeader.class;
    }

    public List findWithoutPartnerId(final Integer partnerId)  throws DAOException {
	return findWithoutPartnerId(partnerId, null);
    }
       
    public List findWithoutPartnerId(final Integer partnerId, final Criteria criteria) throws DAOException {
	//Criteria criteria = createERMCriteria();
	criteria.addFilter("id", partnerId, "<>");
	criteria.addIsNullFilter("descriminator"); // isNull
	//populateERMCriteria(fromCriteria, criteria);
	return getEntityManager().findAll(getEntityHeaderClass(), criteria); // PartnerHeader
    }

    public List findOnlyPartners() throws DAOException {
	return findOnlyPartners(null);
    }
    
    
    public List findOnlyPartners(final Criteria criteria) throws DAOException {
	//Criteria criteria = createERMCriteria();
	criteria.addIsNullFilter("descriminator"); // isNull
	//populateERMCriteria(fromCriteria, criteria);
	return getEntityManager().findAll(getEntityHeaderClass(), criteria); // PartnerHeader
    }
    
    
    // Bank Account
    
    public List<BankAccount> findBankAccounts(Integer partnerId) throws DAOException {
	return getEntityManager().findAll(BankAccount.class, "partner.id", partnerId);
    }
    
    
    
    public BankAccount findDefaultBankAccount(Integer partnerId) throws DAOException, FinderException {
	return findDefaultBankAccount(partnerId, true);
    }
    
    public BankAccount findDefaultBankAccount(Integer partnerId, boolean forceFind) throws DAOException, FinderException {
	Partner partner = findById(partnerId);
	if (partner == null) {
	    throw new FinderException("Partner not found");
	}
	Integer bankAccountId = partner.getBankAccountId();
	if (bankAccountId != null) {
	    return getEntityManager().loadById(BankAccount.class, bankAccountId);
	}
	if (!forceFind) {
	    return null;
	}
	List<BankAccount> accounts = findBankAccounts(partnerId);
	if (accounts == null || accounts.size() == 0) {
	    return null;
	}
	return accounts.get(0);
    }    
}
