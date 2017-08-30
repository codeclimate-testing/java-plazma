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
package org.plazmaforge.framework.client.swing.gui.table;

import java.util.List;

import javax.swing.table.TableModel;

import org.plazmaforge.framework.ext.model.Statable;


/**
 * @author Oleh Hapon Date: 14.11.2003 Time: 8:49:06
 */
public interface StateTableModel extends TableModel {

    Statable getStateData(int rowIndex);

    boolean isNormalRow(int rowIndex);

    boolean isModifiedRow(int rowIndex);

    boolean isDeletedRow(int rowIndex);

    boolean isCreatedRow(int rowIndex);

    void setNormalRow(int rowIndex);

    void setModifiedRow(int rowIndex);

    void setDeletedRow(int rowIndex);

    void setCreatedRow(int rowIndex);

    Object getRowID(int rowIndex);

    Object getRowObject(int rowIndex);

    void addData(List list);

    void addRow(Object row);

    void setRow(int index, Object data);

    int indexOfRow(Object obj);

    ColumnProperty[] getColumns();
}
