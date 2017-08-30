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


import java.sql.SQLException;
import java.sql.Statement;

import org.plazmaforge.bsolution.bank.common.services.BankCompressionExecutor;
import org.plazmaforge.bsolution.base.server.services.BaseCompressionExecutor;
import org.plazmaforge.framework.core.exception.ApplicationException;



/**
 * @author Oleh Hapon
 * Date: 03.01.2005
 * Time: 9:33:24
 * $Id: BankCompressionExecutorImpl.java,v 1.3 2010/12/05 07:55:57 ohapon Exp $
 */
public class BankCompressionExecutorImpl extends BaseCompressionExecutor implements BankCompressionExecutor {

    private final String PRODUCT_DOCUMENT_TYPE_SET = "'PAYMENT'"; // TODO: STUB
    
    private final String PRODUCT_DOCUMENT_TYPE_CLAUSE = " IN (" + PRODUCT_DOCUMENT_TYPE_SET + ") ";  
    
    
    public void executeCompression(Statement st, int periodId) throws SQLException {
	addIncome(st, periodId);
	addOutcome(st, periodId);
    }
    
    // + DOCUMENT INCOME
    private void addIncome(Statement st, int periodId) throws SQLException {
	st.execute("INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)" + 
		" SELECT D.PARTNER_ID, 0, FD.TOTAL FROM FINANCE_DOCUMENT FD" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'INPUT' AND D.PERIOD_ID = " + periodId);
    }

    // + DOCUMENT OUTCOME
    private void addOutcome(Statement st, int periodId) throws SQLException {
	st.execute("INSERT INTO M_PARTNER_REGISTER (PARTNER_ID, DEBIT_AMOUNT, CREDIT_AMOUNT)" + 
		" SELECT D.PARTNER_ID, FD.TOTAL, 0 FROM FINANCE_DOCUMENT FD" +
                " INNER JOIN DOCUMENT D ON D.ID = FD.ID" +
   	        " INNER JOIN DOCUMENT_TYPE T ON T.ID = D.DOCUMENT_TYPE_ID" + 
   	        " INNER JOIN FINANCE_DOCUMENT_TYPE FT ON FT.DOCUMENT_TYPE_ID = T.ID" +
                " WHERE T.DOCUMENT_SECTION" + PRODUCT_DOCUMENT_TYPE_CLAUSE + " AND FT.MOVE_TYPE = 'OUTPUT' AND D.PERIOD_ID = " + periodId);
    }
    
    public void beforeCompression(Statement stm, int periodId)
	    throws SQLException, ApplicationException {

    }

    public void afterCompression(Statement stm, int organizationId,
	    int prevPeriodId, int curPeriodId, int newPeriodId)
	    throws SQLException, ApplicationException {

    }

}
