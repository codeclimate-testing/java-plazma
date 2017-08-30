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
 * Created on 02.07.2003
 *
 */
package org.plazmaforge.framework.client.swing;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swing.app.SwingApplication;





 /**
  * GUIApplication environment
  * 
  * @author Oleh Hapon
  *
  * $Id: SwingEnvironment.java,v 1.3 2010/04/28 06:36:12 ohapon Exp $
  * 
  */

public class SwingEnvironment {

    public static final String IMAGE_KEY = "images";
    public static final String LABEL_KEY = "labels";


    protected static SwingApplication application;
    protected static JFrame frame;
    protected static JMenuBar menuBar;
    protected static JToolBar toolBar;
    protected static JComponent statusBar;
    protected static JDesktopPane desktopPane;


     public static SwingApplication getApplication() {
         return application;
     }

     public static void setApplication(SwingApplication application) {
         SwingEnvironment.application = application;
     }

     public static JFrame getFrame() {
         return frame;
     }

     public static void setFrame(JFrame frame) {
         SwingEnvironment.frame = frame;
     }

     public static JMenuBar getMenuBar() {
         return menuBar;
     }

     public static void setMenuBar(JMenuBar menuBar) {
         SwingEnvironment.menuBar = menuBar;
     }

     public static JToolBar getToolBar() {
         return toolBar;
     }

     public static void setToolBar(JToolBar toolBar) {
         SwingEnvironment.toolBar = toolBar;
     }

     public static JComponent getStatusBar() {
         return statusBar;
     }

     public static void setStatusBar(JComponent statusBar) {
         SwingEnvironment.statusBar = statusBar;
     }

     public static JDesktopPane getDesktopPane() {
         return desktopPane;
     }


     public static void setDesktopPane(JDesktopPane desktopPane) {
         SwingEnvironment.desktopPane = desktopPane;
     }




     public static void exit() {
         SwingEnvironment.application.exit();
     }
     
     public static ImageIcon createImageIcon(String file) {
         return new ImageIcon(file);
     }

     public static ImageIcon getImageIcon(String key) {
         String file = AppEnvironment.getProperty(IMAGE_KEY + "." + key);
         if (file == null) return null;
         file = AppEnvironment.getProperty("images-path") + System.getProperty("file.separator") + file;
         return createImageIcon(file);
     }

}
