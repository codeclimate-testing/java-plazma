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

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.plazmaforge.bsolution.contact.client.swing.GUIContactEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;





/**
 * @author Oleh Hapon
 * Date: 14.03.2004
 * Time: 19:41:19
 * $Id: EmailEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class EmailEdit extends AbstractContactableItemEdit {

    private JLabel defaultLabel;
    private JLabel emailLabel;

    private JCheckBox defaultField;
    private XTextField emailField;
    private XTextEdit noteField;

    public EmailEdit() throws ApplicationException {
        super(GUIContactEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(Email.class);
    }

    protected void initComponents() throws ApplicationException {
        setTitle(getString("title"));
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab(getString("panel.title.common.text"), createCommonPanel());
        tabbedPane.addTab(getString("panel.title.note.text"), createNotePanel());
        add(tabbedPane);
    }

    private JPanel createCommonPanel() {

        defaultLabel = new JLabel(getString("panel.label-default.text"));
        emailLabel = new JLabel(getString("panel.label-email.text"));

        defaultField = new JCheckBox();
        emailField = new XTextField(40);
        emailField.setMaxChar(50);

        GridBagPanel editPanel = new GridBagPanel();        
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        editPanel.add(defaultLabel);
        editPanel.addByY(emailLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        editPanel.add(defaultField);
        editPanel.addByY(emailField);

        return editPanel;
    }

    private JPanel createNotePanel() {
        JPanel editPanel =  new JPanel(new BorderLayout());
        noteField = new XTextEdit();
        editPanel.add(noteField, BorderLayout.CENTER);
        return editPanel;
    }


    private Email getEmail() {
        return (Email) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
        appendTitle(getEmail().getEmailAddress());
        defaultField.setSelected(getEmail().isDefaultItem());
        emailField.setText(getEmail().getEmailAddress());
        noteField.setText(getEmail().getNote());
    }


    protected void populateData() throws ApplicationException {
        getEmail().setEmailAddress(emailField.getText());
        getEmail().setNote(noteField.getText());
        getEmail().setDefaultItem(defaultField.isSelected());
    }
    
    protected void addChild() throws ApplicationException {

	// Add item
	getContactable().addEmail(getEmail());

	// Set default item after add
	getEmail().setDefaultItem(defaultField.isSelected());

    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getEmail().getEmailAddress(), emailLabel.getText());
	checkError(buf);
    }

}
