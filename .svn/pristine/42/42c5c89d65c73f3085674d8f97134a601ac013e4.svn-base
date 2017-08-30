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
 * Created on 14.09.2007
 *
 */

package org.plazmaforge.framework.client.swt.dialogs.dataexport;

import org.eclipse.swt.widgets.Shell;

/** 
 * @author Oleh Hapon
 * $Id: RTFExportDialog.java,v 1.4 2010/05/26 17:21:54 ohapon Exp $
 */

public class RTFExportDialog extends AbstractExportDialog {

	private static final String[] FILTER = { "*.rtf" };

	private static final int FLAGS = OPT_HDR | FMT_NULL | PATTERN_DATE | PATTERN_TIME | PATTERN_NUMBER;
	
	public RTFExportDialog(Shell parentShell) {
		super(parentShell);
	}

	public String[] getFileFilter() {
		return FILTER;
	}

	public int getFlags() {
		return FLAGS;

	}

	public String getMessage() {
		return Messages.getString("ExportDialog.rtf.message");
	}

	public String getTitle() {
		return Messages.getString("ExportDialog.rtf.title");
	}
	
	protected boolean isCheckFile() {
		return true;
	}


}

