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
package org.plazmaforge.bsolution.employee.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.employee.client.swing.GUIEmployeeEnvironment;
import org.plazmaforge.bsolution.employee.common.beans.EmployeeRank;
import org.plazmaforge.bsolution.employee.common.services.EmployeeRankService;
import org.plazmaforge.framework.client.swing.controls.XNumberField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 04.10.2004
 * Time: 21:57:10
 * $Id: EmployeeRankEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class EmployeeRankEdit extends EXTEditForm {

    private JLabel nameLabel;
    private JLabel tariffLabel;

    private JTextField nameField;
    private XNumberField tariffField;


    public EmployeeRankEdit() throws ApplicationException {
        super(GUIEmployeeEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(EmployeeRank.class);
        this.setEntityServiceClass(EmployeeRankService.class);
    }
    
    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));

        nameLabel = new JLabel(getString("panel.label-name.text"));
        tariffLabel = new JLabel(getString("panel.label-tariff.text"));

        nameField = new JTextField(25);
        tariffField = new XNumberField();

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(nameLabel);
        editPanel.addByY(tariffLabel);

        gbc.gridy = 0;
        editPanel.addByX(nameField);
        editPanel.addByY(tariffField);

        add(editPanel);
    }


    private EmployeeRank getEmployeeRank() {
        return (EmployeeRank) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getEmployeeRank().getName());
        nameField.setText(getEmployeeRank().getName());
        tariffField.setValue(getEmployeeRank().getTariff());
    }

    protected void populateData() throws ApplicationException {
        getEmployeeRank().setName(nameField.getText());
        getEmployeeRank().setTariff(tariffField.getDoubleValue());
    }


}
