package org.plazmaforge.bsolution.base.client.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.bsolution.base.client.swt.dialogs.ConfigPanel;
import org.plazmaforge.framework.app.AppConfigurer;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swt.SWTUtils;

public class ConfigApplication {

    private Display display = new Display();
    private Shell shell = new Shell(display);


    private static String rootDir;
    private static String confDir;
    private static String filePrefix;
    
    public ConfigApplication() {
	super();
    }
    
    public void startup() {
	shell.setText("Config Manager");
	shell.setLayout(new FillLayout());

	ConfigPanel panel = new ConfigPanel(shell, SWT.NONE);
	panel.init();
	
	shell.setSize(640, 480);
	SWTUtils.centerWindow(shell);
	shell.open();

	while (!shell.isDisposed()) {
	    if (panel.isExit()) {
		break;
	    }
	    if (!display.readAndDispatch()) {
	        display.sleep();
	    }
	}

	display.dispose();
	
    }

    public static String getFilePrefix() {
	if (filePrefix == null || filePrefix.trim().length() == 0) {
	    return "";
	}
        return filePrefix;
    }

    public static void setFilePrefix(String filePrefix) {
        ConfigApplication.filePrefix = filePrefix;
    }

    public static String getRootDir() {
	if (rootDir == null) {
	    return getUserDir();
	}
        return rootDir;
    }

    public static void setRootDir(String rootDir) {
        ConfigApplication.rootDir = rootDir;
    }

   
    public static String getConfDir() {
	if (confDir == null) {
	    return getUserDir();
	}
        return confDir;
    }

    public static void setConfDir(String confDir) {
        ConfigApplication.confDir = confDir;
    }

    public static String getUserDir() {
	return System.getProperty("user.dir");
    }
    
    public static void main(String[] args) {
	if (args.length > 1) {
	    String a0 = args[0];
	    String a1 = args[1];
	    if ("-fileprefix".equals(a0)) {
		ConfigApplication.setFilePrefix(a1);
	    }
	    
	}
	AppEnvironment.init();
	ConfigApplication.setRootDir(AppEnvironment.getRootDir());
	ConfigApplication.setConfDir(AppEnvironment.getConfigurationDir() + "/conf");
	
	initLocale();
	
	ConfigApplication application = new ConfigApplication();
	application.startup();
    }

    
    private static void initLocale() {
	try {
	    String fileName = AppEnvironment.getRootConfigFileName(AppEnvironment.getApplicationConfigFile());
	    AppConfigurer.loadProperties(fileName);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
