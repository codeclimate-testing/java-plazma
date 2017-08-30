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

/* 
 * Created on 15.09.2008
 *
 */

package org.plazmaforge.framework.platform.service.cache;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author Oleh Hapon
 * $Id: ServiceCacheEnvironment.java,v 1.4 2010/04/28 06:34:32 ohapon Exp $
 */

public class ServiceCacheEnvironment {

    private Map<String, ServiceCache> cacheMap = new HashMap<String, ServiceCache>();
    
    private static ServiceCacheEnvironment instance;

    
    public Map<String, ServiceCache> getCacheMap() {
        return cacheMap;
    }

    public synchronized static ServiceCacheEnvironment getInstance() {
	if (instance == null) {
	    instance = new ServiceCacheEnvironment();
	}
        return instance;
    }
    
    public static void addServiceCache(String serviceClassName, ServiceCache cache) {
	getInstance().getCacheMap().put(serviceClassName, cache);
    }
    
    public static void addServiceCache(String serviceClassName) {
	addServiceCache(serviceClassName, 0);
    }
    
    public static void addServiceCache(String serviceClassName, long expireTime) {
	
	ServiceCache serviceCache = new ServiceCache();
	if (expireTime > 0) {
	    serviceCache.setExpireTime(expireTime);
	}
	
	
	serviceCache.setServiceClassName(serviceClassName);
	addServiceCache(serviceClassName, serviceCache);
    }
    
    public static ServiceCache getServiceCache(String serviceClassName) {
	return getInstance().getCacheMap().get(serviceClassName);
    }
}
