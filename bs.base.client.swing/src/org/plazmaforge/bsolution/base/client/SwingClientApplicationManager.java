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
/*
 * Created on 21.04.2006
 *
 */

package org.plazmaforge.bsolution.base.client;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import org.plazmaforge.bsolution.base.ApplicationManagerExecutor;
import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.base.client.swing.forms.LoginFrame;
import org.plazmaforge.bsolution.base.client.swing.forms.Splash;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.forms.ListForm;
import org.plazmaforge.framework.client.swing.gui.StatusBar;
import org.plazmaforge.framework.client.swing.report.jasperreports.SwingReportPreview;
import org.plazmaforge.framework.client.swing.report.jasperreports.actions.SwingReportActionCreator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.association.PathAssociationCreator;
import org.plazmaforge.framework.platform.EntityEnvironment;
import org.plazmaforge.framework.platform.PlatfromClientApplicationManager;
import org.plazmaforge.framework.report.ReportFactory;
import org.plazmaforge.framework.report.engine.jasperreports.JasperReportsEngine;
import org.plazmaforge.framework.resources.LibraryResources;


public class SwingClientApplicationManager extends PlatfromClientApplicationManager {

    private Splash splash;

    private LoginFrame loginFrame;

    private ApplicationManagerExecutor executor = new ApplicationManagerExecutor();

    public SwingClientApplicationManager() {
    }

    protected void splashShow() throws ApplicationException {
	splash = new Splash();
	splash.pack();
	splash.setLocationRelativeTo(null);
	splash.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	splash.setVisible(true);
    }

    protected void splashHide() throws ApplicationException {
	splash.setVisible(false);
	splash.dispose();
    }

    protected void dialogShow() throws ApplicationException {
	loginFrame = new LoginFrame();
	loginFrame.pack();
	loginFrame.setLocationRelativeTo(null);
	loginFrame.show();

    }

    protected boolean isLogin() {
	return loginFrame.isLogin();
    }

    public void registerPackages() throws ApplicationException {
	executor.registerPackages();
    }
    
    protected void initSystem() throws ApplicationException {
	executor.initSystem();
    }

    protected void loadEntities() throws ApplicationException {
	executor.loadEntities();
    }

    protected void initEnvironment() throws ApplicationException {

	super.initEnvironment();
	executor.initEnvironment();

	if (SwingEnvironment.getMenuBar() != null && SwingEnvironment.getDesktopPane() != null) {
	    SwingEnvironment.getDesktopPane().setBackground(new Color(0, 78, 152));
	}
	ImageIcon icon = LibraryResources.getInstance().createIcon("olmari/plazma.gif");
	SwingEnvironment.getFrame().setIconImage(icon.getImage());
	SwingEnvironment.getDesktopPane().setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    public void updateStatusBar() {
	if (SwingEnvironment.getStatusBar() != null && SwingEnvironment.getStatusBar() instanceof StatusBar) {
	    StatusBar statusBar = (StatusBar) SwingEnvironment.getStatusBar();
	    statusBar.setText(EnterpriseEnvironment.getStatusText(SessionEnvironment.getContext()));
	}
    }
    
    protected void initContext() throws ApplicationException {
	
	super.initContext();
	
	// ---------------------------------------------------------------------------------------
	//
	// INITIALIZE CONTEXT
	//
	// ---------------------------------------------------------------------------------------
	
	
	// Initialize Association Creator
	EntityEnvironment.initAssociationManager();
	//BSolutionEnvironment.initAssociationCreator();
	
	PathAssociationCreator associationCreator = (PathAssociationCreator) AssociationManager.getAssociationCreator();
	
	//associationCreator.addType(ListForm.class, "client.gui.form", "List");
	//associationCreator.addType(EditForm.class, "client.gui.form", "Edit");

	associationCreator.addType(ListForm.class, "richclient.swing.forms", "List");
	associationCreator.addType(EditForm.class, "richclient.swing.forms", "Edit");

	//associationCreator.addType(IListForm.class, "richclient.swing.forms", IListForm.SUFFIX);
	//associationCreator.addType(IEditForm.class, "richclient.swing.forms", IEditForm.SUFFIX);
	
	ReportFactory.setReportActionCreator(new SwingReportActionCreator());
	
	JasperReportsEngine.setReportPreview(new SwingReportPreview());

    }
}
