package org.plazmaforge.bsolution.security.server.services;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.security.common.beans.Permission;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.bsolution.security.common.beans.UserRole;
import org.plazmaforge.bsolution.security.common.services.PermissionService;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.erm.LoadMode;
import org.plazmaforge.framework.ext.security.UserContext;
import org.plazmaforge.framework.ext.security.UserContextHolder;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.security.IPermission;
import org.plazmaforge.framework.security.SecureEnvironment;

public class ERMPermissionService extends AbstractEntityService<Permission, Integer> implements PermissionService {

    // Only for debug mode
    private boolean enableCheckPermission = true;
    
    
    protected Class getEntityClass() {
	return Permission.class;
    }
    
    
    public void loadContext() throws ApplicationException {
	SecureEnvironment.loadContext();
    }
    
    
    public void checkReadPermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	checkReadPermission(getContextUserRoleIds(), objectId, objectType);
    }
    
    public void checkWritePermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	checkWritePermission(getContextUserRoleIds(), objectId, objectType);
    }
    
    public void checkExecPermission(String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	checkExecPermission(getContextUserRoleIds(), objectId, objectType);
    }
    
    
    public void checkReadPermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	if (!enableCheckPermission) {
	    return;
	}
	Permission permission = getPermission(roleIds, objectId, objectType);
	if (permission == null) {
	    return;
	}
	if (!permission.isRead()) {
	    throw new AccessDeniedException();
	}
    }
    
    
    public void checkWritePermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	if (!enableCheckPermission) {
	    return;
	}
	Permission permission = getPermission(roleIds, objectId, objectType);
	if (permission == null) {
	    return;
	}
	if (!permission.isWrite()) {
	    throw new AccessDeniedException();
	}
    }
    
    public void checkExecPermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	if (!enableCheckPermission) {
	    return;
	}
	Permission permission = getPermission(roleIds, objectId, objectType);
	if (permission == null) {
	    //throw new AccessDeniedException(); // 2010-04-20
	    return;
	}
	if (!permission.isExec()) {
	    throw new AccessDeniedException();
	}
    }
    
    
    
    public Permission getPermission(Integer[] roleIds, String objectId, String objectType) throws AccessDeniedException, ApplicationException {
	if (objectId == null || objectType == null) {
	    return null;
	}
	Permission permission = null;
	try {
	    permission = (Permission) getMergePermission(roleIds, objectId, objectType);
	    
	    // 2010-04-20
	    if (permission == null) {
		throw new FinderException();
	    }
	} catch (FinderException ex) {
	    
	    // 2010-04-20
	    // If secure object not found we ignore check permission else AccessDenied 
	    if (hasSecurityObject(objectId, objectType)) {
		throw new AccessDeniedException();
	    }
	    
	}
	return permission;
    }
    
    public List<Permission> getPermissions(Integer[] roleIds, String objectId, String objectType) throws ApplicationException {
	Criteria criteria = createERMCriteria();
	criteria.addFilter("secureObject.objectId", objectId);
	criteria.addFilter("secureObject.objectType", objectType);
	criteria.addInFilter("role.id", roleIds);
	return getEntityManager().findAll(Permission.class, criteria, LoadMode.FORCE);
    }
    
    protected Permission getMergePermission(Integer[] roleIds, String objectId, String objectType) throws ApplicationException {
	List<Permission> permissions  = getPermissions(roleIds, objectId, objectType);
	if (permissions == null || permissions.isEmpty()) {
	    return null;
	}
	Permission permission = new Permission();
	for (Permission p:  permissions) {
	    if (p.isRead()) {
		permission.setRead(true);
	    }
	    if (p.isWrite()) {
		permission.setWrite(true);
	    }
	    if (p.isExec()) {
		permission.setExec(true);
	    }
	}
	return permission;
    }
    
    protected String getRoleIdsQuery(Integer[] roleIds) {
	if (roleIds == null || roleIds.length == 0) {
	    return "(0)";
	}
	StringBuffer buf = new StringBuffer();
	buf.append("(");
	int k = 0;
	String s = null;
	for (Integer r : roleIds) {
	    s = r == null ? null : r.toString();
	    if (s != null && s.trim().length() > 0) {
		if (k > 0) {
		    buf.append(", ");
		}
		buf.append(s.trim());
		k++;
	    }
	}
	if (k == 0) {
	    buf.append("0");
	}
	buf.append(")");
	return buf.toString();
    }
    
    
    protected boolean hasSecurityObject(String objectId, String objectType) throws ApplicationException {
	Criteria criteria = createERMCriteria();
	criteria.addFilter("objectId", objectId);
	List<SecureObject> list = getEntityManager().findAll(SecureObject.class, criteria);
	if (list == null) {
	    return false;
	}
	return list.size() > 0;
    }
    
    /**
     * Return userId of context user
     * @return
     */
    protected Integer getContextUserId() {
	try {
	    UserContext ctx = UserContextHolder.getContext();
	    return ctx == null ? null : Integer.valueOf(ctx.getUserId());  
	} catch (Throwable e) {
	    return null;
	}
    }
    
    /**
     * Return list of role Ids of context user
     * @return
     * @throws ApplicationException
     */
    protected Integer[] getContextUserRoleIds() throws ApplicationException {
	List<Integer> roleIds = new ArrayList<Integer>();
	Integer userId = getContextUserId();
	if (userId == null) {
	    return (Integer[]) roleIds.toArray(new Integer[0]);
	}
	
	Criteria criteria = createERMCriteria();
	criteria.addFilter("user.id", userId);
	List<UserRole> list = getEntityManager().findAll(UserRole.class, criteria);
	
	if (list == null || list.isEmpty()) {
	    return (Integer[]) roleIds.toArray(new Integer[0]);
	}
	for (UserRole r : list) {
	    roleIds.add(r.getRole().getId());
	}
	return (Integer[]) roleIds.toArray(new Integer[0]);
    }
    

    public List<Permission> findByType(String objectType) throws ApplicationException {
	Criteria criteria = createERMCriteria();
	criteria.addFilter("secureObject.objectType", objectType);
	return getEntityManager().findAll(Permission.class, criteria, LoadMode.FORCE);
    }
    
    public List<IPermission> getPermissionsByType(String objectType) throws ApplicationException {
	List<Permission> list = findByType(objectType);
	List<IPermission> permissions = new ArrayList<IPermission>();
	for (Permission p: list) {
	    permissions.add(p);
	}
	return permissions;
    }

}
