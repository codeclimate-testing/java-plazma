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

package org.plazmaforge.framework.client.swing.gui;

import javax.swing.*;
import javax.swing.event.*;

import org.plazmaforge.framework.client.swing.actions.Command;
import org.plazmaforge.framework.resources.Resources;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * @author Oleh Hapon Date: 18.01.2004 Time: 15:25:23 $Id: ToolWindow.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */

public abstract class ToolWindow extends JInternalFrame implements
	InternalFrameListener {

    public ToolWindow(String title) {
	super(title);
    }

    public ToolWindow(String title, boolean resizable) {
	super(title, resizable);
    }

    public ToolWindow(String title, boolean resizable, boolean closable) {
	super(title, resizable, closable);
    }

    public ToolWindow(String title, boolean resizable, boolean closable,
	    boolean maximizable) {
	super(title, resizable, closable, maximizable);
    }

    public ToolWindow(String title, boolean resizable, boolean closable,
	    boolean maximizable, boolean iconifiable) {
	super(title, resizable, closable, maximizable, iconifiable);
    }

    private Resources resources;

    private JPopupMenu popupMenu;

    private JToolBar toolBar;

    private boolean hasBeenBuilt;

    private boolean hasBeenSized = false;

    public ToolWindow() {
	super("", true, true);
	createUserInterface();
    }

    public ToolWindow(Resources resources) {
	super("", true, true);
	this.resources = resources;
	createUserInterface();
    }

    public void updateUI() {
	super.updateUI();
	if (hasBeenBuilt) {
	    hasBeenSized = false;
	    privateResize();
	}
    }

    protected void setToolBar(JToolBar tb) {
	final Container content = getContentPane();
	if (toolBar != null) {
	    content.remove(toolBar);
	}
	if (tb != null) {
	    content.add(tb, BorderLayout.NORTH);
	}
	toolBar = tb;
    }

    private void mousePress(MouseEvent evt) {
	if (evt.isPopupTrigger()) {
	    if (popupMenu instanceof XPopupMenu) {
		((XPopupMenu) popupMenu).show(evt);
	    } else {
		popupMenu.show(this, evt.getX(), evt.getY());
	    }
	}
    }

    private void privateResize() {
	if (!hasBeenSized) {
	    if (toolBar != null) {
		hasBeenSized = true;
		Dimension windowSize = getSize();
		int rqdWidth = toolBar.getPreferredSize().width + 15;
		if (rqdWidth > windowSize.width) {
		    windowSize.width = rqdWidth;
		    setSize(windowSize);
		}
	    }
	}
    }

    protected void createUserInterface() {

	// This is a tool owner.
	GUIUtilities.makeToolWindow(this, true);

	setDefaultCloseOperation(HIDE_ON_CLOSE);

	// Pane to add owner content to.
	final Container content = getContentPane();
	content.setLayout(new BorderLayout());

	String title = getWindowTitle();
	if (title != null) {
	    setTitle(title);
	}

	initActions();

	setPopupMenu(createPopupMenu());

	// Put toolbar at top of owner.
	// TODO: NEW
	setToolBar(createToolBar());

	// The main list for owner.
	final JList list = getList();

	// Allow list to scroll.
	final JScrollPane sp = new JScrollPane();
	sp.setViewportView(list);
	sp.setPreferredSize(new Dimension(100, 100));

	// List in the centre of the owner.
	content.add(sp, BorderLayout.CENTER);

	// Add mouse listener for displaying popup menu.
	list.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent evt) {
		mousePress(evt);
	    }

	    public void mouseReleased(MouseEvent evt) {
		mousePress(evt);
	    }
	});

	// Add a listener to handle doubleclick events in the list.
	list.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {

		    Command cmd = getDoubleClickCommand();
		    if (cmd != null) {
			try {
			    cmd.execute();
			} catch (Exception ex) {
			    //
			}
		    }

		}
	    }
	});

	addInternalFrameListener(this);

	validate();

    }

    public JPopupMenu getPopupMenu() {
	return popupMenu;
    }

    public void setPopupMenu(JPopupMenu popupMenu) {
	this.popupMenu = popupMenu;
    }

    public JToolBar getToolBar() {
	return toolBar;
    }

    public Resources getResources() {
	return resources;
    }

    public void setResources(Resources resources) {
	this.resources = resources;
    }

    protected abstract void initActions();

    protected abstract JPopupMenu createPopupMenu();

    protected abstract JToolBar createToolBar();

    protected abstract Command getDoubleClickCommand();

    protected abstract String getWindowTitle();

    protected abstract JList getList();

    protected abstract void enableDisableActions();

    private boolean hasBeenActivated = false;

    public void internalFrameActivated(InternalFrameEvent e) {
	if (!hasBeenActivated) {
	    hasBeenActivated = true;
	    privateResize();
	}
	getList().requestFocus();
    }

    public void internalFrameClosed(InternalFrameEvent e) {

    }

    public void internalFrameClosing(InternalFrameEvent e) {

    }

    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    public void internalFrameIconified(InternalFrameEvent e) {
    }

    public void internalFrameOpened(InternalFrameEvent e) {
	privateResize();
    }

}
