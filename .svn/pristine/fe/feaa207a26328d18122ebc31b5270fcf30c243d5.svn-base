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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.bsolution.base.client.swing.resources.GUIBaseResources;
import org.plazmaforge.framework.app.AppEnvironment;


public class Splash extends JDialog implements EnterpriseConstants {

    public Splash() throws HeadlessException {
	super();
	setModal(false);
	setUndecorated(true);
	setResizable(false);
	initComponents();

    }

    protected void initComponents() {
	Container c = getContentPane();
	c.setLayout(new BorderLayout());
	JPanel dialogPanel = createDialogPanel();
	c.add(dialogPanel, BorderLayout.CENTER);
	setSize(400, 400);
    }

    protected JPanel createDialogPanel() {
	JPanel p = new JPanel(new BorderLayout());
	/*
         * Border border = createDialogPanelBorder(); if (border!=null) {
         * //p.setBorder(border); }
         */

	ImageIcon icon = new ImageIcon(GUIBaseResources.class
		.getResource("images/about.jpg"));
	int width = 375;
	double scale = (double) width / icon.getIconWidth();
	int height = 250;// (int) (scale * icon.getIconHeight());
	p.add(new ImagePanel(icon.getImage(), width, height, scale),
		BorderLayout.NORTH);

	JLabel label = new JLabel();
	label.setText("<html><center><b>" + APP_NAME + " " + VERSION + " "
		+ (AppEnvironment.isDemo() ? "Demo" : "") + "</b><br>"
		+ HTML_COPYRIGHT + "</center></html>");
	label.setHorizontalAlignment(JLabel.CENTER);
	p.add(label, BorderLayout.CENTER);
	return p;
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
