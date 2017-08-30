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
import java.util.Date;

import org.plazmaforge.bsolution.personality.client.swing.GUIPersonalityEnvironment;
import org.plazmaforge.bsolution.personality.common.beans.PersonEducation;
import org.plazmaforge.bsolution.personality.common.services.PersonEducationService;
import org.plazmaforge.framework.client.swing.gui.table.ColumnProperty;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * Date: 26.09.2004
 * Time: 16:02:19
 * $Id: PersonEducationList.java,v 1.3 2010/12/05 07:56:44 ohapon Exp $
 */
public class PersonEducationList extends AbstractPersonableList {

    public PersonEducationList() throws ApplicationException {
        super(GUIPersonalityEnvironment.getResources());
        initialize();
    }

    public PersonEducationList(Window window) throws ApplicationException {
        super(window, GUIPersonalityEnvironment.getResources());
        initialize();
    }
    
    private void initialize() {
        this.setEntityClass(PersonEducation.class);
        this.setEntityServiceClass(PersonEducationService.class);
        this.setEntityEditFormClass(PersonEducationEdit.class);
    }

    protected void initShell() throws ApplicationException {
        super.initShell();
        getShell().setSize(1000, 200);
    }

    protected void initComponents() throws ApplicationException {
        super.initComponents();
        setTitle(getString("title"));
    }

    protected List<ColumnProperty> createTableColumnProperties() throws ApplicationException {
        List<ColumnProperty> columns = new ArrayList<ColumnProperty>();

        ColumnProperty d = new ColumnProperty();
        d.setName(getString("table.column-education-type-name.name"));
        d.setFieldName("educationTypeName");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-education-form-name.name"));
        d.setFieldName("educationFormName");
        d.setColumnClass(String.class);
        d.setSize(20);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table.column-education-institute-name.name"));
        d.setFieldName("educationInstituteName");
        d.setColumnClass(String.class);
        d.setSize(50);
        columns.add(d);

        d = new ColumnProperty();
        d.setName(getString("table.column-end-date.name"));
        d.setFieldName("endDate");
        d.setColumnClass(Date.class);
        d.setSize(15);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table.column-faculty.name"));
        d.setFieldName("faculty");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);


        d = new ColumnProperty();
        d.setName(getString("table.column-academic-degree-name.name"));
        d.setFieldName("academicDegreeName");
        d.setColumnClass(String.class);
        d.setSize(30);
        columns.add(d);

        return columns;
    }



}
