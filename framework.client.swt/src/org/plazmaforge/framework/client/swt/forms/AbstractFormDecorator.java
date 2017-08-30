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

package org.plazmaforge.framework.client.swt.forms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.plazmaforge.framework.action.IAction;
import org.plazmaforge.framework.action.IActionDescriptor;
import org.plazmaforge.framework.client.forms.IForm;
import org.plazmaforge.framework.client.forms.IFormConstants;
import org.plazmaforge.framework.client.forms.IFormDecorator;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.SWTUtils;
import org.plazmaforge.framework.client.swt.controls.FixMenuManager;
import org.plazmaforge.framework.client.swt.custom.ishell.InternalShell;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.StringUtils;
import org.plazmaforge.framework.util.SystemInfo;


/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractFormDecorator extends Composite implements IFormDecorator, IFormConstants {

    
    public static final Image REFRESH_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/edit/refresh.gif");
    public static final Image PRINT_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/form/print_edit.gif");
    public static final Image SORT_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/edit/alpha_mode.gif");
    public static final Image FIND_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/find.png");
    
    public static final Image FILTER_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/funnel.png"); //org/plazmaforge/framework/resources/images/olmari/Filter.gif   
    public static final Image ADVANCED_FILTER_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/funnel-arrow.png"); //org/plazmaforge/framework/resources/images/olmari/ExtFilter.gif
    public static final Image CLEAR_FILTER_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/funnel-minus.png"); //org/plazmaforge/framework/resources/images/olmari/ClearFilter.gif
    public static final Image PERIOD_FILTER_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/date.png"); //org/plazmaforge/framework/resources/images/olmari/Calendar_ext.gif
    public static final Image EXPORT_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/form/export_wiz.gif");
    public static final Image SETUP_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/cog.png");
    public static final Image HELP_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/form/help_contents.gif"); //org/plazmaforge/framework/resources/images/eclipse/form/help_contents.gif
    
    ////
    
    public static final Image ADD_ITEM_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/page_white_add.png"); //org/plazmaforge/framework/client/images/eclipse/form/addtsk_tsk_h.gif
    public static final Image EDIT_ITEM_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/page_white_edit.png"); //org/plazmaforge/framework/client/images/eclipse/form/edittsk_tsk_h.gif
    public static final Image COPY_ITEM_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/page_white_copy.png"); //org/plazmaforge/framework/client/images/eclipse/form/copytsk_tsk_h.gif
    public static final Image DELETE_ITEM_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/fw/page_white_delete.png"); //org/plazmaforge/framework/client/images/eclipse/form/remtsk_tsk_h.gif
    
    public static final Image ACTION_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/process/go_nav.gif");//org/plazmaforge/framework/client/images/fw/action_go.gif 

    ////
    
    public static final Image FIRST_PAGE_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/page/first.gif"); ///org/plazmaforge/framework/client/images/eclipse/page/first.gif
    public static final Image PREV_PAGE_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/page/previous.gif"); //org/plazmaforge/framework/client/images/eclipse/page/previous.gif
    public static final Image NEXT_PAGE_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/page/next.gif"); //org/plazmaforge/framework/client/images/eclipse/page/next.gif
    public static final Image LAST_PAGE_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/page/last.gif"); //org/plazmaforge/framework/client/images/eclipse/page/last.gif
    
    public static final Image TREE_IMAGE = getResourceImage("/org/plazmaforge/framework/client/images/eclipse/form/tree_mode.gif");
    
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    private IForm form;
    
    protected CoolBarManager coolBarManager;
    
    protected CoolBar coolBar;
    
    protected ToolBarManager toolBarManager;
    
    private ToolBarManager actionToolBarManager;
    
    protected ToolBarManager extToolBarManager;
    
    private boolean modal;
  
    private ISWTShellPresentation shellPresentation;

    protected boolean isInitDecorator;
    
    private boolean isOpened;

    private Map<String, org.eclipse.jface.action.IAction> globalActions = new HashMap<String, org.eclipse.jface.action.IAction>();
    
    
    protected org.eclipse.jface.action.IAction dropDownAction;

    private boolean hasPostionActions;
    
    private List<IActionDescriptor> actionDescriptors;
    
    
    public AbstractFormDecorator(Composite parent) {
	this(parent, SWT.NONE);
    }

    public AbstractFormDecorator(Composite parent, int style) {
	super(parent, style);
	
	//getParent()
	getShellComposite().addListener(SWT.Close, new Listener() {
	    public void handleEvent (Event event) {
		event.doit = false;
		sendMessage("CLOSE");
	    }
	});
	
	registerGlobalActions();
    }
    
    public void init() throws ApplicationException {
	
	setTitle(getDecoratorTitle());
	
	// Initialize form
	initForm();
	
	actionDescriptors = getActionDescriptors(getForm());
	hasPostionActions = hasPostionActions(actionDescriptors);

	
	// Initialize decorator
	initToolBar(); // First tool bar
	
	initExtToolBar();
	
	initMenuBar();
	
	initActions(); // Special cool item for actions
	
	initContextMenu();
	
	
	
	isInitDecorator = true;
	
	coolBarManager.update(true);
	
	initSize(toolBarManager.getControl());
	
	updateState();
    }    
 
    protected void initForm() throws ApplicationException {
    }
 
    protected void initToolBar() throws ApplicationException {
	
    }
    
    protected void initExtToolBar() throws ApplicationException {
	//initSize(extCoolItem, extToolBar);
    }
    
    protected void initMenuBar() throws ApplicationException {
    }
    
    protected void initActions() throws ApplicationException {
	initActions(getForm().getActions());	
    }
    
    protected void initContextMenu() throws ApplicationException {
    }    

    public Map<IAction, IActionDescriptor> getActionDescriptorMap() {
	return getForm().getActionDescriptorMap();
    }
    
    public List<IActionDescriptor> getActionDescriptors() {
	return actionDescriptors;
    }
    
    public boolean hasPostionActions() {
	return hasPostionActions;
    }
    
    ////
    
    protected List<IActionDescriptor> getActionDescriptors(IForm form) {
	List<IActionDescriptor> actionDescriptors = new ArrayList<IActionDescriptor>(); 
	actionDescriptors.addAll(form.getActionDescriptorMap().values());
	return actionDescriptors;
    }
    
    protected boolean hasPostionActions(List<IActionDescriptor> actionDescriptors) {
	
	if (actionDescriptors == null || actionDescriptors.isEmpty()  ) {
	    return false;
	}
	for (IActionDescriptor actionDescriptor : actionDescriptors) {
	    if (!isEmptyPosition(actionDescriptor)) {
		return true;
	    }
	}
	return false;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected void registerGlobalActions() {
	registerGlobalAction(REFRESH_ACTION, Messages.getString("Form.refresh"), REFRESH_IMAGE);
	
	registerGlobalAction(ADD_ACTION, Messages.getString("Form.add"), ADD_ITEM_IMAGE);
	registerGlobalAction(EDIT_ACTION, Messages.getString("Form.edit"), EDIT_ITEM_IMAGE);
	registerGlobalAction(COPY_ACTION, Messages.getString("Form.copy"), COPY_ITEM_IMAGE);
	registerGlobalAction(DEL_ACTION, Messages.getString("Form.delete"), DELETE_ITEM_IMAGE);
	
	registerGlobalAction(PRINT_ACTION, Messages.getString("Form.print"), PRINT_IMAGE);
	registerGlobalAction(EXPORT_ACTION, Messages.getString("Form.export") + "...", Messages.getString("Form.export"), EXPORT_IMAGE);
	
	registerGlobalAction(SETUP_ACTION, Messages.getString("Form.setup"), SETUP_IMAGE);
	registerGlobalAction( HELP_ACTION, Messages.getString("Form.help"), HELP_IMAGE);
	
    }
    
    protected org.eclipse.jface.action.IAction registerGlobalAction(String id, String text, Image image) {
	return registerGlobalAction(id, text, null, image);
    }

    protected org.eclipse.jface.action.IAction registerGlobalAction(String id, String text, String toolTip, Image image) {
	org.eclipse.jface.action.IAction action = createAction(id, text, toolTip, image);
	globalActions.put(id, action);
	return action;
    }

    
    public org.eclipse.jface.action.IAction getGlobalAction(String id) {
	return  globalActions.get(id);
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void sendMessage(String msg) {
	getForm().sendMessage(msg);
    }
    
    public IForm getForm() {
        return form;
    }
    
    public void setForm(IForm form) {
	checkFormClass(form);
	this.form = form;
    }
    
    protected void checkFormClass(IForm form) {
	
    }
    
    public void doAction(String actionIdentificator) {
	getForm().doAction(actionIdentificator); 
    }    

    public int getWidth() {
	return getSize().x;
    }
    
    public int getHeight() {
	return getSize().y;
    }
    
    public void setVisible(boolean visible) {
	super.setVisible(visible);
	if (isInternalShell()) {
	    getInternalShell().open();
	} else {
	    getParent().setVisible(visible);
	}
    }
    
    public void pack() {
	super.pack();
	if (isInternalShell()) {
	    getInternalShell().pack();
	} else {
	    getParent().pack();
	}
    }
    
    public void close() {
	if (isInternalShell()) {
	    getInternalShell().dispose();
	} else {
	    getParent().dispose();
	}	
	dispose();
    }
    
    public Composite getShellComposite() {
	if (isInternalShell()) {
	    return getInternalShell();
	} else {
	    return getParent();
	}
    }
    
    
    public void setSize(int width, int height) {
	super.setSize(width, height);
	if (isInternalShell()) {
	    getInternalShell().setSize(width, height);
	} else {
	    getParent().setSize(width, height);
	}	
    }
    
    public void resize() {
	if (getForm() == null) {
	    return;
	}
	int width = getForm().getWidth();
	int height = getForm().getHeight() + 20;
	setSize(width, height);
    }
    
    public void open() {
	
	if (!getParent().isVisible()) {
	    getParent().setVisible(true);
	}
	
	setVisible(true);
	setFocus();
	isOpened = true;
    }
    
    protected void center() {
	if (isInternalShell()) {
	    if (getInternalShell().getParent() instanceof Shell) {
		SWTUtils.centerWindow((Shell) getInternalShell().getParent());
	    }
	} else if (getParent()  instanceof Shell) {
	    SWTUtils.centerWindow((Shell) getParent());
	}
    }
    
    protected boolean isInternalShell() {
	return getInternalShell() != null;
    }
    
     
    protected InternalShell getInternalShell() {
	Composite rootParent = getParent().getParent();
	if (rootParent == null) {
	    return null;
	}
	if (rootParent  instanceof InternalShell) {
	    return (InternalShell) rootParent;
	}
	return null;
    }
    
    public void setTitle(String title) {
	if (title == null) {
	    return;
	}
	if (shellPresentation != null) {
	    shellPresentation.setTitle(this, title);
	    return;
	}
	
	InternalShell ishell = getInternalShell();
	if (ishell != null) {
	    ishell.setText(title);
	} else if (getParent() instanceof Decorations) {
	    ((Decorations) getParent()).setText(title);
	}
    }
    
    public String getTitle() {
	InternalShell ishell = getInternalShell();
	if (ishell != null) {
	    return ishell.getText();
	} else if (getParent() instanceof Decorations) {
	    return ((Decorations) getParent()).getText();
	}
	return "";
	
    }    
    

    protected void initActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return;
	}
	initToolActions(getToolActions(actions));
	initDropDownActions(getDropDownActions(actions));
	initLinkActions(getLinkActions(actions));
    }


    ////
    
    protected void initToolActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return;
	}
	if (actionToolBarManager == null) {
	    actionToolBarManager = newToolBarManager();
	    coolBarManager.add(actionToolBarManager);
	}
	
	for (IAction action : actions) {
	    actionToolBarManager.add(createMenuAction(action));
	}
	
    }
    
    
    protected List<IAction> getToolActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return null;
	}
	List<IAction> outputActions = new ArrayList<IAction>();
	for (IAction action : actions) {
	    if (!isToolAction(action)) {
		continue;
	    }
	    outputActions.add(action);
	}
	return (outputActions.isEmpty()) ? null : outputActions;
    }

    protected boolean isToolAction(IAction action) {
	if (action == null) {
	    return false;
	}
	IActionDescriptor actionDescriptor = getForm().getActionDescriptor(action);
	if (actionDescriptor == null) {
	    return false;
	}
	return isControlType(actionDescriptor, "toolitem", "item") && isEmptyPosition(actionDescriptor);
    }
    
    protected boolean isMenuAction(IAction action) {
	if (action == null) {
	    return false;
	}
	IActionDescriptor actionDescriptor = getForm().getActionDescriptor(action);
	if (actionDescriptor == null) {
	    return false;
	}
	return isControlType(actionDescriptor, "menuitem", "item") && isEmptyPosition(actionDescriptor);
    }


    protected boolean isEmptyPosition(IActionDescriptor actionDescriptor) {
	if (actionDescriptor == null) {
	    return true;
	}
	String pos = actionDescriptor.getControlPosition();
	if (isEmpty(pos) || (!"first".equals(pos) && !"last".equals(pos) && !"before".equals(pos) && !"after".equals(pos))) {
	    return true;
	}
	String rel = actionDescriptor.getControlRelative();
	if (isEmpty(rel)) {
	    return true;
	}
	// TODO: Must analyze all GLOBAL ACTIONS ID 
	return false;
    }
    
    ////
 
    
    protected List<IAction> getDropDownActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return null;
	}
	List<IAction> outputActions = new ArrayList<IAction>();
	for (IAction action : actions) {
	    if (!isDropDownAction(action)) {
		continue;
	    }
	    outputActions.add(action);
	}
	return (outputActions.isEmpty()) ? null : outputActions;
    }

    protected boolean isDropDownAction(IAction action) {
	if (action == null) {
	    return false;
	}
	IActionDescriptor actionDescriptor = getForm().getActionDescriptor(action);
	if (actionDescriptor == null) {
	    return true;
	}
	String controlType= actionDescriptor.getControlType();
	return (controlType == null || isControlType(actionDescriptor, "dropdown", "link")); //TODO: link is tsub
    }

    
    protected List<IAction> getLinkActions(List<IAction> actions) {
	
	// TODO: Link actions are disabled
	return null;
	
	/*
	List<IAction> outputActions = new ArrayList<IAction>();
	for (IAction action : actions) {
	    if (!isLinkAction(action)) {
		continue;
	    }
	    outputActions.add(action);
	}
	return (outputActions.isEmpty()) ? null : outputActions;
	*/
    }

    protected boolean isLinkAction(IAction action) {
	return isControlType(action, "link");
    }


    
    protected void initDropDownActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return;
	}
	if (actionToolBarManager == null) {
	    actionToolBarManager = newToolBarManager();
	    coolBarManager.add(actionToolBarManager);
	}
	
	dropDownAction = createDropDownAction(Messages.getString("Form.actions"), ACTION_IMAGE, actions);
	actionToolBarManager.add(dropDownAction);
	
    }
    
    protected void initLinkActions(List<IAction> actions) {
	if (actions == null || actions.isEmpty()) {
	    return;
	}
	// TODO
    }
    

    
    
    protected boolean isControlType(IAction action, String... types) {
	if (action == null) {
	    return false;
	}
	IActionDescriptor actionDescriptor = getForm().getActionDescriptor(action);
	return isControlType(actionDescriptor, types);
    }

    protected boolean isControlType(IActionDescriptor actionDescriptor, String... types) {
	if (actionDescriptor == null) {
	    return false;
	}
	String controlType = actionDescriptor.getControlType();
	for (String type: types) {
	    if (type.equals(controlType)) {
		return true;
	    }
	}
	return false;
    }
    
    protected void updateActions() throws ApplicationException {
	//
    }
  
    
    public void updateMode() throws ApplicationException {
	updateActions();
    }
    
    protected void initSize(CoolItem coolItem, ToolBar toolBar) {
	SWTUtils.initSize(coolItem, toolBar);
    }
    
    protected void doExecute(IAction action) {
	if (action == null) {
	    return;
	}
	try {
	    action.execute();
	} catch (ApplicationException ex) {
	    logger.error(ex);
	}
    }
    
    public boolean setFormFocus() {
	IForm form = getForm();
	if (form == null) {
	    return false;
	}
	return form.setFocus();
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }
    
    protected Image getImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }

    public static Image getImage(Class klass, String path) {
	return SWTResourceManager.getImage(klass, path);
    }

    public static Image getResourceImage(String path) {
	return getImage(AbstractFormDecorator.class, path);
    }

    
    // UTIL METHODS
    
    protected CoolBar newCoolBar(Composite parent) {
	CoolBar coolBar = new CoolBar(parent, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);
	//CoolBar coolBar = new CoolBar(parent, SWT.FLAT);
	initCoolBar(coolBar);
	return coolBar;
    }

    protected ToolBarManager newToolBarManager() {
	return new ToolBarManager(SWT.FLAT | SWT.WRAP);
    }
    
    private int h = -1;
    
    protected void initCoolBar(final CoolBar coolBar) {
        coolBar.addListener(SWT.Resize, new Listener() {
	    public void handleEvent (Event event) {
		
		// We had problems on Linux when used "!isInitDecorator"
		// Buttons were invisible. But after resize dialog buttons are visible. 
		if (!isOpened) {
		    return;
		}
		if (coolBar.getSize().y != h) {
		    
		    //coolBar.getParent().getParent().layout();
		    //coolBar.getParent().getParent().getParent().layout(true, true);
		    
		    layout();
		    getParent().layout(true, true);

		    h = coolBar.getSize().y;
		}
	    }
	});
    }
    
    


    public ISWTShellPresentation getShellPresentation() {
        return shellPresentation;
    }

    public void setShellPresentation(ISWTShellPresentation shellPresentation) {
        this.shellPresentation = shellPresentation;
    }

    public boolean isForceUpdate() {
        return form == null ? false : form.isForceUpdate();
    }

    public void updateState() {
	
    }
    
    public void updateDataState() {
	
    }
    
    ////
    
    protected void setEnabled(ToolItem toolItem, boolean enabled) {
	if (toolItem == null) {
	    return;
	}
	toolItem.setEnabled(enabled);
	
	
    }
    
    protected void setEnabled(org.eclipse.jface.action.IAction action, boolean enabled) {
	if (action == null) {
	    return;
	}
	action.setEnabled(enabled);
    }

    //// SPECIAL FOR GLOBAL ACTIONS ////////////////////////////////////////////////////////////////////////////////////////////////
    
    public MenuItem createMenuItem(Menu menu, Image image, String text, final String action) {
	return createMenuItem(menu, SWT.CASCADE, image, text, action);
    }

    public MenuItem createMenuItem(Menu menu, org.eclipse.jface.action.IAction action) {
	return createMenuItem(menu, SWT.CASCADE, action.getImageDescriptor().createImage(), action.getText(), action.getId());
    }

    
    protected MenuItem createMenuItem(Menu menu, int style, Image image, String text, final String action) {
	final MenuItem menuItem = new MenuItem(menu, style);
	if (image != null) {
	    menuItem.setImage(image);
	}
    	menuItem.setText(text);
    	menuItem.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    actionOwner = menuItem;
		    try {
			doAction(action);
		    } finally {
			actionOwner = null;
		    }
		    
		}
	});
    	return menuItem;
    }

    private Object actionOwner;
    
    public Object getActionOwner() {
        return actionOwner;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   

    
    protected String getDecoratorTitle() {
	return null;
    }
    
   
    
    
    //////////////////////////////////////////////////////////////////////////////////
    
    
    protected CoolBar createCoolBar(Composite parent) {
	coolBar = newCoolBar(parent); //new CoolBar(parent, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);
	coolBarManager = new CoolBarManager(coolBar);
	return coolBar;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    protected ImageDescriptor getImageDescriptor(Class location, String filename) {
	return ImageDescriptor.createFromFile(location, filename); 
    }
    
    protected ImageDescriptor getImageDescriptor(Image image) {
	return ImageDescriptor.createFromImage(image); 
    }

    ////
    
    protected void doAddPositionAction(IContributionManager manager, String actionId, String position, String ... types) {
	if (!hasPostionActions()) {
	    return;
	}
	List<IActionDescriptor> descriptors = getActionDescriptors();
	for (IActionDescriptor actionDescriptor : descriptors) {
	    
	    if (isEmptyPosition(actionDescriptor)) {
		continue;
	    }
	    if (!position.equals(actionDescriptor.getControlPosition())) {
		continue;
	    }
	    if (!isControlType(actionDescriptor, types)) {
		continue;
	    }
	    
	    if (!actionId.equals(actionDescriptor.getControlRelative())) {
		continue;
	    }
	    
	    IAction a = actionDescriptor.getAction();
	    if (a == null) {
		continue;
	    }
	
	    org.eclipse.jface.action.IAction action = createMenuAction(a);
	    if (action == null) {
		continue;
	    }
	    manager.add(action);
	}
    }
    
    ////
    
    protected void doAddBeforeAction(IContributionManager manager, String actionId, String ... types) {
	doAddPositionAction(manager, actionId, "before", types);
    }

    protected void doAddAfterAction(IContributionManager manager, String actionId, String ... types) {
	doAddPositionAction(manager, actionId, "after", types);
    }
    
    ////
    
    protected void addAction(IToolBarManager toolBarManager, org.eclipse.jface.action.IAction action) {
	if (toolBarManager == null || action == null) {
	    return;
	}
	doAddBeforeAction(toolBarManager, action.getId(), "toolitem", "item");
	toolBarManager.add(action);
	doAddAfterAction(toolBarManager, action.getId(), "toolitem", "item");
    }
    
    protected void addAction(IToolBarManager toolBarManager, String actionId) {
	addAction(toolBarManager, getGlobalAction(actionId));
    }
    

    protected void addAction(IMenuManager menuManager, org.eclipse.jface.action.IAction action) {
	if (menuManager == null || action == null) {
	    return;
	}
	doAddBeforeAction(menuManager, action.getId(), "menuitem", "item");
	menuManager.add(action);
	doAddAfterAction(menuManager, action.getId(), "menuitem", "item");
    }
    
    protected void addAction(IMenuManager menuManager, String actionId) {
	addAction(menuManager, getGlobalAction(actionId));
    }
    
    protected org.eclipse.jface.action.IAction createAction(String id, String text, Image image) {
	return createAction(id, text, null, image);
    }
    
    protected org.eclipse.jface.action.IAction createAction(String id, String text, String toolTip, Image image) {
	if (id == null) {
	    return null;
	}
	Action action = new Action() {
	    public void run() {
		doAction(getId());
	    }
	};
	action.setId(id);
	if (text != null){
	    action.setText(text);
	}
	if (toolTip != null) {
	    action.setToolTipText(toolTip);
	}  else if (text != null) {
	    action.setToolTipText(text);
	}
	if (image != null) {
	    action.setImageDescriptor(getImageDescriptor(image));
	}
	return action;
	
    }

    protected org.eclipse.jface.action.IAction createDropDownAction(String text, Image image, List<IAction> actions) {
	
	// JFace Action
	DropDownAction dropDownAction = new DropDownAction();
	if (image != null) {
	    dropDownAction.setImageDescriptor(getImageDescriptor(image));
	}
	if (text != null) {
	    dropDownAction.setText(text);
	}
	
	if (actions == null || actions.isEmpty()) {
	    return dropDownAction;
	}
	for (IAction action : actions) {
	    dropDownAction.add(createMenuAction(action));
	}
	return dropDownAction;
    }

    protected org.eclipse.jface.action.IAction createMenuAction(final IAction a) {
	
	if (a == null) {
	    return null;
	}
	
	// JFace Action
	org.eclipse.jface.action.Action action = new org.eclipse.jface.action.Action() {
	    public void run() {
		doExecute(a);
	    }
	};
	String text = a.getText();
	if (!isEmpty(text)) {
	    action.setText(text);
	}
	String imageUrl = a.getImageUrl();
	if (!isEmpty(imageUrl)) {
	    Image image = getResourceImage(imageUrl);
	    if (image != null) {
		action.setImageDescriptor(getImageDescriptor(image));
	    }
	}
	return action;
    }
    
    public class DropDownAction extends org.eclipse.jface.action.Action implements IMenuCreator {

	private FixMenuManager menuManager1 = new FixMenuManager();
	private FixMenuManager menuManager2 = new FixMenuManager();

	private Menu menu1;
	private Menu menu2;

	public DropDownAction() {
	    super(null, AS_DROP_DOWN_MENU);
	    setMenuCreator(this);
	}

	public DropDownAction(String text) {
	    super(text, AS_DROP_DOWN_MENU);
	    setMenuCreator(this);
	}

	private IMenuManager getMenuManager1() {
	    return menuManager1;
	}
	
	private IMenuManager getMenuManager2() {
	    return menuManager2;
	}
	

	public void dispose() {
	    menuManager1.dispose();
	    menuManager2.dispose();
	}

	public Menu getMenu(Control parent) {
	    if (menu1 == null) {
		menu1 = menuManager1.createContextMenu(parent);
	    }
	    return menu1;
	}

	public Menu getMenu(Menu parent) {
	    if (menu2 == null) {
		menu2 = menuManager2.createMenu(parent);
	    }
	    return menu2;
	}

	public void add(org.eclipse.jface.action.IAction action) {
	    getMenuManager1().add(action);
	    getMenuManager2().add(action);
	}
    }
    
    
    protected void initSize(ToolBar toolBar){
	CoolBar cb = (CoolBar) toolBar.getParent();
	CoolItem[] items = cb.getItems();

	for (int i = 0; i < items.length; i++) {
		if (items[i].getControl() == toolBar) {
		    initSize(items[i], toolBar);
		}
	}
    }
    
    protected void setEnabledDropDownActions(boolean enabled) {
	if (dropDownAction == null) {
	    return;
	}
	dropDownAction.setEnabled(enabled);
    }
    
    protected boolean isEmpty(String str) {
	return StringUtils.isEmpty(str);
    }

}
