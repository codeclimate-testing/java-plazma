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
package org.plazmaforge.bsolution.base.client.swing.forms.common;

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.common.acceptors.OrganizationAcceptorUtilities;
import org.plazmaforge.framework.client.swing.controls.XIntegerField;
import org.plazmaforge.framework.client.swing.report.AbstractSwingReportDialog;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.util.Map;
import java.util.HashMap;
import java.awt.*;

/**
 * @author Oleh Hapon Date: 08.01.2005 Time: 19:27:15 $Id: YearReportDialog.java,v 1.4 2010/12/05 07:56:47 ohapon Exp $
 */
public class YearReportDialog extends AbstractSwingReportDialog {

    private XIntegerField yearField;

    public YearReportDialog() throws HeadlessException {

    }

    public YearReportDialog(Frame frame) throws HeadlessException {
	super(frame);
	init();
    }

    protected JPanel createDialogPanel() {
	JPanel p = super.createDialogPanel();
	p.setLayout(new BorderLayout());
	JPanel edit = new JPanel();
	edit.setBorder(BorderFactory.createTitledBorder(getResourceString("ReportDialog.choose.year")));
	edit.add(new JLabel(getResourceString("ReportDialog.field.year")));
	yearField = new XIntegerField(10);
	yearField.setGrouping(false);
	yearField.setValue(EnterpriseEnvironment.getYear());
	edit.add(yearField);
	p.add(edit);
	return p;
    }

    public Map<String, Object> readParameters() throws ApplicationException {
	Map<String, Object> prms = new HashMap<String, Object>();
	OrganizationAcceptorUtilities.initYearParameter(prms, yearField.intValue());
	return prms;
    }

}
