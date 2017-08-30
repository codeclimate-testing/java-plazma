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



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.datawarehouse.convert.ISourceService;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.IImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.xml.XMLImporter;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.xml.XMLUtils;

/**
 * 
 * @author Oleh Hapon
 * $Id: XMLImportDialog.java,v 1.10 2010/12/05 07:52:26 ohapon Exp $
 */
public class XMLImportDialog extends AbstractImportDialog {

    private static final String[] FILTER = { "*.xml" };

    //FLAGS = FMT_ENCODING | FMT_NULL | OPT_HDR;
    private static final int FLAGS = PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;

    public final static String DEFAULT_PATH_EXPESSION = ".";
    
    private Text pathExpressionControl;
    
    private String pathExpression;
    
    private String[] columnNames;
    
    
    public XMLImportDialog(Shell parentShell) {
	super(parentShell);
    }

    protected void populateData() {
	super.populateData();
	pathExpression = getSelectionPathExpression();
    }
    
    public String[] getFileFilter() {
	return FILTER;
    }

    public int getFlags() {
	return FLAGS;

    }

    public String getMessage() {
	return Messages.getString("ImportDialog.xml.message");
    }

    public String getTitle() {
	return Messages.getString("ImportDialog.xml.title");
    }
    
    protected void createOptions(Composite parent) {
	createGeneralOptions(parent);
	createSpecialOptions(parent);
	createXPathOptions(parent);
	createFileSystemOptions(parent);
	createDetailOptions(parent);
    }

    protected void createDetailOptions(Composite parent) {
	//createSelectionTableOptions(parent);
	createColumnMappingOptions(parent);
    }
    
    protected void createXPathOptions(Composite parent) {

	Label l = null;
	Group fmtGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
	initPanelLayoutData(fmtGroup);
	fmtGroup.setText(Messages.getString("XMLExportDialog.group.xpath"));
	fmtGroup.setLayout(new GridLayout(2, false));
	l = new Label(fmtGroup, SWT.NONE);
	l.setText(Messages.getString("XMLExportDialog.xpath.expression"));
	pathExpressionControl = new Text(fmtGroup, SWT.SINGLE | SWT.BORDER | SWT.FILL);
	pathExpressionControl.setText(DEFAULT_PATH_EXPESSION);
	//pathExpressionControl.setLayoutData(new GridData(50, SWT.DEFAULT));
	pathExpressionControl.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
    }

    protected String getSelectionPathExpression() {
	return pathExpressionControl == null ? null : pathExpressionControl.getText();
    }
    
    public IImporter createLocalImporter() throws ApplicationException {
	populateData(); // Transfer data from dialog controls to dialog properties
	if (isEmpty(getFileName())) {
	    return null;
	}	
	XMLImporter importer = new XMLImporter();
	initImporter(importer); // Initialize importer by dialog properties
	return importer;
    }
    
    public void initImporter(final IImporter importer) throws ApplicationException {
	super.initImporter(importer);
	((XMLImporter) importer).setSelectExpression(getPathExpression());
	((XMLImporter) importer).setColumnNames(columnNames);
    }    
    
    protected ISourceService createSourceService() {
	ISourceService service = new ISourceService() {
	    
	    public String getFileName() {
		return getSelectionFileName();
	    }
	    
	    public String[] getSourceColumns() throws ApplicationException {
		XMLImporter importer = (XMLImporter) createLocalImporter();
		if (importer == null) {
		    return null;
		}
		return doLoadColumns(importer);
	    }
	    
	};
	return service;
    }
    
    protected String[] doLoadColumns(XMLImporter importer) throws ApplicationException {
	try {
	    columnNames = importer.loadColumns();
	} catch (ApplicationException ex) {
	    columnNames = null;
	    throw ex;
	}
	return columnNames;
    }

    public String getPathExpression() {
        return pathExpression;
    }    
    
    protected void afterUpdateFileSystemControl() {
	try {
	    String fileName = fileSystemControl.getText();
	    if (isEmpty(fileName)) {
		return;
	    }
	    String pathExpression = (XMLUtils.isPlatformXMLFormat(fileName)) ? "dataset/record" : DEFAULT_PATH_EXPESSION;
	    pathExpressionControl.setText(pathExpression);
	    
	} catch (ApplicationException ex) {

	}
    }
    
}
