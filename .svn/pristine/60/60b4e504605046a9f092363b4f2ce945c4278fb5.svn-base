package org.plazmaforge.bsolution.security.server.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.security.common.beans.PermissionView;
import org.plazmaforge.bsolution.security.common.beans.Role;
import org.plazmaforge.bsolution.security.common.services.PermissionViewService;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;
import org.plazmaforge.framework.util.DBUtils;

public class ERMPermissionViewService extends AbstractEntityService<PermissionView, Integer> implements PermissionViewService {

    private final String SELECT_SQL = "SELECT"
	    + " O.ID AS ID,"
	    + " P.SECURE_OBJECT_ID,"
	    + " P.ID AS SYS_PERMISSION_ID,"
	    + " O.OBJECT_ID,"
	    + " O.CODE,"
	    + " O.NAME,"
	    + " O.OBJECT_TYPE,"
	    + " P.ROLE_ID,"
	    + " P.IS_READ,"
	    + " P.IS_WRITE,"
	    + " P.IS_EXEC"
	    + " FROM SYS_SECURE_OBJECT O"
	    + " LEFT JOIN SYS_PERMISSION P ON O.ID = P.SECURE_OBJECT_ID AND P.ROLE_ID = ?";

    protected Class getEntityClass() {
	return PermissionView.class;
    }

    public List<PermissionView> findByRole(Role role) throws ApplicationException {
	if (role == null) {
	    return new ArrayList<PermissionView>();
	}
	return findByRole(role.getId());
    }

    public List<PermissionView> findByRole(final Integer roleId) throws ApplicationException {
	try {
	    return selectByRoleId(getConnection(), roleId);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    public PermissionView findByRoleAndId(final Integer roleId, final Integer id) throws ApplicationException {
	try {
	    return selectByRoleAndId(getConnection(), roleId, id);
	} catch (SQLException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    private List<PermissionView> selectByRoleId(Connection cn, Integer roleId) throws SQLException {
	List<PermissionView> list = new ArrayList<PermissionView>();
	List<Object[]> rows = DBUtils.getList(cn, SELECT_SQL, new Object[] { roleId });
	for (Object[] row : rows) {
	    PermissionView view = createPermissionView(row);
	    list.add(view);
	}
	return list;
    }

    private PermissionView selectByRoleAndId(Connection cn, Integer roleId, Integer id) throws SQLException {
	List<Object[]> rows = DBUtils.getList(cn, SELECT_SQL + " WHERE O.ID = ?", new Object[] { roleId, id });
	if (rows == null || rows.isEmpty()) {
	    return null;
	}
	PermissionView view = createPermissionView(rows.get(0));
	return view;
    }

    private PermissionView createPermissionView(ResultSet rs) throws SQLException {

	int i = 0;
	PermissionView view = new PermissionView();
	view.setId(rs.getInt(++i));
	view.setSecureObjectId(getInteger(rs, ++i));
	view.setPermissionId(getInteger(rs, ++i));
	view.setObjectId(rs.getString(++i));
	view.setCode(rs.getString(++i));
	view.setName(rs.getString(++i));
	view.setObjectType(rs.getString(++i));
	view.setRoleId(getInteger(rs, ++i));
	view.setRead(getBoolean(rs, ++i));
	view.setWrite(getBoolean(rs, ++i));
	view.setExec(getBoolean(rs, ++i));

	return view;
    }

    
    private PermissionView createPermissionView(Object[] row) throws SQLException {

	int i = -1;
	PermissionView view = new PermissionView();
	view.setId((Integer) row[++i]);
	view.setSecureObjectId((Integer) row[++i]);
	view.setPermissionId((Integer) row[++i]);
	view.setObjectId(getString(row[++i])); // TODO: PROBLEM: return char but real type is CHAR(30) ???. Must analize Hibernate and fix
	view.setCode(getString(row[++i]));
	view.setName(getString(row[++i]));
	view.setObjectType(getString(row[++i]));
	view.setRoleId((Integer) row[++i]);
	view.setRead(getBoolean(row[++i]));
	view.setWrite(getBoolean(row[++i]));
	view.setExec(getBoolean(row[++i]));

	return view;
    }

    
    private Integer getInteger(ResultSet rs, int index) throws SQLException {
	int value = rs.getInt(index);
	if (rs.wasNull()) {
	    return null;
	}
	return value;
    }

    private Boolean getBoolean(ResultSet rs, int index) throws SQLException {
	String value = rs.getString(index);
	return getBoolean(value);
    }
    
    
    
    
    
    private String getString(Object value) throws SQLException {
	if (value == null) {
	    return null;
	}
	return value.toString();
    }
    
    private Boolean getBoolean(Object value) {
	return "Y".equals(value);
    }

}
