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
 * Created on 03.01.2007
 *
 */

package org.plazmaforge.framework.action;

import java.util.List;

import org.plazmaforge.framework.core.DataTransfer;
import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * $Id: IAction.java,v 1.6 2010/12/05 07:51:27 ohapon Exp $
 */

public interface IAction {
    
    String PARAMETERS_DELIM = ",";
    
    
    String getId();

    void setId(String id);
    
    String getName();
    
    void setName(String name);
    
    String getText();
    
    void setText(String text);
    
    String getDescription();
    
    void setDescription(String description);
    
    
    String getCommand();
    
    void setCommand(String command);
    
    
    String getParameter();
    
    void setParameter(String parameter);
    
    void addParameter(String parameter);
    
    List<String> getParameters();
    
    String getParametersString();
    
    void clearParameters();
    
    
    
    String getImageUrl();
    
    void setImageUrl(String imageUrl);
    
    
    Object getOriginal();
    
    void execute() throws ApplicationException;
    
    void execute(DataTransfer transfer) throws ApplicationException;
    
}
