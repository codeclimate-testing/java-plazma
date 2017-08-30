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

package org.plazmaforge.bsolution.base.client.swt.actions;

import org.eclipse.jface.window.Window;
import org.plazmaforge.framework.client.swt.app.SWTProcessRunner;
import org.plazmaforge.framework.client.swt.dialogs.dataimport.AbstractImportDialog;
import org.plazmaforge.framework.client.swt.dialogs.dataimport.ImportDialogFactory;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.ImportFactory;

/**
 * 
 * @author ohapon
 * $Id: AbstractDatabaseImportAction.java,v 1.2 2010/12/05 07:57:18 ohapon Exp $
 */
public abstract class AbstractDatabaseImportAction extends AbstractConvertAction {

    
    private static String IMPORT_SUCCESS_MESSAGE = Messages.getString("TransferResult.import.success");
    
    private static String IMPORT_FAIL_MESSAGE = Messages.getString("TransferResult.import.fail");
    
    private static String TARGET_EMPTY_MESSAGE = Messages.getString("TransferResult.target.empty");
    
    
    
    protected IImporter importer;
    
    protected AbstractImportDialog importDialog;
    
    
    
    protected void initRunner(SWTProcessRunner runner) {
    	runner.setResultDialog(true);
    	runner.setResultMessage(IMPORT_SUCCESS_MESSAGE);
    }

    
    protected void initImporter(AbstractImportDialog importDialog, IImporter importer) throws ApplicationException {
	importDialog.initImporter(importer);
    }
    
    
    protected boolean prepareProcess() throws ApplicationException {
	
	setCustomMode(false);
	
	if (isSupportCustomMode()) {
	    int type = getSelectionTransferType();
	    if (type == 0) {
		return false;
	    }
	    setCustomMode(getSelectionCustomMode(type));
	}
	 
	String format = getFormat();
	importer = ImportFactory.getImporter(format);
	if (importer == null) {
	    return false;
	}
	if (isCustomMode()) {
	    importer.setTransferService(getCustomTransferService());
	}
    	importDialog = (AbstractImportDialog) ImportDialogFactory.getImportDialog(format, getShell());
    	if (importDialog == null) {
    	    return false;
    	}
	if (isCustomMode()) {
	    importDialog.setTransferService(getCustomTransferService());
	    importDialog.setCustomMode(true);
	}
    	if (importDialog.open() != Window.OK) {
    	    return false;
    	}
    	return true;
    }

    
    protected void executeProcess() throws ApplicationException {
	if (importer == null) {
	    return;
	}
	initImporter(importDialog, importer);
	importer.execute();
    }

    protected String createResultMessage() {
	if (importer == null) {
	    return null;
	}
	TransferResult transferResult = importer.getTransferResult();
	if (transferResult == null) {
	    return null;
	}
	if (transferResult.getErrorMessage() != null) {
	    return IMPORT_FAIL_MESSAGE + ": " + transferResult.getErrorMessage(); 
	}
	
	if (transferResult.isEmptyData()) {
	    return TARGET_EMPTY_MESSAGE;
	}
	
	int processedRowCount = transferResult.getProcessedRowCount();
	if (processedRowCount > 0) {
	    return IMPORT_SUCCESS_MESSAGE + "\n" + Messages.getString("TransferResult.processed.rows" , processedRowCount);
	}
	return IMPORT_SUCCESS_MESSAGE;
	
    }
}
