package org.plazmaforge.bsolution.base.web;

import org.plazmaforge.framework.app.AppConfigurer;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.config.ConfigurerManager;

public class WEBApplicationLoader {

    
    

    /**
     * Load Plazma application environment
     *
     */
    public void load(Object args) {
	try {

	    
	    String rootDir = System.getProperty("user.dir");
	    

	    // ONLY FOR TEST !!! Set stub root directory
	    //System.setProperty(AppEnvironment.ROOT_DIR_PROPERTY, "D:\\Plazma\\bsolution.rich");
	    //System.setProperty(AppEnvironment.ROOT_DIR_PROPERTY, "D:\\Plazma\\bs.standart.richclient.swt");


	    AppEnvironment.init();

	    // Set external config file mode
	    AppEnvironment.setExternalConfigFile(true);

	    
	    // CLIENT INIT
	    // ...
	    //

	    // Load application configuration
	    AppConfigurer configurer = new AppConfigurer();

	    configurer.loadConfiguration();

	    ConfigurerManager configurerManager = ConfigurerManager.getInstance();
	    configurer.setAppManager(new WEBApplicationManager());

	    if (configurer.getAppManager() != null) {
		configurer.getAppManager().onStartProcess();
		configurer.getAppManager().loadSystemConfiguration();
		configurer.getAppManager().initComponents();
	    }

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

}
