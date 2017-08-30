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

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.PhoneType;
import org.plazmaforge.bsolution.contact.common.services.PhoneTypeService;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 08.03.2004
 * Time: 11:53:57
 * $Id: PhoneTypeEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class PhoneTypeEdit  extends EXTEditForm {

    private JLabel codeLabel;
    private JLabel nameLabel;

    private JTextField codeField;
    private JTextField nameField;


    public PhoneTypeEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PhoneType.class);
        this.setEntityServiceClass(PhoneTypeService.class);
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

    private PhoneType getPhoneType() {
        return (PhoneType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getPhoneType().getName());
        codeField.setText(getPhoneType().getCode());
        nameField.setText(getPhoneType().getName());
    }

    protected void populateData() throws ApplicationException {
        getPhoneType().setCode(codeField.getText());
        getPhoneType().setName(nameField.getText());
    }


}
