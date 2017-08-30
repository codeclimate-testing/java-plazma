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

package org.plazmaforge.framework.client.swing.actions;

/**
 * @author Oleh Hapon Date: 24.01.2004 Time: 8:55:22 $Id: Command.java,v 1.2 2010/04/28 06:36:11 ohapon Exp $
 */
public interface Command {

    String HELP_COMMAND = "HELP";

    String EXIT_COMMAND = "EXIT";

    String NEW_COMMAND = "NEW";

    String SAVE_COMMAND = "SAVE";

    String SAVE_ALL_COMMAND = "SAVE_ALL";

    String CLOSE_COMMAND = "CLOSE";

    String CLOSE_ALL_COMMAND = "CLOSE_ALL";

    String OPEN_COMMAND = "OPEN";

    String FIND_COMMAND = "FIND";

    String REPLACE_COMMAND = "REPLACE";

    String PRINT_COMMAND = "PRINT";

    String DELETE_COMMAND = "DELETE";

    String PROPERTIES_COMMAND = "PROPERTIES";

    // void setDataTransfer(DataTransfer t);

    // DataTransfer getDataTransfer();

    void execute();
}
