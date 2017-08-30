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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


import org.apache.log4j.Logger;
import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.security.common.beans.User;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;
import org.plazmaforge.framework.config.object.IInterfaceConfig;
import org.plazmaforge.framework.core.exception.AccessDeniedException;

/**
 * @author Oleh Hapon Date: 31.05.2004 Time: 11:48:04 $Id: LoginFrame.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class LoginFrame extends OptionDialog implements Runnable {

    private static final Logger logger = Logger.getLogger(LoginFrame.class);

    private JLabel loginLabel;

    private JLabel passwordLabel;

    private JTextField loginField;

    private JPasswordField passwordField;

    private boolean login;

    public LoginFrame() {
	setTitle(getResourceString("message.authentication"));
	setModal(true);
	setResizable(false);
    }

    protected void initComponents() {
	super.initComponents();
	pack();
    }

    protected JPanel createDialogPanel() {

	loginLabel = new JLabel(getResourceString("message.login"));
	passwordLabel = new JLabel(getResourceString("message.password"));

	loginField = new JTextField(30);
	passwordField = new JPasswordField(30);

	JPanel p = new JPanel(new GridBagLayout());
	p.setBorder(createDialogPanelBorder());

	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.NORTHWEST;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(10, 10, 10, 10);

	p.add(loginLabel, gbc);
	++gbc.gridy;
	p.add(passwordLabel, gbc);

	gbc.fill = GridBagConstraints.HORIZONTAL;
	++gbc.gridx;
	gbc.gridy = 0;
	p.add(loginField, gbc);
	++gbc.gridy;
	p.add(passwordField, gbc);

	loginField.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doOkAction();
	    }
	});
	passwordField.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doOkAction();
	    }
	});

	if (AppEnvironment.isAutoLogin()) {
	    // TODO: HARD CODE FOR AUTO LOGIN
	    loginField.setText("admin");
	    passwordField.setText("test");
	}
	return p;
    }

    public boolean isLogin() {
	return login;
    }

    protected void doOkAction() {
	Thread t = new Thread(this);
	t.start();
    }

    public void run() {
	try {
	    SwingUtilities.invokeAndWait(new Runnable() {
		public void run() {
		    setControllerEnabled(false);
		    statusBar
			    .setText(getResourceString("message.authentication.process"));
		}
	    });

	    User user = EnterpriseEnvironment.login(loginField.getText().trim(), new String(passwordField.getPassword()));
	    SessionContext context = new SessionContext();
	    SessionEnvironment.setContext(context);
	    EnterpriseEnvironment.loadContext(context, user);
	    
	    
	    // TODO: STUB !!!
	    List<IInterfaceConfig> uis = context.getAvailableUserInterfaces();
	    if (uis != null && !uis.isEmpty()) {
		context.setUserInterface(uis.get(0));
	    }
	    
	    
	    System.out.println("Welcome [" + loginField.getText().trim() + "] !");
	    login = true;
	    dispose();
	} catch (AccessDeniedException ex) {
	    logger.error("Authentication error", ex);
	    JOptionPane.showMessageDialog(this, "Access Denied", "Error",
		    JOptionPane.ERROR_MESSAGE);
	} catch (Exception ex) {
	    logger.error("Authentication error", ex);
	    JOptionPane.showMessageDialog(this, ex, "Error",
		    JOptionPane.ERROR_MESSAGE);
	} finally {
	    SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    setControllerEnabled(true);
		    statusBar.setText("");
		    passwordField.setText("");
		}
	    });
	}

    }

    private void setControllerEnabled(boolean b) {
	okButton.setEnabled(b);
	loginField.setEditable(b);
	passwordField.setEditable(b);
    }

}
