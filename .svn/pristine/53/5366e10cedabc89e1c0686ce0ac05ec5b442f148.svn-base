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

package org.plazmaforge.framework.client.swing.forms;


import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;

import org.plazmaforge.framework.client.swing.controls.XTable;
import org.plazmaforge.framework.client.swing.gui.GUIEnvironment;
import org.plazmaforge.framework.client.swing.gui.ToolBar;
import org.plazmaforge.framework.client.swing.gui.table.ButtonTableHeader;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.DateCellRenderer;
import org.plazmaforge.framework.client.swing.gui.table.ObjectTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;



import java.awt.*;
import java.util.Date;

/**
 * @author Oleh Hapon
 * Date: 01.06.2004
 * Time: 9:55:00
 * $Id: FormUtilities.java,v 1.3 2010/12/05 07:52:08 ohapon Exp $
 */
public class FormUtilities implements FormConstants {





    public static JToolBar createToolBar() {
        ToolBar toolBar = new ToolBar();
        toolBar.setBorder(createRaisedBorder());
        toolBar.setUseRolloverButtons(true);
        toolBar.setFloatable(false);
        toolBar.setFocusable(false);
        return toolBar;
    }

    public static Border createRaisedBorder()  {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED),
            BorderFactory.createEmptyBorder(0, 4, 0, 4));
    }


    public static ObjectTableModel createObjectTableModel(Class klass, ColumnProperty[] columns) throws ApplicationException {
        ObjectTableModel  model = new ObjectTableModel();
        model.setColumns(columns);
        model.createObjectProperties(klass);
        return model;
    }

    public static ObjectTableModel createObjectTableModel(Class klass, java.util.List columns) throws ApplicationException {
        ObjectTableModel  model = new ObjectTableModel();
        model.setColumns((ColumnProperty[]) columns.toArray(new ColumnProperty[0]));
        model.createObjectProperties(klass);
        return model;
    }

    public static JTable createTable(TableModel model) {
        JTable table = createTable();
        if (model != null) table.setModel(model);

        JTableHeader header = new ButtonTableHeader();
        header.setColumnModel(table.getColumnModel());
        table.setTableHeader(header);

        /*
        GUIUtilities.prepareColumn(table,10,50);
        */


        // TODO: Init JTable of GUIContext
        GUIEnvironment.TablePreferences p = GUIEnvironment.getTablePreferences();
        table.getTableHeader().setReorderingAllowed(p.isColReorderingAllowed());
        table.setShowHorizontalLines(p.isHorizontalLines());
        table.setShowVerticalLines(p.isVerticalLines());
        table.setColumnSelectionAllowed(p.isColSelectionAllowed());
        table.setRowSelectionAllowed(p.isRowSelectionAllowed());
        //
        table.setSelectionMode(p.getSelectionMode());
        table.setAutoResizeMode(p.getAutoResizeMode());
        //

        return table;
    }


    private static JTable createTable() {
        XTable table = new XTable();
        table.setFocusable(true);
		initDefaultRenderers(table);
        return table;
    }
	
	private static void initDefaultRenderers(JTable table) {
		table.setDefaultRenderer(Date.class, new DateCellRenderer());
	}



    public static JTabbedPane createTabbedPane(int width, int height) {
        if (height < 1) {
            height = DEFAULT_TABBED_PANE_HEIGHT;
        }
        JTabbedPane tabbed = new JTabbedPane();
        tabbed.setPreferredSize(new Dimension(width, height));
        return tabbed;
    }

    public static void closeAllForm(JDesktopPane desktop) {
        if (desktop == null) return;
        //JInternalFrame[] children = GUIUtilities.getOpenNonToolWindows(desktop.getAllFrames());
        JInternalFrame[] children = desktop.getAllFrames();
        JInternalFrame child = null;
        for (int i = children.length - 1; i >= 0; --i) {
            child = children[i];
            Component[] components = child.getContentPane().getComponents();
            for (int j = 0; j < components.length; j++) {
                if (components[j] instanceof Form) {
                    ((Form)components[j]).close();
                    break;
                }
            }
        }
    }

    public static void showListForm(JDesktopPane desktop, Class classListForm) throws ApplicationException {
        if ((desktop == null) || (classListForm == null)) return;
        ListForm listForm = null;
        try {
            JInternalFrame[] children = desktop.getAllFrames();
            JInternalFrame child = null;
            boolean found = false;
            for (int i = children.length - 1; i >= 0; --i) {
                child = children[i];
                Component[] components = child.getContentPane().getComponents();
                listForm = null;
                for (int j = 0; j < components.length; j++) {
                    if (components[j] instanceof ListForm) {
                        listForm = (ListForm)components[j];
                        if (listForm.getClass().equals(classListForm)) {
                            child.show();
                            child.moveToFront();
                            child.setSelected(true);
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) {
                listForm = ((ListForm) classListForm.newInstance());
                listForm.doRun();
            }
        } catch (Exception ex) {
            if (listForm != null) {
        	
        	try {
        	   listForm.close(); 
        	} catch (Throwable th) {
        	    th.printStackTrace();
        	}
            }
            throw new ApplicationException(ex);
        }
    }

    public static EditForm  showEditFormByAddMode(Class classEditForm, Object data) throws ApplicationException {
		return showEditForm(classEditForm, data, EditableMode.ADD);
    }

    public static EditForm  showEditFormByEditMode(Class classEditForm, Object data) throws ApplicationException {
		return showEditForm(classEditForm, data, EditableMode.EDIT);
    }
	
    public static EditForm showEditForm(Class classEditForm, Object data, int mode) throws ApplicationException {
		try {
			EditForm editForm = (EditForm) classEditForm.newInstance();
	        editForm.initEditableMode(mode);
	        editForm.setTransferObject(data);
	        editForm.doRun();
	        //edit.isModifyData()
	        return editForm;

		} catch (Exception ex) {
			throw new ApplicationException(ex);
			
		}
    }
}
