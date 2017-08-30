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
 * Created on 22.12.2004
 *
 */

/**
 * @author Oleh Hapon
 * $Id: MoneyEnvironment.java,v 1.5 2010/12/05 07:51:28 ohapon Exp $
 */
package org.plazmaforge.framework.util;

import java.util.Currency;

import org.plazmaforge.framework.core.LocaleManager;

public class MoneyEnvironment {

    private static MoneyEnvironment ourInstance;

    private static int defaultFractionsDigits;

    private static int priceFractionsDigits;

    public synchronized static MoneyEnvironment getInstance() {
	if (ourInstance == null) {
	    ourInstance = new MoneyEnvironment();
	}
	return ourInstance;
    }

    private MoneyEnvironment() {

    }

    static {
	//Locale locale = Locale.getDefault();
	//defaultFractionsDigits = Currency.getInstance(locale).getDefaultFractionDigits();
	
	// FIXED 2009-01-23. 
	// We had problems with incorrect locale, for example: en_EN. 
	// We had error when we try get currency from incorrect locale
	
	Currency currency = LocaleManager.getCurrency();
	defaultFractionsDigits = currency == null ? 2 : currency.getDefaultFractionDigits();
	priceFractionsDigits = defaultFractionsDigits;
    }

    public static int getDefaultFractionsDigits() {
	return defaultFractionsDigits;
    }

    public static void setDefaultFractionsDigits(int defaultFractionsDigits) {
	MoneyEnvironment.defaultFractionsDigits = defaultFractionsDigits;
    }

    public static int getPriceFractionsDigits() {
	return priceFractionsDigits;
    }

    public static void setPriceFractionsDigits(int priceFractionsDigits) {
	MoneyEnvironment.priceFractionsDigits = priceFractionsDigits;
    }

    public static double roundMoney(double money, int digits) {
	return NumberUtils.round(money, digits);
    }

    public static double roundMoney(double money) {
	return roundMoney(money, getDefaultFractionsDigits());
    }

    public static double roundPrice(double price) {
	return roundMoney(price, getPriceFractionsDigits());
    }

}
