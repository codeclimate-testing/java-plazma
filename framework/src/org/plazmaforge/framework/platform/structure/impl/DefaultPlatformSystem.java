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

package org.plazmaforge.framework.platform.structure.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.service.CompressionExecutor;
import org.plazmaforge.framework.platform.service.PeriodCreator;
import org.plazmaforge.framework.platform.structure.Framework;
import org.plazmaforge.framework.platform.structure.Package;
import org.plazmaforge.framework.platform.structure.PlatformSystem;


public class DefaultPlatformSystem implements PlatformSystem {

    /** Frameworks **/
    private Map<String, Framework> frameworks = new HashMap<String, Framework>();

    /** Frameworks **/
    private Map<String, Package> packages = new HashMap<String, Package>();

    /** Period creator **/
    private PeriodCreator periodCreator;

    public void addFramework(Framework framework) {
	addFramework(framework.getId(), framework);
    }

    public void addFramework(String id, Framework framework) {
	frameworks.put(id, framework);
    }

    public Framework getFramework(String id) {
	return (Framework) frameworks.get(id);
    }

    public boolean isFramework(String id) {
	return frameworks.containsKey(id);
    }

    public List<Framework> getFrameworks() {
	return new ArrayList<Framework>(frameworks.values());
    }

    public void addPackage(Package pkg) {
	addPackage(pkg.getId(), pkg);
    }

    public void addPackage(String id, Package pkg) {
	packages.put(id, pkg);
    }

    public Package getPackage(String id) {
	return packages.get(id);
    }

    public boolean isPackage(String id) {
	return packages.containsKey(id);
    }

    public List<Package> getPackages() {
	return new ArrayList<Package>(packages.values());
    }

    protected Iterator<Package> getPackagesIterator() {
	return packages.values().iterator();
    }

    /**
     * Initialize packages
     * 
     */
    public void initPackages() throws ApplicationException {
	Iterator<Package> itr = getPackagesIterator();
	while (itr.hasNext()) {
	    Package m = itr.next();
	    m.init();
	}
    }

    /**
     * Register new period in system
     * 
     * @return
     * @throws ApplicationException
     */
    public Integer registerPeriod(Serializable context) throws ApplicationException {
	return newPeriod(context);
    }

    /**
     * Create new period in system
     * 
     * @return
     * @throws ApplicationException
     */
    protected Integer newPeriod(Serializable context) throws ApplicationException {
	if (packages == null || packages.isEmpty()) {
	    return null;
	}
	Iterator<Package> itr = getPackagesIterator();
	List<CompressionExecutor> executors = new ArrayList<CompressionExecutor>();
	while (itr.hasNext()) {
	    Package m = (Package) itr.next();
	    if (m.getCompressionExecutor() == null) {
		continue;
	    }
	    executors.add(m.getCompressionExecutor());
	}
	if (executors.size() == 0) {
	    return null;
	}
	CompressionExecutor[] executorsArray = (CompressionExecutor[]) executors.toArray(new CompressionExecutor[0]);
	return newApplicationPeriod(executorsArray, context);
    }

    /**
     * Create new period in application
     * 
     * @param executors
     * @return
     * @throws ApplicationException
     */
    protected Integer newApplicationPeriod(CompressionExecutor[] executors, Serializable context)
	    throws ApplicationException {
	if (periodCreator == null) {
	    return null;
	}
	return periodCreator.createPeriod(executors, context);
    }

    /**
     * Set period creator
     * 
     * @param periodCreator
     */
    public void setPeriodCreator(PeriodCreator periodCreator) {
	this.periodCreator = periodCreator;
    }

}
