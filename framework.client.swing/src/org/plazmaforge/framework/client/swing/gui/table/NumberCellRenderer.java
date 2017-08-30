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
package org.plazmaforge.framework.client.swing.gui.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import org.plazmaforge.framework.core.SystemEnvironment;


import java.text.NumberFormat;
import java.text.DecimalFormat;

/**
 * @author Oleh Hapon Date: 04.12.2004 Time: 15:10:33 $Id: NumberCellRenderer.java,v 1.3 2010/12/05 07:52:10 ohapon Exp $
 */
public class NumberCellRenderer extends DefaultTableCellRenderer {

    protected NumberFormat numberFormat;

    public NumberCellRenderer() {
	setHorizontalAlignment(JLabel.RIGHT);
    }

    public NumberCellRenderer(String pattern) {
	initPattern(pattern);
    }

    public NumberFormat getNumberFormat() {
	if (numberFormat == null) {
	    numberFormat = createNumberFormat();
	}
	return numberFormat;
    }

    public String getPattern() {
	return ((DecimalFormat) getNumberFormat()).toPattern();
    }

    protected void initPattern(String pattern) {
	numberFormat = new DecimalFormat(pattern);
    }

    public NumberCellRenderer(int decimal) {
	numberFormat = createNumberFormat();
	DecimalFormat decimalFormat = (DecimalFormat) numberFormat;

	decimalFormat.setMaximumFractionDigits(decimal);
	decimalFormat.setMinimumFractionDigits(decimal);
    }

    protected NumberFormat createNumberFormat() {
	DecimalFormat decimalFormat = (DecimalFormat) SystemEnvironment
		.getNumberFormat();
	decimalFormat.setMaximumFractionDigits(getDefaultFractionDigits());
	decimalFormat.setMinimumFractionDigits(getDefaultFractionDigits());
	return decimalFormat;
    }

    protected int getDefaultFractionDigits() {
	return 2;
    }

    public void setValue(Object value) {
	setText((value == null) ? "" : getNumberFormat().format(value));
    }

}
