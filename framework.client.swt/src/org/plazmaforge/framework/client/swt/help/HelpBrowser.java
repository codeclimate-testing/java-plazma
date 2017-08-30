package org.plazmaforge.framework.client.swt.help;



import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.plazmaforge.framework.client.help.HelpSystem;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.util.SystemInfo;



public class HelpBrowser extends Dialog {

    
    private ToolItem backToolItem;
    
    private ToolItem forwardToolItem;
    
    private Browser browser;
	
    public HelpBrowser(IShellProvider arg0) {
	super(arg0);
    }

    public HelpBrowser(Shell arg0) {
	super(arg0);
    }

    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        //composite.setLayout(new FillLayout());
        composite.setLayout(new GridLayout());
        
        //Composite toolPanel = new Composite(composite, SWT.NONE);
        
        CoolBar coolBar = createCoolBar(composite);
        //coolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        coolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        
        SashForm sash = new SashForm(composite, SWT.BORDER);
        sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        
        /*
        Tree tree = new Tree(sash, SWT.BORDER);
        tree.setItemCount(1);
        tree.getItem(0).setText("Index");
        */
        
        browser = new Browser(sash, SWT.BORDER);
        String helpSite = HelpSystem.getHelpSite();
        String url = HelpSystem.getHelpUrl();
        browser.setUrl(url);
        
        
        
        return composite;
    }    
    
    protected Point getInitialSize() {
	int width = 640;
	int height = 480;
        return new Point(width, height);
    }
    
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    protected void setShellStyle(int newShellStyle) {
        super.setShellStyle(newShellStyle | SWT.MAX | SWT.RESIZE);
    }
    
    
    protected CoolBar createCoolBar(Composite parent) {
	CoolBar coolBar = new CoolBar(parent, SystemInfo.isWindows ? SWT.NONE : SWT.FLAT);
	ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.WRAP);
    	
    	CoolItem coolItem = new CoolItem(coolBar, SWT.NONE);
    	coolItem.setControl(toolBar);
    	

    	// Back
    	backToolItem = new ToolItem(toolBar, SWT.NONE);
    	backToolItem.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(SelectionEvent e) {
    		    doBackAction();
    		}
    	});
    	backToolItem.setImage(getButtonImage("/org/plazmaforge/framework/client/images/eclipse/navigation/back.gif"));
    	backToolItem.setToolTipText("Go back");

    	// Forward
    	forwardToolItem = new ToolItem(toolBar, SWT.NONE);
    	forwardToolItem.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(SelectionEvent e) {
    		    doForwardAction();
    		}
    	});
    	forwardToolItem.setImage(getButtonImage("/org/plazmaforge/framework/client/images/eclipse/navigation/forward.gif"));
    	forwardToolItem.setToolTipText("Go forward");

    	
    	Point size = toolBar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    	coolItem.setSize(coolItem.computeSize(size.x, size.y + 3)); 

	return coolBar;
    }

    private void doBackAction() {
	browser.back();
    }
    
    private void doForwardAction() {
	browser.forward();
    }
    
    
    protected Image getButtonImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }

}
