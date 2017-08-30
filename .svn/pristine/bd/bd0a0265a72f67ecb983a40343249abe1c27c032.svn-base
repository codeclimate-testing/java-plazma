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

package org.plazmaforge.framework.client.swing.controls;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.plazmaforge.framework.client.swing.forms.IFORMFactory;
import org.plazmaforge.framework.client.swing.forms.ListForm;
import org.plazmaforge.framework.core.data.Item;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.SystemUtils;

/**
 * @author Oleh Hapon Date: 06.03.2004 Time: 17:15:59 $Id: XComboEdit.java,v 1.4 2010/12/05 07:52:09 ohapon Exp $
 */
public class XComboEdit extends JComponent implements XControl {

    private static final String KEY_FIELD = "id"; // ID

    private static final String NAME_FIELD = "name";

    private JTextField textField;

    private JButton listButton;

    private JButton clearButton;

    private Object oldValue;

    private Object value;

    private Object keyValue;

    private boolean isInitValue;

    private PropertyDescriptor[] properties;

    private Method keyMethod;

    private Method nameMethod;

    private IFORMFactory formFactory;

    /** List form. ListButton action use the form */
    private ListForm listForm;

    /** ListForm class */
    private Class listFormClass;

    /** Selected class of ListForm */
    private Class selectedClass;

    private String keyField = KEY_FIELD;

    private String nameField = NAME_FIELD;

    /** Initialize listeners */
    private List initListActionListeners = new ArrayList();

    /** Action listeners */
    private List afterListActionListeners = new ArrayList();

    public XComboEdit() {
	this(false);
    }

    public XComboEdit(boolean isClearButton) {
	this(isClearButton, 0);
    }

    public XComboEdit(boolean isClearButton, int columns) {
	init(isClearButton);
	if (columns > 0) {
	    setColumns(columns);
	}
    }

    public void setSelectedClass(Class klass) throws ApplicationException {
	try {
	    selectedClass = klass;
	    BeanInfo info = Introspector.getBeanInfo(klass);
	    properties = info.getPropertyDescriptors();
	} catch (IntrospectionException ex) {
	    throw new ApplicationException(ex);
	}
    }

    public Class getSelectedClass() {
	return selectedClass;
    }

    private Method getMethod(String name) {
	for (int i = 0; i < properties.length; i++) {
	    if (name.equals(properties[i].getName())) {
		return properties[i].getReadMethod();
	    }
	}
	return null;
    }

    public void setKeyField(String name) {
	// keyMethod = getMethod(name);
	keyField = name;
    }

    private void initKeyField() {
	setKeyField(KEY_FIELD);
    }

    public void setNameField(String name) {
	// nameMethod = getMethod(name);
	nameField = name;
    }

    private void initNameField() {
	setNameField(NAME_FIELD);
    }

    private void initMethods() {
	keyMethod = getMethod(keyField);
	nameMethod = getMethod(nameField);
    }

    public IFORMFactory getFormFactory() {
	return formFactory;
    }

    public void setFormFactory(IFORMFactory formFactory) {
	this.formFactory = formFactory;
    }

    public void initListFormAction(final IFORMFactory formFactory,
	    final Class klass, String keyField, String nameField)
	    throws ApplicationException {
	this.setFormFactory(formFactory);
	this.setListFormClass(klass);

	if ((keyField == null) || (keyField.trim().equals(""))) {
	    this.initKeyField();
	} else {
	    this.setKeyField(keyField);
	}
	if ((nameField == null) || (nameField.trim().equals(""))) {
	    this.initNameField();
	} else {
	    this.setNameField(nameField);
	}

	addListActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		doListAction();
	    }
	});

    }

    /**
         * Execute ListAction
         * 
         */
    protected void doListAction() {
	try {
	    beforeListAction(); // BEFORE

	    listForm = formFactory.getLIST(getListFormClass(), getFormFactory()
		    .getShellWindow());
	    initListAction(); // INIT
	    listForm.setSelectedID(getKeyValue());
	    setValue(listForm.showList());

	    afterListAction(); // AFTER
	} catch (ApplicationException ex) {
	    ex.printStackTrace();
	}
    }

    /**
         * Initialize ListAction
         * 
         */
    protected void initListAction() {
	fireInitListAction(null);
    }

    /**
         * On before ListAction
         * 
         */
    protected void beforeListAction() {

    }

    /**
         * On after ListAction
         * 
         */
    protected void afterListAction() {
	fireAfterListAction(null);
    }

    private void initValue() {
	try {
	    if (value == null) {
		clear();
	    } else {
		if (getSelectedClass() == null) {
		    setSelectedClass(value.getClass());
		    initMethods();
		}
		setKeyValue(keyMethod == null ? null : keyMethod.invoke(value,
			null));
		try {
		    setText(nameMethod == null ? "" : (String) nameMethod
			    .invoke(value, null));
		} catch (Exception ex) {
		    setText(value.toString());
		}

	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void initListFormAction(IFORMFactory formFactory, Class klass)
	    throws ApplicationException {
	initListFormAction(formFactory, klass, null, null);
    }

    public void initListFormAction(IFORMFactory formFactory, Class klass,
	    String nameField) throws ApplicationException {
	initListFormAction(formFactory, klass, null, nameField);
    }

    protected void init(boolean isClearButton) {

	setLayout(new BorderLayout());
	textField = createTextField();
	add(textField, BorderLayout.CENTER);

	listButton = createButton();
	if (isClearButton) {
	    JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	    p.add(listButton);
	    clearButton = createClearButton();
	    p.add(clearButton);
	    add(p, BorderLayout.EAST);
	} else {
	    add(listButton, BorderLayout.EAST);
	}
    }

    public Class getListFormClass() {
	return listFormClass;
    }

    public void setListFormClass(Class listFormClass) {
	this.listFormClass = listFormClass;
    }

    protected JTextField createTextField() {
	JTextField f = new JTextField("", 10);
	// f.setDisabledTextColor(f.getForeground());
	// f.setEnabled(false);
	f.setFocusable(false);
	return f;
    }

    public void setEditable(boolean b) {
	getTextField().setEnabled(b);
    }

    protected JTextField getTextField() {
	return textField;
    }

    protected JButton createButton() {
	return new ComboButton("...");
    }

    protected JButton createClearButton() {
	JButton bt = new ComboButton(new ClearIcon());
	bt.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		clear();
		fireAfterListAction(null);
	    }
	});
	return bt;
    }

    public void addListActionListener(ActionListener l) {
	listButton.addActionListener(l);
    }

    public void setText(String text) {
	getTextField().setText(text);
	getTextField().setCaretPosition(0);
    }

    public String getText() {
	return getTextField().getText().trim();
    }

    public void setColumns(int columns) {
	getTextField().setColumns(columns);
    }

    public Object getValue() {
	// return getKeyValue();
	return value;
    }

    public int getIntValue() {
	return getIntKey();
    }

    public Object getKeyValue() {
	return keyValue;
    }

    public int getIntKey() {
	int k = 0;
	if (keyValue != null) {
	    if (keyValue instanceof Integer) {
		k = ((Integer) keyValue).intValue();
	    } else {
		try {
		    k = Integer.parseInt(keyValue.toString());
		} catch (NumberFormatException ex) {

		}
	    }
	}
	return k;
    }

    public void setKeyValue(Object key) {
	this.keyValue = key;
    }

    public void setValue(Object value) {
	// setKeyValue(key);
	this.oldValue = isInitValue ? this.value : value;
	this.value = value;
	this.isInitValue = true;
	initValue();
    }

    public void setIntValue(int key) {
	setIntKey(key);
    }

    public void setIntKey(int key) {
	this.keyValue = new Integer(key);
    }

    public void setOptionListItem(Item item) {
	if (item == null) {
	    this.keyValue = null;
	    setText("");
	} else {
	    this.keyValue = item.getKey();
	    setText(item.getValue());
	}
    }

    private class ComboButton extends JButton {

	public ComboButton() {
	}

	public ComboButton(Icon icon) {
	    super(icon);
	}

	public ComboButton(String text) {
	    super(text);
	}

	public ComboButton(Action a) {
	    super(a);
	}

	public ComboButton(String text, Icon icon) {
	    super(text, icon);
	}

	public Dimension getPreferredSize() {
	    Dimension dim = textField.getPreferredSize();
	    dim.width = dim.height;
	    return dim;
	}

	public Dimension getMinimumSize() {
	    return getPreferredSize();
	}

	public Dimension getMaximumSize() {
	    return getPreferredSize();
	}

    }

    class ClearIcon implements Icon {

	private Color fillColor;

	private int size;

	public ClearIcon() {
	    fillColor = Color.BLACK;
	    size = 6;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {

	    if (fillColor != null) {
		g.setColor(fillColor);

		g.drawLine(x, y, x + size, y + size);
		g.drawLine(x, y + size, x + size, y);
		g.drawLine(x - 1, y, x - 1 + size, y + size);
		g.drawLine(x - 1, y + size, x - 1 + size, y);
	    }
	}

	public int getIconWidth() {
	    return size;
	}

	public int getIconHeight() {
	    return size;
	}
    }

    public void clear() {
	this.value = null;
	this.keyValue = null;
	getTextField().setText("");
    }

    public void addAfterListActionListener(ActionListener l) {
	afterListActionListeners.add(l);
    }

    protected void fireAfterListAction(ActionEvent e) {
	for (int i = 0; i < afterListActionListeners.size(); i++) {
	    ((ActionListener) afterListActionListeners.get(i))
		    .actionPerformed(e);
	}
    }

    public void addInitListActionListener(ActionListener l) {
	initListActionListeners.add(l);
    }

    protected void fireInitListAction(ActionEvent e) {
	for (int i = 0; i < initListActionListeners.size(); i++) {
	    ((ActionListener) initListActionListeners.get(i))
		    .actionPerformed(e);
	}
    }

    public ListForm getListForm() {
	return listForm;
    }

    public boolean isChange() {
	return !SystemUtils.equals(this.oldValue, this.value);
    }

}
