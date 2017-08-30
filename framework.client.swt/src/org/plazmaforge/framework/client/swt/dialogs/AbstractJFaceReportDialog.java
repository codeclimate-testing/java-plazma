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
 * Created on 17.12.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import java.util.HashMap;
import java.util.Map;


import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReportDialog;

/** 
 * @author Oleh Hapon
 * $Id: AbstractJFaceReportDialog.java,v 1.4 2010/12/05 07:52:25 ohapon Exp $
 */

public abstract class AbstractJFaceReportDialog extends AbstractJFaceDialog implements IReportDialog {

    /** Special parameters for the Report **/
    private Map<String, Object> parameters = new HashMap<String, Object>();
    
    public AbstractJFaceReportDialog(IShellProvider parentShell) {
	super(parentShell);
    }

    public AbstractJFaceReportDialog(Shell parentShell) {
	super(parentShell);
    }
    
    protected Map<String, Object> getParameters() {
        return parameters;
    }

    public boolean isStartReport() throws ApplicationException {
        return (open() == OK) ? true : false;
    }
    

}
