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


package org.plazmaforge.framework.client.swing.gui;

import javax.swing.Action;

import org.plazmaforge.framework.config.AbstractConfigFactory;
import org.plazmaforge.framework.config.configurer.ActionConfigurer;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.report.ReportFactory;
import org.plazmaforge.framework.util.ClassUtilsExt;


public class GUIActionFactory  extends AbstractConfigFactory {

    private static GUIActionFactory instance;
    
    private GUIActionFactory() {
    }
    
    public synchronized static GUIActionFactory getInstance() {
        if (instance == null) {
            instance = new GUIActionFactory();
        }
        return instance;
    }
    
    protected String getConfigurerName() {
        return ActionConfigurer.NAME;
    }
    

    
    public static Action getActionById(String id) {
        return getAction((IActionConfig) getInstance().getObjectConfigById(id));
    }
    
    
    public static Action getAction(IActionConfig actionConfig) {
        return getInstance().createAction(actionConfig);
    }
    
    
    
    
    
    protected Action createAction(IActionConfig actionConfig) {
        
        Action action = null;
        if (actionConfig == null) return null;
        if ("-".equals(actionConfig.getName())) return null;
        String actionClass = actionConfig.getClassName();
        String actionCommand = actionConfig.getCommand();
        
        
        if (!isEmpty(actionClass)) {
            try {
                action = (Action) ClassUtilsExt.forName(actionClass).newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (!isEmpty(actionCommand)) {
            // Stub
            if ("PREVIEW_REPORT".equals(actionCommand)) {
        	
                try {
                    String reportName = null; //actionConfig.hasParameters() ? actionConfig.getParameters().get(0) : null;
                    action = (Action) ReportFactory.getReportActionByName(reportName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            
        }
        return action;

    }

}
