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
 * Created on 11.09.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs.dataexport;




import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.core.FileFormat;

/** 
 * @author Oleh Hapon
 * $Id: ExportDialogFactory.java,v 1.4 2010/05/18 14:12:15 ohapon Exp $
 */

public class ExportDialogFactory {

  
    
    private ExportDialogFactory() {

    }

    /**
     * Return <code>Dialog</code> to configure export by format
     * @param format
     * @param shell
     * @return
     */
    public static Dialog getExportDialog(String format, Shell shell) {
	if (FileFormat.XML.equals(format)) {
	    return new XMLExportDialog(shell);
	} else if (FileFormat.CSV.equals(format)) {
	    return new CSVExportDialog(shell);
	} else if (FileFormat.HTML.equals(format)) {
	    return new HTMLExportDialog(shell);
	} else if (FileFormat.SQL.equals(format)) {
	    return new SQLExportDialog(shell);
	} else if (FileFormat.XLS.equals(format)) {
	    return new XLSExportDialog(shell);
	} else if (FileFormat.RTF.equals(format)) {
	    return new RTFExportDialog(shell);
	} else if (FileFormat.ODT.equals(format)) {
	    return new ODTExportDialog(shell);	    
	} else if (FileFormat.DATABASE_XML.equals(format)) {
	    return new DatabaseXMLExportDialog(shell);
	} else if (FileFormat.DATABASE_CSV.equals(format)) {
	    return new DatabaseCSVExportDialog(shell);
	}  else if (FileFormat.DATABASE_HTML.equals(format)) {
	    return new DatabaseHTMLExportDialog(shell);
	}  else if (FileFormat.DATABASE_XLS.equals(format)) {
	    return new DatabaseXLSExportDialog(shell);
	}  else if (FileFormat.DATABASE_RTF.equals(format)) {
	    return new DatabaseRTFExportDialog(shell);
	} 
 	return null;
    }
}
