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

package org.plazmaforge.framework.client.swt.dialogs.dataimport;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.ISourceService;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.csv.CSVImporter;

/**
 * 
 * @author Oleh Hapon
 * $Id: CSVImportDialog.java,v 1.11 2010/12/05 07:52:26 ohapon Exp $
 */
public class CSVImportDialog extends AbstractImportDialog {

    private static final String[] FILTER = { "*.csv", "*.txt" };

    //FMT_ENCODING | FMT_DELIM | FMT_NULL | OPT_HDR | OPT_QUOTE | OPT_TRIM
    private static final int FLAGS = FMT_ENCODING | FMT_DELIM  | OPT_HDR | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

    private String[] columnNames;
    
    public CSVImportDialog(Shell parentShell) {
	super(parentShell);
    }

    public String[] getFileFilter() {
	return FILTER;
    }

    public int getFlags() {
	return FLAGS;

    }

    public String getMessage() {
	return Messages.getString("ImportDialog.csv.message");
    }

    public String getTitle() {
	return Messages.getString("ImportDialog.csv.title");
    }
    
    
    protected void createDetailOptions(Composite parent) {
	//createSelectionTableOptions(parent); // REFACTORED 2010-05-18
	createColumnMappingOptions(parent);
    }
    
    public IImporter createLocalImporter() throws ApplicationException {
	populateData(); // Transfer data from dialog controls to dialog properties
	if (isEmpty(getFileName())) {
	    return null;
	}	
	CSVImporter importer = new CSVImporter();
	initImporter(importer); // Initialize importer by dialog properties
	return importer;
    }
    
    public void initImporter(final IImporter importer) throws ApplicationException {
	super.initImporter(importer);
	((CSVImporter) importer).setColumnNames(columnNames);
    }
    
    protected ISourceService createSourceService() {
	ISourceService service = new ISourceService() {
	    
	    public String getFileName() {
		return getSelectionFileName();
	    }
	    
	    public String[] getSourceColumns() throws ApplicationException {
		CSVImporter importer = (CSVImporter) createLocalImporter();
		if (importer == null) {
		    return null;
		}
		importer.setColumnNames(null);
		return doLoadColumns(importer);
	    }
	    
	};
	return service;
    }
    
    protected String[] doLoadColumns(CSVImporter importer) throws ApplicationException {
	try {
	    columnNames = importer.loadColumns();
	} catch (ApplicationException ex) {
	    columnNames = null;
	    throw ex;
	}
	return columnNames;
    }
    
}
