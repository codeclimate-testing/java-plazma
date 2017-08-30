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

package org.plazmaforge.framework.datawarehouse.convert.dataimport;

import org.plazmaforge.framework.core.datastorage.DSDataSet;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.ITransferService;
import org.plazmaforge.framework.datawarehouse.TransferInfo;
import org.plazmaforge.framework.datawarehouse.TransferResult;


public interface IDataSetImporter {

    ITransferService getTransferService();

    void setTransferService(ITransferService transferService);
    
    
    DSDataSet getDataSet();

    void setDataSet(DSDataSet dataSet);

    TransferInfo getTransferInfo();

    void setTransferInfo(TransferInfo transferInfo);
    
    TransferResult getTransferResult();

    void setTransferResult(TransferResult transferResult);
    
    
    
    void importDataSet(IImporter importer) throws ApplicationException;

    
    boolean isEnableClearTable();

    void setEnableClearTable(boolean enableClearTable);

    boolean isEnableAutoPrimaryKey();

    void setEnableAutoPrimaryKey(boolean enableAutoPrimaryKey);

    boolean isClearTable();

    void setClearTable(boolean clearTable);

    boolean isAutoPrimaryKey();

    void setAutoPrimaryKey(boolean autoPrimaryKey);

    
}
