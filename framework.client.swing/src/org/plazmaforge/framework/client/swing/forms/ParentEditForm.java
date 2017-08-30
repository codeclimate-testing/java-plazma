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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.plazmaforge.framework.client.swing.forms.actions.edit.AddChildAction;
import org.plazmaforge.framework.client.swing.forms.actions.edit.DeleteChildAction;
import org.plazmaforge.framework.client.swing.forms.actions.edit.EditChildAction;
import org.plazmaforge.framework.client.swing.forms.actions.edit.EditFormAction;
import org.plazmaforge.framework.client.swing.gui.table.AbstractStateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.model.Statable;
import org.plazmaforge.framework.resources.Resources;


import java.awt.*;
import java.awt.event.*;

/**
 * @author Oleh Hapon
 * Date: 09.03.2004
 * Time: 7:39:05
 * $Id: ParentEditForm.java,v 1.3 2010/12/05 07:52:08 ohapon Exp $
 */

public abstract class ParentEditForm extends EditForm {

    private JComponent parentPane;
	
    private JComponent childrenPane;
	
    private JComponent childrenFrame;
	
    private JTabbedPane childrenTabbedPane;

    private JToolBar childrenToolBar;

    protected EditFormAction addChildAction;
	
    protected EditFormAction deleteChildAction;
	
    protected EditFormAction editChildAction;

    private ChildType nullChildType = new NULLChildType();

    public ParentEditForm(Window window, Resources resources) {
        super(window, resources);
    }

    public ParentEditForm(Window window) {
        super(window, null);
    }

    protected void initForm()  throws ApplicationException {
        setLayout(new BorderLayout());
        parentPane = createParentPane();
        childrenFrame = createChildrenFrame();

        add(parentPane, BorderLayout.CENTER);
        add(childrenFrame, BorderLayout.SOUTH);
        
    }

    protected JComponent createParentPane() {
        JPanel p = new JPanel();
        return p;
    }

    protected JComponent createChildrenFrame() {
        JPanel p = new JPanel(new BorderLayout());
        childrenToolBar = createChildrenToolBar();
        childrenPane = createChildrenPane();
        p.add(childrenToolBar, BorderLayout.NORTH);
        p.add(childrenPane, BorderLayout.SOUTH);
        return p;
    }

    protected JComponent createChildrenPane() {
        JPanel p = new JPanel(new BorderLayout());
        p.setMaximumSize(new Dimension(200, 100));
        return p;
    }


    protected JToolBar createChildrenToolBar() {
        JToolBar toolBar = FormUtilities.createToolBar();
        
        if (addChildAction != null) {
        	toolBar.add(addChildAction);
        }
        
        if (deleteChildAction != null) {
        	toolBar.add(deleteChildAction);
        }
        
        if (editChildAction != null) {
        	toolBar.add(editChildAction);
        }
        
        return toolBar;
    }
    

    public JComponent getParentPane() {
        return parentPane;
    }

    public JComponent getChildrenPane() {
        return childrenPane;
    }

    public JComponent getChildrenFrame() {
        return childrenFrame;
    }

    public JToolBar getChildrenToolBar() {
        return childrenToolBar;
    }

    protected JTabbedPane getChildrenTabbedPane() {
        return childrenTabbedPane;
    }

    protected void setChildrenTabbedPane(JTabbedPane childrenTabbedPane) {
        this.childrenTabbedPane = childrenTabbedPane;
    }

    protected JTabbedPane getParentTabbedPane() {
        return getTabbedPane();
    }

    protected void setParentTabbedPane(JTabbedPane parentTabbedPane) {
        // TODO: Setting default layout (BorderLayout)
        if (getParentPane() != null && !(getParentPane().getLayout() instanceof BorderLayout)) {
            getParentPane().setLayout(new BorderLayout());
        }
        setTabbedPane(parentTabbedPane);
    }

    protected void beforeShow() {
        super.beforeShow();
        if (getChildrenTabbedPane() == null) {
            return;
        }
        getChildrenTabbedPane().setSelectedIndex(0);
    }

    protected void addParentTabbedPane() throws ApplicationException {
        if (getParentTabbedPane() == null) {
            return;
        }
        getParentPane().add(getParentTabbedPane());
    }

    protected void addChildrenTabbedPane() throws ApplicationException {
        if (getChildrenTabbedPane() == null) {
            return;
        }
        getChildrenPane().add(getChildrenTabbedPane());
    }

    protected void initActions() throws ApplicationException {
        super.initActions();
        addChildAction = createAddChildAction();
        deleteChildAction = createDeleteChildAction();
        editChildAction = createEditChildAction();
    }
    
    protected EditFormAction createAddChildAction() {
    	return new AddChildAction(this, getResources());
    }
    
    protected EditFormAction createDeleteChildAction() {
    	return new DeleteChildAction(this, getResources());
    }
    
    protected EditFormAction createEditChildAction() {
    	return new EditChildAction(this, getResources());
    }
    


    public void doDeleteChildCommand() throws ApplicationException {
        Object data = this.getSelectedChild();
        if (data == null) {
            return;
        }
        if (confirmYesNo(getResourceString("message.delete.record")) != JOptionPane.YES_OPTION) {
            return;
        }
        deleteChildCommand(data);
        afterRefreshChildData();
    }

    public void doEditChildCommand(int mode) throws ApplicationException {
        Object data = null;
        if (mode == EditableMode.EDIT) {
            data = this.getSelectedChild();
            if (data == null) {
                return;
            }
        }
        EditForm edit = getEditChildForm();
        if (edit == null) {
            return;
        }
        edit.initEditableMode(mode);
        edit.setTransferObject(data);
        beforeEditChild();
        edit.doRun();
        if (edit.isModifyData()) {
            beforeRefreshChildData();
            doRefreshChildData();
            afterRefreshChildData();

        }
        afterEditChild();
    }

    protected void beforeEditChild() throws ApplicationException {}

    protected void afterEditChild() throws ApplicationException {}

    protected void beforeRefreshChildData() throws ApplicationException {}

    protected void afterRefreshChildData() throws ApplicationException {}


    public void doRefreshChildData() throws ApplicationException {
        ((AbstractTableModel) getSelectedChildTable().getModel()).fireTableDataChanged();
    }

    protected EditForm getEditChildForm() throws ApplicationException {
        return getSelectedChildType().getEditForm();
    }

    protected JTable getSelectedChildTable() {
        return getSelectedChildType().getTable();
    }

    protected void deleteChildCommand(Object data) throws ApplicationException {
        if (data == null) {
            return;
        }
        if (data instanceof Statable) {
            ((Statable) data).setDeleted();
        }
        fireSelectedTableDataChanged();
    }

    protected void fireSelectedTableDataChanged() {
        JTable table = getSelectedChildTable();
        if (table == null) {
            return;
        }
        ((AbstractTableModel) table.getModel()).fireTableDataChanged();
    }

    protected Object getSelectedChild(JTable table) {
        if (table == null) {
            table = this.getSelectedChildTable();
        }
        if (table == null) {
            return null;
        }
        int row = table.getSelectedRow();
        if (row < 0 || row > table.getRowCount() - 1) {
            return null;
        }
        return ((AbstractStateTableModel) table.getModel()).getRowObject(row);
    }

    protected Object getSelectedChild() {
        return getSelectedChild(null);
    }


    protected ChildType getSelectedChildType() {
        if (getChildrenTabbedPane() == null) {
            return getNULLChildType();
        }
        return (ChildType) getEntityType(getChildrenTabbedPane().getSelectedComponent());
    }


    protected JTable createChildTable(TableModel model) throws ApplicationException {
        JTable table = createTable(model);
        //table.setSurrendersFocusOnKeystroke(false);

        // Key Listener
        registerKeyEnter(table);
        registerKeyInsert(table);
        registerKeyDelete(table);

        //TODO: Problems notify
        //registerKeyEsc(table);

        // Mouse Listener
        table.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                	
                	if (editChildAction == null) {
                		return;
                	}
                    editChildAction.actionPerformed(null);
                }
            }
            public void mousePressed(MouseEvent e) {

            }
            public void mouseReleased(MouseEvent e) {

            }
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e) {

            }


        });

        return table;
    }


    private void registerKeyEnter(JComponent comp) {
        comp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editChildAction.actionPerformed(null);
            }
        },  KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyInsert(JComponent comp) {
        comp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addChildAction.actionPerformed(null);
            }
        },  KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void registerKeyDelete(JComponent comp) {
        comp.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteChildAction.actionPerformed(null);
            }
        },  KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    protected ChildType getNULLChildType() {
        return nullChildType;
    }

    protected EntityType getNULLEntityType() {
        return getNULLChildType();
    }

}
