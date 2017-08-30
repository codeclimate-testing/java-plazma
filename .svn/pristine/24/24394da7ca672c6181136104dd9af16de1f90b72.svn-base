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

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.ApartmentType;
import org.plazmaforge.bsolution.contact.common.services.ApartmentTypeService;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


public class AppartmentTypeEdit extends EXTEditForm {

    private JLabel nameLabel;
    private JLabel fullNameLabel;

    private JTextField nameField;
    private JTextField fullNameField;


    public AppartmentTypeEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(ApartmentType.class);
        this.setEntityServiceClass(ApartmentTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));

        nameLabel = new JLabel(getString("panel.label-name.text"));
        fullNameLabel = new JLabel(getString("panel.label-full-name.text"));

        nameField = new JTextField(5);
        fullNameField = new JTextField(25);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(nameLabel);
        editPanel.addByY(fullNameLabel);

        gbc.gridy = 0;
        editPanel.addByX(nameField);
        editPanel.addByY(fullNameField);

        add(editPanel);
    }

    private ApartmentType getAppartmentType() {
        return (ApartmentType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getAppartmentType().getFullName());
        nameField.setText(getAppartmentType().getName());
        fullNameField.setText(getAppartmentType().getFullName());
    }


    protected void populateData() throws ApplicationException {
        getAppartmentType().setName(nameField.getText());
        getAppartmentType().setFullName(fullNameField.getText());
    }



}
