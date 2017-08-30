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

package org.plazmaforge.framework.report;

import java.io.Serializable;
import java.util.Map;

import org.plazmaforge.framework.core.IAcceptor;
import org.plazmaforge.framework.core.LocaleConstants;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon Date: 08.07.2004 Time: 9:14:40 $Id: IReport.java,v 1.8 2010/12/05 07:51:25 ohapon Exp $
 */
public interface IReport extends Serializable,  LocaleConstants {

    
    String PATH_SEPARATOR = "/";
    

    String ID = "ID";

    String NAME = "NAME";

    String TITLE = "TITLE";

    String TABLE = "TABLE";

    String DATE = "DATE";

    String START_DATE = "START_DATE";

    String END_DATE = "END_DATE";
    
    

    String getId();

    void setId(String id);
    
    String getName();

    void setName(String name);

    String getCaption();

    void setCaption(String caption);
    
    String getDescription();

    void setDescription(String description);
    
    String getFileName();

    String getPath();
    
    
    String getAbsoluteFileName();

    /** 
     * Get absolute real report file name
     *  
     **/
    String getReportFileName();
    
    /**
     * Set absolute real report file name
     * @param name
     */
    void setReportFileName(String name);

    /**
     * Get absolute real report path
     * @return
     */
    String getReportPath();

    /**
     * Set absolute real report path
     * @param name
     */
    void setReportPath(String name);
    
    

    String[] getAvailableLocaleFileNames();




    String getLocalePrefix();

    String getRegion();

    String getCountry();

    String getLanguage();

    void setParameter(String name, Object value);

    Object getParameter(String name);

    void addParameters(Map<String, Object> map);

    Map<String, Object> getParameters();

    void readParameters() throws ApplicationException;

    void setAcceptor(IAcceptor acceptor);

    IAcceptor getAcceptor();

    void verifyParameters() throws InvalidReportParameterException;

    boolean isChangeParameters();
    
    boolean isAsolutePath();
}
