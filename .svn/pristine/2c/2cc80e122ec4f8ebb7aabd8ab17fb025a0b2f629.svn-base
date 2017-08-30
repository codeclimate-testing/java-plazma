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

package org.plazmaforge.framework.client.swt.dialogs;

import java.util.HashMap;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReportDialog;

/** 
 * @author Oleh Hapon
 * $Id: AbstractReportDialog.java,v 1.5 2010/12/05 07:52:25 ohapon Exp $
 */

public abstract class AbstractReportDialog extends AbstractJFaceDialog implements IReportDialog {

    private Map<String, Object> parameters = new HashMap<String, Object>();
    
    
    public AbstractReportDialog (Shell parent) {
	super (parent);
    }
      
    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText("Report Dialog"); //$NON-NLS-1$
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }

    public boolean isStartReport() throws ApplicationException {
        return (open() == OK) ? true : false;
    }
    
    

    protected Control createDialogArea(Composite parent) {

	// top level composite
	GridLayout gridLayout;

	Composite parentComposite = (Composite) super.createDialogArea(parent);
	parentComposite.setLayout(new FillLayout());

	Composite composite = new Composite(parentComposite, SWT.BORDER);

	//gridLayout = new GridLayout();
	//gridLayout.numColumns = 3;
	//composite.setLayout(gridLayout);

	// CONTENT PANEL
	createContentPanel(composite);

	parent.pack();

	return composite;

    }
    
    protected void createContentPanel(Composite parent) {
	
    }
    
    
    protected void okPressed() {
	populateData();
	super.okPressed();
    }

}
