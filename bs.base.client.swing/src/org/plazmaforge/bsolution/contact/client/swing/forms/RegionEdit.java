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
package org.plazmaforge.bsolution.contact.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.base.client.swing.forms.CountryList;
import org.plazmaforge.bsolution.base.common.beans.Country;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Region;
import org.plazmaforge.bsolution.contact.common.services.RegionService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 03.03.2004
 * Time: 9:34:16
 * $Id: RegionEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class RegionEdit extends EXTEditForm {

    private JLabel countryNameLabel;
    private JLabel nameLabel;

    private JTextField nameField;
    private XComboEdit countryComboEdit;

    public RegionEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Region.class);
        this.setEntityServiceClass(RegionService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        countryNameLabel = new JLabel(getString("panel.label-country.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));

        nameField = new JTextField(25);
        countryComboEdit = new XComboEdit();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(countryNameLabel);
        editPanel.addByY(nameLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(countryComboEdit);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(nameField);

        countryComboEdit.initListFormAction(this, CountryList.class);

        add(editPanel);
    }

    private Region getRegion() {
        return (Region) this.getEntity();
    }


    protected void updateView() throws ApplicationException {
        appendTitle(getRegion().getName());
        countryComboEdit.setValue(getRegion().getCountry());
        nameField.setText(getRegion().getName());
    }

    protected void populateData() throws ApplicationException {
        getRegion().setCountry((Country) countryComboEdit.getValue());
        getRegion().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getRegion().getName(), nameLabel.getText());
	validateRequiredField(buf, getRegion().getCountry(), countryNameLabel.getText());
	checkError(buf);
    }
	

}
