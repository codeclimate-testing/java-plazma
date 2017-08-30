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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.plazmaforge.bsolution.base.client.swing.forms.CountryList;
import org.plazmaforge.bsolution.base.common.beans.Country;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Locality;
import org.plazmaforge.bsolution.contact.common.beans.LocalityType;
import org.plazmaforge.bsolution.contact.common.beans.Region;
import org.plazmaforge.bsolution.contact.common.services.LocalityService;
import org.plazmaforge.bsolution.contact.common.services.LocalityTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboBox;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;




/**
 * @author Oleh Hapon
 * Date: 28.11.2004
 * Time: 12:55:01
 * $Id: LocalityEdit.java,v 1.4 2010/12/05 07:56:45 ohapon Exp $
 */
public class LocalityEdit extends EXTEditForm {

    private JLabel countryNameLabel;
    private JLabel regionNameLabel;
    private JLabel nameLabel;


    private XComboEdit countryComboEdit;
    private XComboEdit regionComboEdit;
    private XComboBox localityTypeComboBox;
    private JTextField nameField;

    public LocalityEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Locality.class);
        this.setEntityServiceClass(LocalityService.class);
    }
    

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        countryNameLabel = new JLabel(getString("panel.label-country.text"));
        regionNameLabel = new JLabel(getString("panel.label-region.text"));
        nameLabel = new JLabel(getString("panel.label-name.text"));

        countryComboEdit = new XComboEdit();
        regionComboEdit = new XComboEdit(true);
        localityTypeComboBox = new XComboBox(getLocalityType());
        nameField = new JTextField(35);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(countryNameLabel);
        editPanel.addByY(regionNameLabel);
        editPanel.addByY(nameLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        editPanel.add(countryComboEdit);
        editPanel.addByY(regionComboEdit);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        editPanel.addByY(localityTypeComboBox);
        editPanel.addByX(nameField);

        add(editPanel);
        countryComboEdit.initListFormAction(this, CountryList.class);
        regionComboEdit.initListFormAction(this, RegionList.class);

    }

    private Locality getLocality() {
        return (Locality) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getLocality().getName());
        countryComboEdit.setValue((Country) getLocality().getCountry());
        regionComboEdit.setValue(getLocality().getRegion());
        localityTypeComboBox.setValue((LocalityType) getLocality().getLocalityType());
        nameField.setText(getLocality().getName());
    }


    protected void populateData() throws ApplicationException {
        getLocality().setCountry((Country) countryComboEdit.getValue());
        getLocality().setRegion((Region) regionComboEdit.getValue());
        getLocality().setLocalityType((LocalityType) localityTypeComboBox.getValue());
        getLocality().setName(nameField.getText());
    }
    
    private LocalityTypeService getLocalityTypeService() {
	return (LocalityTypeService) getSERVICE(LocalityTypeService.class);
    }

    // TODO: You must this remove to service
    private List getLocalityType() throws ApplicationException {
	List inpList = getLocalityTypeService().findAll();
	if (inpList == null || inpList.size() == 0) {
	    return inpList;
	}
	List outList = new ArrayList();
	Iterator itr = inpList.iterator();
	LocalityType localityType = null;
	while (itr.hasNext()) {
	    localityType = (LocalityType) itr.next();
	    if (localityType.getId() == LocalityType.CITY) {
		continue;
	    }
	    outList.add(localityType);
	}

	return outList;
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, (!StringUtils.isEmpty(getLocality().getName()) && getLocality().getLocalityType() != null), nameLabel.getText());
	validateRequiredField(buf, getLocality().getCountry(), countryNameLabel.getText());
	checkError(buf);
    }
	

}
