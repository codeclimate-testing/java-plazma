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

package org.plazmaforge.bs.web.server;

import java.util.List;

import org.plazmaforge.bs.web.client.LogService;
import org.plazmaforge.framework.core.logging.LogRecord;
import org.plazmaforge.framework.core.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LogServiceImpl extends RemoteServiceServlet implements LogService {

    private static Logger logger = Logger.getLogger(LogServiceImpl.class.getName()); 

    
    @Override
    public void log(LogRecord record) {
	processLog(record);
    }

    @Override
    public void log(List<LogRecord> records) {
	if (records == null) {
	    return;
	}
	for (LogRecord record: records) {
	    processLog(record);
	}
    }
    
    protected Logger getLogger(String name) {
	if (name == null) {
	    return null;
	}
	return Logger.getLogger(name);
    }

    protected void processLog(LogRecord record) {
	if (record == null) {
	    return;
	}
	Logger logger = getLogger(record.getLoggerName());
	if (logger == null) {
	    logger = LogServiceImpl.logger;
	}
	logger.log(record);
    }

}
