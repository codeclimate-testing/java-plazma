/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs.base.client.dialogs;

import java.util.List;

import org.plazmaforge.framework.uwt.dialog.Dialog;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.widget.Control;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.PasswordField;
import org.plazmaforge.framework.uwt.widget.TextField;
import org.plazmaforge.framework.uwt.widget.Widget;

/**
 * @author ohapon
 *
 */
public class LoginDialog extends Dialog {

    private TextField loginField;
    private PasswordField passwordField;
    
    public LoginDialog() {
	setTitle("Login Dialog");
	setIcon("action::cog.png");
	setModal(true);
	setPack(true);
	setAutoHide(false);
    }

    @Override
    protected void buildContent(Composite parent) {
	parent.setLayout(new GridLayout(2));
	Label loginLabel = new Label("Login:");
	parent.add(loginLabel);
	loginField = new TextField();
	loginField.setWidth(150);
	parent.add(loginField);
	Label passwordLabel = new Label("Password:");
	parent.add(passwordLabel);
	passwordField = new PasswordField();
	passwordField.setWidth(150);
	parent.add(passwordField);
    }
    
    public String getLogin() {
	return loginField.getText();
    }
    
    public String getPassword() {
	return passwordField.getText();
    }
    
    public void setProcessing(final boolean processing) {
	getApplication().syncExec(new Runnable() {

	    @Override
	    public void run() {
		loginField.setEnabled(!processing);
		passwordField.setEnabled(!processing);
		List<Widget> buttons = getButtonBar().getChildren();
		for(Widget button: buttons) {
		   if (button instanceof Control ) {
		       ((Control) button).setEnabled(!processing);
		   }
		}
	    }
	});
    }

}
