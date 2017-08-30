package org.plazmaforge.framework.datawarehouse.convert;

import org.plazmaforge.framework.core.exception.ApplicationException;

public interface ISourceService {

    String getFileName();
    
    String[] getSourceColumns() throws ApplicationException;
    
}
