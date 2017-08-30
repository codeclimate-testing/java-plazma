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
package org.plazmaforge.framework.report.engine.jfreereport;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;
import javax.swing.Action;
import javax.swing.JDialog;

import org.jfree.report.JFreeReport;
import org.jfree.report.ReportProcessingException;
import org.jfree.report.modules.gui.base.PreviewProxy;
import org.jfree.report.modules.gui.base.CloseAction;
import org.jfree.report.modules.gui.base.PreviewProxyBase;

public class JFreeReportPreviewDialog extends JDialog implements PreviewProxy {

    private class DefaultCloseAction extends CloseAction {

	public DefaultCloseAction() {
	    super(getResources());
	}

	public void actionPerformed(final ActionEvent e) {
	    if (getDefaultCloseOperation() == DISPOSE_ON_CLOSE) {
		dispose();
	    } else {
		setVisible(false);
	    }
	}
    }

    private PreviewProxyBase base;

    private ResourceBundle resources;

    public JFreeReportPreviewDialog(final JFreeReport report)
	    throws ReportProcessingException {
	init(report);
    }

    public JFreeReportPreviewDialog(final JFreeReport report, final Frame owner)
	    throws ReportProcessingException {
	super(owner);
	init(report);
    }

    public JFreeReportPreviewDialog(final JFreeReport report,
	    final Frame owner, final boolean modal)
	    throws ReportProcessingException {
	super(owner, modal);
	init(report);
    }

    public JFreeReportPreviewDialog(final JFreeReport report, final Dialog owner)
	    throws ReportProcessingException {
	super(owner);
	init(report);
    }

    public JFreeReportPreviewDialog(final JFreeReport report,
	    final Dialog owner, final boolean modal)
	    throws ReportProcessingException {
	super(owner, modal);
	init(report);
    }

    public void init(final JFreeReport report) throws ReportProcessingException {
	base = new PreviewProxyBase(this);
	base.init(report);
	registerCloseActions();
	setContentPane(base);
    }

    public void setReport(final JFreeReport report)
	    throws ReportProcessingException {
	base.init(report);
    }

    public Action createDefaultCloseAction() {
	return new DefaultCloseAction();
    }

    public void dispose() {
	base.dispose();
	super.dispose();
    }

    public void close() {
	base.close();
    }

    protected void registerCloseActions() {
	addWindowListener(new WindowAdapter() {
	    public void windowClosing(final WindowEvent e) {
		getBase().getCloseAction().actionPerformed(
			new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				"CloseFrame"));
	    }
	});
    }

    public ResourceBundle getResources() {
	if (resources == null) {
	    resources = ResourceBundle
		    .getBundle(PreviewProxyBase.BASE_RESOURCE_CLASS);
	}
	return resources;
    }

    public PreviewProxyBase getBase() {
	return base;
    }

}
