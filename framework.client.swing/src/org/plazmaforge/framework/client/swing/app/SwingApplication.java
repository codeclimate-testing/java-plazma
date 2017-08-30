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
 * Created on 13.08.2003
 *
 */

package org.plazmaforge.framework.client.swing.app;




import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.plazmaforge.framework.app.AbstractApplication;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swing.SwingEnvironment;
import org.plazmaforge.framework.client.swing.app.SwingAppBuilder;
import org.plazmaforge.framework.client.swing.gui.FrameStatusBar;
import org.plazmaforge.framework.client.swing.gui.plaf.AllBluesBoldMetalTheme;
import org.plazmaforge.framework.client.swing.message.Message;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemInfo;



/**
 * @author Oleh Hapon
 * 
 * $Id: SwingApplication.java,v 1.4 2010/12/05 07:52:09 ohapon Exp $
 */

public class SwingApplication  extends AbstractApplication /*implements ActionListener*/ {

	
    private final int DEFAULT_WIDTH = 640;
    
    private final int DEFAULT_HEIGHT = 480;
    
  
    
    protected SwingAppBuilder appBuilder;
    


	
	

    public SwingApplication() {
		//Stub
    }


	/**
	 * Create main frame
	 *
	 */
	protected void createFrame() {
    	
    	// Create Main Frame
        JFrame frame = new JFrame();
        SwingEnvironment.setFrame(frame);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowListener()  {

            public void windowOpened(WindowEvent e) {
                frameOpened(e);

            }
            public void windowClosing(WindowEvent e) {
                frameClosing(e);
            }
            public void windowClosed(WindowEvent e) {
                frameClosed(e);

            }
            public void windowIconified(WindowEvent e) {
                frameIconified(e);
            }
            public void windowDeiconified(WindowEvent e) {
                frameDeiconified(e);
            }
            public void windowActivated(WindowEvent e) {
                frameActivated(e);
            }
            public void windowDeactivated(WindowEvent e) {
                frameDeactivated(e);
            }

        });
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    	
        appBuilder = new SwingAppBuilder(this);
		
	}
	
    protected void frameOpened(WindowEvent e) {

    }
    
    protected void frameClosing(WindowEvent e) {
        exit();
    }
    
    protected void frameClosed(WindowEvent e) {

    }
    
    protected void frameIconified(WindowEvent e) {

    }
    
    protected void frameDeiconified(WindowEvent e) {

    }
    
    protected void frameActivated(WindowEvent e) {

    }
    
    protected void frameDeactivated(WindowEvent e) {

    }
    
 
	
    
    /**
     * Initialize components
     * 
     * - Menu Bar
     * - Tool Bar
     * - Status Bar
     * - Desktop
     */
    protected void initComponents() throws ApplicationException {
        
        JMenuBar menuBar = createMenuBar();
        JToolBar toolBar = createToolBar();
        JComponent statusBar = createStatusBar();
        JDesktopPane desktop = new JDesktopPane();

        SwingEnvironment.setMenuBar(menuBar);
        SwingEnvironment.setToolBar(toolBar);
        SwingEnvironment.setStatusBar(statusBar);
        SwingEnvironment.setDesktopPane(desktop);

        Container c = SwingEnvironment.getFrame().getContentPane();
        c.setLayout(new BorderLayout());

        if (menuBar != null) {
            SwingEnvironment.getFrame().setJMenuBar(menuBar);
        }
        if (toolBar != null) {
            c.add(toolBar, BorderLayout.NORTH);
        }
        if (statusBar != null) {
            c.add(statusBar, BorderLayout.SOUTH);
        }
        if (desktop != null) {
            c.add(desktop, BorderLayout.CENTER);
        }

        if (getAppManager() != null) getAppManager().initComponents();
        

    }


   /**
     * Get LookAndFeel class name from properties
     * 
     * @return
     */
    protected String getLookAndFeelClassNameProperty() {
	String key = "look-and-feel-class";

	// Get platform LookAndFeel
	String klass = getProperty(SystemInfo.getPlatform() + "-" + key);

	if (StringUtils.isEmpty(klass)) {
	    // Get cross platform LookAndFeel
	    klass = getProperty("cross-" + key);
	}

	if (StringUtils.isEmpty(klass)) {
	    // Get LookAndFeel
	    klass = getProperty(key);
	}

	return klass;
    }

    protected String getLookAndFeelNameProperty() {
	return getProperty("look-and-feel-name");
    }

    protected void initLookAndFeel() {

	String className = null;
	String name = null;

	try {

	    // Fixed MetalLookAndFeel
	    MetalLookAndFeel.setCurrentTheme(new AllBluesBoldMetalTheme());
	    // klass =
                // StringUtilities.getStringNull(GUIAppContext.LOOK_AND_FEEL_CLASS);
	    className = getLookAndFeelClassNameProperty();
	    name = getLookAndFeelNameProperty();

	    if (className == null && name != null) {
		UIManager.LookAndFeelInfo[] ar = UIManager
			.getInstalledLookAndFeels();
		if (ar != null) {
		    for (int i = 0; i < ar.length; i++) {
			if (ar[i].getName().equals(name)) {
			    className = ar[i].getClassName();
			}
		    }
		}

	    }

	    className = getCorrectLookAndFeelClassName(className);

	    setLookAndFeel(className);

	} catch (UnsupportedLookAndFeelException e) {
	    e.printStackTrace();
	    doSetSystemLookAndFeel();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    doSetSystemLookAndFeel();
	}
    }

    protected String getCorrectLookAndFeelClassName(String className) {
	if (StringUtils.isEmpty(className)) {
	    return UIManager.getSystemLookAndFeelClassName();
	}
	return className;
    }

    protected void doSetSystemLookAndFeel() {
	try {
	    setSystemLookAndFeel();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    protected void setSystemLookAndFeel() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    protected void setLookAndFeel(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	UIManager.setLookAndFeel(className);
    }
 

    
    /**
         * Create MenuBar
         */
    protected JMenuBar createMenuBar() {
        return appBuilder.createMenuBar();
    }

    /**
         * Create ToolBar
         */
    protected JToolBar createToolBar() {
       	JToolBar toolbar = appBuilder.createToolBar();
        toolbar.setFloatable(false);
        return toolbar;
    }


   


    /*
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (StringUtilities.isEmpty(action)) {
			return;
        }
        try {
            AppActionManager.execute(action);
        } catch (ApplicationException ex) {
            ex.printStackTrace();
        }
    }
    */

    public static void main(String[] args) {
    	SwingApplication app = null;
        //Initialize application environment
        AppEnvironment.init();
        
        // Create new application
        app = createApplication();
        app.startup(args);
        
    }
	
 
 
    
    protected void errorMessage(Throwable th) {
        Message.systemError(SwingEnvironment.getFrame(), th.toString());
    }
  
    protected void errorMessage(String message) {
        Message.systemError(SwingEnvironment.getFrame(), message);
    }
    
    
    protected static SwingApplication createApplication() {
    	return new SwingApplication(); 
    }
     
    
    protected void initEnvironment() {
        SwingEnvironment.setApplication(this);    	
    }

    
    protected JComponent createStatusBar() {
        FrameStatusBar statusBar = new FrameStatusBar();
        return statusBar;
    }

    protected JDesktopPane createDesktopPane() {
        JDesktopPane d = new JDesktopPane();
        d.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        return d;
    }

    public void run() {
       //GUIAppContext.getFrame().setLocationRelativeTo(null);
       SwingEnvironment.getFrame().show();
       SwingEnvironment.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void setTitle(String title) {
        JFrame frame = SwingEnvironment.getFrame();
        if (frame == null) {
            return;
        }
        frame.setTitle(title);
    }

    public String getTitle() {
        JFrame frame = SwingEnvironment.getFrame();
        if (frame == null) {
            return null;
        }
        return frame.getTitle();
    }
    
}
