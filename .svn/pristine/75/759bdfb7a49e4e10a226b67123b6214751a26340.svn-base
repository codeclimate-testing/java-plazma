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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.config.configurer.ConfigurerInfo;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.config.object.IActionExecutorConfig;
import org.plazmaforge.framework.config.object.IMenuBarConfig;
import org.plazmaforge.framework.config.object.IMenuConfig;
import org.plazmaforge.framework.config.object.IMenuContainerConfig;
import org.plazmaforge.framework.config.object.IMenuItemConfig;
import org.plazmaforge.framework.config.object.IMenuSeparatorConfig;
import org.plazmaforge.framework.config.object.IToolBarConfig;
import org.plazmaforge.framework.config.object.IToolItemConfig;
import org.plazmaforge.framework.core.command.CommandExecutor;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.event.SelectionEvent;
import org.plazmaforge.framework.uwt.event.SelectionListener;
import org.plazmaforge.framework.uwt.widget.MessageBox;
import org.plazmaforge.framework.uwt.widget.menu.Menu;
import org.plazmaforge.framework.uwt.widget.menu.MenuBar;
import org.plazmaforge.framework.uwt.widget.menu.MenuItem;
import org.plazmaforge.framework.uwt.widget.tool.ToolBar;
import org.plazmaforge.framework.uwt.widget.tool.ToolItem;


/**
 * @author ohapon
 *
 */
public class ApplicationBuilder {
    
    
    private static final Logger logger = Logger.getLogger(ApplicationBuilder.class.getName());
    

    /** Index of the system menu (top) in config list **/
    public final int SYSTEM_MENU_INDEX = 0;
    
    /** Index of the tree menu (left) in config list **/
    public final int TREE_MENU_INDEX = 1;
    
    /** Index of the context menu in config list **/
    public final int CONTEXT_MENU_INDEX = 2;
    
    
    
    public final String FILE_MENU = "File";
    
    public final String WINDOW_MENU = "Window";
    
    public final String HELP_MENU = "Help";

    private static boolean IS_CONTRIBUTE_TOOL_ITEM_TEXT = false; 
    
    protected Map<String, IMenuConfig> systemMenuMap = new HashMap<String, IMenuConfig>();

    private String ui;
    
    private List<ConfigurerInfo<?>> configurers;
    
    protected ConfigurerInfo<IMenuBarConfig> menuBarConfigurer;
    protected ConfigurerInfo<IToolBarConfig> toolBarConfigurer;
    protected ConfigurerInfo<IActionConfig> actionConfigurer;

    public ApplicationBuilder(String ui, List<ConfigurerInfo<?>> configurers) {
	this.ui = ui;  //"All"; //"Admin";
	this.configurers = configurers;
	menuBarConfigurer = (ConfigurerInfo<IMenuBarConfig>) getConfigurerDescriptor("MenuBarConfigurer");
	toolBarConfigurer = (ConfigurerInfo<IToolBarConfig>) getConfigurerDescriptor("ToolBarConfigurer");
	actionConfigurer = (ConfigurerInfo<IActionConfig>) getConfigurerDescriptor("ActionConfigurer");
    }

    protected List<IMenuBarConfig> getMenuBarList() {
	return menuBarConfigurer == null ? null : menuBarConfigurer.getObjects(getUI());
    }
    
    protected List<IToolBarConfig> getToolBarList() {
	return toolBarConfigurer == null ? null : toolBarConfigurer.getObjects(getUI());
    }

    
    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str); 
    }

   
    protected String getUI() {
	return ui;
    }
    
    protected ConfigurerInfo<?> getConfigurerDescriptor(String name) {
  	 return ConfigurerInfo.getConfigurer(configurers, name);
   }
    
    protected IMenuBarConfig getMenuBarConfigByIndex(int index) {
	List<IMenuBarConfig> menuBarList = getMenuBarList();
	if (menuBarList == null) {
	    return null;
	}
	int size = menuBarList.size();
	if (size == 0 || index < 0 || index >= size) {
	    return null;
	}
	return (IMenuBarConfig) menuBarList.get(index);
    }
    
    protected int getMenuBarCount() {
	return getMenuBarList() == null ? 0 : getMenuBarList().size();
    }

    
    protected boolean isSystemMenuBarConfig() {
	return getMenuBarCount() > SYSTEM_MENU_INDEX;
    }
    
    protected boolean isTreeMenuBarConfig() {
	return getMenuBarCount() > TREE_MENU_INDEX;
    }

    protected boolean isContextMenuBarConfig() {
	return getMenuBarCount() > CONTEXT_MENU_INDEX;
    }
    
    
    
    protected IMenuBarConfig getSystemMenuBarConfig() {
	return isSystemMenuBarConfig() ? getMenuBarConfigByIndex(SYSTEM_MENU_INDEX) : null;
    }
    
    protected IMenuBarConfig getTreeMenuBarConfig() {
	return isTreeMenuBarConfig() ? getMenuBarConfigByIndex(TREE_MENU_INDEX) : getMenuBarConfigByIndex(SYSTEM_MENU_INDEX);
    }

    protected IMenuBarConfig getContextMenuBarConfig() {
	return isContextMenuBarConfig() ? getMenuBarConfigByIndex(CONTEXT_MENU_INDEX) : null;
    }

    
    
    public List<IMenuItemConfig> getSortMenuChildren(IMenuConfig menuConfig) {
	if (menuConfig == null) {
	    return null;
	}
	List<IMenuItemConfig> children = menuConfig.getChildren();
	List<IMenuItemConfig> sortChildren = new ArrayList<IMenuItemConfig>(children);
	final int sortDirection = -1;
	Collections.sort(sortChildren, new Comparator<IMenuItemConfig>() {
	    public int compare(IMenuItemConfig o1, IMenuItemConfig o2) {
		if (o1 == null && o2 == null) {
		    return 0;
		}
		if (o1 == null) {
		    return -1 * sortDirection; //
		}
		if (o2 == null) {
		    return 1 * sortDirection; //
		}
		int r1 = 1;
		int r2 = 1;
		if (o1 instanceof IMenuConfig) {
		    r1 = -1;
		}
		if (o2 instanceof IMenuConfig) {
		    r2 = -1;
		}
		if (r1 == r2) {
		    return 0;
		}
		return r1 * sortDirection; //
		
	    }
	});
	return sortChildren;
    }

    protected boolean isDefaultSystemMenu() {
	return true;
    }
    
    protected boolean isSystemMenu(String menuName) {
	if (menuName == null) {
	    return false;
	}
	menuName = menuName.trim();
	return FILE_MENU.equalsIgnoreCase(menuName) || WINDOW_MENU.equalsIgnoreCase(menuName) || HELP_MENU.equalsIgnoreCase(menuName);
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void handleError(String message) {
	logger.error(message);
	MessageBox.error(message);
	
    }

    public IMenuBarConfig getTreeMenu() {
	
	boolean isTreeMenuBarConfig = isTreeMenuBarConfig();
	boolean isInvalid = false;
	IMenuBarConfig treeMenuBarConfig = getTreeMenuBarConfig();
	if (isTreeMenuBarConfig) {
	    treeMenuBarConfig = getTreeMenuBarConfig();
	    if (treeMenuBarConfig == null) {
		isInvalid = true;
	    } else {
		List<IMenuItemConfig> children = treeMenuBarConfig.getChildren();
		if (children == null || children.size() == 0) {
		    isInvalid = true;
		}
	    }
	}
	
	if (isInvalid) {
	    return null;
	}
	return treeMenuBarConfig;
	
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // MENU BAR
    // 
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    public MenuBar createSystemMenu() {
	IMenuBarConfig menuBarConfig = getSystemMenuBarConfig();
	if (menuBarConfig == null) {
	    return null;
	}
	MenuBar menuBar = new MenuBar();
	populateMenuBar(menuBar, menuBarConfig);
	return menuBar;
    }
    
    protected void populateMenuBar(MenuBar menuBar, IMenuBarConfig menuBarConfig) {
	populateMenu(menuBar, menuBarConfig);
    }

    protected void populateMenu(Menu menu, IMenuContainerConfig menuConfig) {
	if (menuConfig instanceof IMenuItemConfig) {
	    menu.setText(((IMenuItemConfig) menuConfig).getText());
	}
	List<IMenuItemConfig> children = menuConfig.getChildren();
	if (children == null || children.isEmpty()) {
	    return;
	}
	for (IMenuItemConfig child: children) {
	    if (child instanceof IMenuConfig) {
		Menu childMenu = new Menu();
		menu.addItem(childMenu); // Add Menu 
		populateMenu(childMenu, (IMenuConfig) child);
	    } else if (child instanceof IMenuSeparatorConfig) {
		menu.addSeparator();
	    } else {
		MenuItem childMenuItem = new MenuItem();
		menu.addItem(childMenuItem);
		String text = child.getText();
		String iconPath = child.getIcon();
		
		if (text != null) {
		    childMenuItem.setText(text);
		}

		if (iconPath != null) {
		    
		    //TODO: Convert icon path
		    iconPath = getIconPath(iconPath);
		    childMenuItem.setIcon(iconPath);
		}

		populateAction(childMenuItem, child);
	    }
	}
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // TOOL BAR
    // 
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<ToolBar> createToolBars() {
	List<IToolBarConfig> toolBarConfigList = getToolBarList();
	if (toolBarConfigList == null) {
	    return null;
	}
	List<ToolBar> toolBars = new ArrayList<ToolBar>();
	for (IToolBarConfig toolBarConfig: toolBarConfigList ) {
	    ToolBar toolBar = new ToolBar();
	    toolBars.add(toolBar);
	    populateToolBar(toolBar, toolBarConfig);
	}
	return toolBars;
    }
    
    protected void populateToolBar(ToolBar toolBar, IToolBarConfig toolBarConfig) {
	List<IToolItemConfig> children = toolBarConfig.getChildren();
	if (children == null || children.isEmpty()) {
	    return;
	}
	for (IToolItemConfig child : children) {
	    
	    ToolItem childToolItem = new ToolItem();
	    toolBar.addItem(childToolItem);
	    String text = child.getText();
	    String iconPath = child.getIcon();

	    if (IS_CONTRIBUTE_TOOL_ITEM_TEXT && text != null) {
		childToolItem.setText(text);
	    }

	    if (iconPath != null) {

		// TODO: Convert icon path
		iconPath = getIconPath(iconPath);
		childToolItem.setIcon(iconPath);
	    }

	    populateAction(childToolItem, child);
	}
    }

    
    private String getIconPath(String path) {
	if (path == null) {
	    return null;
	}
	
	// Check folder
	boolean isWindows = path.startsWith("/org/plazmaforge/framework/client/images/eclipse/windows/");
	boolean isForm = path.startsWith("/org/plazmaforge/framework/client/images/eclipse/form/")
		|| path.startsWith("/org/plazmaforge/framework/resources/images/eclipse/");	
	boolean isFw = path.startsWith("/org/plazmaforge/framework/client/images/fw/");
	
	int index = path.lastIndexOf("/");
	if (index >= 0) {
	    if  (index == path.length() - 1) {
		return null;
	    }
	    path = path.substring(index + 1);
	}
	
	if (isWindows) {
	    return "window::" + path;
	}
	if (isForm) {
	    if ("help_contents.gif".equals(path)) {
		path = "help.gif";
	    } else if  ("import_wiz.gif".equals(path)) {
		path = "import.gif";
	    } else if  ("export_wiz.gif".equals(path)) {
		path = "export.gif";
	    }

	    return "form::" + path;
	}
	if (isFw) {
	    return "action::" + path;
	}

	return path;
    }
    
    protected void populateAction(MenuItem menuItem, IActionExecutorConfig actionExecutorConfig) {
	if (menuItem == null || actionExecutorConfig == null) {
	    return;
	}
	SelectionListener selectionListener = createSelectionListener(actionExecutorConfig.getAction());
	if (selectionListener == null) {
	    return;
	}
	menuItem.addSelectionListener(selectionListener);
    }

    protected void populateAction(ToolItem toolItem, IActionExecutorConfig actionExecutorConfig) {
	if (toolItem == null || actionExecutorConfig == null) {
	    return;
	}
	SelectionListener selectionListener = createSelectionListener(actionExecutorConfig.getAction());
	if (selectionListener == null) {
	    return;
	}
	toolItem.addSelectionListener(selectionListener);
    }

    
    protected SelectionListener createSelectionListener(String action) {
	if (action == null) {
	    return null;
	}
	return new ActionSelectionListener(action);
    }
    
    public class ActionSelectionListener implements SelectionListener {

	private String action;
	
	public ActionSelectionListener(String action) {
	    this.action = action;
	}

	@Override
	public void select(SelectionEvent event) {
	    IActionConfig actionConfig = actionConfigurer == null ? null : actionConfigurer.getObjectByName(action);
	    if (actionConfig == null) {
		String message = "Action '" + action  + "' not found";
		logger.warn(message);
		MessageBox.warning(message);
		return;
	    }
	    executeAction(actionConfig);
	}
    }
    
    protected void executeAction(IActionConfig actionConfig) {
	if (actionConfig == null) {
	    handleError("Action is empty");
	    return;
	}
	String className = StringUtils.nullIfEmpty(actionConfig.getClassName(), true);
	if (className != null) {
	    handleError("Action with class name '" + className + "' is not implemented");
	    return;
	}
	String command = StringUtils.nullIfEmpty(actionConfig.getCommand(), true);
	if (command == null) {
	    handleError("Command of action '" + actionConfig.getName() + "' is empty");
	}
	executeCommand(command);
    }
    
    protected void executeCommand(String command) {
	if (command == null) {
	    handleError("Command is empty");
	    return;
	}
	//MessageBox.information("Execute command '" + command + "'");
	CommandExecutor commandExecutor = (CommandExecutor) Application.getCurrent().getApplicationContext().getAttribute("command.executor");
	commandExecutor.executeCommand(command);
	//FormManager
    }
    
    
}
