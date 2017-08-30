/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs;


import java.util.List;
import java.util.Properties;

import org.plazmaforge.framework.config.AppConfiguration;
import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.ConfigurerContributor;
import org.plazmaforge.framework.config.ConfigurerContributor.CommandResolver;
import org.plazmaforge.framework.config.configurer.ConfigurerInfo;
import org.plazmaforge.framework.config.configurer.SystemConfigurer;
import org.plazmaforge.framework.config.object.InterfaceConfig;
import org.plazmaforge.framework.core.command.CommandExecutor;
import org.plazmaforge.framework.core.command.CommandParser;
import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.data.ClassPropertyProviderFactory;
import org.plazmaforge.framework.core.data.Customizer;
import org.plazmaforge.framework.core.data.object.Creator;
import org.plazmaforge.framework.core.data.object.IData;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.logging.Log4JHandler;
import org.plazmaforge.framework.core.logging.LogManager;
import org.plazmaforge.framework.core.resource.BundleResourceProvider;
import org.plazmaforge.framework.core.resource.ResourceProvider;
import org.plazmaforge.framework.ext.service.ServiceLocator;
import org.plazmaforge.framework.util.ClassUtils;
import org.plazmaforge.framework.util.FileUtils;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.ApplicationContext;
import org.plazmaforge.framework.uwt.UIResourceException;
import org.plazmaforge.framework.uwt.UWT;
import org.plazmaforge.framework.uwt.form.DesktopFormProvider;
import org.plazmaforge.framework.uwt.form.FormManager;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.storage.ClassTemplateProvider;
import org.plazmaforge.framework.uwt.storage.TemplateProvider;
import org.plazmaforge.framework.uwt.storage.TemplateProviderAsync;
import org.plazmaforge.framework.uwt.widget.CallbackResult;
import org.plazmaforge.framework.uwt.widget.Frame;


/**
 * @author ohapon
 *
 */
public class DesktopApplicationInitializer extends ClientApplicationInitializer  {

    public static final int DEFAULT_WINDOW_WIDTH = 640;
    public static final int DEFAULT_WINDOW_HEIGHT = 480;

    private ApplicationBuilder applicationBuilder;
    
    @Override
    public void initialize(Object object, Callback<Object> callback) {
	initializeApplication((Application) object, callback);
	callback.onSuccess(Application.METHOD_PRESTART);
    }

    private void initializeApplication(Application application, Callback<Object> callback) {

	String locale = "en";
	
	//DISABLE
	LogManager.getRootLogger().addHandler(new Log4JHandler());
	
	// i18n provider
	ResourceProvider resourceProvider = new BundleResourceProvider();
	UWT.setResourceProvider(resourceProvider, locale);

	final ApplicationContext applicationContext = application.getApplicationContext(); 
	
	applicationContext.setProperty(ApplicationContext.CONFIG_LOCALE, locale);
	applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_DATE, "dd-MM-yyyy");
	applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_DATE_TIME, "dd-MM-yyyy HH:mm:ss");
	applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_TIME, "HH:mm:ss");

	// Only for Desktop application
	applicationContext.setProperty("imageStorage",	"org/plazmaforge/framework/uwt/resources/images"); // UWT BASE
	applicationContext.setProperty("imageStorage/action", "org/plazmaforge/bs/resources/images/action"); // BS ACTION
	applicationContext.setProperty("imageStorage/window", "org/plazmaforge/bs/resources/images/window"); // BS WINDOW (?)
	applicationContext.setProperty("imageStorage/form", "org/plazmaforge/framework/uwt/resources/images/form"); // UWT FORM

	applicationContext.setAttribute(ApplicationContext.CONFIG_PROPERTY_PROVIDER_FACTORY, new ClassPropertyProviderFactory());
	applicationContext.setAttribute(ApplicationContext.CONFIG_SERVICE_CALLER, new DesktopApplicationServiceCaller());
	applicationContext.setAttribute(ApplicationContext.CONFIG_RESOURCE_PROVIDER, resourceProvider);

	applicationContext.setAttribute(ApplicationContext.CONFIG_TEMPLATE_PROVIDER_ASYNC, new DesktopApplicationTemplateProviderAsync());

	//// APPLICATION CONTEXT ////
	
	TypeResolver typeResolver = new TypeResolver();
	typeResolver.setBasePackage("org.plazmaforge.bs");
	typeResolver.registerTypePackage("Entity", "shared.entities", false);
	typeResolver.registerTypePackage("ListForm", "client.forms");
	typeResolver.registerTypePackage("EditForm", "client.forms");
	typeResolver.registerTypePackage("Form", "client.forms");
	typeResolver.registerTypePackage("Service", "shared.services");
	applicationContext.setAttribute("type.resolver", typeResolver);
	
	CommandParser commandParser = new ApplicationCommandParser();
	application.getApplicationContext().setAttribute("command.parser", commandParser);

	CommandExecutor commandExecutor = new ApplicationCommandExecutor(typeResolver);
	application.getApplicationContext().setAttribute("command.executor", commandExecutor);

	CommandResolver commandResolver = new ApplicationCommandResolver();
	application.getApplicationContext().setAttribute("command.resolver", commandResolver);	

	Creator entityCreator = new DesktopApplicationEntityCreator();
	application.getApplicationContext().setAttribute("entity.creator", entityCreator);
	
	Customizer formCustomizer = new ApplicationFormCustomizer(typeResolver, entityCreator);
	application.getApplicationContext().setAttribute("form.customizer", formCustomizer);
	
	FormManager.setFormCreator(new DesktopApplicationFormCreator(formCustomizer));
	FormManager.setFormProvider(new DesktopFormProvider(application));

	
	////
	
	loadApplication(application, callback);
    }
    
    @Override
    protected void configureFrame(Application application) {
	Frame frame = application.getFrame();
	
	// Initialize window size
	frame.setWidth(DEFAULT_WINDOW_HEIGHT);
	frame.setHeight(DEFAULT_WINDOW_HEIGHT);
	
	frame.setTitle(UWT.getUIType() + ": Plazma Application v1.0.3");
	frame.setIcon("action::coins.png");
	
	frame.setLayout(new FitLayout());
	populateFrame(frame);
	
	//frame.center();
	frame.maximize();
	frame.setVisible(true);
    }

    
    protected ApplicationBuilder getApplicationBuilder() {
	return applicationBuilder;
    }

    protected void loadApplicationContext(Application application, Callback<CallbackResult> callback) {
	try {
	    
	    // Get root configuration directory
	    String configurationDir = application.getApplicationContext().getProperty(AppConfiguration.PROPERTY_ROOT_DIR);
	    if (StringUtils.isEmpty(configurationDir)) {
		logError("Can't load configuration. Configuration directory is not setting. Application property '" + AppConfiguration.PROPERTY_ROOT_DIR + "' is empty.");
		//TODO: EXIT
		return;
	    }
	    
	    log("Start load application configuration");
	    
	    String systemContext = "standalone";
	    
	    AppConfiguration configuration = new AppConfiguration();
	    
	    Properties initProperties = new Properties();
	    initProperties.put(AppConfiguration.PROPERTY_ROOT_DIR, configurationDir);
	    //initProperties.put(AppConfiguration.PROPERTY_UI_CONTEXT, "ui");
	    configuration.init(initProperties);
	    
	    SystemConfigurer systemConfigurer = ConfigurerManager.getSystemConfigurer(configuration);
	    String systemConfigFileName = FileUtils.getPath(systemContext, configuration.getSystemConfigFile()) ; // Simple file name 'system-config.xml'
	    systemConfigFileName = configuration.getRootConfigFileName(systemConfigFileName); // Absolute file name
	    systemConfigurer.setAbsoluteConfigFileName(systemConfigFileName);

	    systemConfigurer.loadObjects();
	    ConfigurerManager configurerManager = ConfigurerManager.getInstance();
	    log("Application configuration is loaded");
	    
	    application.getApplicationContext().setAttribute("configurer.manager", configurerManager);
	    
	    // Get all configurers
	    List<ConfigurerInfo<?>> configurers = configurerManager.getConfigurersInfo();
	    
	    // Contribute configurers if need
	    ConfigurerContributor contributor = new ConfigurerContributor(configurers, new ApplicationCommandResolver()); 
	    contributor.contribute();
	    
	    // Add all configurers to context
	    application.getApplicationContext().setAttribute("configurer.manager.configurers", configurers);
	    
	    List<ConfigurerInfo<?>> list = ConfigurerInfo.cloneConfigurers(configurers, new String[] {"InterfaceConfigurer"}, null);
	    if (list != null && !list.isEmpty()) {
		ConfigurerInfo<InterfaceConfig> interfaceConfigurer = (ConfigurerInfo<InterfaceConfig>) list.get(0);
		List<InterfaceConfig> interfaces = interfaceConfigurer.getObjects();
		application.getApplicationContext().setAttribute(ATTRIBUTE_INTERFACES, interfaces);
	    }
	    
	    // TODO: Must load other context: Spring, ERM...
	    // TODO: Must get all organizations from DB
	    
	    loadServiceLocator(configuration, application);
	    
	    callback.onSuccess(new CallbackResult("OK"));
	} catch (Throwable e){
	    log("Load configuration error", e);
	    callback.onFailure(e);
	}
    }
    
    protected void loadServiceLocator(AppConfiguration configuration, Application application) throws ApplicationException {
	
	long time = System.currentTimeMillis();
	
	String serviceLocatorClass = configuration.getConfigurationProperty("plazma.platform.service.locator.class");
	if (serviceLocatorClass == null) {
	    logError("SERVICE_LOCATOR_CLASS is empty");
	    return;
	}
	log("SERVICE_LOCATOR_CLASS = [" + serviceLocatorClass + "]");
	ServiceLocator serviceLocator = (ServiceLocator) ClassUtils.newSafeInstance(serviceLocatorClass);
	if (serviceLocator == null) {
	    logError("Can't load SERVICE_LOCATOR_CLASS by class '" + serviceLocatorClass + "'");
	    return;
	}
	
	
	serviceLocator.setProperty("root.dir", configuration.getRootDir());
	serviceLocator.setProperty("root.config.dir", configuration.getRootConfigDir());
	serviceLocator.setTypeResolver((TypeResolver) application.getApplicationContext().getAttribute("type.resolver"));
	
	
	serviceLocator.init();
	
	log("Start time = [" + ((System.currentTimeMillis() - time) / 1000) + "]");
	
	application.getApplicationContext().setAttribute("service.locator", serviceLocator);
    }    
    
    protected void loadApplicationConfiguration(Application application, String ui, Callback<Object> callback) {
	if (ui == null) {
	    //logError("Can't load configuration: UI is null");
	    //return;
	    logWarn("UI is not setting");
	}
	
	ConfigurerManager configurerManager = (ConfigurerManager) application.getApplicationContext().getAttribute("configurer.manager");
	
	List<ConfigurerInfo<?>> configurers = configurerManager.getConfigurersInfo(ui);
	//List<ConfigurerInfo<?>> configurers = ConfigurerInfo.cloneConfigurers(configurers, CONFIGURER_NAMES, ui);

	CommandResolver commandResolver = (CommandResolver) application.getApplicationContext().getAttribute("command.resolver");
	ConfigurerContributor contributor = new ConfigurerContributor(configurers, commandResolver);
	contributor.contribute();
	
	applicationBuilder = new ApplicationBuilder(ui, configurers);
	
	configureFrame(application);

    }

    public class DesktopApplicationTemplateProviderAsync implements TemplateProviderAsync {

	    private final TemplateProvider templateProvider = new ClassTemplateProvider();
	    
	    @Override
	    public void getData(String path, Callback<IData> callback) {
		try {
		    IData data = templateProvider.getData(path);
		    callback.onSuccess(data);
		} catch (UIResourceException e) {
		    callback.onFailure(e);
		}
	    }

    }
    
       
}
