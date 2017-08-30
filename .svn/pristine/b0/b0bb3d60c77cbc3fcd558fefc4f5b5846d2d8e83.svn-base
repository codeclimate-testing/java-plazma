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

package org.plazmaforge.framework.client.swt.report.jasperreports;


import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.report.engine.jasperreports.IReportPreview;

import org.plazmaforge.studio.reportviewer.ViewerApp;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
/** 
 * @author Oleh Hapon
 * $Id: SWTReportPreview.java,v 1.5 2010/04/28 06:36:49 ohapon Exp $
 */
public class SWTReportPreview implements IReportPreview {
    
    public void viewReport(JasperPrint jasperPrint, boolean isExitOnClose) throws JRException {
	
	if (isEmpty(jasperPrint)) {
	    Toolkit.openMessageDialog("Message", Messages.getString("SWTReportPreview.dataEmpty")); //$NON-NLS-2$
	    return;
	}
	XViewerApp app = new XViewerApp();
	//app.getReportViewer().loadDocument(fileName, isXMLFile);
	app.getReportViewer().setDocument(jasperPrint);
	app.open();
    }

    
    private boolean isEmpty(JasperPrint jasperPrint) {
	return (jasperPrint == null || jasperPrint.getPages() == null || jasperPrint.getPages().isEmpty());
    }
    
    class XViewerApp extends ViewerApp {
	
	protected void initializeBounds() {
	    super.initializeBounds();
	    SWTUtils.centerWindow(getShell());
	}
    }
}
