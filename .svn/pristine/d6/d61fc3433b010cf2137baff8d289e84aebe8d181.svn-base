package org.plazmaforge.bs.web.client;


import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.gxt.UWT_GXT;

import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebApplication extends Application implements EntryPoint {

    
    /**
     * Root viewport
     */
    private Viewport viewport;
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
	
	///////////////////////////////////////////////////////////////
	
	UWT_GXT.init();
	
	///////////////////////////////////////////////////////////////
	
	RootPanel root = RootPanel.get("root");
	
	///////////////////////////////////////////////////////////////
	
	viewport = new Viewport();
	viewport.setStyleAttribute("margin", "0px");
        viewport.setLayout(new FitLayout());

        root.add(viewport);
        
        // Create UWT Application
        String locale = "en";
        
        getApplicationContext().addAttributes(UWT_GXT.getAttributes());
        getApplicationContext().setProperty("locale", locale);
        
        setInitializer(new WebApplicationInitializer(viewport));
        start();
        
    }
    

}
