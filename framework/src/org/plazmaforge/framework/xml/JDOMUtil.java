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
 * Created on 23.03.2008
 *
 */

package org.plazmaforge.framework.xml;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/** 
 * @author Oleh Hapon
 * $Id: JDOMUtil.java,v 1.2 2010/04/28 06:34:35 ohapon Exp $
 */

public class JDOMUtil {

    
    public static  XMLOutputter createXMLOutputter() {
//        Format format = Format.getPrettyFormat();
//        format.setEncoding("UTF-8");
        XMLOutputter xmloutputter = new XMLOutputter();
        return xmloutputter;
    }

    public static  XMLOutputter createXMLOutputter(String encoding) {
        Format format = Format.getPrettyFormat();
        if (encoding == null) {
            encoding = "UTF-8";
        }
        format.setEncoding(encoding);
        XMLOutputter xmloutputter = new XMLOutputter(format);
        return xmloutputter;
    }

   
}
