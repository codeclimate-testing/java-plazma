/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs.web.client;

import java.util.Map;

import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.data.DataWrapper;
import org.plazmaforge.framework.core.data.Parameters;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.core.service.ServiceCaller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author ohapon
 *
 */
public class WebApplicationServiceCaller implements ServiceCaller {
    
    /**
     * Call Service.
     */
    private final CallServiceAsync callService = GWT.create(CallService.class);
    
    private static final Logger logger = Logger.getLogger(WebApplicationServiceCaller.class.getName());

    public <T> void call(final String serviceName, final String methodName, final Object[] parameters, final Callback<T> callback) {

	// By Index
	callService.call(serviceName, methodName, Parameters.byIndex(parameters), Parameters.BY_INDEX,
		new AsyncCallback<DataWrapper>() {

		    @Override
		    public void onFailure(Throwable e) {
			Throwable cause = getClientCause(e);
			logger.error("Call service error: service=" + serviceName + ", method=" + methodName + ", parameters=[" + (parameters == null ? 0 : parameters.length) + "]", cause);
			callback.onFailure(cause);
		    }

		    @Override
		    public void onSuccess(DataWrapper result) {
			Object data = result.getData();
			callback.onSuccess((T) data);
		    }

		});
    }

    @Override
    public <T> void call(final String serviceName, final String methodName, final Map<String, Object> parameters, final Callback<T> callback) {
	
	// By name
	callService.call(serviceName, methodName, Parameters.byName(parameters), Parameters.BY_NAME,
		new AsyncCallback<DataWrapper>() {

		    @Override
		    public void onFailure(Throwable e) {
			Throwable cause = getClientCause(e);
			logger.error("Call service error: service=" + serviceName + ", method=" + methodName + ", parameters=[" + (parameters == null ? 0 : parameters.size()) + "]", cause);
			callback.onFailure(cause);
		    }

		    @Override
		    public void onSuccess(DataWrapper result) {
			Object data = result.getData();
			callback.onSuccess((T) data);
		    }

		});
    }

    private Throwable getClientCause(Throwable e) {
	if (e == null) {
	    return null;
	}
	Throwable cause = null;
	if (e instanceof ApplicationException) {
	    cause = ((ApplicationException) e).getCause();
	    if (cause == null) {
		return e;
	    }
	    return cause;
	}
	return e;
    }

}
