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

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.framework.client.PWT;


/** 
 * @author Oleh Hapon
 *
 */

public class FormModel extends EntityModel implements IFormModel {

    private boolean modify;
    
    
    private List dataList;
    
    private int mode;

    private boolean dataSourceSupport = true;
    
    private boolean readOnly;
    
    
    private boolean autoConfigureAssociation = true;
    
    private boolean autoConfigureEntity = true;
    
    private boolean autoConfigureEntityService = true;
    
    private boolean autoConfigureEntityForm = true;
    
    
    public boolean isModify() {
        return modify;
    }



    public void setModify(boolean modify) {
        this.modify = modify;
    }




    public void clearEntity() {
	setEntity(null);
	setEntityId(null);
	
	setParentEntity(null);
	setParentEntityId(null);	
    }



    public List getDataList() {
	if (dataList == null) {
	    dataList = new ArrayList();
	}
        return dataList;
    }



    public void setDataList(List dataList) {
        this.dataList = dataList;
    }



    public int getMode() {
        return mode;
    }



    public void setMode(int mode) {
        this.mode = mode;
    }
    
    public boolean isEditMode() {
	return mode == PWT.EDIT_MODE;
    }
    
    public boolean isAddMode() {
	return mode == PWT.ADD_MODE;
    }

    public boolean isCopyMode() {
	return mode == PWT.COPY_MODE;
    }

    
    public boolean isViewMode() {
	return mode == PWT.VIEW_MODE;
    }


    public void setEditMode() {
	setMode(PWT.EDIT_MODE);
    }
    
    public void setAddMode() {
	setMode(PWT.ADD_MODE);
    }

    public void setCopyMode() {
	setMode(PWT.COPY_MODE);
    }

    public void setViewMode() {
	setMode(PWT.VIEW_MODE);
    }

    public boolean isDataSourceSupport() {
        return dataSourceSupport;
    }



    public void setDataSourceSupport(boolean dataSourceSupport) {
        this.dataSourceSupport = dataSourceSupport;
    }    
    
    public boolean hasDataSource() {
	return isDataSourceSupport();
    }






    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }


    //

    public boolean isAutoConfigureAssociation() {
        return autoConfigureAssociation;
    }

    public void setAutoConfigureAssociation(boolean autoConfigureAssociation) {
        this.autoConfigureAssociation = autoConfigureAssociation;
    }

    public boolean isAutoConfigureEntity() {
        return autoConfigureEntity;
    }

    public void setAutoConfigureEntity(boolean autoConfigureEntity) {
        this.autoConfigureEntity = autoConfigureEntity;
    }

    public boolean isAutoConfigureEntityForm() {
        return autoConfigureEntityForm;
    }

    public void setAutoConfigureEntityForm(boolean autoConfigureEntityForm) {
        this.autoConfigureEntityForm = autoConfigureEntityForm;
    }

    public boolean isAutoConfigureEntityService() {
        return autoConfigureEntityService;
    }

    public void setAutoConfigureEntityService(boolean autoConfigureEntityService) {
        this.autoConfigureEntityService = autoConfigureEntityService;
    }
    
    //
}
