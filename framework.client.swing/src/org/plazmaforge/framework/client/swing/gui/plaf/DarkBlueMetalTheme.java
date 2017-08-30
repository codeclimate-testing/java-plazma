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

package org.plazmaforge.framework.client.swing.gui.plaf;

import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 20.03.2004
 * Time: 9:57:50
 * $Id: DarkBlueMetalTheme.java,v 1.2 2010/04/28 06:36:12 ohapon Exp $
 */
public class DarkBlueMetalTheme  extends DefaultMetalTheme {

    
    //private static final int[] fontStyles2 = {
    //    Font.PLAIN, Font.PLAIN, Font.PLAIN, Font.PLAIN, Font.PLAIN, Font.PLAIN
    //};
    

    //
    //private static final int[] fontSizes = {
    //    22, 22, 22, 22, 22, 20
    //};




    // light blue colors
    private final ColorUIResource primary1  = new ColorUIResource( 44,  73, 135);
    private final ColorUIResource primary2  = new ColorUIResource( 85, 115, 170); // 58, 110, 165);
    private final ColorUIResource primary3  = new ColorUIResource(49,106,250); //172, 210, 248); //189, 220, 251); //153, 179, 205);

    private final ColorUIResource secondary1 = new ColorUIResource(110, 110, 110);
    private final ColorUIResource secondary2 = new ColorUIResource(170, 170, 170);
    private final ColorUIResource secondary3 = new ColorUIResource(220, 220, 220);


    //
    // Returns the ideal font style for the font identified by key.
    //
    //static int getDefaultFontStyle(int key) {
    //    return fontStyles2[key];
    //}
    //static int getDefaultFontSize(int key) {
    //    return fontSizes[key];
    //}



    public String getName() { return "All Blues - Bold"; }

    public  ColorUIResource getMenuItemSelectedBackground() { return getPrimary2(); }
    public  ColorUIResource getMenuItemSelectedForeground() { return getWhite();            }
    public  ColorUIResource getMenuSelectedBackground()     { return getSecondary2();       }

    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }
    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }




    private FontUIResource controlTextFont;
    private FontUIResource systemTextFont;
    private FontUIResource userTextFont;
    private FontUIResource menuTextFont;
    private FontUIResource windowTitleFont;
    private FontUIResource subTextFont;

    public DarkBlueMetalTheme() {
        super();
        Font f = null;

        f = new Font("Dialog",Font.PLAIN,11);
        controlTextFont = new FontUIResource(f);

        f = new Font("Dialog",Font.PLAIN,11);
        systemTextFont = new FontUIResource(f);

        f = new Font("Dialog",Font.PLAIN,11);
        userTextFont = new FontUIResource(f);

        f = new Font("Dialog",Font.PLAIN,11);
        menuTextFont = new FontUIResource(f);

        f = new Font("Dialog",Font.PLAIN,11);
        windowTitleFont = new FontUIResource(f);

        f = new Font("Dialog",Font.PLAIN,11);
        subTextFont = new FontUIResource(f);

    }




    public FontUIResource getControlTextFont() {
        return controlTextFont;
    }

    public FontUIResource getSystemTextFont() {
        return systemTextFont;
    }

    public FontUIResource getUserTextFont() {
        return userTextFont;
    }

    public FontUIResource getMenuTextFont() {
        return menuTextFont;
    }

    public FontUIResource getWindowTitleFont() {
        return windowTitleFont;
    }

    public FontUIResource getSubTextFont() {
        return subTextFont;
    }



}
