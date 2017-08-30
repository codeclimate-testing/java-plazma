package org.plazmaforge.bsolution.app.web;

import java.util.List;

import org.plazmaforge.framework.config.ConfigurerManager;
import org.plazmaforge.framework.config.object.IActionConfig;
import org.plazmaforge.framework.config.object.IConfigIdentifier;
import org.plazmaforge.framework.config.object.IMenuBarConfig;
import org.plazmaforge.framework.config.object.IMenuConfig;
import org.plazmaforge.framework.config.object.IMenuItemConfig;
import org.plazmaforge.framework.config.object.IMenuSeparatorConfig;
import org.plazmaforge.framework.config.configurer.ActionConfigurer;
import org.plazmaforge.framework.config.configurer.ObjectConfigurer;

public class JSGenerator {

    public String generateMenuBarJS(IMenuBarConfig menuBar) {
	
	
	StringBuffer buf = new StringBuffer();
	addLine(buf, "Ext.onReady(function(){");
	
	/////
	
	addLine(buf, "var tb = new Ext.Toolbar();");
	addLine(buf, "tb.render('toolbar');");

	    
	/////    
	List menus = menuBar.getChildren();
	for (int i = 0; i < menus.size(); i++) {
	    addMenu(buf, "tb", (IMenuConfig) menus.get(i));
	}
	
	
	addLine(buf, "tb.doLayout();");

	// functions to display feedback
	addLine(buf, "function onButtonClick(btn){");
	addLine(buf, "    Ext.example.msg('Button Click','You clicked the \"{0}\" button.', btn.text);");
	addLine(buf, "}");

	addLine(buf, "function onItemClick(item){");
	addLine(buf, "    Ext.example.msg('Menu Click', 'You clicked the \"{0}\" menu item.', item.text);");
	addLine(buf, "}");

	addLine(buf, "function onItemCheck(item, checked){");
	addLine(buf, "    Ext.example.msg('Item Check', 'You {1} the \"{0}\" menu item.', item.text, checked ? 'checked' : 'unchecked');");
	addLine(buf, "}");

	addLine(buf, "function onItemToggle(item, pressed){");
	addLine(buf, "    Ext.example.msg('Button Toggled', 'Button \"{0}\" was toggled to {1}.', item.text, pressed);");
	addLine(buf, "}");
	    
	/////
	addLine(buf, "})");
	return buf.toString();
    }
    
    private int menuId = 0;
    
    private String addMenu(StringBuffer buf, String parent, IMenuConfig menu) {
	if (menu == null) {
	    return null;
	}
	String id = null; //menu.getId();
	if (id == null) {
	    menuId++;
	    id = "" + menuId;
	}
	String text = getMenuText(menu);
	String menuVar = "menu" + id;
	
	//menuId++;
	
	addLine(buf, "var " + menuVar + " = new Ext.menu.Menu({");
	addLine(buf, "        id: '" + menuVar + "',");
	//addLine(buf, "    text:'" + text + "',");	
	addLine(buf, "	        style: {");
	addLine(buf, "            overflow: 'visible'");      // For the Combo popup
	addLine(buf, "        }");
	addLine(buf, "});");
	
	// parent = "tb"
	//addLine(buf, "tb.add({");
	addLine(buf, parent + ".add({");
	addLine(buf, "    text:'" + text + "',");
	//addLine(buf, "    iconCls: 'bmenu',");   // <-- icon
	addLine(buf, "    menu: " + menuVar ); // assign menu by instance
	addLine(buf, "});");
	
	
	
	List<IMenuItemConfig> children = menu.getChildren();
	if (children == null || children.isEmpty()) {
	    return menuVar;
	}
	for (IMenuItemConfig m : children) {
	    
	    if (m instanceof IMenuConfig) {
		addMenu(buf, menuVar, (IMenuConfig) m);
	    } else {
		addMenuItem(buf, menuVar, m);
	    }
	    
	}
	return menuVar;
    }
    
    private void addMenuItem(StringBuffer buf, String parent,  IMenuItemConfig menu) {
	String id = null; //menu.getId();
	if (id == null) {
	    menuId++;
	    id = "" + menuId;
	}
	String text = getMenuText(menu);
	
	String menuVar = "menu" + id;
	
	//menuId++;
	
	if (menu instanceof IMenuSeparatorConfig) {
	    //addLine(buf, parent + ".add({");
	    //addLine(buf, "    text:'" + text + "'");
	    //addLine(buf, "});");
	    
	    addLine(buf, parent + ".add('-');");

	    return;
	}
	addLine(buf, "var " + menuVar + " = new Ext.menu.Menu({");
	addLine(buf, "        id: '" + menuVar + "',");
	//addLine(buf, "    text:'" + text + "',");
	addLine(buf, "	        style: {");
	addLine(buf, "            overflow: 'visible'");      // For the Combo popup
	addLine(buf, "        }");
	addLine(buf, "});");
	
	// parent = "tb"
	//addLine(buf, "tb.add({");
	addLine(buf, parent + ".add({");
	addLine(buf, "    text:'" + text + "'");
	
	//addLine(buf, "    text:'" + text + "',");
	//addLine(buf, "    iconCls: 'bmenu',");   // <-- icon
	//addLine(buf, "    menu: " + menuVar ); // assign menu by instance
	
	addLine(buf, "});");
    }
    
    private void addStr(StringBuffer buf, String str) {
	if (str == null){
	    return;
	}
	buf.append(str);
    }
    private void addLine(StringBuffer buf, String line) {
	if (line == null){
	    return;
	}
	buf.append(line + "\n");
    }
    
    protected String getMenuText(IMenuItemConfig menu) {
	String text = doGetMenuText(menu);
	return (text == null) ? "[EMPTY]" : text;
    }
    
    protected String doGetMenuText(IMenuItemConfig menu) {
	
	String text = menu.getText();
	if (text != null) {
	    return text;
	}
	if (menu instanceof IMenuSeparatorConfig) {
	    return "-";
	}
	
	IConfigIdentifier cid = menu.getActionIdentifier();
	if (cid == null){
	    return null;
	}
	String id = cid.getConfigId();
	if (id == null) {
	    return null;
	}
	IActionConfig action = getActionConfigById(id);
	if (action == null) {
	    return null;
	}
	
	// TODO: Must analyze report action
	// String text = report.getName();
	
	return action.getName();
    }
    
    protected IActionConfig getActionConfigById(String id) {
	IActionConfig actionConfig = getActionConfigurer().getActionById(id);
	if (actionConfig == null) {
	    //handleError("Action [" + id + "] not found.");
	}
	return actionConfig; 
    }
    
    protected ActionConfigurer getActionConfigurer() {
	return (ActionConfigurer) getConfigurer(ActionConfigurer.NAME);
    }
    
    protected ObjectConfigurer getConfigurer(String name) {
  	 return ConfigurerManager.getConfigurer(name);
   }
}
