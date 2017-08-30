
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
 * Created on 03.01.2007
 *
 */

package org.plazmaforge.framework.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.core.exception.ApplicationException;


public abstract class AbstractApplication implements IApplication {
    
    protected final static Logger logger = Logger.getLogger(AbstractApplication.class);
    
    private boolean isInitApplication;
    
    private PrintStream err;
    
    private PrintStream out;
    
    private AppConfigurer appConfigurer;
        
    
    public IAppManager getAppManager() {
        return getAppConfigurer().getAppManager();
    }

    /**
     * Load the Application
     */
    public void load() throws ApplicationException {
        
        loadConfiguration();
        
        initLookAndFeel();
        
        Properties properties = getProperties();
        String appName = properties.getProperty("application-name");
        if (appName != null) {
            setTitle(appName);
        }
        
        ConfigurerManager configurerManager = ConfigurerManager.getInstance();
        
        if (getAppManager() != null) {
            getAppManager().onStartProcess();
            getAppManager().loadSystemConfiguration();
        }
    }
    

    
    
    protected void initLookAndFeel() {
        
    }

    /**
     * Load properties from file
     * @throws ApplicationException
     */
    protected void loadConfiguration() throws ApplicationException {
	getAppConfigurer().loadConfiguration();
    }
    
    protected void loadArguments(String[] args) {
        
        if (args.length == 0) {
            return;
        }

        int i = 0;
        while(i < args.length) {
            if ("-ec".equals(args[i])) {
                i++;
                if (i >= args.length) break;
                if ("true".equals(args[i])) {
                    AppEnvironment.setExternalConfigFile(true);
                }
            } else if ("-edc".equals(args[i])) {
                i++;
                if (i >= args.length) break;
                if ("true".equals(args[i])) {
                    AppEnvironment.setExternalDatabaseConfigFile(true);
                }
            } else if ("-demo".equals(args[i])) {
                    AppEnvironment.setDemo(true);
            } else if ("-nodemo".equals(args[i])) {
                    AppEnvironment.setDemo(false);
            } else if ("-autologin".equals(args[i])) {
                    AppEnvironment.setAutoLogin(true);
            } else if ("-noautologin".equals(args[i])) {
                    AppEnvironment.setAutoLogin(false);
            }
            i++;
        }

    }
    
    
    /**
     * Initialize the Application
     */
    public void init() throws ApplicationException {
        if (isInitApplication) {
            return;
        }
        isInitApplication = true;
        initComponents();
        initKeys();
    }
    
    /**
     * Initialize components of the application
     * @throws ApplicationException
     */
    protected void initComponents() throws ApplicationException {
        
    }
    
    protected void initKeys() {
        
    }    
    
    protected void initEnvironment() {
          
    }
    
    public void run() throws ApplicationException {
	
    }
    
    protected void createFrame() {
        
    }
    
    public void exit() {
        
        // Manager exit
        if (getAppManager() != null) {
            getAppManager().exit();
        }
        
        // Close log files
        closeLog();
        
        // System exit
        systemExit();
       
    }
   
   protected void systemExit() {
       System.exit(0);
   }
    
    public void executeAction(String actionIdentificator) throws ApplicationException {
	
    }

    protected void createLog() {
        try {
            String logsDir = AppEnvironment.getLogsDir();
            File folder = new File(logsDir);
  
            if (!folder.exists()) {
        	folder.mkdir();
            }
            String prefix = logsDir + "/";
            out = new PrintStream(new FileOutputStream(prefix + AppEnvironment.STD_OUT));
            err = new PrintStream(new FileOutputStream(prefix + AppEnvironment.STD_ERR));
            System.setOut(out);
            System.setErr(err);
            
            printConfigurationEnvironment();
        } catch (Exception ex) {
            logError(ex);
        }
    }
    
    protected void closeLog() {
        try {
            if (out != null) {
                out.flush();
                out.close();
            }
            if (err != null) {
                err.flush();
                err.close();
            }
        } catch (Exception ex) {
            logError(ex);
        }
    }
    
    protected void printConfigurationEnvironment() {
        logInfo("");
        logInfo("Configuration environment:");
        logInfo("------------------------------------------------------------------------------");
        logInfo("ROOT_DIR = [" + AppEnvironment.getRootDir() + "]");
        logInfo("CONF_NAME = [" + AppEnvironment.getConfName() + "]");
        //logInfo("CONF_PREFIX = [" + AppEnvironment.getConfPrefix() + "]");
        logInfo("LOGS_DIR = [" + AppEnvironment.getLogsDir() + "]");        
    }  
    
    
    public void startup(String[] args) {
        try {
            
            // Initialize Application Environemnt
            AppEnvironment.init();
            
            // Create log
            createLog();

            // Load arguments and set environment attribute
            loadArguments(args);
            
            // Create main frame
            createFrame();          
            
            // Load configuration, app manager and etc.
            load();
            
            // Initialize application components
            init();
            
            // Initialize environment
            initEnvironment();   
            
            // Run application
            run();
 
        } catch (Throwable th) {
            try {
                logError(th);
                errorMessage(th.toString() 
                        + "\n\nFor more information on error, see log files: "
                        + "\n" + AppEnvironment.getLogsDirName() + "/plazma.log"
                        + "\n" + AppEnvironment.getLogsDirName() + "/" + AppEnvironment.STD_ERR
                        + "\n" + AppEnvironment.getLogsDirName() + "/" + AppEnvironment.STD_OUT);
                exit();
            } catch (Throwable tha) {
        	logError(tha);
                System.exit(0);
            }
             
        }
    }
        
   
    protected abstract void errorMessage(Throwable th);

  
    protected abstract void errorMessage(String message);
    

    protected Properties getProperties() {
        return AppEnvironment.getProperties();
    }
    

    /**
     * Get property
     * 
     * @param key
     * @return
     */
    protected String getProperty(String key) {
        return AppEnvironment.getProperty(key);
    }

    public AppConfigurer getAppConfigurer() {
	if (appConfigurer == null) {
	    appConfigurer = new AppConfigurer(AppConfigurer.createCurrenctConfiguration());
	}
        return appConfigurer;
    }
    
    protected void logError(Throwable th) {
	logger.error("Application Error", th); 
    }   
    
    protected void logInfo(Object message) {
	if (message == null) {
	    return;
	}
	logger.info(message);
	System.out.println(message); // TODO: Stub. Must use logger
    }
    
    
    
}
