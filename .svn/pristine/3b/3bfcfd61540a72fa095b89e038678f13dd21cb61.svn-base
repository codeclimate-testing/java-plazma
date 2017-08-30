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

package org.plazmaforge.bsolution.goods.client.swing;

import org.plazmaforge.bsolution.base.EnterpriseEnvironment;
import org.plazmaforge.bsolution.base.SessionEnvironment;
import org.plazmaforge.bsolution.goods.client.swing.resources.GUIGoodsResources;
import org.plazmaforge.bsolution.goods.common.beans.Goods;
import org.plazmaforge.bsolution.goods.common.beans.GoodsType;
import org.plazmaforge.bsolution.goods.common.services.GoodsTypeService;
import org.plazmaforge.framework.ext.service.ServiceFactory;


/**
 * @author Oleh Hapon
 * Date: 15.08.2004
 * Time: 15:39:35
 * $Id: GUIGoodsEnvironment.java,v 1.2 2010/04/28 06:28:21 ohapon Exp $
 */
public class GUIGoodsEnvironment {

    private static GUIGoodsResources resources;

    public static Integer GOODS_TYPE_ID;
    
    private static GoodsType goodsType;

    static {
	resources = new GUIGoodsResources();
	GOODS_TYPE_ID = new Integer(1);
    }

    public static GUIGoodsResources getResources() {
	return resources;
    }

    public static void initGoods(Goods goods) {
	if (goods == null) {
	    return;
	}
	goods.setOrganization(EnterpriseEnvironment.getOrganization(SessionEnvironment.getContext()));
	goods.setUnit(EnterpriseEnvironment.getUnit());
	goods.setGoodsType(getGoodsType());
	goods.setCurrency(EnterpriseEnvironment.getCurrency());

    }

    public static GoodsType getGoodsType() {
	if (goodsType == null) {
	    try {
		GoodsTypeService service = (GoodsTypeService) ServiceFactory.getService(GoodsTypeService.class); 
		goodsType = service.findById(GOODS_TYPE_ID);
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
	
	//GoodsType goodsType = new GoodsType();
	//goodsType.setId(GOODS_TYPE_ID);
	return goodsType;
    }

}
