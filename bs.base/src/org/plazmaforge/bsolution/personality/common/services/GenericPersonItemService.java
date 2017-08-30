package org.plazmaforge.bsolution.personality.common.services;

import java.io.Serializable;

import org.plazmaforge.framework.ext.service.GenericEntityService;

public interface GenericPersonItemService<E, PK extends Serializable> extends PersonItemService<E, Serializable>, GenericEntityService<E, Serializable> {

}
