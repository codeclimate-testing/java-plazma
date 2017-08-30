package org.plazmaforge.bsolution.organization.common.services;

import java.io.Serializable;

import org.plazmaforge.framework.ext.service.GenericEntityService;

public interface GenericStructurableService<E, PK extends Serializable> extends StructurableService<E, Serializable>, GenericEntityService<E, Serializable> {

}
