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

package org.plazmaforge.framework.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.config.object.IEntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
import org.plazmaforge.framework.ext.association.AssociationManager;
import org.plazmaforge.framework.ext.config.EntityManager;
import org.plazmaforge.framework.ext.security.support.spring.PlatformMethodSecurityInterceptor;
import org.plazmaforge.framework.ext.service.Service;
import org.plazmaforge.framework.platform.Environment;
import org.plazmaforge.framework.platform.PlatformContext;
import org.plazmaforge.framework.platform.PlatformEnvironment;
import org.plazmaforge.framework.util.BooleanUtils;
import org.plazmaforge.framework.util.CodecUtils;

/**
 * 
 * @author Oleh Hapon
 */
public class SecureEnvironment extends Environment {

    
    /** Security Manager **/
    private static SecureManager secureManager;

    /** Service map: Entity ID, Service class name **/
    private static Map<String, String> serviceMap = new HashMap<String, String>();

    private static Map<String, String> permissionMap = new HashMap<String, String>();

    /**
     * Permission attributes <Attributes (full method mask), Roles>
     * For example: 
     *  attr        = "mypackage.service.MyService.get*"
	roles       = "ROLE_1 ROLE_2 ROLE_3" 
     */
    private static Map<String, String> permissionAttributes = new HashMap<String, String>();

    
    

    private static boolean isPrintSecureService;
    
    private static boolean isPrintPermission;
    
    private static boolean isPrintVirtualPermission;
    
    
    private static final Logger logger = Logger.getLogger(SecureEnvironment.class);  
    
    
    static {
	
	/*
	isPrintSecureService = true;
	    
	isPrintPermission = true;
	    
	isPrintVirtualPermission = true;
	*/
	
    }

    
    private SecureEnvironment() {
	
    }
    
    
    public static SecureManager getSecureManager() {
	if (secureManager == null) {
	    secureManager = new NullSecureManager(); 
	}
        return secureManager;
    }

    public static void setSecureManager(SecureManager secureManager) {
	SecureEnvironment.secureManager = secureManager;
    }
    
    public static String encryptPassword(String password) {
	if (password == null) {
	    return null;
	}
	boolean isEncryptPassword = BooleanUtils.parse(PlatformEnvironment.getProperty(PlatformContext.ENCRYPT_PASSWORD));
	if (!isEncryptPassword) {
	    return password;
	}
	String encryptMethod = PlatformEnvironment.getProperty(PlatformContext.ENCRYPT_PASSWORD_METHOD);
	return CodecUtils.encryptPassword(password, encryptMethod);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Load Security Context:
     * 
     *  - Load entities which have service
     *  - Create associations by entities
     *  - Create service map (Entity ID, Service class name)
     *  - Initialize permissions
     *  
     * @throws ApplicationException
     */
    public static void loadContext() throws ApplicationException {
	
	logInfo("\n");
	logInfo("Initialize secure EntityService...");
	
	serviceMap.clear();

	// Load all entities
	List<IEntityConfig> entities = EntityManager.getEntities();
	
	for (IEntityConfig entity : entities) {
	    String ID =  null;
	    try {
		
		// If entity hasn't service then next entity
		if (!hasService(entity)) {
		    continue;
		}

		ID =  entity.getConfigId();
		
		Association association = AssociationManager.getAssociationByEntity(entity);
		
		//Class serviceClass = association.getElementByType(Service.class);
		//String serviceClassName = serviceClass.getName();
		
		String serviceClassName = association.getElementClassNameByType(Service.class);
		

		serviceMap.put(ID, serviceClassName);
		if (isPrintSecureService) {
		    logInfo("[" + ID + "] [" + serviceClassName + "]");
		}

	    } catch (Throwable ex) {
		logError("Secure EntityService of [" + ID + "] is not laod");
	    }
	}
	logInfo("EntityService was loaded");

	
	// ONLY FOR SPRING SECURITY
	// ONLY FOR ENTITIES
	initPermissions();
    }

    /**
     * Return true if entity has service
     * @param entity
     * @return
     */
    private static boolean hasService(IEntityConfig entity) {
	if (entity == null || !entity.isEnabled() || !entity.isMaster() || !entity.isSecure()) {
	    return false;
	}
	return true;
    }
    
    /**
     * Initialize permissions of entities (Spring Security)
     * @throws ApplicationException
     */
    private static void initPermissions() throws ApplicationException {
	
	logInfo("\n");
	logInfo("Loading SecureContext...");
	
	permissionMap.clear();

	IPermissionService service = (IPermissionService) getServiceByClass(PlatformEnvironment.getProperty(PlatformContext.PERMISSION_SERVICE_CLASS));
	
	// Get all permissions (ONLY ENTITIES) 
	List<IPermission> permissions = service.getPermissionsByType(SecureManager.ENTITY);
	for (IPermission p : permissions) {
	    
	    String role = p.getRoleName().trim();
	    String entity = p.getObjectId().trim();

	    if (serviceMap.get(entity) == null) {
		continue;
	    }

	    if (isPrintPermission) {
		    logInfo("[" + role + "] [" + entity + "] isRead="
			    + p.isRead() + ", isWrite=" + p.isWrite() + ", isExec="
			    + p.isExec());
		    
	    }
	    

	    addPermission(role, entity, p.isRead(), "READ");
	    addPermission(role, entity, p.isWrite(), "WRITE");
	    addPermission(role, entity, p.isExec(), "EXEC");

	}

	logInfo("SecureContext was loaded. Permission count = [" + permissions.size() + "]");

	printPermission();

	resetPermissionAttributes();
	createVirtualPermissionAttributes();
	createPermissionAttributes();

	// attr        = "mypackage.service.MyService.get*"
	// roles       = "ROLE_1 ROLE_2 ROLE_3"
	PlatformMethodSecurityInterceptor.setAttributes(permissionAttributes);
    }

    private static void addPermission(String role, String entity, boolean flag, String type) {
	if (!flag) {
	    return;
	}

	String key = entity + "." + type;
	String value = permissionMap.get(key);
	if (value == null) {
	    value = "ROLE_" + role;
	} else {
	    value = value + " " + "ROLE_" + role;
	}
	permissionMap.put(key, value);

    }

    private static void printPermission() {
	if (!isPrintPermission) {
	    return;
	}
	Set<String> keys = permissionMap.keySet();
	for (String key : keys) {
	    String value = permissionMap.get(key);
	    logInfo("key=[" + key + "], value=[" + value + "]");
	}
    }

    private static void resetPermissionAttributes() {
	permissionAttributes.clear();
    }

    private static void createPermissionAttributes() {
	
	// Permission key = entity + "." + type
	// Get all permission keys
	Set<String> keys = permissionMap.keySet();
	
	for (String key : keys) {
	    
	    // Get roles string "ROLE_1 ROLE_2 ROLE_3..."
	    String roles = permissionMap.get(key);
	    int index = key.lastIndexOf(".");

	    String entity = key.substring(0, index);
	    String type = key.substring(index + 1);
	    String serviceClassName = serviceMap.get(entity);

	    // Get method mask
	    String[] methods = getMethodsByType(type);
	    if (methods == null) {
		continue;
	    }
	    for (int i = 0; i < methods.length; i++) {
		
		// Create full method mask
		String attr = serviceClassName + "." + methods[i]; // + "*";

		// attr        = "mypackage.service.MyService.get*"
		// roles       = "ROLE_1 ROLE_2 ROLE_3"

		permissionAttributes.put(attr, roles);
		if (isPrintPermission){
		    logInfo("attr=[" + attr + ", value=[" + roles + "]");
		}
	    }
	}

    }

    private static void createVirtualPermissionAttributes() {

	String roleVirtual = "ROLE_" + "VIRTUAL" + System.currentTimeMillis();
	String[] types = new String[] { "READ", "WRITE", "EXEC" };
	Set<String> keys = serviceMap.keySet();
	if (keys == null || keys.size() == 0) {
	    return;
	}
	if (isPrintVirtualPermission ) {
	    logInfo("VIRTUAL PERMISSION:");    
	}
	for (String key : keys) {
	    String entity = key;
	    String serviceClassName = serviceMap.get(entity);

	    for (int k = 0; k < types.length; k++) {
		String type = types[k];
		
		// Get method mask
		String[] methods = getMethodsByType(type);
		if (methods == null) {
		    continue;
		}
		for (int i = 0; i < methods.length; i++) {
		    String attr = serviceClassName + "." + methods[i]; // + "*";
		    
		    // attr        = "mypackage.service.MyService.get*"
		    // roleVirtual = "ROLE_VIRTUAL1234567890"
		    
		    permissionAttributes.put(attr, roleVirtual);
		    if (isPrintVirtualPermission) {
			logInfo("attr=[" + attr + ", value=[" +  roleVirtual + "]");
		    }
		}
	    }
	}
    }

    /**
     * Return special mask to find method to secure
     * For example:
     *  READ flag  - "get*", "find*"
     *  WRIRE flag - "set*", "create*", "store*", "remove*"
     * @param type
     * @return
     */
    private static String[] getMethodsByType(String type) {
	if ("READ".equals(type)) {
	    return new String[] { "get*", "find*" };
	} else if ("WRITE".equals(type)) {
	    return new String[] { "set*", "create*", "store*", "remove*" };
	}
	return null;
    }

    public static Map getPermisionAttributes() {
	return permissionAttributes;
    }
    
    
    protected static void logInfo(Object message) {
	logInfo(logger, message);
    }
    
    protected static void logError(Object message) {
	logError(logger, message);
    }

    protected static void logError(Object message, Throwable t) {
	logError(logger, message, t);
    }
    

}
