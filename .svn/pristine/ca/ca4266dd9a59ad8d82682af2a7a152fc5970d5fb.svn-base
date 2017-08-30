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

package org.plazmaforge.framework.report.engine.jasperreports;

import java.awt.*;
import java.io.InputStream;

import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class JasperReportsPreviewDialog extends JFrame {

    private JPanel pnlMain;

    private JRViewer viewer = null;

    private boolean isExitOnClose;

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(String sourceFile, boolean isXMLFile)
	    throws JRException {
	// super(GUIAppEnvironment.getFrame()); //JDialog
	this.isExitOnClose = true;

	initComponents();

	this.viewer = new JRViewer(sourceFile, isXMLFile);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(InputStream is, boolean isXMLFile)
	    throws JRException {
	// super(GUIAppEnvironment.getFrame()); JDialog
	this.isExitOnClose = true;

	initComponents();

	this.viewer = new JRViewer(is, isXMLFile);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(JasperPrint jasperPrint)
	    throws JRException {
	// super(GUIAppEnvironment.getFrame()); JDialog
	this.isExitOnClose = true;

	initComponents();

	this.viewer = new JRViewer(jasperPrint);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(String sourceFile, boolean isXMLFile,
	    boolean isExitOnClose) throws JRException {
	// super(GUIAppEnvironment.getFrame()); JDialog
	this.isExitOnClose = isExitOnClose;

	initComponents();

	this.viewer = new JRViewer(sourceFile, isXMLFile);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(InputStream is, boolean isXMLFile,
	    boolean isExitOnClose) throws JRException {
	// super(GUIAppEnvironment.getFrame()); JDialog
	this.isExitOnClose = isExitOnClose;

	initComponents();

	this.viewer = new JRViewer(is, isXMLFile);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    /** Creates new form JasperViewer */
    public JasperReportsPreviewDialog(JasperPrint jasperPrint,
	    boolean isExitOnClose) throws JRException {
	// super(GUIAppEnvironment.getFrame()); JDialog
	this.isExitOnClose = isExitOnClose;

	initComponents();

	this.viewer = new JRViewer(jasperPrint);
	this.pnlMain.add(this.viewer, BorderLayout.CENTER);
    }

    private void initComponents() {

	pnlMain = new javax.swing.JPanel();

	setTitle("JasperViewer");
	// setIconImage(new
        // javax.swing.ImageIcon(getClass().getResource("/dori/jasper/view/images/jricon.GIF")).getImage());
	setResizable(true);
	// setModal(true); JDialog
	addWindowListener(new java.awt.event.WindowAdapter() {
	    public void windowClosing(java.awt.event.WindowEvent evt) {
		exitForm(evt);
	    }
	});

	pnlMain.setLayout(new java.awt.BorderLayout());

	getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);
	pack();
	Dimension d = getMaximumWindowSize();

	int pos = 50;
	// setSize(new Dimension(d.width - delta, d.height - delta));
	setBounds(pos, pos, d.width - pos * 2, d.height - pos * 2);

	// java.awt.Dimension screenSize =
        // java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	// Rectangle rectangle =
        // GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	// java.awt.Dimension screenSize = getParent().getSize();
	// setSize(new java.awt.Dimension(750, 550));
	// setLocation((screenSize.width-750)/2,(screenSize.height-550)/2);
    }

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {

	if (this.isExitOnClose) {
	    // PlatformSystem.exit(0);
	} else {
	    this.setVisible(false);
	    this.viewer.clear();
	    this.viewer = null;
	    this.getContentPane().removeAll();
	    this.dispose();
	}

    }

  
    public static void viewReport(String sourceFile, boolean isXMLFile)
	    throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		sourceFile, isXMLFile, true);
	jasperViewerDialog.show();
    }

  
    public static void viewReport(InputStream is, boolean isXMLFile)
	    throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		is, isXMLFile, true);
	jasperViewerDialog.show();
    }

   
    public static void viewReport(JasperPrint jasperPrint) throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		jasperPrint, true);
	jasperViewerDialog.show();
    }

  
    public static void viewReport(String sourceFile, boolean isXMLFile,
	    boolean isExitOnClose) throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		sourceFile, isXMLFile, isExitOnClose);
	jasperViewerDialog.show();
    }

   
    public static void viewReport(InputStream is, boolean isXMLFile,
	    boolean isExitOnClose) throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		is, isXMLFile, isExitOnClose);
	jasperViewerDialog.show();
    }

  
    public static void viewReport(JasperPrint jasperPrint, boolean isExitOnClose)
	    throws JRException {
	JasperReportsPreviewDialog jasperViewerDialog = new JasperReportsPreviewDialog(
		jasperPrint, isExitOnClose);
	jasperViewerDialog.show();
    }

    
    private Rectangle getMaximumWindowRectangle() {
	return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    }

    private Dimension getMaximumWindowSize() {
	Rectangle rectangle = getMaximumWindowRectangle();
	return new java.awt.Dimension(rectangle.width, rectangle.height);
    }

}
