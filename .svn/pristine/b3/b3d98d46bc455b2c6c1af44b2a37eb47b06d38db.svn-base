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
package org.plazmaforge.bs.web.client;

import org.plazmaforge.bs.base.shared.entities.Country;
import org.plazmaforge.bs.base.shared.entities.Currency;
import org.plazmaforge.bs.base.shared.entities.CurrencyRate;
import org.plazmaforge.bs.base.shared.entities.Language;
import org.plazmaforge.bs.base.shared.entities.Period;
import org.plazmaforge.bs.base.shared.entities.PeriodType;
import org.plazmaforge.bs.base.shared.entities.Tax;
import org.plazmaforge.bs.base.shared.entities.Unit;
import org.plazmaforge.bs.organization.shared.entities.Department;
import org.plazmaforge.bs.organization.shared.entities.Organization;
import org.plazmaforge.bs.organization.shared.entities.OrganizationHeader;
import org.plazmaforge.bs.organization.shared.entities.OrganizationTitle;
import org.plazmaforge.bs.security.shared.entities.Role;
import org.plazmaforge.bs.security.shared.entities.RoleInterface;
import org.plazmaforge.bs.security.shared.entities.User;
import org.plazmaforge.bs.security.shared.entities.UserHeader;
import org.plazmaforge.bs.security.shared.entities.UserOrganization;
import org.plazmaforge.bs.security.shared.entities.UserRole;
import org.plazmaforge.framework.config.object.ActionConfig;
import org.plazmaforge.framework.config.object.ActionDescriptorConfig;
import org.plazmaforge.framework.config.object.ActionExecutorConfig;
import org.plazmaforge.framework.config.object.DialogConfig;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.config.object.EntityTypeConfig;
import org.plazmaforge.framework.config.object.FormConfig;
import org.plazmaforge.framework.config.object.InterfaceConfig;
import org.plazmaforge.framework.config.object.MenuBarConfig;
import org.plazmaforge.framework.config.object.MenuConfig;
import org.plazmaforge.framework.config.object.MenuItemConfig;
import org.plazmaforge.framework.config.object.MenuSeparatorConfig;
import org.plazmaforge.framework.config.object.ModuleConfig;
import org.plazmaforge.framework.config.object.ObjectConfig;
import org.plazmaforge.framework.config.object.PackageConfig;
import org.plazmaforge.framework.config.object.ReportConfig;
import org.plazmaforge.framework.config.object.ReportDescriptorConfig;
import org.plazmaforge.framework.config.object.ToolBarConfig;
import org.plazmaforge.framework.config.object.ConfigIdentifier;
import org.plazmaforge.framework.config.object.AssociationConfig;
import org.plazmaforge.framework.config.object.ToolItemConfig;
import org.plazmaforge.framework.config.object.UIObjectConfig;
import org.plazmaforge.framework.core.exception.AccessDeniedException;
import org.plazmaforge.framework.core.exception.DAOException;
import org.plazmaforge.framework.core.exception.DSException;
import org.plazmaforge.framework.core.service.ServiceCallerException;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author ohapon
 *
 */
public class SerializableWhitelist implements IsSerializable {
    
    ConfigIdentifier ConfigIdentifier;
    
    ObjectConfig objectConfig;
    UIObjectConfig uiObjectConfig;
    
    ModuleConfig moduleConfig;
    PackageConfig packageConfig;
    ActionConfig actionConfig;
    ActionDescriptorConfig actionDescriptorConfig; 
    ActionExecutorConfig actionExecutorConfig;
    AssociationConfig associationConfig;
    
    MenuBarConfig menuBarConfig;
    MenuConfig menuConfig;
    MenuItemConfig menuItemConfig;
    MenuSeparatorConfig menuSeparatorConfig;
    ToolBarConfig toolBarConfig;
    ToolItemConfig toolItemConfig;
    
    DialogConfig dialogConfig;
    FormConfig formConfig;
    ReportConfig reportConfig;
    ReportDescriptorConfig reportDescriptorConfig;
    
    EntityConfig etityConfig;
    EntityTypeConfig etityTypeConfig;
    
    InterfaceConfig interfaceConfig;
    

    
    ////////////////////////////////////////////////////////////////////////////////
    // SERIALIZABLE EXCEPTIONS 
    ////////////////////////////////////////////////////////////////////////////////

    ServiceCallerException serviceCallerException;
    AccessDeniedException accessDeniedException;
    DAOException daoException;
    DSException dsException;
    
    
    
    ////////////////////////////////////////////////////////////////////////////////
    // SERIALIZABLE ENTITIES 
    ////////////////////////////////////////////////////////////////////////////////

    // base
    Country country;
    Currency currency;
    CurrencyRate currencyRate;
    Language language;
    Period period;
    PeriodType periodType;
    Tax tax;
    Unit unit;

    // security
    Role role;
    RoleInterface roleInterface;
    User user;
    UserHeader userHeader;
    UserOrganization userOrganization;
    UserRole userRole;
    
    // organization
    Department department;
    OrganizationHeader organizationHeader;
    OrganizationTitle organizationTitle;
    Organization organization;
    
    // partner
    //ActivityType activityType;
    //FormProperty formProperty;
    //Industry industry;
    //PartnerCategory partnerCategory;
    //PartnerGroup partnerGroup;
    //PartnerType partnerType;
    

}


