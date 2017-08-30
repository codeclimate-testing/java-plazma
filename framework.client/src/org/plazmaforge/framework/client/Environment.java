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

package org.plazmaforge.framework.client;



/**
 * The Rich Client Environment
 * 
 * @author ohapon
 *
 */
public class Environment {
    
    public static final String AWT   = "AWT";
    
    public static final String SWING = "Swing";
    
    public static final String SWT   = "SWT";
    
    
    public static final String PLAZMA_RCP_PROPERTY = "plazma.rcp";
    
    public static final String PLAZMA_RCP_LIST_FORM_PROPERTY = PLAZMA_RCP_PROPERTY + ".listform";
    
    public static final String PLAZMA_RCP_EDIT_FORM_PROPERTY = PLAZMA_RCP_PROPERTY +  ".editform";
    
    public static final String PLAZMA_RICHCLIENT_IMAGES = "/org/plazmaforge/framework/client/images";
    

    /** Form factory (Get the Edit form, List form and etc.) **/
    private static IFormFactory formFactory;
    
    /** Service factory (Get the Service) **/
    private static IServiceFactory serviceFactory;
    
    /** Entities Management **/
    private static IEntityManager entityManager;
    
    /** Toolkit Management (Forms and other) **/
    private static IToolkitManager toolkitManager;
    
    /** Action factory **/
    private static IActionFactory actionFactory;
    
    /** Report factory **/
    private static IReportFactory reportFactory;
    
    
    

    /** Is select text in edit control when control accept focus **/
    private static boolean selectValueWhenFocus = true;
    

    private static String guiType = SWT;
    
    static {
	//
    }
    
    public static String getGuiType() {
        return guiType;
    }

    public static void setGuiType(String guiType) {
        Environment.guiType = guiType;
    }

    public static IEntityManager getEntityManager() {
        return entityManager;
    }

    public static void setEntityManager(IEntityManager entityManager) {
        Environment.entityManager = entityManager;
    }

    public static IFormFactory getFormFactory() {
        return formFactory;
    }

    public static void setFormFactory(IFormFactory formFactory) {
        Environment.formFactory = formFactory;
    }

    public static IServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public static void setServiceFactory(IServiceFactory serviceFactory) {
        Environment.serviceFactory = serviceFactory;
    }

    public static IToolkitManager getToolkitManager() {
        return toolkitManager;
    }

    public static void setToolkitManager(IToolkitManager toolkitManager) {
        Environment.toolkitManager = toolkitManager;
    }

    
    public static IActionFactory getActionFactory() {
        return actionFactory;
    }

    public static void setActionFactory(IActionFactory actionFactory) {
        Environment.actionFactory = actionFactory;
    }

    public static IReportFactory getReportFactory() {
        return reportFactory;
    }

    public static void setReportFactory(IReportFactory reportFactory) {
        Environment.reportFactory = reportFactory;
    }

    public static boolean isSelectValueWhenFocus() {
        return selectValueWhenFocus;
    }

    public static void setSelectValueWhenFocus(boolean selectValueWhenFocus) {
        Environment.selectValueWhenFocus = selectValueWhenFocus;
    }

    
    
    
}
