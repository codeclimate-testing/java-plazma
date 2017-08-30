package org.plazmaforge.bsolution.base.server.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.plazmaforge.bsolution.base.common.beans.SystemInfo;
import org.plazmaforge.bsolution.base.common.services.SystemInfoService;
import org.plazmaforge.bsolution.security.common.beans.SecureObject;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.ObjectConfigurer;
import org.plazmaforge.framework.config.object.IObjectConfig;
import org.plazmaforge.framework.core.LocaleManager;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.FinderException;
import org.plazmaforge.framework.ext.service.impl.AbstractEntityService;

public class SystemInfoServiceImpl extends AbstractEntityService<SystemInfo, Integer> implements SystemInfoService {

    //private static final Logger logger = Logger.getLogger(SystemInfoServiceImpl.class);
    
    private static final int ID_LEN = 50; // 50
    
    private static final int CODE_LEN = 50; // 50
    
    private static final int NAME_LEN = 50;
    
    private Integer ID = new Integer(1);

    protected Class getEntityClass() {
	return SystemInfo.class;
    }

    public SystemInfo load() throws DAOException, FinderException {
	return findById(ID);
    }

    public void initSystem() throws ApplicationException {
	try {
	    initSystem(getConnection());
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	}
    }

    public void reinitSystem() throws ApplicationException {
	try {
	    reinitSystem(getConnection());
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public void checkSystem() throws ApplicationException {
	checkSecureSystem();
    }
    
    public void checkSecureSystem() throws ApplicationException {
	try {
	    checkSecureSystem(getConnection());
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	}
    }
    
    public void syncSecureSystem() throws ApplicationException {
	try {
	    syncSecureSystem(getConnection());
	} catch (SQLException ex) {
	    throw new ApplicationException(ex);
	}
    }
    

    // 1. INIT 
    private void initSystem(Connection cn) throws SQLException {
	System.out.println("Start initializing system");
	syncBusinessableObjects(cn);
	syncSecureSystem(cn, true, true, true);
	//syncPersons(cn); // DISABLE - NO REASONS
	System.out.println("Stop initializing system");
    }

    // 2. REINIT
    private void reinitSystem(Connection cn) throws SQLException {
	System.out.println("Start reinitializing system");
	syncBusinessableObjects(cn);
	syncSecureSystem(cn, true, true, false); // isInsertPermission = false
	//syncPersons(cn); // DIASABLE - NO REASONS
	System.out.println("Stop reinitializing system");
    }
    
    // 3. CHECK
    private void checkSecureSystem(Connection cn) throws SQLException {
	System.out.println("Start checking secure system");
	syncSecureSystem(cn, false, false, false);
	System.out.println("Stop checking secure system");
    }

    // 4. SYNC
    private void syncSecureSystem(Connection cn) throws SQLException {
	System.out.println("Start sync secure system");
	syncSecureSystem(cn, true, true, false);
	System.out.println("Stop sync secure system");
    }
    
    
    private void syncBusinessableObjects(Connection cn) throws SQLException {
	Statement stm = null;
	PreparedStatement pstm = null;
	try {
	    System.out.println("Start initialize businessable");
	    stm = cn.createStatement();
	    ResultSet rs = stm.executeQuery("SELECT ID, NAME FROM V_BUSINESSABLE");
	    List<String[]> list = new ArrayList<String[]>();
	    while (rs.next()) {
		String[] record = new String[2];
		record[0] = "" + rs.getInt(1);
		record[1] = rs.getString(2);
		list.add(record);
	    }
	    stm.close();
	    pstm = cn.prepareStatement("UPDATE BUSINESSABLE SET NAME = ? WHERE ID = ?");
	    for (String[] record : list) {
		pstm.setString(1, record[1]);
		pstm.setInt(2, new Integer(record[0]));
		pstm.execute();
	    }
	    System.out.println("Stop initialize businessable");
	} finally {
	    try {
		if (stm != null) {
		    stm.close();
		}
		if (pstm != null) {
		    pstm.close();
		}

	    } catch (Exception e) {

	    }
	}
    }

    private List<SecureObject> getEntities(Connection cn) throws SQLException {
	PreparedStatement pstm = null;
	ResultSet rs = null;
	try {
	    pstm = cn.prepareStatement("SELECT ID, CODE, NAME FROM SYS_ENTITY WHERE IS_SECURE = ?");
	    pstm.setString(1, "Y");
	    rs = pstm.executeQuery();
	    List<SecureObject> list = new ArrayList<SecureObject>();
	    SecureObject so = null;
	    while (rs.next()) {
		so = new SecureObject();
		so.setObjectId(rs.getString(1));
		so.setCode(rs.getString(2));
		so.setName(rs.getString(3));
		list.add(so);
	    }
	    return list;
	} finally {
	    try {
		if (pstm != null) {
		    pstm.close();
		}
		if (rs != null) {
		    rs.close();
		}

	    } catch (Exception e) {

	    }
	}
    }
    
    private void syncSecureEntitiyObjects(Connection cn, boolean isUpdate, boolean isDelete, boolean isInsertPermission) throws SQLException {
	List<SecureObject> objects = getEntities(cn);
	syncSecureObjects(cn, "ENTITY", objects, isUpdate, isDelete, isInsertPermission);
    }
    
    /*
    private void syncSecureEntities(Connection cn) throws SQLException {
	
	
	Statement stm = null;
	PreparedStatement pstm = null;
	try {
	    System.out.println("Start initialize secure object");
	    stm = cn.createStatement();
	    ResultSet rs = stm.executeQuery("SELECT ID, NAME FROM SYS_ENTITY");
	    List<String[]> list = new ArrayList<String[]>();
	    while (rs.next()) {
		String[] record = new String[2];
		record[0] = rs.getString(1);
		record[1] = rs.getString(2);
		list.add(record);
	    }
	    stm.close();
	    pstm = cn.prepareStatement("UPDATE SYS_SECURE_OBJECT SET NAME = ? WHERE OBJECT_ID = ? AND NAME IS NULL");
	    for (String[] record : list) {
		pstm.setString(1, record[1]);
		pstm.setString(2, record[0]);
		pstm.execute();
	    }
	    System.out.println("Stop initialize secure object");
	} finally {
	    try {
		if (stm != null) {
		    stm.close();
		}
		if (pstm != null) {
		    pstm.close();
		}

	    } catch (Exception e) {

	    }
	}
    }
    */

    private List getObjectsFromConfiguration(String configurerName) {
	if (isEmpty(configurerName)) {
	    return new ArrayList();
	}
	
	ObjectConfigurer configurer = ConfigurerManager.getConfigurer(configurerName);
	if (configurer == null) {
	    System.out.println("Configurer [" + configurerName + "] not found");
	    return new ArrayList();
	}
	List objects = configurer.getObjects();
	return objects; 
    }
    
    private List<SecureObject> getSecureObjectsFromConfiguration(String configurerName) {
	List objects = getObjectsFromConfiguration(configurerName);
	List<SecureObject> secureObjects = new ArrayList<SecureObject>();
	if (objects == null) {
	    return secureObjects;
	}
	String objectId = null;
	String code = null;
	String name = null;
	
	SecureObject so = null;
	for (int i = 0 ; i < objects.size(); i++) {
	    
	    IObjectConfig c = (IObjectConfig) objects.get(i);
	    
	    objectId = c.getId();
	    code = c.getCode();
	    name = c.getName();
	    
	    so = new SecureObject();
	    so.setObjectId(objectId);
	    so.setCode(code);
	    so.setName(name);
	    
	    secureObjects.add(so);
	}	
	return secureObjects;
    }
    
    private SecureObject findSecureObject(List<SecureObject> objects, String objectId) {
	if (objects == null || objectId == null) {
	    return null;
	}
	String soObjectId = null;
	for (SecureObject so : objects) {
	    soObjectId = so.getObjectId();
	    if (soObjectId != null) {
		soObjectId = soObjectId.trim();
	    }
	    if (objectId.equals(soObjectId)) {
		return so;
	    }
	}
	return null;
	
    }

    private boolean isFind(List<Integer> ids, int id) {
	if (ids == null || ids.isEmpty()) {
	    return false;
	}
	for (Integer element : ids) {
	    if (id == element.intValue()) {
		return true;
	    }
	}
	return false;
	
    }

    
    private void syncSecureSystem(Connection cn, boolean isUpdate, boolean isDelete, boolean isInsertPermission) throws SQLException {
	syncSecureEntitiyObjects(cn, isUpdate, isDelete, isInsertPermission);
	syncSecureObjects(cn, "ACTION", "ActionConfigurer", isUpdate, isDelete, isInsertPermission);
	syncSecureObjects(cn, "REPORT", "ReportConfigurer", isUpdate, isDelete, isInsertPermission);
    }
    
    private void syncSecureObjects(Connection cn, String objectType, String configurerName, boolean isUpdate, boolean isDelete, boolean isInsertPermission) throws SQLException {
	List<SecureObject> objects = getSecureObjectsFromConfiguration(configurerName);
	syncSecureObjects(cn, objectType, objects, isUpdate, isDelete, isInsertPermission);
    }
    
    
    private void syncSecureObjects(Connection cn, String objectType, List<SecureObject> objects, boolean isUpdate, boolean isDelete, boolean isInsertPermission) throws SQLException {
	if (isEmpty(objectType)) {
	    return;
	}
	
	Statement stm = null;
	PreparedStatement pstm = null;
	PreparedStatement insertStm = null;
	PreparedStatement updateStm = null;
	PreparedStatement permissionStm = null;
	
	SecureObject soTest = null;
	try {
	    System.out.println("Start initialize secure object [" + objectType + "]");
	    pstm = cn.prepareStatement("SELECT ID, OBJECT_ID FROM SYS_SECURE_OBJECT WHERE OBJECT_TYPE = ?");
	    pstm.setString(1, objectType);
	    ResultSet rs = pstm.executeQuery();
	    List<String[]> list = new ArrayList<String[]>();
	    while (rs.next()) {
		String[] record = new String[2];
		record[0] = "" + rs.getInt(1);
		record[1] = rs.getString(2);
		list.add(record);
	    }
	    pstm.close();
	    rs.close();
	    
	    // 1. DELETE OLD
	    if (isDelete) {
		    Set<Integer> oldIds = new HashSet<Integer>();
		    for (String[] record : list) {
			String objectId = record[1];
			
			// If object not found then delete
			if (findSecureObject(objects, objectId) == null) {
			    oldIds.add(new Integer(record[0]));
			}
			
		    }
		    if (!oldIds.isEmpty()) {
			deleteBySet(cn, "DELETE FROM SYS_PERMISSION WHERE SECURE_OBJECT_ID IN ", oldIds);
			deleteBySet(cn, "DELETE FROM SYS_SECURE_OBJECT WHERE ID IN ", oldIds);
		    }
	    }
	    
	    
	    // 2. INSERT/UPDATE
	    stm = cn.createStatement();
	    rs = stm.executeQuery("SELECT MAX(ID) FROM  SYS_SECURE_OBJECT");
	    int maxId = 0;
	    if (rs.next()) {
		maxId = rs.getInt(1);
	    }
	    stm.close();
	    rs.close();

	    
	    stm = cn.createStatement();
	    rs = stm.executeQuery("SELECT MAX(ID) FROM  SYS_PERMISSION");
	    int maxPermissionId = 0;
	    if (rs.next()) {
		maxPermissionId = rs.getInt(1);
	    }
	    stm.close();
	    rs.close();

	    
	    
	    // 2.1 INSERT
	    insertStm = cn.prepareStatement("INSERT INTO SYS_SECURE_OBJECT (ID, OBJECT_ID, CODE, NAME, OBJECT_TYPE) VALUES (?, ?, ?, ?, ?)");
	    
	    // 2.2 UPDATE
	    if (isUpdate) {
		updateStm = cn.prepareStatement("UPDATE SYS_SECURE_OBJECT SET NAME = ? WHERE ID = ?");
	    }
	    
	    // 2.3 INSERT PERMISSION
	    List<Integer> pIds = new ArrayList<Integer>();
	    if (isInsertPermission) {
		pstm = cn.prepareStatement("SELECT P.SECURE_OBJECT_ID FROM SYS_PERMISSION P"
		+ " INNER JOIN SYS_SECURE_OBJECT O ON P.SECURE_OBJECT_ID = O.ID"
		+ " WHERE O.OBJECT_TYPE = ?");
		pstm.setString(1, objectType);
		
		// + " INNER JOIN SYS_SECURE_OBJECT O ON P.SECURE_OBJECT_ID = O.ID  ORDER BY P.SECURE_OBJECT_ID");
		// + " WHERE O.OBJECT_TYPE = ?");
		//pstm.setString(1, objectType);
		
		rs = pstm.executeQuery();
		while (rs.next()) {
		    pIds.add(rs.getInt(1));
		}
		pstm.close();
		rs.close();
		
		if ("ENTITY".equals(objectType)) {
		    permissionStm = cn.prepareStatement("INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_READ, IS_WRITE) VALUES (?, ?, ?, ?, ?)");
		} else {
		    permissionStm = cn.prepareStatement("INSERT INTO SYS_PERMISSION (ID, SECURE_OBJECT_ID, ROLE_ID, IS_EXEC) VALUES (?, ?, ?, ?)");
		}
		
	    }
	    
	    
	    for (SecureObject so : objects) {
		
		soTest = so;
		
		String objectId = so.getObjectId();
		if (isEmpty(objectId)) {
		    continue;
		}
		objectId = objectId.trim();
		String code = so.getCode();
		String name = so.getName();
		

		if (objectId.length() > ID_LEN) {
		    System.out.println("Long objectId [" + objectId + "]");
		    continue;
		}

		if (code != null) {
		    code = code.trim();
		    if (code.length() > CODE_LEN) {
			System.out.println("Long code [" + code + "]");
			continue;
		    }
		}

		if (name != null) {
		    name = name.trim();
		    if (name.length() > NAME_LEN) {
			name = name.substring(0, NAME_LEN - 3) + "...";
		    }
		}

		    
		boolean found = false;
		int id = 0;
		for (String[] record : list) {
		    String oid = record[1];
		    if (isEmpty(oid)) {
			continue;
		    }
		    oid = oid.trim();
		    if (objectId.equals(oid)) {
			found = true;
			id = new Integer(record[0]);
			break;
		    }
		}
		if (found) {
		    if (isUpdate) {
			updateStm.setString(1, name);
			updateStm.setInt(2, id);
			updateStm.execute();
		    }
		    
		    if (isInsertPermission && !isFind(pIds, id)) {
			maxPermissionId++;
			
			//System.out.println("1>>: " + id);
			permissionStm.setInt(1, maxPermissionId);
			permissionStm.setInt(2, id);
			permissionStm.setInt(3, 1);
			
			permissionStm.setString(4, "Y");
			
			if ("ENTITY".equals(objectType)) {
			    permissionStm.setString(5, "Y");
			}
			
			permissionStm.execute();
		    }
		    
		} else {
		    maxId++;
		    id = maxId;
		    insertStm.setInt(1, id);
		    insertStm.setString(2, objectId);
		    insertStm.setString(3, code);
		    insertStm.setString(4, name);
		    insertStm.setString(5, objectType);
		    insertStm.execute();
		    
		    if (isInsertPermission) {
			maxPermissionId++;
			
			//System.out.println("2>>: " + id);
			
			permissionStm.setInt(1, maxPermissionId);
			permissionStm.setInt(2, id);
			permissionStm.setInt(3, 1);
			
			permissionStm.setString(4, "Y");
			
			if ("ENTITY".equals(objectType)) {
			    permissionStm.setString(5, "Y");
			}
			
			permissionStm.execute();
		    }
		}
	    }
	    
	    System.out.println("Stop initialize secure object [" + objectType + "]");
	    
	} finally {
	    try {
		if (stm != null) {
		    stm.close();
		}
		if (pstm != null) {
		    pstm.close();
		}

	    } catch (Exception e) {

	    }
	}
    }

 
    private void deleteBySet(Connection cn, String sql, Set<Integer> ids) throws SQLException {
	
	StringBuffer buf = new StringBuffer(sql);
	buf.append(" (");
	boolean first = true;
	for (Integer id : ids) {
	    if (!first){
		buf.append(",");
	    }
	    if (first) {
		first = false;
	    }
	    buf.append(id);
	}
	buf.append(" )");
	
	
	Statement stm = null;
	try {
	    stm = cn.createStatement();
	    stm.execute(buf.toString());
	    stm.close();
	} finally {
	    try {
		if (stm != null) {
		    stm.close();
		}
	    } catch (Exception e) {

	    }
	}	
	
    }
    
    private void syncPersons(Connection cn) throws SQLException {
	Statement stm = null;
	PreparedStatement pstm = null;
	try {
	    System.out.println("Start initialize person");
	    stm = cn.createStatement();
	    ResultSet rs = stm.executeQuery("SELECT ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME FROM CONTACT");
	    List<String[]> list = new ArrayList<String[]>();
	    while (rs.next()) {
		String[] record = new String[4];

		record[0] = "" + rs.getInt(1);
		record[1] = rs.getString(2);
		record[2] = rs.getString(3);
		record[3] = rs.getString(4);

		list.add(record);
	    }
	    stm.close();
	    pstm = cn.prepareStatement("UPDATE CONTACT SET NAME = ? WHERE ID = ?");
	    for (String[] record : list) {
		pstm.setString(1, getPersonName(record[1], record[2], record[3]));
		pstm.setInt(2, new Integer(record[0]));
		pstm.execute();
	    }
	    System.out.println("Stop initialize person");
	} finally {
	    try {
		if (stm != null) {
		    stm.close();
		}
		if (pstm != null) {
		    pstm.close();
		}

	    } catch (Exception e) {

	    }
	}
    }

    private String getPersonName(String firstName, String lastName, String middleName) {
	return LocaleManager.getPersonName(firstName, lastName, middleName);
    }

}
