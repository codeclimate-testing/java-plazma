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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.nebula.widgets.pshelf.PShelf;
import org.plazmaforge.framework.client.Toolkit;
import org.plazmaforge.framework.client.app.RCPAbstractApplication;
import org.plazmaforge.framework.client.app.RCPApplication;
import org.plazmaforge.framework.client.forms.FormEnvironment;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.controls.ToolButton;
import org.plazmaforge.framework.client.swt.custom.ishell.DesktopForm;
import org.plazmaforge.framework.client.swt.custom.ishell.InternalShell;
import org.plazmaforge.framework.client.swt.custom.ishell.internal.DesktopListener;
import org.plazmaforge.framework.client.swt.layout.FormDataCreator;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.SystemInfo;


/** 
 * @author Oleh Hapon
 *
 */

public class SWTApplication extends RCPAbstractApplication<Composite, Menu, ToolBar, Composite> implements RCPApplication, IShellProvider {

    /**
     * Main Shell
     */
    protected Shell shell;  //  @jve:decl-index=0:visual-constraint="10,52"
    
     // Child shell (desktop emulate) Don't use
    protected Shell desktopShell;
    
    /**
     * Sash form
     */
    protected SashForm sashForm;
    
    /**
     * Tree menu
     */
    protected PShelf treeMenu;
    
    
    protected ToolButton treeMenuTool;
    
    
    /**
     * Desktop
     */
    protected DesktopForm desktop;
    
    /**
     * Tab folder for open windows 
     */
    protected CTabFolder tabShell;

    /**
     * Status label
     */
    protected Label statusLabel;
    
    /**
     * Application Builder
     */
    private SWTAppBuilder appBuilder;
    
    protected CoolBar coolBar;
    
    protected CoolItem coolItem;
    
    protected Menu contextMenu;
    
    
    protected Set<MenuItem> checkmenuItems;
    
    
    
    public static final String MENU_BAR_VISIBLE = "menu.bar.visible";
    
    public static final String TOOL_BAR_VISIBLE = "tool.bar.visible";
    
    public static final String TREE_MENU_VISIBLE = "tree.menu.visible";
    
    public static final String STATUS_BAR_VISIBLE = "status.bar.visible";
    
    public static final String DESKTOP_SHOW_TITLE = "desktop.ShowTitle";
    
    public static final String DESKTOP_AUTO_MAX_WINDOWS = "desktop.AutoMaxWindows";
    
    public static final String PAGINATION_IN_FROM = "form.pagination";
    
    
    private static final String MENU_ITEM_ID = "id";
    
    
    public SWTApplication() {
	super();
	initialize();
    }

    /**
     * Launch the application
     * @param args
     */
    public static void main(String[] args) {
	try {
	    SWTEnvironment.init();
	    SWTApplication app = new SWTApplication();
	    SWTEnvironment.setApplication(app);
	    app.startup(args);
	} catch (Exception e) {
	    logger.error("Application Error", e);
	}
    }

    public void run() {
	open();
    }
    /**
     * Open the window
     */
    public void open() {
	final Display display = Display.getDefault();
	
	shell.open();
	shell.layout();
	
	if (desktopShell != null) {
	    desktopShell.open();
	}
	shell.setActive();
	
	initTools();
	initForms();
	
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch())
		display.sleep();
	}
	exit();
    }

    /**
     * Create contents of the window
     */
    protected void initialize() {
	
	
	Composite composite;
	FillLayout fillLayout;
	appBuilder = new SWTAppBuilder();
	appBuilder.setApplication(this);
	
	GridLayout gridLayout;
	shell = new Shell();
	gridLayout = new GridLayout();
	gridLayout.horizontalSpacing = 0;
	
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
	gridLayout.marginWidth = 0;
	
	initGridLayout(gridLayout);
	
	shell.setLayout(gridLayout);
	shell.setText("SWT Application");
	shell.setSize(new Point(640, 480));
	shell.setMaximized(true);
	
	shell.addControlListener(new ControlListener() {
	    public void controlMoved(ControlEvent e) {
		desktopShellUpdate();
	    }

	    public void controlResized(ControlEvent e) {
		desktopShellUpdate();
	    }

	});
	
	// Create Menu Bar
	Menu menu = new Menu(getShell(), SWT.BAR);
	shell.setMenuBar(menu);
	this.menuBar = menu;

	composite = new Composite(shell, SWT.NONE);
	composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	fillLayout = new FillLayout();
	fillLayout.marginWidth = 2;
	composite.setLayout(fillLayout);

	//this.toolBar = new ToolBar(shell, SWT.NONE);
	
	// Create Cool Bar
	coolBar = newCoolBar(composite); //new CoolBar(composite, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);
	//coolBar.setLayout(new FillLayout());
	
	// Create Tool Bar
	this.toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
		
	coolItem = new CoolItem(coolBar, SWT.PUSH); //SWT.NONE SWT.PUSH
	coolItem.setControl(toolBar);
	
	// Create Content
	this.content = createContent();
	
	
	// ---------------------------------------------------------------
	// Create Sash Form
	this.sashForm = new SashForm(this.content, SWT.NONE);
	this.sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	
	// Create Tree Menu
	this.treeMenu = new PShelf(sashForm, SWT.BORDER);
    	
	// Create Desktop Composite
    	Composite desktopComposite = new Composite(sashForm, SWT.NONE);
    	
    	
	this.sashForm.setWeights(new int[] {1, 5 });
	// ---------------------------------------------------------------

	// Create Tab Shell
	this.tabShell = createTabShell();
	
	// Create Status Bar
	this.statusBar = createStatusBar();

	
	/*
	desktopShell = new Shell(shell, SWT.NO_TRIM);
	desktopShell.setSize(new Point(500, 375));
	
	desktopShell.addFocusListener(new FocusListener() {
	    
	    public void focusGained(FocusEvent e) {
		//shell.setFocus();
		//shell.setFocus()
		shell.setActive();
		
	    }
	    public void focusLost(FocusEvent e) {
		
	    }
	    
	    
	});
	*/
	
	sashForm.setFocus();
	
	initDesktop(desktopComposite);

    }
    
    protected void initTools() {
	
	checkMenuItems(MENU_BAR_VISIBLE, isVisibleMenuBar());
	checkMenuItems(TOOL_BAR_VISIBLE, isVisibleToolBar());
	checkMenuItems(TREE_MENU_VISIBLE, isVisibleTreeMenu());
	
	setVisibleMenuBar(getPreferenceBoolean(MENU_BAR_VISIBLE));
	setVisibleToolBar(getPreferenceBoolean(TOOL_BAR_VISIBLE));
	setVisibleTreeMenu(getPreferenceBoolean(TREE_MENU_VISIBLE));
	
	setShowMaximizedTitle(getPreferenceBoolean(DESKTOP_SHOW_TITLE));
	setAutoMaximize(getPreferenceBoolean(DESKTOP_AUTO_MAX_WINDOWS));

	initTool = true;
    }
    
    protected void initForms() {
	setPaginationInForm(getPreferenceBoolean(PAGINATION_IN_FROM, true));	
    }
    
    protected void initGridLayout(GridLayout gridLayout) {
	if (gridLayout == null) {
	    return;
	}
	if (SystemInfo.isWindows) {
	    return;
	}
	gridLayout.verticalSpacing = 0;
	gridLayout.marginHeight = 0;
    }
   
    private boolean isStartClosingShell;
    
    private boolean isStartActivatingShell;
    
    private int windowCount;    
    
    
    /**
     * Event when tab shell item close
     * @param item
     */
    protected void closeTabShellItem(CTabItem item) {
	InternalShell ishell = (InternalShell) item.getData();
	item.setData(null);
	if (shell != null) {
	    isStartClosingShell = true;
	    try {
		int index = getIndexOfInternalShell(ishell);
		if (index > -1) {
		    desktop.getShells()[index].close();
		}
	    } finally {
		isStartClosingShell = false;
	    }
	}
	checkTabShell();
    }
 
    /**
     * Event when tab shel item select
     * @param item
     */
    protected void selectedTabShellItem(CTabItem item) {
	InternalShell ishell = (InternalShell) item.getData();
	if (shell != null) {
	    isStartActivatingShell = true;
	    try {
		int index = getIndexOfInternalShell(ishell);
		if (index > -1) {
		    desktop.getShells()[index]. setActive();
		}
	    } finally {
		isStartActivatingShell = false;
	    } 
	}
    }
    
    /**
     * Returns index of internal shell
     * @param ishell
     * @return
     */
    protected int getIndexOfInternalShell(InternalShell ishell) {
	InternalShell[] shells = desktop.getShells();
	for (int i = 0; i < shells.length; i++) {
	    if (ishell == shells[i]) {
		return i;
	    }
	}
	return -1;
    }
 
    /**
     * Create new tab shell item 
     * @param internalShell
     * @return
     */
    protected CTabItem createTabShellItem(InternalShell internalShell) {
	
	CTabItem tabItem = new CTabItem(this.tabShell, SWT.NONE);
	windowCount++;
	String text = internalShell.getText();
	if (text == null) {
	    text = "Window " + windowCount;
	}
	tabItem.setText(text);
	tabItem.setData(internalShell);
	
	setTabShellVisible(true);
	return tabItem;
    }
    
    /**
     * Create Tab Shell
     * @return
     */
    protected CTabFolder createTabShell() {
	CTabFolder tabFolder = new CTabFolder(shell, SWT.CLOSE | SWT.FLAT);
	tabFolder.addCTabFolder2Listener(new CTabFolder2Adapter() {
		public void close(CTabFolderEvent e) {
		    CTabItem item = (CTabItem) e.item;
		    closeTabShellItem(item);
		}
	});
	
	tabFolder.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
		    CTabItem item = (CTabItem) e.item;
		    selectedTabShellItem(item);
		}
	});
	
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.heightHint = 0;
	gridData.exclude = true;
	tabFolder.setLayoutData(gridData);
	tabFolder.setVisible(false);

	return tabFolder;

    }
    
    /**
     * Set visible status of Tab Shell
     * @param visible
     */
    protected void setTabShellVisible(boolean visible) {
	if (this.tabShell.isVisible() == visible) {
	    return;
	}
	((GridData)this.tabShell.getLayoutData()).exclude = !visible;
	this.tabShell.setVisible(visible);
	this.shell.layout(new Control[] {this.tabShell});
    }
    
    /**
     * Check Tab Shell. If the tab shell doesn't have items then disable.
     *
     */
    protected void checkTabShell() {
	if (this.tabShell.getItemCount() <= 1) {
	   this.setTabShellVisible(false); 
	}	
    }
    
    /**
     * Initialize <code>DesktopForm</code>
     *
     */
    protected void initDesktop(Composite parent) {
	FormLayout layout = new FormLayout();
	layout.spacing = 0;
	layout.marginWidth = 0;
	layout.marginHeight = 0;
	//this.content.setLayout(layout);
	parent.setLayout(layout);
	
	
	//CustomSeparator sep = new CustomSeparator(this.content, SWT.HORIZONTAL);
	//sep.setLayoutData(FormDataCreator.createFormData(sep, "0, 1, 0"));
	   
	this.desktop = new DesktopForm(parent, SWT.NONE);
        desktop.setShowMaximizedTitle(false);
        desktop.setAutoMaximize(true);
        //desktop.se
	desktop.setLayoutData(FormDataCreator.createFormData(desktop, "0, 1, :prev, 1"));
	    
	//Display display = Display.getDefault();
	//iconImage = new Image(display, InternalShellExampleSWT.class.getResourceAsStream("ishell.png"));
	
	// DISABLE IMAGE
	/*
	Image backgroundImage = new Image(display, InternalShellExampleSWT.class.getResourceAsStream("IMG_2006-a-fixed-seamless.jpg"));
	    
	// Add a background image to the DesktopForm
	final ScaledImage si = new ScaledImage(desktop, SWT.NONE);
	si.setImage(backgroundImage);
	si.setImagePlacement(ScaledImage.IMAGE_PLACEMENT_TILE);
	// Note: Don't set a layout on a DesktopForm
	si.setLocation(0, 0);
	si.setSize(desktop.getSize());
	*/
	
	
	desktop.addListener(SWT.Resize, new Listener() {
	      public void handleEvent(Event event) {
	        //si.setSize(desktop.getSize()); // DISABLE IMAGE
	      }
	});
	
	desktop.addDesktopListener(new DesktopListener()
	    {
	      public void shellCreated(Event event) {
		  desktopShellCreated((InternalShell) event.widget);
	      }

	      public void shellDisposed(Event event) {
		  desktopShellDisposed((InternalShell) event.widget);
	      }

	      public void shellActivated(Event event) {
		  desktopShellActivated((InternalShell) event.widget);
	      }
	    });
	
    }
    
    /**
     * Event when shell created
     * @param ishell
     */
    protected void desktopShellCreated(InternalShell ishell) {
	if (ishell == null) {
	    return;
	}	
	CTabItem item = createTabShellItem(ishell);
	this.tabShell.setSelection(item);
    }
    
    /**
     * Event when shell disposed
     * @param ishell
     */
    protected void desktopShellDisposed(InternalShell ishell) {
	if (ishell == null) {
	    return;
	}	
	if (isStartClosingShell) {
	    return;
	}
	checkTabShell();
	CTabItem item = getTabShelItem(ishell);
	if (item != null && !item.isDisposed()) {
	    item.dispose();
	}
    }
  
    /**
     * Event when shell activated
     * @param ishell
     */
    protected void desktopShellActivated(InternalShell ishell) {
	
	if (ishell == null) {
	    return;
	}
	
	if (isStartActivatingShell) {
	    return;
	}
	if (desktop.getAutoMaximize()) {
	    ishell.setMaximized(true);
	}
	
	
	CTabItem item = getTabShelItem(ishell);
	if (item != null) {
	    this.tabShell.setSelection(item);
	    String title = ishell.getText();
	    if (title != null) {
		item.setText(title);
	    }
	}	
    }  
    
    protected CTabItem getTabShelItem(InternalShell ishell) {
	CTabItem[] items = this.tabShell.getItems();
	if (items == null || items.length == 0) {
	    return null;
	}
	for (int i = 0; i < items.length; i++) {
	    CTabItem item = items[i];
	    InternalShell is = (InternalShell) item.getData();
	    if (ishell == is) {
		return item;
	    }
	}
	return null;
    }
    
    
    protected void desktopShellUpdate() {
	if (desktopShell == null) {
	    return;
	}
	Point location = shell.getLocation();
	Point size = shell.getSize();
	Rectangle clientArea = shell.getClientArea();

	int margin = ((GridLayout)shell.getLayout()).verticalSpacing + 1;
	int inc = 0;
	int d = (size.x - clientArea.width) / 2;
	int x = location.x + d + inc;
	int y = location.y + (size.y - clientArea.height - d) + toolBar.getSize().y + inc + margin;// (+6)

	int width =  clientArea.width - inc * 2;
	int height =  clientArea.height - toolBar.getSize().y - statusBar.getSize().y - inc * 2 - margin * 2;// (-12)
	
	desktopShell.setBounds(x, y, width, height);
	
    }
    
    protected SWTAppBuilder getAppBuilder() {
	return appBuilder;
    }
    
    protected Menu createMenuBar() {
	return getAppBuilder().createMenuBar();
    }
    
    protected Menu createContextMenu() {
	return getAppBuilder().createContextMenu();
    }
    
    protected ToolBar createToolBar() {
	return getAppBuilder().createToolBar();
    }
    
    protected Composite createStatusBar() {
	return getAppBuilder().createStatusBar();
    }
    
    protected Composite createContent() {
	return getAppBuilder().createContent();
    }
    
    protected PShelf createTreeMenu() {
	return getAppBuilder().createTreeMenu();
    }
    
    public String getTitle() {
	return (shell == null) ? null : shell.getText();
    }
    
    public void setTitle(String title) {
	if (shell == null) {
	    return;
	}
	shell.setText(title);
    }
    
    public String getStatusText() {
	return statusLabel == null ? null : statusLabel.getText(); 
    }
    
    public void setStatusText(String text) {
	if (statusLabel == null) {
	    return;
	}
	statusLabel.setText(text);
	statusBar.layout();
    }
    
    public Shell getShell() {
	return shell;
    }
    
    protected void setStatusLabel(Label statusLabel) {
	this.statusLabel = statusLabel; 
    }
    
     
    protected void systemExit() {
	getShell().dispose();
	super.systemExit();
    }
    
    protected void errorMessage(Throwable e) {
	Toolkit.openErrorDialog(e);
    }

    
    protected void errorMessage(String message) {
	Toolkit.openErrorDialog("System Error", message);
    }
    
    /**
     * Initialize components of the application
     * @throws ApplicationException
     */
    protected void initComponents() throws ApplicationException {
	//initUI();
	if (getAppManager() != null) getAppManager().initComponents();
	initUI();
    }    

    protected void initUI() {
	createMenuBar();
	createToolBar();
	createTreeMenu();
	
	createContextMenu();
    }
    
    protected void initEnvironment() {
        super.initEnvironment();
        //SWTEnvironment.setApplication(this);
    }


    public Shell getDesktopShell() {
	if (desktopShell == null) {
	    return shell;
	}
	return desktopShell;
    }

    public DesktopForm getDesktop() {
        return desktop;
    }
    

    public boolean isVisibleMenuBar() {
	return shell != null && shell.getMenuBar() != null; 
    }
    
    public boolean isVisibleToolBar() {
	return coolBar != null  && coolBar.isVisible(); 
    }
    
    public boolean isVisibleTreeMenu() {
	return treeMenu != null  && treeMenu.isVisible(); 
    }
    
    public boolean isVisibleStatusBar() {
	return getStatusBar() == null ? false : getStatusBar().isVisible(); 
    }

    
    public void setVisibleMenuBar(boolean visible) {
	if (getMenuBar() == null) {
	    return; 
	}
	if (shell == null) {
	    return;
	}
	if (visible) {
	    shell.setMenuBar(getMenuBar());
	    shell.layout();
	} else {
	    shell.setMenuBar(null);
	    shell.layout();
	}
	
	checkMenuItems(MENU_BAR_VISIBLE, visible);
    }

    public void viewMenuBar() {
	if (getMenuBar() == null) {
	    return; 
	}
	if (shell == null) {
	    return;
	}
	boolean visible = shell.getMenuBar() != null;
	setVisibleMenuBar(!visible);
    }
    
    public void setVisibleToolBar(boolean visible) {
	if (coolBar == null) {
	    return; 
	}
	
	setVisibleControl(coolBar, visible); 
	Composite parent = coolBar.getParent();
	parent.layout();
	
	setVisibleControl(parent, visible); 
	parent.getParent().layout();

	checkMenuItems(TOOL_BAR_VISIBLE, visible);
    }
    
    public void viewToolBar() {
	if (coolBar == null) {
	    return; 
	}
	setVisibleToolBar(!coolBar.isVisible());
    }
    
    
    
    public void setVisibleTreeMenu(boolean visible) {
	if (treeMenu == null) {
	    return;
	}
	treeMenu.setVisible(visible);
	sashForm.layout();
	updateTreeMenuTool();
	checkMenuItems(TREE_MENU_VISIBLE, visible);
    }
    
    public void viewTreeMenu() {
	if (treeMenu == null) {
	    return;
	}
	setVisibleTreeMenu(!treeMenu.isVisible());
    }
    
    public void updateTreeMenuTool() {
	treeMenuTool.setToolTipText(getTreeMenuLabelToolTip());
    }
    
    protected String getTreeMenuLabelToolTip() {
	if (treeMenu == null || sashForm == null) {
	    return "";
	}
	return treeMenu.isVisible() ? Messages.getString("SWTAppBuilder.HideTreeMenu") : Messages.getString("SWTAppBuilder.ShowTreeMenu"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    ////----
    protected void setVisibleControl(Control control, boolean visible) {
	if (control == null) {
	    return;
	}
	control.setVisible(visible);
	if (control.getLayoutData() instanceof GridData) {
	    ((GridData) control.getLayoutData()).exclude = !visible;
	}
    }

    
    ////
    
    public void setShowMaximizedTitle(boolean b) {
	 getDesktop().setShowMaximizedTitle(b);
	 checkMenuItems(DESKTOP_SHOW_TITLE, b);
    }
    
    public boolean isShowMaximizedTitle() {
	 return getDesktop().getShowMaximizedTitle();
   }
    
    
    public void setAutoMaximize(boolean b) {
	 getDesktop().setAutoMaximize(b);
	 checkMenuItems(DESKTOP_AUTO_MAX_WINDOWS, b);
    }
    
    public boolean isAutoMaximize() {
	 return getDesktop().getAutoMaximize();
   }
    
    public void setPaginationInForm(boolean b) {
	FormEnvironment.setPagination(b);
	setPreference(PAGINATION_IN_FROM, b ? "true" : "false");
    }
    
    public boolean isPaginationInForm() {
	return FormEnvironment.isPagination();
    }
    
    
    
    ////----
    public Set<MenuItem> getCheckMenuItems() {
	 if (checkmenuItems == null) {
	     checkmenuItems = new HashSet<MenuItem>();
	 }
	 return checkmenuItems;
    }
     
     public void addCheckMenuItem(MenuItem item) {
	 getCheckMenuItems().add(item);
     }
     
     public void addCheckMenuItem(MenuItem item, String id) {
	 item.setData(MENU_ITEM_ID, id);
	 addCheckMenuItem(item);
     }
     
     public Set<MenuItem> getCheckMenuItems(String id) {
	 Set<MenuItem> items = getCheckMenuItems();
	 Set<MenuItem> result = new HashSet<MenuItem>();
	 for (MenuItem item: items) {
	     if (id.equals(item.getData(MENU_ITEM_ID))) {
		 result.add(item);
	     }
	 }
	 return result;
     }
     
     public void checkMenuItems(Set<MenuItem> items, boolean check) {
	 for (MenuItem item: items) {
	     item.setSelection(check);
	 }
     }
     
     
     public void checkMenuItems(String id, boolean check) {
	 Set<MenuItem> items = getCheckMenuItems(id);
	 checkMenuItems(items, check);
	 
	 if (!initTool) {
	     return;
	 }
	 setPreference(id, check ? "true" : "false");
     }

     ////----
     protected Properties preferences;
     
     private List<PreferencesListener> preferenceListneteners = new ArrayList<PreferencesListener>();
     
     
     protected String preferencesFileName;
     
     protected boolean modifyPreferences;
     
     protected boolean initTool;
     
     
     
     
     public String getPreferencesFileName() {
	 if (preferencesFileName == null) {
	     preferencesFileName = System.getProperty("user.dir") + "/.preferences";
	 }
        return preferencesFileName;
    }

    public void loadPreferences() throws ApplicationException {
	preferences = new Properties();
	try {
	    String fileName = getPreferencesFileName();
	    File file = new File(fileName);
	    if (file.exists()) {
		preferences.load(new FileInputStream(file));
		fireLoadPreferences();
	    }
	    initDefaultPreferences();
	} catch (Exception ex) {
	    throw new ApplicationException(ex);
	}
     }
     
     public void storePreferences() throws ApplicationException {
	 
	 if (preferences == null || !modifyPreferences) {
	     return;
	 }
	 try {
	     String fileName = getPreferencesFileName();
	     preferences.store(new FileOutputStream(fileName), "Plazma Preferences");
	     fireStorePreferences();

	 } catch (Exception ex) {
	     throw new ApplicationException(ex);
	 }
     }
     
     public void addPreferencesListener(PreferencesListener l) {
	preferenceListneteners.add(l); 
     }

     public void removePreferencesListener(PreferencesListener l) {
	preferenceListneteners.remove(l); 
     }
     
     protected void fireLoadPreferences() {
	 for (PreferencesListener l :preferenceListneteners) {
	     l.loadPreferences(preferences);
	 }
     }
     
     protected void fireStorePreferences() {
	 for (PreferencesListener l :preferenceListneteners) {
	     l.storePreferences(preferences);
	 }
     }
     
     protected void fireModifyPreferences() {
	 for (PreferencesListener l :preferenceListneteners) {
	     l.modifyPreferences(preferences);
	 }
     }  

     public void updatePreferences() {
	 fireModifyPreferences();
     }
     
     protected void initDefaultPreferences() {
	 if (preferences == null) {
	     return;
	 }
	 setDefaultPreference(MENU_BAR_VISIBLE, "true");
	 setDefaultPreference(TOOL_BAR_VISIBLE, "true");
	 setDefaultPreference(TREE_MENU_VISIBLE, "true");
	 
	 setDefaultPreference(DESKTOP_SHOW_TITLE, "false");
	 setDefaultPreference(DESKTOP_AUTO_MAX_WINDOWS, "true");
     }
     
     public void setPreference(String name, String value) {
	 preferences.put(name, value);
	 modifyPreferences = true;
     }
     
     public boolean isPreference(String name) {
	 return preferences.get(name) != null;
     }

     public boolean getPreferenceBoolean(String name) {
	 return "true".equals(preferences.get(name));
     }

     public boolean getPreferenceBoolean(String name, boolean defValue) {
	 Object value = preferences.get(name);
	 if (value == null) {
	     return defValue;
	 }
	 return "true".equals(value);
     }

     public void setDefaultPreference(String name, String value) {
	 if (!isPreference(name)) {
	     setPreference(name, value);
	 }

     }
     
     public void importPreferences() {
	 
     }
     
     public void exportPreferences() {
	 
     }
     
     
     public void load() throws ApplicationException {
	 super.load();
	 loadPreferences();
     }
     
     public void exit() {
	 try {
	     storePreferences();
	 } catch (Throwable e) {
	     logError(e);
	 }
	 super.exit();
     }
     
     
     // UTIL METHODS
     
     protected CoolBar newCoolBar(Composite parent) {
 	CoolBar coolBar = new CoolBar(parent, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);
 	initCoolBar(coolBar);
 	return coolBar;
     }
     
     
     protected void initCoolBar(final CoolBar coolBar) {
         coolBar.addListener(SWT.Resize, new Listener() {
 	    public void handleEvent (Event event) {
 		coolBar.getParent().getParent().layout();
 	    }
 	});
     }

     
    
}
