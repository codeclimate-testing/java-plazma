package org.plazmaforge.bsolution.base.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.config.object.IMenuBarConfig;
import org.plazmaforge.framework.config.object.IMenuConfig;
import org.plazmaforge.framework.config.object.IMenuItemConfig;
import org.plazmaforge.framework.config.object.IToolBarConfig;
import org.plazmaforge.framework.config.configurer.ActionConfigurer;
import org.plazmaforge.framework.config.configurer.MenuBarConfigurer;
import org.plazmaforge.framework.config.configurer.ObjectConfigurer;
import org.plazmaforge.framework.config.configurer.ToolBarConfigurer;
import org.plazmaforge.framework.util.StringUtils;

public class WEBApplicationBuilder {
    

    /** Index of the system menu (top) in config list **/
    public final int SYSTEM_MENU_INDEX = 0;
    
    /** Index of the tree menu (left) in config list **/
    public final int TREE_MENU_INDEX = 1;
    
    /** Index of the context menu in config list **/
    public final int CONTEXT_MENU_INDEX = 2;
    
    
    
    public final String FILE_MENU = "File"; //$NON-NLS-1$
    
    public final String WINDOW_MENU = "Window"; //$NON-NLS-1$
    
    public final String HELP_MENU = "Help"; //$NON-NLS-1$

    
    protected Map<String, IMenuConfig> systemMenuMap = new HashMap<String, IMenuConfig>();
    
    
    public WEBApplicationBuilder(String ui) {
	super();
	this.ui = ui;
    }

    protected ObjectConfigurer getConfigurer(String name) {
   	 return ConfigurerManager.getConfigurer(name);
    }
    
    protected List getConfigurerObjects(String name) {
	ObjectConfigurer configurer = getConfigurer(name);
	if (configurer == null) {
	    return null;
	}
   	 return configurer.getObjects();
    }
    
    protected List getConfigurerObjects(String name, String category) {
	ObjectConfigurer configurer = getConfigurer(name);
	if (configurer == null) {
	    return null;
	}
   	 return configurer.getObjects(category);
    }
    
    protected ActionConfigurer getActionConfigurer() {
	return (ActionConfigurer) getConfigurer(ActionConfigurer.NAME);
    }
    
    protected MenuBarConfigurer getMenuBarConfigurer() {
	return (MenuBarConfigurer) getConfigurer(MenuBarConfigurer.NAME);
    }

    protected ToolBarConfigurer getToolBarConfigurer() {
	return (ToolBarConfigurer) getConfigurer(ToolBarConfigurer.NAME);
    }
    
    
    protected List<IActionConfig> getActionList() {
	return getActionConfigurer().getObjects(); //getConfigurerObjects(ActionConfigurer.NAME);
    }
    
    protected List<IMenuBarConfig> getMenuBarList() {
	return getMenuBarConfigurer().getObjects(getUI()); //getConfigurerObjects(MenuBarConfigurer.NAME);
    }
    
    protected List<IToolBarConfig> getToolBarList() {
	return getToolBarConfigurer().getObjects(getUI()); //getConfigurerObjects(ToolBarConfigurer.NAME);
    }

    
    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str); 
    }

    private String ui;
    
    protected String getUI() {
	return ui;// AppEnvironment.getUserInterface(); //"All"; //"Admin";
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected IActionConfig getActionConfigById(String id) {
	IActionConfig actionConfig = getActionConfigurer().getActionById(id);
	if (actionConfig == null) {
	    handleError("Action [" + id + "] not found.");
	}
	return actionConfig; 
    }
    
    protected IMenuConfig getMenuConfigById(String id, List menus) {
	for (int i = 0; i < menus.size(); i++) {
	    IMenuConfig m = (IMenuConfig) menus.get(i);
	    if (id.equals(m.getId())) {
		return m;
	    }
	}
	return null;
    }

    protected IMenuBarConfig getMenuBarConfigByIndex(int index) {
	List menuBarList = getMenuBarList();
	if (menuBarList == null) {
	    return null;
	}
	int size = menuBarList.size();
	if (size == 0 || index < 0 || index >= size) {
	    return null;
	}
	return (IMenuBarConfig) menuBarList.get(index);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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

    
    
    public List getSortMenuChildren(IMenuConfig menuConfig) {
	if (menuConfig == null) {
	    return null;
	}
	List children = menuConfig.getChildren();
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
    
    protected boolean isSystemMenu(String menuId) {
	if (menuId == null) {
	    return false;
	}
	menuId = menuId.trim();
	return FILE_MENU.equalsIgnoreCase(menuId) || WINDOW_MENU.equalsIgnoreCase(menuId) || HELP_MENU.equalsIgnoreCase(menuId);
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void handleError(String message) {
	// TODO: STUB
	System.err.println(message);
    }

    
    
    
    
    
    
    
    public IMenuBarConfig createTreeMenu() {
	
	boolean isTreeMenuBarConfig = isTreeMenuBarConfig();
	boolean isInvalid = false;
	IMenuBarConfig treeMenuBarConfig = getTreeMenuBarConfig();
	if (isTreeMenuBarConfig) {
	    treeMenuBarConfig = getTreeMenuBarConfig();
	    if (treeMenuBarConfig == null) {
		isInvalid = true;
	    } else {
		List children = treeMenuBarConfig.getChildren();
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
    
    
   
}
