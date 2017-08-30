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

/**
 * @author Oleh Hapon
 */

package org.plazmaforge.framework.platform.service;

import java.io.Serializable;
import java.util.Map;

import org.plazmaforge.framework.core.exception.ApplicationException;


/**
 * Executor for compression data period
 * 
 * For example you use data by period (month, quarter, year and etc). When you
 * create new period you have to compresses actualy period.
 * 
 * @author hapon
 * 
 */
public interface CompressionExecutor {

    /**
     * Set parameters
     * 
     * @param parameters
     */
    void setParameters(Map parameters);

    /**
     * Set parameter
     * 
     * @param key
     * @param value
     */
    void setParameter(Object key, Object value);

    /**
     * Compression actualy data period
     * 
     * @param data
     * @throws ApplicationException
     */
    void compression(Serializable data) throws ApplicationException;

    /**
     * Before commpression
     * 
     * @param data
     * @throws ApplicationException
     */
    void beforeCompression(Serializable data) throws ApplicationException;

    /**
     * After compression
     * 
     * @param data
     * @throws ApplicationException
     */
    void afterCompression(Serializable data) throws ApplicationException;

}
