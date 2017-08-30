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
package org.plazmaforge.framework.client.swing.report;

import javax.swing.*;

import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.report.IReportDialog;


import java.util.Map;
import java.util.HashMap;
import java.awt.*;

/**
 * @author Oleh Hapon Date: 08.01.2005 Time: 17:12:02 $Id: AbstractSwingReportDialog.java,v 1.5 2010/12/05 07:52:09 ohapon Exp $
 */
public abstract class AbstractSwingReportDialog extends OptionDialog implements	IReportDialog {

    private Map<String, Object> parameters = new HashMap<String, Object>();

    public AbstractSwingReportDialog() throws HeadlessException {
	initTitle();
    }

    public AbstractSwingReportDialog(Frame owner) throws HeadlessException {
	super(owner);
	initTitle();
    }

    public AbstractSwingReportDialog(Frame owner, boolean modal)
	    throws HeadlessException {
	super(owner, modal);
	initTitle();
    }

    public AbstractSwingReportDialog(Frame owner, String title)
	    throws HeadlessException {
	super(owner, title);
    }

    public AbstractSwingReportDialog(Frame owner, String title, boolean modal)
	    throws HeadlessException {
	super(owner, title, modal);
    }

    public AbstractSwingReportDialog(Frame owner, String title, boolean modal,
	    GraphicsConfiguration gc) {
	super(owner, title, modal, gc);
    }

    public AbstractSwingReportDialog(Dialog owner) throws HeadlessException {
	super(owner);
	initTitle();
    }

    public AbstractSwingReportDialog(Dialog owner, boolean modal)
	    throws HeadlessException {
	super(owner, modal);
	initTitle();
    }

    public AbstractSwingReportDialog(Dialog owner, String title)
	    throws HeadlessException {
	super(owner, title);
    }

    public AbstractSwingReportDialog(Dialog owner, String title, boolean modal)
	    throws HeadlessException {
	super(owner, title, modal);
    }

    public AbstractSwingReportDialog(Dialog owner, String title, boolean modal,
	    GraphicsConfiguration gc) throws HeadlessException {
	super(owner, title, modal, gc);
    }

    protected void initTitle() {
	setTitle(getResourceString("ReportDialog.title"));
    }

    protected Map<String, Object> getParameters() {
	return parameters;
    }

    public boolean isStartReport() throws ApplicationException {
	return (showDialog() == JOptionPane.OK_OPTION) ? true : false;
    }

}
