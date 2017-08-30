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
package org.plazmaforge.bsolution.base.client.swing.forms;

import javax.swing.*;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Period;
import org.plazmaforge.bsolution.base.common.services.PeriodService;
import org.plazmaforge.framework.client.swing.controls.XDateField;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.DateUtils;


import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/**
 * @author Oleh Hapon Date: 07.05.2004 Time: 18:05:56 $Id: PeriodEdit.java,v 1.4 2010/12/05 07:56:44 ohapon Exp $
 */
public class PeriodEdit extends EXTEditForm {

    private JLabel startDateLabel;

    private JLabel endDateLabel;

    private JLabel nameLabel;

    private XDateField startDateField;

    private XDateField endDateField;

    private XTextField nameField;

    public PeriodEdit() {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Period.class);
	this.setEntityServiceClass(PeriodService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	startDateLabel = new JLabel(getString("panel.label-start-date.text"));
	endDateLabel = new JLabel(getString("panel.label-end-date.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	startDateField = new XDateField();
	endDateField = new XDateField();
	nameField = new XTextField(30);
	nameField.setMaxChar(30);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(startDateLabel);
	editPanel.addByY(endDateLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(startDateField);
	editPanel.addByY(endDateField);
	editPanel.addByY(nameField);

	startDateField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		generatePeriodName();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

	endDateField.addFocusListener(new FocusListener() {
	    public void focusLost(FocusEvent e) {
		generatePeriodName();
	    }

	    public void focusGained(FocusEvent e) {

	    }
	});

	add(editPanel);
    }

    private Period getPeriod() {
	return (Period) getEntity();
    }

    protected void initData() throws ApplicationException {
	super.initData();
	getPeriod().getPeriodType().setId(EnterpriseEnvironment.getPeriodId());
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getPeriod().getName());
	startDateField.setDate(getPeriod().getStartDate());
	endDateField.setDate(getPeriod().getEndDate());
	nameField.setText(getPeriod().getName());
    }

    protected void populateData() throws ApplicationException {
	getPeriod().setStartDate(startDateField.getDate());
	getPeriod().setEndDate(endDateField.getDate());
	getPeriod().setName(nameField.getText());
    }

    private void generatePeriodName() {
	nameField.setText(DateUtils.getPeriodName(startDateField.getDate(),
		endDateField.getDate()));
    }

}
