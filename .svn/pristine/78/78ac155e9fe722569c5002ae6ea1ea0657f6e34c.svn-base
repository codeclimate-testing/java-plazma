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
package org.plazmaforge.bs.web.client;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bs.ApplicationBuilder;
import org.plazmaforge.bs.ApplicationCommandExecutor;
import org.plazmaforge.bs.ApplicationCommandParser;
import org.plazmaforge.bs.ApplicationFormCustomizer;
import org.plazmaforge.bs.ClientApplicationInitializer;
import org.plazmaforge.framework.config.configurer.ConfigurerInfo;
import org.plazmaforge.framework.config.object.InterfaceConfig;
import org.plazmaforge.framework.core.command.CommandExecutor;
import org.plazmaforge.framework.core.command.CommandParser;
import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.data.Customizer;
import org.plazmaforge.framework.core.data.object.Creator;
import org.plazmaforge.framework.core.data.object.IData;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.ApplicationContext;
import org.plazmaforge.framework.uwt.UWT;
import org.plazmaforge.framework.uwt.form.DesktopFormProvider;
import org.plazmaforge.framework.uwt.form.FormManager;
import org.plazmaforge.framework.uwt.storage.TemplateProviderAsync;
import org.plazmaforge.framework.uwt.widget.CallbackResult;
import org.plazmaforge.framework.uwt.widget.Frame;
import org.plazmaforge.framework.core.logging.Handler;
import org.plazmaforge.framework.core.logging.LogManager;
import org.plazmaforge.framework.core.logging.LogRecord;
import org.plazmaforge.framework.core.resource.CacheResourceProvider;
import org.plazmaforge.framework.core.resource.Resource;
import org.plazmaforge.framework.core.resource.ResourceProvider;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author ohapon
 *
 */
public class WebApplicationInitializer  extends ClientApplicationInitializer {

    // List of NLS resources
    private final String[] resourceNames = new String[] {
	    "org.plazmaforge.framework.uwt.resources.messages",
	    "org.plazmaforge.framework.uwt.demo.messages",
	    "org.plazmaforge.bs.base.client.forms.messages",
	    "org.plazmaforge.bs.contact.client.forms.messages",
	    "org.plazmaforge.bs.organization.client.forms.messages",
	    "org.plazmaforge.bs.partner.client.forms.messages",
	    "org.plazmaforge.bs.document.client.forms.messages",
	    "org.plazmaforge.bs.project.client.forms.messages"
	    }; 
    
    

    /**
     * Log Service
     */
    private final LogServiceAsync logService = GWT.create(LogService.class);

    
    /**
     * Resource Service (NLS)
     */
    private final ResourceServiceAsync resourceService = GWT.create(ResourceService.class);

    /**
     * Template Service (*.ui.xml)
     */
    private final TemplateServiceAsync templateService = GWT.create(TemplateService.class);

    /**
     * Application Configuration Service
     */
    private final ConfigurationServiceAsync configurationService = GWT.create(ConfigurationService.class);


    
    /**
     * Application Builder
     */
    private ApplicationBuilder applicationBuilder;
    
    /**
     * Root viewport
     */
    private Viewport viewport;
    
    
    public WebApplicationInitializer(Viewport viewport) {
	this.viewport = viewport;
    }

    @Override
    protected ApplicationBuilder getApplicationBuilder() {
	return applicationBuilder;
    }

    @Override
    public void initialize(Object object, Callback<Object> callback) {
	initializeApplication((Application) object, callback);
	//TODO: 
	// - Remove to real callback point
	// - Implement empty GXTApplicationAdapter
	//callback.onSuccess("OK");
    }

    public void initializeApplication(final Application application, final Callback<Object> callback) {
	
	// Add Log Handler
	LogManager.getRootLogger().addHandler(new WebLogHandler());
	
	
	final ApplicationContext applicationContext = application.getApplicationContext(); 
	final String locale = applicationContext.getProperty("locale");
	
        //applicationContext.addAttributes(UWT_GXT.getAttributes());
        //applicationContext.setProperty("locale", locale);
	
        applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_DATE, "dd-MM-yyyy");
        applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_DATE_TIME, "dd-MM-yyyy HH:mm:ss");
        applicationContext.setProperty(ApplicationContext.CONFIG_FORMAT_TIME, "HH:mm:ss");
        
        // Only for Web application
        applicationContext.setProperty("imageStorage", "resources/images");               // UWT BASE
        applicationContext.setProperty("imageStorage/action", "resources/images/action"); // BS ACTION
        applicationContext.setProperty("imageStorage/window", "resources/images/window"); // UWT WINDOW
        applicationContext.setProperty("imageStorage/form", "resources/images/form");     // UWT FORM
        
        applicationContext.setAttribute(ApplicationContext.CONFIG_SERVICE_CALLER, new WebApplicationServiceCaller());
        applicationContext.setAttribute(ApplicationContext.CONFIG_TEMPLATE_PROVIDER_ASYNC, new WebApplicationTemplateProvider());

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

	//CommandResolver commandResolver = new ApplicationCommandResolver();
	//application.getApplicationContext().setAttribute("command.resolver", commandResolver);
	
	Creator entityCreator = new WebApplicationEntityCreator();
	application.getApplicationContext().setAttribute("entity.creator", entityCreator);
	
	
	Customizer formCustomizer = new ApplicationFormCustomizer(typeResolver, entityCreator);
	application.getApplicationContext().setAttribute("form.customizer", formCustomizer);

	FormManager.setFormCreator(new WebApplicationFormCreator(formCustomizer));
	FormManager.setFormProvider(new DesktopFormProvider(application));

	////

	resourceService.getResources(resourceNames, locale, new AsyncCallback<List<Resource>>() {

		    @Override
		    public void onFailure(Throwable e) {
			log("Load resources error", e);
		    }

		    @Override
		    public void onSuccess(List<Resource> result) {

			// Create Frame
			Resource[] resources = result.toArray(new Resource[0]);
			ResourceProvider resourceProvider = new CacheResourceProvider(resources);
			UWT.setResourceProvider(resourceProvider, locale);

			applicationContext.setAttribute(ApplicationContext.CONFIG_RESOURCE_PROVIDER, resourceProvider);
			
			loadApplication(application, callback);
		    }

		});

    }
	
    
    protected void loadApplicationContext(final Application application, final Callback<CallbackResult> callback) {
	configurationService.getConfigurers(new String[] {"InterfaceConfigurer"}, null,	new AsyncCallback<List<ConfigurerInfo<?>>>() {

	    @Override
	    public void onFailure(Throwable e) {
		log("Load configuration error", e);
		callback.onFailure(e);
		return;
	    }

	    @Override
	    public void onSuccess(List<ConfigurerInfo<?>> list) {
		if (list != null && !list.isEmpty()) {
		    ConfigurerInfo<InterfaceConfig> interfaceConfigurer = (ConfigurerInfo<InterfaceConfig>) list.get(0);
		    List<InterfaceConfig> interfaces = interfaceConfigurer.getObjects();
		    application.getApplicationContext().setAttribute(ATTRIBUTE_INTERFACES, interfaces);
		}
		
		// TODO: Must load other context
		// TODO: Must get all organizations from DB
		
		callback.onSuccess(new CallbackResult("OK"));
	    }

	});
    }
    
    protected void loadApplicationConfiguration(final Application app, final String ui, final Callback<Object> callback) {
	configurationService.getConfigurers(ui,	new AsyncCallback<List<ConfigurerInfo<?>>>() {

		    @Override
		    public void onFailure(Throwable e) {
			log("Load configurers error", e);
		    }

		    @Override
		    public void onSuccess(List<ConfigurerInfo<?>> result) {

			List<ConfigurerInfo<?>> configurers = result;
			applicationBuilder = new ApplicationBuilder(ui,	configurers);
			configureFrame(app);

		    }

		});
    }
	
    @Override
    protected void configureFrame(Application app) {
	Frame frame = app.getFrame();
	frame.setDelegate(viewport);

	populateFrame(frame);

	viewport.layout(true);
    }
    
    ////
	
    class WebApplicationTemplateProvider implements TemplateProviderAsync {

	@Override
	public void getData(String path, final Callback<IData> callback) {
	    templateService.getData(path, new AsyncCallback<IData>() {

		@Override
		public void onFailure(Throwable caught) {
		    callback.onFailure(caught);
		}

		@Override
		public void onSuccess(IData result) {
		    callback.onSuccess(result);
		}

	    });
	}

    }
    
    class WebLogHandler extends Handler {
	
	private List<LogRecord> records = new ArrayList<LogRecord>();
	
	private int poolSize;

	@Override
	public void log(LogRecord record) {
	    if (record == null) {
		return;
	    }
	    if (poolSize > 0) {
		records.add(record);
		if (records.size() >= poolSize) {
		    processLog(records);
		}
	    } else {
		processLog(record);
	    }
	}
	
	private void clear() {
	    records.clear();
	}

	private void processLog(LogRecord record) {
	    //record.setMessage("WebClient: "  + record.getMessage());
	    logService.log(record, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Void result) {
		}
		
	    });
	}

	private void processLog(List<LogRecord> records) {
	    logService.log(records, new AsyncCallback<Void>() {

		@Override
		public void onFailure(Throwable caught) {
		    clear(); // TODO
		}

		@Override
		public void onSuccess(Void result) {
		    clear();
		}
		
	    });
	}
	
    }

}
