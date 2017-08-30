package org.plazmaforge.bsolution.product.server.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.plazmaforge.bsolution.base.common.MoveConstants;
import org.plazmaforge.bsolution.finance.common.beans.IWarehouseDocument;
import org.plazmaforge.bsolution.finance.common.beans.ProductMove;
import org.plazmaforge.bsolution.finance.server.services.ERMFinanceManager;
import org.plazmaforge.bsolution.organization.common.beans.MtrlResponsible;
import org.plazmaforge.bsolution.product.common.beans.Product;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.bsolution.product.common.beans.ProductHeader;
import org.plazmaforge.bsolution.product.common.beans.ProductStock;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ConverterUtils;
import org.plazmaforge.framework.util.DBUtils;

public class ERMProductManager extends ERMFinanceManager {

    
    
    protected boolean supportStock;

    protected Map<Integer, ProductStock> productStock;
    
    protected String moveType;
    
    protected boolean validMoveType;
    
    
    protected ProductDocument getProductDocument(Object data) {
	return (ProductDocument) data;
    }
    
    //
    // Implementation Stock mode: 
    //
    // 1. preSave/loadOldProductQuantity
    //
    // 2. postSave/loadNewProductQuantity
    //
    // 3. postSave/updateProductStock
    //
   
    // PRE SAVE (PRE INSERT or UPDATE)
    protected void preSave(Connection cn, Object data)  {
	
	ProductDocument d = getProductDocument(data);
	
	// SYNCHRONIZE DOCUMENT RESPONSIBLE /////////
	initDocumentResponsible(d);
	
	
	// STOCK ////////////////////////////////////
	initProductStock(cn, d);
	
	loadOldProductQuantity(cn, d);
	/////////////////////////////////////////////
	
	
	
	//prepareChildren(d.getProductItems());

	checkProductDocument(cn, d);
	
	prepareProductMove(d);

	super.preSave(cn, data);
    }
    
    protected void preDelete(Connection cn, Object data)  {
	
	ProductDocument d = getProductDocument(data);
	
	// STOCK ////////////////////////////////////
	initProductStock(cn, d);
	
	loadOldProductQuantity(cn, d);
	/////////////////////////////////////////////

	
	super.preDelete(cn, data);
    }

    
    
    protected void initProductStock(Connection cn, ProductDocument productDocument) {
	supportStock = isSupportStock(cn, productDocument);
	moveType = supportStock ? getMoveType(cn, productDocument) : null;
	
	if (moveType == null) {
	    validMoveType = false;  
	} else {
	    validMoveType = MoveConstants.REST.equals(moveType)
	    
	    || MoveConstants.INPUT.equals(moveType) 
	    || MoveConstants.OUTPUT.equals(moveType)
	    
	    || MoveConstants.ORDER_INPUT.equals(moveType) 
	    || MoveConstants.ORDER_OUTPUT.equals(moveType);  
	}
    }

    protected void initDocumentResponsible(ProductDocument d) {
	if (!(d instanceof IWarehouseDocument)) {
	    return;
	}
	IWarehouseDocument wd = (IWarehouseDocument) d;
	if (!wd.isSyncDocumentResponsible()) {
	    return;
	}
	MtrlResponsible mr = wd.getMtrlResponsible();
	d.setResponsible(mr == null ? null : mr.getContact());
    }

    protected boolean isSupportStock() {
        return supportStock;
    }

    protected String getMoveType() {
        return moveType;
    }
    
    protected boolean isValidMoveType() {
	return validMoveType;
    }
    

    // POST SAVE (POST INSERT or UPDATE)
    protected void postSave(Connection cn, final Object entity) {
	
	ProductDocument d = (ProductDocument) entity;
	
	loadNewProductQuantity(cn, d);
	
	updateProductStock(cn, d);

	super.postSave(cn, entity);
    }

    
    protected void postDelete(Connection cn, Object data)  {
	
	ProductDocument d = getProductDocument(data);
	updateProductStock(cn, d);
	
	super.postDelete(cn, data);
    }

    
    
    protected String getMoveType(Connection cn, ProductDocument productDocument) {
	if (productDocument == null) {
	    return null;
	}
	Integer documentTypeId = productDocument.getDocumentTypeId();
	if (documentTypeId == null) {
	    return null;
	}
	
	List<Object[]> list = getList(cn, "SELECT MOVE_TYPE FROM FINANCE_DOCUMENT_TYPE WHERE DOCUMENT_TYPE_ID = " + documentTypeId);
	if (list == null || list.isEmpty()) {
	    return null;
	}
	Object[] row = (Object[]) list.get(0);
	return (String) row[0];
    }
    
    
    protected boolean isCheckProductDocument() {
	return false;
    }
    
    protected void checkProductDocument(Connection cn, final ProductDocument productDocument) {
	if (!isCheckProductDocument()) {
	    return;
	}
	List<ProductDocumentItem> productItems = productDocument.getProductItems();
	if (productItems == null || productItems.size() == 0) {
	    return;
	}
	for (ProductDocumentItem item : productItems) {
	    checkProduct(cn, item.getProduct());
	}
    }
    
    protected void checkProduct(Connection cn, final ProductHeader product) {}
    
    
    /**
     * Prepare <code>ProductMove</code> items
     * @param document
     */
    protected void prepareProductMove(ProductDocument document) {

	// Clear moves
	document.getProductMoves().clear();
	List productItems = document.getProductItems();
	if (productItems == null || productItems.size() == 0) {
	    return;
	}
	for (int i = 0; i < productItems.size(); i++) {
	    ProductDocumentItem item = (ProductDocumentItem) productItems.get(i);
	    ProductMove move = new ProductMove();

	    // Populate move
	    populateProductMove(item, move);

	    // Add move
	    document.addProductMove(move);

	}

    }

    /**
     * Populate <code>ProductMove</code>
     * @param item
     * @param move
     */
    protected void populateProductMove(ProductDocumentItem item, ProductMove move) {

	move.setProductId(item.getProduct().getId());
	move.setUnitId(item.getUnit().getId());
	move.setUnitRate(item.getUnitRate());
	move.setPrice(item.getPrice());
	move.setPriceWithTax(item.getPriceWithTax());
	move.setTaxPrice(item.getTaxPrice());
	move.setQuantity(item.getQuantity());
	move.setAmount(item.getAmount());
	move.setAmountWithTax(item.getAmountWithTax());
	move.setTaxAmount(item.getTaxAmount());
	
	move.setAccountQuantity(item.getAccountQuantity());
	move.setAccountPrice(item.getAccountPrice());
	move.setAccountPriceWithTax(item.getAccountPriceWithTax());
	move.setAccountTaxPrice(item.getAccountTaxPrice());

    }

    protected boolean isSupportStock(Connection cn, ProductDocument d) {
	List<Object[]> list = getList(cn, "SELECT IS_AUTO_CALCULATE_PROD_REST FROM ENTERPRISE_CONTEXT");
	if (list == null || list.isEmpty()) {
	    return false;
	}
	Object[] row = (Object[]) list.get(0);
	//Object v = list.get(0);
	Object v = row[0];
	return v.toString().equals("Y");
    }
    

    
    /**
     * Load old values of quantity of product by product document from database (SQL query). 
     * @param session
     * @param productDocument
     * @throws HibernateException
     * @throws ApplicationException
     */
    protected void loadOldProductQuantity(Connection cn, final ProductDocument productDocument) {
	
	if (!isSupportStock()) {
	    return;
	}

	if (!isValidMoveType()) {
	    return;
	}

	Integer id = productDocument.getId();
	if (id == null) {
	    productStock = null;
	    return;
	}
	productStock = new HashMap<Integer, ProductStock>();
	List<Object[]> list = getList(cn, "SELECT PRODUCT_ID, ACCOUNT_QUANTITY FROM PRODUCT_MOVE WHERE OWNER_ID = " + id);
	int size = list.size(); 
	for (int i = 0; i < size; i++) {
	    Object[] row = (Object[]) list.get(i);
	    Integer productId = getInteger(row[0]);
	    Double quantity = getDouble(row[1]);
	    if (quantity == null) {
		continue;
	    }
	    ProductStock stock = productStock.get(productId);
	    if (stock == null) {
		stock = new ProductStock();
		stock.setProductId(productId);
		productStock.put(productId, stock);
	    }
	    stock.setOldQuantity(stock.getOldQuantity() + quantity);
	}
    }

    /**
     * Load new values of quantity of product from product document. 
     * @param session
     * @param productDocument
     */
    protected void loadNewProductQuantity(Connection cn, ProductDocument productDocument) {
	
	if (!isSupportStock()) {
	    return;
	}

	if (!isValidMoveType()) {
	    return;
	}

	if (productStock == null) {
	    productStock = new HashMap<Integer, ProductStock>();
	}
	
	List<ProductMove> newMoveList = productDocument.getProductMoves();
	for (ProductMove m : newMoveList) {
	    Integer productId = m.getProductId();
	    double quantity = m.getAccountQuantity();
	    ProductStock stock = productStock.get(productId);
	    if (stock == null) {
		stock = new ProductStock();
		stock.setProductId(productId);
		productStock.put(productId, stock);
	    }
	    stock.setNewQuantity(stock.getNewQuantity() + quantity);
	}
    }

    protected void updateProductStock(Connection cn, ProductDocument productDocument) {
	
	if (!isSupportStock()) {
	    return;
	}

	if (!isValidMoveType()) {
	    return;
	}

	if (productStock == null || productStock.isEmpty()) {
	    return;
	}
	
	Set<Integer> ids = productStock.keySet();
	StringBuffer buf = new StringBuffer();
	boolean f = false;
	for (Integer id:  ids) {
	    if (f) {
		buf.append(" ,");
	    }
	    buf.append(id);
	    f = true;
	}
	if (!f) {
	    return;
	}

	// Get specify quantity field name for updating by move type
	// In simple case it is "AVAILABLE_QUANTITY", but for order mode it is "RESERVED_QUANTITY" (sale order) or "EXPECTED_QUANTITY" (purchase order)
	String quantityFieldName = getQuantityFieldNameByMoveType(getMoveType());

	
	List<Object[]> list = getList(cn, "SELECT ID, " + quantityFieldName + " FROM PRODUCT WHERE ID IN (" + buf + ")");
	int size = list.size(); 
	for (int i = 0; i < size; i++) {
	    Object[] row = (Object[]) list.get(i);
	    Integer productId = (Integer) row[0];
	    Double quantity = getDouble(row[1]);
	    
	    if (quantity == null) {
		quantity = 0d;
	    }
	    
	    ProductStock stock = productStock.get(productId);
	    if (stock == null) {
		stock = new ProductStock();
		stock.setProductId(productId);
		productStock.put(productId, stock);
	    }
	    stock.setQuantity(quantity);
	}
	
	
	
	ProductStock stock  = null;
	List<Object[]> rows = new ArrayList<Object[]>();
	for (Integer id:  ids) {
	    stock = productStock.get(id);
	    
	    double quantity = stock.getQuantity();
	    if (isRealInputByMoveType(getMoveType())) {
		quantity = quantity + stock.getOldQuantity() - stock.getNewQuantity();
	    } else {
		quantity = quantity - stock.getOldQuantity() + stock.getNewQuantity();
	    }
	    rows.add(new Object[] {id, quantity});
	}
	if (rows.isEmpty()) {
	    return;
	}
	String sql  = "UPDATE PRODUCT SET " + quantityFieldName + " = ? WHERE ID = ?";
	updateList(cn, sql, rows);
	
	// TODO: Must implement update product stock
    }
    

    protected String getQuantityFieldNameByMoveType(String moveType) {
	if (moveType == null) {
	    return null;
	}
	
	if (MoveConstants.REST.equals(moveType) || MoveConstants.INPUT.equals(moveType) || MoveConstants.OUTPUT.equals(moveType)) {
	    return Product.AVAILABLE_QUANTITY;
	}
	
	if (MoveConstants.ORDER_INPUT.equals(moveType)) {
	    return Product.EXPECTED_QUANTITY;
	}

	if (MoveConstants.ORDER_OUTPUT.equals(moveType)) {
	    return Product.RESERVED_QUANTITY;
	}
	
	return null;

    }

    protected boolean isRealInputByMoveType(String moveType) {
	if (moveType == null) {
	    return false;
	}
	
	return (MoveConstants.REST.equals(moveType) || MoveConstants.INPUT.equals(moveType) || MoveConstants.ORDER_INPUT.equals(moveType));

    }

    protected Integer getInteger(Object value) {
	return ConverterUtils.toInteger(value);
    }

    protected Double getDouble(Object value) {
	return ConverterUtils.toDouble(value);
    }

    protected List<Object[]> getList(Connection cn, String sql) {
	return getList(cn, sql, null);
    }
    
    protected List<Object[]> getList(Connection cn, String sql, Object[] parameters) {
	try {
	    return DBUtils.getList(cn, sql, parameters);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

    protected void updateList(Connection cn, String sql) {
	updateList(cn, sql, null);
    }
    
    protected void updateList(Connection cn, String sql, List<Object[]> list) {
	try {
	    DBUtils.updateList(cn, sql, list);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

}
