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

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.plazmaforge.bsolution.base.client.swing.forms.CountryList;
import org.plazmaforge.bsolution.base.common.beans.Country;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.City;
import org.plazmaforge.bsolution.contact.common.beans.Region;
import org.plazmaforge.bsolution.contact.common.services.CityService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;




/**
 * @author Oleh Hapon
 * Date: 07.03.2004
 * Time: 8:56:16
 * $Id: CityEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class CityEdit extends EXTEditForm {

    private JLabel countryNameLabel;
    private JLabel regionNameLabel;
    private JLabel nameLabel;

    private XComboEdit countryComboEdit;
    private XComboEdit regionComboEdit;
    private JTextField nameField;

    public CityEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(City.class);
        this.setEntityServiceClass(CityService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        countryNameLabel = new JLabel(getString("panel.label-country.text"));
        regionNameLabel = new JLabel(getString("panel.label-region.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));

        countryComboEdit = new XComboEdit();
        regionComboEdit = new XComboEdit(true);
        nameField = new JTextField(35);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(countryNameLabel);
        editPanel.addByY(regionNameLabel);
        editPanel.addByY(nameLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(countryComboEdit);
        editPanel.addByY(regionComboEdit);
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(nameField);

        add(editPanel);
        countryComboEdit.initListFormAction(this, CountryList.class);
        regionComboEdit.initListFormAction(this, RegionList.class);

    }

    private City getCity() {
        return (City) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getCity().getName());
        countryComboEdit.setValue(getCity().getCountry());
        regionComboEdit.setValue(getCity().getRegion());
        nameField.setText(getCity().getName());
    }

    protected void populateData() throws ApplicationException {
        getCity().setCountry((Country) countryComboEdit.getValue());
        getCity().setRegion((Region) regionComboEdit.getValue());
        getCity().setName(nameField.getText());
    }
	
    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getCity().getName(), nameLabel.getText());
	validateRequiredField(buf, getCity().getCountry(), countryNameLabel.getText());
	checkError(buf);
    }
	

}
