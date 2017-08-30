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
 * Created on 12.02.2008
 *
 */

package org.plazmaforge.framework.client.swt.dialogs.dataexport;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/** 
 * @author Oleh Hapon
 * $Id: DatabaseXLSExportDialog.java,v 1.11 2010/05/16 09:47:54 ohapon Exp $
 */

public class DatabaseXLSExportDialog extends XLSExportDialog {

   
    public DatabaseXLSExportDialog(Shell parentShell) {
	super(parentShell);
    }

  
    
    protected void chooseFileSystemElement() {
	chooseDirectory();
    }
    
    protected boolean isCheckFile() {
	return false;
    }
    
    protected String getGroupFileSystemMessage() {
	return getGroupDirectoryMessage();
    }
    
    
    protected String getFileSystemErrorMessage() {
	return getDirectoryErrorMessage();
    }
    
    protected void createDetailOptions(Composite parent) {
	createTablesSelectionOptions(parent);
    }
    
    protected void populateConfigurer() {
	super.populateConfigurer();
	populateTablesSelectionConfigurer();
    }
    
    protected boolean isValid() {
	if (!super.isValid()) {
	    return false;
	}
	return isValidTableNames();
    }


}
