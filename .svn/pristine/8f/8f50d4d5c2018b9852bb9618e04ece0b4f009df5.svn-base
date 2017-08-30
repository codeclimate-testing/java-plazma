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

import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.bsolution.base.client.swing.resources.GUIBaseResources;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swing.controls.XLinkLabel;
import org.plazmaforge.framework.client.swing.dialogs.OptionDialog;
import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.client.swing.gui.StatusBar;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Oleh Hapon Date: 14.11.2004 Time: 13:28:32 $Id: AboutDialog.java,v 1.2 2010/04/28 06:28:15 ohapon Exp $
 */
public class AboutDialog extends OptionDialog implements EnterpriseConstants {

    public AboutDialog() throws HeadlessException {
	setModal(true);
	init();
	this.setUndecorated(true);
    }

    protected JPanel createDialogPanel() {
	JPanel p = new JPanel(new BorderLayout());
	// Border border = createDialogPanelBorder();
	// if (border != null) {
	// p.setBorder(border);
	// }

	ImageIcon icon = new ImageIcon(GUIBaseResources.class
		.getResource("images/about.jpg"));
	int width = 375;
	double scale = (double) width / icon.getIconWidth();
	int height = 250;// (int)(scale * icon.getIconHeight());
	p.add(new ImagePanel(icon.getImage(), width, height, scale),
		BorderLayout.NORTH);

	GridBagPanel panel = new GridBagPanel();
	GridBagConstraints gc = panel.getGridBagConstraints();

	gc.insets = new Insets(1, 1, 1, 1);
	gc.fill = GridBagConstraints.HORIZONTAL;
	gc.gridwidth = 2;
	JLabel label = new JLabel("<html><b> " + APP_NAME + " " + VERSION
		+ (AppEnvironment.isDemo() ? " Demo" : "") + "</b></html>");
	label.setHorizontalAlignment(JLabel.CENTER);
	panel.add(label);
	label = new JLabel("<html>" + HTML_COPYRIGHT + "</html>");
	label.setHorizontalAlignment(JLabel.CENTER);
	panel.addByY(label);

	gc.anchor = GridBagConstraints.EAST;
	gc.gridwidth = 1;

	panel.addByY(new JLabel("web:"));
	XLinkLabel webLabel = new XLinkLabel("<html><a href='" + CONTACT_WWW
		+ "'>" + CONTACT_WWW + "</a></html>");
	webLabel.setLink(CONTACT_WWW);
	panel.addByX(webLabel);

	gc.gridx = 0;
	panel.addByY(new JLabel("email:"));
	XLinkLabel emailLabel = new XLinkLabel("<html><a href='mailto:"
		+ CONTACT_EMAIL + "'>" + CONTACT_EMAIL + "</a></html>");
	emailLabel.setLink("mailto:" + CONTACT_EMAIL);
	panel.addByX(emailLabel);

	p.add(panel, BorderLayout.CENTER);
	return p;
    }

    protected JPanel createButtonPanel() {
	JPanel p = new JPanel();
	p.setBorder(createButtonPanelBorder());
	okButton = createOkButton();
	okButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doOkAction();
	    }
	});
	p.add(okButton);
	GUIUtilities.setJButtonSizesTheSame(new JButton[] { okButton });
	return p;
    }

    protected StatusBar createStatusBar() {
	return null;
    }

    public void show() {
	pack();
	this.setLocationRelativeTo(getOwner());
	super.show();
    }

    private class ImagePanel extends JPanel {

	private Image image;

	private int panelWidth;

	private int panelHeight;

	private double scale;

	public ImagePanel(Image image, int width, int height, double scale) {
	    this.image = image;
	    this.scale = scale;
	    this.panelWidth = width;
	    this.panelHeight = height;
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.scale(scale, scale);
	    g2.drawImage(image, 0, 0, ImagePanel.this);
	}

	public Dimension getPreferredSize() {
	    return new Dimension(panelWidth, panelHeight);
	}

    }

}
