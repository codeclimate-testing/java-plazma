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
package org.plazmaforge.bs.base.client.forms;


import org.plazmaforge.framework.uwt.form.EditForm;
import org.plazmaforge.framework.uwt.layout.GridLayout;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.widget.Label;
import org.plazmaforge.framework.uwt.widget.TextField;

/**
 * @author ohapon
 *
 */
public class UnitEditForm extends EditForm {

    private Label codeLabel;
    private Label nameLabel;
    
    private TextField codeField;
    private TextField nameField;
	    
    @Override
    protected void configure() {
	super.configure();
	//setPack(false); // Reset auto pack form
    }
    
    
    @Override
    protected void buildContent(Composite content) {
	setTitle("Edit Product");
	GridLayout layout = new GridLayout(2);
	content.setLayout(layout);
	
	codeLabel = new Label("Code");
	content.add(codeLabel);
	codeField = new TextField();
	codeField.setProperty("code");
	content.add(codeField);
	
	nameLabel = new Label("Name");
	content.add(nameLabel);
	nameField = new TextField();
	nameField.setProperty("name");
	content.add(nameField);
	
    }
    
   
  
   
}
