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

package org.plazmaforge.framework.client.swt.app;

import java.util.Iterator;
import java.util.List;

import javax.swing.Action;



import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.pshelf.PShelf;
import org.eclipse.swt.nebula.widgets.pshelf.PShelfItem;
import org.eclipse.swt.nebula.widgets.pshelf.RedmondShelfRenderer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.plazmaforge.framework.action.ActionFactory;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.app.AbstractAppBuilder;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.controls.ToolButton;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.config.object.IMenuBarConfig;
import org.plazmaforge.framework.config.object.IMenuConfig;
import org.plazmaforge.framework.config.object.IMenuItemConfig;
import org.plazmaforge.framework.config.object.IMenuSeparatorConfig;
import org.plazmaforge.framework.config.object.IToolBarConfig;
import org.plazmaforge.framework.config.object.IToolItemConfig;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTAppBuilder extends AbstractAppBuilder {
    
    
    protected static Logger logger = Logger.getLogger(SWTAppBuilder.class);
    

    
    private String[][] MENU = {
	    {"Dictionaries", "References"},
	    {"Contacts", "Contacts"}, 
	    {"Documents", "Documents"}, 
	    {"Projects", "Projects"}, 
	    {"Tasks", "Tasks"}, 
	    {"Organizer", "Organizer"},
	    {"Reports", "Reports"},
    
    };
    
  
    
    
    
    
    private SWTApplication app;

    private static final String ACTION_KEY = "action"; //$NON-NLS-1$
    
    private SWTActionHelper actionHelper = new SWTActionHelper();;
   
    public void setApplication(SWTApplication app) {
        this.app = app;
    }
    
    protected Shell getShell() {
	return app.getShell();
    }
    
    protected SWTApplication getApplication() {
	return app;
    }
    
    /**
     * Create Menu Bar
     * @return
     */
    public Menu createMenuBar() {
	
	Menu menu;
	Menu popupMenu;

	
        if (getApplication().getMenuBar() == null) {
            menu = new Menu(getShell(), SWT.BAR);
        } else {
            menu = getApplication().getMenuBar();
        }
        
        // Add only custom menu items and return
        if (!isDefaultSystemMenu()) {
            createCustomMenuItems(menu);
	    return menu;
	}
        
	// --------------------------------------------------------------------------------------
	// FILE MENU: CREATE
	// --------------------------------------------------------------------------------------
	MenuItem fileMenu = new MenuItem(menu, SWT.CASCADE);
	fileMenu.setText(Messages.getString("SWTAppBuilder.File")); //$NON-NLS-1$
	popupMenu = new Menu(fileMenu);
	fileMenu.setMenu(popupMenu);

   	// Add custom menu items
	createCustomMenuItems(menu);
 	
        // --------------------------------------------------------------------------------------
        // FILE MENU: LOAD
        // --------------------------------------------------------------------------------------
	// Add custom menu items
        IMenuConfig fileMenuConfig = systemMenuMap.get(FILE_MENU);
        if (fileMenuConfig != null)  {
            loadMenuChild(fileMenu.getMenu(), fileMenuConfig);
            new MenuItem(fileMenu.getMenu(), SWT.SEPARATOR);
        }
        MenuItem exitMenuItem = new MenuItem(fileMenu.getMenu(), SWT.NONE);
	exitMenuItem.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		getApplication().exit();
	    }
	});
	exitMenuItem.setText(Messages.getString("SWTAppBuilder.Exit")); //$NON-NLS-1$
	
	//--------------------------------------------------------------------------------------
        // WINDOW MENU
        // --------------------------------------------------------------------------------------	
	MenuItem windowMenu = new MenuItem(menu, SWT.CASCADE);
	windowMenu.setText(Messages.getString("SWTAppBuilder.Window")); //$NON-NLS-1$
	popupMenu = new Menu(windowMenu);
	windowMenu.setMenu(popupMenu);	
	
        createViewMenuItem(windowMenu.getMenu());
        createDesktopMenuItems(windowMenu.getMenu());
        
        // Add custom menu items
        IMenuConfig windowMenuConfig = systemMenuMap.get(WINDOW_MENU);
        if (windowMenuConfig != null)  {
            new MenuItem(windowMenu.getMenu(), SWT.SEPARATOR);
            loadMenuChild(windowMenu.getMenu(), windowMenuConfig);
        }
        
        
        // --------------------------------------------------------------------------------------
        // HELP MENU
        // --------------------------------------------------------------------------------------	
        MenuItem helpMenu = new MenuItem(menu, SWT.CASCADE);
	helpMenu.setText(Messages.getString("SWTAppBuilder.Help")); //$NON-NLS-1$
	popupMenu = new Menu(helpMenu);
	helpMenu.setMenu(popupMenu);	
	
	// Add custom menu items
        IMenuConfig helpMenuConfig = systemMenuMap.get(HELP_MENU);
        if (helpMenuConfig != null)  {
            loadMenuChild(helpMenu.getMenu(), helpMenuConfig);
        }
        
	return menu;
    }
    
    /**
     * Create View menu item. It is system item 
     * @param parentMenu
     * @return
     */
    public MenuItem createViewMenuItem(Menu parentMenu) {
	
	if (parentMenu.getItemCount() > 0) {
	    new MenuItem(parentMenu, SWT.SEPARATOR);
	}
         
         final MenuItem viewMenu = new MenuItem(parentMenu, SWT.CASCADE);
         viewMenu.setText(Messages.getString("SWTAppBuilder.view")); //$NON-NLS-1$
         Menu popupMenu = new Menu(viewMenu);
         viewMenu.setMenu(popupMenu);	
         
         final MenuItem viewMenuBarItem = new MenuItem(viewMenu.getMenu(), SWT.CHECK);
         app.addCheckMenuItem(viewMenuBarItem, SWTApplication.MENU_BAR_VISIBLE);
         
         viewMenuBarItem.setSelection(app.isVisibleMenuBar());
         viewMenuBarItem.setText(Messages.getString("SWTAppBuilder.menu.bar")); //$NON-NLS-1$
         viewMenuBarItem.addListener(SWT.Selection, new Listener() {
           public void handleEvent(Event event)  {
               app.viewMenuBar();
           }
         });
         
         final MenuItem viewToolBarItem = new MenuItem(viewMenu.getMenu(), SWT.CHECK);
         app.addCheckMenuItem(viewToolBarItem, SWTApplication.TOOL_BAR_VISIBLE);
         
         viewToolBarItem.setSelection(app.isVisibleToolBar());
         viewToolBarItem.setText(Messages.getString("SWTAppBuilder.tool.bar")); //$NON-NLS-1$
         viewToolBarItem.addListener(SWT.Selection, new Listener() {
           public void handleEvent(Event event)  {
                app.viewToolBar();
           }
         });	

         
         final MenuItem viewTreeMenuItem = new MenuItem(viewMenu.getMenu(), SWT.CHECK);
         app.addCheckMenuItem(viewTreeMenuItem, SWTApplication.TREE_MENU_VISIBLE);
         
         viewTreeMenuItem.setSelection(app.isVisibleTreeMenu());
         viewTreeMenuItem.setText(Messages.getString("SWTAppBuilder.tree.menu")); //$NON-NLS-1$
         viewTreeMenuItem.addListener(SWT.Selection, new Listener() {
           public void handleEvent(Event event)  {
                app.viewTreeMenu();
           }
         });	
         
         return viewMenu;
    }
    
    /**
     * Create Desktop menu items. It is system items
     * @param parentMenu
     */
    public void createDesktopMenuItems(Menu parentMenu) {
	if (app.getDesktop() == null) {
	    return;
	}
	final MenuItem showMaxTitleItem = new MenuItem(parentMenu, SWT.CHECK);
	app.addCheckMenuItem(showMaxTitleItem, SWTApplication.DESKTOP_SHOW_TITLE);
	
        showMaxTitleItem.setSelection(app.getDesktop().getShowMaximizedTitle());
        showMaxTitleItem.setText(Messages.getString("SWTAppBuilder.ShowTitle")); //$NON-NLS-1$
        
        showMaxTitleItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	boolean b = showMaxTitleItem.getSelection();
        	
        	app.setShowMaximizedTitle(b); // REFACTORED 2009-02-16
        	
        	//app.getDesktop().setShowMaximizedTitle(b);
        	//app.checkMenuItems("desktop.ShowTitle", b);
            }
	});
        
        
        final MenuItem autoMaxTitleItem = new MenuItem(parentMenu, SWT.CHECK);
        app.addCheckMenuItem(autoMaxTitleItem, SWTApplication.DESKTOP_AUTO_MAX_WINDOWS);
        
        autoMaxTitleItem.setSelection(app.getDesktop().getAutoMaximize());
        autoMaxTitleItem.setText(Messages.getString("SWTAppBuilder.AutoMaxWindows")); //$NON-NLS-1$
        autoMaxTitleItem.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event)  {
        	boolean b = autoMaxTitleItem.getSelection();
        	
        	app.setAutoMaximize(b); // REFACTORED 2009-02-16
        	
        	//app.getDesktop().setAutoMaximize(b);
        	//app.checkMenuItems("desktop.AutoMaxWindows", b);
            }
        });
        
//      new MenuItem(windowMenu.getMenu(), SWT.SEPARATOR);
//      
//      final InternalShell active = app.getDesktop().getActiveShell();
//      MenuItem closeItem = new MenuItem(windowMenu.getMenu(), SWT.PUSH);
//      boolean forceClose = (active == null) ? false : ((active.getStyle() & SWT.CLOSE) == 0);
//      closeItem.setText("&Close Active Window" + (forceClose ? " (Force)" : ""));
//      if(active == null) closeItem.setEnabled(false);
//      else closeItem.addListener(SWT.Selection, new Listener()
//      {
//        public void handleEvent(Event event)
//        {
//          active.close();
//        }
//      });
        
        return;
    }
    
    /**
     * Create Custom menu items
     * @param parentMenu
     */
    public void createCustomMenuItems(Menu parentMenu) {
        IMenuBarConfig menuBarConfig = getSystemMenuBarConfig(); 
        if (menuBarConfig == null) {
            return;
        }
        
        Iterator i = menuBarConfig.getChildren().iterator();
        IMenuConfig menuConfig = null;
        while (i.hasNext()) {
            
            menuConfig = (IMenuConfig) i.next();
            String menuName = menuConfig.getName();
            if (isDefaultSystemMenu() && isSystemMenu(menuName)) {
        	systemMenuMap.put(menuName, menuConfig);
        	continue;
            }
            
            MenuItem menuItem = new MenuItem(parentMenu, SWT.CASCADE);
            menuItem.setText(menuConfig.getText());
            Menu popupMenu = new Menu(menuItem);
            menuItem.setMenu(popupMenu);
            
            loadMenuChild(popupMenu, menuConfig);
        }
    }
    
 
    
    
    public Menu createContextMenu() {
	
	Menu menu = new Menu(getShell(), SWT.POP_UP);
	
	createViewMenuItem(menu);
	
        app.contextMenu = menu;
        if (app.desktop != null) {
            app.desktop.setMenu(menu);
        }
        
        return menu;
    }
    
    
    /**
     * Load child of menu
     * @param menu
     * @param menuConfig
     */
    protected void loadMenuChild(Menu menu, IMenuConfig menuConfig) {
        List list = menuConfig.getChildren();
        if (list == null) return;
        Iterator i = list.iterator();
        IMenuItemConfig menuItemConfig = null;
        while (i.hasNext()) {
            menuItemConfig = (IMenuItemConfig) i.next();
            if (menuItemConfig instanceof IMenuConfig) {
        	
                MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
                String text = menuItemConfig.getText();
                if (text != null) {
                    menuItem.setText(menuItemConfig.getText());
                }
                
                Menu popupMenu = new Menu(menuItem);
                menuItem.setMenu(popupMenu);
                loadMenuChild(popupMenu, (IMenuConfig) menuItemConfig);
        	
            } else {
                if (menuItemConfig instanceof IMenuSeparatorConfig ) {
                    new MenuItem(menu, SWT.SEPARATOR);
                } else {
                    createMenuItem(menu, menuItemConfig);
                }
            }
        
        }
    }    
    

    /**
     * Create <code>MenuItem</code> by <code>MenuItemConfig</code>
     * @param menu
     * @param menuItemConfig
     * @return
     */
    protected MenuItem createMenuItem(Menu menu, IMenuItemConfig menuItemConfig) {
	String menuItemName = menuItemConfig.getName();
	String actionName = menuItemConfig.getAction();
	if (actionName == null) {
	    logActionIsEmpty("MenuItem", menuItemName);
	    return null;
	}
        IAction action = getActionByName(actionName);
        if (action == null) {
            logActionNotFound("MenuItem", menuItemName, actionName);
            return null;
        }
        
        Object actionObject = getActionObject(action);
        if (actionObject == null) {
            return null;
        }
        if (actionObject instanceof Action) {
            return createMenuItem(menu, (Action) actionObject);
        }
        if (actionObject instanceof IAction) {
            return createMenuItem(menu, (IAction) actionObject);
        }
        return null;
    }
    
    
    protected MenuItem createMenuItem(Menu menu, Action action ) {
        String text = getActionText(action);
        if (isEmpty(text)) {
            text = generateName(action);
            logActionNameIsEmpty(null, text); // TODO: Must use actionId
        }
        MenuItem newMenuItem = createMenuItem(menu);
      	newMenuItem.setText(text);
        Image image = getActionImage(action); //GUI
        if (image != null) {
            newMenuItem.setImage(image); 
        }
        setMenuItemAction(newMenuItem, action);
        return newMenuItem; 
    }
    
    protected MenuItem createMenuItem(Menu menu, IAction action ) {
        String text = getActionText(action);
        if (isEmpty(text)) {
            text = generateName(action);
            logActionNameIsEmpty(action.getName(), text);
	}
        MenuItem newMenuItem = createMenuItem(menu);
      	newMenuItem.setText(text);
        Image image = getActionImage(action);
        if (image != null) {
            newMenuItem.setImage(image); 
        }
        setMenuItemAction(newMenuItem, action);
        return newMenuItem; 
    }
    

    
    /**
     * Create the menu item
     * @param menu
     * @return
     */
    protected MenuItem createMenuItem(Menu menu) {
	return new MenuItem(menu, SWT.NONE);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Returns the action object of action
     * @param action
     * @return
     */
    protected Object getActionObject(IAction action) {
	return actionHelper.getActionObject(action);
    }

    
    /**
     * Returns the name of Swing action
     * @param action
     * @return name
     */
    protected String getActionText(Action action) {
	return actionHelper.getActionText(action);
    }
    
    /**
     * Returns the name of action
     * @param action
     * @return
     */
    protected String getActionText(IAction action) {
	return actionHelper.getActionText(action);
    }    
    
    /**
     * Get SWT image from Swing action 
     * @param action
     * @return
     */
    public Image getActionImage(Action action){
	return actionHelper.getActionImage(action);
    }
    
    /**
     * Get SWT image from IAction
     */
    public Image getActionImage(IAction action) {
	return actionHelper.getActionImage(action);
    }
    
    protected Image getImage(String path) {
	return SWTResourceManager.getImage(this.getClass(), path);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Menu createDefaultMenuBar() {
	
	Menu menu;
	Menu popupMenu;
	MenuItem fileMenu;
	MenuItem windowMenu;	
	MenuItem helpMenu;

	
	menu = new Menu(getShell(), SWT.BAR);

	// FILE MENU
	fileMenu = new MenuItem(menu, SWT.CASCADE);
	fileMenu.setText(Messages.getString("SWTAppBuilder.File")); //$NON-NLS-1$
	popupMenu = new Menu(fileMenu);
	fileMenu.setMenu(popupMenu);

        
	MenuItem exitMenuItem = new MenuItem(popupMenu, SWT.NONE);
	exitMenuItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    getApplication().exit();
		}
	});
	exitMenuItem.setText(Messages.getString("SWTAppBuilder.Exit")); //$NON-NLS-1$
	

	// WINDOW MENU
	windowMenu = new MenuItem(menu, SWT.CASCADE);
	windowMenu.setText(Messages.getString("SWTAppBuilder.Window")); //$NON-NLS-1$

	popupMenu = new Menu(windowMenu);
	windowMenu.setMenu(popupMenu);

	
	// HELP MENU
	helpMenu = new MenuItem(menu, SWT.CASCADE);
	helpMenu.setText(Messages.getString("SWTAppBuilder.Help")); //$NON-NLS-1$

	popupMenu = new Menu(helpMenu);
	helpMenu.setMenu(popupMenu);

	
	return menu;
    }
    
    /**
     * Create ToolBar
     * @return
     */
    public ToolBar createToolBar() {
        List toolBarList = getToolBarList();
        if (toolBarList == null || toolBarList.size() == 0) {
            initSize(getApplication().getToolBar(), app.coolItem);
            return null;
        }

        final CoolBar coolBar = app.coolBar;
        CoolItem coolItem = null;
        ToolBar toolBar = null;
        
        
//        coolBar.addListener(SWT.Resize, new Listener() {
//	    public void handleEvent (Event event) {
//		coolBar.getParent().getParent().layout();
//	    }
//	});
        
        
        for (int i = 0; i < toolBarList.size(); i++) {
            IToolBarConfig toolBarConfig = (IToolBarConfig) toolBarList.get(i);
            if (i == 0) {
        	// FIRST TOOL BAR
        	coolItem = app.coolItem;
                if (getApplication().getToolBar() == null ) {
                    toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
                    coolItem.setControl(toolBar);
                } else {
                    toolBar = getApplication().getToolBar(); 
                }
            } else {
        	// SECOND TOOL BAR
        	coolItem = new CoolItem(coolBar, SWT.PUSH);
        	toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
        	coolItem.setControl(toolBar);
        	coolItem.addListener(SWT.Move, new Listener() {
        	    public void handleEvent (Event event) {
        		app.coolBar.layout();
        	    }
        	});
            }
            populateToolBar(toolBar, toolBarConfig);
            initSize(toolBar, coolItem);
        }
        
       return toolBar;
    }
    
    protected void populateToolBar(ToolBar toolBar, IToolBarConfig toolBarConfig) {
        Iterator i = toolBarConfig.getChildren().iterator();
        while (i.hasNext()) {
            IToolItemConfig buttonConfig = (IToolItemConfig) i.next();
            IAction action = ActionFactory.getActionByName(buttonConfig.getAction());
            if (action == null) {
        	continue;
            }
            
            Object actionObject = getActionObject(action);
            if (actionObject == null) {
        	continue;
            }
            if (actionObject instanceof Action) {
                createToolItem(toolBar, (Action) actionObject);
            }
            if (actionObject instanceof IAction) {
                createToolItem(toolBar, (IAction) actionObject);
            }
            
        }
    }
    
    protected void initSize(ToolBar toolBar, CoolItem coolItem) {
	if (toolBar == null || coolItem == null) {
	   return; 
	}
        Point size = toolBar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	coolItem.setSize(coolItem.computeSize(size.x, size.y + 3));
    }

    
    /**
     * Create ToolItem by Swing action
     * @param toolBar
     * @param action
     * @return
     */
    public ToolItem createToolItem(ToolBar toolBar, Action action) {
        Image image = getActionImage(action);
        if (image == null) {
            return null;
        }
    	ToolItem newToolItem = createToolItem(toolBar);
    	newToolItem.setImage(image);
    	setToolItemAction(newToolItem, action);
        return 	newToolItem;
    }
     
    /**
     * Create ToolItem by action
     * @param toolBar
     * @param action
     * @return
     */
    public ToolItem createToolItem(ToolBar toolBar, IAction action) {
        Image image = getActionImage(action);
        if (image == null) {
            return null;
        }
    	ToolItem newToolItem = createToolItem(toolBar);
    	newToolItem.setImage(image);
    	String name = action.getName();
    	if (name != null) {
    	    newToolItem.setToolTipText(name);
    	}
    	setToolItemAction(newToolItem, action);
        return 	newToolItem;
    }    
        
    /**
     * Create ToolItem
     * @param toolBar
     * @return
     */
    protected ToolItem createToolItem(ToolBar toolBar) {
	return new ToolItem(toolBar, SWT.PUSH);
    }
    
    public ToolBar createDefaultToolBar() {
	ToolBar toolBar;
	ToolItem newToolItem;
	ToolItem helpToolItem;	
	
	toolBar = new ToolBar(getShell(), SWT.NONE);

	newToolItem = new ToolItem(toolBar, SWT.PUSH);
	newToolItem.setImage(getImage("/org/plazmaforge/framework/resources/images/eclipse/topic.gif")); //$NON-NLS-1$

	helpToolItem = new ToolItem(toolBar, SWT.PUSH);
	helpToolItem.setImage(getImage("/org/plazmaforge/framework/resources/images/eclipse/view.gif")); //$NON-NLS-1$
	return toolBar;
    }
    
    public Composite createStatusBar() {
	Composite statusBar = new Composite(getShell(), SWT.NONE);
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginHeight = 2;
	gridLayout.numColumns = 2;
	statusBar.setLayout(gridLayout);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	//gridData.heightHint = 15;
	statusBar.setLayoutData(gridData);

	createTreeMenuTool(statusBar);
	
	Label statusLabel = new Label(statusBar, SWT.NONE);
	statusLabel.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));
	//statusLabel.setText("status text"); //$NON-NLS-1$
	getApplication().setStatusLabel(statusLabel);
	return statusBar;
	
    }
    
    protected void createTreeMenuTool(Composite parent) {
	if (app.treeMenu == null || app.sashForm == null) {
	    return;
	}
	app.treeMenuTool = new ToolButton(parent, SWT.FLAT);
	app.treeMenuTool.setImage(getImage("/org/plazmaforge/framework/client/images/eclipse/form/tree_mode.gif")); //$NON-NLS-1$
	app.treeMenuTool.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    doTreeToolButtonSelect();
		}
	    });
    }
    
    protected void doTreeToolButtonSelect() {
	if (app.treeMenu == null || app.sashForm == null) {
	    return;
	}
	app.viewTreeMenu();
    }
    
    public Composite createContent() {
	Composite content = new Composite(getShell(), SWT.BORDER);
	content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	GridLayout layout = new GridLayout();
	layout.horizontalSpacing = 0;
	layout.verticalSpacing = 0;
	layout.marginTop = 0;
	layout.marginBottom = 0;
	layout.marginHeight = 0;
	layout.marginWidth = 0;
	content.setLayout(layout);
	return content;
    }
    
    /**
     * Create Tree Menu
     * @return
     */
    public PShelf createTreeMenu() {
	
	boolean isTreeMenuBarConfig = isTreeMenuBarConfig();
	boolean isInvalid = false;
	if (isTreeMenuBarConfig) {
	    IMenuBarConfig treeMenuBarConfig = getTreeMenuBarConfig();
	    if (treeMenuBarConfig == null) {
		isInvalid = true;
	    } else {
		List children = treeMenuBarConfig.getChildren();
		if (children == null || children.size() == 0) {
		    isInvalid = true;
		}
	    }
	}
	
	PShelf treeMenu = getApplication().treeMenu;
	
	if (isInvalid) {
	    if (treeMenu != null) {
		treeMenu.setVisible(false);
	    }
	    return null;
	}
	
	
	if (treeMenu == null) {
	    SashForm sashForm = getApplication().sashForm;
	    treeMenu = new PShelf(sashForm, SWT.BORDER);
	    getApplication().treeMenu = treeMenu;
	    sashForm.setWeights(new int[] {1, 5 });
	}
	
	// Initialize view of the tree menu
	initTreeMenu(treeMenu);

	
	
	if (isTreeMenuBarConfig) {
	    createSectionTreeMenuItems(treeMenu);
	} else {
	    createDefaultTreeMenuItems(treeMenu);	    
	}
	
	
	loadTreeMenuItems(treeMenu);
	
	// Force resize: fix PShelf - call PShelf.computeItemYCoordinates() (problem for Linux)
	treeMenu.notifyListeners(SWT.Resize, null);
	
	app.updateTreeMenuTool();
	
	return treeMenu;
    }
    
    /**
     * Initialize Tree Menu
     * @param treeMenu
     */
    protected void initTreeMenu(PShelf treeMenu) {

	//sh.setBackground(SWTResourceManager.getColor(128, 255, 0));
    	//sh.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE + 20));
	//sh.setBounds(0, 0, 68, 68);
    	
	treeMenu.setRenderer(new RedmondShelfRenderer());
	
	//AbstractRenderer renderer =  sh.getRenderer();
	//if (renderer instanceof PaletteShelfRenderer) {
	//((PaletteShelfRenderer) renderer).setShadeColor(SWTResourceManager.getColor(SWT.COLOR_BLUE));
	     
	//}
	//renderer.setShadeColor(SWTResourceManager.getColor(SWT.COLOR_BLUE));	
    }
    
    protected void createDefaultTreeMenuItems(PShelf parent) {
	
       MENU[0][1] = Messages.getString("SWTAppBuilder.References");
       MENU[1][1] = Messages.getString("SWTAppBuilder.Contacts");
       MENU[2][1] = Messages.getString("SWTAppBuilder.Documents");
       MENU[3][1] = Messages.getString("SWTAppBuilder.Projects");
       MENU[4][1] = Messages.getString("SWTAppBuilder.Tasks");
       MENU[5][1] = Messages.getString("SWTAppBuilder.Organizer");
       MENU[6][1] = Messages.getString("SWTAppBuilder.Reports");
		    
	for (int i = 0; i < MENU.length; i++) {
	    PShelfItem item = new PShelfItem(parent, SWT.NONE);
	    item.setData(MENU[i][0]);
	    item.setText(MENU[i][1]);
	}
    }
    
    
    protected void createSectionTreeMenuItems(PShelf parent) {
	IMenuBarConfig menuBarConfig = getTreeMenuBarConfig();
	if (menuBarConfig == null) {
	    return;
	}
	List children = menuBarConfig.getChildren();
	if (children == null || children.size() == 0) {
	    return;
	}
	for (int i = 0; i < children.size(); i++) {
	    IMenuConfig menu = (IMenuConfig) children.get(i);
	    PShelfItem item = new PShelfItem(parent, SWT.NONE);
	    item.setData(menu.getName());
	    item.setText(menu.getText());
	}
    }
    
    
    protected void loadTreeMenuItems(PShelf parent) {
	PShelfItem[] items = parent.getItems();
		
	IMenuBarConfig menuBarConfig = getTreeMenuBarConfig(); 
	if (menuBarConfig == null) {
	    return;
	}
        List menus = menuBarConfig.getChildren();
	        
	for (PShelfItem item : items) {
	    String name = (String) item.getData();
	    IMenuConfig m = getMenuConfigByName(name, menus);
	    if (m == null) {
		continue;
	    }
	    loadTreeMenuChild(item, m);

	}
    } 
    
    
    
    protected void loadTreeMenuChild(PShelfItem parent, IMenuConfig menuConfig) {
        List list = getSortMenuChildren(menuConfig); //menuConfig.getChildren();
        if (list == null) return;
        Iterator i = list.iterator();
        IMenuItemConfig menuItemConfig = null;
        
        parent.getBody().setLayout(new FillLayout());
        Tree tree = new Tree(parent.getBody(), SWT.BORDER);
        
        tree.addMouseListener(new MouseListener() {
            
            public void mouseDoubleClick(MouseEvent e) {
        	Tree tree = (Tree) e.widget;
        	TreeItem[] items = tree.getSelection();
        	if (items == null || items.length == 0) {
        	    return;
        	}
        	Event event = new Event();
        	event.widget = items[0];
        	SelectionEvent se = new SelectionEvent(event);
        	runWidgetAction(se);
            }

            public void mouseDown(MouseEvent e) {
        	
            }

            public void mouseUp(MouseEvent e) {
        	
            }
    	});
        
    	
        while (i.hasNext()) {
            menuItemConfig = (IMenuItemConfig) i.next();
            if (menuItemConfig instanceof IMenuConfig) {
        	
        	
           	TreeItem treeItem = new TreeItem(tree, SWT.NONE);
           	treeItem.setImage(getImage("/org/plazmaforge/framework/client/images/eclipse/folder/fldr_obj.gif")); //$NON-NLS-1$
           	String text = menuItemConfig.getText();
           	if (text != null) {
           	    treeItem.setText(menuItemConfig.getText());
                }           	
                  
                loadTreeMenuChild(treeItem, (IMenuConfig) menuItemConfig);
        	
            } else {
                if (menuItemConfig instanceof IMenuSeparatorConfig ) {
                    //new MenuItem(menu, SWT.SEPARATOR);
                } else {
                    createTreeMenuItem(tree, menuItemConfig);
                }
            }
        
        }	
    }
    

    protected void loadTreeMenuChild(TreeItem parent, IMenuConfig menuConfig) {
        List list = this.getSortMenuChildren(menuConfig); //menuConfig.getChildren();
        if (list == null) return;
        Iterator i = list.iterator();
        IMenuItemConfig menuItemConfig = null;
        
        while (i.hasNext()) {
            menuItemConfig = (IMenuItemConfig) i.next();
            if (menuItemConfig instanceof IMenuConfig) {
        	
        	
           	TreeItem treeItem = new TreeItem(parent, SWT.NONE);
           	treeItem.setImage(getImage("/org/plazmaforge/framework/client/images/eclipse/folder/fldr_obj.gif")); //$NON-NLS-1$
           	String text = menuItemConfig.getText();
           	if (text != null) {
           	    treeItem.setText(menuItemConfig.getText());
                }           	
                  
                loadTreeMenuChild(treeItem, (IMenuConfig) menuItemConfig);
        	
            } else {
                if (menuItemConfig instanceof IMenuSeparatorConfig ) {
                    //new MenuItem(menu, SWT.SEPARATOR);
                } else {
                    createTreeMenuItem(parent, menuItemConfig);
                }
            }
        
        }	
    }
    
    
   protected TreeItem createTreeMenuItem(Tree tree, IMenuItemConfig menuItemConfig) {
	
        String menuItemName = menuItemConfig.getName();
	String actionName = menuItemConfig.getAction();
	if (actionName == null) {
	    logActionIsEmpty("TreeItem", menuItemName);
	    return null;
	}
        IAction action = getActionByName(actionName);
        if (action == null) {
            logActionNotFound("TreeItem", menuItemName, actionName);
            return null;
        }
        
        Object actionObject = getActionObject(action);
        if (actionObject == null) {
            return null;
        }
        if (actionObject instanceof Action) {
            return createTreeItem(tree, (Action) actionObject);
        }
        if (actionObject instanceof IAction) {
            return createTreeItem(tree, (IAction) actionObject);
        }
        return null;
   }
   
   
   protected TreeItem createTreeMenuItem(TreeItem parent, IMenuItemConfig menuItemConfig) {
	
       String menuItemName = menuItemConfig.getName();
	String actionName = menuItemConfig.getAction();
	if (actionName == null) {
	    logActionIsEmpty("TreeItem", menuItemName);
	    return null;
	}
       IAction action = getActionByName(actionName);
       if (action == null) {
           logActionNotFound("TreeItem", menuItemName, actionName);
           return null;
       }
       
       Object actionObject = getActionObject(action);
       if (actionObject == null) {
           return null;
       }
       if (actionObject instanceof Action) {
           return createTreeItem(parent, (Action) actionObject);
       }
       if (actionObject instanceof IAction) {
           return createTreeItem(parent, (IAction) actionObject);
       }
       return null;
   }
   
   
   protected TreeItem createTreeItem(Tree parent, Action action) {
       String text = getActionText(action);
       if (isEmpty(text)) {
           text = generateName(action);
           logActionNameIsEmpty(null, text); // TODO: Must use actionId
       }
       TreeItem treeItem = createTreeItem(parent);
       treeItem.setText(text);             
       Image image = getActionImage(action);
       setTreeItemImage(treeItem, image);
       setTreeItemAction(treeItem, action);
       return treeItem;       
   }
   
   protected TreeItem createTreeItem(Tree parent, IAction action) {
       String text = getActionText(action);
       if (isEmpty(text)) {
	   text = generateName(action);
           logActionNameIsEmpty(action.getName(), text);
       }
       TreeItem treeItem = createTreeItem(parent);
       treeItem.setText(text);             
       Image image = getActionImage(action);
       setTreeItemImage(treeItem, image);
       setTreeItemAction(treeItem, action);
       return treeItem;       
   }   
   
   protected TreeItem createTreeItem(TreeItem parent, Action action) {
       String text = getActionText(action);
       if (isEmpty(text)) {
           text = generateName(action);
           logActionNameIsEmpty(null, text); // TODO: Must use actionId
       }
       TreeItem treeItem = createTreeItem(parent);
       treeItem.setText(text);             
       Image image = getActionImage(action);
       setTreeItemImage(treeItem, image);
       setTreeItemAction(treeItem, action);
       return treeItem;       
   }
   
   protected TreeItem createTreeItem(TreeItem parent, IAction action) {
       String text = getActionText(action);
       if (isEmpty(text)) {
	   text = generateName(action);
           logActionNameIsEmpty(action.getName(), text);
       }
       TreeItem treeItem = createTreeItem(parent);
       treeItem.setText(text);             
       Image image = getActionImage(action);
       setTreeItemImage(treeItem, image);
       setTreeItemAction(treeItem, action);
       return treeItem;       
   }   
   
   protected void setTreeItemImage(TreeItem treeItem, Image image) {
       Image itemImage = image == null ? getImage("/org/plazmaforge/framework/client/images/eclipse/folder/activity.gif") : image; //$NON-NLS-1$
       treeItem.setImage(itemImage);
   }
   
   
   protected TreeItem createTreeItem(Tree parent) {
       return new TreeItem(parent, SWT.NONE);
   }
   
   protected TreeItem createTreeItem(TreeItem parent) {
       return new TreeItem(parent, SWT.NONE);
   }
   
   

    
    protected IAction getActionByName(String name) {
	IActionConfig actionConfig = getActionConfigByName(name);
	if (actionConfig == null) {
	    return null;
	}
	return ActionFactory.getActionByName(actionConfig.getName());
    }
    
    protected void setMenuItemAction(MenuItem toolItem, Object action) {
	setWidgetAction(toolItem, action);
        toolItem.addSelectionListener(new SelectionAdapter() {
    	    public void widgetSelected(SelectionEvent e) {
    		runWidgetAction(e);
    	    }
    	});
    }
    
    protected void setToolItemAction(ToolItem toolItem, Object action) {
	setWidgetAction(toolItem, action);
        toolItem.addSelectionListener(new SelectionAdapter() {
    	    public void widgetSelected(SelectionEvent e) {
    		runWidgetAction(e);
    	    }
    	});
    }
    
    protected void setTreeItemAction(TreeItem toolItem, Object action) {
	setWidgetAction(toolItem, action);
    }
    
    
    protected void setWidgetAction(Widget widget, Object action) {
	widget.setData(ACTION_KEY, action);
    }
    
    
    protected void runWidgetAction(SelectionEvent e) {
	if (e == null) {
	    return;
	}
	Object source = e.getSource(); 
	if (source == null) {
	    return;
	}
	if (!(source instanceof Widget)) {
	    return;
	}
	Widget widget = (Widget) source;
	Object actionObject = widget.getData(ACTION_KEY);
	if (actionObject == null) {
	    return;
	}
	if (actionObject instanceof Action) {
	    run((Action) actionObject, e);
	} else if (actionObject instanceof IAction) {
	    run((IAction) actionObject, e);
	}
    }
    

    protected void run(Action action, SelectionEvent e) {
	try{
	    Toolkit.run(action , e);
	} catch (Exception ex) {
	    
	}
    }
    
    protected void run(IAction action, SelectionEvent e) {
	Widget widget = (Widget) e.getSource();
	Toolkit.run((IAction) widget.getData(ACTION_KEY), e);
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    protected String generateName(IAction action) {
	return (action == null) ? null : ("<" + action.getName() + ">"); 
    }
    
    protected String generateName(Action action) {
	return (action == null) ? null : ("<unknown>"); // TODO Must use actionId
    }

    
    protected void logActionIsEmpty(String itemType, String itemId) {
	logger.warn("Action is empty. " + itemType + " [id=" + itemId + "]");
    }
    
    protected void logActionNotFound(String itemType, String itemId, String actionName) {
	logger.warn("Action '" + actionName + "' not found. " + itemType + " [id=" + itemId + "]");
    }
    
    protected void logActionNameIsEmpty(String actionName, String newName) {
	logger.warn("Action name is empty. ActionName = '" + actionName + "'. Auto generate name ='" + newName + "'");
    }

 
}
