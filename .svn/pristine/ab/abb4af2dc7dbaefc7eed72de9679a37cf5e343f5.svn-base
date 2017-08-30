package org.plazmaforge.bs.security.server.services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.plazmaforge.bs.security.shared.entities.Role;
import org.plazmaforge.bs.security.shared.entities.User;
import org.plazmaforge.bs.security.shared.entities.UserOrganization;
import org.plazmaforge.bs.security.shared.entities.UserRole;
import org.plazmaforge.bs.security.shared.services.UserService;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.ApplicationError;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.Filter;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.ConverterUtils;
import org.plazmaforge.framework.util.DBUtils;

public class UserServiceImpl extends AbstractEntityService<User, Integer> implements UserService {

    protected Class<User> getEntityClass() {
	return User.class;
    }

//    public Integer create(User d) throws DAOException {
//	d.setRegDate(new Date());
//	return super.create(d);
//    }

    protected void onPreInsert(Object entity) {
	super.onPreInsert(entity);
	User user = (User) entity;
	user.setRegDate(new Date());
    }
   
    protected void onPreSave(Object entity) {
	super.onPreSave(entity);
	User user = (User) entity;
	if (user.isChangePassword()) {
	    user.setPassword(encryptPassword(user.getPassword()));
	}
	if (user.isEmptyUserRoles()) {
	    throw new ApplicationError("No roles of user [" + user.getLogin() + "]");
	}
    }

    protected void onPostLoad(Object entity) {
	super.onPostLoad(entity);
	try {
	    User user = (User) entity;
	    if (user.isEmptyUserOrganizations()) {
		return;
	    }
	    List<Object[]> list = DBUtils.getList(getConnection(), "SELECT P.ID, P.NAME FROM PARTNER P LEFT JOIN ORGANIZATION O ON O.ID = P.ID");
	    Map<Integer, String> map = new HashMap<Integer, String>();
	    for (Object[] row : list) {
		map.put((Integer) row[0], (String) row[1]);
	    }
	    List<UserOrganization> orgs = user.getUserOrganizationList();
	    for (UserOrganization org : orgs) {
		org.setOrganizationName(map.get(org.getOrganizationId()));
	    }
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }
    
    public User login(String login, String password) throws AccessDeniedException {
	try {
	    logCallMethod("login(String, String)");
	    User user = findUser(login, password);
	    if (user == null) {
		throw new AccessDeniedException("User not found [" + login + "]");
	    }

	    // TODO: Stub
	    // You must load OrganizationId and OrganizationName from
            // PARTNER table by ownerId and entityId
	    
	    user.setOrganizationId(new Integer(1));
	    user.setOrganizationName("");

	    user.init();
	    
	    return user;
	} catch (AccessDeniedException ex) {
	    logWarn("Access Denied: " + ex.getMessage());
	    throw ex;
	} catch (DAOException ex) {
	    logError(ex);
	    throw new AccessDeniedException();
	}
    }
    
    public boolean existsUser(String login) throws DAOException {
	try {
	    logCallMethod("existsUser(String");
	    User user = findUser(login);
	    if (user == null) {
		return false;
	    }
	    return true;
	} catch (Throwable ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }

    public boolean existsUser(String login, String password) throws DAOException {
	try {
	    logCallMethod("existsUser(String, String)");
	    User user = findUser(login, password);
	    if (user == null) {
		return false;
	    }
	    return true;
	} catch (Throwable ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }
    
    protected User findUser(String login, String password) throws DAOException {
	String encryptPassword = encryptPassword(password);
	Criteria criteria = createERMCriteria();
	criteria.addFilter("login", login, true);
	criteria.addFilter("password", encryptPassword);
	return getEntityManager().load(User.class, criteria);
    }
    
    protected User findUser(String login) throws DAOException {
	Criteria criteria = createERMCriteria();
	criteria.addFilter("login", login, true);
	return getEntityManager().load(User.class, criteria);
    }
    
    
    
    
    public List<Integer> getOrganizationIds(User user) throws DAOException {
	try {
	    logCallMethod("getOrganizationIds(User)");
	    if (user == null || user.getId() == null) {
		return null;
	    }
	    
	    Integer userId = user.getId();
	    List<Object[]> rows = DBUtils.getList(getConnection(), "SELECT ORGANIZATION_ID FROM SYS_USER_ORG WHERE USER_ID = " + userId);
	    List<Integer> list = new ArrayList<Integer>();
	    for (Object[] row : rows) {
		list.add(ConverterUtils.toInteger(row[0]));
	    }
	    return list;
	} catch  (Throwable ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }

    public List<String> getUserInterfaceIds(User user) throws DAOException {
	try {
	    logCallMethod("getUserInterfaceIds(User)");
	    if (user == null) {
		return createEmptyStringList();
	    }
	    List<UserRole> userRoles = user.getUserRoleList();
	    if (userRoles == null || userRoles.isEmpty()) {
		return createEmptyStringList();
	    }
	    List<Integer> ids = new ArrayList<Integer>();
	    for (UserRole userRole : userRoles) {
		Role role = userRole.getRole();
		if (role == null || role.getId() == null) {
		    continue;
		}
		ids.add(role.getId());
	    }
	    return getUserInterfaceIdsByRole(ids);

	} catch (Throwable ex) {
	    logError("Service error", ex);
	    throw new DAOException(ex);
	}
    }
    
    private List<String> createEmptyStringList() {
	return new ArrayList<String>();
    }

    private List<String> getUserInterfaceIdsByRole(final List<Integer> roleIds)
	    throws SQLException {

	if (roleIds == null || roleIds.isEmpty()) {
	    return createEmptyStringList();
	}

	final StringBuffer buf = new StringBuffer();
	buf.append("SELECT INTERFACE_ID FROM SYS_ROLE_INTERFACE WHERE ");

	for (int i = 0; i < roleIds.size(); i++) {
	    if (i > 0) {
		buf.append(" OR ");
	    }
	    buf.append("ROLE_ID = " + roleIds.get(i));
	}

	List<Object[]> idss = DBUtils.getList(getConnection(), buf.toString());

	if (idss == null || idss.isEmpty()) {
	    return createEmptyStringList();
	}

	LinkedHashSet<String> set = new LinkedHashSet<String>();
	for (Object[] row : idss) {
	    set.add((String) row[0]);
	}

	List<String> result = new ArrayList<String>();
	for (String id : set) {
	    result.add(id);
	}

	return result;

    }     

    
    public List<Integer> sysGetOrganizationIds(User user) throws DAOException {
	return getOrganizationIds(user);
    }

    public List<String> sysGetUserInterfaceIds(User user) throws DAOException {
	return getUserInterfaceIds(user);
    }
    
    private String encryptPassword(String password) {
	//TODO
	if ("test".equals(password)) {
	    return "098f6bcd4621d373cade4e832627b4f6";
	}
	return password;
	//return SecureEnvironment.encryptPassword(password);
    }

}
