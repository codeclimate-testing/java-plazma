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

package org.plazmaforge.bsolution.goods.server.services;


import java.sql.SQLException;
import java.sql.Statement;

import org.plazmaforge.bsolution.base.server.services.BaseCompressionExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.CreateException;
import org.plazmaforge.framework.core.exception.FinderException;


/**
 * @author Oleh Hapon
 * Date: 03.01.2005
 * Time: 9:46:27
 * $Id: GoodsCompressionExecutorImpl.java,v 1.3 2010/12/05 07:56:00 ohapon Exp $
 */
public class GoodsCompressionExecutorImpl extends BaseCompressionExecutor {

    public void executeCompression(Statement stm, int periodId) throws SQLException {
	
	if (!isEnable()) {
	    return;
	}
	
        addCredit(stm, periodId);	// + INCOME
        addDebit(stm, periodId); 	// - OUTCOME
        
        //addMove(stm, periodId); 	//   DISABLE (No reason)
        
        addWriteoff(stm, periodId);	// -
        addRest(stm, periodId);		// +
        
    }

    private boolean isEnable() {
	return false;
    }
    
    
    public void beforeCompression(Statement stm, int periodId) throws SQLException, ApplicationException {
        //stm.execute("DELETE FROM m_product_register");
        //stm.execute("DELETE FROM m_product_detail_register");
    }
	
    public void afterCompression(Statement stm, int organizationId, int prevPeriodId, int curPeriodId, int newPeriodId) throws SQLException, ApplicationException {
       // afterCompressionGoods(stm, organizationId, prevPeriodId, newPeriodId);
        //afterCompressionGoodsDetail(stm, organizationId, prevPeriodId, newPeriodId);
    }
	
	
    // + DOCUMENT INCOME
    private void addCredit(Statement st, int periodId) throws SQLException {

	// PARTNER
        st.execute(
        	"INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT D.PARTNER_ID, 0, D.TOTAL FROM GOODS_INCOME AD"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " WHERE D.PERIOD_ID = " + periodId
        );

        
        // PRODUCT DETAIL
        st.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT AD.WAREHOUSE_ID, AD.MTRL_RESPONSIBLE_ID, G.ID, 0, 0, I.QUANTITY * I.UNIT_RATE, I.AMOUNT FROM GOODS_INCOME_ITEM I"+
                " INNER JOIN GOODS_INCOME AD ON AD.ID = I.GOODS_INCOME_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );

        // PRODUCT
        st.execute(
        	"INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                "SELECT G.ID, 0, 0, I.QUANTITY * I.UNIT_RATE, I.AMOUNT FROM GOODS_INCOME_ITEM I"+
                " INNER JOIN GOODS_INCOME AD ON AD.ID = I.GOODS_INCOME_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );
    }

    // - DOCUMENT OUTCOME
    private void addDebit(Statement st, int periodId) throws SQLException {
	
	// PARTNER
        st.execute(
        	"INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)"+
                " SELECT D.PARTNER_ID, D.TOTAL, 0 FROM GOODS_OUTCOME AD"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " WHERE D.PERIOD_ID = " + periodId
        );

        // PRODUCT DETAIL
        st.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT AD.WAREHOUSE_ID, AD.MTRL_RESPONSIBLE_ID, G.ID, I.QUANTITY * I.UNIT_RATE, I.AMOUNT, 0, 0 FROM GOODS_OUTCOME_ITEM I"+
                " INNER JOIN GOODS_OUTCOME AD ON AD.ID = I.GOODS_OUTCOME_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );

        // PRODUCT
        st.execute(
        	"INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                "SELECT G.ID, I.QUANTITY * I.UNIT_RATE, I.AMOUNT, 0, 0 FROM GOODS_OUTCOME_ITEM I"+
                " INNER JOIN GOODS_OUTCOME AD ON AD.ID = I.GOODS_OUTCOME_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );
    }

    // DISABLE
    /*
    private void addMove(Statement st, int periodId) throws SQLException {

    	// INCOME
        st.execute(
                "INSERT INTO m_product_detail_register (warehouse_id, responsible_id, product_id, debit_quantity, debit_amount, credit_quantity, credit_amount)"+
                " SELECT ad.credit_warehouse_id, ad.credit_responsible_id, g.id, 0, 0, i.quantity * i.unit_rate, i.amount FROM goods_move_item i"+
                " INNER JOIN goods_move ad ON ad.id = i.goods_move_id"+
                " INNER JOIN goods g ON g.id = i.product_id"+
                " WHERE ad.period_id = " + periodId
        );

        // OUTCOME
        st.execute(
                "INSERT INTO m_product_detail_register (warehouse_id, responsible_id, product_id, debit_quantity, debit_amount, credit_quantity, credit_amount)"+
                " SELECT ad.debit_warehouse_id, ad.debit_responsible_id, g.id, i.quantity * i.unit_rate, i.amount, 0, 0 FROM goods_move_item i"+
                " INNER JOIN goods_move ad ON ad.id = i.goods_move_id"+
                " INNER JOIN goods g ON g.id = i.product_id"+
                " WHERE ad.period_id = " + periodId
        );
    }
    */

    
    //  TODO: Remove to DOCUMENT OUTCOME 
    // - DOCUMENT OUTCOME (WRITEOFF)
    private void addWriteoff(Statement st, int periodId) throws SQLException {

        st.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT AD.WAREHOUSE_ID, AD.MTRL_RESPONSIBLE_ID, G.ID, 0, 0, I.QUANTITY * I.UNIT_RATE, I.AMOUNT FROM GOODS_WRITEOFF_ITEM I"+
                " INNER JOIN GOODS_WRITEOFF AD ON AD.ID = I.GOODS_WRITEOFF_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );

        st.execute(
        	"INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                "SELECT G.ID, 0, 0, I.QUANTITY * I.UNIT_RATE, I.AMOUNT FROM GOODS_WRITEOFF_ITEM I"+
                " INNER JOIN GOODS_WRITEOFF AD ON AD.ID = I.GOODS_WRITEOFF_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );
    }

    // TODO: Use document category REST without concrete document
    // + DOCUMENT OUTCOME (REST)
    private void addRest(Statement st, int periodId) throws SQLException {

        st.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER (WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                " SELECT AD.WAREHOUSE_ID, AD.MTRL_RESPONSIBLE_ID, G.ID, I.QUANTITY * I.UNIT_RATE, I.AMOUNT, 0, 0 FROM GOODS_REST_ITEM I"+
                " INNER JOIN GOODS_REST AD ON AD.ID = I.GOODS_REST_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );

        st.execute(
        	"INSERT INTO M_PRODUCT_REGISTER (PRODUCT_ID, DEBIT_QUANTITY, DEBIT_AMOUNT, CREDIT_QUANTITY, CREDIT_AMOUNT)"+
                "SELECT G.ID, I.QUANTITY * I.UNIT_RATE, I.AMOUNT, 0, 0 FROM GOODS_REST_ITEM I"+
                " INNER JOIN GOODS_REST AD ON AD.ID = I.GOODS_REST_ID"+
                " INNER JOIN V_FINANCE_DOCUMENT D ON D.ID = AD.ID"+                
                " INNER JOIN GOODS G ON G.ID = I.PRODUCT_ID"+
                " WHERE D.PERIOD_ID = " + periodId
        );
    }
	
	
    // --------------------------------------------------------------------------------------------------------------------------------------------
	
	
    public void afterCompressionGoods(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException, FinderException, CreateException {

        stm.execute("DELETE FROM M_PRODUCT_REGISTER_SUM");

        stm.execute(
        	"INSERT INTO M_PRODUCT_REGISTER_SUM (PRODUCT_ID, DEBIT_QUANTITY, CREDIT_QUANTITY, DEBIT_AMOUNT, CREDIT_AMOUNT) "+
                " SELECT R.PRODUCT_ID, SUM(R.DEBIT_QUANTITY), SUM(R.CREDIT_QUANTITY), SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_PRODUCT_REGISTER R"+
                " GROUP BY R.PRODUCT_ID"
        );

		
		
	 // -------------------------------------------------------------------------------------------------			 
	 // Populate temporable table M_PRODUCT_REGISTER_ID
	 // -------------------------------------------------------------------------------------------------
		
	 // Delete from M_PRODUCT_REGISTER_ID
        stm.execute(
        	"DELETE FROM M_PRODUCT_REGISTER_ID");

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

        String sql = "INSERT INTO PRODUCT_REGISTER (" +
        " ID," +
        " ORGANIZATION_ID," +
        " PERIOD_ID," +
        " PRODUCT_ID," +
        " DEBIT_QUANTITY," +
        " CREDIT_QUANTITY," +
        " DEBIT_AMOUNT," +
        " CREDIT_AMOUNT) ";
		
		
		
        if (prevPeriodId > 0) {
			
            sql +=  " SELECT " + getNextValueSQL() + ", "+
                         organizationId + "," +
                         newPeriodId + "," +
                         "    U.PRODUCT_ID," +

			 getAddOprDouble("U1.DEBIT_QUANTITY", "U2.DEBIT_QUANTITY") + ", " +                        
			 getAddOprDouble("U1.CREDIT_QUANTITY", "U2.CREDIT_QUANTITY") + ", " +
			 getAddOprDouble("U1.DEBIT_AMOUNT", "U2.DEBIT_AMOUNT") + ", " +						 
			 getAddOprDouble("U1.CREDIT_AMOUNT", "U2.CREDIT_AMOUNT") + 
					 
			  " FROM" +
	                    "    M_PRODUCT_REGISTER_ID U " +
	                    "    LEFT JOIN PRODUCT_REGISTER U1 ON U1.PRODUCT_ID = U.PRODUCT_ID AND U1.PERIOD_ID = " + prevPeriodId +
	                    "    LEFT JOIN M_PRODUCT_REGISTER_SUM U2 ON U2.PRODUCT_ID = U.PRODUCT_ID";
			
        } else {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                         "    PRODUCT_ID,"+
                         "    DEBIT_QUANTITY,"+
                         "    CREDIT_QUANTITY,"+
                         "    DEBIT_AMOUNT,"+
                         "    CREDIT_AMOUNT"+
                         " FROM"+
                         "    M_PRODUCT_REGISTER_SUM";
        }

        stm.execute(sql);

        //st.executeBatch();

    }

    public void afterCompressionGoodsDetail(Statement stm, int organizationId, int prevPeriodId, int newPeriodId) throws SQLException, FinderException, CreateException {

        stm.execute("DELETE FROM M_PRODUCT_DETAIL_REGISTER_SUM");

        stm.execute(
        	"INSERT INTO M_PRODUCT_DETAIL_REGISTER_SUM (PRODUCT_ID, WAREHOUSE_ID, MTRL_RESPONSIBLE_ID, DEBIT_QUANTITY, CREDIT_QUANTITY, DEBIT_AMOUNT, CREDIT_AMOUNT) "+
                " SELECT R.PRODUCT_ID, R.WAREHOUSE_ID, R.MTRL_RESPONSIBLE_ID, SUM(R.DEBIT_QUANTITY), SUM(R.CREDIT_QUANTITY), SUM(R.DEBIT_AMOUNT), SUM(R.CREDIT_AMOUNT) FROM M_PRODUCT_DETAIL_REGISTER R"+
                " GROUP BY R.PRODUCT_ID, R.WAREHOUSE_ID, R.MTRL_RESPONSIBLE_ID"
        );

		
		
	 // -------------------------------------------------------------------------------------------------			 
	 // Populate temporable table M_PRODUCT_DETAIL_REGISTER_ID
	 // -------------------------------------------------------------------------------------------------
		
	 // Delete from M_PRODUCT_DETAIL_REGISTER_ID
         stm.execute(
        	 "DELETE FROM M_PRODUCT_DETAIL_REGISTER_ID");

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

        String sql = "INSERT INTO PRODUCT_DETAIL_REGISTER (" +
        	" ID," +
        	" ORGANIZATION_ID," +
        	" PERIOD_ID," +
        	" PRODUCT_ID," +
        	" WAREHOUSE_ID," +
        	" MTRL_RESPONSIBLE_ID," +
        
        	" DEBIT_QUANTITY," +
        	" CREDIT_QUANTITY," +
        	" DEBIT_AMOUNT," +
        	" CREDIT_AMOUNT) ";
		
        if (prevPeriodId > 0) {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                         
                         "    U.PRODUCT_ID," +
                         "    U.WAREHOUSE_ID," +
                         "    U.MTRL_RESPONSIBLE_ID," +

					 getAddOprDouble("U1.DEBIT_QUANTITY", "U2.DEBIT_QUANTITY") + ", " +                        
					 getAddOprDouble("U1.CREDIT_QUANTITY", "U2.CREDIT_QUANTITY") + ", " +
					 getAddOprDouble("U1.DEBIT_AMOUNT", "U2.DEBIT_AMOUNT") + ", " +						 
					 getAddOprDouble("U1.CREDIT_AMOUNT", "U2.CREDIT_AMOUNT") + 
                    
					 " FROM" +
			                    "    M_PRODUCT_DETAIL_REGISTER_ID U " +                        
			                    "    LEFT JOIN PRODUCT_DETAIL_REGISTER U1 ON " +
			                    "    (U1.PRODUCT_ID = U.PRODUCT_ID AND U1.WAREHOUSE_ID = U.WAREHOUSE_ID AND U1.MTRL_RESPONSIBLE_ID = U.MTRL_RESPONSIBLE_ID" +
			                    "    AND U1.PERIOD_ID = " + prevPeriodId + ")"+
			                    "    LEFT JOIN M_PRODUCT_DETAIL_REGISTER_SUM U2 ON " +
			                    "    (U2.PRODUCT_ID = U.PRODUCT_ID AND U2.WAREHOUSE_ID = U.WAREHOUSE_ID AND U2.MTRL_RESPONSIBLE_ID = U.MTRL_RESPONSIBLE_ID)";
        } else {
			
            sql +=  " SELECT " + getNextValueSQL() + ", " +
                         organizationId + "," +
                         newPeriodId + "," +
                         "    PRODUCT_ID,"+
                         "    WAREHOUSE_ID," +
                         "    MTRL_RESPONSIBLE_ID," +
                         
                         "    DEBIT_QUANTITY,"+
                         "    CREDIT_QUANTITY,"+
                         "    DEBIT_AMOUNT,"+
                         "    CREDIT_AMOUNT"+
                         " FROM"+
                         "    M_PRODUCT_DETAIL_REGISTER_SUM";
        }

        stm.execute(sql);

        //st.executeBatch();

   }

	
	
	
	

}
