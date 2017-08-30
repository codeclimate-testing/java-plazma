package org.plazmaforge.bsolution.base.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.base.client.swing.GUIBaseEnvironment;
import org.plazmaforge.bsolution.base.common.services.SystemEntityService;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * @author Oleh Hapon Date: 03.06.2006 Time: 10:57:52 $Id: SystemEntityEdit.java,v 1.2 2010/12/05 07:56:44 ohapon Exp $
 */
public class SystemEntityEdit extends EXTEditForm {

    private JLabel codeLabel;

    private JLabel nameLabel;

    private XTextField codeField;

    private XTextField nameField;

    public SystemEntityEdit() {
	super(GUIBaseEnvironment.getResources());
	initialize();
    }

    private void initialize() {
	this.setEntityClass(EntityConfig.class);
	this.setEntityServiceClass(SystemEntityService.class);
    }

    protected void initComponents() throws ApplicationException {

	setTitle(getString("title"));
	codeLabel = new JLabel(getString("panel.label-code.text"));
	nameLabel = new JLabel(getString("panel.label-name.text"));

	codeField = new XTextField(20);
	codeField.setMaxChar(20);
	nameField = new XTextField(50);
	nameField.setMaxChar(50);

	GridBagPanel editPanel = new GridBagPanel();
	GridBagConstraints gbc = editPanel.getGridBagConstraints();

	gbc.fill = GridBagConstraints.HORIZONTAL;

	editPanel.add(codeLabel);
	editPanel.addByY(nameLabel);

	gbc.gridy = 0;
	gbc.gridwidth = 1;
	editPanel.addByX(codeField);
	gbc.gridwidth = 2;
	editPanel.addByY(nameField);

	add(editPanel);
    }

    protected void initShell() throws ApplicationException {
	super.initShell();
	getShell().setSize(600, 250);
    }

    private EntityConfig getSystemEntity() {
	return (EntityConfig) this.getEntity();
    }

    protected void updateView() throws ApplicationException {

	appendTitle(getSystemEntity().getCode());
	codeField.setText(getSystemEntity().getCode());
	nameField.setText(getSystemEntity().getName());

    }

    protected void populateData() throws ApplicationException {
	getSystemEntity().setCode(codeField.getText());
	getSystemEntity().setName(nameField.getText());
    }

    protected void validateData() throws ApplicationException {
	super.validateData();
	StringBuffer buf = new StringBuffer();
	validateRequiredField(buf, getSystemEntity().getName(), codeLabel
		.getText());
	checkError(buf);
    }

}
