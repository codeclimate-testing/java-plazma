/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs.web.server;

import java.util.List;

import org.plazmaforge.bs.web.client.ConfigurationService;
import org.plazmaforge.bs.web.client.SerializableWhitelist;
import org.plazmaforge.framework.config.configurer.AcceptorConfigurer;
import org.plazmaforge.framework.config.configurer.ActionConfigurer;
import org.plazmaforge.framework.config.configurer.AssociationConfigurer;
import org.plazmaforge.framework.config.configurer.ConfigurerInfo;
import org.plazmaforge.framework.config.configurer.FormConfigurer;
import org.plazmaforge.framework.config.configurer.InterfaceConfigurer;
import org.plazmaforge.framework.config.configurer.MenuBarConfigurer;
import org.plazmaforge.framework.config.configurer.PackageConfigurer;
import org.plazmaforge.framework.config.configurer.ReportConfigurer;
import org.plazmaforge.framework.config.configurer.ToolBarConfigurer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author ohapon
 *
 */
@SuppressWarnings("serial")
public class ConfigurationServiceImpl extends RemoteServiceServlet implements ConfigurationService {

    public static final String[] CONFIGURER_NAMES = {
	ActionConfigurer.NAME,
	InterfaceConfigurer.NAME,
	ToolBarConfigurer.NAME,
	MenuBarConfigurer.NAME,
	FormConfigurer.NAME,
	AcceptorConfigurer.NAME,
	ReportConfigurer.NAME,
	AssociationConfigurer.NAME,
	PackageConfigurer.NAME,
    };

    
    public void addWhitelist(SerializableWhitelist whitelist) {}

    public List<ConfigurerInfo<?>> getConfigurers(String category) {
	return getConfigurers(CONFIGURER_NAMES, category);
    }

    public List<ConfigurerInfo<?>> getConfigurers(String[] names, String category) {
	
	// Get configurers from ServletContext 
	List<ConfigurerInfo<?>> configurers = (List<ConfigurerInfo<?>>) getServletContext().getAttribute("configurer.manager.configurers");
	if (configurers == null) {
	    return null;
	}
	
	List<ConfigurerInfo<?>> result = ConfigurerInfo.cloneConfigurers(configurers, names, category);
	return result;
    }
    
  
    
}
