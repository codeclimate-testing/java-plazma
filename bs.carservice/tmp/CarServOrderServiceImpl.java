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

package org.plazmaforge.bsolution.carservice.server.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrder;
import org.plazmaforge.bsolution.carservice.common.beans.CarServOrderImage;
import org.plazmaforge.bsolution.carservice.common.services.CarServOrderService;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.finance.common.beans.IPartnerableDocument;
import org.plazmaforge.bsolution.finance.common.beans.IWarehouseDocument;
import org.plazmaforge.bsolution.goods.server.services.AbstractGoodsDocumentService;
import org.plazmaforge.bsolution.product.common.beans.ProductDocumentItem;
import org.plazmaforge.framework.core.exception.ApplicationException;

/**
 * 
 * @author Oleh Hapon
 * $Id: CarServOrderServiceImpl.java,v 1.7 2010/12/05 07:53:47 ohapon Exp $
 */
public class CarServOrderServiceImpl extends AbstractGoodsDocumentService<CarServOrder, Integer> implements CarServOrderService {

    
    private static final String IMAGE_TABLE = "CAR_SERV_ORDER_IMAGE";
    
    private static final String IMAGE_FIELD = "IMAGE_DATA";
    
    
    
    protected Class getEntityClass() {
        return CarServOrder.class;
    }

    protected void preparePartnerMove(final FinanceDocument document) {
        preparePartnerMoveByPartnerableDocument((IPartnerableDocument) document);
    }


    protected void prepareWarehouseMove(FinanceDocument document) {
        prepareWarehouseMoveByWarehouseDocument((IWarehouseDocument) document);
 
    
    
    }
    
    //  BEFORE MODIFY
    protected void doBeforeModify(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	
	CarServOrder carServOrder = getCastEntity(entity);
	
	// TODO
	// Reset inventory ids 
	carServOrder.resetInventoryIds();
	carServOrder.resetAdditionalRepairId();
	carServOrder.resetTotalInventoryIds();
	
	
	// Special hack for clear TOTAL INVENTORY IDs
	Integer id = carServOrder.getId();
	if (id != null) {
	    
	    // CLEAR DAMAGES
	    SQLQuery query = session.createSQLQuery("UPDATE CAR_SERV_ORDER_DAMAGE SET TOTAL_INVENTORY_ID = NULL WHERE CAR_SERV_ORDER_ID = " + id);
	    query.executeUpdate();
	    
	    // CLEAR ITEMS
	    query = session.createSQLQuery("UPDATE CAR_SERV_ORDER_ITEM SET CAR_SERV_ORDER_INVENTORY_ID = NULL WHERE CAR_SERV_ORDER_ID = " + id);
	    query.executeUpdate();

	    
	    // CLEAR PAINT TYPES
	    query = session.createSQLQuery("UPDATE CAR_SERV_ORDER_PAINT_TYPE SET CAR_SERV_ORDER_INVENTORY_ID = NULL WHERE CAR_SERV_ORDER_ID = " + id);
	    query.executeUpdate();
	    
	}
	
	/*
	// Update null ids in items (reset ids to null)
	List<ProductDocumentItem> items = carServOrder.getProductItems();
	for (ProductDocumentItem item : items) {
	    if (item.getId() != null) {
		session.update(item);
	    }
	}
	
	// Update null ids in paint types (reset ids to null)
	List<CarServOrderPaintType> paintTypes = carServOrder.getPaintTypeList();
	for (CarServOrderPaintType type : paintTypes) {
	    if (type.getId() != null) {
		session.update(type);
	    }
	}
	*/
	
	
	// Prepare Paint Types
	prepareChildren(carServOrder.getPaintTypeList());
	
	super.doBeforeModify(session, entity);
	
	//flush(session); // NEW*
    }

    // AFTER MODIFY
    protected void doAfterModify(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	
	CarServOrder carServOrder = getCastEntity(entity);
	
	// TODO
	flush(session);
	super.doAfterModify(session, entity);
	carServOrder.setInventoryIds();
	
	List<ProductDocumentItem> items = carServOrder.getProductItems();
	for (ProductDocumentItem item : items) {
	    session.update(item);
	}
	
	carServOrder.setAdditionalRepairId();
	carServOrder.setTotalInventoryIds();
	
	session.update(carServOrder); // new: for additional repair
	
	//flush(session);
	
	
	List<CarServOrderImage> images = carServOrder.getImageList();
	if (images == null || images.isEmpty()) {
	    return;
	}
	
	for (CarServOrderImage image : images) {
	    if (image.getImageEntry().isImageDirty()) {
		storeImage(session, image.getId(), image.getImageEntry().getBinaryData());
	    }
	}
	
	//CarServOrderImage image  = images.get(0);
	//storeImage(session, image.getId(), image.getImageEntry().getBinaryData());

    }

    // AFTER INIT
    public void doAfterInit(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	super.doAfterInit(session, entity);
	CarServOrder carServOrder = getCastEntity(entity);

	
	// TODO
	// STUB
	
	/*
	
	List<CarServOrderImage> images = carServOrder.getImageList();
	if (images == null || images.isEmpty()) {
	    return;
	}
	CarServOrderImage image  = images.get(0);
	
	byte[] data = loadImage(session, image.getId());
	image.getImageEntry().setBinaryData(data);
	*/
	
    }
    
    
    
    protected void doBeforeDelete(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	
	CarServOrder carServOrder = getCastEntity(entity);
	
	// Reset inventory ids 
	carServOrder.resetInventoryIds();
	carServOrder.resetAdditionalRepairId();
	carServOrder.resetTotalInventoryIds();
	
	super.doBeforeDelete(session, entity);

	flush(session);
    }
    
    
    protected void doAfterDelete(Session session, final Object entity) throws HibernateException, SQLException, ApplicationException {
	super.doAfterDelete(session, entity);
    }
    
    /**
     * Store image. We use Hibernate Session  
     * @param session
     * @param id
     * @param data
     * @throws HibernateException
     * @throws SQLException
     */
    protected void storeImage(Session session, Integer id, byte[] data) throws HibernateException, SQLException {
	// Store image to DB. We can use File System (FS) to store image too.
	storeBinaryDataToDB(session, IMAGE_TABLE, IMAGE_FIELD, id, data);
    }

    
   ///////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Load image by id
     */
    public byte[] loadImage(final Integer id) throws ApplicationException {
	// Load image from DB. We can use File System (FS) to load image too.
	return loadBinaryDataFromDB(IMAGE_TABLE, IMAGE_FIELD, id);
    }
    
    /**
     * Store image by id and data.
     */
    public void storeImage(final Integer id, final byte[] data) throws ApplicationException {
	// Store image to DB. We can use File System (FS) to store image too.
	storeBinaryDataToDB(IMAGE_TABLE, IMAGE_FIELD, id, data);
    }
}
