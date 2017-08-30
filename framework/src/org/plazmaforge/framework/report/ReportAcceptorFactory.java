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

/*
 * 18.02.2006
 */

package org.plazmaforge.framework.report;

import org.plazmaforge.framework.config.AbstractConfigFactory;
import org.plazmaforge.framework.config.configurer.AcceptorConfigurer;
import org.plazmaforge.framework.config.object.IAcceptorConfig;
import org.plazmaforge.framework.config.object.IReportConfig;
import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;

/**
 * Report acceptor factory
 * @author ohapon
 *
 */
public class ReportAcceptorFactory extends AbstractConfigFactory {

    private static ReportAcceptorFactory instance;

    private ReportAcceptorFactory() {

    }

    public synchronized static ReportAcceptorFactory getInstance() {
	if (instance == null) {
	    instance = new ReportAcceptorFactory();
	}
	return instance;
    }

    @Override
    protected String getConfigurerName() {
	return AcceptorConfigurer.NAME;
    }

    /**
     * Get acceptor by reportConfig
     * @param reportConfig
     * @return
     */
    public static IAcceptor getAcceptor(IReportConfig reportConfig) {
	if (reportConfig == null) {
	    return null;
	}
	return getAcceptor(reportConfig, reportConfig.getAcceptor());
    }

    /**
     * Get acceptor by reportConfig and acceptor
     * @param reportConfig
     * @param identifier
     * @return
     */
    public static IAcceptor getAcceptor(IReportConfig reportConfig, String acceptor) {
	IAcceptorConfig acceptorConfig = (IAcceptorConfig) getInstance().getObjectConfigByName(acceptor);
	return getAcceptor(reportConfig, acceptorConfig);
    }

    /**
     * Get acceptor by reportConfig and acceptorConfig
     * @param reportConfig
     * @param acceptorConfig
     * @return
     */
    public static IAcceptor getAcceptor(IReportConfig reportConfig, IAcceptorConfig acceptorConfig) {
	return getInstance().createAcceptor(reportConfig, acceptorConfig);
    }

    /**
     * Create acceptor
     * @param reportConfig
     * @param acceptorConfig
     * @return
     */
    protected IAcceptor createAcceptor(IReportConfig reportConfig, IAcceptorConfig acceptorConfig) {
	
	if (acceptorConfig == null) {
	    return null;
	}
	String className = acceptorConfig.getClassName();

	if (!isEmpty(className)) {
	    return createAcceptorByClass(reportConfig, className);
	}
	
	return null;
	
	
	    // TODO:
	    // 2008-11-26

	    /*
	    ReportDialogAcceptor acceptor = new ReportDialogAcceptor();
	    ConfigIdentifier dialogIdentifier = null;
	    if (!isEmpty(acceptorConfig.getDialogIdentifier())) {
		dialogIdentifier = acceptorConfig.getDialogIdentifier();
	    } else {
		dialogIdentifier = reportConfig.getDialogIdentifier();
	    }
	    acceptor.setReportDialog(ReportDialogFactory.getDialog(dialogIdentifier));
	    return acceptor;
	    */
    }
    
    /**
     * Create acceptor by class
     * @param reportConfig
     * @param className
     * @return
     */
    protected IAcceptor createAcceptorByClass(IReportConfig reportConfig, String className) {
	try {
	    return (IAcceptor) ClassUtilsExt.getClassInstance(className);
	} catch (ApplicationException ex) {
	    logger.error("Error create acceptor by class", ex);
	    return null;
	}
    }

}
