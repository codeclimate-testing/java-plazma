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

package org.plazmaforge.framework.datawarehouse;

import java.io.Serializable;

public class TransferResult implements Serializable {


    private int dataSetCount;
    
    ////
    
    private int dataRowCount;
    
    ////
    
    private int insertRowCount;
    
    private int updateRowCount;
    
    private int deleteRowCount;
    
    ////
    
    private boolean emptyData;
    
    private String errorMessage;
    
    

    public int getDataSetCount() {
        return dataSetCount;
    }

    public void setDataSetCount(int dataSetCount) {
        this.dataSetCount = dataSetCount;
    }

    public int getDataRowCount() {
        return dataRowCount;
    }

    public void setDataRowCount(int dataRowCount) {
        this.dataRowCount = dataRowCount;
    }

    public int getInsertRowCount() {
        return insertRowCount;
    }

    public void setInsertRowCount(int insertRowCount) {
        this.insertRowCount = insertRowCount;
    }

    public int getUpdateRowCount() {
        return updateRowCount;
    }

    public void setUpdateRowCount(int updateRowCount) {
        this.updateRowCount = updateRowCount;
    }

    public int getDeleteRowCount() {
        return deleteRowCount;
    }

    public void setDeleteRowCount(int deleteRowCount) {
        this.deleteRowCount = deleteRowCount;
    }

    public boolean isEmptyData() {
        return emptyData;
    }

    public void setEmptyData(boolean emptyData) {
        this.emptyData = emptyData;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public int getProcessedRowCount() {
	return insertRowCount + updateRowCount + deleteRowCount;
    }
}
