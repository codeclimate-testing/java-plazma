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

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.beans.Country;
import org.plazmaforge.bsolution.base.common.services.CountryService;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 28.02.2004 Time: 20:02:03 $Id: CountryEdit.java,v
 *         1.1 2007/03/02 07:06:41 ohapon Exp $
 */
public class CountryEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private JTextField codeField;

    private JTextField nameField;

    public CountryEdit() throws ApplicationException {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Country.class);
	this.setEntityServiceClass(CountryService.class);

    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));

	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new JTextField(5);
	nameField = new JTextField(25);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	editPanel.addByX(codeField);
	editPanel.addByY(nameField);

	add(editPanel);
    }

    private Country getCountry() {
	return (Country) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getCountry().getName());
	codeField.setText(getCountry().getCode());
	nameField.setText(getCountry().getName());
    }

    protected void populateData() throws ApplicationException {
	getCountry().setCode(codeField.getText());
	getCountry().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getCountry().getName(), nameLabel.getText());
	checkError(buf);
    }

}
