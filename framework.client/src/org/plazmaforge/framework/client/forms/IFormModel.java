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

package org.plazmaforge.framework.client.forms;


import org.plazmaforge.framework.client.models.IDataModel;

/** 
 * @author Oleh Hapon
 *
 */

public interface IFormModel extends IEntityModel, IDataModel  {

    
    boolean isModify();
    
    void setModify(boolean modify);
    
    

    /**
     * Clears the entity.
     * ID is null and entity is null. 
     */
    void clearEntity();
    
 
    
    /**
     * Sets editable mode of the form
     * @param mode
     */
    void setMode(int mode);
    
    /**
     * Return editable mode of the form
     * @return
     */
    int getMode();
    
    /**
     * Return true if editable mode of form is EDIT_MODE
     * @return
     */
    boolean isEditMode();
    
    /**
     * Return true if editable mode of form is ADD_MODE
     * @return
     */
    boolean isAddMode();

    /**
     * Return true if editable mode of form is COPY_MODE
     * @return
     */
    boolean isCopyMode();

    /**
     * Return true if editable mode of form is VIEW_MODE
     * @return
     */
    boolean isViewMode();
    
    /**
     * Set EDIT_MODE
     *
     */
    void setEditMode();
    
    /**
     * Set ADD_MODE
     *
     */
    void setAddMode();

    
    /**
     * Set COPY_MODE
     *
     */
    void setCopyMode();

    
    /**
     * Set VIEW_MODE
     *
     */
    void setViewMode();
    
    /**
     * Returns true if the form has data source or form works with entity service.
     * If the form doesn't have data source then you have to use <code>setEntity</code> method.
     * @return
     */
    boolean hasDataSource();
    
    
    void setDataSourceSupport(boolean dataSourceSupport);
    
    boolean isReadOnly();
    
    void setReadOnly(boolean readOnly);
    
    
    boolean isAutoConfigureAssociation();

    void setAutoConfigureAssociation(boolean autoConfigureAssociation);

	
    boolean isAutoConfigureEntity();
    
    void setAutoConfigureEntity(boolean autoConfigure);
    
    
    boolean isAutoConfigureEntityService();
    
    void setAutoConfigureEntityService(boolean autoConfigure);

    
    boolean isAutoConfigureEntityForm();
    
    void setAutoConfigureEntityForm(boolean autoConfigure);
    
}
