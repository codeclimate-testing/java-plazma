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

package org.plazmaforge.framework.client.swing.controls;

import javax.swing.*;
import javax.swing.text.Document;

import org.plazmaforge.framework.client.swing.gui.NumberDocument;



import java.text.ParseException;
import java.text.NumberFormat;

/**
 * @author Oleh Hapon
 * Date: 05.05.2004
 * Time: 10:23:51
 * $Id: XNumberField.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */
public class XNumberField  extends JTextField  {

    public static int DEFAULT_COLUMNS = 12;

    private int decimals = 2;

    private boolean integer = false;

    private double value = 0.0;

    private java.text.NumberFormat numberFormat = null;

    //private javax.swing.event.EventListenerList listenerList =  null;


    public XNumberField() {
        this.setColumns(DEFAULT_COLUMNS);
        init();
    }

    public XNumberField(int col) {
        super(col);
        init();
    }


    private void init() {
        //this.addFocusListener(this);
        numberFormat=NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(true);
        this.setText(numberFormat.format(0));
        setHorizontalAlignment(JTextField.RIGHT);


/*        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent evt) {
                numberFormat.setGroupingUsed(false);
                setText( numberFormat.format(value));
                numberFormat.setGroupingUsed(isGrouping());
            }
            public void focusLost(FocusEvent evt) {
                parseValue();
            }
        });
*/    }
	
    protected Document createDefaultModel() {
        return new NumberDocument();
    }

    public int getDecimals() {
        return this.decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
        if (!isInteger()) {
            numberFormat.setMaximumFractionDigits(decimals);
            numberFormat.setMinimumFractionDigits(decimals);
        }
        this.setText( numberFormat.format(getValue()));
    }

    public boolean isInteger() {
        return this.integer;
    }

    public void setInteger(boolean integer) {
        if (integer) {
            numberFormat.setMaximumFractionDigits(0);
            numberFormat.setMinimumFractionDigits(0);
        } else {
            numberFormat.setMaximumFractionDigits(getDecimals());
            numberFormat.setMinimumFractionDigits(getDecimals());
        }
        this.integer = integer;
        this.setText( numberFormat.format(getValue()));
    }


    protected void parseValue() {
        setText(getText());
        try {
            double oldValue = value;
            value =  numberFormat.parse(getText()).doubleValue();
            //this.fireActionListenerActionPerformed(new java.awt.event.ActionEvent( this, 0, "") );
        } catch (ParseException ex){
			ex.printStackTrace();
        }
        setText( numberFormat.format(value));
    }


    public Double getDoubleValue() {
        return new Double(getValue());
    }

    public double getValue() {
        parseValue();
        return this.value;
    }

    public double doubleValue() {
        return getValue();
    }

    public byte byteValue() {
        return (byte) getValue();
    }

    public int intValue() {
        return (int) getValue();
    }

    public short shortValue() {
        return (short) getValue();
    }

    public float floatValue() {
        return (float) getValue();
    }

    public void setValue(Double value) {
        if (value == null) {
            setValue(0d);
        } else {
            setValue(value.doubleValue());
        }
    }

    public void setValue(double value) {
        this.value = value;
        this.setText(numberFormat.format(this.value));
    }

    public void setValue(int value) {
        setValue((double)value);
    }



    public boolean isGrouping() {
        return this.numberFormat.isGroupingUsed();
    }

    public void setGrouping(boolean grouping) {
        this.numberFormat.setGroupingUsed(grouping);
    }

/*
   
    public synchronized void addActionListener(java.awt.event.ActionListener listener) {
        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add(java.awt.event.ActionListener.class, listener);
    }

    public synchronized void removeActionListener(java.awt.event.ActionListener listener) {
        listenerList.remove(java.awt.event.ActionListener.class, listener);
    }

    private void fireActionListenerActionPerformed(java.awt.event.ActionEvent event) {
        if (listenerList == null) return;
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==java.awt.event.ActionListener.class) {
                ((java.awt.event.ActionListener)listeners[i+1]).actionPerformed(event);
            }
        }
    }
    
*/

}
