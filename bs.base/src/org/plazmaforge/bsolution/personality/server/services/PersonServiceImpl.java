package org.plazmaforge.bsolution.personality.server.services;

import org.plazmaforge.bsolution.personality.common.beans.Person;
import org.plazmaforge.bsolution.personality.common.beans.PersonHeader;
import org.plazmaforge.bsolution.personality.common.services.PersonService;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class PersonServiceImpl extends AbstractEntityService<Person, Integer> implements PersonService {

    protected Class getEntityClass() {
	return Person.class;
    }

    protected Class getEntityHeaderClass() {
	return PersonHeader.class;
    }

}
