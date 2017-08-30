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
 * Created on 10.07.2004
 *
 */
package org.plazmaforge.framework.core;


import java.io.Serializable;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * @author Oleh Hapon
 * $Id: IAcceptor.java,v 1.1 2010/12/05 07:51:25 ohapon Exp $
 */
public interface IAcceptor extends Serializable  {

    String ID = "ID";

    String NAME = "NAME";

    String ENTITY = "ENTITY";

    String DIALOG = "DIALOG";
    
    
    String REPORT_CONNECTION = "ACCEPTOR.REPORT_CONNECTION";
    
    String REPORT_ENGINE = "ACCEPTOR.REPORT_ENGINE";
    
    

    Map<String, Object> readParameters() throws ApplicationException;

    boolean isStartProcess() throws ApplicationException;

    void prepareData(Map parameters) throws ApplicationException;
}