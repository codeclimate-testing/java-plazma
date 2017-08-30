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
package org.plazmaforge.bsolution.product.server.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.base.server.services.BaseCompressionExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.CreateException;
import org.plazmaforge.framework.core.exception.FinderException;



/**
 * @author Oleh Hapon
 * $Id: ProductCompressionExecutorImpl.java,v 1.3 2010/12/05 07:55:56 ohapon Exp $
 */

public class ProductCompressionExecutorImpl extends BaseCompressionExecutor {

    // AMOUNT = CREDIT - DEBIT
    
    private final String INPUT = "INPUT";
    private final String OUTPUT = "OUTPUT";
    private final String REST = "REST"; 
    
    private final String PRODUCT_DOCUMENT_TYPE_SET = "'GOODS'"; // TODO: STUB
    
    private final String PRODUCT_DOCUMENT_TYPE_CLAUSE = " IN (" + PRODUCT_DOCUMENT_TYPE_SET + ") ";    
    
    
    public void executeCompression(Statement stm, int periodId) throws SQLException {
	
        addIncome(stm, periodId);	// + INCOME
        addOutcome(stm, periodId); 	// - OUTCOME
        addRest(stm, periodId);		// +
        
    }

    protected void clearTempTable(Statement stm) throws SQLException {
        stm.execute("DELETE FROM M_PRODUCT_REGISTER");
        stm.execute("DELETE FROM M_PRODUCT_DETAIL_REGISTER");
        
        stm.execute("DELETE FROM M_PRODUCT_REGISTER_SUM");
        stm.execute("DELETE FROM M_PRODUCT_REGISTER_ID");
        
        stm.execute("DELETE FROM M_PRODUCT_DETAIL_REGISTER_SUM");
        stm.execute("DELETE FROM M_PRODUCT_DETAIL_REGISTER_ID");
    }
    
    public void beforeCompression(Statement stm, int periodId) throws SQLException, ApplicationException {
	clearTempTable(stm);
    }
	
    public void afterCompression(Statement stm, int organizationId, int prevPeriodId, int curPeriodId, int newPeriodId) throws SQLException, ApplicationException {
        afterCompressionGoods(stm, organizationId, prevPeriodId, newPeriodId);
        afterCompressionGoodsDetail(stm, organizationId, prevPeriodId, newPeriodId);
    }

    
    
    
    // + DOCUMENT INCOME
    private void addIncome(Statement st, int periodId) throws SQLException {

	// PARTNER
        st.execute(
        	"INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT D.PARTNER_ID, 0, FD.TOTAL FROM FINANCE_DOCUMENT FD" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'INPUT' AND D.PERIOD_ID = " + periodId
        );

        
        // PRODUCT DETAIL
        st.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT WM.WAREHOUSE_ID, WM.MTRL_RESPONSIBLE_ID, PM.PRODUCT_ID, 0, 0, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT" +
        	" FROM PRODUCT_MOVE PM" +
                " INNER JOIN WAREHOUSE_MOVE WM ON WM.OWNER_ID = PM.OWNER_ID" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'INPUT' AND D.PERIOD_ID = " + periodId
        );
        

        // PRODUCT
        st.execute(
        	"INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT PM.PRODUCT_ID, 0, 0, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT" +                
        	" FROM PRODUCT_MOVE PM" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'INPUT' AND D.PERIOD_ID = " + periodId
        );
    }
    
    
    // - DOCUMENT OUTCOME
    private void addOutcome(Statement st, int periodId) throws SQLException {
	
	// PARTNER
        st.execute(
        	"INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT D.PARTNER_ID, FD.TOTAL, 0 FROM FINANCE_DOCUMENT FD" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'OUTPUT' AND D.PERIOD_ID = " + periodId
        );

        // PRODUCT DETAIL
        st.execute(
                "INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT WM.WAREHOUSE_ID, WM.MTRL_RESPONSIBLE_ID, PM.PRODUCT_ID, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT, 0, 0"+
        	" FROM PRODUCT_MOVE PM" +
        	" INNER JOIN WAREHOUSE_MOVE WM ON WM.OWNER_ID = PM.OWNER_ID" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
     	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
     	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'OUTPUT' AND D.PERIOD_ID = " + periodId
        );

        // PRODUCT
        st.execute(
                "INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                "SELECT PM.PRODUCT_ID, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT, 0, 0"+
                " FROM PRODUCT_MOVE PM" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'OUTPUT' AND D.PERIOD_ID = " + periodId
        );
    }

    
    // + DOCUMENT INCOME (REST)
    private void addRest(Statement st, int periodId) throws SQLException {

	
        // PRODUCT DETAIL
        st.execute(
                "INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT WM.WAREHOUSE_ID, WM.MTRL_RESPONSIBLE_ID, PM.PRODUCT_ID, 0, 0, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT" +
        	" FROM PRODUCT_MOVE PM" +
                " INNER JOIN WAREHOUSE_MOVE WM ON WM.OWNER_ID = PM.OWNER_ID" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'REST' AND D.PERIOD_ID = " + periodId
        );
        

        // PRODUCT
        st.execute(
                "INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT PM.PRODUCT_ID, 0, 0, PM.QUANTITY * PM.UNIT_RATE, PM.AMOUNT" +                
        	" FROM PRODUCT_MOVE PM" +
                " INNER JOIN DOCUMENT D ON D.ID = PM.OWNER_ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'REST' AND D.PERIOD_ID = " + periodId
        );
        
    }
    
    // --------------------------------------------------------------------------------------------------------------------------------------
    // AFTERR BLOCK
    // --------------------------------------------------------------------------------------------------------------------------------------
    public void afterCompressionGoods(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException, FinderException, CreateException {

        stm.execute(
                "INSERT INTO M_PRODUCT_REGISTER_SUM (PRODUCT_ID, DEBIT_QUANTITY, CREDIT_QUANTITY, DEBIT_AMOUNT, CREDIT_AMOUNT) "+
                " SELECT R.PRODUCT_ID, SUM(R.DEBIT_QUANTITY), SUM(R.CREDIT_QUANTITY), SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_PRODUCT_REGISTER R"+
                " GROUP BY R.PRODUCT_ID"
        );

		
		
	 // -------------------------------------------------------------------------------------------------			 
	 // Populate temporable table M_PRODUCT_REGISTER_ID
	 // -------------------------------------------------------------------------------------------------
		
	 // Insert into M_PRODUCT_REGISTER_ID from PRODUCT_REGISTER
	 stm.execute(
	                "INSERT INTO M_PRODUCT_REGISTER_ID (PRODUCT_ID) " +
	                "    SELECT P.PRODUCT_ID FROM PRODUCT_REGISTER P" +
	                "    WHERE P.ORGANIZATION_ID = " + organizationId + " AND P.PERIOD_ID = " + prevPeriodId);
		 
	 // Insert into M_PRODUCT_REGISTER_ID from M_PRODUCT_REGISTER_SUM
	 stm.execute(
		 "INSERT INTO M_PRODUCT_REGISTER_ID (PRODUCT_ID) " +
	                "    SELECT R.PRODUCT_ID FROM M_PRODUCT_REGISTER_SUM R " +
	                "    WHERE NOT (R.PRODUCT_ID IN (SELECT I.PRODUCT_ID FROM M_PRODUCT_REGISTER_ID I))");

		 
		 
		 
		 
        stm.execute(
        	"DELETE FROM PRODUCT_REGISTER WHERE " +
                "ORGANIZATION_ID = " + organizationId + " AND "+
                "PERIOD_ID = " + newPeriodId);

        
        addProductRegister(stm, organizationId, prevPeriodId, newPeriodId); 
        
        /*
        String sql = "INSERT INTO product_register (" +
                " id," +
                " organization_id," +
                " period_id," +
                " product_id," +
                " debit_quantity," +
                " credit_quantity," +
                " quantity,"+
                " debit_amount," +
                " credit_amount, " +
                " amount) ";
		
		
		
        if (prevPeriodId > 0) {
			
            sql +=  " SELECT " + getNextValueSQL() + ", "+
                         organizationId + "," +
                         newPeriodId + "," +
                    "    u.product_id," +

			 getAddOprDouble("u1.debit_quantity", "u2.debit_quantity") + ", " +                        
			 getAddOprDouble("u1.credit_quantity", "u2.credit_quantity") + ", " +
			 "0.0," +
			 getAddOprDouble("u1.debit_amount", "u2.debit_amount") + ", " +						 
			 getAddOprDouble("u1.credit_amount", "u2.credit_amount") + "," + 
			 "0.0" +		 
                    " FROM" +
                    "    m_product_register_id u " +
                    "    LEFT JOIN product_register u1 ON u1.product_id = u.product_id AND u1.period_id = " + prevPeriodId +
                    "    LEFT JOIN m_product_register_sum u2 ON u2.product_id = u.product_id";
			
        } else {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                    "    product_id,"+
                    "    debit_quantity,"+
                    "    credit_quantity,"+
                    "    0.0," +
                    "    debit_amount,"+
                    "    credit_amount,"+
                    "    0.0" +
                    " FROM"+
                    "    m_product_register_sum";
        }

        stm.execute(sql);
        */

    }
    
    protected void addProductRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId)  throws SQLException {
	List<ProductInfo> productInfoList = getProductRegister(stm, organizationId, prevPeriodId, newPeriodId);
	if (productInfoList == null || productInfoList.size() == 0) {
	    return;
	}
	String sql = "INSERT INTO PRODUCT_REGISTER ("
	    + " ID,"
	    + " ORGANIZATION_ID," 
	    + " PERIOD_ID," 
	    + " PRODUCT_ID,"
    	    + " DEBIT_QUANTITY," 
    	    + " CREDIT_QUANTITY," 
	    + " DEBIT_AMOUNT," 
	    + " CREDIT_AMOUNT, " 
    	    + " QUANTITY,"	    
	    + " AMOUNT) "
	    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	ResultSet rs = stm.executeQuery("SELECT MAX(ID) FROM PRODUCT_REGISTER");
	rs.next();
	int id = rs.getInt(1);
	
	PreparedStatement ps = prepareStatement(sql);
	try {
	    for (ProductInfo info : productInfoList) {
		id++;
		ps.setInt(1, id);
		ps.setInt(2, organizationId);
		ps.setInt(3, newPeriodId);
		ps.setInt(4, info.productId);
		
		ps.setDouble(5, info.debitQuantity);
		ps.setDouble(6, info.creditQuantity);
		
		ps.setDouble(7, info.debitAmount);
		ps.setDouble(8, info.creditAmount);
		
		ps.setDouble(9, info.quantity);		
		ps.setDouble(10, info.amount);
		
		ps.execute();
	    }
	} finally {
	    close(rs);
	    close(ps);
	}
	
    }
    
    protected List<ProductInfo> getProductRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId)  throws SQLException {
	
	List<ProductInfo> productInfoList = null;
	String sql = null;
	ResultSet rs = null;
	try {
	    if (prevPeriodId > 0) {
		sql = " SELECT "
			+ " U.PRODUCT_ID,"
			+ " U1.DEBIT_QUANTITY,"
			+ " U2.DEBIT_QUANTITY, "
			+ " U1.CREDIT_QUANTITY,"
			+ " U2.CREDIT_QUANTITY,"
			+ " U1.DEBIT_AMOUNT,"
			+ " U2.DEBIT_AMOUNT,"
			+ " U1.CREDIT_AMOUNT,"
			+ " U2.CREDIT_AMOUNT"
			+ " FROM M_PRODUCT_REGISTER_ID U "
			+ " LEFT JOIN PRODUCT_REGISTER U1 ON U1.PRODUCT_ID = U.PRODUCT_ID AND U1.PERIOD_ID = "
			+ prevPeriodId
			+ " LEFT JOIN M_PRODUCT_REGISTER_SUM U2 ON U2.PRODUCT_ID = U.PRODUCT_ID";

		rs = stm.executeQuery(sql);
		productInfoList = new ArrayList<ProductInfo>();
		while (rs.next()) {
		    ProductInfo info = new ProductInfo();
		    info.productId = rs.getInt(1);

		    info.debitQuantity = rs.getDouble(2) + rs.getDouble(3);
		    info.creditQuantity = rs.getDouble(4) + rs.getDouble(5);

		    info.debitAmount = rs.getDouble(6) + rs.getDouble(7);
		    info.creditAmount = rs.getDouble(8) + rs.getDouble(9);

		    info.quantity = info.creditQuantity - info.debitQuantity;
		    info.amount = info.creditAmount - info.debitAmount;

		    productInfoList.add(info);
		}

	    } else {

		sql = " SELECT " 
			   + " PRODUCT_ID,"
			   + " DEBIT_QUANTITY,"
			   + " CREDIT_QUANTITY,"
			   + " DEBIT_AMOUNT,"
			   + " CREDIT_AMOUNT"
			   + " FROM M_PRODUCT_REGISTER_SUM";

		rs = stm.executeQuery(sql);
		productInfoList = new ArrayList<ProductInfo>();
		while (rs.next()) {
		    ProductInfo info = new ProductInfo();
		    info.productId = rs.getInt(1);

		    info.debitQuantity = rs.getDouble(2);
		    info.creditQuantity = rs.getDouble(3);

		    info.debitAmount = rs.getDouble(4);
		    info.creditAmount = rs.getDouble(5);

		    info.quantity = info.creditQuantity - info.debitQuantity;
		    info.amount = info.creditAmount - info.debitAmount;

		    productInfoList.add(info);
		}
	    }

	} finally {
	    close(rs);
	}
	
	return productInfoList;
    }

    public void afterCompressionGoodsDetail(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException, FinderException, CreateException {

        stm.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER_SUM (PRODUCT_ID, WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, DEBIT_QUANTITY, CREDIT_QUANTITY, DEBIT_AMOUNT, CREDIT_AMOUNT) "+
                " SELECT R.PRODUCT_ID, R.WAREHOUSE_ID, R.MTRL_RESPONSIBLE_ID, SUM(R.DEBIT_QUANTITY), SUM(R.CREDIT_QUANTITY), SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_PRODUCT_DETAIL_REGISTER R"+
                " GROUP BY R.PRODUCT_ID, R.WAREHOUSE_ID, R.MTRL_RESPONSIBLE_ID"
        );

		
		
	 // -------------------------------------------------------------------------------------------------			 
	 // Populate temporable table M_PRODUCT_DETAIL_REGISTER_ID
	 // -------------------------------------------------------------------------------------------------
		
	 // Insert into M_PRODUCT_DETAIL_REGISTER_ID from PRODUCT_DETAIL_REGISTER
	 stm.execute(
		 "INSERT INTO M_PRODUCT_DETAIL_REGISTER_ID (PRODUCT_ID, WAREHOUSE_ID, MTRL_RESPONSIBLE_ID) " +
	               "    SELECT P.PRODUCT_ID, P.WAREHOUSE_ID, P.MTRL_RESPONSIBLE_ID FROM PRODUCT_DETAIL_REGISTER P" +
	               "    WHERE P.ORGANIZATION_ID = " + organizationId + " AND P.PERIOD_ID = " + prevPeriodId);
		 
	 // Insert into M_PRODUCT_DETAIL_REGISTER_ID from M_PRODUCT_DETAIL_REGISTER_SUM
	 stm.execute(
		 "INSERT INTO M_PRODUCT_DETAIL_REGISTER_ID (PRODUCT_ID, WAREHOUSE_ID, MTRL_RESPONSIBLE_ID) " +
	               "    SELECT R.PRODUCT_ID, R.WAREHOUSE_ID, R.MTRL_RESPONSIBLE_ID FROM M_PRODUCT_DETAIL_REGISTER_SUM R " +
	               "    WHERE NOT (R.PRODUCT_ID IN (SELECT I.PRODUCT_ID FROM M_PRODUCT_REGISTER_ID I))");
		 
		 
        stm.execute(
        	"DELETE FROM PRODUCT_DETAIL_REGISTER WHERE " +
                "ORGANIZATION_ID = " + organizationId + " AND "+
                "PERIOD_ID = " + newPeriodId);

        addProductDetailsRegister(stm, organizationId, prevPeriodId, newPeriodId);

        /*
        String sql = "INSERT INTO product_detail_register (" +
                " id," +
                " organization_id," +
                " period_id," +
                " product_id," +
                " warehouse_id," +
                " responsible_id," +
                
                " debit_quantity," +
                " credit_quantity," +
                " quantity,"+
                " debit_amount," +
                " credit_amount," +
        	" amount) ";
		
        if (prevPeriodId > 0) {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                         
                    "    u.product_id," +
                    "    u.warehouse_id," +
                    "    u.responsible_id," +

                    getAddOprDouble("u1.debit_quantity", "u2.debit_quantity") + ", " +                        
                    getAddOprDouble("u1.credit_quantity", "u2.credit_quantity") + ", " +
                    "0.0," +		
                    
                    getAddOprDouble("u1.debit_amount", "u2.debit_amount") + ", " +						 
                    getAddOprDouble("u1.credit_amount", "u2.credit_amount") + ", " +
                    "0.0" +
                    
                    " FROM" +
                    "    m_product_detail_register_id u " +                        
                    "    LEFT JOIN product_detail_register u1 ON " +
                    "    (u1.product_id = u.product_id AND u1.warehouse_id = u.warehouse_id AND u1.responsible_id = u.responsible_id" +
					"    AND u1.period_id = " + prevPeriodId + ")"+
                    "    LEFT JOIN m_product_detail_register_sum u2 ON " +
                    "    (u2.product_id = u.product_id AND u2.warehouse_id = u.warehouse_id AND u2.responsible_id = u.responsible_id)";
        } else {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                         
                    "    product_id,"+
                    "    warehouse_id," +
                    "    responsible_id," +
                    
                    "    debit_quantity,"+
                    "    credit_quantity,"+
                    "    0.0," +
                    
                    "    debit_amount,"+
                    "    credit_amount,"+
                    "    0.0" +
                    
                    " FROM"+
                    "    m_product_detail_register_sum";
        }

        stm.execute(sql);
        */
        

   }
    
    protected void addProductDetailsRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId)  throws SQLException {
	List<ProductInfo> productInfoList = getProductDetailsRegister(stm, organizationId, prevPeriodId, newPeriodId);
	if (productInfoList == null || productInfoList.size() == 0) {
	    return;
	}
	String sql = "INSERT INTO PRODUCT_DETAIL_REGISTER ("
	    + " ID,"
	    + " ORGANIZATION_ID," 
	    + " PERIOD_ID," 
	    + " PRODUCT_ID,"
	    + " WAREHOUSE_ID,"
            + " MTRL_RESPONSIBLE_ID,"
    	    + " DEBIT_QUANTITY," 
    	    + " CREDIT_QUANTITY," 
	    + " DEBIT_AMOUNT," 
	    + " CREDIT_AMOUNT, " 
    	    + " QUANTITY,"	    
	    + " AMOUNT) "
	    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	ResultSet rs = stm.executeQuery("SELECT MAX(ID) FROM PRODUCT_DETAIL_REGISTER");
	rs.next();
	int id = rs.getInt(1);
	
	PreparedStatement ps = prepareStatement(sql);
	try {
	    for (ProductInfo info : productInfoList) {
		id++;
		ps.setInt(1, id);
		ps.setInt(2, organizationId);
		ps.setInt(3, newPeriodId);
		ps.setInt(4, info.productId);
		
		ps.setInt(5, info.warehouseId);
		ps.setInt(6, info.responsibleId);
		
		ps.setDouble(7, info.debitQuantity);
		ps.setDouble(8, info.creditQuantity);
		
		ps.setDouble(9, info.debitAmount);
		ps.setDouble(10, info.creditAmount);
		
		ps.setDouble(11, info.quantity);		
		ps.setDouble(12, info.amount);
		
		ps.execute();
	    }
	} finally {
	    close(rs);
	    close(ps);
	}
	
    }
    
    
    protected List<ProductInfo> getProductDetailsRegister(Statement stm, int organizationId, int prevPeriodId, int newPeriodId)  throws SQLException {
	
	List<ProductInfo> productInfoList = null;
	String sql = null;
	ResultSet rs = null;
	try {
	    if (prevPeriodId > 0) {
		sql = " SELECT "
			+ " U.PRODUCT_ID,"
			+ " U.WAREHOUSE_ID,"
			+ " U.MTRL_RESPONSIBLE_ID,"
			+ " U1.DEBIT_QUANTITY,"
			+ " U2.DEBIT_QUANTITY, "
			+ " U1.CREDIT_QUANTITY,"
			+ " U2.CREDIT_QUANTITY,"
			+ " U1.DEBIT_AMOUNT,"
			+ " U2.DEBIT_AMOUNT,"
			+ " U1.CREDIT_AMOUNT,"
			+ " U2.CREDIT_AMOUNT"
			+ " FROM M_PRODUCT_DETAIL_REGISTER_ID U "
			+ " LEFT JOIN PRODUCT_DETAIL_REGISTER U1 ON "
			+ " (U1.PRODUCT_ID = U.PRODUCT_ID AND U1.WAREHOUSE_ID = U.WAREHOUSE_ID AND U1.MTRL_RESPONSIBLE_ID = U.MTRL_RESPONSIBLE_ID"
			+ " AND U1.PERIOD_ID = " + prevPeriodId	+ ")"
			+ " LEFT JOIN M_PRODUCT_DETAIL_REGISTER_SUM U2 ON "
			+ " (U2.PRODUCT_ID = U.PRODUCT_ID AND U2.WAREHOUSE_ID = U.WAREHOUSE_ID AND U2.MTRL_RESPONSIBLE_ID = U.MTRL_RESPONSIBLE_ID)";
	            
	            
		rs = stm.executeQuery(sql);
		productInfoList = new ArrayList<ProductInfo>();
		while (rs.next()) {
		    ProductInfo info = new ProductInfo();
		    info.productId = rs.getInt(1);
		    info.warehouseId = rs.getInt(2);
		    info.responsibleId = rs.getInt(3);

		    info.debitQuantity = rs.getDouble(4) + rs.getDouble(5);
		    info.creditQuantity = rs.getDouble(6) + rs.getDouble(7);

		    info.debitAmount = rs.getDouble(8) + rs.getDouble(9);
		    info.creditAmount = rs.getDouble(10) + rs.getDouble(11);

		    info.quantity = info.creditQuantity - info.debitQuantity;
		    info.amount = info.creditAmount - info.debitAmount;

		    productInfoList.add(info);
		}

	    } else {

		sql = " SELECT " 
			   + " PRODUCT_ID,"
			   + " WAREHOUSE_ID,"
		           + " MTRL_RESPONSIBLE_ID,"
			   + " DEBIT_QUANTITY,"
			   + " CREDIT_QUANTITY,"
			   + " DEBIT_AMOUNT,"
			   + " CREDIT_AMOUNT"
			   + " FROM M_PRODUCT_DETAIL_REGISTER_SUM";

		rs = stm.executeQuery(sql);
		productInfoList = new ArrayList<ProductInfo>();
		while (rs.next()) {
		    ProductInfo info = new ProductInfo();
		    info.productId = rs.getInt(1);
		    info.warehouseId = rs.getInt(2);
		    info.responsibleId = rs.getInt(3);

		    info.debitQuantity = rs.getDouble(4);
		    info.creditQuantity = rs.getDouble(5);

		    info.debitAmount = rs.getDouble(6);
		    info.creditAmount = rs.getDouble(7);

		    info.quantity = info.creditQuantity - info.debitQuantity;
		    info.amount = info.creditAmount - info.debitAmount;

		    productInfoList.add(info);
		}
	    }

	} finally {
	    close(rs);
	}
	
	return productInfoList;
    }
    
    
    private class ProductInfo {
	
	int productId;
	
	int warehouseId;
	int responsibleId;
	
	double debitQuantity;
	double creditQuantity;
	
	double debitAmount;
	double creditAmount;
	
	double quantity;
	double amount;
    }

}
