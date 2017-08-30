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
 * Created on 15.04.2006
 */

package org.plazmaforge.framework.platform.structure;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.service.PeriodCreator;


/**
 * A <code>System</code> of <code>Platform</code>
 */
public interface PlatformSystem {

    void addFramework(Framework framework);

    void addFramework(String id, Framework framework);

    Framework getFramework(String id);

    boolean isFramework(String id);

    List getFrameworks();

    void addPackage(Package pkg);

    void addPackage(String id, Package pkg);

    Package getPackage(String id);

    boolean isPackage(String id);

    List getPackages();

    void initPackages() throws ApplicationException;

    Integer registerPeriod(Serializable context) throws ApplicationException;

    void setPeriodCreator(PeriodCreator periodCreator);

}
