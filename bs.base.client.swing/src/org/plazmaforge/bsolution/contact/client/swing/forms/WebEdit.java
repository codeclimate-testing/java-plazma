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
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.framework.client.swing.controls.XTextEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 16.03.2004 Time: 10:10:13
 * $Id: WebEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public class WebEdit extends AbstractContactableItemEdit {

    private JLabel defaultLabel;

    private JLabel urlLabel;

    private JCheckBox defaultField;

    private XTextField urlField;

    private XTextEdit noteField;

    public WebEdit() throws ApplicationException {
	super(GUIContactEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(Web.class);
    }

    protected void initComponents() throws ApplicationException {
	setTitle(getString("title"));
	JTabbedPane tabbedPane = new JTabbedPane();
	tabbedPane.addTab(getString("panel.title.common.text"),	createCommonPanel());
	tabbedPane.addTab(getString("panel.title.note.text"), createNotePanel());
	add(tabbedPane);
    }

    private JPanel createCommonPanel() {

	defaultLabel = new JLabel(getString("panel.label-default.text"));
	urlLabel = new JLabel(getString("panel.label-url.text"));

	defaultField = new JCheckBox();
	urlField = new XTextField(40);
	urlField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	editPanel.add(defaultLabel);
	editPanel.addByY(urlLabel);

	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;

	editPanel.add(defaultField);
	editPanel.addByY(urlField);

	return editPanel;
    }

    private JPanel createNotePanel() {
	JPanel editPanel = new JPanel(new BorderLayout());
	noteField = new XTextEdit();
	editPanel.add(noteField, BorderLayout.CENTER);
	return editPanel;
    }

    private Web getWeb() {
	return (Web) this.getEntity();
    }

    protected void updateView() throws ApplicationException {
	appendTitle(getWeb().getUrl());
	defaultField.setSelected(getWeb().isDefaultItem());
	urlField.setText(getWeb().getUrl());
	noteField.setText(getWeb().getNote());
    }

    protected void populateData() throws ApplicationException {
	getWeb().setUrl(urlField.getText());
	getWeb().setNote(noteField.getText());
	getWeb().setDefaultItem(defaultField.isSelected());
    }

    protected void addChild() throws ApplicationException {

	// Add item
	getContactable().addWeb(getWeb());

	// Set default item after add
	getWeb().setDefaultItem(defaultField.isSelected());

    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getWeb().getUrl(), urlLabel.getText());
	checkError(buf);
    }

}
