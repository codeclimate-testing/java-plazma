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
 * Created on 07.08.2003
 *
 */
package org.plazmaforge.framework.client.swing.app;



import java.awt.Dimension;
import java.util.List;
import java.util.Iterator;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import org.plazmaforge.framework.client.swing.forms.FormUtilities;
import org.plazmaforge.framework.client.swing.gui.GUIActionFactory;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.configurer.MenuBarConfigurer;
import org.plazmaforge.framework.config.configurer.ObjectConfigurer;
import org.plazmaforge.framework.config.configurer.ToolBarConfigurer;
import org.plazmaforge.framework.config.object.IMenuBarConfig;
import org.plazmaforge.framework.config.object.IMenuConfig;
import org.plazmaforge.framework.config.object.IMenuItemConfig;
import org.plazmaforge.framework.config.object.IMenuSeparatorConfig;
import org.plazmaforge.framework.config.object.IToolBarConfig;
import org.plazmaforge.framework.config.object.IToolItemConfig;
import org.plazmaforge.framework.util.StringUtils;



 /**
  * Builder of Swing Application. Create GUI components
  * 
  * - MenuBar
  * - ToolBar
  * 
  * @author Oleh Hapon
  * 
  * $Id: SwingAppBuilder.java,v 1.3 2010/04/28 06:36:13 ohapon Exp $ 
  */
public class SwingAppBuilder {

	 
     protected SwingApplication application;

     public SwingAppBuilder() {
     }

     public SwingAppBuilder(SwingApplication application) {
         this.application = application;
     }

    
     
     public JMenuBar createMenuBar() {
    	 
         List configObjects = getConfigurerObjects(MenuBarConfigurer.NAME);
         if (configObjects == null || configObjects.size() == 0) {
             return null;
         }
         JMenuBar menuBar = new JMenuBar();
         IMenuBarConfig menuBarConfig = (IMenuBarConfig) configObjects.get(0); 

         Iterator i = menuBarConfig.getChildren().iterator();
         IMenuConfig menuConfig = null;
         while (i.hasNext()) {
             menuConfig = (IMenuConfig) i.next();
             JMenu menu = new JMenu(new String(menuConfig.getText()));
             menuBar.add(menu);
             loadMenuChild(menu, menuConfig);
         }
         return menuBar;
         
     }
	 



     protected void loadMenuChild(JMenu menu, IMenuConfig menuConfig) {
	List list = menuConfig.getChildren();
	if (list == null)
	    return;
	Iterator i = list.iterator();
	IMenuItemConfig menuItemConfig = null;
	while (i.hasNext()) {
	    menuItemConfig = (IMenuItemConfig) i.next();
	    if (menuItemConfig instanceof IMenuConfig) {
		JMenu m = new JMenu(menuItemConfig.getText());
		menu.add(m);
		loadMenuChild(m, (IMenuConfig) menuItemConfig);
	    } else {
		if (menuItemConfig instanceof IMenuSeparatorConfig) {
		    menu.addSeparator();
		} else {
		    JMenuItem mi = createMenuItem(menuItemConfig);
		    if (mi != null) {
			menu.add(mi);
		    }
		}

	    }

	}
    }
     
     protected JMenuItem createMenuItem(IMenuItemConfig e) {
	Action action = getActionById(e.getAction());
	if (action == null) {
	    System.err.println("Action [" + e.getAction() + "] not found.");
	    return null;
	}
	JMenuItem mi = new JMenuItem(action);
	return mi;
    }     

     

     

     /**
      * Create Tool Bar
      * 
      * @return
      */
     public JToolBar createToolBar() {
	List configObjects = getConfigurerObjects(ToolBarConfigurer.NAME);
	if (configObjects == null || configObjects.size() == 0) {
	    return null;
	}
	JToolBar toolBar = FormUtilities.createToolBar();
	IToolBarConfig toolBarConfig = (IToolBarConfig) configObjects.get(0);
	Action action = null;
	Iterator i = toolBarConfig.getChildren().iterator();
	while (i.hasNext()) {
	    action = getActionById(((IToolItemConfig) i.next()).getAction());
	    if (action == null) {
		toolBar.add(new XSeparator(new Dimension(5, 20)));
	    } else {
		toolBar.add(action);
	    }
	}
	return toolBar;
    }
     
     protected Action getActionById(String actionId) {
		 return GUIActionFactory.getActionById(actionId);
     }
     
     protected ObjectConfigurer getConfigurer(String name) {
    	 return ConfigurerManager.getConfigurer(name);
     }
     
     protected List getConfigurerObjects(String name) {
    	 return getConfigurer(name).getObjects();
     }
     
     
     protected boolean isEmpty(String str) {
		 return StringUtils.isEmpty(str); 
     }


     class XSeparator extends JSeparator  {
         
           private Dimension separatorSize;

           public XSeparator() {
               this( null );
           }

           public XSeparator( Dimension size )   {
           super( JSeparator.VERTICAL);
               setSeparatorSize(size);
           }

           /*
           public String getUIClassID()  {
               return "ToolBarSeparatorUI";
           }
           */


           public void setSeparatorSize( Dimension size )  {
               if (size != null) {
                   separatorSize = size;
               } else {
                   super.updateUI();
               }
               this.invalidate();
           }

           public Dimension getSeparatorSize() {
               return separatorSize;
           }

           public Dimension getMinimumSize() {
               return getPreferredSize();
           }

           public Dimension getMaximumSize() {
               return getPreferredSize();
           }

           public Dimension getPreferredSize() {
              return separatorSize.getSize();
           }
     }



}
