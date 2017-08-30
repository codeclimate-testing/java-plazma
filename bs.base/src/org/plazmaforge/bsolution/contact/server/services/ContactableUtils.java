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
 * Created on 18.02.2009
 *
 */

package org.plazmaforge.bsolution.contact.server.services;

import java.util.Map;

/** 
 * @author Oleh Hapon
 * $Id: ContactableUtils.java,v 1.3 2010/04/28 06:24:25 ohapon Exp $
 */

public class ContactableUtils {

    public static void populateHibernatePropertyMap(Map<String, String> map) {
	map.put("phoneString", "defPhone.phoneString");
	map.put("addressString", "defAddress.addressString");
	//map.put("localityAddressString", "defAddress.localityAddressString");
	map.put("localityAddressString", "defAddress.addressString"); // TODO: STUB
	map.put("cityName", "defAddress.cityName");
	map.put("localityName", "defAddress.localityName");
    }

    public static void populateBankHibernatePropertyMap(Map<String, String> map) {
	map.put("phoneString", "defBankPhone.phoneString");
	map.put("addressString", "defBankAddress.addressString");
	//map.put("localityAddressString", "defBankAddress.localityAddressString");
	map.put("localityAddressString", "defBankAddress.addressString"); // TODO: STUB
	map.put("cityName", "defBankAddress.cityName");
	map.put("localityName", "defBankAddress.localityName");
    }

}
