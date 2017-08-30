package org.plazmaforge.bs.web.client;



import org.plazmaforge.framework.core.data.DataWrapper;
import org.plazmaforge.framework.core.data.Parameters;
import org.plazmaforge.framework.core.exception.ApplicationException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("call")
public interface CallService extends RemoteService {

    void addWhitelist(CallWhitelist whitelist);
    
    DataWrapper call(String service, String method, Parameters parameters, String type) throws ApplicationException;
    
}
