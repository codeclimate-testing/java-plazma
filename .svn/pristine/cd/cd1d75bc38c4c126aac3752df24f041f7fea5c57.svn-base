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

package org.plazmaforge.bsolution.personality.client.swing.forms;


import java.awt.Window;
import java.util.List;
import java.util.ArrayList;

import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.common.beans.PersonLanguage;
import org.plazmaforge.bsolution.personality.common.services.PersonLanguageService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 21:32:23
 * $Id: PersonLanguageList.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonLanguageList extends AbstractPersonableList {



    public PersonLanguageList() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }

    public PersonLanguageList(Window window) throws ApplicationException {
        super(window, GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonLanguage.class);
        this.setEntityServiceClass(PersonLanguageService.class);
        this.setEntityEditFormClass(PersonLanguageEdit.class);
    }


    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(400, 200);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-language-name.name"));
        d.setFieldName("languageName");
        d.setColumnClass(String.class);
        d.setSize(80);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-easy.name"));
        d.setFieldName("easy");
        d.setColumnClass(Boolean.class);
        d.setSize(20);
        columns.add(d);

        return columns;
    }



}
