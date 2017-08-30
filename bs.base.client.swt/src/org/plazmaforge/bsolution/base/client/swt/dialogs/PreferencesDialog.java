package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.plazmaforge.framework.client.swt.SWTEnvironment;
import org.plazmaforge.framework.client.swt.app.SWTApplication;

public class PreferencesDialog extends TitleAreaDialog {

    
    public static final String GUI_PANEL = "GUI_PANEL";
    
    public static final String FORMS_PANEL = "FORMS_PANEL";

    
    private List<PanelInfo> panelInfoList;
    
    private Tree tree;
    
    private String currentPanelId;
    
    
    private Composite commonPanel;
    
    private ItemPanel guiPanel;
    
    private ItemPanel formsPanel;

    
  
    public PreferencesDialog(Shell shell) {
	super(shell);
    }
    
    protected void configureShell(Shell shell) {
	super.configureShell(shell);
	shell.setText(Messages.getString("PreferencesDialog.title"));
    }
    

    protected Control createDialogArea(Composite parent) {
	Composite comp = (Composite) super.createDialogArea(parent);

        SashForm sash = new SashForm(comp, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.widthHint = 300;
        gd.heightHint = 300;
        sash.setLayoutData(gd);
        
        tree = new Tree(sash, SWT.BORDER);
        
        initPanelInfo();
        initTree();
        
        commonPanel = new Composite(sash, SWT.BORDER);
        commonPanel.setLayout(new GridLayout());
        
        sash.setWeights(new int[] {30, 70});
     
        tree.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
        	if (!isInit) {
        	    return;
        	}
        	TreeItem treeItem = (TreeItem) e.item;
        	doSelection((String) treeItem.getData());
            }
        });
        
        init();
        
        loadData();
        
        return comp;
    }
    
    protected void okPressed() {
	storeData();
	super.okPressed();
    }
    
    private boolean isInit;
    
    public void init() {
	if (isInit) {
	    return;
	}
	isInit = true;
	tree.setSelection(tree.getItem(0));
        doSelection(GUI_PANEL);
    }
    
    private void initPanelInfo() {
	addPanelInfo(GUI_PANEL, Messages.getString("PreferencesDialog.gui"));
	addPanelInfo(FORMS_PANEL, Messages.getString("PreferencesDialog.forms"));
	
	setPanelInfoVisible(GUI_PANEL, true);
	setPanelInfoVisible(FORMS_PANEL, true);
    }

    
    private void initTree() {
	List<PanelInfo> items = getVisiblePanelInfoList();
	tree.setItemCount(items.size());
	for (int i = 0; i < items.size(); i++) {
	    TreeItem treeItem = tree.getItem(i);
	    PanelInfo panelInfo = items.get(i);
	    treeItem.setData(panelInfo.id);
	    treeItem.setText(panelInfo.name);
	}
	
    }
    
    private void setPanelInfoVisible(String id, boolean visible) {
	if (id == null) {
	    return;
	}
	List<PanelInfo> items = getPanelInfoList();
	if (items == null || items.isEmpty()) {
	    return;
	}
	for (PanelInfo panelInfo : items) {
	    if (id.equals(panelInfo.id)) {
		panelInfo.visible = visible;
		return;
	    }
	}
    }

    

    private List<PanelInfo> getPanelInfoList() {
	if (panelInfoList == null) {
	    panelInfoList = new ArrayList<PanelInfo>();
	}
        return panelInfoList;
    }

    private List<PanelInfo> getVisiblePanelInfoList() {
	List<PanelInfo> list = getPanelInfoList();
	List<PanelInfo> result = new ArrayList<PanelInfo>();
	for (PanelInfo panelInfo : list) {
	    if (panelInfo.visible) {
		result.add(panelInfo);
	    }
	}
	return result;
	
    }
    private void addPanelInfo(PanelInfo panelInfo) {
	getPanelInfoList().add(panelInfo);
    }

    private void addPanelInfo(String id, String name) {
	PanelInfo panelInfo = new PanelInfo();
	panelInfo.id = id;
	panelInfo.name = name;
	addPanelInfo(panelInfo);
    }

    ////
    
    private void doSelection(String panelId) {
	if (panelId == null) {
	    return;
	}
	if (panelId.equals(currentPanelId)) {
	    return;
	}
	currentPanelId = panelId;
	
	hidePanels();
	if (GUI_PANEL.equals(panelId)) {
	    showGUIPanel();
	} else  if (FORMS_PANEL.equals(panelId)) {
	    showFormsPanel();
	}
    }
    
    private void hidePanels() {
	hidePanel(guiPanel);
	hidePanel(formsPanel);
    }
    
    
    private void setVisible(Control control, boolean visible) {
	if (control == null) {
	    return;
	}
	control.setVisible(visible);
	Object layoutData = control.getLayoutData();
	if (!(layoutData instanceof GridData)) {
	    return;
	}
	((GridData) layoutData).exclude = !visible;
    }

    
    private void hidePanel(Composite panel) {
	if (panel == null) {
	    return;
	}
	setVisible(panel, false);
    }
    
    private void showGUIPanel() {
	if (guiPanel == null) {
	    guiPanel = createGUIPanel(commonPanel);
	} else {
	    setVisible(guiPanel, true);
	}
	commonPanel.layout();
	commonPanel.getParent().layout();
    }
    
    private void showFormsPanel() {
	if (formsPanel == null) {
	    formsPanel = createFormsPanel(commonPanel);
	} else {
	    setVisible(formsPanel, true);
	}
	commonPanel.layout();
	commonPanel.getParent().layout();
    }
    
    ////
    
    private ItemPanel createGUIPanel(Composite parent) {
	ItemPanel panel = new GUIPanel(parent, Messages.getString("PreferencesDialog.gui"));
	return panel;
    }

    private ItemPanel createFormsPanel(Composite parent) {
	ItemPanel panel = new FormsPanel(parent, Messages.getString("PreferencesDialog.forms"));
	return panel;
    }
    
    ////
    
    class PanelInfo {
	
	String id;
	
	String name;
	
	boolean visible = true;
    }

    
    class ItemPanel extends Composite {

	    
	    public ItemPanel(Composite parent, String title) {
		super(parent, SWT.NONE);

		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setLayout(new GridLayout());

		createTitle(title);
		createContent(this);

		loadData();
	    }

	    protected void createTitle(String title) {
		Label label = new Label(this, SWT.NONE);
		label.setText(title);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	    }

	    protected Composite createContent(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		content.setLayout(new GridLayout());
		return content;
	    }

	    protected Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(text);
		button.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		return button;
	    }
	    
	    protected void createContent() {

	    }

	    public void loadData() {

	    }

	    public void storeData() {

	    }
	    
	}

    ////
    
    class GUIPanel extends ItemPanel {
	
	private Button visibleMenuBarField;
	
	private Button visibleToolBarField;
	
	private Button visibleTreeMenuField;
	    
	private Button showWindowTitleField;
	
	private Button autoMaxWindowField;
	    
	    
	
	public GUIPanel(Composite parent, String title) {
	    super(parent, title);
	}

	protected Composite createContent(Composite parent) {
	    Composite content = super.createContent(parent);
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 1;
	    layout.horizontalSpacing = 0;
	    layout.verticalSpacing = 0;

	    content.setLayout(layout);


	    visibleMenuBarField = new Button(content, SWT.CHECK);
	    visibleMenuBarField.setText(Messages.getString("PreferencesDialog.visibleMenuBar"));
	    
	    visibleToolBarField = new Button(content, SWT.CHECK);
	    visibleToolBarField.setText(Messages.getString("PreferencesDialog.visibleToolBar"));
	    
	    visibleTreeMenuField = new Button(content, SWT.CHECK);
	    visibleTreeMenuField.setText(Messages.getString("PreferencesDialog.visibleTreeMenu"));
	    
	    new Label(content, SWT.NONE);
	    
	    showWindowTitleField = new Button(content, SWT.CHECK);
	    showWindowTitleField.setText(Messages.getString("PreferencesDialog.showWindowTitle"));
	    
	    autoMaxWindowField = new Button(content, SWT.CHECK);
	    autoMaxWindowField.setText(Messages.getString("PreferencesDialog.autoMaxWindows"));
	    
	    return content;
	}
	
	 public void loadData() {
	     SWTApplication app = getApplication();
	     if (app == null) {
		 return;
	     }
	     visibleMenuBarField.setSelection(app.isVisibleMenuBar());
	     visibleToolBarField.setSelection(app.isVisibleToolBar());
	     visibleTreeMenuField.setSelection(app.isVisibleTreeMenu());
	     
	     ////
	     
	     showWindowTitleField.setSelection(app.isShowMaximizedTitle());
	     autoMaxWindowField.setSelection(app.isAutoMaximize());
	 }

	 public void storeData() {
	     SWTApplication app = getApplication();
	     if (app == null) {
		 return;
	     }
	     app.setVisibleMenuBar(visibleMenuBarField.getSelection());
	     app.setVisibleToolBar(visibleToolBarField.getSelection());
	     app.setVisibleTreeMenu(visibleTreeMenuField.getSelection());

	     ////
	     
	     app.setShowMaximizedTitle(showWindowTitleField.getSelection());
	     app.setAutoMaximize(autoMaxWindowField.getSelection());
	 }
    }
    
    class FormsPanel extends ItemPanel {
	
	
	private Button paginationInListFormField;
	
	public FormsPanel(Composite parent, String title) {
	    super(parent, title);
	}

	protected Composite createContent(Composite parent) {
	    Composite content = super.createContent(parent);
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 1;
	    layout.horizontalSpacing = 0;
	    layout.verticalSpacing = 0;

	    content.setLayout(layout);


	    paginationInListFormField = new Button(content, SWT.CHECK);
	    paginationInListFormField.setText(Messages.getString("PreferencesDialog.pagination"));
	    
	    return content;
	}
	
	
	 public void loadData() {
	     SWTApplication app = getApplication();
	     if (app == null) {
		 return;
	     }
	     paginationInListFormField.setSelection(app.isPaginationInForm());
	 }

	 public void storeData() {
	     SWTApplication app = getApplication();
	     if (app == null) {
		 return;
	     }
	     app.setPaginationInForm(paginationInListFormField.getSelection());
	 }
    }

    /////////////////////////////////////////////////////////////
    
    
    protected SWTApplication getApplication() {
	return SWTEnvironment.getApplication();
    }
    
    /////////////////////////////////////////////////////////////
    
    protected void loadData() {
	if (guiPanel != null) guiPanel.loadData();  
	if (formsPanel != null) formsPanel.loadData();
    }

    protected void storeData() {
	if (guiPanel != null) guiPanel.storeData();  
	if (formsPanel != null) formsPanel.storeData();
	
	SWTApplication app = getApplication();
	if (app == null) {
	    return;
	}
	app.updatePreferences();	     
    }

}
