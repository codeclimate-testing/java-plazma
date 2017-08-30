package org.plazmaforge.bsolution.base.server.services;

import java.io.Serializable;

import org.plazmaforge.bsolution.base.common.services.AttributeValueService;
import org.plazmaforge.bsolution.base.common.services.FileService;
import org.plazmaforge.framework.ext.model.IAttributeHolder;
import org.plazmaforge.framework.ext.model.IFileHolder;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public abstract class AbstractComplexService<E, PK extends Serializable> extends AbstractEntityService<E, PK> {

    // AttributeValueService is not AttributeService
    protected AttributeValueService attributeValueService;  
    
    protected FileService fileService;
    
    
    public void setAttributeValueService(AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }  
    
    ////
    
    protected IAttributeHolder getAttributeHolder(Object entity) {
	return (IAttributeHolder) entity;
    }
    
    protected IFileHolder getFileHolder(Object entity) {
	return (IFileHolder) entity;
    }
}
