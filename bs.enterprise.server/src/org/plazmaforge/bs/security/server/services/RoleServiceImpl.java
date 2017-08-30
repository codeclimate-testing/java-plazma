package org.plazmaforge.bs.security.server.services;



import java.util.List;

import org.plazmaforge.bs.security.shared.entities.Role;
import org.plazmaforge.bs.security.shared.entities.RoleInterface;
import org.plazmaforge.bs.security.shared.services.RoleService;
import org.plazmaforge.framework.config.InterfaceConfigManager;
import org.plazmaforge.framework.config.object.IInterfaceConfig;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class RoleServiceImpl extends AbstractEntityService<Role, Integer> implements RoleService {

    protected Class getEntityClass() {
        return Role.class;
    }

    protected void onPostLoad(Object entity) {
	super.onPostLoad(entity);
	Role role = (Role) entity;
	initializeRoleInterfaces(role);
    }
    
    protected void initializeRoleInterfaces(Role role) {
	if (role.isEmptyRoleInterfaces()) {
	    return;
	}
	
	List<IInterfaceConfig> interfaces = InterfaceConfigManager.getInterfaces();
	if (interfaces == null || interfaces.isEmpty()) {
	    return;
	}
	
	List<RoleInterface>  roleInterfaces = role.getRoleInterfaces();
	for (RoleInterface roleInterface : roleInterfaces) {
	    String id = roleInterface.getInterfaceId();
	    if (id == null) {
		continue;
	    }
	    roleInterface.setInterfaceName(InterfaceConfigManager.getInterfaceName(id));
	}
	
    }

  

}
