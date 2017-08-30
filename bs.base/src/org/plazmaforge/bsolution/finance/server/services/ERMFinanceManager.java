package org.plazmaforge.bsolution.finance.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.ContractorMove;
import org.plazmaforge.bsolution.finance.common.beans.EmployeeMove;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.IContractorDocument;
import org.plazmaforge.bsolution.finance.common.beans.IContractorHeader;
import org.plazmaforge.bsolution.finance.common.beans.IPartnerableDocument;
import org.plazmaforge.bsolution.finance.common.beans.IWarehouseDocument;
import org.plazmaforge.bsolution.finance.common.beans.PartnerMove;
import org.plazmaforge.bsolution.finance.common.beans.TemplateEntry;
import org.plazmaforge.bsolution.finance.common.beans.WarehouseMove;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.organization.common.beans.Warehouse;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.erm.procedure.AbstractProcedure;
import org.plazmaforge.framework.ext.config.EntityManager;

public class ERMFinanceManager extends AbstractProcedure {

    public void execute(Connection cn, Map<String, Object> parameters) throws SQLException {
	try {
	    String entryPoint = getEntryPoint(parameters);
	    Object[] values = null;
	    Object data = null;
	    setEntityManager(getEntityManager(parameters));
	    if ("preSave".equals(entryPoint)) {
		// PRE SAVE (PRE INSERT or UPDATE)
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		preSave(cn, data);
	    } else if ("preDelete".equals(entryPoint)) {
		// PRE DELETE
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		preDelete(cn, data);
	    } else if ("postSave".equals(entryPoint)) {
		// POST SAVE (POST INSERT or MODIFY)
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		postSave(cn, data);
	    } else if ("postDelete".equals(entryPoint)) {
		// POST DELETE
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		postDelete(cn, data);
	    } else if ("preparePartnerMove".equals(entryPoint)) {
		// PARTNERS
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		preparePartnerMove((FinanceDocument) data);
	    } else if ("prepareWarehouseMove".equals(entryPoint)) {
		// WAREHOUSES
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		prepareWarehouseMove((FinanceDocument) data);
	    } else if ("prepareEntryItems".equals(entryPoint)) {
		// ENTRIES
		values = getParameterValues(parameters, 1, true);
		data = values[0];
		prepareEntryItems(cn, (FinanceDocument) data);
	    } else {
		throw new RuntimeException("Entry point '" + entryPoint + "' not found");
	    }
	} catch (Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	} finally {
	    setEntityManager(null);
	}
    }

    
    protected void preSave(Connection cn, Object data) {
	FinanceDocument document = (FinanceDocument) data; 
	preparePartnerMove(document);
	prepareWarehouseMove(document);
	prepareEntryItems(cn, document);
    }
    
    protected void preDelete(Connection cn, Object data) {
	//do nothing
    }
    
    protected void postSave(Connection cn, Object data) {
	//do nothing
    }

    protected void postDelete(Connection cn, Object data) {
	//do nothing
    }
    

    protected void preparePartnerMove(FinanceDocument document) {
	if (document instanceof IPartnerableDocument) {
	    preparePartnerMoveByPartnerableDocument((IPartnerableDocument) document);
	} else if (document instanceof IContractorDocument) {
	    preparePartnerMoveByContractorDocument((IContractorDocument) document);
	}
    }

    protected void prepareWarehouseMove(FinanceDocument document) {
	if (document instanceof IWarehouseDocument) {
	    prepareWarehouseMoveByWarehouseDocument((IWarehouseDocument) document);
	}
    }

    protected void prepareEntryItems(Connection cn, FinanceDocument document) {
	
	// If calculate is disabled (document) then return
	if (!document.isCalculateAccountEntry()) {
	    return;
	}
	
	// If calculate is disabled (environment) then return 
	if (!FinanceEnvironment.isCalculateAccountEntry()) {
	    return;
	}
	
	
	document.getEntryItems().clear();

	Integer documentTypeId = document.getDocumentTypeId();

	if (documentTypeId == null) {
	    return;
	}

	TemplateEntry entry = getEntityManager().load(TemplateEntry.class, "financeDocumentType.documentType.id", documentTypeId);
	if (entry == null) {
	    // No entry for the DocumentType
	    return;
	}
	EntryCalculateExecutorImpl executor = new EntryCalculateExecutorImpl();
	executor.setEntryCalculateFinder(new ERMEntryCalculateFinder(cn, getEntityManager()));
	try {
	    executor.calculate(document, entry);
	} catch (ApplicationException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    ////
    
    protected void preparePartnerMoveByPartnerableDocument(IPartnerableDocument document) {
	if (document.getPartner() == null) {
	    return;
	}
	Integer partnerId = document.getPartner().getId();
	preparePartnerMove((FinanceDocument) document, partnerId);
    }

    
    protected void preparePartnerMove(FinanceDocument document, Integer partnerId) {
	if (partnerId == null) {
	    return;
	}

	document.getPartnerMoves().clear();
	PartnerMove move = new PartnerMove();

	// Populate move
	move.setPartnerId(partnerId);
	move.setAmount(document.getTotal());
	move.setAmountWithTax(document.getTotalWithTax());
	move.setTaxAmount(document.getTaxTotal());

	// Add move
	document.addPartnerMove(move);

    }

    protected void preparePartnerMoveByContractorDocument(IContractorDocument document) {
	IContractorHeader contractor = document.getContractor();
	if (contractor == null) {
	    return;
	}
	Integer id = contractor.getOwnerId();
	String type = getContractorType(contractor);
	if ("PARTNER".equals(type)) {
	    preparePartnerMove((FinanceDocument) document, id);
	} else if ("EMPLOYEE".equals(type)) {
	    prepareEmployeeMove((FinanceDocument) document, id);
	}
    }
    
    private String getContractorType(IContractorHeader contractor) {
	if (contractor == null) {
	    return null;
	}
	String type = EntityManager.getEntityId(contractor);
	
	if (type == null) {
	    return null;
	}
	return type.trim();
    }

    protected void prepareWarehouseMoveByWarehouseDocument(IWarehouseDocument document) {
	prepareWarehouseMoveByWarehouseDocument(document, true);
    }

    protected void prepareWarehouseMoveByWarehouseDocument(IWarehouseDocument document, boolean isClear) {
	FinanceDocument financeDocument = (FinanceDocument) document;
	if (isClear) {
	    clearWarehouseMoves(financeDocument);
	}
	prepareWarehouseMove(financeDocument, document.getWarehouse(), document.getMtrlResponsible(), null);
    }

    protected void prepareWarehouseMove(FinanceDocument document, Warehouse warehouse, MtrlResponsible responsible, String moveType) {

	if (warehouse == null) {
	    return;
	}

	Integer warehouseId = null;
	Integer responsibleId = null;

	warehouseId = warehouse.getId();

	if (responsible != null) {
	    responsibleId = responsible.getId();
	}
	prepareWarehouseMove(document, warehouseId, responsibleId, moveType);
    }

    protected void clearWarehouseMoves(FinanceDocument document) {
	document.getWarehouseMoves().clear();
    }

    protected void prepareWarehouseMove(FinanceDocument document, Integer warehouseId, Integer responsibleId, String moveType) {

	if (warehouseId == null) {
	    return;
	}

	WarehouseMove move = new WarehouseMove();

	// Populate move
	move.setWarehouseId(warehouseId);
	move.setMtrlResponsibleId(responsibleId);
	move.setMoveType(moveType);

	// Add move
	document.addWarehouseMove(move);

    }

    // ---

    protected void prepareContractorMove(FinanceDocument document, Integer contractorId) {
	if (contractorId == null) {
	    return;
	}

	document.getContractorMoves().clear();
	ContractorMove move = new ContractorMove();

	// Populate move
	move.setContractorId(contractorId);
	move.setAmount(document.getTotal());
	move.setAmountWithTax(document.getTotalWithTax());
	move.setTaxAmount(document.getTaxTotal());

	// Add move
	document.addContractorMove(move);

    }

    protected void prepareEmployeeMove(FinanceDocument document, Integer employeeId) {
	if (employeeId == null) {
	    return;
	}

	document.getEmployeeMoves().clear();
	EmployeeMove move = new EmployeeMove();

	// Populate move
	move.setEmployeeId(employeeId);
	move.setAmount(document.getTotal());
	move.setAmountWithTax(document.getTotalWithTax());
	move.setTaxAmount(document.getTaxTotal());

	// Add move
	document.addEmployeeMove(move);

    }

}
