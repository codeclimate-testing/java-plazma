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

import org.plazmaforge.bs.organization.shared.entities.OrganizationHeader;
import org.plazmaforge.framework.config.object.InterfaceConfig;
import org.plazmaforge.framework.uwt.dialog.Dialog;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.ComboBox;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.ListBox;

/**
 * @author ohapon
 *
 */
public class InputDialog extends Dialog {

    private List<OrganizationHeader> organizations;
    
    private List<InterfaceConfig> interfaces;
    
    private ComboBox<OrganizationHeader> organizationField;
    
    private ListBox<InterfaceConfig> interfaceField;
    
    public InputDialog() {
	setTitle("Input Dialog");
	setIcon("action::cog.png");
	setModal(true);
	setPack(true);
    }
    
    protected void buildContent(Composite parent) {
	super.buildContent(parent);
	
	parent.setLayout(new GridLayout());
	
	Label organizationLabel = new Label("Organizations:");
	parent.add(organizationLabel);
	organizationField = new ComboBox<OrganizationHeader>();
	organizationField.setDisplayProperty("name");
	organizationField.setWidth(200);
	parent.add(organizationField);
	
	Label interfaceLabel = new Label("Interfaces:");
	parent.add(interfaceLabel);
	interfaceField = new ListBox<InterfaceConfig>();
	interfaceField.setDisplayProperty("caption");
	interfaceField.setWidth(200);
	interfaceField.setHeight(150);
	parent.add(interfaceField);
	
    }   
    
    protected void load() {
	if (organizations != null) {
	    organizationField.setItems(organizations);
	    organizationField.setSelectionFirst();
	}
	
	if (interfaces != null) {
	    interfaceField.setItems(interfaces);
	    interfaceField.setSelectionFirst();
	}
    }

    public List<OrganizationHeader> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrganizationHeader> organizations) {
        this.organizations = organizations;
    }

    public OrganizationHeader getOrganization() {
	return organizationField == null ? null : organizationField.getSelectionItem(); 
    }
    
    public List<InterfaceConfig> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<InterfaceConfig> interfaces) {
        this.interfaces = interfaces;
    }

    
    public InterfaceConfig getInterface() {
	return interfaceField == null ? null : interfaceField.getSelectionItem(); 
    }
    
}
