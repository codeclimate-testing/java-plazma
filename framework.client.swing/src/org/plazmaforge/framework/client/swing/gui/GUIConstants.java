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
package org.plazmaforge.framework.client.swing.gui;

import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 20.10.2003
 * Time: 16:02:12
 * $Id: GUIConstants.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public interface GUIConstants {

    // Default JTable preferences
    boolean DEFAULT_TABLE_COL_REORDERING_ALLOWED = true;
    boolean DEFAULT_TABLE_HORIZONTAL_LINES       = true;
    boolean DEFAULT_TABLE_VERTICAL_LINES = true;
    boolean DEFAULT_TABLE_COL_SELECTION_ALLOWED  = false;
    boolean DEFAULT_TABLE_ROW_SELECTION_ALLOWED  = true;

    int DEFAULT_TABLE_SELECTION_MODE             = 2;
    int DEFAULT_TABLE_AUTO_RESIZE_MODE           = 3;

    int DEFAULT_GRID_LAYOUT_LABEL_ANCHOR         = GridBagConstraints.WEST;
    Insets DEFAULT_EMPTY_BORDER_INSETS           = new Insets(5, 10, 5, 10);
    Insets DEFAULT_GRID_LAYOUT_INSETS            = new Insets(5, 5, 5, 10); //new Insets(5, 10, 5, 10);




    public int MAIN_MARGIN_LEFT = 10;
    public int MAIN_MARGIN_RIGHT = 10;
    public int MAIN_MARGIN_MIDDLE_H = 10;
    public int MAIN_MARGIN_TOP = 10;
    public int MAIN_MARGIN_BOTTOM =10;
    public int MAIN_MARGIN_MIDDLE_V = 10;

    public int GROUP_MARGIN_LEFT = 7;
    public int GROUP_MARGIN_RIGHT = 7;
    public int GROUP_MARGIN_MIDDLE_H = 0;
    public int GROUP_MARGIN_TOP = 5;
    public int GROUP_MARGIN_BOTTOM = 11;
    public int GROUP_MARGIN_MIDDLE_V = 2;

    public int TEXTFIELD_MARGIN_MIDDLE_H = 4;

    public int LABEL_HEIGHT = 21;
    public int LABEL0_WIDTH = 15;
    public int LABEL1_WIDTH = 75;
    public int LABEL2_WIDTH = 107;
    public int LABEL3_WIDTH = 185;
    public int LABEL4_WIDTH = 0;
    public int LABEL5_WIDTH = 0;




    public int CONTENT_PANE_WIDTH = 792;
    public int CONTENT_PANE_HEIGHT = 573;

    public int MAIN_MENU_HEIGHT = 23;

    public int NAVBAR_HEIGHT = 33;

    public int STATUS_BAR_HEIGHT = 23;

    public int FUNCTION_BAR_WIDTH = 100;

    public int MAIN_PANEL_HEIGHT = CONTENT_PANE_HEIGHT - MAIN_MENU_HEIGHT - NAVBAR_HEIGHT - STATUS_BAR_HEIGHT;
    public int MAIN_PANEL_WIDTH = CONTENT_PANE_WIDTH - FUNCTION_BAR_WIDTH;

    public int INTRO_MARGIN_LEFT = 0;
    public int INTRO_MARGIN_TOP = 25;
    public int INTRO_LINE_WIDTH = 185;
    public int INTRO_LINE_HEIGHT = 56;
    public int LOGO_WIDTH = 236;
    public int LOGO_HEIGHT = 145;
    public int INTRO_BUTTON_HEIGHT = 27;
    public int INTRO_BUTTON_WIDTH = 155;

    public int LOGIN_MARGIN_LEFT = 14;
    public int LOGIN_MARGIN_RIGHT = 14;
    public int LOGIN_MARGIN_MIDDLE_H = 14;
    public int LOGIN_MARGIN_TOP = 14;
    public int LOGIN_MARGIN_BOTTOM =14;
    public int LOGIN_MARGIN_MIDDLE_V = 14;

    public int DIALOG_MARGIN_LEFT = 5;
    public int DIALOG_MARGIN_RIGHT = 5;
    public int DIALOG_MARGIN_MIDDLE_H = 5;
    public int DIALOG_MARGIN_TOP = 5;
    public int DIALOG_MARGIN_BOTTOM =5;
    public int DIALOG_MARGIN_MIDDLE_V = 5;

    public int OUTER_MARGIN_LEFT = 7;
    public int OUTER_MARGIN_RIGHT = 9;
    public int OUTER_MARGIN_MIDDLE_H = 9;
    public int OUTER_MARGIN_TOP = 4;
    public int OUTER_MARGIN_BOTTOM =9;
    public int OUTER_MARGIN_MIDDLE_V = 4;

    public int INTAB_MARGIN_LEFT = 5;
    public int INTAB_MARGIN_RIGHT = 9;
    public int INTAB_MARGIN_MIDDLE_H = 9;
    public int INTAB_MARGIN_TOP = 2;
    public int INTAB_MARGIN_BOTTOM =6;
    public int INTAB_MARGIN_MIDDLE_V = 4;

    public int TEXTFIELD_MARGIN_V = 4;
    public int TEXTFIELD_MARGIN_H = 4;

    public int BUTTON_MARGIN_V = 4;
    public int BUTTON_MARGIN_H = 4;

    public int GROUP_BOX_LABEL_MARGIN = 8;
    public int GROUP_BOX_MARGIN_LEFT = 6;
    public int GROUP_BOX_MARGIN_RIGHT = 5;
    public int GROUP_BOX_MARGIN_TOP = 1;
    public int GROUP_BOX_MARGIN_BOTTOM = 5;
    public int GROUP_BOX_MARGIN_MIDDLE_V = 10;
    public int GROUP_BOX_MARGIN_MIDDLE_H = 12;

    public int TEXTFIELD_HEIGHT = 21;
    public int TEXTFIELD0_WIDTH = 50;
    public int TEXTFIELD1_WIDTH = 100;
    public int TEXTFIELD2_WIDTH = 204;
    public int TEXTFIELD3_WIDTH = 150;
    public int TEXTFIELD4_WIDTH = 143;
    public int TEXTFIELD5_WIDTH = 96;

    public int CHECKBOX_WIDTH = 16;

    public int COMBOBOX_HEIGHT = 21;
    public int COMBOBOX1_WIDTH = 100;
    public int COMBOBOX2_WIDTH = 204;
    public int COMBOBOX3_WIDTH = 150;
    public int COMBOBOX4_WIDTH = 0;
    public int COMBOBOX5_WIDTH = 0;

    public int Label0_WIDTH = 15;
    public int Label1_WIDTH = 75;
    public int Label2_WIDTH = 107;
    public int Label3_WIDTH = 185;
    public int Label4_WIDTH = 0;
    public int Label5_WIDTH = 0;

    public int LOGIN_BUTTON_HEIGHT = 19;
    public int BUTTON_HEIGHT = 22;
    public int BUTTON1_WIDTH = 86;
    public int BUTTON2_WIDTH = 100;
    public int BUTTON3_WIDTH = 134;
    public int BUTTON4_WIDTH = 150;
    public int BUTTON5_WIDTH = 0;
    public int BUTTON_OK_WIDTH = 75;
    public int BUTTON_CANCEL_WIDTH = 75;
    public int BUTTON_CLOSE_WIDTH = 100;

    public int LEFT_APPLICATION_PANE_WIDTH = (MAIN_PANEL_WIDTH - OUTER_MARGIN_LEFT - OUTER_MARGIN_MIDDLE_H - OUTER_MARGIN_RIGHT)/2 - 1;
    public int RIGHT_APPLICATION_PANE_WIDTH = (MAIN_PANEL_WIDTH - OUTER_MARGIN_LEFT - OUTER_MARGIN_MIDDLE_H - OUTER_MARGIN_RIGHT)/2 - 1;

    public int UP_PANEL_HEIGHT = (MAIN_PANEL_HEIGHT - OUTER_MARGIN_TOP - OUTER_MARGIN_MIDDLE_V - OUTER_MARGIN_BOTTOM)/2;
    public int BOTTOM_PANEL_HEIGHT = (MAIN_PANEL_HEIGHT - OUTER_MARGIN_TOP - OUTER_MARGIN_MIDDLE_V - OUTER_MARGIN_BOTTOM)/2;

    public int NAVBAR_MARGIN_LEFT = 5;
    public int NAVBAR_MARGIN_RIGHT = 5;
    public int NAVBAR_MARGIN_TOP = 5;
    public int NAVBAR_MARGIN_BOTTOM =5;

    public int FUNCTION_BAR_MARGIN_LEFT = 7;
    public int FUNCTION_BAR_MARGIN_RIGHT = 7;
    public int FUNCTION_BAR_MARGIN_TOP = 7;
    public int FUNCTION_BAR_MARGIN_BOTTOM = 7;

    public int STATUS_BAR_LABEL_WIDTH = CONTENT_PANE_WIDTH;
    public int STATUS_BAR_LABEL_HEIGHT = STATUS_BAR_HEIGHT;

//	public Color TITLE_COLOR = new Color(100, 100, 100);
//	public Color STATUS_BORDER = new Color(255, 239, 222);
//	public Color FIND_MODE_BACKGROUND_COLOR = new Color(0, 127, 0);
//	public Color BARS_BACKGROUND_COLOR = new Color(255, 204, 153);
//	public Color BUTTONS_BACKGROUND_COLOR = new Color(255, 223, 191);

    public Color BUTTONS_BACKGROUND_COLOR = new Color(204, 204, 204);

    public int TAB_HEADER_HEIGHT = 27;

    public Insets TEXTFIELD_INSETS = new Insets(0, 3, 0, 0);



    public Color TITLE_COLOR = new Color(255, 255, 255);
    public Color EDIT_MODE_BG_COLOR = new Color(218, 150, 17);
    public Color GROUP_BOX_BG_COLOR = new Color(230, 230, 205);
    public Color TITLE_BG_COLOR = new Color(99, 132, 189);
    public Color MAIN_BG_COLOR = new Color(222, 222, 198);
    public Color ACTION_COLOR = new Color(198, 198, 171);

    public Color TAB_BG_COLOR = MAIN_BG_COLOR;
    public Color TAB_BG_NOSELECTED_COLOR = new Color(198, 198, 181);
    public Color TAB_FOCUS_INDICATOR_COLOR = new Color(153, 153, 204);
    public Color TAB_TOP_COLOR = new Color(255, 255, 255);
    public Color TAB_TOP_HIGHLIGHT_COLOR = new Color(222, 222, 200);
    public Color TAB_BOTTOM1_COLOR = new Color(190, 190, 171);
    public Color TAB_BOTTOM2_COLOR = TAB_TOP_COLOR;
    public Color TAB_RIGHT_COLOR = new Color(141, 141, 128);
    public Color TAB_RIGHT1_COLOR = TAB_TOP_HIGHLIGHT_COLOR;
    public Color TAB_RIGHT2_COLOR = new Color(205, 205, 190);
    public Color TAB_RIGHT3_COLOR = new Color(153, 153, 137);
    public Color TAB_RIGHT_SHADOW1_COLOR = new Color(170, 170, 156);
    public Color TAB_RIGHT_SHADOW2_COLOR = TAB_RIGHT3_COLOR;

    public Color BUTTON_BORDER_COLOR = new Color(141, 141, 128);
    public Color[] BUTTON_COLORS = {	new Color(253, 253, 243),
                                        new Color(245, 244, 231),
                                        new Color(235, 234, 216),
                                        new Color(226, 225, 208),
                                        new Color(222, 222, 200),
                                        new Color(214, 214, 195),
                                        new Color(205, 205, 190),
                                        new Color(198, 198, 183)	};

}
