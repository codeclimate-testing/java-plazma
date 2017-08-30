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

package org.plazmaforge.bsolution.bank.server.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.FieldMapping;
import org.plazmaforge.framework.datawarehouse.TransferEvent;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.TransferTriggerAdapter;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.AbstractDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IDataSetImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;
import org.plazmaforge.framework.sql.IDGenerator;
import org.plazmaforge.framework.util.StringUtils;

public class BankImporter extends AbstractDataSetImporter implements IDataSetImporter {

    private static String BANK = "BANK";
    
    private static String ID = "ID";
    
    private static String BIC = "BIC";
    
    private static String NAME = "NAME";
    
    
    private static String[] BASE_COLUMNS = {ID, BIC}; // Only BANK columns
    
    private static String[] KEY_COLUMNS = {BIC}; // BIC is unique column of BANK table
    
    
    private int BIC_COLUMN_INDEX = -1;
    
    private int NAME_COLUMN_INDEX = -1;
    
    
    public BankImporter() {
	super();
	setEnableClearTable(false);
	setEnableAutoPrimaryKey(false);
	setAutoPrimaryKey(true);
    }


    public void importDataSet(IImporter importer) throws ApplicationException {
	
	DSDataSet dataSet = getDataSet();
	
	TransferInfo transferInfo = getTransferInfo();
	transferInfo.setClearTable(false);
	transferInfo.setAutoPrimaryKey(true);
	transferInfo.setIdGenerateStrategy(IDGenerator.SEQUENCE_STRATEGY);
	transferInfo.setSequanceName("BUSINESSABLE_SEQUENCE");
	
	transferInfo.setSupportsUpdate(false); // NO UPDATE FOR BASE TABLE (BANK)
	
	List<FieldMapping> inputMapping = transferInfo.getMapping();
	
	BIC_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, BIC);
	NAME_COLUMN_INDEX = getColumnIndex(dataSet, inputMapping, NAME);
	
	List<FieldMapping> columnMapping = getTransformColumnMapping(inputMapping);
	addPrimaryKeyColumnMappingIfNeed(columnMapping, ID, Integer.class);
	
	transferInfo.setMapping(columnMapping);
	transferInfo.setTrigger(new BankTrigger());
	
	TransferResult transferResult = getTransferService().updateTable(dataSet, transferInfo);
	
	setTransferResult(transferResult);
    }
      
    
    protected String[] getBaseColumns() {
	return BASE_COLUMNS; 
    }

    protected String[] getKeyColumns() {
	return KEY_COLUMNS; 
    }
	
    
    protected String[] replacer() {
	String[] array = new String[2];
	array[0] = "¡¢°?"; // CHART_TABLE_FROM
	array[1] = "²³¯¿"; // CHART_TABLE_TO
	return array;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    
    class BankTrigger extends TransferTriggerAdapter {

	private PreparedStatement businessableInsertStm;
	private PreparedStatement contactableInsertStm;
	private PreparedStatement partnerInsertStm;
	
	private PreparedStatement businessableUpdateStm;
	private PreparedStatement partnerUpdateStm;
	
	
	
	public void init() throws ApplicationException, SQLException {
	    businessableInsertStm = getConnection().prepareStatement("INSERT INTO BUSINESSABLE (ID, ENTITY_ID, OWNER_ID, NAME) VALUES (?, ?, ?, ?)");
	    contactableInsertStm = getConnection().prepareStatement("INSERT INTO CONTACTABLE (ID, ENTITY_ID, OWNER_ID) VALUES (?, ?, ?)");
	    partnerInsertStm = getConnection().prepareStatement("INSERT INTO PARTNER (ID, NAME, DESCRIMINATOR) VALUES (?, ?, ?)");
	    
	    businessableUpdateStm = getConnection().prepareStatement("UPDATE BUSINESSABLE SET NAME = ? WHERE ID IN (SELECT ID FROM BANK WHERE BIC = ?)");
	    partnerUpdateStm = getConnection().prepareStatement("UPDATE PARTNER SET NAME = ? WHERE ID IN (SELECT ID FROM BANK WHERE BIC = ?)");
	}

	public void dispose() throws ApplicationException, SQLException {
	    close(businessableInsertStm);
	    close(contactableInsertStm);
	    close(partnerInsertStm);
	    
	    close(businessableUpdateStm);
	    close(partnerUpdateStm);
	}

	public void doBeforeInsert(TransferEvent event) throws ApplicationException, SQLException {
	    
	    Object id = getId(event);
	    String name = getName(event);

	    businessableInsertStm.setObject(1, id);
	    businessableInsertStm.setObject(2, BANK);
	    businessableInsertStm.setObject(3, id);
	    businessableInsertStm.setObject(4, name);

	    businessableInsertStm.executeUpdate();
	    
	    ////

	    contactableInsertStm.setObject(1, id);
	    contactableInsertStm.setObject(2, BANK);
	    contactableInsertStm.setObject(3, id);

	    contactableInsertStm.executeUpdate();
	    
	    ////

	    partnerInsertStm.setObject(1, id);
	    partnerInsertStm.setObject(2, name);
	    partnerInsertStm.setObject(3, BANK); // DESCRIMINATOR
	    
	    partnerInsertStm.executeUpdate();
	}

	public void doBeforeUpdate(TransferEvent event) throws ApplicationException, SQLException {
	    
	    Object bic = getBic(event);
	    String name = getName(event);

	    businessableUpdateStm.setObject(1, name);
	    businessableUpdateStm.setObject(2, bic);

	    businessableUpdateStm.executeUpdate();
	    
	    ////

	    partnerUpdateStm.setObject(1, name);
	    partnerUpdateStm.setObject(2, bic);
	    
	    partnerUpdateStm.executeUpdate();
	}

	///////////////////////////////////////////////////////////////////////////////
	
	private Object getId(TransferEvent event) {
	    return event.pkValues[0];
	}
	
	private String getBic(TransferEvent event) {
	    return (String) event.row[BIC_COLUMN_INDEX];
	}
	
	private String getName(TransferEvent event) {
	    String name = (String) event.row[NAME_COLUMN_INDEX];
	    String[] replacer = replacer();
	    name = StringUtils.replaceCharTable(name, replacer[0], replacer[1]);
	    return name;
	}
	
	
    }
}
