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

import org.plazmaforge.framework.core.exception.ApplicationException;


import java.util.Map;
import java.awt.*;

/**
 * @author Oleh Hapon Date: 08.01.2005 Time: 17:34:08 $Id: SwingReportDialog.java,v 1.4 2010/12/05 07:52:09 ohapon Exp $
 */
public class SwingReportDialog extends AbstractSwingReportDialog {

    public SwingReportDialog() throws HeadlessException {

    }

    public SwingReportDialog(Frame owner) throws HeadlessException {
	super(owner);
    }

    public SwingReportDialog(Frame owner, boolean modal)
	    throws HeadlessException {
	super(owner, modal);
    }

    public SwingReportDialog(Frame owner, String title)
	    throws HeadlessException {
	super(owner, title);
    }

    public SwingReportDialog(Frame owner, String title, boolean modal)
	    throws HeadlessException {
	super(owner, title, modal);
    }

    public SwingReportDialog(Frame owner, String title, boolean modal,
	    GraphicsConfiguration gc) {
	super(owner, title, modal, gc);
    }

    public SwingReportDialog(Dialog owner) throws HeadlessException {
	super(owner);
    }

    public SwingReportDialog(Dialog owner, boolean modal)
	    throws HeadlessException {
	super(owner, modal);
    }

    public SwingReportDialog(Dialog owner, String title)
	    throws HeadlessException {
	super(owner, title);
    }

    public SwingReportDialog(Dialog owner, String title, boolean modal)
	    throws HeadlessException {
	super(owner, title, modal);
    }

    public SwingReportDialog(Dialog owner, String title, boolean modal,
	    GraphicsConfiguration gc) throws HeadlessException {
	super(owner, title, modal, gc);
    }

    public Map<String, Object> readParameters() throws ApplicationException {
	return getParameters();
    }

    protected JPanel createDialogPanel() {
	JPanel p = super.createDialogPanel();
	JLabel messageLabel = new JLabel(getResourceString("ReportDialog.start.report"));
	p.add(messageLabel);
	return p;
    }
}
