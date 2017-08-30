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

package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

public interface Constants {

    byte ORIENTATION_PORTRAINT = 1;
    
    byte ORIENTATION_LANDSCAPE = 2;
    
    byte MODE_OPAQUE = 1;
    
    byte MODE_TRANSPARENT = 2;
    
    
    // ALIGNMENT
    byte HORIZONTAL_ALIGN_LEFT = 1;
    byte HORIZONTAL_ALIGN_CENTER = 2;
    byte HORIZONTAL_ALIGN_RIGHT = 3;
    byte HORIZONTAL_ALIGN_JUSTIFIED = 4;

    byte VERTICAL_ALIGN_TOP = 1;
    byte VERTICAL_ALIGN_MIDDLE = 2;
    byte VERTICAL_ALIGN_BOTTOM = 3;
    byte VERTICAL_ALIGN_JUSTIFIED = 4;
    //
    
    

    // TEXT
    byte ROTATION_NONE = 0;

    byte ROTATION_LEFT = 1;

    byte ROTATION_RIGHT = 2;
    
    byte ROTATION_UPSIDE_DOWN = 3;


    // PRINT TEXT
    byte RUN_DIRECTION_LTR = 0;
    byte RUN_DIRECTION_RTL = 1;

}
