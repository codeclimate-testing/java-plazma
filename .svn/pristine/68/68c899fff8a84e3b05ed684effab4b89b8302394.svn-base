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
import org.plazmaforge.framework.config.configurer.DialogConfigurer;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IDialogConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.ClassUtilsExt;

/**
 * Dialog factory
 * @author ohapon
 *
 */
public class ReportDialogFactory extends AbstractConfigFactory {

    private static ReportDialogFactory instance;

    private ReportDialogFactory() {

    }

    public synchronized static ReportDialogFactory getInstance() {
	if (instance == null) {
	    instance = new ReportDialogFactory();
	}
	return instance;
    }

    @Override
    protected String getConfigurerName() {
	return DialogConfigurer.NAME;
    }

    /**
     * Get dialog by identifier
     * @param identifier
     * @return
     */
    public static IReportDialog getDialog(IConfigIdentifier identifier) {
	return getDialog((IDialogConfig) getInstance().getObjectConfig(identifier));
    }

    /**
     * Get dialog by dialogConfig
     * @param dialogConfig
     * @return
     */
    public static IReportDialog getDialog(IDialogConfig dialogConfig) {
	return getInstance().createDialog(dialogConfig);
    }
    
    /**
     * Create dialog
     * @param dialogConfig
     * @return
     */
    protected IReportDialog createDialog(IDialogConfig dialogConfig) {
	if (dialogConfig == null || isEmpty(dialogConfig.getClassName())) {
	    return null;
	}
	try {
	    return (IReportDialog) ClassUtilsExt.getClassInstance(dialogConfig.getClassName(), null);
	} catch (ApplicationException ex) {
	    logger.error("CreateDialogError", ex);
	    return null;
	}
    }

}
