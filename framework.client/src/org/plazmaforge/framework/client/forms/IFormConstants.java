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

package org.plazmaforge.framework.client.forms;

/** 
 * @author Oleh Hapon
 *
 */

public interface IFormConstants {
    
  
    /**
     * Help action. Press F1 key.
     */
    String HELP_ACTION = "HELP";
    
    /**
     * Ok action. Default Ok action is Save action
     */
    String OK_ACTION = "OK";
    
    /**
     * Save action. Save data to source and close form.
     */
    String SAVE_ACTION = "SAVE";
    
    /**
     * Cancel action. Close form.
     */
    String CANCEL_ACTION = "CANCEL";
    
    /**
     * Exit action. Default the action is close from.
     */
    String EXIT_ACTION = "EXIT";
    
    /**
     * Enter action. Press ENTER key or double mouse click.
     */
    String ENTER_ACTION  = "ENTER";
    
    /**
     * Refresh action. Reload data from source to form.
     */
    String REFRESH_ACTION = "REFRESH";
    
    /**
     * Choose action. Press ENTER key or double mouse click in CHOOSE_MODE 
     */
    String CHOOSE_ACTION = "CHOOSE";
    
    
    String ADD_ACTION = "ADD";
    
    String COPY_ACTION = "COPY";
    
    String DEL_ACTION = "DEL";
    
    String EDIT_ACTION = "EDIT";
    
    String VIEW_ACTION = "VIEW";
    
    String ADD_CYCLE_ACTION = "ADD_CYCLE";
    
    String PRINT_ACTION = "PRINT";
    
    String SORT_ACTION = "SORT";

    String FIND_ACTION = "FIND";
    
    
    String TREE_ADD_ACTION  = "TREE_ADD";
    
    String TREE_DEL_ACTION  = "TREE_DEL";
    
    String TREE_EDIT_ACTION  = "TREE_EDIT";
    
    String TREE_ENTER_ACTION  = "TREE_ENTER";    
    
    
    String FILTER_ACTION = "FILTER";
    
    String INTERNAL_FILTER_ACTION = "INTERNAL_FILTER";
    
    String FAST_FILTER_ACTION = "FAST_FILTER";
    
    String ADVANCED_FILTER_ACTION = "ADVANCED_FILTER";
    
    String CLEAR_FILTER_ACTION = "CLEAR_FILTER";
    
    String PERIOD_FILTER_ACTION = "PERIOD_FILTER";
    
    String EXPORT_ACTION = "EXPORT";
    
    
    
    String SETUP_ACTION = "SETUP";
    
    
    String ITEM_ADD_ACTION = "ITEM_ADD";
    
    String ITEM_DEL_ACTION = "ITEM_DEL";
    
    String ITEM_EDIT_ACTION = "ITEM_EDIT";
    
    
    
    String INFO_ACTION = "INFO";
    
    String RESET_ACTION = "RESET";
    
    String CLEAR_ACTION = "CLEAR";
    
    
    String ADD_BY_COPY_ACTION = "ADD_BY_COPY"; // Add new object by copy selected object
    
    String ADD_BY_OBJECT_ACTION = "ADD_BY_OBJECT"; // Add new object by other object
    
    String ADD_OTHER_OBJECTS_ACTION = "ADD_OTHER_OBJECTS"; // Add new objects to other storage by selected object 
    
    // Validation constants
    
    int REQUIRED = 1;
    
    
    
    String FIRST_PAGE_ACTION = "FIRST_PAGE";
    
    String PREV_PAGE_ACTION = "PREV_PAGE";
    
    String NEXT_PAGE_ACTION = "NEXT_PAGE";
    
    String LAST_PAGE_ACTION = "LAST_PAGE";
    
    
}
