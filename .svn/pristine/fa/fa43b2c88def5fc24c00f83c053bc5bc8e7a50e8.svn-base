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
package org.plazmaforge.bsolution.contact.client.swing.forms;

import javax.swing.*;
import javax.swing.table.TableModel;

import org.plazmaforge.bsolution.base.SessionContext;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.contact.common.beans.Address;
import org.plazmaforge.bsolution.contact.common.beans.ContactableElement;
import org.plazmaforge.bsolution.contact.common.beans.Email;
import org.plazmaforge.bsolution.contact.common.beans.Phone;
import org.plazmaforge.bsolution.contact.common.beans.Web;
import org.plazmaforge.framework.client.swing.forms.AbstractChildType;
import org.plazmaforge.framework.client.swing.forms.EXTParentEditForm;
import org.plazmaforge.framework.client.swing.forms.EditForm;
import org.plazmaforge.framework.client.swing.gui.GUIUtilities;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.client.swing.gui.table.StateTableModel;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleh Hapon Date: 05.06.2004 Time: 13:03:49 
 * $Id: AbstractContactableEdit.java,v 1.3 2010/12/05 07:56:45 ohapon Exp $
 */
public abstract class AbstractContactableEdit extends EXTParentEditForm {

    public AbstractContactableEdit(Resources resources)
	    throws ApplicationException {
	super(resources);
    }

    /** *************************************************************************************************************** */
    /* Address definitions */
    /** *************************************************************************************************************** */
    protected JTable addressTable;

    protected JComponent createAddressPanel() throws ApplicationException {
	addressTable = createChildTable(createAddressTableModel());
	GUIUtilities.prepareColumn(addressTable, 5, 100);
	JScrollPane scroll = new JScrollPane(addressTable);
	this.registerEntityType(scroll, new AddressItemType());
	return scroll;
    }

    protected TableModel createAddressTableModel() throws ApplicationException {

	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();
	ColumnProperty d = new ColumnProperty();
	d.setName(" ");
	d.setFieldName("defaultItem");
	d.setColumnClass(Boolean.class);
	d.setSize(5);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-address.column-address-type.name"));
	d.setFieldName("addressTypeName");
	d.setColumnClass(String.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-address.column-address-string.name"));
	d.setFieldName("addressString");
	d.setColumnClass(String.class);
	d.setSize(55);
	columns.add(d);

	return createObjectTableModel(Address.class, columns);
    }

    /** *************************************************************************************************************** */
    /* Phone definitions */
    /** *************************************************************************************************************** */
    protected JTable phoneTable;

    protected JComponent createPhonePanel() throws ApplicationException {
	phoneTable = createChildTable(createPhoneTableModel());
	GUIUtilities.prepareColumn(phoneTable, 5, 100);
	JScrollPane scroll = new JScrollPane(phoneTable);
	this.registerEntityType(scroll, new PhoneItemType());
	return scroll;
    }

    protected TableModel createPhoneTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(" ");
	d.setFieldName("defaultItem");
	d.setColumnClass(Boolean.class);
	d.setSize(5);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-phone.column-phone-type.name"));
	d.setFieldName("phoneTypeName");
	d.setColumnClass(String.class);
	d.setSize(15);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-phone.column-phone-string.name"));
	d.setFieldName("phoneString");
	d.setColumnClass(String.class);
	d.setSize(55);
	columns.add(d);

	return createObjectTableModel(Phone.class, columns);
    }

    /** *************************************************************************************************************** */
    /* Email definitions */
    /** *************************************************************************************************************** */
    protected JTable emailTable;

    protected JComponent createEmailPanel() throws ApplicationException {
	emailTable = createChildTable(createEmailTableModel());
	GUIUtilities.prepareColumn(emailTable, 5, 100);
	JScrollPane scroll = new JScrollPane(emailTable);
	this.registerEntityType(scroll, new EmailItemType());
	return scroll;
    }

    protected TableModel createEmailTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(" ");
	d.setFieldName("defaultItem");
	d.setColumnClass(Boolean.class);
	d.setSize(5);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-email.column-email-address.name"));
	d.setFieldName("emailAddress");
	d.setColumnClass(String.class);
	d.setSize(70);
	columns.add(d);

	return createObjectTableModel(Email.class, columns);
    }

    /** *************************************************************************************************************** */
    /* Web definitions */
    /** *************************************************************************************************************** */
    protected JTable webTable;

    protected JComponent createWebPanel() throws ApplicationException {
	webTable = createChildTable(createWebTableModel());
	GUIUtilities.prepareColumn(webTable, 5, 100);
	JScrollPane scroll = new JScrollPane(webTable);
	this.registerEntityType(scroll, new WebItemType());
	return scroll;
    }

    protected TableModel createWebTableModel() throws ApplicationException {
	List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

	ColumnProperty d = new ColumnProperty();
	d.setName(" ");
	d.setFieldName("defaultItem");
	d.setColumnClass(Boolean.class);
	d.setSize(5);
	columns.add(d);

	d = new ColumnProperty();
	d.setName(getString("table-web.column-url.name"));
	d.setFieldName("url");
	d.setColumnClass(String.class);
	d.setSize(70);
	columns.add(d);

	return createObjectTableModel(Web.class, columns);
    }

    /** *************************************************************************************************************** */
    /* Edit form definitions */
    /** *************************************************************************************************************** */

    protected AddressEdit getAddressEdit() throws ApplicationException {
	return (AddressEdit) getEDIT(AddressEdit.class);
    }

    protected PhoneEdit getPhoneEdit() throws ApplicationException {
	return (PhoneEdit) getEDIT(PhoneEdit.class);
    }

    protected EmailEdit getEmailEdit() throws ApplicationException {
	return (EmailEdit) getEDIT(EmailEdit.class);
    }

    protected WebEdit getWebEdit() throws ApplicationException {
	return (WebEdit) getEDIT(WebEdit.class);
    }

    protected class AddressItemType extends AbstractChildType {
	public JTable getTable() {
	    return addressTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getAddressEdit();
	}
    }

    protected class EmailItemType extends AbstractChildType {
	public JTable getTable() {
	    return emailTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getEmailEdit();
	}
    }

    protected class PhoneItemType extends AbstractChildType {
	public JTable getTable() {
	    return phoneTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getPhoneEdit();
	}
    }

    protected class WebItemType extends AbstractChildType {
	public JTable getTable() {
	    return webTable;
	}

	public EditForm getEditForm() throws ApplicationException {
	    return getWebEdit();
	}
    }

    protected EditForm getEditChildForm() throws ApplicationException {
	EditForm form = super.getEditChildForm();
	if (!(form instanceof ContactableItemEdit)) {
	    return form;
	}
	((ContactableItemEdit) form).setContactable(getContactableElement());
	return form;
    }

    protected void updateTables() {
	ContactableElement contactable = getContactableElement();

	updateAddressTable(contactable);
	updatePhoneTable(contactable);
	updateEmailTable(contactable);
	updateWebTable(contactable);
    }

    protected void updateAddressTable() {
	updateAddressTable(getContactableElement());
    }

    protected void updatePhoneTable() {
	updatePhoneTable(getContactableElement());
    }

    protected void updateEmailTable() {
	updateEmailTable(getContactableElement());
    }

    protected void updateWebTable() {
	updateWebTable(getContactableElement());
    }

    protected void updateAddressTable(ContactableElement contactable) {
	List addressList = contactable.getAddressList();
	((StateTableModel) addressTable.getModel()).addData(addressList);
    }

    protected void updatePhoneTable(ContactableElement contactable) {
	List phoneList = contactable.getPhoneList();
	((StateTableModel) phoneTable.getModel()).addData(phoneList);
    }

    protected void updateEmailTable(ContactableElement contactable) {
	List emailList = contactable.getEmailList();
	((StateTableModel) emailTable.getModel()).addData(emailList);
    }

    protected void updateWebTable(ContactableElement contactable) {
	List webList = contactable.getWebList();
	((StateTableModel) webTable.getModel()).addData(webList);
    }

    protected abstract ContactableElement getContactableElement();

    protected SessionContext getEnterpriseContext() {
	return SessionEnvironment.getContext();
    }
}
