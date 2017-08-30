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
import org.plazmaforge.framework.client.swt.dialogs.dataexport.AbstractExportDialog;
import org.plazmaforge.framework.client.swt.dialogs.dataexport.ExportDialogFactory;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.TransferResult;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.ExportFactory;
import org.plazmaforge.framework.datawarehouse.convert.dataexport.IExporter;

/**
 * 
 * @author ohapon
 * $Id: AbstractDatabaseExportAction.java,v 1.9 2010/12/05 07:57:18 ohapon Exp $
 */
public abstract class AbstractDatabaseExportAction extends AbstractConvertAction  {

    private static String EXPORT_SUCCESS_MESSAGE = Messages.getString("TransferResult.export.success");
    
    private static String EXPORT_FAIL_MESSAGE = Messages.getString("TransferResult.export.fail");
    
    private static String EXPORT_EMPTY_MESSAGE = Messages.getString("TransferResult.source.empty");

    
    protected IExporter exporter;
    
    protected AbstractExportDialog exportDialog;
    
    
    
    protected void initRunner(SWTProcessRunner runner) {
    	runner.setResultDialog(true);
    	runner.setResultMessage(Messages.getString("DatabaseExportAction.result"));
    }

    
    protected void initExporter(AbstractExportDialog exportDialog, IExporter exporter) throws ApplicationException {
	exportDialog.initExporter(exporter);
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
	exporter = ExportFactory.getExporter(format);
	if (exporter == null) {
	    return false;
	}
	if (isCustomMode()) {
	    exporter.setTransferService(getCustomTransferService());
	}
    	exportDialog = (AbstractExportDialog) ExportDialogFactory.getExportDialog(format, getShell());
    	if (exportDialog == null) {
    	    return false;
    	}
	if (isCustomMode()) {
	    exportDialog.setTransferService(getCustomTransferService());
	    exportDialog.setCustomMode(true);
	}
    	if (exportDialog.open() != Window.OK) {
    	    return false;
    	}
    	return true;
    }

    
    protected void executeProcess() throws ApplicationException {
	if (exporter == null) {
	    return;
	}
	initExporter(exportDialog, exporter);
	exporter.execute();
    }
    
    protected String createResultMessage() {
	if (exporter == null) {
	    return null;
	}
	TransferResult transferResult = exporter.getTransferResult();
	if (transferResult == null) {
	    return null;
	}
	if (transferResult.getErrorMessage() != null) {
	    return EXPORT_FAIL_MESSAGE + ": " + transferResult.getErrorMessage(); 
	}
	
	if (transferResult.isEmptyData()) {
	    return EXPORT_EMPTY_MESSAGE;
	}
	
	String message = EXPORT_SUCCESS_MESSAGE;
	if (transferResult.getDataSetCount() > 0) {
	    message += "\n" + Messages.getString("TransferResult.processed.tables" , transferResult.getDataSetCount());
	}
        if (transferResult.getDataSetCount() == 0 || transferResult.getDataSetCount() == 1 || transferResult.getDataRowCount() == 0) {
            message += "\n" + Messages.getString("TransferResult.processed.rows" , transferResult.getDataRowCount());
        }
	return message;
	
    }
}
