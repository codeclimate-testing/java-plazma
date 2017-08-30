package org.plazmaforge.bsolution.base.client.swt.dialogs;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.plazmaforge.bsolution.base.client.swt.ConfigApplication;

public class ConfigPanel extends Composite {

    public static final String CLIENT_CONF_FILE = "client.conf";
    
    ////
    
    public static final String GENERAL_PANEL = "GENERAL_PANEL";
    
    public static final String PROPERTIES_PANEL = "PROPERTIES_PANEL";
    
    public static final String CLASSPATH_PANEL = "CLASSPATH_PANEL";
    
    public static final String JDBC_PANEL = "JDBC_PANEL";
    
    public static final String JNDI_PANEL = "JNDI_PANEL";
    
    public static final String RMI_PANEL = "RMI_PANEL";    
    
    ////
    
    public static final String DEFAULT_PANEL = GENERAL_PANEL;
    
    ////
    
    public static final String GENERAL_PANEL_TITLE = Messages.getString("ConfigPanel.general");
    
    public static final String PROPERTIES_PANEL_TITLE = Messages.getString("ConfigPanel.properties");
    
    public static final String CLASSPATH_PANEL_TITLE = Messages.getString("ConfigPanel.classpath");
    
    public static final String JDBC_PANEL_TITLE = Messages.getString("ConfigPanel.jdbc");
    
    public static final String JNDI_PANEL_TITLE = Messages.getString("ConfigPanel.jndi");
    
    public static final String RMI_PANEL_TITLE = Messages.getString("ConfigPanel.rmi");
    
    
    
    
    private boolean isInit = false;
    
    private Tree tree;
    
    ////
    
    private Composite commonPanel;
    
    ////
    
    private ItemPanel generalPanel;
    
    private ItemPanel propertiesPanel;
    
    private ItemPanel classpathPanel;
    
    private ItemPanel jdbcPanel;
    
    private ItemPanel jndiPanel;
    
    private ItemPanel rmiPanel;
    
    ////
    
    private boolean exit;
    
    private String currentPanelId;
    
    private List<PanelInfo> panelInfoList;
    
    ////
    
    private boolean supportJDBC;
    
    private boolean supportJNDI;
    
    private boolean supportRMI;
    
    
    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public ConfigPanel(Composite parent, int style) {
	
	super(parent, style);
	setLayout(new GridLayout());
	
        SashForm sash = new SashForm(this, SWT.NONE);
        sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        tree = new Tree(sash, SWT.BORDER);
        
        initClient();
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
        
        createToolBar();
    }
    
    private Composite createToolBar() {
	Composite bar = new Composite(this, SWT.NONE);
	GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	bar.setLayoutData(gridData);
	GridLayout layout = new GridLayout(); 
	layout.numColumns = 2;
	bar.setLayout(layout);
	Button okButton = new Button(bar, SWT.NONE);
	okButton.setText("Save");
	okButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
        	doOkAction();
            }
	});  
	gridData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
	gridData.widthHint = 80;
	okButton.setLayoutData(gridData);
	Button cancelButton = new Button(bar, SWT.NONE);
	cancelButton.setText("Cancel");
	cancelButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
        	doCancelAction();
            }
	}); 	
	gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
	gridData.widthHint = 80;
	cancelButton.setLayoutData(gridData);
	return bar;
    }
    
    protected void doOkAction() {
	storeData();
	exit = true;
    }
    
    protected void doCancelAction() {
	exit = true;
    }
    
    public void init() {
	if (isInit) {
	    return;
	}
	isInit = true;
	tree.setSelection(tree.getItem(0));
        doSelection(DEFAULT_PANEL);
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

    private void initClient() {
	
	supportJDBC = false;
	supportJNDI = false;
	supportRMI = false;
	    
	String rootDir = ConfigApplication.getRootDir();
	String clientFileName = rootDir + "/" + CLIENT_CONF_FILE;
	File file = new File(clientFileName);
	if (!file.exists()) {
	    supportJDBC = true;
	    return;
	}
	Properties prop = new Properties();
	try {
	    prop.load(new FileInputStream(clientFileName));
	    String clientType = prop.getProperty("plazma.client.type");
	    if (clientType == null) {
		supportJDBC = true;
		return;
	    }
	    if (clientType.startsWith("lite")) {
		supportRMI = true;
	    } else if ((clientType.startsWith("ejb"))) {
		supportJNDI = true;
	    } else {
		supportJDBC = true;
	    }
	} catch (Exception ex) {
	    supportJDBC = true;
	    supportJNDI = false;
	    supportRMI = false;
	    ex.printStackTrace();
	}
	
	
    }

    private void initPanelInfo() {
	addPanelInfo(GENERAL_PANEL, GENERAL_PANEL_TITLE);
	addPanelInfo(PROPERTIES_PANEL, PROPERTIES_PANEL_TITLE);
	addPanelInfo(CLASSPATH_PANEL, CLASSPATH_PANEL_TITLE);
	addPanelInfo(JDBC_PANEL, JDBC_PANEL_TITLE);
	addPanelInfo(JNDI_PANEL, JNDI_PANEL_TITLE);
	addPanelInfo(RMI_PANEL, RMI_PANEL_TITLE);
	
	setPanelInfoVisible(JDBC_PANEL, isJDBCPanel());
	setPanelInfoVisible(JNDI_PANEL, isJNDIPanel());
	setPanelInfoVisible(RMI_PANEL, isRMIPanel());
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

    private boolean isJDBCPanel() {
	return supportJDBC;
    }

    private boolean isRMIPanel() {
	return supportRMI;
    }

    private boolean isJNDIPanel() {
	return supportJNDI;
    }

    private void doSelection(String panelId) {
	if (panelId == null) {
	    return;
	}
	if (panelId.equals(currentPanelId)) {
	    return;
	}
	currentPanelId = panelId;
	
	hidePanels();
	if (GENERAL_PANEL.equals(panelId)) {
	    showGeneralPanel();
	} else if (PROPERTIES_PANEL.equals(panelId)) {
	    showPropertiesPanel();
	} else  if (CLASSPATH_PANEL.equals(panelId)) {
	    showClasspathPanel();
	} else  if (JDBC_PANEL.equals(panelId)) {
	    showJDBCPanel();
	} else  if (JNDI_PANEL.equals(panelId)) {
	    showJNDIPanel();
	} else  if (RMI_PANEL.equals(panelId)) {
	    showRMIPanel();
	}
    }

    private void hidePanels() {
	hidePanel(generalPanel);
	hidePanel(propertiesPanel);
	hidePanel(classpathPanel);
	hidePanel(jdbcPanel);
	hidePanel(jndiPanel);
	hidePanel(rmiPanel);
    }
    
    private void hidePanel(Composite panel) {
	if (panel == null) {
	    return;
	}
	setVisible(panel, false);
    }

    private void showGeneralPanel() {
	if (generalPanel == null) {
	    generalPanel = createGeneralPanel(commonPanel);
	} else {
	    setVisible(generalPanel, true);
	}
	commonPanel.layout();
    }

    private void showPropertiesPanel() {
	if (propertiesPanel == null) {
	    propertiesPanel = createPropertiesPanel(commonPanel);
	} else {
	    setVisible(propertiesPanel, true);
	}
	commonPanel.layout();
    }
    
    private void showClasspathPanel() {
	if (classpathPanel == null) {
	    classpathPanel = createClasspathPanel(commonPanel);
	} else {
	    setVisible(classpathPanel, true);
	}
	commonPanel.layout();
    }
    
    private void showJDBCPanel() {
	if (jdbcPanel == null) {
	    jdbcPanel = createJDBCPanel(commonPanel);
	} else {
	    setVisible(jdbcPanel, true);
	}
	commonPanel.layout();
    }
    
    private void showJNDIPanel() {
	if (jndiPanel == null) {
	    jndiPanel = createJNDIPanel(commonPanel);
	} else {
	    setVisible(jndiPanel, true);
	}
	commonPanel.layout();
    }
    
    private void showRMIPanel() {
	if (rmiPanel == null) {
	    rmiPanel = createRMIPanel(commonPanel);
	} else {
	    setVisible(rmiPanel, true);
	}
	commonPanel.layout();
    }

    private ItemPanel createGeneralPanel(Composite parent) {
	ItemPanel panel = new GeneralPanel(parent, GENERAL_PANEL_TITLE);
	return panel;
    }

    
    private ItemPanel createPropertiesPanel(Composite parent) {
	ItemPanel panel = new PropertiesPanel(parent, PROPERTIES_PANEL_TITLE);
	return panel;
    }

    private ItemPanel createClasspathPanel(Composite parent) {
	ItemPanel panel = new ClasspathPanel(parent, CLASSPATH_PANEL_TITLE);
	return panel;
    }
    
    private ItemPanel createJDBCPanel(Composite parent) {
	ItemPanel panel = new JDBCPanel(parent, JDBC_PANEL_TITLE);
	return panel;
    }
    
    private ItemPanel createJNDIPanel(Composite parent) {
	ItemPanel panel = new JNDIPanel(parent, JNDI_PANEL_TITLE);
	return panel;
    }
    
    private ItemPanel createRMIPanel(Composite parent) {
	ItemPanel panel = new RMIPanel(parent, RMI_PANEL_TITLE);
	return panel;
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

   
    protected void storeData() {
	storeData(generalPanel);
	storeData(propertiesPanel);
	storeData(classpathPanel);
	storeData(jdbcPanel);
	storeData(jndiPanel);
	storeData(rmiPanel);
    }
    
    protected void storeData(ItemPanel panel) {
	if (panel == null) {
	    return;
	}
	panel.storeData();
    }
  
    class PanelInfo {
	
	String id;
	
	String name;
	
	boolean visible = true;
    }
}
